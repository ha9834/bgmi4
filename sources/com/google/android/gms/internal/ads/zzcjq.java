package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcjq {
    public static ArrayList<zzwt.zzi.zza> zza(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzwt.zzi.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzwt.zzi.zza.zzh(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzdok e) {
                zzawz.zzen("Unable to deserialize proto from offline signals database:");
                zzawz.zzen(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static int zza(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        String[] strArr = {"total"};
        String[] strArr2 = new String[1];
        switch (i) {
            case 1:
                strArr2[0] = "failed_requests";
                break;
            case 2:
                strArr2[0] = "total_requests";
                break;
        }
        Cursor query = sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
        if (query.getCount() > 0) {
            query.moveToNext();
            i2 = 0 + query.getInt(query.getColumnIndexOrThrow("total"));
        }
        query.close();
        return i2;
    }
}
