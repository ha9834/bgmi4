package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

@KeepForSdk
/* loaded from: classes.dex */
public final class ListenerHolder<L> {

    /* renamed from: a, reason: collision with root package name */
    private final a f1317a;
    private volatile L b;
    private final ListenerKey<L> c;

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public ListenerHolder(Looper looper, L l, String str) {
        this.f1317a = new a(looper);
        this.b = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.c = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    /* loaded from: classes.dex */
    private final class a extends zap {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Preconditions.checkArgument(message.what == 1);
            ListenerHolder.this.a((Notifier) message.obj);
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ListenerKey<L> {

        /* renamed from: a, reason: collision with root package name */
        private final L f1318a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @KeepForSdk
        public ListenerKey(L l, String str) {
            this.f1318a = l;
            this.b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.f1318a == listenerKey.f1318a && this.b.equals(listenerKey.b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1318a) * 31) + this.b.hashCode();
        }
    }

    @KeepForSdk
    public final void notifyListener(Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.f1317a.sendMessage(this.f1317a.obtainMessage(1, notifier));
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.b != null;
    }

    @KeepForSdk
    public final void clear() {
        this.b = null;
    }

    @KeepForSdk
    public final ListenerKey<L> getListenerKey() {
        return this.c;
    }

    @KeepForSdk
    final void a(Notifier<? super L> notifier) {
        L l = this.b;
        if (l == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(l);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }
}
