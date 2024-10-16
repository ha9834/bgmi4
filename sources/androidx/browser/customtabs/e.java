package androidx.browser.customtabs;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f403a = new Object();
    private final android.support.b.b b;
    private final android.support.b.a c;
    private final ComponentName d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(android.support.b.b bVar, android.support.b.a aVar, ComponentName componentName) {
        this.b = bVar;
        this.c = aVar;
        this.d = componentName;
    }

    public boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.b.a(this.c, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentName b() {
        return this.d;
    }
}
