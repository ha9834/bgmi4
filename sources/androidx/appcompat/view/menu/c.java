package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f226a;
    private Map<androidx.core.a.a.b, MenuItem> b;
    private Map<androidx.core.a.a.c, SubMenu> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f226a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof androidx.core.a.a.b)) {
            return menuItem;
        }
        androidx.core.a.a.b bVar = (androidx.core.a.a.b) menuItem;
        if (this.b == null) {
            this.b = new androidx.b.a();
        }
        MenuItem menuItem2 = this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f226a, bVar);
        this.b.put(bVar, jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.a.a.c)) {
            return subMenu;
        }
        androidx.core.a.a.c cVar = (androidx.core.a.a.c) subMenu;
        if (this.c == null) {
            this.c = new androidx.b.a();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f226a, cVar);
        this.c.put(cVar, sVar);
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Map<androidx.core.a.a.b, MenuItem> map = this.b;
        if (map != null) {
            map.clear();
        }
        Map<androidx.core.a.a.c, SubMenu> map2 = this.c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        Map<androidx.core.a.a.b, MenuItem> map = this.b;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.a.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        Map<androidx.core.a.a.b, MenuItem> map = this.b;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.a.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
