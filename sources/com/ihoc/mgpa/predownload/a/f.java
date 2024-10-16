package com.ihoc.mgpa.predownload.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.ihoc.mgpa.n.m;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class f implements c {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.ihoc.mgpa.predownload.a.c
    public String a(String str) {
        m.a("TGPA_IFileMover", "getPreDownloadFilePath  md5 = " + str);
        Cursor cursor = null;
        try {
            try {
                cursor = com.ihoc.mgpa.n.a.a().getContentResolver().query(Uri.parse("content://com.vivo.game.res.download/res_task?query=list").buildUpon().appendQueryParameter("md5", str).build(), null, null, null, null);
                while (cursor.moveToNext()) {
                    cursor.getString(cursor.getColumnIndex("fileName"));
                    String string = cursor.getString(cursor.getColumnIndex("md5"));
                    String string2 = cursor.getString(cursor.getColumnIndex("fileUri"));
                    cursor.getLong(cursor.getColumnIndex("fileLength"));
                    int i = cursor.getInt(cursor.getColumnIndex("state"));
                    cursor.getLong(cursor.getColumnIndex("currentLength"));
                    if (str.equals(string) && i == 2 && !TextUtils.isEmpty(string2)) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string2;
                    }
                }
                if (cursor == null) {
                    return "";
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return "";
                }
            }
            cursor.close();
            return "";
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public void a(String str, boolean z, String str2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r1 == null) goto L23;
     */
    @Override // com.ihoc.mgpa.predownload.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() {
        /*
            r9 = this;
            java.lang.String r0 = "TGPA_IFileMover"
            java.lang.String r1 = "isAppStoreSupportPreDownload  "
            com.ihoc.mgpa.n.m.a(r0, r1)
            r0 = 0
            r1 = 0
            android.content.Context r2 = com.ihoc.mgpa.n.a.a()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            java.lang.String r2 = "content://com.vivo.game.res.download/res_task?query=support"
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            if (r2 == 0) goto L33
            int r2 = r1.getInt(r0)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            r3 = 1
            if (r2 != r3) goto L2d
            r0 = 1
        L2d:
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        L33:
            if (r1 == 0) goto L42
            goto L3f
        L36:
            r2 = move-exception
            goto L3a
        L38:
            r0 = move-exception
            goto L43
        L3a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L42
        L3f:
            r1.close()
        L42:
            return r0
        L43:
            if (r1 == 0) goto L48
            r1.close()
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.predownload.a.f.a():boolean");
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public boolean a(List<String> list) {
        m.a("TGPA_IFileMover", "deleteFileInAppStore  files = " + list);
        try {
            ContentResolver contentResolver = com.ihoc.mgpa.n.a.a().getContentResolver();
            Uri.Builder buildUpon = Uri.parse("content://com.vivo.game.res.download/res_task").buildUpon();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                buildUpon.appendQueryParameter(TransferTable.COLUMN_FILE, it.next());
            }
            contentResolver.delete(buildUpon.build(), null, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
