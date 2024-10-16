package com.uqm.crashsight.proguard;

import android.content.Context;
import android.os.Process;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static i f6616a;
    private final Context c;
    private long e;
    private long f;
    private Map<Integer, Long> d = new HashMap();
    private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private final Object i = new Object();
    private int j = 0;
    private final d b = d.a();

    static /* synthetic */ int b(i iVar) {
        int i = iVar.j - 1;
        iVar.j = i;
        return i;
    }

    private i(Context context) {
        this.c = context;
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f6616a == null) {
                f6616a = new i(context);
            }
            iVar = f6616a;
        }
        return iVar;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            iVar = f6616a;
        }
        return iVar;
    }

    public final void a(int i, SightPkg.RequestPkg requestPkg, String str, String str2, h hVar, long j, boolean z) {
        try {
            try {
                a(new j(this.c, i, requestPkg.getCmd(), CrashSightStrategy.a.encode2SendDatas(requestPkg), str, str2, hVar, true, z), true, true, j);
            } catch (Throwable th) {
                th = th;
                if (m.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void a(int i, SightPkg.RequestPkg requestPkg, String str, String str2, h hVar, boolean z) {
        try {
            try {
                a(new j(this.c, i, requestPkg.getCmd(), CrashSightStrategy.a.encode2SendDatas(requestPkg), str, str2, hVar, 0, 0, false, null), z, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (m.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final long a(boolean z) {
        long j;
        long b = q.b();
        int i = z ? 5 : 3;
        List<f> a2 = this.b.a(i);
        if (a2 != null && a2.size() > 0) {
            j = 0;
            try {
                f fVar = a2.get(0);
                if (fVar.e >= b) {
                    j = q.b(fVar.g);
                    if (i == 3) {
                        this.e = j;
                    } else {
                        this.f = j;
                    }
                    a2.remove(fVar);
                }
            } catch (Throwable th) {
                m.a(th);
            }
            if (a2.size() > 0) {
                this.b.a(a2);
            }
        } else {
            j = z ? this.f : this.e;
        }
        m.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(long j, boolean z) {
        int i = z ? 5 : 3;
        f fVar = new f();
        fVar.b = i;
        fVar.e = q.b();
        fVar.c = "";
        fVar.d = "";
        fVar.g = q.c(j);
        this.b.b(i);
        this.b.a(fVar);
        if (z) {
            this.f = j;
        } else {
            this.e = j;
        }
        m.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public final synchronized void a(int i, long j) {
        if (i >= 0) {
            this.d.put(Integer.valueOf(i), Long.valueOf(j));
            f fVar = new f();
            fVar.b = i;
            fVar.e = j;
            fVar.c = "";
            fVar.d = "";
            fVar.g = new byte[0];
            this.b.b(i);
            this.b.a(fVar);
            m.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), q.a(j));
            return;
        }
        m.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized long a(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = this.d.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<f> a2 = this.b.a(i);
            if (a2 != null && a2.size() > 0) {
                if (a2.size() > 1) {
                    for (f fVar : a2) {
                        if (fVar.e > j) {
                            j = fVar.e;
                        }
                    }
                    this.b.b(i);
                } else {
                    try {
                        j = a2.get(0).e;
                    } catch (Throwable th) {
                        m.a(th);
                    }
                }
            }
        } else {
            m.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    public final boolean b(int i) {
        if (com.uqm.crashsight.b.c) {
            m.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i);
        m.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        m.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void c(int i) {
        k a2 = k.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.i) {
            m.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.g.size();
            final int size2 = this.h.size();
            if (size == 0 && size2 == 0) {
                m.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a2 == null || !a2.c()) {
                size2 = 0;
            }
            for (int i2 = 0; i2 < size; i2++) {
                Runnable peek = this.g.peek();
                if (peek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(peek);
                    this.g.poll();
                } catch (Throwable th) {
                    m.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
            }
            for (int i3 = 0; i3 < size2; i3++) {
                Runnable peek2 = this.h.peek();
                if (peek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(peek2);
                    this.h.poll();
                } catch (Throwable th2) {
                    m.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
            if (size > 0) {
                m.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            for (int i4 = 0; i4 < size; i4++) {
                final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.i) {
                    if (this.j >= 2 && a2 != null) {
                        a2.a(runnable);
                    } else {
                        m.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "CS_ASYNC_UPLOAD");
                        if (q.a(new Runnable() { // from class: com.uqm.crashsight.proguard.i.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                                synchronized (i.this.i) {
                                    i.b(i.this);
                                }
                            }
                        }, "CS_ASYNC_UPLOAD") != null) {
                            synchronized (this.i) {
                                this.j++;
                            }
                        } else {
                            m.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                            a(runnable, true);
                        }
                    }
                }
            }
            if (size2 > 0) {
                m.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            if (a2 != null) {
                a2.a(new Runnable(this) { // from class: com.uqm.crashsight.proguard.i.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable2;
                        for (int i5 = 0; i5 < size2 && (runnable2 = (Runnable) linkedBlockingQueue2.poll()) != null; i5++) {
                            runnable2.run();
                        }
                    }
                });
            }
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            m.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            m.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.i) {
                if (z) {
                    this.g.put(runnable);
                } else {
                    this.h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            m.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            m.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        m.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
            return;
        }
        if (runnable == null) {
            m.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        m.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = q.a(runnable, "CS_SYNC_UPLOAD");
        if (a2 == null) {
            m.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j);
        } catch (Throwable th) {
            m.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }
}
