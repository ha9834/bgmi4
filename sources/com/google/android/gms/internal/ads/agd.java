package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class agd implements agj {

    /* renamed from: a, reason: collision with root package name */
    private agj[] f1861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agd(agj... agjVarArr) {
        this.f1861a = agjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.agj
    public final boolean a(Class<?> cls) {
        for (agj agjVar : this.f1861a) {
            if (agjVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agj
    public final agi b(Class<?> cls) {
        for (agj agjVar : this.f1861a) {
            if (agjVar.a(cls)) {
                return agjVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
