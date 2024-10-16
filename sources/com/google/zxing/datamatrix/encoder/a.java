package com.google.zxing.datamatrix.encoder;

import com.intlgame.core.INTLMethodID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements g {
    public int a() {
        return 0;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        if (j.a(hVar.a(), hVar.f5409a) >= 2) {
            hVar.a(a(hVar.a().charAt(hVar.f5409a), hVar.a().charAt(hVar.f5409a + 1)));
            hVar.f5409a += 2;
            return;
        }
        char b = hVar.b();
        int a2 = j.a(hVar.a(), hVar.f5409a, a());
        if (a2 != a()) {
            switch (a2) {
                case 1:
                    hVar.a((char) 230);
                    hVar.b(1);
                    return;
                case 2:
                    hVar.a((char) 239);
                    hVar.b(2);
                    return;
                case 3:
                    hVar.a((char) 238);
                    hVar.b(3);
                    return;
                case 4:
                    hVar.a((char) 240);
                    hVar.b(4);
                    return;
                case 5:
                    hVar.a((char) 231);
                    hVar.b(5);
                    return;
                default:
                    throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(a2)));
            }
        }
        if (j.b(b)) {
            hVar.a((char) 235);
            hVar.a((char) ((b - 128) + 1));
            hVar.f5409a++;
        } else {
            hVar.a((char) (b + 1));
            hVar.f5409a++;
        }
    }

    private static char a(char c, char c2) {
        if (j.a(c) && j.a(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
