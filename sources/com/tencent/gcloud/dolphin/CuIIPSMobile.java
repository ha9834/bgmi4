package com.tencent.gcloud.dolphin;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.google.android.gms.drive.DriveFile;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class CuIIPSMobile {
    private static final String PROVIDER_NAME = ".ApolloFileprovider";
    private static final String RES_SUFFIX = ".res";
    private static final String TAG = "CuIIPSMobile";
    PowerManager.WakeLock wakeLock = null;
    WifiManager.WifiLock wifiLock = null;

    public static String GetApkAbsPath(Object obj) {
        Activity activity = (Activity) obj;
        try {
            String str = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 0).sourceDir;
            Log.v("GetApkAbsPath", "getapkpath success, path:" + str);
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "GetApkAbsPath getapkpath failed");
            return "error";
        }
    }

    public static boolean copyResFileFromApp(Object obj, String str, String str2) {
        String str3;
        String str4;
        Activity activity = (Activity) obj;
        if (activity == null) {
            str3 = TAG;
            str4 = "Dolphin copyResFileFromApp the activity is null";
        } else {
            Context applicationContext = activity.getApplicationContext();
            if (str == null || str.length() == 0) {
                str3 = TAG;
                str4 = "Dolphin copyResFileFromApp the srcPath is null";
            } else if (str2 == null || str2.length() == 0) {
                str3 = TAG;
                str4 = "Dolphin copyResFileFromApp the dstPath is null";
            } else {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.length());
                String str5 = str2 + substring;
                Log.i(TAG, "copyResFileFromApp srcFileName:" + substring + ",dstAbsPath" + str5);
                try {
                    InputStream open = applicationContext.getAssets().open(substring);
                    File file = new File(str2);
                    if (!file.exists() && !file.mkdirs()) {
                        Log.e(TAG, "Dolphin copyResFileFromApp dstFileDir:" + file + "makedir failed");
                        return false;
                    }
                    File file2 = new File(str5);
                    if (file2.exists() && !file2.delete()) {
                        Log.e(TAG, "Dolphin copyResFileFromApp dstFile:" + file2 + "delete failed");
                        return false;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            fileOutputStream.flush();
                            open.close();
                            fileOutputStream.close();
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        Log.e(str3, str4);
        return false;
    }

    public static int installAPK(String str, Object obj) {
        Uri fromFile;
        Activity activity = (Activity) obj;
        if (activity == null) {
            Log.e(TAG, "installAPK the activity is null");
            return -1;
        }
        Context applicationContext = activity.getApplicationContext();
        if (str == null || str.length() == 0 || !isFileExist(str)) {
            return -1;
        }
        File file = new File(str);
        if (!str.startsWith(Environment.getExternalStorageDirectory().getPath())) {
            String path = applicationContext.getFilesDir().getPath();
            for (String absolutePath = file.getAbsolutePath(); absolutePath != null && !path.equals(absolutePath); absolutePath = new File(absolutePath).getParent()) {
                try {
                    Runtime.getRuntime().exec("chmod 777 " + absolutePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    return -2;
                }
            }
        }
        Intent intent = new Intent();
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.setAction("android.intent.action.VIEW");
        int i = applicationContext.getApplicationInfo().targetSdkVersion;
        Log.d(TAG, "targetVersion=" + i);
        if (i < 24 || Build.VERSION.SDK_INT < 24) {
            fromFile = Uri.fromFile(file);
        } else {
            intent.addFlags(1);
            fromFile = FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + PROVIDER_NAME, file);
        }
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        try {
            applicationContext.startActivity(intent);
            return 0;
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            return -3;
        }
    }

    public static boolean isFileExist(String str) {
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public boolean acquireWakeLock(Object obj, int i) {
        Activity activity = (Activity) obj;
        if (this.wakeLock != null) {
            return false;
        }
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        if (i == 1) {
            this.wakeLock = powerManager.newWakeLock(536870913, "PostLocationService");
        }
        if (i == 2) {
            this.wakeLock = powerManager.newWakeLock(536870918, "PostLocationService");
        }
        if (i == 3) {
            this.wakeLock = powerManager.newWakeLock(536870922, "PostLocationService");
        }
        if (i == 4) {
            this.wakeLock = powerManager.newWakeLock(536870938, "PostLocationService");
        }
        if (i == 5) {
            this.wakeLock = powerManager.newWakeLock(DriveFile.MODE_READ_WRITE, "PostLocationService");
        }
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return false;
        }
        wakeLock.acquire();
        return true;
    }

    public boolean createWifiLock(Object obj, int i) {
        this.wifiLock = ((WifiManager) ((Context) obj).getSystemService("wifi")).createWifiLock(i, "cu_iipsmobile_wifilock");
        return this.wifiLock != null;
    }

    public String install(String str) {
        ProcessBuilder processBuilder = new ProcessBuilder("pm", "install", "-r", str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Process start = processBuilder.start();
            InputStream errorStream = start.getErrorStream();
            while (true) {
                int read = errorStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            }
            InputStream inputStream = start.getInputStream();
            while (true) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(read2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isOpenNetwork(Object obj) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ((Activity) obj).getSystemService("connectivity");
        if (connectivityManager.getActiveNetworkInfo() != null) {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    public boolean isWifiLocked() {
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null) {
            return wifiLock.isHeld();
        }
        return false;
    }

    public boolean lockWifi() {
        if (isWifiLocked()) {
            return true;
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock == null) {
            return false;
        }
        wifiLock.acquire();
        return true;
    }

    public boolean releaseLock() {
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock == null || !wifiLock.isHeld()) {
            return this.wifiLock == null;
        }
        this.wifiLock.release();
        return true;
    }

    public boolean releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return false;
        }
        wakeLock.release();
        this.wakeLock = null;
        return true;
    }

    public boolean slientInstall(String str) {
        try {
            Process exec = Runtime.getRuntime().exec("su");
            OutputStream outputStream = exec.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes("chmod 777 " + str + "\n");
            StringBuilder sb = new StringBuilder();
            sb.append("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r ");
            sb.append(str);
            dataOutputStream.writeBytes(sb.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            return exec.waitFor() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean testnet(String str) {
        try {
            int responseCode = ((HttpURLConnection) new URL(str).openConnection()).getResponseCode();
            Log.v("CuIIPSMobile::testnet", "connect code" + responseCode);
            if (responseCode == 200) {
                Log.v("CuIIPSMobile::testnet", "testnet net is ok");
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public int toggleWiFi(Object obj, boolean z) {
        Log.v(TAG, "toggleWiFi begin");
        ((WifiManager) ((Context) obj).getSystemService("wifi")).setWifiEnabled(z);
        return 1;
    }
}
