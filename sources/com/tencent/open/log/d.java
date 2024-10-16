package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* renamed from: com.tencent.open.log.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0212d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static c b() {
            if (a()) {
                return c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private File f6390a;
        private long b;
        private long c;

        public File a() {
            return this.f6390a;
        }

        public void a(File file) {
            this.f6390a = file;
        }

        public long b() {
            return this.b;
        }

        public void a(long j) {
            this.b = j;
        }

        public long c() {
            return this.c;
        }

        public void b(long j) {
            this.c = j;
        }

        public static c b(File file) {
            c cVar = new c();
            cVar.a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            cVar.a(blockCount * blockSize);
            cVar.b(availableBlocks * blockSize);
            return cVar;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }
    }

    public static boolean a(String str) {
        return str.contains("access_token") || str.contains("pay_token") || str.contains("pfkey") || str.contains("expires_in") || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    public static boolean a(Bundle bundle) {
        return bundle.containsKey("access_token") || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey("expires_in") || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }

    public static Bundle b(Bundle bundle) {
        if (!a(bundle)) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove("access_token");
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove("expires_in");
        bundle2.remove("openid");
        bundle2.remove("proxy_code");
        bundle2.remove("proxy_expires_in");
        return bundle2;
    }
}
