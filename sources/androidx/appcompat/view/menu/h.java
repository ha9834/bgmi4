package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.a;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {

    /* renamed from: a, reason: collision with root package name */
    e f237a;
    private g b;
    private androidx.appcompat.app.c c;
    private m.a d;

    public h(g gVar) {
        this.b = gVar;
    }

    public void a(IBinder iBinder) {
        g gVar = this.b;
        c.a aVar = new c.a(gVar.f());
        this.f237a = new e(aVar.a(), a.g.abc_list_menu_item_layout);
        this.f237a.a(this);
        this.b.a(this.f237a);
        aVar.a(this.f237a.a(), this);
        View p = gVar.p();
        if (p != null) {
            aVar.a(p);
        } else {
            aVar.a(gVar.o()).a(gVar.n());
        }
        aVar.a(this);
        this.c = aVar.b();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.c;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f237a.a(this.b, true);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void a(g gVar, boolean z) {
        if (z || gVar == this.b) {
            a();
        }
        m.a aVar = this.d;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(g gVar) {
        m.a aVar = this.d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((i) this.f237a.a().getItem(i), 0);
    }
}
