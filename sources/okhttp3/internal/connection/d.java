package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ad;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<ad> f7087a = new LinkedHashSet();

    public synchronized void a(ad adVar) {
        this.f7087a.add(adVar);
    }

    public synchronized void b(ad adVar) {
        this.f7087a.remove(adVar);
    }

    public synchronized boolean c(ad adVar) {
        return this.f7087a.contains(adVar);
    }
}
