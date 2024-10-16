package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaa zzb(Context context, String str) throws zzz {
        zzaa zzd = zzd(context, str);
        return zzd != null ? zzd : zzc(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaa zzc(Context context, String str) {
        zzaa zzaaVar = new zzaa(zza.zzc(), System.currentTimeMillis());
        zzaa zza = zza(context, str, zzaaVar, true);
        if (zza != null && !zza.equals(zzaaVar)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
            }
            return zza;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        zza(context, str, zzaaVar);
        return zzaaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final zzaa zzd(Context context, String str) throws zzz {
        zzaa zze;
        try {
            zze = zze(context, str);
        } catch (zzz e) {
            e = e;
        }
        if (zze != null) {
            zza(context, str, zze);
            return zze;
        }
        e = null;
        try {
            zzaa zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (zza != null) {
                zza(context, str, zza, false);
                return zza;
            }
        } catch (zzz e2) {
            e = e2;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    private static KeyPair zzc(String str, String str2) throws zzz {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzz(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzz(e2);
        }
    }

    private final zzaa zze(Context context, String str) throws zzz {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (zzz | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzz(e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3 A[Catch: all -> 0x00b7, Throwable -> 0x00ba, TRY_ENTER, TryCatch #8 {Throwable -> 0x00ba, all -> 0x00b7, blocks: (B:8:0x0043, B:18:0x005f, B:29:0x00a1, B:39:0x00b3, B:40:0x00b6), top: B:7:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[Catch: all -> 0x00b7, Throwable -> 0x00ba, SYNTHETIC, TRY_LEAVE, TryCatch #8 {Throwable -> 0x00ba, all -> 0x00b7, blocks: (B:8:0x0043, B:18:0x005f, B:29:0x00a1, B:39:0x00b3, B:40:0x00b6), top: B:7:0x0043 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.firebase.iid.zzaa zza(android.content.Context r9, java.lang.String r10, com.google.firebase.iid.zzaa r11, boolean r12) {
        /*
            r8 = this;
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L10
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "Writing key to properties file"
            android.util.Log.d(r0, r2)
        L10:
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            java.lang.String r2 = "pub"
            java.lang.String r3 = com.google.firebase.iid.zzaa.zza(r11)
            r0.setProperty(r2, r3)
            java.lang.String r2 = "pri"
            java.lang.String r3 = com.google.firebase.iid.zzaa.zzb(r11)
            r0.setProperty(r2, r3)
            java.lang.String r2 = "cre"
            long r3 = com.google.firebase.iid.zzaa.zzc(r11)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setProperty(r2, r3)
            java.io.File r9 = zzf(r9, r10)
            r10 = 0
            r9.createNewFile()     // Catch: java.io.IOException -> Lc4
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> Lc4
            java.lang.String r3 = "rw"
            r2.<init>(r9, r3)     // Catch: java.io.IOException -> Lc4
            java.nio.channels.FileChannel r9 = r2.getChannel()     // Catch: java.lang.Throwable -> Lb7 java.lang.Throwable -> Lba
            r9.lock()     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            r3 = 0
            if (r12 == 0) goto L95
            long r5 = r9.size()     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            int r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r12 <= 0) goto L95
            r9.position(r3)     // Catch: com.google.firebase.iid.zzz -> L66 java.io.IOException -> L68 java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            com.google.firebase.iid.zzaa r11 = zza(r9)     // Catch: com.google.firebase.iid.zzz -> L66 java.io.IOException -> L68 java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            if (r9 == 0) goto L62
            zza(r10, r9)     // Catch: java.lang.Throwable -> Lb7 java.lang.Throwable -> Lba
        L62:
            zza(r10, r2)     // Catch: java.io.IOException -> Lc4
            return r11
        L66:
            r12 = move-exception
            goto L69
        L68:
            r12 = move-exception
        L69:
            java.lang.String r5 = "FirebaseInstanceId"
            boolean r1 = android.util.Log.isLoggable(r5, r1)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            if (r1 == 0) goto L95
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            java.lang.String r5 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            int r5 = r5.length()     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            int r5 = r5 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            r6.<init>(r5)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            java.lang.String r5 = "Tried reading key pair before writing new one, but failed with: "
            r6.append(r5)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            r6.append(r12)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            java.lang.String r12 = r6.toString()     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            android.util.Log.d(r1, r12)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
        L95:
            r9.position(r3)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            java.io.OutputStream r12 = java.nio.channels.Channels.newOutputStream(r9)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            r0.store(r12, r10)     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> Lab
            if (r9 == 0) goto La4
            zza(r10, r9)     // Catch: java.lang.Throwable -> Lb7 java.lang.Throwable -> Lba
        La4:
            zza(r10, r2)     // Catch: java.io.IOException -> Lc4
            return r11
        La8:
            r11 = move-exception
            r12 = r10
            goto Lb1
        Lab:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> Lad
        Lad:
            r12 = move-exception
            r7 = r12
            r12 = r11
            r11 = r7
        Lb1:
            if (r9 == 0) goto Lb6
            zza(r12, r9)     // Catch: java.lang.Throwable -> Lb7 java.lang.Throwable -> Lba
        Lb6:
            throw r11     // Catch: java.lang.Throwable -> Lb7 java.lang.Throwable -> Lba
        Lb7:
            r9 = move-exception
            r11 = r10
            goto Lc0
        Lba:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> Lbc
        Lbc:
            r11 = move-exception
            r7 = r11
            r11 = r9
            r9 = r7
        Lc0:
            zza(r11, r2)     // Catch: java.io.IOException -> Lc4
            throw r9     // Catch: java.io.IOException -> Lc4
        Lc4:
            r9 = move-exception
            java.lang.String r11 = "FirebaseInstanceId"
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r12 = java.lang.String.valueOf(r9)
            int r12 = r12.length()
            int r12 = r12 + 21
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "Failed to write key: "
            r0.append(r12)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            android.util.Log.w(r11, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzx.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzaa, boolean):com.google.firebase.iid.zzaa");
    }

    private static File zzb(Context context) {
        File b = a.b(context);
        if (b != null && b.isDirectory()) {
            return b;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zzf(Context context, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb2 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb2.append("com.google.InstanceId_");
                sb2.append(encodeToString);
                sb2.append(".properties");
                sb = sb2.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), sb);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[Catch: all -> 0x0032, Throwable -> 0x0034, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0006, B:8:0x001c, B:16:0x002e, B:17:0x0031), top: B:2:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[Catch: all -> 0x0032, Throwable -> 0x0034, SYNTHETIC, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0006, B:8:0x001c, B:16:0x002e, B:17:0x0031), top: B:2:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.firebase.iid.zzaa zza(java.io.File r10) throws com.google.firebase.iid.zzz, java.io.IOException {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            com.google.firebase.iid.zzaa r1 = zza(r7)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            if (r7 == 0) goto L1f
            zza(r10, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L1f:
            zza(r10, r0)
            return r1
        L23:
            r1 = move-exception
            r2 = r10
            goto L2c
        L26:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L28
        L28:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L2c:
            if (r7 == 0) goto L31
            zza(r2, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L31:
            throw r1     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L32:
            r1 = move-exception
            goto L36
        L34:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L32
        L36:
            zza(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzx.zza(java.io.File):com.google.firebase.iid.zzaa");
    }

    private static zzaa zza(FileChannel fileChannel) throws zzz, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new zzz("Invalid properties file");
        }
        try {
            return new zzaa(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new zzz(e);
        }
    }

    private static zzaa zza(SharedPreferences sharedPreferences, String str) throws zzz {
        String string = sharedPreferences.getString(zzax.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzax.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzaa(zzc(string, string2), zzb(sharedPreferences, str));
    }

    private final void zza(Context context, String str, zzaa zzaaVar) {
        String zzv;
        String zzw;
        long j;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzaaVar.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzz unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String zzd = zzax.zzd(str, "|P|");
        zzv = zzaaVar.zzv();
        edit.putString(zzd, zzv);
        String zzd2 = zzax.zzd(str, "|K|");
        zzw = zzaaVar.zzw();
        edit.putString(zzd2, zzw);
        String zzd3 = zzax.zzd(str, "cre");
        j = zzaaVar.zzbz;
        edit.putString(zzd3, String.valueOf(j));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzax.zzd(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }
}
