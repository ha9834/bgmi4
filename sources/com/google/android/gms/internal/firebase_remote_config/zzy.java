package com.google.android.gms.internal.firebase_remote_config;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzy {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f4196a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private static final Pattern b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern c;
    private static final Pattern d;
    private String e;
    private String f;
    private final SortedMap<String, String> g = new TreeMap();
    private String h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzy(String str) {
        this.e = "application";
        this.f = "octet-stream";
        Matcher matcher = c.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.valueOf("Type must be in the 'maintype/subtype; parameter=value' format"));
        }
        String group = matcher.group(1);
        if (!f4196a.matcher(group).matches()) {
            throw new IllegalArgumentException(String.valueOf("Type contains reserved characters"));
        }
        this.e = group;
        this.h = null;
        String group2 = matcher.group(2);
        if (!f4196a.matcher(group2).matches()) {
            throw new IllegalArgumentException(String.valueOf("Subtype contains reserved characters"));
        }
        this.f = group2;
        this.h = null;
        String group3 = matcher.group(3);
        if (group3 != null) {
            Matcher matcher2 = d.matcher(group3);
            while (matcher2.find()) {
                String group4 = matcher2.group(1);
                String group5 = matcher2.group(3);
                if (group5 == null) {
                    group5 = matcher2.group(2);
                }
                a(group4, group5);
            }
        }
    }

    private final zzy a(String str, String str2) {
        if (str2 == null) {
            this.h = null;
            this.g.remove(str.toLowerCase(Locale.US));
            return this;
        }
        if (!b.matcher(str).matches()) {
            throw new IllegalArgumentException(String.valueOf("Name contains reserved characters"));
        }
        this.h = null;
        this.g.put(str.toLowerCase(Locale.US), str2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return b.matcher(str).matches();
    }

    public final String zzp() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('/');
        sb.append(this.f);
        SortedMap<String, String> sortedMap = this.g;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                String value = entry.getValue();
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=");
                if (!a(value)) {
                    String replace = value.replace("\\", "\\\\").replace("\"", "\\\"");
                    StringBuilder sb2 = new StringBuilder(String.valueOf(replace).length() + 2);
                    sb2.append("\"");
                    sb2.append(replace);
                    sb2.append("\"");
                    value = sb2.toString();
                }
                sb.append(value);
            }
        }
        this.h = sb.toString();
        return this.h;
    }

    public final String toString() {
        return zzp();
    }

    private final boolean a(zzy zzyVar) {
        return zzyVar != null && this.e.equalsIgnoreCase(zzyVar.e) && this.f.equalsIgnoreCase(zzyVar.f);
    }

    public static boolean zzb(String str, String str2) {
        return str2 != null && new zzy(str).a(new zzy(str2));
    }

    public final zzy zza(Charset charset) {
        a("charset", charset == null ? null : charset.name());
        return this;
    }

    public final Charset zzr() {
        String str = this.g.get("charset".toLowerCase(Locale.US));
        if (str == null) {
            return null;
        }
        return Charset.forName(str);
    }

    public final int hashCode() {
        return zzp().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzyVar = (zzy) obj;
        return a(zzyVar) && this.g.equals(zzyVar.g);
    }

    static {
        StringBuilder sb = new StringBuilder(String.valueOf("[^\\s/=;\"]+").length() + 14 + String.valueOf("[^\\s/=;\"]+").length() + String.valueOf(";.*").length());
        sb.append("\\s*(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")/(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")\\s*(");
        sb.append(";.*");
        sb.append(")?");
        c = Pattern.compile(sb.toString(), 32);
        StringBuilder sb2 = new StringBuilder(String.valueOf("\"([^\"]*)\"").length() + 1 + String.valueOf("[^\\s;\"]*").length());
        sb2.append("\"([^\"]*)\"");
        sb2.append("|");
        sb2.append("[^\\s;\"]*");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder(String.valueOf("[^\\s/=;\"]+").length() + 12 + String.valueOf(sb3).length());
        sb4.append("\\s*;\\s*(");
        sb4.append("[^\\s/=;\"]+");
        sb4.append(")=(");
        sb4.append(sb3);
        sb4.append(")");
        d = Pattern.compile(sb4.toString());
    }
}
