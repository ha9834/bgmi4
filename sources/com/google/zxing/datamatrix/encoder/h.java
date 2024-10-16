package com.google.zxing.datamatrix.encoder;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    int f5409a;
    private final String b;
    private SymbolShapeHint c;
    private com.google.zxing.a d;
    private com.google.zxing.a e;
    private final StringBuilder f;
    private int g;
    private k h;
    private int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.b = sb.toString();
        this.c = SymbolShapeHint.FORCE_NONE;
        this.f = new StringBuilder(str.length());
        this.g = -1;
    }

    public void a(SymbolShapeHint symbolShapeHint) {
        this.c = symbolShapeHint;
    }

    public void a(com.google.zxing.a aVar, com.google.zxing.a aVar2) {
        this.d = aVar;
        this.e = aVar2;
    }

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.i = i;
    }

    public char b() {
        return this.b.charAt(this.f5409a);
    }

    public StringBuilder c() {
        return this.f;
    }

    public void a(String str) {
        this.f.append(str);
    }

    public void a(char c) {
        this.f.append(c);
    }

    public int d() {
        return this.f.length();
    }

    public int e() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public void f() {
        this.g = -1;
    }

    public boolean g() {
        return this.f5409a < l();
    }

    private int l() {
        return this.b.length() - this.i;
    }

    public int h() {
        return l() - this.f5409a;
    }

    public k i() {
        return this.h;
    }

    public void j() {
        c(d());
    }

    public void c(int i) {
        k kVar = this.h;
        if (kVar == null || i > kVar.f()) {
            this.h = k.a(i, this.c, this.d, this.e, true);
        }
    }

    public void k() {
        this.h = null;
    }
}
