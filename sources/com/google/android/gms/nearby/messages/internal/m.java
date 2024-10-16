package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements OnCompleteListener<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ TaskCompletionSource f5013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.f5013a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Boolean> task) {
        if (task.isSuccessful()) {
            this.f5013a.setResult(null);
        } else {
            this.f5013a.setException(task.getException());
        }
    }
}
