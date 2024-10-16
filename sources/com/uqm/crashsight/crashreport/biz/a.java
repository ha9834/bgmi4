package com.uqm.crashsight.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.helpshift.util.ErrorReportProvider;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.d;
import com.uqm.crashsight.proguard.h;
import com.uqm.crashsight.proguard.i;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f6549a;
    private long b;
    private int c;
    private boolean d;

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && userInfoBean.b != 5 && (a2 = aVar.a(com.uqm.crashsight.crashreport.common.info.a.a(aVar.f6549a).d)) != null && a2.size() >= 20) {
                m.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
                return;
            }
            long a3 = d.a().a("t_ui", a(userInfoBean), (com.uqm.crashsight.proguard.c) null, true);
            if (a3 >= 0) {
                m.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                userInfoBean.f6548a = a3;
            }
        }
    }

    public a(Context context, boolean z) {
        this.d = true;
        this.f6549a = context;
        this.d = z;
    }

    public final void a(int i, boolean z, long j) {
        com.uqm.crashsight.crashreport.common.strategy.a a2 = com.uqm.crashsight.crashreport.common.strategy.a.a();
        if (a2 != null && !a2.c().f && i != 1 && i != 3 && i != 5) {
            m.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.c++;
        }
        com.uqm.crashsight.crashreport.common.info.a a3 = com.uqm.crashsight.crashreport.common.info.a.a(this.f6549a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.c = a3.d;
        userInfoBean.d = com.uqm.crashsight.crashreport.common.info.a.g();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = a3.k;
        userInfoBean.o = i == 1 ? 1 : 0;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.q;
        userInfoBean.g = a3.r;
        userInfoBean.h = a3.s;
        userInfoBean.i = a3.t;
        userInfoBean.k = a3.u;
        userInfoBean.r = a3.x();
        userInfoBean.s = a3.C();
        userInfoBean.p = a3.E();
        userInfoBean.q = a3.F();
        k.a().a(new RunnableC0216a(userInfoBean, z), 0L);
    }

    public final void a() {
        this.b = q.b() + ErrorReportProvider.BATCH_TIME;
        k.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.crashreport.biz.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0216a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6552a;
        private UserInfoBean b;

        public RunnableC0216a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.f6552a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.uqm.crashsight.crashreport.common.info.a b;
            try {
                if (this.b != null) {
                    UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null && (b = com.uqm.crashsight.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = b.e();
                    }
                    m.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.f6552a) {
                    a aVar = a.this;
                    k a2 = k.a();
                    if (a2 != null) {
                        a2.a(new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (m.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void c() {
        boolean z;
        if (this.d) {
            i a2 = i.a();
            if (a2 == null) {
                return;
            }
            com.uqm.crashsight.crashreport.common.strategy.a a3 = com.uqm.crashsight.crashreport.common.strategy.a.a();
            if (a3 == null) {
                return;
            }
            if (!a3.b() || a2.b(1001)) {
                String str = com.uqm.crashsight.crashreport.common.info.a.a(this.f6549a).d;
                ArrayList arrayList = new ArrayList();
                final List<UserInfoBean> a4 = a(str);
                if (a4 != null) {
                    int size = a4.size() - 20;
                    if (size > 0) {
                        int i = 0;
                        while (i < a4.size() - 1) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < a4.size(); i3++) {
                                if (a4.get(i).e > a4.get(i3).e) {
                                    UserInfoBean userInfoBean = a4.get(i);
                                    a4.set(i, a4.get(i3));
                                    a4.set(i3, userInfoBean);
                                }
                            }
                            i = i2;
                        }
                        for (int i4 = 0; i4 < size; i4++) {
                            arrayList.add(a4.get(i4));
                        }
                    }
                    Iterator<UserInfoBean> it = a4.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        UserInfoBean next = it.next();
                        if (next.f != -1) {
                            it.remove();
                            if (next.e < q.b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.e > System.currentTimeMillis() - 600000 && (next.b == 1 || next.b == 4 || next.b == 3)) {
                            i5++;
                        }
                    }
                    if (i5 > 15) {
                        m.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i5));
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    a4 = new ArrayList<>();
                    z = true;
                }
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                if (z && a4.size() != 0) {
                    m.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a4.size()));
                    SightPkg.UserInfoPackage encodeUserInfoPackage = CrashSightStrategy.a.encodeUserInfoPackage(a4, this.c == 1 ? 1 : 2);
                    if (encodeUserInfoPackage == null) {
                        m.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                        return;
                    }
                    byte[] byteArray = encodeUserInfoPackage.toByteArray();
                    if (byteArray == null) {
                        m.d("[UserInfo] Failed to encode data.", new Object[0]);
                        return;
                    }
                    SightPkg.RequestPkg encode2RequestPkg = CrashSightStrategy.a.encode2RequestPkg(this.f6549a, 840, byteArray);
                    if (encode2RequestPkg == null) {
                        m.d("[UserInfo] Request package is null.", new Object[0]);
                        return;
                    }
                    i.a().a(1001, encode2RequestPkg, com.uqm.crashsight.crashreport.common.strategy.a.a().c().p, StrategyBean.f6574a, new h() { // from class: com.uqm.crashsight.crashreport.biz.a.1
                        @Override // com.uqm.crashsight.proguard.h
                        public final void a(boolean z2) {
                            if (z2) {
                                m.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                long currentTimeMillis = System.currentTimeMillis();
                                for (UserInfoBean userInfoBean2 : a4) {
                                    userInfoBean2.f = currentTimeMillis;
                                    a.a(a.this, userInfoBean2, true);
                                }
                            }
                        }
                    }, this.c == 1);
                    return;
                }
                m.c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        }
    }

    public final void b() {
        k a2 = k.a();
        if (a2 != null) {
            a2.a(new AnonymousClass2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.crashreport.biz.a$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 implements Runnable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                m.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                k.a().a(new b(), (a.this.b - currentTimeMillis) + 5000);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private long f6554a;

        public c(long j) {
            this.f6554a = 21600000L;
            this.f6554a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            k a2 = k.a();
            if (a2 != null) {
                a2.a(new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j = this.f6554a;
            k.a().a(new c(j), j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.uqm.crashsight.crashreport.biz.UserInfoBean> a(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 0
            boolean r1 = com.uqm.crashsight.proguard.q.a(r13)     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            if (r1 == 0) goto L9
            r4 = r0
            goto L1d
        L9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            java.lang.String r2 = "_pc = '"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            r1.append(r13)     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            java.lang.String r13 = "'"
            r1.append(r13)     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            java.lang.String r13 = r1.toString()     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            r4 = r13
        L1d:
            com.uqm.crashsight.proguard.d r1 = com.uqm.crashsight.proguard.d.a()     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            java.lang.String r2 = "t_ui"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 1
            android.database.Cursor r13 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La5 java.lang.Throwable -> Laa
            if (r13 != 0) goto L33
            if (r13 == 0) goto L32
            r13.close()
        L32:
            return r0
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            r1.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
        L3d:
            boolean r3 = r13.moveToNext()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            r4 = 0
            if (r3 == 0) goto L6e
            com.uqm.crashsight.crashreport.biz.UserInfoBean r3 = a(r13)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            if (r3 == 0) goto L4e
            r2.add(r3)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            goto L3d
        L4e:
            java.lang.String r3 = "_id"
            int r3 = r13.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> Lbb
            long r5 = r13.getLong(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> Lbb
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> Lbb
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> Lbb
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> Lbb
            goto L3d
        L66:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            com.uqm.crashsight.proguard.m.d(r3, r4)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            goto L3d
        L6e:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            if (r3 <= 0) goto L9d
            r3 = 4
            java.lang.String r7 = r1.substring(r3)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            com.uqm.crashsight.proguard.d r5 = com.uqm.crashsight.proguard.d.a()     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            java.lang.String r6 = "t_ui"
            r8 = 0
            r9 = 0
            r10 = 1
            int r1 = r5.a(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            java.lang.String r3 = "[Database] deleted %s error data %d"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            java.lang.String r6 = "t_ui"
            r5[r4] = r6     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            r4 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            r5[r4] = r1     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
            com.uqm.crashsight.proguard.m.d(r3, r5)     // Catch: java.lang.Throwable -> La3 java.lang.Throwable -> Lbb
        L9d:
            if (r13 == 0) goto La2
            r13.close()
        La2:
            return r2
        La3:
            r1 = move-exception
            goto Lac
        La5:
            r13 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto Lbc
        Laa:
            r1 = move-exception
            r13 = r0
        Lac:
            boolean r2 = com.uqm.crashsight.proguard.m.a(r1)     // Catch: java.lang.Throwable -> Lbb
            if (r2 != 0) goto Lb5
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
        Lb5:
            if (r13 == 0) goto Lba
            r13.close()
        Lba:
            return r0
        Lbb:
            r0 = move-exception
        Lbc:
            if (r13 == 0) goto Lc1
            r13.close()
        Lc1:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.biz.a.a(java.lang.String):java.util.List");
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            UserInfoBean userInfoBean = list.get(i);
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(userInfoBean.f6548a);
        }
        String sb2 = sb.toString();
        String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
        sb.setLength(0);
        try {
            m.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(d.a().a("t_ui", substring, (String[]) null, (com.uqm.crashsight.proguard.c) null, true)));
        } catch (Throwable th) {
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f6548a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f6548a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", q.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) q.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f6548a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
