package com.tencent.open.a;

import java.io.IOException;
import okhttp3.ab;
import okhttp3.ac;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ab f6360a;
    private String b = null;
    private int c;
    private int d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ab abVar, int i) {
        this.f6360a = abVar;
        this.d = i;
        this.c = abVar.b();
        ac g = this.f6360a.g();
        if (g != null) {
            this.e = (int) g.b();
        } else {
            this.e = 0;
        }
    }

    public String a() throws IOException {
        if (this.b == null) {
            ac g = this.f6360a.g();
            if (g != null) {
                this.b = g.g();
            }
            if (this.b == null) {
                this.b = "";
            }
        }
        return this.b;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }
}
