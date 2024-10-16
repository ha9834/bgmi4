package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aa;
import androidx.lifecycle.w;
import com.facebook.internal.security.CertificateUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.k, androidx.lifecycle.y, androidx.savedstate.d {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    w.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    i<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.l mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<b> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.c mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    w mViewLifecycleOwner;
    androidx.lifecycle.p<androidx.lifecycle.k> mViewLifecycleOwnerLiveData;
    String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {
        abstract void a();

        private b() {
        }
    }

    @Override // androidx.lifecycle.k
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public androidx.lifecycle.k getViewLifecycleOwner() {
        w wVar = this.mViewLifecycleOwner;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.k> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.y
    public androidx.lifecycle.x getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        return this.mFragmentManager.c(this);
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == Lifecycle.State.INITIALIZED || this.mParentFragment == null) {
            return this.mMaxState.ordinal();
        }
        return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public w.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Application application = null;
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.a(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.u(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    @Override // androidx.savedstate.d
    public final androidx.savedstate.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        final Bundle f607a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Bundle bundle) {
            this.f607a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f607a = parcel.readBundle();
            if (classLoader == null || (bundle = this.f607a) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f607a);
        }
    }

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new l();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() { // from class: androidx.fragment.app.Fragment.1
            @Override // java.lang.Runnable
            public void run() {
                Fragment.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.p<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mSavedStateRegistryController = androidx.savedstate.c.a(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = h.b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (java.lang.InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_CREATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.i();
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (savedState == null || savedState.f607a == null) ? null : savedState.f607a;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.d(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        i<?> iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.g();
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentActivity getActivity() {
        i<?> iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return (FragmentActivity) iVar.f();
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        i<?> iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.e();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.mChildFragmentManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.b(this.mParentFragment));
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.d(this);
        } else {
            fragmentManager.e(this);
        }
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.d();
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.d();
            }
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.a(fragmentManager.i(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public androidx.loader.a.a getLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        i<?> iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        iVar.a(this, intent, -1, bundle);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        getParentFragmentManager().a(this, intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().a(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        getParentFragmentManager().a(this, strArr, i);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        i<?> iVar = this.mHost;
        if (iVar != null) {
            return iVar.a(str);
        }
        return false;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        i<?> iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater b2 = iVar.b();
        androidx.core.f.f.a(b2, this.mChildFragmentManager.I());
        return b2;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        i<?> iVar = this.mHost;
        Activity f = iVar == null ? null : iVar.f();
        if (f != null) {
            this.mCalled = false;
            onInflate(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        i<?> iVar = this.mHost;
        Activity f = iVar == null ? null : iVar.f();
        if (f != null) {
            this.mCalled = false;
            onAttach(f);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.c(1)) {
            return;
        }
        this.mChildFragmentManager.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.a(parcelable);
        this.mChildFragmentManager.s();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new l();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(androidx.core.app.m mVar) {
        ensureAnimationInfo().s = mVar;
    }

    public void setExitSharedElementCallback(androidx.core.app.m mVar) {
        ensureAnimationInfo().t = mVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public Object getEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.k;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public Object getReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.l == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.l;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().m = obj;
    }

    public Object getExitTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.m;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().n = obj;
    }

    public Object getReenterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.n == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.n;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().o = obj;
    }

    public Object getSharedElementEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().p = obj;
    }

    public Object getSharedElementReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        if (aVar.p == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return this.mAnimationInfo.p;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().r = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.r == null) {
            return true;
        }
        return this.mAnimationInfo.r.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().q = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.q == null) {
            return true;
        }
        return this.mAnimationInfo.q.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().w = true;
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().w = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            handler = fragmentManager.m().h();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().w) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().w = false;
        } else if (Looper.myLooper() != this.mHost.h().getLooper()) {
            this.mHost.h().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.2
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.callStartTransitionListener(false);
                }
            });
        } else {
            callStartTransitionListener(true);
        }
    }

    void callStartTransitionListener(boolean z) {
        c cVar;
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            cVar = null;
        } else {
            aVar.w = false;
            cVar = aVar.x;
            this.mAnimationInfo.x = null;
        }
        if (cVar != null) {
            cVar.a();
            return;
        }
        if (!FragmentManager.f612a || this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        final SpecialEffectsController a2 = SpecialEffectsController.a(viewGroup, fragmentManager);
        a2.b();
        if (z) {
            this.mHost.h().post(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                @Override // java.lang.Runnable
                public void run() {
                    a2.d();
                }
            });
        } else {
            a2.d();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + CertificateUtil.DELIMITER);
        this.mChildFragmentManager.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e createFragmentContainer() {
        return new e() { // from class: androidx.fragment.app.Fragment.4
            @Override // androidx.fragment.app.e
            public View a(int i) {
                if (Fragment.this.mView == null) {
                    throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
                }
                return Fragment.this.mView.findViewById(i);
            }

            @Override // androidx.fragment.app.e
            public boolean a() {
                return Fragment.this.mView != null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void performAttach() {
        Iterator<b> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.a(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.g());
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
        this.mFragmentManager.q(this);
        this.mChildFragmentManager.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.q();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.a(new androidx.lifecycle.i() { // from class: androidx.fragment.app.Fragment.5
                @Override // androidx.lifecycle.i
                public void a(androidx.lifecycle.k kVar, Lifecycle.Event event) {
                    if (event != Lifecycle.Event.ON_STOP || Fragment.this.mView == null) {
                        return;
                    }
                    Fragment.this.mView.cancelPendingInputEvents();
                }
            });
        }
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_CREATE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.q();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new w(this, getViewModelStore());
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a();
            androidx.lifecycle.z.a(this.mView, this.mViewLifecycleOwner);
            aa.a(this.mView, this.mViewLifecycleOwner);
            androidx.savedstate.e.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.b((androidx.lifecycle.p<androidx.lifecycle.k>) this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.b()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.mViewLifecycleOwner = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.q();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        restoreViewState();
        this.mChildFragmentManager.u();
    }

    private void restoreViewState() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.q();
        this.mChildFragmentManager.a(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_START);
        }
        this.mChildFragmentManager.v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.q();
        this.mChildFragmentManager.a(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_RESUME);
        }
        this.mChildFragmentManager.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean a2 = this.mFragmentManager.a(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != a2) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(a2);
            onPrimaryNavigationFragmentChanged(a2);
            this.mChildFragmentManager.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.b(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.c(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.a(menu, menuInflater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.a(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.a(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.b(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.b(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        Parcelable l = this.mChildFragmentManager.l();
        if (l != null) {
            bundle.putParcelable("android:support:fragments", l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.x();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.y();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.z();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().a().a(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.loader.a.a.a(this).a();
        this.mPerformedCreateView = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.A();
        this.mLifecycleRegistry.a(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.mChildFragmentManager.h()) {
            return;
        }
        this.mChildFragmentManager.A();
        this.mChildFragmentManager = new l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(c cVar) {
        ensureAnimationInfo();
        if (cVar == this.mAnimationInfo.x) {
            return;
        }
        if (cVar != null && this.mAnimationInfo.x != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.mAnimationInfo.w) {
            this.mAnimationInfo.x = cVar;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    private a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new a();
        }
        return this.mAnimationInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        ensureAnimationInfo().d = i;
        ensureAnimationInfo().e = i2;
        ensureAnimationInfo().f = i3;
        ensureAnimationInfo().g = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEnterAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getExitAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPopEnterAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPopExitAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getPopDirection() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.h = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getSharedElementSourceNames() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.i == null) {
            return new ArrayList<>();
        }
        return this.mAnimationInfo.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getSharedElementTargetNames() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.j == null) {
            return new ArrayList<>();
        }
        return this.mAnimationInfo.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        a aVar = this.mAnimationInfo;
        aVar.i = arrayList;
        aVar.j = arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.m getEnterTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.m getExitTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getAnimatingAway() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f608a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f608a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().b = animator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator getAnimator() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPostOnViewCreatedAlpha(float f) {
        ensureAnimationInfo().u = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getPostOnViewCreatedAlpha() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 1.0f;
        }
        return aVar.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFocusedView(View view) {
        ensureAnimationInfo().v = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getFocusedView() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPostponed() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().y = z;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return prepareCallInternal(aVar, new androidx.a.a.c.a<Void, androidx.activity.result.c>() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.a.a.c.a
            public androidx.activity.result.c a(Void r1) {
                if (Fragment.this.mHost instanceof androidx.activity.result.d) {
                    return ((androidx.activity.result.d) Fragment.this.mHost).getActivityResultRegistry();
                }
                return Fragment.this.requireActivity().getActivityResultRegistry();
            }
        }, aVar2);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> aVar, final androidx.activity.result.c cVar, androidx.activity.result.a<O> aVar2) {
        return prepareCallInternal(aVar, new androidx.a.a.c.a<Void, androidx.activity.result.c>() { // from class: androidx.fragment.app.Fragment.7
            @Override // androidx.a.a.c.a
            public androidx.activity.result.c a(Void r1) {
                return cVar;
            }
        }, aVar2);
    }

    private <I, O> androidx.activity.result.b<I> prepareCallInternal(final androidx.activity.result.a.a<I, O> aVar, final androidx.a.a.c.a<Void, androidx.activity.result.c> aVar2, final androidx.activity.result.a<O> aVar3) {
        if (this.mState > 1) {
            throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        }
        final AtomicReference atomicReference = new AtomicReference();
        registerOnPreAttachListener(new b() { // from class: androidx.fragment.app.Fragment.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // androidx.fragment.app.Fragment.b
            void a() {
                String generateActivityResultKey = Fragment.this.generateActivityResultKey();
                atomicReference.set(((androidx.activity.result.c) aVar2.a(null)).a(generateActivityResultKey, Fragment.this, aVar, aVar3));
            }
        });
        return new androidx.activity.result.b<I>() { // from class: androidx.fragment.app.Fragment.9
            @Override // androidx.activity.result.b
            public void a(I i, androidx.core.app.b bVar) {
                androidx.activity.result.b bVar2 = (androidx.activity.result.b) atomicReference.get();
                if (bVar2 == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                bVar2.a(i, bVar);
            }

            @Override // androidx.activity.result.b
            public void a() {
                androidx.activity.result.b bVar = (androidx.activity.result.b) atomicReference.getAndSet(null);
                if (bVar != null) {
                    bVar.a();
                }
            }
        };
    }

    private void registerOnPreAttachListener(b bVar) {
        if (this.mState >= 0) {
            bVar.a();
        } else {
            this.mOnPreAttachedListeners.add(bVar);
        }
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        View f608a;
        Animator b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        ArrayList<String> i;
        ArrayList<String> j;
        Boolean q;
        Boolean r;
        boolean w;
        c x;
        boolean y;
        Object k = null;
        Object l = Fragment.USE_DEFAULT_TRANSITION;
        Object m = null;
        Object n = Fragment.USE_DEFAULT_TRANSITION;
        Object o = null;
        Object p = Fragment.USE_DEFAULT_TRANSITION;
        androidx.core.app.m s = null;
        androidx.core.app.m t = null;
        float u = 1.0f;
        View v = null;

        a() {
        }
    }
}
