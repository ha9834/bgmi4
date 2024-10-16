package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class aic implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private zzdrs<?, ?> f1888a;
    private Object b;
    private List<Object> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzdrp zzdrpVar) throws IOException {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.c.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aic)) {
            return false;
        }
        aic aicVar = (aic) obj;
        if (this.b != null && aicVar.b != null) {
            zzdrs<?, ?> zzdrsVar = this.f1888a;
            if (zzdrsVar != aicVar.f1888a) {
                return false;
            }
            if (!zzdrsVar.f3604a.isArray()) {
                return this.b.equals(aicVar.b);
            }
            Object obj2 = this.b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) aicVar.b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) aicVar.b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) aicVar.b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) aicVar.b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) aicVar.b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) aicVar.b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) aicVar.b);
        }
        List<Object> list2 = this.c;
        if (list2 != null && (list = aicVar.c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), aicVar.b());
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
        a(zzdrp.zzaf(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final aic clone() {
        aic aicVar = new aic();
        try {
            aicVar.f1888a = this.f1888a;
            if (this.c == null) {
                aicVar.c = null;
            } else {
                aicVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zzdrw) {
                    aicVar.b = (zzdrw) ((zzdrw) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    aicVar.b = ((byte[]) this.b).clone();
                } else {
                    int i = 0;
                    if (this.b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.b;
                        byte[][] bArr2 = new byte[bArr.length];
                        aicVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.b instanceof boolean[]) {
                        aicVar.b = ((boolean[]) this.b).clone();
                    } else if (this.b instanceof int[]) {
                        aicVar.b = ((int[]) this.b).clone();
                    } else if (this.b instanceof long[]) {
                        aicVar.b = ((long[]) this.b).clone();
                    } else if (this.b instanceof float[]) {
                        aicVar.b = ((float[]) this.b).clone();
                    } else if (this.b instanceof double[]) {
                        aicVar.b = ((double[]) this.b).clone();
                    } else if (this.b instanceof zzdrw[]) {
                        zzdrw[] zzdrwVarArr = (zzdrw[]) this.b;
                        zzdrw[] zzdrwVarArr2 = new zzdrw[zzdrwVarArr.length];
                        aicVar.b = zzdrwVarArr2;
                        while (i < zzdrwVarArr.length) {
                            zzdrwVarArr2[i] = (zzdrw) zzdrwVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return aicVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
