package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.a.a;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;

@KeepName
/* loaded from: classes.dex */
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1259a;
    private boolean b = false;
    private SignInConfiguration c;
    private boolean d;
    private int e;
    private Intent f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0060a<Void> {
        private a() {
        }

        @Override // androidx.loader.a.a.InterfaceC0060a
        public final void a(androidx.loader.content.b<Void> bVar) {
        }

        @Override // androidx.loader.a.a.InterfaceC0060a
        public final androidx.loader.content.b<Void> a(int i, Bundle bundle) {
            return new zze(SignInHubActivity.this, GoogleApiClient.getAllClients());
        }

        @Override // androidx.loader.a.a.InterfaceC0060a
        public final /* synthetic */ void a(androidx.loader.content.b<Void> bVar, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.e, SignInHubActivity.this.f);
            SignInHubActivity.this.finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            a(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        this.c = (SignInConfiguration) intent.getBundleExtra(ConfigDBHelper.TABLE_NAME_CONFIG).getParcelable(ConfigDBHelper.TABLE_NAME_CONFIG);
        if (this.c == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            if (f1259a) {
                setResult(0);
                a(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                return;
            }
            f1259a = true;
            Intent intent2 = new Intent(action);
            if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                intent2.setPackage("com.google.android.gms");
            } else {
                intent2.setPackage(getPackageName());
            }
            intent2.putExtra(ConfigDBHelper.TABLE_NAME_CONFIG, this.c);
            try {
                startActivityForResult(intent2, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_HTTP_ERROR);
                return;
            } catch (ActivityNotFoundException unused) {
                this.b = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                a(17);
                return;
            }
        }
        this.d = bundle.getBoolean("signingInGoogleApiClients");
        if (this.d) {
            this.e = bundle.getInt("signInResultCode");
            this.f = (Intent) bundle.getParcelable("signInResultData");
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.d);
        if (this.d) {
            bundle.putInt("signInResultCode", this.e);
            bundle.putParcelable("signInResultData", this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.b) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
            if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                zzp.zzd(this).zzc(this.c.zzm(), googleSignInAccount);
                intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.d = true;
                this.e = i2;
                this.f = intent;
                a();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                }
                a(intExtra);
                return;
            }
        }
        a(8);
    }

    private final void a() {
        getSupportLoaderManager().a(0, null, new a());
        f1259a = false;
    }

    private final void a(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f1259a = false;
    }
}
