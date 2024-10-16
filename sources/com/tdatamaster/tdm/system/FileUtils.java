package com.tdatamaster.tdm.system;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class FileUtils {
    private static final String MSDK_SHARE_PREFERENCE_FILE_NAME = "tdm";
    private static final String TAG = "FileUtils";
    private static FileUtils instance = new FileUtils();
    private Context mContext = null;
    private TDMNetworkReceiver mNetworkReceiver = null;
    private boolean mInitialized = false;

    private native void FileUtilsInit();

    public native String GetDefaultPreferenceByKey(String str, boolean z);

    protected FileUtils() {
    }

    public static FileUtils GetInstance() {
        return instance;
    }

    public void Initialize(Context context) {
        if (context == null) {
            TDMLog.e(TAG, "context is null. initialize failed!");
            return;
        }
        if (this.mInitialized) {
            return;
        }
        this.mContext = context;
        try {
            FileUtilsInit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mInitialized = true;
    }

    public boolean setSharePreference(String str, String str2, boolean z) {
        return setSharePreference(MSDK_SHARE_PREFERENCE_FILE_NAME, str, str2, z);
    }

    public boolean setSharePreference(String str, String str2, String str3, boolean z) {
        Context context = this.mContext;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.apply();
            return true;
        }
        TDMLog.e(TAG, "mContext is null");
        return false;
    }

    public String getSharePreferenceByKey(String str, boolean z) {
        return getSharePreferenceByKey(MSDK_SHARE_PREFERENCE_FILE_NAME, str, z);
    }

    public String getSharePreferenceByKey(String str, String str2, boolean z) {
        Context context = this.mContext;
        if (context != null) {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        }
        TDMLog.e(TAG, "mContext is null");
        return "";
    }

    public void deleteSharePreferenceItem(String str, boolean z) {
        deleteSharePreferenceItem(MSDK_SHARE_PREFERENCE_FILE_NAME, str, z);
    }

    public void deleteSharePreferenceItem(String str, String str2, boolean z) {
        Context context = this.mContext;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.remove(str2);
            edit.apply();
            return;
        }
        TDMLog.e(TAG, "mContext is null");
    }

    public void deleteSharePreference(boolean z) {
        deleteSharePreference(MSDK_SHARE_PREFERENCE_FILE_NAME, z);
    }

    public void deleteSharePreference(String str, boolean z) {
        Context context = this.mContext;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.apply();
            return;
        }
        TDMLog.e(TAG, "mContext is null");
    }
}
