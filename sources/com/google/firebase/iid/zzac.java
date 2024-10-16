package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzac implements ServiceConnection {

    @GuardedBy("this")
    int state;
    final Messenger zzce;
    zzaj zzcf;

    @GuardedBy("this")
    final Queue<zzal<?>> zzcg;

    @GuardedBy("this")
    final SparseArray<zzal<?>> zzch;
    final /* synthetic */ zzab zzci;

    private zzac(zzab zzabVar) {
        this.zzci = zzabVar;
        this.state = 0;
        this.zzce = new Messenger(new com.google.android.gms.internal.firebase_messaging.zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.zzaf
            private final zzac zzcj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcj = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.zzcj.zza(message);
            }
        }));
        this.zzcg = new ArrayDeque();
        this.zzch = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzb(zzal zzalVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        switch (this.state) {
            case 0:
                this.zzcg.add(zzalVar);
                Preconditions.checkState(this.state == 0);
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                }
                this.state = 1;
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.zzci.zzag;
                if (!connectionTracker.bindService(context, intent, this, 1)) {
                    zza(0, "Unable to bind to service");
                } else {
                    scheduledExecutorService = this.zzci.zzcb;
                    scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.zzae
                        private final zzac zzcj;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzcj = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzcj.zzaa();
                        }
                    }, 30L, TimeUnit.SECONDS);
                }
                return true;
            case 1:
                this.zzcg.add(zzalVar);
                return true;
            case 2:
                this.zzcg.add(zzalVar);
                zzy();
                return true;
            case 3:
            case 4:
                return false;
            default:
                int i = this.state;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            zzal<?> zzalVar = this.zzch.get(i);
            if (zzalVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.zzch.remove(i);
            zzz();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                zzalVar.zza(new zzak(4, "Not supported by GmsCore"));
            } else {
                zzalVar.zzb(data);
            }
            return true;
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zza(0, "Null service connection");
            return;
        }
        try {
            this.zzcf = new zzaj(iBinder);
            this.state = 2;
            zzy();
        } catch (RemoteException e) {
            zza(0, e.getMessage());
        }
    }

    private final void zzy() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.zzci.zzcb;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzah
            private final zzac zzcj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcj = this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzal<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                zzac zzacVar = this.zzcj;
                while (true) {
                    synchronized (zzacVar) {
                        if (zzacVar.state != 2) {
                            return;
                        }
                        if (zzacVar.zzcg.isEmpty()) {
                            zzacVar.zzz();
                            return;
                        }
                        poll = zzacVar.zzcg.poll();
                        zzacVar.zzch.put(poll.zzcm, poll);
                        scheduledExecutorService2 = zzacVar.zzci.zzcb;
                        scheduledExecutorService2.schedule(new Runnable(zzacVar, poll) { // from class: com.google.firebase.iid.zzag
                            private final zzac zzcj;
                            private final zzal zzck;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzcj = zzacVar;
                                this.zzck = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzcj.zza(this.zzck.zzcm);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = zzacVar.zzci.zzag;
                    Messenger messenger = zzacVar.zzce;
                    Message obtain = Message.obtain();
                    obtain.what = poll.what;
                    obtain.arg1 = poll.zzcm;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.zzab());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.zzco);
                    obtain.setData(bundle);
                    try {
                        zzacVar.zzcf.send(obtain);
                    } catch (RemoteException e) {
                        zzacVar.zza(2, e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zza(2, "Service disconnected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zza(int i, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.state) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.state = 4;
                ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                context = this.zzci.zzag;
                connectionTracker.unbindService(context, this);
                zzak zzakVar = new zzak(i, str);
                Iterator<zzal<?>> it = this.zzcg.iterator();
                while (it.hasNext()) {
                    it.next().zza(zzakVar);
                }
                this.zzcg.clear();
                for (int i2 = 0; i2 < this.zzch.size(); i2++) {
                    this.zzch.valueAt(i2).zza(zzakVar);
                }
                this.zzch.clear();
                return;
            case 3:
                this.state = 4;
                return;
            case 4:
                return;
            default:
                int i3 = this.state;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzz() {
        Context context;
        if (this.state == 2 && this.zzcg.isEmpty() && this.zzch.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.zzci.zzag;
            connectionTracker.unbindService(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzaa() {
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzal<?> zzalVar = this.zzch.get(i);
        if (zzalVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.zzch.remove(i);
            zzalVar.zza(new zzak(3, "Timed out waiting for response"));
            zzz();
        }
    }
}
