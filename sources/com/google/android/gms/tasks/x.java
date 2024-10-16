package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* loaded from: classes2.dex */
final class x<TResult> implements Continuation<Void, List<TResult>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Collection f5202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Collection collection) {
        this.f5202a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task<Void> task) throws Exception {
        if (this.f5202a.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f5202a.iterator();
        while (it.hasNext()) {
            arrayList.add(((Task) it.next()).getResult());
        }
        return arrayList;
    }
}
