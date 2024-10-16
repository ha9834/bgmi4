package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TbsDownloadUpload {
    private static TbsDownloadUpload b;

    /* renamed from: a, reason: collision with root package name */
    Map<String, Object> f6464a = new HashMap();
    private Context c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    public SharedPreferences mPreferences;

    /* loaded from: classes2.dex */
    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        this.c = context.getApplicationContext();
        if (this.c == null) {
            this.c = context;
        }
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            if (b == null) {
                b = new TbsDownloadUpload(context);
            }
            tbsDownloadUpload = b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            tbsDownloadUpload = b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized void clear() {
        synchronized (TbsDownloadUpload.class) {
            b = null;
        }
    }

    public void clearUploadCode() {
        this.f6464a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.f6464a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.f6464a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.f6464a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.f6464a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.f6464a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public synchronized int getNeedDownloadCode() {
        if (this.g == 1) {
            return TbsListener.ErrorCode.NEEDDOWNLOAD_9;
        }
        return this.d;
    }

    public synchronized int getLocalCoreVersion() {
        return this.i;
    }

    public synchronized int getStartDownloadCode() {
        if (this.h == 1) {
            return TbsListener.ErrorCode.STARTDOWNLOAD_9;
        }
        return this.e;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void readTbsDownloadInfo(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.readTbsDownloadInfo(android.content.Context):void");
    }

    private static File a(Context context, String str) {
        j.a();
        File e = j.e(context);
        if (e == null) {
            return null;
        }
        File file = new File(e, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[Catch: all -> 0x00dc, SYNTHETIC, TRY_LEAVE, TryCatch #13 {, blocks: (B:3:0x0001, B:23:0x0088, B:26:0x0090, B:31:0x0095, B:33:0x008d, B:65:0x00c9, B:57:0x00d3, B:62:0x00db, B:61:0x00d8, B:68:0x00ce, B:47:0x00b2, B:43:0x00bc, B:50:0x00b7), top: B:2:0x0001, inners: #1, #3, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void writeTbsDownloadInfo() {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.writeTbsDownloadInfo():void");
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }
}
