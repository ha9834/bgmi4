package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f7149a = new o() { // from class: okhttp3.o.1
        @Override // okhttp3.o
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    List<InetAddress> a(String str) throws UnknownHostException;
}
