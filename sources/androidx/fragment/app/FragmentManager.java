package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.a.b;
import androidx.fragment.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.s;
import androidx.fragment.app.t;
import androidx.lifecycle.Lifecycle;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.security.CertificateUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {

    /* renamed from: a, reason: collision with root package name */
    static boolean f612a = true;
    private static boolean f;
    private androidx.activity.result.b<Intent> C;
    private androidx.activity.result.b<IntentSenderRequest> D;
    private androidx.activity.result.b<String[]> E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private ArrayList<androidx.fragment.app.a> K;
    private ArrayList<Boolean> L;
    private ArrayList<Fragment> M;
    private ArrayList<g> N;
    private m O;
    ArrayList<androidx.fragment.app.a> b;
    Fragment d;
    private boolean h;
    private ArrayList<Fragment> j;
    private OnBackPressedDispatcher l;
    private ArrayList<d> q;
    private i<?> v;
    private androidx.fragment.app.e w;
    private Fragment x;
    private final ArrayList<e> g = new ArrayList<>();
    private final r i = new r();
    private final j k = new j(this);
    private final androidx.activity.b m = new androidx.activity.b(false) { // from class: androidx.fragment.app.FragmentManager.1
        @Override // androidx.activity.b
        public void c() {
            FragmentManager.this.c();
        }
    };
    private final AtomicInteger n = new AtomicInteger();
    private final Map<String, Bundle> o = Collections.synchronizedMap(new HashMap());
    private final Map<String, Object> p = Collections.synchronizedMap(new HashMap());
    private Map<Fragment, HashSet<androidx.core.os.b>> r = Collections.synchronizedMap(new HashMap());
    private final t.a s = new t.a() { // from class: androidx.fragment.app.FragmentManager.4
        @Override // androidx.fragment.app.t.a
        public void a(Fragment fragment, androidx.core.os.b bVar) {
            FragmentManager.this.a(fragment, bVar);
        }

        @Override // androidx.fragment.app.t.a
        public void b(Fragment fragment, androidx.core.os.b bVar) {
            if (bVar.a()) {
                return;
            }
            FragmentManager.this.b(fragment, bVar);
        }
    };
    private final k t = new k(this);
    private final CopyOnWriteArrayList<n> u = new CopyOnWriteArrayList<>();
    int c = -1;
    private h y = null;
    private h z = new h() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // androidx.fragment.app.h
        public Fragment c(ClassLoader classLoader, String str) {
            return FragmentManager.this.m().a(FragmentManager.this.m().g(), str, (Bundle) null);
        }
    };
    private z A = null;
    private z B = new z() { // from class: androidx.fragment.app.FragmentManager.7
        @Override // androidx.fragment.app.z
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    };
    ArrayDeque<LaunchedFragmentInfo> e = new ArrayDeque<>();
    private Runnable P = new Runnable() { // from class: androidx.fragment.app.FragmentManager.8
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.a(true);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        String h();
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public void a(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment) {
        }

        @Deprecated
        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i) {
        return f || Log.isLoggable("FragmentManager", i);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new y("FragmentManager"));
        i<?> iVar = this.v;
        if (iVar != null) {
            try {
                iVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    public s a() {
        return new androidx.fragment.app.a(this);
    }

    public boolean b() {
        boolean a2 = a(true);
        N();
        return a2;
    }

    private void J() {
        synchronized (this.g) {
            if (!this.g.isEmpty()) {
                this.m.a(true);
            } else {
                this.m.a(f() > 0 && a(this.x));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.D()) && a(fragmentManager.x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void c() {
        a(true);
        if (this.m.a()) {
            e();
        } else {
            this.l.a();
        }
    }

    public void d() {
        a((e) new f(null, -1, 0), false);
    }

    public boolean e() {
        return a((String) null, -1, 0);
    }

    public void a(String str, int i) {
        a((e) new f(str, -1, i), false);
    }

    public boolean b(String str, int i) {
        return a(str, -1, i);
    }

    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((e) new f(null, i, i2), false);
    }

    private boolean a(String str, int i, int i2) {
        a(false);
        d(true);
        Fragment fragment = this.d;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().e()) {
            return true;
        }
        boolean a2 = a(this.K, this.L, str, i, i2);
        if (a2) {
            this.h = true;
            try {
                b(this.K, this.L);
            } finally {
                M();
            }
        }
        J();
        Q();
        this.i.d();
        return a2;
    }

    public int f() {
        ArrayList<androidx.fragment.app.a> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public a b(int i) {
        return this.b.get(i);
    }

    void a(Fragment fragment, androidx.core.os.b bVar) {
        if (this.r.get(fragment) == null) {
            this.r.put(fragment, new HashSet<>());
        }
        this.r.get(fragment).add(bVar);
    }

    void b(Fragment fragment, androidx.core.os.b bVar) {
        HashSet<androidx.core.os.b> hashSet = this.r.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.r.remove(fragment);
            if (fragment.mState < 5) {
                u(fragment);
                g(fragment);
            }
        }
    }

    public final void a(String str) {
        this.o.remove(str);
    }

    /* renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 implements androidx.lifecycle.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f620a;
        final /* synthetic */ o b;
        final /* synthetic */ Lifecycle c;
        final /* synthetic */ FragmentManager d;

        @Override // androidx.lifecycle.i
        public void a(androidx.lifecycle.k kVar, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.d.o.get(this.f620a)) != null) {
                this.b.a(this.f620a, bundle);
                this.d.a(this.f620a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.c.b(this);
                this.d.p.remove(this.f620a);
            }
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment d2 = d(string);
        if (d2 == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment a(View view) {
        Object tag = view.getTag(a.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.fragment.app.f fVar) {
        for (p pVar : this.i.g()) {
            Fragment a2 = pVar.a();
            if (a2.mContainerId == fVar.getId() && a2.mView != null && a2.mView.getParent() == null) {
                a2.mContainer = fVar;
                pVar.s();
            }
        }
    }

    public List<Fragment> g() {
        return this.i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.x c(Fragment fragment) {
        return this.O.e(fragment);
    }

    private m s(Fragment fragment) {
        return this.O.d(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        this.O.a(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        this.O.c(fragment);
    }

    public Fragment.SavedState f(Fragment fragment) {
        p c2 = this.i.c(fragment.mWho);
        if (c2 == null || !c2.a().equals(fragment)) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return c2.n();
    }

    public boolean h() {
        return this.I;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        } else {
            i<?> iVar = this.v;
            if (iVar != null) {
                sb.append(iVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            } else {
                sb.append(Constants.NULL_VERSION_ID);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.i.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.j;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                Fragment fragment = this.j.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.b;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                androidx.fragment.app.a aVar = this.b.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.n.get());
        synchronized (this.g) {
            int size3 = this.g.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    e eVar = this.g.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(eVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.c);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.G);
        printWriter.print(" mStopped=");
        printWriter.print(this.H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.I);
        if (this.F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        Fragment a2 = pVar.a();
        if (a2.mDeferStart) {
            if (this.h) {
                this.J = true;
                return;
            }
            a2.mDeferStart = false;
            if (f612a) {
                pVar.c();
            } else {
                g(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i) {
        return this.c >= i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0079. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(androidx.fragment.app.Fragment r9, int r10) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(androidx.fragment.app.Fragment, int):void");
    }

    private void t(Fragment fragment) {
        HashSet<androidx.core.os.b> hashSet = this.r.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            hashSet.clear();
            u(fragment);
            this.r.remove(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z) {
        ViewGroup x = x(fragment);
        if (x == null || !(x instanceof androidx.fragment.app.f)) {
            return;
        }
        ((androidx.fragment.app.f) x).setDrawDisappearingViewsLast(!z);
    }

    private void u(Fragment fragment) {
        fragment.performDestroyView();
        this.t.g(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.b((androidx.lifecycle.p<androidx.lifecycle.k>) null);
        fragment.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        a(fragment, this.c);
    }

    private void v(final Fragment fragment) {
        if (fragment.mView != null) {
            d.a a2 = androidx.fragment.app.d.a(this.v.g(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (a2 != null && a2.b != null) {
                a2.b.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = fragment.mContainer;
                        final View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        a2.b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentManager.9
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.mView == null || !fragment.mHidden) {
                                    return;
                                }
                                fragment.mView.setVisibility(8);
                            }
                        });
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                a2.b.start();
            } else {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.f665a);
                    a2.f665a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        r(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (!this.i.b(fragment.mWho)) {
            if (a(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.c + "since it is not added to " + this);
                return;
            }
            return;
        }
        g(fragment);
        if (fragment.mView != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            if (fragment.mPostponedAlpha > 0.0f) {
                fragment.mView.setAlpha(fragment.mPostponedAlpha);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            d.a a2 = androidx.fragment.app.d.a(this.v.g(), fragment, true, fragment.getPopDirection());
            if (a2 != null) {
                if (a2.f665a != null) {
                    fragment.mView.startAnimation(a2.f665a);
                } else {
                    a2.b.setTarget(fragment.mView);
                    a2.b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            v(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        i<?> iVar;
        if (this.v == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.c) {
            this.c = i;
            if (f612a) {
                this.i.c();
            } else {
                Iterator<Fragment> it = this.i.h().iterator();
                while (it.hasNext()) {
                    h(it.next());
                }
                for (p pVar : this.i.g()) {
                    Fragment a2 = pVar.a();
                    if (!a2.mIsNewlyAdded) {
                        h(a2);
                    }
                    if (a2.mRemoving && !a2.isInBackStack()) {
                        this.i.b(pVar);
                    }
                }
            }
            K();
            if (this.F && (iVar = this.v) != null && this.c == 7) {
                iVar.d();
                this.F = false;
            }
        }
    }

    private void K() {
        Iterator<p> it = this.i.g().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p i(Fragment fragment) {
        p c2 = this.i.c(fragment.mWho);
        if (c2 != null) {
            return c2;
        }
        p pVar = new p(this.t, this.i, fragment);
        pVar.a(this.v.g().getClassLoader());
        pVar.a(this.c);
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p j(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        p i = i(fragment);
        fragment.mFragmentManager = this;
        this.i.a(i);
        if (!fragment.mDetached) {
            this.i.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (z(fragment)) {
                this.F = true;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.i.b(fragment);
            if (z(fragment)) {
                this.F = true;
            }
            fragment.mRemoving = true;
            w(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        w(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (a(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.i.b(fragment);
            if (z(fragment)) {
                this.F = true;
            }
            w(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.i.a(fragment);
            if (a(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (z(fragment)) {
                this.F = true;
            }
        }
    }

    public Fragment d(int i) {
        return this.i.b(i);
    }

    public Fragment b(String str) {
        return this.i.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment c(String str) {
        return this.i.d(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment d(String str) {
        return this.i.e(str);
    }

    private void L() {
        if (i()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean i() {
        return this.G || this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar, boolean z) {
        if (!z) {
            if (this.v == null) {
                if (this.I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            L();
        }
        synchronized (this.g) {
            if (this.v == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.g.add(eVar);
                j();
            }
        }
    }

    void j() {
        synchronized (this.g) {
            boolean z = (this.N == null || this.N.isEmpty()) ? false : true;
            boolean z2 = this.g.size() == 1;
            if (z || z2) {
                this.v.h().removeCallbacks(this.P);
                this.v.h().post(this.P);
                J();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.n.getAndIncrement();
    }

    private void d(boolean z) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.v == null) {
            if (this.I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if (Looper.myLooper() != this.v.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            L();
        }
        if (this.K == null) {
            this.K = new ArrayList<>();
            this.L = new ArrayList<>();
        }
        this.h = true;
        try {
            a((ArrayList<androidx.fragment.app.a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, boolean z) {
        if (z && (this.v == null || this.I)) {
            return;
        }
        d(z);
        if (eVar.a(this.K, this.L)) {
            this.h = true;
            try {
                b(this.K, this.L);
            } finally {
                M();
            }
        }
        J();
        Q();
        this.i.d();
    }

    private void M() {
        this.h = false;
        this.L.clear();
        this.K.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z) {
        d(z);
        boolean z2 = false;
        while (c(this.K, this.L)) {
            this.h = true;
            try {
                b(this.K, this.L);
                M();
                z2 = true;
            } catch (Throwable th) {
                M();
                throw th;
            }
        }
        J();
        Q();
        this.i.d();
        return z2;
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.N;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            g gVar = this.N.get(i);
            if (arrayList != null && !gVar.f626a && (indexOf2 = arrayList.indexOf(gVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.N.remove(i);
                i--;
                size--;
                gVar.e();
            } else if (gVar.c() || (arrayList != null && gVar.b.a(arrayList, 0, arrayList.size()))) {
                this.N.remove(i);
                i--;
                size--;
                if (arrayList != null && !gVar.f626a && (indexOf = arrayList.indexOf(gVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                    gVar.e();
                } else {
                    gVar.d();
                }
            }
            i++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).s) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).s) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        ?? r1;
        boolean z;
        int i3;
        int i4;
        ArrayList<Boolean> arrayList3;
        int i5;
        int i6;
        ArrayList<Boolean> arrayList4;
        int i7;
        boolean z2;
        boolean z3 = arrayList.get(i).s;
        ArrayList<Fragment> arrayList5 = this.M;
        if (arrayList5 == null) {
            this.M = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.M.addAll(this.i.h());
        Fragment D = D();
        boolean z4 = false;
        for (int i8 = i; i8 < i2; i8++) {
            androidx.fragment.app.a aVar = arrayList.get(i8);
            if (!arrayList2.get(i8).booleanValue()) {
                D = aVar.a(this.M, D);
            } else {
                D = aVar.b(this.M, D);
            }
            z4 = z4 || aVar.j;
        }
        this.M.clear();
        if (z3 || this.c < 1) {
            r1 = 1;
        } else if (f612a) {
            for (int i9 = i; i9 < i2; i9++) {
                Iterator<s.a> it = arrayList.get(i9).d.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.i.a(i(fragment));
                    }
                }
            }
            r1 = 1;
        } else {
            r1 = 1;
            t.a(this.v.g(), this.w, arrayList, arrayList2, i, i2, false, this.s);
        }
        b(arrayList, arrayList2, i, i2);
        if (f612a) {
            boolean booleanValue = arrayList2.get(i2 - 1).booleanValue();
            for (int i10 = i; i10 < i2; i10++) {
                androidx.fragment.app.a aVar2 = arrayList.get(i10);
                if (booleanValue) {
                    for (int size = aVar2.d.size() - r1; size >= 0; size--) {
                        Fragment fragment2 = aVar2.d.get(size).b;
                        if (fragment2 != null) {
                            i(fragment2).c();
                        }
                    }
                } else {
                    Iterator<s.a> it2 = aVar2.d.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = it2.next().b;
                        if (fragment3 != null) {
                            i(fragment3).c();
                        }
                    }
                }
            }
            a(this.c, (boolean) r1);
            for (SpecialEffectsController specialEffectsController : a(arrayList, i, i2)) {
                specialEffectsController.a(booleanValue);
                specialEffectsController.b();
                specialEffectsController.d();
            }
            i7 = i2;
            arrayList4 = arrayList2;
        } else {
            if (z3) {
                androidx.b.b bVar = new androidx.b.b();
                b((androidx.b.b<Fragment>) bVar);
                i5 = 1;
                z = z3;
                i3 = i2;
                i4 = i;
                arrayList3 = arrayList2;
                i6 = a(arrayList, arrayList2, i, i2, (androidx.b.b<Fragment>) bVar);
                a((androidx.b.b<Fragment>) bVar);
            } else {
                z = z3;
                i3 = i2;
                i4 = i;
                arrayList3 = arrayList2;
                i5 = 1;
                i6 = i3;
            }
            if (i6 == i4 || !z) {
                arrayList4 = arrayList3;
                i7 = i3;
            } else {
                if (this.c >= i5) {
                    arrayList4 = arrayList3;
                    int i11 = i6;
                    i7 = i3;
                    z2 = true;
                    t.a(this.v.g(), this.w, arrayList, arrayList2, i, i11, true, this.s);
                } else {
                    arrayList4 = arrayList3;
                    i7 = i3;
                    z2 = true;
                }
                a(this.c, z2);
            }
        }
        for (int i12 = i; i12 < i7; i12++) {
            androidx.fragment.app.a aVar3 = arrayList.get(i12);
            if (arrayList4.get(i12).booleanValue() && aVar3.c >= 0) {
                aVar3.c = -1;
            }
            aVar3.a();
        }
        if (z4) {
            R();
        }
    }

    private Set<SpecialEffectsController> a(ArrayList<androidx.fragment.app.a> arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator<s.a> it = arrayList.get(i).d.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.a(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    private void a(androidx.b.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            Fragment b2 = bVar.b(i);
            if (!b2.mAdded) {
                View requireView = b2.requireView();
                b2.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, androidx.b.b<Fragment> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.g() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                g gVar = new g(aVar, booleanValue);
                this.N.add(gVar);
                aVar.a(gVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    void a(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.c >= 1) {
            t.a(this.v.g(), this.w, arrayList, arrayList2, 0, 1, true, this.s);
        }
        if (z3) {
            a(this.c, true);
        }
        for (Fragment fragment : this.i.i()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.b(fragment.mContainerId)) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    private static void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.a aVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                aVar.b(i == i2 + (-1));
            } else {
                aVar.a(1);
                aVar.f();
            }
            i++;
        }
    }

    private void w(Fragment fragment) {
        ViewGroup x = x(fragment);
        if (x == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (x.getTag(a.b.visible_removing_fragment_view_tag) == null) {
            x.setTag(a.b.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) x.getTag(a.b.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private ViewGroup x(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId > 0 && this.w.a()) {
            View a2 = this.w.a(fragment.mContainerId);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    private void b(androidx.b.b<Fragment> bVar) {
        int i = this.c;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 5);
        for (Fragment fragment : this.i.h()) {
            if (fragment.mState < min) {
                a(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void N() {
        if (f612a) {
            Iterator<SpecialEffectsController> it = P().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        } else if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).d();
            }
        }
    }

    private void O() {
        if (f612a) {
            Iterator<SpecialEffectsController> it = P().iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        } else {
            if (this.r.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.r.keySet()) {
                t(fragment);
                g(fragment);
            }
        }
    }

    private Set<SpecialEffectsController> P() {
        HashSet hashSet = new HashSet();
        Iterator<p> it = this.i.g().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().a().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.a(viewGroup, F()));
            }
        }
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean c(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.g) {
            if (this.g.isEmpty()) {
                return false;
            }
            int size = this.g.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.g.get(i).a(arrayList, arrayList2);
            }
            this.g.clear();
            this.v.h().removeCallbacks(this.P);
            return z;
        }
    }

    private void Q() {
        if (this.J) {
            this.J = false;
            K();
        }
    }

    private void R() {
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.get(i).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.fragment.app.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.add(aVar);
    }

    boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.b;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.b.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.b.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.a aVar = this.b.get(size);
                    if ((str != null && str.equals(aVar.h())) || (i >= 0 && i == aVar.c)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        androidx.fragment.app.a aVar2 = this.b.get(size);
                        if ((str == null || !str.equals(aVar2.h())) && (i < 0 || i != aVar2.c)) {
                            break;
                        }
                        size--;
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.b.size() - 1) {
                return false;
            }
            for (int size3 = this.b.size() - 1; size3 > size; size3--) {
                arrayList.add(this.b.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable l() {
        int size;
        N();
        O();
        a(true);
        this.G = true;
        this.O.a(true);
        ArrayList<FragmentState> e2 = this.i.e();
        BackStackState[] backStackStateArr = null;
        if (e2.isEmpty()) {
            if (a(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> f2 = this.i.f();
        ArrayList<androidx.fragment.app.a> arrayList = this.b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new BackStackState(this.b.get(i));
                if (a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.b.get(i));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f627a = e2;
        fragmentManagerState.b = f2;
        fragmentManagerState.c = backStackStateArr;
        fragmentManagerState.d = this.n.get();
        Fragment fragment = this.d;
        if (fragment != null) {
            fragmentManagerState.e = fragment.mWho;
        }
        fragmentManagerState.f.addAll(this.o.keySet());
        fragmentManagerState.g.addAll(this.o.values());
        fragmentManagerState.h = new ArrayList<>(this.e);
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        p pVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f627a == null) {
            return;
        }
        this.i.b();
        Iterator<FragmentState> it = fragmentManagerState.f627a.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment a2 = this.O.a(next.b);
                if (a2 != null) {
                    if (a(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + a2);
                    }
                    pVar = new p(this.t, this.i, a2, next);
                } else {
                    pVar = new p(this.t, this.i, this.v.g().getClassLoader(), E(), next);
                }
                Fragment a3 = pVar.a();
                a3.mFragmentManager = this;
                if (a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + a3.mWho + "): " + a3);
                }
                pVar.a(this.v.g().getClassLoader());
                this.i.a(pVar);
                pVar.a(this.c);
            }
        }
        for (Fragment fragment : this.O.c()) {
            if (!this.i.b(fragment.mWho)) {
                if (a(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f627a);
                }
                this.O.c(fragment);
                fragment.mFragmentManager = this;
                p pVar2 = new p(this.t, this.i, fragment);
                pVar2.a(1);
                pVar2.c();
                fragment.mRemoving = true;
                pVar2.c();
            }
        }
        this.i.a(fragmentManagerState.b);
        if (fragmentManagerState.c != null) {
            this.b = new ArrayList<>(fragmentManagerState.c.length);
            for (int i = 0; i < fragmentManagerState.c.length; i++) {
                androidx.fragment.app.a a4 = fragmentManagerState.c[i].a(this);
                if (a(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + a4.c + "): " + a4);
                    PrintWriter printWriter = new PrintWriter(new y("FragmentManager"));
                    a4.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.b.add(a4);
            }
        } else {
            this.b = null;
        }
        this.n.set(fragmentManagerState.d);
        if (fragmentManagerState.e != null) {
            this.d = d(fragmentManagerState.e);
            y(this.d);
        }
        ArrayList<String> arrayList = fragmentManagerState.f;
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Bundle bundle = fragmentManagerState.g.get(i2);
                bundle.setClassLoader(this.v.g().getClassLoader());
                this.o.put(arrayList.get(i2), bundle);
            }
        }
        this.e = new ArrayDeque<>(fragmentManagerState.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i<?> m() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment n() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.e o() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r p() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void a(i<?> iVar, androidx.fragment.app.e eVar, final Fragment fragment) {
        String str;
        if (this.v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.v = iVar;
        this.w = eVar;
        this.x = fragment;
        if (this.x != null) {
            a(new n() { // from class: androidx.fragment.app.FragmentManager.10
                @Override // androidx.fragment.app.n
                public void a(FragmentManager fragmentManager, Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (iVar instanceof n) {
            a((n) iVar);
        }
        if (this.x != null) {
            J();
        }
        if (iVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) iVar;
            this.l = cVar.getOnBackPressedDispatcher();
            Fragment fragment2 = cVar;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.l.a(fragment2, this.m);
        }
        if (fragment != null) {
            this.O = fragment.mFragmentManager.s(fragment);
        } else if (iVar instanceof androidx.lifecycle.y) {
            this.O = m.a(((androidx.lifecycle.y) iVar).getViewModelStore());
        } else {
            this.O = new m(false);
        }
        this.O.a(i());
        this.i.a(this.O);
        Object obj = this.v;
        if (obj instanceof androidx.activity.result.d) {
            androidx.activity.result.c activityResultRegistry = ((androidx.activity.result.d) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + CertificateUtil.DELIMITER;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.C = activityResultRegistry.a(str2 + "StartActivityForResult", new b.C0023b(), new androidx.activity.result.a<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.11
                @Override // androidx.activity.result.a
                public void a(ActivityResult activityResult) {
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No Activities were started for result for " + this);
                        return;
                    }
                    String str3 = pollFirst.f624a;
                    int i = pollFirst.b;
                    Fragment d2 = FragmentManager.this.i.d(str3);
                    if (d2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                        return;
                    }
                    d2.onActivityResult(i, activityResult.a(), activityResult.b());
                }
            });
            this.D = activityResultRegistry.a(str2 + "StartIntentSenderForResult", new b(), new androidx.activity.result.a<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.2
                @Override // androidx.activity.result.a
                public void a(ActivityResult activityResult) {
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No IntentSenders were started for " + this);
                        return;
                    }
                    String str3 = pollFirst.f624a;
                    int i = pollFirst.b;
                    Fragment d2 = FragmentManager.this.i.d(str3);
                    if (d2 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                        return;
                    }
                    d2.onActivityResult(i, activityResult.a(), activityResult.b());
                }
            });
            this.E = activityResultRegistry.a(str2 + "RequestPermissions", new b.a(), new androidx.activity.result.a<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.3
                @Override // androidx.activity.result.a
                @SuppressLint({"SyntheticAccessor"})
                public void a(Map<String, Boolean> map) {
                    String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map.values());
                    int[] iArr = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                    }
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.e.pollFirst();
                    if (pollFirst == null) {
                        Log.w("FragmentManager", "No permissions were requested for " + this);
                        return;
                    }
                    String str3 = pollFirst.f624a;
                    int i2 = pollFirst.b;
                    Fragment d2 = FragmentManager.this.i.d(str3);
                    if (d2 == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str3);
                        return;
                    }
                    d2.onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        if (this.v == null) {
            return;
        }
        this.G = false;
        this.H = false;
        this.O.a(false);
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (this.C != null) {
            this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.C.a(intent);
            return;
        }
        this.v.a(fragment, intent, i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.D != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (a(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            } else {
                intent2 = intent;
            }
            IntentSenderRequest a2 = new IntentSenderRequest.a(intentSender).a(intent2).a(i3, i2).a();
            this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            if (a(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.D.a(a2);
            return;
        }
        this.v.a(fragment, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, String[] strArr, int i) {
        if (this.E != null) {
            this.e.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            this.E.a(strArr);
            return;
        }
        this.v.a(fragment, strArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        f(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        f(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.H = true;
        this.O.a(true);
        f(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        f(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.I = true;
        a(true);
        O();
        f(-1);
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.l != null) {
            this.m.b();
            this.l = null;
        }
        androidx.activity.result.b<Intent> bVar = this.C;
        if (bVar != null) {
            bVar.a();
            this.D.a();
            this.E.a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void f(int i) {
        try {
            this.h = true;
            this.i.a(i);
            a(i, false);
            if (f612a) {
                Iterator<SpecialEffectsController> it = P().iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.h = false;
            a(true);
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.c < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && b(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                Fragment fragment2 = this.j.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.j = arrayList;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Menu menu) {
        boolean z = false;
        if (this.c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && b(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MenuItem menuItem) {
        if (this.c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(MenuItem menuItem) {
        if (this.c < 1) {
            return false;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Menu menu) {
        if (this.c < 1) {
            return;
        }
        for (Fragment fragment : this.i.h()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        if (fragment != null && (!fragment.equals(d(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.d;
        this.d = fragment;
        y(fragment2);
        y(this.d);
    }

    private void y(Fragment fragment) {
        if (fragment == null || !fragment.equals(d(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        J();
        y(this.d);
    }

    public Fragment D() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(d(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public h E() {
        h hVar = this.y;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.x;
        if (fragment != null) {
            return fragment.mFragmentManager.E();
        }
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z F() {
        z zVar = this.A;
        if (zVar != null) {
            return zVar;
        }
        Fragment fragment = this.x;
        if (fragment != null) {
            return fragment.mFragmentManager.F();
        }
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k G() {
        return this.t;
    }

    public void a(n nVar) {
        this.u.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Fragment fragment) {
        Iterator<n> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    boolean H() {
        boolean z = false;
        for (Fragment fragment : this.i.i()) {
            if (fragment != null) {
                z = z(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean z(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Fragment fragment) {
        if (fragment.mAdded && z(fragment)) {
            this.F = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 I() {
        return this.k;
    }

    /* loaded from: classes.dex */
    private class f implements e {

        /* renamed from: a, reason: collision with root package name */
        final String f625a;
        final int b;
        final int c;

        f(String str, int i, int i2) {
            this.f625a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.e
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManager.this.d == null || this.b >= 0 || this.f625a != null || !FragmentManager.this.d.getChildFragmentManager().e()) {
                return FragmentManager.this.a(arrayList, arrayList2, this.f625a, this.b, this.c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g implements Fragment.c {

        /* renamed from: a, reason: collision with root package name */
        final boolean f626a;
        final androidx.fragment.app.a b;
        private int c;

        g(androidx.fragment.app.a aVar, boolean z) {
            this.f626a = z;
            this.b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.c
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.b.f641a.j();
        }

        @Override // androidx.fragment.app.Fragment.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        void d() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.f641a.g()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.b.f641a.a(this.b, this.f626a, !z, true);
        }

        void e() {
            this.b.f641a.a(this.b, this.f626a, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() { // from class: androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        String f624a;
        int b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        LaunchedFragmentInfo(String str, int i) {
            this.f624a = str;
            this.b = i;
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f624a = parcel.readString();
            this.b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f624a);
            parcel.writeInt(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends androidx.activity.result.a.a<IntentSenderRequest, ActivityResult> {
        b() {
        }

        @Override // androidx.activity.result.a.a
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent b = intentSenderRequest.b();
            if (b != null && (bundleExtra = b.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                b.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (b.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.a()).a(null).a(intentSenderRequest.d(), intentSenderRequest.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.a.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult a(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }
}
