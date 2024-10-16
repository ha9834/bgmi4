package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzsy {
    public static final String DEVICE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f3740a;
    private static final Pattern b;
    private static final Pattern c;
    private static final int[] d;
    public static final String zzbnq;

    public static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int zzbs(int i) {
        if (i == 8) {
            return 3;
        }
        if (i != 16) {
            return i != 24 ? i != 32 ? 0 : 1073741824 : BleSignal.UNKNOWN_TX_POWER;
        }
        return 2;
    }

    public static ExecutorService zzax(String str) {
        return Executors.newSingleThreadExecutor(new anu(str));
    }

    public static void zza(zzrv zzrvVar) {
        if (zzrvVar != null) {
            try {
                zzrvVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String zzbg(String str) {
        if (str == null) {
            return null;
        }
        return new Locale(str).getLanguage();
    }

    public static byte[] zzbh(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static int zzb(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int zzd(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static float zza(float f, float f2, float f3) {
        return Math.max(0.1f, Math.min(f, 8.0f));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r6 = java.util.Arrays.binarySearch(r3, r4)
            if (r6 >= 0) goto La
            int r6 = r6 + 2
            int r3 = -r6
            goto L16
        La:
            int r6 = r6 + (-1)
            if (r6 < 0) goto L14
            r0 = r3[r6]
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto La
        L14:
            int r3 = r6 + 1
        L16:
            if (r7 == 0) goto L1d
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L1d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zza(long[], long, boolean, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzb(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L9
            r5 = r0 ^ (-1)
            goto L1a
        L9:
            int r0 = r0 + 1
            int r1 = r4.length
            if (r0 >= r1) goto L14
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L9
        L14:
            if (r7 == 0) goto L19
            int r5 = r0 + (-1)
            goto L1a
        L19:
            r5 = r0
        L1a:
            if (r8 == 0) goto L24
            int r4 = r4.length
            int r4 = r4 + (-1)
            int r4 = java.lang.Math.min(r4, r5)
            return r4
        L24:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zzb(long[], long, boolean, boolean):int");
    }

    public static long zza(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        double d2 = j2;
        double d3 = j3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = j;
        Double.isNaN(d4);
        return (long) (d4 * (d2 / d3));
    }

    public static void zza(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long j4 = 1000000 / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
            return;
        }
        double d2 = j2;
        Double.isNaN(d2);
        double d3 = 1000000.0d / d2;
        while (i < jArr.length) {
            double d4 = jArr[i];
            Double.isNaN(d4);
            jArr[i] = (long) (d4 * d3);
            i++;
        }
    }

    public static int zzay(String str) {
        int length = str.length();
        zzsk.checkArgument(length <= 4);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i << 8) | str.charAt(i2);
        }
        return i;
    }

    public static byte[] zzbi(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i << 1;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String zza(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static int zzg(int i, int i2) {
        if (i == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i == 1073741824) {
            return i2 << 2;
        }
        switch (i) {
            case 2:
                return i2 << 1;
            case 3:
                return i2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int zzbt(int i) {
        switch (i) {
            case 0:
                return SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            case 1:
                return 3538944;
            case 2:
                return 13107200;
            case 3:
                return 131072;
            case 4:
                return 131072;
            default:
                throw new IllegalStateException();
        }
    }

    static {
        SDK_INT = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        DEVICE = Build.DEVICE;
        MANUFACTURER = Build.MANUFACTURER;
        MODEL = Build.MODEL;
        String str = DEVICE;
        String str2 = MODEL;
        String str3 = MANUFACTURER;
        int i = SDK_INT;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        zzbnq = sb.toString();
        f3740a = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        b = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        c = Pattern.compile("%([A-Fa-f0-9]{2})");
        d = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }
}
