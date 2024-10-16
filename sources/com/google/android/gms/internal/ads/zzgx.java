package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzgx {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> f3642a = new HashMap<>();

    public static zzgc zzc(String str, boolean z) throws zzgz {
        Pair<String, MediaCodecInfo.CodecCapabilities> a2 = a(str, z);
        if (a2 == null) {
            return null;
        }
        return new zzgc((String) a2.first, zzkq.SDK_INT >= 19 ? ((MediaCodecInfo.CodecCapabilities) a2.second).isFeatureSupported("adaptive-playback") : false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3643a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f3643a = str;
            this.b = z;
        }

        public final int hashCode() {
            String str = this.f3643a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f3643a, aVar.f3643a) && this.b == aVar.b;
        }
    }

    private static synchronized Pair<String, MediaCodecInfo.CodecCapabilities> a(String str, boolean z) throws zzgz {
        synchronized (zzgx.class) {
            a aVar = new a(str, z);
            if (f3642a.containsKey(aVar)) {
                return f3642a.get(aVar);
            }
            Pair<String, MediaCodecInfo.CodecCapabilities> a2 = a(aVar, zzkq.SDK_INT >= 21 ? new ajp(z) : new ajo());
            if (z && a2 == null && zzkq.SDK_INT >= 21 && (a2 = a(aVar, new ajo())) != null) {
                String str2 = (String) a2.first;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
            return a2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Pair<String, MediaCodecInfo.CodecCapabilities> a(a aVar, ajn ajnVar) throws zzgz {
        try {
            String str = aVar.f3643a;
            int a2 = ajnVar.a();
            boolean b = ajnVar.b();
            boolean z = false;
            int i = 0;
            while (i < a2) {
                MediaCodecInfo a3 = ajnVar.a(i);
                String name = a3.getName();
                if (!a3.isEncoder() && name.startsWith("OMX.") && (b || !name.endsWith(".secure"))) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int i2 = 0;
                    while (i2 < supportedTypes.length) {
                        String str2 = supportedTypes[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str2);
                            boolean a4 = ajnVar.a(aVar.f3643a, capabilitiesForType);
                            if (!b) {
                                f3642a.put(aVar.b ? new a(str, z) : aVar, Pair.create(name, capabilitiesForType));
                                if (a4) {
                                    f3642a.put(aVar.b ? aVar : new a(str, true), Pair.create(String.valueOf(name).concat(".secure"), capabilitiesForType));
                                }
                            } else {
                                f3642a.put(aVar.b == a4 ? aVar : new a(str, a4), Pair.create(name, capabilitiesForType));
                            }
                            if (f3642a.containsKey(aVar)) {
                                return f3642a.get(aVar);
                            }
                        }
                        i2++;
                        z = false;
                    }
                }
                i++;
                z = false;
            }
            return null;
        } catch (Exception e) {
            throw new zzgz(e);
        }
    }
}
