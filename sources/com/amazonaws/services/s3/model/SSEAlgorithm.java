package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public enum SSEAlgorithm {
    AES256("AES256"),
    KMS("aws:kms");

    private final String algorithm;

    public String getAlgorithm() {
        return this.algorithm;
    }

    SSEAlgorithm(String str) {
        this.algorithm = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.algorithm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SSEAlgorithm fromString(String str) {
        if (str == null) {
            return null;
        }
        for (SSEAlgorithm sSEAlgorithm : values()) {
            if (sSEAlgorithm.getAlgorithm().equals(str)) {
                return sSEAlgorithm;
            }
        }
        throw new IllegalArgumentException("Unsupported algorithm " + str);
    }

    public static SSEAlgorithm getDefault() {
        return AES256;
    }
}
