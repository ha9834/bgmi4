package com.subao.common.k;

import android.content.Context;
import android.net.NetworkInfo;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.net.DatagramSocket;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static n f6109a = new c(1000);

    /* loaded from: classes2.dex */
    public interface a {
        void b(b bVar);

        void c(b bVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        NetworkInfo a(Context context);

        void a(DatagramSocket datagramSocket);
    }

    /* loaded from: classes2.dex */
    public enum e {
        CELLULAR,
        WIFI,
        BLUETOOTH,
        ETHERNET,
        VPN
    }

    private static synchronized void a(n nVar) {
        synchronized (m.class) {
            if (f6109a != null) {
                f6109a.a();
            }
            f6109a = nVar;
        }
    }

    public static void a(Context context) {
        int i;
        if (!r.a()) {
            i = 2000;
        } else {
            if (r.b() || b(context)) {
                a((n) new o(context));
                return;
            }
            i = GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE;
        }
        a((n) new c(i));
        throw new d(i);
    }

    static boolean b(Context context) {
        boolean z = context.getPackageManager().checkPermission("android.permission.CHANGE_NETWORK_STATE", context.getPackageName()) == 0;
        if (!z) {
            com.subao.common.d.a("SubaoParallel", "Has not required permission: CHANGE_NETWORK_STATE");
        }
        return z;
    }

    public static Object a(e eVar, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Callback cannot be null");
        }
        return f6109a.a(eVar, aVar);
    }

    public static void a(Object obj) {
        f6109a.a(obj);
    }

    /* loaded from: classes2.dex */
    public static class d extends IOException {

        /* renamed from: a, reason: collision with root package name */
        private final int f6111a;

        public d(int i) {
            super("Cellular Operation Exception, Error " + i);
            this.f6111a = i;
        }

        public int a() {
            return this.f6111a;
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements n {

        /* renamed from: a, reason: collision with root package name */
        private final int f6110a;

        @Override // com.subao.common.a
        public void a() {
        }

        @Override // com.subao.common.k.n
        public void a(Object obj) {
        }

        c(int i) {
            this.f6110a = i;
        }

        @Override // com.subao.common.k.n
        public Object a(e eVar, a aVar) {
            throw new d(this.f6110a);
        }
    }
}
