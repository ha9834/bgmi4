package com.tencent.smtt.sdk;

/* loaded from: classes2.dex */
public class MimeTypeMap {

    /* renamed from: a, reason: collision with root package name */
    private static MimeTypeMap f6431a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().h(str);
        }
        return android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
    }

    public boolean hasMimeType(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().i(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
    }

    public String getMimeTypeFromExtension(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().j(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().k(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
    }

    public String getExtensionFromMimeType(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            return a2.c().l(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (f6431a == null) {
                f6431a = new MimeTypeMap();
            }
            mimeTypeMap = f6431a;
        }
        return mimeTypeMap;
    }
}
