package com.shieldtunnel.svpn.common.d;

import android.content.Context;
import android.net.VpnService;
import com.shieldtunnel.svpn.XYVpnService;
import com.shieldtunnel.svpn.common.i.i;
import com.shieldtunnel.svpn.common.jni.JniCallback;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public class d implements JniCallback {

    /* renamed from: a, reason: collision with root package name */
    private final c f5794a;
    private final com.shieldtunnel.svpn.common.jni.b b;
    private final com.shieldtunnel.svpn.common.f.h c = new com.shieldtunnel.svpn.common.f.h(com.shieldtunnel.svpn.common.g.c.a(com.shieldtunnel.svpn.common.g.a.a()));

    /* loaded from: classes2.dex */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f5795a;
        private final com.shieldtunnel.svpn.common.jni.b b;
        private final Context c;
        private final byte[] d;
        private final int e;
        private final byte[] f;
        private final int g;
        private final int h;

        a(int i, com.shieldtunnel.svpn.common.jni.b bVar, Context context, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
            this.f5795a = i;
            this.b = bVar;
            this.c = context.getApplicationContext();
            this.d = bArr;
            this.e = i2;
            this.f = bArr2;
            this.g = i3;
            this.h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.f5795a, i.b.a(this.c, this.h, new InetSocketAddress(com.shieldtunnel.svpn.common.k.e.a(this.d), this.e), new InetSocketAddress(com.shieldtunnel.svpn.common.k.e.a(this.f), this.g)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.shieldtunnel.svpn.common.jni.b bVar) {
        this.f5794a = cVar;
        this.b = bVar;
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(byte[] bArr) {
        this.f5794a.a(bArr);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void b(int i, byte[] bArr, byte[] bArr2) {
        this.c.a(bArr, bArr2, this.b, i);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, byte[] bArr) {
        this.c.a(bArr, this.b, i);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void b(int i, byte[] bArr) {
        this.f5794a.a(i, bArr);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, byte[] bArr, byte[] bArr2) {
        this.c.a(bArr, bArr2);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        this.c.a(bArr, bArr2, bArr3, z);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        new com.shieldtunnel.svpn.common.i.b(this.b, i).a(i2, bArr, bArr2, bArr3, bArr4);
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (i.b.a()) {
            com.shieldtunnel.svpn.common.j.c.a(new a(i, this.b, this.f5794a.f(), bArr, i2, bArr2, i3, i4));
        } else {
            this.b.a(i, -1);
        }
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public int a(int i) {
        XYVpnService d = XYVpnService.d();
        return (d == null || d.protect(i) || VpnService.prepare(this.f5794a.f()) != null) ? 0 : -1;
    }

    @Override // com.shieldtunnel.svpn.common.jni.JniCallback
    public void a(int i, int i2, byte[] bArr) {
        this.f5794a.a(i, i2, bArr);
    }
}
