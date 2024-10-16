package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements g {
    public int a() {
        return 4;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.g()) {
                break;
            }
            a(hVar.b(), sb);
            hVar.f5409a++;
            if (sb.length() >= 4) {
                hVar.a(a(sb, 0));
                sb.delete(0, 4);
                if (j.a(hVar.a(), hVar.f5409a, a()) != a()) {
                    hVar.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(hVar, sb);
    }

    private static void a(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.j();
                int f = hVar.i().f() - hVar.d();
                int h = hVar.h();
                if (h > f) {
                    hVar.c(hVar.d() + 1);
                    f = hVar.i().f() - hVar.d();
                }
                if (h <= f && f <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            String a2 = a(charSequence, 0);
            if (!(!hVar.g()) || i > 2) {
                z = false;
            }
            if (i <= 2) {
                hVar.c(hVar.d() + i);
                if (hVar.i().f() - hVar.d() >= 3) {
                    hVar.c(hVar.d() + a2.length());
                    z = false;
                }
            }
            if (z) {
                hVar.k();
                hVar.f5409a -= i;
            } else {
                hVar.a(a2);
            }
        } finally {
            hVar.b(0);
        }
    }

    private static void a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c >= '@' && c <= '^') {
            sb.append((char) (c - '@'));
        } else {
            j.c(c);
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int charAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
        char c = (char) ((charAt >> 16) & 255);
        char c2 = (char) ((charAt >> 8) & 255);
        char c3 = (char) (charAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }
}
