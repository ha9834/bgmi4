package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfj;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzi {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private static final GmsLogger c = new GmsLogger("DriveEventService", "");

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    @GuardedBy("this")
    a f1539a;

    @GuardedBy("this")
    boolean b;
    private final String d;

    @GuardedBy("this")
    private CountDownLatch e;

    @VisibleForTesting
    private int f;

    /* loaded from: classes.dex */
    static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<DriveEventService> f1540a;

        private a(DriveEventService driveEventService) {
            this.f1540a = new WeakReference<>(driveEventService);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(DriveEventService driveEventService, com.google.android.gms.drive.events.a aVar) {
            this(driveEventService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message a() {
            return obtainMessage(2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message a(zzfj zzfjVar) {
            return obtainMessage(1, zzfjVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DriveEventService driveEventService = this.f1540a.get();
                    if (driveEventService != null) {
                        driveEventService.a((zzfj) message.obj);
                        return;
                    } else {
                        getLooper().quit();
                        return;
                    }
                case 2:
                    getLooper().quit();
                    return;
                default:
                    DriveEventService.c.wfmt("DriveEventService", "Unexpected message type: %s", Integer.valueOf(message.what));
                    return;
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    final class b extends zzet {
        private b() {
        }

        /* synthetic */ b(DriveEventService driveEventService, com.google.android.gms.drive.events.a aVar) {
            this();
        }

        @Override // com.google.android.gms.internal.drive.zzes
        public final void zzc(zzfj zzfjVar) throws RemoteException {
            synchronized (DriveEventService.this) {
                DriveEventService.this.c();
                if (DriveEventService.this.f1539a != null) {
                    DriveEventService.this.f1539a.sendMessage(DriveEventService.this.f1539a.a(zzfjVar));
                } else {
                    DriveEventService.c.e("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.b = false;
        this.f = -1;
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzfj zzfjVar) {
        DriveEvent zzak = zzfjVar.zzak();
        try {
            int type = zzak.getType();
            if (type == 4) {
                zza((zzb) zzak);
                return;
            }
            if (type == 7) {
                c.wfmt("DriveEventService", "Unhandled transfer state event in %s: %s", this.d, (zzv) zzak);
                return;
            }
            switch (type) {
                case 1:
                    onChange((ChangeEvent) zzak);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzak);
                    return;
                default:
                    c.wfmt("DriveEventService", "Unhandled event: %s", zzak);
                    return;
            }
        } catch (Exception e) {
            c.e("DriveEventService", String.format("Error handling event in %s", this.d), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() throws SecurityException {
        int a2 = a();
        if (a2 == this.f) {
            return;
        }
        if (!UidVerifier.isGooglePlayServicesUid(this, a2)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.f = a2;
    }

    @VisibleForTesting
    protected int a() {
        return Binder.getCallingUid();
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        com.google.android.gms.drive.events.a aVar = null;
        if (!ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            return null;
        }
        if (this.f1539a == null && !this.b) {
            this.b = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.e = new CountDownLatch(1);
            new com.google.android.gms.drive.events.a(this, countDownLatch).start();
            try {
                if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                    c.e("DriveEventService", "Failed to synchronously initialize event handler.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to start event handler", e);
            }
        }
        return new b(this, aVar).asBinder();
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public void onChange(ChangeEvent changeEvent) {
        c.wfmt("DriveEventService", "Unhandled change event in %s: %s", this.d, changeEvent);
    }

    @Override // com.google.android.gms.drive.events.CompletionListener
    public void onCompletion(CompletionEvent completionEvent) {
        c.wfmt("DriveEventService", "Unhandled completion event in %s: %s", this.d, completionEvent);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        if (this.f1539a != null) {
            this.f1539a.sendMessage(this.f1539a.a());
            this.f1539a = null;
            try {
                if (!this.e.await(5000L, TimeUnit.MILLISECONDS)) {
                    c.w("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException unused) {
            }
            this.e = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override // com.google.android.gms.drive.events.zzd
    public final void zza(zzb zzbVar) {
        c.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", this.d, zzbVar);
    }
}
