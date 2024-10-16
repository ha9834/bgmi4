package com.google.android.vending.licensing;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final i f5387a;
    private final e b;
    private final int c;
    private final String d;
    private final String e;
    private final c f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(i iVar, c cVar, e eVar, int i, String str, String str2) {
        this.f5387a = iVar;
        this.f = cVar;
        this.b = eVar;
        this.c = i;
        this.d = str;
        this.e = str2;
    }

    public e a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void a(PublicKey publicKey, int i, String str, String str2) {
        String str3;
        k kVar = null;
        if (i == 0 || i == 1 || i == 2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    Log.e("LicenseValidator", "Signature verification failed: signedData is empty. (Device not signed-in to any Google accounts?)");
                    d();
                    return;
                }
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publicKey);
                signature.update(str.getBytes());
                if (!signature.verify(com.google.android.vending.licensing.util.a.a(str2))) {
                    Log.e("LicenseValidator", "Signature verification failed.");
                    d();
                    return;
                }
                try {
                    kVar = k.a(str);
                    if (kVar.f5389a != i) {
                        Log.e("LicenseValidator", "Response codes don't match.");
                        d();
                        return;
                    }
                    if (kVar.b != this.c) {
                        Log.e("LicenseValidator", "Nonce doesn't match.");
                        d();
                        return;
                    }
                    if (!kVar.c.equals(this.d)) {
                        Log.e("LicenseValidator", "Package name doesn't match.");
                        d();
                        return;
                    } else if (!kVar.d.equals(this.e)) {
                        Log.e("LicenseValidator", "Version codes don't match.");
                        d();
                        return;
                    } else {
                        str3 = kVar.e;
                        if (TextUtils.isEmpty(str3)) {
                            Log.e("LicenseValidator", "User identifier is empty.");
                            d();
                            return;
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    Log.e("LicenseValidator", "Could not parse response.");
                    d();
                    return;
                }
            } catch (Base64DecoderException unused2) {
                Log.e("LicenseValidator", "Could not Base64-decode signature.");
                d();
                return;
            } catch (InvalidKeyException unused3) {
                a(5);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (SignatureException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            str3 = null;
        }
        switch (i) {
            case 0:
            case 2:
                a(this.f.a(str3), kVar);
                return;
            case 1:
                a(561, kVar);
                return;
            case 3:
                a(3);
                return;
            case 4:
                Log.w("LicenseValidator", "An error has occurred on the licensing server.");
                a(291, kVar);
                return;
            case 5:
                Log.w("LicenseValidator", "Licensing server is refusing to talk to this device, over quota.");
                a(291, kVar);
                return;
            default:
                switch (i) {
                    case 257:
                        Log.w("LicenseValidator", "Error contacting licensing server.");
                        a(291, kVar);
                        return;
                    case 258:
                        a(1);
                        return;
                    case 259:
                        a(2);
                        return;
                    default:
                        Log.e("LicenseValidator", "Unknown response code for license check.");
                        d();
                        return;
                }
        }
    }

    private void a(int i, k kVar) {
        this.f5387a.a(i, kVar);
        if (this.f5387a.c()) {
            this.b.allow(i);
        } else {
            this.b.dontAllow(i);
        }
    }

    private void a(int i) {
        this.b.applicationError(i);
    }

    private void d() {
        this.b.dontAllow(561);
    }
}
