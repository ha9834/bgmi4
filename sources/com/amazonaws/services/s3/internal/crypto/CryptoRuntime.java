package com.amazonaws.services.s3.internal.crypto;

import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class CryptoRuntime {
    private static final String BC_PROVIDER_FQCN = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    static final String BOUNCY_CASTLE_PROVIDER = "BC";

    public static synchronized boolean isBouncyCastleAvailable() {
        boolean z;
        synchronized (CryptoRuntime.class) {
            z = Security.getProvider(BOUNCY_CASTLE_PROVIDER) != null;
        }
        return z;
    }

    public static synchronized void enableBouncyCastle() {
        synchronized (CryptoRuntime.class) {
            if (isBouncyCastleAvailable()) {
                return;
            }
            try {
                Security.addProvider((Provider) Class.forName(BC_PROVIDER_FQCN).newInstance());
            } catch (Exception e) {
                LogFactory.getLog(CryptoRuntime.class).debug("Bouncy Castle not available", e);
            }
        }
    }

    static void recheck() {
        recheckAesGcmAvailablility();
        recheckRsaKeyWrapAvailablility();
    }

    public static boolean isAesGcmAvailable() {
        return AesGcm.isAvailable;
    }

    private static void recheckAesGcmAvailablility() {
        AesGcm.recheck();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRsaKeyWrapAvailable() {
        return RsaEcbOaepWithSHA256AndMGF1Padding.isAvailable;
    }

    private static void recheckRsaKeyWrapAvailablility() {
        RsaEcbOaepWithSHA256AndMGF1Padding.recheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class AesGcm {
        static volatile boolean isAvailable = check();

        private AesGcm() {
        }

        static boolean recheck() {
            isAvailable = check();
            return isAvailable;
        }

        private static boolean check() {
            try {
                Cipher.getInstance(ContentCryptoScheme.AES_GCM.getCipherAlgorithm(), CryptoRuntime.BOUNCY_CASTLE_PROVIDER);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class RsaEcbOaepWithSHA256AndMGF1Padding {
        static volatile boolean isAvailable = check();

        private RsaEcbOaepWithSHA256AndMGF1Padding() {
        }

        static boolean recheck() {
            isAvailable = check();
            return isAvailable;
        }

        private static boolean check() {
            try {
                Cipher.getInstance(S3KeyWrapScheme.RSA_ECB_OAEP_WITH_SHA256_AND_MGF1_PADDING, CryptoRuntime.BOUNCY_CASTLE_PROVIDER);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
