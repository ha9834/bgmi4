package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;

@zzard
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzbht<WebViewT extends zzbhx & zzbif & zzbih> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbhw f2875a;
    private final WebViewT b;

    public static zzbht<zzbgz> zzc(final zzbgz zzbgzVar) {
        return new zzbht<>(zzbgzVar, new zzbhw(zzbgzVar) { // from class: com.google.android.gms.internal.ads.lq

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2324a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2324a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhw
            public final void zzh(Uri uri) {
                zzbii zzaai = this.f2324a.zzaai();
                if (zzaai == null) {
                    zzawz.zzen("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    zzaai.zzh(uri);
                }
            }
        });
    }

    private zzbht(WebViewT webviewt, zzbhw zzbhwVar) {
        this.f2875a = zzbhwVar;
        this.b = webviewt;
    }

    @JavascriptInterface
    public final void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzawz.zzep("URL is empty, ignoring message");
        } else {
            zzaxi.zzdvv.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.lr

                /* renamed from: a, reason: collision with root package name */
                private final zzbht f2325a;
                private final String b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2325a = this;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2325a.a(this.b);
                }
            });
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawz.zzds("Click string is empty, not proceeding.");
            return "";
        }
        zzdh zzaal = this.b.zzaal();
        if (zzaal == null) {
            zzawz.zzds("Signal utils is empty, ignoring.");
            return "";
        }
        zzdc zzcg = zzaal.zzcg();
        if (zzcg == null) {
            zzawz.zzds("Signals object is empty, ignoring.");
            return "";
        }
        if (this.b.getContext() == null) {
            zzawz.zzds("Context is null, ignoring.");
            return "";
        }
        return zzcg.zza(this.b.getContext(), str, this.b.getView(), this.b.zzyd());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.f2875a.zzh(Uri.parse(str));
    }
}
