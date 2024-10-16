package com.helpshift.common.platform;

import android.os.Environment;
import android.text.TextUtils;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AndroidBackupDAO implements BackupDAO {
    private final String BACKUP_FILE_NAME = "__hs__backup_dao_storage";
    private String externalDirectoryPath;

    @Override // com.helpshift.common.dao.BackupDAO
    public synchronized void storeValue(String str, Serializable serializable) {
        if (!TextUtils.isEmpty(str) && serializable != null) {
            HashMap<String, Serializable> restoreHashMap = restoreHashMap();
            if (restoreHashMap == null) {
                restoreHashMap = new HashMap<>();
            }
            if (serializable.equals(restoreHashMap.get(str))) {
                return;
            }
            restoreHashMap.put(str, serializable);
            backupHashMap(restoreHashMap);
        }
    }

    @Override // com.helpshift.common.dao.BackupDAO
    public synchronized Serializable getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, Serializable> restoreHashMap = restoreHashMap();
        if (restoreHashMap == null) {
            return null;
        }
        return restoreHashMap.get(str);
    }

    @Override // com.helpshift.common.dao.BackupDAO
    public synchronized void removeKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Serializable> restoreHashMap = restoreHashMap();
        if (restoreHashMap != null && restoreHashMap.containsKey(str)) {
            restoreHashMap.remove(str);
            backupHashMap(restoreHashMap);
        }
    }

    @Override // com.helpshift.common.dao.BackupDAO
    public synchronized void delete() {
        if (backupExists()) {
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
                if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                    File file = new File(externalStoragePublicDirectory, "__hs__backup_dao_storage");
                    if (file.canWrite()) {
                        file.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void backupHashMap(HashMap<String, Serializable> hashMap) {
        if (hashMap == null) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            if (externalStoragePublicDirectory.canWrite()) {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(externalStoragePublicDirectory, "__hs__backup_dao_storage")));
                try {
                    objectOutputStream2.writeObject(hashMap);
                    objectOutputStream = objectOutputStream2;
                } catch (Exception unused) {
                    objectOutputStream = objectOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuitely(objectOutputStream);
                    throw th;
                }
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        IOUtils.closeQuitely(objectOutputStream);
    }

    private HashMap<String, Serializable> restoreHashMap() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        r1 = null;
        r1 = null;
        HashMap<String, Serializable> hashMap = null;
        if (!backupExists()) {
            return null;
        }
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
            if (externalStoragePublicDirectory.canRead()) {
                objectInputStream = new ObjectInputStream(new FileInputStream(new File(externalStoragePublicDirectory, "__hs__backup_dao_storage")));
                try {
                    hashMap = (HashMap) objectInputStream.readObject();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    objectInputStream2 = objectInputStream;
                    th = th;
                    IOUtils.closeQuitely(objectInputStream2);
                    throw th;
                }
            } else {
                objectInputStream = null;
            }
        } catch (Exception unused2) {
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        IOUtils.closeQuitely(objectInputStream);
        return hashMap;
    }

    private boolean backupExists() {
        try {
            return new File(Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath()), "__hs__backup_dao_storage").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private String getExternalDirectoryPath() {
        if (this.externalDirectoryPath == null) {
            this.externalDirectoryPath = ".backups/" + HelpshiftContext.getApplicationContext().getPackageName() + "/helpshift/databases/";
        }
        return this.externalDirectoryPath;
    }
}
