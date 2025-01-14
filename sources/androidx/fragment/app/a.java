package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends s implements FragmentManager.a, FragmentManager.e {

    /* renamed from: a, reason: collision with root package name */
    final FragmentManager f641a;
    boolean b;
    int c;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.c >= 0) {
            sb.append(" #");
            sb.append(this.c);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.b);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.m != 0 || this.n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (this.o != 0 || this.p != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (this.d.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            s.a aVar = this.d.get(i);
            switch (aVar.f681a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f681a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentManager fragmentManager) {
        super(fragmentManager.E(), fragmentManager.m() != null ? fragmentManager.m().g().getClassLoader() : null);
        this.c = -1;
        this.f641a = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.s
    public void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.mFragmentManager = this.f641a;
    }

    @Override // androidx.fragment.app.s
    public s a(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.f641a) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.a(fragment);
    }

    @Override // androidx.fragment.app.s
    public s b(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.f641a) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.b(fragment);
    }

    @Override // androidx.fragment.app.s
    public s a(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f641a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f641a);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state == Lifecycle.State.DESTROYED) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        return super.a(fragment, state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.j) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                s.a aVar = this.d.get(i2);
                if (aVar.b != null) {
                    aVar.b.mBackStackNesting += i;
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void a() {
        if (this.t != null) {
            for (int i = 0; i < this.t.size(); i++) {
                this.t.get(i).run();
            }
            this.t = null;
        }
    }

    @Override // androidx.fragment.app.s
    public int b() {
        return a(false);
    }

    @Override // androidx.fragment.app.s
    public int c() {
        return a(true);
    }

    @Override // androidx.fragment.app.s
    public void d() {
        i();
        this.f641a.b((FragmentManager.e) this, false);
    }

    @Override // androidx.fragment.app.s
    public void e() {
        i();
        this.f641a.b((FragmentManager.e) this, true);
    }

    int a(boolean z) {
        if (this.b) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new y("FragmentManager"));
            a("  ", printWriter);
            printWriter.close();
        }
        this.b = true;
        if (this.j) {
            this.c = this.f641a.k();
        } else {
            this.c = -1;
        }
        this.f641a.a(this, z);
        return this.c;
    }

    @Override // androidx.fragment.app.FragmentManager.e
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.j) {
            return true;
        }
        this.f641a.a(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            s.a aVar = this.d.get(i2);
            int i3 = aVar.b != null ? aVar.b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            s.a aVar = this.d.get(i4);
            int i5 = aVar.b != null ? aVar.b.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar2 = arrayList.get(i6);
                    int size2 = aVar2.d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        s.a aVar3 = aVar2.d.get(i7);
                        if ((aVar3.b != null ? aVar3.b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            s.a aVar = this.d.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.i);
                fragment.setSharedElementNames(this.q, this.r);
            }
            int i2 = aVar.f681a;
            if (i2 == 1) {
                fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                this.f641a.a(fragment, false);
                this.f641a.j(fragment);
            } else {
                switch (i2) {
                    case 3:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.k(fragment);
                        break;
                    case 4:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.l(fragment);
                        break;
                    case 5:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.a(fragment, false);
                        this.f641a.m(fragment);
                        break;
                    case 6:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.n(fragment);
                        break;
                    case 7:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.a(fragment, false);
                        this.f641a.o(fragment);
                        break;
                    case 8:
                        this.f641a.p(fragment);
                        break;
                    case 9:
                        this.f641a.p(null);
                        break;
                    case 10:
                        this.f641a.a(fragment, aVar.h);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f681a);
                }
            }
            if (!this.s && aVar.f681a != 1 && fragment != null && !FragmentManager.f612a) {
                this.f641a.h(fragment);
            }
        }
        if (this.s || FragmentManager.f612a) {
            return;
        }
        FragmentManager fragmentManager = this.f641a;
        fragmentManager.a(fragmentManager.c, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            s.a aVar = this.d.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.e(this.i));
                fragment.setSharedElementNames(this.r, this.q);
            }
            int i = aVar.f681a;
            if (i == 1) {
                fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                this.f641a.a(fragment, true);
                this.f641a.k(fragment);
            } else {
                switch (i) {
                    case 3:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.j(fragment);
                        break;
                    case 4:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.m(fragment);
                        break;
                    case 5:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.a(fragment, true);
                        this.f641a.l(fragment);
                        break;
                    case 6:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.o(fragment);
                        break;
                    case 7:
                        fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                        this.f641a.a(fragment, true);
                        this.f641a.n(fragment);
                        break;
                    case 8:
                        this.f641a.p(null);
                        break;
                    case 9:
                        this.f641a.p(fragment);
                        break;
                    case 10:
                        this.f641a.a(fragment, aVar.g);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f681a);
                }
            }
            if (!this.s && aVar.f681a != 3 && fragment != null && !FragmentManager.f612a) {
                this.f641a.h(fragment);
            }
        }
        if (this.s || !z || FragmentManager.f612a) {
            return;
        }
        FragmentManager fragmentManager = this.f641a;
        fragmentManager.a(fragmentManager.c, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.d.size()) {
            s.a aVar = this.d.get(i);
            switch (aVar.f681a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    Fragment fragment3 = aVar.b;
                    int i2 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.mContainerId == i2) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.d.add(i3, new s.a(9, fragment5));
                                    i3++;
                                    fragment4 = null;
                                }
                                s.a aVar2 = new s.a(3, fragment5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.d.add(i3, aVar2);
                                arrayList.remove(fragment5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.d.remove(i3);
                        i = i3 - 1;
                    } else {
                        aVar.f681a = 1;
                        arrayList.add(fragment3);
                        i = i3;
                    }
                    fragment2 = fragment4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b == fragment2) {
                        this.d.add(i, new s.a(9, aVar.b));
                        i++;
                        fragment2 = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.d.add(i, new s.a(9, fragment2));
                    i++;
                    fragment2 = aVar.b;
                    break;
            }
            i++;
        }
        return fragment2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            s.a aVar = this.d.get(size);
            int i = aVar.f681a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.b;
                            break;
                        case 10:
                            aVar.h = aVar.g;
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        for (int i = 0; i < this.d.size(); i++) {
            if (b(this.d.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment.c cVar) {
        for (int i = 0; i < this.d.size(); i++) {
            s.a aVar = this.d.get(i);
            if (b(aVar)) {
                aVar.b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    private static boolean b(s.a aVar) {
        Fragment fragment = aVar.b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentManager.a
    public String h() {
        return this.l;
    }
}
