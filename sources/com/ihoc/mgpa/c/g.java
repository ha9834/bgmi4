package com.ihoc.mgpa.c;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final g f5500a = new g();

    private g() {
    }

    public static g c() {
        return f5500a;
    }

    public long a() {
        long blockSizeLong;
        long availableBlocksLong;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (!externalStorageDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                availableBlocksLong = statFs.getAvailableBlocks();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
            }
            return availableBlocksLong * blockSizeLong;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public long b() {
        long blockSizeLong;
        long availableBlocksLong;
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (!dataDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                availableBlocksLong = statFs.getAvailableBlocks();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
            }
            return availableBlocksLong * blockSizeLong;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public long d() {
        long blockSizeLong;
        long blockCountLong;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (!externalStorageDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                blockCountLong = statFs.getBlockCount();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
            }
            return blockCountLong * blockSizeLong;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public long e() {
        long blockSizeLong;
        long blockCountLong;
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (!dataDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                blockCountLong = statFs.getBlockCount();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
            }
            return blockCountLong * blockSizeLong;
        } catch (Exception unused) {
            return -1L;
        }
    }
}
