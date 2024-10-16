package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashSet;
import kotlin.collections.ab;
import kotlin.collections.j;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class FacebookSignatureValidator {
    public static final FacebookSignatureValidator INSTANCE = new FacebookSignatureValidator();
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBL2_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    private static final HashSet<String> validAppSignatureHashes = ab.a((Object[]) new String[]{FBR_HASH, FBR2_HASH, FBI_HASH, FBL_HASH, FBL2_HASH, MSR_HASH, FBF_HASH});

    private FacebookSignatureValidator() {
    }

    public static final boolean validateSignature(Context context, String str) {
        h.b(context, "context");
        h.b(str, "packageName");
        String str2 = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        h.a((Object) str2, "brand");
        if (l.a(str2, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, (Object) null) && (i & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures != null) {
                Signature[] signatureArr = packageInfo.signatures;
                h.a((Object) signatureArr, "packageInfo.signatures");
                if (!(signatureArr.length == 0)) {
                    Signature[] signatureArr2 = packageInfo.signatures;
                    h.a((Object) signatureArr2, "packageInfo.signatures");
                    for (Signature signature : signatureArr2) {
                        HashSet<String> hashSet = validAppSignatureHashes;
                        byte[] byteArray = signature.toByteArray();
                        h.a((Object) byteArray, "it.toByteArray()");
                        if (!j.a((Iterable<? extends String>) hashSet, Utility.sha1hash(byteArray))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
