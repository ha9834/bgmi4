package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    final ArrayDeque<b> f122a;
    private final Runnable b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f122a = new ArrayDeque<>();
        this.b = runnable;
    }

    androidx.activity.a a(b bVar) {
        this.f122a.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    @SuppressLint({"LambdaLast"})
    public void a(k kVar, b bVar) {
        Lifecycle lifecycle = kVar.getLifecycle();
        if (lifecycle.a() == Lifecycle.State.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
    }

    public void a() {
        Iterator<b> descendingIterator = this.f122a.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {
        private final b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // androidx.activity.a
        public void a() {
            OnBackPressedDispatcher.this.f122a.remove(this.b);
            this.b.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements androidx.activity.a, i {
        private final Lifecycle b;
        private final b c;
        private androidx.activity.a d;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, b bVar) {
            this.b = lifecycle;
            this.c = bVar;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.i
        public void a(k kVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.d = OnBackPressedDispatcher.this.a(this.c);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                androidx.activity.a aVar = this.d;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                a();
            }
        }

        @Override // androidx.activity.a
        public void a() {
            this.b.b(this);
            this.c.b(this);
            androidx.activity.a aVar = this.d;
            if (aVar != null) {
                aVar.a();
                this.d = null;
            }
        }
    }
}
