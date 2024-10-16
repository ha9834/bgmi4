package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes2.dex */
public class b implements i {

    /* renamed from: a, reason: collision with root package name */
    private long f5382a;
    private long b;
    private long c;
    private long d;
    private int f;
    private j g;
    private long e = 0;
    private Vector<String> h = new Vector<>();
    private Vector<String> i = new Vector<>();
    private Vector<Long> j = new Vector<>();

    public b(Context context, h hVar) {
        this.g = new j(context.getSharedPreferences("com.google.android.vending.licensing.APKExpansionPolicy", 0), hVar);
        this.f = Integer.parseInt(this.g.b("lastResponse", Integer.toString(291)));
        this.f5382a = Long.parseLong(this.g.b("validityTimestamp", "0"));
        this.b = Long.parseLong(this.g.b("retryUntil", "0"));
        this.c = Long.parseLong(this.g.b("maxRetries", "0"));
        this.d = Long.parseLong(this.g.b("retryCount", "0"));
    }

    public void a() {
        this.g.a("lastResponse", Integer.toString(291));
        b("0");
        c("0");
        a(Long.parseLong("0"));
        a("0");
        this.g.a();
    }

    @Override // com.google.android.vending.licensing.i
    public void a(int i, k kVar) {
        if (i != 291) {
            a(0L);
        } else {
            a(this.d + 1);
        }
        if (i == 256) {
            Map<String, String> d = d(kVar.g);
            this.f = i;
            a(Long.toString(System.currentTimeMillis() + 60000));
            for (String str : d.keySet()) {
                if (str.equals("VT")) {
                    a(d.get(str));
                } else if (str.equals("GT")) {
                    b(d.get(str));
                } else if (str.equals("GR")) {
                    c(d.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    a(Integer.parseInt(str.substring(8)) - 1, d.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    b(Integer.parseInt(str.substring(9)) - 1, d.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    a(Integer.parseInt(str.substring(9)) - 1, Long.parseLong(d.get(str)));
                }
            }
        } else if (i == 561) {
            a("0");
            b("0");
            c("0");
        }
        d(i);
        this.g.a();
    }

    private void d(int i) {
        this.e = System.currentTimeMillis();
        this.f = i;
        this.g.a("lastResponse", Integer.toString(i));
    }

    private void a(long j) {
        this.d = j;
        this.g.a("retryCount", Long.toString(j));
    }

    private void a(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(valueOf.longValue());
        }
        this.f5382a = valueOf.longValue();
        this.g.a("validityTimestamp", str);
    }

    private void b(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
            str = "0";
            l = 0L;
        }
        this.b = l.longValue();
        this.g.a("retryUntil", str);
    }

    private void c(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
            str = "0";
            l = 0L;
        }
        this.c = l.longValue();
        this.g.a("maxRetries", str);
    }

    public int b() {
        return this.h.size();
    }

    public String a(int i) {
        if (i < this.h.size()) {
            return this.h.elementAt(i);
        }
        return null;
    }

    public void a(int i, String str) {
        if (i >= this.h.size()) {
            this.h.setSize(i + 1);
        }
        this.h.set(i, str);
    }

    public String b(int i) {
        if (i < this.i.size()) {
            return this.i.elementAt(i);
        }
        return null;
    }

    public void b(int i, String str) {
        if (i >= this.i.size()) {
            this.i.setSize(i + 1);
        }
        this.i.set(i, str);
    }

    public long c(int i) {
        if (i < this.j.size()) {
            return this.j.elementAt(i).longValue();
        }
        return -1L;
    }

    public void a(int i, long j) {
        if (i >= this.j.size()) {
            this.j.setSize(i + 1);
        }
        this.j.set(i, Long.valueOf(j));
    }

    @Override // com.google.android.vending.licensing.i
    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        int i = this.f;
        if (i == 256) {
            if (currentTimeMillis <= this.f5382a) {
                return true;
            }
        } else if (i == 291 && currentTimeMillis < this.e + 60000) {
            return currentTimeMillis <= this.b || this.d <= this.c;
        }
        return false;
    }

    private Map<String, String> d(String str) {
        HashMap hashMap = new HashMap();
        try {
            com.google.android.vending.licensing.util.b.a(new URI("?" + str), hashMap);
        } catch (URISyntaxException unused) {
            Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }
}
