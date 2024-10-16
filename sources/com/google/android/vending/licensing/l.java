package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class l implements i {

    /* renamed from: a, reason: collision with root package name */
    private long f5390a;
    private long b;
    private long c;
    private long d;
    private long e = 0;
    private int f;
    private j g;

    public l(Context context, h hVar) {
        this.g = new j(context.getSharedPreferences("com.google.android.vending.licensing.ServerManagedPolicy", 0), hVar);
        this.f = Integer.parseInt(this.g.b("lastResponse", Integer.toString(291)));
        this.f5390a = Long.parseLong(this.g.b("validityTimestamp", "0"));
        this.b = Long.parseLong(this.g.b("retryUntil", "0"));
        this.c = Long.parseLong(this.g.b("maxRetries", "0"));
        this.d = Long.parseLong(this.g.b("retryCount", "0"));
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
            a(d.get("VT"));
            b(d.get("GT"));
            c(d.get("GR"));
        } else if (i == 561) {
            a("0");
            b("0");
            c("0");
        }
        a(i);
        this.g.a();
    }

    private void a(int i) {
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
            Log.w("ServerManagedPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(valueOf.longValue());
        }
        this.f5390a = valueOf.longValue();
        this.g.a("validityTimestamp", str);
    }

    private void b(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "License retry timestamp (GT) missing, grace period disabled");
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
            Log.w("ServerManagedPolicy", "Licence retry count (GR) missing, grace period disabled");
            str = "0";
            l = 0L;
        }
        this.c = l.longValue();
        this.g.a("maxRetries", str);
    }

    @Override // com.google.android.vending.licensing.i
    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        int i = this.f;
        if (i == 256) {
            if (currentTimeMillis <= this.f5390a) {
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
            Log.w("ServerManagedPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }
}
