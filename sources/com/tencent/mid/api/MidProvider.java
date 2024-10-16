package com.tencent.mid.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mid.b.g;
import com.tencent.mid.util.Util;
import com.tencent.midas.oversea.api.CocosPayHelper;

/* loaded from: classes.dex */
public class MidProvider extends ContentProvider {
    public static final int CMD_GET_PRIVATE_MID = 1;
    public static final int CMD_GET_PRIVATE_MID_ENTITY = 2;
    public static final int CMD_GET_PRIVATE_NEW_VERSION_MID_ENTITY = 3;
    public static final int CMD_INSERT_NEW_VERSION_MID_ENTITY = 10;
    public static final int CMD_INSERT_NEW_VERSION_MID_OLD_ENTITY = 11;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        Context applicationContext = getContext().getApplicationContext();
        applicationContext.getPackageName();
        if (Util.isEmpty(lastPathSegment)) {
            return CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
        }
        try {
            switch (Integer.parseInt(lastPathSegment)) {
                case 1:
                    MidEntity i = g.a(applicationContext).i();
                    if (i != null) {
                        return i.getMid();
                    }
                    return null;
                case 2:
                    MidEntity i2 = g.a(applicationContext).i();
                    if (i2 == null) {
                        return null;
                    }
                    i2.setImei("");
                    i2.setImsi("");
                    i2.setMac("");
                    return i2.toString();
                case 3:
                    MidEntity c = g.a(applicationContext).c();
                    if (c == null) {
                        return null;
                    }
                    c.setImei("");
                    c.setImsi("");
                    c.setMac("");
                    return c.toString();
                default:
                    return "";
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "-2";
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String lastPathSegment = uri.getLastPathSegment();
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        applicationContext.getPackageName();
        if (Util.isEmpty(lastPathSegment)) {
            return null;
        }
        try {
            switch (Integer.parseInt(lastPathSegment)) {
                case 10:
                    String asString = contentValues.getAsString("mid");
                    if (!Util.isMidValid(MidService.getLocalMidOnly(getContext().getApplicationContext()))) {
                        g.a(applicationContext).b(MidEntity.parse(asString), false);
                        break;
                    }
                    break;
                case 11:
                    String asString2 = contentValues.getAsString("mid");
                    if (!Util.isMidValid(MidService.getLocalMidOnly(getContext().getApplicationContext()))) {
                        g.a(applicationContext).a(MidEntity.parse(asString2), false);
                        break;
                    }
                    break;
                default:
                    return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
