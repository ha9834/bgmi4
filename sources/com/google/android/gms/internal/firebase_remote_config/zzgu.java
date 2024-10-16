package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.internal.firebase_remote_config.zzhh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzgu {
    private static volatile boolean b;
    private static volatile zzgu d;
    private final Map<a, zzhh.zze<?, ?>> e;
    private static final Class<?> c = a();

    /* renamed from: a, reason: collision with root package name */
    static final zzgu f4177a = new zzgu(true);

    private static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4178a;
        private final int b;

        a(Object obj, int i) {
            this.f4178a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f4178a) * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4178a == aVar.f4178a && this.b == aVar.b;
        }
    }

    public static zzgu zzgf() {
        zzgu zzguVar = d;
        if (zzguVar == null) {
            synchronized (zzgu.class) {
                zzguVar = d;
                if (zzguVar == null) {
                    zzguVar = bx.a();
                    d = zzguVar;
                }
            }
        }
        return zzguVar;
    }

    public final <ContainingType extends zzim> zzhh.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzhh.zze) this.e.get(new a(containingtype, i));
    }

    zzgu() {
        this.e = new HashMap();
    }

    private zzgu(boolean z) {
        this.e = Collections.emptyMap();
    }
}
