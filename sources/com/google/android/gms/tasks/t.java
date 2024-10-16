package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class t implements OnTokenCanceledListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5199a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TaskCompletionSource taskCompletionSource) {
        this.f5199a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        v vVar;
        vVar = this.f5199a.f5177a;
        vVar.a();
    }
}
