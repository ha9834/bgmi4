package com.tencent.ieg.gpc.globalization.base.uploader;

import com.tencent.ieg.gpc.globalization.base.GGResult;

/* loaded from: classes2.dex */
public class GGUploadResult extends GGResult {
    public String fileUrl;

    public GGUploadResult(int i, String str) {
        super(i, str);
        this.fileUrl = "";
    }

    @Override // com.tencent.ieg.gpc.globalization.base.GGResult
    public String toJasonString() {
        return "{\"code\" : " + String.valueOf(this.code) + ", \"msg\": \"" + this.msg + "\", \"fileUrl\": \"" + this.fileUrl + "\"}";
    }
}
