package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.e.f;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class a<D> extends b<D> {

    /* renamed from: a, reason: collision with root package name */
    volatile a<D>.RunnableC0062a f809a;
    volatile a<D>.RunnableC0062a b;
    long c;
    long d;
    Handler e;
    private final Executor o;

    public void cancelLoadInBackground() {
    }

    public abstract D loadInBackground();

    public void onCanceled(D d) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.loader.content.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0062a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f810a;
        private final CountDownLatch f = new CountDownLatch(1);

        RunnableC0062a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        public D a(Void... voidArr) {
            try {
                return (D) a.this.d();
            } catch (OperationCanceledException e) {
                if (d()) {
                    return null;
                }
                throw e;
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void a(D d) {
            try {
                a.this.b(this, d);
            } finally {
                this.f.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void b(D d) {
            try {
                a.this.a(this, d);
            } finally {
                this.f.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f810a = false;
            a.this.c();
        }

        public void a() {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.d = -10000L;
        this.o = executor;
    }

    public void setUpdateThrottle(long j) {
        this.c = j;
        if (j != 0) {
            this.e = new Handler();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.b
    public void a() {
        super.a();
        cancelLoad();
        this.f809a = new RunnableC0062a();
        c();
    }

    @Override // androidx.loader.content.b
    protected boolean b() {
        if (this.f809a == null) {
            return false;
        }
        if (!this.j) {
            this.m = true;
        }
        if (this.b != null) {
            if (this.f809a.f810a) {
                this.f809a.f810a = false;
                this.e.removeCallbacks(this.f809a);
            }
            this.f809a = null;
            return false;
        }
        if (this.f809a.f810a) {
            this.f809a.f810a = false;
            this.e.removeCallbacks(this.f809a);
            this.f809a = null;
            return false;
        }
        boolean a2 = this.f809a.a(false);
        if (a2) {
            this.b = this.f809a;
            cancelLoadInBackground();
        }
        this.f809a = null;
        return a2;
    }

    void c() {
        if (this.b != null || this.f809a == null) {
            return;
        }
        if (this.f809a.f810a) {
            this.f809a.f810a = false;
            this.e.removeCallbacks(this.f809a);
        }
        if (this.c > 0 && SystemClock.uptimeMillis() < this.d + this.c) {
            this.f809a.f810a = true;
            this.e.postAtTime(this.f809a, this.d + this.c);
        } else {
            this.f809a.a(this.o, (Void[]) null);
        }
    }

    void a(a<D>.RunnableC0062a runnableC0062a, D d) {
        onCanceled(d);
        if (this.b == runnableC0062a) {
            rollbackContentChanged();
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            deliverCancellation();
            c();
        }
    }

    void b(a<D>.RunnableC0062a runnableC0062a, D d) {
        if (this.f809a != runnableC0062a) {
            a(runnableC0062a, d);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d);
            return;
        }
        commitContentChanged();
        this.d = SystemClock.uptimeMillis();
        this.f809a = null;
        deliverResult(d);
    }

    protected D d() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.b != null;
    }

    public void waitForLoader() {
        a<D>.RunnableC0062a runnableC0062a = this.f809a;
        if (runnableC0062a != null) {
            runnableC0062a.a();
        }
    }

    @Override // androidx.loader.content.b
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f809a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f809a);
            printWriter.print(" waiting=");
            printWriter.println(this.f809a.f810a);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.b);
            printWriter.print(" waiting=");
            printWriter.println(this.b.f810a);
        }
        if (this.c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            f.a(this.c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            f.a(this.d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
