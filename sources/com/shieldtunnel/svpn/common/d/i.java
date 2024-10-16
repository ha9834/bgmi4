package com.shieldtunnel.svpn.common.d;

import com.shieldtunnel.svpn.common.d.e;

/* loaded from: classes2.dex */
public class i implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e.a f5797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e.a aVar) {
        this.f5797a = aVar;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public String a() {
        return "Established";
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i) {
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(int i, byte[] bArr) {
        f.a(this.f5797a, i, bArr);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void a(String str) {
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean b() {
        return true;
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public void c() {
        f.a(this.f5797a);
    }

    @Override // com.shieldtunnel.svpn.common.d.e
    public boolean d() {
        return false;
    }
}
