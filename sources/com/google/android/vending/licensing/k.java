package com.google.android.vending.licensing;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public int f5389a;
    public int b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;

    public static k a(String str) {
        String substring;
        int indexOf = str.indexOf(58);
        if (-1 == indexOf) {
            substring = "";
        } else {
            String substring2 = str.substring(0, indexOf);
            substring = indexOf >= str.length() ? "" : str.substring(indexOf + 1);
            str = substring2;
        }
        String[] split = TextUtils.split(str, Pattern.quote("|"));
        if (split.length < 6) {
            throw new IllegalArgumentException("Wrong number of fields.");
        }
        k kVar = new k();
        kVar.g = substring;
        kVar.f5389a = Integer.parseInt(split[0]);
        kVar.b = Integer.parseInt(split[1]);
        kVar.c = split[2];
        kVar.d = split[3];
        kVar.e = split[4];
        kVar.f = Long.parseLong(split[5]);
        return kVar;
    }

    public String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.f5389a), Integer.valueOf(this.b), this.c, this.d, this.e, Long.valueOf(this.f)});
    }
}
