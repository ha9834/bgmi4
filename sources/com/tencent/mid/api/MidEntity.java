package com.tencent.mid.api;

import com.tencent.mid.util.Util;
import com.tencent.mid.util.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MidEntity {
    public static final String TAG_GUID = "guid";
    public static final String TAG_IMEI = "imei";
    public static final String TAG_IMSI = "imsi";
    public static final String TAG_MAC = "mac";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VER = "ver";
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_NEW = 2;

    /* renamed from: a, reason: collision with root package name */
    private static d f6258a = Util.getLogger();
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = "0";
    private long f = 0;
    private int g = 0;
    private long h = 0;

    public long getGuid() {
        return this.h;
    }

    public void setGuid(long j) {
        this.h = j;
    }

    public int getVersion() {
        return this.g;
    }

    public void setVersion(int i) {
        this.g = i;
    }

    public long getTimestamps() {
        return this.f;
    }

    public void setTimestamps(long j) {
        this.f = j;
    }

    public boolean isMidValid() {
        return Util.isMidValid(this.e);
    }

    public static MidEntity parse(String str) {
        MidEntity midEntity = new MidEntity();
        if (Util.isStringValid(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(TAG_IMEI)) {
                    midEntity.setImei(jSONObject.getString(TAG_IMEI));
                }
                if (!jSONObject.isNull(TAG_IMSI)) {
                    midEntity.setImsi(jSONObject.getString(TAG_IMSI));
                }
                if (!jSONObject.isNull(TAG_MAC)) {
                    midEntity.setMac(jSONObject.getString(TAG_MAC));
                }
                if (!jSONObject.isNull("mid")) {
                    midEntity.setMid(jSONObject.getString("mid"));
                }
                if (!jSONObject.isNull("ts")) {
                    midEntity.setTimestamps(jSONObject.getLong("ts"));
                }
                if (!jSONObject.isNull(TAG_VER)) {
                    midEntity.g = jSONObject.optInt(TAG_VER, 0);
                }
                if (!jSONObject.isNull("guid")) {
                    midEntity.h = jSONObject.optLong("guid", 0L);
                }
            } catch (JSONException e) {
                f6258a.d(e.toString());
            }
        }
        return midEntity;
    }

    public int compairTo(MidEntity midEntity) {
        if (midEntity == null) {
            return 1;
        }
        if (!isMidValid() || !midEntity.isMidValid()) {
            return isMidValid() ? 1 : -1;
        }
        if (this.e.equals(midEntity.e)) {
            return 0;
        }
        return this.f >= midEntity.f ? 1 : -1;
    }

    public String toString() {
        return a().toString();
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Util.jsonPut(jSONObject, TAG_IMEI, this.b);
            Util.jsonPut(jSONObject, TAG_IMSI, this.c);
            Util.jsonPut(jSONObject, TAG_MAC, this.d);
            Util.jsonPut(jSONObject, "mid", this.e);
            try {
                jSONObject.put("guid", this.h);
            } catch (Throwable unused) {
            }
            jSONObject.put("ts", this.f);
        } catch (JSONException e) {
            f6258a.d(e.toString());
        }
        return jSONObject;
    }

    public String getMid() {
        return this.e;
    }

    public void setMid(String str) {
        this.e = str;
    }

    public String getImei() {
        return this.b;
    }

    public void setImei(String str) {
        this.b = str;
    }

    public String getImsi() {
        return this.c;
    }

    public void setImsi(String str) {
        this.c = str;
    }

    public String getMac() {
        return this.d;
    }

    public void setMac(String str) {
        this.d = str;
    }
}
