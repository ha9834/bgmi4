package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.b.b;

/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {
    public abstract void onCustomTabsServiceConnected(ComponentName componentName, b bVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onCustomTabsServiceConnected(componentName, new b(b.a.a(iBinder), componentName) { // from class: androidx.browser.customtabs.d.1
        });
    }
}
