package okhttp3;

import com.helpshift.common.domain.network.NetworkConstants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class q extends aa {

    /* renamed from: a, reason: collision with root package name */
    private static final v f7152a = v.a(NetworkConstants.contentType);
    private final List<String> b;
    private final List<String> c;

    q(List<String> list, List<String> list2) {
        this.b = okhttp3.internal.c.a(list);
        this.c = okhttp3.internal.c.a(list2);
    }

    public int a() {
        return this.b.size();
    }

    public String a(int i) {
        return this.b.get(i);
    }

    public String b(int i) {
        return this.c.get(i);
    }

    public String c(int i) {
        return t.a(b(i), true);
    }

    @Override // okhttp3.aa
    public v b() {
        return f7152a;
    }

    @Override // okhttp3.aa
    public long c() {
        return a((okio.d) null, true);
    }

    @Override // okhttp3.aa
    public void a(okio.d dVar) throws IOException {
        a(dVar, false);
    }

    private long a(@Nullable okio.d dVar, boolean z) {
        okio.c c;
        if (z) {
            c = new okio.c();
        } else {
            c = dVar.c();
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c.i(38);
            }
            c.b(this.b.get(i));
            c.i(61);
            c.b(this.c.get(i));
        }
        if (!z) {
            return 0L;
        }
        long b = c.b();
        c.t();
        return b;
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f7153a;
        private final List<String> b;
        private final Charset c;

        public a() {
            this(null);
        }

        public a(Charset charset) {
            this.f7153a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f7153a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f7153a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            this.b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            return this;
        }

        public q a() {
            return new q(this.f7153a, this.b);
        }
    }
}
