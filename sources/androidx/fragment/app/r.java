package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.amazonaws.services.s3.internal.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f679a = new ArrayList<>();
    private final HashMap<String, p> b = new HashMap<>();
    private m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(m mVar) {
        this.c = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<String> list) {
        this.f679a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment e = e(str);
                if (e == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + e);
                }
                a(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        Fragment a2 = pVar.a();
        if (b(a2.mWho)) {
            return;
        }
        this.b.put(a2.mWho, pVar);
        if (a2.mRetainInstanceChangedWhileDetached) {
            if (a2.mRetainInstance) {
                this.c.a(a2);
            } else {
                this.c.c(a2);
            }
            a2.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f679a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f679a) {
            this.f679a.add(fragment);
        }
        fragment.mAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                pVar.a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Iterator<Fragment> it = this.f679a.iterator();
        while (it.hasNext()) {
            p pVar = this.b.get(it.next().mWho);
            if (pVar != null) {
                pVar.c();
            }
        }
        for (p pVar2 : this.b.values()) {
            if (pVar2 != null) {
                pVar2.c();
                Fragment a2 = pVar2.a();
                if (a2.mRemoving && !a2.isInBackStack()) {
                    b(pVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        synchronized (this.f679a) {
            this.f679a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(p pVar) {
        Fragment a2 = pVar.a();
        if (a2.mRetainInstance) {
            this.c.c(a2);
        }
        if (this.b.put(a2.mWho, null) != null && FragmentManager.a(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<FragmentState> e() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.b.size());
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                Fragment a2 = pVar.a();
                FragmentState m = pVar.m();
                arrayList.add(m);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Saved state of " + a2 + ": " + m.m);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ArrayList<String> f() {
        synchronized (this.f679a) {
            if (this.f679a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f679a.size());
            Iterator<Fragment> it = this.f679a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<p> g() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> h() {
        ArrayList arrayList;
        if (this.f679a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f679a) {
            arrayList = new ArrayList(this.f679a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> i() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                arrayList.add(pVar.a());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(int i) {
        for (int size = this.f679a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f679a.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                Fragment a2 = pVar.a();
                if (a2.mFragmentId == i) {
                    return a2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f679a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f679a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (p pVar : this.b.values()) {
            if (pVar != null) {
                Fragment a2 = pVar.a();
                if (str.equals(a2.mTag)) {
                    return a2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        return this.b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p c(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment d(String str) {
        Fragment findFragmentByWho;
        for (p pVar : this.b.values()) {
            if (pVar != null && (findFragmentByWho = pVar.a().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment e(String str) {
        p pVar = this.b.get(str);
        if (pVar != null) {
            return pVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f679a.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = this.f679a.get(i);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return viewGroup.indexOfChild(fragment2.mView) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f679a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f679a.get(indexOf);
            if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                return viewGroup.indexOfChild(fragment3.mView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p pVar : this.b.values()) {
                printWriter.print(str);
                if (pVar != null) {
                    Fragment a2 = pVar.a();
                    printWriter.println(a2);
                    a2.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(Constants.NULL_VERSION_ID);
                }
            }
        }
        int size = this.f679a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                Fragment fragment = this.f679a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }
}
