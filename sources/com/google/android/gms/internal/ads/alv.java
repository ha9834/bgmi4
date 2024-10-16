package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class alv implements aly {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1960a = new byte[8];
    private final Stack<alx> b = new Stack<>();
    private final ame c = new ame();
    private alz d;
    private int e;
    private int f;
    private long g;

    @Override // com.google.android.gms.internal.ads.aly
    public final void a(alz alzVar) {
        this.d = alzVar;
    }

    @Override // com.google.android.gms.internal.ads.aly
    public final void a() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.aly
    public final boolean a(zzno zznoVar) throws IOException, InterruptedException {
        String str;
        double longBitsToDouble;
        long j;
        int i;
        zzsk.checkState(this.d != null);
        while (true) {
            if (!this.b.isEmpty()) {
                long position = zznoVar.getPosition();
                j = this.b.peek().b;
                if (position >= j) {
                    alz alzVar = this.d;
                    i = this.b.pop().f1961a;
                    alzVar.c(i);
                    return true;
                }
            }
            if (this.e == 0) {
                long a2 = this.c.a(zznoVar, true, false, 4);
                if (a2 == -2) {
                    zznoVar.zzig();
                    while (true) {
                        zznoVar.zzc(this.f1960a, 0, 4);
                        int a3 = ame.a(this.f1960a[0]);
                        if (a3 != -1 && a3 <= 4) {
                            int a4 = (int) ame.a(this.f1960a, a3, false);
                            if (this.d.b(a4)) {
                                zznoVar.zzr(a3);
                                a2 = a4;
                            }
                        }
                        zznoVar.zzr(1);
                    }
                }
                if (a2 == -1) {
                    return false;
                }
                this.f = (int) a2;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(zznoVar, false, true, 8);
                this.e = 2;
            }
            int a5 = this.d.a(this.f);
            switch (a5) {
                case 0:
                    zznoVar.zzr((int) this.g);
                    this.e = 0;
                case 1:
                    long position2 = zznoVar.getPosition();
                    this.b.add(new alx(this.f, this.g + position2));
                    this.d.a(this.f, position2, this.g);
                    this.e = 0;
                    return true;
                case 2:
                    long j2 = this.g;
                    if (j2 > 8) {
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j2);
                        throw new zzlm(sb.toString());
                    }
                    this.d.a(this.f, a(zznoVar, (int) j2));
                    this.e = 0;
                    return true;
                case 3:
                    long j3 = this.g;
                    if (j3 > 2147483647L) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j3);
                        throw new zzlm(sb2.toString());
                    }
                    alz alzVar2 = this.d;
                    int i2 = this.f;
                    int i3 = (int) j3;
                    if (i3 == 0) {
                        str = "";
                    } else {
                        byte[] bArr = new byte[i3];
                        zznoVar.readFully(bArr, 0, i3);
                        str = new String(bArr);
                    }
                    alzVar2.a(i2, str);
                    this.e = 0;
                    return true;
                case 4:
                    this.d.a(this.f, (int) this.g, zznoVar);
                    this.e = 0;
                    return true;
                case 5:
                    long j4 = this.g;
                    if (j4 != 4 && j4 != 8) {
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j4);
                        throw new zzlm(sb3.toString());
                    }
                    alz alzVar3 = this.d;
                    int i4 = this.f;
                    int i5 = (int) this.g;
                    long a6 = a(zznoVar, i5);
                    if (i5 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) a6);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(a6);
                    }
                    alzVar3.a(i4, longBitsToDouble);
                    this.e = 0;
                    return true;
                default:
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a5);
                    throw new zzlm(sb4.toString());
            }
        }
    }

    private final long a(zzno zznoVar, int i) throws IOException, InterruptedException {
        zznoVar.readFully(this.f1960a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f1960a[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        }
        return j;
    }
}
