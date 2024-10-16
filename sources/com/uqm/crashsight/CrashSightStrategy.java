package com.uqm.crashsight;

import android.content.Context;
import com.tencent.mtt.engine.http.HttpUtils;
import com.uqm.crashsight.crashreport.biz.UserInfoBean;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.crashreport.common.info.c;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import com.uqm.crashsight.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CrashSightStrategy {
    private String d;
    private String e;
    private String f;
    private long g;
    private String h;
    private String i;
    private a s;
    private boolean j = true;
    private boolean k = true;
    private boolean l = false;
    private boolean m = true;
    private Class<?> n = null;
    private boolean o = true;
    private boolean p = true;
    private boolean q = true;
    private boolean r = false;

    /* renamed from: a, reason: collision with root package name */
    protected int f6545a = 31;
    protected boolean b = false;
    protected int c = 2;

    public synchronized CrashSightStrategy setCrashSightLogUpload(boolean z) {
        this.o = z;
        return this;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_LENGTH = 131072;
        public static final int MAX_USERDATA_VALUE_LENGTH = 131072;

        public static SightPkg.SummaryInfo encodeSummaryInfo$734a2b33(UserInfoBean userInfoBean) {
            if (userInfoBean == null) {
                return null;
            }
            String i = com.uqm.crashsight.crashreport.common.info.a.b().i();
            SightPkg.SummaryInfo.Builder userId = SightPkg.SummaryInfo.newBuilder().setStartTime(userInfoBean.e).setSessionId(userInfoBean.j == null ? "" : userInfoBean.j).setProceName(userInfoBean.c == null ? "" : userInfoBean.c).setUserId(userInfoBean.d == null ? "" : userInfoBean.d);
            if (i == null) {
                i = "";
            }
            SightPkg.SummaryInfo.Builder coldStart = userId.setGatewayIp(i).setColdStart(userInfoBean.o == 1);
            switch (userInfoBean.b) {
                case 1:
                    coldStart.setStartType(1);
                    break;
                case 2:
                    coldStart.setStartType(4);
                    break;
                case 3:
                    coldStart.setStartType(2);
                    break;
                case 4:
                    coldStart.setStartType(3);
                    break;
                case 5:
                    coldStart.setStartType(8);
                    break;
                default:
                    if (userInfoBean.b >= 10 && userInfoBean.b < 20) {
                        coldStart.setStartType(userInfoBean.b);
                        break;
                    } else {
                        m.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
                        return null;
                    }
            }
            coldStart.clearValueMap();
            if (userInfoBean.p >= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(userInfoBean.p);
                coldStart.putValueMap("C01", sb.toString());
            }
            if (userInfoBean.q >= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(userInfoBean.q);
                coldStart.putValueMap("C02", sb2.toString());
            }
            if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
                for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                    coldStart.putValueMap("C03_" + entry.getKey(), entry.getValue());
                }
            }
            if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
                for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                    coldStart.putValueMap("C04_" + entry2.getKey(), entry2.getValue());
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(!userInfoBean.l);
            coldStart.putValueMap("A36", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(userInfoBean.g);
            coldStart.putValueMap("F02", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(userInfoBean.h);
            coldStart.putValueMap("F03", sb5.toString());
            coldStart.putValueMap("F04", userInfoBean.j);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(userInfoBean.i);
            coldStart.putValueMap("F05", sb6.toString());
            coldStart.putValueMap("F06", userInfoBean.m);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(userInfoBean.k);
            coldStart.putValueMap("F10", sb7.toString());
            SightPkg.SummaryInfo build = coldStart.h();
            m.c("summary type %d vm:%d", Integer.valueOf(build.getStartType()), Integer.valueOf(build.getValueMapCount()));
            return build;
        }

        public static SightPkg.UserInfoPackage encodeUserInfoPackage(List<UserInfoBean> list, int i) {
            com.uqm.crashsight.crashreport.common.info.a b;
            if (list == null || list.size() == 0 || (b = com.uqm.crashsight.crashreport.common.info.a.b()) == null) {
                return null;
            }
            b.s();
            SightPkg.UserInfoPackage.Builder newBuilder = SightPkg.UserInfoPackage.newBuilder();
            newBuilder.setProceName(b.d);
            newBuilder.setDeviceId(b.h());
            ArrayList arrayList = new ArrayList();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                SightPkg.SummaryInfo encodeSummaryInfo$734a2b33 = encodeSummaryInfo$734a2b33(it.next());
                if (encodeSummaryInfo$734a2b33 != null) {
                    arrayList.add(encodeSummaryInfo$734a2b33);
                }
            }
            newBuilder.addAllList(arrayList);
            newBuilder.putValueMap("A7", b.g);
            newBuilder.putValueMap("A6", b.r());
            newBuilder.putValueMap("A5", b.q());
            StringBuilder sb = new StringBuilder();
            sb.append(b.n());
            newBuilder.putValueMap("A2", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.o());
            newBuilder.putValueMap("A1", sb2.toString());
            newBuilder.putValueMap("A24", b.i);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b.p());
            newBuilder.putValueMap("A17", sb3.toString());
            newBuilder.putValueMap("A15", b.u());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b.v());
            newBuilder.putValueMap("A13", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b.K());
            newBuilder.putValueMap("pss", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(b.L());
            newBuilder.putValueMap("vss", sb6.toString());
            newBuilder.putValueMap("F08", b.w);
            newBuilder.putValueMap("F09", b.x);
            Map<String, String> C = b.C();
            if (C != null && C.size() > 0) {
                for (Map.Entry<String, String> entry : C.entrySet()) {
                    newBuilder.putValueMap("C04_" + entry.getKey(), entry.getValue());
                }
            }
            switch (i) {
                case 1:
                    newBuilder.setType(1);
                    break;
                case 2:
                    newBuilder.setType(2);
                    break;
                default:
                    m.e("unknown up type %d ", Integer.valueOf(i));
                    return null;
            }
            return (SightPkg.UserInfoPackage) newBuilder.h();
        }

        public static SightPkg.RequestPkg encode2RequestPkg(Context context, int i, byte[] bArr) {
            com.uqm.crashsight.crashreport.common.info.a b = com.uqm.crashsight.crashreport.common.info.a.b();
            StrategyBean c = com.uqm.crashsight.crashreport.common.strategy.a.a().c();
            if (b == null || c == null) {
                m.e("Can not create request pkg for parameters is invalid.", new Object[0]);
                return null;
            }
            try {
                SightPkg.RequestPkg.Builder newBuilder = SightPkg.RequestPkg.newBuilder();
                synchronized (b) {
                    newBuilder.setPlatformId(1);
                    newBuilder.setProdId(b.f());
                    newBuilder.setBundleId(b.c);
                    newBuilder.setVersion(b.k);
                    newBuilder.setChannel(b.m);
                    newBuilder.setSdkVer(b.f);
                    newBuilder.setCmd(i);
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    newBuilder.setSBuffer(ByteString.a(bArr));
                    newBuilder.setModel(b.h);
                    newBuilder.setOsVer(b.i);
                    newBuilder.clearReserved();
                    newBuilder.setSessionId(b.e());
                    newBuilder.setStrategylastUpdateTime(c.n);
                    newBuilder.setDeviceId(b.h());
                    newBuilder.setApn(c.b(context));
                    newBuilder.setUploadTime(System.currentTimeMillis());
                    newBuilder.setImei(b.k());
                    newBuilder.setQimei(b.j());
                    newBuilder.setImsi(b.m());
                    newBuilder.setMac(b.l());
                    newBuilder.setAndroidId(b.h());
                    newBuilder.setNetworkType(c.b(context));
                    StringBuilder sb = new StringBuilder();
                    b.getClass();
                    sb.append("com.uqm.crashsight");
                    newBuilder.setSdkId(sb.toString());
                    newBuilder.putReserved("A26", b.w());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b.I());
                    newBuilder.putReserved("A62", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b.J());
                    newBuilder.putReserved("A63", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b.B);
                    newBuilder.putReserved("F11", sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(b.A);
                    newBuilder.putReserved("F12", sb5.toString());
                    newBuilder.putReserved("D3", b.l);
                    if (b.b != null) {
                        for (com.uqm.crashsight.a aVar : b.b) {
                            if (aVar.versionKey != null && aVar.version != null) {
                                newBuilder.putReserved(aVar.versionKey, aVar.version);
                            }
                        }
                    }
                    newBuilder.putReserved("G15", q.b("G15", ""));
                    newBuilder.putReserved("sessionUUID", com.uqm.crashsight.crashreport.common.info.b.a().b());
                    newBuilder.putReserved("traceUUID", com.uqm.crashsight.crashreport.common.info.b.a().c());
                    newBuilder.putReserved("matchUUID", com.uqm.crashsight.crashreport.common.info.b.a().d());
                    try {
                        String str = "";
                        if (com.uqm.crashsight.crashreport.common.strategy.a.a().e() != null) {
                            str = com.uqm.crashsight.crashreport.common.strategy.a.a().e();
                            m.c("cloudStrategy is %s", str);
                        }
                        newBuilder.putReserved("STRATEGY_INFOS", str);
                        newBuilder.putReserved("HarmonyVersion", c.g(context));
                    } catch (Throwable unused) {
                    }
                    newBuilder.putReserved("D4", q.b("D4", "0"));
                }
                Map<String, String> B = b.B();
                if (B != null) {
                    for (Map.Entry<String, String> entry : B.entrySet()) {
                        newBuilder.putReserved(entry.getKey(), entry.getValue());
                    }
                }
                return newBuilder.h();
            } catch (Throwable th) {
                if (!m.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        public static byte[] encode2SendDatas(Object obj) {
            try {
                SightPkg.UniPacket.Builder newBuilder = SightPkg.UniPacket.newBuilder();
                newBuilder.setEncodeName(HttpUtils.DEFAULT_ENCODE_NAME);
                newBuilder.setIRequestId(1);
                newBuilder.setSServantName("RqdServer");
                newBuilder.setSFuncName("sync");
                newBuilder.setRequest((SightPkg.RequestPkg) obj);
                SightPkg.UniPacket build = newBuilder.h();
                m.a("encode2SendDatas successful", new Object[0]);
                return build.toByteArray();
            } catch (Throwable th) {
                if (m.b(th)) {
                    return null;
                }
                th.printStackTrace();
                return null;
            }
        }

        public static SightPkg.ResponsePkg decode2ResponsePkg$308be088(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                SightPkg.ResponsePkg response = SightPkg.UniPacket.parseFrom(bArr).getResponse();
                if (response != null) {
                    m.a(response.toString(), new Object[0]);
                }
                return response;
            } catch (Throwable th) {
                if (m.b(th)) {
                    return null;
                }
                th.printStackTrace();
                return null;
            }
        }

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized CrashSightStrategy setRecordUserInfoOnceADay(boolean z) {
        this.r = z;
        return this;
    }

    public synchronized CrashSightStrategy setUploadProcess(boolean z) {
        this.q = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.q;
    }

    public synchronized boolean isCrashSightLogUpload() {
        return this.o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.r;
    }

    public boolean isReplaceOldChannel() {
        return this.p;
    }

    public void setReplaceOldChannel(boolean z) {
        this.p = z;
    }

    public synchronized String getAppVersion() {
        if (this.d == null) {
            return com.uqm.crashsight.crashreport.common.info.a.b().k;
        }
        return this.d;
    }

    public synchronized CrashSightStrategy setAppVersion(String str) {
        this.d = str;
        return this;
    }

    public synchronized CrashSightStrategy setUserInfoActivity(Class<?> cls) {
        this.n = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.n;
    }

    public synchronized String getAppChannel() {
        if (this.e == null) {
            return com.uqm.crashsight.crashreport.common.info.a.b().m;
        }
        return this.e;
    }

    public synchronized CrashSightStrategy setAppChannel(String str) {
        this.e = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        if (this.f == null) {
            return com.uqm.crashsight.crashreport.common.info.a.b().c;
        }
        return this.f;
    }

    public synchronized CrashSightStrategy setAppPackageName(String str) {
        this.f = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.g;
    }

    public synchronized CrashSightStrategy setAppReportDelay(long j) {
        this.g = j;
        return this;
    }

    public synchronized String getLibCrashSightSOFilePath() {
        return this.h;
    }

    public synchronized CrashSightStrategy setLibCrashSightSOFilePath(String str) {
        this.h = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.i;
    }

    public synchronized CrashSightStrategy setDeviceID(String str) {
        this.i = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.j;
    }

    public synchronized CrashSightStrategy setEnableNativeCrashMonitor(boolean z) {
        this.j = z;
        return this;
    }

    public synchronized CrashSightStrategy setEnableUserInfo(boolean z) {
        this.m = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.m;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.l;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.l = z;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.k;
    }

    public synchronized CrashSightStrategy setEnableANRCrashMonitor(boolean z) {
        this.k = z;
        return this;
    }

    public synchronized a getCrashHandleCallback() {
        return this.s;
    }

    public synchronized CrashSightStrategy setCrashHandleCallback(a aVar) {
        this.s = aVar;
        return this;
    }

    public synchronized void setCallBackType(int i) {
        this.f6545a = i;
    }

    public synchronized int getCallBackType() {
        return this.f6545a;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.b = z;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    public synchronized void setCrashHandleTimeout(int i) {
        this.c = i;
    }

    public synchronized int getCrashHandleTimeout() {
        return this.c;
    }
}
