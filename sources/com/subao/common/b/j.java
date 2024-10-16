package com.subao.common.b;

import android.util.JsonReader;
import com.subao.common.e.an;
import com.subao.common.e.r;
import com.subao.common.intf.QueryOriginUserStateCallback;
import com.subao.common.intf.UserInfo;
import com.subao.common.j.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* loaded from: classes2.dex */
public class j {
    public static void a(com.subao.common.j.l lVar, an anVar, String str, UserInfo userInfo, long j, QueryOriginUserStateCallback queryOriginUserStateCallback, Object obj) {
        if (queryOriginUserStateCallback == null) {
            throw new NullPointerException();
        }
        if (lVar != null && !lVar.b()) {
            queryOriginUserStateCallback.onOriginUserState(userInfo, obj, 1005, 0, null);
        } else {
            com.subao.common.m.d.a(new a(anVar, str, userInfo, j, queryOriginUserStateCallback, obj));
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final an f5927a;
        private final String b;
        private final UserInfo c;
        private final int d;
        private final QueryOriginUserStateCallback e;
        private final Object f;

        a(an anVar, String str, UserInfo userInfo, long j, QueryOriginUserStateCallback queryOriginUserStateCallback, Object obj) {
            this.f5927a = anVar == null ? r.c : anVar;
            this.b = str;
            this.c = userInfo;
            this.d = (int) j;
            this.e = queryOriginUserStateCallback;
            this.f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0164a c0164a;
            int i;
            int i2;
            String str;
            int i3;
            try {
                b.c a2 = a();
                if (a2.f6066a != 200) {
                    c0164a = null;
                    i3 = 1008;
                } else {
                    c0164a = C0164a.a(a2);
                    i3 = 0;
                }
                i = i3;
            } catch (IOException e) {
                e.printStackTrace();
                c0164a = null;
                i = 1006;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                c0164a = null;
                i = 1007;
            }
            if (c0164a == null) {
                str = null;
                i2 = 0;
            } else {
                i2 = c0164a.f5928a;
                str = c0164a.b;
            }
            this.e.onOriginUserState(this.c, this.f, i, i2, str);
        }

        private b.c a() {
            int i = this.d;
            return com.subao.common.j.b.a(new com.subao.common.j.b(i, i).a(new URL(this.f5927a.f5971a, this.f5927a.b, this.f5927a.c, String.format("/api/v1/%s/tokeninfo", this.b)), b.EnumC0172b.POST, b.a.JSON.e), com.subao.common.n.g.b(this.c));
        }

        /* renamed from: com.subao.common.b.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0164a {

            /* renamed from: a, reason: collision with root package name */
            final int f5928a;
            final String b;

            private C0164a(int i, String str) {
                this.f5928a = i;
                this.b = str;
            }

            static C0164a a(b.c cVar) {
                String str = null;
                if (cVar == null || cVar.b == null || cVar.b.length < 2) {
                    return null;
                }
                int i = 0;
                JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(cVar.b)));
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        if ("origin_code".equals(nextName)) {
                            i = jsonReader.nextInt();
                        } else if ("origin_body".equals(nextName)) {
                            str = com.subao.common.n.g.b(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    com.subao.common.e.a(jsonReader);
                    return new C0164a(i, str);
                } catch (Throwable th) {
                    com.subao.common.e.a(jsonReader);
                    throw th;
                }
            }
        }
    }
}
