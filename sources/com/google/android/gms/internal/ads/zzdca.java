package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class zzdca<P> {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f3539a = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<zzdcb<P>>> b = new ConcurrentHashMap();
    private zzdcb<P> c;
    private final Class<P> d;

    public final zzdcb<P> zzanu() {
        return this.c;
    }

    private zzdca(Class<P> cls) {
        this.d = cls;
    }

    public static <P> zzdca<P> zza(Class<P> cls) {
        return new zzdca<>(cls);
    }

    public final void zza(zzdcb<P> zzdcbVar) {
        this.c = zzdcbVar;
    }

    public final zzdcb<P> zza(P p, zzdha.zzb zzbVar) throws GeneralSecurityException {
        byte[] array;
        switch (abk.f1782a[zzbVar.zzanw().ordinal()]) {
            case 1:
            case 2:
                array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.zzasp()).array();
                break;
            case 3:
                array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.zzasp()).array();
                break;
            case 4:
                array = zzdbm.zzgoz;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        zzdcb<P> zzdcbVar = new zzdcb<>(p, array, zzbVar.zzaso(), zzbVar.zzanw());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdcbVar);
        String str = new String(zzdcbVar.zzanx(), f3539a);
        List<zzdcb<P>> put = this.b.put(str, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzdcbVar);
            this.b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdcbVar;
    }

    public final Class<P> zzanr() {
        return this.d;
    }
}
