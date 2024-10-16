package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import androidx.lifecycle.k;
import androidx.savedstate.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements f {

    /* renamed from: a, reason: collision with root package name */
    private final d f909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Recreator(d dVar) {
        this.f909a = dVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.i
    public void a(k kVar, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        kVar.getLifecycle().b(this);
        Bundle a2 = this.f909a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (a2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(b.a.class);
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((b.a) declaredConstructor.newInstance(new Object[0])).a(this.f909a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements b.InterfaceC0068b {

        /* renamed from: a, reason: collision with root package name */
        final Set<String> f910a = new HashSet();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(b bVar) {
            bVar.a("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.b.InterfaceC0068b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f910a));
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str) {
            this.f910a.add(str);
        }
    }
}
