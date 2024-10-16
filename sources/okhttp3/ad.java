package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    final a f7051a;
    final Proxy b;
    final InetSocketAddress c;

    public ad(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f7051a = aVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public a a() {
        return this.f7051a;
    }

    public Proxy b() {
        return this.b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        return this.f7051a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ad) {
            ad adVar = (ad) obj;
            if (adVar.f7051a.equals(this.f7051a) && adVar.b.equals(this.b) && adVar.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f7051a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}
