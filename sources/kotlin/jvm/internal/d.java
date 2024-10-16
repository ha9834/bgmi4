package kotlin.jvm.internal;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.a.m;
import kotlin.jvm.a.n;
import kotlin.jvm.a.o;
import kotlin.jvm.a.p;
import kotlin.jvm.a.q;
import kotlin.jvm.a.r;
import kotlin.jvm.a.s;
import kotlin.jvm.a.t;
import kotlin.jvm.a.u;
import kotlin.jvm.a.v;
import kotlin.jvm.a.w;

/* loaded from: classes3.dex */
public final class d implements kotlin.e.b<Object>, c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6969a = new a(null);
    private static final Map<Class<? extends Object<?>>, Integer> c;
    private static final HashMap<String, String> d;
    private static final HashMap<String, String> e;
    private static final HashMap<String, String> f;
    private static final Map<String, String> g;
    private final Class<?> b;

    public d(Class<?> cls) {
        h.b(cls, "jClass");
        this.b = cls;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.b;
    }

    @Override // kotlin.e.b
    public String b() {
        return f6969a.a(a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && h.a(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.e.b) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.Class<?> r6) {
            /*
                r5 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.h.b(r6, r0)
                boolean r0 = r6.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lca
            Le:
                boolean r0 = r6.isLocalClass()
                if (r0 == 0) goto L77
                java.lang.String r0 = r6.getSimpleName()
                java.lang.reflect.Method r2 = r6.getEnclosingMethod()
                r3 = 2
                if (r2 == 0) goto L41
                java.lang.String r4 = "name"
                kotlin.jvm.internal.h.a(r0, r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r2 = r2.getName()
                r4.append(r2)
                java.lang.String r2 = "$"
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                java.lang.String r2 = kotlin.text.l.b(r0, r2, r1, r3, r1)
                if (r2 == 0) goto L41
                r6 = r2
                goto L67
            L41:
                java.lang.reflect.Constructor r6 = r6.getEnclosingConstructor()
                if (r6 == 0) goto L66
                java.lang.String r2 = "name"
                kotlin.jvm.internal.h.a(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = r6.getName()
                r2.append(r6)
                java.lang.String r6 = "$"
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                java.lang.String r6 = kotlin.text.l.b(r0, r6, r1, r3, r1)
                goto L67
            L66:
                r6 = r1
            L67:
                if (r6 == 0) goto L6b
                r1 = r6
                goto Lca
            L6b:
                java.lang.String r6 = "name"
                kotlin.jvm.internal.h.a(r0, r6)
                r6 = 36
                java.lang.String r1 = kotlin.text.l.b(r0, r6, r1, r3, r1)
                goto Lca
            L77:
                boolean r0 = r6.isArray()
                if (r0 == 0) goto Lb4
                java.lang.Class r6 = r6.getComponentType()
                java.lang.String r0 = "componentType"
                kotlin.jvm.internal.h.a(r6, r0)
                boolean r0 = r6.isPrimitive()
                if (r0 == 0) goto Lae
                java.util.Map r0 = kotlin.jvm.internal.d.c()
                java.lang.String r6 = r6.getName()
                java.lang.Object r6 = r0.get(r6)
                java.lang.String r6 = (java.lang.String) r6
                if (r6 == 0) goto Lae
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                java.lang.String r6 = "Array"
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                r1 = r6
            Lae:
                if (r1 == 0) goto Lb1
                goto Lca
            Lb1:
                java.lang.String r1 = "Array"
                goto Lca
            Lb4:
                java.util.Map r0 = kotlin.jvm.internal.d.c()
                java.lang.String r1 = r6.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lc6
                goto Lca
            Lc6:
                java.lang.String r1 = r6.getSimpleName()
            Lca:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.d.a.a(java.lang.Class):java.lang.String");
        }
    }

    static {
        int i = 0;
        List b = kotlin.collections.j.b(kotlin.jvm.a.a.class, kotlin.jvm.a.b.class, m.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.jvm.a.c.class, kotlin.jvm.a.d.class, kotlin.jvm.a.e.class, kotlin.jvm.a.f.class, kotlin.jvm.a.g.class, kotlin.jvm.a.h.class, kotlin.jvm.a.i.class, kotlin.jvm.a.j.class, kotlin.jvm.a.k.class, kotlin.jvm.a.l.class, n.class, o.class, p.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.j.a(b, 10));
        for (Object obj : b) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.j.b();
            }
            arrayList.add(kotlin.i.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        c = kotlin.collections.w.a(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put(Constants.LONG, "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(d);
        hashMap3.putAll(e);
        Collection<String> values = d.values();
        h.a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            h.a((Object) str, "kotlinName");
            sb.append(kotlin.text.l.c(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair a2 = kotlin.i.a(sb.toString(), str + ".Companion");
            hashMap3.put(a2.a(), a2.b());
        }
        for (Map.Entry<Class<? extends Object<?>>, Integer> entry : c.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f = hashMap3;
        HashMap<String, String> hashMap4 = f;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.w.a(hashMap4.size()));
        Iterator<T> it = hashMap4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), kotlin.text.l.c((String) entry2.getValue(), '.', null, 2, null));
        }
        g = linkedHashMap;
    }
}
