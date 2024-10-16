package com.shieldtunnel.svpn.common.f;

/* loaded from: classes2.dex */
public class i extends e {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5817a;

    @Override // com.shieldtunnel.svpn.common.f.e
    protected String a() {
        return "script";
    }

    @Override // com.shieldtunnel.svpn.common.f.e
    protected void a(byte[] bArr) {
        this.f5817a = bArr;
    }

    public byte[] c() {
        return this.f5817a;
    }
}
