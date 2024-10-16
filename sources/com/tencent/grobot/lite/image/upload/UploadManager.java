package com.tencent.grobot.lite.image.upload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.thread.ThreadManager;
import com.tencent.grobot.lite.image.upload.cos.COSUploadUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class UploadManager {
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final String CHARSET = "utf-8";
    private static final String CONTENT_TYPE = "multipart/form-data";
    private static final String LINE_END = "\r\n";
    private static final long MAX_SIZE = 204800;
    private static final String PREFIX = "--";
    private static final String TAG = "UploadManager";
    public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
    public static final int UPLOAD_SERVER_ERROR_CODE = 3;
    public static final int UPLOAD_SUCCESS_CODE = 1;
    private static UploadManager uploadManager;
    private Context mContext;
    private OnUploadListener onUploadListener;
    private String path;
    private int readTimeOut = 12000;
    private int connectTimeout = 12000;
    private List<String> tmpList = new ArrayList();

    /* loaded from: classes2.dex */
    public interface OnUploadListener {
        void onUploadFailed(String str, String str2, String str3);

        void onUploadProgress(String str, long j, long j2, String str2);

        void onUploadSucceed(String str, String str2, String str3);
    }

    private UploadManager(Context context) {
        this.mContext = context;
    }

    public static UploadManager getInstance(Context context) {
        if (uploadManager == null) {
            uploadManager = new UploadManager(context);
        }
        return uploadManager;
    }

    public static void onDestory() {
        UploadManager uploadManager2 = uploadManager;
        if (uploadManager2 != null) {
            uploadManager2.onUploadListener = null;
            uploadManager = null;
        }
    }

    public void uploadPhoto(String str) {
        if (str == null && TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.get().postToNetThread(new UploadPhotoRunnable(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cosUploadFile(String str, String str2) {
        COSUploadUtil.uploadPhoto(str, str2, this.onUploadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UploadPhotoRunnable implements Runnable {
        private String picPath;

        public UploadPhotoRunnable(String str) {
            this.picPath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.picPath);
            if (file.exists()) {
                long fileSize = UploadManager.this.getFileSize(file);
                if (fileSize == -1) {
                    return;
                }
                if (fileSize <= UploadManager.MAX_SIZE) {
                    UploadManager.this.cosUploadFile(this.picPath, file.getPath());
                    return;
                }
                TLog.d("upload Run path", UploadManager.this.path + "==" + file.getPath());
                String compress = UploadManager.this.compress(file.getPath());
                if (compress == null || TextUtils.isEmpty(compress)) {
                    TLog.e(UploadManager.TAG, "upLoadRunnable  upLoadRunnable");
                    return;
                }
                File file2 = new File(compress);
                if (compress == null || TextUtils.isEmpty(compress) || !file2.exists()) {
                    return;
                }
                UploadManager.this.cosUploadFile(this.picPath, file2.getPath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getFileSize(File file) {
        FileChannel fileChannel = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                if (!file.exists() || !file.isFile()) {
                    return -1L;
                }
                fileChannel = new FileInputStream(file).getChannel();
                return fileChannel.size();
            } finally {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            if (fileChannel != null) {
                fileChannel.close();
            }
            return -1L;
        } catch (IOException e4) {
            e4.printStackTrace();
            if (fileChannel != null) {
                fileChannel.close();
            }
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String compress(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.grobot.lite.image.upload.UploadManager.compress(java.lang.String):java.lang.String");
    }

    public void setOnUploadListener(OnUploadListener onUploadListener) {
        this.onUploadListener = onUploadListener;
    }

    public int getReadTimeOut() {
        return this.readTimeOut;
    }

    public void setReadTimeOut(int i) {
        this.readTimeOut = i;
    }

    public void deleteTmpFile() {
        if (this.tmpList.size() > 0) {
            for (int i = 0; i < this.tmpList.size(); i++) {
                try {
                    File file = new File(this.tmpList.get(i));
                    file.delete();
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file));
                    this.mContext.sendBroadcast(intent);
                } catch (Exception e) {
                    TLog.e(TAG, "deleteTmpFile  Exception" + e);
                }
            }
        }
    }
}
