package com.tencent.abase;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.tencent.abase.log.XLog;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes2.dex */
public class SecurityStore {
    private static final String ALIAS = "GCloudCoreKeyChain";
    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    public static SecurityStore Instance = new SecurityStore();
    private static final String RSA = "RSA/ECB/PKCS1Padding";
    private static final String SP_NAME = "GCloudCoreSP";
    private Context mContext = null;
    private KeyPair mKeyPair = null;

    public void init(Context context) {
        this.mContext = context;
    }

    public void getKeyPair() {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            if (!keyStore.containsAlias(ALIAS)) {
                generateKeyPair(this.mContext, ALIAS);
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS, null);
            if (privateKeyEntry != null) {
                this.mKeyPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
            XLog.w("KeyChain init failed exception: " + e);
        }
    }

    public void setString(String str, String str2) {
        if (TX.Instance.getSolidConfigBool("GCloud.GCloudCore", "UseKeyStore", false) && this.mKeyPair == null) {
            getKeyPair();
        }
        if (this.mKeyPair != null) {
            try {
                Cipher cipher = Cipher.getInstance(RSA);
                cipher.init(1, this.mKeyPair.getPublic());
                str2 = Base64.encodeToString(cipher.doFinal(str2.getBytes("UTF-8")), 0);
            } catch (Exception e) {
                e.printStackTrace();
                XLog.e("KeyChain setString exception:" + e);
            }
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_NAME, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String getString(String str, String str2) {
        String string = this.mContext.getSharedPreferences(SP_NAME, 0).getString(str, str2);
        if (TX.Instance.getSolidConfigBool("GCloud.GCloudCore", "UseKeyStore", false) && this.mKeyPair == null) {
            getKeyPair();
        }
        if (this.mKeyPair == null) {
            return string;
        }
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(2, this.mKeyPair.getPrivate());
            return new String(cipher.doFinal(Base64.decode(string, 0)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            XLog.e("KeyChain setString exception:" + e);
            return string;
        }
    }

    private KeyPair generateKeyPair(Context context, String str) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", ANDROID_KEY_STORE);
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setDigests(Constants.SHA256, "SHA-512").setEncryptionPaddings("PKCS1Padding").setKeySize(4096).build());
            return keyPairGenerator.generateKeyPair();
        }
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 30);
        KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).setKeySize(4096).build();
        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", ANDROID_KEY_STORE);
        keyPairGenerator2.initialize(build);
        return keyPairGenerator2.generateKeyPair();
    }
}
