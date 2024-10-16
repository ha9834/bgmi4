package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class Tasks {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        v vVar = new v();
        vVar.a((v) tresult);
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f5180a;

        private a() {
            this.f5180a = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.f5180a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.f5180a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.f5180a.countDown();
        }

        public final void a() throws InterruptedException {
            this.f5180a.await();
        }

        public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f5180a.await(j, timeUnit);
        }

        /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        v vVar = new v();
        vVar.a(exc);
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5181a = new Object();
        private final int b;
        private final v<Void> c;

        @GuardedBy("mLock")
        private int d;

        @GuardedBy("mLock")
        private int e;

        @GuardedBy("mLock")
        private int f;

        @GuardedBy("mLock")
        private Exception g;

        @GuardedBy("mLock")
        private boolean h;

        public c(int i, v<Void> vVar) {
            this.b = i;
            this.c = vVar;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            synchronized (this.f5181a) {
                this.e++;
                this.g = exc;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            synchronized (this.f5181a) {
                this.d++;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            synchronized (this.f5181a) {
                this.f++;
                this.h = true;
                a();
            }
        }

        @GuardedBy("mLock")
        private final void a() {
            int i = this.d;
            int i2 = this.e;
            int i3 = i + i2 + this.f;
            int i4 = this.b;
            if (i3 == i4) {
                if (this.g != null) {
                    v<Void> vVar = this.c;
                    StringBuilder sb = new StringBuilder(54);
                    sb.append(i2);
                    sb.append(" out of ");
                    sb.append(i4);
                    sb.append(" underlying tasks failed");
                    vVar.a(new ExecutionException(sb.toString(), this.g));
                    return;
                }
                if (this.h) {
                    this.c.a();
                } else {
                    this.c.a((v<Void>) null);
                }
            }
        }
    }

    public static <TResult> Task<TResult> forCanceled() {
        v vVar = new v();
        vVar.a();
        return vVar;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        v vVar = new v();
        executor.execute(new w(vVar, callable));
        return vVar;
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        a aVar = new a(null);
        a(task, aVar);
        aVar.a();
        return (TResult) a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) a(task);
        }
        a aVar = new a(null);
        a(task, aVar);
        if (!aVar.a(j, timeUnit)) {
            throw new TimeoutException("Timed out waiting for Task");
        }
        return (TResult) a(task);
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        v vVar = new v();
        c cVar = new c(collection.size(), vVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            a(it2.next(), cVar);
        }
        return vVar;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        if (taskArr.length == 0) {
            return forResult(null);
        }
        return whenAll(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return (Task<List<TResult>>) whenAll(collection).continueWith(new x(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        return whenAllSuccess(Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWithTask(new y(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        return whenAllComplete(Arrays.asList(taskArr));
    }

    private static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void a(Task<?> task, b bVar) {
        task.addOnSuccessListener(TaskExecutors.f5178a, bVar);
        task.addOnFailureListener(TaskExecutors.f5178a, bVar);
        task.addOnCanceledListener(TaskExecutors.f5178a, bVar);
    }

    private Tasks() {
    }
}
