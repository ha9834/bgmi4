package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d {
    static float[] a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static Path a(String str) {
        Path path = new Path();
        b[] b2 = b(str);
        if (b2 == null) {
            return null;
        }
        try {
            b.a(b2, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a((ArrayList<b>) arrayList, trim.charAt(0), c(trim));
            }
            i2 = a2;
            i = a2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a((ArrayList<b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    public static boolean a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].f558a != bVarArr2[i].f558a || bVarArr[i].b.length != bVarArr2[i].b.length) {
                return false;
            }
        }
        return true;
    }

    public static void b(b[] bVarArr, b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].f558a = bVarArr2[i].f558a;
            for (int i2 = 0; i2 < bVarArr2[i].b.length; i2++) {
                bVarArr[i].b[i2] = bVarArr2[i].b[i2];
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f557a;
        boolean b;

        a() {
        }
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.f557a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[LOOP:0: B:2:0x0007->B:14:0x003e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r8, int r9, androidx.core.graphics.d.a r10) {
        /*
            r0 = 0
            r10.b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L41
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L39
            r6 = 69
            if (r5 == r6) goto L37
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L37
            switch(r5) {
                case 44: goto L39;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L35
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L3b
        L27:
            r10.b = r7
            r2 = 0
            r4 = 1
            goto L3b
        L2c:
            if (r1 == r9) goto L35
            if (r2 != 0) goto L35
            r10.b = r7
            r2 = 0
            r4 = 1
            goto L3b
        L35:
            r2 = 0
            goto L3b
        L37:
            r2 = 1
            goto L3b
        L39:
            r2 = 0
            r4 = 1
        L3b:
            if (r4 == 0) goto L3e
            goto L41
        L3e:
            int r1 = r1 + 1
            goto L7
        L41:
            r10.f557a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.d.a(java.lang.String, int, androidx.core.graphics.d$a):void");
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public char f558a;
        public float[] b;

        b(char c, float[] fArr) {
            this.f558a = c;
            this.b = fArr;
        }

        b(b bVar) {
            this.f558a = bVar.f558a;
            float[] fArr = bVar.b;
            this.b = d.a(fArr, 0, fArr.length);
        }

        public static void a(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                a(path, fArr, c, bVarArr[i].f558a, bVarArr[i].b);
                c = bVarArr[i].f558a;
            }
        }

        public void a(b bVar, b bVar2, float f) {
            this.f558a = bVar.f558a;
            int i = 0;
            while (true) {
                float[] fArr = bVar.b;
                if (i >= fArr.length) {
                    return;
                }
                this.b[i] = (fArr[i] * (1.0f - f)) + (bVar2.b[i] * f);
                i++;
            }
        }

        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            Path path2 = path;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            float f9 = fArr[3];
            float f10 = fArr[4];
            float f11 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f10, f11);
                    f6 = f10;
                    f8 = f6;
                    f7 = f11;
                    f9 = f7;
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            float f12 = f6;
            float f13 = f7;
            float f14 = f10;
            float f15 = f11;
            int i3 = 0;
            char c3 = c;
            while (i3 < fArr2.length) {
                float f16 = 0.0f;
                switch (c2) {
                    case 'A':
                        i2 = i3;
                        int i4 = i2 + 5;
                        int i5 = i2 + 6;
                        a(path, f12, f13, fArr2[i4], fArr2[i5], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f12 = fArr2[i4];
                        f13 = fArr2[i5];
                        f9 = f13;
                        f8 = f12;
                        break;
                    case 'C':
                        i2 = i3;
                        int i6 = i2 + 2;
                        int i7 = i2 + 3;
                        int i8 = i2 + 4;
                        int i9 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f12 = fArr2[i8];
                        float f17 = fArr2[i9];
                        float f18 = fArr2[i6];
                        float f19 = fArr2[i7];
                        f13 = f17;
                        f9 = f19;
                        f8 = f18;
                        break;
                    case 'H':
                        i2 = i3;
                        int i10 = i2 + 0;
                        path2.lineTo(fArr2[i10], f13);
                        f12 = fArr2[i10];
                        break;
                    case 'L':
                        i2 = i3;
                        int i11 = i2 + 0;
                        int i12 = i2 + 1;
                        path2.lineTo(fArr2[i11], fArr2[i12]);
                        f12 = fArr2[i11];
                        f13 = fArr2[i12];
                        break;
                    case 'M':
                        i2 = i3;
                        int i13 = i2 + 0;
                        f12 = fArr2[i13];
                        int i14 = i2 + 1;
                        f13 = fArr2[i14];
                        if (i2 > 0) {
                            path2.lineTo(fArr2[i13], fArr2[i14]);
                            break;
                        } else {
                            path2.moveTo(fArr2[i13], fArr2[i14]);
                            f15 = f13;
                            f14 = f12;
                            break;
                        }
                    case 'Q':
                        i2 = i3;
                        int i15 = i2 + 0;
                        int i16 = i2 + 1;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        path2.quadTo(fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        float f20 = fArr2[i15];
                        float f21 = fArr2[i16];
                        f12 = fArr2[i17];
                        f13 = fArr2[i18];
                        f8 = f20;
                        f9 = f21;
                        break;
                    case 'S':
                        float f22 = f13;
                        float f23 = f12;
                        i2 = i3;
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f24 = (f23 * 2.0f) - f8;
                            f = (f22 * 2.0f) - f9;
                            f2 = f24;
                        } else {
                            f2 = f23;
                            f = f22;
                        }
                        int i19 = i2 + 0;
                        int i20 = i2 + 1;
                        int i21 = i2 + 2;
                        int i22 = i2 + 3;
                        path.cubicTo(f2, f, fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                        float f25 = fArr2[i19];
                        float f26 = fArr2[i20];
                        f12 = fArr2[i21];
                        f13 = fArr2[i22];
                        f8 = f25;
                        f9 = f26;
                        break;
                    case 'T':
                        float f27 = f13;
                        float f28 = f12;
                        i2 = i3;
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f27 = (f27 * 2.0f) - f9;
                            f28 = (f28 * 2.0f) - f8;
                        }
                        int i23 = i2 + 0;
                        int i24 = i2 + 1;
                        path2.quadTo(f28, f27, fArr2[i23], fArr2[i24]);
                        f12 = fArr2[i23];
                        f8 = f28;
                        f9 = f27;
                        f13 = fArr2[i24];
                        break;
                    case 'V':
                        float f29 = f12;
                        i2 = i3;
                        int i25 = i2 + 0;
                        path2 = path;
                        path2.lineTo(f29, fArr2[i25]);
                        f12 = f29;
                        f13 = fArr2[i25];
                        break;
                    case 'a':
                        int i26 = i3 + 5;
                        float f30 = fArr2[i26] + f12;
                        int i27 = i3 + 6;
                        float f31 = fArr2[i27] + f13;
                        float f32 = fArr2[i3 + 0];
                        float f33 = fArr2[i3 + 1];
                        float f34 = fArr2[i3 + 2];
                        float f35 = f12;
                        boolean z = fArr2[i3 + 3] != 0.0f;
                        i2 = i3;
                        a(path, f12, f13, f30, f31, f32, f33, f34, z, fArr2[i3 + 4] != 0.0f);
                        f12 = f35 + fArr2[i26];
                        f13 += fArr2[i27];
                        f9 = f13;
                        f8 = f12;
                        path2 = path;
                        break;
                    case 'c':
                        int i28 = i3 + 2;
                        int i29 = i3 + 3;
                        int i30 = i3 + 4;
                        int i31 = i3 + 5;
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                        float f36 = fArr2[i28] + f12;
                        float f37 = fArr2[i29] + f13;
                        f12 += fArr2[i30];
                        f13 += fArr2[i31];
                        f8 = f36;
                        f9 = f37;
                        i2 = i3;
                        break;
                    case 'h':
                        int i32 = i3 + 0;
                        path2.rLineTo(fArr2[i32], 0.0f);
                        f12 += fArr2[i32];
                        i2 = i3;
                        break;
                    case 'l':
                        int i33 = i3 + 0;
                        int i34 = i3 + 1;
                        path2.rLineTo(fArr2[i33], fArr2[i34]);
                        f12 += fArr2[i33];
                        f13 += fArr2[i34];
                        i2 = i3;
                        break;
                    case 'm':
                        int i35 = i3 + 0;
                        f12 += fArr2[i35];
                        int i36 = i3 + 1;
                        f13 += fArr2[i36];
                        if (i3 > 0) {
                            path2.rLineTo(fArr2[i35], fArr2[i36]);
                            i2 = i3;
                            break;
                        } else {
                            path2.rMoveTo(fArr2[i35], fArr2[i36]);
                            f15 = f13;
                            f14 = f12;
                            i2 = i3;
                            break;
                        }
                    case 'q':
                        int i37 = i3 + 0;
                        int i38 = i3 + 1;
                        int i39 = i3 + 2;
                        int i40 = i3 + 3;
                        path2.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                        float f38 = fArr2[i37] + f12;
                        float f39 = fArr2[i38] + f13;
                        f12 += fArr2[i39];
                        f13 += fArr2[i40];
                        f8 = f38;
                        f9 = f39;
                        i2 = i3;
                        break;
                    case 's':
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f40 = f12 - f8;
                            f3 = f13 - f9;
                            f4 = f40;
                        } else {
                            f4 = 0.0f;
                            f3 = 0.0f;
                        }
                        int i41 = i3 + 0;
                        int i42 = i3 + 1;
                        int i43 = i3 + 2;
                        int i44 = i3 + 3;
                        path.rCubicTo(f4, f3, fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                        float f41 = fArr2[i41] + f12;
                        float f42 = fArr2[i42] + f13;
                        f12 += fArr2[i43];
                        f13 += fArr2[i44];
                        f8 = f41;
                        f9 = f42;
                        i2 = i3;
                        break;
                    case 't':
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f16 = f12 - f8;
                            f5 = f13 - f9;
                        } else {
                            f5 = 0.0f;
                        }
                        int i45 = i3 + 0;
                        int i46 = i3 + 1;
                        path2.rQuadTo(f16, f5, fArr2[i45], fArr2[i46]);
                        float f43 = f16 + f12;
                        float f44 = f5 + f13;
                        f12 += fArr2[i45];
                        f13 += fArr2[i46];
                        f9 = f44;
                        i2 = i3;
                        f8 = f43;
                        break;
                    case 'v':
                        int i47 = i3 + 0;
                        path2.rLineTo(0.0f, fArr2[i47]);
                        f13 += fArr2[i47];
                        i2 = i3;
                        break;
                    default:
                        i2 = i3;
                        f13 = f13;
                        break;
                }
                i3 = i2 + i;
                c3 = c2;
            }
            fArr[0] = f12;
            fArr[1] = f13;
            fArr[2] = f8;
            fArr[3] = f9;
            fArr[4] = f14;
            fArr[5] = f15;
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            Double.isNaN(d3);
            double d4 = d3 * cos;
            double d5 = f2;
            Double.isNaN(d5);
            double d6 = f5;
            Double.isNaN(d6);
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = -f;
            Double.isNaN(d8);
            Double.isNaN(d5);
            double d9 = (d8 * sin) + (d5 * cos);
            double d10 = f6;
            Double.isNaN(d10);
            double d11 = d9 / d10;
            double d12 = f3;
            Double.isNaN(d12);
            double d13 = f4;
            Double.isNaN(d13);
            Double.isNaN(d6);
            double d14 = ((d12 * cos) + (d13 * sin)) / d6;
            double d15 = -f3;
            Double.isNaN(d15);
            Double.isNaN(d13);
            Double.isNaN(d10);
            double d16 = ((d15 * sin) + (d13 * cos)) / d10;
            double d17 = d7 - d14;
            double d18 = d11 - d16;
            double d19 = (d7 + d14) / 2.0d;
            double d20 = (d11 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                Log.w("PathParser", "Points are too far apart " + d21);
                float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d22);
            double d23 = d17 * sqrt2;
            double d24 = sqrt2 * d18;
            if (z == z2) {
                d = d19 - d24;
                d2 = d20 + d23;
            } else {
                d = d19 + d24;
                d2 = d20 - d23;
            }
            double atan2 = Math.atan2(d11 - d2, d7 - d);
            double atan22 = Math.atan2(d16 - d2, d14 - d) - atan2;
            if (z2 != (atan22 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                atan22 = atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d6);
            double d25 = d * d6;
            Double.isNaN(d10);
            double d26 = d2 * d10;
            a(path, (d25 * cos) - (d26 * sin), (d25 * sin) + (d26 * cos), d6, d10, d3, d5, radians, atan2, atan22);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = ceil;
            Double.isNaN(d18);
            double d19 = d9 / d18;
            double d20 = d5;
            double d21 = d6;
            double d22 = d17;
            double d23 = d14;
            int i = 0;
            double d24 = d8;
            while (i < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d27 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d28 = (d12 * sin3) - (d13 * cos3);
                double d29 = (sin3 * d15) + (cos3 * d16);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d20 + (d23 * sin4)), (float) (d21 + (d22 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d19;
                ceil = ceil;
                sin = sin;
                d21 = d27;
                d15 = d15;
                d24 = d25;
                d22 = d29;
                d23 = d28;
                cos = cos;
                d10 = d3;
                d20 = d26;
            }
        }
    }
}
