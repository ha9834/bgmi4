package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApi<O extends Api.ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    protected final GoogleApiManager f1292a;
    private final Context b;
    private final Api<O> c;
    private final O d;
    private final zai<O> e;
    private final Looper f;
    private final int g;
    private final GoogleApiClient h;
    private final StatusExceptionMapper i;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Settings {

        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zabn;
        public final Looper zabo;

        @KeepForSdk
        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private StatusExceptionMapper f1293a;
            private Looper b;

            @KeepForSdk
            public Builder() {
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f1293a = statusExceptionMapper;
                return this;
            }

            @KeepForSdk
            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.b = looper;
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @KeepForSdk
            public Settings build() {
                if (this.f1293a == null) {
                    this.f1293a = new ApiExceptionMapper();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new Settings(this.f1293a, this.b);
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zabn = statusExceptionMapper;
            this.zabo = looper;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, Looper looper) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        this.b = context.getApplicationContext();
        this.c = api;
        this.d = null;
        this.f = looper;
        this.e = zai.zaa(api);
        this.h = new zabp(this);
        this.f1292a = GoogleApiManager.zab(this.b);
        this.g = this.f1292a.zabd();
        this.i = new ApiExceptionMapper();
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setLooper(looper).setMapper(statusExceptionMapper).build());
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.b = activity.getApplicationContext();
        this.c = api;
        this.d = o;
        this.f = settings.zabo;
        this.e = zai.zaa(this.c, this.d);
        this.h = new zabp(this);
        this.f1292a = GoogleApiManager.zab(this.b);
        this.g = this.f1292a.zabd();
        this.i = settings.zabn;
        if (!(activity instanceof GoogleApiActivity)) {
            zaae.zaa(activity, this.f1292a, this.e);
        }
        this.f1292a.zaa((GoogleApi<?>) this);
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.b = context.getApplicationContext();
        this.c = api;
        this.d = o;
        this.f = settings.zabo;
        this.e = zai.zaa(this.c, this.d);
        this.h = new zabp(this);
        this.f1292a = GoogleApiManager.zab(this.b);
        this.g = this.f1292a.zabd();
        this.i = settings.zabn;
        this.f1292a.zaa((GoogleApi<?>) this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(activity, (Api) api, (Api.ApiOptions) o, new Settings.Builder().setMapper(statusExceptionMapper).setLooper(activity.getMainLooper()).build());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setMapper(statusExceptionMapper).build());
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(int i, T t) {
        t.zau();
        this.f1292a.zaa(this, i, (BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>) t);
        return t;
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> a(int i, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1292a.zaa(this, i, taskApiCall, taskCompletionSource, this.i);
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        return (T) a(0, (int) t);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return a(0, taskApiCall);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        return (T) a(1, (int) t);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return a(1, taskApiCall);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        return (T) a(2, (int) t);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return a(2, taskApiCall);
    }

    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(t.getListenerKey().equals(u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f1292a.zaa(this, (RegisterListenerMethod<Api.AnyClient, ?>) t, (UnregisterListenerMethod<Api.AnyClient, ?>) u);
    }

    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.zajz.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaka.getListenerKey(), "Listener has already been released.");
        return this.f1292a.zaa(this, registrationMethods.zajz, registrationMethods.zaka);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.f1292a.zaa(this, listenerKey);
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l, String str) {
        return ListenerHolders.createListenerHolder(l, this.f, str);
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.Api$Client] */
    public Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        return this.c.zai().buildClient(this.b, looper, a().build(), this.d, zaaVar, zaaVar);
    }

    public final Api<O> getApi() {
        return this.c;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.d;
    }

    public final zai<O> zak() {
        return this.e;
    }

    public final int getInstanceId() {
        return this.g;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.h;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.f;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.b;
    }

    @KeepForSdk
    protected ClientSettings.Builder a() {
        Account account;
        Set<Scope> emptySet;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.d;
        if ((o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) && (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).getGoogleSignInAccount()) != null) {
            account = googleSignInAccount2.getAccount();
        } else {
            O o2 = this.d;
            account = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).getAccount() : null;
        }
        ClientSettings.Builder account2 = builder.setAccount(account);
        O o3 = this.d;
        if ((o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) && (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).getGoogleSignInAccount()) != null) {
            emptySet = googleSignInAccount.getRequestedScopes();
        } else {
            emptySet = Collections.emptySet();
        }
        return account2.addAllRequiredScopes(emptySet).setRealClientClassName(this.b.getClass().getName()).setRealClientPackageName(this.b.getPackageName());
    }

    public zace zaa(Context context, Handler handler) {
        return new zace(context, handler, a().build());
    }
}
