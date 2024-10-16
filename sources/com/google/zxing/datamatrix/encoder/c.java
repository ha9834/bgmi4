package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements g {
    public int a() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.g()) {
                break;
            }
            char b = hVar.b();
            hVar.f5409a++;
            int a2 = a(b, sb);
            int d = hVar.d() + ((sb.length() / 3) << 1);
            hVar.c(d);
            int f = hVar.i().f() - d;
            if (!hVar.g()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (f < 2 || f > 2)) {
                    a2 = a(hVar, sb, sb2, a2);
                }
                while (sb.length() % 3 == 1 && ((a2 <= 3 && f != 1) || a2 > 3)) {
                    a2 = a(hVar, sb, sb2, a2);
                }
            } else if (sb.length() % 3 == 0 && j.a(hVar.a(), hVar.f5409a, a()) != a()) {
                hVar.b(0);
                break;
            }
        }
        b(hVar, sb);
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        hVar.f5409a--;
        int a2 = a(hVar.b(), sb2);
        hVar.k();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, StringBuilder sb) {
        hVar.a(a(sb, 0));
        sb.delete(0, 3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void b(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int d = hVar.d() + length;
        hVar.c(d);
        int f = hVar.i().f() - d;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.g()) {
                hVar.a((char) 254);
            }
        } else if (f == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.g()) {
                hVar.a((char) 254);
            }
            hVar.f5409a--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (f > 0 || hVar.g()) {
                hVar.a((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.b(0);
    }

    int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i) {
        int charAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
