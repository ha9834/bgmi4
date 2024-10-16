package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class ec implements eb {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdp f4527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(zzdp zzdpVar) {
        this.f4527a = zzdpVar;
    }

    @Override // com.google.android.gms.internal.measurement.eb
    public final int a() {
        return this.f4527a.size();
    }

    @Override // com.google.android.gms.internal.measurement.eb
    public final byte a(int i) {
        return this.f4527a.zzaq(i);
    }
}
