package com.google.android.gms.internal.measurement;

import com.amazonaws.event.ProgressEvent;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.measurement.zzey;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dc<T> implements dl<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4513a = new int[0];
    private static final Unsafe b = eg.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzgi g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final df o;
    private final cn p;
    private final ed<?, ?> q;
    private final ca<?> r;
    private final cv s;

    private dc(int[] iArr, Object[] objArr, int i, int i2, zzgi zzgiVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, df dfVar, cn cnVar, ed<?, ?> edVar, ca<?> caVar, cv cvVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzgiVar instanceof zzey;
        this.j = z;
        this.h = caVar != null && caVar.a(zzgiVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = dfVar;
        this.p = cnVar;
        this.q = edVar;
        this.r = caVar;
        this.g = zzgiVar;
        this.s = cvVar;
    }

    private static boolean f(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> dc<T> a(Class<T> cls, cz czVar, df dfVar, cn cnVar, ed<?, ?> edVar, ca<?> caVar, cv cvVar) {
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
        if (czVar instanceof dj) {
            dj djVar = (dj) czVar;
            int i25 = 0;
            boolean z = djVar.a() == zzey.zzd.zzaim;
            String d = djVar.d();
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
                iArr = f4513a;
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
            Object[] e = djVar.e();
            Class<?> cls3 = djVar.c().getClass();
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
            return new dc<>(iArr2, objArr, c2, charAt, djVar.c(), z, false, iArr, i25, i60, dfVar, cnVar, edVar, caVar, cvVar);
        }
        ((ea) czVar).a();
        int i93 = zzey.zzd.zzaim;
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

    @Override // com.google.android.gms.internal.measurement.dl
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01d8 A[LOOP:0: B:2:0x0005->B:104:0x01d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dc.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = d(i2);
            int i3 = this.c[i2];
            long j = 1048575 & d;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzez.zzbx(Double.doubleToLongBits(eg.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(eg.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzez.zzbx(eg.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzez.zzbx(eg.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzez.zzbx(eg.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzez.zzs(eg.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) eg.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = eg.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + eg.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzez.zzbx(eg.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + eg.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzez.zzbx(eg.b(t, j));
                    break;
                case 17:
                    Object f2 = eg.f(t, j);
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
                    i = (i * 53) + eg.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + eg.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(Double.doubleToLongBits(b(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(c(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzs(f(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + ((String) eg.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + eg.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + eg.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + zzez.zzbx(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((dc<T>) t, i3, i2)) {
                        i = (i * 53) + eg.f(t, j).hashCode();
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
    @Override // com.google.android.gms.internal.measurement.dl
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
                    if (a((dc<T>) t2, i)) {
                        eg.a(t, j, eg.e(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.d(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.b(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.b(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.b(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((dc<T>) t2, i)) {
                        eg.a(t, j, eg.c(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((dc<T>) t2, i)) {
                        eg.a(t, j, eg.f(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((dc<T>) t2, i)) {
                        eg.a(t, j, eg.f(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.b(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.a(t2, j));
                        b((dc<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((dc<T>) t2, i)) {
                        eg.a((Object) t, j, eg.b(t2, j));
                        b((dc<T>) t, i);
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
                    dn.a(this.s, t, t2, j);
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
                    if (a((dc<T>) t2, i2, i)) {
                        eg.a(t, j, eg.f(t2, j));
                        b((dc<T>) t, i2, i);
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
                    if (a((dc<T>) t2, i2, i)) {
                        eg.a(t, j, eg.f(t2, j));
                        b((dc<T>) t, i2, i);
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
        dn.a(this.q, t, t2);
        if (this.h) {
            dn.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long d = d(i) & 1048575;
        if (a((dc<T>) t2, i)) {
            Object f = eg.f(t, d);
            Object f2 = eg.f(t2, d);
            if (f != null && f2 != null) {
                eg.a(t, d, zzez.a(f, f2));
                b((dc<T>) t, i);
            } else if (f2 != null) {
                eg.a(t, d, f2);
                b((dc<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.c[i];
        long j = d & 1048575;
        if (a((dc<T>) t2, i2, i)) {
            Object f = eg.f(t, j);
            Object f2 = eg.f(t2, j);
            if (f != null && f2 != null) {
                eg.a(t, j, zzez.a(f, f2));
                b((dc<T>) t, i2, i);
            } else if (f2 != null) {
                eg.a(t, j, f2);
                b((dc<T>) t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.dl
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
                int i10 = (i8 < zzet.DOUBLE_LIST_PACKED.id() || i8 > zzet.SINT64_LIST_PACKED.id()) ? 0 : this.c[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzb(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzd(i9, eg.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zze(i9, eg.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzg(i9, eg.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzj(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzc(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((dc<T>) t, i6)) {
                            Object f = eg.f(t, j2);
                            if (f instanceof zzdp) {
                                i7 += zzee.zzc(i9, (zzdp) f);
                                break;
                            } else {
                                i7 += zzee.zzc(i9, (String) f);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (a((dc<T>) t, i6)) {
                            i7 += dn.a(i9, eg.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzc(i9, (zzdp) eg.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzh(i9, eg.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzl(i9, eg.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzk(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzi(i9, eg.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.zzf(i9, eg.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((dc<T>) t, i6)) {
                            i7 += zzee.c(i9, (zzgi) eg.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i7 += dn.i(i9, a(t, j2), false);
                        break;
                    case 19:
                        i7 += dn.h(i9, a(t, j2), false);
                        break;
                    case 20:
                        i7 += dn.a(i9, (List<Long>) a(t, j2), false);
                        break;
                    case 21:
                        i7 += dn.b(i9, (List<Long>) a(t, j2), false);
                        break;
                    case 22:
                        i7 += dn.e(i9, a(t, j2), false);
                        break;
                    case 23:
                        i7 += dn.i(i9, a(t, j2), false);
                        break;
                    case 24:
                        i7 += dn.h(i9, a(t, j2), false);
                        break;
                    case 25:
                        i7 += dn.j(i9, a(t, j2), false);
                        break;
                    case 26:
                        i7 += dn.a(i9, a(t, j2));
                        break;
                    case 27:
                        i7 += dn.a(i9, a(t, j2), a(i6));
                        break;
                    case 28:
                        i7 += dn.b(i9, a(t, j2));
                        break;
                    case 29:
                        i7 += dn.f(i9, a(t, j2), false);
                        break;
                    case 30:
                        i7 += dn.d(i9, a(t, j2), false);
                        break;
                    case 31:
                        i7 += dn.h(i9, a(t, j2), false);
                        break;
                    case 32:
                        i7 += dn.i(i9, a(t, j2), false);
                        break;
                    case 33:
                        i7 += dn.g(i9, a(t, j2), false);
                        break;
                    case 34:
                        i7 += dn.c(i9, a(t, j2), false);
                        break;
                    case 35:
                        int i11 = dn.i((List) unsafe.getObject(t, j2));
                        if (i11 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i11);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(i11) + i11;
                            break;
                        }
                    case 36:
                        int h = dn.h((List) unsafe.getObject(t, j2));
                        if (h <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(h) + h;
                            break;
                        }
                    case 37:
                        int a2 = dn.a((List<Long>) unsafe.getObject(t, j2));
                        if (a2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, a2);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(a2) + a2;
                            break;
                        }
                    case 38:
                        int b2 = dn.b((List) unsafe.getObject(t, j2));
                        if (b2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, b2);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(b2) + b2;
                            break;
                        }
                    case 39:
                        int e = dn.e((List) unsafe.getObject(t, j2));
                        if (e <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, e);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(e) + e;
                            break;
                        }
                    case 40:
                        int i12 = dn.i((List) unsafe.getObject(t, j2));
                        if (i12 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i12);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(i12) + i12;
                            break;
                        }
                    case 41:
                        int h2 = dn.h((List) unsafe.getObject(t, j2));
                        if (h2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h2);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(h2) + h2;
                            break;
                        }
                    case 42:
                        int j3 = dn.j((List) unsafe.getObject(t, j2));
                        if (j3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, j3);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(j3) + j3;
                            break;
                        }
                    case 43:
                        int f2 = dn.f((List) unsafe.getObject(t, j2));
                        if (f2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, f2);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(f2) + f2;
                            break;
                        }
                    case 44:
                        int d2 = dn.d((List) unsafe.getObject(t, j2));
                        if (d2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, d2);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(d2) + d2;
                            break;
                        }
                    case 45:
                        int h3 = dn.h((List) unsafe.getObject(t, j2));
                        if (h3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, h3);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(h3) + h3;
                            break;
                        }
                    case 46:
                        int i13 = dn.i((List) unsafe.getObject(t, j2));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i13);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(i13) + i13;
                            break;
                        }
                    case 47:
                        int g = dn.g((List) unsafe.getObject(t, j2));
                        if (g <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, g);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(g) + g;
                            break;
                        }
                    case 48:
                        int c = dn.c((List) unsafe.getObject(t, j2));
                        if (c <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, c);
                            }
                            i7 += zzee.zzbi(i9) + zzee.zzbk(c) + c;
                            break;
                        }
                    case 49:
                        i7 += dn.b(i9, (List<zzgi>) a(t, j2), a(i6));
                        break;
                    case 50:
                        i7 += this.s.a(i9, eg.f(t, j2), b(i6));
                        break;
                    case 51:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzb(i9, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzd(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zze(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzg(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzj(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzc(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((dc<T>) t, i9, i6)) {
                            Object f3 = eg.f(t, j2);
                            if (f3 instanceof zzdp) {
                                i7 += zzee.zzc(i9, (zzdp) f3);
                                break;
                            } else {
                                i7 += zzee.zzc(i9, (String) f3);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += dn.a(i9, eg.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzc(i9, (zzdp) eg.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzh(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzl(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzk(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzi(i9, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.zzf(i9, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((dc<T>) t, i9, i6)) {
                            i7 += zzee.c(i9, (zzgi) eg.f(t, j2), a(i6));
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i3 = 267386880;
            }
            return i7 + a((ed) this.q, (Object) t);
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
            } else if (!this.k || i19 < zzet.DOUBLE_LIST_PACKED.id() || i19 > zzet.SINT64_LIST_PACKED.id()) {
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
                        i15 += zzee.zzb(i18, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzb(i18, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzd(i18, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zze(i18, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzg(i18, unsafe2.getInt(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i17 & i2) != 0) {
                        j = 0;
                        i15 += zzee.zzg(i18, 0L);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzj(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzc(i18, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i17 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzdp) {
                            i15 += zzee.zzc(i18, (zzdp) object);
                            j = 0;
                            break;
                        } else {
                            i15 += zzee.zzc(i18, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i17 & i2) != 0) {
                        i15 += dn.a(i18, unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzc(i18, (zzdp) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzh(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzl(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzk(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzh(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzi(i18, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.zzf(i18, unsafe2.getLong(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i17 & i2) != 0) {
                        i15 += zzee.c(i18, (zzgi) unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i15 += dn.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 19:
                    i15 += dn.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 20:
                    i15 += dn.a(i18, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 21:
                    i15 += dn.b(i18, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 22:
                    i15 += dn.e(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 23:
                    i15 += dn.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 24:
                    i15 += dn.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 25:
                    i15 += dn.j(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 26:
                    i15 += dn.a(i18, (List<?>) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 27:
                    i15 += dn.a(i18, (List<?>) unsafe2.getObject(t, j4), a(i14));
                    j = 0;
                    break;
                case 28:
                    i15 += dn.b(i18, (List) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 29:
                    i15 += dn.f(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 30:
                    i15 += dn.d(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 31:
                    i15 += dn.h(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 32:
                    i15 += dn.i(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 33:
                    i15 += dn.g(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 34:
                    i15 += dn.c(i18, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 35:
                    int i21 = dn.i((List) unsafe2.getObject(t, j4));
                    if (i21 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i21);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(i21) + i21;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int h4 = dn.h((List) unsafe2.getObject(t, j4));
                    if (h4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h4);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(h4) + h4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int a3 = dn.a((List<Long>) unsafe2.getObject(t, j4));
                    if (a3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, a3);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(a3) + a3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int b3 = dn.b((List) unsafe2.getObject(t, j4));
                    if (b3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b3);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(b3) + b3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int e2 = dn.e((List) unsafe2.getObject(t, j4));
                    if (e2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, e2);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(e2) + e2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int i22 = dn.i((List) unsafe2.getObject(t, j4));
                    if (i22 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i22);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(i22) + i22;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int h5 = dn.h((List) unsafe2.getObject(t, j4));
                    if (h5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h5);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(h5) + h5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int j5 = dn.j((List) unsafe2.getObject(t, j4));
                    if (j5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, j5);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(j5) + j5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int f4 = dn.f((List) unsafe2.getObject(t, j4));
                    if (f4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, f4);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(f4) + f4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int d4 = dn.d((List) unsafe2.getObject(t, j4));
                    if (d4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, d4);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(d4) + d4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int h6 = dn.h((List) unsafe2.getObject(t, j4));
                    if (h6 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h6);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(h6) + h6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int i23 = dn.i((List) unsafe2.getObject(t, j4));
                    if (i23 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i23);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(i23) + i23;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int g2 = dn.g((List) unsafe2.getObject(t, j4));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(g2) + g2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int c2 = dn.c((List) unsafe2.getObject(t, j4));
                    if (c2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, c2);
                        }
                        i15 += zzee.zzbi(i18) + zzee.zzbk(c2) + c2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i15 += dn.b(i18, (List<zzgi>) unsafe2.getObject(t, j4), a(i14));
                    j = 0;
                    break;
                case 50:
                    i15 += this.s.a(i18, unsafe2.getObject(t, j4), b(i14));
                    j = 0;
                    break;
                case 51:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzb(i18, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzb(i18, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzd(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zze(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzg(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzg(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzj(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzc(i18, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (a((dc<T>) t, i18, i14)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzdp) {
                            i15 += zzee.zzc(i18, (zzdp) object2);
                            j = 0;
                            break;
                        } else {
                            i15 += zzee.zzc(i18, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += dn.a(i18, unsafe2.getObject(t, j4), a(i14));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzc(i18, (zzdp) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzh(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzl(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzk(i18, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzh(i18, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzi(i18, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.zzf(i18, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (a((dc<T>) t, i18, i14)) {
                        i15 += zzee.c(i18, (zzgi) unsafe2.getObject(t, j4), a(i14));
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
        int a4 = i15 + a((ed) this.q, (Object) t);
        if (!this.h) {
            return a4;
        }
        cb<?> a5 = this.r.a(t);
        int i24 = 0;
        for (int i25 = 0; i25 < a5.f4495a.c(); i25++) {
            Map.Entry<?, Object> b4 = a5.f4495a.b(i25);
            i24 += cb.a((zzeq<?>) b4.getKey(), b4.getValue());
        }
        for (Map.Entry<?, Object> entry : a5.f4495a.d()) {
            i24 += cb.a((zzeq<?>) entry.getKey(), entry.getValue());
        }
        return a4 + i24;
    }

    private static <UT, UB> int a(ed<UT, UB> edVar, T t) {
        return edVar.f(edVar.b(t));
    }

    private static List<?> a(Object obj, long j) {
        return (List) eg.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2b  */
    @Override // com.google.android.gms.internal.measurement.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r14, com.google.android.gms.internal.measurement.ep r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dc.a(java.lang.Object, com.google.android.gms.internal.measurement.ep):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(T r19, com.google.android.gms.internal.measurement.ep r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dc.b(java.lang.Object, com.google.android.gms.internal.measurement.ep):void");
    }

    private final <K, V> void a(ep epVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            epVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(ed<UT, UB> edVar, T t, ep epVar) throws IOException {
        edVar.a((ed<UT, UB>) edVar.b(t), epVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0085. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dl
    public final void a(T t, dm dmVar, zzel zzelVar) throws IOException {
        if (zzelVar == null) {
            throw new NullPointerException();
        }
        ed edVar = this.q;
        ca<?> caVar = this.r;
        cb<?> cbVar = null;
        Object obj = null;
        while (true) {
            try {
                int a2 = dmVar.a();
                int g = g(a2);
                if (g < 0) {
                    if (a2 == Integer.MAX_VALUE) {
                        for (int i = this.m; i < this.n; i++) {
                            obj = a((Object) t, this.l[i], (int) obj, (ed<UT, int>) edVar);
                        }
                        if (obj != null) {
                            edVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a3 = !this.h ? null : caVar.a(zzelVar, this.g, a2);
                    if (a3 != null) {
                        cb<?> b2 = cbVar == null ? caVar.b(t) : cbVar;
                        obj = caVar.a(dmVar, a3, zzelVar, b2, obj, edVar);
                        cbVar = b2;
                    } else {
                        edVar.a(dmVar);
                        if (obj == null) {
                            obj = edVar.c(t);
                        }
                        if (!edVar.a((ed) obj, dmVar)) {
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                obj = a((Object) t, this.l[i2], (int) obj, (ed<UT, int>) edVar);
                            }
                            if (obj != null) {
                                edVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int d = d(g);
                    switch ((267386880 & d) >>> 20) {
                        case 0:
                            eg.a(t, d & 1048575, dmVar.d());
                            b((dc<T>) t, g);
                            break;
                        case 1:
                            eg.a((Object) t, d & 1048575, dmVar.e());
                            b((dc<T>) t, g);
                            break;
                        case 2:
                            eg.a((Object) t, d & 1048575, dmVar.g());
                            b((dc<T>) t, g);
                            break;
                        case 3:
                            eg.a((Object) t, d & 1048575, dmVar.f());
                            b((dc<T>) t, g);
                            break;
                        case 4:
                            eg.a((Object) t, d & 1048575, dmVar.h());
                            b((dc<T>) t, g);
                            break;
                        case 5:
                            eg.a((Object) t, d & 1048575, dmVar.i());
                            b((dc<T>) t, g);
                            break;
                        case 6:
                            eg.a((Object) t, d & 1048575, dmVar.j());
                            b((dc<T>) t, g);
                            break;
                        case 7:
                            eg.a(t, d & 1048575, dmVar.k());
                            b((dc<T>) t, g);
                            break;
                        case 8:
                            a(t, d, dmVar);
                            b((dc<T>) t, g);
                            break;
                        case 9:
                            if (a((dc<T>) t, g)) {
                                long j = d & 1048575;
                                eg.a(t, j, zzez.a(eg.f(t, j), dmVar.a(a(g), zzelVar)));
                                break;
                            } else {
                                eg.a(t, d & 1048575, dmVar.a(a(g), zzelVar));
                                b((dc<T>) t, g);
                                break;
                            }
                        case 10:
                            eg.a(t, d & 1048575, dmVar.n());
                            b((dc<T>) t, g);
                            break;
                        case 11:
                            eg.a((Object) t, d & 1048575, dmVar.o());
                            b((dc<T>) t, g);
                            break;
                        case 12:
                            int p = dmVar.p();
                            zzfe c = c(g);
                            if (c != null && !c.zzg(p)) {
                                obj = dn.a(a2, p, obj, (ed<UT, Object>) edVar);
                                break;
                            }
                            eg.a((Object) t, d & 1048575, p);
                            b((dc<T>) t, g);
                            break;
                        case 13:
                            eg.a((Object) t, d & 1048575, dmVar.q());
                            b((dc<T>) t, g);
                            break;
                        case 14:
                            eg.a((Object) t, d & 1048575, dmVar.r());
                            b((dc<T>) t, g);
                            break;
                        case 15:
                            eg.a((Object) t, d & 1048575, dmVar.s());
                            b((dc<T>) t, g);
                            break;
                        case 16:
                            eg.a((Object) t, d & 1048575, dmVar.t());
                            b((dc<T>) t, g);
                            break;
                        case 17:
                            if (a((dc<T>) t, g)) {
                                long j2 = d & 1048575;
                                eg.a(t, j2, zzez.a(eg.f(t, j2), dmVar.b(a(g), zzelVar)));
                                break;
                            } else {
                                eg.a(t, d & 1048575, dmVar.b(a(g), zzelVar));
                                b((dc<T>) t, g);
                                break;
                            }
                        case 18:
                            dmVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 19:
                            dmVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 20:
                            dmVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 21:
                            dmVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 22:
                            dmVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 23:
                            dmVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 24:
                            dmVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 25:
                            dmVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 26:
                            if (f(d)) {
                                dmVar.j(this.p.a(t, d & 1048575));
                                break;
                            } else {
                                dmVar.i(this.p.a(t, d & 1048575));
                                break;
                            }
                        case 27:
                            dmVar.a(this.p.a(t, d & 1048575), a(g), zzelVar);
                            break;
                        case 28:
                            dmVar.k(this.p.a(t, d & 1048575));
                            break;
                        case 29:
                            dmVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 30:
                            List<Integer> a4 = this.p.a(t, d & 1048575);
                            dmVar.m(a4);
                            obj = dn.a(a2, a4, c(g), obj, edVar);
                            break;
                        case 31:
                            dmVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 32:
                            dmVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 33:
                            dmVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 34:
                            dmVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 35:
                            dmVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 36:
                            dmVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 37:
                            dmVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 38:
                            dmVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 39:
                            dmVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 40:
                            dmVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 41:
                            dmVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 42:
                            dmVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 43:
                            dmVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 44:
                            List<Integer> a5 = this.p.a(t, d & 1048575);
                            dmVar.m(a5);
                            obj = dn.a(a2, a5, c(g), obj, edVar);
                            break;
                        case 45:
                            dmVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 46:
                            dmVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 47:
                            dmVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 48:
                            dmVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 49:
                            dmVar.b(this.p.a(t, d & 1048575), a(g), zzelVar);
                            break;
                        case 50:
                            Object b3 = b(g);
                            long d2 = d(g) & 1048575;
                            Object f = eg.f(t, d2);
                            if (f == null) {
                                f = this.s.e(b3);
                                eg.a(t, d2, f);
                            } else if (this.s.c(f)) {
                                Object e = this.s.e(b3);
                                this.s.a(e, f);
                                eg.a(t, d2, e);
                                f = e;
                            }
                            dmVar.a(this.s.a(f), this.s.f(b3), zzelVar);
                            break;
                        case 51:
                            eg.a(t, d & 1048575, Double.valueOf(dmVar.d()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 52:
                            eg.a(t, d & 1048575, Float.valueOf(dmVar.e()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 53:
                            eg.a(t, d & 1048575, Long.valueOf(dmVar.g()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 54:
                            eg.a(t, d & 1048575, Long.valueOf(dmVar.f()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 55:
                            eg.a(t, d & 1048575, Integer.valueOf(dmVar.h()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 56:
                            eg.a(t, d & 1048575, Long.valueOf(dmVar.i()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 57:
                            eg.a(t, d & 1048575, Integer.valueOf(dmVar.j()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 58:
                            eg.a(t, d & 1048575, Boolean.valueOf(dmVar.k()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 59:
                            a(t, d, dmVar);
                            b((dc<T>) t, a2, g);
                            break;
                        case 60:
                            if (a((dc<T>) t, a2, g)) {
                                long j3 = d & 1048575;
                                eg.a(t, j3, zzez.a(eg.f(t, j3), dmVar.a(a(g), zzelVar)));
                            } else {
                                eg.a(t, d & 1048575, dmVar.a(a(g), zzelVar));
                                b((dc<T>) t, g);
                            }
                            b((dc<T>) t, a2, g);
                            break;
                        case 61:
                            eg.a(t, d & 1048575, dmVar.n());
                            b((dc<T>) t, a2, g);
                            break;
                        case 62:
                            eg.a(t, d & 1048575, Integer.valueOf(dmVar.o()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 63:
                            int p2 = dmVar.p();
                            zzfe c2 = c(g);
                            if (c2 != null && !c2.zzg(p2)) {
                                obj = dn.a(a2, p2, obj, (ed<UT, Object>) edVar);
                                break;
                            }
                            eg.a(t, d & 1048575, Integer.valueOf(p2));
                            b((dc<T>) t, a2, g);
                            break;
                        case 64:
                            eg.a(t, d & 1048575, Integer.valueOf(dmVar.q()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 65:
                            eg.a(t, d & 1048575, Long.valueOf(dmVar.r()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 66:
                            eg.a(t, d & 1048575, Integer.valueOf(dmVar.s()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 67:
                            eg.a(t, d & 1048575, Long.valueOf(dmVar.t()));
                            b((dc<T>) t, a2, g);
                            break;
                        case 68:
                            eg.a(t, d & 1048575, dmVar.b(a(g), zzelVar));
                            b((dc<T>) t, a2, g);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = edVar.a();
                                } catch (zzfh unused) {
                                    edVar.a(dmVar);
                                    if (obj == null) {
                                        obj = edVar.c(t);
                                    }
                                    if (!edVar.a((ed) obj, dmVar)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            obj = a((Object) t, this.l[i3], (int) obj, (ed<UT, int>) edVar);
                                        }
                                        if (obj != null) {
                                            edVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!edVar.a((ed) obj, dmVar)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    obj = a((Object) t, this.l[i4], (int) obj, (ed<UT, int>) edVar);
                                }
                                if (obj != null) {
                                    edVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.m; i5 < this.n; i5++) {
                    obj = a((Object) t, this.l[i5], (int) obj, (ed<UT, int>) edVar);
                }
                if (obj != null) {
                    edVar.b((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    private static zzhs e(Object obj) {
        zzey zzeyVar = (zzey) obj;
        zzhs zzhsVar = zzeyVar.zzahz;
        if (zzhsVar != zzhs.zzwq()) {
            return zzhsVar;
        }
        zzhs a2 = zzhs.a();
        zzeyVar.zzahz = a2;
        return a2;
    }

    private static int a(byte[] bArr, int i, int i2, zzig zzigVar, Class<?> cls, bh bhVar) throws IOException {
        switch (db.f4512a[zzigVar.ordinal()]) {
            case 1:
                int b2 = bi.b(bArr, i, bhVar);
                bhVar.c = Boolean.valueOf(bhVar.b != 0);
                return b2;
            case 2:
                return bi.e(bArr, i, bhVar);
            case 3:
                bhVar.c = Double.valueOf(bi.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                bhVar.c = Integer.valueOf(bi.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                bhVar.c = Long.valueOf(bi.b(bArr, i));
                return i + 8;
            case 8:
                bhVar.c = Float.valueOf(bi.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int a2 = bi.a(bArr, i, bhVar);
                bhVar.c = Integer.valueOf(bhVar.f4486a);
                return a2;
            case 12:
            case 13:
                int b3 = bi.b(bArr, i, bhVar);
                bhVar.c = Long.valueOf(bhVar.b);
                return b3;
            case 14:
                return bi.a(dh.a().a((Class) cls), bArr, i, i2, bhVar);
            case 15:
                int a3 = bi.a(bArr, i, bhVar);
                bhVar.c = Integer.valueOf(zzeb.zzaz(bhVar.f4486a));
                return a3;
            case 16:
                int b4 = bi.b(bArr, i, bhVar);
                bhVar.c = Long.valueOf(zzeb.zzbm(bhVar.b));
                return b4;
            case 17:
                return bi.d(bArr, i, bhVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, bh bhVar) throws IOException {
        int a2;
        zzff zzffVar = (zzff) b.getObject(t, j2);
        if (!zzffVar.zzrx()) {
            int size = zzffVar.size();
            zzffVar = zzffVar.zzap(size == 0 ? 10 : size << 1);
            b.putObject(t, j2, zzffVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    bw bwVar = (bw) zzffVar;
                    int a3 = bi.a(bArr, i, bhVar);
                    int i8 = bhVar.f4486a + a3;
                    while (a3 < i8) {
                        bwVar.a(bi.c(bArr, a3));
                        a3 += 8;
                    }
                    if (a3 == i8) {
                        return a3;
                    }
                    throw zzfi.a();
                }
                if (i5 == 1) {
                    bw bwVar2 = (bw) zzffVar;
                    bwVar2.a(bi.c(bArr, i));
                    int i9 = i + 8;
                    while (i9 < i2) {
                        int a4 = bi.a(bArr, i9, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return i9;
                        }
                        bwVar2.a(bi.c(bArr, a4));
                        i9 = a4 + 8;
                    }
                    return i9;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    cf cfVar = (cf) zzffVar;
                    int a5 = bi.a(bArr, i, bhVar);
                    int i10 = bhVar.f4486a + a5;
                    while (a5 < i10) {
                        cfVar.a(bi.d(bArr, a5));
                        a5 += 4;
                    }
                    if (a5 == i10) {
                        return a5;
                    }
                    throw zzfi.a();
                }
                if (i5 == 5) {
                    cf cfVar2 = (cf) zzffVar;
                    cfVar2.a(bi.d(bArr, i));
                    int i11 = i + 4;
                    while (i11 < i2) {
                        int a6 = bi.a(bArr, i11, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return i11;
                        }
                        cfVar2.a(bi.d(bArr, a6));
                        i11 = a6 + 4;
                    }
                    return i11;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    cr crVar = (cr) zzffVar;
                    int a7 = bi.a(bArr, i, bhVar);
                    int i12 = bhVar.f4486a + a7;
                    while (a7 < i12) {
                        a7 = bi.b(bArr, a7, bhVar);
                        crVar.zzby(bhVar.b);
                    }
                    if (a7 == i12) {
                        return a7;
                    }
                    throw zzfi.a();
                }
                if (i5 == 0) {
                    cr crVar2 = (cr) zzffVar;
                    int b2 = bi.b(bArr, i, bhVar);
                    crVar2.zzby(bhVar.b);
                    while (b2 < i2) {
                        int a8 = bi.a(bArr, b2, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return b2;
                        }
                        b2 = bi.b(bArr, a8, bhVar);
                        crVar2.zzby(bhVar.b);
                    }
                    return b2;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return bi.a(bArr, i, (zzff<?>) zzffVar, bhVar);
                }
                if (i5 == 0) {
                    return bi.a(i3, bArr, i, i2, (zzff<?>) zzffVar, bhVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    cr crVar3 = (cr) zzffVar;
                    int a9 = bi.a(bArr, i, bhVar);
                    int i13 = bhVar.f4486a + a9;
                    while (a9 < i13) {
                        crVar3.zzby(bi.b(bArr, a9));
                        a9 += 8;
                    }
                    if (a9 == i13) {
                        return a9;
                    }
                    throw zzfi.a();
                }
                if (i5 == 1) {
                    cr crVar4 = (cr) zzffVar;
                    crVar4.zzby(bi.b(bArr, i));
                    int i14 = i + 8;
                    while (i14 < i2) {
                        int a10 = bi.a(bArr, i14, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return i14;
                        }
                        crVar4.zzby(bi.b(bArr, a10));
                        i14 = a10 + 8;
                    }
                    return i14;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    ci ciVar = (ci) zzffVar;
                    int a11 = bi.a(bArr, i, bhVar);
                    int i15 = bhVar.f4486a + a11;
                    while (a11 < i15) {
                        ciVar.b(bi.a(bArr, a11));
                        a11 += 4;
                    }
                    if (a11 == i15) {
                        return a11;
                    }
                    throw zzfi.a();
                }
                if (i5 == 5) {
                    ci ciVar2 = (ci) zzffVar;
                    ciVar2.b(bi.a(bArr, i));
                    int i16 = i + 4;
                    while (i16 < i2) {
                        int a12 = bi.a(bArr, i16, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return i16;
                        }
                        ciVar2.b(bi.a(bArr, a12));
                        i16 = a12 + 4;
                    }
                    return i16;
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    bj bjVar = (bj) zzffVar;
                    int a13 = bi.a(bArr, i, bhVar);
                    int i17 = bhVar.f4486a + a13;
                    while (a13 < i17) {
                        a13 = bi.b(bArr, a13, bhVar);
                        bjVar.a(bhVar.b != 0);
                    }
                    if (a13 == i17) {
                        return a13;
                    }
                    throw zzfi.a();
                }
                if (i5 == 0) {
                    bj bjVar2 = (bj) zzffVar;
                    int b3 = bi.b(bArr, i, bhVar);
                    bjVar2.a(bhVar.b != 0);
                    while (b3 < i2) {
                        int a14 = bi.a(bArr, b3, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return b3;
                        }
                        b3 = bi.b(bArr, a14, bhVar);
                        bjVar2.a(bhVar.b != 0);
                    }
                    return b3;
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int a15 = bi.a(bArr, i, bhVar);
                        int i18 = bhVar.f4486a;
                        if (i18 < 0) {
                            throw zzfi.b();
                        }
                        if (i18 == 0) {
                            zzffVar.add("");
                        } else {
                            zzffVar.add(new String(bArr, a15, i18, zzez.f4562a));
                            a15 += i18;
                        }
                        while (a15 < i2) {
                            int a16 = bi.a(bArr, a15, bhVar);
                            if (i3 != bhVar.f4486a) {
                                return a15;
                            }
                            a15 = bi.a(bArr, a16, bhVar);
                            int i19 = bhVar.f4486a;
                            if (i19 < 0) {
                                throw zzfi.b();
                            }
                            if (i19 == 0) {
                                zzffVar.add("");
                            } else {
                                zzffVar.add(new String(bArr, a15, i19, zzez.f4562a));
                                a15 += i19;
                            }
                        }
                        return a15;
                    }
                    int a17 = bi.a(bArr, i, bhVar);
                    int i20 = bhVar.f4486a;
                    if (i20 < 0) {
                        throw zzfi.b();
                    }
                    if (i20 == 0) {
                        zzffVar.add("");
                    } else {
                        int i21 = a17 + i20;
                        if (!ej.a(bArr, a17, i21)) {
                            throw zzfi.i();
                        }
                        zzffVar.add(new String(bArr, a17, i20, zzez.f4562a));
                        a17 = i21;
                    }
                    while (a17 < i2) {
                        int a18 = bi.a(bArr, a17, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return a17;
                        }
                        a17 = bi.a(bArr, a18, bhVar);
                        int i22 = bhVar.f4486a;
                        if (i22 < 0) {
                            throw zzfi.b();
                        }
                        if (i22 == 0) {
                            zzffVar.add("");
                        } else {
                            int i23 = a17 + i22;
                            if (!ej.a(bArr, a17, i23)) {
                                throw zzfi.i();
                            }
                            zzffVar.add(new String(bArr, a17, i22, zzez.f4562a));
                            a17 = i23;
                        }
                    }
                    return a17;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return bi.a(a(i6), i3, bArr, i, i2, zzffVar, bhVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int a19 = bi.a(bArr, i, bhVar);
                    int i24 = bhVar.f4486a;
                    if (i24 < 0) {
                        throw zzfi.b();
                    }
                    if (i24 > bArr.length - a19) {
                        throw zzfi.a();
                    }
                    if (i24 == 0) {
                        zzffVar.add(zzdp.zzadh);
                    } else {
                        zzffVar.add(zzdp.zzb(bArr, a19, i24));
                        a19 += i24;
                    }
                    while (a19 < i2) {
                        int a20 = bi.a(bArr, a19, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return a19;
                        }
                        a19 = bi.a(bArr, a20, bhVar);
                        int i25 = bhVar.f4486a;
                        if (i25 < 0) {
                            throw zzfi.b();
                        }
                        if (i25 > bArr.length - a19) {
                            throw zzfi.a();
                        }
                        if (i25 == 0) {
                            zzffVar.add(zzdp.zzadh);
                        } else {
                            zzffVar.add(zzdp.zzb(bArr, a19, i25));
                            a19 += i25;
                        }
                    }
                    return a19;
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        a2 = bi.a(i3, bArr, i, i2, (zzff<?>) zzffVar, bhVar);
                    }
                    return i;
                }
                a2 = bi.a(bArr, i, (zzff<?>) zzffVar, bhVar);
                zzey zzeyVar = (zzey) t;
                zzhs zzhsVar = zzeyVar.zzahz;
                if (zzhsVar == zzhs.zzwq()) {
                    zzhsVar = null;
                }
                zzhs zzhsVar2 = (zzhs) dn.a(i4, zzffVar, c(i6), zzhsVar, this.q);
                if (zzhsVar2 != null) {
                    zzeyVar.zzahz = zzhsVar2;
                }
                return a2;
            case 33:
            case 47:
                if (i5 == 2) {
                    ci ciVar3 = (ci) zzffVar;
                    int a21 = bi.a(bArr, i, bhVar);
                    int i26 = bhVar.f4486a + a21;
                    while (a21 < i26) {
                        a21 = bi.a(bArr, a21, bhVar);
                        ciVar3.b(zzeb.zzaz(bhVar.f4486a));
                    }
                    if (a21 == i26) {
                        return a21;
                    }
                    throw zzfi.a();
                }
                if (i5 == 0) {
                    ci ciVar4 = (ci) zzffVar;
                    int a22 = bi.a(bArr, i, bhVar);
                    ciVar4.b(zzeb.zzaz(bhVar.f4486a));
                    while (a22 < i2) {
                        int a23 = bi.a(bArr, a22, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return a22;
                        }
                        a22 = bi.a(bArr, a23, bhVar);
                        ciVar4.b(zzeb.zzaz(bhVar.f4486a));
                    }
                    return a22;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    cr crVar5 = (cr) zzffVar;
                    int a24 = bi.a(bArr, i, bhVar);
                    int i27 = bhVar.f4486a + a24;
                    while (a24 < i27) {
                        a24 = bi.b(bArr, a24, bhVar);
                        crVar5.zzby(zzeb.zzbm(bhVar.b));
                    }
                    if (a24 == i27) {
                        return a24;
                    }
                    throw zzfi.a();
                }
                if (i5 == 0) {
                    cr crVar6 = (cr) zzffVar;
                    int b4 = bi.b(bArr, i, bhVar);
                    crVar6.zzby(zzeb.zzbm(bhVar.b));
                    while (b4 < i2) {
                        int a25 = bi.a(bArr, b4, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return b4;
                        }
                        b4 = bi.b(bArr, a25, bhVar);
                        crVar6.zzby(zzeb.zzbm(bhVar.b));
                    }
                    return b4;
                }
                return i;
            case 49:
                if (i5 == 3) {
                    dl a26 = a(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int a27 = bi.a(a26, bArr, i, i2, i28, bhVar);
                    zzffVar.add(bhVar.c);
                    while (a27 < i2) {
                        int a28 = bi.a(bArr, a27, bhVar);
                        if (i3 != bhVar.f4486a) {
                            return a27;
                        }
                        a27 = bi.a(a26, bArr, a28, i2, i28, bhVar);
                        zzffVar.add(bhVar.c);
                    }
                    return a27;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, bh bhVar) throws IOException {
        int i4;
        Unsafe unsafe = b;
        Object b2 = b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.s.c(object)) {
            Object e = this.s.e(b2);
            this.s.a(e, object);
            unsafe.putObject(t, j, e);
            object = e;
        }
        cu<?, ?> f = this.s.f(b2);
        Map<?, ?> a2 = this.s.a(object);
        int a3 = bi.a(bArr, i, bhVar);
        int i5 = bhVar.f4486a;
        if (i5 < 0 || i5 > i2 - a3) {
            throw zzfi.a();
        }
        int i6 = i5 + a3;
        K k = f.b;
        V v = f.d;
        while (a3 < i6) {
            int i7 = a3 + 1;
            int i8 = bArr[a3];
            if (i8 < 0) {
                int a4 = bi.a(i8, bArr, i7, bhVar);
                i8 = bhVar.f4486a;
                i4 = a4;
            } else {
                i4 = i7;
            }
            int i9 = i8 & 7;
            switch (i8 >>> 3) {
                case 1:
                    if (i9 != f.f4510a.zzxa()) {
                        break;
                    } else {
                        a3 = a(bArr, i4, i2, f.f4510a, (Class<?>) null, bhVar);
                        k = (K) bhVar.c;
                        break;
                    }
                case 2:
                    if (i9 != f.c.zzxa()) {
                        break;
                    } else {
                        a3 = a(bArr, i4, i2, f.c, f.d.getClass(), bhVar);
                        v = bhVar.c;
                        break;
                    }
            }
            a3 = bi.a(i8, bArr, i4, i2, bhVar);
        }
        if (a3 != i6) {
            throw zzfi.h();
        }
        a2.put(k, v);
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, bh bhVar) throws IOException {
        int i9;
        Unsafe unsafe = b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(bi.c(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(bi.d(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = bi.b(bArr, i, bhVar);
                    unsafe.putObject(t, j, Long.valueOf(bhVar.b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = bi.a(bArr, i, bhVar);
                    unsafe.putObject(t, j, Integer.valueOf(bhVar.f4486a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(bi.b(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(bi.a(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = bi.b(bArr, i, bhVar);
                    unsafe.putObject(t, j, Boolean.valueOf(bhVar.b != 0));
                    break;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int a2 = bi.a(bArr, i, bhVar);
                    int i10 = bhVar.f4486a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & DriveFile.MODE_WRITE_ONLY) != 0 && !ej.a(bArr, a2, a2 + i10)) {
                            throw zzfi.i();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i10, zzez.f4562a));
                        a2 += i10;
                    }
                    unsafe.putInt(t, j2, i4);
                    return a2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int a3 = bi.a(a(i8), bArr, i, i2, bhVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, bhVar.c);
                    } else {
                        unsafe.putObject(t, j, zzez.a(object, bhVar.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return a3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = bi.e(bArr, i, bhVar);
                    unsafe.putObject(t, j, bhVar.c);
                    break;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a4 = bi.a(bArr, i, bhVar);
                    int i11 = bhVar.f4486a;
                    zzfe c = c(i8);
                    if (c == null || c.zzg(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = a4;
                        break;
                    } else {
                        e(t).a(i3, Long.valueOf(i11));
                        return a4;
                    }
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = bi.a(bArr, i, bhVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzeb.zzaz(bhVar.f4486a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = bi.b(bArr, i, bhVar);
                    unsafe.putObject(t, j, Long.valueOf(zzeb.zzbm(bhVar.b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = bi.a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, bhVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, bhVar.c);
                        break;
                    } else {
                        unsafe.putObject(t, j, zzez.a(object2, bhVar.c));
                        break;
                    }
                }
                return i;
            default:
                return i;
        }
        unsafe.putInt(t, j2, i4);
        return i9;
    }

    private final dl a(int i) {
        int i2 = (i / 3) << 1;
        dl dlVar = (dl) this.d[i2];
        if (dlVar != null) {
            return dlVar;
        }
        dl<T> a2 = dh.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final zzfe c(int i) {
        return (zzfe) this.d[((i / 3) << 1) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0562, code lost:
    
        if (r0 == r4) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0564, code lost:
    
        r26.putInt(r11, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x056a, code lost:
    
        r0 = null;
        r1 = r8.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x056f, code lost:
    
        if (r1 >= r8.n) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0571, code lost:
    
        r0 = (com.google.android.gms.internal.measurement.zzhs) r8.a(r11, r8.l[r1], (int) r0, (com.google.android.gms.internal.measurement.ed<UT, int>) r8.q);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0580, code lost:
    
        if (r0 == null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0582, code lost:
    
        r8.q.b(r11, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0587, code lost:
    
        if (r6 != 0) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x058b, code lost:
    
        if (r2 != r32) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0592, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfi.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0599, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0595, code lost:
    
        if (r2 > r32) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0597, code lost:
    
        if (r3 != r6) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x059e, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfi.h();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:116:0x0087. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.bh r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dc.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.bh):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.measurement.dl
    public final void a(T t, byte[] bArr, int i, int i2, bh bhVar) throws IOException {
        byte b2;
        int i3;
        int g;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        dc<T> dcVar = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i8 = i2;
        bh bhVar2 = bhVar;
        if (dcVar.j) {
            Unsafe unsafe2 = b;
            int i9 = -1;
            int i10 = i;
            int i11 = -1;
            int i12 = 0;
            while (i10 < i8) {
                int i13 = i10 + 1;
                byte b3 = bArr2[i10];
                if (b3 < 0) {
                    i3 = bi.a(b3, bArr2, i13, bhVar2);
                    b2 = bhVar2.f4486a;
                } else {
                    b2 = b3;
                    i3 = i13;
                }
                int i14 = b2 >>> 3;
                int i15 = b2 & 7;
                if (i14 > i11) {
                    g = dcVar.a(i14, i12 / 3);
                } else {
                    g = dcVar.g(i14);
                }
                if (g == i9) {
                    i4 = i14;
                    i5 = i3;
                    unsafe = unsafe2;
                    i6 = 0;
                } else {
                    int i16 = dcVar.c[g + 1];
                    int i17 = (267386880 & i16) >>> 20;
                    long j = 1048575 & i16;
                    if (i17 <= 17) {
                        switch (i17) {
                            case 0:
                                int i18 = g;
                                if (i15 != 1) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i18;
                                    break;
                                } else {
                                    eg.a(t2, j, bi.c(bArr2, i3));
                                    i10 = i3 + 8;
                                    i11 = i14;
                                    i12 = i18;
                                    i9 = -1;
                                    break;
                                }
                            case 1:
                                int i19 = g;
                                if (i15 != 5) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    break;
                                } else {
                                    eg.a((Object) t2, j, bi.d(bArr2, i3));
                                    i10 = i3 + 4;
                                    i11 = i14;
                                    i12 = i19;
                                    i9 = -1;
                                    break;
                                }
                            case 2:
                            case 3:
                                int i20 = g;
                                if (i15 != 0) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i20;
                                    break;
                                } else {
                                    int b4 = bi.b(bArr2, i3, bhVar2);
                                    unsafe2.putLong(t, j, bhVar2.b);
                                    i10 = b4;
                                    i11 = i14;
                                    i12 = i20;
                                    i9 = -1;
                                    break;
                                }
                            case 4:
                            case 11:
                                int i21 = g;
                                if (i15 != 0) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i21;
                                    break;
                                } else {
                                    i10 = bi.a(bArr2, i3, bhVar2);
                                    unsafe2.putInt(t2, j, bhVar2.f4486a);
                                    i11 = i14;
                                    i12 = i21;
                                    i9 = -1;
                                    break;
                                }
                            case 5:
                            case 14:
                                if (i15 != 1) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, bi.b(bArr2, i3));
                                    i10 = i3 + 8;
                                    i11 = i14;
                                    i12 = g;
                                    i9 = -1;
                                    break;
                                }
                            case 6:
                            case 13:
                                if (i15 != 5) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    unsafe2.putInt(t2, j, bi.a(bArr2, i3));
                                    i10 = i3 + 4;
                                    i12 = g;
                                    i11 = i14;
                                    i9 = -1;
                                    break;
                                }
                            case 7:
                                if (i15 != 0) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    int b5 = bi.b(bArr2, i3, bhVar2);
                                    eg.a(t2, j, bhVar2.b != 0);
                                    i10 = b5;
                                    i12 = g;
                                    i11 = i14;
                                    i9 = -1;
                                    break;
                                }
                            case 8:
                                if (i15 != 2) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    if ((536870912 & i16) == 0) {
                                        i10 = bi.c(bArr2, i3, bhVar2);
                                    } else {
                                        i10 = bi.d(bArr2, i3, bhVar2);
                                    }
                                    unsafe2.putObject(t2, j, bhVar2.c);
                                    i12 = g;
                                    i11 = i14;
                                    i9 = -1;
                                    break;
                                }
                            case 9:
                                if (i15 != 2) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    i10 = bi.a(dcVar.a(g), bArr2, i3, i8, bhVar2);
                                    Object object = unsafe2.getObject(t2, j);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j, bhVar2.c);
                                    } else {
                                        unsafe2.putObject(t2, j, zzez.a(object, bhVar2.c));
                                    }
                                    i12 = g;
                                    i11 = i14;
                                    i9 = -1;
                                    break;
                                }
                            case 10:
                                if (i15 != 2) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    i10 = bi.e(bArr2, i3, bhVar2);
                                    unsafe2.putObject(t2, j, bhVar2.c);
                                    i12 = g;
                                    i11 = i14;
                                    i9 = -1;
                                    break;
                                }
                            case 12:
                                int i22 = g;
                                if (i15 != 0) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i22;
                                    break;
                                } else {
                                    i10 = bi.a(bArr2, i3, bhVar2);
                                    unsafe2.putInt(t2, j, bhVar2.f4486a);
                                    i11 = i14;
                                    i12 = i22;
                                    i9 = -1;
                                    break;
                                }
                            case 15:
                                int i23 = g;
                                if (i15 != 0) {
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    i6 = i23;
                                    break;
                                } else {
                                    i10 = bi.a(bArr2, i3, bhVar2);
                                    unsafe2.putInt(t2, j, zzeb.zzaz(bhVar2.f4486a));
                                    i11 = i14;
                                    i12 = i23;
                                    i9 = -1;
                                    break;
                                }
                            case 16:
                                if (i15 != 0) {
                                    i6 = g;
                                    i4 = i14;
                                    i7 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    int b6 = bi.b(bArr2, i3, bhVar2);
                                    unsafe2.putLong(t, j, zzeb.zzbm(bhVar2.b));
                                    i10 = b6;
                                    i11 = i14;
                                    i12 = g;
                                    i9 = -1;
                                    break;
                                }
                            default:
                                i6 = g;
                                i4 = i14;
                                i7 = i3;
                                unsafe = unsafe2;
                                break;
                        }
                        i5 = i7;
                    } else if (i17 != 27) {
                        i6 = g;
                        if (i17 <= 49) {
                            i4 = i14;
                            int i24 = i3;
                            unsafe = unsafe2;
                            i10 = a((dc<T>) t, bArr, i3, i2, b2, i14, i15, i6, i16, i17, j, bhVar);
                            if (i10 == i24) {
                                i5 = i10;
                            } else {
                                t2 = t;
                                bArr2 = bArr;
                                bhVar2 = bhVar;
                                unsafe2 = unsafe;
                                i12 = i6;
                                i11 = i4;
                                i9 = -1;
                                i8 = i2;
                                dcVar = this;
                            }
                        } else {
                            i4 = i14;
                            i7 = i3;
                            unsafe = unsafe2;
                            if (i17 != 50) {
                                i10 = a((dc<T>) t, bArr, i7, i2, b2, i4, i15, i16, i17, j, i6, bhVar);
                                if (i10 == i7) {
                                    i5 = i10;
                                } else {
                                    t2 = t;
                                    bArr2 = bArr;
                                    bhVar2 = bhVar;
                                    unsafe2 = unsafe;
                                    i12 = i6;
                                    i11 = i4;
                                    i9 = -1;
                                    i8 = i2;
                                    dcVar = this;
                                }
                            } else if (i15 == 2) {
                                i10 = a((dc<T>) t, bArr, i7, i2, i6, j, bhVar);
                                if (i10 == i7) {
                                    i5 = i10;
                                } else {
                                    t2 = t;
                                    bArr2 = bArr;
                                    bhVar2 = bhVar;
                                    unsafe2 = unsafe;
                                    i12 = i6;
                                    i11 = i4;
                                    i9 = -1;
                                    i8 = i2;
                                    dcVar = this;
                                }
                            } else {
                                i5 = i7;
                            }
                        }
                    } else if (i15 == 2) {
                        zzff zzffVar = (zzff) unsafe2.getObject(t2, j);
                        if (!zzffVar.zzrx()) {
                            int size = zzffVar.size();
                            zzffVar = zzffVar.zzap(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j, zzffVar);
                        }
                        i10 = bi.a(dcVar.a(g), b2, bArr, i3, i2, zzffVar, bhVar);
                        i11 = i14;
                        i12 = g;
                        i9 = -1;
                    } else {
                        i6 = g;
                        i4 = i14;
                        i7 = i3;
                        unsafe = unsafe2;
                        i5 = i7;
                    }
                }
                i10 = bi.a(b2, bArr, i5, i2, e(t), bhVar);
                t2 = t;
                bArr2 = bArr;
                bhVar2 = bhVar;
                unsafe2 = unsafe;
                i12 = i6;
                i11 = i4;
                i9 = -1;
                i8 = i2;
                dcVar = this;
            }
            if (i10 != i8) {
                throw zzfi.h();
            }
            return;
        }
        a((dc<T>) t, bArr, i, i2, 0, bhVar);
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final void c(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d = d(this.l[i2]) & 1048575;
            Object f = eg.f(t, d);
            if (f != null) {
                eg.a(t, d, this.s.d(f));
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

    private final <UT, UB> UB a(Object obj, int i, UB ub, ed<UT, UB> edVar) {
        zzfe c;
        int i2 = this.c[i];
        Object f = eg.f(obj, d(i) & 1048575);
        return (f == null || (c = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(f), c, (zzfe) ub, (ed<UT, zzfe>) edVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzfe zzfeVar, UB ub, ed<UT, UB> edVar) {
        cu<?, ?> f = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfeVar.zzg(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = edVar.a();
                }
                bp b2 = zzdp.b(zzga.a(f, next.getKey(), next.getValue()));
                try {
                    zzga.a(b2.b(), f, next.getKey(), next.getValue());
                    edVar.a((ed<UT, UB>) ub, i2, b2.a());
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
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.dl] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.dl] */
    @Override // com.google.android.gms.internal.measurement.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dc.d(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, dl dlVar) {
        return dlVar.d(eg.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, ep epVar) throws IOException {
        if (obj instanceof String) {
            epVar.a(i, (String) obj);
        } else {
            epVar.a(i, (zzdp) obj);
        }
    }

    private final void a(Object obj, int i, dm dmVar) throws IOException {
        if (f(i)) {
            eg.a(obj, i & 1048575, dmVar.m());
        } else if (this.i) {
            eg.a(obj, i & 1048575, dmVar.l());
        } else {
            eg.a(obj, i & 1048575, dmVar.n());
        }
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> double b(T t, long j) {
        return ((Double) eg.f(t, j)).doubleValue();
    }

    private static <T> float c(T t, long j) {
        return ((Float) eg.f(t, j)).floatValue();
    }

    private static <T> int d(T t, long j) {
        return ((Integer) eg.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) eg.f(t, j)).longValue();
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) eg.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((dc<T>) t, i) == a((dc<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((dc<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d = d(i);
            long j = d & 1048575;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    return eg.e(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return eg.d(t, j) != 0.0f;
                case 2:
                    return eg.b(t, j) != 0;
                case 3:
                    return eg.b(t, j) != 0;
                case 4:
                    return eg.a(t, j) != 0;
                case 5:
                    return eg.b(t, j) != 0;
                case 6:
                    return eg.a(t, j) != 0;
                case 7:
                    return eg.c(t, j);
                case 8:
                    Object f = eg.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzdp) {
                        return !zzdp.zzadh.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return eg.f(t, j) != null;
                case 10:
                    return !zzdp.zzadh.equals(eg.f(t, j));
                case 11:
                    return eg.a(t, j) != 0;
                case 12:
                    return eg.a(t, j) != 0;
                case 13:
                    return eg.a(t, j) != 0;
                case 14:
                    return eg.b(t, j) != 0;
                case 15:
                    return eg.a(t, j) != 0;
                case 16:
                    return eg.b(t, j) != 0;
                case 17:
                    return eg.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e = e(i);
        return (eg.a(t, (long) (e & 1048575)) & (1 << (e >>> 20))) != 0;
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e = e(i);
        long j = e & 1048575;
        eg.a((Object) t, j, eg.a(t, j) | (1 << (e >>> 20)));
    }

    private final boolean a(T t, int i, int i2) {
        return eg.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        eg.a((Object) t, e(i2) & 1048575, i);
    }

    private final int g(int i) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, 0);
    }

    private final int a(int i, int i2) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, i2);
    }

    private final int b(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
