package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    final android.support.b.a f404a;
    private final a b = new a() { // from class: androidx.browser.customtabs.f.1
        @Override // androidx.browser.customtabs.a
        public void a(int i, Bundle bundle) {
            try {
                f.this.f404a.a(i, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(String str, Bundle bundle) {
            try {
                f.this.f404a.a(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(Bundle bundle) {
            try {
                f.this.f404a.a(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void b(String str, Bundle bundle) {
            try {
                f.this.f404a.b(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                f.this.f404a.a(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(android.support.b.a aVar) {
        this.f404a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.f404a.asBinder();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).a().equals(this.f404a.asBinder());
        }
        return false;
    }
}
