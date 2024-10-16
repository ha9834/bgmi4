package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.b.c;

/* loaded from: classes.dex */
public class PostMessageService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private c.a f390a = new c.a() { // from class: androidx.browser.customtabs.PostMessageService.1
        @Override // android.support.b.c
        public void a(android.support.b.a aVar, Bundle bundle) throws RemoteException {
            aVar.a(bundle);
        }

        @Override // android.support.b.c
        public void a(android.support.b.a aVar, String str, Bundle bundle) throws RemoteException {
            aVar.b(str, bundle);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f390a;
    }
}
