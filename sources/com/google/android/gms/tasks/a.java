package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class a extends CancellationToken {

    /* renamed from: a, reason: collision with root package name */
    private final v<Void> f5182a = new v<>();

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f5182a.isComplete();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.f5182a.addOnSuccessListener(new b(this, onTokenCanceledListener));
        return this;
    }

    public final void a() {
        this.f5182a.b((v<Void>) null);
    }
}
