package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final Feature[] f1325a;
    private final boolean b;

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f1325a = null;
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* renamed from: a, reason: collision with root package name */
        private RemoteCall<A, TaskCompletionSource<ResultT>> f1326a;
        private boolean b;
        private Feature[] c;

        private Builder() {
            this.b = true;
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, ResultT> execute(final BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.f1326a = new RemoteCall(biConsumer) { // from class: com.google.android.gms.common.api.internal.an

                /* renamed from: a, reason: collision with root package name */
                private final BiConsumer f1340a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1340a = biConsumer;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    this.f1340a.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f1326a = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.c = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.b = z;
            return this;
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            Preconditions.checkArgument(this.f1326a != null, "execute parameter required");
            return new ao(this, this.c, this.b);
        }
    }

    @KeepForSdk
    private TaskApiCall(Feature[] featureArr, boolean z) {
        this.f1325a = featureArr;
        this.b = z;
    }

    public final Feature[] zabt() {
        return this.f1325a;
    }

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.b;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>();
    }
}
