package com.tencent.hawk.bridge;

import com.tencent.hawk.bridge.GpuVendorBase;

/* loaded from: classes2.dex */
public class GpuVendorTegra extends GpuVendorBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GpuVendorTegra(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.hawk.bridge.GpuVendorBase
    public int checkDeviceClassByGpu(String[] strArr, int[] iArr, int i) {
        GpuVendorBase.SeriesParam seriesParam;
        int i2 = iArr[0];
        int i3 = 1;
        int i4 = 1;
        while (true) {
            if (i4 >= strArr.length) {
                seriesParam = null;
                break;
            }
            String str = strArr[i4];
            if (this.seriesMap.containsKey(str)) {
                seriesParam = this.seriesMap.get(str);
                break;
            }
            i4++;
        }
        if (seriesParam == null) {
            return iArr[0];
        }
        int[] paramValue = seriesParam.getParamValue();
        if (paramValue == null) {
            return iArr[0];
        }
        for (int i5 = 0; i5 < i && paramValue[i5] <= 0 && i3 < i; i5++) {
            i2 = iArr[i3];
            i3++;
        }
        return i2;
    }
}
