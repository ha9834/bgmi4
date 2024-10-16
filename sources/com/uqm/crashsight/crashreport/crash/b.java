package com.uqm.crashsight.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.helpshift.util.ErrorReportProvider;
import com.tencent.connect.common.Constants;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.mtt.engine.http.HttpUtils;
import com.uqm.crashsight.CrashModule;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.PlugInBean;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.f;
import com.uqm.crashsight.proguard.h;
import com.uqm.crashsight.proguard.i;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import com.uqm.crashsight.proguard.v;
import com.uqm.crashsight.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f6589a;
    private Context b;
    private i c;
    private com.uqm.crashsight.proguard.d d;
    private com.uqm.crashsight.crashreport.common.strategy.a e;
    private com.uqm.crashsight.proguard.c f;
    private CrashSightStrategy.a g;

    public b(int i, Context context, i iVar, com.uqm.crashsight.proguard.d dVar, com.uqm.crashsight.crashreport.common.strategy.a aVar, CrashSightStrategy.a aVar2, com.uqm.crashsight.proguard.c cVar) {
        f6589a = i;
        this.b = context;
        this.c = iVar;
        this.d = dVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = cVar;
    }

    private static List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.d && aVar.b <= currentTimeMillis - ErrorReportProvider.BATCH_TIME) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> b;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (b = b(arrayList)) != null && b.size() > 0) {
            Collections.sort(b);
            CrashDetailBean crashDetailBean3 = null;
            for (int i = 0; i < b.size(); i++) {
                CrashDetailBean crashDetailBean4 = b.get(i);
                if (i == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else if (crashDetailBean4.t != null && (split = crashDetailBean4.t.split("\n")) != null) {
                    for (String str : split) {
                        if (!crashDetailBean3.t.contains(str)) {
                            crashDetailBean3.u++;
                            crashDetailBean3.t += str + "\n";
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.u = 0;
            crashDetailBean.t = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!aVar2.e && !aVar2.d) {
                String str2 = crashDetailBean2.t;
                StringBuilder sb = new StringBuilder();
                sb.append(aVar2.b);
                if (!str2.contains(sb.toString())) {
                    crashDetailBean2.u++;
                    crashDetailBean2.t += aVar2.b + "\n";
                }
            }
        }
        if (crashDetailBean2.s != crashDetailBean.s) {
            String str3 = crashDetailBean2.t;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.s);
            if (!str3.contains(sb2.toString())) {
                crashDetailBean2.u++;
                crashDetailBean2.t += crashDetailBean.s + "\n";
            }
        }
        return crashDetailBean2;
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return b(crashDetailBean);
    }

    public final boolean b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return true;
        }
        if (c.n != null && !c.n.isEmpty()) {
            if (crashDetailBean.q.contains(c.n)) {
                m.d("This exceptionStack contains the filter string set. It will not be record and upload.", new Object[0]);
                l.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
            if (crashDetailBean.o.contains(c.n)) {
                m.d("This exceptionMsg contains the filter string set. It will not be record and upload.", new Object[0]);
                l.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (c.o != null && !c.o.isEmpty()) {
            m.c("Crash regular filter for crash stack is: %s", c.o);
            if (Pattern.compile(c.o).matcher(crashDetailBean.q).find()) {
                m.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                m.e("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.b != 2) {
            f fVar = new f();
            fVar.b = 1;
            fVar.c = crashDetailBean.B;
            fVar.d = crashDetailBean.C;
            fVar.e = crashDetailBean.s;
            this.d.b(1);
            this.d.a(fVar);
            m.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            m.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> b = b();
        ArrayList arrayList = null;
        if (b != null && b.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(a(b));
            b.removeAll(arrayList);
            if (b.size() > 20) {
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ");
                sb.append("(");
                sb.append("SELECT _id");
                sb.append(" FROM t_cr");
                sb.append(" order by _id");
                sb.append(" limit 5");
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                try {
                    m.c("deleted first record %s data %d", "t_cr", Integer.valueOf(com.uqm.crashsight.proguard.d.a().a("t_cr", sb2, (String[]) null, (com.uqm.crashsight.proguard.c) null, true)));
                } catch (Throwable th) {
                    if (!m.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            if (!com.uqm.crashsight.b.c && c.d) {
                boolean z = false;
                for (a aVar : b) {
                    if (crashDetailBean.v.equals(aVar.c)) {
                        if (aVar.e) {
                            z = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z || arrayList2.size() >= c.c) {
                    m.a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a2 = a(arrayList2, crashDetailBean);
                    for (a aVar2 : arrayList2) {
                        if (aVar2.f6580a != a2.f6577a) {
                            arrayList.add(aVar2);
                        }
                    }
                    e(a2);
                    c(arrayList);
                    m.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        m.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c = com.uqm.crashsight.crashreport.common.strategy.a.a().c();
        if (c == null) {
            m.d("have not synced remote!", new Object[0]);
            l.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c.e) {
            m.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            m.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            l.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b = q.b();
        List<a> b2 = b();
        m.c("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
        l.d("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(b2));
        b2.removeAll(arrayList);
        Iterator<a> it = b2.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b < b - c.g) {
                it.remove();
                arrayList.add(next);
            } else if (next.d) {
                if (next.b >= currentTimeMillis - ErrorReportProvider.BATCH_TIME) {
                    it.remove();
                } else if (!next.e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f >= 3 && next.b < currentTimeMillis - ErrorReportProvider.BATCH_TIME) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        List<CrashDetailBean> b3 = b(b2);
        if (b3 != null && b3.size() > 0) {
            String str = com.uqm.crashsight.crashreport.common.info.a.b().k;
            Iterator<CrashDetailBean> it2 = b3.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return b3;
    }

    public final void c(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.b;
        if (i == 3) {
            if (!c.a().r()) {
                return;
            }
        } else {
            switch (i) {
                case 0:
                    if (!c.a().q()) {
                        return;
                    }
                    break;
                case 1:
                    m.a("IS_OPEN_UNITY_UP", new Object[0]);
                    if (CrashModule.IS_OPEN_UNITY_UP_CLOSE_JAVA) {
                        c.a().e();
                        m.a("UNITY_UP_CLOASE_JAVA: Java monitor closed.", new Object[0]);
                    } else if (CrashModule.IS_OPEN_UNITY_UP_JAVA_USE_FILTER) {
                        c.n = "signal";
                        m.a("UNITY_UP_JAVA_USE_FILTER: Crash Filter is java.lang.Error.", new Object[0]);
                    }
                    if (!c.a().q()) {
                        return;
                    }
                    break;
            }
        }
        if (this.f != null) {
            m.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            com.uqm.crashsight.proguard.c cVar = this.f;
            int i2 = crashDetailBean.b;
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.l) {
            m.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.b == 7, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[Catch: Throwable -> 0x00c9, TryCatch #0 {Throwable -> 0x00c9, blocks: (B:20:0x0041, B:23:0x004f, B:27:0x0058, B:28:0x0060, B:30:0x0066, B:32:0x0074, B:34:0x0085, B:36:0x008d, B:38:0x0093, B:40:0x009b, B:42:0x00a5, B:44:0x00ad, B:46:0x00b4, B:48:0x00c0, B:50:0x007b), top: B:19:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: Throwable -> 0x00c9, TryCatch #0 {Throwable -> 0x00c9, blocks: (B:20:0x0041, B:23:0x004f, B:27:0x0058, B:28:0x0060, B:30:0x0066, B:32:0x0074, B:34:0x0085, B:36:0x008d, B:38:0x0093, B:40:0x009b, B:42:0x00a5, B:44:0x00ad, B:46:0x00b4, B:48:0x00c0, B:50:0x007b), top: B:19:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(final java.util.List<com.uqm.crashsight.crashreport.crash.CrashDetailBean> r15, long r16, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.crash.b.a(java.util.List, long, boolean, boolean, boolean):void");
    }

    public final void a(byte[] bArr, long j, boolean z, boolean z2, boolean z3) {
        i iVar;
        if (com.uqm.crashsight.crashreport.common.info.a.a(this.b).e && (iVar = this.c) != null && iVar.b(c.f6591a)) {
            StrategyBean c = this.e.c();
            if (!c.e) {
                m.d("remote report is disable!", new Object[0]);
                m.b("[crash] server closed crashSight in this app. please check your appid if is correct, and re-install it", new Object[0]);
                return;
            }
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                String str = c.q;
                String str2 = StrategyBean.b;
                SightPkg.RequestPkg encode2RequestPkg = CrashSightStrategy.a.encode2RequestPkg(this.b, 850, bArr);
                if (encode2RequestPkg == null) {
                    m.d("request package is null.", new Object[0]);
                } else {
                    this.c.a(f6589a, encode2RequestPkg, str, str2, new h(this) { // from class: com.uqm.crashsight.crashreport.crash.b.2
                        @Override // com.uqm.crashsight.proguard.h
                        public final void a(boolean z4) {
                            v.a().c();
                        }
                    }, false);
                }
            } catch (Throwable th) {
                m.e("req cr error %s", th.toString());
                if (m.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            m.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                m.c("expuid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                m.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c.a().a(it.next());
            }
            m.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        m.b("[crash] upload fail.", new Object[0]);
    }

    public final void d(CrashDetailBean crashDetailBean) {
        int i;
        Map<String, String> map;
        String str;
        HashMap hashMap;
        if (crashDetailBean == null) {
            return;
        }
        if (this.g == null && this.f == null) {
            return;
        }
        try {
            switch (crashDetailBean.b) {
                case 0:
                    if (c.a().q()) {
                        i = 0;
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (c.a().q()) {
                        i = 2;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    if (!c.a().r()) {
                        return;
                    }
                    break;
                case 4:
                    i = 3;
                    if (!c.a().s()) {
                        return;
                    }
                    break;
                case 5:
                    i = 5;
                    if (!c.a().t()) {
                        return;
                    }
                    break;
                case 6:
                    i = 6;
                    if (!c.a().u()) {
                        return;
                    }
                    break;
                case 7:
                    i = 7;
                    break;
                default:
                    return;
            }
            int i2 = crashDetailBean.b;
            String str2 = crashDetailBean.n;
            String str3 = crashDetailBean.p;
            String str4 = crashDetailBean.q;
            long j = crashDetailBean.s;
            byte[] bArr = null;
            if (this.f != null) {
                m.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                com.uqm.crashsight.proguard.c cVar = this.f;
                m.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                String b = this.f.b();
                if (b != null) {
                    hashMap = new HashMap(1);
                    hashMap.put("userData", b);
                } else {
                    hashMap = null;
                }
                map = hashMap;
            } else if (this.g != null) {
                m.c("Calling 'onCrashHandleStart' of CrashSight crash listener.", new Object[0]);
                l.d("[Start]Calling 'onCrashHandleStart' of CrashSight crash listener.", new Object[0]);
                map = this.g.onCrashHandleStart(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                l.d("[End]Calling 'onCrashHandleStart' of CrashSight crash listener.", new Object[0]);
            } else {
                map = null;
            }
            if (map != null && map.size() > 0) {
                crashDetailBean.P = new LinkedHashMap(map.size());
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        if (!q.a(next.getKey())) {
                            String key = next.getKey();
                            if (q.a(next.getValue())) {
                                str = next.getValue();
                            } else {
                                str = next.getValue();
                            }
                            i3 += str.length();
                            if (i3 > 131072) {
                                m.d("setted %s value length is over limit %d substring", key, 131072);
                            } else {
                                crashDetailBean.P.put(key, str);
                            }
                        }
                    }
                }
            }
            m.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f != null) {
                m.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                bArr = this.f.a();
            } else if (this.g != null) {
                m.c("Calling 'onCrashHandleStart2GetExtraDatas' of CrashSight crash listener.", new Object[0]);
                bArr = this.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
            }
            crashDetailBean.V = bArr;
            if (bArr != null) {
                if (bArr.length > 131072) {
                    m.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), 131072);
                    crashDetailBean.V = Arrays.copyOf(bArr, 131072);
                }
                m.a("add extra bytes %d ", Integer.valueOf(bArr.length));
            }
            if (this.f != null) {
                m.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                com.uqm.crashsight.proguard.c cVar2 = this.f;
                String str5 = crashDetailBean.o;
                String str6 = crashDetailBean.m;
                String str7 = crashDetailBean.e;
                String str8 = crashDetailBean.c;
                String str9 = crashDetailBean.B;
                String str10 = crashDetailBean.C;
                if (cVar2.c()) {
                    return;
                }
                m.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
        } catch (Throwable th) {
            m.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (!m.a(th)) {
                th.printStackTrace();
            }
            l.d("crash handle callback something wrong! %s", th.getClass().getName());
            if (l.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f6577a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f6577a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.s));
            contentValues.put("_s1", crashDetailBean.v);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            if (!crashDetailBean.j) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", q.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) q.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f6577a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void e(CrashDetailBean crashDetailBean) {
        ContentValues f;
        if (crashDetailBean == null || (f = f(crashDetailBean)) == null) {
            return;
        }
        long a2 = com.uqm.crashsight.proguard.d.a().a("t_cr", f, (com.uqm.crashsight.proguard.c) null, true);
        if (a2 >= 0) {
            m.c("insert %s success!", "t_cr");
            crashDetailBean.f6577a = a2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.uqm.crashsight.crashreport.crash.CrashDetailBean> b(java.util.List<com.uqm.crashsight.crashreport.crash.a> r13) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.crash.b.b(java.util.List):java.util.List");
    }

    private static a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f6580a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private List<a> b() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                cursor = com.uqm.crashsight.proguard.d.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    try {
                        if (cursor.getCount() <= 0) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("_id in ");
                        sb.append("(");
                        int i = 0;
                        while (cursor.moveToNext()) {
                            a b = b(cursor);
                            if (b != null) {
                                arrayList.add(b);
                            } else {
                                try {
                                    sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                                    sb.append(",");
                                    i++;
                                } catch (Throwable unused) {
                                    m.d("unknown id!", new Object[0]);
                                }
                            }
                        }
                        if (sb.toString().contains(",")) {
                            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                        }
                        sb.append(")");
                        String sb2 = sb.toString();
                        sb.setLength(0);
                        if (i > 0) {
                            m.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(com.uqm.crashsight.proguard.d.a().a("t_cr", sb2, (String[]) null, (com.uqm.crashsight.proguard.c) null, true)));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (!m.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return arrayList;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
        }
    }

    private static void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f6580a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            m.c("deleted %s data %d", "t_cr", Integer.valueOf(com.uqm.crashsight.proguard.d.a().a("t_cr", sb3, (String[]) null, (com.uqm.crashsight.proguard.c) null, true)));
        } catch (Throwable th) {
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f6577a);
                }
                String sb2 = sb.toString();
                String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
                sb.setLength(0);
                m.c("deleted %s data %d", "t_cr", Integer.valueOf(com.uqm.crashsight.proguard.d.a().a("t_cr", substring, (String[]) null, (com.uqm.crashsight.proguard.c) null, true)));
            } catch (Throwable th) {
                if (m.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static SightPkg.ExceptionUpload a(Context context, CrashDetailBean crashDetailBean, com.uqm.crashsight.crashreport.common.info.a aVar) {
        SightPkg.Attachment a2;
        SightPkg.Attachment a3;
        SightPkg.Attachment build;
        SightPkg.Attachment a4;
        if (context == null || crashDetailBean == null || aVar == null) {
            m.d("enExp args == null", new Object[0]);
            return null;
        }
        SightPkg.ExceptionUpload.Builder newBuilder = SightPkg.ExceptionUpload.newBuilder();
        int i = crashDetailBean.b;
        if (i == 9) {
            newBuilder.setType(crashDetailBean.j ? "209" : "109");
        } else if (i != 1000) {
            switch (i) {
                case 0:
                    newBuilder.setType(crashDetailBean.j ? "200" : CocosPayHelper.AP_MIDAS_RESP_RESULT_CHANNEL_ERR);
                    break;
                case 1:
                    newBuilder.setType(crashDetailBean.j ? "201" : "101");
                    break;
                case 2:
                    newBuilder.setType(crashDetailBean.j ? "202" : "102");
                    break;
                case 3:
                    newBuilder.setType(crashDetailBean.j ? "203" : "103");
                    break;
                case 4:
                    newBuilder.setType(crashDetailBean.j ? "204" : "104");
                    break;
                case 5:
                    newBuilder.setType(crashDetailBean.j ? "207" : "107");
                    break;
                case 6:
                    newBuilder.setType(crashDetailBean.j ? "206" : "106");
                    break;
                case 7:
                    newBuilder.setType(crashDetailBean.j ? "208" : "108");
                    break;
                default:
                    m.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                    break;
            }
        } else {
            newBuilder.setType(Constants.DEFAULT_UIN);
        }
        newBuilder.setCrashTime(crashDetailBean.s);
        newBuilder.setExpName(crashDetailBean.n);
        newBuilder.setExpMessage(crashDetailBean.o);
        newBuilder.setExpAddr(crashDetailBean.p);
        newBuilder.setCallStack(crashDetailBean.q);
        if (crashDetailBean.A != null) {
            newBuilder.putAllAllStacks(crashDetailBean.A);
        }
        newBuilder.setExpuid(crashDetailBean.c);
        newBuilder.setSession(SightPkg.AppSession.newBuilder().h());
        newBuilder.setUserid(crashDetailBean.m);
        newBuilder.setDeviceId(crashDetailBean.e);
        newBuilder.setCrashThread(crashDetailBean.C);
        newBuilder.setGatewayIp(com.uqm.crashsight.crashreport.common.info.a.b().i());
        newBuilder.setAppInfo(SightPkg.AppInfo.newBuilder().h());
        if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.h.entrySet()) {
                newBuilder.addPlugins(SightPkg.AppInfo.newBuilder().setName(entry.getValue().f6558a).setUUID(entry.getValue().c).setVer(entry.getValue().b).h());
            }
        }
        if (crashDetailBean.j) {
            newBuilder.setCrashCount(crashDetailBean.u);
            if (crashDetailBean.t != null && crashDetailBean.t.length() > 0) {
                try {
                    newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("alltimes.txt").setType(1).setData(ByteString.a(crashDetailBean.t.getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    newBuilder.clearAttaches();
                }
            }
            m.c("crashcount:%d sz:%d", Integer.valueOf(newBuilder.getCrashCount()), Integer.valueOf(newBuilder.getAttachesCount()));
        }
        if (crashDetailBean.x != null) {
            try {
                newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("log.txt").setType(1).setData(ByteString.a(crashDetailBean.x.getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                newBuilder.clearAttaches();
            }
        }
        if (crashDetailBean.y != null) {
            try {
                newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("jniLog.txt").setType(1).setData(ByteString.a(crashDetailBean.y.getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                newBuilder.clearAttaches();
            }
        }
        if (!q.a(crashDetailBean.W)) {
            try {
                newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("crashInfos.txt").setType(1).setData(ByteString.a(crashDetailBean.W.getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        if (crashDetailBean.X != null && (a4 = a("backupRecord.zip", context, crashDetailBean.X)) != null) {
            m.c("attach backup record", new Object[0]);
            newBuilder.addAttaches(a4);
        }
        if (crashDetailBean.z != null && crashDetailBean.z.length > 0 && (build = SightPkg.Attachment.newBuilder().setFileName("crashsightlog.zip").setType(2).setData(ByteString.a(crashDetailBean.z)).h()) != null) {
            m.c("attach user log", new Object[0]);
            newBuilder.addAttaches(build);
        }
        if (crashDetailBean.b == 3) {
            m.c("crashBean.anrMessages:%s", crashDetailBean.Q);
            if (crashDetailBean.Q != null && crashDetailBean.Q.containsKey("CS_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.Q.get("CS_CR_01"))) {
                        newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("anrMessage.txt").setType(1).setData(ByteString.a(crashDetailBean.Q.get("CS_CR_01").getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
                        m.c("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    newBuilder.clearAttaches();
                }
                crashDetailBean.Q.remove("CS_CR_01");
            }
            if (crashDetailBean.w != null && (a3 = a("trace.zip", context, crashDetailBean.w)) != null) {
                m.c("attach traces", new Object[0]);
                newBuilder.addAttaches(a3);
            }
        }
        if (crashDetailBean.b == 1 && crashDetailBean.w != null && (a2 = a("tomb.zip", context, crashDetailBean.w)) != null) {
            m.c("attach tombs", new Object[0]);
            newBuilder.addAttaches(a2);
        }
        if (aVar.D != null && !aVar.D.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = aVar.D.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            try {
                newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("martianlog.txt").setType(1).setData(ByteString.a(sb.toString().getBytes(HttpUtils.DEFAULT_ENCODE_NAME))).h());
                m.c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.V != null && crashDetailBean.V.length > 0) {
            newBuilder.addAttaches(SightPkg.Attachment.newBuilder().setFileName("userExtraByteData").setType(1).setData(ByteString.a(crashDetailBean.V)).h());
            m.c("attach extraData", new Object[0]);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.D);
        newBuilder.putValueMap("A9", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.E);
        newBuilder.putValueMap("A11", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.F);
        newBuilder.putValueMap("A10", sb4.toString());
        newBuilder.putValueMap("A23", crashDetailBean.f);
        newBuilder.putValueMap("A7", aVar.g);
        newBuilder.putValueMap("A6", aVar.r());
        newBuilder.putValueMap("A5", aVar.q());
        newBuilder.putValueMap("A22", aVar.h());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(crashDetailBean.H);
        newBuilder.putValueMap("A2", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(crashDetailBean.G);
        newBuilder.putValueMap("A1", sb6.toString());
        newBuilder.putValueMap("A24", aVar.i);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(crashDetailBean.I);
        newBuilder.putValueMap("A17", sb7.toString());
        newBuilder.putValueMap("A3", aVar.k());
        newBuilder.putValueMap("A16", aVar.m());
        newBuilder.putValueMap("A25", aVar.h());
        newBuilder.putValueMap("A14", aVar.l());
        newBuilder.putValueMap("A15", aVar.u());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(aVar.v());
        newBuilder.putValueMap("A13", sb8.toString());
        newBuilder.putValueMap("A34", crashDetailBean.B);
        if (aVar.y != null) {
            newBuilder.putValueMap("productIdentify", aVar.y);
        }
        try {
            newBuilder.putValueMap("A26", URLEncoder.encode(crashDetailBean.J, HttpUtils.DEFAULT_ENCODE_NAME));
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.b == 1) {
            newBuilder.putValueMap("A27", crashDetailBean.L);
            newBuilder.putValueMap("A28", crashDetailBean.K);
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.k);
            newBuilder.putValueMap("A29", sb9.toString());
        }
        newBuilder.putValueMap("A30", crashDetailBean.M);
        StringBuilder sb10 = new StringBuilder();
        sb10.append(crashDetailBean.N);
        newBuilder.putValueMap("A18", sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append(!crashDetailBean.O);
        newBuilder.putValueMap("A36", sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append(aVar.r);
        newBuilder.putValueMap("F02", sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append(aVar.s);
        newBuilder.putValueMap("F03", sb13.toString());
        newBuilder.putValueMap("F04", aVar.e());
        StringBuilder sb14 = new StringBuilder();
        sb14.append(aVar.t);
        newBuilder.putValueMap("F05", sb14.toString());
        newBuilder.putValueMap("F06", aVar.q);
        newBuilder.putValueMap("F08", aVar.w);
        newBuilder.putValueMap("F09", aVar.x);
        StringBuilder sb15 = new StringBuilder();
        sb15.append(aVar.u);
        newBuilder.putValueMap("F10", sb15.toString());
        if (crashDetailBean.R >= 0) {
            StringBuilder sb16 = new StringBuilder();
            sb16.append(crashDetailBean.R);
            newBuilder.putValueMap("C01", sb16.toString());
        }
        if (crashDetailBean.S >= 0) {
            StringBuilder sb17 = new StringBuilder();
            sb17.append(crashDetailBean.S);
            newBuilder.putValueMap("C02", sb17.toString());
        }
        if (crashDetailBean.T != null && crashDetailBean.T.size() > 0) {
            for (Map.Entry<String, String> entry2 : crashDetailBean.T.entrySet()) {
                newBuilder.putValueMap("C03_" + entry2.getKey(), entry2.getValue());
            }
        }
        if (crashDetailBean.U != null && crashDetailBean.U.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.U.entrySet()) {
                newBuilder.putValueMap("C04_" + entry3.getKey(), entry3.getValue());
            }
        }
        newBuilder.putValueMap("G01", crashDetailBean.r);
        if (crashDetailBean.P != null && crashDetailBean.P.size() > 0) {
            newBuilder.putAllUserMap(crashDetailBean.P);
            m.a("setted message size %d", Integer.valueOf(newBuilder.getUserMapCount()));
        }
        Object[] objArr = new Object[12];
        objArr[0] = crashDetailBean.n;
        objArr[1] = crashDetailBean.c;
        objArr[2] = aVar.e();
        objArr[3] = Long.valueOf((crashDetailBean.s - crashDetailBean.N) / 1000);
        objArr[4] = Boolean.valueOf(crashDetailBean.k);
        objArr[5] = Boolean.valueOf(crashDetailBean.O);
        objArr[6] = Boolean.valueOf(crashDetailBean.j);
        objArr[7] = Boolean.valueOf(crashDetailBean.b == 1);
        objArr[8] = Integer.valueOf(crashDetailBean.u);
        objArr[9] = crashDetailBean.t;
        objArr[10] = Boolean.valueOf(crashDetailBean.d);
        objArr[11] = Integer.valueOf(newBuilder.getValueMapCount());
        m.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr);
        return newBuilder.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.uqm.crashsight.crashreport.common.info.SightPkg.Attachment a(java.lang.String r5, android.content.Context r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.crash.b.a(java.lang.String, android.content.Context, java.lang.String):com.uqm.crashsight.crashreport.common.info.SightPkg$Attachment");
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.uqm.crashsight.crashreport.common.info.a b = com.uqm.crashsight.crashreport.common.info.a.b();
        if (b == null) {
            return;
        }
        m.e("#++++++++++Record By CrashSight++++++++++#", new Object[0]);
        m.e("# You can use CrashSight to get more Crash Detail!", new Object[0]);
        m.e("# PKG NAME: %s", b.c);
        m.e("# APP VER: %s", b.k);
        m.e("# SDK VER: %s", b.f);
        m.e("# LAUNCH TIME: %s", q.a(new Date(com.uqm.crashsight.crashreport.common.info.a.b().f6569a)));
        m.e("# CRASH TYPE: %s", str);
        m.e("# CRASH TIME: %s", str2);
        m.e("# CRASH PROCESS: %s", str3);
        m.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            m.e("# REPORT ID: %s", crashDetailBean.c);
            Object[] objArr = new Object[2];
            objArr[0] = b.h;
            objArr[1] = b.v().booleanValue() ? "ROOTED" : "UNROOT";
            m.e("# CRASH DEVICE: %s %s", objArr);
            m.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E), Long.valueOf(crashDetailBean.F));
            m.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H), Long.valueOf(crashDetailBean.I));
            if (!q.a(crashDetailBean.L)) {
                m.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.Q == null) {
                    str6 = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
                } else {
                    str6 = crashDetailBean.Q.get("CS_CR_01");
                }
                objArr2[0] = str6;
                m.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!q.a(str5)) {
            m.e("# CRASH STACK: ", new Object[0]);
            m.e(str5, new Object[0]);
        }
        m.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
