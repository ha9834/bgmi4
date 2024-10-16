package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final k f676a;
    private final r b;
    private final Fragment c;
    private boolean d = false;
    private int e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar, r rVar, Fragment fragment) {
        this.f676a = kVar;
        this.b = rVar;
        this.c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar, r rVar, ClassLoader classLoader, h hVar, FragmentState fragmentState) {
        this.f676a = kVar;
        this.b = rVar;
        this.c = hVar.c(classLoader, fragmentState.f628a);
        if (fragmentState.j != null) {
            fragmentState.j.setClassLoader(classLoader);
        }
        this.c.setArguments(fragmentState.j);
        this.c.mWho = fragmentState.b;
        this.c.mFromLayout = fragmentState.c;
        Fragment fragment = this.c;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.d;
        this.c.mContainerId = fragmentState.e;
        this.c.mTag = fragmentState.f;
        this.c.mRetainInstance = fragmentState.g;
        this.c.mRemoving = fragmentState.h;
        this.c.mDetached = fragmentState.i;
        this.c.mHidden = fragmentState.k;
        this.c.mMaxState = Lifecycle.State.values()[fragmentState.l];
        if (fragmentState.m != null) {
            this.c.mSavedFragmentState = fragmentState.m;
        } else {
            this.c.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar, r rVar, Fragment fragment, FragmentState fragmentState) {
        this.f676a = kVar;
        this.b = rVar;
        this.c = fragment;
        Fragment fragment2 = this.c;
        fragment2.mSavedViewState = null;
        fragment2.mSavedViewRegistryState = null;
        fragment2.mBackStackNesting = 0;
        fragment2.mInLayout = false;
        fragment2.mAdded = false;
        fragment2.mTargetWho = fragment2.mTarget != null ? this.c.mTarget.mWho : null;
        this.c.mTarget = null;
        if (fragmentState.m != null) {
            this.c.mSavedFragmentState = fragmentState.m;
        } else {
            this.c.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if (this.c.mFragmentManager == null) {
            return this.c.mState;
        }
        int i = this.e;
        switch (this.c.mMaxState) {
            case RESUMED:
                break;
            case STARTED:
                i = Math.min(i, 5);
                break;
            case CREATED:
                i = Math.min(i, 1);
                break;
            case INITIALIZED:
                i = Math.min(i, 0);
                break;
            default:
                i = Math.min(i, -1);
                break;
        }
        if (this.c.mFromLayout) {
            if (this.c.mInLayout) {
                i = Math.max(this.e, 2);
                if (this.c.mView != null && this.c.mView.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, this.c.mState) : Math.min(i, 1);
            }
        }
        if (!this.c.mAdded) {
            i = Math.min(i, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (FragmentManager.f612a && this.c.mContainer != null) {
            lifecycleImpact = SpecialEffectsController.a(this.c.mContainer, this.c.getParentFragmentManager()).a(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i, 3);
        } else if (this.c.mRemoving) {
            if (this.c.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.c.mDeferStart && this.c.mState < 5) {
            i = Math.min(i, 4);
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + this.c);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c() {
        if (this.d) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + a());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int b = b();
                if (b != this.c.mState) {
                    if (b > this.c.mState) {
                        switch (this.c.mState + 1) {
                            case 0:
                                e();
                                break;
                            case 1:
                                f();
                                break;
                            case 2:
                                d();
                                g();
                                break;
                            case 3:
                                h();
                                break;
                            case 4:
                                if (this.c.mView != null && this.c.mContainer != null) {
                                    SpecialEffectsController.a(this.c.mContainer, this.c.getParentFragmentManager()).a(SpecialEffectsController.Operation.State.a(this.c.mView.getVisibility()), this);
                                }
                                this.c.mState = 4;
                                break;
                            case 5:
                                i();
                                break;
                            case 6:
                                this.c.mState = 6;
                                break;
                            case 7:
                                j();
                                break;
                        }
                    } else {
                        switch (this.c.mState - 1) {
                            case -1:
                                r();
                                break;
                            case 0:
                                q();
                                break;
                            case 1:
                                p();
                                this.c.mState = 1;
                                break;
                            case 2:
                                this.c.mInLayout = false;
                                this.c.mState = 2;
                                break;
                            case 3:
                                if (FragmentManager.a(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                                }
                                if (this.c.mView != null && this.c.mSavedViewState == null) {
                                    o();
                                }
                                if (this.c.mView != null && this.c.mContainer != null) {
                                    SpecialEffectsController.a(this.c.mContainer, this.c.getParentFragmentManager()).d(this);
                                }
                                this.c.mState = 3;
                                break;
                            case 4:
                                l();
                                break;
                            case 5:
                                this.c.mState = 5;
                                break;
                            case 6:
                                k();
                                break;
                        }
                    }
                } else {
                    if (FragmentManager.f612a && this.c.mHiddenChanged) {
                        if (this.c.mView != null && this.c.mContainer != null) {
                            SpecialEffectsController a2 = SpecialEffectsController.a(this.c.mContainer, this.c.getParentFragmentManager());
                            if (this.c.mHidden) {
                                a2.c(this);
                            } else {
                                a2.b(this);
                            }
                        }
                        if (this.c.mFragmentManager != null) {
                            this.c.mFragmentManager.r(this.c);
                        }
                        this.c.mHiddenChanged = false;
                        this.c.onHiddenChanged(this.c.mHidden);
                    }
                    return;
                }
            }
        } finally {
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.c.mFromLayout && this.c.mInLayout && !this.c.mPerformedCreateView) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Fragment fragment = this.c;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, this.c.mSavedFragmentState);
            if (this.c.mView != null) {
                this.c.mView.setSaveFromParentEnabled(false);
                this.c.mView.setTag(a.b.fragment_container_view_tag, this.c);
                if (this.c.mHidden) {
                    this.c.mView.setVisibility(8);
                }
                this.c.performViewCreated();
                k kVar = this.f676a;
                Fragment fragment2 = this.c;
                kVar.a(fragment2, fragment2.mView, this.c.mSavedFragmentState, false);
                this.c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ClassLoader classLoader) {
        if (this.c.mSavedFragmentState == null) {
            return;
        }
        this.c.mSavedFragmentState.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        if (this.c.mTargetWho != null) {
            Fragment fragment4 = this.c;
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        if (this.c.mSavedUserVisibleHint != null) {
            Fragment fragment5 = this.c;
            fragment5.mUserVisibleHint = fragment5.mSavedUserVisibleHint.booleanValue();
            this.c.mSavedUserVisibleHint = null;
        } else {
            Fragment fragment6 = this.c;
            fragment6.mUserVisibleHint = fragment6.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (this.c.mUserVisibleHint) {
            return;
        }
        this.c.mDeferStart = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        p pVar = null;
        if (this.c.mTarget != null) {
            p c = this.b.c(this.c.mTarget.mWho);
            if (c == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment = this.c;
            fragment.mTargetWho = fragment.mTarget.mWho;
            this.c.mTarget = null;
            pVar = c;
        } else if (this.c.mTargetWho != null && (pVar = this.b.c(this.c.mTargetWho)) == null) {
            throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTargetWho + " that does not belong to this FragmentManager!");
        }
        if (pVar != null && (FragmentManager.f612a || pVar.a().mState < 1)) {
            pVar.c();
        }
        Fragment fragment2 = this.c;
        fragment2.mHost = fragment2.mFragmentManager.m();
        Fragment fragment3 = this.c;
        fragment3.mParentFragment = fragment3.mFragmentManager.n();
        this.f676a.a(this.c, false);
        this.c.performAttach();
        this.f676a.b(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        if (!this.c.mIsCreated) {
            k kVar = this.f676a;
            Fragment fragment = this.c;
            kVar.a(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            k kVar2 = this.f676a;
            Fragment fragment3 = this.c;
            kVar2.b(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        Fragment fragment4 = this.c;
        fragment4.restoreChildFragmentState(fragment4.mSavedFragmentState);
        this.c.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        String str;
        if (this.c.mFromLayout) {
            return;
        }
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        if (this.c.mContainer != null) {
            viewGroup = this.c.mContainer;
        } else if (this.c.mContainerId != 0) {
            if (this.c.mContainerId == -1) {
                throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
            }
            viewGroup = (ViewGroup) this.c.mFragmentManager.o().a(this.c.mContainerId);
            if (viewGroup == null && !this.c.mRestored) {
                try {
                    str = this.c.getResources().getResourceName(this.c.mContainerId);
                } catch (Resources.NotFoundException unused) {
                    str = "unknown";
                }
                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.mContainerId) + " (" + str + ") for fragment " + this.c);
            }
        }
        Fragment fragment2 = this.c;
        fragment2.mContainer = viewGroup;
        fragment2.performCreateView(performGetLayoutInflater, viewGroup, fragment2.mSavedFragmentState);
        if (this.c.mView != null) {
            boolean z = false;
            this.c.mView.setSaveFromParentEnabled(false);
            this.c.mView.setTag(a.b.fragment_container_view_tag, this.c);
            if (viewGroup != null) {
                s();
            }
            if (this.c.mHidden) {
                this.c.mView.setVisibility(8);
            }
            if (androidx.core.f.v.A(this.c.mView)) {
                androidx.core.f.v.p(this.c.mView);
            } else {
                final View view = this.c.mView;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.p.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        view.removeOnAttachStateChangeListener(this);
                        androidx.core.f.v.p(view);
                    }
                });
            }
            this.c.performViewCreated();
            k kVar = this.f676a;
            Fragment fragment3 = this.c;
            kVar.a(fragment3, fragment3.mView, this.c.mSavedFragmentState, false);
            int visibility = this.c.mView.getVisibility();
            float alpha = this.c.mView.getAlpha();
            if (FragmentManager.f612a) {
                this.c.setPostOnViewCreatedAlpha(alpha);
                if (this.c.mContainer != null && visibility == 0) {
                    View findFocus = this.c.mView.findFocus();
                    if (findFocus != null) {
                        this.c.setFocusedView(findFocus);
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c);
                        }
                    }
                    this.c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment4 = this.c;
                if (visibility == 0 && fragment4.mContainer != null) {
                    z = true;
                }
                fragment4.mIsNewlyAdded = z;
            }
        }
        this.c.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        k kVar = this.f676a;
        Fragment fragment2 = this.c;
        kVar.c(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.performStart();
        this.f676a.c(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View focusedView = this.c.getFocusedView();
        if (focusedView != null && a(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.a(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.setFocusedView(null);
        this.c.performResume();
        this.f676a.d(this.c, false);
        Fragment fragment = this.c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    private boolean a(View view) {
        if (view == this.c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.mView) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.performPause();
        this.f676a.e(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.performStop();
        this.f676a.f(this.c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState m() {
        FragmentState fragmentState = new FragmentState(this.c);
        if (this.c.mState > -1 && fragmentState.m == null) {
            fragmentState.m = t();
            if (this.c.mTargetWho != null) {
                if (fragmentState.m == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.c.mTargetWho);
                if (this.c.mTargetRequestCode != 0) {
                    fragmentState.m.putInt("android:target_req_state", this.c.mTargetRequestCode);
                }
            }
        } else {
            fragmentState.m = this.c.mSavedFragmentState;
        }
        return fragmentState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState n() {
        Bundle t;
        if (this.c.mState <= -1 || (t = t()) == null) {
            return null;
        }
        return new Fragment.SavedState(t);
    }

    private Bundle t() {
        Bundle bundle = new Bundle();
        this.c.performSaveInstanceState(bundle);
        this.f676a.d(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.c.mView != null) {
            o();
        }
        if (this.c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.c.mSavedViewState);
        }
        if (this.c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.c.mSavedViewRegistryState);
        }
        if (!this.c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.c.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.mViewLifecycleOwner.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.mSavedViewRegistryState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        if (this.c.mContainer != null && this.c.mView != null) {
            this.c.mContainer.removeView(this.c.mView);
        }
        this.c.performDestroyView();
        this.f676a.g(this.c, false);
        Fragment fragment = this.c;
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.b((androidx.lifecycle.p<androidx.lifecycle.k>) null);
        this.c.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        Fragment e;
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        boolean z = true;
        boolean z2 = this.c.mRemoving && !this.c.isInBackStack();
        if (z2 || this.b.a().b(this.c)) {
            i<?> iVar = this.c.mHost;
            if (iVar instanceof androidx.lifecycle.y) {
                z = this.b.a().b();
            } else if (iVar.g() instanceof Activity) {
                z = true ^ ((Activity) iVar.g()).isChangingConfigurations();
            }
            if (z2 || z) {
                this.b.a().f(this.c);
            }
            this.c.performDestroy();
            this.f676a.h(this.c, false);
            for (p pVar : this.b.g()) {
                if (pVar != null) {
                    Fragment a2 = pVar.a();
                    if (this.c.mWho.equals(a2.mTargetWho)) {
                        a2.mTarget = this.c;
                        a2.mTargetWho = null;
                    }
                }
            }
            if (this.c.mTargetWho != null) {
                Fragment fragment = this.c;
                fragment.mTarget = this.b.e(fragment.mTargetWho);
            }
            this.b.b(this);
            return;
        }
        if (this.c.mTargetWho != null && (e = this.b.e(this.c.mTargetWho)) != null && e.mRetainInstance) {
            this.c.mTarget = e;
        }
        this.c.mState = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.performDetach();
        boolean z = false;
        this.f676a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !this.c.isInBackStack()) {
            z = true;
        }
        if (z || this.b.a().b(this.c)) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.c.mContainer.addView(this.c.mView, this.b.c(this.c));
    }
}
