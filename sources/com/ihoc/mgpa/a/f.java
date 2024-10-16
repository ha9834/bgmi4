package com.ihoc.mgpa.a;

import com.helpshift.BuildConfig;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.connect.common.Constants;

/* loaded from: classes2.dex */
public enum f {
    UNIQUE_ID("unique_id"),
    UNIQUE_ID3("unique_id3"),
    UNIQUE_ID2("unique_id2"),
    XID(DeviceInfoName.XID_STRING),
    DEBUGID("debug_id"),
    OAID("oaid"),
    OPEN_ID(Constants.JumpUrlConstants.URL_KEY_OPENID),
    VMP_NUMBER("vmp_number"),
    MOBILE_TYPE("mobile_type"),
    SDK_TYPE("sdk_type"),
    CPU_RATE("cpu_rate"),
    USED_MEM("used_mem"),
    BATTERY_TEMP("battery_temp"),
    SOC_TEMP("soc_temp"),
    FPS_AVG("avg_fps"),
    FRAME_MISS_AVG("avg_frame_miss"),
    NET_LATENCY_AVG("avg_net_latency"),
    MAP_ID("map_id"),
    MATCH_STATE("match_state"),
    MATCH_MARK("match_mark"),
    VENDOR_LEVEL("vendor_level"),
    TEMP_LEVEL("temp_level"),
    FPS_LEVEL("fps_level"),
    DYNAMIC_SETTING("dynamic_setting"),
    APM_KEY("apm_key"),
    TIME_RELATIVE("relative_time"),
    TIME_INIT("init_time"),
    TIME_REPORT("report_time"),
    SDK_SUPPORT(BuildConfig.FLAVOR_supportDimension),
    SDK_VENDOR_SUPPORT("vendor_support"),
    SDK_VENDOR_VERSION("vendor_version"),
    SDK_SUPPROT_JP("support1"),
    SDK_SUPPROT_CJ("support2"),
    SDK_SUPPROT_DH("support3"),
    SDK_SUPPROT_XH("support4"),
    SDK_SUPPROT_TP("support5"),
    SDK_SUPPROT_WL("support6"),
    SDK_SUPPORT_SPA("support7"),
    SDK_SCENEID_SUPPORT("scene_support"),
    PERF_SDKFUC_OPEN_STR("perf_func_open"),
    SDKFUNC_OPEN("func_open"),
    SCENE_OPEN("open_scene"),
    CALLBACK_OPEN("open_callback"),
    THREAD_OPEN("open_thread"),
    LIGHT_THREAD_OPEN("open_light_thread"),
    USER_COUNT_OPEN("open_user_count"),
    NET_LATENCY_OPEN("open_net_latency"),
    FPS_OPEN("open_fps"),
    FPS_REPORT_OPEN("open_fps_report"),
    DEVICE_CHECK_OPEN("open_device_check"),
    PREDOWNLOAD_OPEN("open_predownload"),
    UNIQUEID_OPEN("open_uniqueid"),
    SAFEUNIQUEID_OPEN("open_safeid"),
    TRANSCEIVER_OPEN("open_transceiver"),
    OPTCONFIG_OPEN("open_optcfg"),
    SSPFUNC_OPEN("open_ssp"),
    SSPREPORT_OPEN("open_ssp_report"),
    SCENETRANSFORM_OPEN("open_scene_trans"),
    SCENECONTROL_OPEN("open_scene_control"),
    HAPTIC_OPEN("open_haptic"),
    NET_LATENCY_OPT_SCENE("open_5g_scene");

    private String ka;

    f(String str) {
        this.ka = str;
    }

    public String a() {
        return this.ka;
    }
}
