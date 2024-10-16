package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES10;
import android.opengl.GLES20;

/* loaded from: classes2.dex */
public class GpuInfoHandler {

    /* loaded from: classes2.dex */
    static class GpuInfo {
        private String mRender;
        private String mVendor;
        private String mVersion;

        public GpuInfo(String str, String str2, String str3) {
            this.mVendor = str;
            this.mRender = str2;
            this.mVersion = str3;
        }

        public String getVendor() {
            if (this.mVendor == null) {
                this.mVendor = Constant.APM_CFG_GPU_NA;
            }
            return this.mVendor;
        }

        public String getRender() {
            if (this.mRender == null) {
                this.mRender = Constant.APM_CFG_GPU_NA;
            }
            return this.mRender;
        }

        public String getVersion() {
            if (this.mVersion == null) {
                this.mVersion = Constant.APM_CFG_GPU_NA;
            }
            return this.mVersion;
        }

        public boolean isValid() {
            String str = this.mVendor;
            return (str == null || this.mRender == null || this.mVersion == null || str.equals(Constant.APM_CFG_GPU_NA) || this.mRender.equals(Constant.APM_CFG_GPU_NA) || this.mVersion.equals(Constant.APM_CFG_GPU_NA)) ? false : true;
        }
    }

    public static synchronized GpuInfo getGpuInfoByGLES() {
        GpuInfo gpuInfo;
        synchronized (GpuInfoHandler.class) {
            HawkLogger.w("Get gpu info by gles");
            String glGetString = GLES20.glGetString(7937);
            String glGetString2 = GLES20.glGetString(7938);
            String glGetString3 = GLES20.glGetString(7936);
            if (glGetString == null && (glGetString = GLES10.glGetString(7937)) == null) {
                glGetString = Constant.APM_CFG_GPU_NA;
            }
            if (glGetString2 == null && (glGetString2 = GLES10.glGetString(7938)) == null) {
                glGetString2 = Constant.APM_CFG_GPU_NA;
            }
            if (glGetString3 == null && (glGetString3 = GLES10.glGetString(7936)) == null) {
                glGetString3 = Constant.APM_CFG_GPU_NA;
            }
            HawkLogger.w("finish get gpu info");
            gpuInfo = new GpuInfo(glGetString3, glGetString, glGetString2);
        }
        return gpuInfo;
    }

    public static synchronized GpuInfo readGpuInfoByCache(Context context) {
        synchronized (GpuInfoHandler.class) {
            String str = Constant.APM_CFG_GPU_NA;
            String str2 = Constant.APM_CFG_GPU_NA;
            String str3 = Constant.APM_CFG_GPU_NA;
            if (context == null) {
                return new GpuInfo(Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
            if (sharedPreferences != null) {
                str = sharedPreferences.getString(Constant.APM_CFG_GPU_VENDOR, Constant.APM_CFG_GPU_NA);
                str2 = sharedPreferences.getString(Constant.APM_CFG_GPU_RENDERER, Constant.APM_CFG_GPU_NA);
                str3 = sharedPreferences.getString(Constant.APM_CFG_GPU_VERSION, Constant.APM_CFG_GPU_NA);
            }
            return new GpuInfo(str, str2, str3);
        }
    }

    public static synchronized void writeGpuInfoInCache(Context context, GpuInfo gpuInfo) {
        synchronized (GpuInfoHandler.class) {
            if (context == null) {
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (edit == null) {
                    return;
                }
                edit.putString(Constant.APM_CFG_GPU_VENDOR, gpuInfo.getVendor());
                edit.putString(Constant.APM_CFG_GPU_RENDERER, gpuInfo.getRender());
                edit.putString(Constant.APM_CFG_GPU_VERSION, gpuInfo.getVersion());
                edit.commit();
                HawkLogger.w("WriteGpuInfoInCache");
            } else {
                HawkLogger.e("WriteGpuInfoInCache error");
            }
        }
    }
}
