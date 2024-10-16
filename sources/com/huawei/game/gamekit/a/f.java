package com.huawei.game.gamekit.a;

import com.huawei.game.gamekit.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5466a = "SystemUploadMessage";
    private static final String b = "MessageType";
    private static final int c = 20002;
    private static f d;
    private com.huawei.game.gamekit.a.a e = new a();

    /* loaded from: classes2.dex */
    static class a extends com.huawei.game.gamekit.a.a {
        private Map<String, String> b = new HashMap();

        a() {
            this.b.put("temperature", "TempCurLevel");
            this.b.put("cpu_level", "CpuCurLevel");
            this.b.put("gpu_level", "GpuCurLevel");
            this.b.put("cpu_load", "CpuLoadCurLevel");
            this.b.put("gpu_load", "GpuLoadCurLevel");
            this.b.put("fps_limit", "FpsLimit");
            this.b.put("rpic_set", "RpicSet");
            this.b.put("fps", "Fps");
            this.b.put("frame_drops", "FrameDrops");
            this.b.put("game_overheat", "GameOverHeat");
        }

        @Override // com.huawei.game.gamekit.a.a
        public final Map<String, String> a(String str) {
            return this.b;
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (d == null) {
                d = new f();
            }
            fVar = d;
        }
        return fVar;
    }

    @Override // com.huawei.game.gamekit.a.e
    public final String a(String str, String str2) {
        String str3;
        String str4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.get(next));
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(b, 20002);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    a.C0132a a2 = this.e.a(str, new a.C0132a((String) entry.getKey(), entry.getValue()));
                    if (a2 != null) {
                        jSONObject2.put(a2.f5462a, a2.b);
                    }
                }
                return jSONObject2.toString();
            } catch (JSONException unused) {
                str3 = f5466a;
                str4 = "translateMessage outJson operation exception";
                com.huawei.game.gamekit.b.c.d(str3, str4);
                return str2;
            }
        } catch (JSONException unused2) {
            str3 = f5466a;
            str4 = "translateMessage JSONObject operation exception";
        }
    }
}
