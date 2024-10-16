package com.ihoc.mgpa.a;

import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.hawk.db.DBInfoMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public enum d {
    SCENEID("SceneID", e.SCENE, 3),
    CURRENTFPS("CurrentFps", e.FPS, 3),
    NETLATENCY("NetLatency", e.NET_LATENCY, 5),
    NETSERVERIP("NetServerIP", e.SERVER_IP, 5),
    MAXFPS("MaxFps", e.FPS_TARGET, 3),
    HDMODE("HDMode", e.HD_MODEL, 1),
    PICTUREQUALITYCURLEVEL("PictureQualityCurLevel", e.MODEL_LEVEL, 1),
    PEOPLENUM("PeopleNum", e.USERS_COUNT, 3),
    KEYTHREAD("KeyThread", e.THREAD_TID, 3),
    STATUS(DBInfoMeta.KEY_Status, null, 2),
    ANTIALIASING("AntiAliasing", e.AntiAliasing, 1),
    RECOMMENDCPULEVEL("RecommendCpuLevel", e.SPA_CPU_LEVEL, 3),
    RECOMMENDGPULEVEL("RecommendGpuLevel", e.SPA_GPU_LEVEL, 3),
    RECOMMENDFPS("RecommendFps", e.SPA_TARGET_FPS, 3),
    APPVERSION(DeviceInfoName.APP_VERSION_STRING, e.MAIN_VERCODE, 0),
    RESOURCEVERSION("ResourceVersion", e.SUB_VERCODE, 0),
    SHADOW("Shadow", e.Shadow, 1),
    IMPORTANTLEVEL("ImportantLevel", e.SCENE_IMPORTANCE, 3),
    SPECIALEFFECT("SpecialEffect", e.BROADCAST_TYPE, 3);

    private String u;
    private e v;
    private int w;

    d(String str, e eVar, int i) {
        this.u = str;
        this.v = eVar;
        this.w = i;
    }

    public static String a(String str) {
        for (d dVar : values()) {
            if (dVar.b() != null && dVar.b().b().equals(str)) {
                return dVar.a();
            }
        }
        return null;
    }

    public static List<Map<String, String>> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 5; i++) {
            arrayList.add(new HashMap());
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int c = c(entry.getKey());
            if (c >= 0 && c <= 5) {
                ((Map) arrayList.get(c)).put(entry.getKey(), entry.getValue());
            }
        }
        return arrayList;
    }

    public static int b(String str) {
        for (d dVar : values()) {
            if (dVar.a().equals(str)) {
                return dVar.c();
            }
        }
        return -1;
    }

    public static int c(String str) {
        for (d dVar : values()) {
            if (dVar.b() != null && dVar.b().b().equals(str)) {
                return dVar.c();
            }
        }
        return -1;
    }

    public String a() {
        return this.u;
    }

    public e b() {
        return this.v;
    }

    public int c() {
        return this.w;
    }
}
