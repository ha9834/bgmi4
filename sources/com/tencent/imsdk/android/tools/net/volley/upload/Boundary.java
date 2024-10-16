package com.tencent.imsdk.android.tools.net.volley.upload;

import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.util.Random;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
class Boundary {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String boundary;
    private final byte[] closingBoundary;
    private final byte[] startingBoundary;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Boundary(String str) {
        str = TextUtils.isEmpty(str) ? generateBoundary() : str;
        this.boundary = str;
        String str2 = "--" + str + APLogFileUtil.SEPARATOR_LINE;
        String str3 = "--" + str + "--" + APLogFileUtil.SEPARATOR_LINE;
        this.startingBoundary = EncodingUtils.getAsciiBytes(str2);
        this.closingBoundary = EncodingUtils.getAsciiBytes(str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBoundary() {
        return this.boundary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getStartingBoundary() {
        return this.startingBoundary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getClosingBoundary() {
        return this.closingBoundary;
    }

    private static String generateBoundary() {
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        StringBuilder sb = new StringBuilder(nextInt);
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }
}
