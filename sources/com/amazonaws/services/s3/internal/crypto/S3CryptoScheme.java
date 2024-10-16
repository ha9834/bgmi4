package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.services.s3.model.CryptoMode;
import java.security.SecureRandom;

/* loaded from: classes.dex */
final class S3CryptoScheme {
    static final String AES = "AES";
    static final String RSA = "RSA";
    private static final SecureRandom SRAND = new SecureRandom();
    private final ContentCryptoScheme contentCryptoScheme;
    private final S3KeyWrapScheme kwScheme;

    S3CryptoScheme(ContentCryptoScheme contentCryptoScheme) {
        this.contentCryptoScheme = contentCryptoScheme;
        this.kwScheme = new S3KeyWrapScheme();
    }

    private S3CryptoScheme(ContentCryptoScheme contentCryptoScheme, S3KeyWrapScheme s3KeyWrapScheme) {
        this.contentCryptoScheme = contentCryptoScheme;
        this.kwScheme = s3KeyWrapScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecureRandom getSecureRandom() {
        return SRAND;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentCryptoScheme getContentCryptoScheme() {
        return this.contentCryptoScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public S3KeyWrapScheme getKeyWrapScheme() {
        return this.kwScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAesGcm(String str) {
        return ContentCryptoScheme.AES_GCM.getCipherAlgorithm().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static S3CryptoScheme from(CryptoMode cryptoMode) {
        switch (cryptoMode) {
            case EncryptionOnly:
                return new S3CryptoScheme(ContentCryptoScheme.AES_CBC, S3KeyWrapScheme.NONE);
            case AuthenticatedEncryption:
            case StrictAuthenticatedEncryption:
                return new S3CryptoScheme(ContentCryptoScheme.AES_GCM, new S3KeyWrapScheme());
            default:
                throw new IllegalStateException();
        }
    }
}
