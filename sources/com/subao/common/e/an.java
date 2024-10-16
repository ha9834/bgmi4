package com.subao.common.e;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public final String f5971a;
    public final String b;
    public final int c;

    public an(String str, String str2, int i) {
        this.f5971a = TextUtils.isEmpty(str) ? "http" : str;
        this.b = str2;
        this.c = i;
    }

    public static an a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(https?)://([^/:?]+)(?::(\\d{1,5}))?/?", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group(2);
        if (!TextUtils.isEmpty(group)) {
            String group2 = matcher.group(3);
            int parseInt = group2 != null ? Integer.parseInt(group2) : -1;
            if (parseInt == -1 || (parseInt > 0 && parseInt < 65536)) {
                return new an(matcher.group(1), group, parseInt);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof an)) {
            return false;
        }
        an anVar = (an) obj;
        return this.c == anVar.c && com.subao.common.e.a(this.b, anVar.b) && com.subao.common.e.a(this.f5971a, anVar.f5971a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f5971a.length() + this.b.length() + 64);
        sb.append(this.f5971a);
        sb.append("://");
        sb.append(this.b);
        if (this.c >= 0) {
            sb.append(':');
            sb.append(this.c);
        }
        return sb.toString();
    }
}
