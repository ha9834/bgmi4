package com.gamesafe.ano;

import android.app.Activity;
import android.content.Context;
import com.gamesafe.ano.g;

/* loaded from: classes.dex */
public class h {
    private static volatile h d;

    /* renamed from: a, reason: collision with root package name */
    public g.a f1097a = new i(this);
    private g b;
    private String c;

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    private void a(Context context, String str, String str2, String str3, g.a aVar) {
        this.b = new l(context, str, str2, str3, aVar);
        this.b.a();
    }

    private void a(g gVar, String str) {
        if (gVar != null && this.b == gVar) {
            if (str == null || str.equals(this.c)) {
                this.b = null;
                gVar.c();
            }
        }
    }

    private void b(Context context, String str, String str2, String str3, g.a aVar) {
        String[] split = str3.split(";");
        if (split == null || split.length < 2) {
            b.a(a.a("*#07#:OnnNyfHznnvbzWjs.kvmnzViyNcjr xhy zmm"));
            return;
        }
        String str4 = split[0];
        int parseInt = Integer.parseInt(split[1]);
        int parseInt2 = Integer.parseInt(split[2]);
        if (parseInt2 > parseInt) {
            return;
        }
        this.b = new d(context, str, str2, str4, parseInt, parseInt2, aVar);
        this.b.a();
    }

    private void b(String str) {
        a(this.b, str.substring(12));
    }

    private void c(String str) {
        try {
            d(str);
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        String str2;
        if (str.startsWith(a.a("hnbwjs:"))) {
            String[] split = str.substring(7).split("\\|");
            if (split == null || split.length < 8) {
                str2 = "*#07#:OnnNyfHznnvbzWjs.kvmnzViyNcjr xhy zmm";
            } else {
                String str3 = split[0];
                String str4 = split[1];
                String str5 = split[2];
                String str6 = split[3];
                String str7 = split[4];
                String str8 = split[5];
                String str9 = split[6];
                String str10 = split[7];
                Activity d2 = c.d();
                if (d2 != null) {
                    if (this.b != null) {
                        if (!str10.equals("1")) {
                            return;
                        } else {
                            a(this.b, (String) null);
                        }
                    }
                    this.c = str3;
                    if (this.c.equals("1010")) {
                        a(d2, str4, str5, str7, this.f1097a);
                        return;
                    } else {
                        if (this.c.equals("1011")) {
                            b(d2, str4, str5, str6, this.f1097a);
                            return;
                        }
                        return;
                    }
                }
                str2 = "*#07#:bzoXpmmzioVxodqdot avdgzy";
            }
            b.a(a.a(str2));
        }
    }

    public void a(String str) {
        if (str.startsWith(a.a("hnbwjs:"))) {
            c(str);
        } else if (str.startsWith(a.a("cdyz_hnbwjs:"))) {
            b(str);
        }
    }
}
