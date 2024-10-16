package com.ihoc.mgpa.i;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile l f5619a;

    private l() {
    }

    public static l a() {
        if (f5619a == null) {
            synchronized (l.class) {
                if (f5619a == null) {
                    f5619a = new l();
                }
            }
        }
        return f5619a;
    }

    public void a(a aVar, HashMap<String, String> hashMap) {
        com.ihoc.mgpa.n.m.a(aVar.a(), hashMap);
        com.ihoc.mgpa.l.a.a.a().a(2007, aVar.a(), hashMap);
    }

    public void a(String str, String str2) {
        com.ihoc.mgpa.l.a.a.a().a(str, str2);
    }
}
