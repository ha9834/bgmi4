package com.tencent.hawk.bridge;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public final class QCCFetcher implements Runnable {
    public static boolean isQccFileFetchInSession;
    public static int qccVersion;
    private String mCacheFileName;
    private Context mCtx;
    private String mProjIden;
    private String mTargetName;
    private boolean isQccFileReady = false;
    private boolean isFetchDone = false;
    private int maxTimeOut = 10000;

    public QCCFetcher(Context context, String str, String str2, String str3) {
        this.mCacheFileName = null;
        this.mTargetName = null;
        this.mCtx = context;
        this.mProjIden = str;
        this.mCacheFileName = str2;
        this.mTargetName = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean doGet() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.QCCFetcher.doGet():boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (i < 10 && !this.isFetchDone) {
            i++;
            if (doGet()) {
                return;
            }
        }
    }

    public void asynFetchQcc(int i) {
        HawkLogger.d("begin to fetch qcc file async");
        if (isQccFileFetchInSession) {
            return;
        }
        isQccFileFetchInSession = true;
        File fileStreamPath = this.mCtx.getFileStreamPath(this.mTargetName);
        if (fileStreamPath.exists() && !fileStreamPath.delete()) {
            HawkLogger.e("delete temp failed in asyncfetch " + this.mTargetName);
        }
        qccVersion = i;
        this.isQccFileReady = false;
        Thread thread = new Thread(this);
        thread.setName("QccFetcherThread");
        thread.start();
    }

    public boolean checkQccFileReady() {
        return this.isQccFileReady;
    }

    public void setQccFileReady() {
        this.isQccFileReady = true;
    }

    public void resetQccFileReady() {
        this.isQccFileReady = false;
    }
}
