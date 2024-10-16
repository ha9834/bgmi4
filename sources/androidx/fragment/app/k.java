package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f673a = new CopyOnWriteArrayList<>();
    private final FragmentManager b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final FragmentManager.c f674a;
        final boolean b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FragmentManager fragmentManager) {
        this.b = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z) {
        Context g = this.b.m().g();
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().a(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.a(this.b, fragment, g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z) {
        Context g = this.b.m().g();
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().b(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.b(this.b, fragment, g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.a(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().b(fragment, bundle, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.b(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.c(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().a(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.a(this.b, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().c(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.a(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().d(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.b(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().e(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.c(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().f(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.d(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().d(fragment, bundle, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.d(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().g(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.e(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().h(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.f(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment n = this.b.n();
        if (n != null) {
            n.getParentFragmentManager().G().i(fragment, true);
        }
        Iterator<a> it = this.f673a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.f674a.g(this.b, fragment);
            }
        }
    }
}
