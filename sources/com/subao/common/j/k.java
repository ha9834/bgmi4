package com.subao.common.j;

import android.content.Context;
import android.net.ConnectivityManager;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class k {
    public static com.subao.common.h a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return com.subao.common.h.UNKNOWN;
        }
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue() ? com.subao.common.h.ON : com.subao.common.h.OFF;
        } catch (Exception unused) {
            return com.subao.common.h.UNKNOWN;
        }
    }
}
