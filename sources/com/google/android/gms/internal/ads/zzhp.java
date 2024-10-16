package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzhp implements zzgf {

    /* renamed from: a, reason: collision with root package name */
    private int f3647a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(long j) throws zzgd;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(long j, long j2) throws zzgd;

    protected void a(long j, boolean z) throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    protected abstract int b(long j) throws zzgd;

    protected void b() throws zzgd {
    }

    protected void c() throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean e();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long f();

    protected void k() throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long l();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long m();

    @Override // com.google.android.gms.internal.ads.zzgf
    public void zza(int i, Object obj) throws zzgd {
    }

    protected void zzdz() throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int o() {
        return this.f3647a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(long j) throws zzgd {
        zzkh.checkState(this.f3647a == 0);
        this.f3647a = b(j);
        int i = this.f3647a;
        zzkh.checkState(i == 0 || i == 1 || i == -1);
        return this.f3647a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j, boolean z) throws zzgd {
        zzkh.checkState(this.f3647a == 1);
        this.f3647a = 2;
        a(j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p() throws zzgd {
        zzkh.checkState(this.f3647a == 2);
        this.f3647a = 3;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() throws zzgd {
        zzkh.checkState(this.f3647a == 3);
        this.f3647a = 2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() throws zzgd {
        zzkh.checkState(this.f3647a == 2);
        this.f3647a = 1;
        zzdz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() throws zzgd {
        int i = this.f3647a;
        zzkh.checkState((i == 2 || i == 3 || i == -2) ? false : true);
        this.f3647a = -2;
        k();
    }
}
