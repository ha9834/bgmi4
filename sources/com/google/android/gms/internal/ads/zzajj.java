package com.google.android.gms.internal.ads;

import android.content.Context;
import com.amazonaws.services.s3.util.Mimetypes;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzajj extends zzaju<zzalf> implements zzajq, zzajw {

    /* renamed from: a */
    private final zzbjb f2741a;
    private zzajx b;

    public zzajj(Context context, zzbai zzbaiVar) throws zzbhj {
        try {
            this.f2741a = new zzbjb(context, new az(this));
            this.f2741a.setWillNotDraw(true);
            this.f2741a.addJavascriptInterface(new ay(this), "GoogleJsInterface");
            zzk.zzlg().zza(context, zzbaiVar.zzbsx, this.f2741a.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbhj("Init failed.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zzi(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcl(String str) {
        zzcm(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcm(String str) {
        zzbbm.zzeae.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.au

            /* renamed from: a, reason: collision with root package name */
            private final zzajj f2059a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2059a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2059a.c(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcn(String str) {
        zzbbm.zzeae.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.av

            /* renamed from: a, reason: collision with root package name */
            private final zzajj f2060a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2060a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2060a.b(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(zzajx zzajxVar) {
        this.b = zzajxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void destroy() {
        this.f2741a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final boolean isDestroyed() {
        return this.f2741a.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final zzalg zzru() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void zzco(String str) {
        zzbbm.zzeae.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.aw

            /* renamed from: a, reason: collision with root package name */
            private final zzajj f2061a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2061a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2061a.a(this.b);
            }
        });
    }

    public final /* synthetic */ void a(String str) {
        this.f2741a.zzco(str);
    }

    public final /* synthetic */ void b(String str) {
        this.f2741a.loadUrl(str);
    }

    public final /* synthetic */ void c(String str) {
        this.f2741a.loadData(str, Mimetypes.MIMETYPE_HTML, "UTF-8");
    }
}
