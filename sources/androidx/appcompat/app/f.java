package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.core.f.e;

/* loaded from: classes.dex */
public class f extends Dialog implements d {

    /* renamed from: a, reason: collision with root package name */
    private e f180a;
    private final e.a b;

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeFinished(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeStarted(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public f(Context context, int i) {
        super(context, a(context, i));
        this.b = new e.a() { // from class: androidx.appcompat.app.f.1
            @Override // androidx.core.f.e.a
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return f.this.a(keyEvent);
            }
        };
        e b = b();
        b.a(a(context, i));
        b.a((Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        b().i();
        super.onCreate(bundle);
        b().a(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        b().c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        b().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) b().b(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        b().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        b().d();
    }

    public boolean a(int i) {
        return b().d(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        b().f();
    }

    public e b() {
        if (this.f180a == null) {
            this.f180a = e.a(this, this);
        }
        return this.f180a;
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0024a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.f.e.a(this.b, getWindow().getDecorView(), this, keyEvent);
    }
}
