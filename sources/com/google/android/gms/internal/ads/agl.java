package com.google.android.gms.internal.ads;

import com.amazonaws.event.ProgressEvent;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzdob;
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
public final class agl<T> implements agx<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f1864a = new int[0];
    private static final Unsafe b = ahs.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzdpk g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final ago o;
    private final afv p;
    private final aho<?, ?> q;
    private final afh<?> r;
    private final agf s;

    private agl(int[] iArr, Object[] objArr, int i, int i2, zzdpk zzdpkVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, ago agoVar, afv afvVar, aho<?, ?> ahoVar, afh<?> afhVar, agf agfVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzdpkVar instanceof zzdob;
        this.j = z;
        this.h = afhVar != null && afhVar.a(zzdpkVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = agoVar;
        this.p = afvVar;
        this.q = ahoVar;
        this.r = afhVar;
        this.g = zzdpkVar;
        this.s = agfVar;
    }

    private static boolean f(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> agl<T> a(Class<T> cls, agi agiVar, ago agoVar, afv afvVar, aho<?, ?> ahoVar, afh<?> afhVar, agf agfVar) {
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
        if (agiVar instanceof agu) {
            agu aguVar = (agu) agiVar;
            int i25 = 0;
            boolean z = aguVar.a() == zzdob.zze.zzhht;
            String d = aguVar.d();
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
                iArr = f1864a;
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
            Object[] e = aguVar.e();
            Class<?> cls3 = aguVar.c().getClass();
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
            return new agl<>(iArr2, objArr, c2, charAt, aguVar.c(), z, false, iArr, i25, i60, agoVar, afvVar, ahoVar, afhVar, agfVar);
        }
        ((ahk) agiVar).a();
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

    @Override // com.google.android.gms.internal.ads.agx
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01d8 A[LOOP:0: B:2:0x0005->B:104:0x01d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.agx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = d(i2);
            int i3 = this.c[i2];
            long j = 1048575 & d;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzdod.zzft(Double.doubleToLongBits(ahs.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(ahs.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzdod.zzft(ahs.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzdod.zzft(ahs.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzdod.zzft(ahs.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzdod.zzbh(ahs.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) ahs.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = ahs.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + ahs.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzdod.zzft(ahs.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + ahs.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzdod.zzft(ahs.b(t, j));
                    break;
                case 17:
                    Object f2 = ahs.f(t, j);
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
                    i = (i * 53) + ahs.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + ahs.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(Double.doubleToLongBits(b(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(c(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzbh(f(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + ((String) ahs.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + ahs.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + ahs.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + zzdod.zzft(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((agl<T>) t, i3, i2)) {
                        i = (i * 53) + ahs.f(t, j).hashCode();
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
    @Override // com.google.android.gms.internal.ads.agx
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
                    if (a((agl<T>) t2, i)) {
                        ahs.a(t, j, ahs.e(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.d(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.b(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.b(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.b(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((agl<T>) t2, i)) {
                        ahs.a(t, j, ahs.c(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((agl<T>) t2, i)) {
                        ahs.a(t, j, ahs.f(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((agl<T>) t2, i)) {
                        ahs.a(t, j, ahs.f(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.b(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.a(t2, j));
                        b((agl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((agl<T>) t2, i)) {
                        ahs.a((Object) t, j, ahs.b(t2, j));
                        b((agl<T>) t, i);
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
                    agz.a(this.s, t, t2, j);
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
                    if (a((agl<T>) t2, i2, i)) {
                        ahs.a(t, j, ahs.f(t2, j));
                        b((agl<T>) t, i2, i);
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
                    if (a((agl<T>) t2, i2, i)) {
                        ahs.a(t, j, ahs.f(t2, j));
                        b((agl<T>) t, i2, i);
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
        agz.a(this.q, t, t2);
        if (this.h) {
            agz.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long d = d(i) & 1048575;
        if (a((agl<T>) t2, i)) {
            Object f = ahs.f(t, d);
            Object f2 = ahs.f(t2, d);
            if (f != null && f2 != null) {
                ahs.a(t, d, zzdod.a(f, f2));
                b((agl<T>) t, i);
            } else if (f2 != null) {
                ahs.a(t, d, f2);
                b((agl<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.c[i];
        long j = d & 1048575;
        if (a((agl<T>) t2, i2, i)) {
            Object f = ahs.f(t, j);
            Object f2 = ahs.f(t2, j);
            if (f != null && f2 != null) {
                ahs.a(t, j, zzdod.a(f, f2));
                b((agl<T>) t, i2, i);
            } else if (f2 != null) {
                ahs.a(t, j, f2);
                b((agl<T>) t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final int b(T t) {
        int i;
        int i2;
        long j;
        int i3 = 267386880;
        if (this.j) {
            Unsafe unsafe = b;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.c.length) {
                int d = d(i4);
                int i6 = (d & i3) >>> 20;
                int i7 = this.c[i4];
                long j2 = d & 1048575;
                int i8 = (i6 < zzdnv.DOUBLE_LIST_PACKED.id() || i6 > zzdnv.SINT64_LIST_PACKED.id()) ? 0 : this.c[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzc(i7, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzk(i7, ahs.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzl(i7, ahs.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzab(i7, ahs.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzn(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzae(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzj(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((agl<T>) t, i4)) {
                            Object f = ahs.f(t, j2);
                            if (f instanceof zzdmr) {
                                i5 += zzdni.zzc(i7, (zzdmr) f);
                                break;
                            } else {
                                i5 += zzdni.zzg(i7, (String) f);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (a((agl<T>) t, i4)) {
                            i5 += agz.a(i7, ahs.f(t, j2), a(i4));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzc(i7, (zzdmr) ahs.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzac(i7, ahs.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzag(i7, ahs.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzaf(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzo(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzad(i7, ahs.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.zzm(i7, ahs.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((agl<T>) t, i4)) {
                            i5 += zzdni.c(i7, (zzdpk) ahs.f(t, j2), a(i4));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i5 += agz.i(i7, a(t, j2), false);
                        break;
                    case 19:
                        i5 += agz.h(i7, a(t, j2), false);
                        break;
                    case 20:
                        i5 += agz.a(i7, (List<Long>) a(t, j2), false);
                        break;
                    case 21:
                        i5 += agz.b(i7, (List<Long>) a(t, j2), false);
                        break;
                    case 22:
                        i5 += agz.e(i7, a(t, j2), false);
                        break;
                    case 23:
                        i5 += agz.i(i7, a(t, j2), false);
                        break;
                    case 24:
                        i5 += agz.h(i7, a(t, j2), false);
                        break;
                    case 25:
                        i5 += agz.j(i7, a(t, j2), false);
                        break;
                    case 26:
                        i5 += agz.a(i7, (List<?>) a(t, j2));
                        break;
                    case 27:
                        i5 += agz.a(i7, (List<?>) a(t, j2), a(i4));
                        break;
                    case 28:
                        i5 += agz.b(i7, a(t, j2));
                        break;
                    case 29:
                        i5 += agz.f(i7, a(t, j2), false);
                        break;
                    case 30:
                        i5 += agz.d(i7, a(t, j2), false);
                        break;
                    case 31:
                        i5 += agz.h(i7, a(t, j2), false);
                        break;
                    case 32:
                        i5 += agz.i(i7, a(t, j2), false);
                        break;
                    case 33:
                        i5 += agz.g(i7, a(t, j2), false);
                        break;
                    case 34:
                        i5 += agz.c(i7, a(t, j2), false);
                        break;
                    case 35:
                        int i9 = agz.i((List) unsafe.getObject(t, j2));
                        if (i9 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, i9);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(i9) + i9;
                            break;
                        }
                    case 36:
                        int h = agz.h((List) unsafe.getObject(t, j2));
                        if (h <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, h);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(h) + h;
                            break;
                        }
                    case 37:
                        int a2 = agz.a((List<Long>) unsafe.getObject(t, j2));
                        if (a2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, a2);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(a2) + a2;
                            break;
                        }
                    case 38:
                        int b2 = agz.b((List) unsafe.getObject(t, j2));
                        if (b2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b2);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(b2) + b2;
                            break;
                        }
                    case 39:
                        int e = agz.e((List) unsafe.getObject(t, j2));
                        if (e <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, e);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(e) + e;
                            break;
                        }
                    case 40:
                        int i10 = agz.i((List) unsafe.getObject(t, j2));
                        if (i10 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, i10);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(i10) + i10;
                            break;
                        }
                    case 41:
                        int h2 = agz.h((List) unsafe.getObject(t, j2));
                        if (h2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, h2);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(h2) + h2;
                            break;
                        }
                    case 42:
                        int j3 = agz.j((List) unsafe.getObject(t, j2));
                        if (j3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, j3);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(j3) + j3;
                            break;
                        }
                    case 43:
                        int f2 = agz.f((List) unsafe.getObject(t, j2));
                        if (f2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, f2);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(f2) + f2;
                            break;
                        }
                    case 44:
                        int d2 = agz.d((List) unsafe.getObject(t, j2));
                        if (d2 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, d2);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(d2) + d2;
                            break;
                        }
                    case 45:
                        int h3 = agz.h((List) unsafe.getObject(t, j2));
                        if (h3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, h3);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(h3) + h3;
                            break;
                        }
                    case 46:
                        int i11 = agz.i((List) unsafe.getObject(t, j2));
                        if (i11 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, i11);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(i11) + i11;
                            break;
                        }
                    case 47:
                        int g = agz.g((List) unsafe.getObject(t, j2));
                        if (g <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(g) + g;
                            break;
                        }
                    case 48:
                        int c = agz.c((List) unsafe.getObject(t, j2));
                        if (c <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, c);
                            }
                            i5 += zzdni.zzgd(i7) + zzdni.zzgf(c) + c;
                            break;
                        }
                    case 49:
                        i5 += agz.b(i7, (List<zzdpk>) a(t, j2), a(i4));
                        break;
                    case 50:
                        i5 += this.s.a(i7, ahs.f(t, j2), b(i4));
                        break;
                    case 51:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzc(i7, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzk(i7, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzl(i7, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzab(i7, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzn(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzae(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzj(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((agl<T>) t, i7, i4)) {
                            Object f3 = ahs.f(t, j2);
                            if (f3 instanceof zzdmr) {
                                i5 += zzdni.zzc(i7, (zzdmr) f3);
                                break;
                            } else {
                                i5 += zzdni.zzg(i7, (String) f3);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += agz.a(i7, ahs.f(t, j2), a(i4));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzc(i7, (zzdmr) ahs.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzac(i7, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzag(i7, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzaf(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzo(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzad(i7, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.zzm(i7, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((agl<T>) t, i7, i4)) {
                            i5 += zzdni.c(i7, (zzdpk) ahs.f(t, j2), a(i4));
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + a((aho) this.q, (Object) t);
        }
        Unsafe unsafe2 = b;
        int i12 = 0;
        int i13 = -1;
        int i14 = 0;
        for (int i15 = 0; i15 < this.c.length; i15 += 3) {
            int d3 = d(i15);
            int[] iArr = this.c;
            int i16 = iArr[i15];
            int i17 = (d3 & 267386880) >>> 20;
            if (i17 <= 17) {
                i = iArr[i15 + 2];
                int i18 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i18 != i13) {
                    i14 = unsafe2.getInt(t, i18);
                } else {
                    i18 = i13;
                }
                i13 = i18;
            } else if (!this.k || i17 < zzdnv.DOUBLE_LIST_PACKED.id() || i17 > zzdnv.SINT64_LIST_PACKED.id()) {
                i = 0;
                i2 = 0;
            } else {
                i = this.c[i15 + 2] & 1048575;
                i2 = 0;
            }
            long j4 = d3 & 1048575;
            switch (i17) {
                case 0:
                    j = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzc(i16, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzb(i16, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzk(i16, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzl(i16, unsafe2.getLong(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzab(i16, unsafe2.getInt(t, j4));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i14 & i2) != 0) {
                        j = 0;
                        i12 += zzdni.zzn(i16, 0L);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzae(i16, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzj(i16, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i14 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzdmr) {
                            i12 += zzdni.zzc(i16, (zzdmr) object);
                            j = 0;
                            break;
                        } else {
                            i12 += zzdni.zzg(i16, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i14 & i2) != 0) {
                        i12 += agz.a(i16, unsafe2.getObject(t, j4), a(i15));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzc(i16, (zzdmr) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzac(i16, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzag(i16, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzaf(i16, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzo(i16, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzad(i16, unsafe2.getInt(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.zzm(i16, unsafe2.getLong(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i14 & i2) != 0) {
                        i12 += zzdni.c(i16, (zzdpk) unsafe2.getObject(t, j4), a(i15));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i12 += agz.i(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 19:
                    i12 += agz.h(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 20:
                    i12 += agz.a(i16, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 21:
                    i12 += agz.b(i16, (List<Long>) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 22:
                    i12 += agz.e(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 23:
                    i12 += agz.i(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 24:
                    i12 += agz.h(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 25:
                    i12 += agz.j(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 26:
                    i12 += agz.a(i16, (List<?>) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 27:
                    i12 += agz.a(i16, (List<?>) unsafe2.getObject(t, j4), a(i15));
                    j = 0;
                    break;
                case 28:
                    i12 += agz.b(i16, (List) unsafe2.getObject(t, j4));
                    j = 0;
                    break;
                case 29:
                    i12 += agz.f(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 30:
                    i12 += agz.d(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 31:
                    i12 += agz.h(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 32:
                    i12 += agz.i(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 33:
                    i12 += agz.g(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 34:
                    i12 += agz.c(i16, (List) unsafe2.getObject(t, j4), false);
                    j = 0;
                    break;
                case 35:
                    int i19 = agz.i((List) unsafe2.getObject(t, j4));
                    if (i19 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i19);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(i19) + i19;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int h4 = agz.h((List) unsafe2.getObject(t, j4));
                    if (h4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h4);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(h4) + h4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int a3 = agz.a((List<Long>) unsafe2.getObject(t, j4));
                    if (a3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, a3);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(a3) + a3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int b3 = agz.b((List) unsafe2.getObject(t, j4));
                    if (b3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b3);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(b3) + b3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int e2 = agz.e((List) unsafe2.getObject(t, j4));
                    if (e2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, e2);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(e2) + e2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int i20 = agz.i((List) unsafe2.getObject(t, j4));
                    if (i20 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i20);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(i20) + i20;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int h5 = agz.h((List) unsafe2.getObject(t, j4));
                    if (h5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h5);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(h5) + h5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int j5 = agz.j((List) unsafe2.getObject(t, j4));
                    if (j5 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, j5);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(j5) + j5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int f4 = agz.f((List) unsafe2.getObject(t, j4));
                    if (f4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, f4);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(f4) + f4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int d4 = agz.d((List) unsafe2.getObject(t, j4));
                    if (d4 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, d4);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(d4) + d4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int h6 = agz.h((List) unsafe2.getObject(t, j4));
                    if (h6 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, h6);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(h6) + h6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int i21 = agz.i((List) unsafe2.getObject(t, j4));
                    if (i21 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i21);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(i21) + i21;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int g2 = agz.g((List) unsafe2.getObject(t, j4));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(g2) + g2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int c2 = agz.c((List) unsafe2.getObject(t, j4));
                    if (c2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, c2);
                        }
                        i12 += zzdni.zzgd(i16) + zzdni.zzgf(c2) + c2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i12 += agz.b(i16, (List<zzdpk>) unsafe2.getObject(t, j4), a(i15));
                    j = 0;
                    break;
                case 50:
                    i12 += this.s.a(i16, unsafe2.getObject(t, j4), b(i15));
                    j = 0;
                    break;
                case 51:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzc(i16, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzb(i16, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzk(i16, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzl(i16, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzab(i16, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzn(i16, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzae(i16, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzj(i16, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (a((agl<T>) t, i16, i15)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzdmr) {
                            i12 += zzdni.zzc(i16, (zzdmr) object2);
                            j = 0;
                            break;
                        } else {
                            i12 += zzdni.zzg(i16, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += agz.a(i16, unsafe2.getObject(t, j4), a(i15));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzc(i16, (zzdmr) unsafe2.getObject(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzac(i16, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzag(i16, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzaf(i16, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzo(i16, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzad(i16, d(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.zzm(i16, e(t, j4));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (a((agl<T>) t, i16, i15)) {
                        i12 += zzdni.c(i16, (zzdpk) unsafe2.getObject(t, j4), a(i15));
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
        }
        int a4 = i12 + a((aho) this.q, (Object) t);
        return this.h ? a4 + this.r.a(t).h() : a4;
    }

    private static <UT, UB> int a(aho<UT, UB> ahoVar, T t) {
        return ahoVar.f(ahoVar.b(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) ahs.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a27  */
    @Override // com.google.android.gms.internal.ads.agx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r14, com.google.android.gms.internal.ads.aib r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.a(java.lang.Object, com.google.android.gms.internal.ads.aib):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(T r19, com.google.android.gms.internal.ads.aib r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.b(java.lang.Object, com.google.android.gms.internal.ads.aib):void");
    }

    private final <K, V> void a(aib aibVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            aibVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(aho<UT, UB> ahoVar, T t, aib aibVar) throws IOException {
        ahoVar.a((aho<UT, UB>) ahoVar.b(t), aibVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0085. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agx
    public final void a(T t, agw agwVar, zzdno zzdnoVar) throws IOException {
        if (zzdnoVar == null) {
            throw new NullPointerException();
        }
        aho ahoVar = this.q;
        afh<?> afhVar = this.r;
        afk<?> afkVar = null;
        Object obj = null;
        while (true) {
            try {
                int a2 = agwVar.a();
                int g = g(a2);
                if (g < 0) {
                    if (a2 == Integer.MAX_VALUE) {
                        for (int i = this.m; i < this.n; i++) {
                            obj = a((Object) t, this.l[i], (int) obj, (aho<UT, int>) ahoVar);
                        }
                        if (obj != null) {
                            ahoVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a3 = !this.h ? null : afhVar.a(zzdnoVar, this.g, a2);
                    if (a3 != null) {
                        afk<?> b2 = afkVar == null ? afhVar.b(t) : afkVar;
                        obj = afhVar.a(agwVar, a3, zzdnoVar, b2, obj, ahoVar);
                        afkVar = b2;
                    } else {
                        ahoVar.a(agwVar);
                        if (obj == null) {
                            obj = ahoVar.c(t);
                        }
                        if (!ahoVar.a((aho) obj, agwVar)) {
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                obj = a((Object) t, this.l[i2], (int) obj, (aho<UT, int>) ahoVar);
                            }
                            if (obj != null) {
                                ahoVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int d = d(g);
                    switch ((267386880 & d) >>> 20) {
                        case 0:
                            ahs.a(t, d & 1048575, agwVar.d());
                            b((agl<T>) t, g);
                            break;
                        case 1:
                            ahs.a((Object) t, d & 1048575, agwVar.e());
                            b((agl<T>) t, g);
                            break;
                        case 2:
                            ahs.a((Object) t, d & 1048575, agwVar.g());
                            b((agl<T>) t, g);
                            break;
                        case 3:
                            ahs.a((Object) t, d & 1048575, agwVar.f());
                            b((agl<T>) t, g);
                            break;
                        case 4:
                            ahs.a((Object) t, d & 1048575, agwVar.h());
                            b((agl<T>) t, g);
                            break;
                        case 5:
                            ahs.a((Object) t, d & 1048575, agwVar.i());
                            b((agl<T>) t, g);
                            break;
                        case 6:
                            ahs.a((Object) t, d & 1048575, agwVar.j());
                            b((agl<T>) t, g);
                            break;
                        case 7:
                            ahs.a(t, d & 1048575, agwVar.k());
                            b((agl<T>) t, g);
                            break;
                        case 8:
                            a(t, d, agwVar);
                            b((agl<T>) t, g);
                            break;
                        case 9:
                            if (a((agl<T>) t, g)) {
                                long j = d & 1048575;
                                ahs.a(t, j, zzdod.a(ahs.f(t, j), agwVar.a(a(g), zzdnoVar)));
                                break;
                            } else {
                                ahs.a(t, d & 1048575, agwVar.a(a(g), zzdnoVar));
                                b((agl<T>) t, g);
                                break;
                            }
                        case 10:
                            ahs.a(t, d & 1048575, agwVar.n());
                            b((agl<T>) t, g);
                            break;
                        case 11:
                            ahs.a((Object) t, d & 1048575, agwVar.o());
                            b((agl<T>) t, g);
                            break;
                        case 12:
                            int p = agwVar.p();
                            zzdog c = c(g);
                            if (c != null && !c.zzf(p)) {
                                obj = agz.a(a2, p, obj, (aho<UT, Object>) ahoVar);
                                break;
                            }
                            ahs.a((Object) t, d & 1048575, p);
                            b((agl<T>) t, g);
                            break;
                        case 13:
                            ahs.a((Object) t, d & 1048575, agwVar.q());
                            b((agl<T>) t, g);
                            break;
                        case 14:
                            ahs.a((Object) t, d & 1048575, agwVar.r());
                            b((agl<T>) t, g);
                            break;
                        case 15:
                            ahs.a((Object) t, d & 1048575, agwVar.s());
                            b((agl<T>) t, g);
                            break;
                        case 16:
                            ahs.a((Object) t, d & 1048575, agwVar.t());
                            b((agl<T>) t, g);
                            break;
                        case 17:
                            if (a((agl<T>) t, g)) {
                                long j2 = d & 1048575;
                                ahs.a(t, j2, zzdod.a(ahs.f(t, j2), agwVar.b(a(g), zzdnoVar)));
                                break;
                            } else {
                                ahs.a(t, d & 1048575, agwVar.b(a(g), zzdnoVar));
                                b((agl<T>) t, g);
                                break;
                            }
                        case 18:
                            agwVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 19:
                            agwVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 20:
                            agwVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 21:
                            agwVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 22:
                            agwVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 23:
                            agwVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 24:
                            agwVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 25:
                            agwVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 26:
                            if (f(d)) {
                                agwVar.j(this.p.a(t, d & 1048575));
                                break;
                            } else {
                                agwVar.i(this.p.a(t, d & 1048575));
                                break;
                            }
                        case 27:
                            agwVar.a(this.p.a(t, d & 1048575), a(g), zzdnoVar);
                            break;
                        case 28:
                            agwVar.k(this.p.a(t, d & 1048575));
                            break;
                        case 29:
                            agwVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 30:
                            List<Integer> a4 = this.p.a(t, d & 1048575);
                            agwVar.m(a4);
                            obj = agz.a(a2, a4, c(g), obj, ahoVar);
                            break;
                        case 31:
                            agwVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 32:
                            agwVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 33:
                            agwVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 34:
                            agwVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 35:
                            agwVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 36:
                            agwVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 37:
                            agwVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 38:
                            agwVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 39:
                            agwVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 40:
                            agwVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 41:
                            agwVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 42:
                            agwVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 43:
                            agwVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 44:
                            List<Integer> a5 = this.p.a(t, d & 1048575);
                            agwVar.m(a5);
                            obj = agz.a(a2, a5, c(g), obj, ahoVar);
                            break;
                        case 45:
                            agwVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 46:
                            agwVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 47:
                            agwVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 48:
                            agwVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 49:
                            agwVar.b(this.p.a(t, d & 1048575), a(g), zzdnoVar);
                            break;
                        case 50:
                            Object b3 = b(g);
                            long d2 = d(g) & 1048575;
                            Object f = ahs.f(t, d2);
                            if (f == null) {
                                f = this.s.e(b3);
                                ahs.a(t, d2, f);
                            } else if (this.s.c(f)) {
                                Object e = this.s.e(b3);
                                this.s.a(e, f);
                                ahs.a(t, d2, e);
                                f = e;
                            }
                            agwVar.a(this.s.a(f), this.s.f(b3), zzdnoVar);
                            break;
                        case 51:
                            ahs.a(t, d & 1048575, Double.valueOf(agwVar.d()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 52:
                            ahs.a(t, d & 1048575, Float.valueOf(agwVar.e()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 53:
                            ahs.a(t, d & 1048575, Long.valueOf(agwVar.g()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 54:
                            ahs.a(t, d & 1048575, Long.valueOf(agwVar.f()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 55:
                            ahs.a(t, d & 1048575, Integer.valueOf(agwVar.h()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 56:
                            ahs.a(t, d & 1048575, Long.valueOf(agwVar.i()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 57:
                            ahs.a(t, d & 1048575, Integer.valueOf(agwVar.j()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 58:
                            ahs.a(t, d & 1048575, Boolean.valueOf(agwVar.k()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 59:
                            a(t, d, agwVar);
                            b((agl<T>) t, a2, g);
                            break;
                        case 60:
                            if (a((agl<T>) t, a2, g)) {
                                long j3 = d & 1048575;
                                ahs.a(t, j3, zzdod.a(ahs.f(t, j3), agwVar.a(a(g), zzdnoVar)));
                            } else {
                                ahs.a(t, d & 1048575, agwVar.a(a(g), zzdnoVar));
                                b((agl<T>) t, g);
                            }
                            b((agl<T>) t, a2, g);
                            break;
                        case 61:
                            ahs.a(t, d & 1048575, agwVar.n());
                            b((agl<T>) t, a2, g);
                            break;
                        case 62:
                            ahs.a(t, d & 1048575, Integer.valueOf(agwVar.o()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 63:
                            int p2 = agwVar.p();
                            zzdog c2 = c(g);
                            if (c2 != null && !c2.zzf(p2)) {
                                obj = agz.a(a2, p2, obj, (aho<UT, Object>) ahoVar);
                                break;
                            }
                            ahs.a(t, d & 1048575, Integer.valueOf(p2));
                            b((agl<T>) t, a2, g);
                            break;
                        case 64:
                            ahs.a(t, d & 1048575, Integer.valueOf(agwVar.q()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 65:
                            ahs.a(t, d & 1048575, Long.valueOf(agwVar.r()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 66:
                            ahs.a(t, d & 1048575, Integer.valueOf(agwVar.s()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 67:
                            ahs.a(t, d & 1048575, Long.valueOf(agwVar.t()));
                            b((agl<T>) t, a2, g);
                            break;
                        case 68:
                            ahs.a(t, d & 1048575, agwVar.b(a(g), zzdnoVar));
                            b((agl<T>) t, a2, g);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = ahoVar.a();
                                } catch (zzdol unused) {
                                    ahoVar.a(agwVar);
                                    if (obj == null) {
                                        obj = ahoVar.c(t);
                                    }
                                    if (!ahoVar.a((aho) obj, agwVar)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            obj = a((Object) t, this.l[i3], (int) obj, (aho<UT, int>) ahoVar);
                                        }
                                        if (obj != null) {
                                            ahoVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!ahoVar.a((aho) obj, agwVar)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    obj = a((Object) t, this.l[i4], (int) obj, (aho<UT, int>) ahoVar);
                                }
                                if (obj != null) {
                                    ahoVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.m; i5 < this.n; i5++) {
                    obj = a((Object) t, this.l[i5], (int) obj, (aho<UT, int>) ahoVar);
                }
                if (obj != null) {
                    ahoVar.b((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    private static zzdqu e(Object obj) {
        zzdob zzdobVar = (zzdob) obj;
        zzdqu zzdquVar = zzdobVar.zzhhd;
        if (zzdquVar != zzdqu.zzazz()) {
            return zzdquVar;
        }
        zzdqu a2 = zzdqu.a();
        zzdobVar.zzhhd = a2;
        return a2;
    }

    private static int a(byte[] bArr, int i, int i2, zzdri zzdriVar, Class<?> cls, aep aepVar) throws IOException {
        switch (agm.f1865a[zzdriVar.ordinal()]) {
            case 1:
                int b2 = aeo.b(bArr, i, aepVar);
                aepVar.c = Boolean.valueOf(aepVar.b != 0);
                return b2;
            case 2:
                return aeo.e(bArr, i, aepVar);
            case 3:
                aepVar.c = Double.valueOf(aeo.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                aepVar.c = Integer.valueOf(aeo.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                aepVar.c = Long.valueOf(aeo.b(bArr, i));
                return i + 8;
            case 8:
                aepVar.c = Float.valueOf(aeo.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int a2 = aeo.a(bArr, i, aepVar);
                aepVar.c = Integer.valueOf(aepVar.f1835a);
                return a2;
            case 12:
            case 13:
                int b3 = aeo.b(bArr, i, aepVar);
                aepVar.c = Long.valueOf(aepVar.b);
                return b3;
            case 14:
                return aeo.a(ags.a().a((Class) cls), bArr, i, i2, aepVar);
            case 15:
                int a3 = aeo.a(bArr, i, aepVar);
                aepVar.c = Integer.valueOf(zzdnd.zzft(aepVar.f1835a));
                return a3;
            case 16:
                int b4 = aeo.b(bArr, i, aepVar);
                aepVar.c = Long.valueOf(zzdnd.zzfi(aepVar.b));
                return b4;
            case 17:
                return aeo.d(bArr, i, aepVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, aep aepVar) throws IOException {
        int a2;
        zzdoj zzdojVar = (zzdoj) b.getObject(t, j2);
        if (!zzdojVar.zzavi()) {
            int size = zzdojVar.size();
            zzdojVar = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
            b.putObject(t, j2, zzdojVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    aff affVar = (aff) zzdojVar;
                    int a3 = aeo.a(bArr, i, aepVar);
                    int i8 = aepVar.f1835a + a3;
                    while (a3 < i8) {
                        affVar.a(aeo.c(bArr, a3));
                        a3 += 8;
                    }
                    if (a3 == i8) {
                        return a3;
                    }
                    throw zzdok.a();
                }
                if (i5 == 1) {
                    aff affVar2 = (aff) zzdojVar;
                    affVar2.a(aeo.c(bArr, i));
                    int i9 = i + 8;
                    while (i9 < i2) {
                        int a4 = aeo.a(bArr, i9, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return i9;
                        }
                        affVar2.a(aeo.c(bArr, a4));
                        i9 = a4 + 8;
                    }
                    return i9;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    afn afnVar = (afn) zzdojVar;
                    int a5 = aeo.a(bArr, i, aepVar);
                    int i10 = aepVar.f1835a + a5;
                    while (a5 < i10) {
                        afnVar.a(aeo.d(bArr, a5));
                        a5 += 4;
                    }
                    if (a5 == i10) {
                        return a5;
                    }
                    throw zzdok.a();
                }
                if (i5 == 5) {
                    afn afnVar2 = (afn) zzdojVar;
                    afnVar2.a(aeo.d(bArr, i));
                    int i11 = i + 4;
                    while (i11 < i2) {
                        int a6 = aeo.a(bArr, i11, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return i11;
                        }
                        afnVar2.a(aeo.d(bArr, a6));
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
                    afz afzVar = (afz) zzdojVar;
                    int a7 = aeo.a(bArr, i, aepVar);
                    int i12 = aepVar.f1835a + a7;
                    while (a7 < i12) {
                        a7 = aeo.b(bArr, a7, aepVar);
                        afzVar.a(aepVar.b);
                    }
                    if (a7 == i12) {
                        return a7;
                    }
                    throw zzdok.a();
                }
                if (i5 == 0) {
                    afz afzVar2 = (afz) zzdojVar;
                    int b2 = aeo.b(bArr, i, aepVar);
                    afzVar2.a(aepVar.b);
                    while (b2 < i2) {
                        int a8 = aeo.a(bArr, b2, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return b2;
                        }
                        b2 = aeo.b(bArr, a8, aepVar);
                        afzVar2.a(aepVar.b);
                    }
                    return b2;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return aeo.a(bArr, i, (zzdoj<?>) zzdojVar, aepVar);
                }
                if (i5 == 0) {
                    return aeo.a(i3, bArr, i, i2, (zzdoj<?>) zzdojVar, aepVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    afz afzVar3 = (afz) zzdojVar;
                    int a9 = aeo.a(bArr, i, aepVar);
                    int i13 = aepVar.f1835a + a9;
                    while (a9 < i13) {
                        afzVar3.a(aeo.b(bArr, a9));
                        a9 += 8;
                    }
                    if (a9 == i13) {
                        return a9;
                    }
                    throw zzdok.a();
                }
                if (i5 == 1) {
                    afz afzVar4 = (afz) zzdojVar;
                    afzVar4.a(aeo.b(bArr, i));
                    int i14 = i + 8;
                    while (i14 < i2) {
                        int a10 = aeo.a(bArr, i14, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return i14;
                        }
                        afzVar4.a(aeo.b(bArr, a10));
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
                    afr afrVar = (afr) zzdojVar;
                    int a11 = aeo.a(bArr, i, aepVar);
                    int i15 = aepVar.f1835a + a11;
                    while (a11 < i15) {
                        afrVar.zzgp(aeo.a(bArr, a11));
                        a11 += 4;
                    }
                    if (a11 == i15) {
                        return a11;
                    }
                    throw zzdok.a();
                }
                if (i5 == 5) {
                    afr afrVar2 = (afr) zzdojVar;
                    afrVar2.zzgp(aeo.a(bArr, i));
                    int i16 = i + 4;
                    while (i16 < i2) {
                        int a12 = aeo.a(bArr, i16, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return i16;
                        }
                        afrVar2.zzgp(aeo.a(bArr, a12));
                        i16 = a12 + 4;
                    }
                    return i16;
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    aeq aeqVar = (aeq) zzdojVar;
                    int a13 = aeo.a(bArr, i, aepVar);
                    int i17 = aepVar.f1835a + a13;
                    while (a13 < i17) {
                        a13 = aeo.b(bArr, a13, aepVar);
                        aeqVar.a(aepVar.b != 0);
                    }
                    if (a13 == i17) {
                        return a13;
                    }
                    throw zzdok.a();
                }
                if (i5 == 0) {
                    aeq aeqVar2 = (aeq) zzdojVar;
                    int b3 = aeo.b(bArr, i, aepVar);
                    aeqVar2.a(aepVar.b != 0);
                    while (b3 < i2) {
                        int a14 = aeo.a(bArr, b3, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return b3;
                        }
                        b3 = aeo.b(bArr, a14, aepVar);
                        aeqVar2.a(aepVar.b != 0);
                    }
                    return b3;
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int a15 = aeo.a(bArr, i, aepVar);
                        int i18 = aepVar.f1835a;
                        if (i18 < 0) {
                            throw zzdok.b();
                        }
                        if (i18 == 0) {
                            zzdojVar.add("");
                        } else {
                            zzdojVar.add(new String(bArr, a15, i18, zzdod.f3593a));
                            a15 += i18;
                        }
                        while (a15 < i2) {
                            int a16 = aeo.a(bArr, a15, aepVar);
                            if (i3 != aepVar.f1835a) {
                                return a15;
                            }
                            a15 = aeo.a(bArr, a16, aepVar);
                            int i19 = aepVar.f1835a;
                            if (i19 < 0) {
                                throw zzdok.b();
                            }
                            if (i19 == 0) {
                                zzdojVar.add("");
                            } else {
                                zzdojVar.add(new String(bArr, a15, i19, zzdod.f3593a));
                                a15 += i19;
                            }
                        }
                        return a15;
                    }
                    int a17 = aeo.a(bArr, i, aepVar);
                    int i20 = aepVar.f1835a;
                    if (i20 < 0) {
                        throw zzdok.b();
                    }
                    if (i20 == 0) {
                        zzdojVar.add("");
                    } else {
                        int i21 = a17 + i20;
                        if (!ahv.a(bArr, a17, i21)) {
                            throw zzdok.h();
                        }
                        zzdojVar.add(new String(bArr, a17, i20, zzdod.f3593a));
                        a17 = i21;
                    }
                    while (a17 < i2) {
                        int a18 = aeo.a(bArr, a17, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return a17;
                        }
                        a17 = aeo.a(bArr, a18, aepVar);
                        int i22 = aepVar.f1835a;
                        if (i22 < 0) {
                            throw zzdok.b();
                        }
                        if (i22 == 0) {
                            zzdojVar.add("");
                        } else {
                            int i23 = a17 + i22;
                            if (!ahv.a(bArr, a17, i23)) {
                                throw zzdok.h();
                            }
                            zzdojVar.add(new String(bArr, a17, i22, zzdod.f3593a));
                            a17 = i23;
                        }
                    }
                    return a17;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return aeo.a(a(i6), i3, bArr, i, i2, zzdojVar, aepVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int a19 = aeo.a(bArr, i, aepVar);
                    int i24 = aepVar.f1835a;
                    if (i24 < 0) {
                        throw zzdok.b();
                    }
                    if (i24 > bArr.length - a19) {
                        throw zzdok.a();
                    }
                    if (i24 == 0) {
                        zzdojVar.add(zzdmr.zzhcr);
                    } else {
                        zzdojVar.add(zzdmr.zzi(bArr, a19, i24));
                        a19 += i24;
                    }
                    while (a19 < i2) {
                        int a20 = aeo.a(bArr, a19, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return a19;
                        }
                        a19 = aeo.a(bArr, a20, aepVar);
                        int i25 = aepVar.f1835a;
                        if (i25 < 0) {
                            throw zzdok.b();
                        }
                        if (i25 > bArr.length - a19) {
                            throw zzdok.a();
                        }
                        if (i25 == 0) {
                            zzdojVar.add(zzdmr.zzhcr);
                        } else {
                            zzdojVar.add(zzdmr.zzi(bArr, a19, i25));
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
                        a2 = aeo.a(i3, bArr, i, i2, (zzdoj<?>) zzdojVar, aepVar);
                    }
                    return i;
                }
                a2 = aeo.a(bArr, i, (zzdoj<?>) zzdojVar, aepVar);
                zzdob zzdobVar = (zzdob) t;
                zzdqu zzdquVar = zzdobVar.zzhhd;
                if (zzdquVar == zzdqu.zzazz()) {
                    zzdquVar = null;
                }
                zzdqu zzdquVar2 = (zzdqu) agz.a(i4, zzdojVar, c(i6), zzdquVar, this.q);
                if (zzdquVar2 != null) {
                    zzdobVar.zzhhd = zzdquVar2;
                }
                return a2;
            case 33:
            case 47:
                if (i5 == 2) {
                    afr afrVar3 = (afr) zzdojVar;
                    int a21 = aeo.a(bArr, i, aepVar);
                    int i26 = aepVar.f1835a + a21;
                    while (a21 < i26) {
                        a21 = aeo.a(bArr, a21, aepVar);
                        afrVar3.zzgp(zzdnd.zzft(aepVar.f1835a));
                    }
                    if (a21 == i26) {
                        return a21;
                    }
                    throw zzdok.a();
                }
                if (i5 == 0) {
                    afr afrVar4 = (afr) zzdojVar;
                    int a22 = aeo.a(bArr, i, aepVar);
                    afrVar4.zzgp(zzdnd.zzft(aepVar.f1835a));
                    while (a22 < i2) {
                        int a23 = aeo.a(bArr, a22, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return a22;
                        }
                        a22 = aeo.a(bArr, a23, aepVar);
                        afrVar4.zzgp(zzdnd.zzft(aepVar.f1835a));
                    }
                    return a22;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    afz afzVar5 = (afz) zzdojVar;
                    int a24 = aeo.a(bArr, i, aepVar);
                    int i27 = aepVar.f1835a + a24;
                    while (a24 < i27) {
                        a24 = aeo.b(bArr, a24, aepVar);
                        afzVar5.a(zzdnd.zzfi(aepVar.b));
                    }
                    if (a24 == i27) {
                        return a24;
                    }
                    throw zzdok.a();
                }
                if (i5 == 0) {
                    afz afzVar6 = (afz) zzdojVar;
                    int b4 = aeo.b(bArr, i, aepVar);
                    afzVar6.a(zzdnd.zzfi(aepVar.b));
                    while (b4 < i2) {
                        int a25 = aeo.a(bArr, b4, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return b4;
                        }
                        b4 = aeo.b(bArr, a25, aepVar);
                        afzVar6.a(zzdnd.zzfi(aepVar.b));
                    }
                    return b4;
                }
                return i;
            case 49:
                if (i5 == 3) {
                    agx a26 = a(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int a27 = aeo.a(a26, bArr, i, i2, i28, aepVar);
                    zzdojVar.add(aepVar.c);
                    while (a27 < i2) {
                        int a28 = aeo.a(bArr, a27, aepVar);
                        if (i3 != aepVar.f1835a) {
                            return a27;
                        }
                        a27 = aeo.a(a26, bArr, a28, i2, i28, aepVar);
                        zzdojVar.add(aepVar.c);
                    }
                    return a27;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, aep aepVar) throws IOException {
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
        age<?, ?> f = this.s.f(b2);
        Map<?, ?> a2 = this.s.a(object);
        int a3 = aeo.a(bArr, i, aepVar);
        int i5 = aepVar.f1835a;
        if (i5 < 0 || i5 > i2 - a3) {
            throw zzdok.a();
        }
        int i6 = i5 + a3;
        K k = f.b;
        V v = f.d;
        while (a3 < i6) {
            int i7 = a3 + 1;
            int i8 = bArr[a3];
            if (i8 < 0) {
                int a4 = aeo.a(i8, bArr, i7, aepVar);
                i8 = aepVar.f1835a;
                i4 = a4;
            } else {
                i4 = i7;
            }
            int i9 = i8 & 7;
            switch (i8 >>> 3) {
                case 1:
                    if (i9 != f.f1862a.zzbak()) {
                        break;
                    } else {
                        a3 = a(bArr, i4, i2, f.f1862a, (Class<?>) null, aepVar);
                        k = (K) aepVar.c;
                        break;
                    }
                case 2:
                    if (i9 != f.c.zzbak()) {
                        break;
                    } else {
                        a3 = a(bArr, i4, i2, f.c, f.d.getClass(), aepVar);
                        v = aepVar.c;
                        break;
                    }
            }
            a3 = aeo.a(i8, bArr, i4, i2, aepVar);
        }
        if (a3 != i6) {
            throw zzdok.g();
        }
        a2.put(k, v);
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, aep aepVar) throws IOException {
        int i9;
        Unsafe unsafe = b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(aeo.c(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(aeo.d(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = aeo.b(bArr, i, aepVar);
                    unsafe.putObject(t, j, Long.valueOf(aepVar.b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = aeo.a(bArr, i, aepVar);
                    unsafe.putObject(t, j, Integer.valueOf(aepVar.f1835a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(aeo.b(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(aeo.a(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = aeo.b(bArr, i, aepVar);
                    unsafe.putObject(t, j, Boolean.valueOf(aepVar.b != 0));
                    break;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int a2 = aeo.a(bArr, i, aepVar);
                    int i10 = aepVar.f1835a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & DriveFile.MODE_WRITE_ONLY) != 0 && !ahv.a(bArr, a2, a2 + i10)) {
                            throw zzdok.h();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i10, zzdod.f3593a));
                        a2 += i10;
                    }
                    unsafe.putInt(t, j2, i4);
                    return a2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int a3 = aeo.a(a(i8), bArr, i, i2, aepVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, aepVar.c);
                    } else {
                        unsafe.putObject(t, j, zzdod.a(object, aepVar.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return a3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = aeo.e(bArr, i, aepVar);
                    unsafe.putObject(t, j, aepVar.c);
                    break;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a4 = aeo.a(bArr, i, aepVar);
                    int i11 = aepVar.f1835a;
                    zzdog c = c(i8);
                    if (c == null || c.zzf(i11)) {
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
                    i9 = aeo.a(bArr, i, aepVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzdnd.zzft(aepVar.f1835a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = aeo.b(bArr, i, aepVar);
                    unsafe.putObject(t, j, Long.valueOf(zzdnd.zzfi(aepVar.b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = aeo.a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, aepVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, aepVar.c);
                        break;
                    } else {
                        unsafe.putObject(t, j, zzdod.a(object2, aepVar.c));
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

    private final agx a(int i) {
        int i2 = (i / 3) << 1;
        agx agxVar = (agx) this.d[i2];
        if (agxVar != null) {
            return agxVar;
        }
        agx<T> a2 = ags.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final zzdog c(int i) {
        return (zzdog) this.d[((i / 3) << 1) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0573, code lost:
    
        if (r0 == r4) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0575, code lost:
    
        r26.putInt(r11, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x057b, code lost:
    
        r0 = null;
        r1 = r8.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0580, code lost:
    
        if (r1 >= r8.n) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0582, code lost:
    
        r0 = (com.google.android.gms.internal.ads.zzdqu) r8.a(r11, r8.l[r1], (int) r0, (com.google.android.gms.internal.ads.aho<UT, int>) r8.q);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0591, code lost:
    
        if (r0 == null) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0593, code lost:
    
        r8.q.b(r11, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0598, code lost:
    
        if (r6 != 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x059c, code lost:
    
        if (r2 != r32) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x05a3, code lost:
    
        throw com.google.android.gms.internal.ads.zzdok.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x05aa, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x05a6, code lost:
    
        if (r2 > r32) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x05a8, code lost:
    
        if (r3 != r6) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x05af, code lost:
    
        throw com.google.android.gms.internal.ads.zzdok.g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:119:0x0087. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.ads.aep r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.aep):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.ads.agx
    public final void a(T t, byte[] bArr, int i, int i2, aep aepVar) throws IOException {
        byte b2;
        int i3;
        int g;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        agl<T> aglVar = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i8 = i2;
        aep aepVar2 = aepVar;
        if (aglVar.j) {
            Unsafe unsafe2 = b;
            int i9 = -1;
            int i10 = i;
            int i11 = -1;
            int i12 = 0;
            while (i10 < i8) {
                int i13 = i10 + 1;
                byte b3 = bArr2[i10];
                if (b3 < 0) {
                    i3 = aeo.a(b3, bArr2, i13, aepVar2);
                    b2 = aepVar2.f1835a;
                } else {
                    b2 = b3;
                    i3 = i13;
                }
                int i14 = b2 >>> 3;
                int i15 = b2 & 7;
                if (i14 > i11) {
                    g = aglVar.a(i14, i12 / 3);
                } else {
                    g = aglVar.g(i14);
                }
                if (g == i9) {
                    i4 = i14;
                    i5 = i3;
                    unsafe = unsafe2;
                    i6 = 0;
                } else {
                    int i16 = aglVar.c[g + 1];
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
                                    ahs.a(t2, j, aeo.c(bArr2, i3));
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
                                    ahs.a((Object) t2, j, aeo.d(bArr2, i3));
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
                                    int b4 = aeo.b(bArr2, i3, aepVar2);
                                    unsafe2.putLong(t, j, aepVar2.b);
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
                                    i10 = aeo.a(bArr2, i3, aepVar2);
                                    unsafe2.putInt(t2, j, aepVar2.f1835a);
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
                                    unsafe2.putLong(t, j, aeo.b(bArr2, i3));
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
                                    unsafe2.putInt(t2, j, aeo.a(bArr2, i3));
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
                                    int b5 = aeo.b(bArr2, i3, aepVar2);
                                    ahs.a(t2, j, aepVar2.b != 0);
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
                                        i10 = aeo.c(bArr2, i3, aepVar2);
                                    } else {
                                        i10 = aeo.d(bArr2, i3, aepVar2);
                                    }
                                    unsafe2.putObject(t2, j, aepVar2.c);
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
                                    i10 = aeo.a(aglVar.a(g), bArr2, i3, i8, aepVar2);
                                    Object object = unsafe2.getObject(t2, j);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j, aepVar2.c);
                                    } else {
                                        unsafe2.putObject(t2, j, zzdod.a(object, aepVar2.c));
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
                                    i10 = aeo.e(bArr2, i3, aepVar2);
                                    unsafe2.putObject(t2, j, aepVar2.c);
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
                                    i10 = aeo.a(bArr2, i3, aepVar2);
                                    unsafe2.putInt(t2, j, aepVar2.f1835a);
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
                                    i10 = aeo.a(bArr2, i3, aepVar2);
                                    unsafe2.putInt(t2, j, zzdnd.zzft(aepVar2.f1835a));
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
                                    int b6 = aeo.b(bArr2, i3, aepVar2);
                                    unsafe2.putLong(t, j, zzdnd.zzfi(aepVar2.b));
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
                            i10 = a((agl<T>) t, bArr, i3, i2, b2, i14, i15, i6, i16, i17, j, aepVar);
                            if (i10 == i24) {
                                i5 = i10;
                            } else {
                                t2 = t;
                                bArr2 = bArr;
                                aepVar2 = aepVar;
                                unsafe2 = unsafe;
                                i12 = i6;
                                i11 = i4;
                                i9 = -1;
                                i8 = i2;
                                aglVar = this;
                            }
                        } else {
                            i4 = i14;
                            i7 = i3;
                            unsafe = unsafe2;
                            if (i17 != 50) {
                                i10 = a((agl<T>) t, bArr, i7, i2, b2, i4, i15, i16, i17, j, i6, aepVar);
                                if (i10 == i7) {
                                    i5 = i10;
                                } else {
                                    t2 = t;
                                    bArr2 = bArr;
                                    aepVar2 = aepVar;
                                    unsafe2 = unsafe;
                                    i12 = i6;
                                    i11 = i4;
                                    i9 = -1;
                                    i8 = i2;
                                    aglVar = this;
                                }
                            } else if (i15 == 2) {
                                i10 = a((agl<T>) t, bArr, i7, i2, i6, j, aepVar);
                                if (i10 == i7) {
                                    i5 = i10;
                                } else {
                                    t2 = t;
                                    bArr2 = bArr;
                                    aepVar2 = aepVar;
                                    unsafe2 = unsafe;
                                    i12 = i6;
                                    i11 = i4;
                                    i9 = -1;
                                    i8 = i2;
                                    aglVar = this;
                                }
                            } else {
                                i5 = i7;
                            }
                        }
                    } else if (i15 == 2) {
                        zzdoj zzdojVar = (zzdoj) unsafe2.getObject(t2, j);
                        if (!zzdojVar.zzavi()) {
                            int size = zzdojVar.size();
                            zzdojVar = zzdojVar.zzfl(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j, zzdojVar);
                        }
                        i10 = aeo.a(aglVar.a(g), b2, bArr, i3, i2, zzdojVar, aepVar);
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
                i10 = aeo.a(b2, bArr, i5, i2, e(t), aepVar);
                t2 = t;
                bArr2 = bArr;
                aepVar2 = aepVar;
                unsafe2 = unsafe;
                i12 = i6;
                i11 = i4;
                i9 = -1;
                i8 = i2;
                aglVar = this;
            }
            if (i10 != i8) {
                throw zzdok.g();
            }
            return;
        }
        a((agl<T>) t, bArr, i, i2, 0, aepVar);
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final void c(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d = d(this.l[i2]) & 1048575;
            Object f = ahs.f(t, d);
            if (f != null) {
                ahs.a(t, d, this.s.d(f));
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

    private final <UT, UB> UB a(Object obj, int i, UB ub, aho<UT, UB> ahoVar) {
        zzdog c;
        int i2 = this.c[i];
        Object f = ahs.f(obj, d(i) & 1048575);
        return (f == null || (c = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(f), c, (zzdog) ub, (aho<UT, zzdog>) ahoVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzdog zzdogVar, UB ub, aho<UT, UB> ahoVar) {
        age<?, ?> f = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzdogVar.zzf(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = ahoVar.a();
                }
                aew b2 = zzdmr.b(zzdpc.a(f, next.getKey(), next.getValue()));
                try {
                    zzdpc.a(b2.b(), f, next.getKey(), next.getValue());
                    ahoVar.a((aho<UT, UB>) ub, i2, b2.a());
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
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.agx] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.ads.agx] */
    @Override // com.google.android.gms.internal.ads.agx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.d(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, agx agxVar) {
        return agxVar.d(ahs.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, aib aibVar) throws IOException {
        if (obj instanceof String) {
            aibVar.a(i, (String) obj);
        } else {
            aibVar.a(i, (zzdmr) obj);
        }
    }

    private final void a(Object obj, int i, agw agwVar) throws IOException {
        if (f(i)) {
            ahs.a(obj, i & 1048575, agwVar.m());
        } else if (this.i) {
            ahs.a(obj, i & 1048575, agwVar.l());
        } else {
            ahs.a(obj, i & 1048575, agwVar.n());
        }
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> double b(T t, long j) {
        return ((Double) ahs.f(t, j)).doubleValue();
    }

    private static <T> float c(T t, long j) {
        return ((Float) ahs.f(t, j)).floatValue();
    }

    private static <T> int d(T t, long j) {
        return ((Integer) ahs.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) ahs.f(t, j)).longValue();
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) ahs.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((agl<T>) t, i) == a((agl<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((agl<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d = d(i);
            long j = d & 1048575;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    return ahs.e(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return ahs.d(t, j) != 0.0f;
                case 2:
                    return ahs.b(t, j) != 0;
                case 3:
                    return ahs.b(t, j) != 0;
                case 4:
                    return ahs.a(t, j) != 0;
                case 5:
                    return ahs.b(t, j) != 0;
                case 6:
                    return ahs.a(t, j) != 0;
                case 7:
                    return ahs.c(t, j);
                case 8:
                    Object f = ahs.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzdmr) {
                        return !zzdmr.zzhcr.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return ahs.f(t, j) != null;
                case 10:
                    return !zzdmr.zzhcr.equals(ahs.f(t, j));
                case 11:
                    return ahs.a(t, j) != 0;
                case 12:
                    return ahs.a(t, j) != 0;
                case 13:
                    return ahs.a(t, j) != 0;
                case 14:
                    return ahs.b(t, j) != 0;
                case 15:
                    return ahs.a(t, j) != 0;
                case 16:
                    return ahs.b(t, j) != 0;
                case 17:
                    return ahs.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e = e(i);
        return (ahs.a(t, (long) (e & 1048575)) & (1 << (e >>> 20))) != 0;
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e = e(i);
        long j = e & 1048575;
        ahs.a((Object) t, j, ahs.a(t, j) | (1 << (e >>> 20)));
    }

    private final boolean a(T t, int i, int i2) {
        return ahs.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        ahs.a((Object) t, e(i2) & 1048575, i);
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
