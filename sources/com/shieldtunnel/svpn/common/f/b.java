package com.shieldtunnel.svpn.common.f;

import com.shieldtunnel.svpn.common.f.k;

/* loaded from: classes2.dex */
public class b extends k {
    static final /* synthetic */ boolean g = !b.class.desiredAssertionStatus();
    private final a f;

    /* loaded from: classes2.dex */
    interface a {
        void a(k.c cVar);
    }

    private b(k.b bVar, a aVar) {
        super(bVar);
        this.f = aVar;
    }

    public static byte[] a(k.b bVar, a aVar) {
        b bVar2 = new b(bVar, aVar);
        l n = bVar2.n();
        bVar2.b(n);
        if (!bVar2.c(n)) {
            return null;
        }
        if (g || n != null) {
            return j.c(n.d);
        }
        throw new AssertionError();
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String e() {
        return "v4";
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String i() {
        return "AccelNodes";
    }

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String l() {
        return "nodes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.shieldtunnel.svpn.common.f.k
    public boolean a(l lVar) {
        return lVar != null && lVar.c() > 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.shieldtunnel.svpn.common.f.k
    public void a(k.c cVar) {
        super.a(cVar);
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}
