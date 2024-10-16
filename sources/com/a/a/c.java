package com.a.a;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class c implements com.a.a.a.a {

    /* renamed from: a, reason: collision with root package name */
    protected com.a.a.a.d f937a;
    private final Context b;
    private AtomicReference<com.a.a.a.c> c = new AtomicReference<>(null);
    private com.a.a.a.b d = new a();

    public static String a(String str) {
        return str.replace("\r", "\\r");
    }

    public static String b(String str) {
        return str.replace("</", "<\\/");
    }

    public static String c(String str) {
        return str.replace("\n", "\\n");
    }

    public static String d(String str) {
        return str.replace("'", "\\'");
    }

    public static String e(String str) {
        return str.replace("\\", "\\\\");
    }

    public static String f(String str) {
        return String.format("%s.returnResultToJava(eval('try{%s}catch(e){\"%s\"+e}'));", "evgeniiJsEvaluator", a(c(b(d(e(str))))), "evgeniiJsEvaluatorException");
    }

    public c(Context context) {
        this.b = context;
    }

    public void a(String str, com.a.a.a.c cVar) {
        String f = f(str);
        this.c.set(cVar);
        a().a(f);
    }

    public com.a.a.a.d a() {
        if (this.f937a == null) {
            this.f937a = new d(this.b, this);
        }
        return this.f937a;
    }

    @Override // com.a.a.a.a
    public void g(final String str) {
        final com.a.a.a.c andSet = this.c.getAndSet(null);
        if (andSet == null) {
            return;
        }
        this.d.a(new Runnable() { // from class: com.a.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 != null && str2.startsWith("evgeniiJsEvaluatorException")) {
                    andSet.b(str.substring(27));
                } else {
                    andSet.a(str);
                }
            }
        });
    }
}
