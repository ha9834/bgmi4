package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class tr {
    private static boolean b;
    private static MessageDigest c;
    private static final Object d = new Object();
    private static final Object e = new Object();

    /* renamed from: a */
    static CountDownLatch f2525a = new CountDownLatch(1);

    public static void a() {
        synchronized (e) {
            if (!b) {
                b = true;
                new Thread(new un()).start();
            }
        }
    }

    private static MessageDigest b() {
        boolean z;
        MessageDigest messageDigest;
        a();
        try {
            z = f2525a.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = c) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String a(zzbp.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] a2;
        byte[] byteArray = zzaVar.toByteArray();
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcrm)).booleanValue()) {
            if (aix.f1902a == null) {
                throw new GeneralSecurityException();
            }
            a2 = ((zzbp.zzg) ((zzdob) zzbp.zzg.zzbk().zzn(zzdmr.zzz(aix.f1902a.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzbw.TINK_HYBRID).zzaya())).toByteArray();
        } else {
            Vector<byte[]> a3 = a(byteArray, 255);
            if (a3 == null || a3.size() == 0) {
                a2 = a(a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzbp.zzg.zza zzbk = zzbp.zzg.zzbk();
                Iterator<byte[]> it = a3.iterator();
                while (it.hasNext()) {
                    zzbk.zzn(zzdmr.zzz(a(it.next(), str, false)));
                }
                zzbk.zzo(zzdmr.zzz(a(byteArray)));
                a2 = ((zzbp.zzg) ((zzdob) zzbk.zzaya())).toByteArray();
            }
        }
        return zzcg.zza(a2, true);
    }

    private static Vector<byte[]> a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zzbp.zza a(zzbp.zza.zzd zzdVar) {
        zzbp.zza.C0092zza zzam = zzbp.zza.zzam();
        zzam.zzau(zzdVar.zzac());
        return (zzbp.zza) ((zzdob) zzam.zzaya());
    }

    private static byte[] a(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = z ? TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE : 255;
        if (bArr.length > i) {
            bArr = a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(a(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (vy vyVar : new zzcl().cN) {
            vyVar.a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdmh(str.getBytes("UTF-8")).zzy(bArr3);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (d) {
            MessageDigest b2 = b();
            if (b2 == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b2.reset();
            b2.update(bArr);
            digest = c.digest();
        }
        return digest;
    }

    public static String a(String str, String str2, boolean z) {
        byte[] b2 = b(str, str2, true);
        if (b2 != null) {
            return zzcg.zza(b2, true);
        }
        return Integer.toString(7);
    }

    private static byte[] b(String str, String str2, boolean z) {
        byte[] zza;
        zzbp.zzc.zza zzaw = zzbp.zzc.zzaw();
        try {
            if (str.length() < 3) {
                zza = str.getBytes("ISO-8859-1");
            } else {
                zza = zzcg.zza(str, true);
            }
            zzaw.zzc(zzdmr.zzz(zza));
            zzaw.zzd(zzdmr.zzz(str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzcg.zza(str2, true)));
            return ((zzbp.zzc) ((zzdob) zzaw.zzaya())).toByteArray();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }
}
