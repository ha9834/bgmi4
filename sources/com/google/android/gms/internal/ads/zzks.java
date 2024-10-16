package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzks implements zzlo, zzlp {

    /* renamed from: a, reason: collision with root package name */
    private final int f3675a;
    private zzlq b;
    private int c;
    private int d;
    private zzqw e;
    private long f;
    private boolean g = true;
    private boolean h;

    public zzks(int i) {
        this.f3675a = i;
    }

    protected void a() throws zzku {
    }

    protected void a(long j, boolean z) throws zzku {
    }

    protected void a(boolean z) throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzlh[] zzlhVarArr, long j) throws zzku {
    }

    protected void b() throws zzku {
    }

    protected void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public void zza(int i, Object obj) throws zzku {
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzlp zzgi() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public zzso zzgj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public int zzgp() throws zzku {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlo, com.google.android.gms.internal.ads.zzlp
    public final int getTrackType() {
        return this.f3675a;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void setIndex(int i) {
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final int getState() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzlq zzlqVar, zzlh[] zzlhVarArr, zzqw zzqwVar, long j, boolean z, long j2) throws zzku {
        zzsk.checkState(this.d == 0);
        this.b = zzlqVar;
        this.d = 1;
        a(z);
        zza(zzlhVarArr, zzqwVar, j2);
        a(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void start() throws zzku {
        zzsk.checkState(this.d == 1);
        this.d = 2;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzlh[] zzlhVarArr, zzqw zzqwVar, long j) throws zzku {
        zzsk.checkState(!this.h);
        this.e = zzqwVar;
        this.g = false;
        this.f = j;
        a(zzlhVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzqw zzgk() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final boolean zzgl() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzgm() {
        this.h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final boolean zzgn() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzgo() throws IOException {
        this.e.zzjb();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzdx(long j) throws zzku {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void stop() throws zzku {
        zzsk.checkState(this.d == 2);
        this.d = 1;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void disable() {
        zzsk.checkState(this.d == 1);
        this.d = 0;
        this.e = null;
        this.h = false;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlq d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(zzlj zzljVar, zznd zzndVar, boolean z) {
        int zzb = this.e.zzb(zzljVar, zzndVar, z);
        if (zzb == -4) {
            if (zzndVar.zzic()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            zzndVar.zzaga += this.f;
        } else if (zzb == -5) {
            zzlh zzlhVar = zzljVar.zzaue;
            if (zzlhVar.zzaua != Long.MAX_VALUE) {
                zzljVar.zzaue = zzlhVar.zzed(zzlhVar.zzaua + this.f);
            }
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j) {
        this.e.zzeo(j - this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f() {
        return this.g ? this.h : this.e.isReady();
    }
}
