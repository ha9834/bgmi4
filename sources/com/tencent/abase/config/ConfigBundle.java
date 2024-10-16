package com.tencent.abase.config;

/* loaded from: classes2.dex */
public class ConfigBundle {
    public static ConfigBundle sInstance = new ConfigBundle();

    private native boolean getBoolean(String str, String str2, boolean z);

    private native int getInt(String str, String str2, int i);

    private native long getLong(String str, String str2, long j);

    private native String getString(String str, String str2, String str3);

    private native boolean setBoolean(String str, String str2, boolean z);

    private native boolean setInt(String str, String str2, int i);

    private native boolean setLong(String str, String str2, long j);

    private native boolean setString(String str, String str2, String str3);

    public static ConfigBundle getInstance() {
        return sInstance;
    }

    public boolean set(String str, String str2, String str3) {
        return setString(str, str2, str3);
    }

    public boolean set(String str, String str2, int i) {
        return setInt(str, str2, i);
    }

    public boolean set(String str, String str2, long j) {
        return setLong(str, str2, j);
    }

    public boolean set(String str, String str2, boolean z) {
        return setBoolean(str, str2, z);
    }

    public String get(String str, String str2, String str3) {
        return getString(str, str2, str3);
    }

    public int get(String str, String str2, int i) {
        return getInt(str, str2, i);
    }

    public long get(String str, String str2, long j) {
        return getLong(str, str2, j);
    }

    public boolean get(String str, String str2, boolean z) {
        return getBoolean(str, str2, z);
    }
}
