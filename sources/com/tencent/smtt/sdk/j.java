package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mtt.MttTraceEvent;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private static j b;

    /* renamed from: a, reason: collision with root package name */
    public static ThreadLocal<Integer> f6525a = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.j.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    };
    private static Handler c = null;
    private static int d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                synchronized (j.class) {
                    if (b == null) {
                        b = new j();
                    }
                }
            }
            jVar = b;
        }
        return jVar;
    }

    public int a(boolean z, Context context) {
        if (z || f6525a.get().intValue() <= 0) {
            f6525a.set(Integer.valueOf(b(context)));
        }
        return f6525a.get().intValue();
    }

    public String a(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(d(context), "tbs.conf");
            if (!file.exists()) {
                return null;
            }
            Properties properties = new Properties();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                String property = properties.getProperty(str);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return property;
            } catch (Exception unused2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(c(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property != null) {
                    int parseInt = Integer.parseInt(property);
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return parseInt;
                }
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return 0;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Context context) {
        TbsLog.d("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock");
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(d(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e.toString());
                        }
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (d == 0) {
                        d = parseInt;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                    }
                    return parseInt;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e4.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e5.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    File a(Context context, Context context2) {
        MttTraceEvent.begin(256, "TbsInstaller.getTbsCoreShareDir");
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share");
        if (!file.isDirectory() && ((context == null || !TbsShareManager.isThirdPartyApp(context)) && !file.mkdir())) {
            TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
            return null;
        }
        MttTraceEvent.end(256, "TbsInstaller.getTbsCoreShareDir");
        return file;
    }

    File c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    File d(Context context) {
        return a((Context) null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File e(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }
}
