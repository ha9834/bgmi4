package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzby extends AbstractMap<String, Object> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    Map<String, Object> f4139a;
    final zzbr b;

    /* loaded from: classes2.dex */
    public enum zzc {
        IGNORE_CASE
    }

    public zzby() {
        this(EnumSet.noneOf(zzc.class));
    }

    /* loaded from: classes2.dex */
    final class a extends AbstractSet<Map.Entry<String, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private final o f4140a;

        a() {
            this.f4140a = (o) new l(zzby.this, zzby.this.b.zzbv()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<String, Object>> iterator() {
            return new b(zzby.this, this.f4140a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return zzby.this.f4139a.size() + this.f4140a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            zzby.this.f4139a.clear();
            this.f4140a.clear();
        }
    }

    public zzby(EnumSet<zzc> enumSet) {
        this.f4139a = new zzbl();
        this.b = zzbr.zza(getClass(), enumSet.contains(zzc.IGNORE_CASE));
    }

    /* loaded from: classes2.dex */
    final class b implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4141a;
        private final Iterator<Map.Entry<String, Object>> b;
        private final Iterator<Map.Entry<String, Object>> c;

        b(zzby zzbyVar, o oVar) {
            this.b = (m) oVar.iterator();
            this.c = zzbyVar.f4139a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f4141a) {
                this.c.remove();
            }
            this.b.remove();
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Map.Entry<String, Object> next() {
            if (!this.f4141a) {
                if (this.b.hasNext()) {
                    return this.b.next();
                }
                this.f4141a = true;
            }
            return this.c.next();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        zzbz zzae = this.b.zzae(str);
        if (zzae != null) {
            return zzae.zzh(this);
        }
        if (this.b.zzbv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.f4139a.get(str);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(String str, Object obj) {
        zzbz zzae = this.b.zzae(str);
        if (zzae != null) {
            Object zzh = zzae.zzh(this);
            zzae.zzb(this, obj);
            return zzh;
        }
        if (this.b.zzbv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.f4139a.put(str, obj);
    }

    public zzby zzb(String str, Object obj) {
        zzbz zzae = this.b.zzae(str);
        if (zzae != null) {
            zzae.zzb(this, obj);
        } else {
            if (this.b.zzbv()) {
                str = str.toLowerCase(Locale.US);
            }
            this.f4139a.put(str, obj);
        }
        return this;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            zzb(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.b.zzae(str) != null) {
            throw new UnsupportedOperationException();
        }
        if (this.b.zzbv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.f4139a.remove(str);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new a();
    }

    @Override // java.util.AbstractMap
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzby clone() {
        try {
            zzby zzbyVar = (zzby) super.clone();
            zzbt.zza(this, zzbyVar);
            zzbyVar.f4139a = (Map) zzbt.clone(this.f4139a);
            return zzbyVar;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public final zzbr zzby() {
        return this.b;
    }
}
