package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

/* loaded from: classes2.dex */
final class bu extends zzl {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerToken f3912a;
    private final ListenerHolder<OpenFileCallback> b;
    private final /* synthetic */ zzch c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(zzch zzchVar, ListenerToken listenerToken, ListenerHolder<OpenFileCallback> listenerHolder) {
        this.c = zzchVar;
        this.f3912a = listenerToken;
        this.b = listenerHolder;
    }

    private final void a(bq<OpenFileCallback> bqVar) {
        this.b.notifyListener(new by(this, bqVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Status status, OpenFileCallback openFileCallback) {
        openFileCallback.onError(ApiExceptionUtil.fromStatus(status));
        this.c.cancelOpenFileCallback(this.f3912a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzfb zzfbVar, OpenFileCallback openFileCallback) {
        openFileCallback.onContents(new zzbi(zzfbVar.f3965a));
        this.c.cancelOpenFileCallback(this.f3912a);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final Status status) throws RemoteException {
        a(new bq(this, status) { // from class: com.google.android.gms.internal.drive.bv

            /* renamed from: a, reason: collision with root package name */
            private final bu f3913a;
            private final Status b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3913a = this;
                this.b = status;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                this.f3913a.a(this.b, (OpenFileCallback) obj);
            }
        });
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final zzfb zzfbVar) throws RemoteException {
        a(new bq(this, zzfbVar) { // from class: com.google.android.gms.internal.drive.bx

            /* renamed from: a, reason: collision with root package name */
            private final bu f3915a;
            private final zzfb b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3915a = this;
                this.b = zzfbVar;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                this.f3915a.a(this.b, (OpenFileCallback) obj);
            }
        });
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final zzff zzffVar) throws RemoteException {
        a(new bq(zzffVar) { // from class: com.google.android.gms.internal.drive.bw

            /* renamed from: a, reason: collision with root package name */
            private final zzff f3914a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3914a = zzffVar;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                zzff zzffVar2 = this.f3914a;
                ((OpenFileCallback) obj).onProgress(zzffVar2.f3967a, zzffVar2.b);
            }
        });
    }
}
