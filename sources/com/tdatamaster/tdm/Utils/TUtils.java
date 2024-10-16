package com.tdatamaster.tdm.Utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class TUtils {
    private static String TAG = "TUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0115 A[Catch: IOException -> 0x0111, TRY_LEAVE, TryCatch #1 {IOException -> 0x0111, blocks: (B:63:0x010d, B:56:0x0115), top: B:62:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyAssertsToDest(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.Utils.TUtils.copyAssertsToDest(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static String calculateFileMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encodeFile2HexStr = MD5Util.encodeFile2HexStr(str);
        return TextUtils.isEmpty(encodeFile2HexStr) ? encodeFile2HexStr : encodeFile2HexStr.toUpperCase();
    }

    public static String calculateAssetsFileMD5(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String encodeAssets2HexStr = MD5Util.encodeAssets2HexStr(context, str);
        return TextUtils.isEmpty(encodeAssets2HexStr) ? encodeAssets2HexStr : encodeAssets2HexStr.toUpperCase();
    }
}
