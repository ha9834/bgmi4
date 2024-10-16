package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.av;
import androidx.core.f.v;
import java.util.ArrayList;

/* loaded from: classes.dex */
class i extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    ab f183a;
    boolean b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new Runnable() { // from class: androidx.appcompat.app.i.1
        @Override // java.lang.Runnable
        public void run() {
            i.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c() { // from class: androidx.appcompat.app.i.2
        @Override // androidx.appcompat.widget.Toolbar.c
        public boolean a(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f183a = new av(toolbar, false);
        this.c = new c(callback);
        this.f183a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f183a.a(charSequence);
    }

    public Window.Callback h() {
        return this.c;
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        v.a(this.f183a.a(), f);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        return this.f183a.b();
    }

    @Override // androidx.appcompat.app.a
    public void a(int i) {
        this.f183a.d(i);
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.f183a.b(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void b(CharSequence charSequence) {
        this.f183a.a(charSequence);
    }

    public void a(int i, int i2) {
        this.f183a.c((i & i2) | ((i2 ^ (-1)) & this.f183a.o()));
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.f183a.o();
    }

    @Override // androidx.appcompat.app.a
    public boolean c() {
        return this.f183a.k();
    }

    @Override // androidx.appcompat.app.a
    public boolean d() {
        return this.f183a.l();
    }

    @Override // androidx.appcompat.app.a
    public boolean e() {
        this.f183a.a().removeCallbacks(this.g);
        v.a(this.f183a.a(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        if (!this.f183a.c()) {
            return false;
        }
        this.f183a.d();
        return true;
    }

    void i() {
        Menu j = j();
        androidx.appcompat.view.menu.g gVar = j instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) j : null;
        if (gVar != null) {
            gVar.h();
        }
        try {
            j.clear();
            if (!this.c.onCreatePanelMenu(0, j) || !this.c.onPreparePanel(0, null, j)) {
                j.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.i();
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void g() {
        this.f183a.a().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
        if (z == this.e) {
            return;
        }
        this.e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).a(z);
        }
    }

    /* loaded from: classes.dex */
    private class c extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !i.this.b) {
                i.this.f183a.m();
                i.this.b = true;
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(i.this.f183a.b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu j() {
        if (!this.d) {
            this.f183a.a(new a(), new b());
            this.d = true;
        }
        return this.f183a.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements m.a {
        private boolean b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (i.this.c == null) {
                return false;
            }
            i.this.c.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.b) {
                return;
            }
            this.b = true;
            i.this.f183a.n();
            if (i.this.c != null) {
                i.this.c.onPanelClosed(108, gVar);
            }
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (i.this.c != null) {
                if (i.this.f183a.i()) {
                    i.this.c.onPanelClosed(108, gVar);
                } else if (i.this.c.onPreparePanel(0, null, gVar)) {
                    i.this.c.onMenuOpened(108, gVar);
                }
            }
        }
    }
}
