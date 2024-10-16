package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements a.InterfaceC0042a, a.c {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.l mFragmentLifecycleRegistry;
    final g mFragments;
    boolean mResumed;
    boolean mStopped;

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.core.app.a.c
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public FragmentActivity() {
        this.mFragments = g.a(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int i) {
        super(i);
        this.mFragments = g.a(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().a(FRAGMENTS_TAG, new b.InterfaceC0068b() { // from class: androidx.fragment.app.FragmentActivity.1
            @Override // androidx.savedstate.b.InterfaceC0068b
            public Bundle a() {
                Bundle bundle = new Bundle();
                FragmentActivity.this.markFragmentsCreated();
                FragmentActivity.this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
                Parcelable c = FragmentActivity.this.mFragments.c();
                if (c != null) {
                    bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, c);
                }
                return bundle;
            }
        });
        addOnContextAvailableListener(new androidx.activity.a.b() { // from class: androidx.fragment.app.FragmentActivity.2
            @Override // androidx.activity.a.b
            public void a(Context context) {
                FragmentActivity.this.mFragments.a((Fragment) null);
                Bundle a2 = FragmentActivity.this.getSavedStateRegistry().a(FragmentActivity.FRAGMENTS_TAG);
                if (a2 != null) {
                    FragmentActivity.this.mFragments.a(a2.getParcelable(FragmentActivity.FRAGMENTS_TAG));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.b();
        super.onActivityResult(i, i2, intent);
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.b((Activity) this);
    }

    public void setEnterSharedElementCallback(androidx.core.app.m mVar) {
        androidx.core.app.a.a(this, mVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.m mVar) {
        androidx.core.app.a.b(this, mVar);
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.c((Activity) this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.d(this);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.b();
        super.onConfigurationChanged(configuration);
        this.mFragments.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_CREATE);
        this.mFragments.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.b(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_PAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.b();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.b();
        super.onResume();
        this.mResumed = true;
        this.mFragments.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_RESUME);
        this.mFragments.g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.a(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.b();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.e();
        }
        this.mFragments.l();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_START);
        this.mFragments.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.i();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.a();
    }

    @Deprecated
    public androidx.loader.a.a getSupportLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.b();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            androidx.core.app.a.a(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            androidx.core.app.a.a(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* loaded from: classes.dex */
    class a extends i<FragmentActivity> implements androidx.activity.c, androidx.activity.result.d, n, androidx.lifecycle.y {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.lifecycle.k
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.lifecycle.y
        public androidx.lifecycle.x getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.fragment.app.i
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.i
        public boolean a(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.i
        public LayoutInflater b() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public FragmentActivity e() {
            return FragmentActivity.this;
        }

        @Override // androidx.fragment.app.i
        public void d() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.i
        public boolean a(String str) {
            return androidx.core.app.a.a((Activity) FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.n
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.e
        public View a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.e
        public boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.d
        public androidx.activity.result.c getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }
    }

    void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.g()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), state);
                }
                if (fragment.mViewLifecycleOwner != null && fragment.mViewLifecycleOwner.getLifecycle().a().a(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.a(state);
                    z = true;
                }
                if (fragment.mLifecycleRegistry.a().a(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.b(state);
                    z = true;
                }
            }
        }
        return z;
    }
}
