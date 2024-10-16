package com.devbrackets.android.exomedia.b;

import android.net.Uri;

/* loaded from: classes.dex */
public class b {
    public static String a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return null;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf == -1 && uri.getPathSegments().size() > 1) {
            lastPathSegment = uri.getPathSegments().get(uri.getPathSegments().size() - 2);
            lastIndexOf = lastPathSegment.lastIndexOf(46);
        }
        if (lastIndexOf == -1) {
            lastIndexOf = 0;
            lastPathSegment = "." + uri.getLastPathSegment();
        }
        return lastPathSegment.substring(lastIndexOf).toLowerCase();
    }
}
