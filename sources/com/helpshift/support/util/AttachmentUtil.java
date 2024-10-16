package com.helpshift.support.util;

import android.content.Context;
import android.net.Uri;
import com.helpshift.common.domain.AttachmentFileManagerDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.HSApiData;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.IOUtils;
import com.helpshift.util.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class AttachmentUtil {
    private static final int IMAGE_MAX_DIMENSION = 1024;
    private static final String TAG = "Helpshift_AttachUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String copyAttachment(String str) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Context applicationContext = HelpshiftContext.getApplicationContext();
        HSApiData hSApiData = new HSApiData(applicationContext);
        FileOutputStream fileOutputStream2 = null;
        try {
            String buildLocalAttachmentCopyFileName = buildLocalAttachmentCopyFileName(AndroidFileUtil.getFileExtension(str));
            File file = new File(applicationContext.getFilesDir(), buildLocalAttachmentCopyFileName);
            String absolutePath = file.getAbsolutePath();
            if (file.exists()) {
                fileOutputStream = null;
                fileInputStream = null;
            } else {
                hSApiData.storeFile(buildLocalAttachmentCopyFileName);
                fileInputStream = new FileInputStream(new File(str));
                try {
                    fileOutputStream = applicationContext.openFileOutput(buildLocalAttachmentCopyFileName, 0);
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            if (ImageUtil.isResizableImage(absolutePath)) {
                                ImageUtil.scaleDownAndSaveWithMaxDimension(absolutePath, 1024);
                            }
                        } catch (NullPointerException e) {
                            e = e;
                            HSLogger.d(TAG, "NPE", e);
                            IOUtils.closeQuitely(fileOutputStream);
                            IOUtils.closeQuitely(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        IOUtils.closeQuitely(fileOutputStream2);
                        IOUtils.closeQuitely(fileInputStream);
                        throw th;
                    }
                } catch (NullPointerException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(fileOutputStream2);
                    IOUtils.closeQuitely(fileInputStream);
                    throw th;
                }
            }
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(fileInputStream);
            return absolutePath;
        } catch (NullPointerException e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void copyAttachment(AttachmentPickerFile attachmentPickerFile) throws IOException {
        InputStream inputStream;
        Uri uri = (Uri) attachmentPickerFile.transientUri;
        if (uri == null) {
            HSLogger.d(TAG, "Can't proceed if uri is null");
            return;
        }
        Context applicationContext = HelpshiftContext.getApplicationContext();
        HSApiData hSApiData = new HSApiData(applicationContext);
        FileOutputStream fileOutputStream = null;
        try {
            String buildLocalAttachmentCopyFileName = buildLocalAttachmentCopyFileName(AndroidFileUtil.getFileExtensionFromMimeType(applicationContext, uri));
            File file = new File(applicationContext.getFilesDir(), buildLocalAttachmentCopyFileName);
            String absolutePath = file.getAbsolutePath();
            if (!file.exists()) {
                hSApiData.storeFile(buildLocalAttachmentCopyFileName);
                inputStream = applicationContext.getContentResolver().openInputStream(uri);
                try {
                    fileOutputStream = applicationContext.openFileOutput(buildLocalAttachmentCopyFileName, 0);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    attachmentPickerFile.filePath = absolutePath;
                    attachmentPickerFile.isFileCompressionAndCopyingDone = true;
                    if (ImageUtil.isResizableImage(absolutePath)) {
                        ImageUtil.scaleDownAndSaveWithMaxDimension(absolutePath, 1024, ImageUtil.getExifOrientation(applicationContext, uri));
                    }
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuitely(fileOutputStream);
                    IOUtils.closeQuitely(inputStream);
                    throw th;
                }
            } else {
                attachmentPickerFile.filePath = absolutePath;
                attachmentPickerFile.isFileCompressionAndCopyingDone = true;
                inputStream = null;
            }
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(inputStream);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private static String buildLocalAttachmentCopyFileName(String str) {
        String str2 = AttachmentFileManagerDM.LOCAL_RSC_MESSAGE_PREFIX + UUID.randomUUID().toString() + "0-thumbnail";
        if (str == null) {
            return str2;
        }
        return str2 + "." + str;
    }
}
