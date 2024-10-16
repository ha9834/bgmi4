package com.tencent.gcloud.apkchannel;

import android.util.Log;
import com.google.android.gms.games.GamesStatusCodes;
import com.tencent.gcloud.apkchannel.v1.ZipEocdCommentTool;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureV2ChannelTool;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes2.dex */
public final class ApkChannelUtil {
    public static final String CHANNELID = "channelId";
    public static final int CHANNEL_ID_WHITE_LIST_END = 89999999;
    public static final int CHANNEL_ID_WHITE_LIST_START = 89900000;
    public static final int OFFICIAL_CHANNEL_ID_WHITE_LIST_END = 79999999;
    public static final int OFFICIAL_CHANNEL_ID_WHITE_LIST_START = 79900000;
    public static final String TAG = "ApkChannelUtil";

    public static void clearChannel(String str) throws Exception {
        clearKeyValuePair(str);
    }

    private static void clearKeyValuePair(String str) throws Exception {
        ZipEocdCommentTool.clearComment(str);
    }

    public static long getCDFHOffset(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readCDFHOffset(str);
            Log.i(TAG, "getCDFHOffset offset:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long getCDFHSize(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readCDFHSize(str);
            Log.i(TAG, "getCDFHSize size:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long getEOCDOffset(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readEOCDOffset(str);
            Log.i(TAG, "getEOCDOffset offset:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long getEOCDSize(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readEOCDSize(str);
            Log.i(TAG, "getEOCDSize size:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    private static int getV2ChannelBlockId(String str) throws IOException {
        try {
            return ApkSignatureV2ChannelTool.getApkCurChannelId(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static String getV2ChannelBlockValue(String str) throws IOException {
        byte[] bArr;
        Log.i(TAG, "apollo0511 getV2ChannelBlockValue apkFilePath:" + str);
        try {
            bArr = ApkSignatureV2ChannelTool.getApkCurChannelValue(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new ChannelComment().getValue(bArr);
        } catch (ProtocolException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getV2ChannelId(String str) throws IOException {
        try {
            Log.i(TAG, "getV2ChannelId apkFilePath:" + str);
            return getV2ChannelBlockId(str);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "getV2ChannelId exception!");
            return -1;
        }
    }

    public static long getV2ChannelOffset(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readCommentOffset(str);
            Log.i(TAG, "getV2ChannelOffset offset:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long getV2ChannelSize(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.readCommentSize(str);
            Log.i(TAG, "getV2ChannelSize size:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static String getV2ChannelValue(String str) throws IOException {
        try {
            Log.i(TAG, "getV2ChannelValue apkFilePath:" + str);
            return getV2ChannelBlockValue(str);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "getV2ChannelValue exception!");
            return null;
        }
    }

    public static long getV2SignBlockOffset(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.getSignBlockOffset(str);
            Log.i(TAG, "getV2SignBlockOffset offset:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long getV2SignBlockSize(String str) {
        long j = 0;
        try {
            j = ApkSignatureV2ChannelTool.getSignBlockSize(str);
            Log.i(TAG, "getV2SignBlockSize size:" + j);
            return j;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static int isSignatureV2Apk(String str) {
        try {
            boolean isSignatureV2Apk = ApkSignatureV2ChannelTool.isSignatureV2Apk(str);
            Log.i(TAG, "isSignatureV2Apk ret:" + isSignatureV2Apk);
            return isSignatureV2Apk ? 1 : 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String readChannel(String str) throws IOException {
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                return null;
            }
            return readChannelComment.p.getProperty("channelId");
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "readChannel exception!");
            return null;
        }
    }

    private static ChannelComment readChannelComment(String str) throws IOException {
        byte[] readComment;
        try {
            readComment = ApkSignatureV2ChannelTool.readYYBComment(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused) {
            readComment = ZipEocdCommentTool.readComment(str);
        }
        if (readComment == null) {
            return null;
        }
        ChannelComment channelComment = new ChannelComment();
        try {
            channelComment.decode(readComment);
            return channelComment;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateChannel(String str, String str2) throws Exception {
        updateKeyValuePair(str, "channelId", str2);
    }

    private static boolean updateKeyValueBlock(int i, String str, String str2) throws Exception {
        if (i <= 0 || str == null || str.equals("")) {
            return false;
        }
        ChannelComment channelComment = new ChannelComment();
        if (!ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
            return true;
        }
        ApkSignatureV2ChannelTool.updateChannInfoBlock(str2, i, channelComment.encode(str));
        return true;
    }

    private static void updateKeyValuePair(String str, String str2, String str3) throws Exception {
        ChannelComment readChannelComment = readChannelComment(str);
        if (readChannelComment == null) {
            readChannelComment = new ChannelComment();
        }
        readChannelComment.p.setProperty(str2, str3);
        if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str)) {
            ApkSignatureV2ChannelTool.updateYYBComment(str, readChannelComment.encode());
        } else {
            ZipEocdCommentTool.updateComment(str, readChannelComment.encode());
        }
    }

    public static boolean updateV2ChannelInfo(int i, String str, String str2) throws Exception {
        try {
            Log.i(TAG, "updateV2ChannelInfo channelId:" + i + ",channelInfo:" + str + ",apkFilePath:" + str2);
            return updateKeyValueBlock(i, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "updateV2ChannelInfo exception!");
            return false;
        }
    }

    public static void writeOldCommentToNewFile(String str, String str2) throws Exception {
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment != null) {
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                } else {
                    ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "writeOldCommentToNewFile exception!");
        }
    }

    public static void writeOldCommentToNewFileWithWhiteList(String str, String str2) throws Exception {
        byte[] encode;
        byte[] encode2;
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                Log.i(TAG, "Comment is null");
                return;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i(TAG, "old_apk_channel_value is null");
                return;
            }
            String readChannel2 = readChannel(str2);
            int parseInt = readChannel2 != null ? Integer.parseInt(readChannel2) : 0;
            int parseInt2 = Integer.parseInt(readChannel);
            if (parseInt2 < 79900000 || parseInt2 > 89999999) {
                Log.i(TAG, "value=" + parseInt2);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            } else if (readChannel2 == null) {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel value is null");
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            } else if (parseInt2 < 79900000 || parseInt2 > 79999999 || parseInt < 89900000 || parseInt > 89999999) {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel=" + parseInt);
                Log.i(TAG, "Don't need reWrite channel Value");
            } else {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel=" + parseInt);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            }
            Log.i(TAG, "final_apk_channel_value=" + readChannel(str2));
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "writeOldCommentToNewFileWithWhiteList exception!");
        }
    }

    public static int writeOldCommentToNewFileWithWhiteListReturnReWriteRes(String str, String str2) throws Exception {
        int parseInt;
        byte[] encode;
        byte[] encode2;
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                Log.i(TAG, "Comment is null");
                return 0;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i(TAG, "old_apk_channel_value is null");
                return 0;
            }
            String readChannel2 = readChannel(str2);
            if (readChannel2 != null) {
                try {
                    parseInt = Integer.parseInt(readChannel2);
                } catch (NumberFormatException unused) {
                    Log.i(TAG, "old_channelValue or new_channelValue is character， rewrite old channel directly.");
                    try {
                        if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                            Log.i(TAG, "use v2 signature");
                            ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                            return 2000;
                        }
                        Log.i(TAG, "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                        return 2000;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i(TAG, "writeOldCommentToNewFileWithWhiteListReturnReWriteRes exception!");
                        return GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE;
                    }
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = Integer.parseInt(readChannel);
            if (parseInt2 < 79900000 || parseInt2 > 89999999) {
                Log.i(TAG, "value=" + parseInt2);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            } else if (readChannel2 == null) {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel value is null");
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            } else if (parseInt2 < 79900000 || parseInt2 > 79999999 || parseInt < 89900000 || parseInt > 89999999) {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel=" + parseInt);
                Log.i(TAG, "Don't need reWrite channel Value");
            } else {
                Log.i(TAG, "old channel=" + parseInt2 + " new channel=" + parseInt);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i(TAG, "use v2 signature");
                    encode2 = readChannelComment.encode();
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, encode2);
                } else {
                    Log.i(TAG, "use v1 signature");
                    encode = readChannelComment.encode();
                    ZipEocdCommentTool.updateComment(str2, encode);
                }
            }
            Log.i(TAG, "final_apk_channel_value=" + readChannel(str2));
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.i(TAG, "writeOldCommentToNewFileWithWhiteListReturnReWriteRes exception!");
            return 1001;
        }
    }
}
