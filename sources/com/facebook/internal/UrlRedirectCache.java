package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.text.d;

/* loaded from: classes.dex */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String b = j.b(UrlRedirectCache.class).b();
        if (b == null) {
            b = "UrlRedirectCache";
        }
        tag = b;
        redirectContentTag = tag + "_Redirect";
    }

    private UrlRedirectCache() {
    }

    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (kotlin.jvm.internal.h.a((java.lang.Object) r4, (java.lang.Object) r10) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        com.facebook.internal.Logger.Companion.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri getRedirectedUri(android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }

    public static final void cacheUriRedirect(Uri uri, Uri uri2) {
        String uri3;
        Charset charset;
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStream = (OutputStream) null;
        try {
            try {
                FileLruCache cache = getCache();
                String uri4 = uri.toString();
                h.a((Object) uri4, "fromUri.toString()");
                outputStream = cache.openPutStream(uri4, redirectContentTag);
                uri3 = uri2.toString();
                h.a((Object) uri3, "toUri.toString()");
                charset = d.f6980a;
            } catch (IOException e) {
                Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
            }
            if (uri3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = uri3.getBytes(charset);
            h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        } finally {
            Utility.closeQuietly(outputStream);
        }
    }

    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, tag, "clearCache failed " + e.getMessage());
        }
    }
}
