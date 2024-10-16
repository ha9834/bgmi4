package com.adjust.sdk;

import android.net.Uri;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AdjustLinkResolution {
    private static volatile ExecutorService executor = null;
    private static final String[] expectedUrlHostSuffixArray = {"adjust.com", "adj.st", "go.link"};
    private static final int maxRecursions = 10;

    /* loaded from: classes.dex */
    public interface AdjustLinkResolutionCallback {
        void resolvedLinkCallback(Uri uri);
    }

    private AdjustLinkResolution() {
    }

    public static void resolveLink(String str, String[] strArr, final AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        final URL url;
        if (adjustLinkResolutionCallback == null) {
            return;
        }
        if (str == null) {
            adjustLinkResolutionCallback.resolvedLinkCallback(null);
            return;
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null) {
            adjustLinkResolutionCallback.resolvedLinkCallback(null);
            return;
        }
        if (!urlMatchesSuffix(url.getHost(), strArr)) {
            adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url));
            return;
        }
        if (executor == null) {
            synchronized (expectedUrlHostSuffixArray) {
                if (executor == null) {
                    executor = Executors.newSingleThreadExecutor();
                }
            }
        }
        executor.execute(new Runnable() { // from class: com.adjust.sdk.AdjustLinkResolution.1
            @Override // java.lang.Runnable
            public void run() {
                AdjustLinkResolution.requestAndResolve(url, 0, adjustLinkResolutionCallback);
            }
        });
    }

    private static void resolveLink(URL url, URL url2, int i, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        if (url == null) {
            adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url2));
            return;
        }
        if (isTerminalUrl(url.getHost())) {
            adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url));
        } else if (i > 10) {
            adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url));
        } else {
            requestAndResolve(url, i, adjustLinkResolutionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        resolveLink(r0, r4, r5 + 1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r1 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void requestAndResolve(java.net.URL r4, int r5, com.adjust.sdk.AdjustLinkResolution.AdjustLinkResolutionCallback r6) {
        /*
            java.net.URL r4 = convertToHttps(r4)
            r0 = 0
            java.net.URLConnection r1 = r4.openConnection()     // Catch: java.lang.Throwable -> L27 java.lang.Throwable -> L34
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L27 java.lang.Throwable -> L34
            r2 = 0
            r1.setInstanceFollowRedirects(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L25
            r1.connect()     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L25
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L25
            if (r2 == 0) goto L20
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L25
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L25
            r0 = r3
        L20:
            if (r1 == 0) goto L3a
            goto L37
        L23:
            r2 = move-exception
            goto L29
        L25:
            goto L35
        L27:
            r2 = move-exception
            r1 = r0
        L29:
            if (r1 == 0) goto L2e
            r1.disconnect()
        L2e:
            int r5 = r5 + 1
            resolveLink(r0, r4, r5, r6)
            throw r2
        L34:
            r1 = r0
        L35:
            if (r1 == 0) goto L3a
        L37:
            r1.disconnect()
        L3a:
            int r5 = r5 + 1
            resolveLink(r0, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.AdjustLinkResolution.requestAndResolve(java.net.URL, int, com.adjust.sdk.AdjustLinkResolution$AdjustLinkResolutionCallback):void");
    }

    private static boolean isTerminalUrl(String str) {
        return urlMatchesSuffix(str, expectedUrlHostSuffixArray);
    }

    private static boolean urlMatchesSuffix(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static URL convertToHttps(URL url) {
        String externalForm;
        if (url == null || (externalForm = url.toExternalForm()) == null || !externalForm.startsWith("http:")) {
            return url;
        }
        try {
            return new URL("https:" + externalForm.substring(5));
        } catch (MalformedURLException unused) {
            return url;
        }
    }

    private static Uri convertToUri(URL url) {
        if (url == null) {
            return null;
        }
        return Uri.parse(url.toString());
    }
}
