package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.pubg.imobile.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Random f5365a = new Random(SystemClock.uptimeMillis());
    private static final Pattern b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int a(int i) {
        switch (i) {
            case 1:
                return R.string.state_idle;
            case 2:
                return R.string.state_fetching_url;
            case 3:
                return R.string.state_connecting;
            case 4:
                return R.string.state_downloading;
            case 5:
                return R.string.state_completed;
            case 6:
                return R.string.state_paused_network_unavailable;
            case 7:
                return R.string.state_paused_by_request;
            case 8:
                return R.string.state_paused_wifi_disabled;
            case 9:
                return R.string.state_paused_wifi_unavailable;
            case 10:
                return R.string.state_paused_wifi_disabled;
            case 11:
                return R.string.state_paused_wifi_unavailable;
            case 12:
                return R.string.state_paused_roaming;
            case 13:
                return R.string.state_paused_network_setup_failure;
            case 14:
                return R.string.state_paused_sdcard_unavailable;
            case 15:
                return R.string.state_failed_unlicensed;
            case 16:
                return R.string.state_failed_fetching_url;
            case 17:
                return R.string.state_failed_sdcard_full;
            case 18:
                return R.string.state_failed_cancelled;
            default:
                return R.string.state_unknown;
        }
    }

    public static File a(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for " + str);
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    public static boolean b(String str) {
        String replaceFirst = str.replaceFirst("/+", "/");
        return replaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) || replaceFirst.startsWith(Environment.getExternalStorageDirectory().toString());
    }

    public static String a(long j, long j2) {
        if (j2 == 0) {
            return "";
        }
        return String.format("%.2f", Float.valueOf(((float) j) / 1048576.0f)) + "MB /" + String.format("%.2f", Float.valueOf(((float) j2) / 1048576.0f)) + "MB";
    }

    public static String b(long j, long j2) {
        if (j2 == 0) {
            return "";
        }
        return Long.toString((j * 100) / j2) + "%";
    }

    public static String a(float f) {
        return String.format("%.2f", Float.valueOf((f * 1000.0f) / 1024.0f));
    }

    public static String a(long j) {
        SimpleDateFormat simpleDateFormat;
        if (j > 3600000) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        }
        return simpleDateFormat.format(new Date(j - TimeZone.getDefault().getRawOffset()));
    }

    public static String a(Context context, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "main." : "patch.");
        sb.append(str);
        sb.append(".");
        sb.append(context.getPackageName());
        sb.append(".obb");
        return sb.toString();
    }

    public static String a(Context context, String str) {
        return b(context) + File.separator + str;
    }

    public static String b(Context context, String str) {
        return a(context) + File.separator + str;
    }

    public static String a(Context context) {
        return Environment.getExternalStorageDirectory().toString() + a.b + context.getPackageName();
    }

    public static String b(Context context) {
        return Environment.getExternalStorageDirectory().toString() + a.f5357a + context.getPackageName();
    }

    public static boolean a(Context context, String str, long j, boolean z) {
        return a(context, new File(a(context, str)), j, z);
    }

    public static boolean b(Context context, String str, long j, boolean z) {
        return a(context, new File(b(context, str)), j, z);
    }

    public static boolean a(Context context, File file, long j, boolean z) {
        if (!file.exists()) {
            return false;
        }
        if (file.length() == j) {
            return true;
        }
        if (!z) {
            return false;
        }
        file.delete();
        return false;
    }
}
