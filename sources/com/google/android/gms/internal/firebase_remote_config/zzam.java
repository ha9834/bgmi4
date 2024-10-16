package com.google.android.gms.internal.firebase_remote_config;

import com.helpshift.common.domain.network.NetworkConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzam implements zzci {
    public static final String MEDIA_TYPE = new zzy(NetworkConstants.contentType).zza(zzbo.UTF_8).zzp();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zze(String str, Object obj) {
        if (str == null) {
            return;
        }
        try {
            StringReader stringReader = new StringReader(str);
            Class<?> cls = obj.getClass();
            zzbr zzc = zzbr.zzc(cls);
            List asList = Arrays.asList(cls);
            zzby zzbyVar = zzby.class.isAssignableFrom(cls) ? (zzby) obj : null;
            Map map = Map.class.isAssignableFrom(cls) ? (Map) obj : null;
            zzbn zzbnVar = new zzbn(obj);
            StringWriter stringWriter = new StringWriter();
            StringWriter stringWriter2 = new StringWriter();
            StringWriter stringWriter3 = stringWriter;
            boolean z = true;
            while (true) {
                int read = stringReader.read();
                if (read == -1 || read == 38) {
                    String zzai = zzcs.zzai(stringWriter3.toString());
                    if (zzai.length() != 0) {
                        String zzai2 = zzcs.zzai(stringWriter2.toString());
                        zzbz zzae = zzc.zzae(zzai);
                        if (zzae != null) {
                            Type zza = zzbt.zza((List<Type>) asList, zzae.getGenericType());
                            if (zzco.zzc(zza)) {
                                Class<?> zzb = zzco.zzb(asList, zzco.zzd(zza));
                                zzbnVar.zza(zzae.zzbz(), zzb, a(zzb, asList, zzai2));
                            } else if (zzco.zza(zzco.zzb(asList, zza), (Class<?>) Iterable.class)) {
                                Collection<Object> collection = (Collection) zzae.zzh(obj);
                                if (collection == null) {
                                    collection = zzbt.zzb(zza);
                                    zzae.zzb(obj, collection);
                                }
                                collection.add(a(zza == Object.class ? null : zzco.zze(zza), asList, zzai2));
                            } else {
                                zzae.zzb(obj, a(zza, asList, zzai2));
                            }
                        } else if (map != null) {
                            ArrayList arrayList = (ArrayList) map.get(zzai);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                if (zzbyVar != null) {
                                    zzbyVar.zzb(zzai, arrayList);
                                } else {
                                    map.put(zzai, arrayList);
                                }
                            }
                            arrayList.add(zzai2);
                        }
                    }
                    StringWriter stringWriter4 = new StringWriter();
                    StringWriter stringWriter5 = new StringWriter();
                    if (read == -1) {
                        zzbnVar.zzbu();
                        return;
                    } else {
                        stringWriter3 = stringWriter4;
                        stringWriter2 = stringWriter5;
                        z = true;
                    }
                } else if (read != 61) {
                    if (z) {
                        stringWriter3.write(read);
                    } else {
                        stringWriter2.write(read);
                    }
                } else if (z) {
                    z = false;
                } else {
                    stringWriter2.write(read);
                }
            }
        } catch (IOException e) {
            throw zzeb.zzb(e);
        }
    }

    private static Object a(Type type, List<Type> list, String str) {
        return zzbt.zza(zzbt.zza(list, type), str);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzci
    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        throw new NoSuchMethodError();
    }
}
