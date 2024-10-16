package com.ihoc.mgpa.j;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
class Q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0250b f5634a;
    final /* synthetic */ S b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s, InterfaceC0250b interfaceC0250b) {
        this.b = s;
        this.f5634a = interfaceC0250b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0250b interfaceC0250b;
        InterfaceC0250b interfaceC0250b2;
        this.b.d = new LocalSocket();
        try {
            try {
                this.b.d.connect(new LocalSocketAddress(this.b.h()));
                this.b.c = this.b.d.isConnected();
                if (this.b.c && this.f5634a != null) {
                    this.f5634a.a();
                }
                if (this.b.c) {
                    this.b.d.setReceiveBufferSize(500000);
                    this.b.d.setSendBufferSize(500000);
                    this.b.f = this.b.d.getOutputStream();
                    this.b.e = this.b.d.getInputStream();
                    this.b.g = new PrintWriter(this.b.f, true);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = this.b.e.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        String str = new String(bArr, 0, read, "UTF-8");
                        StringBuilder sb = new StringBuilder();
                        sb.append("VmpSocketClient:receive: ");
                        sb.append(str);
                        com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
                        this.b.b(str);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.b.b().a());
                    sb2.append(" connect is broken.");
                    com.ihoc.mgpa.n.m.a("TGPA", sb2.toString());
                    this.b.c = false;
                }
                com.ihoc.mgpa.n.m.a("TGPA", "VmpSocketClient:Connect Socket connect failed. socket type: " + this.b.b().a());
                if (this.b.c || (interfaceC0250b = this.f5634a) == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.b.c = false;
                com.ihoc.mgpa.n.m.a("TGPA", "VmpSocketClient:Connect Socket connect failed. socket type: " + this.b.b().a());
                if (this.b.c || (interfaceC0250b = this.f5634a) == null) {
                    return;
                }
            }
            interfaceC0250b.b();
        } catch (Throwable th) {
            com.ihoc.mgpa.n.m.a("TGPA", "VmpSocketClient:Connect Socket connect failed. socket type: " + this.b.b().a());
            if (!this.b.c && (interfaceC0250b2 = this.f5634a) != null) {
                interfaceC0250b2.b();
            }
            throw th;
        }
    }
}
