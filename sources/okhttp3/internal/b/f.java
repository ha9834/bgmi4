package okhttp3.internal.b;

import com.tencent.imsdk.android.tools.net.volley.upload.HttpClientStack;

/* loaded from: classes3.dex */
public final class f {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean c(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return !str.equals("PROPFIND");
    }
}
