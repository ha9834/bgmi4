package androidx.core.f;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f536a;
    private a b;
    private InterfaceC0049b c;

    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z);
    }

    /* renamed from: androidx.core.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0049b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f536a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(InterfaceC0049b interfaceC0049b) {
        if (this.c != null && interfaceC0049b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = interfaceC0049b;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }
}
