package com.vk.api.sdk.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class VKInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        h.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        h.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        h.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        h.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        h.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            h.a(context);
            h.a((Object) context, "context!!");
            com.vk.api.sdk.b.a(context);
            return false;
        } catch (Exception e) {
            Log.e(VKInitProvider.class.getSimpleName(), "Failed to initialize the VK SDK", e);
            return false;
        }
    }
}
