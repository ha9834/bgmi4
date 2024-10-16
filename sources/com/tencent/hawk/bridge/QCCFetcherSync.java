package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.game.gamekit.b.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class QCCFetcherSync {
    private static final String QCC_CACHED_FILE = "TAPM_CACHED";
    private static final String QCC_CACHED_VERSION_KEY = "TAPM_CACHED_VK";
    private String mAppId;
    private Context mCtx;
    private int maxTimeOut = 10000;
    private int mErrorCode = -1;
    private String mLocalFetchFileName = a.f5471a;

    public QCCFetcherSync(Context context, String str) {
        this.mCtx = context;
        this.mAppId = str;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    private void writeQccCachedVersion(int i) {
        SharedPreferences sharedPreferences = this.mCtx.getSharedPreferences(QCC_CACHED_FILE, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            edit.putInt(QCC_CACHED_VERSION_KEY, i);
            edit.commit();
            HawkLogger.d("writeQualityCache");
            return;
        }
        HawkLogger.e("writeQualityCache error");
    }

    private int readQualityCache() {
        SharedPreferences sharedPreferences = this.mCtx.getSharedPreferences(QCC_CACHED_FILE, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(QCC_CACHED_VERSION_KEY, -1);
        }
        return -1;
    }

    public boolean fetchFileWithRedirect() {
        int i;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int readQualityCache = readQualityCache();
        if (readQualityCache <= 0) {
            String str = "asset_qcc_file_" + (Math.random() * 1000.0d);
            if (!FileUtil.cpAssetFile(this.mCtx, Constant.QUALITY_CONTROL_PREFIX + this.mAppId, str)) {
                HawkLogger.e("QccSYNC, CpAssetFile failed");
                this.mErrorCode = -4;
                return false;
            }
            QCCJudgerMultiVersion qCCJudgerMultiVersion = new QCCJudgerMultiVersion();
            try {
                fileInputStream2 = this.mCtx.openFileInput(str);
            } catch (FileNotFoundException e) {
                HawkLogger.e("QccSYNC, cannot open asset_qcc_file" + e.getMessage());
                fileInputStream2 = null;
            }
            if (!qCCJudgerMultiVersion.parseQccFile(fileInputStream2)) {
                HawkLogger.e("Parse Asset qcc config error, return");
                this.mErrorCode = -1;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                        HawkLogger.e("QccSYNC, cannot close file");
                    }
                }
                this.mCtx.deleteFile(str);
                return false;
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                    HawkLogger.e("QccSYNC, cannot close file");
                }
            }
            this.mCtx.deleteFile(str);
            readQualityCache = qCCJudgerMultiVersion.getQccVersion();
            HawkLogger.i("QccSYNC, get default qcc config version: " + readQualityCache);
            if (readQualityCache > 0) {
                writeQccCachedVersion(readQualityCache);
            }
        }
        String str2 = "";
        int i2 = 0;
        int i3 = readQualityCache;
        int i4 = -1;
        while (true) {
            if (i4 == i3) {
                break;
            }
            int i5 = i2 + 1;
            if (i2 >= 10) {
                i2 = i5;
                break;
            }
            HawkLogger.d("QccSYNC, Redirect " + i5);
            str2 = "QccSYNC_" + i3 + (Math.random() * 1000.0d);
            int i6 = 0;
            while (true) {
                i = i6 + 1;
                if (i6 >= 10 || processFetch(i3, str2)) {
                    break;
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    HawkLogger.e("Sleep error: " + e2.getMessage());
                }
                File fileStreamPath = this.mCtx.getFileStreamPath(str2);
                if (fileStreamPath != null && fileStreamPath.exists()) {
                    fileStreamPath.delete();
                }
                i6 = i;
            }
            if (i >= 10) {
                HawkLogger.e("QccSYNC, cannot fetch target qcc config: " + i3);
                this.mErrorCode = -2;
                return false;
            }
            try {
                fileInputStream = this.mCtx.openFileInput(str2);
            } catch (FileNotFoundException e3) {
                HawkLogger.e("QccSYNC, cannot open asset_qcc_file" + e3.getMessage());
                fileInputStream = null;
            }
            QCCJudgerMultiVersion qCCJudgerMultiVersion2 = new QCCJudgerMultiVersion();
            if (!qCCJudgerMultiVersion2.parseQccFile(fileInputStream)) {
                HawkLogger.e("QccSYNC, Parse Qcc Config failed");
                this.mCtx.deleteFile(str2);
                i2 = i5;
            } else {
                int qccVersion = qCCJudgerMultiVersion2.getQccVersion();
                if (qccVersion > -1) {
                    i4 = i3;
                    i3 = qccVersion;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                        HawkLogger.e("QccSYNC, cannot close file");
                    }
                }
                i2 = i5;
            }
        }
        if (i2 < 10 && i4 == i3) {
            writeQccCachedVersion(i4);
            this.mLocalFetchFileName = str2;
            return true;
        }
        HawkLogger.e("QccSYNC, fetch failed, LocalVersion: " + i4 + ", LinkVersion: " + i3 + ", RT: " + i2);
        this.mErrorCode = -3;
        return false;
    }

    public String getFetchedLocalFileName() {
        return this.mLocalFetchFileName;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean processFetch(int r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.QCCFetcherSync.processFetch(int, java.lang.String):boolean");
    }
}
