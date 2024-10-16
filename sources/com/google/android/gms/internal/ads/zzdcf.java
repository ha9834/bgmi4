package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzdcf {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3541a = Logger.getLogger(zzdcf.class.getName());
    private static final ConcurrentMap<String, zzdbs> b = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> c = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdbk> d = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdcc<?>> e = new ConcurrentHashMap();

    public static synchronized void zza(String str, zzdbk<?> zzdbkVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (d.containsKey(str.toLowerCase())) {
                if (!zzdbkVar.getClass().equals(d.get(str.toLowerCase()).getClass())) {
                    Logger logger = f3541a;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger.logp(level, "com.google.crypto.tink.Registry", "addCatalogue", valueOf.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(valueOf) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                    sb.append("catalogue for name ");
                    sb.append(str);
                    sb.append(" has been already registered");
                    throw new GeneralSecurityException(sb.toString());
                }
            }
            d.put(str.toLowerCase(), zzdbkVar);
        }
    }

    public static zzdbk<?> zzgi(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdbk<?> zzdbkVar = d.get(str.toLowerCase());
        if (zzdbkVar != null) {
            return zzdbkVar;
        }
        String format = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase().startsWith("tinkaead")) {
            format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            format = String.valueOf(format).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
            format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase().startsWith("tink")) {
            format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(format);
    }

    private static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static synchronized <P> void zza(zzdbs<P> zzdbsVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            zza((zzdbs) zzdbsVar, true);
        }
    }

    public static synchronized <P> void zza(zzdbs<P> zzdbsVar, boolean z) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdbsVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String keyType = zzdbsVar.getKeyType();
            if (b.containsKey(keyType)) {
                zzdbs a2 = a(keyType, null);
                boolean booleanValue = c.get(keyType).booleanValue();
                if (!zzdbsVar.getClass().equals(a2.getClass()) || (!booleanValue && z)) {
                    Logger logger = f3541a;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(keyType);
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", keyType, a2.getClass().getName(), zzdbsVar.getClass().getName()));
                }
            }
            b.put(keyType, zzdbsVar);
            c.put(keyType, Boolean.valueOf(z));
        }
    }

    public static synchronized <P> void zza(zzdcc<P> zzdccVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdccVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> zzanr = zzdccVar.zzanr();
            if (e.containsKey(zzanr)) {
                zzdcc<?> zzdccVar2 = e.get(zzanr);
                if (!zzdccVar.getClass().equals(zzdccVar2.getClass())) {
                    Logger logger = f3541a;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(zzanr.toString());
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzanr.getName(), zzdccVar2.getClass().getName(), zzdccVar.getClass().getName()));
                }
            }
            e.put(zzanr, zzdccVar);
        }
    }

    private static <P> zzdbs<P> a(String str, Class<P> cls) throws GeneralSecurityException {
        zzdbs<P> zzdbsVar = b.get(str);
        if (zzdbsVar == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("No key manager found for key type: ");
            sb.append(str);
            sb.append(".  Check the configuration of the registry.");
            throw new GeneralSecurityException(sb.toString());
        }
        if (cls == null || zzdbsVar.zzanr().equals(cls)) {
            return zzdbsVar;
        }
        String name = zzdbsVar.zzanr().getName();
        String name2 = cls.getName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 80 + String.valueOf(str).length() + String.valueOf(name2).length());
        sb2.append("Primitive type ");
        sb2.append(name);
        sb2.append(" of keymanager for type ");
        sb2.append(str);
        sb2.append(" does not match requested primitive type ");
        sb2.append(name2);
        throw new GeneralSecurityException(sb2.toString());
    }

    public static synchronized zzdgr zza(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdgr zzr;
        synchronized (zzdcf.class) {
            zzdbs a2 = a(zzdgwVar.zzart(), null);
            if (c.get(zzdgwVar.zzart()).booleanValue()) {
                zzr = a2.zzr(zzdgwVar.zzaru());
            } else {
                String valueOf = String.valueOf(zzdgwVar.zzart());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzr;
    }

    public static synchronized zzdpk zzb(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdpk zzq;
        synchronized (zzdcf.class) {
            zzdbs a2 = a(zzdgwVar.zzart(), null);
            if (c.get(zzdgwVar.zzart()).booleanValue()) {
                zzq = a2.zzq(zzdgwVar.zzaru());
            } else {
                String valueOf = String.valueOf(zzdgwVar.zzart());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzq;
    }

    public static synchronized zzdpk zza(String str, zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdpk zzb;
        synchronized (zzdcf.class) {
            zzdbs a2 = a(str, null);
            if (c.get(str).booleanValue()) {
                zzb = a2.zzb(zzdpkVar);
            } else {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzb;
    }

    public static <P> P zza(String str, zzdpk zzdpkVar, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, (Class) a(cls)).zza(zzdpkVar);
    }

    private static <P> P a(String str, zzdmr zzdmrVar, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, cls).zzp(zzdmrVar);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, zzdmr.zzz(bArr), (Class) a(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdca<P> zza(zzdbu zzdbuVar, zzdbs<P> zzdbsVar, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) a(cls);
        abl.b(zzdbuVar.a());
        zzdca<P> zzdcaVar = (zzdca<P>) zzdca.zza(cls2);
        for (zzdha.zzb zzbVar : zzdbuVar.a().zzasi()) {
            if (zzbVar.zzaso() == zzdgu.ENABLED) {
                zzdcb zza = zzdcaVar.zza(a(zzbVar.zzasn().zzart(), zzbVar.zzasn().zzaru(), cls2), zzbVar);
                if (zzbVar.zzasp() == zzdbuVar.a().zzash()) {
                    zzdcaVar.zza(zza);
                }
            }
        }
        return zzdcaVar;
    }

    public static <P> P zza(zzdca<P> zzdcaVar) throws GeneralSecurityException {
        zzdcc<?> zzdccVar = e.get(zzdcaVar.zzanr());
        if (zzdccVar == null) {
            String valueOf = String.valueOf(zzdcaVar.zzanr().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        return (P) zzdccVar.zza(zzdcaVar);
    }
}
