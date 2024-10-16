package com.subao.common.n;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class b {
    public static byte[] a(String str, byte[] bArr) {
        return MessageDigest.getInstance(str).digest(bArr);
    }

    public static byte[] a(byte[] bArr) {
        return a(Constants.MD5, bArr);
    }
}
