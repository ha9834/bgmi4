package com.nostra13.universalimageloader.b;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class d {
    public static String a(String str, com.nostra13.universalimageloader.core.assist.c cVar) {
        return str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + cVar.a() + "x" + cVar.b();
    }

    public static Comparator<String> a() {
        return new Comparator<String>() { // from class: com.nostra13.universalimageloader.b.d.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)).compareTo(str2.substring(0, str2.lastIndexOf(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)));
            }
        };
    }
}
