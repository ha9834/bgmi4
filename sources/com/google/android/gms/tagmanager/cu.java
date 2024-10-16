package com.google.android.gms.tagmanager;

import android.content.Context;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzl;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzox;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class cu {

    /* renamed from: a, reason: collision with root package name */
    private static final bs<zzl> f5110a = new bs<>(zzgj.zzkc(), true);
    private final zzov b;
    private final ae c;
    private final Map<String, ag> d;
    private final Map<String, ag> e;
    private final Map<String, ag> f;
    private final eh<zzot, bs<zzl>> g;
    private final eh<String, da> h;
    private final Set<zzox> i;
    private final DataLayer j;
    private final Map<String, db> k;
    private volatile String l;
    private int m;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public cu(Context context, zzov zzovVar, DataLayer dataLayer, zzan zzanVar, zzan zzanVar2, ae aeVar) {
        if (zzovVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.b = zzovVar;
        this.i = new HashSet(zzovVar.zzls());
        this.j = dataLayer;
        this.c = aeVar;
        cv cvVar = new cv(this);
        new ei();
        this.g = ei.a(Constants.MB, cvVar);
        cw cwVar = new cw(this);
        new ei();
        this.h = ei.a(Constants.MB, cwVar);
        this.d = new HashMap();
        b(new zzm(context));
        b(new l(zzanVar2));
        b(new w(dataLayer));
        b(new zzgk(context, dataLayer));
        this.e = new HashMap();
        c(new j());
        c(new ac());
        c(new zzbm());
        c(new ai());
        c(new aj());
        c(new az());
        c(new ba());
        c(new cd());
        c(new Cdo());
        this.f = new HashMap();
        a(new bt(context));
        a(new cs(context));
        a(new eb(context));
        a(new ec(context));
        a(new ed(context));
        a(new ee(context));
        a(new ef(context));
        a(new ek());
        a(new i(this.b.getVersion()));
        a(new l(zzanVar));
        a(new p(dataLayer));
        a(new y(context));
        a(new z());
        a(new ab());
        a(new af(this));
        a(new ak());
        a(new al());
        a(new at(context));
        a(new au());
        a(new zzdd());
        a(new be());
        a(new bg(context));
        a(new bu());
        a(new by());
        a(new ca());
        a(new cc());
        a(new ce(context));
        a(new dc());
        a(new dd());
        a(new dv());
        a(new dy());
        this.k = new HashMap();
        for (zzox zzoxVar : this.i) {
            for (int i = 0; i < zzoxVar.zzmq().size(); i++) {
                zzot zzotVar = zzoxVar.zzmq().get(i);
                db a2 = a(this.k, a(zzotVar));
                a2.a(zzoxVar);
                a2.a(zzoxVar, zzotVar);
                a2.a(zzoxVar, "Unknown");
            }
            for (int i2 = 0; i2 < zzoxVar.zzmr().size(); i2++) {
                zzot zzotVar2 = zzoxVar.zzmr().get(i2);
                db a3 = a(this.k, a(zzotVar2));
                a3.a(zzoxVar);
                a3.b(zzoxVar, zzotVar2);
                a3.b(zzoxVar, "Unknown");
            }
        }
        for (Map.Entry<String, List<zzot>> entry : this.b.zzmo().entrySet()) {
            for (zzot zzotVar3 : entry.getValue()) {
                if (!zzgj.zzg(zzotVar3.zzlu().get(zzb.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    a(this.k, entry.getKey()).a(zzotVar3);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(List<zzj> list) {
        for (zzj zzjVar : list) {
            if (zzjVar.name != null && zzjVar.name.startsWith("gaExperiment:")) {
                DataLayer dataLayer = this.j;
                if (zzjVar.zzqi == null) {
                    zzdi.zzac("supplemental missing experimentSupplemental");
                } else {
                    for (zzl zzlVar : zzjVar.zzqi.zzpf) {
                        dataLayer.a(zzgj.zzc(zzlVar));
                    }
                    zzl[] zzlVarArr = zzjVar.zzqi.zzpe;
                    int length = zzlVarArr.length;
                    int i = 0;
                    while (true) {
                        Map<String, Object> map = null;
                        if (i >= length) {
                            break;
                        }
                        Object zzh = zzgj.zzh(zzlVarArr[i]);
                        if (!(zzh instanceof Map)) {
                            String valueOf = String.valueOf(zzh);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                            sb.append("value: ");
                            sb.append(valueOf);
                            sb.append(" is not a map value, ignored.");
                            zzdi.zzac(sb.toString());
                        } else {
                            map = (Map) zzh;
                        }
                        if (map != null) {
                            dataLayer.push(map);
                        }
                        i++;
                    }
                    for (zzc.C0108zzc c0108zzc : zzjVar.zzqi.zzpg) {
                        if (!c0108zzc.hasKey()) {
                            zzdi.zzac("GaExperimentRandom: No key");
                        } else {
                            Object obj = dataLayer.get(c0108zzc.getKey());
                            Long valueOf2 = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                            long zzg = c0108zzc.zzg();
                            long zzh2 = c0108zzc.zzh();
                            if (!c0108zzc.zzi() || valueOf2 == null || valueOf2.longValue() < zzg || valueOf2.longValue() > zzh2) {
                                if (zzg <= zzh2) {
                                    double random = Math.random();
                                    double d = zzh2 - zzg;
                                    Double.isNaN(d);
                                    double d2 = zzg;
                                    Double.isNaN(d2);
                                    obj = Long.valueOf(Math.round((random * d) + d2));
                                } else {
                                    zzdi.zzac("GaExperimentRandom: random range invalid");
                                }
                            }
                            dataLayer.a(c0108zzc.getKey());
                            Map<String, Object> a2 = DataLayer.a(c0108zzc.getKey(), obj);
                            if (c0108zzc.zzj() > 0) {
                                if (a2.containsKey("gtm")) {
                                    Object obj2 = a2.get("gtm");
                                    if (obj2 instanceof Map) {
                                        ((Map) obj2).put("lifetime", Long.valueOf(c0108zzc.zzj()));
                                    } else {
                                        zzdi.zzac("GaExperimentRandom: gtm not a map");
                                    }
                                } else {
                                    a2.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c0108zzc.zzj())));
                                }
                            }
                            dataLayer.push(a2);
                        }
                    }
                }
            }
            String valueOf3 = String.valueOf(zzjVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 22);
            sb2.append("Ignored supplemental: ");
            sb2.append(valueOf3);
            zzdi.zzab(sb2.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(String str) {
        c(str);
        o b = this.c.b(str).b();
        Iterator<zzot> it = a(this.i, new HashSet(), new cy(this), b.b()).a().iterator();
        while (it.hasNext()) {
            a(this.d, it.next(), new HashSet(), b.a());
        }
        c((String) null);
    }

    public final bs<zzl> b(String str) {
        this.m = 0;
        return a(str, new HashSet(), this.c.a(str).a());
    }

    @VisibleForTesting
    private final synchronized void c(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String a() {
        return this.l;
    }

    private static db a(Map<String, db> map, String str) {
        db dbVar = map.get(str);
        if (dbVar != null) {
            return dbVar;
        }
        db dbVar2 = new db();
        map.put(str, dbVar2);
        return dbVar2;
    }

    private final bs<Set<zzot>> a(Set<zzox> set, Set<String> set2, cz czVar, ct ctVar) {
        bs bsVar;
        Set<zzot> hashSet = new HashSet<>();
        Set<zzot> hashSet2 = new HashSet<>();
        boolean z = true;
        for (zzox zzoxVar : set) {
            ci a2 = ctVar.a();
            Iterator<zzot> it = zzoxVar.zzlx().iterator();
            boolean z2 = true;
            while (true) {
                if (it.hasNext()) {
                    bs<Boolean> a3 = a(it.next(), set2, a2.a());
                    if (a3.a().booleanValue()) {
                        zzgj.zzi(false);
                        bsVar = new bs(false, a3.b());
                        break;
                    }
                    z2 = z2 && a3.b();
                } else {
                    Iterator<zzot> it2 = zzoxVar.zzlw().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            bs<Boolean> a4 = a(it2.next(), set2, a2.b());
                            if (!a4.a().booleanValue()) {
                                zzgj.zzi(false);
                                bsVar = new bs(false, a4.b());
                                break;
                            }
                            z2 = z2 && a4.b();
                        } else {
                            zzgj.zzi(true);
                            bsVar = new bs(true, z2);
                            break;
                        }
                    }
                }
            }
            if (((Boolean) bsVar.a()).booleanValue()) {
                czVar.a(zzoxVar, hashSet, hashSet2, a2);
            }
            z = z && bsVar.b();
        }
        hashSet.removeAll(hashSet2);
        ctVar.a(hashSet);
        return new bs<>(hashSet, z);
    }

    private static String a(zzot zzotVar) {
        return zzgj.zzc(zzotVar.zzlu().get(zzb.INSTANCE_NAME.toString()));
    }

    private static void a(Map<String, ag> map, ag agVar) {
        if (map.containsKey(agVar.zzif())) {
            String valueOf = String.valueOf(agVar.zzif());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate function type name: ".concat(valueOf) : new String("Duplicate function type name: "));
        }
        map.put(agVar.zzif(), agVar);
    }

    @VisibleForTesting
    private final void a(ag agVar) {
        a(this.f, agVar);
    }

    @VisibleForTesting
    private final void b(ag agVar) {
        a(this.d, agVar);
    }

    @VisibleForTesting
    private final void c(ag agVar) {
        a(this.e, agVar);
    }

    @VisibleForTesting
    private final bs<Boolean> a(zzot zzotVar, Set<String> set, cf cfVar) {
        bs<zzl> a2 = a(this.e, zzotVar, set, cfVar);
        Boolean zzg = zzgj.zzg(a2.a());
        cfVar.a(zzgj.zzi(zzg));
        return new bs<>(zzg, a2.b());
    }

    private final String b() {
        if (this.m <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.m));
        for (int i = 2; i < this.m; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private final bs<zzl> a(String str, Set<String> set, bf bfVar) {
        zzot next;
        this.m++;
        da a2 = this.h.a(str);
        if (a2 != null) {
            this.c.a();
            a(a2.b(), set);
            this.m--;
            return a2.a();
        }
        db dbVar = this.k.get(str);
        if (dbVar == null) {
            String b = b();
            StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 15 + String.valueOf(str).length());
            sb.append(b);
            sb.append("Invalid macro: ");
            sb.append(str);
            zzdi.zzav(sb.toString());
            this.m--;
            return f5110a;
        }
        bs<Set<zzot>> a3 = a(dbVar.a(), set, new cx(this, dbVar.b(), dbVar.c(), dbVar.e(), dbVar.d()), bfVar.b());
        if (a3.a().isEmpty()) {
            next = dbVar.f();
        } else {
            if (a3.a().size() > 1) {
                String b2 = b();
                StringBuilder sb2 = new StringBuilder(String.valueOf(b2).length() + 37 + String.valueOf(str).length());
                sb2.append(b2);
                sb2.append("Multiple macros active for macroName ");
                sb2.append(str);
                zzdi.zzac(sb2.toString());
            }
            next = a3.a().iterator().next();
        }
        if (next == null) {
            this.m--;
            return f5110a;
        }
        bs<zzl> a4 = a(this.f, next, set, bfVar.a());
        boolean z = a3.b() && a4.b();
        bs<zzl> bsVar = f5110a;
        if (a4 != bsVar) {
            bsVar = new bs<>(a4.a(), z);
        }
        zzl zzji = next.zzji();
        if (bsVar.b()) {
            this.h.a(str, new da(bsVar, zzji));
        }
        a(zzji, set);
        this.m--;
        return bsVar;
    }

    private final void a(zzl zzlVar, Set<String> set) {
        bs<zzl> a2;
        if (zzlVar == null || (a2 = a(zzlVar, set, new bq())) == f5110a) {
            return;
        }
        Object zzh = zzgj.zzh(a2.a());
        if (zzh instanceof Map) {
            this.j.push((Map) zzh);
            return;
        }
        if (zzh instanceof List) {
            for (Object obj : (List) zzh) {
                if (obj instanceof Map) {
                    this.j.push((Map) obj);
                } else {
                    zzdi.zzac("pushAfterEvaluate: value not a Map");
                }
            }
            return;
        }
        zzdi.zzac("pushAfterEvaluate: value not a Map or List");
    }

    private final bs<zzl> a(zzl zzlVar, Set<String> set, dz dzVar) {
        if (!zzlVar.zzqw) {
            return new bs<>(zzlVar, true);
        }
        int i = zzlVar.type;
        if (i != 7) {
            switch (i) {
                case 2:
                    zzl zzk = zzor.zzk(zzlVar);
                    zzk.zzqn = new zzl[zzlVar.zzqn.length];
                    for (int i2 = 0; i2 < zzlVar.zzqn.length; i2++) {
                        bs<zzl> a2 = a(zzlVar.zzqn[i2], set, dzVar.a(i2));
                        bs<zzl> bsVar = f5110a;
                        if (a2 == bsVar) {
                            return bsVar;
                        }
                        zzk.zzqn[i2] = a2.a();
                    }
                    return new bs<>(zzk, false);
                case 3:
                    zzl zzk2 = zzor.zzk(zzlVar);
                    if (zzlVar.zzqo.length != zzlVar.zzqp.length) {
                        String valueOf = String.valueOf(zzlVar.toString());
                        zzdi.zzav(valueOf.length() != 0 ? "Invalid serving value: ".concat(valueOf) : new String("Invalid serving value: "));
                        return f5110a;
                    }
                    zzk2.zzqo = new zzl[zzlVar.zzqo.length];
                    zzk2.zzqp = new zzl[zzlVar.zzqo.length];
                    for (int i3 = 0; i3 < zzlVar.zzqo.length; i3++) {
                        bs<zzl> a3 = a(zzlVar.zzqo[i3], set, dzVar.b(i3));
                        bs<zzl> a4 = a(zzlVar.zzqp[i3], set, dzVar.c(i3));
                        bs<zzl> bsVar2 = f5110a;
                        if (a3 == bsVar2 || a4 == bsVar2) {
                            return f5110a;
                        }
                        zzk2.zzqo[i3] = a3.a();
                        zzk2.zzqp[i3] = a4.a();
                    }
                    return new bs<>(zzk2, false);
                case 4:
                    if (set.contains(zzlVar.zzqq)) {
                        String str = zzlVar.zzqq;
                        String obj = set.toString();
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(obj).length());
                        sb.append("Macro cycle detected.  Current macro reference: ");
                        sb.append(str);
                        sb.append(".  Previous macro references: ");
                        sb.append(obj);
                        sb.append(".");
                        zzdi.zzav(sb.toString());
                        return f5110a;
                    }
                    set.add(zzlVar.zzqq);
                    bs<zzl> a5 = ea.a(a(zzlVar.zzqq, set, dzVar.a()), zzlVar.zzqv);
                    set.remove(zzlVar.zzqq);
                    return a5;
                default:
                    int i4 = zzlVar.type;
                    StringBuilder sb2 = new StringBuilder(25);
                    sb2.append("Unknown type: ");
                    sb2.append(i4);
                    zzdi.zzav(sb2.toString());
                    return f5110a;
            }
        }
        zzl zzk3 = zzor.zzk(zzlVar);
        zzk3.zzqu = new zzl[zzlVar.zzqu.length];
        for (int i5 = 0; i5 < zzlVar.zzqu.length; i5++) {
            bs<zzl> a6 = a(zzlVar.zzqu[i5], set, dzVar.d(i5));
            bs<zzl> bsVar3 = f5110a;
            if (a6 == bsVar3) {
                return bsVar3;
            }
            zzk3.zzqu[i5] = a6.a();
        }
        return new bs<>(zzk3, false);
    }

    private final bs<zzl> a(Map<String, ag> map, zzot zzotVar, Set<String> set, cf cfVar) {
        zzl zzlVar = zzotVar.zzlu().get(zzb.FUNCTION.toString());
        if (zzlVar == null) {
            zzdi.zzav("No function id in properties");
            return f5110a;
        }
        String str = zzlVar.zzqr;
        ag agVar = map.get(str);
        if (agVar == null) {
            zzdi.zzav(String.valueOf(str).concat(" has no backing implementation."));
            return f5110a;
        }
        bs<zzl> a2 = this.g.a(zzotVar);
        if (a2 != null) {
            this.c.a();
            return a2;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        for (Map.Entry<String, zzl> entry : zzotVar.zzlu().entrySet()) {
            bs<zzl> a3 = a(entry.getValue(), set, cfVar.a(entry.getKey()).a(entry.getValue()));
            bs<zzl> bsVar = f5110a;
            if (a3 == bsVar) {
                return bsVar;
            }
            if (a3.b()) {
                zzotVar.zza(entry.getKey(), a3.a());
            } else {
                z = false;
            }
            hashMap.put(entry.getKey(), a3.a());
        }
        if (!agVar.a(hashMap.keySet())) {
            String valueOf = String.valueOf(agVar.zzig());
            String valueOf2 = String.valueOf(hashMap.keySet());
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
            sb.append("Incorrect keys for function ");
            sb.append(str);
            sb.append(" required ");
            sb.append(valueOf);
            sb.append(" had ");
            sb.append(valueOf2);
            zzdi.zzav(sb.toString());
            return f5110a;
        }
        boolean z2 = z && agVar.zzgw();
        bs<zzl> bsVar2 = new bs<>(agVar.zzb(hashMap), z2);
        if (z2) {
            this.g.a(zzotVar, bsVar2);
        }
        cfVar.a(bsVar2.a());
        return bsVar2;
    }
}
