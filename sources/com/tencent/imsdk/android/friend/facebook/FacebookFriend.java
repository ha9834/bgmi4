package com.tencent.imsdk.android.friend.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.NativeProtocol;
import com.facebook.messenger.MessengerUtils;
import com.facebook.share.Sharer;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.api.common.IMSDKLaunchResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendListResult;
import com.tencent.imsdk.android.api.relation.IMSDKFriendReqInfo;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.interfaces.IAppAvailable;
import com.tencent.imsdk.android.base.interfaces.ILauncher;
import com.tencent.imsdk.android.base.relation.IMSDKFriendBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.FileUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FacebookFriend extends IMSDKFriendBase implements IAppAvailable, ILauncher {
    private final String FB_MESSENGER_LAUNCH_KEY;
    private final String FB_PACKAGE_NAME;
    private final int FRIEND_DEFAULT;
    private final int FRIEND_INVITE;
    private final String GRAPH_PATH_FRIENDS;
    private CallbackManager mCallbackManager;
    private Context mCtx;

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public String getChannelId() {
        return "1";
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationSupported() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEvent(String str, String str2, String str3) {
        if (this.mSTBuilder != null) {
            this.mSTBuilder.setMethod(str).setStage(str2).setResult(str3).create().reportEvent();
        }
    }

    public FacebookFriend(Context context) {
        super(context);
        this.mCtx = null;
        this.mCallbackManager = null;
        this.GRAPH_PATH_FRIENDS = "/me/invitable_friends";
        this.FRIEND_DEFAULT = 0;
        this.FRIEND_INVITE = 1;
        this.FB_MESSENGER_LAUNCH_KEY = "target_url";
        this.FB_PACKAGE_NAME = InnerStat.ThirdPN.FACEBOOK;
        if (this.mCtx == null) {
            this.mCtx = context;
            if (!FacebookSdk.isInitialized()) {
                FacebookSdk.sdkInitialize(context);
            }
            if (this.mCallbackManager == null) {
                this.mCallbackManager = CallbackManager.Factory.create();
            }
            this.mSTBuilder = new InnerStat.Builder(context, "2.2.1", FacebookSdk.getSdkVersion());
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void invite(final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        IMSDKProxyActivity.registerLifeCycle(this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.1
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                GameRequestDialog gameRequestDialog = new GameRequestDialog(activity);
                GameRequestContent.Builder builder = new GameRequestContent.Builder();
                boolean z = false;
                if (iMSDKFriendReqInfo.title == null) {
                    IMLogger.w("game request title is null !", new Object[0]);
                } else {
                    builder.setTitle(iMSDKFriendReqInfo.title);
                }
                if (iMSDKFriendReqInfo.content == null) {
                    IMLogger.w("game request content is null !", new Object[0]);
                } else {
                    builder.setMessage(iMSDKFriendReqInfo.content);
                }
                StringBuilder sb = new StringBuilder();
                if (iMSDKFriendReqInfo.extraJson != null && iMSDKFriendReqInfo.extraJson.length() > 0) {
                    IMLogger.d("info.extraJson = " + iMSDKFriendReqInfo.extraJson);
                    try {
                        JSONObject jSONObject = new JSONObject(iMSDKFriendReqInfo.extraJson);
                        if (jSONObject.has("invitetype") && jSONObject.has("userlist")) {
                            JSONArray jSONArray = jSONObject.getJSONArray("userlist");
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append(jSONArray.getString(i));
                            }
                            IMLogger.d("friendListString = " + sb.toString());
                            if (sb.length() > 0) {
                                builder.setTo(sb.toString());
                                z = true;
                            }
                        } else {
                            IMLogger.w("ExtraJson not null, but no invitetype | userlist data setted in extraJson, exec default invite!", new Object[0]);
                        }
                    } catch (Exception e) {
                        IMLogger.e(e.toString(), new Object[0]);
                        iMSDKResultListener.onResult(new IMSDKResult(11, -1, e.getMessage()));
                        activity.finish();
                        return;
                    }
                }
                if (!z) {
                    builder.setFilters(GameRequestContent.Filters.APP_NON_USERS);
                }
                GameRequestContent build = builder.build();
                FacebookFriend.this.reportEvent("invite", "process gameRequestDialog", gameRequestDialog.canShow(build) ? "can show" : "can not show");
                if (gameRequestDialog.canShow(build)) {
                    gameRequestDialog.registerCallback(FacebookFriend.this.mCallbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.1.1
                        @Override // com.facebook.FacebookCallback
                        public void onSuccess(GameRequestDialog.Result result) {
                            IMLogger.d("invite onSuccess called, result = " + result.toString());
                            if (result.getRequestId() == null) {
                                iMSDKResultListener.onResult(new IMSDKResult(2, 2, "send game quest select nobody!"));
                                return;
                            }
                            IMSDKResult iMSDKResult = new IMSDKResult(1, 1, "send game quest success !");
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("RequestId", result.getRequestId());
                                JSONArray jSONArray2 = new JSONArray();
                                for (int i2 = 0; i2 < result.getRequestRecipients().size(); i2++) {
                                    jSONArray2.put(result.getRequestRecipients().get(i2));
                                }
                                jSONObject2.put("RequestRecipients", jSONArray2);
                                iMSDKResult.retExtraJson = jSONObject2.toString();
                            } catch (JSONException e2) {
                                IMLogger.w("put extra data error : " + e2.getMessage(), new Object[0]);
                                FacebookFriend.this.reportEvent("invite", "json parse error after invite success", e2.getMessage());
                            } catch (Exception e3) {
                                IMLogger.w(e3.getMessage(), new Object[0]);
                                FacebookFriend.this.reportEvent("invite", "unknown error after invite success", e3.getMessage());
                            }
                            iMSDKResultListener.onResult(iMSDKResult);
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onCancel() {
                            IMLogger.w("invite onCancel called", new Object[0]);
                            iMSDKResultListener.onResult(new IMSDKResult(2, 2, "send game quest canceled !"));
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onError(FacebookException facebookException) {
                            IMLogger.e("invite onError called, error = " + facebookException.getMessage(), new Object[0]);
                            iMSDKResultListener.onResult(new IMSDKResult(9999, -1, facebookException.getMessage()));
                        }
                    });
                    gameRequestDialog.show(build);
                } else {
                    FacebookFriend.this.returnByError(iMSDKResultListener, 7, 7, "can not show game request !");
                }
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                FacebookFriend.this.mCallbackManager.onActivityResult(i, i2, intent);
                return true;
            }
        });
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void share(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        String str = null;
        switch (iMSDKFriendReqInfo.type) {
            case 0:
            case 2:
                if (AccessToken.getCurrentAccessToken() == null || AccessToken.getCurrentAccessToken().isExpired()) {
                    returnByError(iMSDKResultListener, 10, 10, "need login to facebook before send message in background !");
                    break;
                } else if (!AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions")) {
                    returnByError(iMSDKResultListener, 12, 12, "background share need publish_actions permission !");
                    break;
                } else {
                    sendGraphRequest(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
                    break;
                }
                break;
            case 1:
                str = "dialog share no support for text !";
                break;
            case 3:
            case 5:
                deliverMessageWithDialog(true, iMSDKFriendReqInfo, iMSDKResultListener, objArr);
                break;
            case 4:
                str = "background share no support for image !";
                break;
            default:
                str = "no support for share type : " + iMSDKFriendReqInfo.type;
                break;
        }
        if (str != null) {
            returnByError(iMSDKResultListener, 7, 7, str);
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void sendMessage(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        this.mSTBuilder.setMethod("sendMessage").setResult("success").create().reportEvent();
        int i = iMSDKFriendReqInfo.type;
        if (i != 0) {
            switch (i) {
                case 2:
                case 4:
                    break;
                case 3:
                case 5:
                    deliverMessageWithDialog(false, iMSDKFriendReqInfo, iMSDKResultListener, objArr);
                    return;
                default:
                    returnByError(iMSDKResultListener, 7, 7, "no support send type : " + iMSDKFriendReqInfo.type);
                    IMLogger.e("no support send type : " + iMSDKFriendReqInfo.type, new Object[0]);
                    return;
            }
        }
        returnByError(iMSDKResultListener, 7, 7, "background message no support for text/link/picture");
    }

    private String getSendToFriendString(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray(NativeProtocol.AUDIENCE_FRIENDS);
                    StringBuilder sb = new StringBuilder();
                    String str2 = "";
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (i != 0) {
                            str2 = str2 + ",";
                        }
                        sb.append(jSONArray.getString(i));
                    }
                    return str2 + sb.toString();
                }
            } catch (JSONException e) {
                IMLogger.w("extra data error : " + e.getMessage(), new Object[0]);
                return "";
            }
        }
        return "";
    }

    private List<String> getSendToFriendList(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(NativeProtocol.AUDIENCE_FRIENDS)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(NativeProtocol.AUDIENCE_FRIENDS);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                }
            } catch (JSONException e) {
                IMLogger.w("extra data error : " + e.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    private void sendGraphRequest(IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener, Object... objArr) {
        final GraphRequest graphRequest = new GraphRequest();
        graphRequest.setAccessToken(AccessToken.getCurrentAccessToken());
        Bundle bundle = new Bundle();
        if (iMSDKFriendReqInfo.type == 0 || iMSDKFriendReqInfo.type == 2) {
            if (iMSDKFriendReqInfo.title != null) {
                bundle.putString("name", iMSDKFriendReqInfo.title);
            }
            if (iMSDKFriendReqInfo.content != null) {
                bundle.putString("message", iMSDKFriendReqInfo.content);
                bundle.putString("description", iMSDKFriendReqInfo.content);
            }
            if (iMSDKFriendReqInfo.link != null) {
                bundle.putString("link", iMSDKFriendReqInfo.link);
            }
            if (iMSDKFriendReqInfo.imagePath != null) {
                bundle.putString("picture", iMSDKFriendReqInfo.imagePath);
            }
        }
        String sendToFriendString = getSendToFriendString(iMSDKFriendReqInfo.extraJson);
        if (sendToFriendString != null && sendToFriendString.length() > 0) {
            bundle.putString("tags", sendToFriendString);
        }
        graphRequest.setGraphPath("/me/feed");
        graphRequest.setHttpMethod(HttpMethod.POST);
        graphRequest.setParameters(bundle);
        graphRequest.setCallback(new GraphRequest.Callback() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.2
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    IMSDKResult iMSDKResult = new IMSDKResult(1, 1, "facebook share success : " + graphResponse.getJSONObject().get("id"));
                    if (graphResponse.getJSONObject() != null && graphResponse.getJSONObject().get("id") != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("PostId", graphResponse.getJSONObject().get("id"));
                        iMSDKResult.retExtraJson = jSONObject.toString();
                    }
                    iMSDKResultListener.onResult(iMSDKResult);
                } catch (JSONException e) {
                    IMLogger.e("can not get post id : " + e.getMessage(), new Object[0]);
                    iMSDKResultListener.onResult(new IMSDKResult(11, 11, e.getMessage()));
                }
            }
        });
        if (T.mGlobalActivityUpToDate != null) {
            T.mGlobalActivityUpToDate.runOnUiThread(new Runnable() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.3
                @Override // java.lang.Runnable
                public void run() {
                    graphRequest.executeAsync();
                }
            });
        } else {
            IMLogger.e("sendGraphRequest, T.mGlobalActivityUpToDate = null, please check!", new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(11, 11, "T.mGlobalActivityUpToDate = null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareContent createShareContent(IMSDKFriendReqInfo iMSDKFriendReqInfo, IMSDKResultListener iMSDKResultListener, Object... objArr) {
        if (iMSDKFriendReqInfo.type == 3) {
            ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
            builder.setContentTitle(iMSDKFriendReqInfo.title);
            builder.setContentDescription(iMSDKFriendReqInfo.content);
            builder.setImageUrl(convert2Uri(iMSDKFriendReqInfo.imagePath));
            builder.setContentUrl(convert2UriWithParas(iMSDKFriendReqInfo.link, iMSDKFriendReqInfo.extraJson));
            builder.setPeopleIds(getSendToFriendList(iMSDKFriendReqInfo.extraJson));
            return builder.build();
        }
        Bitmap bitmap = null;
        if (iMSDKFriendReqInfo.type == 5) {
            SharePhotoContent.Builder builder2 = new SharePhotoContent.Builder();
            builder2.setPeopleIds(getSendToFriendList(iMSDKFriendReqInfo.extraJson));
            SharePhoto.Builder builder3 = new SharePhoto.Builder();
            builder3.setCaption(iMSDKFriendReqInfo.content);
            if (Patterns.WEB_URL.matcher(iMSDKFriendReqInfo.imagePath).matches()) {
                builder3.setImageUrl(convert2Uri(iMSDKFriendReqInfo.imagePath));
            } else if (FileUtils.isFileExist(iMSDKFriendReqInfo.imagePath)) {
                bitmap = BitmapFactory.decodeFile(iMSDKFriendReqInfo.imagePath);
            } else {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.mCtx.getContentResolver(), Uri.parse(iMSDKFriendReqInfo.imagePath));
                } catch (IOException e) {
                    IMLogger.d(e.getMessage());
                }
            }
            if (bitmap != null) {
                builder3.setBitmap(bitmap);
                builder3.setUserGenerated(true);
            }
            builder2.addPhoto(builder3.build());
            return builder2.build();
        }
        IMLogger.e("no support type : " + iMSDKFriendReqInfo.type, new Object[0]);
        return null;
    }

    private void deliverMessageWithDialog(final boolean z, final IMSDKFriendReqInfo iMSDKFriendReqInfo, final IMSDKResultListener iMSDKResultListener, final Object... objArr) {
        IMSDKProxyActivity.registerLifeCycle(this.mCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.4
            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected void onActivityCreate(Bundle bundle, Activity activity) {
                FacebookDialog messageDialog;
                ShareContent createShareContent = FacebookFriend.this.createShareContent(iMSDKFriendReqInfo, iMSDKResultListener, objArr);
                if (z) {
                    messageDialog = new ShareDialog(activity);
                } else {
                    messageDialog = new MessageDialog(activity);
                }
                FacebookFriend.this.reportEvent("share", "create share content success", z ? "ShareDialog" : "MessageDialog");
                IMLogger.d("deliverMessageWithDialog isShared = " + z + ", info = " + iMSDKFriendReqInfo.toString());
                if (!z && !FacebookFriend.this.isMessengerInstalled()) {
                    FacebookFriend.this.returnByError(iMSDKResultListener, 15, 15, "need Messenger installed Or Login!");
                    activity.finish();
                } else {
                    if (!z || DeviceUtils.isAppInstalled(FacebookFriend.this.mCtx, InnerStat.ThirdPN.FACEBOOK)) {
                        messageDialog.registerCallback(FacebookFriend.this.mCallbackManager, new FacebookCallback<Sharer.Result>() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.4.1
                            @Override // com.facebook.FacebookCallback
                            public void onSuccess(Sharer.Result result) {
                                IMLogger.d("deliverMessageWithDialog isShare = " + z + ", onSuccess called, result = " + result.toString());
                                StringBuilder sb = new StringBuilder();
                                sb.append(z ? "facebook share dialog success : " : "facebook send message dialog success : ");
                                sb.append(result.getPostId());
                                IMSDKResult iMSDKResult = new IMSDKResult(1, 1, sb.toString());
                                try {
                                    new JSONObject().put("PostId", result.getPostId());
                                } catch (JSONException e) {
                                    IMLogger.e("can not get post id : " + e.getMessage(), new Object[0]);
                                    FacebookFriend.this.reportEvent("share", "json parse error after share success", e.getMessage());
                                }
                                iMSDKResultListener.onResult(iMSDKResult);
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onCancel() {
                                IMLogger.w("deliverMessageWithDialog isShare = " + z + ", onCancel called", new Object[0]);
                                iMSDKResultListener.onResult(new IMSDKResult(2, 2, "share canceled !"));
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onError(FacebookException facebookException) {
                                IMLogger.e("deliverMessageWithDialog isShare = " + z + ", onError called, error = " + facebookException.toString(), new Object[0]);
                                iMSDKResultListener.onResult(new IMSDKResult(9999, -1, facebookException.getMessage()));
                            }
                        });
                        if (createShareContent != null) {
                            messageDialog.show(createShareContent);
                            return;
                        }
                        return;
                    }
                    FacebookFriend.this.returnByError(iMSDKResultListener, 15, 15, "need Facebook App installed !");
                    activity.finish();
                }
            }

            @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
            protected boolean onActivityResult(int i, int i2, Intent intent) {
                FacebookFriend.this.mCallbackManager.onActivityResult(i, i2, intent);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMessengerInstalled() {
        Intent intent = new Intent();
        intent.setClassName(MessengerUtils.PACKAGE_NAME, "com.facebook.orca.auth.StartScreenActivity");
        return this.mCtx.getPackageManager().resolveActivity(intent, 0) != null;
    }

    @Override // com.tencent.imsdk.android.base.interfaces.IAppAvailable
    public boolean isApplicationInstalled() {
        return isMessengerInstalled();
    }

    protected Uri convert2UriWithParas(String str, String str2) {
        if (T.ckIsEmpty(str2)) {
            return convert2Uri(str);
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("parasMap")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parasMap");
                if (jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                } else {
                    IMLogger.w("parasMapObj is null", new Object[0]);
                }
            } else {
                IMLogger.w("parasMap key not exist", new Object[0]);
            }
        } catch (JSONException e) {
            IMLogger.w("FacebookFriend catch JSONException : " + e.getMessage(), new Object[0]);
        } catch (Exception e2) {
            IMLogger.w("FacebookFriend catch Exception : " + e2.getMessage(), new Object[0]);
        }
        return addPara2Uri(str, hashMap);
    }

    protected Uri addPara2Uri(String str, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return convert2Uri(str);
        }
        StringBuilder sb = new StringBuilder(str);
        try {
            if (T.ckIsEmpty(new URL(str).getQuery())) {
                sb.append("?");
            } else if (!str.endsWith("&")) {
                sb.append("&");
            }
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                sb.append(str2 + "=");
                sb.append(str3);
                sb.append("&");
            }
            sb.append("channel=");
            sb.append("Facebook");
            IMLogger.d("final url is : " + sb.toString());
            return convert2Uri(sb.toString());
        } catch (MalformedURLException unused) {
            IMLogger.w("need a valid url start with http:// or https://, url=" + str + ", parasMap=" + map, new Object[0]);
            return convert2Uri(str);
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void getJsonParas(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        HashMap hashMap;
        IMLogger.d("getJsonParas, paraJson=[" + str + "]");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            hashMap = new HashMap();
            resolveMap(str, hashMap);
            IMLogger.d("getJsonParas, parasMap=" + hashMap);
        } catch (JSONException e) {
            iMSDKResultListener.onResult(new IMSDKResult(11, 11, e.getMessage()));
        }
        if (hashMap.size() == 0) {
            iMSDKResultListener.onResult(new IMSDKResult(11, 11, "getJsonParas error!"));
            return;
        }
        for (String str2 : hashMap.keySet()) {
            jSONObject2.put(str2, hashMap.get(str2));
        }
        jSONObject.put("parasMap", jSONObject2);
        IMSDKResult iMSDKResult = new IMSDKResult(1, 1, "getJsonParas success!");
        iMSDKResult.retExtraJson = jSONObject.toString();
        IMLogger.d("getJsonParas, retExtraJson=" + jSONObject.toString());
        iMSDKResultListener.onResult(iMSDKResult);
    }

    private void resolveMap(String str, Map<String, String> map) {
        if (T.ckIsEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("=");
        String substring = str.substring(0, indexOf);
        int indexOf2 = str.indexOf("&");
        if (indexOf2 != -1) {
            map.put(substring, str.substring(indexOf + 1, indexOf2));
            resolveMap(str.substring(indexOf2 + 1), map);
        } else {
            map.put(substring, str.substring(indexOf + 1));
        }
    }

    @Override // com.tencent.imsdk.android.base.relation.IMSDKFriendBase
    public void getInviteFriends(final int i, final int i2, String str, final IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        IMLogger.d("getInviteFriends page=" + i + "|count=" + i2 + "|extraJson=" + str);
        if (i <= 0 || i2 <= 0) {
            IMLogger.e("getFriends invalid argument, page=" + i + "|count=" + i2, new Object[0]);
            iMSDKResultListener.onResult(new IMSDKFriendListResult(11, -1, "page <= 0 || count <= 0"));
            return;
        }
        new Thread(new Runnable() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.5
            @Override // java.lang.Runnable
            public void run() {
                GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "/me/invitable_friends", new GraphRequest.Callback() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.5.1
                    @Override // com.facebook.GraphRequest.Callback
                    public void onCompleted(GraphResponse graphResponse) {
                        IMLogger.d("getFriends onCompleted: " + graphResponse.toString());
                        if (graphResponse.getJSONObject() != null) {
                            FacebookFriend.this.parseFriendsJson(i, graphResponse.getJSONObject(), new ArrayList<>(), iMSDKResultListener);
                        } else {
                            IMLogger.e("getFriends onCompleted response = null", new Object[0]);
                            iMSDKResultListener.onResult(new IMSDKFriendListResult(9999, graphResponse.getError().getErrorCode(), graphResponse.getError().getErrorMessage()));
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putString("limit", String.valueOf(i2));
                newGraphPathRequest.setParameters(bundle);
                newGraphPathRequest.executeAsync();
            }
        }).start();
    }

    protected void callbackWithResult(ArrayList<IMSDKFriendInfo> arrayList, IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        IMSDKFriendListResult iMSDKFriendListResult = new IMSDKFriendListResult(1, 1);
        iMSDKFriendListResult.sameGameFriendList = arrayList;
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(iMSDKFriendListResult);
        }
    }

    protected void parseFriendsJson(int i, JSONObject jSONObject, final ArrayList<IMSDKFriendInfo> arrayList, final IMSDKResultListener<IMSDKFriendListResult> iMSDKResultListener) {
        IMLogger.d("parseFriendsJson page=" + i + "|friendJson=" + jSONObject);
        if (jSONObject != null && jSONObject.has("data")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    IMSDKFriendInfo iMSDKFriendInfo = new IMSDKFriendInfo();
                    if (jSONObject2.has("id")) {
                        iMSDKFriendInfo.channelUserId = jSONObject2.getString("id");
                    }
                    if (jSONObject2.has("name")) {
                        iMSDKFriendInfo.userName = jSONObject2.getString("name");
                    }
                    if (jSONObject2.has("picture") && jSONObject2.getJSONObject("picture").has("data") && jSONObject2.getJSONObject("picture").getJSONObject("data").has("url")) {
                        iMSDKFriendInfo.pictureUrl = jSONObject2.getJSONObject("picture").getJSONObject("data").getString("url");
                    }
                    arrayList.add(iMSDKFriendInfo);
                }
                if (i == 1) {
                    callbackWithResult(arrayList, iMSDKResultListener);
                    return;
                }
                final int i3 = i - 1;
                arrayList.clear();
                if (jSONObject.has("paging") && jSONObject.getJSONObject("paging").has("next")) {
                    String string = jSONObject.getJSONObject("paging").getString("next");
                    IMLogger.d("get_next_url=" + string);
                    new IMSDKHttpClient(this.mCurCtx).get(string, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.friend.facebook.FacebookFriend.6
                        @Override // com.tencent.imsdk.android.base.IMSDKListener
                        public void onNotify(byte[] bArr) {
                            if (bArr != null) {
                                try {
                                    FacebookFriend.this.parseFriendsJson(i3, new JSONObject(new String(bArr)), arrayList, iMSDKResultListener);
                                    return;
                                } catch (JSONException e) {
                                    IMLogger.w("parseFriendsJson httpClient onNotify catch error:" + e.getMessage(), new Object[0]);
                                    FacebookFriend.this.callbackWithResult(arrayList, iMSDKResultListener);
                                    return;
                                }
                            }
                            IMLogger.w("parseFriendsJson httpClient onNotify return result=null", new Object[0]);
                            FacebookFriend.this.callbackWithResult(arrayList, iMSDKResultListener);
                        }

                        @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                        public void onResult(IMSDKResult iMSDKResult) {
                            IMLogger.w("parseFriendsJson httpClient get onResult:" + iMSDKResult.toString(), new Object[0]);
                            FacebookFriend.this.callbackWithResult(arrayList, iMSDKResultListener);
                        }
                    });
                    return;
                }
                iMSDKResultListener.onResult(new IMSDKFriendListResult(11, -1, "page conflict next, error page|count argument!!!"));
                return;
            } catch (JSONException e) {
                IMLogger.w("parseFriendsJson catch error:" + e.getMessage(), new Object[0]);
                callbackWithResult(arrayList, iMSDKResultListener);
                return;
            }
        }
        IMLogger.d("parseFriendsJson friendsJson null || friendsJson not contains data");
        callbackWithResult(arrayList, iMSDKResultListener);
    }

    @Override // com.tencent.imsdk.android.base.interfaces.ILauncher
    public void handleLaunchData(Intent intent, IMSDKResultListener<IMSDKLaunchResult> iMSDKResultListener) {
        Uri parse;
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                IMLogger.d("handle uri : " + data.toString());
                IMSDKLaunchResult iMSDKLaunchResult = new IMSDKLaunchResult(1, 1);
                JSONObject jSONObject = new JSONObject();
                for (String str : data.getQueryParameterNames()) {
                    try {
                        jSONObject.put(str, data.getQueryParameter(str));
                    } catch (Exception e) {
                        IMLogger.w("put uri parameter " + str + " failed : " + e.getMessage(), new Object[0]);
                    }
                    if (str.equals("target_url") && (parse = Uri.parse(data.getQueryParameter(str))) != null) {
                        for (String str2 : parse.getQueryParameterNames()) {
                            try {
                                jSONObject.put(str2, parse.getQueryParameter(str2));
                            } catch (Exception e2) {
                                IMLogger.w("put uri parameter " + str + " failed : " + e2.getMessage(), new Object[0]);
                            }
                        }
                    }
                }
                iMSDKLaunchResult.launchUri = data.toString();
                iMSDKLaunchResult.launchData = jSONObject.toString();
                iMSDKResultListener.onResult(iMSDKLaunchResult);
                return;
            }
            IMLogger.w("uri is null", new Object[0]);
            iMSDKResultListener.onResult(new IMSDKLaunchResult(11, 11, "uri is null"));
            return;
        }
        IMLogger.w("intent is null", new Object[0]);
        iMSDKResultListener.onResult(new IMSDKLaunchResult(11, 11, "intent is null"));
    }
}
