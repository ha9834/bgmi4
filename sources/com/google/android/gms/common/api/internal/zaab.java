package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zaab {

    /* renamed from: a, reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f1383a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<TaskCompletionSource<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f1383a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new b(this, basePendingResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <TResult> void a(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.getTask().addOnCompleteListener(new c(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return (this.f1383a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void zaah() {
        a(false, GoogleApiManager.zahx);
    }

    public final void zaai() {
        a(true, zacp.zakx);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1383a) {
            hashMap = new HashMap(this.f1383a);
        }
        synchronized (this.b) {
            hashMap2 = new HashMap(this.b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).zab(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }
}
