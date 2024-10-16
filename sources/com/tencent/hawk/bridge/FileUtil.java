package com.tencent.hawk.bridge;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class FileUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d java.io.FileNotFoundException -> L67
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d java.io.FileNotFoundException -> L67
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d java.io.FileNotFoundException -> L67
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d java.io.FileNotFoundException -> L67
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L46
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L46
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L46
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L46
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
        L1a:
            int r0 = r2.read(r5)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
            r3 = -1
            if (r0 == r3) goto L25
            r4.write(r5, r1, r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
            goto L1a
        L25:
            r4.flush()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
            r2.close()     // Catch: java.io.IOException -> L2c
            goto L30
        L2c:
            r5 = move-exception
            r5.printStackTrace()
        L30:
            r4.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r4 = move-exception
            r4.printStackTrace()
        L38:
            r4 = 1
            return r4
        L3a:
            r5 = move-exception
            goto L83
        L3c:
            r5 = move-exception
            goto L44
        L3e:
            r5 = move-exception
            goto L48
        L40:
            r5 = move-exception
            goto L84
        L42:
            r5 = move-exception
            r4 = r0
        L44:
            r0 = r2
            goto L4f
        L46:
            r5 = move-exception
            r4 = r0
        L48:
            r0 = r2
            goto L69
        L4a:
            r5 = move-exception
            r2 = r0
            goto L84
        L4d:
            r5 = move-exception
            r4 = r0
        L4f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r5 = move-exception
            r5.printStackTrace()
        L5c:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r4 = move-exception
            r4.printStackTrace()
        L66:
            return r1
        L67:
            r5 = move-exception
            r4 = r0
        L69:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L76
            r0.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r5 = move-exception
            r5.printStackTrace()
        L76:
            if (r4 == 0) goto L80
            r4.close()     // Catch: java.io.IOException -> L7c
            goto L80
        L7c:
            r4 = move-exception
            r4.printStackTrace()
        L80:
            return r1
        L81:
            r5 = move-exception
            r2 = r0
        L83:
            r0 = r4
        L84:
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r4 = move-exception
            r4.printStackTrace()
        L8e:
            if (r0 == 0) goto L98
            r0.close()     // Catch: java.io.IOException -> L94
            goto L98
        L94:
            r4 = move-exception
            r4.printStackTrace()
        L98:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean copyFileWithCtx(FileInputStream fileInputStream, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    fileInputStream = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileInputStream.write(bArr, 0, read);
                        }
                        fileInputStream.flush();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                            return true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        bufferedInputStream2 = bufferedInputStream;
                        bufferedOutputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        return false;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedInputStream2 = bufferedInputStream;
                        bufferedOutputStream = fileInputStream;
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileInputStream == 0) {
                            throw th;
                        }
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileInputStream = 0;
                } catch (IOException e12) {
                    e = e12;
                    fileInputStream = 0;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedOutputStream2 = null;
        } catch (IOException e14) {
            e = e14;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = 0;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String fread(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.FileUtil.fread(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean mvFile(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedOutputStream = null;
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedOutputStream = null;
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            new File(str).delete();
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e6) {
                e6.printStackTrace();
                return true;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return false;
        } catch (IOException e10) {
            e = e10;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            if (bufferedOutputStream == null) {
                throw th;
            }
            try {
                bufferedOutputStream.close();
                throw th;
            } catch (IOException e14) {
                e14.printStackTrace();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized boolean cpFileWithCtx(Context context, String str, String str2) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        synchronized (FileUtil.class) {
            try {
                ?? openFileInput = context.openFileInput(str);
                if (openFileInput == 0) {
                    return false;
                }
                try {
                    FileOutputStream openFileOutput = context.openFileOutput(str2, 0);
                    if (openFileOutput == null) {
                        return false;
                    }
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        try {
                            bufferedInputStream = new BufferedInputStream(openFileInput);
                            try {
                                openFileInput = new BufferedOutputStream(openFileOutput);
                            } catch (FileNotFoundException e) {
                                e = e;
                                openFileInput = 0;
                            } catch (IOException e2) {
                                e = e2;
                                openFileInput = 0;
                            } catch (Throwable th) {
                                th = th;
                                openFileInput = 0;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = null;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        bufferedOutputStream2 = null;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        openFileInput = 0;
                        bufferedInputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            openFileInput.write(bArr, 0, read);
                        }
                        openFileInput.flush();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            openFileInput.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return true;
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        bufferedInputStream2 = bufferedInputStream;
                        bufferedOutputStream2 = openFileInput;
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return false;
                    } catch (IOException e10) {
                        e = e10;
                        bufferedInputStream2 = bufferedInputStream;
                        bufferedOutputStream = openFileInput;
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        if (openFileInput == 0) {
                            throw th;
                        }
                        try {
                            openFileInput.close();
                            throw th;
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e15) {
                    e15.printStackTrace();
                    return false;
                }
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                return false;
            }
        }
    }

    public static void cleanSpace(Context context) {
        String[] fileList = context.fileList();
        if (fileList == null) {
            return;
        }
        int i = 0;
        for (String str : fileList) {
            if (str.startsWith("hawk_data.pre") && (str.endsWith("comp") || str.endsWith("zip"))) {
                i++;
            }
        }
        if (i > 50) {
            for (String str2 : fileList) {
                if (str2.startsWith("hawk_data.pre") && (str2.endsWith("comp") || str2.endsWith("zip"))) {
                    context.deleteFile(str2);
                }
            }
            context.deleteFile("TAPM_CM_AUDIT");
        }
        for (String str3 : fileList) {
            if (str3.startsWith("hawk_data.pre_") && !str3.endsWith("comp") && !str3.endsWith("zip")) {
                context.deleteFile(str3);
            }
        }
        int i2 = 0;
        for (String str4 : fileList) {
            if (str4 != null && (str4.startsWith("TAPM_INI") || str4.startsWith("TAPM_TMP") || str4.startsWith("TAPM_COM") || str4.startsWith("TAPM_ERR"))) {
                i2++;
            }
        }
        if (i2 >= 80) {
            for (String str5 : fileList) {
                if (str5 != null && (str5.startsWith("TAPM_INI") || str5.startsWith("TAPM_TMP") || str5.startsWith("TAPM_COM") || str5.startsWith("TAPM_ERR"))) {
                    context.deleteFile(str5);
                }
            }
            context.deleteFile("__SEAUDIT");
        }
    }

    public static synchronized boolean checkFileExists(Context context, String str) {
        synchronized (FileUtil.class) {
            File fileStreamPath = context.getFileStreamPath(str);
            if (fileStreamPath != null) {
                if (fileStreamPath.exists()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static synchronized void deleteFile(Context context, String str) {
        synchronized (FileUtil.class) {
            if (context == null) {
                return;
            }
            if (!context.getFileStreamPath(str).delete()) {
                HawkLogger.e("delete file failed: " + str);
            }
        }
    }

    public static boolean unpackZip(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            byte[] bArr = new byte[4096];
            while (zipInputStream.getNextEntry() != null) {
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
            }
            zipInputStream.close();
            return true;
        } catch (IOException e) {
            HawkLogger.e("Unzip file failed : " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean cpAssetFile(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            android.content.res.AssetManager r1 = r3.getAssets()
            if (r1 != 0) goto L10
            java.lang.String r3 = "find no assetManager"
            com.tencent.hawk.bridge.HawkLogger.e(r3)
            return r0
        L10:
            r2 = 0
            java.io.InputStream r4 = r1.open(r4)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L6a
            if (r4 != 0) goto L27
            java.lang.String r3 = "cannot find default qcc file"
            com.tencent.hawk.bridge.HawkLogger.e(r3)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            if (r4 == 0) goto L26
            r4.close()     // Catch: java.io.IOException -> L22
            goto L26
        L22:
            r3 = move-exception
            r3.printStackTrace()
        L26:
            return r0
        L27:
            java.io.File r3 = r3.getFileStreamPath(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            r3 = 16384(0x4000, float:2.2959E-41)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
        L34:
            int r1 = r4.read(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2 = -1
            if (r1 == r2) goto L3f
            r5.write(r3, r0, r1)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            goto L34
        L3f:
            r5.flush()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r3 = "cp file from asset done"
            com.tencent.hawk.bridge.HawkLogger.i(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r3 = 1
            if (r4 == 0) goto L52
            r4.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r4 = move-exception
            r4.printStackTrace()
        L52:
            r5.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r4 = move-exception
            r4.printStackTrace()
        L5a:
            return r3
        L5b:
            r3 = move-exception
            goto L9b
        L5d:
            r3 = move-exception
            goto L64
        L5f:
            r3 = move-exception
            r5 = r2
            goto L9b
        L62:
            r3 = move-exception
            r5 = r2
        L64:
            r2 = r4
            goto L6c
        L66:
            r3 = move-exception
            r4 = r2
            r5 = r4
            goto L9b
        L6a:
            r3 = move-exception
            r5 = r2
        L6c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r4.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "cp asset file error :"
            r4.append(r1)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L99
            r4.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L99
            com.tencent.hawk.bridge.HawkLogger.e(r3)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r3 = move-exception
            r3.printStackTrace()
        L8e:
            if (r5 == 0) goto L98
            r5.close()     // Catch: java.io.IOException -> L94
            goto L98
        L94:
            r3 = move-exception
            r3.printStackTrace()
        L98:
            return r0
        L99:
            r3 = move-exception
            r4 = r2
        L9b:
            if (r4 == 0) goto La5
            r4.close()     // Catch: java.io.IOException -> La1
            goto La5
        La1:
            r4 = move-exception
            r4.printStackTrace()
        La5:
            if (r5 == 0) goto Laf
            r5.close()     // Catch: java.io.IOException -> Lab
            goto Laf
        Lab:
            r4 = move-exception
            r4.printStackTrace()
        Laf:
            throw r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.FileUtil.cpAssetFile(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static boolean checkFile(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        HawkLogger.d("CC not equal :" + str + " " + str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileMD5String(java.io.File r7) {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch: java.security.NoSuchAlgorithmException -> L8
            goto Ld
        L8:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        Ld:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r7]     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L4d
        L16:
            r4 = 0
            int r5 = r2.read(r3, r4, r7)     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L4d
            if (r5 <= 0) goto L27
            r6 = 0
        L1e:
            if (r6 >= r5) goto L23
            int r6 = r6 + 1
            goto L1e
        L23:
            r1.update(r3, r4, r5)     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L4d
            goto L16
        L27:
            byte[] r7 = r1.digest()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L4d
            java.lang.String r7 = com.tencent.hawk.bridge.HexUtil.bytes2HexStr(r7)     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L4d
            r2.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r0 = move-exception
            r0.printStackTrace()
        L37:
            return r7
        L38:
            r7 = move-exception
            goto L3f
        L3a:
            r7 = move-exception
            r2 = r0
            goto L4e
        L3d:
            r7 = move-exception
            r2 = r0
        L3f:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r7 = move-exception
            r7.printStackTrace()
        L4c:
            return r0
        L4d:
            r7 = move-exception
        L4e:
            if (r2 == 0) goto L58
            r2.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r0 = move-exception
            r0.printStackTrace()
        L58:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hawk.bridge.FileUtil.getFileMD5String(java.io.File):java.lang.String");
    }

    public static void preCreateFile(Context context) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput("hawk_data_init", 0);
            if (openFileOutput != null) {
                try {
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
