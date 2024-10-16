package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends androidx.lifecycle.v {

    /* renamed from: a, reason: collision with root package name */
    private static final w.b f675a = new w.b() { // from class: androidx.fragment.app.m.1
        @Override // androidx.lifecycle.w.b
        public <T extends androidx.lifecycle.v> T a(Class<T> cls) {
            return new m(true);
        }
    };
    private final boolean e;
    private final HashMap<String, Fragment> b = new HashMap<>();
    private final HashMap<String, m> c = new HashMap<>();
    private final HashMap<String, androidx.lifecycle.x> d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(androidx.lifecycle.x xVar) {
        return (m) new androidx.lifecycle.w(xVar, f675a).a(m.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.v
    public void a() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.containsKey(fragment.mWho)) {
                return;
            }
            this.b.put(fragment.mWho, fragment);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> c() {
        return new ArrayList(this.b.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (!this.b.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.e) {
            return this.f;
        }
        return !this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.b.remove(fragment.mWho) != null) && FragmentManager.a(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m d(Fragment fragment) {
        m mVar = this.c.get(fragment.mWho);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this.e);
        this.c.put(fragment.mWho, mVar2);
        return mVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.x e(Fragment fragment) {
        androidx.lifecycle.x xVar = this.d.get(fragment.mWho);
        if (xVar != null) {
            return xVar;
        }
        androidx.lifecycle.x xVar2 = new androidx.lifecycle.x();
        this.d.put(fragment.mWho, xVar2);
        return xVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        m mVar = this.c.get(fragment.mWho);
        if (mVar != null) {
            mVar.a();
            this.c.remove(fragment.mWho);
        }
        androidx.lifecycle.x xVar = this.d.get(fragment.mWho);
        if (xVar != null) {
            xVar.b();
            this.d.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.b.equals(mVar.b) && this.c.equals(mVar.c) && this.d.equals(mVar.d);
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
