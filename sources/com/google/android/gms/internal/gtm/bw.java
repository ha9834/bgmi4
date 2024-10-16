package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzqp;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class bw<T extends zzqp> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f4324a = Logger.getLogger(zzqj.class.getName());
    private static String b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    bw() {
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends zzqp> T a(Class<T> cls) {
        String format;
        ClassLoader classLoader = bw.class.getClassLoader();
        if (cls.equals(zzqp.class)) {
            format = b;
        } else {
            if (!cls.getPackage().equals(bw.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            format = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((bw) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).a());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(bw.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((bw) it.next()).a()));
                } catch (ServiceConfigurationError e5) {
                    Logger logger = f4324a;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
