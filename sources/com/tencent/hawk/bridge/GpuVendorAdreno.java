package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class GpuVendorAdreno extends GpuVendorBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GpuVendorAdreno(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.hawk.bridge.GpuVendorBase
    public int checkDeviceClassByGpu(String[] strArr, int[] iArr, int i) {
        int i2 = iArr[0];
        int i3 = 1;
        for (int i4 = 1; i4 < strArr.length; i4++) {
            if (isValidInt(strArr[i4])) {
                int i5 = this.sValidNumber;
                int i6 = (i5 / 100) * 100;
                if (this.seriesMap != null && this.seriesMap.containsKey(String.valueOf(i6))) {
                    int[] paramValue = this.seriesMap.get(String.valueOf(i6)).getParamValue();
                    if (paramValue == null) {
                        return iArr[0];
                    }
                    for (int i7 = 0; i7 < i && i5 >= paramValue[i7] && i3 < i; i7++) {
                        i2 = iArr[i3];
                        i3++;
                    }
                    return i2;
                }
                return iArr[i - 1];
            }
        }
        return iArr[0];
    }
}
