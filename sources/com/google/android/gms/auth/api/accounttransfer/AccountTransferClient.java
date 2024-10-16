package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzah;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.internal.auth.zzz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class AccountTransferClient extends GoogleApi<zzn> {
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> b = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> c = new com.google.android.gms.auth.api.accounttransfer.b();
    private static final Api<zzn> d = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", c, b);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b<T> extends TaskApiCall<com.google.android.gms.internal.auth.zzu, T> {

        /* renamed from: a, reason: collision with root package name */
        private TaskCompletionSource<T> f1224a;

        private b() {
        }

        protected abstract void a(zzz zzzVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(T t) {
            this.f1224a.setResult(t);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(Status status) {
            AccountTransferClient.b(this.f1224a, status);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.TaskApiCall
        public /* synthetic */ void a(com.google.android.gms.internal.auth.zzu zzuVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
            this.f1224a = taskCompletionSource;
            a((zzz) zzuVar.getService());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(com.google.android.gms.auth.api.accounttransfer.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(Context context) {
        super(context, d, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c extends b<Void> {

        /* renamed from: a, reason: collision with root package name */
        zzy f1225a;

        private c() {
            super(null);
            this.f1225a = new j(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(com.google.android.gms.auth.api.accounttransfer.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> extends com.google.android.gms.internal.auth.zzs {

        /* renamed from: a, reason: collision with root package name */
        private b<T> f1223a;

        public a(b<T> bVar) {
            this.f1223a = bVar;
        }

        @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
        public final void onFailure(Status status) {
            this.f1223a.a(status);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(Activity activity) {
        super(activity, (Api<Api.ApiOptions>) d, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        return doWrite(new com.google.android.gms.auth.api.accounttransfer.c(this, new zzaf(str, bArr)));
    }

    public Task<byte[]> retrieveData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new d(this, new zzad(str)));
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new f(this, new com.google.android.gms.internal.auth.zzv(str)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new h(this, new zzah(str, pendingIntent)));
    }

    public Task<Void> notifyCompletion(String str, int i) {
        Preconditions.checkNotNull(str);
        return doWrite(new i(this, new zzab(str, i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TaskCompletionSource taskCompletionSource, Status status) {
        taskCompletionSource.setException(new AccountTransferException(status));
    }
}
