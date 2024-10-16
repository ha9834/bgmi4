package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> c = new az();

    /* renamed from: a, reason: collision with root package name */
    private final Object f1306a;
    private final CallbackHandler<R> b;
    private final WeakReference<GoogleApiClient> d;
    private final CountDownLatch e;
    private final ArrayList<PendingResult.StatusListener> f;
    private ResultCallback<? super R> g;
    private final AtomicReference<au> h;
    private R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;

    @KeepName
    private a mResultGuardian;
    private ICancelToken n;
    private volatile zacm<R> o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a {
        private a() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.zab(BasePendingResult.this.i);
            super.finalize();
        }

        /* synthetic */ a(BasePendingResult basePendingResult, az azVar) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f1306a = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.b = new CallbackHandler<>(Looper.getMainLooper());
        this.d = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract R createFailedResult(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zam() {
        return null;
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public final void zaa(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.zab(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zab(Status.RESULT_TIMEOUT);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.f1306a = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.b = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.d = new WeakReference<>(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    @Deprecated
    public BasePendingResult(Looper looper) {
        this.f1306a = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList<>();
        this.h = new AtomicReference<>();
        this.p = false;
        this.b = new CallbackHandler<>(looper);
        this.d = new WeakReference<>(null);
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.e.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        Preconditions.checkState(!this.k, "Result has already been consumed");
        Preconditions.checkState(this.o == null, "Cannot await if then() has been called.");
        try {
            this.e.await();
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.checkState(!this.k, "Result has already been consumed.");
        Preconditions.checkState(this.o == null, "Cannot await if then() has been called.");
        try {
            if (!this.e.await(j, timeUnit)) {
                zab(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.f1306a) {
            if (resultCallback == null) {
                this.g = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            if (this.o != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.b.zaa(resultCallback, a());
            } else {
                this.g = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.f1306a) {
            if (resultCallback == null) {
                this.g = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            if (this.o != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.b.zaa(resultCallback, a());
            } else {
                this.g = resultCallback;
                CallbackHandler<R> callbackHandler = this.b;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.f1306a) {
            if (isReady()) {
                statusListener.onComplete(this.j);
            } else {
                this.f.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.f1306a) {
            if (!this.l && !this.k) {
                if (this.n != null) {
                    try {
                        this.n.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zab(this.i);
                this.l = true;
                a((BasePendingResult<R>) createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    public final boolean zat() {
        boolean isCanceled;
        synchronized (this.f1306a) {
            if (this.d.get() == null || !this.p) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.f1306a) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        Preconditions.checkState(!this.k, "Result has already been consumed.");
        synchronized (this.f1306a) {
            Preconditions.checkState(this.o == null, "Cannot call then() twice.");
            Preconditions.checkState(this.g == null, "Cannot call then() if callbacks are set.");
            Preconditions.checkState(this.l ? false : true, "Cannot call then() if result was canceled.");
            this.p = true;
            this.o = new zacm<>(this.d);
            then = this.o.then(resultTransform);
            if (isReady()) {
                this.b.zaa(this.o, a());
            } else {
                this.g = this.o;
            }
        }
        return then;
    }

    @KeepForSdk
    public final void setResult(R r) {
        synchronized (this.f1306a) {
            if (this.m || this.l) {
                zab(r);
                return;
            }
            isReady();
            boolean z = true;
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.k) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            a((BasePendingResult<R>) r);
        }
    }

    public final void zab(Status status) {
        synchronized (this.f1306a) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.m = true;
            }
        }
    }

    public final void zaa(au auVar) {
        this.h.set(auVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final void a(ICancelToken iCancelToken) {
        synchronized (this.f1306a) {
            this.n = iCancelToken;
        }
    }

    public final void zau() {
        this.p = this.p || c.get().booleanValue();
    }

    private final R a() {
        R r;
        synchronized (this.f1306a) {
            Preconditions.checkState(!this.k, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.i;
            this.i = null;
            this.g = null;
            this.k = true;
        }
        au andSet = this.h.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void a(R r) {
        this.i = r;
        az azVar = null;
        this.n = null;
        this.e.countDown();
        this.j = this.i.getStatus();
        if (this.l) {
            this.g = null;
        } else if (this.g == null) {
            if (this.i instanceof Releasable) {
                this.mResultGuardian = new a(this, azVar);
            }
        } else {
            this.b.removeMessages(2);
            this.b.zaa(this.g, a());
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.j);
        }
        this.f.clear();
    }

    public static void zab(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }
}
