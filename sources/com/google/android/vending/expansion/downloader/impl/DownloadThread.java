package com.google.android.vending.expansion.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DownloadThread {

    /* renamed from: a, reason: collision with root package name */
    private Context f5368a;
    private com.google.android.vending.expansion.downloader.impl.a b;
    private DownloaderService c;
    private final c d;
    private final com.google.android.vending.expansion.downloader.impl.b e;
    private String f;

    /* loaded from: classes2.dex */
    private class RetryDownload extends Throwable {
        private static final long serialVersionUID = 6196036036517540229L;
        final /* synthetic */ DownloadThread this$0;
    }

    public DownloadThread(com.google.android.vending.expansion.downloader.impl.a aVar, DownloaderService downloaderService, com.google.android.vending.expansion.downloader.impl.b bVar) {
        this.f5368a = downloaderService;
        this.b = aVar;
        this.c = downloaderService;
        this.e = bVar;
        this.d = c.a(downloaderService);
        this.f = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + "/" + Build.ID + ")" + downloaderService.getPackageName();
    }

    private String b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f5370a;
        public FileOutputStream b;
        public int e;
        public String g;
        public boolean c = false;
        public int d = 0;
        public boolean f = false;

        public b(com.google.android.vending.expansion.downloader.impl.a aVar, DownloaderService downloaderService) {
            this.e = 0;
            this.e = aVar.l;
            this.g = aVar.f5375a;
            this.f5370a = downloaderService.a(aVar.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f5369a;
        public int b;
        public String c;
        public boolean d;
        public String e;
        public String f;
        public String g;
        public int h;
        public long i;

        private a() {
            this.f5369a = 0;
            this.b = 0;
            this.d = false;
            this.h = 0;
            this.i = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class StopRequest extends Throwable {
        private static final long serialVersionUID = 6338592678988347973L;
        public int mFinalStatus;

        public StopRequest(int i, String str) {
            super(str);
            this.mFinalStatus = i;
        }

        public StopRequest(int i, String str, Throwable th) {
            super(str, th);
            this.mFinalStatus = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a() {
        Process.setThreadPriority(10);
        b bVar = new b(this.b, this.c);
        PowerManager.WakeLock wakeLock = null;
        try {
            try {
                PowerManager.WakeLock newWakeLock = ((PowerManager) this.f5368a.getSystemService("power")).newWakeLock(1, "LVLDL");
                newWakeLock.acquire();
                boolean z = false;
                while (!z) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bVar.g).openConnection();
                    httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, b());
                    try {
                        a(bVar, httpURLConnection);
                        httpURLConnection.disconnect();
                        z = true;
                    } catch (RetryDownload unused) {
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
                b(bVar);
                if (newWakeLock != null) {
                    newWakeLock.release();
                }
                a(bVar, 200);
                a(200, bVar.c, bVar.d, bVar.e, bVar.f, bVar.f5370a);
            } catch (Throwable th2) {
                if (0 != 0) {
                    wakeLock.release();
                }
                a(bVar, 491);
                a(491, bVar.c, bVar.d, bVar.e, bVar.f, bVar.f5370a);
                throw th2;
            }
        } catch (StopRequest e) {
            Log.w("LVLDL", "Aborting request for download " + this.b.c + ": " + e.getMessage());
            e.printStackTrace();
            int i = e.mFinalStatus;
            if (0 != 0) {
                wakeLock.release();
            }
            a(bVar, i);
            a(i, bVar.c, bVar.d, bVar.e, bVar.f, bVar.f5370a);
        } catch (Throwable th3) {
            Log.w("LVLDL", "Exception for " + this.b.c + ": " + th3);
            if (0 != 0) {
                wakeLock.release();
            }
            a(bVar, 491);
            a(491, bVar.c, bVar.d, bVar.e, bVar.f, bVar.f5370a);
        }
    }

    private void a(b bVar, HttpURLConnection httpURLConnection) throws StopRequest, RetryDownload {
        a aVar = new a();
        e(bVar);
        d(bVar, aVar);
        a(aVar, httpURLConnection);
        a(bVar);
        this.e.a(3);
        a(bVar, aVar, httpURLConnection, d(bVar, httpURLConnection));
        a(bVar, aVar, httpURLConnection);
        InputStream b2 = b(bVar, httpURLConnection);
        this.e.a(4);
        a(bVar, aVar, new byte[4096], b2);
    }

    private void a(b bVar) throws StopRequest {
        switch (this.c.a(this.d)) {
            case 1:
                return;
            case 2:
                throw new StopRequest(195, "waiting for network to return");
            case 3:
                throw new StopRequest(197, "waiting for wifi");
            case 4:
            default:
                return;
            case 5:
                throw new StopRequest(195, "roaming is not allowed");
            case 6:
                throw new StopRequest(196, "waiting for wifi or for download over cellular to be authorized");
        }
    }

    private void a(b bVar, a aVar, byte[] bArr, InputStream inputStream) throws StopRequest {
        while (true) {
            int b2 = b(bVar, aVar, bArr, inputStream);
            if (b2 == -1) {
                b(bVar, aVar);
                return;
            }
            bVar.f = true;
            a(bVar, bArr, b2);
            aVar.f5369a += b2;
            aVar.b += b2;
            a(bVar, aVar);
            e(bVar);
        }
    }

    private void b(b bVar) throws StopRequest {
        c(bVar);
        String str = bVar.f5370a;
        String a2 = com.google.android.vending.expansion.downloader.d.a(this.c, this.b.c);
        if (bVar.f5370a.equals(a2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(a2);
        if (this.b.e != -1 && this.b.f == this.b.e) {
            if (!file.renameTo(file2)) {
                throw new StopRequest(492, "unable to finalize destination file");
            }
            return;
        }
        throw new StopRequest(487, "file delivered with incorrect size. probably due to network not browser configured");
    }

    private void a(b bVar, int i) {
        d(bVar);
        if (bVar.f5370a == null || !DownloaderService.b(i)) {
            return;
        }
        new File(bVar.f5370a).delete();
        bVar.f5370a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0049 -> B:9:0x00c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x003f -> B:9:0x00c5). Please report as a decompilation issue!!! */
    private void c(b bVar) {
        FileOutputStream fileOutputStream;
        ?? r0 = 0;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        FileOutputStream fileOutputStream4 = null;
        FileOutputStream fileOutputStream5 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(bVar.f5370a, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (SyncFailedException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            } catch (RuntimeException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            Log.w("LVLDL", "IOException while closing synced file: ", e5);
            r0 = "LVLDL";
        } catch (RuntimeException e6) {
            Log.w("LVLDL", "exception while closing file: ", e6);
            r0 = "LVLDL";
        }
        try {
            FileDescriptor fd = fileOutputStream.getFD();
            fd.sync();
            fileOutputStream.close();
            r0 = fd;
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream2 = fileOutputStream;
            Log.w("LVLDL", "file " + bVar.f5370a + " not found: " + e);
            r0 = fileOutputStream2;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
                r0 = fileOutputStream2;
            }
        } catch (SyncFailedException e8) {
            e = e8;
            fileOutputStream3 = fileOutputStream;
            Log.w("LVLDL", "file " + bVar.f5370a + " sync failed: " + e);
            r0 = fileOutputStream3;
            if (fileOutputStream3 != null) {
                fileOutputStream3.close();
                r0 = fileOutputStream3;
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream4 = fileOutputStream;
            Log.w("LVLDL", "IOException trying to sync " + bVar.f5370a + ": " + e);
            r0 = fileOutputStream4;
            if (fileOutputStream4 != null) {
                fileOutputStream4.close();
                r0 = fileOutputStream4;
            }
        } catch (RuntimeException e10) {
            e = e10;
            fileOutputStream5 = fileOutputStream;
            Log.w("LVLDL", "exception while syncing file: ", e);
            r0 = fileOutputStream5;
            if (fileOutputStream5 != null) {
                fileOutputStream5.close();
                r0 = fileOutputStream5;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = fileOutputStream;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e11) {
                    Log.w("LVLDL", "IOException while closing synced file: ", e11);
                } catch (RuntimeException e12) {
                    Log.w("LVLDL", "exception while closing file: ", e12);
                }
            }
            throw th;
        }
    }

    private void d(b bVar) {
        try {
            if (bVar.b != null) {
                bVar.b.close();
                bVar.b = null;
            }
        } catch (IOException unused) {
        }
    }

    private void e(b bVar) throws StopRequest {
        if (this.c.k() == 1 && this.c.l() == 193) {
            throw new StopRequest(this.c.l(), "download paused");
        }
    }

    private void a(b bVar, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar.f5369a - aVar.h <= 4096 || currentTimeMillis - aVar.i <= 1000) {
            return;
        }
        this.b.f = aVar.f5369a;
        this.d.b(this.b);
        aVar.h = aVar.f5369a;
        aVar.i = currentTimeMillis;
        this.c.a(aVar.b + this.c.f5371a);
    }

    private void a(b bVar, byte[] bArr, int i) throws StopRequest {
        try {
            if (bVar.b == null) {
                bVar.b = new FileOutputStream(bVar.f5370a, true);
            }
            bVar.b.write(bArr, 0, i);
            d(bVar);
        } catch (IOException e) {
            if (!com.google.android.vending.expansion.downloader.d.a()) {
                throw new StopRequest(499, "external media not mounted while writing destination file");
            }
            if (com.google.android.vending.expansion.downloader.d.a(com.google.android.vending.expansion.downloader.d.a(bVar.f5370a)) < i) {
                throw new StopRequest(498, "insufficient space while writing destination file", e);
            }
            throw new StopRequest(492, "while writing destination file: " + e.toString(), e);
        }
    }

    private void b(b bVar, a aVar) throws StopRequest {
        this.b.f = aVar.f5369a;
        this.d.c(this.b);
        if ((aVar.e == null || aVar.f5369a == Integer.parseInt(aVar.e)) ? false : true) {
            if (a(aVar)) {
                throw new StopRequest(489, "mismatched content length");
            }
            throw new StopRequest(f(bVar), "closed socket before end of file");
        }
    }

    private boolean a(a aVar) {
        return aVar.f5369a > 0 && aVar.c == null;
    }

    private int b(b bVar, a aVar, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e) {
            c();
            this.b.f = aVar.f5369a;
            this.d.c(this.b);
            if (a(aVar)) {
                throw new StopRequest(489, "while reading response: " + e.toString() + ", can't resume interrupted download with no ETag", e);
            }
            throw new StopRequest(f(bVar), "while reading response: " + e.toString(), e);
        }
    }

    private InputStream b(b bVar, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            c();
            throw new StopRequest(f(bVar), "while getting entity: " + e.toString(), e);
        }
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("Net ");
        sb.append(this.c.a(this.d) == 1 ? "Up" : "Down");
        Log.i("LVLDL", sb.toString());
    }

    private void a(b bVar, a aVar, HttpURLConnection httpURLConnection) throws StopRequest {
        if (aVar.d) {
            return;
        }
        b(bVar, aVar, httpURLConnection);
        try {
            bVar.f5370a = this.c.a(this.b.c, this.b.e);
            try {
                bVar.b = new FileOutputStream(bVar.f5370a);
            } catch (FileNotFoundException e) {
                try {
                    if (new File(com.google.android.vending.expansion.downloader.d.b(this.c)).mkdirs()) {
                        bVar.b = new FileOutputStream(bVar.f5370a);
                    }
                } catch (Exception unused) {
                    throw new StopRequest(492, "while opening destination file: " + e.toString(), e);
                }
            }
            c(bVar, aVar);
            a(bVar);
        } catch (DownloaderService.GenerateSaveFileError e2) {
            throw new StopRequest(e2.mStatus, e2.mMessage);
        }
    }

    private void c(b bVar, a aVar) {
        this.b.d = aVar.c;
        this.d.c(this.b);
    }

    private void b(b bVar, a aVar, HttpURLConnection httpURLConnection) throws StopRequest {
        String headerField = httpURLConnection.getHeaderField(Headers.CONTENT_DISPOSITION);
        if (headerField != null) {
            aVar.f = headerField;
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Location");
        if (headerField2 != null) {
            aVar.g = headerField2;
        }
        String headerField3 = httpURLConnection.getHeaderField(Headers.ETAG);
        if (headerField3 != null) {
            aVar.c = headerField3;
        }
        String headerField4 = httpURLConnection.getHeaderField("Transfer-Encoding");
        String str = headerField4 != null ? headerField4 : null;
        String headerField5 = httpURLConnection.getHeaderField("Content-Type");
        if (headerField5 != null && !headerField5.equals("application/vnd.android.obb")) {
            throw new StopRequest(487, "file delivered with incorrect Mime type");
        }
        if (str == null) {
            long contentLength = httpURLConnection.getContentLength();
            if (headerField5 != null) {
                if (contentLength != -1 && contentLength != this.b.e) {
                    Log.e("LVLDL", "Incorrect file size delivered.");
                } else {
                    aVar.e = Long.toString(contentLength);
                }
            }
        }
        if (aVar.e == null && (str == null || !str.equalsIgnoreCase("chunked"))) {
            throw new StopRequest(495, "can't know size of download, giving up");
        }
    }

    private void a(b bVar, a aVar, HttpURLConnection httpURLConnection, int i) throws StopRequest, RetryDownload {
        if (i == 503 && this.b.j < 5) {
            c(bVar, httpURLConnection);
        }
        if (i != (aVar.d ? TbsListener.ErrorCode.UNZIP_IO_ERROR : 200)) {
            a(bVar, aVar, i);
        } else {
            bVar.e = 0;
        }
    }

    private void a(b bVar, a aVar, int i) throws StopRequest {
        int i2;
        if (DownloaderService.b(i)) {
            i2 = i;
        } else if (i < 300 || i >= 400) {
            i2 = (aVar.d && i == 200) ? 489 : 494;
        } else {
            i2 = FacebookRequestErrorClassification.ESC_APP_INACTIVE;
        }
        throw new StopRequest(i2, "http error " + i);
    }

    private void a(a aVar, HttpURLConnection httpURLConnection) {
        if (aVar.d) {
            if (aVar.c != null) {
                httpURLConnection.setRequestProperty(Headers.GET_OBJECT_IF_MATCH, aVar.c);
            }
            httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + aVar.f5369a + "-");
        }
    }

    private void c(b bVar, HttpURLConnection httpURLConnection) throws StopRequest {
        bVar.c = true;
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        if (headerField != null) {
            try {
                bVar.d = Integer.parseInt(headerField);
                if (bVar.d < 0) {
                    bVar.d = 0;
                } else {
                    if (bVar.d < 30) {
                        bVar.d = 30;
                    } else if (bVar.d > 86400) {
                        bVar.d = Strategy.TTL_SECONDS_MAX;
                    }
                    bVar.d += com.google.android.vending.expansion.downloader.d.f5365a.nextInt(31);
                    bVar.d *= 1000;
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new StopRequest(194, "got 503 Service Unavailable, will retry later");
    }

    private int d(b bVar, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            c();
            throw new StopRequest(f(bVar), "while trying to execute request: " + e.toString(), e);
        } catch (IllegalArgumentException e2) {
            throw new StopRequest(495, "while trying to execute request: " + e2.toString(), e2);
        }
    }

    private int f(b bVar) {
        if (this.c.a(this.d) != 1) {
            return 195;
        }
        if (this.b.j < 5) {
            bVar.c = true;
            return 194;
        }
        Log.w("LVLDL", "reached max retries for " + this.b.j);
        return 495;
    }

    private void d(b bVar, a aVar) throws StopRequest {
        if (bVar.f5370a != null) {
            if (!com.google.android.vending.expansion.downloader.d.b(bVar.f5370a)) {
                throw new StopRequest(492, "found invalid internal destination filename");
            }
            File file = new File(bVar.f5370a);
            if (file.exists()) {
                long length = file.length();
                if (length == 0) {
                    file.delete();
                    bVar.f5370a = null;
                } else {
                    if (this.b.d == null) {
                        file.delete();
                        throw new StopRequest(489, "Trying to resume a download that can't be resumed");
                    }
                    try {
                        bVar.b = new FileOutputStream(bVar.f5370a, true);
                        aVar.f5369a = (int) length;
                        if (this.b.e != -1) {
                            aVar.e = Long.toString(this.b.e);
                        }
                        aVar.c = this.b.d;
                        aVar.d = true;
                    } catch (FileNotFoundException e) {
                        throw new StopRequest(492, "while opening destination for resuming: " + e.toString(), e);
                    }
                }
            }
        }
        if (bVar.b != null) {
            d(bVar);
        }
    }

    private void a(int i, boolean z, int i2, int i3, boolean z2, String str) {
        b(i, z, i2, i3, z2, str);
        DownloaderService.c(i);
    }

    private void b(int i, boolean z, int i2, int i3, boolean z2, String str) {
        com.google.android.vending.expansion.downloader.impl.a aVar = this.b;
        aVar.h = i;
        aVar.k = i2;
        aVar.l = i3;
        aVar.g = System.currentTimeMillis();
        if (!z) {
            this.b.j = 0;
        } else if (z2) {
            this.b.j = 1;
        } else {
            this.b.j++;
        }
        this.d.c(this.b);
    }
}
