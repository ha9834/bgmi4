package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";

    /* renamed from: a, reason: collision with root package name */
    private final Account f1445a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<Api<?>, OptionalApiSettings> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final SignInOptions i;
    private final boolean j;
    private Integer k;

    /* loaded from: classes.dex */
    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
        }
    }

    @KeepForSdk
    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    @KeepForSdk
    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Account f1446a;
        private androidx.b.b<Scope> b;
        private Map<Api<?>, OptionalApiSettings> c;
        private View e;
        private String f;
        private String g;
        private boolean i;
        private int d = 0;
        private SignInOptions h = SignInOptions.DEFAULT;

        public final Builder setAccount(Account account) {
            this.f1446a = account;
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            if (this.b == null) {
                this.b = new androidx.b.b<>();
            }
            this.b.add(scope);
            return this;
        }

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            if (this.b == null) {
                this.b = new androidx.b.b<>();
            }
            this.b.addAll(collection);
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.c = map;
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.d = i;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.e = view;
            return this;
        }

        @KeepForSdk
        public final Builder setRealClientPackageName(String str) {
            this.f = str;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.g = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.h = signInOptions;
            return this;
        }

        public final Builder enableSignInClientDisconnectFix() {
            this.i = true;
            return this;
        }

        @KeepForSdk
        public final ClientSettings build() {
            return new ClientSettings(this.f1446a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.f1445a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.d = map == null ? Collections.EMPTY_MAP : map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = signInOptions;
        this.j = z;
        HashSet hashSet = new HashSet(this.b);
        Iterator<OptionalApiSettings> it = this.d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().mScopes);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    @Nullable
    @Deprecated
    public final String getAccountName() {
        Account account = this.f1445a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    @Nullable
    public final Account getAccount() {
        return this.f1445a;
    }

    @KeepForSdk
    public final Account getAccountOrDefault() {
        Account account = this.f1445a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    @KeepForSdk
    public final int getGravityForPopups() {
        return this.e;
    }

    @KeepForSdk
    public final Set<Scope> getRequiredScopes() {
        return this.b;
    }

    @KeepForSdk
    public final Set<Scope> getAllRequestedScopes() {
        return this.c;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.d;
    }

    @KeepForSdk
    @Nullable
    public final String getRealClientPackageName() {
        return this.g;
    }

    @Nullable
    public final String getRealClientClassName() {
        return this.h;
    }

    @KeepForSdk
    @Nullable
    public final View getViewForPopups() {
        return this.f;
    }

    @Nullable
    public final SignInOptions getSignInOptions() {
        return this.i;
    }

    @Nullable
    public final Integer getClientSessionId() {
        return this.k;
    }

    public final void setClientSessionId(Integer num) {
        this.k = num;
    }

    @KeepForSdk
    public final Set<Scope> getApplicableScopes(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.d.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            return this.b;
        }
        HashSet hashSet = new HashSet(this.b);
        hashSet.addAll(optionalApiSettings.mScopes);
        return hashSet;
    }

    public final boolean isSignInClientDisconnectFixEnabled() {
        return this.j;
    }
}
