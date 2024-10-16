package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@VisibleForTesting
@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface zzbgz extends zzj, zzaji, zzakg, zzbdf, zzbhx, zzbhy, zzbic, zzbif, zzbig, zzbih, zzue {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbdf
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zza(zzadv zzadvVar);

    void zza(zzadx zzadxVar);

    void zza(zzbhq zzbhqVar);

    void zza(zzbin zzbinVar);

    void zza(String str, Predicate<zzaho<? super zzbgz>> predicate);

    void zza(String str, zzaho<? super zzbgz> zzahoVar);

    void zza(String str, zzbft zzbftVar);

    void zzaab();

    void zzaac();

    Context zzaad();

    com.google.android.gms.ads.internal.overlay.zzd zzaae();

    com.google.android.gms.ads.internal.overlay.zzd zzaaf();

    zzbin zzaag();

    String zzaah();

    zzbii zzaai();

    WebViewClient zzaaj();

    boolean zzaak();

    zzdh zzaal();

    IObjectWrapper zzaam();

    boolean zzaan();

    void zzaao();

    boolean zzaap();

    boolean zzaaq();

    void zzaar();

    void zzaas();

    zzadx zzaat();

    void zzaau();

    void zzaav();

    boolean zzaaw();

    void zzaf(boolean z);

    void zzam(IObjectWrapper iObjectWrapper);

    void zzaq(boolean z);

    void zzar(boolean z);

    void zzas(boolean z);

    void zzat(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void zzb(String str, zzaho<? super zzbgz> zzahoVar);

    void zzb(String str, String str2, String str3);

    boolean zzb(boolean z, int i);

    void zzbn(Context context);

    void zzdi(int i);

    void zztl();

    zzbhq zzyb();

    Activity zzyd();

    com.google.android.gms.ads.internal.zza zzye();

    zzadh zzyg();

    zzbai zzyh();
}
