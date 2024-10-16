package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzg;
import com.google.android.gms.tagmanager.zzgj;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzor {
    public static zzov zza(zzi zziVar) throws zzoz {
        zzl[] zzlVarArr = new zzl[zziVar.zzpj.length];
        for (int i = 0; i < zziVar.zzpj.length; i++) {
            a(i, zziVar, zzlVarArr, new HashSet(0));
        }
        zzow zzmn = zzov.zzmn();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zziVar.zzpm.length; i2++) {
            arrayList.add(a(zziVar.zzpm[i2], zziVar, zzlVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zziVar.zzpn.length; i3++) {
            arrayList2.add(a(zziVar.zzpn[i3], zziVar, zzlVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zziVar.zzpl.length; i4++) {
            zzot a2 = a(zziVar.zzpl[i4], zziVar, zzlVarArr, i4);
            zzmn.zzc(a2);
            arrayList3.add(a2);
        }
        for (zzc.zze zzeVar : zziVar.zzpo) {
            zzoy zzoyVar = new zzoy();
            Iterator<Integer> it = zzeVar.zzn().iterator();
            while (it.hasNext()) {
                zzoyVar.zzd((zzot) arrayList2.get(it.next().intValue()));
            }
            Iterator<Integer> it2 = zzeVar.zzo().iterator();
            while (it2.hasNext()) {
                zzoyVar.zze((zzot) arrayList2.get(it2.next().intValue()));
            }
            Iterator<Integer> it3 = zzeVar.zzp().iterator();
            while (it3.hasNext()) {
                zzoyVar.zzf((zzot) arrayList.get(it3.next().intValue()));
            }
            Iterator<Integer> it4 = zzeVar.zzr().iterator();
            while (it4.hasNext()) {
                zzoyVar.zzct(zziVar.zzpj[it4.next().intValue()].string);
            }
            Iterator<Integer> it5 = zzeVar.zzq().iterator();
            while (it5.hasNext()) {
                zzoyVar.zzg((zzot) arrayList.get(it5.next().intValue()));
            }
            Iterator<Integer> it6 = zzeVar.zzs().iterator();
            while (it6.hasNext()) {
                zzoyVar.zzcu(zziVar.zzpj[it6.next().intValue()].string);
            }
            Iterator<Integer> it7 = zzeVar.zzt().iterator();
            while (it7.hasNext()) {
                zzoyVar.zzh((zzot) arrayList3.get(it7.next().intValue()));
            }
            Iterator<Integer> it8 = zzeVar.zzv().iterator();
            while (it8.hasNext()) {
                zzoyVar.zzcv(zziVar.zzpj[it8.next().intValue()].string);
            }
            Iterator<Integer> it9 = zzeVar.zzu().iterator();
            while (it9.hasNext()) {
                zzoyVar.zzi((zzot) arrayList3.get(it9.next().intValue()));
            }
            Iterator<Integer> it10 = zzeVar.zzw().iterator();
            while (it10.hasNext()) {
                zzoyVar.zzcw(zziVar.zzpj[it10.next().intValue()].string);
            }
            zzmn.zzb(zzoyVar.zzms());
        }
        zzmn.zzcs(zziVar.version);
        zzmn.zzaf(zziVar.zzpw);
        return zzmn.zzmp();
    }

    public static zzl zzk(zzl zzlVar) {
        zzl zzlVar2 = new zzl();
        zzlVar2.type = zzlVar.type;
        zzlVar2.zzqv = (int[]) zzlVar.zzqv.clone();
        if (zzlVar.zzqw) {
            zzlVar2.zzqw = zzlVar.zzqw;
        }
        return zzlVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzl a(int i, zzi zziVar, zzl[] zzlVarArr, Set<Integer> set) throws zzoz {
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 90);
            sb.append("Value cycle detected.  Current value reference: ");
            sb.append(i);
            sb.append(".  Previous value references: ");
            sb.append(valueOf);
            sb.append(".");
            a(sb.toString());
        }
        zzl zzlVar = (zzl) a(zziVar.zzpj, i, "values");
        if (zzlVarArr[i] != null) {
            return zzlVarArr[i];
        }
        zzl zzlVar2 = null;
        set.add(Integer.valueOf(i));
        int i2 = 0;
        switch (zzlVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzlVar2 = zzlVar;
                break;
            case 2:
                zzg.zza a2 = a(zzlVar);
                zzl zzk = zzk(zzlVar);
                zzk.zzqn = new zzl[a2.zzpz.length];
                int[] iArr = a2.zzpz;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    zzk.zzqn[i3] = a(iArr[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i3 = i4;
                }
                zzlVar2 = zzk;
                break;
            case 3:
                zzlVar2 = zzk(zzlVar);
                zzg.zza a3 = a(zzlVar);
                if (a3.zzqa.length != a3.zzqb.length) {
                    int length2 = a3.zzqa.length;
                    int length3 = a3.zzqb.length;
                    StringBuilder sb2 = new StringBuilder(58);
                    sb2.append("Uneven map keys (");
                    sb2.append(length2);
                    sb2.append(") and map values (");
                    sb2.append(length3);
                    sb2.append(")");
                    a(sb2.toString());
                }
                zzlVar2.zzqo = new zzl[a3.zzqa.length];
                zzlVar2.zzqp = new zzl[a3.zzqa.length];
                int[] iArr2 = a3.zzqa;
                int length4 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length4) {
                    zzlVar2.zzqo[i6] = a(iArr2[i5], zziVar, zzlVarArr, set);
                    i5++;
                    i6++;
                }
                int[] iArr3 = a3.zzqb;
                int length5 = iArr3.length;
                int i7 = 0;
                while (i2 < length5) {
                    zzlVar2.zzqp[i7] = a(iArr3[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i7++;
                }
                break;
            case 4:
                zzlVar2 = zzk(zzlVar);
                zzlVar2.zzqq = zzgj.zzc(a(a(zzlVar).zzqe, zziVar, zzlVarArr, set));
                break;
            case 7:
                zzlVar2 = zzk(zzlVar);
                zzg.zza a4 = a(zzlVar);
                zzlVar2.zzqu = new zzl[a4.zzqd.length];
                int[] iArr4 = a4.zzqd;
                int length6 = iArr4.length;
                int i8 = 0;
                while (i2 < length6) {
                    zzlVar2.zzqu[i8] = a(iArr4[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i8++;
                }
                break;
        }
        if (zzlVar2 == null) {
            String valueOf2 = String.valueOf(zzlVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 15);
            sb3.append("Invalid value: ");
            sb3.append(valueOf2);
            a(sb3.toString());
        }
        zzlVarArr[i] = zzlVar2;
        set.remove(Integer.valueOf(i));
        return zzlVar2;
    }

    private static zzg.zza a(zzl zzlVar) throws zzoz {
        if (((zzg.zza) zzlVar.zza(zzg.zza.zzpx)) == null) {
            String valueOf = String.valueOf(zzlVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 54);
            sb.append("Expected a ServingValue and didn't get one. Value is: ");
            sb.append(valueOf);
            a(sb.toString());
        }
        return (zzg.zza) zzlVar.zza(zzg.zza.zzpx);
    }

    private static void a(String str) throws zzoz {
        com.google.android.gms.tagmanager.zzdi.zzav(str);
        throw new zzoz(str);
    }

    private static <T> T a(T[] tArr, int i, String str) throws zzoz {
        if (i < 0 || i >= tArr.length) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
            sb.append("Index out of bounds detected: ");
            sb.append(i);
            sb.append(" in ");
            sb.append(str);
            a(sb.toString());
        }
        return tArr[i];
    }

    private static zzot a(zzc.zzb zzbVar, zzi zziVar, zzl[] zzlVarArr, int i) throws zzoz {
        zzou zzml = zzot.zzml();
        Iterator<Integer> it = zzbVar.zze().iterator();
        while (it.hasNext()) {
            zzc.zzd zzdVar = (zzc.zzd) a(zziVar.zzpk, it.next().intValue(), "properties");
            String str = (String) a(zziVar.zzpi, zzdVar.zzl(), "keys");
            zzl zzlVar = (zzl) a(zzlVarArr, zzdVar.getValue(), "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzml.zzm(zzlVar);
            } else {
                zzml.zzb(str, zzlVar);
            }
        }
        return zzml.zzmm();
    }

    public static void zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }
}
