package com.shieldtunnel.svpn.common.f;

import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.b;
import com.shieldtunnel.svpn.common.f.k;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final k.b f5801a;
    private final com.shieldtunnel.svpn.common.jni.b b;
    private b c;
    private long d = 600000;
    private long e = 10800000;
    private c f = new c(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.shieldtunnel.svpn.common.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0150a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f5802a;

        C0150a(a aVar) {
            this.f5802a = new WeakReference<>(aVar);
        }

        @Override // com.shieldtunnel.svpn.common.f.b.a
        public void a(k.c cVar) {
            l lVar;
            if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                Log.d(LogTag.DATA, String.format("Nodes download completed: %s", cVar.toString()));
            }
            a aVar = this.f5802a.get();
            if (aVar != null) {
                c cVar2 = aVar.f;
                if (cVar2 == null) {
                    Log.d(LogTag.DATA, "Try to refresh next time, but task is null");
                }
                if (cVar.b <= 0) {
                    if (cVar2 != null) {
                        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                            Log.d(LogTag.DATA, String.format(f.b, "Retry nodes after %d seconds", Long.valueOf(aVar.d / 1000)));
                        }
                        com.shieldtunnel.svpn.common.j.b.a().a(cVar2, aVar.d);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                        Log.d(LogTag.DATA, String.format(f.b, "Refresh after %d seconds", Long.valueOf(aVar.e / 1000)));
                    }
                    com.shieldtunnel.svpn.common.j.b.a().a(cVar2, aVar.e);
                }
                if (aVar.c == null && (lVar = cVar.f5819a) != null && lVar.e && lVar.c() > 16) {
                    aVar.b.a(0, "key_node_list_update", j.c(lVar.b()));
                    return;
                }
                return;
            }
            com.shieldtunnel.svpn.common.b.a(LogTag.DATA, "Owner is null");
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f5803a;
        public final byte[] b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, byte[] bArr) {
            this.f5803a = i;
            this.b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5803a == bVar.f5803a && Arrays.equals(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.f5803a << 16) | Arrays.hashCode(this.b);
        }

        public String toString() {
            return String.format(f.b, "[Accel Nodes %d]", Integer.valueOf(this.f5803a));
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f5804a;

        c(a aVar) {
            this.f5804a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f5804a.get();
            if (aVar != null) {
                aVar.b();
            } else {
                Log.d(LogTag.DATA, "Refresh nodes task running, but owner is null");
            }
        }
    }

    public a(k.b bVar, com.shieldtunnel.svpn.common.jni.b bVar2) {
        this.f5801a = bVar;
        this.b = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a(this.b.a());
        a();
        c();
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void c() {
        m.a(this.f5801a, this.b);
    }

    public void d() {
        c cVar = this.f;
        this.f = null;
        if (cVar != null) {
            com.shieldtunnel.svpn.common.j.b.a().a(cVar);
        }
    }

    public void a(long j, long j2) {
        this.d = j;
        this.e = j2;
    }

    public byte[] a(int i) {
        l a2 = o.a(this.f5801a, i);
        byte[] b2 = a2 != null ? a2.b() : null;
        if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
            Log.d(LogTag.DATA, "PCode: " + com.shieldtunnel.svpn.common.k.e.b(b2));
        }
        return b2;
    }

    public byte[] a() {
        byte[] a2 = com.shieldtunnel.svpn.common.f.b.a(this.f5801a, new C0150a(this));
        b bVar = this.c;
        if (bVar == null) {
            return a2;
        }
        Log.w(LogTag.DATA, String.format(f.b, "Use Debug Nodes: (count=%d)", Integer.valueOf(bVar.f5803a)));
        return bVar.b;
    }
}
