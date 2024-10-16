package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public enum StorageClass {
    Standard("STANDARD"),
    ReducedRedundancy("REDUCED_REDUNDANCY"),
    Glacier("GLACIER"),
    StandardInfrequentAccess("STANDARD_IA");

    private final String storageClassId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StorageClass fromValue(String str) throws IllegalArgumentException {
        for (StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    StorageClass(String str) {
        this.storageClassId = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.storageClassId;
    }
}
