package com.tencent.hawk.bridge;

import com.facebook.appevents.UserDataStore;
import com.tencent.hawk.bridge.GpuVendorBase;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class GpuVendorPowerVR extends GpuVendorBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GpuVendorPowerVR(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.hawk.bridge.GpuVendorBase
    public int checkDeviceClassByGpu(String[] strArr, int[] iArr, int i) {
        int i2;
        int i3 = iArr[0];
        int i4 = 1;
        GpuVendorBase.SeriesParam seriesParam = null;
        String str = "";
        int i5 = 1;
        while (true) {
            if (i5 >= strArr.length) {
                i2 = 0;
                break;
            }
            String str2 = strArr[i5];
            if (str2 != null && str2.length() != 0) {
                if (str.equals("") && seriesParam == null) {
                    Iterator<String> it = this.seriesInOrderList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        HawkLogger.d(next + " == " + str2);
                        if (str2.startsWith(next) && this.seriesMap.containsKey(next)) {
                            seriesParam = this.seriesMap.get(next);
                            str = next;
                            break;
                        }
                    }
                }
                if (!str.equals("") && seriesParam != null) {
                    if (str.equals("gx") || str.equals("g") || str.equals(UserDataStore.GENDER)) {
                        if (str2.length() == str.length()) {
                            HawkLogger.d("token length is equals series");
                            return iArr[0];
                        }
                        if (isValidInt(str2.substring(str.length()))) {
                            i2 = this.sValidNumber;
                            break;
                        }
                    } else if (str.equals("sgx") && isValidInt(str2)) {
                        i2 = this.sValidNumber;
                        break;
                    }
                }
            }
            i5++;
        }
        if (!str.equals("") && seriesParam != null) {
            int[] paramValue = seriesParam.getParamValue();
            if (paramValue == null) {
                return iArr[0];
            }
            for (int i6 = 0; i6 < i && i2 >= paramValue[i6] && i4 < i; i6++) {
                i3 = iArr[i4];
                i4++;
            }
            return i3;
        }
        return iArr[0];
    }
}
