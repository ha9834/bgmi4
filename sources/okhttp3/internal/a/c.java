package okhttp3.internal.a;

import com.amazonaws.services.s3.Headers;
import com.helpshift.util.ErrorReportProvider;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.s;
import okhttp3.z;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final z f7064a;

    @Nullable
    public final ab b;

    c(z zVar, ab abVar) {
        this.f7064a = zVar;
        this.b = abVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (r3.j().d() == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.ab r3, okhttp3.z r4) {
        /*
            int r0 = r3.b()
            r1 = 0
            switch(r0) {
                case 200: goto L30;
                case 203: goto L30;
                case 204: goto L30;
                case 300: goto L30;
                case 301: goto L30;
                case 302: goto L9;
                case 307: goto L9;
                case 308: goto L30;
                case 404: goto L30;
                case 405: goto L30;
                case 410: goto L30;
                case 414: goto L30;
                case 501: goto L30;
                default: goto L8;
            }
        L8:
            goto L46
        L9:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.j()
            int r0 = r0.c()
            r2 = -1
            if (r0 != r2) goto L30
            okhttp3.d r0 = r3.j()
            boolean r0 = r0.e()
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.j()
            boolean r0 = r0.d()
            if (r0 == 0) goto L46
        L30:
            okhttp3.d r3 = r3.j()
            boolean r3 = r3.b()
            if (r3 != 0) goto L45
            okhttp3.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L45
            r1 = 1
        L45:
            return r1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.a.c.a(okhttp3.ab, okhttp3.z):boolean");
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f7065a;
        final z b;
        final ab c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, z zVar, ab abVar) {
            this.l = -1;
            this.f7065a = j;
            this.b = zVar;
            this.c = abVar;
            if (abVar != null) {
                this.i = abVar.k();
                this.j = abVar.l();
                s f = abVar.f();
                int a2 = f.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = f.a(i);
                    String b = f.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = okhttp3.internal.b.d.a(b);
                        this.e = b;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.h = okhttp3.internal.b.d.a(b);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.f = okhttp3.internal.b.d.a(b);
                        this.g = b;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = okhttp3.internal.b.e.b(b, -1);
                    }
                }
            }
        }

        public c a() {
            c b = b();
            return (b.f7064a == null || !this.b.f().i()) ? b : new c(null, null);
        }

        private c b() {
            String str;
            if (this.c == null) {
                return new c(this.b, null);
            }
            if (this.b.g() && this.c.e() == null) {
                return new c(this.b, null);
            }
            if (!c.a(this.c, this.b)) {
                return new c(this.b, null);
            }
            okhttp3.d f = this.b.f();
            if (f.a() || a(this.b)) {
                return new c(this.b, null);
            }
            okhttp3.d j = this.c.j();
            long d = d();
            long c = c();
            if (f.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(f.c()));
            }
            long j2 = 0;
            long millis = f.h() != -1 ? TimeUnit.SECONDS.toMillis(f.h()) : 0L;
            if (!j.f() && f.g() != -1) {
                j2 = TimeUnit.SECONDS.toMillis(f.g());
            }
            if (!j.a()) {
                long j3 = millis + d;
                if (j3 < j2 + c) {
                    ab.a h = this.c.h();
                    if (j3 >= c) {
                        h.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d > ErrorReportProvider.BATCH_TIME && e()) {
                        h.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, h.a());
                }
            }
            String str2 = this.k;
            if (str2 != null) {
                str = Headers.GET_OBJECT_IF_NONE_MATCH;
            } else if (this.f != null) {
                str = Headers.GET_OBJECT_IF_MODIFIED_SINCE;
                str2 = this.g;
            } else if (this.d != null) {
                str = Headers.GET_OBJECT_IF_MODIFIED_SINCE;
                str2 = this.e;
            } else {
                return new c(this.b, null);
            }
            s.a b = this.b.c().b();
            okhttp3.internal.a.f7061a.a(b, str, str2);
            return new c(this.b.e().a(b.a()).b(), this.c);
        }

        private long c() {
            long j;
            long j2;
            if (this.c.j().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                Date date = this.d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f == null || this.c.a().a().l() != null) {
                return 0L;
            }
            Date date2 = this.d;
            if (date2 != null) {
                j = date2.getTime();
            } else {
                j = this.i;
            }
            long time2 = j - this.f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long d() {
            Date date = this.d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            if (this.l != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(this.l));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f7065a - j);
        }

        private boolean e() {
            return this.c.j().c() == -1 && this.h == null;
        }

        private static boolean a(z zVar) {
            return (zVar.a(Headers.GET_OBJECT_IF_MODIFIED_SINCE) == null && zVar.a(Headers.GET_OBJECT_IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
