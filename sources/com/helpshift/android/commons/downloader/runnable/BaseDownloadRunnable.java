package com.helpshift.android.commons.downloader.runnable;

import android.os.Build;
import android.os.Process;
import com.amazonaws.services.s3.Headers;
import com.facebook.share.internal.ShareConstants;
import com.helpshift.android.commons.downloader.HelpshiftSSLSocketFactory;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.util.HSLogger;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public abstract class BaseDownloadRunnable implements Runnable {
    protected static final String DOWNLOAD_MANAGER_DB_KEY = "kDownloadManagerCachedFiles";
    private static final String TAG = "Helpshift_DownloadRun";
    private NetworkAuthDataFetcher networkAuthDataFetcher;
    private OnDownloadFinishListener onDownloadFinishListener;
    private OnProgressChangedListener onProgressChangedListener;
    protected DownloadRequestedFileInfo requestInfo;

    protected abstract void clearCache();

    protected abstract long getAlreadyDownloadedBytes() throws FileNotFoundException;

    protected abstract boolean isGzipSupported();

    protected abstract void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        this.requestInfo = downloadRequestedFileInfo;
        this.networkAuthDataFetcher = networkAuthDataFetcher;
        this.onProgressChangedListener = onProgressChangedListener;
        this.onDownloadFinishListener = onDownloadFinishListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v31, types: [java.lang.String] */
    @Override // java.lang.Runnable
    public void run() {
        int i;
        ?? r3;
        int i2;
        List<String> list;
        HSLogger.d(TAG, "Starting download : " + this.requestInfo.url);
        Process.setThreadPriority(10);
        try {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            URL buildUrl = buildUrl();
            ?? protocol = buildUrl.getProtocol();
            if ("https".equals(protocol)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) buildUrl.openConnection();
                fixSSLSocketProtocols(httpsURLConnection);
                r3 = httpsURLConnection;
            } else {
                r3 = (HttpURLConnection) buildUrl.openConnection();
            }
            i = protocol;
            if (this.requestInfo.etag != null) {
                i = protocol;
                if (!this.requestInfo.etag.isEmpty()) {
                    ?? r5 = this.requestInfo.etag;
                    r3.setRequestProperty(Headers.GET_OBJECT_IF_NONE_MATCH, r5);
                    i = r5;
                }
            }
            r3.setInstanceFollowRedirects(true);
            InputStream inputStream = null;
            try {
                try {
                    try {
                        try {
                            r3.setRequestProperty(Headers.RANGE, "bytes=" + getAlreadyDownloadedBytes() + "-");
                            i2 = r3.getResponseCode();
                            try {
                            } catch (IOException e) {
                                e = e;
                                notifyDownloadFinish(false, e, i2, "");
                                HSLogger.e(TAG, "Exception in download", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        notifyDownloadFinish(false, e2, i2, "");
                                        HSLogger.e(TAG, "Exception in closing download response", e2, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                                    }
                                }
                                r3.disconnect();
                            }
                        } catch (IOException e3) {
                            e = e3;
                            notifyDownloadFinish(false, e, i, "");
                            HSLogger.e(TAG, "Exception IO", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                            return;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        i2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        i = 0;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                notifyDownloadFinish(false, e5, i, "");
                                HSLogger.e(TAG, "Exception in closing download response", e5, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                            }
                        }
                        r3.disconnect();
                        throw th;
                    }
                    if (i2 == 416) {
                        clearCache();
                        throw new IOException("Requested Range Not Satisfiable, failed with 416 status");
                    }
                    if (i2 == 304) {
                        notifyDownloadFinish(false, null, i2, "");
                        r3.disconnect();
                        return;
                    }
                    InputStream inputStream2 = r3.getInputStream();
                    if (isGzipSupported() && (list = r3.getHeaderFields().get(Headers.CONTENT_ENCODING)) != null && list.size() > 0 && list.get(0).equalsIgnoreCase(HttpStack.ENCODING_GZIP)) {
                        inputStream2 = new GZIPInputStream(inputStream2);
                    }
                    int contentLength = r3.getContentLength();
                    String headerField = r3.getHeaderField("Etag");
                    processHttpResponse(inputStream2, contentLength, i2, headerField);
                    Thread.interrupted();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            notifyDownloadFinish(false, e6, i2, headerField);
                            HSLogger.e(TAG, "Exception in closing download response", e6, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                        }
                    }
                    r3.disconnect();
                } catch (InterruptedException e7) {
                    e = e7;
                    notifyDownloadFinish(false, e, i, "");
                    HSLogger.e(TAG, "Exception Interrupted", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                    Thread.currentThread().interrupt();
                } catch (MalformedURLException e8) {
                    e = e8;
                    notifyDownloadFinish(false, e, i, "");
                    HSLogger.e(TAG, "MalformedURLException", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                } catch (GeneralSecurityException e9) {
                    e = e9;
                    notifyDownloadFinish(false, e, i, "");
                    HSLogger.e(TAG, "GeneralSecurityException", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                } catch (Exception e10) {
                    e = e10;
                    notifyDownloadFinish(false, e, i, "");
                    HSLogger.e(TAG, "Unknown Exception", e, LogExtrasModelProvider.fromString("route", this.requestInfo.url));
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MalformedURLException e11) {
            e = e11;
            i = 0;
        } catch (IOException e12) {
            e = e12;
            i = 0;
        } catch (InterruptedException e13) {
            e = e13;
            i = 0;
        } catch (GeneralSecurityException e14) {
            e = e14;
            i = 0;
        } catch (Exception e15) {
            e = e15;
            i = 0;
        }
    }

    private URL buildUrl() throws MalformedURLException, URISyntaxException, GeneralSecurityException {
        URI uri;
        if (this.requestInfo.isSecured) {
            URI uri2 = new URI(this.requestInfo.url);
            String path = uri2.getPath();
            Map<String, String> queryMap = getQueryMap(uri2.getQuery());
            queryMap.put("v", "1");
            queryMap.put(ShareConstants.MEDIA_URI, path);
            Map<String, String> authData = this.networkAuthDataFetcher.getAuthData(queryMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : authData.entrySet()) {
                arrayList.add(entry.getKey() + "=" + entry.getValue());
            }
            uri = new URI(uri2.getScheme(), uri2.getAuthority(), uri2.getPath(), join("&", arrayList), null);
        } else {
            uri = new URI(this.requestInfo.url);
        }
        return new URL(uri.toASCIIString());
    }

    private void fixSSLSocketProtocols(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT > 19) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("TLSv1.2");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("SSLv3");
        httpsURLConnection.setSSLSocketFactory(new HelpshiftSSLSocketFactory(httpsURLConnection.getSSLSocketFactory(), arrayList, arrayList2));
    }

    private Map<String, String> getQueryMap(String str) {
        String[] split = str.split("&");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    private String join(CharSequence charSequence, Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : iterable) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeFileStream(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyProgressChange(int i) {
        OnProgressChangedListener onProgressChangedListener = this.onProgressChangedListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this.requestInfo.url, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyDownloadFinish(boolean z, Object obj, int i, String str) {
        OnDownloadFinishListener onDownloadFinishListener = this.onDownloadFinishListener;
        if (onDownloadFinishListener != null) {
            onDownloadFinishListener.onDownloadFinish(z, this.requestInfo.url, obj, i, str);
        }
    }
}
