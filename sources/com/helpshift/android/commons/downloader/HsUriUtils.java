package com.helpshift.android.commons.downloader;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;

/* loaded from: classes2.dex */
public class HsUriUtils {
    public static boolean isValidUriPath(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean canReadFileAtUri(Context context, String str) {
        if (!isValidUriPath(str)) {
            return false;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            r1 = openFileDescriptor != null;
            closeParcelFileDescriptor(openFileDescriptor);
        } catch (Exception unused) {
            closeParcelFileDescriptor(null);
        } catch (Throwable th) {
            closeParcelFileDescriptor(null);
            throw th;
        }
        return r1;
    }

    public static void closeParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
