package com.nostra13.universalimageloader.b;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class e {
    public static File a(Context context) {
        return a(context, true);
    }

    public static File a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError unused) {
            str = "";
        } catch (NullPointerException unused2) {
            str = "";
        }
        File c = (z && "mounted".equals(str) && d(context)) ? c(context) : null;
        if (c == null) {
            c = context.getCacheDir();
        }
        if (c != null) {
            return c;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        c.c("Can't define system cache directory! '%s' will be used.", str2);
        return new File(str2);
    }

    public static File b(Context context) {
        return a(context, "uil-images");
    }

    public static File a(Context context, String str) {
        File a2 = a(context);
        File file = new File(a2, str);
        return (file.exists() || file.mkdir()) ? file : a2;
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                c.c("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                c.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    private static boolean d(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
