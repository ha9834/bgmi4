package com.helpshift.db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseSqliteHelper extends SQLiteOpenHelper {
    private DatabaseContract contract;
    private IDbMigrationListener listener;

    /* loaded from: classes2.dex */
    public interface IDbMigrationListener {
        void onDbMigrationFailed(MigrationType migrationType, String str);

        void onDbMigrationSuccess(MigrationType migrationType, String str);
    }

    /* loaded from: classes2.dex */
    public enum MigrationType {
        UPGRADE,
        DOWNGRADE
    }

    public BaseSqliteHelper(Context context, DatabaseContract databaseContract) {
        super(context, databaseContract.getDatabaseName(), (SQLiteDatabase.CursorFactory) null, databaseContract.getDatabaseVersion());
        this.contract = databaseContract;
    }

    public void setListener(IDbMigrationListener iDbMigrationListener) {
        this.listener = iDbMigrationListener;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            createAllTables(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e) {
                HSLogger.f(this.contract.getTag(), "Error in onCreate inside finally block, ", e, new ILogExtrasModel[0]);
            }
        } catch (Throwable th) {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e2) {
                HSLogger.f(this.contract.getTag(), "Error in onCreate inside finally block, ", e2, new ILogExtrasModel[0]);
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<IMigrator> migratorsForUpgrade = this.contract.getMigratorsForUpgrade(i);
        if (ListUtils.isEmpty(migratorsForUpgrade)) {
            return;
        }
        boolean migrate = migrate(sQLiteDatabase, migratorsForUpgrade, i);
        IDbMigrationListener iDbMigrationListener = this.listener;
        if (iDbMigrationListener != null) {
            if (migrate) {
                iDbMigrationListener.onDbMigrationSuccess(MigrationType.UPGRADE, this.contract.getDatabaseName());
            } else {
                iDbMigrationListener.onDbMigrationFailed(MigrationType.UPGRADE, this.contract.getDatabaseName());
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean dropAndCreateAllTablesOnMigrate = dropAndCreateAllTablesOnMigrate(sQLiteDatabase);
        IDbMigrationListener iDbMigrationListener = this.listener;
        if (iDbMigrationListener != null) {
            if (dropAndCreateAllTablesOnMigrate) {
                iDbMigrationListener.onDbMigrationSuccess(MigrationType.DOWNGRADE, this.contract.getDatabaseName());
            } else {
                iDbMigrationListener.onDbMigrationFailed(MigrationType.DOWNGRADE, this.contract.getDatabaseName());
            }
        }
    }

    private boolean dropAndCreateAllTablesOnMigrate(SQLiteDatabase sQLiteDatabase) {
        try {
            dropAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
            return true;
        } catch (Exception e) {
            HSLogger.f(this.contract.getTag(), "Exception while recreating tables on DB upgrade/downgrade: version: " + this.contract.getDatabaseVersion(), e, new ILogExtrasModel[0]);
            throw e;
        }
    }

    public boolean dropAndCreateAllTables(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return true;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                dropAllTables(sQLiteDatabase);
                createAllTables(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    if (!sQLiteDatabase.inTransaction()) {
                        return true;
                    }
                    sQLiteDatabase.endTransaction();
                    return true;
                } catch (Exception e) {
                    HSLogger.f(this.contract.getTag(), "Error in recreating inside finally block, ", e, new ILogExtrasModel[0]);
                    return true;
                }
            } catch (Exception e2) {
                HSLogger.f(this.contract.getTag(), "Exception while recreating tables: version: " + this.contract.getDatabaseVersion(), e2, new ILogExtrasModel[0]);
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e3) {
                    HSLogger.f(this.contract.getTag(), "Error in recreating inside finally block, ", e3, new ILogExtrasModel[0]);
                }
                return false;
            }
        } catch (Throwable th) {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e4) {
                HSLogger.f(this.contract.getTag(), "Error in recreating inside finally block, ", e4, new ILogExtrasModel[0]);
            }
            throw th;
        }
    }

    private void dropAllTables(SQLiteDatabase sQLiteDatabase) {
        Iterator<String> it = this.contract.getTableNames().iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next());
        }
    }

    private void createAllTables(SQLiteDatabase sQLiteDatabase) {
        Iterator<String> it = this.contract.getCreateTableQueries().iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(it.next());
        }
    }

    private boolean migrate(SQLiteDatabase sQLiteDatabase, List<IMigrator> list, int i) {
        boolean z = false;
        try {
            Iterator<IMigrator> it = list.iterator();
            while (it.hasNext()) {
                it.next().migrate(sQLiteDatabase);
            }
            z = true;
        } catch (Exception e) {
            HSLogger.f(this.contract.getTag(), "Exception while migrating " + this.contract.getDatabaseName() + " old: " + i + ", new: " + this.contract.getDatabaseVersion(), e, new ILogExtrasModel[0]);
        }
        if (!z) {
            dropAndCreateAllTablesOnMigrate(sQLiteDatabase);
        }
        return z;
    }
}
