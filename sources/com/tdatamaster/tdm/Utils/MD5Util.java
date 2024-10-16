package com.tdatamaster.tdm.Utils;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.tdatamaster.tdm.system.TDMLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class MD5Util {
    private static String TAG = "TUtils";

    public static byte[] encode(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encode2HexStr(byte[] bArr) {
        return HexUtil.bytes2HexStr(encode(bArr));
    }

    public static String encode2Base64(byte[] bArr) {
        return Base64Util.encode(encode(bArr));
    }

    public static byte[] encodeFile(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            byte[] digest = messageDigest.digest();
                            try {
                                fileInputStream.close();
                                return digest;
                            } catch (IOException e) {
                                TDMLog.d(TAG, "IOException: " + e.getMessage());
                                return digest;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            TDMLog.d(TAG, "IOException: " + e2.getMessage());
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    TDMLog.d(TAG, "IOEXCeption: " + e3.getMessage());
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        TDMLog.d(TAG, "IOException: " + e4.getMessage());
                    }
                    return null;
                }
            }
        } catch (FileNotFoundException e5) {
            TDMLog.d(TAG, "FileNotFoundException : " + e5.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e6) {
            TDMLog.d(TAG, "NoSuchAlgorithmException : " + e6.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStream] */
    public static byte[] encodeAssetsFile(Context context, String str) {
        MessageDigest messageDigest;
        byte[] bArr;
        InputStream inputStream;
        String str2;
        String str3;
        try {
            try {
                messageDigest = MessageDigest.getInstance(Constants.MD5);
                bArr = new byte[1024];
            } catch (Throwable th) {
                th = th;
            }
            try {
                inputStream = context.getAssets().open(str);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (FileNotFoundException unused) {
                        TDMLog.i(TAG, "FileNotFoundException，may not be noticed if not using the encrypt function");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                TDMLog.i(TAG, "IOEXCeption: " + e.getMessage());
                                str2 = TAG;
                                str3 = "IOEXCeption";
                                TDMLog.e(str2, str3);
                                return null;
                            }
                        }
                        return null;
                    } catch (IOException e2) {
                        e = e2;
                        TDMLog.i(TAG, "IOEXCeption: " + e.getMessage());
                        TDMLog.e(TAG, "IOEXCeption");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                TDMLog.i(TAG, "IOEXCeption: " + e3.getMessage());
                                str2 = TAG;
                                str3 = "IOEXCeption";
                                TDMLog.e(str2, str3);
                                return null;
                            }
                        }
                        return null;
                    }
                }
                byte[] digest = messageDigest.digest();
                if (inputStream == null) {
                    return digest;
                }
                try {
                    inputStream.close();
                    return digest;
                } catch (IOException e4) {
                    TDMLog.i(TAG, "IOEXCeption: " + e4.getMessage());
                    TDMLog.e(TAG, "IOEXCeption");
                    return digest;
                }
            } catch (FileNotFoundException unused2) {
                inputStream = null;
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                if (context != 0) {
                    try {
                        context.close();
                    } catch (IOException e6) {
                        TDMLog.i(TAG, "IOEXCeption: " + e6.getMessage());
                        TDMLog.e(TAG, "IOEXCeption");
                    }
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException e7) {
            TDMLog.i(TAG, "NoSuchAlgorithmException: " + e7.getMessage());
            TDMLog.e(TAG, "NoSuchAlgorithmException");
            return null;
        }
    }

    public static String encodeFile2HexStr(String str) {
        return HexUtil.bytes2HexStr(encodeFile(str));
    }

    public static String encodeAssets2HexStr(Context context, String str) {
        return HexUtil.bytes2HexStr(encodeAssetsFile(context, str));
    }

    public static String encodeFile2Base64(String str) {
        byte[] encodeFile = encodeFile(str);
        if (encodeFile == null) {
            return null;
        }
        return Base64Util.encode(encodeFile);
    }
}
