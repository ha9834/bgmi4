package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String javaName;

    TlsVersion(String str) {
        this.javaName = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TlsVersion a(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 79201641) {
            if (str.equals("SSLv3")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode != 79923350) {
            switch (hashCode) {
                case -503070503:
                    if (str.equals("TLSv1.1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -503070502:
                    if (str.equals("TLSv1.2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -503070501:
                    if (str.equals("TLSv1.3")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
        } else {
            if (str.equals("TLSv1")) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return TLS_1_3;
            case 1:
                return TLS_1_2;
            case 2:
                return TLS_1_1;
            case 3:
                return TLS_1_0;
            case 4:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<TlsVersion> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
