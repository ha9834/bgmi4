package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class a<T> implements OnDelegateCreatedListener<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ DeferredLifecycleHelper f1587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f1587a = deferredLifecycleHelper;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LifecycleDelegate lifecycleDelegate2;
        this.f1587a.f1582a = lifecycleDelegate;
        linkedList = this.f1587a.c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            DeferredLifecycleHelper.a aVar = (DeferredLifecycleHelper.a) it.next();
            lifecycleDelegate2 = this.f1587a.f1582a;
            aVar.a(lifecycleDelegate2);
        }
        linkedList2 = this.f1587a.c;
        linkedList2.clear();
        DeferredLifecycleHelper.a(this.f1587a, (Bundle) null);
    }
}
