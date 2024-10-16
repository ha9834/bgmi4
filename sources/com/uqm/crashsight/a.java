package com.uqm.crashsight;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.m;

/* loaded from: classes.dex */
public abstract class a {
    public int id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, CrashSightStrategy crashSightStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onSelfDefiedStrategyChanged(SightPkg.RqdStrategy rqdStrategy) {
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (m.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (m.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
