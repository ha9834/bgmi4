package okhttp3;

import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f7155a;

    s(a aVar) {
        this.f7155a = (String[]) aVar.f7156a.toArray(new String[aVar.f7156a.size()]);
    }

    private s(String[] strArr) {
        this.f7155a = strArr;
    }

    @Nullable
    public String a(String str) {
        return a(this.f7155a, str);
    }

    public int a() {
        return this.f7155a.length / 2;
    }

    public String a(int i) {
        return this.f7155a[i * 2];
    }

    public String b(int i) {
        return this.f7155a[(i * 2) + 1];
    }

    public List<String> b(String str) {
        int a2 = a();
        ArrayList arrayList = null;
        for (int i = 0; i < a2; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.f7156a, this.f7155a);
        return aVar;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && Arrays.equals(((s) obj).f7155a, this.f7155a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f7155a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static s a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            c(str);
            a(str2, str);
        }
        return new s(strArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(okhttp3.internal.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(okhttp3.internal.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f7156a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            int indexOf = str.indexOf(CertificateUtil.DELIMITER, 1);
            if (indexOf != -1) {
                return c(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(CertificateUtil.DELIMITER)) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        public a a(String str, String str2) {
            s.c(str);
            s.a(str2, str);
            return c(str, str2);
        }

        public a b(String str, String str2) {
            s.c(str);
            return c(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f7156a.add(str);
            this.f7156a.add(str2.trim());
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f7156a.size()) {
                if (str.equalsIgnoreCase(this.f7156a.get(i))) {
                    this.f7156a.remove(i);
                    this.f7156a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a d(String str, String str2) {
            s.c(str);
            s.a(str2, str);
            b(str);
            c(str, str2);
            return this;
        }

        public s a() {
            return new s(this);
        }
    }
}
