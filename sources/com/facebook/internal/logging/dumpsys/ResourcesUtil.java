package com.facebook.internal.logging.dumpsys;

import android.content.res.Resources;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.imsdk.android.IR;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class ResourcesUtil {
    public static final ResourcesUtil INSTANCE = new ResourcesUtil();

    private final int getResourcePackageId(int i) {
        return (i >>> 24) & 255;
    }

    private ResourcesUtil() {
    }

    public static final String getIdStringQuietly(Resources resources, int i) {
        try {
            return getIdString(resources, i);
        } catch (Resources.NotFoundException unused) {
            return INSTANCE.getFallbackIdString(i);
        }
    }

    public static final String getIdString(Resources resources, int i) throws Resources.NotFoundException {
        String str;
        String str2;
        if (resources == null) {
            return INSTANCE.getFallbackIdString(i);
        }
        if (INSTANCE.getResourcePackageId(i) != 127) {
            str = resources.getResourcePackageName(i);
            h.a((Object) str, "r.getResourcePackageName(resourceId)");
            str2 = CertificateUtil.DELIMITER;
        } else {
            str = "";
            str2 = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i);
        String resourceEntryName = resources.getResourceEntryName(i);
        StringBuilder sb = new StringBuilder(str.length() + 1 + str2.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append(IR.account.EMAIL_TAG);
        sb.append(str);
        sb.append(str2);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        String sb2 = sb.toString();
        h.a((Object) sb2, "sb.toString()");
        return sb2;
    }

    private final String getFallbackIdString(int i) {
        return "#" + Integer.toHexString(i);
    }
}
