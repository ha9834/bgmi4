package com.shieldtunnel.svpn.common.k;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public enum a {
        SHA_256(Constants.SHA256);


        /* renamed from: a, reason: collision with root package name */
        final String f5855a;

        a(String str) {
            this.f5855a = str;
        }
    }

    public static byte[] a(a aVar, byte[] bArr) {
        return MessageDigest.getInstance(aVar.f5855a).digest(bArr);
    }
}
