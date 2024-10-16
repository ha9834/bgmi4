package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y implements Continuation<Void, Task<List<Task<?>>>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Collection f5203a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Collection collection) {
        this.f5203a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<List<Task<?>>> then(Task<Void> task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5203a);
        return Tasks.forResult(arrayList);
    }
}
