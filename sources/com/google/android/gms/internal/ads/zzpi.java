package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.nearby.connection.Connections;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzpi {
    private static final SparseIntArray d;
    private static final SparseIntArray e;
    private static final Map<String, Integer> f;

    /* renamed from: a, reason: collision with root package name */
    private static final zzpd f3704a = zzpd.zzbc("OMX.google.raw.decoder");
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<zzpd>> c = new HashMap<>();
    private static int g = -1;

    public static zzpd zziv() {
        return f3704a;
    }

    public static zzpd zze(String str, boolean z) throws zzpk {
        List<zzpd> a2 = a(str, z);
        if (a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3705a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f3705a = str;
            this.b = z;
        }

        public final int hashCode() {
            String str = this.f3705a;
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
            return TextUtils.equals(this.f3705a, aVar.f3705a) && this.b == aVar.b;
        }
    }

    private static synchronized List<zzpd> a(String str, boolean z) throws zzpk {
        synchronized (zzpi.class) {
            a aVar = new a(str, z);
            List<zzpd> list = c.get(aVar);
            if (list != null) {
                return list;
            }
            List<zzpd> a2 = a(aVar, zzsy.SDK_INT >= 21 ? new amz(z) : new amy());
            if (z && a2.isEmpty() && 21 <= zzsy.SDK_INT && zzsy.SDK_INT <= 23) {
                a2 = a(aVar, new amy());
                if (!a2.isEmpty()) {
                    String str2 = a2.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzpd> unmodifiableList = Collections.unmodifiableList(a2);
            c.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zziw() throws zzpk {
        int i;
        if (g == -1) {
            int i2 = 0;
            zzpd zze = zze("video/avc", false);
            if (zze != null) {
                MediaCodecInfo.CodecProfileLevel[] zziq = zze.zziq();
                int length = zziq.length;
                int i3 = 0;
                while (i2 < length) {
                    switch (zziq[i2].level) {
                        case 1:
                            i = 25344;
                            break;
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                            i = 101376;
                            break;
                        case 16:
                            i = 101376;
                            break;
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case 128:
                            i = 414720;
                            break;
                        case 256:
                            i = 414720;
                            break;
                        case 512:
                            i = 921600;
                            break;
                        case 1024:
                            i = 1310720;
                            break;
                        case ProgressEvent.PART_COMPLETED_EVENT_CODE /* 2048 */:
                            i = 2097152;
                            break;
                        case 4096:
                            i = 2097152;
                            break;
                        case 8192:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case Connections.MAX_BYTES_DATA_SIZE /* 32768 */:
                            i = 9437184;
                            break;
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzsy.SDK_INT >= 21 ? 345600 : 172800);
            }
            g = i2;
        }
        return g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0029, code lost:
    
        if (r3.equals("hev1") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbe(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.zzbe(java.lang.String):android.util.Pair");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzpk.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.amw):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01bb A[Catch: Exception -> 0x02af, TryCatch #0 {Exception -> 0x02af, blocks: (B:3:0x0004, B:5:0x0016, B:8:0x0026, B:11:0x0030, B:13:0x0036, B:15:0x003e, B:17:0x0046, B:19:0x004e, B:21:0x0056, B:23:0x005e, B:27:0x01bb, B:29:0x01c3, B:69:0x0238, B:71:0x023e, B:73:0x0244, B:76:0x026a, B:77:0x02a0, B:89:0x0069, B:91:0x006f, B:94:0x007a, B:96:0x007e, B:98:0x0086, B:101:0x0093, B:103:0x0099, B:105:0x00a1, B:107:0x00ab, B:109:0x00b5, B:111:0x00bf, B:113:0x00c9, B:115:0x00d3, B:117:0x00dd, B:119:0x00e7, B:121:0x00f1, B:123:0x00fb, B:125:0x0105, B:127:0x010f, B:130:0x011c, B:132:0x0120, B:134:0x0128, B:136:0x0132, B:138:0x013c, B:140:0x0146, B:143:0x0152, B:145:0x0158, B:147:0x0160, B:149:0x016a, B:151:0x0174, B:153:0x017e, B:155:0x0188, B:157:0x0192, B:160:0x019e, B:162:0x01a2, B:164:0x01ac), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzpd> a(com.google.android.gms.internal.ads.zzpi.a r16, com.google.android.gms.internal.ads.amx r17) throws com.google.android.gms.internal.ads.zzpk {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.a(com.google.android.gms.internal.ads.zzpi$a, com.google.android.gms.internal.ads.amx):java.util.List");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        if (strArr.length < 2) {
            String valueOf3 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf4 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                valueOf = valueOf4;
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String valueOf5 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf5.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf5) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf6 = Integer.valueOf(d.get(valueOf.intValue()));
            if (valueOf6 == null) {
                String valueOf7 = String.valueOf(valueOf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf7).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf7);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf8 = Integer.valueOf(e.get(valueOf2.intValue()));
            if (valueOf8 == null) {
                String valueOf9 = String.valueOf(valueOf2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf9).length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf9);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf6, valueOf8);
        } catch (NumberFormatException unused) {
            String valueOf10 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf10.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf10) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        d.put(77, 2);
        d.put(88, 4);
        d.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        e.put(11, 4);
        e.put(12, 8);
        e.put(13, 16);
        e.put(20, 32);
        e.put(21, 64);
        e.put(22, 128);
        e.put(30, 256);
        e.put(31, 512);
        e.put(32, 1024);
        e.put(40, ProgressEvent.PART_COMPLETED_EVENT_CODE);
        e.put(41, 4096);
        e.put(42, 8192);
        e.put(50, 16384);
        e.put(51, Connections.MAX_BYTES_DATA_SIZE);
        e.put(52, 65536);
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("L30", 1);
        f.put("L60", 4);
        f.put("L63", 16);
        f.put("L90", 64);
        f.put("L93", 256);
        f.put("L120", 1024);
        f.put("L123", 4096);
        f.put("L150", 16384);
        f.put("L153", 65536);
        f.put("L156", 262144);
        f.put("L180", Integer.valueOf(Constants.MB));
        f.put("L183", 4194304);
        f.put("L186", Integer.valueOf(SpecialCallActivity.FLAG_HARDWARE_ACCELERATED));
        f.put("H30", 2);
        f.put("H60", 8);
        f.put("H63", 32);
        f.put("H90", 128);
        f.put("H93", 512);
        f.put("H120", Integer.valueOf(ProgressEvent.PART_COMPLETED_EVENT_CODE));
        f.put("H123", 8192);
        f.put("H150", Integer.valueOf(Connections.MAX_BYTES_DATA_SIZE));
        f.put("H153", 131072);
        f.put("H156", 524288);
        f.put("H180", 2097152);
        f.put("H183", 8388608);
        f.put("H186", 33554432);
    }
}
