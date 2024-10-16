package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* loaded from: classes2.dex */
final class aob implements Handler.Callback, Choreographer.FrameCallback {
    private static final aob b = new aob();

    /* renamed from: a, reason: collision with root package name */
    public volatile long f1998a;
    private final Handler c;
    private final HandlerThread d = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer e;
    private int f;

    public static aob a() {
        return b;
    }

    private aob() {
        this.d.start();
        this.c = new Handler(this.d.getLooper(), this);
        this.c.sendEmptyMessage(0);
    }

    public final void b() {
        this.c.sendEmptyMessage(1);
    }

    public final void c() {
        this.c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f1998a = j;
        this.e.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.e = Choreographer.getInstance();
                return true;
            case 1:
                this.f++;
                if (this.f == 1) {
                    this.e.postFrameCallback(this);
                }
                return true;
            case 2:
                this.f--;
                if (this.f == 0) {
                    this.e.removeFrameCallback(this);
                    this.f1998a = 0L;
                }
                return true;
            default:
                return false;
        }
    }
}
