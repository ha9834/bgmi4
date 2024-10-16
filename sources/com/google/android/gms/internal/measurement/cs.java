package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class cs implements cy {

    /* renamed from: a, reason: collision with root package name */
    private cy[] f4509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cy... cyVarArr) {
        this.f4509a = cyVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.cy
    public final boolean a(Class<?> cls) {
        for (cy cyVar : this.f4509a) {
            if (cyVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.cy
    public final cz b(Class<?> cls) {
        for (cy cyVar : this.f4509a) {
            if (cyVar.a(cls)) {
                return cyVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
