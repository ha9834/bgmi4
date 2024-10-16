package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ee implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private zzur<?, ?> f4359a;
    private Object b;
    private List<ef> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ef efVar) throws IOException {
        Object a2;
        List<ef> list = this.c;
        if (list != null) {
            list.add(efVar);
            return;
        }
        Object obj = this.b;
        if (obj instanceof zzuw) {
            byte[] bArr = efVar.b;
            zzun zzj = zzun.zzj(bArr, 0, bArr.length);
            int zzoa = zzj.zzoa();
            if (zzoa != bArr.length - zzuo.zzbc(zzoa)) {
                throw zzuv.a();
            }
            a2 = ((zzuw) this.b).zza(zzj);
        } else if (obj instanceof zzuw[]) {
            zzuw[] zzuwVarArr = (zzuw[]) this.f4359a.a(Collections.singletonList(efVar));
            zzuw[] zzuwVarArr2 = (zzuw[]) this.b;
            zzuw[] zzuwVarArr3 = (zzuw[]) Arrays.copyOf(zzuwVarArr2, zzuwVarArr2.length + zzuwVarArr.length);
            System.arraycopy(zzuwVarArr, 0, zzuwVarArr3, zzuwVarArr2.length, zzuwVarArr.length);
            a2 = zzuwVarArr3;
        } else if (obj instanceof zzsk) {
            a2 = ((zzsk) this.b).zzpg().zza((zzsk) this.f4359a.a(Collections.singletonList(efVar))).zzpm();
        } else if (obj instanceof zzsk[]) {
            zzsk[] zzskVarArr = (zzsk[]) this.f4359a.a(Collections.singletonList(efVar));
            zzsk[] zzskVarArr2 = (zzsk[]) this.b;
            zzsk[] zzskVarArr3 = (zzsk[]) Arrays.copyOf(zzskVarArr2, zzskVarArr2.length + zzskVarArr.length);
            System.arraycopy(zzskVarArr, 0, zzskVarArr3, zzskVarArr2.length, zzskVarArr.length);
            a2 = zzskVarArr3;
        } else {
            a2 = this.f4359a.a(Collections.singletonList(efVar));
        }
        this.f4359a = this.f4359a;
        this.b = a2;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(zzur<?, T> zzurVar) {
        if (this.b != null) {
            if (!this.f4359a.equals(zzurVar)) {
                throw new IllegalStateException("Tried to getExtension with a different Extension.");
            }
        } else {
            this.f4359a = zzurVar;
            this.b = zzurVar.a(this.c);
            this.c = null;
        }
        return (T) this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        Object obj = this.b;
        if (obj != null) {
            zzur<?, ?> zzurVar = this.f4359a;
            if (zzurVar.b) {
                int length = Array.getLength(obj);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj2 = Array.get(obj, i2);
                    if (obj2 != null) {
                        i += zzurVar.a(obj2);
                    }
                }
                return i;
            }
            return zzurVar.a(obj);
        }
        int i3 = 0;
        for (ef efVar : this.c) {
            i3 += zzuo.zzbj(efVar.f4360a) + 0 + efVar.b.length;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzuo zzuoVar) throws IOException {
        Object obj = this.b;
        if (obj != null) {
            zzur<?, ?> zzurVar = this.f4359a;
            if (zzurVar.b) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzurVar.a(obj2, zzuoVar);
                    }
                }
                return;
            }
            zzurVar.a(obj, zzuoVar);
            return;
        }
        for (ef efVar : this.c) {
            zzuoVar.zzcb(efVar.f4360a);
            zzuoVar.zzm(efVar.b);
        }
    }

    public final boolean equals(Object obj) {
        List<ef> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ee)) {
            return false;
        }
        ee eeVar = (ee) obj;
        if (this.b != null && eeVar.b != null) {
            zzur<?, ?> zzurVar = this.f4359a;
            if (zzurVar != eeVar.f4359a) {
                return false;
            }
            if (!zzurVar.f4458a.isArray()) {
                return this.b.equals(eeVar.b);
            }
            Object obj2 = this.b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) eeVar.b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) eeVar.b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) eeVar.b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) eeVar.b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) eeVar.b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) eeVar.b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) eeVar.b);
        }
        List<ef> list2 = this.c;
        if (list2 != null && (list = eeVar.c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), eeVar.b());
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
        a(zzuo.zzl(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ee clone() {
        ee eeVar = new ee();
        try {
            eeVar.f4359a = this.f4359a;
            if (this.c == null) {
                eeVar.c = null;
            } else {
                eeVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zzuw) {
                    eeVar.b = (zzuw) ((zzuw) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    eeVar.b = ((byte[]) this.b).clone();
                } else {
                    int i = 0;
                    if (this.b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.b;
                        byte[][] bArr2 = new byte[bArr.length];
                        eeVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.b instanceof boolean[]) {
                        eeVar.b = ((boolean[]) this.b).clone();
                    } else if (this.b instanceof int[]) {
                        eeVar.b = ((int[]) this.b).clone();
                    } else if (this.b instanceof long[]) {
                        eeVar.b = ((long[]) this.b).clone();
                    } else if (this.b instanceof float[]) {
                        eeVar.b = ((float[]) this.b).clone();
                    } else if (this.b instanceof double[]) {
                        eeVar.b = ((double[]) this.b).clone();
                    } else if (this.b instanceof zzuw[]) {
                        zzuw[] zzuwVarArr = (zzuw[]) this.b;
                        zzuw[] zzuwVarArr2 = new zzuw[zzuwVarArr.length];
                        eeVar.b = zzuwVarArr2;
                        while (i < zzuwVarArr.length) {
                            zzuwVarArr2[i] = (zzuw) zzuwVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return eeVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
