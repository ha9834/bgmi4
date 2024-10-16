package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzabh;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class MobileAdsInitProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    private final zzabh f1127a = new zzabh();

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f1127a.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return this.f1127a.onCreate();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f1127a.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return this.f1127a.getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.f1127a.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f1127a.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.f1127a.update(uri, contentValues, str, strArr);
    }
}
