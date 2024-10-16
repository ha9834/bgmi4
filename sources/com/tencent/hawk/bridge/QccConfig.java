package com.tencent.hawk.bridge;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.hawk.bridge.QCCJudgerMultiVersion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class QccConfig {
    private static final int OPT_CPUCORES = 9;
    private static final int OPT_CPUFREQ = 8;
    private static final int OPT_EMULATOR = 1;
    private static final int OPT_FILTER_GPU = 3;
    private static final int OPT_FILTER_MANU = 5;
    private static final int OPT_FILTER_MODEL = 2;
    private static final int OPT_FILTER_SOC = 4;
    private static final int OPT_GPU = 10;
    private static final int OPT_RAM = 7;
    private static final int OPT_RESOLUTION = 6;
    private QCCFilter modelFilter = null;
    private QCCFilter gpuFilter = null;
    private QCCFilter socFilter = null;
    private QCCFilter manuFilter = null;
    private Map<String, GpuVendorBase> gpuVendorMap = null;
    private List<String> classValueDefList = null;
    private int[] classValueDefInts = null;
    private boolean initCtxFlag = false;
    private int switchOpts = 0;
    private int andOpts = 0;
    private int emulatorQuality = 0;
    private int classLevelNum = 0;
    private int[] intParamsRam = null;
    private int[] intParamsResolution = null;
    private int[] intParamsCpuFreq = null;
    private int[] intParamsCpuCore = null;
    private boolean enableRegex = false;

    private void initContinerByClsSz(int i) {
        this.classLevelNum = i;
        this.modelFilter = new QCCFilter();
        this.gpuFilter = new QCCFilter();
        this.socFilter = new QCCFilter();
        this.manuFilter = new QCCFilter();
        this.intParamsRam = new int[i];
        this.intParamsResolution = new int[i];
        this.intParamsCpuFreq = new int[i];
        this.intParamsCpuCore = new int[i];
        this.classValueDefList = new ArrayList();
        this.classValueDefInts = new int[i];
        this.gpuVendorMap = new HashMap();
        this.gpuVendorMap.put("adreno", new GpuVendorAdreno("adreno", i));
        this.gpuVendorMap.put("mali", new GpuVendorMali("mali", i));
        this.gpuVendorMap.put("powervr", new GpuVendorPowerVR("powervr", i));
        this.gpuVendorMap.put("tegra", new GpuVendorTegra("tegra", i));
    }

    public boolean parseQccConfig(JsonReader jsonReader) throws IOException {
        try {
            jsonReader.beginObject();
            while (true) {
                boolean z = true;
                if (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    HawkLogger.d("parse: " + nextName);
                    if ("classLevelNum".equals(nextName)) {
                        this.classLevelNum = jsonReader.nextInt();
                        initContinerByClsSz(this.classLevelNum);
                        this.initCtxFlag = true;
                    } else if ("classLevelValues".equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        if (!this.classValueDefList.isEmpty()) {
                            this.classValueDefList.clear();
                        }
                        this.classValueDefInts = null;
                        this.classValueDefInts = new int[this.classLevelNum];
                        readIntArray(jsonReader, this.classValueDefInts, this.classLevelNum);
                        for (int i : this.classValueDefInts) {
                            this.classValueDefList.add(String.valueOf(i));
                            this.modelFilter.getFilterMap().put(String.valueOf(i), new ArrayList());
                            this.gpuFilter.getFilterMap().put(String.valueOf(i), new ArrayList());
                            this.socFilter.getFilterMap().put(String.valueOf(i), new ArrayList());
                            this.manuFilter.getFilterMap().put(String.valueOf(i), new ArrayList());
                        }
                    } else if ("switchops".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        this.switchOpts = jsonReader.nextInt();
                    } else if ("andopts".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        this.andOpts = jsonReader.nextInt();
                    } else if ("emulator".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        this.emulatorQuality = jsonReader.nextInt();
                    } else if ("regex".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        if (jsonReader.nextInt() != 1) {
                            z = false;
                        }
                        this.enableRegex = z;
                    } else if ("filter-model".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readFilterInfo(jsonReader, this.modelFilter);
                    } else if ("filter-gpu".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readFilterInfo(jsonReader, this.gpuFilter);
                    } else if ("filter-soc".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readFilterInfo(jsonReader, this.socFilter);
                    } else if ("filter-manu".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readFilterInfo(jsonReader, this.manuFilter);
                    } else if ("resolution".equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readIntArray(jsonReader, this.intParamsResolution, this.classLevelNum - 1);
                    } else if ("ram".equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readIntArray(jsonReader, this.intParamsRam, this.classLevelNum - 1);
                    } else if ("cpufreq".equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readIntArray(jsonReader, this.intParamsCpuFreq, this.classLevelNum - 1);
                    } else if ("cpucores".equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        readIntArray(jsonReader, this.intParamsCpuCore, this.classLevelNum - 1);
                    } else if ("gpu_vendor".equals(nextName)) {
                        if (!this.initCtxFlag) {
                            HawkLogger.e("ctx not initialized,return");
                            return false;
                        }
                        parseGPU(jsonReader);
                    } else {
                        HawkLogger.e("skip value : " + nextName);
                        jsonReader.skipValue();
                    }
                } else {
                    HawkLogger.e("parse qcc finished");
                    jsonReader.endObject();
                    return this.initCtxFlag;
                }
            }
        } catch (Exception e) {
            HawkLogger.e("Exception occured: " + e.getMessage());
            String message = e.getMessage();
            if (message == null) {
                EventDispatcher.dispatchEvent(1013, Constant.APM_CFG_GPU_NA);
            } else if (message.length() > 32) {
                EventDispatcher.dispatchEvent(1013, message.substring(0, 31));
            } else {
                EventDispatcher.dispatchEvent(1013, message);
            }
            return false;
        }
    }

    private void parseGPU(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            HawkLogger.d("gpu vendor: " + nextName);
            if (this.gpuVendorMap.containsKey(nextName)) {
                parseGPUSeriesParams(jsonReader, nextName, this.gpuVendorMap.get(nextName), this.classLevelNum);
            } else {
                throw new IOException("gpuvendror not exists");
            }
        }
        jsonReader.endObject();
    }

    private void parseGPUSeriesParams(JsonReader jsonReader, String str, GpuVendorBase gpuVendorBase, int i) throws IOException {
        jsonReader.beginObject();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("series") && jsonReader.peek() != JsonToken.NULL) {
                HawkLogger.d("read series");
                readStringArray(jsonReader, arrayList);
                gpuVendorBase.initSeries(arrayList, i);
            } else if (arrayList.contains(nextName) && jsonReader.peek() != JsonToken.NULL) {
                if (gpuVendorBase.seriesMap.containsKey(nextName)) {
                    readIntArray(jsonReader, gpuVendorBase.seriesMap.get(nextName).getParamValue(), i - 1);
                } else {
                    throw new IOException("bad series");
                }
            } else {
                HawkLogger.e("gpu skip values: " + nextName);
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private void readIntArray(JsonReader jsonReader, int[] iArr, int i) throws IOException {
        jsonReader.beginArray();
        int i2 = 0;
        while (jsonReader.hasNext()) {
            if (i2 < i) {
                iArr[i2] = jsonReader.nextInt();
                i2++;
            } else {
                jsonReader.nextInt();
            }
        }
        jsonReader.endArray();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("intarray: ");
        for (int i3 : iArr) {
            stringBuffer.append(String.valueOf(i3) + "|");
        }
        HawkLogger.d(stringBuffer.toString());
    }

    private void readStringArray(JsonReader jsonReader, List<String> list) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String nextString = jsonReader.nextString();
            if (nextString != null) {
                list.add(nextString.trim().toLowerCase(Locale.ENGLISH));
                stringBuffer.append(nextString + "-");
            }
        }
        HawkLogger.d("strarray: " + stringBuffer.toString());
        jsonReader.endArray();
    }

    private void readFilterInfo(JsonReader jsonReader, QCCFilter qCCFilter) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            HawkLogger.d("filter-key-name " + nextName);
            List<String> targetCategoryFilter = qCCFilter.getTargetCategoryFilter(nextName);
            if (targetCategoryFilter == null) {
                throw new IOException("bad category :" + nextName);
            }
            Iterator<String> it = this.classValueDefList.iterator();
            while (it.hasNext()) {
                if (nextName.equals(it.next()) && jsonReader.peek() != JsonToken.NULL) {
                    readStringArray(jsonReader, targetCategoryFilter);
                }
            }
        }
        jsonReader.endObject();
    }

    private boolean isOptEnable(int i) {
        return ((this.switchOpts >> (i - 1)) & 1) == 1;
    }

    private boolean isAndEnable(int i) {
        return ((this.andOpts >> (i - 1)) & 1) == 1;
    }

    public static boolean isEmulator(String str, String str2) {
        if (str == null || str2 == null || str.equals(Constant.APM_CFG_GPU_NA) || str2.equals(Constant.APM_CFG_GPU_NA)) {
            return false;
        }
        HawkLogger.d("vender : " + str + " renderer:" + str2);
        return HawkNative.checkEmulator(str, str2) > 1;
    }

    private String getFilterMatch(QCCFilter qCCFilter, String str) {
        if (qCCFilter == null || qCCFilter.getFilterMap() == null || str == null) {
            HawkLogger.d("filter is null");
            return null;
        }
        String str2 = null;
        for (Map.Entry<String, List<String>> entry : qCCFilter.getFilterMap().entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null && !value.isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str3 : value) {
                    if (str3 != null && !TextUtils.isEmpty(str3)) {
                        stringBuffer.append(str3 + "-");
                        if (this.enableRegex) {
                            Pattern compile = Pattern.compile(str3);
                            if (compile == null) {
                                HawkLogger.e("Pattern is null");
                            } else {
                                Matcher matcher = compile.matcher(str);
                                if (matcher == null) {
                                    HawkLogger.e("Matcher is null");
                                } else if (matcher.matches()) {
                                    HawkLogger.d("regex matches");
                                    str2 = key;
                                    break;
                                }
                            }
                        } else if (str.contains(str3.trim().toLowerCase(Locale.ENGLISH))) {
                            str2 = key;
                            break;
                        }
                    }
                }
                HawkLogger.d("fv: " + stringBuffer.toString());
                if (str2 != null) {
                    break;
                }
            }
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    private int getAndValue(int[] iArr, int i, int[] iArr2, int i2) {
        if (iArr == null) {
            return iArr2[0];
        }
        int i3 = iArr2[0];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 : iArr) {
            stringBuffer.append(String.valueOf(i4));
        }
        HawkLogger.d(stringBuffer.toString());
        int length = iArr.length;
        int i5 = 1;
        for (int i6 = 0; i6 < length && i >= iArr[i6] && i5 < i2; i6++) {
            i3 = iArr2[i5];
            i5++;
        }
        return i3;
    }

    private int judgleGPU(String str) {
        if (str == null) {
            return this.classValueDefInts[0];
        }
        String[] split = str.toLowerCase(Locale.ENGLISH).split("\\s|-|\\.|\\+|\\t|:");
        if (split == null || split.length == 0) {
            return this.classValueDefInts[0];
        }
        if (split[0].contains("vivante")) {
            return this.classValueDefInts[0];
        }
        if (split[0].contains("adreno")) {
            HawkLogger.d("in check adreno");
            if (!this.gpuVendorMap.containsKey("adreno")) {
                HawkLogger.d("contains null, return");
                return this.classValueDefInts[0];
            }
            return this.gpuVendorMap.get("adreno").checkDeviceClassByGpu(split, this.classValueDefInts, this.classLevelNum);
        }
        if (split[0].contains("powervr") || split[0].contains("imagination") || split[0].contains("sgx")) {
            HawkLogger.d("in check powervr");
            if (!this.gpuVendorMap.containsKey("powervr")) {
                HawkLogger.d("powervr null, return");
                return this.classValueDefInts[0];
            }
            return this.gpuVendorMap.get("powervr").checkDeviceClassByGpu(split, this.classValueDefInts, this.classLevelNum);
        }
        if (split[0].contains("arm") || split[0].contains("mali") || (split.length > 1 && split[1].contains("mali"))) {
            HawkLogger.d("in check mali");
            if (!this.gpuVendorMap.containsKey("mali")) {
                HawkLogger.d("mali null, return");
                return this.classValueDefInts[0];
            }
            return this.gpuVendorMap.get("mali").checkDeviceClassByGpu(split, this.classValueDefInts, this.classLevelNum);
        }
        if (split[0].contains("tegra") || split[0].contains("nvidia")) {
            HawkLogger.d("in check tegra");
            if (!this.gpuVendorMap.containsKey("tegra")) {
                HawkLogger.d("tegra null, return");
                return this.classValueDefInts[0];
            }
            return this.gpuVendorMap.get("tegra").checkDeviceClassByGpu(split, this.classValueDefInts, this.classLevelNum);
        }
        return this.classValueDefInts[0];
    }

    public int judgeDcls(QCCJudgerMultiVersion.QCCParam qCCParam) {
        if (!this.initCtxFlag) {
            HawkLogger.e("ctx not initialized, return");
            return 0;
        }
        if (Build.VERSION.SDK_INT < 11) {
            HawkLogger.w("current sdk level under honeyComb, return");
            return 0;
        }
        if (this.switchOpts == 0) {
            HawkLogger.e("switch opts is 0, return");
            return 0;
        }
        if (isOptEnable(1) && isEmulator(qCCParam.gpuVendor, qCCParam.gpuRenderer)) {
            HawkLogger.d("emulator, return default");
            return this.emulatorQuality;
        }
        if (this.classValueDefInts == null) {
            HawkLogger.d("default class value is null");
            return 0;
        }
        if (isOptEnable(2)) {
            HawkLogger.d("try to match filter model");
            String filterMatch = getFilterMatch(this.modelFilter, qCCParam.model);
            if (filterMatch != null) {
                try {
                    HawkLogger.d("filter model match");
                    return Integer.parseInt(filterMatch);
                } catch (Exception unused) {
                }
            }
        }
        if (isOptEnable(3)) {
            HawkLogger.d("try to match filter gpu");
            String filterMatch2 = getFilterMatch(this.gpuFilter, qCCParam.gpuRenderer);
            if (filterMatch2 != null) {
                try {
                    HawkLogger.d("filter gpu match");
                    return Integer.parseInt(filterMatch2);
                } catch (Exception unused2) {
                }
            }
        }
        if (isOptEnable(4)) {
            HawkLogger.d("try to match filter soc");
            String filterMatch3 = getFilterMatch(this.socFilter, qCCParam.socPlat);
            if (filterMatch3 != null) {
                try {
                    HawkLogger.d("filter soc match");
                    return Integer.parseInt(filterMatch3);
                } catch (Exception unused3) {
                }
            }
        }
        if (isOptEnable(5)) {
            HawkLogger.d("try to match filter manu");
            String filterMatch4 = getFilterMatch(this.manuFilter, qCCParam.manu);
            if (filterMatch4 != null) {
                try {
                    HawkLogger.d("filter manu match");
                    return Integer.parseInt(filterMatch4);
                } catch (Exception unused4) {
                }
            }
        }
        HawkLogger.d("begin and values calculation, levelnums: " + this.classLevelNum);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : this.classValueDefInts) {
            stringBuffer.append(String.valueOf(i) + "-");
        }
        HawkLogger.d("def values : " + stringBuffer.toString());
        if (isOptEnable(6) && isAndEnable(6)) {
            HawkLogger.d("in OPT_RESOLUTION");
            int andValue = getAndValue(this.intParamsResolution, qCCParam.resolution, this.classValueDefInts, this.classLevelNum);
            HawkLogger.d("PRE OPT_RESOLUTION: " + andValue);
            r2 = 99 >= andValue ? andValue : 99;
            HawkLogger.d("OPT_RESOLUTION: " + r2);
        }
        if (isOptEnable(7) && isAndEnable(7)) {
            HawkLogger.d("in OPT_RAM " + qCCParam.ram);
            int andValue2 = getAndValue(this.intParamsRam, qCCParam.ram, this.classValueDefInts, this.classLevelNum);
            HawkLogger.d("PRE OPT_RAM: " + andValue2);
            if (r2 >= andValue2) {
                r2 = andValue2;
            }
            HawkLogger.d("OPT_RAM: " + r2);
        }
        if (isOptEnable(8) && isAndEnable(8)) {
            HawkLogger.d("in OPT_CPUFREQ");
            int andValue3 = getAndValue(this.intParamsCpuFreq, qCCParam.cpuFreq, this.classValueDefInts, this.classLevelNum);
            HawkLogger.d("PRE OPT_CPUFREQ: " + andValue3);
            if (r2 >= andValue3) {
                r2 = andValue3;
            }
            HawkLogger.d("OPT_CPUFREQ: " + r2);
        }
        if (isOptEnable(9) && isAndEnable(9)) {
            HawkLogger.d("in OPT_CPUCORES");
            int andValue4 = getAndValue(this.intParamsCpuCore, qCCParam.cpuCore, this.classValueDefInts, this.classLevelNum);
            HawkLogger.d("PRE OPT_CPUCORES: " + andValue4);
            if (r2 >= andValue4) {
                r2 = andValue4;
            }
            HawkLogger.d("OPT_CPUCORES: " + r2);
        }
        if (isOptEnable(10) && isAndEnable(10)) {
            HawkLogger.d("in OPT_GPU");
            int judgleGPU = judgleGPU(qCCParam.gpuRenderer);
            HawkLogger.d("PRE OPT_GPU: " + judgleGPU);
            if (r2 >= judgleGPU) {
                r2 = judgleGPU;
            }
            HawkLogger.d("OPT_GPU: " + r2);
        }
        int[] iArr = this.classValueDefInts;
        return r2 > iArr[this.classLevelNum - 1] ? iArr[0] : r2;
    }
}
