package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.b.a;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final android.support.b.b f392a;
    private final ComponentName b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(android.support.b.b bVar, ComponentName componentName) {
        this.f392a = bVar;
        this.b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public static boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new d() { // from class: androidx.browser.customtabs.b.1
                @Override // android.content.ServiceConnection
                public final void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // androidx.browser.customtabs.d
                public final void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
                    bVar.a(0L);
                    applicationContext.unbindService(this);
                }
            });
        } catch (SecurityException unused) {
            return false;
        }
    }

    public boolean a(long j) {
        try {
            return this.f392a.a(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public e a(final a aVar) {
        a.AbstractBinderC0007a abstractBinderC0007a = new a.AbstractBinderC0007a() { // from class: androidx.browser.customtabs.b.2
            private Handler c = new Handler(Looper.getMainLooper());

            @Override // android.support.b.a
            public void a(final int i, final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, bundle);
                    }
                });
            }

            @Override // android.support.b.a
            public void a(final String str, final Bundle bundle) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(str, bundle);
                    }
                });
            }

            @Override // android.support.b.a
            public void a(final Bundle bundle) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(bundle);
                    }
                });
            }

            @Override // android.support.b.a
            public void b(final String str, final Bundle bundle) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.b(str, bundle);
                    }
                });
            }

            @Override // android.support.b.a
            public void a(final int i, final Uri uri, final boolean z, final Bundle bundle) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, uri, z, bundle);
                    }
                });
            }
        };
        try {
            if (this.f392a.a(abstractBinderC0007a)) {
                return new e(this.f392a, abstractBinderC0007a, this.b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
