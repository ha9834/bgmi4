package com.gamesafe.ano;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class MainThreadDispatcher2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f1091a;

        public a(String str) {
            this.f1091a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainThreadDispatcher2.c(this.f1091a);
        }
    }

    public static void SendCmd(String str) {
        if (str.startsWith(com.gamesafe.ano.a.a("npw:"))) {
            c(str.substring(4));
        } else {
            new Handler(Looper.getMainLooper()).post(b(str));
        }
    }

    private static Runnable b(String str) {
        return new a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        AnoJavaMethod.sendCmd(str);
    }
}
