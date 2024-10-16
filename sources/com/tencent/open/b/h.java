package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.tencent.connect.common.Constants;
import com.tencent.mid.api.MidEntity;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected static h f6372a;
    protected HandlerThread e;
    protected Handler f;
    protected Random b = new Random();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected Executor g = k.b();
    protected Executor h = k.b();

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f6372a == null) {
                f6372a = new h();
            }
            hVar = f6372a;
        }
        return hVar;
    }

    private h() {
        this.e = null;
        if (this.e == null) {
            this.e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new Handler(this.e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        h.this.b();
                        break;
                    case 1001:
                        h.this.e();
                        break;
                }
                super.handleMessage(message);
            }
        };
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String k = l.k(d.b(com.tencent.open.utils.g.a()));
                        String k2 = l.k(d.c(com.tencent.open.utils.g.a()));
                        String k3 = l.k(d.a());
                        String k4 = l.k(d.d(com.tencent.open.utils.g.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(RecommendParams.KEY_UIN, Constants.DEFAULT_UIN);
                        bundle2.putString(MidEntity.TAG_IMEI, k);
                        bundle2.putString(MidEntity.TAG_IMSI, k2);
                        bundle2.putString("android_id", k4);
                        bundle2.putString(MidEntity.TAG_MAC, k3);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("language", d.b());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()));
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", l.d(com.tencent.open.utils.g.a(), "com.qzone"));
                        bundle2.putString(Constants.PARAM_QQ_VER, l.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", l.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString(Constants.PARAM_APP_VER, l.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        h.this.d.add(new c(bundle2));
                        int size = h.this.d.size();
                        int a2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a2 == 0) {
                            a2 = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z) {
                            if (h.this.f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            h.this.f.sendMessageDelayed(obtain, a2);
                            return;
                        }
                        h.this.e();
                        h.this.f.removeMessages(1001);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(final String str, final long j, final long j2, final long j3, final int i, final String str2, final boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(com.tencent.open.utils.g.a());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString(ProductAction.ACTION_DETAIL, str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(a2);
                        sb.append('&');
                        sb.append("sdcard=");
                        sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb.append('&');
                        sb.append("wifi=");
                        sb.append(a.e(com.tencent.open.utils.g.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int a3 = 100 / h.this.a(i);
                        if (a3 <= 0) {
                            a3 = 1;
                        } else if (a3 > 100) {
                            a3 = 100;
                        }
                        bundle.putString("frequency", a3 + "");
                        bundle.putString("reqSize", j2 + "");
                        bundle.putString(CocosPayHelper.RES_CODE, i + "");
                        bundle.putString("rspSize", j3 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString(RecommendParams.KEY_UIN, Constants.DEFAULT_UIN);
                        h.this.c.add(new c(bundle));
                        int size = h.this.c.size();
                        int a4 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (!h.this.a("report_cgi", size) && !z) {
                            if (!h.this.f.hasMessages(1000)) {
                                Message obtain = Message.obtain();
                                obtain.what = 1000;
                                h.this.f.sendMessageDelayed(obtain, a4);
                            }
                        }
                        h.this.b();
                        h.this.f.removeMessages(1000);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    protected void b() {
        if (l.b(com.tencent.open.utils.g.a())) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, String> c = h.this.c();
                        if (c != null && !c.isEmpty()) {
                            int a2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
                            if (a2 == 0) {
                                a2 = 3;
                            }
                            SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + a2);
                            boolean z = false;
                            int i = 0;
                            while (true) {
                                i++;
                                try {
                                    int d = com.tencent.open.a.a.a().b("https://wspeed.qq.com/w.cgi", c).d();
                                    SLog.i("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + d);
                                    if (d != 200) {
                                        break;
                                    }
                                    g.a().b("report_cgi");
                                    z = true;
                                    break;
                                } catch (SocketTimeoutException e) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                                    if (i >= a2) {
                                        break;
                                    }
                                } catch (Exception e2) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                                }
                            }
                            if (!z) {
                                g.a().a("report_cgi", h.this.c);
                            }
                            h.this.c.clear();
                        }
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e3);
                    }
                }
            });
        }
    }

    protected boolean a(String str, String str2) {
        int a2;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("report_cgi")) {
            try {
                a2 = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < a2) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else if (str.equals("report_via")) {
            a2 = f.a(str2);
            if (this.b.nextInt(100) < a2) {
                z = true;
            }
        } else {
            a2 = 100;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + a2);
        return z;
    }

    protected boolean a(String str, int i) {
        int i2;
        if (str.equals("report_cgi")) {
            i2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportMaxcount");
            if (i2 == 0) {
                i2 = 5;
            }
        } else if (str.equals("report_via")) {
            i2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportBatchCount");
            if (i2 == 0) {
                i2 = 5;
            }
        } else {
            i2 = 0;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected int a(int i) {
        if (i == 0) {
            int a2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    protected Map<String, String> c() {
        if (this.c.size() == 0) {
            return null;
        }
        c cVar = (c) this.c.get(0);
        if (cVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = cVar.f6368a.get("appid");
        List<Serializable> a2 = g.a().a("report_cgi");
        if (a2 != null) {
            this.c.addAll(a2);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("appid", str);
            hashMap.put("releaseversion", Constants.SDK_VERSION_REPORT);
            hashMap.put("device", com.tencent.open.utils.f.a().a(com.tencent.open.utils.g.a()));
            hashMap.put("qua", Constants.SDK_QUA);
            hashMap.put("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                c cVar2 = (c) this.c.get(i);
                hashMap.put(i + "_1", cVar2.f6368a.get("apn"));
                hashMap.put(i + "_2", cVar2.f6368a.get("frequency"));
                hashMap.put(i + "_3", cVar2.f6368a.get("commandid"));
                hashMap.put(i + "_4", cVar2.f6368a.get(CocosPayHelper.RES_CODE));
                hashMap.put(i + "_5", cVar2.f6368a.get("timeCost"));
                hashMap.put(i + "_6", cVar2.f6368a.get("reqSize"));
                hashMap.put(i + "_7", cVar2.f6368a.get("rspSize"));
                hashMap.put(i + "_8", cVar2.f6368a.get(ProductAction.ACTION_DETAIL));
                hashMap.put(i + "_9", cVar2.f6368a.get(RecommendParams.KEY_UIN));
                hashMap.put(i + "_10", d.e(com.tencent.open.utils.g.a()) + "&" + cVar2.f6368a.get("deviceInfo"));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + hashMap.toString());
            return hashMap;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Map<String, String> d() {
        List<Serializable> a2 = g.a().a("report_via");
        if (a2 != null) {
            this.d.addAll(a2);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.f6368a.keySet()) {
                try {
                    String str2 = cVar.f6368a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        if (l.b(com.tencent.open.utils.g.a())) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.5
                /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
                
                    r19 = r4;
                    r23 = r6;
                    r21 = r13;
                    r0 = r17;
                    r2 = true;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 297
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.AnonymousClass5.run():void");
                }
            });
        }
    }

    public void a(final String str, final Map<String, String> map) {
        if (l.b(com.tencent.open.utils.g.a())) {
            k.b(new Runnable() { // from class: com.tencent.open.b.h.6
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    try {
                        int a2 = f.a();
                        if (a2 == 0) {
                            a2 = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a2);
                        do {
                            i++;
                            try {
                                try {
                                    SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.a.a().a(str, map).d());
                                } catch (SocketTimeoutException e) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                }
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e2);
                            }
                        } while (i < a2);
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e3);
                    }
                }
            });
        }
    }
}
