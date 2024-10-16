package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class cj implements cp {

    /* renamed from: a, reason: collision with root package name */
    private cp[] f4334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cp... cpVarArr) {
        this.f4334a = cpVarArr;
    }

    @Override // com.google.android.gms.internal.gtm.cp
    public final boolean a(Class<?> cls) {
        for (cp cpVar : this.f4334a) {
            if (cpVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.cp
    public final co b(Class<?> cls) {
        for (cp cpVar : this.f4334a) {
            if (cpVar.a(cls)) {
                return cpVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
