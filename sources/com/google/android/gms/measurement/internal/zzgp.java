package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzgp extends dz {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    protected fb f4944a;

    @VisibleForTesting
    protected boolean b;
    private zzgk c;
    private final Set<zzgn> d;
    private boolean e;
    private final AtomicReference<String> f;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgp(zzfj zzfjVar) {
        super(zzfjVar);
        this.d = new CopyOnWriteArraySet();
        this.b = true;
        this.f = new AtomicReference<>();
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return false;
    }

    public final void zzif() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f4944a);
        }
    }

    public final Boolean zzig() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzaa().a(atomicReference, 15000L, "boolean test flag value", new eh(this, atomicReference));
    }

    public final String zzih() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzaa().a(atomicReference, 15000L, "String test flag value", new eq(this, atomicReference));
    }

    public final Long zzii() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzaa().a(atomicReference, 15000L, "long test flag value", new et(this, atomicReference));
    }

    public final Integer zzij() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzaa().a(atomicReference, 15000L, "int test flag value", new ew(this, atomicReference));
    }

    public final Double zzik() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzaa().a(atomicReference, 15000L, "double test flag value", new ev(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        j();
        zzm();
        zzaa().zza(new ey(this, z));
    }

    public final void zza(boolean z) {
        j();
        zzm();
        zzaa().zza(new ex(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        zzo();
        zzm();
        j();
        zzab().zzgr().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzac().b(z);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (zzad().zze(zzr().c(), zzak.zzik)) {
            zzo();
            String zzho = zzac().n.zzho();
            if (zzho != null) {
                if ("unset".equals(zzho)) {
                    a(Constants.JumpUrlConstants.SRC_TYPE_APP, "_npa", (Object) null, zzx().currentTimeMillis());
                } else {
                    a(Constants.JumpUrlConstants.SRC_TYPE_APP, "_npa", Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zzho) ? 1L : 0L), zzx().currentTimeMillis());
                }
            }
        }
        if (this.v.isEnabled() && this.b) {
            zzab().zzgr().zzao("Recording app launch after enabling measurement for the first time (FE)");
            zzim();
        } else {
            zzab().zzgr().zzao("Updating Scion state (FE)");
            zzs().c();
        }
    }

    public final void setMinimumSessionDuration(long j) {
        zzm();
        zzaa().zza(new fa(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzm();
        zzaa().zza(new ez(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzx().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, Bundle bundle) {
        zzm();
        zzo();
        a(str, str2, zzx().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, long j, Bundle bundle) {
        zzm();
        zzo();
        a(str, str2, j, bundle, true, this.c == null || zzjs.e(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        List<String> list;
        String[] strArr;
        int i;
        long j2;
        ArrayList arrayList;
        zzhr zzhrVar;
        Bundle bundle2;
        int i2;
        Class<?> cls;
        List<String> h;
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str3, zzak.zzip)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzo();
        j();
        if (!this.v.isEnabled()) {
            zzab().zzgr().zzao("Event not sent since app measurement is disabled");
            return;
        }
        if (zzad().zze(zzr().c(), zzak.zzix) && (h = zzr().h()) != null && !h.contains(str2)) {
            zzab().zzgr().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.e) {
            this.e = true;
            try {
                if (!this.v.zzia()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, getContext().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e) {
                    zzab().zzgn().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzab().zzgq().zzao("Tag Manager is not found and thus will not be used");
            }
        }
        if (zzad().zze(zzr().c(), zzak.zzje) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            a("auto", "_lgclid", bundle.getString("gclid"), zzx().currentTimeMillis());
        }
        if (z3) {
            zzae();
            if (!"_iap".equals(str2)) {
                zzjs zzz = this.v.zzz();
                if (!zzz.a(DataLayer.EVENT_KEY, str2)) {
                    i2 = 2;
                } else if (zzz.a(DataLayer.EVENT_KEY, zzgj.zzpn, str2)) {
                    i2 = !zzz.a(DataLayer.EVENT_KEY, 40, str2) ? 2 : 0;
                } else {
                    i2 = 13;
                }
                if (i2 != 0) {
                    zzab().zzgm().zza("Invalid public event name. Event will not be logged (FE)", zzy().a(str2));
                    this.v.zzz();
                    this.v.zzz().zza(i2, "_ev", zzjs.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzae();
        zzhr zzin = zzt().zzin();
        if (zzin != null && !bundle.containsKey("_sc")) {
            zzin.f4947a = true;
        }
        zzhq.zza(zzin, bundle, z && z3);
        boolean equals = "am".equals(str);
        boolean e2 = zzjs.e(str2);
        if (z && this.c != null && !e2 && !equals) {
            zzab().zzgr().zza("Passing event to registered event handler (FE)", zzy().a(str2), zzy().a(bundle));
            this.c.interceptEvent(str, str2, bundle, j);
            return;
        }
        if (this.v.g()) {
            int b = zzz().b(str2);
            if (b != 0) {
                zzab().zzgm().zza("Invalid event name. Event will not be logged (FE)", zzy().a(str2));
                zzz();
                this.v.zzz().a(str3, b, "_ev", zzjs.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            String str4 = str2;
            Bundle a2 = zzz().a(str3, str2, bundle, listOf, z3, true);
            zzhr zzhrVar2 = (a2 != null && a2.containsKey("_sc") && a2.containsKey("_si")) ? new zzhr(a2.getString("_sn"), a2.getString("_sc"), Long.valueOf(a2.getLong("_si")).longValue()) : null;
            zzhr zzhrVar3 = zzhrVar2 == null ? zzin : zzhrVar2;
            if (zzad().o(str3)) {
                zzae();
                if (zzt().zzin() != null && "_ae".equals(str4)) {
                    long e3 = zzv().e();
                    if (e3 > 0) {
                        zzz().a(a2, e3);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(a2);
            long nextLong = zzz().c().nextLong();
            if (zzad().zze(zzr().c(), zzak.zzid) && zzac().q.get() > 0 && zzac().a(j) && zzac().t.get()) {
                zzab().zzgs().zzao("Current session is expired, remove the session number and Id");
                if (zzad().zze(zzr().c(), zzak.zzhz)) {
                    a("auto", "_sid", (Object) null, zzx().currentTimeMillis());
                }
                if (zzad().zze(zzr().c(), zzak.zzia)) {
                    a("auto", "_sno", (Object) null, zzx().currentTimeMillis());
                }
            }
            if (zzad().n(zzr().c()) && a2.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0L) == 1) {
                zzab().zzgs().zzao("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.v.zzv().a(j, true);
            }
            String[] strArr2 = (String[]) a2.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                String str5 = strArr2[i3];
                Object obj = a2.get(str5);
                zzz();
                Bundle[] a3 = zzjs.a(obj);
                if (a3 != null) {
                    strArr = strArr2;
                    a2.putInt(str5, a3.length);
                    i = length;
                    int i5 = 0;
                    while (i5 < a3.length) {
                        Bundle bundle3 = a3[i5];
                        zzhq.zza(zzhrVar3, bundle3, true);
                        String str6 = str5;
                        long j3 = nextLong;
                        ArrayList arrayList3 = arrayList2;
                        Bundle a4 = zzz().a(str3, "_ep", bundle3, listOf, z3, false);
                        a4.putString("_en", str4);
                        a4.putLong("_eid", j3);
                        a4.putString("_gn", str6);
                        a4.putInt("_ll", a3.length);
                        a4.putInt("_i", i5);
                        arrayList3.add(a4);
                        i5++;
                        a2 = a2;
                        arrayList2 = arrayList3;
                        str5 = str6;
                        zzhrVar3 = zzhrVar3;
                        listOf = listOf;
                        i4 = i4;
                        nextLong = j3;
                    }
                    list = listOf;
                    j2 = nextLong;
                    arrayList = arrayList2;
                    zzhrVar = zzhrVar3;
                    bundle2 = a2;
                    i4 += a3.length;
                } else {
                    list = listOf;
                    strArr = strArr2;
                    i = length;
                    j2 = nextLong;
                    arrayList = arrayList2;
                    zzhrVar = zzhrVar3;
                    bundle2 = a2;
                }
                i3++;
                strArr2 = strArr;
                a2 = bundle2;
                arrayList2 = arrayList;
                nextLong = j2;
                length = i;
                zzhrVar3 = zzhrVar;
                listOf = list;
            }
            int i6 = i4;
            long j4 = nextLong;
            ArrayList arrayList4 = arrayList2;
            Bundle bundle4 = a2;
            if (i6 != 0) {
                bundle4.putLong("_eid", j4);
                bundle4.putInt("_epc", i6);
            }
            int i7 = 0;
            while (i7 < arrayList4.size()) {
                Bundle bundle5 = (Bundle) arrayList4.get(i7);
                String str7 = i7 != 0 ? "_ep" : str4;
                String str8 = str4;
                bundle5.putString("_o", str);
                Bundle a5 = z2 ? zzz().a(bundle5) : bundle5;
                zzab().zzgr().zza("Logging event (FE)", zzy().a(str8), zzy().a(a5));
                ArrayList arrayList5 = arrayList4;
                zzs().a(new zzai(str7, new zzah(a5), str, j), str3);
                if (!equals) {
                    Iterator<zzgn> it = this.d.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(a5), j);
                    }
                }
                i7++;
                str4 = str8;
                arrayList4 = arrayList5;
            }
            String str9 = str4;
            zzae();
            if (zzt().zzin() == null || !"_ae".equals(str9)) {
                return;
            }
            zzv().zza(true, true);
        }
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        zzm();
        String str3 = str == null ? Constants.JumpUrlConstants.SRC_TYPE_APP : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2 && this.c != null && !zzjs.e(str2)) {
            z3 = false;
            b(str3, str2, j, bundle2, z2, z3, !z, null);
        }
        z3 = true;
        b(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzaa().zza(new ej(this, str, str2, j, zzjs.zzh(bundle), z, z2, z3, str3));
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3 = str == null ? Constants.JumpUrlConstants.SRC_TYPE_APP : str;
        int i = 6;
        if (z) {
            i = zzz().c(str2);
        } else {
            zzjs zzz = zzz();
            if (zzz.a("user property", str2)) {
                if (!zzz.a("user property", zzgl.zzpp, str2)) {
                    i = 15;
                } else if (zzz.a("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzz();
            this.v.zzz().zza(i, "_ev", zzjs.zza(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int b = zzz().b(str2, obj);
            if (b != 0) {
                zzz();
                this.v.zzz().zza(b, "_ev", zzjs.zza(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object c = zzz().c(str2, obj);
                if (c != null) {
                    a(str3, str2, j, c);
                    return;
                }
                return;
            }
        }
        a(str3, str2, j, (Object) null);
    }

    private final void a(String str, String str2, long j, Object obj) {
        zzaa().zza(new ei(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzo()
            r8.zzm()
            r8.j()
            com.google.android.gms.measurement.internal.zzs r0 = r8.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r8.zzr()
            java.lang.String r1 = r1.c()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzik
            boolean r0 = r0.zze(r1, r2)
            if (r0 == 0) goto L80
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L80
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L6e
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L6e
            java.lang.String r10 = "false"
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            boolean r10 = r10.equals(r11)
            r0 = 1
            if (r10 == 0) goto L4a
            r10 = r0
            goto L4c
        L4a:
            r10 = 0
        L4c:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            java.lang.String r10 = "_npa"
            com.google.android.gms.measurement.internal.cz r2 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r2 = r2.n
            r3 = r11
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 != 0) goto L66
            java.lang.String r0 = "true"
            goto L68
        L66:
            java.lang.String r0 = "false"
        L68:
            r2.zzau(r0)
            r3 = r10
            r6 = r11
            goto L82
        L6e:
            if (r11 != 0) goto L80
            java.lang.String r10 = "_npa"
            com.google.android.gms.measurement.internal.cz r0 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r0 = r0.n
            java.lang.String r1 = "unset"
            r0.zzau(r1)
            r3 = r10
            r6 = r11
            goto L82
        L80:
            r3 = r10
            r6 = r11
        L82:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.v
            boolean r10 = r10.isEnabled()
            if (r10 != 0) goto L98
            com.google.android.gms.measurement.internal.zzef r9 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgr()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zzao(r10)
            return
        L98:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.v
            boolean r10 = r10.g()
            if (r10 != 0) goto La1
            return
        La1:
            com.google.android.gms.measurement.internal.zzef r10 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgr()
            java.lang.String r11 = "Setting user property (FE)"
            com.google.android.gms.measurement.internal.zzed r0 = r8.zzy()
            java.lang.String r0 = r0.a(r3)
            r10.zza(r11, r0, r6)
            com.google.android.gms.measurement.internal.zzjn r10 = new com.google.android.gms.measurement.internal.zzjn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzhv r9 = r8.zzs()
            r9.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.a(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzjn> zzh(boolean z) {
        zzm();
        j();
        zzab().zzgr().zzao("Fetching user attributes (FE)");
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.v.zzaa().zza(new el(this, atomicReference, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzab().zzgn().zza("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjn> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzab().zzgn().zzao("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final String zzi() {
        zzm();
        return this.f.get();
    }

    public final String zzy(long j) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from analytics worker thread");
            return null;
        }
        if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from main thread");
            return null;
        }
        long elapsedRealtime = zzx().elapsedRealtime();
        String a2 = a(120000L);
        long elapsedRealtime2 = zzx().elapsedRealtime() - elapsedRealtime;
        return (a2 != null || elapsedRealtime2 >= 120000) ? a2 : a(120000 - elapsedRealtime2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        this.f.set(str);
    }

    private final String a(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzaa().zza(new ek(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzab().zzgn().zzao("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void resetAnalyticsData(long j) {
        a((String) null);
        zzaa().zza(new en(this, j));
    }

    public final void zzim() {
        zzo();
        zzm();
        j();
        if (this.v.g()) {
            zzs().e();
            this.b = false;
            String h = zzac().h();
            if (TextUtils.isEmpty(h)) {
                return;
            }
            zzw().l();
            if (h.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", h);
            logEvent("auto", "_ou", bundle);
        }
    }

    public final void zza(zzgk zzgkVar) {
        zzgk zzgkVar2;
        zzo();
        zzm();
        j();
        if (zzgkVar != null && zzgkVar != (zzgkVar2 = this.c)) {
            Preconditions.checkState(zzgkVar2 == null, "EventInterceptor already set.");
        }
        this.c = zzgkVar;
    }

    public final void zza(zzgn zzgnVar) {
        zzm();
        j();
        Preconditions.checkNotNull(zzgnVar);
        if (this.d.add(zzgnVar)) {
            return;
        }
        zzab().zzgn().zzao("OnEventListener already registered");
    }

    public final void zzb(zzgn zzgnVar) {
        zzm();
        j();
        Preconditions.checkNotNull(zzgnVar);
        if (this.d.remove(zzgnVar)) {
            return;
        }
        zzab().zzgn().zzao("OnEventListener had not been registered");
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        setConditionalUserProperty(bundle, zzx().currentTimeMillis());
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzm();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzab().zzgn().zzao("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        a(bundle2, j);
    }

    public final void zzd(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zzl();
        a(new Bundle(bundle), zzx().currentTimeMillis());
    }

    private final void a(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgg.zza(bundle, "app_id", String.class, null);
        zzgg.zza(bundle, "origin", String.class, null);
        zzgg.zza(bundle, "name", String.class, null);
        zzgg.zza(bundle, "value", Object.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (zzz().c(string) != 0) {
            zzab().zzgk().zza("Invalid conditional user property name", zzy().c(string));
            return;
        }
        if (zzz().b(string, obj) != 0) {
            zzab().zzgk().zza("Invalid conditional user property value", zzy().c(string), obj);
            return;
        }
        Object c = zzz().c(string, obj);
        if (c == null) {
            zzab().zzgk().zza("Unable to normalize conditional user property value", zzy().c(string), obj);
            return;
        }
        zzgg.zza(bundle, c);
        long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzab().zzgk().zza("Invalid conditional user property timeout", zzy().c(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzab().zzgk().zza("Invalid conditional user property time to live", zzy().c(string), Long.valueOf(j3));
        } else {
            zzaa().zza(new ep(this, bundle));
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzm();
        a((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzl();
        a(str, str2, str3, bundle);
    }

    private final void a(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzaa().zza(new eo(this, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bundle bundle) {
        zzo();
        j();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.v.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not sent since collection is disabled");
            return;
        }
        zzjn zzjnVar = new zzjn(bundle.getString("name"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin"));
        try {
            zzai a2 = zzz().a(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false);
            zzs().a(new zzq(bundle.getString("app_id"), bundle.getString("origin"), zzjnVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzz().a(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), a2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz().a(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Bundle bundle) {
        zzo();
        j();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!this.v.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not cleared since collection is disabled");
            return;
        }
        try {
            zzs().a(new zzq(bundle.getString("app_id"), bundle.getString("origin"), new zzjn(bundle.getString("name"), 0L, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz().a(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zzn(String str, String str2) {
        zzm();
        return a((String) null, str, str2);
    }

    public final ArrayList<Bundle> zzd(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return a(str, str2, str3);
    }

    @VisibleForTesting
    private final ArrayList<Bundle> a(String str, String str2, String str3) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.v.zzaa().zza(new er(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzab().zzgn().zza("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List list = (List) atomicReference.get();
        if (list == null) {
            zzab().zzgn().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
        return zzjs.zzd((List<zzq>) list);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzm();
        return a((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return a(str, str2, str3, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @VisibleForTesting
    private final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.v.zzaa().zza(new eu(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                zzab().zzgn().zza("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjn> list = (List) atomicReference.get();
        if (list == null) {
            zzab().zzgn().zzao("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        androidx.b.a aVar = new androidx.b.a(list.size());
        for (zzjn zzjnVar : list) {
            aVar.put(zzjnVar.name, zzjnVar.getValue());
        }
        return aVar;
    }

    public final String getCurrentScreenName() {
        zzhr zzio = this.v.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqu;
        }
        return null;
    }

    public final String getCurrentScreenClass() {
        zzhr zzio = this.v.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqv;
        }
        return null;
    }

    public final String getGmpAppId() {
        if (this.v.zzhx() != null) {
            return this.v.zzhx();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.v.zzab().zzgk().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
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
