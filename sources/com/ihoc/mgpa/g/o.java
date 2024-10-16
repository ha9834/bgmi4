package com.ihoc.mgpa.g;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static volatile o f5573a;
    public b b = new b();
    public a c = new a();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public E f5574a;
        public D b;
        public A c;
        public p d;
        public B e;
        public C0245b f;
        public z g;
        public w h;
        public r i;
        public l j;
        public n k;
        public j l;
        public s m;
        public C n;
        public C0246c o;
        public q p;
        public String q;
        public int r;
        public int s;
        public k t;
        public C0247d u;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5575a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public boolean m = false;
        public boolean n = false;
        public boolean o = false;
        public boolean p = false;
        public boolean q = false;
        public boolean r = false;
        public boolean s = false;
        public boolean t = false;
        public boolean u = false;
        public boolean v = false;
        public boolean w = false;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;
        public boolean A = false;
        public boolean B = false;
        public boolean C = false;
        public boolean D = true;
        public boolean E = false;
        public boolean F = false;
        public boolean G = false;
        public boolean H = true;
        public boolean I = true;
        public boolean J = false;
        public boolean K = false;
        public boolean L = false;
        public boolean M = false;
        public boolean N = false;
        public boolean O = false;
        public boolean P = false;
        public boolean Q = false;
        public boolean R = false;

        public String toString() {
            return "Feature{globalSwitch=" + this.f5575a + ", debugMode=" + this.b + ", logUpload=" + this.c + ", reportAll=" + this.d + ", registerCallback=" + this.e + ", checkCpuCoreLock=" + this.f + ", heavyThreadBind=" + this.g + ", lightThreadBind=" + this.h + ", cpuApply=" + this.i + ", gpuApply=" + this.j + ", netLatency=" + this.k + ", screenUser=" + this.l + ", preTransceiver=" + this.m + ", transceiver=" + this.n + ", transceiverSignalpipe=" + this.o + ", deviceCheck=" + this.p + ", romVersionReport=" + this.q + ", preDownload=" + this.r + ", sceneToVendor=" + this.s + ", sceneTransform=" + this.t + ", sceneType=" + this.u + ", optCfg=" + this.v + ", spa=" + this.w + ", spaReport=" + this.x + ", fpsStrategy=" + this.y + ", notchProbe=" + this.z + ", vendorUniqueIdReport=" + this.A + ", uniqueIdReport=" + this.B + ", safeUniqueIdReport=" + this.C + ", vendorOAIDReport=" + this.D + ", debugIdReport=" + this.E + ", predownFileCheck=" + this.F + ", threadAffinitySet=" + this.G + ", commonHaptic=" + this.H + ", richTap=" + this.I + ", useNoneRichTap=" + this.J + ", turingShield=" + this.K + ", netLatencyProbe=" + this.L + ", reportException=" + this.M + ", dataForward=" + this.N + ", backgroundDownload=" + this.O + ", bgPreDownload=" + this.Q + ", bgCloseNotifyInFore=" + this.P + ", isAutoCopyPreFile=" + this.R + '}';
        }
    }

    private o() {
    }

    public static o b() {
        if (f5573a == null) {
            synchronized (o.class) {
                if (f5573a == null) {
                    f5573a = new o();
                }
            }
        }
        return f5573a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 1469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.g.o.a(org.json.JSONObject):int");
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        try {
            for (Field field : this.b.getClass().getDeclaredFields()) {
                hashMap.put(field.getName(), field.getBoolean(this.b) ? "1" : "0");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
        return hashMap;
    }
}
