package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* loaded from: classes.dex */
public final class WorkQueue {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final ReentrantLock workLock;

    /* loaded from: classes.dex */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQueue() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQueue(int i) {
        this(i, null, 2, 0 == true ? 1 : 0);
    }

    public final WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem$default(this, runnable, false, 2, null);
    }

    public WorkQueue(int i, Executor executor) {
        h.b(executor, "executor");
        this.maxConcurrent = i;
        this.executor = executor;
        this.workLock = new ReentrantLock();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ WorkQueue(int r1, java.util.concurrent.Executor r2, int r3, kotlin.jvm.internal.f r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L6
            r1 = 8
        L6:
            r3 = r3 & 2
            if (r3 == 0) goto L13
            java.util.concurrent.Executor r2 = com.facebook.FacebookSdk.getExecutor()
            java.lang.String r3 = "FacebookSdk.getExecutor()"
            kotlin.jvm.internal.h.a(r2, r3)
        L13:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.<init>(int, java.util.concurrent.Executor, int, kotlin.jvm.internal.f):void");
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: assert, reason: not valid java name */
        public final void m7assert(boolean z) {
            if (!z) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return workQueue.addActiveWorkItem(runnable, z);
    }

    public final WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        h.b(runnable, "callback");
        WorkNode workNode = new WorkNode(this, runnable);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            k kVar = k.f6974a;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void validate() {
        int i;
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            if (this.runningJobs != null) {
                WorkNode workNode = this.runningJobs;
                i = 0;
                while (workNode != null) {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                    if (workNode == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            i = 0;
            Companion.m7assert(this.runningCount == i);
            k kVar = k.f6974a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void startItem() {
        finishItemAndStartNew(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2 = (WorkNode) null;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent && (workNode2 = this.pendingJobs) != null) {
            this.pendingJobs = workNode2.removeFromList(workNode2);
            this.runningJobs = workNode2.addToList(this.runningJobs, false);
            this.runningCount++;
            workNode2.setRunning(true);
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.WorkQueue$execute$1
            @Override // java.lang.Runnable
            public final void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    try {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            workNode.getCallback().run();
                        } finally {
                            WorkQueue.this.finishItemAndStartNew(workNode);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class WorkNode implements WorkItem {
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable runnable) {
            h.b(runnable, "callback");
            this.this$0 = workQueue;
            this.callback = runnable;
        }

        public final Runnable getCallback() {
            return this.callback;
        }

        public final WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        public void setRunning(boolean z) {
            this.isRunning = z;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            reentrantLock.lock();
            try {
                if (!isRunning()) {
                    this.this$0.pendingJobs = removeFromList(this.this$0.pendingJobs);
                    return true;
                }
                k kVar = k.f6974a;
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            reentrantLock.lock();
            try {
                if (!isRunning()) {
                    this.this$0.pendingJobs = removeFromList(this.this$0.pendingJobs);
                    this.this$0.pendingJobs = addToList(this.this$0.pendingJobs, true);
                }
                k kVar = k.f6974a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final WorkNode addToList(WorkNode workNode, boolean z) {
            WorkQueue.Companion.m7assert(this.next == null);
            WorkQueue.Companion.m7assert(this.prev == null);
            if (workNode == null) {
                this.prev = this;
                this.next = this.prev;
                workNode = this.next;
            } else {
                this.next = workNode;
                this.prev = workNode.prev;
                WorkNode workNode2 = this.prev;
                if (workNode2 != null) {
                    workNode2.next = this;
                }
                WorkNode workNode3 = this.next;
                if (workNode3 != null) {
                    WorkNode workNode4 = this.prev;
                    workNode3.prev = workNode4 != null ? workNode4.next : null;
                }
            }
            if (workNode != null) {
                return z ? this : workNode;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            WorkQueue.Companion.m7assert(this.next != null);
            WorkQueue.Companion.m7assert(this.prev != null);
            WorkNode workNode2 = this;
            if (workNode == workNode2 && (workNode = this.next) == workNode2) {
                workNode = null;
            }
            WorkNode workNode3 = this.next;
            if (workNode3 != null) {
                workNode3.prev = this.prev;
            }
            WorkNode workNode4 = this.prev;
            if (workNode4 != null) {
                workNode4.next = this.next;
            }
            this.prev = (WorkNode) null;
            this.next = this.prev;
            return workNode;
        }

        public final void verify(boolean z) {
            WorkNode workNode;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            WorkNode workNode4 = this;
            companion.m7assert(workNode == workNode4);
            Companion companion2 = WorkQueue.Companion;
            WorkNode workNode5 = this.next;
            if (workNode5 == null || (workNode2 = workNode5.prev) == null) {
                workNode2 = this;
            }
            companion2.m7assert(workNode2 == workNode4);
            WorkQueue.Companion.m7assert(isRunning() == z);
        }
    }
}
