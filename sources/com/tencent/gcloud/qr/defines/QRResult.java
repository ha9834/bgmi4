package com.tencent.gcloud.qr.defines;

/* loaded from: classes2.dex */
public class QRResult {
    private int iTag;
    private String imagePath;
    private int imageType;
    private int retCode;

    public QRResult(int i, int i2, int i3, String str) {
        this.iTag = i;
        this.retCode = i2;
        this.imageType = i3;
        this.imagePath = str;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getImageType() {
        return this.imageType;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getTag() {
        return this.iTag;
    }
}
