package com.uqm.crashsight.proguard;

import android.content.Context;
import com.helpshift.common.domain.network.NetworkConstants;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.protobuf.InvalidProtocolBufferException;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private int f6619a;
    private int b;
    private final Context c;
    private final int d;
    private final byte[] e;
    private final com.uqm.crashsight.crashreport.common.info.a f;
    private final com.uqm.crashsight.crashreport.common.strategy.a g;
    private final g h;
    private final i i;
    private final int j;
    private final h k;
    private final h l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public j(Context context, int i, int i2, byte[] bArr, String str, String str2, h hVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, hVar, 2, NetworkConstants.UPLOAD_CONNECT_TIMEOUT, z2, null);
    }

    public j(Context context, int i, int i2, byte[] bArr, String str, String str2, h hVar, int i3, int i4, boolean z, Map<String, String> map) {
        this.f6619a = 2;
        this.b = NetworkConstants.UPLOAD_CONNECT_TIMEOUT;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.c = context;
        this.f = com.uqm.crashsight.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.uqm.crashsight.crashreport.common.strategy.a.a();
        this.h = g.a(context);
        this.i = i.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = hVar;
        i iVar = this.i;
        this.l = null;
        this.d = i2;
        if (i3 > 0) {
            this.f6619a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.s = z;
        this.o = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkg r5, boolean r6, int r7, java.lang.String r8) {
        /*
            r4 = this;
            int r5 = r4.d
            r0 = 630(0x276, float:8.83E-43)
            if (r5 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r5 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r5 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r5 == r0) goto L17
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L1c
        L17:
            java.lang.String r5 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r5 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L2a
            java.lang.String r7 = "[Upload] Success: %s"
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r1] = r5
            com.uqm.crashsight.proguard.m.a(r7, r8)
            goto L3d
        L2a:
            java.lang.String r2 = "[Upload] Failed to upload(%d) %s: %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3[r1] = r7
            r3[r0] = r5
            r5 = 2
            r3[r5] = r8
            com.uqm.crashsight.proguard.m.e(r2, r3)
        L3d:
            long r7 = r4.q
            long r0 = r4.r
            long r7 = r7 + r0
            r0 = 0
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 <= 0) goto L5d
            com.uqm.crashsight.proguard.i r5 = r4.i
            boolean r7 = r4.s
            long r7 = r5.a(r7)
            long r0 = r4.q
            long r7 = r7 + r0
            long r0 = r4.r
            long r7 = r7 + r0
            com.uqm.crashsight.proguard.i r5 = r4.i
            boolean r0 = r4.s
            r5.a(r7, r0)
        L5d:
            com.uqm.crashsight.proguard.h r5 = r4.k
            if (r5 == 0) goto L6a
            int r7 = r4.d
            long r7 = r4.q
            long r7 = r4.r
            r5.a(r6)
        L6a:
            com.uqm.crashsight.proguard.h r5 = r4.l
            if (r5 == 0) goto L77
            int r7 = r4.d
            long r7 = r4.q
            long r7 = r4.r
            r5.a(r6)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.j.a(com.uqm.crashsight.crashreport.common.info.SightPkg$ResponsePkg, boolean, int, java.lang.String):void");
    }

    private boolean a(SightPkg.ResponsePkg responsePkg, com.uqm.crashsight.crashreport.common.info.a aVar, com.uqm.crashsight.crashreport.common.strategy.a aVar2) throws InvalidProtocolBufferException, InvalidProtocolBufferException {
        if (responsePkg == null) {
            m.d("resp == null!", new Object[0]);
            return false;
        }
        if (responsePkg.getResult() != 0) {
            m.e("resp result error %d", Long.valueOf(responsePkg.getResult()));
            return false;
        }
        try {
            if (!q.a(responsePkg.getGatewayIp()) && !com.uqm.crashsight.crashreport.common.info.a.b().i().equals(responsePkg.getGatewayIp())) {
                d.a().a(com.uqm.crashsight.crashreport.common.strategy.a.f6575a, "gateway", responsePkg.getGatewayIp().getBytes("UTF-8"), (c) null, true);
                aVar.d(responsePkg.getGatewayIp());
            }
            if (!q.a(responsePkg.getQimei()) && !com.uqm.crashsight.crashreport.common.info.a.b().j().equals(responsePkg.getQimei())) {
                d.a().a(com.uqm.crashsight.crashreport.common.strategy.a.f6575a, "device", responsePkg.getQimei().getBytes("UTF-8"), (c) null, true);
                aVar.e(responsePkg.getQimei());
            }
        } catch (Throwable th) {
            m.a(th);
        }
        aVar.j = responsePkg.getServerTime();
        if (responsePkg.getCmd() == 510) {
            if (responsePkg.getSBuffer() == null) {
                m.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(responsePkg.getCmd()));
                return false;
            }
            SightPkg.RqdStrategy parseFrom = SightPkg.RqdStrategy.parseFrom(responsePkg.getSBuffer());
            if (parseFrom == null) {
                m.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(responsePkg.getCmd()));
                return false;
            }
            aVar2.a(parseFrom, this.d);
            aVar2.a(parseFrom);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 831
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.j.run():void");
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    private static String a(String str) {
        if (q.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            m.a(th);
            return str;
        }
    }
}
