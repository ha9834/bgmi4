package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f7008a = new e();

    private e() {
    }

    public final List<MainDispatcherFactory> a() {
        MainDispatcherFactory mainDispatcherFactory;
        MainDispatcherFactory mainDispatcherFactory2;
        if (!f.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
                mainDispatcherFactory2 = null;
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return a(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.j.b(ServiceLoader.load(cls, classLoader));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <S> List<S> a(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.h.a((Object) list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.j.a((Collection) arrayList, (Iterable) f7008a.a((URL) it.next()));
        }
        Set d = kotlin.collections.j.d((Iterable) arrayList);
        if (!(!d.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        Set set = d;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.j.a(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f7008a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
        }
        return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    private final List<String> a(URL url) {
        Throwable th;
        String url2 = url.toString();
        if (kotlin.text.l.a(url2, "jar", false, 2, (Object) null)) {
            String a2 = kotlin.text.l.a(kotlin.text.l.b(url2, "jar:file:", (String) null, 2, (Object) null), '!', (String) null, 2, (Object) null);
            String b = kotlin.text.l.b(url2, "!/", (String) null, 2, (Object) null);
            JarFile jarFile = new JarFile(a2, false);
            Throwable th2 = (Throwable) null;
            try {
                th = (Throwable) null;
                try {
                    List<String> a3 = f7008a.a(new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(b)), "UTF-8")));
                    jarFile.close();
                    return a3;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    if (th2 == null) {
                        throw th4;
                    }
                    kotlin.a.a(th2, th4);
                    throw th2;
                }
            }
        }
        th = (Throwable) null;
        try {
            return f7008a.a(new BufferedReader(new InputStreamReader(url.openStream())));
        } finally {
        }
    }

    private final List<String> a(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String a2 = kotlin.text.l.a(readLine, "#", (String) null, 2, (Object) null);
                if (a2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = kotlin.text.l.b((CharSequence) a2).toString();
                String str = obj;
                int i = 0;
                while (true) {
                    if (i >= str.length()) {
                        z = true;
                        break;
                    }
                    char charAt = str.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
                if (str.length() > 0) {
                    linkedHashSet.add(obj);
                }
            } else {
                return kotlin.collections.j.b((Iterable) linkedHashSet);
            }
        }
    }
}
