package com.huawei.devices.hapticskit;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.huawei.android.os.VibratorEx;

/* loaded from: classes2.dex */
final class d extends b {
    private static final Bundle g;
    private static final Uri h;
    private VibratorEx e;
    private String f;

    static {
        Bundle bundle = new Bundle();
        bundle.putString("func", "sound_to_vibrate_effect");
        g = bundle;
        h = Uri.parse("content://com.huawei.gameassistant.provider.PublicThirdApi");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Handler handler, Context context) {
        super(handler, context);
        this.e = new VibratorEx();
        this.f = context.getPackageName();
        Log.i("HapticAdapter", "mPkgName = " + this.f);
    }

    private boolean c(String str) {
        String str2;
        String str3;
        try {
            Bundle call = this.d.getContentResolver().call(h, "getSwitchStatus", str, g);
            return (call != null ? call.getInt("status", 2) : 2) == 2;
        } catch (IllegalArgumentException unused) {
            str2 = "HapticAdapter";
            str3 = "IllegalArgumentException happened";
            Log.e(str2, str3);
            return false;
        } catch (SecurityException unused2) {
            str2 = "HapticAdapter";
            str3 = "SecurityException happened";
            Log.e(str2, str3);
            return false;
        } catch (Exception unused3) {
            str2 = "HapticAdapter";
            str3 = "Exception happened";
            Log.e(str2, str3);
            return false;
        }
    }

    @Override // com.huawei.devices.hapticskit.b
    public final void a(String str) {
        String str2;
        String str3;
        Log.i("HapticAdapter", "setHwVibrator " + str);
        if ((str != null && str.startsWith("haptic.game")) && !c(this.f)) {
            str2 = "HapticAdapter";
            str3 = "4D Switch is not open";
        } else {
            if (str != null) {
                VibratorEx vibratorEx = this.e;
                if (vibratorEx != null && vibratorEx.isSupportHwVibrator(str)) {
                    this.e.setHwVibrator(str);
                    return;
                }
                return;
            }
            str2 = "HapticAdapter";
            str3 = "Input value is null";
        }
        Log.e(str2, str3);
    }

    @Override // com.huawei.devices.hapticskit.b
    public final String b(String str) {
        String str2;
        String str3;
        VibratorEx vibratorEx;
        Log.i("HapticAdapter", "getParameter " + str);
        if (str == null) {
            str2 = "HapticAdapter";
            str3 = "Input value is null";
        } else {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1140203581) {
                if (hashCode == 2074676459 && str.equals(com.huawei.devices.a.a.d)) {
                    c = 0;
                }
            } else if (str.equals(com.huawei.devices.a.a.c)) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1 && (vibratorEx = this.e) != null) {
                    return vibratorEx.getHwParameter(com.huawei.devices.a.a.c);
                }
                return null;
            }
            String str4 = Build.MODEL;
            if (str4 != null) {
                if (str4.matches(com.huawei.devices.a.a.p) || str4.matches(com.huawei.devices.a.a.q)) {
                    return com.huawei.devices.a.a.m;
                }
                VibratorEx vibratorEx2 = this.e;
                if (vibratorEx2 == null) {
                    return null;
                }
                String hwParameter = vibratorEx2.getHwParameter(com.huawei.devices.a.a.c);
                return (hwParameter == null || hwParameter.equals(com.huawei.devices.a.a.o)) ? com.huawei.devices.a.a.o : com.huawei.devices.a.a.n;
            }
            str2 = "HapticAdapter";
            str3 = "Phone Model is null";
        }
        Log.e(str2, str3);
        return null;
    }
}
