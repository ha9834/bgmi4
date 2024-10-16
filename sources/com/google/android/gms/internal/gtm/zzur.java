package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzur<M extends zzuq<M>, T> {

    /* renamed from: a, reason: collision with root package name */
    protected final Class<T> f4458a;
    protected final boolean b;
    private final int c;
    private final zzrc<?, ?> d;
    public final int tag;

    public static <M extends zzuq<M>, T extends zzuw> zzur<M, T> zza(int i, Class<T> cls, long j) {
        return new zzur<>(11, cls, 810, false);
    }

    private zzur(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzur(int i, Class<T> cls, zzrc<?, ?> zzrcVar, int i2, boolean z) {
        this.c = i;
        this.f4458a = cls;
        this.tag = i2;
        this.b = false;
        this.d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzurVar = (zzur) obj;
        return this.c == zzurVar.c && this.f4458a == zzurVar.f4458a && this.tag == zzurVar.tag && this.b == zzurVar.b;
    }

    public final int hashCode() {
        return ((((((this.c + 1147) * 31) + this.f4458a.hashCode()) * 31) + this.tag) * 31) + (this.b ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T a(List<ef> list) {
        if (list == null) {
            return null;
        }
        if (this.b) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ef efVar = list.get(i);
                if (efVar.b.length != 0) {
                    arrayList.add(a(zzun.zzk(efVar.b)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            Class<T> cls = this.f4458a;
            T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        }
        if (list.isEmpty()) {
            return null;
        }
        return this.f4458a.cast(a(zzun.zzk(list.get(list.size() - 1).b)));
    }

    private final Object a(zzun zzunVar) {
        Class componentType = this.b ? this.f4458a.getComponentType() : this.f4458a;
        try {
            switch (this.c) {
                case 10:
                    zzuw zzuwVar = (zzuw) componentType.newInstance();
                    zzunVar.zza(zzuwVar, this.tag >>> 3);
                    return zzuwVar;
                case 11:
                    zzuw zzuwVar2 = (zzuw) componentType.newInstance();
                    zzunVar.zza(zzuwVar2);
                    return zzuwVar2;
                default:
                    int i = this.c;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Object obj, zzuo zzuoVar) {
        try {
            zzuoVar.zzcb(this.tag);
            switch (this.c) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzuw) obj).zza(zzuoVar);
                    zzuoVar.zzd(i, 4);
                    return;
                case 11:
                    zzuoVar.zzb((zzuw) obj);
                    return;
                default:
                    int i2 = this.c;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i2);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.c;
        switch (i2) {
            case 10:
                return (zzuo.zzbb(i) << 1) + ((zzuw) obj).zzpe();
            case 11:
                return zzuo.zzb(i, (zzuw) obj);
            default:
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
        }
    }
}
