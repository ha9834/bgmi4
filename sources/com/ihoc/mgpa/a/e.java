package com.ihoc.mgpa.a;

/* loaded from: classes2.dex */
public enum e {
    OPEN_ID(0),
    MAIN_VERCODE(1),
    SUB_VERCODE(2),
    TIME_STAMP(3),
    SCENE(4),
    FPS(5),
    FRAME_MISS(6),
    FPS_TARGET(7),
    MODEL_LEVEL(8),
    EFFECT_LEVEL(9),
    HD_MODEL(10),
    USERS_COUNT(11),
    NET_LATENCY(12),
    RECORDING(13),
    URGENT_SIGNAL(14),
    SERVER_IP(15),
    ROLE_STATUS(16),
    CPU_LEVEL(17),
    GPU_LEVEL(18),
    COMMOND_ID(20),
    SCENE_TYPE(40),
    LOAD_CHUNK(41),
    BLOOM_AREA(42),
    MTR(43),
    BROADCAST_TYPE(44),
    LIGHT_THREAD_TID(50),
    THREAD_TID(51),
    RESET_THREAD_TID(5101),
    ROLE_OUTLINE(52),
    PictureStyle(53),
    AntiAliasing(54),
    ServerPort(55),
    SocketType(56),
    Shadow(57),
    Vulkan(58),
    HapticStop(60),
    HapticPattern(63),
    HapticMode(64),
    NET_LATENCY_LEVEL(70),
    NET_LATENCY_LEVEL_CONFIG(71),
    NET_LATENCY_OPT_SCENE(72),
    EVENT_REPORT_PERIOD(73),
    THREAD_MATCH_RULES(74),
    RESOURCE_UPDATE_PROGRESS(75),
    VOICE_STATUS(76),
    TEAM_INFO(77),
    ROOM_INFO(78),
    RESOURCE_UPDATE_KOG(79),
    SPA_CPU_LEVEL(80),
    SPA_GPU_LEVEL(81),
    SPA_TARGET_FPS(82),
    SCENE_IMPORTANCE(83),
    RESOURCE_UPDATE_TITLE(84),
    RESOURCE_UPDATE_ICON(85),
    SDK_VERSION(90),
    STRATEGY_CHECK(10000),
    INVALID(32767);

    private int ga;

    e(int i) {
        this.ga = i;
    }

    public static e a(int i) {
        for (e eVar : values()) {
            if (eVar.a() == i) {
                return eVar;
            }
        }
        return INVALID;
    }

    public int a() {
        return this.ga;
    }

    public String b() {
        return String.valueOf(this.ga);
    }
}
