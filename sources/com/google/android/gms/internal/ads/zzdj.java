package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdj {
    private static Cipher b;
    private static final Object c = new Object();
    private static final Object d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final SecureRandom f3559a = null;

    public zzdj(SecureRandom secureRandom) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] zzan(String str) throws zzdk {
        try {
            byte[] zza = zzcg.zza(str, false);
            if (zza.length != 32) {
                throw new zzdk(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zzdk(this, e);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) throws zzdk {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzdk(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            synchronized (c) {
                a().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = a().doFinal(bArr2);
                iv = a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length];
            allocate.get(bArr3);
            return zzcg.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzdk(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzdk(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzdk(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzdk(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzdk(this, e5);
        }
    }

    public final byte[] zza(byte[] bArr, String str) throws zzdk {
        byte[] doFinal;
        if (bArr.length != 16) {
            throw new zzdk(this);
        }
        try {
            byte[] zza = zzcg.zza(str, false);
            if (zza.length <= 16) {
                throw new zzdk(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[zza.length - 16];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            synchronized (c) {
                a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = a().doFinal(bArr3);
            }
            return doFinal;
        } catch (IllegalArgumentException e) {
            throw new zzdk(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzdk(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzdk(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzdk(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzdk(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzdk(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzdk(this, e7);
        }
    }

    private static Cipher a() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (d) {
            if (b == null) {
                b = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            }
            cipher = b;
        }
        return cipher;
    }
}
