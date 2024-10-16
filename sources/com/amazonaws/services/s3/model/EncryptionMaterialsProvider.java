package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public interface EncryptionMaterialsProvider extends EncryptionMaterialsAccessor {
    EncryptionMaterials getEncryptionMaterials();

    void refresh();
}
