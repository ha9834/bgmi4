package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.a.a;
import androidx.activity.result.d;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.aa;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.savedstate.b;
import androidx.savedstate.e;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements c, d, k, y, androidx.savedstate.d {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.c mActivityResultRegistry;
    private int mContentLayoutId;
    final androidx.activity.a.a mContextAwareHelper;
    private w.b mDefaultFactory;
    private final l mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.c mSavedStateRegistryController;
    private x mViewModelStore;

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object f120a;
        x b;

        a() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.a.a();
        this.mLifecycleRegistry = new l(this);
        this.mSavedStateRegistryController = androidx.savedstate.c.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e) {
                    if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new androidx.activity.result.c() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.activity.result.c
            public <I, O> void a(final int i, androidx.activity.result.a.a<I, O> aVar, I i2, androidx.core.app.b bVar) {
                Bundle a2;
                ComponentActivity componentActivity = ComponentActivity.this;
                final a.C0022a<O> b = aVar.b(componentActivity, i2);
                if (b != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a(i, (int) b.a());
                        }
                    });
                    return;
                }
                Intent a3 = aVar.a((Context) componentActivity, (ComponentActivity) i2);
                if (a3.getExtras() != null && a3.getExtras().getClassLoader() == null) {
                    a3.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (a3.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    Bundle bundleExtra = a3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    a3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    a2 = bundleExtra;
                } else {
                    a2 = bVar != null ? bVar.a() : null;
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a3.getAction())) {
                    String[] stringArrayExtra = a3.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    androidx.core.app.a.a(componentActivity, stringArrayExtra, i);
                    return;
                }
                if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a3.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a3.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        androidx.core.app.a.a(componentActivity, intentSenderRequest.a(), i, intentSenderRequest.b(), intentSenderRequest.c(), intentSenderRequest.d(), 0, a2);
                        return;
                    } catch (IntentSender.SendIntentException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                a(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e));
                            }
                        });
                        return;
                    }
                }
                androidx.core.app.a.a(componentActivity, a3, i, a2);
            }
        };
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.i
                public void a(k kVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.i
            public void a(k kVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().b();
                }
            }
        });
        getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.i
            public void a(k kVar, Lifecycle.Event event) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().b(this);
            }
        });
        if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().a(ACTIVITY_RESULT_TAG, new b.InterfaceC0068b() { // from class: androidx.activity.ComponentActivity.6
            @Override // androidx.savedstate.b.InterfaceC0068b
            @SuppressLint({"SyntheticAccessor"})
            public Bundle a() {
                Bundle bundle = new Bundle();
                ComponentActivity.this.mActivityResultRegistry.a(bundle);
                return bundle;
            }
        });
        addOnContextAvailableListener(new androidx.activity.a.b() { // from class: androidx.activity.ComponentActivity.7
            @Override // androidx.activity.a.b
            @SuppressLint({"SyntheticAccessor"})
            public void a(Context context) {
                Bundle a2 = ComponentActivity.this.getSavedStateRegistry().a(ComponentActivity.ACTIVITY_RESULT_TAG);
                if (a2 != null) {
                    ComponentActivity.this.mActivityResultRegistry.b(a2);
                }
            }
        });
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        this.mContextAwareHelper.a(this);
        super.onCreate(bundle);
        s.a(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof l) {
            ((l) lifecycle).b(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        x xVar = this.mViewModelStore;
        if (xVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            xVar = aVar.b;
        }
        if (xVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f120a = onRetainCustomNonConfigurationInstance;
        aVar2.b = xVar;
        return aVar2;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f120a;
        }
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    private void initViewTreeOwners() {
        z.a(getWindow().getDecorView(), this);
        aa.a(getWindow().getDecorView(), this);
        e.a(getWindow().getDecorView(), this);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.a();
    }

    public final void addOnContextAvailableListener(androidx.activity.a.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    public final void removeOnContextAvailableListener(androidx.activity.a.b bVar) {
        this.mContextAwareHelper.b(bVar);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.k
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.y
    public x getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.mViewModelStore = aVar.b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new x();
            }
        }
    }

    public w.b getDefaultViewModelProviderFactory() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new u(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.d
    public final androidx.savedstate.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> aVar, androidx.activity.result.c cVar, androidx.activity.result.a<O> aVar2) {
        return cVar.a("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @Override // androidx.activity.result.d
    public final androidx.activity.result.c getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (androidx.f.a.a()) {
                androidx.f.a.a("reportFullyDrawn() for " + getComponentName());
            }
            if (Build.VERSION.SDK_INT > 19) {
                super.reportFullyDrawn();
            } else if (Build.VERSION.SDK_INT == 19 && androidx.core.content.a.b(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            androidx.f.a.b();
        }
    }
}
