package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.smtt.sdk.WebView;

@zzard
/* loaded from: classes2.dex */
public final class zzacf {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2696a;

    public zzacf(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.f2696a = context;
    }

    public final boolean zzqi() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(WebView.SCHEME_TEL));
        return a(intent);
    }

    public final boolean zzqj() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(intent);
    }

    public final boolean zzqk() {
        return ((Boolean) zzazl.zza(this.f2696a, new k())).booleanValue() && Wrappers.packageManager(this.f2696a).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzql() {
        return a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    private final boolean a(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        return !this.f2696a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
