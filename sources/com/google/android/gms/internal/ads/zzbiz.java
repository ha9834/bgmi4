package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.games.Notifications;
import com.intlgame.core.INTLMethodID;
import com.tencent.abase.utils.ConstantUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbiz extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f2880a = {ConstantUtils.NET_UNKNOWN, "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] b = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzbje c;

    public void zza(zzbja zzbjaVar) {
    }

    public void zzb(zzbja zzbjaVar) {
    }

    public boolean zzc(zzbja zzbjaVar) {
        return false;
    }

    public WebResourceResponse zzd(zzbja zzbjaVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbje zzbjeVar) {
        this.c = zzbjeVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (str == null) {
            return;
        }
        zzbja zzbjaVar = new zzbja(str);
        zzbje zzbjeVar = this.c;
        if (zzbjeVar != null) {
            zzbjeVar.zza(zzbjaVar);
        } else {
            zza(zzbjaVar);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (str == null) {
            return;
        }
        String valueOf = String.valueOf(str);
        zzawz.zzds(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        zzb(new zzbja(str));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        return zzc(new zzbja(str));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return false;
        }
        return zzc(new zzbja(webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str == null) {
            return null;
        }
        return zzd(new zzbja(str));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzd(new zzbja(webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (i >= 0 || (-i) - 1 >= f2880a.length) {
            String.valueOf(i);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError == null) {
            return;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError < 0 || primaryError >= b.length) {
            String.valueOf(primaryError);
        }
        sslError.getUrl();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case Notifications.NOTIFICATION_TYPES_ALL /* 127 */:
                    case 128:
                    case 129:
                    case INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
