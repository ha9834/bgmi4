package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class er implements fa {

    /* renamed from: a, reason: collision with root package name */
    static final fa f2155a = new er();

    private er() {
    }

    @Override // com.google.android.gms.internal.ads.fa
    public final Object a(zzbjf zzbjfVar) {
        String currentScreenName = zzbjfVar.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbjfVar.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
