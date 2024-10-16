package com.ihoc.mgpa.predownload;

import android.content.Context;
import com.ihoc.mgpa.predownload.b;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GamePredownloadHelper {
    private static volatile b mInstance;

    public static int combinePackage(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return getGamePredownloader().a(context, str, str2, str3, str4, str5, str6);
    }

    private static b getGamePredownloader() {
        if (mInstance == null) {
            synchronized (b.class) {
                if (mInstance == null) {
                    mInstance = new c();
                }
            }
        }
        return mInstance;
    }

    public static void getGameVersionUpdateInfo(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback) {
        getGamePredownloader().a(context, str, arrayList, gameCallback);
    }

    public static void init(String str, String str2) {
        getGamePredownloader().a(str);
        getGamePredownloader().c(str2);
    }

    public static void init(String str, String str2, b.c cVar) {
        getGamePredownloader().a(str);
        getGamePredownloader().c(str2);
    }

    public static void init(String str, String str2, String str3) {
        getGamePredownloader().a(str);
        getGamePredownloader().c(str2);
        getGamePredownloader().b(str3);
    }

    public static void reportPreDownladInfo(Context context, HashMap<String, String> hashMap) {
        getGamePredownloader().a(context, hashMap);
    }

    @Deprecated
    public static void reportPreDownladInfo(HashMap<String, String> hashMap) {
        getGamePredownloader().a(null, hashMap);
    }
}
