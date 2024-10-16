package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbhk extends FrameLayout implements zzbgz {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2873a;
    private final zzbcw b;
    private final AtomicBoolean c;

    public zzbhk(zzbgz zzbgzVar) {
        super(zzbgzVar.getContext());
        this.c = new AtomicBoolean();
        this.f2873a = zzbgzVar;
        this.b = new zzbcw(zzbgzVar.zzaad(), this, this);
        addView(this.f2873a.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbih
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcw zzya() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void onPause() {
        this.b.onPause();
        this.f2873a.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaao() {
        this.b.onDestroy();
        this.f2873a.zzaao();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaau() {
        setBackgroundColor(0);
        this.f2873a.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int zzyi() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int zzyj() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzyk() {
        this.f2873a.zzyk();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebView getWebView() {
        return this.f2873a.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, Map<String, ?> map) {
        this.f2873a.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, JSONObject jSONObject) {
        this.f2873a.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f2873a.zza(str, zzahoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f2873a.zzb(str, zzahoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.f2873a.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaab() {
        this.f2873a.zzaab();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzdi(int i) {
        this.f2873a.zzdi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zztl() {
        this.f2873a.zztl();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaac() {
        this.f2873a.zzaac();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(boolean z, long j) {
        this.f2873a.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzco(String str) {
        this.f2873a.zzco(str);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzb(String str, JSONObject jSONObject) {
        this.f2873a.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    public final Activity zzyd() {
        return this.f2873a.zzyd();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final Context zzaad() {
        return this.f2873a.zzaad();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final com.google.android.gms.ads.internal.zza zzye() {
        return this.f2873a.zzye();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final com.google.android.gms.ads.internal.overlay.zzd zzaae() {
        return this.f2873a.zzaae();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final IObjectWrapper zzaam() {
        return this.f2873a.zzaam();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final com.google.android.gms.ads.internal.overlay.zzd zzaaf() {
        return this.f2873a.zzaaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbie
    public final zzbin zzaag() {
        return this.f2873a.zzaag();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final String zzaah() {
        return this.f2873a.zzaah();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzbii zzaai() {
        return this.f2873a.zzaai();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebViewClient zzaaj() {
        return this.f2873a.zzaaj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaak() {
        return this.f2873a.zzaak();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbif
    public final zzdh zzaal() {
        return this.f2873a.zzaal();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbig
    public final zzbai zzyh() {
        return this.f2873a.zzyh();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbhy
    public final boolean zzaan() {
        return this.f2873a.zzaan();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean isDestroyed() {
        return this.f2873a.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaap() {
        return this.f2873a.zzaap();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzld() {
        this.f2873a.zzld();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzlc() {
        this.f2873a.zzlc();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final String zzyf() {
        return this.f2873a.zzyf();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzadg zzyc() {
        return this.f2873a.zzyc();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzadh zzyg() {
        return this.f2873a.zzyg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzbhq zzyb() {
        return this.f2873a.zzyb();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f2873a.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.f2873a.zzam(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzbin zzbinVar) {
        this.f2873a.zza(zzbinVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaq(boolean z) {
        this.f2873a.zzaq(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaar() {
        this.f2873a.zzaar();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzbn(Context context) {
        this.f2873a.zzbn(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaf(boolean z) {
        this.f2873a.zzaf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setRequestedOrientation(int i) {
        this.f2873a.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f2873a.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzar(boolean z) {
        this.f2873a.zzar(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final void zza(String str, zzbft zzbftVar) {
        this.f2873a.zza(str, zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbft zzet(String str) {
        return this.f2873a.zzet(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaas() {
        this.f2873a.zzaas();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void destroy() {
        IObjectWrapper zzaam = zzaam();
        if (zzaam != null) {
            zzk.zzlv().zzab(zzaam);
            zzaxi.zzdvv.postDelayed(new lj(this), ((Integer) zzyt.zzpe().zzd(zzacu.zzcuv)).intValue());
            return;
        }
        this.f2873a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadData(String str, String str2, String str3) {
        this.f2873a.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f2873a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadUrl(String str) {
        this.f2873a.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzb(String str, String str2, String str3) {
        this.f2873a.zzb(str, str2, str3);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2873a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f2873a.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f2873a.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f2873a.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void onResume() {
        this.f2873a.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaav() {
        TextView textView = new TextView(getContext());
        Resources resources = zzk.zzlk().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzat(boolean z) {
        this.f2873a.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzadv zzadvVar) {
        this.f2873a.zza(zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        this.f2873a.zza(zzudVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzadx zzadxVar) {
        this.f2873a.zza(zzadxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzadx zzaat() {
        return this.f2873a.zzaat();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final void zza(zzbhq zzbhqVar) {
        this.f2873a.zza(zzbhqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaaq() {
        return this.f2873a.zzaaq();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzas(boolean z) {
        this.f2873a.zzas(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzao(boolean z) {
        this.f2873a.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zztm() {
        this.f2873a.zztm();
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.f2873a.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zzc(boolean z, int i) {
        this.f2873a.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str) {
        this.f2873a.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void zza(boolean z, int i, String str, String str2) {
        this.f2873a.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzb(boolean z, int i) {
        if (!this.c.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoo)).booleanValue()) {
            return false;
        }
        removeView(this.f2873a.getView());
        return this.f2873a.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzaaw() {
        return this.c.get();
    }
}
