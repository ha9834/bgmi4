package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m extends c {
    @Override // com.google.zxing.datamatrix.encoder.c
    public int a() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.g()) {
                break;
            }
            char b = hVar.b();
            hVar.f5409a++;
            a(b, sb);
            if (sb.length() % 3 == 0) {
                a(hVar, sb);
                if (j.a(hVar.a(), hVar.f5409a, a()) != a()) {
                    hVar.b(0);
                    break;
                }
            }
        }
        b(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int a(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
        } else {
            j.c(c);
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void b(h hVar, StringBuilder sb) {
        hVar.j();
        int f = hVar.i().f() - hVar.d();
        hVar.f5409a -= sb.length();
        if (hVar.h() > 1 || f > 1 || hVar.h() != f) {
            hVar.a((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.b(0);
        }
    }
}
