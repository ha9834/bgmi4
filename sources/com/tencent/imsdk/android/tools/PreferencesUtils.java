package com.tencent.imsdk.android.tools;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class PreferencesUtils {
    public static final String PREFERENCE_NAME = "imsdk_settings";
    private String mFilePreference = null;

    public void setPreferenceFileName(String str) {
        this.mFilePreference = str;
    }

    private String checkPreferenceFile() {
        String str = this.mFilePreference;
        if (str == null || str.length() == 0) {
            this.mFilePreference = PREFERENCE_NAME;
        }
        return this.mFilePreference;
    }

    public boolean putString(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(checkPreferenceFile(), 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public String getString(Context context, String str, String str2) {
        return context == null ? str2 : context.getSharedPreferences(checkPreferenceFile(), 0).getString(str, str2);
    }

    public boolean putInt(Context context, String str, int i) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(checkPreferenceFile(), 0).edit();
        edit.putInt(str, i);
        return edit.commit();
    }

    public int getInt(Context context, String str, int i) {
        return context == null ? i : context.getSharedPreferences(checkPreferenceFile(), 0).getInt(str, i);
    }

    public boolean putLong(Context context, String str, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(checkPreferenceFile(), 0).edit();
        edit.putLong(str, j);
        return edit.commit();
    }

    public long getLong(Context context, String str, int i) {
        return context == null ? i : context.getSharedPreferences(checkPreferenceFile(), 0).getLong(str, i);
    }

    public boolean putBoolean(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(checkPreferenceFile(), 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public boolean getBoolean(Context context, String str, boolean z) {
        return context == null ? z : context.getSharedPreferences(checkPreferenceFile(), 0).getBoolean(str, z);
    }

    public boolean remove(Context context, String str) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(checkPreferenceFile(), 0).edit();
        edit.remove(str);
        return edit.commit();
    }
}
