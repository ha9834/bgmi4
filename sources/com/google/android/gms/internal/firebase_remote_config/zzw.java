package com.google.android.gms.internal.firebase_remote_config;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.google.android.gms.internal.firebase_remote_config.zzby;
import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzw extends zzby {

    @zzcc(HttpHeader.ACCEPT)
    private List<String> accept;

    @zzcc(HttpStack.HEADER_ACCEPT_ENCODING)
    private List<String> acceptEncoding;

    @zzcc("Age")
    private List<Long> age;

    @zzcc("WWW-Authenticate")
    private List<String> authenticate;

    @zzcc("Authorization")
    private List<String> authorization;

    @zzcc(Headers.CACHE_CONTROL)
    private List<String> cacheControl;

    @zzcc(Headers.CONTENT_ENCODING)
    private List<String> contentEncoding;

    @zzcc("Content-Length")
    private List<Long> contentLength;

    @zzcc(Headers.CONTENT_MD5)
    private List<String> contentMD5;

    @zzcc(Headers.CONTENT_RANGE)
    private List<String> contentRange;

    @zzcc("Content-Type")
    private List<String> contentType;

    @zzcc("Cookie")
    private List<String> cookie;

    @zzcc("Date")
    private List<String> date;

    @zzcc(Headers.ETAG)
    private List<String> etag;

    @zzcc(Headers.EXPIRES)
    private List<String> expires;

    @zzcc(Headers.GET_OBJECT_IF_MATCH)
    private List<String> ifMatch;

    @zzcc(Headers.GET_OBJECT_IF_MODIFIED_SINCE)
    private List<String> ifModifiedSince;

    @zzcc(Headers.GET_OBJECT_IF_NONE_MATCH)
    private List<String> ifNoneMatch;

    @zzcc("If-Range")
    private List<String> ifRange;

    @zzcc(Headers.GET_OBJECT_IF_UNMODIFIED_SINCE)
    private List<String> ifUnmodifiedSince;

    @zzcc(Headers.LAST_MODIFIED)
    private List<String> lastModified;

    @zzcc(HttpHeader.LOCATION)
    private List<String> location;

    @zzcc("MIME-Version")
    private List<String> mimeVersion;

    @zzcc(Headers.RANGE)
    private List<String> range;

    @zzcc("Retry-After")
    private List<String> retryAfter;

    @zzcc(HttpHeader.USER_AGENT)
    private List<String> userAgent;

    public zzw() {
        super(EnumSet.of(zzby.zzc.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton(HttpStack.ENCODING_GZIP));
    }

    public final zzw zzo(String str) {
        this.authorization = a((Object) null);
        return this;
    }

    public final String getContentType() {
        return (String) a((List) this.contentType);
    }

    public final String zzq() {
        return (String) a((List) this.etag);
    }

    public final zzw zzp(String str) {
        this.ifModifiedSince = a((Object) null);
        return this;
    }

    public final zzw zzq(String str) {
        this.ifMatch = a((Object) null);
        return this;
    }

    public final zzw zzr(String str) {
        this.ifNoneMatch = a(str);
        return this;
    }

    public final zzw zzs(String str) {
        this.ifUnmodifiedSince = a((Object) null);
        return this;
    }

    public final zzw zzt(String str) {
        this.ifRange = a((Object) null);
        return this;
    }

    public final String getLocation() {
        return (String) a((List) this.location);
    }

    public final String getUserAgent() {
        return (String) a((List) this.userAgent);
    }

    public final zzw zzu(String str) {
        this.userAgent = a(str);
        return this;
    }

    private static void a(Logger logger, StringBuilder sb, StringBuilder sb2, zzaj zzajVar, String str, Object obj, Writer writer) throws IOException {
        if (obj == null || zzbt.isNull(obj)) {
            return;
        }
        String name = obj instanceof Enum ? zzbz.zza((Enum<?>) obj).getName() : obj.toString();
        String str2 = (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : name;
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            sb.append(zzcl.zzgh);
        }
        if (sb2 != null) {
            sb2.append(" -H '");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            sb2.append("'");
        }
        if (zzajVar != null) {
            zzajVar.addHeader(str, name);
        }
        if (writer != null) {
            writer.write(str);
            writer.write(": ");
            writer.write(name);
            writer.write(APLogFileUtil.SEPARATOR_LINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzw zzwVar, StringBuilder sb, StringBuilder sb2, Logger logger, zzaj zzajVar) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : zzwVar.entrySet()) {
            String key = entry.getKey();
            Object[] objArr = {key};
            if (!hashSet.add(key)) {
                throw new IllegalArgumentException(zzdy.zza("multiple headers of the same name (headers are case insensitive): %s", objArr));
            }
            Object value = entry.getValue();
            if (value != null) {
                zzbz zzae = zzwVar.zzby().zzae(key);
                if (zzae != null) {
                    key = zzae.getName();
                }
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = zzco.zzi(value).iterator();
                    while (it.hasNext()) {
                        a(logger, sb, sb2, zzajVar, key, it.next(), null);
                    }
                } else {
                    a(logger, sb, sb2, zzajVar, key, value, null);
                }
            }
        }
    }

    public final void zza(zzai zzaiVar, StringBuilder sb) throws IOException {
        clear();
        er erVar = new er(this, sb);
        int zzah = zzaiVar.zzah();
        for (int i = 0; i < zzah; i++) {
            String zzc = zzaiVar.zzc(i);
            String zzd = zzaiVar.zzd(i);
            List<Type> list = erVar.d;
            zzbr zzbrVar = erVar.c;
            zzbn zzbnVar = erVar.f4095a;
            StringBuilder sb2 = erVar.b;
            if (sb2 != null) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzc).length() + 2 + String.valueOf(zzd).length());
                sb3.append(zzc);
                sb3.append(": ");
                sb3.append(zzd);
                sb2.append(sb3.toString());
                sb2.append(zzcl.zzgh);
            }
            zzbz zzae = zzbrVar.zzae(zzc);
            if (zzae != null) {
                Type zza = zzbt.zza(list, zzae.getGenericType());
                if (zzco.zzc(zza)) {
                    Class<?> zzb = zzco.zzb(list, zzco.zzd(zza));
                    zzbnVar.zza(zzae.zzbz(), zzb, a(zzb, list, zzd));
                } else if (zzco.zza(zzco.zzb(list, zza), (Class<?>) Iterable.class)) {
                    Collection<Object> collection = (Collection) zzae.zzh(this);
                    if (collection == null) {
                        collection = zzbt.zzb(zza);
                        zzae.zzb(this, collection);
                    }
                    collection.add(a(zza == Object.class ? null : zzco.zze(zza), list, zzd));
                } else {
                    zzae.zzb(this, a(zza, list, zzd));
                }
            } else {
                ArrayList arrayList = (ArrayList) get(zzc);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    zzb(zzc, arrayList);
                }
                arrayList.add(zzd);
            }
        }
        erVar.f4095a.zzbu();
    }

    private static <T> T a(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static <T> List<T> a(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private static Object a(Type type, List<Type> list, String str) {
        return zzbt.zza(zzbt.zza(list, type), str);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    /* renamed from: zzb */
    public final /* synthetic */ zzby clone() {
        return (zzw) clone();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzw) super.zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby, java.util.AbstractMap
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzw) super.clone();
    }
}
