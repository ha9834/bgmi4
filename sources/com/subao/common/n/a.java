package com.subao.common.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context, String str) {
        return a(context, str, null);
    }

    static boolean a(Context context, String str, C0178a c0178a) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Intent b2 = b(context, str);
            if (b2 == null) {
                return false;
            }
            if (c0178a == null) {
                c0178a = new C0178a();
            }
            if (c0178a.a(b2, null)) {
                return true;
            }
            context.startActivity(b2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getLaunchIntentForPackage(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String a(Intent intent) {
        ComponentName component;
        if (intent == null || (component = intent.getComponent()) == null) {
            return null;
        }
        return String.format("%s/%s", component.getPackageName(), component.getClassName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.subao.common.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0178a {
        C0178a() {
        }

        public boolean a(Intent intent, b bVar) {
            String a2 = a.a(intent);
            if (a2 == null) {
                return false;
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.a(new String[]{"am", "start", "--user", "0", a2});
            try {
                bVar.a(true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bVar.a().getInputStream()));
                boolean z = false;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return z;
                    }
                    String lowerCase = readLine.toLowerCase(Locale.US);
                    if (lowerCase.contains("starting: intent")) {
                        z = true;
                    } else if (lowerCase.contains("error") || lowerCase.contains("exception")) {
                        z = false;
                    }
                }
            } catch (IOException unused) {
                return false;
            } catch (RuntimeException unused2) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final ProcessBuilder f6132a = new ProcessBuilder(new String[0]);

        b() {
        }

        public Process a() {
            return this.f6132a.start();
        }

        public void a(boolean z) {
            this.f6132a.redirectErrorStream(z);
        }

        public void a(String[] strArr) {
            this.f6132a.command(strArr);
        }
    }
}
