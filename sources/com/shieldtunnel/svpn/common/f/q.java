package com.shieldtunnel.svpn.common.f;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f5827a;
    public final String b;
    public final int c;

    public q(String str, String str2, int i) {
        this.f5827a = TextUtils.isEmpty(str) ? "http" : str;
        this.b = str2;
        this.c = i;
    }

    public static q a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(https?)://([^/:?]+)(?::(\\d{1,5}))?/?", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group(2);
        if (TextUtils.isEmpty(group)) {
            return null;
        }
        String group2 = matcher.group(3);
        int parseInt = group2 != null ? Integer.parseInt(group2) : -1;
        if (parseInt == -1 || (parseInt > 0 && parseInt < 65536)) {
            return new q(matcher.group(1), group, parseInt);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.c == qVar.c && com.shieldtunnel.svpn.common.c.a(this.b, qVar.b) && com.shieldtunnel.svpn.common.c.a(this.f5827a, qVar.f5827a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f5827a.length() + this.b.length() + 64);
        sb.append(this.f5827a);
        sb.append("://");
        sb.append(this.b);
        if (this.c >= 0) {
            sb.append(':');
            sb.append(this.c);
        }
        return sb.toString();
    }
}
