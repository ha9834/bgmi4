package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class hf extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ he f4903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf(he heVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f4903a = heVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        gn gnVar;
        gn gnVar2;
        gn gnVar3;
        gnVar = this.f4903a.k;
        if (!gnVar.a(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            gnVar2 = this.f4903a.k;
            gnVar2.a();
            this.f4903a.zzab().zzgk().zzao("Opening the database failed, dropping and recreating it");
            if (!this.f4903a.getContext().getDatabasePath("google_app_measurement.db").delete()) {
                this.f4903a.zzab().zzgk().zza("Failed to delete corrupted db file", "google_app_measurement.db");
            }
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                gnVar3 = this.f4903a.k;
                gnVar3.b();
                return writableDatabase;
            } catch (SQLiteException e) {
                this.f4903a.zzab().zzgk().zza("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        zzef zzab = this.f4903a.zzab();
        strArr = he.b;
        zzab.a(zzab, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", strArr);
        zzab.a(this.f4903a.zzab(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzef zzab2 = this.f4903a.zzab();
        strArr2 = he.c;
        zzab.a(zzab2, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", strArr2);
        zzef zzab3 = this.f4903a.zzab();
        strArr3 = he.d;
        zzab.a(zzab3, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", strArr3);
        zzef zzab4 = this.f4903a.zzab();
        strArr4 = he.f;
        zzab.a(zzab4, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", strArr4);
        zzab.a(this.f4903a.zzab(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzef zzab5 = this.f4903a.zzab();
        strArr5 = he.e;
        zzab.a(zzab5, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", strArr5);
        zzef zzab6 = this.f4903a.zzab();
        strArr6 = he.g;
        zzab.a(zzab6, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", strArr6);
        zzef zzab7 = this.f4903a.zzab();
        strArr7 = he.h;
        zzab.a(zzab7, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", strArr7);
        zzab.a(this.f4903a.zzab(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzef zzab8 = this.f4903a.zzab();
        strArr8 = he.i;
        zzab.a(zzab8, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", strArr8);
        zzab.a(this.f4903a.zzab(), sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzab.a(this.f4903a.zzab(), sQLiteDatabase);
    }
}
