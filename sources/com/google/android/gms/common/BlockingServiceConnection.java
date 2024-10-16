package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1275a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    @KeepForSdk
    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f1275a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f1275a = true;
        IBinder poll = this.b.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @KeepForSdk
    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.f1275a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f1275a = true;
        return this.b.take();
    }
}
