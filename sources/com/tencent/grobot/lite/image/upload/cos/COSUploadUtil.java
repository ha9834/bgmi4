package com.tencent.grobot.lite.image.upload.cos;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GameParameters;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;

/* loaded from: classes2.dex */
public class COSUploadUtil {
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018f, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0141, code lost:
    
        r21.onUploadSucceed(r10, r19, r1);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x016d, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013f, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void uploadPhoto(java.lang.String r19, java.lang.String r20, com.tencent.grobot.lite.image.upload.UploadManager.OnUploadListener r21) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.grobot.lite.image.upload.cos.COSUploadUtil.uploadPhoto(java.lang.String, java.lang.String, com.tencent.grobot.lite.image.upload.UploadManager$OnUploadListener):void");
    }

    private static String getCosPath(File file) {
        GameParameters gameParam = GRobotApplication.getInstance().getGameParam();
        if (gameParam != null) {
            return gameParam.roleId + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + System.currentTimeMillis() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + file.getName();
        }
        return System.currentTimeMillis() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + file.getName();
    }
}
