package com.tencent.hawk.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class GpuVendorBase {
    private String gpuVendorName;
    protected int sValidNumber = 0;
    protected Map<String, SeriesParam> seriesMap = new HashMap();
    protected List<String> seriesInOrderList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int checkDeviceClassByGpu(String[] strArr, int[] iArr, int i);

    /* loaded from: classes2.dex */
    protected static class SeriesParam {
        private int[] paramValue;
        private String seriesName;

        SeriesParam(String str, int i) {
            this.seriesName = null;
            this.paramValue = null;
            this.seriesName = str;
            this.paramValue = new int[i];
        }

        public String getSeriesName() {
            return this.seriesName;
        }

        public int[] getParamValue() {
            return this.paramValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValidInt(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        for (int i = 0; i < lowerCase.length(); i++) {
            try {
                if (!Character.isDigit(lowerCase.charAt(i))) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        this.sValidNumber = 0;
        this.sValidNumber = Integer.parseInt(lowerCase);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpuVendorBase(String str, int i) {
        this.gpuVendorName = null;
        this.gpuVendorName = str;
    }

    public void initSeries(List<String> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.seriesMap.put(list.get(i2), new SeriesParam(list.get(i2), i));
            this.seriesInOrderList.add(list.get(i2));
        }
    }

    public Map<String, SeriesParam> getSeriesMap() {
        return this.seriesMap;
    }

    public String getVendorName() {
        return this.gpuVendorName;
    }
}
