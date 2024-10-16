package com.tencent.ipubgm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import androidx.core.app.a;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.epicgames.ue4.GameActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.ipubgm.PermissionDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

@SuppressLint({"NewApi"})
@TargetApi(11)
/* loaded from: classes.dex */
public class AndroidUtil {
    static boolean AskedExternalStorageAtStartUp = false;
    private static final String LOG_TAG = "HHF";
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int STARTUP_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 3;
    public static int StartUpExternalStorageRejectedTimes;
    private static String myfilePath;
    private static PermissionDialog permissionDlg;

    public static void realInsertImage(String str) {
        String str2;
        File externalStorageDirectory;
        Context applicationContext = GameActivity.Get().getApplicationContext();
        File file = new File(str);
        if (Build.VERSION.SDK_INT == 19 && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            File file2 = new File(externalStorageDirectory, "DCIM/Camera");
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        try {
            str2 = MediaStore.Images.Media.insertImage(applicationContext.getContentResolver(), str, file.getName(), (String) null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null) {
            return;
        }
        Uri parse = Uri.parse(str2);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ContentValues contentValues = new ContentValues();
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        applicationContext.getContentResolver().update(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues, "_id=?", new String[]{ContentUris.parseId(parse) + ""});
        MediaScannerConnection.scanFile(applicationContext, new String[]{getRealFilePath(applicationContext, parse)}, null, null);
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                return;
            }
            realInsertImage(myfilePath);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z = false;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == -1 && strArr[i2].contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                z = true;
            }
        }
        if (z) {
            StartUpExternalStorageRejectedTimes++;
            boolean a2 = a.a((Activity) GameActivity.Get(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (a2 && StartUpExternalStorageRejectedTimes <= 1) {
                try {
                    Context applicationContext = GameActivity.Get().getApplicationContext();
                    int identifier = applicationContext.getResources().getIdentifier("StartUpRejectExternalStorageTips", "string", applicationContext.getPackageName());
                    int identifier2 = applicationContext.getResources().getIdentifier("StartUpRejectExternalStorageYes", "string", applicationContext.getPackageName());
                    int identifier3 = applicationContext.getResources().getIdentifier("StartUpRejectExternalStorageNo", "string", applicationContext.getPackageName());
                    if (permissionDlg != null) {
                        permissionDlg.cancel();
                    }
                    new PermissionDialog.Builder(GameActivity.Get(), 1).setHTMLMessage(identifier).setPositiveButton(identifier2, new View.OnClickListener() { // from class: com.tencent.ipubgm.AndroidUtil.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AndroidUtil.RequestPermission();
                        }
                    }).setNegativeButton(identifier3, new View.OnClickListener() { // from class: com.tencent.ipubgm.AndroidUtil.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    }).create().show();
                } catch (Exception e) {
                    e.printStackTrace();
                    RequestPermission();
                }
            }
            if (a2) {
                return;
            }
            Context applicationContext2 = GameActivity.Get().getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext2.getSharedPreferences("configuration", 0);
            if (sharedPreferences.getBoolean("iGameDirectToSettingFirstTime", true)) {
                try {
                    int identifier4 = applicationContext2.getResources().getIdentifier("StartUpDontAskAgainTips", "string", applicationContext2.getPackageName());
                    int identifier5 = applicationContext2.getResources().getIdentifier("StartUpDontAskAgainSetting", "string", applicationContext2.getPackageName());
                    int identifier6 = applicationContext2.getResources().getIdentifier("StartUpDontAskAgainCancel", "string", applicationContext2.getPackageName());
                    if (permissionDlg != null) {
                        permissionDlg.cancel();
                    }
                    new PermissionDialog.Builder(GameActivity.Get(), 1).setHTMLMessage(identifier4).setPositiveButton(identifier5, new View.OnClickListener() { // from class: com.tencent.ipubgm.AndroidUtil.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AndroidUtil.JumpToSetting();
                        }
                    }).setNegativeButton(identifier6, new View.OnClickListener() { // from class: com.tencent.ipubgm.AndroidUtil.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    }).create().show();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("iGameDirectToSettingFirstTime", false);
                    edit.commit();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void insertImage(String str) {
        if (androidx.core.content.a.b(GameActivity.Get(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            myfilePath = new String(str);
            a.a((Activity) GameActivity.Get(), "android.permission.WRITE_EXTERNAL_STORAGE");
            a.a(GameActivity.Get(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return;
        }
        realInsertImage(str);
    }

    public static String getRealFilePath(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if (TransferTable.COLUMN_FILE.equals(scheme)) {
            return uri.getPath();
        }
        if (!FirebaseAnalytics.Param.CONTENT.equals(scheme) || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static void gotoGoogleMarket() {
        Context applicationContext = GameActivity.Get().getApplicationContext();
        String packageName = applicationContext.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
        boolean z = false;
        Iterator<ResolveInfo> it = applicationContext.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                ActivityInfo activityInfo = next.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                intent.addFlags(2097152);
                intent.addFlags(67108864);
                intent.setComponent(componentName);
                applicationContext.startActivity(intent);
                z = true;
                Log.d(LOG_TAG, "gotoGoogleMarket，found GP app and open it.");
                break;
            }
        }
        if (z) {
            return;
        }
        applicationContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        Log.d(LOG_TAG, "gotoGoogleMarket，not found GP app, open web browser.");
    }

    public static void onResume() {
        if (AskedExternalStorageAtStartUp) {
            return;
        }
        AskedExternalStorageAtStartUp = true;
        Context applicationContext = GameActivity.Get().getApplicationContext();
        if (IsPermissionGranted(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}[0])) {
            return;
        }
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("configuration", 0);
        boolean z = sharedPreferences.getBoolean("iGameStartUpFirstTime", true);
        if (z) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("iGameStartUpFirstTime", false);
            edit.commit();
        }
        boolean a2 = a.a((Activity) GameActivity.Get(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (z || a2) {
            try {
                int identifier = applicationContext.getResources().getIdentifier("StartUpExternalStorageTips", "string", applicationContext.getPackageName());
                int identifier2 = applicationContext.getResources().getIdentifier("StartUpExternalStorageOK", "string", applicationContext.getPackageName());
                if (permissionDlg != null) {
                    permissionDlg.cancel();
                }
                new PermissionDialog.Builder(GameActivity.Get(), 0).setHTMLMessage(identifier).setPositiveButton(identifier2, new View.OnClickListener() { // from class: com.tencent.ipubgm.AndroidUtil.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AndroidUtil.RequestPermission();
                    }
                }).create().show();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                RequestPermission();
                return;
            }
        }
        RequestPermission();
    }

    public static void RequestPermission() {
        a.a(GameActivity.Get(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
    }

    public static void JumpToSetting() {
        try {
            Context applicationContext = GameActivity.Get().getApplicationContext();
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(Uri.fromParts("package", applicationContext.getPackageName(), null));
            applicationContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean IsPermissionGranted(String str) {
        return Build.VERSION.SDK_INT >= 23 && GameActivity.Get().checkSelfPermission(str) == 0;
    }
}
