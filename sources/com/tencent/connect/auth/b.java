package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f6180a;
    static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();
    private static int e = 0;
    public HashMap<String, a> b = new HashMap<>();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IUiListener f6181a;
        public com.tencent.connect.auth.a b;
        public String c;
    }

    public static b a() {
        if (f6180a == null) {
            f6180a = new b();
        }
        return f6180a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String a(a aVar) {
        int b = b();
        try {
            this.b.put("" + b, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            double random = Math.random();
            double d2 = length;
            Double.isNaN(d2);
            stringBuffer.append(charArray[(int) (random * d2)]);
        }
        return stringBuffer.toString();
    }
}
