package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {
    public final RegisterListenerMethod<A, L> zajz;
    public final UnregisterListenerMethod<A, L> zaka;

    private RegistrationMethods(RegisterListenerMethod<A, L> registerListenerMethod, UnregisterListenerMethod<A, L> unregisterListenerMethod) {
        this.zajz = registerListenerMethod;
        this.zaka = unregisterListenerMethod;
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, L> {

        /* renamed from: a, reason: collision with root package name */
        private RemoteCall<A, TaskCompletionSource<Void>> f1323a;
        private RemoteCall<A, TaskCompletionSource<Boolean>> b;
        private ListenerHolder<L> c;
        private Feature[] d;
        private boolean e;

        private Builder() {
            this.e = true;
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, L> register(final BiConsumer<A, TaskCompletionSource<Void>> biConsumer) {
            this.f1323a = new RemoteCall(biConsumer) { // from class: com.google.android.gms.common.api.internal.ag

                /* renamed from: a, reason: collision with root package name */
                private final BiConsumer f1334a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1334a = biConsumer;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    this.f1334a.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> biConsumer) {
            this.f1323a = new RemoteCall(this) { // from class: com.google.android.gms.common.api.internal.ah

                /* renamed from: a, reason: collision with root package name */
                private final RegistrationMethods.Builder f1335a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1335a = this;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    this.f1335a.a((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @KeepForSdk
        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.f1323a = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.b = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.c = listenerHolder;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setFeatures(Feature[] featureArr) {
            this.d = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z) {
            this.e = z;
            return this;
        }

        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            Preconditions.checkArgument(this.f1323a != null, "Must set register function");
            Preconditions.checkArgument(this.b != null, "Must set unregister function");
            Preconditions.checkArgument(this.c != null, "Must set holder");
            return new RegistrationMethods<>(new ai(this, this.c, this.d, this.e), new aj(this, this.c.getListenerKey()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
            this.f1323a.accept(anyClient, taskCompletionSource);
        }
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>();
    }
}
