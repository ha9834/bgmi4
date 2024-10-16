package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes.dex */
public final class zzayi {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2828a = new Object();

    @GuardedBy("lock")
    private String b = "";

    @GuardedBy("lock")
    private String c = "";

    @GuardedBy("lock")
    private boolean d = false;

    @VisibleForTesting
    private String e = "";

    public final void zze(Context context, String str, String str2) {
        if (!a(context, str, str2)) {
            a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.e)) {
            zzawz.zzdp("Creative is not pushed for this device.");
            a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.e)) {
            zzawz.zzdp("The app is not linked for creative preview.");
            d(context, str, str2);
        } else if ("0".equals(this.e)) {
            zzawz.zzdp("Device is linked for in app preview.");
            a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzwo = zzwo();
        if (b(context, str, str2)) {
            if (!zzwo && !TextUtils.isEmpty(str3)) {
                a(context, str2, str3, str);
            }
            zzawz.zzdp("Device is linked for debug signals.");
            a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        d(context, str, str2);
    }

    @VisibleForTesting
    private final boolean a(Context context, String str, String str2) {
        String c = c(context, b(context, (String) zzyt.zzpe().zzd(zzacu.zzcuc), str, str2).toString(), str2);
        if (TextUtils.isEmpty(c)) {
            zzawz.zzdp("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(c.trim());
            String optString = jSONObject.optString("gct");
            this.e = jSONObject.optString("status");
            synchronized (this.f2828a) {
                this.c = optString;
            }
            return true;
        } catch (JSONException e) {
            zzawz.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean b(Context context, String str, String str2) {
        String c = c(context, b(context, (String) zzyt.zzpe().zzd(zzacu.zzcud), str, str2).toString(), str2);
        if (TextUtils.isEmpty(c)) {
            zzawz.zzdp("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(c.trim()).optString("debug_mode"));
            synchronized (this.f2828a) {
                this.d = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzawz.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String c(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeader.USER_AGENT, zzk.zzlg().zzq(context, str2));
        zzbbh<String> zzc = new zzayu(context).zzc(str, hashMap);
        try {
            return zzc.get(((Integer) zzyt.zzpe().zzd(zzacu.zzcuf)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(str);
            zzawz.zzc(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e);
            zzc.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String valueOf2 = String.valueOf(str);
            zzawz.zzc(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e2);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzawz.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void d(Context context, String str, String str2) {
        zzk.zzlg();
        zzaxi.zza(context, b(context, (String) zzyt.zzpe().zzd(zzacu.zzcub), str, str2));
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzk.zzlq().zzwo()) {
            return false;
        }
        zzawz.zzdp("Sending troubleshooting signals to the server.");
        a(context, str, str2, str3);
        return true;
    }

    private final void a(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = b(context, (String) zzyt.zzpe().zzd(zzacu.zzcue), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzk.zzlg();
        zzaxi.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri b(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String a(Context context) {
        String str;
        synchronized (this.f2828a) {
            if (TextUtils.isEmpty(this.b)) {
                zzk.zzlg();
                this.b = zzaxi.zzr(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.b)) {
                    zzk.zzlg();
                    this.b = zzaxi.zzwb();
                    zzk.zzlg();
                    zzaxi.zzc(context, "debug_signals_id.txt", this.b);
                }
            }
            str = this.b;
        }
        return str;
    }

    public final String zzwn() {
        String str;
        synchronized (this.f2828a) {
            str = this.c;
        }
        return str;
    }

    public final boolean zzwo() {
        boolean z;
        synchronized (this.f2828a) {
            z = this.d;
        }
        return z;
    }

    @VisibleForTesting
    private final void a(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzawz.zzeo("Can not create dialog without Activity Context");
        } else {
            zzaxi.zzdvv.post(new gb(this, context, str, z, z2));
        }
    }
}
