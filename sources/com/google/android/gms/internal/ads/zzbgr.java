package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;

@zzard
@TargetApi(11)
/* loaded from: classes2.dex */
public final class zzbgr extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2871a;

    public zzbgr(zzbgz zzbgzVar) {
        this.f2871a = zzbgzVar;
    }

    private final boolean a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        com.google.android.gms.ads.internal.zzb zzaax;
        try {
        } catch (WindowManager.BadTokenException e) {
            zzawz.zzd("Fail to display Dialog.", e);
        }
        if (this.f2871a != null && this.f2871a.zzaai() != null && this.f2871a.zzaai().zzaax() != null && (zzaax = this.f2871a.zzaai().zzaax()) != null && !zzaax.zzkx()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzaax.zzbk(sb.toString());
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str2);
        if (z) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builder.setView(linearLayout).setPositiveButton(R.string.ok, new la(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new kz(jsPromptResult)).setOnCancelListener(new ky(jsPromptResult)).create().show();
        } else {
            builder.setMessage(str3).setPositiveButton(R.string.ok, new kx(jsResult)).setNegativeButton(R.string.cancel, new kw(jsResult)).setOnCancelListener(new kv(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.f2871a.zzaaj() != null) {
            webView2.setWebViewClient(this.f2871a.zzaaj());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            zzawz.zzep("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzaae = ((zzbgz) webView).zzaae();
        if (zzaae == null) {
            zzawz.zzep("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaae.close();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (lb.f2309a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzawz.zzen(sb2);
                break;
            case 2:
                zzawz.zzep(sb2);
                break;
            case 3:
            case 4:
                zzawz.zzeo(sb2);
                break;
            case 5:
                zzawz.zzdp(sb2);
                break;
            default:
                zzawz.zzeo(sb2);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(j + Math.min(131072L, j4), 1048576L);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzd zzaae = this.f2871a.zzaae();
        if (zzaae == null) {
            zzawz.zzep("Could not get ad overlay when hiding custom view.");
        } else {
            zzaae.zzte();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context a(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            return webView.getContext();
        }
        zzbgz zzbgzVar = (zzbgz) webView;
        Activity zzyd = zzbgzVar.zzyd();
        return zzyd != null ? zzyd : zzbgzVar.getContext();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + 131072;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzd zzaae = this.f2871a.zzaae();
        if (zzaae == null) {
            zzawz.zzep("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            zzaae.zza(view, customViewCallback);
            zzaae.setRequestedOrientation(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzk.zzlg();
            if (!zzaxi.zzp(this.f2871a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzk.zzlg();
                if (!zzaxi.zzp(this.f2871a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (PlatformVersion.isAtLeastLollipop()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcol)).booleanValue()) {
                zzbgz zzbgzVar = this.f2871a;
                if (zzbgzVar == null || zzbgzVar.zzaai() == null || this.f2871a.zzaai().zzabj() == null) {
                    super.onPermissionRequest(permissionRequest);
                    return;
                }
                String[] zza = this.f2871a.zzaai().zzabj().zza(permissionRequest.getResources());
                if (zza.length > 0) {
                    permissionRequest.grant(zza);
                    return;
                } else {
                    permissionRequest.deny();
                    return;
                }
            }
        }
        super.onPermissionRequest(permissionRequest);
    }
}