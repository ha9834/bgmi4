package com.ihoc.mgpa.g;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5572a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public float q;
    public int r;

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f5572a = jSONObject.getBoolean("available");
            this.b = jSONObject.getInt("fpsMiniCount");
            this.c = jSONObject.getInt("headReduce");
            this.d = jSONObject.getInt("tailReduce");
            this.e = jSONObject.getInt("section");
            this.f = jSONObject.getInt("variance");
            this.g = (float) jSONObject.getDouble("varianceFactor");
            this.h = jSONObject.getInt("maxVarianceScore");
            this.i = jSONObject.getInt("fpsLow");
            this.j = jSONObject.getInt("lowFactor");
            this.k = jSONObject.getInt("fpsMiddle");
            this.l = jSONObject.getInt("middleFactor1");
            this.m = jSONObject.getInt("middleFactor2");
            this.n = jSONObject.getInt("highFactor1");
            this.o = jSONObject.getInt("highFactor2");
            this.p = jSONObject.getInt("factorMaxValue");
            this.q = (float) jSONObject.getDouble("factorMultiValue");
            this.r = jSONObject.getInt("goodScore");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
