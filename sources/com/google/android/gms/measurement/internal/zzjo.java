package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class zzjo extends gq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjg zzjgVar) {
        super(zzjgVar);
    }

    @Override // com.google.android.gms.measurement.internal.gq
    protected final boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbs.zzk.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zzqz().zzra().zzrb();
        if (obj instanceof String) {
            zzaVar.zzdc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zzbl(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zzc(((Double) obj).doubleValue());
        } else {
            zzab().zzgk().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzbs.zze.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zzmu().zzmv().zzmw();
        if (obj instanceof String) {
            zzaVar.zzca((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zzam(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzab().zzgk().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbs.zze a(zzbs.zzc zzcVar, String str) {
        for (zzbs.zze zzeVar : zzcVar.zzmj()) {
            if (zzeVar.getName().equals(str)) {
                return zzeVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(zzbs.zzc zzcVar, String str) {
        zzbs.zze a2 = a(zzcVar, str);
        if (a2 == null) {
            return null;
        }
        if (a2.zzmx()) {
            return a2.zzmy();
        }
        if (a2.zzna()) {
            return Long.valueOf(a2.zznb());
        }
        if (a2.zznd()) {
            return Double.valueOf(a2.zzne());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzbs.zzc.zza zzaVar, String str, Object obj) {
        List<zzbs.zze> zzmj = zzaVar.zzmj();
        int i = 0;
        while (true) {
            if (i >= zzmj.size()) {
                i = -1;
                break;
            } else if (str.equals(zzmj.get(i).getName())) {
                break;
            } else {
                i++;
            }
        }
        zzbs.zze.zza zzbz = zzbs.zze.zzng().zzbz(str);
        if (obj instanceof Long) {
            zzbz.zzam(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzbz.zzca((String) obj);
        } else if (obj instanceof Double) {
            zzbz.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zzaVar.zza(i, zzbz);
        } else {
            zzaVar.zza(zzbz);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(zzbs.zzf zzfVar) {
        List<zzbs.zze> zzmj;
        if (zzfVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzbs.zzg zzgVar : zzfVar.zzni()) {
            if (zzgVar != null) {
                a(sb, 1);
                sb.append("bundle {\n");
                if (zzgVar.zznx()) {
                    a(sb, 1, "protocol_version", Integer.valueOf(zzgVar.zzny()));
                }
                a(sb, 1, Constants.PARAM_PLATFORM, zzgVar.zzom());
                if (zzgVar.zzoq()) {
                    a(sb, 1, "gmp_version", Long.valueOf(zzgVar.zzao()));
                }
                if (zzgVar.zzor()) {
                    a(sb, 1, "uploading_gmp_version", Long.valueOf(zzgVar.zzos()));
                }
                if (zzgVar.zzpq()) {
                    a(sb, 1, "dynamite_version", Long.valueOf(zzgVar.zzaq()));
                }
                if (zzgVar.zzpi()) {
                    a(sb, 1, "config_version", Long.valueOf(zzgVar.zzpj()));
                }
                a(sb, 1, "gmp_app_id", zzgVar.getGmpAppId());
                a(sb, 1, "admob_app_id", zzgVar.zzpp());
                a(sb, 1, "app_id", zzgVar.zzag());
                a(sb, 1, "app_version", zzgVar.zzal());
                if (zzgVar.zzpf()) {
                    a(sb, 1, "app_version_major", Integer.valueOf(zzgVar.zzpg()));
                }
                a(sb, 1, "firebase_instance_id", zzgVar.getFirebaseInstanceId());
                if (zzgVar.zzow()) {
                    a(sb, 1, "dev_cert_hash", Long.valueOf(zzgVar.zzap()));
                }
                a(sb, 1, "app_store", zzgVar.zzan());
                if (zzgVar.zzoc()) {
                    a(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgVar.zzod()));
                }
                if (zzgVar.zzoe()) {
                    a(sb, 1, "start_timestamp_millis", Long.valueOf(zzgVar.zznq()));
                }
                if (zzgVar.zzof()) {
                    a(sb, 1, "end_timestamp_millis", Long.valueOf(zzgVar.zznr()));
                }
                if (zzgVar.zzog()) {
                    a(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgVar.zzoh()));
                }
                if (zzgVar.zzoj()) {
                    a(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgVar.zzok()));
                }
                a(sb, 1, "app_instance_id", zzgVar.getAppInstanceId());
                a(sb, 1, "resettable_device_id", zzgVar.zzot());
                a(sb, 1, "device_id", zzgVar.zzph());
                a(sb, 1, "ds_id", zzgVar.zzpl());
                if (zzgVar.zzou()) {
                    a(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgVar.zzov()));
                }
                a(sb, 1, "os_version", zzgVar.getOsVersion());
                a(sb, 1, "device_model", zzgVar.zzon());
                a(sb, 1, "user_default_language", zzgVar.zzcr());
                if (zzgVar.zzoo()) {
                    a(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgVar.zzop()));
                }
                if (zzgVar.zzox()) {
                    a(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgVar.zzoy()));
                }
                if (zzgVar.zzpb()) {
                    a(sb, 1, "service_upload", Boolean.valueOf(zzgVar.zzpc()));
                }
                a(sb, 1, "health_monitor", zzgVar.zzoz());
                if (zzgVar.zzpk() && zzgVar.zzbd() != 0) {
                    a(sb, 1, "android_id", Long.valueOf(zzgVar.zzbd()));
                }
                if (zzgVar.zzpn()) {
                    a(sb, 1, "retry_counter", Integer.valueOf(zzgVar.zzpo()));
                }
                List<zzbs.zzk> zzno = zzgVar.zzno();
                if (zzno != null) {
                    for (zzbs.zzk zzkVar : zzno) {
                        if (zzkVar != null) {
                            a(sb, 2);
                            sb.append("user_property {\n");
                            a(sb, 2, "set_timestamp_millis", zzkVar.zzqs() ? Long.valueOf(zzkVar.zzqt()) : null);
                            a(sb, 2, "name", zzy().c(zzkVar.getName()));
                            a(sb, 2, "string_value", zzkVar.zzmy());
                            a(sb, 2, "int_value", zzkVar.zzna() ? Long.valueOf(zzkVar.zznb()) : null);
                            a(sb, 2, "double_value", zzkVar.zznd() ? Double.valueOf(zzkVar.zzne()) : null);
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbs.zza> zzpd = zzgVar.zzpd();
                String zzag = zzgVar.zzag();
                if (zzpd != null) {
                    for (zzbs.zza zzaVar : zzpd) {
                        if (zzaVar != null) {
                            a(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzaVar.zzly()) {
                                a(sb, 2, "audience_id", Integer.valueOf(zzaVar.zzlz()));
                            }
                            if (zzaVar.zzma()) {
                                a(sb, 2, "new_audience", Boolean.valueOf(zzaVar.zzmb()));
                            }
                            a(sb, 2, "current_data", zzaVar.zzlv(), zzag);
                            a(sb, 2, "previous_data", zzaVar.zzlx(), zzag);
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbs.zzc> zznl = zzgVar.zznl();
                if (zznl != null) {
                    for (zzbs.zzc zzcVar : zznl) {
                        if (zzcVar != null) {
                            a(sb, 2);
                            sb.append("event {\n");
                            a(sb, 2, "name", zzy().a(zzcVar.getName()));
                            if (zzcVar.zzml()) {
                                a(sb, 2, "timestamp_millis", Long.valueOf(zzcVar.getTimestampMillis()));
                            }
                            if (zzcVar.zzmo()) {
                                a(sb, 2, "previous_timestamp_millis", Long.valueOf(zzcVar.zzmm()));
                            }
                            if (zzcVar.zzmp()) {
                                a(sb, 2, "count", Integer.valueOf(zzcVar.getCount()));
                            }
                            if (zzcVar.zzmk() != 0 && (zzmj = zzcVar.zzmj()) != null) {
                                for (zzbs.zze zzeVar : zzmj) {
                                    if (zzeVar != null) {
                                        a(sb, 3);
                                        sb.append("param {\n");
                                        a(sb, 3, "name", zzy().b(zzeVar.getName()));
                                        a(sb, 3, "string_value", zzeVar.zzmy());
                                        a(sb, 3, "int_value", zzeVar.zzna() ? Long.valueOf(zzeVar.zznb()) : null);
                                        a(sb, 3, "double_value", zzeVar.zznd() ? Double.valueOf(zzeVar.zzne()) : null);
                                        a(sb, 3);
                                        sb.append("}\n");
                                    }
                                }
                            }
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                a(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(zzbk.zza zzaVar) {
        if (zzaVar == null) {
            return com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzaVar.zzkb()) {
            a(sb, 0, "filter_id", Integer.valueOf(zzaVar.getId()));
        }
        a(sb, 0, "event_name", zzy().a(zzaVar.zzjz()));
        String a2 = a(zzaVar.zzkf(), zzaVar.zzkg(), zzaVar.zzki());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", a2);
        }
        a(sb, 1, "event_count_filter", zzaVar.zzke());
        sb.append("  filters {\n");
        Iterator<zzbk.zzb> it = zzaVar.zzkc().iterator();
        while (it.hasNext()) {
            a(sb, 2, it.next());
        }
        a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(zzbk.zzd zzdVar) {
        if (zzdVar == null) {
            return com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzdVar.zzkb()) {
            a(sb, 0, "filter_id", Integer.valueOf(zzdVar.getId()));
        }
        a(sb, 0, "property_name", zzy().c(zzdVar.getPropertyName()));
        String a2 = a(zzdVar.zzkf(), zzdVar.zzkg(), zzdVar.zzki());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", a2);
        }
        a(sb, 1, zzdVar.zzli());
        sb.append("}\n");
        return sb.toString();
    }

    private static String a(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void a(StringBuilder sb, int i, String str, zzbs.zzi zziVar, String str2) {
        if (zziVar == null) {
            return;
        }
        a(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziVar.zzpz() != 0) {
            a(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zziVar.zzpy()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zziVar.zzpw() != 0) {
            a(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zziVar.zzpv()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzad().f(str2)) {
            if (zziVar.zzqc() != 0) {
                a(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzbs.zzb zzbVar : zziVar.zzqb()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzbVar.zzme() ? Integer.valueOf(zzbVar.getIndex()) : null);
                    sb.append(CertificateUtil.DELIMITER);
                    sb.append(zzbVar.zzmf() ? Long.valueOf(zzbVar.zzmg()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zziVar.zzqf() != 0) {
                a(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzbs.zzj zzjVar : zziVar.zzqe()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzjVar.zzme() ? Integer.valueOf(zzjVar.getIndex()) : null);
                    sb.append(": [");
                    Iterator<Long> it = zzjVar.zzqk().iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        long longValue = it.next().longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
        }
        a(sb, 3);
        sb.append("}\n");
    }

    private final void a(StringBuilder sb, int i, String str, zzbk.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        a(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzcVar.zzku()) {
            a(sb, i, "comparison_type", zzcVar.zzkv().name());
        }
        if (zzcVar.zzkw()) {
            a(sb, i, "match_as_float", Boolean.valueOf(zzcVar.zzkx()));
        }
        a(sb, i, "comparison_value", zzcVar.zzkz());
        a(sb, i, "min_comparison_value", zzcVar.zzlb());
        a(sb, i, "max_comparison_value", zzcVar.zzld());
        a(sb, i);
        sb.append("}\n");
    }

    private final void a(StringBuilder sb, int i, zzbk.zzb zzbVar) {
        if (zzbVar == null) {
            return;
        }
        a(sb, i);
        sb.append("filter {\n");
        if (zzbVar.zzkp()) {
            a(sb, i, "complement", Boolean.valueOf(zzbVar.zzkq()));
        }
        a(sb, i, "param_name", zzy().b(zzbVar.zzkr()));
        int i2 = i + 1;
        zzbk.zze zzkm = zzbVar.zzkm();
        if (zzkm != null) {
            a(sb, i2);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzkm.zzlk()) {
                a(sb, i2, "match_type", zzkm.zzll().name());
            }
            a(sb, i2, "expression", zzkm.zzln());
            if (zzkm.zzlo()) {
                a(sb, i2, "case_sensitive", Boolean.valueOf(zzkm.zzlp()));
            }
            if (zzkm.zzlr() > 0) {
                a(sb, i2 + 1);
                sb.append("expression_list {\n");
                for (String str : zzkm.zzlq()) {
                    a(sb, i2 + 2);
                    sb.append(str);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            a(sb, i2);
            sb.append("}\n");
        }
        a(sb, i2, "number_filter", zzbVar.zzko());
        a(sb, i);
        sb.append("}\n");
    }

    private static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        a(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzab().zzgk().zzao("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(zzai zzaiVar, zzn zznVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotNull(zznVar);
        if (!TextUtils.isEmpty(zznVar.zzcg) || !TextUtils.isEmpty(zznVar.zzcu)) {
            return true;
        }
        zzae();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<Long> list, int i) {
        if (i < (list.size() << 6)) {
            return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        j |= 1 << i2;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> a(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzab().zzgn().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzab().zzgn().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        for (int size2 = arrayList.size() - 1; size2 >= 0 && ((Long) arrayList.get(size2)).longValue() == 0; size2--) {
            size = size2;
        }
        return arrayList.subList(0, size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzx().currentTimeMillis() - j) > j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzz().zzo();
        MessageDigest d = zzjs.d();
        if (d == null) {
            zzab().zzgk().zzao("Failed to get MD5");
            return 0L;
        }
        return zzjs.a(d.digest(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzab().zzgk().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] c(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzab().zzgk().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Integer> d() {
        Map<String, String> zzk = zzak.zzk(this.f4889a.getContext());
        if (zzk == null || zzk.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzak.zzhr.get(null).intValue();
        for (Map.Entry<String, String> entry : zzk.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzab().zzgn().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzab().zzgn().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzjo zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ hb zzgx() {
        return super.zzgx();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ he zzgy() {
        return super.zzgy();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzfd zzgz() {
        return super.zzgz();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
