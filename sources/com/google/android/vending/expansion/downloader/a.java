package com.google.android.vending.expansion.downloader;

import java.io.File;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5357a = File.separator + "Android" + File.separator + "obb" + File.separator;
    public static final String b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("obb");
        sb.append(File.separator);
        b = sb.toString();
    }
}
