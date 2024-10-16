package com.google.android.gms.internal.ads;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.internal.ads.zzdob;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzdno {
    private static volatile boolean b;
    private static volatile zzdno d;
    private final Map<a, zzdob.zzd<?, ?>> e;
    private static final Class<?> c = b();

    /* renamed from: a, reason: collision with root package name */
    static final zzdno f3586a = new zzdno(true);

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f3587a;
        private final int b;

        a(Object obj, int i) {
            this.f3587a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f3587a) * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3587a == aVar.f3587a && this.b == aVar.b;
        }
    }

    public static zzdno zzaxd() {
        return afg.a();
    }

    public static zzdno zzaxe() {
        zzdno zzdnoVar = d;
        if (zzdnoVar == null) {
            synchronized (zzdno.class) {
                zzdnoVar = d;
                if (zzdnoVar == null) {
                    zzdnoVar = afg.b();
                    d = zzdnoVar;
                }
            }
        }
        return zzdnoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdno a() {
        return afo.a(zzdno.class);
    }

    public final <ContainingType extends zzdpk> zzdob.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzdob.zzd) this.e.get(new a(containingtype, i));
    }

    zzdno() {
        this.e = new HashMap();
    }

    private zzdno(boolean z) {
        this.e = Collections.emptyMap();
    }
}
