package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzaht {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2734a;
    private final zzdh b;
    private final View c;

    public zzaht(Context context, zzdh zzdhVar, View view) {
        this.f2734a = context;
        this.b = zzdhVar;
        this.c = view;
    }

    private static Intent a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    @VisibleForTesting
    private final ResolveInfo a(Intent intent) {
        return a(intent, new ArrayList<>());
    }

    @VisibleForTesting
    private final ResolveInfo a(Intent intent, ArrayList<ResolveInfo> arrayList) {
        PackageManager packageManager;
        ResolveInfo resolveInfo = null;
        try {
            packageManager = this.f2734a.getPackageManager();
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
        if (packageManager == null) {
            return null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            int i = 0;
            while (true) {
                if (i >= queryIntentActivities.size()) {
                    break;
                }
                ResolveInfo resolveInfo2 = queryIntentActivities.get(i);
                if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                    resolveInfo = resolveActivity;
                    break;
                }
                i++;
            }
        }
        arrayList.addAll(queryIntentActivities);
        return resolveInfo;
    }

    private static Intent a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent zze(java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaht.zze(java.util.Map):android.content.Intent");
    }
}
