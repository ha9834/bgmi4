package okio;

import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f7170a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    transient int c;
    transient String d;
    final byte[] data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    public static ByteString a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        s.a(bArr.length, i, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    public static ByteString a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(s.f7193a));
        byteString.d = str;
        return byteString;
    }

    public String a() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, s.f7193a);
        this.d = str2;
        return str2;
    }

    public String b() {
        return b.a(this.data);
    }

    public ByteString c() {
        return d(Constants.SHA1);
    }

    public ByteString d() {
        return d(Constants.SHA256);
    }

    private ByteString d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @Nullable
    public static ByteString b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = b.a(str);
        if (a2 != null) {
            return new ByteString(a2);
        }
        return null;
    }

    public String e() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f7170a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteString c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteString a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
        return new ByteString(bArr);
    }

    public ByteString f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    public ByteString a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.data;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(this.data, i, bArr2, 0, i3);
        return new ByteString(bArr2);
    }

    public byte a(int i) {
        return this.data[i];
    }

    public int g() {
        return this.data.length;
    }

    public byte[] h() {
        return (byte[]) this.data.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        byte[] bArr = this.data;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, ByteString byteString, int i2, int i3) {
        return byteString.a(i2, this.data, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.data;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && s.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(ByteString byteString) {
        return a(0, byteString, 0, byteString.g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int g = byteString.g();
            byte[] bArr = this.data;
            if (g == bArr.length && byteString.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.c = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(ByteString byteString) {
        int g = g();
        int g2 = byteString.g();
        int min = Math.min(g, g2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int a3 = byteString.a(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (g == g2) {
            return 0;
        }
        return g < g2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + e() + "]";
            }
            return "[size=" + this.data.length + " hex=" + a(0, 64).e() + "…]";
        }
        String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            return "[size=" + this.data.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
