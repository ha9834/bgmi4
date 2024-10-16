package com.google.zxing.datamatrix.encoder;

import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements g {
    public int a() {
        return 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.g()) {
                break;
            }
            sb.append(hVar.b());
            hVar.f5409a++;
            if (j.a(hVar.a(), hVar.f5409a, a()) != a()) {
                hVar.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int d = hVar.d() + length + 1;
        hVar.c(d);
        boolean z = hVar.i().f() - d > 0;
        if (hVar.g() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            hVar.a(a(sb.charAt(i), hVar.d() + 1));
        }
    }

    private static char a(char c, int i) {
        int i2 = c + ((i * TbsListener.ErrorCode.NEEDDOWNLOAD_10) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }
}
