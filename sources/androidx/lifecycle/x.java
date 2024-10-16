package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, v> f798a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, v vVar) {
        v put = this.f798a.put(str, vVar);
        if (put != null) {
            put.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v a(String str) {
        return this.f798a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> a() {
        return new HashSet(this.f798a.keySet());
    }

    public final void b() {
        Iterator<v> it = this.f798a.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.f798a.clear();
    }
}
