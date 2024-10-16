package androidx.browser.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.b.b;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* renamed from: a, reason: collision with root package name */
    final Map<IBinder, IBinder.DeathRecipient> f387a = new androidx.b.a();
    private b.a b = new b.a() { // from class: androidx.browser.customtabs.CustomTabsService.1
        @Override // android.support.b.b
        public boolean a(long j) {
            return CustomTabsService.this.a(j);
        }

        @Override // android.support.b.b
        public boolean a(android.support.b.a aVar) {
            final f fVar = new f(aVar);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.CustomTabsService.1.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        CustomTabsService.this.a(fVar);
                    }
                };
                synchronized (CustomTabsService.this.f387a) {
                    aVar.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f387a.put(aVar.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.b(fVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.b.b
        public boolean a(android.support.b.a aVar, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.a(new f(aVar), uri, bundle, list);
        }

        @Override // android.support.b.b
        public Bundle a(String str, Bundle bundle) {
            return CustomTabsService.this.a(str, bundle);
        }

        @Override // android.support.b.b
        public boolean a(android.support.b.a aVar, Bundle bundle) {
            return CustomTabsService.this.a(new f(aVar), bundle);
        }

        @Override // android.support.b.b
        public boolean a(android.support.b.a aVar, Uri uri) {
            return CustomTabsService.this.a(new f(aVar), uri);
        }

        @Override // android.support.b.b
        public int a(android.support.b.a aVar, String str, Bundle bundle) {
            return CustomTabsService.this.a(new f(aVar), str, bundle);
        }

        @Override // android.support.b.b
        public boolean a(android.support.b.a aVar, int i, Uri uri, Bundle bundle) {
            return CustomTabsService.this.a(new f(aVar), i, uri, bundle);
        }
    };

    protected abstract int a(f fVar, String str, Bundle bundle);

    protected abstract Bundle a(String str, Bundle bundle);

    protected abstract boolean a(long j);

    protected abstract boolean a(f fVar, int i, Uri uri, Bundle bundle);

    protected abstract boolean a(f fVar, Uri uri);

    protected abstract boolean a(f fVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean a(f fVar, Bundle bundle);

    protected abstract boolean b(f fVar);

    protected boolean a(f fVar) {
        try {
            synchronized (this.f387a) {
                IBinder a2 = fVar.a();
                a2.unlinkToDeath(this.f387a.get(a2), 0);
                this.f387a.remove(a2);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}
