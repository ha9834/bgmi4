package com.helpshift.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.helpshift.constants.CommonSharedPrefrences;
import com.helpshift.support.model.FaqSearchIndex;
import com.helpshift.support.search.storage.SearchTokenDaoImpl;
import com.helpshift.support.storage.FaqsDataSource;
import com.helpshift.util.HSLogger;
import com.helpshift.util.IOUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class HSStorage {
    static final String TAG = "HelpShiftDebug";
    private static FaqSearchIndex cachedSearchIndex;
    private Context context;
    private final String dbFile = "fullIndex.db";
    private Map<String, String> migrationBackupData = new HashMap();
    private SharedPreferences storage;

    public HSStorage(Context context) {
        this.context = context;
        this.storage = context.getSharedPreferences(CommonSharedPrefrences.JSON_PREFS, 0);
    }

    private JSONObject storageGetObj(String str) throws JSONException {
        return new JSONObject(this.storage.getString(str, "{}"));
    }

    private JSONArray storageGetArr(String str) throws JSONException {
        return new JSONArray(this.storage.getString(str, "[]"));
    }

    private String storageGet(String str) {
        return this.storage.getString(str, "");
    }

    private Integer storageGetInt(String str) {
        return storageGetInt(str, 0);
    }

    private Integer storageGetInt(String str, int i) {
        return Integer.valueOf(this.storage.getInt(str, i));
    }

    public Float storageGetFloat(String str) {
        return Float.valueOf(this.storage.getFloat(str, 0.0f));
    }

    public boolean contains(String str) {
        return this.storage.contains(str);
    }

    public Boolean storageGetBoolean(String str) {
        return Boolean.valueOf(this.storage.getBoolean(str, false));
    }

    private Long storageGetLong(String str) {
        return Long.valueOf(this.storage.getLong(str, 0L));
    }

    private void storageSet(String str, JSONArray jSONArray) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, jSONArray.toString());
        edit.apply();
    }

    private void storageSet(String str, JSONObject jSONObject) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, jSONObject.toString());
        edit.apply();
    }

    private void storageSet(String str, String str2) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private void storageSet(String str, Integer num) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putInt(str, num.intValue());
        edit.apply();
    }

    private void storageSet(String str, Boolean bool) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.apply();
    }

    private void storageSet(String str, Long l) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putLong(str, l.longValue());
        edit.apply();
    }

    public void backupForMigration() {
        this.migrationBackupData.put(CommonSharedPrefrences.INSTALL_CREDS_HASH, getString(CommonSharedPrefrences.INSTALL_CREDS_HASH));
    }

    public void restoreMigrationData() {
        for (Map.Entry<String, String> entry : this.migrationBackupData.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                storageSet(entry.getKey(), entry.getValue());
            }
        }
        this.migrationBackupData.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearDatabase() {
        FaqsDataSource.getInstance().clearDB();
        SharedPreferences.Editor edit = this.storage.edit();
        edit.clear();
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearLegacySearchIndexFile() {
        this.context.deleteFile("tfidf.db");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLibraryVersion() {
        return storageGet(CommonSharedPrefrences.LIBRARY_VERSION);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLibraryVersion(String str) {
        storageSet(CommonSharedPrefrences.LIBRARY_VERSION, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getApplicationVersion() {
        return storageGet("applicationVersion");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setApplicationVersion(String str) {
        storageSet("applicationVersion", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReviewCounter() {
        return storageGetInt("reviewCounter").intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setReviewCounter(int i) {
        storageSet("reviewCounter", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLaunchReviewCounter() {
        return storageGetInt("launchReviewCounter").intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLaunchReviewCounter(int i) {
        storageSet("launchReviewCounter", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONArray getStoredFiles() throws JSONException {
        return storageGetArr("cachedImages");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStoredFiles(JSONArray jSONArray) {
        storageSet("cachedImages", jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void storeIndex(FaqSearchIndex faqSearchIndex) {
        ObjectOutputStream objectOutputStream;
        cachedSearchIndex = faqSearchIndex;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream openFileOutput = this.context.openFileOutput("fullIndex.db", 0);
            try {
                objectOutputStream = new ObjectOutputStream(openFileOutput);
                try {
                    objectOutputStream.writeObject(faqSearchIndex);
                    objectOutputStream.flush();
                    setDBFlag();
                    IOUtils.closeQuitely(openFileOutput);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = openFileOutput;
                    try {
                        HSLogger.d("HelpShiftDebug", "store index", e);
                        IOUtils.closeQuitely(fileOutputStream);
                        IOUtils.closeQuitely(objectOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuitely(fileOutputStream);
                        IOUtils.closeQuitely(objectOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = openFileOutput;
                    IOUtils.closeQuitely(fileOutputStream);
                    IOUtils.closeQuitely(objectOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
        }
        IOUtils.closeQuitely(objectOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadIndex() throws IOException, ClassCastException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        Throwable th;
        FileInputStream fileInputStream;
        if (cachedSearchIndex != null) {
            return;
        }
        try {
            fileInputStream = this.context.openFileInput("fullIndex.db");
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    cachedSearchIndex = (FaqSearchIndex) objectInputStream.readObject();
                    IOUtils.closeQuitely(fileInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(fileInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                objectInputStream = null;
                th = th3;
            }
        } catch (Throwable th4) {
            objectInputStream = null;
            th = th4;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FaqSearchIndex readIndex() {
        return cachedSearchIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean getDBFlag() {
        return storageGetBoolean("dbFlag");
    }

    protected void setDBFlag() {
        storageSet("dbFlag", (Boolean) true);
    }

    protected void unsetDBFlag() {
        storageSet("dbFlag", (Boolean) false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteIndex() {
        cachedSearchIndex = null;
        SearchTokenDaoImpl.getInstance().clear();
        this.context.deleteFile("fullIndex.db");
        unsetDBFlag();
    }

    protected JSONObject getFailedApiCalls() throws JSONException {
        return storageGetObj("failedApiCalls");
    }

    protected void storeFailedApiCall(String str, JSONObject jSONObject) throws JSONException {
        JSONObject failedApiCalls = getFailedApiCalls();
        failedApiCalls.put(str, jSONObject);
        storageSet("failedApiCalls", failedApiCalls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getLastErrorReportedTime() {
        return storageGetLong("lastErrorReportedTime").longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLastErrorReportedTime(long j) {
        storageSet("lastErrorReportedTime", Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCacheSearchIndexNull() {
        return cachedSearchIndex == null;
    }

    public String getString(String str) {
        return this.storage.getString(str, "");
    }
}
