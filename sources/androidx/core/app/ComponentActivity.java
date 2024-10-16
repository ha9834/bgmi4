package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.f.e;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.s;

/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements e.a, androidx.lifecycle.k {
    private androidx.b.g<Class<? extends a>, a> mExtraDataMap = new androidx.b.g<>();
    private androidx.lifecycle.l mLifecycleRegistry = new androidx.lifecycle.l(this);

    @Deprecated
    /* loaded from: classes.dex */
    public static class a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.a(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.f.e.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.f.e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.f.e.a(decorView, keyEvent)) {
            return androidx.core.f.e.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
