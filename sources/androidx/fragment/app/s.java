package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private final h f680a;
    private final ClassLoader b;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    String l;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    ArrayList<Runnable> t;
    ArrayList<a> d = new ArrayList<>();
    boolean k = true;
    boolean s = false;

    public abstract int b();

    public abstract int c();

    public abstract void d();

    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f681a;
        Fragment b;
        int c;
        int d;
        int e;
        int f;
        Lifecycle.State g;
        Lifecycle.State h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, Fragment fragment) {
            this.f681a = i;
            this.b = fragment;
            this.g = Lifecycle.State.RESUMED;
            this.h = Lifecycle.State.RESUMED;
        }

        a(int i, Fragment fragment, Lifecycle.State state) {
            this.f681a = i;
            this.b = fragment;
            this.g = fragment.mMaxState;
            this.h = state;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(h hVar, ClassLoader classLoader) {
        this.f680a = hVar;
        this.b = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.d.add(aVar);
        aVar.c = this.e;
        aVar.d = this.f;
        aVar.e = this.g;
        aVar.f = this.h;
    }

    public s a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public s a(int i, Fragment fragment) {
        a(i, fragment, (String) null, 1);
        return this;
    }

    public s a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s a(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return a(viewGroup.getId(), fragment, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        a(new a(i2, fragment));
    }

    public s b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    public s a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public s b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public s c(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public s a(Fragment fragment, Lifecycle.State state) {
        a(new a(10, fragment, state));
        return this;
    }

    public s a(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        return this;
    }

    public s a(String str) {
        if (!this.k) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.j = true;
        this.l = str;
        return this;
    }

    public s i() {
        if (this.j) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.k = false;
        return this;
    }

    public s c(boolean z) {
        this.s = z;
        return this;
    }
}
