package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class eq implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private zzip<?, ?> f4534a;
    private Object b;
    private List<er> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(er erVar) throws IOException {
        List<er> list = this.c;
        if (list != null) {
            list.add(erVar);
            return;
        }
        Object obj = this.b;
        if (obj instanceof zziw) {
            byte[] bArr = erVar.b;
            zzil zzj = zzil.zzj(bArr, 0, bArr.length);
            int zzta = zzj.zzta();
            if (zzta != bArr.length - zzio.zzbj(zzta)) {
                throw zzit.a();
            }
            zziw zza = ((zziw) this.b).zza(zzj);
            this.f4534a = this.f4534a;
            this.b = zza;
            this.c = null;
            return;
        }
        if (obj instanceof zziw[]) {
            Collections.singletonList(erVar);
            throw new NoSuchMethodError();
        }
        if (obj instanceof zzgi) {
            Collections.singletonList(erVar);
            throw new NoSuchMethodError();
        }
        if (obj instanceof zzgi[]) {
            Collections.singletonList(erVar);
            throw new NoSuchMethodError();
        }
        Collections.singletonList(erVar);
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a() {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        int i = 0;
        for (er erVar : this.c) {
            i += zzio.zzbq(erVar.f4535a) + 0 + erVar.b.length;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(zzio zzioVar) throws IOException {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        for (er erVar : this.c) {
            zzioVar.zzck(erVar.f4535a);
            zzioVar.zzk(erVar.b);
        }
    }

    public final boolean equals(Object obj) {
        List<er> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eq)) {
            return false;
        }
        eq eqVar = (eq) obj;
        if (this.b != null && eqVar.b != null) {
            zzip<?, ?> zzipVar = this.f4534a;
            if (zzipVar != eqVar.f4534a) {
                return false;
            }
            if (!zzipVar.f4575a.isArray()) {
                return this.b.equals(eqVar.b);
            }
            Object obj2 = this.b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) eqVar.b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) eqVar.b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) eqVar.b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) eqVar.b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) eqVar.b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) eqVar.b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) eqVar.b);
        }
        List<er> list2 = this.c;
        if (list2 != null && (list = eqVar.c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), eqVar.b());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzio.zzj(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final eq clone() {
        eq eqVar = new eq();
        try {
            eqVar.f4534a = this.f4534a;
            if (this.c == null) {
                eqVar.c = null;
            } else {
                eqVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zziw) {
                    eqVar.b = (zziw) ((zziw) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    eqVar.b = ((byte[]) this.b).clone();
                } else {
                    int i = 0;
                    if (this.b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.b;
                        byte[][] bArr2 = new byte[bArr.length];
                        eqVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.b instanceof boolean[]) {
                        eqVar.b = ((boolean[]) this.b).clone();
                    } else if (this.b instanceof int[]) {
                        eqVar.b = ((int[]) this.b).clone();
                    } else if (this.b instanceof long[]) {
                        eqVar.b = ((long[]) this.b).clone();
                    } else if (this.b instanceof float[]) {
                        eqVar.b = ((float[]) this.b).clone();
                    } else if (this.b instanceof double[]) {
                        eqVar.b = ((double[]) this.b).clone();
                    } else if (this.b instanceof zziw[]) {
                        zziw[] zziwVarArr = (zziw[]) this.b;
                        zziw[] zziwVarArr2 = new zziw[zziwVarArr.length];
                        eqVar.b = zziwVarArr2;
                        while (i < zziwVarArr.length) {
                            zziwVarArr2[i] = (zziw) zziwVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return eqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
