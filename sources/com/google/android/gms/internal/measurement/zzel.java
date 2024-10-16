package com.google.android.gms.internal.measurement;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.internal.measurement.zzey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzel {
    private static volatile boolean b;
    private static volatile zzel d;
    private static volatile zzel e;
    private final Map<a, zzey.zze<?, ?>> f;
    private static final Class<?> c = b();

    /* renamed from: a, reason: collision with root package name */
    static final zzel f4555a = new zzel(true);

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
        private final Object f4556a;
        private final int b;

        a(Object obj, int i) {
            this.f4556a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f4556a) * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4556a == aVar.f4556a && this.b == aVar.b;
        }
    }

    public static zzel zztp() {
        zzel zzelVar = d;
        if (zzelVar == null) {
            synchronized (zzel.class) {
                zzelVar = d;
                if (zzelVar == null) {
                    zzelVar = by.a();
                    d = zzelVar;
                }
            }
        }
        return zzelVar;
    }

    public static zzel zztq() {
        zzel zzelVar = e;
        if (zzelVar == null) {
            synchronized (zzel.class) {
                zzelVar = e;
                if (zzelVar == null) {
                    zzelVar = by.b();
                    e = zzelVar;
                }
            }
        }
        return zzelVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzel a() {
        return ch.a(zzel.class);
    }

    public final <ContainingType extends zzgi> zzey.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzey.zze) this.f.get(new a(containingtype, i));
    }

    zzel() {
        this.f = new HashMap();
    }

    private zzel(boolean z) {
        this.f = Collections.emptyMap();
    }
}
