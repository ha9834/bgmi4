package com.subao.common.e;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.subao.common.e.ad;
import com.subao.common.e.f;
import com.subao.common.i.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ah extends ag {

    /* renamed from: a, reason: collision with root package name */
    private final a f5962a;
    private final b b;

    /* loaded from: classes2.dex */
    public interface a {
        void a(b bVar);

        void a(String str);
    }

    @Override // com.subao.common.e.ad
    protected String a() {
        return "configs/misc";
    }

    @Override // com.subao.common.e.ad
    protected String b() {
        return "misc-config";
    }

    ah(ad.a aVar, a aVar2) {
        super(aVar);
        this.b = new b();
        this.f5962a = aVar2;
    }

    public static void a(ad.a aVar, a aVar2) {
        ag.a((ag) new ah(aVar, aVar2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.subao.common.e.ag
    public void b(ae aeVar) {
        if (this.f5962a != null) {
            this.f5962a.a((aeVar == null || aeVar.c == null) ? "" : new String(aeVar.c));
        }
        super.b(aeVar);
    }

    @Override // com.subao.common.e.ag
    protected void a(String str, String str2) {
        this.b.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ag
    public void a(boolean z) {
        super.a(z);
        d.a.a(b.a(this.b.f5963a), b.a(this.b.b), b.a(this.b.d), b.a(this.b.c));
        com.subao.common.b.b.a(this.b.e);
        ar.a(this.b.f);
        com.subao.common.l.a.a().a(this.b.a(), this.b.b());
        a aVar = this.f5962a;
        if (aVar != null) {
            aVar.a(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean e;
        private String f;
        private f.a[] g;
        private f.a[] h;
        private int i;

        /* renamed from: a, reason: collision with root package name */
        private int f5963a = 100;
        private int b = 1000;
        private int c = 10000;
        private int d = 0;
        private final Map<String, String> j = new HashMap(4);

        private static boolean b(String str) {
            return "1".equals(str) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str);
        }

        static boolean a(int i) {
            return a(i, System.currentTimeMillis());
        }

        static boolean a(int i, long j) {
            if (i <= 0) {
                return false;
            }
            return i >= 10000 || ((int) (j & 16777215)) % 10000 < i;
        }

        void a(String str, String str2) {
            try {
                if ("er_tg".equals(str)) {
                    this.f5963a = Integer.parseInt(str2);
                } else if ("er_auth".equals(str)) {
                    this.b = Integer.parseInt(str2);
                } else if ("er_was".equals(str)) {
                    this.c = Integer.parseInt(str2);
                } else if ("er_ml".equals(str)) {
                    this.d = Integer.parseInt(str2);
                } else if ("auth_http".equals(str)) {
                    this.e = b(str2);
                } else if ("acc_info_up_proto".equals(str)) {
                    this.f = str2;
                } else if ("qos_zte_primary".equals(str)) {
                    this.g = c(str2);
                } else if ("qos_zte_secondary".equals(str)) {
                    this.h = c(str2);
                } else if ("auth_cache_time".equals(str)) {
                    this.i = Integer.parseInt(str2);
                } else {
                    this.j.put(str, str2);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        private static f.a[] c(String str) {
            f.a aVar;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(",");
            ArrayList arrayList = new ArrayList(split.length);
            for (String str2 : split) {
                int indexOf = str2.indexOf(58);
                int i = -1;
                if (indexOf < 0) {
                    aVar = new f.a(str2, -1);
                } else {
                    try {
                        i = Integer.parseInt(str2.substring(indexOf + 1));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    aVar = new f.a(str2.substring(0, indexOf), i);
                }
                arrayList.add(aVar);
            }
            return (f.a[]) arrayList.toArray(new f.a[arrayList.size()]);
        }

        f.a[] a() {
            return this.g;
        }

        f.a[] b() {
            return this.h;
        }

        public String a(String str) {
            return this.j.get(str);
        }
    }
}
