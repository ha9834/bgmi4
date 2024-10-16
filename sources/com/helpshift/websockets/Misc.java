package com.helpshift.websockets;

import com.google.android.gms.nearby.messages.BleSignal;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class Misc {
    private static final SecureRandom sRandom = new SecureRandom();

    private Misc() {
    }

    public static byte[] getBytesUTF8(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String toStringUTF8(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return toStringUTF8(bArr, 0, bArr.length);
    }

    public static String toStringUTF8(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        } catch (IndexOutOfBoundsException unused2) {
            return null;
        }
    }

    public static byte[] nextBytes(byte[] bArr) {
        sRandom.nextBytes(bArr);
        return bArr;
    }

    public static byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }

    public static String toOpcodeName(int i) {
        switch (i) {
            case 0:
                return "CONTINUATION";
            case 1:
                return "TEXT";
            case 2:
                return "BINARY";
            default:
                switch (i) {
                    case 8:
                        return "CLOSE";
                    case 9:
                        return "PING";
                    case 10:
                        return "PONG";
                    default:
                        return (1 > i || i > 7) ? (8 > i || i > 15) ? String.format("0x%X", Integer.valueOf(i)) : String.format("CONTROL(0x%X)", Integer.valueOf(i)) : String.format("DATA(0x%X)", Integer.valueOf(i));
                }
        }
    }

    public static String readLine(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                if (read == 10) {
                    break;
                }
                if (read != 13) {
                    byteArrayOutputStream.write(read);
                } else {
                    int read2 = inputStream.read();
                    if (read2 == -1) {
                        byteArrayOutputStream.write(read);
                        break;
                    }
                    if (read2 == 10) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                    byteArrayOutputStream.write(read2);
                }
            } else if (byteArrayOutputStream.size() == 0) {
                return null;
            }
        }
        return byteArrayOutputStream.toString(str);
    }

    public static int min(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int max(int[] iArr) {
        int i = BleSignal.UNKNOWN_TX_POWER;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i < iArr[i2]) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static String join(Collection<?> collection, String str) {
        StringBuilder sb = new StringBuilder();
        join(sb, collection, str);
        return sb.toString();
    }

    private static void join(StringBuilder sb, Collection<?> collection, String str) {
        boolean z = true;
        for (Object obj : collection) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(obj.toString());
        }
    }

    public static String extractHost(URI uri) {
        String host = uri.getHost();
        if (host != null) {
            return host;
        }
        String extractHostFromAuthorityPart = extractHostFromAuthorityPart(uri.getRawAuthority());
        return extractHostFromAuthorityPart != null ? extractHostFromAuthorityPart : extractHostFromEntireUri(uri.toString());
    }

    static String extractHostFromAuthorityPart(String str) {
        Matcher matcher;
        if (str == null || (matcher = Pattern.compile("^(.*@)?([^:]+)(:\\d+)?$").matcher(str)) == null || !matcher.matches()) {
            return null;
        }
        return matcher.group(2);
    }

    static String extractHostFromEntireUri(String str) {
        Matcher matcher;
        if (str == null || (matcher = Pattern.compile("^\\w+://([^@/]*@)?([^:/]+)(:\\d+)?(/.*)?$").matcher(str)) == null || !matcher.matches()) {
            return null;
        }
        return matcher.group(2);
    }
}
