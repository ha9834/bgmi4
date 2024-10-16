package com.uqm.crashsight.crashreport.crash.jni;

import android.content.Context;
import com.uqm.crashsight.crashreport.crash.CrashDetailBean;
import com.uqm.crashsight.crashreport.crash.c;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.o;
import com.uqm.crashsight.proguard.q;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6605a;
    private final com.uqm.crashsight.crashreport.crash.b b;
    private final com.uqm.crashsight.crashreport.common.info.a c;
    private final com.uqm.crashsight.crashreport.common.strategy.a d;

    public a(Context context, com.uqm.crashsight.crashreport.common.info.a aVar, com.uqm.crashsight.crashreport.crash.b bVar, com.uqm.crashsight.crashreport.common.strategy.a aVar2) {
        this.f6605a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    @Override // com.uqm.crashsight.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str13;
        int indexOf;
        boolean k = c.a().k();
        if (k) {
            m.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.h();
        crashDetailBean.f = this.c.k;
        crashDetailBean.g = this.c.u();
        com.uqm.crashsight.crashreport.common.info.a aVar = this.c;
        crashDetailBean.m = com.uqm.crashsight.crashreport.common.info.a.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = k ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![CrashSight]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 == null ? "" : str5;
        crashDetailBean.r = str6 == null ? "" : str6;
        crashDetailBean.s = j;
        crashDetailBean.v = q.a(crashDetailBean.q.getBytes());
        crashDetailBean.B = str;
        crashDetailBean.C = str2;
        crashDetailBean.J = this.c.w();
        crashDetailBean.h = this.c.t();
        crashDetailBean.i = this.c.G();
        crashDetailBean.w = str9;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a2 = b.a(dumpFilePath, str9);
        if (!q.a(a2)) {
            crashDetailBean.W = a2;
        }
        crashDetailBean.X = b.b(dumpFilePath);
        crashDetailBean.x = b.a(str10, c.e, null, false);
        crashDetailBean.y = b.a(str11, c.e, null, true);
        crashDetailBean.K = str8;
        crashDetailBean.L = str7;
        crashDetailBean.M = str12;
        crashDetailBean.G = this.c.o();
        crashDetailBean.H = this.c.n();
        crashDetailBean.I = this.c.p();
        if (z) {
            crashDetailBean.D = com.uqm.crashsight.crashreport.common.info.c.k();
            crashDetailBean.E = com.uqm.crashsight.crashreport.common.info.c.h();
            crashDetailBean.F = com.uqm.crashsight.crashreport.common.info.c.m();
            if (crashDetailBean.x == null) {
                crashDetailBean.x = q.a(this.f6605a, c.e, (String) null);
            }
            crashDetailBean.z = o.a();
            crashDetailBean.N = this.c.f6569a;
            crashDetailBean.O = this.c.a();
            crashDetailBean.A = q.a(c.f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
                String substring = crashDetailBean.q.substring(i, crashDetailBean.q.length() - 1);
                if (substring.length() > 0 && crashDetailBean.A.containsKey(crashDetailBean.C) && (indexOf = (str13 = crashDetailBean.A.get(crashDetailBean.C)).indexOf(substring)) > 0) {
                    String substring2 = str13.substring(indexOf);
                    crashDetailBean.A.put(crashDetailBean.C, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.B = this.c.d;
            }
            this.b.d(crashDetailBean);
            crashDetailBean.R = this.c.E();
            crashDetailBean.S = this.c.F();
            crashDetailBean.T = this.c.x();
            crashDetailBean.U = this.c.C();
        } else {
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            crashDetailBean.F = -1L;
            if (crashDetailBean.x == null) {
                crashDetailBean.x = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.N = -1L;
            crashDetailBean.R = -1;
            crashDetailBean.S = -1;
            crashDetailBean.T = map;
            crashDetailBean.U = this.c.C();
            crashDetailBean.A = null;
            if (str == null) {
                crashDetailBean.B = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.z = bArr;
            }
        }
        return crashDetailBean;
    }

    @Override // com.uqm.crashsight.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, String str5, int i3, String str6, int i4, int i5, int i6, String str7, String str8) {
        m.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, str5, i3, str6, i4, i5, i6, str7, str8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f A[Catch: Throwable -> 0x02f8, TryCatch #2 {Throwable -> 0x02f8, blocks: (B:3:0x0019, B:5:0x0021, B:6:0x007d, B:9:0x0086, B:11:0x0089, B:13:0x008d, B:15:0x00a6, B:18:0x00ae, B:17:0x00b7, B:22:0x00c1, B:24:0x00cb, B:26:0x00d3, B:27:0x00df, B:29:0x00e9, B:32:0x00f0, B:33:0x0102, B:35:0x010c, B:38:0x0114, B:39:0x0129, B:41:0x012f, B:44:0x013f, B:46:0x0163, B:47:0x01ab, B:49:0x01ce, B:50:0x01d5, B:52:0x01df, B:54:0x01e7, B:57:0x0224, B:108:0x0184, B:109:0x00fc, B:111:0x00ba, B:114:0x004b, B:115:0x0051, B:117:0x005b), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0163 A[Catch: Throwable -> 0x02f8, TryCatch #2 {Throwable -> 0x02f8, blocks: (B:3:0x0019, B:5:0x0021, B:6:0x007d, B:9:0x0086, B:11:0x0089, B:13:0x008d, B:15:0x00a6, B:18:0x00ae, B:17:0x00b7, B:22:0x00c1, B:24:0x00cb, B:26:0x00d3, B:27:0x00df, B:29:0x00e9, B:32:0x00f0, B:33:0x0102, B:35:0x010c, B:38:0x0114, B:39:0x0129, B:41:0x012f, B:44:0x013f, B:46:0x0163, B:47:0x01ab, B:49:0x01ce, B:50:0x01d5, B:52:0x01df, B:54:0x01e7, B:57:0x0224, B:108:0x0184, B:109:0x00fc, B:111:0x00ba, B:114:0x004b, B:115:0x0051, B:117:0x005b), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ce A[Catch: Throwable -> 0x02f8, TryCatch #2 {Throwable -> 0x02f8, blocks: (B:3:0x0019, B:5:0x0021, B:6:0x007d, B:9:0x0086, B:11:0x0089, B:13:0x008d, B:15:0x00a6, B:18:0x00ae, B:17:0x00b7, B:22:0x00c1, B:24:0x00cb, B:26:0x00d3, B:27:0x00df, B:29:0x00e9, B:32:0x00f0, B:33:0x0102, B:35:0x010c, B:38:0x0114, B:39:0x0129, B:41:0x012f, B:44:0x013f, B:46:0x0163, B:47:0x01ab, B:49:0x01ce, B:50:0x01d5, B:52:0x01df, B:54:0x01e7, B:57:0x0224, B:108:0x0184, B:109:0x00fc, B:111:0x00ba, B:114:0x004b, B:115:0x0051, B:117:0x005b), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01df A[Catch: Throwable -> 0x02f8, TryCatch #2 {Throwable -> 0x02f8, blocks: (B:3:0x0019, B:5:0x0021, B:6:0x007d, B:9:0x0086, B:11:0x0089, B:13:0x008d, B:15:0x00a6, B:18:0x00ae, B:17:0x00b7, B:22:0x00c1, B:24:0x00cb, B:26:0x00d3, B:27:0x00df, B:29:0x00e9, B:32:0x00f0, B:33:0x0102, B:35:0x010c, B:38:0x0114, B:39:0x0129, B:41:0x012f, B:44:0x013f, B:46:0x0163, B:47:0x01ab, B:49:0x01ce, B:50:0x01d5, B:52:0x01df, B:54:0x01e7, B:57:0x0224, B:108:0x0184, B:109:0x00fc, B:111:0x00ba, B:114:0x004b, B:115:0x0051, B:117:0x005b), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0252 A[Catch: Throwable -> 0x02f4, TryCatch #1 {Throwable -> 0x02f4, blocks: (B:60:0x024c, B:62:0x0252, B:64:0x025a, B:66:0x025e, B:68:0x0268, B:70:0x0272, B:72:0x027a, B:73:0x027c), top: B:59:0x024c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x025a A[Catch: Throwable -> 0x02f4, TryCatch #1 {Throwable -> 0x02f4, blocks: (B:60:0x024c, B:62:0x0252, B:64:0x025a, B:66:0x025e, B:68:0x0268, B:70:0x0272, B:72:0x027a, B:73:0x027c), top: B:59:0x024c }] */
    @Override // com.uqm.crashsight.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, int r39, java.lang.String r40, int r41, int r42, int r43, java.lang.String r44, java.lang.String r45, java.lang.String[] r46) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.uqm.crashsight.crashreport.crash.jni.NativeExceptionHandler
    public final void handleAnr() {
        com.uqm.crashsight.crashreport.crash.anr.b.a().a(this.f6605a);
    }
}
