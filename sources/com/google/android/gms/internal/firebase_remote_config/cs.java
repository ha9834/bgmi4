package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class cs implements cy {

    /* renamed from: a, reason: collision with root package name */
    private cy[] f4067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cy... cyVarArr) {
        this.f4067a = cyVarArr;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cy
    public final boolean a(Class<?> cls) {
        for (cy cyVar : this.f4067a) {
            if (cyVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.cy
    public final cw b(Class<?> cls) {
        for (cy cyVar : this.f4067a) {
            if (cyVar.a(cls)) {
                return cyVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
