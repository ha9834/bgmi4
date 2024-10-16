package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class b implements OnSuccessListener<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ OnTokenCanceledListener f5183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.f5183a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Void r1) {
        this.f5183a.onCanceled();
    }
}
