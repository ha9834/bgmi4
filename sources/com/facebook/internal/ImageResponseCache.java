package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class ImageResponseCache {
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();
    private static final String TAG;
    private static FileLruCache imageCache;

    static {
        String simpleName = ImageResponseCache.class.getSimpleName();
        h.a((Object) simpleName, "ImageResponseCache::class.java.simpleName");
        TAG = simpleName;
    }

    private ImageResponseCache() {
    }

    public final String getTAG() {
        return TAG;
    }

    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
            if (fileLruCache == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return fileLruCache;
    }

    public static final InputStream getCachedImageStream(Uri uri) {
        InputStream inputStream = (InputStream) null;
        if (uri == null || !INSTANCE.isCDNURL(uri)) {
            return inputStream;
        }
        try {
            FileLruCache cache = getCache();
            String uri2 = uri.toString();
            h.a((Object) uri2, "uri.toString()");
            return FileLruCache.get$default(cache, uri2, null, 2, null);
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            return inputStream;
        }
    }

    public static final InputStream interceptAndCacheImageStream(HttpURLConnection httpURLConnection) throws IOException {
        h.b(httpURLConnection, "connection");
        InputStream inputStream = (InputStream) null;
        if (httpURLConnection.getResponseCode() != 200) {
            return inputStream;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream2 = httpURLConnection.getInputStream();
        try {
            if (INSTANCE.isCDNURL(parse)) {
                FileLruCache cache = getCache();
                String uri = parse.toString();
                h.a((Object) uri, "uri.toString()");
                return cache.interceptAndPut(uri, new BufferedHttpInputStream(inputStream2, httpURLConnection));
            }
        } catch (IOException unused) {
        }
        return inputStream2;
    }

    private final boolean isCDNURL(Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host != null && l.b(host, "fbcdn.net", false, 2, (Object) null)) {
                return true;
            }
            if (host != null && l.a(host, "fbcdn", false, 2, (Object) null) && l.b(host, "akamaihd.net", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BufferedHttpInputStream extends BufferedInputStream {
        private HttpURLConnection connection;

        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(HttpURLConnection httpURLConnection) {
            h.b(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            h.b(httpURLConnection, "connection");
            this.connection = httpURLConnection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }
}
