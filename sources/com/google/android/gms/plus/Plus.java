package com.google.android.gms.plus;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.plus.zze;
import com.google.android.gms.internal.plus.zzi;
import com.google.android.gms.internal.plus.zzj;
import com.google.android.gms.plus.internal.zzh;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes2.dex */
public final class Plus {
    public static final Api.ClientKey<zzh> CLIENT_KEY = new Api.ClientKey<>();

    /* renamed from: a, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzh, PlusOptions> f5036a = new a();

    @Deprecated
    public static final Api<PlusOptions> API = new Api<>("Plus.API", f5036a, CLIENT_KEY);

    @Deprecated
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);

    @Deprecated
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);

    @Deprecated
    public static final People PeopleApi = new zzj();

    @Deprecated
    public static final Account AccountApi = new zze();

    @Deprecated
    private static final zzb b = new zzi();
    private static final com.google.android.gms.plus.zza c = new com.google.android.gms.internal.plus.zzh();

    @Deprecated
    /* loaded from: classes2.dex */
    public static final class PlusOptions implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        final Set<String> f5037a;
        private final String b;

        @Deprecated
        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            String f5038a;
            final Set<String> b = new HashSet();

            @VisibleForTesting
            @Deprecated
            public final Builder addActivityTypes(String... strArr) {
                Preconditions.checkNotNull(strArr, "activityTypes may not be null.");
                for (String str : strArr) {
                    this.b.add(str);
                }
                return this;
            }

            @VisibleForTesting
            @Deprecated
            public final PlusOptions build() {
                return new PlusOptions(this, null);
            }

            @Deprecated
            public final Builder setServerClientId(String str) {
                this.f5038a = str;
                return this;
            }
        }

        private PlusOptions() {
            this.b = null;
            this.f5037a = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.b = builder.f5038a;
            this.f5037a = builder.b;
        }

        /* synthetic */ PlusOptions(Builder builder, a aVar) {
            this(builder);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ PlusOptions(a aVar) {
            this();
        }

        @VisibleForTesting
        @Deprecated
        public static Builder builder() {
            return new Builder();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzh> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.CLIENT_KEY, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zzh zza(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        Preconditions.checkState(googleApiClient.hasApi(API), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (hasConnectedApi) {
            return (zzh) googleApiClient.getClient(CLIENT_KEY);
        }
        return null;
    }
}
