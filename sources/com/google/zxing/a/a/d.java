package com.google.zxing.a.a;

import com.google.android.gms.games.Notifications;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f5397a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    static final int[][] c;
    private static final int[][] d;
    private final byte[] e;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        d = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            d[0][i] = (i - 65) + 2;
        }
        d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            d[1][i2] = (i2 - 97) + 2;
        }
        d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            d[2][i3] = (i3 - 48) + 2;
        }
        int[][] iArr2 = d;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, Notifications.NOTIFICATION_TYPES_ALL};
        for (int i4 = 0; i4 < 28; i4++) {
            d[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            if (iArr4[i5] > 0) {
                d[4][iArr4[i5]] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        c = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = c;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.e = bArr;
    }

    public com.google.zxing.common.a a() {
        Collection<f> singletonList = Collections.singletonList(f.f5399a);
        int i = 0;
        while (true) {
            byte[] bArr = this.e;
            if (i < bArr.length) {
                int i2 = i + 1;
                byte b2 = i2 < bArr.length ? bArr[i2] : (byte) 0;
                byte b3 = this.e[i];
                int i3 = b3 != 13 ? b3 != 44 ? b3 != 46 ? b3 != 58 ? 0 : b2 == 32 ? 5 : 0 : b2 == 32 ? 3 : 0 : b2 == 32 ? 4 : 0 : b2 == 10 ? 2 : 0;
                if (i3 > 0) {
                    singletonList = a(singletonList, i, i3);
                    i = i2;
                } else {
                    singletonList = a(singletonList, i);
                }
                i++;
            } else {
                return ((f) Collections.min(singletonList, new Comparator<f>() { // from class: com.google.zxing.a.a.d.1
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(f fVar, f fVar2) {
                        return fVar.c() - fVar2.c();
                    }
                })).a(this.e);
            }
        }
    }

    private Collection<f> a(Iterable<f> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, linkedList);
        }
        return a(linkedList);
    }

    private void a(f fVar, int i, Collection<f> collection) {
        char c2 = (char) (this.e[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        boolean z = d[fVar.a()][c2] > 0;
        f fVar2 = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = d[i2][c2];
            if (i3 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i);
                }
                if (!z || i2 == fVar.a() || i2 == 2) {
                    collection.add(fVar2.a(i2, i3));
                }
                if (!z && c[fVar.a()][i2] >= 0) {
                    collection.add(fVar2.b(i2, i3));
                }
            }
        }
        if (fVar.b() > 0 || d[fVar.a()][c2] == 0) {
            collection.add(fVar.a(i));
        }
    }

    private static Collection<f> a(Iterable<f> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(f fVar, int i, int i2, Collection<f> collection) {
        f b2 = fVar.b(i);
        collection.add(b2.a(4, i2));
        if (fVar.a() != 4) {
            collection.add(b2.b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b2.a(2, 16 - i2).a(2, 1));
        }
        if (fVar.b() > 0) {
            collection.add(fVar.a(i).a(i + 1));
        }
    }

    private static Collection<f> a(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    z = false;
                    break;
                }
                if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }
}
