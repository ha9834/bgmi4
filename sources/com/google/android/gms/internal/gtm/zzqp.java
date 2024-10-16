package com.google.android.gms.internal.gtm;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.internal.gtm.zzrc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzqp {
    private static volatile boolean b;
    private static volatile zzqp d;
    private final Map<a, zzrc.zzd<?, ?>> e;
    private static final Class<?> c = b();

    /* renamed from: a, reason: collision with root package name */
    static final zzqp f4435a = new zzqp(true);

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
        private final Object f4436a;
        private final int b;

        a(Object obj, int i) {
            this.f4436a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f4436a) * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4436a == aVar.f4436a && this.b == aVar.b;
        }
    }

    public static zzqp zzoq() {
        return bo.a();
    }

    public static zzqp zzor() {
        zzqp zzqpVar = d;
        if (zzqpVar == null) {
            synchronized (zzqp.class) {
                zzqpVar = d;
                if (zzqpVar == null) {
                    zzqpVar = bo.b();
                    d = zzqpVar;
                }
            }
        }
        return zzqpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqp a() {
        return bw.a(zzqp.class);
    }

    public final <ContainingType extends zzsk> zzrc.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzrc.zzd) this.e.get(new a(containingtype, i));
    }

    zzqp() {
        this.e = new HashMap();
    }

    private zzqp(boolean z) {
        this.e = Collections.emptyMap();
    }
}
