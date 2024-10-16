package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.core.IServiceCallback;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ServiceCallbackHelper<ICallback extends IServiceCallback> {
    protected ReferenceQueue<ICallback> mCallbackReferenceQueue = new ReferenceQueue<>();
    protected ArrayList<WeakReference<ICallback>> mWeakCallbackArrayList = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface Caller<T> {
        void call(T t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void register(ICallback icallback) {
        if (icallback == null) {
            return;
        }
        synchronized (this.mWeakCallbackArrayList) {
            while (true) {
                Reference<? extends ICallback> poll = this.mCallbackReferenceQueue.poll();
                if (poll != null) {
                    this.mWeakCallbackArrayList.remove(poll);
                } else {
                    try {
                        break;
                    } catch (ConcurrentModificationException unused) {
                    }
                }
            }
            Iterator<WeakReference<ICallback>> it = this.mWeakCallbackArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().get() == icallback) {
                    return;
                }
            }
            this.mWeakCallbackArrayList.add(new WeakReference<>(icallback, this.mCallbackReferenceQueue));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregister(ICallback icallback) {
        if (icallback == null) {
            return;
        }
        synchronized (this.mWeakCallbackArrayList) {
            try {
                try {
                    Iterator<WeakReference<ICallback>> it = this.mWeakCallbackArrayList.iterator();
                    while (it.hasNext()) {
                        WeakReference<ICallback> next = it.next();
                        if (next.get() == icallback) {
                            this.mWeakCallbackArrayList.remove(next);
                            return;
                        }
                    }
                } catch (ConcurrentModificationException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterAll() {
        synchronized (this.mWeakCallbackArrayList) {
            this.mWeakCallbackArrayList.clear();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void broadcast(CallbackHelper.Caller<ICallback> caller) {
        synchronized (this.mWeakCallbackArrayList) {
            try {
                Iterator<WeakReference<ICallback>> it = this.mWeakCallbackArrayList.iterator();
                while (it.hasNext()) {
                    ICallback icallback = it.next().get();
                    if (icallback != null && caller != null) {
                        try {
                            caller.call(icallback);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            } catch (ConcurrentModificationException unused) {
            }
        }
    }
}
