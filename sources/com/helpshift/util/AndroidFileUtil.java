package com.helpshift.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class AndroidFileUtil {
    public static final String TAG = "AndroidFileUtil";
    private static final Set<String> imageMimeTypes = new HashSet(Arrays.asList("image/jpeg", "image/png", "image/gif", "image/x-png", "image/x-citrix-pjpeg", "image/x-citrix-gif", "image/pjpeg"));

    public static boolean isSupportedMimeType(String str) {
        return imageMimeTypes.contains(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void saveFile(URL url, File file) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = url.openStream();
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[500];
                    while (true) {
                        int read = inputStream.read(bArr, 0, bArr.length);
                        if (read < 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    IOUtils.closeQuitely(inputStream);
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        HSLogger.d(TAG, "saveFile Exception :", e);
                        IOUtils.closeQuitely(inputStream2);
                        IOUtils.closeQuitely(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        IOUtils.closeQuitely(inputStream);
                        IOUtils.closeQuitely(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(inputStream);
                    IOUtils.closeQuitely(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            fileOutputStream = null;
        }
        IOUtils.closeQuitely(fileOutputStream);
    }

    public static String getMimeType(URL url) {
        try {
            return url.openConnection().getContentType();
        } catch (Exception e) {
            HSLogger.d(TAG, "openConnection() Exception :", e);
            return null;
        }
    }

    public static String getMimeType(String str) {
        try {
            return getMimeType(new URL("file://" + str));
        } catch (MalformedURLException e) {
            HSLogger.d(TAG, "error in getting mimeType :", e);
            return null;
        }
    }

    public static String getFileExtension(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 <= 0 || lastIndexOf2 >= str.length() - 1 || lastIndexOf >= lastIndexOf2) {
            return null;
        }
        return str.substring(lastIndexOf2 + 1);
    }

    public static boolean doesFileFromUriExistAndCanRead(Uri uri, Context context) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            boolean z = openFileDescriptor != null;
            if (openFileDescriptor != null) {
                try {
                    openFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            return z;
        } catch (Exception e) {
            HSLogger.d(TAG, "Unable to open input file descriptor for doesFileFromUriExistAndCanRead: " + uri, e);
            return false;
        }
    }

    public static String getFileExtensionFromMimeType(Context context, Uri uri) {
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    public static String getFileExtensionFromFileName(String str) {
        int lastIndexOf;
        if (StringUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.indexOf(47) >= 0) {
            return null;
        }
        return substring;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        if (r7 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if (r7 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileExtension(android.content.Context r7, android.net.Uri r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L4b
            if (r7 != 0) goto L6
            goto L4b
        L6:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r7 == 0) goto L2f
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L44
            if (r8 == 0) goto L2f
            java.lang.String r8 = "_display_name"
            int r8 = r7.getColumnIndex(r8)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L44
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L44
            java.lang.String r8 = getFileExtensionFromFileName(r8)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L44
            if (r7 == 0) goto L2e
            r7.close()
        L2e:
            return r8
        L2f:
            if (r7 == 0) goto L43
        L31:
            r7.close()
            goto L43
        L35:
            r8 = move-exception
            r7 = r0
            goto L45
        L38:
            r7 = r0
        L39:
            java.lang.String r8 = com.helpshift.util.AndroidFileUtil.TAG     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "Unable to detect file extension via Uri"
            com.helpshift.util.HSLogger.e(r8, r1)     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L43
            goto L31
        L43:
            return r0
        L44:
            r8 = move-exception
        L45:
            if (r7 == 0) goto L4a
            r7.close()
        L4a:
            throw r8
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.util.AndroidFileUtil.getFileExtension(android.content.Context, android.net.Uri):java.lang.String");
    }
}
