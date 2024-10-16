package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final i<?> f668a;

    public static g a(i<?> iVar) {
        return new g((i) androidx.core.e.e.a(iVar, "callbacks == null"));
    }

    private g(i<?> iVar) {
        this.f668a = iVar;
    }

    public FragmentManager a() {
        return this.f668a.b;
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManager = this.f668a.b;
        i<?> iVar = this.f668a;
        fragmentManager.a(iVar, iVar, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f668a.b.I().onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.f668a.b.q();
    }

    public Parcelable c() {
        return this.f668a.b.l();
    }

    public void a(Parcelable parcelable) {
        i<?> iVar = this.f668a;
        if (!(iVar instanceof androidx.lifecycle.y)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iVar.b.a(parcelable);
    }

    public void d() {
        this.f668a.b.s();
    }

    public void e() {
        this.f668a.b.u();
    }

    public void f() {
        this.f668a.b.v();
    }

    public void g() {
        this.f668a.b.w();
    }

    public void h() {
        this.f668a.b.x();
    }

    public void i() {
        this.f668a.b.y();
    }

    public void j() {
        this.f668a.b.A();
    }

    public void a(boolean z) {
        this.f668a.b.b(z);
    }

    public void b(boolean z) {
        this.f668a.b.c(z);
    }

    public void a(Configuration configuration) {
        this.f668a.b.a(configuration);
    }

    public void k() {
        this.f668a.b.B();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f668a.b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.f668a.b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.f668a.b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.f668a.b.b(menuItem);
    }

    public void b(Menu menu) {
        this.f668a.b.b(menu);
    }

    public boolean l() {
        return this.f668a.b.a(true);
    }
}
