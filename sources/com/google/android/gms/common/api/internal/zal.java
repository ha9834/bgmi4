package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference<aw> c;
    protected final GoogleApiAvailability d;
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: protected */
    public zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i);

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.c = new AtomicReference<>(null);
        this.e = new zap(Looper.getMainLooper());
        this.d = googleApiAvailability;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), a(this.c.get()));
        c();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new aw(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        aw awVar = this.c.get();
        if (awVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", awVar.a());
            bundle.putInt("failed_status", awVar.b().getErrorCode());
            bundle.putParcelable("failed_resolution", awVar.b().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.b = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.aw> r0 = r3.c
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.internal.aw r0 = (com.google.android.gms.common.api.internal.aw) r0
            r1 = 1
            r2 = 0
            switch(r4) {
                case 1: goto L2e;
                case 2: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L55
        Le:
            com.google.android.gms.common.GoogleApiAvailability r4 = r3.d
            android.app.Activity r5 = r3.getActivity()
            int r4 = r4.isGooglePlayServicesAvailable(r5)
            if (r4 != 0) goto L1b
            goto L1c
        L1b:
            r1 = 0
        L1c:
            if (r0 != 0) goto L1f
            return
        L1f:
            com.google.android.gms.common.ConnectionResult r5 = r0.b()
            int r5 = r5.getErrorCode()
            r6 = 18
            if (r5 != r6) goto L56
            if (r4 != r6) goto L56
            return
        L2e:
            r4 = -1
            if (r5 != r4) goto L32
            goto L56
        L32:
            if (r5 != 0) goto L55
            r4 = 13
            if (r6 == 0) goto L3e
            java.lang.String r5 = "<<ResolutionFailureErrorDetail>>"
            int r4 = r6.getIntExtra(r5, r4)
        L3e:
            com.google.android.gms.common.api.internal.aw r5 = new com.google.android.gms.common.api.internal.aw
            com.google.android.gms.common.ConnectionResult r6 = new com.google.android.gms.common.ConnectionResult
            r1 = 0
            r6.<init>(r4, r1)
            int r4 = a(r0)
            r5.<init>(r6, r4)
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.aw> r4 = r3.c
            r4.set(r5)
            r0 = r5
            r1 = 0
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5c
            r3.c()
            return
        L5c:
            if (r0 == 0) goto L69
            com.google.android.gms.common.ConnectionResult r4 = r0.b()
            int r5 = r0.a()
            r3.a(r4, r5)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zal.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.c.set(null);
        a();
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        aw awVar = new aw(connectionResult, i);
        if (this.c.compareAndSet(null, awVar)) {
            this.e.post(new ax(this, awVar));
        }
    }

    private static int a(aw awVar) {
        if (awVar == null) {
            return -1;
        }
        return awVar.a();
    }
}
