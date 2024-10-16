package com.google.android.gms.internal.gtm;

import com.amazonaws.event.ProgressEvent;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.gtm.zzrc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class cr<T> implements da<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4337a = new int[0];
    private static final Unsafe b = dv.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzsk g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final ct o;
    private final cc p;
    private final dr<?, ?> q;
    private final bp<?> r;
    private final cl s;

    private cr(int[] iArr, Object[] objArr, int i, int i2, zzsk zzskVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, ct ctVar, cc ccVar, dr<?, ?> drVar, bp<?> bpVar, cl clVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzskVar instanceof zzrc;
        this.j = z;
        this.h = bpVar != null && bpVar.a(zzskVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = ctVar;
        this.p = ccVar;
        this.q = drVar;
        this.r = bpVar;
        this.g = zzskVar;
        this.s = clVar;
    }

    private static boolean f(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> cr<T> a(Class<T> cls, co coVar, ct ctVar, cc ccVar, dr<?, ?> drVar, bp<?> bpVar, cl clVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char charAt;
        int i6;
        int charAt2;
        int charAt3;
        int i7;
        int[] iArr;
        int i8;
        char c;
        char c2;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        int i13;
        int i14;
        char c3;
        char c4;
        int i15;
        int objectFieldOffset;
        String str;
        Class<?> cls2;
        int i16;
        int i17;
        int i18;
        int i19;
        Field a2;
        int i20;
        char charAt12;
        int i21;
        Field a3;
        char c5;
        Field a4;
        int i22;
        char charAt13;
        int i23;
        char charAt14;
        int i24;
        char charAt15;
        char charAt16;
        char charAt17;
        if (coVar instanceof cy) {
            cy cyVar = (cy) coVar;
            int i25 = 0;
            boolean z = cyVar.a() == zzrc.zze.zzbba;
            String d = cyVar.d();
            int length = d.length();
            int charAt18 = d.charAt(0);
            if (charAt18 >= 55296) {
                int i26 = charAt18 & 8191;
                int i27 = 1;
                int i28 = 13;
                while (true) {
                    i = i27 + 1;
                    charAt17 = d.charAt(i27);
                    if (charAt17 < 55296) {
                        break;
                    }
                    i26 |= (charAt17 & 8191) << i28;
                    i28 += 13;
                    i27 = i;
                }
                charAt18 = (charAt17 << i28) | i26;
            } else {
                i = 1;
            }
            int i29 = i + 1;
            int charAt19 = d.charAt(i);
            if (charAt19 >= 55296) {
                int i30 = charAt19 & 8191;
                int i31 = 13;
                while (true) {
                    i2 = i29 + 1;
                    charAt16 = d.charAt(i29);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i30 |= (charAt16 & 8191) << i31;
                    i31 += 13;
                    i29 = i2;
                }
                charAt19 = i30 | (charAt16 << i31);
            } else {
                i2 = i29;
            }
            if (charAt19 == 0) {
                iArr = f4337a;
                charAt3 = 0;
                c2 = 0;
                i8 = 0;
                charAt = 0;
                charAt2 = 0;
                c = 0;
            } else {
                int i32 = i2 + 1;
                char charAt20 = d.charAt(i2);
                if (charAt20 >= 55296) {
                    int i33 = charAt20 & 8191;
                    int i34 = 13;
                    while (true) {
                        i3 = i32 + 1;
                        charAt11 = d.charAt(i32);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i33 |= (charAt11 & 8191) << i34;
                        i34 += 13;
                        i32 = i3;
                    }
                    charAt20 = ((charAt11 << i34) | i33) == true ? 1 : 0;
                } else {
                    i3 = i32;
                }
                int i35 = i3 + 1;
                int charAt21 = d.charAt(i3);
                if (charAt21 >= 55296) {
                    int i36 = charAt21 & 8191;
                    int i37 = 13;
                    while (true) {
                        i4 = i35 + 1;
                        charAt10 = d.charAt(i35);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i36 |= (charAt10 & 8191) << i37;
                        i37 += 13;
                        i35 = i4;
                    }
                    charAt21 = i36 | (charAt10 << i37);
                } else {
                    i4 = i35;
                }
                int i38 = i4 + 1;
                char charAt22 = d.charAt(i4);
                if (charAt22 >= 55296) {
                    int i39 = charAt22 & 8191;
                    int i40 = 13;
                    while (true) {
                        i5 = i38 + 1;
                        charAt9 = d.charAt(i38);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i39 |= (charAt9 & 8191) << i40;
                        i40 += 13;
                        i38 = i5;
                    }
                    charAt22 = ((charAt9 << i40) | i39) == true ? 1 : 0;
                } else {
                    i5 = i38;
                }
                int i41 = i5 + 1;
                charAt = d.charAt(i5);
                if (charAt >= 55296) {
                    int i42 = charAt & 8191;
                    int i43 = 13;
                    while (true) {
                        i6 = i41 + 1;
                        charAt8 = d.charAt(i41);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i42 |= (charAt8 & 8191) << i43;
                        i43 += 13;
                        i41 = i6;
                    }
                    charAt = ((charAt8 << i43) | i42) == true ? 1 : 0;
                } else {
                    i6 = i41;
                }
                int i44 = i6 + 1;
                charAt2 = d.charAt(i6);
                if (charAt2 >= 55296) {
                    int i45 = charAt2 & 8191;
                    int i46 = 13;
                    while (true) {
                        i12 = i44 + 1;
                        charAt7 = d.charAt(i44);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i45 |= (charAt7 & 8191) << i46;
                        i46 += 13;
                        i44 = i12;
                    }
                    charAt2 = (charAt7 << i46) | i45;
                    i44 = i12;
                }
                int i47 = i44 + 1;
                charAt3 = d.charAt(i44);
                if (charAt3 >= 55296) {
                    int i48 = charAt3 & 8191;
                    int i49 = 13;
                    while (true) {
                        i11 = i47 + 1;
                        charAt6 = d.charAt(i47);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i48 |= (charAt6 & 8191) << i49;
                        i49 += 13;
                        i47 = i11;
                    }
                    charAt3 = i48 | (charAt6 << i49);
                    i47 = i11;
                }
                int i50 = i47 + 1;
                int charAt23 = d.charAt(i47);
                if (charAt23 >= 55296) {
                    int i51 = 13;
                    int i52 = charAt23 & 8191;
                    int i53 = i50;
                    while (true) {
                        i10 = i53 + 1;
                        charAt5 = d.charAt(i53);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i52 |= (charAt5 & 8191) << i51;
                        i51 += 13;
                        i53 = i10;
                    }
                    charAt23 = i52 | (charAt5 << i51);
                    i7 = i10;
                } else {
                    i7 = i50;
                }
                int i54 = i7 + 1;
                i25 = d.charAt(i7);
                if (i25 >= 55296) {
                    int i55 = 13;
                    int i56 = i25 & 8191;
                    int i57 = i54;
                    while (true) {
                        i9 = i57 + 1;
                        charAt4 = d.charAt(i57);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i56 |= (charAt4 & 8191) << i55;
                        i55 += 13;
                        i57 = i9;
                    }
                    i25 = i56 | (charAt4 << i55);
                    i54 = i9;
                }
                iArr = new int[i25 + charAt3 + charAt23];
                i8 = (charAt20 << 1) + charAt21;
                int i58 = i54;
                c = charAt20;
                c2 = charAt22;
                i2 = i58;
            }
            Unsafe unsafe = b;
            Object[] e = cyVar.e();
            Class<?> cls3 = cyVar.c().getClass();
            int i59 = i8;
            int[] iArr2 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i60 = i25 + charAt3;
            int i61 = i25;
            int i62 = i60;
            int i63 = 0;
            int i64 = 0;
            while (i2 < length) {
                int i65 = i2 + 1;
                int charAt24 = d.charAt(i2);
                char c6 = 55296;
                if (charAt24 >= 55296) {
                    int i66 = 13;
                    int i67 = charAt24 & 8191;
                    int i68 = i65;
                    while (true) {
                        i24 = i68 + 1;
                        charAt15 = d.charAt(i68);
                        if (charAt15 < c6) {
                            break;
                        }
                        i67 |= (charAt15 & 8191) << i66;
                        i66 += 13;
                        i68 = i24;
                        c6 = 55296;
                    }
                    charAt24 = i67 | (charAt15 << i66);
                    i13 = i24;
                } else {
                    i13 = i65;
                }
                int i69 = i13 + 1;
                int charAt25 = d.charAt(i13);
                int i70 = length;
                char c7 = 55296;
                if (charAt25 >= 55296) {
                    int i71 = 13;
                    int i72 = charAt25 & 8191;
                    int i73 = i69;
                    while (true) {
                        i23 = i73 + 1;
                        charAt14 = d.charAt(i73);
                        if (charAt14 < c7) {
                            break;
                        }
                        i72 |= (charAt14 & 8191) << i71;
                        i71 += 13;
                        i73 = i23;
                        c7 = 55296;
                    }
                    charAt25 = i72 | (charAt14 << i71);
                    i14 = i23;
                } else {
                    i14 = i69;
                }
                int i74 = i25;
                int i75 = charAt25 & 255;
                boolean z2 = z;
                if ((charAt25 & 1024) != 0) {
                    iArr[i63] = i64;
                    i63++;
                }
                int i76 = i63;
                if (i75 >= 51) {
                    int i77 = i14 + 1;
                    int charAt26 = d.charAt(i14);
                    char c8 = 55296;
                    if (charAt26 >= 55296) {
                        int i78 = charAt26 & 8191;
                        int i79 = 13;
                        while (true) {
                            i22 = i77 + 1;
                            charAt13 = d.charAt(i77);
                            if (charAt13 < c8) {
                                break;
                            }
                            i78 |= (charAt13 & 8191) << i79;
                            i79 += 13;
                            i77 = i22;
                            c8 = 55296;
                        }
                        charAt26 = i78 | (charAt13 << i79);
                        i77 = i22;
                    }
                    int i80 = i75 - 51;
                    int i81 = i77;
                    if (i80 == 9 || i80 == 17) {
                        i21 = 1;
                        objArr[((i64 / 3) << 1) + 1] = e[i59];
                        i59++;
                    } else if (i80 == 12 && (charAt18 & 1) == 1) {
                        objArr[((i64 / 3) << 1) + 1] = e[i59];
                        i59++;
                        i21 = 1;
                    } else {
                        i21 = 1;
                    }
                    int i82 = charAt26 << i21;
                    Object obj = e[i82];
                    if (obj instanceof Field) {
                        a3 = (Field) obj;
                        c5 = c2;
                    } else {
                        a3 = a(cls3, (String) obj);
                        e[i82] = a3;
                        c5 = c2;
                    }
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                    int i83 = i82 + 1;
                    Object obj2 = e[i83];
                    if (obj2 instanceof Field) {
                        a4 = (Field) obj2;
                    } else {
                        a4 = a(cls3, (String) obj2);
                        e[i83] = a4;
                    }
                    str = d;
                    i19 = (int) unsafe.objectFieldOffset(a4);
                    cls2 = cls3;
                    i16 = i59;
                    objectFieldOffset = objectFieldOffset2;
                    i18 = 0;
                    c4 = c5;
                    c3 = charAt;
                    i15 = charAt24;
                    i2 = i81;
                } else {
                    char c9 = c2;
                    int i84 = i59 + 1;
                    Field a5 = a(cls3, (String) e[i59]);
                    c3 = charAt;
                    if (i75 == 9 || i75 == 17) {
                        c4 = c9;
                        objArr[((i64 / 3) << 1) + 1] = a5.getType();
                    } else {
                        if (i75 == 27 || i75 == 49) {
                            c4 = c9;
                            objArr[((i64 / 3) << 1) + 1] = e[i84];
                            i15 = charAt24;
                            i84++;
                        } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                            c4 = c9;
                            if ((charAt18 & 1) == 1) {
                                objArr[((i64 / 3) << 1) + 1] = e[i84];
                                i15 = charAt24;
                                i84++;
                            }
                        } else if (i75 == 50) {
                            int i85 = i61 + 1;
                            iArr[i61] = i64;
                            int i86 = (i64 / 3) << 1;
                            int i87 = i84 + 1;
                            objArr[i86] = e[i84];
                            if ((charAt25 & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                                i84 = i87 + 1;
                                objArr[i86 + 1] = e[i87];
                                c4 = c9;
                                i61 = i85;
                                i15 = charAt24;
                            } else {
                                i61 = i85;
                                i84 = i87;
                                c4 = c9;
                                i15 = charAt24;
                            }
                        } else {
                            c4 = c9;
                        }
                        objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                        if ((charAt18 & 1) == 1 || i75 > 17) {
                            str = d;
                            cls2 = cls3;
                            i16 = i84;
                            i17 = i14;
                            i18 = 0;
                            i19 = 0;
                        } else {
                            i17 = i14 + 1;
                            int charAt27 = d.charAt(i14);
                            if (charAt27 >= 55296) {
                                int i88 = charAt27 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i20 = i17 + 1;
                                    charAt12 = d.charAt(i17);
                                    if (charAt12 < 55296) {
                                        break;
                                    }
                                    i88 |= (charAt12 & 8191) << i89;
                                    i89 += 13;
                                    i17 = i20;
                                }
                                charAt27 = i88 | (charAt12 << i89);
                                i17 = i20;
                            }
                            int i90 = (c << 1) + (charAt27 / 32);
                            Object obj3 = e[i90];
                            str = d;
                            if (obj3 instanceof Field) {
                                a2 = (Field) obj3;
                                cls2 = cls3;
                                i16 = i84;
                            } else {
                                a2 = a(cls3, (String) obj3);
                                e[i90] = a2;
                                cls2 = cls3;
                                i16 = i84;
                            }
                            i19 = (int) unsafe.objectFieldOffset(a2);
                            i18 = charAt27 % 32;
                        }
                        if (i75 >= 18 || i75 > 49) {
                            i2 = i17;
                        } else {
                            iArr[i62] = objectFieldOffset;
                            i62++;
                            i2 = i17;
                        }
                    }
                    i15 = charAt24;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                    if ((charAt18 & 1) == 1) {
                    }
                    str = d;
                    cls2 = cls3;
                    i16 = i84;
                    i17 = i14;
                    i18 = 0;
                    i19 = 0;
                    if (i75 >= 18) {
                    }
                    i2 = i17;
                }
                int i91 = i64 + 1;
                iArr2[i64] = i15;
                int i92 = i91 + 1;
                iArr2[i91] = (i75 << 20) | ((charAt25 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((charAt25 & 512) != 0 ? DriveFile.MODE_WRITE_ONLY : 0) | objectFieldOffset;
                i64 = i92 + 1;
                iArr2[i92] = (i18 << 20) | i19;
                cls3 = cls2;
                charAt = c3;
                i25 = i74;
                i59 = i16;
                length = i70;
                z = z2;
                c2 = c4;
                i63 = i76;
                d = str;
            }
            return new cr<>(iArr2, objArr, c2, charAt, cyVar.c(), z, false, iArr, i25, i60, ctVar, ccVar, drVar, bpVar, clVar);
        }
        ((dn) coVar).a();
        int i93 = zzrc.zze.zzbba;
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01d8 A[LOOP:0: B:2:0x0005->B:104:0x01d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.gtm.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.cr.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = d(i2);
            int i3 = this.c[i2];
            long j = 1048575 & d;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzre.zzz(Double.doubleToLongBits(dv.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(dv.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzre.zzz(dv.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzre.zzz(dv.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzre.zzz(dv.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzre.zzk(dv.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) dv.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = dv.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + dv.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzre.zzz(dv.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + dv.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzre.zzz(dv.b(t, j));
                    break;
                case 17:
                    Object f2 = dv.f(t, j);
                    i = (i * 53) + (f2 != null ? f2.hashCode() : 37);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + dv.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + dv.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(Double.doubleToLongBits(b(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(c(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzk(f(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + ((String) dv.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + dv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + dv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + zzre.zzz(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((cr<T>) t, i3, i2)) {
                        i = (i * 53) + dv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.q.b(t).hashCode();
        return this.h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.da
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.c.length; i += 3) {
            int d = d(i);
            long j = 1048575 & d;
            int i2 = this.c[i];
            switch ((d & 267386880) >>> 20) {
                case 0:
                    if (a((cr<T>) t2, i)) {
                        dv.a(t, j, dv.e(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.d(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.b(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.b(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.b(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((cr<T>) t2, i)) {
                        dv.a(t, j, dv.c(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((cr<T>) t2, i)) {
                        dv.a(t, j, dv.f(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((cr<T>) t2, i)) {
                        dv.a(t, j, dv.f(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.b(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.a(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((cr<T>) t2, i)) {
                        dv.a((Object) t, j, dv.b(t2, j));
                        b((cr<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    a(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.a(t, t2, j);
                    break;
                case 50:
                    dc.a(this.s, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (a((cr<T>) t2, i2, i)) {
                        dv.a(t, j, dv.f(t2, j));
                        b((cr<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    b(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (a((cr<T>) t2, i2, i)) {
                        dv.a(t, j, dv.f(t2, j));
                        b((cr<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i);
                    break;
            }
        }
        if (this.j) {
            return;
        }
        dc.a(this.q, t, t2);
        if (this.h) {
            dc.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long d = d(i) & 1048575;
        if (a((cr<T>) t2, i)) {
            Object f = dv.f(t, d);
            Object f2 = dv.f(t2, d);
            if (f != null && f2 != null) {
                dv.a(t, d, zzre.a(f, f2));
                b((cr<T>) t, i);
            } else if (f2 != null) {
                dv.a(t, d, f2);
                b((cr<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.c[i];
        long j = d & 1048575;
        if (a((cr<T>) t2, i2, i)) {
            Object f = dv.f(t, j);
            Object f2 = dv.f(t2, j);
            if (f != null && f2 != null) {
                dv.a(t, j, zzre.a(f, f2));
                b((cr<T>) t, i2, i);
            } else if (f2 != null) {
                dv.a(t, j, f2);
                b((cr<T>) t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final int b(T t) {
        int i;
        int i2;
        long j;
        int i3 = 267386880;
        int i4 = 1048575;
        int i5 = 1;
        if (this.j) {
            Unsafe unsafe = b;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.c.length) {
                int d = d(i6);
                int i8 = (d & i3) >>> 20;
                int i9 = this.c[i6];
                long j2 = d & 1048575;
                int i10 = (i8 < zzqw.DOUBLE_LIST_PACKED.id() || i8 > zzqw.SINT64_LIST_PACKED.id()) ? 0 : this.c[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzb(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzd(i9, dv.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zze(i9, dv.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzi(i9, dv.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzl(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzc(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((cr<T>) t, i6)) {
                            Object f = dv.f(t, j2);
                            if (f instanceof zzps) {
                                i7 += zzqj.zzc(i9, (zzps) f);
                                break;
                            } else {
                                i7 += zzqj.zzb(i9, (String) f);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (a((cr<T>) t, i6)) {
                            i7 += dc.a(i9, dv.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzc(i9, (zzps) dv.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzj(i9, dv.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzn(i9, dv.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzm(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzk(i9, dv.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.zzf(i9, dv.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((cr<T>) t, i6)) {
                            i7 += zzqj.c(i9, (zzsk) dv.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i7 += dc.i(i9, a(t, j2), false);
                        break;
                    case 19:
                        i7 += dc.h(i9, a(t, j2), false);
                        break;
                    case 20:
                        i7 += dc.a(i9, (List<Long>) a(t, j2), false);
                        break;
                    case 21:
                        i7 += dc.b(i9, (List<Long>) a(t, j2), false);
                        break;
                    case 22:
                        i7 += dc.e(i9, a(t, j2), false);
                        break;
                    case 23:
                        i7 += dc.i(i9, a(t, j2), false);
                        break;
                    case 24:
                        i7 += dc.h(i9, a(t, j2), false);
                        break;
                    case 25:
                        i7 += dc.j(i9, a(t, j2), false);
                        break;
                    case 26:
                        i7 += dc.a(i9, (List<?>) a(t, j2));
                        break;
                    case 27:
                        i7 += dc.a(i9, (List<?>) a(t, j2), a(i6));
                        break;
                    case 28:
                        i7 += dc.b(i9, a(t, j2));
                        break;
                    case 29:
                        i7 += dc.f(i9, a(t, j2), false);
                        break;
                    case 30:
                        i7 += dc.d(i9, a(t, j2), false);
                        break;
                    case 31:
                        i7 += dc.h(i9, a(t, j2), false);
                        break;
                    case 32:
                        i7 += dc.i(i9, a(t, j2), false);
                        break;
                    case 33:
                        i7 += dc.g(i9, a(t, j2), false);
                        break;
                    case 34:
                        i7 += dc.c(i9, a(t, j2), false);
                        break;
                    case 35:
                        int i11 = dc.i((List) unsafe.getObject(t, j2));
                        if (i11 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i11);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(i11) + i11;
                            break;
                        }
                    case 36:
                        int h = dc.h((List) unsafe.getObject(t, j2));
                        if (h <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(h) + h;
                            break;
                        }
                    case 37:
                        int a2 = dc.a((List<Long>) unsafe.getObject(t, j2));
                        if (a2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, a2);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(a2) + a2;
                            break;
                        }
                    case 38:
                        int b2 = dc.b((List) unsafe.getObject(t, j2));
                        if (b2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, b2);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(b2) + b2;
                            break;
                        }
                    case 39:
                        int e = dc.e((List) unsafe.getObject(t, j2));
                        if (e <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, e);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(e) + e;
                            break;
                        }
                    case 40:
                        int i12 = dc.i((List) unsafe.getObject(t, j2));
                        if (i12 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i12);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(i12) + i12;
                            break;
                        }
                    case 41:
                        int h2 = dc.h((List) unsafe.getObject(t, j2));
                        if (h2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h2);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(h2) + h2;
                            break;
                        }
                    case 42:
                        int j3 = dc.j((List) unsafe.getObject(t, j2));
                        if (j3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, j3);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(j3) + j3;
                            break;
                        }
                    case 43:
                        int f2 = dc.f((List) unsafe.getObject(t, j2));
                        if (f2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, f2);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(f2) + f2;
                            break;
                        }
                    case 44:
                        int d2 = dc.d((List) unsafe.getObject(t, j2));
                        if (d2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, d2);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(d2) + d2;
                            break;
                        }
                    case 45:
                        int h3 = dc.h((List) unsafe.getObject(t, j2));
                        if (h3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h3);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(h3) + h3;
                            break;
                        }
                    case 46:
                        int i13 = dc.i((List) unsafe.getObject(t, j2));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i13);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(i13) + i13;
                            break;
                        }
                    case 47:
                        int g = dc.g((List) unsafe.getObject(t, j2));
                        if (g <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, g);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(g) + g;
                            break;
                        }
                    case 48:
                        int c = dc.c((List) unsafe.getObject(t, j2));
                        if (c <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, c);
                            }
                            i7 += zzqj.zzbb(i9) + zzqj.zzbd(c) + c;
                            break;
                        }
                    case 49:
                        i7 += dc.b(i9, (List<zzsk>) a(t, j2), a(i6));
                        break;
                    case 50:
                        i7 += this.s.a(i9, dv.f(t, j2), b(i6));
                        break;
                    case 51:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzb(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzd(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zze(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzi(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzl(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzc(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((cr<T>) t, i9, i6)) {
                            Object f3 = dv.f(t, j2);
                            if (f3 instanceof zzps) {
                                i7 += zzqj.zzc(i9, (zzps) f3);
                                break;
                            } else {
                                i7 += zzqj.zzb(i9, (String) f3);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += dc.a(i9, dv.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzc(i9, (zzps) dv.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzj(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzn(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzm(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzk(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.zzf(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((cr<T>) t, i9, i6)) {
                            i7 += zzqj.c(i9, (zzsk) dv.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i3 = 267386880;
            }
            return i7 + a((dr) this.q, (Object) t);
        }
        Unsafe unsafe2 = b;
        int i14 = 0;
        int i15 = 0;
        int i16 = -1;
        int i17 = 0;
        while (i14 < this.c.length) {
            int d3 = d(i14);
            int[] iArr = this.c;
            int i18 = iArr[i14];
            int i19 = (d3 & 267386880) >>> 20;
            if (i19 <= 17) {
                i = iArr[i14 + 2];
                int i20 = i & i4;
                i2 = i5 << (i >>> 20);
                if (i20 != i16) {
                    i17 = unsafe2.getInt(t, i20);
                } else {
                    i20 = i16;
                }
                i16 = i20;
            } else if (!this.k || i19 < zzqw.DOUBLE_LIST_PACKED.id() || i19 > zzqw.SINT64_LIST_PACKED.id()) {
                i = 0;
                i2 = 0;
            } else {
                i = this.c[i14 + 2] & i4;
                i2 = 0;
            }
            long j4 = d3 & i4;
            switch (i19) {
                case 0:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzb(i18, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzb(i18, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzd(i18, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zze(i18, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzi(i18, unsafe2.getInt(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i17 & i2) != 0) {
                        j = 0;
                        i15 += zzqj.zzg(i18, 0L);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzl(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzc(i18, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i17 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzps) {
                            i15 += zzqj.zzc(i18, (zzps) object);
                            j = 0;
                            break;
                        } else {
                            i15 += zzqj.zzb(i18, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i17 & i2) != 0) {
                        i15 += dc.a(i18, unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzc(i18, (zzps) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzj(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzn(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzm(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzh(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzk(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.zzf(i18, unsafe2.getLong(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i17 & i2) != 0) {
                        i15 += zzqj.c(i18, (zzsk) unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i15 += dc.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 19:
                    i15 += dc.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 20:
                    i15 += dc.a(i18, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 21:
                    i15 += dc.b(i18, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 22:
                    i15 += dc.e(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 23:
                    i15 += dc.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 24:
                    i15 += dc.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 25:
                    i15 += dc.j(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 26:
                    i15 += dc.a(i18, (List<?>) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 27:
                    i15 += dc.a(i18, (List<?>) unsafe2.getObject(t, j4), a(i14));
                    j = 0;
                    break;
                case 28:
                    i15 += dc.b(i18, (List) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 29:
                    i15 += dc.f(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 30:
                    i15 += dc.d(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 31:
                    i15 += dc.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 32:
                    i15 += dc.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 33:
                    i15 += dc.g(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 34:
                    i15 += dc.c(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 35:
                    int i21 = dc.i((List) unsafe2.getObject(t, j4));
                    if (i21 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i21);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(i21) + i21;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int h4 = dc.h((List) unsafe2.getObject(t, j4));
                    if (h4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h4);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(h4) + h4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int a3 = dc.a((List<Long>) unsafe2.getObject(t, j4));
                    if (a3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, a3);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(a3) + a3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int b3 = dc.b((List) unsafe2.getObject(t, j4));
                    if (b3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b3);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(b3) + b3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int e2 = dc.e((List) unsafe2.getObject(t, j4));
                    if (e2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, e2);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(e2) + e2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int i22 = dc.i((List) unsafe2.getObject(t, j4));
                    if (i22 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i22);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(i22) + i22;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int h5 = dc.h((List) unsafe2.getObject(t, j4));
                    if (h5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h5);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(h5) + h5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int j5 = dc.j((List) unsafe2.getObject(t, j4));
                    if (j5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, j5);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(j5) + j5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int f4 = dc.f((List) unsafe2.getObject(t, j4));
                    if (f4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, f4);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(f4) + f4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int d4 = dc.d((List) unsafe2.getObject(t, j4));
                    if (d4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, d4);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(d4) + d4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int h6 = dc.h((List) unsafe2.getObject(t, j4));
                    if (h6 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h6);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(h6) + h6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int i23 = dc.i((List) unsafe2.getObject(t, j4));
                    if (i23 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i23);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(i23) + i23;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int g2 = dc.g((List) unsafe2.getObject(t, j4));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(g2) + g2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int c2 = dc.c((List) unsafe2.getObject(t, j4));
                    if (c2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, c2);
                        }
                        i15 += zzqj.zzbb(i18) + zzqj.zzbd(c2) + c2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i15 += dc.b(i18, (List<zzsk>) unsafe2.getObject(t, j4), a(i14));
                    j = 0;
                    break;
                case 50:
                    i15 += this.s.a(i18, unsafe2.getObject(t, j4), b(i14));
                    j = 0;
                    break;
                case 51:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzb(i18, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzb(i18, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzd(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zze(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzi(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzg(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzl(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzc(i18, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (a((cr<T>) t, i18, i14)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzps) {
                            i15 += zzqj.zzc(i18, (zzps) object2);
                            j = 0;
                            break;
                        } else {
                            i15 += zzqj.zzb(i18, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += dc.a(i18, unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzc(i18, (zzps) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzj(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzn(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzm(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzh(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzk(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.zzf(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (a((cr<T>) t, i18, i14)) {
                        i15 += zzqj.c(i18, (zzsk) unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
            i14 += 3;
            i4 = 1048575;
            i5 = 1;
        }
        int a4 = i15 + a((dr) this.q, (Object) t);
        if (!this.h) {
            return a4;
        }
        bs<?> a5 = this.r.a(t);
        int i24 = 0;
        for (int i25 = 0; i25 < a5.f4320a.c(); i25++) {
            Map.Entry<?, Object> b4 = a5.f4320a.b(i25);
            i24 += bs.a((zzqv<?>) b4.getKey(), b4.getValue());
        }
        for (Map.Entry<?, Object> entry : a5.f4320a.d()) {
            i24 += bs.a((zzqv<?>) entry.getKey(), entry.getValue());
        }
        return a4 + i24;
    }

    private static <UT, UB> int a(dr<UT, UB> drVar, T t) {
        return drVar.f(drVar.b(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) dv.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2b  */
    @Override // com.google.android.gms.internal.gtm.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r14, com.google.android.gms.internal.gtm.ed r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.cr.a(java.lang.Object, com.google.android.gms.internal.gtm.ed):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(T r19, com.google.android.gms.internal.gtm.ed r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.cr.b(java.lang.Object, com.google.android.gms.internal.gtm.ed):void");
    }

    private final <K, V> void a(ed edVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            edVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(dr<UT, UB> drVar, T t, ed edVar) throws IOException {
        drVar.a((dr<UT, UB>) drVar.b(t), edVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x00b4. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.da
    public final void a(T t, cz czVar, zzqp zzqpVar) throws IOException {
        if (zzqpVar == null) {
            throw new NullPointerException();
        }
        dr drVar = this.q;
        bp<?> bpVar = this.r;
        bs<?> bsVar = null;
        Object obj = null;
        while (true) {
            try {
                int a2 = czVar.a();
                int i = -1;
                if (a2 >= this.e && a2 <= this.f) {
                    int i2 = 0;
                    int length = (this.c.length / 3) - 1;
                    while (true) {
                        if (i2 <= length) {
                            int i3 = (length + i2) >>> 1;
                            int i4 = i3 * 3;
                            int i5 = this.c[i4];
                            if (a2 == i5) {
                                i = i4;
                            } else if (a2 < i5) {
                                length = i3 - 1;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                    }
                }
                if (i < 0) {
                    if (a2 == Integer.MAX_VALUE) {
                        for (int i6 = this.m; i6 < this.n; i6++) {
                            obj = a((Object) t, this.l[i6], (int) obj, (dr<UT, int>) drVar);
                        }
                        if (obj != null) {
                            drVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a3 = !this.h ? null : bpVar.a(zzqpVar, this.g, a2);
                    if (a3 != null) {
                        bs<?> b2 = bsVar == null ? bpVar.b(t) : bsVar;
                        obj = bpVar.a(czVar, a3, zzqpVar, b2, obj, drVar);
                        bsVar = b2;
                    } else {
                        drVar.a(czVar);
                        if (obj == null) {
                            obj = drVar.c(t);
                        }
                        if (!drVar.a((dr) obj, czVar)) {
                            for (int i7 = this.m; i7 < this.n; i7++) {
                                obj = a((Object) t, this.l[i7], (int) obj, (dr<UT, int>) drVar);
                            }
                            if (obj != null) {
                                drVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int d = d(i);
                    switch ((267386880 & d) >>> 20) {
                        case 0:
                            dv.a(t, d & 1048575, czVar.d());
                            b((cr<T>) t, i);
                            break;
                        case 1:
                            dv.a((Object) t, d & 1048575, czVar.e());
                            b((cr<T>) t, i);
                            break;
                        case 2:
                            dv.a((Object) t, d & 1048575, czVar.g());
                            b((cr<T>) t, i);
                            break;
                        case 3:
                            dv.a((Object) t, d & 1048575, czVar.f());
                            b((cr<T>) t, i);
                            break;
                        case 4:
                            dv.a((Object) t, d & 1048575, czVar.h());
                            b((cr<T>) t, i);
                            break;
                        case 5:
                            dv.a((Object) t, d & 1048575, czVar.i());
                            b((cr<T>) t, i);
                            break;
                        case 6:
                            dv.a((Object) t, d & 1048575, czVar.j());
                            b((cr<T>) t, i);
                            break;
                        case 7:
                            dv.a(t, d & 1048575, czVar.k());
                            b((cr<T>) t, i);
                            break;
                        case 8:
                            a(t, d, czVar);
                            b((cr<T>) t, i);
                            break;
                        case 9:
                            if (a((cr<T>) t, i)) {
                                long j = d & 1048575;
                                dv.a(t, j, zzre.a(dv.f(t, j), czVar.a(a(i), zzqpVar)));
                                break;
                            } else {
                                dv.a(t, d & 1048575, czVar.a(a(i), zzqpVar));
                                b((cr<T>) t, i);
                                break;
                            }
                        case 10:
                            dv.a(t, d & 1048575, czVar.n());
                            b((cr<T>) t, i);
                            break;
                        case 11:
                            dv.a((Object) t, d & 1048575, czVar.o());
                            b((cr<T>) t, i);
                            break;
                        case 12:
                            int p = czVar.p();
                            zzrh c = c(i);
                            if (c != null && !c.zzb(p)) {
                                obj = dc.a(a2, p, obj, (dr<UT, Object>) drVar);
                                break;
                            }
                            dv.a((Object) t, d & 1048575, p);
                            b((cr<T>) t, i);
                            break;
                        case 13:
                            dv.a((Object) t, d & 1048575, czVar.q());
                            b((cr<T>) t, i);
                            break;
                        case 14:
                            dv.a((Object) t, d & 1048575, czVar.r());
                            b((cr<T>) t, i);
                            break;
                        case 15:
                            dv.a((Object) t, d & 1048575, czVar.s());
                            b((cr<T>) t, i);
                            break;
                        case 16:
                            dv.a((Object) t, d & 1048575, czVar.t());
                            b((cr<T>) t, i);
                            break;
                        case 17:
                            if (a((cr<T>) t, i)) {
                                long j2 = d & 1048575;
                                dv.a(t, j2, zzre.a(dv.f(t, j2), czVar.b(a(i), zzqpVar)));
                                break;
                            } else {
                                dv.a(t, d & 1048575, czVar.b(a(i), zzqpVar));
                                b((cr<T>) t, i);
                                break;
                            }
                        case 18:
                            czVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 19:
                            czVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 20:
                            czVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 21:
                            czVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 22:
                            czVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 23:
                            czVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 24:
                            czVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 25:
                            czVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 26:
                            if (f(d)) {
                                czVar.j(this.p.a(t, d & 1048575));
                                break;
                            } else {
                                czVar.i(this.p.a(t, d & 1048575));
                                break;
                            }
                        case 27:
                            czVar.a(this.p.a(t, d & 1048575), a(i), zzqpVar);
                            break;
                        case 28:
                            czVar.k(this.p.a(t, d & 1048575));
                            break;
                        case 29:
                            czVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 30:
                            List<Integer> a4 = this.p.a(t, d & 1048575);
                            czVar.m(a4);
                            obj = dc.a(a2, a4, c(i), obj, drVar);
                            break;
                        case 31:
                            czVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 32:
                            czVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 33:
                            czVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 34:
                            czVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 35:
                            czVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 36:
                            czVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 37:
                            czVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 38:
                            czVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 39:
                            czVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 40:
                            czVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 41:
                            czVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 42:
                            czVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 43:
                            czVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 44:
                            List<Integer> a5 = this.p.a(t, d & 1048575);
                            czVar.m(a5);
                            obj = dc.a(a2, a5, c(i), obj, drVar);
                            break;
                        case 45:
                            czVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 46:
                            czVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 47:
                            czVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 48:
                            czVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 49:
                            czVar.b(this.p.a(t, d & 1048575), a(i), zzqpVar);
                            break;
                        case 50:
                            Object b3 = b(i);
                            long d2 = d(i) & 1048575;
                            Object f = dv.f(t, d2);
                            if (f == null) {
                                f = this.s.e(b3);
                                dv.a(t, d2, f);
                            } else if (this.s.c(f)) {
                                Object e = this.s.e(b3);
                                this.s.a(e, f);
                                dv.a(t, d2, e);
                                f = e;
                            }
                            czVar.a(this.s.a(f), this.s.f(b3), zzqpVar);
                            break;
                        case 51:
                            dv.a(t, d & 1048575, Double.valueOf(czVar.d()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 52:
                            dv.a(t, d & 1048575, Float.valueOf(czVar.e()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 53:
                            dv.a(t, d & 1048575, Long.valueOf(czVar.g()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 54:
                            dv.a(t, d & 1048575, Long.valueOf(czVar.f()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 55:
                            dv.a(t, d & 1048575, Integer.valueOf(czVar.h()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 56:
                            dv.a(t, d & 1048575, Long.valueOf(czVar.i()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 57:
                            dv.a(t, d & 1048575, Integer.valueOf(czVar.j()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 58:
                            dv.a(t, d & 1048575, Boolean.valueOf(czVar.k()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 59:
                            a(t, d, czVar);
                            b((cr<T>) t, a2, i);
                            break;
                        case 60:
                            if (a((cr<T>) t, a2, i)) {
                                long j3 = d & 1048575;
                                dv.a(t, j3, zzre.a(dv.f(t, j3), czVar.a(a(i), zzqpVar)));
                            } else {
                                dv.a(t, d & 1048575, czVar.a(a(i), zzqpVar));
                                b((cr<T>) t, i);
                            }
                            b((cr<T>) t, a2, i);
                            break;
                        case 61:
                            dv.a(t, d & 1048575, czVar.n());
                            b((cr<T>) t, a2, i);
                            break;
                        case 62:
                            dv.a(t, d & 1048575, Integer.valueOf(czVar.o()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 63:
                            int p2 = czVar.p();
                            zzrh c2 = c(i);
                            if (c2 != null && !c2.zzb(p2)) {
                                obj = dc.a(a2, p2, obj, (dr<UT, Object>) drVar);
                                break;
                            }
                            dv.a(t, d & 1048575, Integer.valueOf(p2));
                            b((cr<T>) t, a2, i);
                            break;
                        case 64:
                            dv.a(t, d & 1048575, Integer.valueOf(czVar.q()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 65:
                            dv.a(t, d & 1048575, Long.valueOf(czVar.r()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 66:
                            dv.a(t, d & 1048575, Integer.valueOf(czVar.s()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 67:
                            dv.a(t, d & 1048575, Long.valueOf(czVar.t()));
                            b((cr<T>) t, a2, i);
                            break;
                        case 68:
                            dv.a(t, d & 1048575, czVar.b(a(i), zzqpVar));
                            b((cr<T>) t, a2, i);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = drVar.a();
                                } catch (zzrl unused) {
                                    drVar.a(czVar);
                                    if (obj == null) {
                                        obj = drVar.c(t);
                                    }
                                    if (!drVar.a((dr) obj, czVar)) {
                                        for (int i8 = this.m; i8 < this.n; i8++) {
                                            obj = a((Object) t, this.l[i8], (int) obj, (dr<UT, int>) drVar);
                                        }
                                        if (obj != null) {
                                            drVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!drVar.a((dr) obj, czVar)) {
                                for (int i9 = this.m; i9 < this.n; i9++) {
                                    obj = a((Object) t, this.l[i9], (int) obj, (dr<UT, int>) drVar);
                                }
                                if (obj != null) {
                                    drVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i10 = this.m; i10 < this.n; i10++) {
                    obj = a((Object) t, this.l[i10], (int) obj, (dr<UT, int>) drVar);
                }
                if (obj != null) {
                    drVar.b((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    private final da a(int i) {
        int i2 = (i / 3) << 1;
        da daVar = (da) this.d[i2];
        if (daVar != null) {
            return daVar;
        }
        da<T> a2 = cx.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final zzrh c(int i) {
        return (zzrh) this.d[((i / 3) << 1) + 1];
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final void c(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d = d(this.l[i2]) & 1048575;
            Object f = dv.f(t, d);
            if (f != null) {
                dv.a(t, d, this.s.d(f));
            }
            i2++;
        }
        int length = this.l.length;
        while (i < length) {
            this.p.b(t, this.l[i]);
            i++;
        }
        this.q.d(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, dr<UT, UB> drVar) {
        zzrh c;
        int i2 = this.c[i];
        Object f = dv.f(obj, d(i) & 1048575);
        return (f == null || (c = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(f), c, ub, drVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzrh zzrhVar, UB ub, dr<UT, UB> drVar) {
        ck<?, ?> f = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzrhVar.zzb(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = drVar.a();
                }
                bf b2 = zzps.b(zzsc.a(f, next.getKey(), next.getValue()));
                try {
                    zzsc.a(b2.b(), f, next.getKey(), next.getValue());
                    drVar.a((dr<UT, UB>) ub, i2, b2.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0104, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.gtm.da] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.gtm.da] */
    @Override // com.google.android.gms.internal.gtm.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.cr.d(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, da daVar) {
        return daVar.d(dv.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, ed edVar) throws IOException {
        if (obj instanceof String) {
            edVar.a(i, (String) obj);
        } else {
            edVar.a(i, (zzps) obj);
        }
    }

    private final void a(Object obj, int i, cz czVar) throws IOException {
        if (f(i)) {
            dv.a(obj, i & 1048575, czVar.m());
        } else if (this.i) {
            dv.a(obj, i & 1048575, czVar.l());
        } else {
            dv.a(obj, i & 1048575, czVar.n());
        }
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> double b(T t, long j) {
        return ((Double) dv.f(t, j)).doubleValue();
    }

    private static <T> float c(T t, long j) {
        return ((Float) dv.f(t, j)).floatValue();
    }

    private static <T> int d(T t, long j) {
        return ((Integer) dv.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) dv.f(t, j)).longValue();
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) dv.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((cr<T>) t, i) == a((cr<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((cr<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d = d(i);
            long j = d & 1048575;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    return dv.e(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return dv.d(t, j) != 0.0f;
                case 2:
                    return dv.b(t, j) != 0;
                case 3:
                    return dv.b(t, j) != 0;
                case 4:
                    return dv.a(t, j) != 0;
                case 5:
                    return dv.b(t, j) != 0;
                case 6:
                    return dv.a(t, j) != 0;
                case 7:
                    return dv.c(t, j);
                case 8:
                    Object f = dv.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzps) {
                        return !zzps.zzavx.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return dv.f(t, j) != null;
                case 10:
                    return !zzps.zzavx.equals(dv.f(t, j));
                case 11:
                    return dv.a(t, j) != 0;
                case 12:
                    return dv.a(t, j) != 0;
                case 13:
                    return dv.a(t, j) != 0;
                case 14:
                    return dv.b(t, j) != 0;
                case 15:
                    return dv.a(t, j) != 0;
                case 16:
                    return dv.b(t, j) != 0;
                case 17:
                    return dv.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e = e(i);
        return (dv.a(t, (long) (e & 1048575)) & (1 << (e >>> 20))) != 0;
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e = e(i);
        long j = e & 1048575;
        dv.a((Object) t, j, dv.a(t, j) | (1 << (e >>> 20)));
    }

    private final boolean a(T t, int i, int i2) {
        return dv.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        dv.a((Object) t, e(i2) & 1048575, i);
    }
}
