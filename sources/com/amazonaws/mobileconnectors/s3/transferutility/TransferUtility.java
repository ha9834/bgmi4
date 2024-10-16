package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class TransferUtility {
    private static final Log LOGGER = LogFactory.getLog(TransferUtility.class);
    static final int MINIMUM_UPLOAD_PART_SIZE = 5242880;
    private final Context appContext;
    private final TransferDBUtil dbUtil;
    private final AmazonS3 s3;

    public TransferUtility(AmazonS3 amazonS3, Context context) {
        this.s3 = amazonS3;
        this.appContext = context.getApplicationContext();
        this.dbUtil = new TransferDBUtil(this.appContext);
    }

    public TransferObserver download(String str, String str2, File file) {
        return download(str, str2, file, null);
    }

    public TransferObserver download(String str, String str2, File file, TransferListener transferListener) {
        if (file == null || file.isDirectory()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int parseInt = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.DOWNLOAD, str, str2, file).getLastPathSegment());
        if (file.isFile()) {
            LOGGER.warn("Overwrite existing file: " + file);
            file.delete();
        }
        sendIntent("add_transfer", parseInt);
        return new TransferObserver(parseInt, this.dbUtil, str, str2, file, transferListener);
    }

    public TransferObserver upload(String str, String str2, File file) {
        return upload(str, str2, file, new ObjectMetadata());
    }

    public TransferObserver upload(String str, String str2, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return upload(str, str2, file, objectMetadata, null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        int parseInt;
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        if (shouldUploadInMultipart(file)) {
            parseInt = createMultipartUploadRecords(str, str2, file, objectMetadata, cannedAccessControlList);
        } else {
            parseInt = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList).getLastPathSegment());
        }
        sendIntent("add_transfer", parseInt);
        return new TransferObserver(parseInt, this.dbUtil, str, str2, file, transferListener);
    }

    public TransferObserver getTransferById(int i) {
        Cursor cursor;
        try {
            cursor = this.dbUtil.queryTransferById(i);
            try {
                if (!cursor.moveToNext()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                TransferObserver transferObserver = new TransferObserver(i, this.dbUtil);
                transferObserver.updateFromDB(cursor);
                if (cursor != null) {
                    cursor.close();
                }
                return transferObserver;
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<TransferObserver> getTransfersWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow("_id")), this.dbUtil);
                transferObserver.updateFromDB(cursor);
                arrayList.add(transferObserver);
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<TransferObserver> getTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransfersWithTypeAndState(transferType, transferState);
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0) {
                    TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow("_id")), this.dbUtil);
                    transferObserver.updateFromDB(cursor);
                    arrayList.add(transferObserver);
                }
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private int createMultipartUploadRecords(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d = length;
        Double.isNaN(d);
        long max = (long) Math.max(Math.ceil(d / 10000.0d), 5242880.0d);
        double d2 = max;
        Double.isNaN(d);
        Double.isNaN(d2);
        int ceil = ((int) Math.ceil(d / d2)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[ceil];
        contentValuesArr[0] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList);
        long j = length;
        long j2 = 0;
        int i = 1;
        for (int i2 = 1; i2 < ceil; i2++) {
            long min = Math.min(max, j);
            j -= max;
            contentValuesArr[i2] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, j2, i, "", min, j <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList);
            j2 += max;
            i++;
        }
        return this.dbUtil.bulkInsertTransferRecords(contentValuesArr);
    }

    public boolean pause(int i) {
        sendIntent("pause_transfer", i);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pauseAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                pause(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public TransferObserver resume(int i) {
        sendIntent("resume_transfer", i);
        return getTransferById(i);
    }

    public boolean cancel(int i) {
        sendIntent("cancel_transfer", i);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                cancel(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public boolean deleteTransferRecord(int i) {
        cancel(i);
        return this.dbUtil.deleteTransferRecords(i) > 0;
    }

    private synchronized void sendIntent(String str, int i) {
        String uuid = UUID.randomUUID().toString();
        S3ClientReference.put(uuid, this.s3);
        Intent intent = new Intent(this.appContext, (Class<?>) TransferService.class);
        intent.setAction(str);
        intent.putExtra("id", i);
        intent.putExtra("s3_reference_key", uuid);
        this.appContext.startService(intent);
    }

    private boolean shouldUploadInMultipart(File file) {
        return file != null && file.length() > 5242880;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends AmazonWebServiceRequest> X appendTransferServiceUserAgentString(X x) {
        x.getRequestClientOptions().appendUserAgent("TransferService/" + VersionInfoUtils.getVersion());
        return x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends AmazonWebServiceRequest> X appendMultipartTransferServiceUserAgentString(X x) {
        x.getRequestClientOptions().appendUserAgent("TransferService_multipart/" + VersionInfoUtils.getVersion());
        return x;
    }

    TransferDBUtil getDbUtil() {
        return this.dbUtil;
    }
}
