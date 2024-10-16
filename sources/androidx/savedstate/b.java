package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import androidx.lifecycle.k;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class b {
    private Bundle c;
    private boolean d;
    private Recreator.a e;
    private androidx.a.a.b.b<String, InterfaceC0068b> b = new androidx.a.a.b.b<>();

    /* renamed from: a, reason: collision with root package name */
    boolean f912a = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar);
    }

    /* renamed from: androidx.savedstate.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.c.remove(str);
        if (this.c.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public void a(String str, InterfaceC0068b interfaceC0068b) {
        if (this.b.a(str, interfaceC0068b) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void a(Class<? extends a> cls) {
        if (!this.f912a) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.e == null) {
            this.e = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.e.a(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle lifecycle, Bundle bundle) {
        if (this.d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        lifecycle.a(new f() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.i
            public void a(k kVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    b.this.f912a = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    b.this.f912a = false;
                }
            }
        });
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.a.a.b.b<String, InterfaceC0068b>.d c = this.b.c();
        while (c.hasNext()) {
            Map.Entry next = c.next();
            bundle2.putBundle((String) next.getKey(), ((InterfaceC0068b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
