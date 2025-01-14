package com.google.android.gms.internal.firebase_remote_config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzt extends zzby {
    private static final zzcr c = new zzcu("=&-_.!~*'()@:$,;/?:", false);
    private String d;
    private String e;
    private String f;
    private int g;
    private List<String> h;
    private String i;

    public zzt() {
        this.g = -1;
    }

    public zzt(String str) {
        this(b(str));
    }

    public zzt(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private zzt(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        this.g = -1;
        this.d = str.toLowerCase(Locale.US);
        this.e = str2;
        this.g = i;
        this.h = a(str3);
        this.i = str4 != null ? zzcs.zzai(str4) : null;
        if (str5 != null) {
            zzam.zze(str5, this);
        }
        this.f = str6 != null ? zzcs.zzai(str6) : null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return zzp().hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof zzt)) {
            return zzp().equals(((zzt) obj).zzp());
        }
        return false;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return zzp();
    }

    public final String zzp() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) zzdt.checkNotNull(this.d));
        sb.append("://");
        String str = this.f;
        if (str != null) {
            sb.append(zzcs.zzal(str));
            sb.append('@');
        }
        sb.append((String) zzdt.checkNotNull(this.e));
        int i = this.g;
        if (i != -1) {
            sb.append(':');
            sb.append(i);
        }
        String valueOf = String.valueOf(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        List<String> list = this.h;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = this.h.get(i2);
                if (i2 != 0) {
                    sb2.append('/');
                }
                if (str2.length() != 0) {
                    sb2.append(zzcs.zzaj(str2));
                }
            }
        }
        a(entrySet(), sb2);
        String str3 = this.i;
        if (str3 != null) {
            sb2.append('#');
            sb2.append(c.zzag(str3));
        }
        String valueOf2 = String.valueOf(sb2.toString());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final URL zzk(String str) {
        try {
            return new URL(b(zzp()), str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final void zzl(String str) {
        this.h = a(null);
    }

    private static List<String> a(String str) {
        String substring;
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i = 0;
        while (z) {
            int indexOf = str.indexOf(47, i);
            boolean z2 = indexOf != -1;
            if (z2) {
                substring = str.substring(i, indexOf);
            } else {
                substring = str.substring(i);
            }
            arrayList.add(zzcs.zzai(substring));
            i = indexOf + 1;
            z = z2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String zzam = zzcs.zzam(entry.getKey());
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        z = a(z, sb, zzam, it.next());
                    }
                } else {
                    z = a(z, sb, zzam, value);
                }
            }
        }
    }

    private static boolean a(boolean z, StringBuilder sb, String str, Object obj) {
        if (z) {
            z = false;
            sb.append('?');
        } else {
            sb.append('&');
        }
        sb.append(str);
        String zzam = zzcs.zzam(obj.toString());
        if (zzam.length() != 0) {
            sb.append('=');
            sb.append(zzam);
        }
        return z;
    }

    private static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    /* renamed from: zzb */
    public final /* synthetic */ zzby clone() {
        return (zzt) clone();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzt) super.zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby, java.util.AbstractMap
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzt zztVar = (zzt) super.clone();
        List<String> list = this.h;
        if (list != null) {
            zztVar.h = new ArrayList(list);
        }
        return zztVar;
    }
}
