package okhttp3.internal.http2;

import com.facebook.internal.security.CertificateUtil;
import okhttp3.s;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f7106a = ByteString.a(CertificateUtil.DELIMITER);
    public static final ByteString b = ByteString.a(":status");
    public static final ByteString c = ByteString.a(":method");
    public static final ByteString d = ByteString.a(":path");
    public static final ByteString e = ByteString.a(":scheme");
    public static final ByteString f = ByteString.a(":authority");
    public final ByteString g;
    public final ByteString h;
    final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0231a {
        void a(s sVar);
    }

    public a(String str, String str2) {
        this(ByteString.a(str), ByteString.a(str2));
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.a(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.g = byteString;
        this.h = byteString2;
        this.i = byteString.g() + 32 + byteString2.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.g.equals(aVar.g) && this.h.equals(aVar.h);
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return okhttp3.internal.c.a("%s: %s", this.g.a(), this.h.a());
    }
}
