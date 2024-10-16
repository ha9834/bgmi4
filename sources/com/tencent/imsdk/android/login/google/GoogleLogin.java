package com.tencent.imsdk.android.login.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.MetaDataUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleLogin extends IMSDKLoginBase {
    protected static final String CHANNEL = "Google";
    private static final int CHANNEL_ID = 3;
    private static final String GMS_CLIENT_KEY = "IMSDK_GOOGLE_CLIENT_KEY";
    private GoogleSignInAccount mAcct;
    private Context mCtx;
    private GoogleApiClient mGoogleAuthApiClient;
    GoogleAuthConnectListener mGoogleAuthConnectListener;
    private GoogleApiClient mGoogleGameApiClient;
    GoogleGameConnectListener mGoogleGameConnectListener;
    private Player mPlayer;
    private boolean mQuickLoginFlag;
    private InnerStat.Builder mSTBuilder;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InnerCallback {
        private static IMSDKListener<Map<String, String>> mGoogleConnectListener;
        protected static IMSDKResultListener<IMSDKLoginResult> mQuickLoginListener;

        private InnerCallback() {
        }

        public static void setCallback(IMSDKListener<Map<String, String>> iMSDKListener) {
            mGoogleConnectListener = iMSDKListener;
        }

        public static void setQuickLoginCallback(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
            mQuickLoginListener = iMSDKResultListener;
        }

        public static void onQuickLogin(IMSDKLoginResult iMSDKLoginResult) {
            IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener = mQuickLoginListener;
            if (iMSDKResultListener != null) {
                iMSDKLoginResult.channelId = 3;
                iMSDKResultListener.onResult(iMSDKLoginResult);
                mQuickLoginListener = null;
            }
        }

        public static void onResult(IMSDKLoginResult iMSDKLoginResult) {
            IMSDKListener<Map<String, String>> iMSDKListener = mGoogleConnectListener;
            if (iMSDKListener != null) {
                iMSDKLoginResult.channelId = 3;
                iMSDKListener.onResult(iMSDKLoginResult);
                mGoogleConnectListener = null;
            }
        }

        public static void onNotify(Map<String, String> map) {
            IMSDKListener<Map<String, String>> iMSDKListener = mGoogleConnectListener;
            if (iMSDKListener != null) {
                iMSDKListener.onNotify(map);
                mGoogleConnectListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    class GoogleGameConnectListener implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        protected static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
        private boolean mResolvingConnectionFailure = false;
        private boolean mResolvingConnectionCancel = false;

        GoogleGameConnectListener() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            IMLogger.d("google game connected !");
            try {
                if (GoogleLogin.this.mGoogleGameApiClient != null && GoogleLogin.this.mGoogleGameApiClient.hasConnectedApi(Games.API)) {
                    GoogleLogin.this.mPlayer = Games.Players.getCurrentPlayer(GoogleLogin.this.mGoogleGameApiClient);
                    IMLogger.d("player id : " + GoogleLogin.this.mPlayer.getPlayerId());
                    IMLogger.d("player name : " + GoogleLogin.this.mPlayer.getDisplayName());
                    if (GoogleLogin.this.mGoogleAuthApiClient.isConnected()) {
                        GoogleLogin.this.mGoogleAuthApiClient.reconnect();
                        return;
                    } else {
                        GoogleLogin.this.mGoogleAuthApiClient.connect();
                        return;
                    }
                }
                InnerCallback.onResult(new IMSDKLoginResult(3, -1, "google connect has no game api"));
            } catch (Exception e) {
                InnerCallback.onResult(new IMSDKLoginResult(3, -1, e.getMessage()));
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            IMLogger.d("google game suspended !");
            GoogleLogin.this.mGoogleGameApiClient.connect();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            if (GoogleLogin.this.mQuickLoginFlag) {
                InnerCallback.onQuickLogin(new IMSDKLoginResult(9999, connectionResult.getErrorCode(), connectionResult.getErrorMessage()));
                return;
            }
            if (this.mResolvingConnectionCancel && connectionResult.getErrorCode() != 4) {
                InnerCallback.onResult(new IMSDKLoginResult(2, connectionResult.getErrorCode(), connectionResult.getErrorMessage()));
                this.mResolvingConnectionCancel = false;
                if (GoogleLogin.this.mSTBuilder != null) {
                    GoogleLogin.this.mSTBuilder.setMethod("onConnectionFailed").setResult("connect google cancel").setStage("GoogleGameConnectListener").create().reportEvent();
                    return;
                }
                return;
            }
            if (this.mResolvingConnectionFailure) {
                IMLogger.d("already in resolving google play games sign in");
                return;
            }
            IMLogger.d("gms game connect failed : " + connectionResult.getErrorCode() + ", " + connectionResult.getErrorMessage());
            final GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            if (connectionResult.hasResolution()) {
                IMSDKProxyActivity.registerLifeCycle(GoogleLogin.this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.google.GoogleLogin.GoogleGameConnectListener.1
                    boolean bActivityCallbackFlag = false;

                    @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                    protected void onActivityCreate(Bundle bundle, Activity activity) {
                        GoogleGameConnectListener.this.mResolvingConnectionFailure = true;
                        try {
                            connectionResult.startResolutionForResult(activity, 9000);
                        } catch (IntentSender.SendIntentException e) {
                            IMLogger.d("try fix gms error : " + e.getMessage());
                            InnerCallback.onResult(new IMSDKLoginResult(9999, connectionResult.getErrorCode(), e.getMessage()));
                            if (GoogleLogin.this.mSTBuilder != null) {
                                GoogleLogin.this.mSTBuilder.setMethod("onConnectionFailed").setResult("fix google connect error : " + connectionResult.getErrorCode() + "," + e.getMessage()).setStage("GoogleGameConnectListener").create().reportEvent();
                            }
                            GoogleGameConnectListener.this.mResolvingConnectionFailure = false;
                            this.bActivityCallbackFlag = true;
                        }
                    }

                    @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                    protected boolean onActivityResult(int i, int i2, Intent intent) {
                        this.bActivityCallbackFlag = true;
                        if (i == 9000) {
                            GoogleGameConnectListener.this.mResolvingConnectionFailure = false;
                            if (i2 == -1) {
                                IMLogger.d("google game fix connect success !");
                                GoogleLogin.this.mGoogleGameApiClient.connect();
                            } else if (i2 == 0) {
                                if (googleApiAvailability.isGooglePlayServicesAvailable(GoogleLogin.this.mCtx) == 0 && connectionResult.getErrorCode() != 4) {
                                    GoogleGameConnectListener.this.mResolvingConnectionCancel = true;
                                    GoogleLogin.this.mGoogleGameApiClient.connect();
                                } else {
                                    InnerCallback.onResult(new IMSDKLoginResult(2, i2, "google auth activity result : " + i2));
                                    if (GoogleLogin.this.mSTBuilder != null) {
                                        GoogleLogin.this.mSTBuilder.setMethod("onActivityResult").setResult("connect google cancel : " + i2).setStage("GoogleGameConnectListener").create().reportEvent();
                                    }
                                }
                            } else {
                                InnerCallback.onResult(new IMSDKLoginResult(9999, i2, "google auth activity result : " + i2));
                                if (GoogleLogin.this.mSTBuilder != null) {
                                    GoogleLogin.this.mSTBuilder.setMethod("onActivityResult").setResult("connect google error : " + i2).setStage("GoogleGameConnectListener").create().reportEvent();
                                }
                                if (i2 == 10002) {
                                    IMLogger.e("check your test permission to this game !", new Object[0]);
                                } else if (i2 == 10004) {
                                    IMLogger.e("check your google play games configuration !", new Object[0]);
                                } else if (i2 == 10006) {
                                    IMLogger.e("check your Internet connection to google play games !", new Object[0]);
                                }
                            }
                        }
                        return true;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                    public void onActivityDestroy() {
                        super.onActivityDestroy();
                        if (this.bActivityCallbackFlag) {
                            return;
                        }
                        GoogleGameConnectListener.this.mResolvingConnectionCancel = false;
                        GoogleGameConnectListener.this.mResolvingConnectionFailure = false;
                        InnerCallback.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out google callback"));
                        if (GoogleLogin.this.mSTBuilder != null) {
                            GoogleLogin.this.mSTBuilder.setMethod("onActivityResult").setResult("activity destroyed with out google callback").setStage("GoogleGameConnectListener").create().reportEvent();
                        }
                    }
                });
                return;
            }
            IMLogger.d("gms auth connect failed : " + connectionResult.getErrorMessage());
            InnerCallback.onResult(new IMSDKLoginResult(9999, connectionResult.getErrorCode(), connectionResult.getErrorMessage()));
            if (GoogleLogin.this.mSTBuilder != null) {
                GoogleLogin.this.mSTBuilder.setMethod("onConnectionFailed").setResult("connect google has no solution : " + connectionResult.getErrorCode() + ", " + connectionResult.getErrorMessage()).setStage("GoogleGameConnectListener").create().reportEvent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class GoogleAuthConnectListener implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        protected static final int RC_SIGN_IN = 9001;

        GoogleAuthConnectListener() {
        }

        protected void handleConnectSuccess(GoogleSignInResult googleSignInResult) {
            GoogleLogin.this.mAcct = googleSignInResult.getSignInAccount();
            if (GoogleLogin.this.mAcct != null) {
                Map<String, String> sortableMap = T.getSortableMap();
                sortableMap.put("iChannel", String.valueOf(3));
                String idToken = GoogleLogin.this.mAcct.getIdToken();
                sortableMap.put("idToken", idToken);
                IMLogger.d("id token : " + idToken);
                String serverAuthCode = GoogleLogin.this.mAcct.getServerAuthCode();
                sortableMap.put("authCode", serverAuthCode);
                IMLogger.d("auth code : " + serverAuthCode);
                InnerCallback.onNotify(sortableMap);
                return;
            }
            InnerCallback.onResult(new IMSDKLoginResult(3, -1, "GoogleSignInAccount empty "));
            if (GoogleLogin.this.mSTBuilder != null) {
                GoogleLogin.this.mSTBuilder.setMethod("handleConnectSuccess").setResult("connect google sign in account is null").setStage("GoogleAuthConnectListener").create().reportEvent();
            }
        }

        protected void handleConnectFailed(GoogleSignInResult googleSignInResult) {
            if (googleSignInResult == null) {
                InnerCallback.onResult(new IMSDKLoginResult(3, -1, "GoogleSignInResult empty"));
                if (GoogleLogin.this.mSTBuilder != null) {
                    GoogleLogin.this.mSTBuilder.setMethod("handleConnectFailed").setResult("connect google sign in result is null").setStage("GoogleAuthConnectListener").create().reportEvent();
                    return;
                }
                return;
            }
            if (googleSignInResult.getStatus().isCanceled() || googleSignInResult.getStatus().getStatusCode() == 12501) {
                InnerCallback.onResult(new IMSDKLoginResult(2, googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getStatus().getStatusMessage()));
                if (GoogleLogin.this.mSTBuilder != null) {
                    GoogleLogin.this.mSTBuilder.setMethod("handleConnectFailed").setResult("connect google cancel : " + googleSignInResult.getStatus().getStatusCode() + ", " + googleSignInResult.getStatus().getStatusMessage()).setStage("GoogleAuthConnectListener").create().reportEvent();
                    return;
                }
                return;
            }
            InnerCallback.onResult(new IMSDKLoginResult(9999, googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getStatus().getStatusMessage()));
            if (GoogleLogin.this.mSTBuilder != null) {
                GoogleLogin.this.mSTBuilder.setMethod("handleConnectFailed").setResult("connect google error : " + googleSignInResult.getStatus().getStatusCode() + ", " + googleSignInResult.getStatus().getStatusMessage()).setStage("GoogleAuthConnectListener").create().reportEvent();
            }
        }

        protected void handleSilentSignFailed() {
            IMSDKProxyActivity.registerLifeCycle(GoogleLogin.this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.google.GoogleLogin.GoogleAuthConnectListener.1
                boolean bActivityCallbackFlag = false;

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected void onActivityCreate(Bundle bundle, Activity activity) {
                    activity.startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(GoogleLogin.this.mGoogleAuthApiClient), 9001);
                }

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected boolean onActivityResult(int i, int i2, Intent intent) {
                    this.bActivityCallbackFlag = true;
                    if (i == 9001) {
                        GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
                        if (signInResultFromIntent != null && signInResultFromIntent.isSuccess()) {
                            GoogleAuthConnectListener.this.handleConnectSuccess(signInResultFromIntent);
                        } else {
                            GoogleAuthConnectListener.this.handleConnectFailed(signInResultFromIntent);
                        }
                    }
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                public void onActivityDestroy() {
                    super.onActivityDestroy();
                    if (this.bActivityCallbackFlag) {
                        return;
                    }
                    InnerCallback.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out google callback"));
                    if (GoogleLogin.this.mSTBuilder != null) {
                        GoogleLogin.this.mSTBuilder.setMethod("onActivityDestroy").setResult("activity destroyed with out google callback").setStage("GoogleGameConnectListener").create().reportEvent();
                    }
                }
            });
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            IMLogger.d("google auth connected !");
            if (!GoogleLogin.this.mQuickLoginFlag) {
                Auth.GoogleSignInApi.silentSignIn(GoogleLogin.this.mGoogleAuthApiClient).setResultCallback(new ResultCallback<GoogleSignInResult>() { // from class: com.tencent.imsdk.android.login.google.GoogleLogin.GoogleAuthConnectListener.2
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(GoogleSignInResult googleSignInResult) {
                        if (googleSignInResult != null && googleSignInResult.isSuccess()) {
                            GoogleAuthConnectListener.this.handleConnectSuccess(googleSignInResult);
                        } else {
                            GoogleAuthConnectListener.this.handleSilentSignFailed();
                        }
                    }
                });
            } else {
                GoogleLogin.this.realQuickLogin();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            IMLogger.d("google auth suspended !");
            if (GoogleLogin.this.mGoogleAuthApiClient != null) {
                GoogleLogin.this.mGoogleAuthApiClient.connect();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            if (GoogleLogin.this.mQuickLoginFlag) {
                InnerCallback.onQuickLogin(new IMSDKLoginResult(9999, connectionResult.getErrorCode(), connectionResult.getErrorMessage()));
                return;
            }
            IMLogger.d("gms auth connect failed : " + connectionResult.getErrorMessage());
            InnerCallback.onResult(new IMSDKLoginResult(9999, connectionResult.getErrorCode(), connectionResult.getErrorMessage()));
            if (GoogleLogin.this.mSTBuilder != null) {
                GoogleLogin.this.mSTBuilder.setMethod("onConnectionFailed").setResult("connect google : " + connectionResult.getErrorCode() + ", " + connectionResult.getErrorMessage()).setStage("GoogleAuthConnectListener").create().reportEvent();
            }
        }
    }

    public GoogleLogin(Context context) {
        super(context);
        this.mQuickLoginFlag = false;
        this.mCtx = null;
        if (this.mCtx == null) {
            this.mCtx = context;
            try {
                this.mSTBuilder = new InnerStat.Builder(this.mCtx, BuildConfig.VERSION_NAME, String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE));
                this.mGoogleGameConnectListener = new GoogleGameConnectListener();
                this.mGoogleGameApiClient = new GoogleApiClient.Builder(this.mCtx).addApiIfAvailable(Games.API, new Scope[0]).addConnectionCallbacks(this.mGoogleGameConnectListener).addOnConnectionFailedListener(this.mGoogleGameConnectListener).build();
                GoogleSignInOptions.Builder requestProfile = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestId().requestProfile();
                String readFromApplication = MetaDataUtils.readFromApplication(this.mCtx, GMS_CLIENT_KEY, "");
                if (readFromApplication != null && readFromApplication.length() > 0) {
                    requestProfile.requestServerAuthCode(readFromApplication);
                    requestProfile.requestIdToken(readFromApplication);
                    GoogleSignInOptions build = requestProfile.build();
                    this.mGoogleAuthConnectListener = new GoogleAuthConnectListener();
                    this.mGoogleAuthApiClient = new GoogleApiClient.Builder(this.mCtx).addApi(Auth.GOOGLE_SIGN_IN_API, build).addOnConnectionFailedListener(this.mGoogleAuthConnectListener).addConnectionCallbacks(this.mGoogleAuthConnectListener).build();
                }
                IMLogger.w("need IMSDK_GOOGLE_CLIENT_KEY meta-data in AndroidManifest.xml !", new Object[0]);
                if (this.mSTBuilder != null) {
                    this.mSTBuilder.setMethod("GoogleLogin").setResult("need config : IMSDK_GOOGLE_CLIENT_KEY").setStage("check").create().reportEvent();
                }
                GoogleSignInOptions build2 = requestProfile.build();
                this.mGoogleAuthConnectListener = new GoogleAuthConnectListener();
                this.mGoogleAuthApiClient = new GoogleApiClient.Builder(this.mCtx).addApi(Auth.GOOGLE_SIGN_IN_API, build2).addOnConnectionFailedListener(this.mGoogleAuthConnectListener).addConnectionCallbacks(this.mGoogleAuthConnectListener).build();
            } catch (Exception e) {
                IMLogger.e("gms build api failed : " + e.getMessage(), new Object[0]);
                InnerStat.Builder builder = this.mSTBuilder;
                if (builder != null) {
                    builder.setMethod("GoogleLogin").setResult("exception : " + e.getMessage()).setStage("end").create().reportEvent();
                }
            }
        }
    }

    public void connectGoogleApiClient() {
        GoogleApiClient googleApiClient = this.mGoogleGameApiClient;
        if (googleApiClient != null) {
            if (!googleApiClient.isConnected()) {
                this.mGoogleGameApiClient.connect();
                InnerStat.Builder builder = this.mSTBuilder;
                if (builder != null) {
                    builder.setMethod("connectGoogleApiClient").setResult("call connect").setStage("start").create().reportEvent();
                    return;
                }
                return;
            }
            this.mGoogleGameApiClient.reconnect();
            InnerStat.Builder builder2 = this.mSTBuilder;
            if (builder2 != null) {
                builder2.setMethod("connectGoogleApiClient").setResult("call reconnect").setStage("start").create().reportEvent();
            }
        }
    }

    protected void realQuickLogin() {
        if (InnerCallback.mQuickLoginListener != null) {
            super.quickLogin(InnerCallback.mQuickLoginListener);
            InnerCallback.mQuickLoginListener = null;
        } else {
            InnerStat.Builder builder = this.mSTBuilder;
            if (builder != null) {
                builder.setMethod("realQuickLogin").setResult("listener is null").setStage("end").create().reportEvent();
            }
            IMLogger.e("QuickLogin InnerCallback.mQuickLoginListener is null , It could be recycled. plz try again! ", new Object[0]);
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void quickLogin(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        this.mQuickLoginFlag = true;
        InnerCallback.setQuickLoginCallback(iMSDKResultListener);
        connectGoogleApiClient();
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        GoogleApiClient googleApiClient = this.mGoogleGameApiClient;
        return googleApiClient != null && googleApiClient.isConnected();
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        GoogleSignInAccount googleSignInAccount = this.mAcct;
        if (googleSignInAccount != null) {
            map.put("BindIdToken", googleSignInAccount.getIdToken());
            map.put("BindAuthCode", this.mAcct.getServerAuthCode());
        }
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        this.mQuickLoginFlag = false;
        InnerCallback.setCallback(iMSDKListener);
        connectGoogleApiClient();
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        try {
            if (T.ckNonEmpty(iMSDKLoginResult.channelUserId) && this.mAcct != null) {
                iMSDKLoginResult.channelUserId = this.mAcct.getId();
            }
            if (this.mPlayer != null) {
                JSONObject jSONObject = new JSONObject(iMSDKLoginResult.retExtraJson == null ? "{}" : iMSDKLoginResult.retExtraJson);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playerId", this.mPlayer.getPlayerId());
                jSONObject2.put("displayName", this.mPlayer.getDisplayName());
                jSONObject2.put("name", this.mPlayer.getName());
                jSONObject.put("gmsPayerInfo", jSONObject2);
                iMSDKLoginResult.retExtraJson = jSONObject.toString();
            }
        } catch (Exception e) {
            IMLogger.e("set channel data error : " + e.getMessage(), new Object[0]);
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        try {
            if (this.mGoogleAuthApiClient.isConnected()) {
                if (T.isDebug()) {
                    Auth.GoogleSignInApi.revokeAccess(this.mGoogleAuthApiClient);
                }
                Auth.GoogleSignInApi.signOut(this.mGoogleAuthApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.tencent.imsdk.android.login.google.GoogleLogin.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(Status status) {
                        IMLogger.d("sign out result : " + status.getStatusMessage());
                        GoogleLogin.this.mGoogleAuthApiClient.disconnect();
                    }
                });
            }
            if (this.mGoogleGameApiClient.isConnected()) {
                Games.signOut(this.mGoogleGameApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.tencent.imsdk.android.login.google.GoogleLogin.2
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(Status status) {
                        IMLogger.d("sign out result : " + status.getStatusMessage());
                    }
                });
            } else {
                IMLogger.d("gms not connected yet");
            }
        } catch (Exception e) {
            IMLogger.w("google sign out error : " + e.getMessage(), new Object[0]);
        }
        super.logout(iMSDKResultListener);
    }
}
