package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cr implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private zzis<?, ?> f3931a;
    private Object b;
    private List<cs> c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzip.zzb(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final cr clone() {
        Object clone;
        cr crVar = new cr();
        try {
            crVar.f3931a = this.f3931a;
            if (this.c == null) {
                crVar.c = null;
            } else {
                crVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zzix) {
                    clone = (zzix) ((zzix) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    clone = ((byte[]) this.b).clone();
                } else {
                    int i = 0;
                    if (this.b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.b;
                        byte[][] bArr2 = new byte[bArr.length];
                        crVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.b instanceof boolean[]) {
                        clone = ((boolean[]) this.b).clone();
                    } else if (this.b instanceof int[]) {
                        clone = ((int[]) this.b).clone();
                    } else if (this.b instanceof long[]) {
                        clone = ((long[]) this.b).clone();
                    } else if (this.b instanceof float[]) {
                        clone = ((float[]) this.b).clone();
                    } else if (this.b instanceof double[]) {
                        clone = ((double[]) this.b).clone();
                    } else if (this.b instanceof zzix[]) {
                        zzix[] zzixVarArr = (zzix[]) this.b;
                        zzix[] zzixVarArr2 = new zzix[zzixVarArr.length];
                        crVar.b = zzixVarArr2;
                        while (i < zzixVarArr.length) {
                            zzixVarArr2[i] = (zzix) zzixVarArr[i].clone();
                            i++;
                        }
                    }
                }
                crVar.b = clone;
            }
            return crVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a() {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        int i = 0;
        for (cs csVar : this.c) {
            i += zzip.zzq(csVar.f3932a) + 0 + csVar.b.length;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(cs csVar) throws IOException {
        List<cs> list = this.c;
        if (list != null) {
            list.add(csVar);
            return;
        }
        Object obj = this.b;
        if (!(obj instanceof zzix)) {
            if (obj instanceof zzix[]) {
                Collections.singletonList(csVar);
                throw new NoSuchMethodError();
            }
            Collections.singletonList(csVar);
            throw new NoSuchMethodError();
        }
        byte[] bArr = csVar.b;
        zzio zza = zzio.zza(bArr, 0, bArr.length);
        int zzbe = zza.zzbe();
        if (zzbe != bArr.length - zzip.zzm(zzbe)) {
            throw zziw.a();
        }
        zzix zza2 = ((zzix) this.b).zza(zza);
        this.f3931a = this.f3931a;
        this.b = zza2;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(zzip zzipVar) throws IOException {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        for (cs csVar : this.c) {
            zzipVar.zzp(csVar.f3932a);
            zzipVar.zzc(csVar.b);
        }
    }

    public final boolean equals(Object obj) {
        List<cs> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cr)) {
            return false;
        }
        cr crVar = (cr) obj;
        if (this.b == null || crVar.b == null) {
            List<cs> list2 = this.c;
            if (list2 != null && (list = crVar.c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(b(), crVar.b());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        zzis<?, ?> zzisVar = this.f3931a;
        if (zzisVar != crVar.f3931a) {
            return false;
        }
        if (!zzisVar.f3997a.isArray()) {
            return this.b.equals(crVar.b);
        }
        Object obj2 = this.b;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) crVar.b) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) crVar.b) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) crVar.b) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) crVar.b) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) crVar.b) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) crVar.b) : Arrays.deepEquals((Object[]) obj2, (Object[]) crVar.b);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
