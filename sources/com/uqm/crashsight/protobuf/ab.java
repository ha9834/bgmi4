package com.uqm.crashsight.protobuf;

import com.google.android.gms.drive.DriveFile;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.uqm.crashsight.protobuf.ByteString;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.WireFormat;
import com.uqm.crashsight.protobuf.c;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ab<T> implements ao<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6786a = new int[0];
    private static final Unsafe b = aw.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final MessageLite g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final ae o;
    private final r p;
    private final at<?, ?> q;
    private final k<?> r;
    private final u s;

    private static int d(int i) {
        return (i & 267386880) >>> 20;
    }

    private static long e(int i) {
        return i & 1048575;
    }

    private ab(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, ae aeVar, r rVar, at<?, ?> atVar, k<?> kVar, u uVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = messageLite instanceof GeneratedMessageLite;
        this.j = z;
        this.h = kVar != null && kVar.a(messageLite);
        this.k = z2;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = aeVar;
        this.p = rVar;
        this.q = atVar;
        this.r = kVar;
        this.g = messageLite;
        this.s = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0595  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.uqm.crashsight.protobuf.ab<T> a(com.uqm.crashsight.protobuf.y r49, com.uqm.crashsight.protobuf.ae r50, com.uqm.crashsight.protobuf.r r51, com.uqm.crashsight.protobuf.at<?, ?> r52, com.uqm.crashsight.protobuf.k<?> r53, com.uqm.crashsight.protobuf.u r54) {
        /*
            Method dump skipped, instructions count: 1675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.a(com.uqm.crashsight.protobuf.y, com.uqm.crashsight.protobuf.ae, com.uqm.crashsight.protobuf.r, com.uqm.crashsight.protobuf.at, com.uqm.crashsight.protobuf.k, com.uqm.crashsight.protobuf.u):com.uqm.crashsight.protobuf.ab");
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
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c2, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.b(r11, r7) == com.uqm.crashsight.protobuf.aw.b(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01dd, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01fa, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.b(r11, r7) == com.uqm.crashsight.protobuf.aw.b(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        if (com.uqm.crashsight.protobuf.aq.a(com.uqm.crashsight.protobuf.aw.f(r11, r7), com.uqm.crashsight.protobuf.aw.f(r12, r7)) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0216, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.b(r11, r7) == com.uqm.crashsight.protobuf.aw.b(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0238, code lost:
    
        if (java.lang.Float.floatToIntBits(com.uqm.crashsight.protobuf.aw.d(r11, r7)) == java.lang.Float.floatToIntBits(com.uqm.crashsight.protobuf.aw.d(r12, r7))) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x025c, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.uqm.crashsight.protobuf.aw.e(r11, r7)) == java.lang.Double.doubleToLongBits(com.uqm.crashsight.protobuf.aw.e(r12, r7))) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        if (com.uqm.crashsight.protobuf.aq.a(com.uqm.crashsight.protobuf.aw.f(r11, r7), com.uqm.crashsight.protobuf.aw.f(r12, r7)) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.b(r11, r7) == com.uqm.crashsight.protobuf.aw.b(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.b(r11, r7) == com.uqm.crashsight.protobuf.aw.b(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00dc, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0112, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0131, code lost:
    
        if (com.uqm.crashsight.protobuf.aq.a(com.uqm.crashsight.protobuf.aw.f(r11, r7), com.uqm.crashsight.protobuf.aw.f(r12, r7)) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0150, code lost:
    
        if (com.uqm.crashsight.protobuf.aq.a(com.uqm.crashsight.protobuf.aw.f(r11, r7), com.uqm.crashsight.protobuf.aw.f(r12, r7)) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x016f, code lost:
    
        if (com.uqm.crashsight.protobuf.aq.a(com.uqm.crashsight.protobuf.aw.f(r11, r7), com.uqm.crashsight.protobuf.aw.f(r12, r7)) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018a, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.c(r11, r7) == com.uqm.crashsight.protobuf.aw.c(r12, r7)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a5, code lost:
    
        if (com.uqm.crashsight.protobuf.aw.a(r11, r7) == com.uqm.crashsight.protobuf.aw.a(r12, r7)) goto L162;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0263 A[LOOP:0: B:2:0x0005->B:142:0x0263, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0262 A[SYNTHETIC] */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(T r11, T r12) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int[] iArr = this.c;
            int i3 = iArr[i2 + 1];
            int i4 = iArr[i2];
            long j = i3 & 1048575;
            switch ((i3 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + Internal.a(Double.doubleToLongBits(aw.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(aw.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + Internal.a(aw.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + Internal.a(aw.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + Internal.a(aw.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + Internal.a(aw.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) aw.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = aw.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + aw.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + Internal.a(aw.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + aw.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + Internal.a(aw.b(t, j));
                    break;
                case 17:
                    Object f2 = aw.f(t, j);
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
                    i = (i * 53) + aw.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + aw.f(t, j).hashCode();
                    break;
                case 51:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(Double.doubleToLongBits(((Double) aw.f(t, j)).doubleValue()));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Float.floatToIntBits(((Float) aw.f(t, j)).floatValue());
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Long) aw.f(t, j)).longValue());
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Long) aw.f(t, j)).longValue());
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Long) aw.f(t, j)).longValue());
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Boolean) aw.f(t, j)).booleanValue());
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((String) aw.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + aw.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + aw.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Long) aw.f(t, j)).longValue());
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + ((Integer) aw.f(t, j)).intValue();
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + Internal.a(((Long) aw.f(t, j)).longValue());
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (aw.a(t, (long) (iArr[i2 + 2] & 1048575)) == i4) {
                        i = (i * 53) + aw.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.q.b(t).hashCode();
        return this.h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.ao
    public final void b(T t, T t2) {
        int i;
        if (t2 == null) {
            throw new NullPointerException();
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.c;
            if (i2 < iArr.length) {
                int i3 = iArr[i2 + 1];
                long j = i3 & 1048575;
                int i4 = iArr[i2];
                switch ((i3 & 267386880) >>> 20) {
                    case 0:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        } else {
                            aw.a(t, j, aw.e(t2, j));
                            b((ab<T>) t, i2);
                            break;
                        }
                    case 1:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        } else {
                            aw.a((Object) t, j, aw.d(t2, j));
                            b((ab<T>) t, i2);
                            break;
                        }
                    case 2:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.b(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 3:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.b(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 4:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 5:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.b(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 6:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 7:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        } else {
                            aw.a(t, j, aw.c(t2, j));
                            b((ab<T>) t, i2);
                            break;
                        }
                    case 8:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a(t, j, aw.f(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 9:
                    case 17:
                        a(t, t2, i2);
                        break;
                    case 10:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a(t, j, aw.f(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 11:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 12:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 13:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 14:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.b(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 15:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.a(t2, j));
                        b((ab<T>) t, i2);
                        break;
                    case 16:
                        if (!a((ab<T>) t2, i2)) {
                            break;
                        }
                        aw.a((Object) t, j, aw.b(t2, j));
                        b((ab<T>) t, i2);
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
                        aq.a(this.s, t, t2, j);
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
                        int i5 = i2 + 2;
                        if (!(aw.a(t2, (long) (iArr[i5] & 1048575)) == i4)) {
                            break;
                        } else {
                            aw.a(t, j, aw.f(t2, j));
                            i = this.c[i5];
                            aw.a((Object) t, i & 1048575, i4);
                            break;
                        }
                    case 60:
                    case 68:
                        b(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        int i6 = i2 + 2;
                        if (!(aw.a(t2, (long) (iArr[i6] & 1048575)) == i4)) {
                            break;
                        } else {
                            aw.a(t, j, aw.f(t2, j));
                            i = this.c[i6];
                            aw.a((Object) t, i & 1048575, i4);
                            break;
                        }
                }
                i2 += 3;
            } else {
                aq.a(this.q, t, t2);
                if (this.h) {
                    aq.a(this.r, t, t2);
                    return;
                }
                return;
            }
        }
    }

    private void a(T t, T t2, int i) {
        long j = this.c[i + 1] & 1048575;
        if (a((ab<T>) t2, i)) {
            Object f = aw.f(t, j);
            Object f2 = aw.f(t2, j);
            if (f != null && f2 != null) {
                aw.a(t, j, Internal.a(f, f2));
                b((ab<T>) t, i);
            } else if (f2 != null) {
                aw.a(t, j, f2);
                b((ab<T>) t, i);
            }
        }
    }

    private void b(T t, T t2, int i) {
        int[] iArr = this.c;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (aw.a(t2, (long) (iArr[i + 2] & 1048575)) == i3) {
            Object f = aw.f(t, j);
            Object f2 = aw.f(t2, j);
            if (f != null && f2 != null) {
                aw.a(t, j, Internal.a(f, f2));
                aw.a((Object) t, this.c[r9] & 1048575, i3);
            } else if (f2 != null) {
                aw.a(t, j, f2);
                aw.a((Object) t, this.c[r9] & 1048575, i3);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x023d, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0327, code lost:
    
        r5 = (com.uqm.crashsight.protobuf.CodedOutputStream.h(r14) + com.uqm.crashsight.protobuf.CodedOutputStream.j(r3)) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0323, code lost:
    
        r2.putInt(r19, r15, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x024f, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0261, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0273, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0285, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0297, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x02a9, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x02bb, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02cc, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02dd, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02ee, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x02ff, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0310, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0321, code lost:
    
        if (r18.k != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x046f, code lost:
    
        if ((r3 instanceof com.uqm.crashsight.protobuf.ByteString) != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x055a, code lost:
    
        if (a((com.uqm.crashsight.protobuf.ab<T>) r19, r13, r3) != false) goto L469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0862, code lost:
    
        r7 = com.uqm.crashsight.protobuf.CodedOutputStream.d(r13, (com.uqm.crashsight.protobuf.MessageLite) r2.getObject(r19, r7), a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x057a, code lost:
    
        if (a((com.uqm.crashsight.protobuf.ab<T>) r19, r13, r3) != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x088f, code lost:
    
        r11 = com.uqm.crashsight.protobuf.CodedOutputStream.j(r13, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0582, code lost:
    
        if (a((com.uqm.crashsight.protobuf.ab<T>) r19, r13, r3) != false) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x089b, code lost:
    
        r8 = com.uqm.crashsight.protobuf.CodedOutputStream.l(r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x05a2, code lost:
    
        if (a((com.uqm.crashsight.protobuf.ab<T>) r19, r13, r3) != false) goto L496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x08c0, code lost:
    
        r7 = r2.getObject(r19, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x08c4, code lost:
    
        r7 = com.uqm.crashsight.protobuf.CodedOutputStream.c(r13, (com.uqm.crashsight.protobuf.ByteString) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x05aa, code lost:
    
        if (a((com.uqm.crashsight.protobuf.ab<T>) r19, r13, r3) != false) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x08cf, code lost:
    
        r7 = com.uqm.crashsight.protobuf.aq.a(r13, r2.getObject(r19, r7), a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x05ba, code lost:
    
        if ((r7 instanceof com.uqm.crashsight.protobuf.ByteString) != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x08ea, code lost:
    
        r7 = com.uqm.crashsight.protobuf.CodedOutputStream.b(r13, (java.lang.String) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x06c0, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x07aa, code lost:
    
        r8 = (com.uqm.crashsight.protobuf.CodedOutputStream.h(r13) + com.uqm.crashsight.protobuf.CodedOutputStream.j(r7)) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x07a6, code lost:
    
        r2.putInt(r19, r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x06d2, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x06e4, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x06f6, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0708, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x071a, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x072c, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x073e, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x074f, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0760, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x0771, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x0782, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x0793, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x07a4, code lost:
    
        if (r18.k != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0860, code lost:
    
        if ((r10 & r17) != 0) goto L469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x088d, code lost:
    
        if ((r10 & r17) != 0) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0899, code lost:
    
        if ((r10 & r17) != 0) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x08be, code lost:
    
        if ((r10 & r17) != 0) goto L496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x08cd, code lost:
    
        if ((r10 & r17) != 0) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x08e7, code lost:
    
        if ((r7 instanceof com.uqm.crashsight.protobuf.ByteString) != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0141, code lost:
    
        if ((r3 instanceof com.uqm.crashsight.protobuf.ByteString) != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0472, code lost:
    
        r3 = com.uqm.crashsight.protobuf.CodedOutputStream.b(r14, (java.lang.String) r3);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:319:0x0551. Please report as an issue. */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(T r19) {
        /*
            Method dump skipped, instructions count: 2734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(at<UT, UB> atVar, T t) {
        return atVar.f(atVar.b(t));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0066. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:360:0x0664. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b3a  */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r13, com.uqm.crashsight.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.a(java.lang.Object, com.uqm.crashsight.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:359:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(T r20, com.uqm.crashsight.protobuf.Writer r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.b(java.lang.Object, com.uqm.crashsight.protobuf.Writer):void");
    }

    private <K, V> void a(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.a(i, this.s.f(this.d[(i2 / 3) << 1]), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(at<UT, UB> atVar, T t, Writer writer) throws IOException {
        atVar.a((at<UT, UB>) atVar.b(t), writer);
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final void a(T t, an anVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (extensionRegistryLite == null) {
            throw new NullPointerException();
        }
        a(this.q, this.r, (k) t, anVar, extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:366:0x0082, code lost:
    
        r0 = r18.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0086, code lost:
    
        if (r0 >= r18.n) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0088, code lost:
    
        r13 = a((java.lang.Object) r21, r18.l[r0], (int) r13, (com.uqm.crashsight.protobuf.at<UT, int>) r19);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0093, code lost:
    
        if (r13 == null) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0095, code lost:
    
        r19.b((java.lang.Object) r21, (T) r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0098, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x00aa. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0719 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x06fc A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite<ET>> void a(com.uqm.crashsight.protobuf.at<UT, UB> r19, com.uqm.crashsight.protobuf.k<ET> r20, T r21, com.uqm.crashsight.protobuf.an r22, com.uqm.crashsight.protobuf.ExtensionRegistryLite r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.a(com.uqm.crashsight.protobuf.at, com.uqm.crashsight.protobuf.k, java.lang.Object, com.uqm.crashsight.protobuf.an, com.uqm.crashsight.protobuf.ExtensionRegistryLite):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite c(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.a()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite b2 = UnknownFieldSetLite.b();
        generatedMessageLite.unknownFields = b2;
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.protobuf.ab$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6787a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6787a[WireFormat.FieldType.h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6787a[WireFormat.FieldType.l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6787a[WireFormat.FieldType.f6781a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6787a[WireFormat.FieldType.g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6787a[WireFormat.FieldType.o.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6787a[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6787a[WireFormat.FieldType.p.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6787a[WireFormat.FieldType.b.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6787a[WireFormat.FieldType.n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6787a[WireFormat.FieldType.e.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6787a[WireFormat.FieldType.m.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6787a[WireFormat.FieldType.c.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6787a[WireFormat.FieldType.d.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6787a[WireFormat.FieldType.k.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6787a[WireFormat.FieldType.q.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6787a[WireFormat.FieldType.r.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6787a[WireFormat.FieldType.i.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private static int a(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, c.a aVar) throws IOException {
        switch (AnonymousClass1.f6787a[fieldType.ordinal()]) {
            case 1:
                int b2 = c.b(bArr, i, aVar);
                aVar.c = Boolean.valueOf(aVar.b != 0);
                return b2;
            case 2:
                return c.e(bArr, i, aVar);
            case 3:
                aVar.c = Double.valueOf(c.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                aVar.c = Integer.valueOf(c.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                aVar.c = Long.valueOf(c.b(bArr, i));
                return i + 8;
            case 8:
                aVar.c = Float.valueOf(c.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int a2 = c.a(bArr, i, aVar);
                aVar.c = Integer.valueOf(aVar.f6808a);
                return a2;
            case 12:
            case 13:
                int b3 = c.b(bArr, i, aVar);
                aVar.c = Long.valueOf(aVar.b);
                return b3;
            case 14:
                return c.a(ak.a().a((Class) cls), bArr, i, i2, aVar);
            case 15:
                int a3 = c.a(bArr, i, aVar);
                aVar.c = Integer.valueOf(CodedInputStream.e(aVar.f6808a));
                return a3;
            case 16:
                int b4 = c.b(bArr, i, aVar);
                aVar.c = Long.valueOf(CodedInputStream.a(aVar.b));
                return b4;
            case 17:
                return c.d(bArr, i, aVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0031. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, c.a aVar) throws IOException {
        int a2;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) b.getObject(t, j2);
        if (!protobufList.a()) {
            int size = protobufList.size();
            protobufList = protobufList.c(size == 0 ? 10 : size << 1);
            b.putObject(t, j2, protobufList);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return c.f(bArr, i, protobufList, aVar);
                }
                if (i5 == 1) {
                    return c.f(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return c.e(bArr, i, protobufList, aVar);
                }
                if (i5 == 5) {
                    return c.e(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return c.b(bArr, i, protobufList, aVar);
                }
                if (i5 == 0) {
                    return c.b(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return c.a(bArr, i, (Internal.ProtobufList<?>) protobufList, aVar);
                }
                if (i5 == 0) {
                    return c.a(i3, bArr, i, i2, (Internal.ProtobufList<?>) protobufList, aVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return c.d(bArr, i, protobufList, aVar);
                }
                if (i5 == 1) {
                    return c.d(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return c.c(bArr, i, protobufList, aVar);
                }
                if (i5 == 5) {
                    return c.c(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return c.g(bArr, i, protobufList, aVar);
                }
                if (i5 == 0) {
                    return c.g(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return c.j(i3, bArr, i, i2, protobufList, aVar);
                    }
                    return c.k(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return c.a(a(i6), i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    return c.l(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        a2 = c.a(i3, bArr, i, i2, (Internal.ProtobufList<?>) protobufList, aVar);
                    }
                    return i;
                }
                a2 = c.a(bArr, i, (Internal.ProtobufList<?>) protobufList, aVar);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.a()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) aq.a(i4, (List<Integer>) protobufList, (Internal.EnumVerifier) this.d[((i6 / 3) << 1) + 1], unknownFieldSetLite, (at<UT, UnknownFieldSetLite>) this.q);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return a2;
            case 33:
            case 47:
                if (i5 == 2) {
                    return c.h(bArr, i, protobufList, aVar);
                }
                if (i5 == 0) {
                    return c.h(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return c.i(bArr, i, protobufList, aVar);
                }
                if (i5 == 0) {
                    return c.i(i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            case 49:
                if (i5 == 3) {
                    return c.b(a(i6), i3, bArr, i, i2, protobufList, aVar);
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, c.a aVar) throws IOException {
        Unsafe unsafe = b;
        Object obj = this.d[(i3 / 3) << 1];
        Object object = unsafe.getObject(t, j);
        if (this.s.c(object)) {
            Object e = this.s.e(obj);
            this.s.a(e, object);
            unsafe.putObject(t, j, e);
            object = e;
        }
        MapEntryLite.a<?, ?> f = this.s.f(obj);
        Map<?, ?> a2 = this.s.a(object);
        int a3 = c.a(bArr, i, aVar);
        int i4 = aVar.f6808a;
        if (i4 < 0 || i4 > i2 - a3) {
            throw InvalidProtocolBufferException.c();
        }
        int i5 = i4 + a3;
        K k = f.d;
        V v = f.f;
        while (a3 < i5) {
            int i6 = a3 + 1;
            int i7 = bArr[a3];
            if (i7 < 0) {
                i6 = c.a(i7, bArr, i6, aVar);
                i7 = aVar.f6808a;
            }
            int i8 = i6;
            int i9 = i7 & 7;
            switch (i7 >>> 3) {
                case 1:
                    if (i9 != f.c.b()) {
                        break;
                    } else {
                        a3 = a(bArr, i8, i2, f.c, (Class<?>) null, aVar);
                        k = (K) aVar.c;
                        break;
                    }
                case 2:
                    if (i9 != f.e.b()) {
                        break;
                    } else {
                        a3 = a(bArr, i8, i2, f.e, f.f.getClass(), aVar);
                        v = aVar.c;
                        break;
                    }
            }
            a3 = c.a(i7, bArr, i8, i2, aVar);
        }
        if (a3 != i5) {
            throw InvalidProtocolBufferException.k();
        }
        a2.put(k, v);
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, c.a aVar) throws IOException {
        int i9;
        Unsafe unsafe = b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(c.c(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(c.d(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = c.b(bArr, i, aVar);
                    unsafe.putObject(t, j, Long.valueOf(aVar.b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = c.a(bArr, i, aVar);
                    unsafe.putObject(t, j, Integer.valueOf(aVar.f6808a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(c.b(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(c.a(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = c.b(bArr, i, aVar);
                    unsafe.putObject(t, j, Boolean.valueOf(aVar.b != 0));
                    break;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int a2 = c.a(bArr, i, aVar);
                    int i10 = aVar.f6808a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & DriveFile.MODE_WRITE_ONLY) != 0 && !Utf8.a(bArr, a2, a2 + i10)) {
                            throw InvalidProtocolBufferException.l();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i10, Internal.f6726a));
                        a2 += i10;
                    }
                    unsafe.putInt(t, j2, i4);
                    return a2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int a3 = c.a(a(i8), bArr, i, i2, aVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, aVar.c);
                    } else {
                        unsafe.putObject(t, j, Internal.a(object, aVar.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return a3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = c.e(bArr, i, aVar);
                    unsafe.putObject(t, j, aVar.c);
                    break;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a4 = c.a(bArr, i, aVar);
                    int i11 = aVar.f6808a;
                    Internal.EnumVerifier enumVerifier = (Internal.EnumVerifier) this.d[((i8 / 3) << 1) + 1];
                    if (enumVerifier == null || enumVerifier.a(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                        if (unknownFieldSetLite == UnknownFieldSetLite.a()) {
                            unknownFieldSetLite = UnknownFieldSetLite.b();
                            generatedMessageLite.unknownFields = unknownFieldSetLite;
                        }
                        unknownFieldSetLite.a(i3, Long.valueOf(i11));
                    }
                    return a4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = c.a(bArr, i, aVar);
                    unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.e(aVar.f6808a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = c.b(bArr, i, aVar);
                    unsafe.putObject(t, j, Long.valueOf(CodedInputStream.a(aVar.b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = c.a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, aVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, aVar.c);
                        break;
                    } else {
                        unsafe.putObject(t, j, Internal.a(object2, aVar.c));
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

    private ao a(int i) {
        int i2 = (i / 3) << 1;
        ao aoVar = (ao) this.d[i2];
        if (aoVar != null) {
            return aoVar;
        }
        ao<T> a2 = ak.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:118:0x009d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a(T t, byte[] bArr, int i, int i2, int i3, c.a aVar) throws IOException {
        Unsafe unsafe;
        int i4;
        GeneratedMessageLite generatedMessageLite;
        ab<T> abVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int a2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        c.a aVar2;
        int i16;
        int i17;
        int i18;
        int i19;
        c.a aVar3;
        int i20;
        int i21;
        ab<T> abVar2 = this;
        GeneratedMessageLite generatedMessageLite2 = t;
        byte[] bArr2 = bArr;
        int i22 = i2;
        int i23 = i3;
        c.a aVar4 = aVar;
        Unsafe unsafe2 = b;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        while (true) {
            if (i24 < i22) {
                int i30 = i24 + 1;
                byte b2 = bArr2[i24];
                if (b2 < 0) {
                    int a3 = c.a(b2, bArr2, i30, aVar4);
                    i10 = aVar4.f6808a;
                    i30 = a3;
                } else {
                    i10 = b2;
                }
                int i31 = i10 >>> 3;
                int i32 = i10 & 7;
                if (i31 > i25) {
                    a2 = (i31 < abVar2.e || i31 > abVar2.f) ? -1 : abVar2.a(i31, i26 / 3);
                    i11 = -1;
                } else {
                    a2 = (i31 < abVar2.e || i31 > abVar2.f) ? -1 : abVar2.a(i31, 0);
                    i11 = -1;
                }
                if (a2 == i11) {
                    i12 = i31;
                    i5 = i30;
                    i6 = i10;
                    i13 = i28;
                    i14 = i29;
                    unsafe = unsafe2;
                    i4 = i23;
                    i15 = 0;
                } else {
                    int[] iArr = abVar2.c;
                    int i33 = iArr[a2 + 1];
                    int i34 = (i33 & 267386880) >>> 20;
                    int i35 = i10;
                    long j = i33 & 1048575;
                    if (i34 <= 17) {
                        int i36 = iArr[a2 + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = i36 & 1048575;
                        if (i38 != i29) {
                            if (i29 != -1) {
                                unsafe2.putInt(generatedMessageLite2, i29, i28);
                            }
                            i16 = i38;
                            i17 = unsafe2.getInt(generatedMessageLite2, i38);
                        } else {
                            i16 = i29;
                            i17 = i28;
                        }
                        switch (i34) {
                            case 0:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 1) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    aw.a(generatedMessageLite2, j, c.c(bArr2, i30));
                                    i24 = i30 + 8;
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 1:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 5) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    aw.a((Object) generatedMessageLite2, j, c.d(bArr2, i30));
                                    i24 = i30 + 4;
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 2:
                            case 3:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    int b3 = c.b(bArr2, i30, aVar);
                                    unsafe2.putLong(t, j, aVar.b);
                                    i28 = i17 | i37;
                                    i24 = b3;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 4:
                            case 11:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.a(bArr2, i30, aVar);
                                    unsafe2.putInt(generatedMessageLite2, j, aVar.f6808a);
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 5:
                            case 14:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 1) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, c.b(bArr2, i30));
                                    i24 = i30 + 8;
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 6:
                            case 13:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 5) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    unsafe2.putInt(generatedMessageLite2, j, c.a(bArr2, i30));
                                    i24 = i30 + 4;
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i23 = i3;
                                    i22 = i2;
                                    i25 = i12;
                                }
                            case 7:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.b(bArr2, i30, aVar);
                                    aw.a(generatedMessageLite2, j, aVar.b != 0);
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i23 = i3;
                                    i22 = i2;
                                    i25 = i12;
                                }
                            case 8:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 2) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    if ((i33 & DriveFile.MODE_WRITE_ONLY) == 0) {
                                        i24 = c.c(bArr2, i30, aVar);
                                    } else {
                                        i24 = c.d(bArr2, i30, aVar);
                                    }
                                    unsafe2.putObject(generatedMessageLite2, j, aVar.c);
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i23 = i3;
                                    i22 = i2;
                                    i25 = i12;
                                }
                            case 9:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 2) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.a(abVar2.a(i18), bArr2, i30, i2, aVar);
                                    if ((i17 & i37) == 0) {
                                        unsafe2.putObject(generatedMessageLite2, j, aVar.c);
                                    } else {
                                        unsafe2.putObject(generatedMessageLite2, j, Internal.a(unsafe2.getObject(generatedMessageLite2, j), aVar.c));
                                    }
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i23 = i3;
                                    i22 = i2;
                                    i25 = i12;
                                }
                            case 10:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 2) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.e(bArr2, i30, aVar);
                                    unsafe2.putObject(generatedMessageLite2, j, aVar.c);
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 12:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.a(bArr2, i30, aVar);
                                    int i39 = aVar.f6808a;
                                    Internal.EnumVerifier enumVerifier = (Internal.EnumVerifier) abVar2.d[((i18 / 3) << 1) + 1];
                                    if (enumVerifier == null || enumVerifier.a(i39)) {
                                        unsafe2.putInt(generatedMessageLite2, j, i39);
                                        i28 = i17 | i37;
                                        i29 = i16;
                                        i26 = i18;
                                        i27 = i19;
                                        aVar4 = aVar;
                                        i25 = i12;
                                        i23 = i3;
                                        i22 = i2;
                                    } else {
                                        GeneratedMessageLite generatedMessageLite3 = generatedMessageLite2;
                                        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite3.unknownFields;
                                        if (unknownFieldSetLite == UnknownFieldSetLite.a()) {
                                            unknownFieldSetLite = UnknownFieldSetLite.b();
                                            generatedMessageLite3.unknownFields = unknownFieldSetLite;
                                        }
                                        unknownFieldSetLite.a(i19, Long.valueOf(i39));
                                        i28 = i17;
                                        i29 = i16;
                                        i26 = i18;
                                        i27 = i19;
                                        aVar4 = aVar;
                                        i25 = i12;
                                        i23 = i3;
                                        i22 = i2;
                                    }
                                }
                                break;
                            case 15:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                bArr2 = bArr;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    i24 = c.a(bArr2, i30, aVar);
                                    unsafe2.putInt(generatedMessageLite2, j, CodedInputStream.e(aVar.f6808a));
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 16:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                if (i32 != 0) {
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    int b4 = c.b(bArr2, i30, aVar);
                                    unsafe2.putLong(t, j, CodedInputStream.a(aVar.b));
                                    i28 = i17 | i37;
                                    i24 = b4;
                                    i29 = i16;
                                    i26 = i18;
                                    i27 = i19;
                                    aVar4 = aVar;
                                    i25 = i12;
                                    i23 = i3;
                                    i22 = i2;
                                }
                            case 17:
                                if (i32 != 3) {
                                    i12 = i31;
                                    i18 = a2;
                                    i19 = i35;
                                    i5 = i30;
                                    i13 = i17;
                                    i14 = i16;
                                    i15 = i18;
                                    unsafe = unsafe2;
                                    i6 = i19;
                                    i4 = i3;
                                    break;
                                } else {
                                    int i40 = a2;
                                    i24 = c.a(abVar2.a(a2), bArr, i30, i2, (i31 << 3) | 4, aVar);
                                    if ((i17 & i37) == 0) {
                                        aVar3 = aVar;
                                        unsafe2.putObject(generatedMessageLite2, j, aVar3.c);
                                    } else {
                                        aVar3 = aVar;
                                        unsafe2.putObject(generatedMessageLite2, j, Internal.a(unsafe2.getObject(generatedMessageLite2, j), aVar3.c));
                                    }
                                    i28 = i17 | i37;
                                    i29 = i16;
                                    i26 = i40;
                                    i27 = i35;
                                    i25 = i31;
                                    i23 = i3;
                                    bArr2 = bArr;
                                    i22 = i2;
                                    aVar4 = aVar3;
                                }
                            default:
                                i12 = i31;
                                i18 = a2;
                                i19 = i35;
                                i5 = i30;
                                i13 = i17;
                                i14 = i16;
                                i15 = i18;
                                unsafe = unsafe2;
                                i6 = i19;
                                i4 = i3;
                                break;
                        }
                    } else {
                        i12 = i31;
                        c.a aVar5 = aVar4;
                        int i41 = a2;
                        bArr2 = bArr;
                        if (i34 != 27) {
                            i13 = i28;
                            i14 = i29;
                            if (i34 <= 49) {
                                int i42 = i30;
                                i15 = i41;
                                unsafe = unsafe2;
                                i24 = a((ab<T>) t, bArr, i30, i2, i35, i12, i32, i41, i33, i34, j, aVar);
                                if (i24 == i42) {
                                    i5 = i24;
                                    i6 = i35;
                                    i4 = i3;
                                } else {
                                    bArr2 = bArr;
                                    i28 = i13;
                                    i25 = i12;
                                    i27 = i35;
                                    i29 = i14;
                                    unsafe2 = unsafe;
                                    i26 = i15;
                                    aVar4 = aVar;
                                    i23 = i3;
                                    i22 = i2;
                                    generatedMessageLite2 = t;
                                    abVar2 = this;
                                }
                            } else {
                                i20 = i30;
                                i21 = i35;
                                i15 = i41;
                                unsafe = unsafe2;
                                if (i34 != 50) {
                                    i24 = a((ab<T>) t, bArr, i20, i2, i21, i12, i32, i33, i34, j, i15, aVar);
                                    if (i24 == i20) {
                                        i5 = i24;
                                        i6 = i21;
                                        i4 = i3;
                                    } else {
                                        bArr2 = bArr;
                                        i27 = i21;
                                        i28 = i13;
                                        i25 = i12;
                                        i29 = i14;
                                        unsafe2 = unsafe;
                                        i26 = i15;
                                        aVar4 = aVar;
                                        i23 = i3;
                                        i22 = i2;
                                        generatedMessageLite2 = t;
                                        abVar2 = this;
                                    }
                                } else if (i32 == 2) {
                                    i24 = a(t, bArr, i20, i2, i15, j, aVar);
                                    if (i24 == i20) {
                                        i5 = i24;
                                        i6 = i21;
                                        i4 = i3;
                                    } else {
                                        bArr2 = bArr;
                                        i28 = i13;
                                        i25 = i12;
                                        i27 = i21;
                                        i29 = i14;
                                        unsafe2 = unsafe;
                                        i26 = i15;
                                        aVar4 = aVar;
                                        i23 = i3;
                                        i22 = i2;
                                        generatedMessageLite2 = t;
                                        abVar2 = this;
                                    }
                                } else {
                                    i5 = i20;
                                    i6 = i21;
                                    i4 = i3;
                                }
                            }
                        } else if (i32 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(generatedMessageLite2, j);
                            if (!protobufList.a()) {
                                int size = protobufList.size();
                                protobufList = protobufList.c(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(generatedMessageLite2, j, protobufList);
                            }
                            i24 = c.a(abVar2.a(i41), i35, bArr, i30, i2, protobufList, aVar);
                            i27 = i35;
                            i26 = i41;
                            aVar4 = aVar5;
                            i28 = i28;
                            i25 = i12;
                            i29 = i29;
                            i23 = i3;
                            i22 = i2;
                        } else {
                            i13 = i28;
                            i14 = i29;
                            i20 = i30;
                            i21 = i35;
                            i15 = i41;
                            unsafe = unsafe2;
                            i5 = i20;
                            i6 = i21;
                            i4 = i3;
                        }
                    }
                }
                if (i6 != i4 || i4 == 0) {
                    if (this.h) {
                        aVar2 = aVar;
                        if (aVar2.d != ExtensionRegistryLite.c()) {
                            i24 = c.a(i6, bArr, i5, i2, t, this.g, this.q, aVar);
                            bArr2 = bArr;
                            i27 = i6;
                            abVar2 = this;
                            aVar4 = aVar2;
                            i28 = i13;
                            i25 = i12;
                            i29 = i14;
                            unsafe2 = unsafe;
                            i26 = i15;
                            i22 = i2;
                            generatedMessageLite2 = t;
                            i23 = i4;
                        }
                    } else {
                        aVar2 = aVar;
                    }
                    GeneratedMessageLite generatedMessageLite4 = (GeneratedMessageLite) t;
                    UnknownFieldSetLite unknownFieldSetLite2 = generatedMessageLite4.unknownFields;
                    if (unknownFieldSetLite2 == UnknownFieldSetLite.a()) {
                        unknownFieldSetLite2 = UnknownFieldSetLite.b();
                        generatedMessageLite4.unknownFields = unknownFieldSetLite2;
                    }
                    i24 = c.a(i6, bArr, i5, i2, unknownFieldSetLite2, aVar);
                    bArr2 = bArr;
                    generatedMessageLite2 = t;
                    i27 = i6;
                    abVar2 = this;
                    aVar4 = aVar2;
                    i28 = i13;
                    i25 = i12;
                    i29 = i14;
                    unsafe2 = unsafe;
                    i26 = i15;
                    i22 = i2;
                    i23 = i4;
                } else {
                    i7 = i13;
                    i8 = i14;
                    i9 = -1;
                    generatedMessageLite = t;
                    abVar = this;
                }
            } else {
                int i43 = i29;
                unsafe = unsafe2;
                i4 = i23;
                generatedMessageLite = generatedMessageLite2;
                abVar = abVar2;
                i5 = i24;
                i6 = i27;
                i7 = i28;
                i8 = i43;
                i9 = -1;
            }
        }
        if (i8 != i9) {
            unsafe.putInt(generatedMessageLite, i8, i7);
        }
        UnknownFieldSetLite unknownFieldSetLite3 = null;
        for (int i44 = abVar.m; i44 < abVar.n; i44++) {
            unknownFieldSetLite3 = (UnknownFieldSetLite) abVar.a((Object) generatedMessageLite, abVar.l[i44], (int) unknownFieldSetLite3, (at<UT, int>) abVar.q);
        }
        if (unknownFieldSetLite3 != null) {
            abVar.q.b((Object) generatedMessageLite, (GeneratedMessageLite) unknownFieldSetLite3);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw InvalidProtocolBufferException.k();
            }
        } else if (i5 > i2 || i6 != i4) {
            throw InvalidProtocolBufferException.k();
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x01f7, code lost:
    
        if (r0 == r15) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0247, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0226, code lost:
    
        if (r0 == r15) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0245, code lost:
    
        if (r0 == r15) goto L119;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0074. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r28v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r28, byte[] r29, int r30, int r31, com.uqm.crashsight.protobuf.c.a r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.a(java.lang.Object, byte[], int, int, com.uqm.crashsight.protobuf.c$a):void");
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final void d(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long j = this.c[this.l[i2] + 1] & 1048575;
            Object f = aw.f(t, j);
            if (f != null) {
                aw.a(t, j, this.s.d(f));
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

    private final <UT, UB> UB a(Object obj, int i, UB ub, at<UT, UB> atVar) {
        Internal.EnumVerifier enumVerifier;
        int i2 = this.c[i];
        Object f = aw.f(obj, r0[i + 1] & 1048575);
        return (f == null || (enumVerifier = (Internal.EnumVerifier) this.d[((i / 3) << 1) + 1]) == null) ? ub : (UB) a(i, i2, this.s.a(f), enumVerifier, (Internal.EnumVerifier) ub, (at<UT, Internal.EnumVerifier>) atVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, at<UT, UB> atVar) {
        MapEntryLite.a<?, ?> f = this.s.f(this.d[(i / 3) << 1]);
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = atVar.a();
                }
                ByteString.d c = ByteString.c(MapEntryLite.a(f, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.a(c.b(), f, next.getKey(), next.getValue());
                    atVar.a((at<UT, UB>) ub, i2, c.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0136, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.uqm.crashsight.protobuf.ao] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.uqm.crashsight.protobuf.ao] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.uqm.crashsight.protobuf.ao] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.uqm.crashsight.protobuf.ao] */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(T r14) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ab.e(java.lang.Object):boolean");
    }

    private static void a(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.a(i, (String) obj);
        } else {
            writer.a(i, (ByteString) obj);
        }
    }

    private void a(Object obj, int i, an anVar) throws IOException {
        if ((536870912 & i) != 0) {
            aw.a(obj, i & 1048575, anVar.n());
        } else if (this.i) {
            aw.a(obj, i & 1048575, anVar.m());
        } else {
            aw.a(obj, i & 1048575, anVar.o());
        }
    }

    private int b(int i) {
        return this.c[i];
    }

    private int c(int i) {
        return this.c[i + 2];
    }

    private static <T> double a(T t, long j) {
        return aw.e(t, j);
    }

    private static <T> float b(T t, long j) {
        return aw.d(t, j);
    }

    private static <T> int c(T t, long j) {
        return aw.a(t, j);
    }

    private static <T> long d(T t, long j) {
        return aw.b(t, j);
    }

    private static <T> boolean e(T t, long j) {
        return aw.c(t, j);
    }

    private static <T> double f(T t, long j) {
        return ((Double) aw.f(t, j)).doubleValue();
    }

    private static <T> float g(T t, long j) {
        return ((Float) aw.f(t, j)).floatValue();
    }

    private static <T> int h(T t, long j) {
        return ((Integer) aw.f(t, j)).intValue();
    }

    private static <T> long i(T t, long j) {
        return ((Long) aw.f(t, j)).longValue();
    }

    private static <T> boolean j(T t, long j) {
        return ((Boolean) aw.f(t, j)).booleanValue();
    }

    private boolean a(T t, int i) {
        if (this.j) {
            int i2 = this.c[i + 1];
            long j = i2 & 1048575;
            switch ((i2 & 267386880) >>> 20) {
                case 0:
                    return aw.e(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return aw.d(t, j) != 0.0f;
                case 2:
                    return aw.b(t, j) != 0;
                case 3:
                    return aw.b(t, j) != 0;
                case 4:
                    return aw.a(t, j) != 0;
                case 5:
                    return aw.b(t, j) != 0;
                case 6:
                    return aw.a(t, j) != 0;
                case 7:
                    return aw.c(t, j);
                case 8:
                    Object f = aw.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof ByteString) {
                        return !ByteString.f6635a.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return aw.f(t, j) != null;
                case 10:
                    return !ByteString.f6635a.equals(aw.f(t, j));
                case 11:
                    return aw.a(t, j) != 0;
                case 12:
                    return aw.a(t, j) != 0;
                case 13:
                    return aw.a(t, j) != 0;
                case 14:
                    return aw.b(t, j) != 0;
                case 15:
                    return aw.a(t, j) != 0;
                case 16:
                    return aw.b(t, j) != 0;
                case 17:
                    return aw.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int i3 = this.c[i + 2];
        return (aw.a(t, (long) (i3 & 1048575)) & (1 << (i3 >>> 20))) != 0;
    }

    private void b(T t, int i) {
        if (this.j) {
            return;
        }
        int i2 = this.c[i + 2];
        long j = i2 & 1048575;
        aw.a((Object) t, j, aw.a(t, j) | (1 << (i2 >>> 20)));
    }

    private boolean a(T t, int i, int i2) {
        return aw.a(t, (long) (this.c[i2 + 2] & 1048575)) == i;
    }

    private int a(int i, int i2) {
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
