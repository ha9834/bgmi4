package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzhv extends dz {

    /* renamed from: a, reason: collision with root package name */
    private final zzin f4948a;
    private zzdx b;
    private volatile Boolean c;
    private final a d;
    private final gn e;
    private final List<Runnable> f;
    private final a g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzhv(zzfj zzfjVar) {
        super(zzfjVar);
        this.f = new ArrayList();
        this.e = new gn(zzfjVar.zzx());
        this.f4948a = new zzin(this);
        this.d = new fi(this, zzfjVar);
        this.g = new ft(this, zzfjVar);
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return false;
    }

    public final boolean isConnected() {
        zzo();
        j();
        return this.b != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        zzo();
        j();
        a(new fs(this, a(true)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzdx zzdxVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) {
        int i;
        List<AbstractSafeParcelable> zzc;
        zzo();
        zzm();
        j();
        boolean h = h();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!h || (zzc = zzu().zzc(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zzc);
                i = zzc.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzai) {
                    try {
                        zzdxVar.zza((zzai) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e) {
                        zzab().zzgk().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjn) {
                    try {
                        zzdxVar.zza((zzjn) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e2) {
                        zzab().zzgk().zza("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzq) {
                    try {
                        zzdxVar.zza((zzq) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e3) {
                        zzab().zzgk().zza("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzab().zzgk().zzao("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzai zzaiVar, String str) {
        Preconditions.checkNotNull(zzaiVar);
        zzo();
        j();
        boolean h = h();
        a(new fv(this, h, h && zzu().zza(zzaiVar), zzaiVar, a(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        zzo();
        j();
        zzae();
        a(new fu(this, true, zzu().zzc(zzqVar), new zzq(zzqVar), a(true), zzqVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzq>> atomicReference, String str, String str2, String str3) {
        zzo();
        j();
        a(new fx(this, atomicReference, str, str2, str3, a(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzp zzpVar, String str, String str2) {
        zzo();
        j();
        a(new fw(this, str, str2, a(false), zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzjn>> atomicReference, String str, String str2, String str3, boolean z) {
        zzo();
        j();
        a(new fz(this, atomicReference, str, str2, str3, z, a(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzp zzpVar, String str, String str2, boolean z) {
        zzo();
        j();
        a(new fy(this, str, str2, z, a(false), zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzjn zzjnVar) {
        zzo();
        j();
        a(new fk(this, h() && zzu().zza(zzjnVar), zzjnVar, a(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzjn>> atomicReference, boolean z) {
        zzo();
        j();
        a(new fj(this, atomicReference, a(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        zzo();
        zzm();
        j();
        zzn a2 = a(false);
        if (h()) {
            zzu().resetAnalyticsData();
        }
        a(new fm(this, a2));
    }

    private final boolean h() {
        zzae();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzo();
        j();
        a(new fl(this, atomicReference, a(false)));
    }

    public final void getAppInstanceId(zzp zzpVar) {
        zzo();
        j();
        a(new fp(this, a(false), zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        zzo();
        j();
        zzn a2 = a(true);
        boolean zza = zzad().zza(zzak.zzjd);
        if (zza) {
            zzu().zzgh();
        }
        a(new fo(this, a2, zza));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzhr zzhrVar) {
        zzo();
        j();
        a(new fr(this, zzhrVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        zzo();
        this.e.a();
        this.d.a(zzak.zzhl.get(null).longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        boolean z;
        boolean z2;
        zzo();
        j();
        if (isConnected()) {
            return;
        }
        boolean z3 = false;
        if (this.c == null) {
            zzo();
            j();
            Boolean e = zzac().e();
            if (e == null || !e.booleanValue()) {
                zzae();
                if (zzr().g() == 1) {
                    z = true;
                    z2 = true;
                } else {
                    zzab().zzgs().zzao("Checking service availability");
                    int zzd = zzz().zzd(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zzd == 9) {
                        zzab().zzgn().zzao("Service invalid");
                        z = false;
                        z2 = false;
                    } else if (zzd != 18) {
                        switch (zzd) {
                            case 0:
                                zzab().zzgs().zzao("Service available");
                                z = true;
                                z2 = true;
                                break;
                            case 1:
                                zzab().zzgs().zzao("Service missing");
                                z = false;
                                z2 = true;
                                break;
                            case 2:
                                zzab().zzgr().zzao("Service container out of date");
                                if (zzz().zzjx() >= 15300) {
                                    Boolean e2 = zzac().e();
                                    z = e2 == null || e2.booleanValue();
                                    z2 = false;
                                    break;
                                } else {
                                    z = false;
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 3:
                                zzab().zzgn().zzao("Service disabled");
                                z = false;
                                z2 = false;
                                break;
                            default:
                                zzab().zzgn().zza("Unexpected service status", Integer.valueOf(zzd));
                                z = false;
                                z2 = false;
                                break;
                        }
                    } else {
                        zzab().zzgn().zzao("Service updating");
                        z = true;
                        z2 = true;
                    }
                }
                if (!z && zzad().b()) {
                    zzab().zzgk().zzao("No way to upload. Consider using the full version of Analytics");
                    z2 = false;
                }
                if (z2) {
                    zzac().a(z);
                }
            } else {
                z = true;
            }
            this.c = Boolean.valueOf(z);
        }
        if (this.c.booleanValue()) {
            this.f4948a.zzix();
            return;
        }
        if (zzad().b()) {
            return;
        }
        zzae();
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            z3 = true;
        }
        if (z3) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context context = getContext();
            zzae();
            intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
            this.f4948a.zzb(intent);
            return;
        }
        zzab().zzgk().zzao("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void a(zzdx zzdxVar) {
        zzo();
        Preconditions.checkNotNull(zzdxVar);
        this.b = zzdxVar;
        k();
        m();
    }

    public final void disconnect() {
        zzo();
        j();
        this.f4948a.zziw();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.f4948a);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ComponentName componentName) {
        zzo();
        if (this.b != null) {
            this.b = null;
            zzab().zzgs().zza("Disconnected from device MeasurementService", componentName);
            zzo();
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        zzo();
        if (isConnected()) {
            zzab().zzgs().zzao("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    private final void a(Runnable runnable) throws IllegalStateException {
        zzo();
        if (isConnected()) {
            runnable.run();
        } else {
            if (this.f.size() >= 1000) {
                zzab().zzgk().zzao("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f.add(runnable);
            this.g.a(60000L);
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        zzo();
        zzab().zzgs().zza("Processing queued up service tasks", Integer.valueOf(this.f.size()));
        Iterator<Runnable> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                zzab().zzgk().zza("Task exception while flushing queue", e);
            }
        }
        this.f.clear();
        this.g.c();
    }

    private final zzn a(boolean z) {
        zzae();
        return zzr().a(z ? zzab().zzgu() : null);
    }

    public final void zza(zzp zzpVar, zzai zzaiVar, String str) {
        zzo();
        j();
        if (zzz().zzd(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzab().zzgn().zzao("Not bundling data. Service unavailable or out of date");
            zzz().zza(zzpVar, new byte[0]);
        } else {
            a(new fq(this, zzaiVar, str, zzpVar));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdx a(zzhv zzhvVar, zzdx zzdxVar) {
        zzhvVar.b = null;
        return null;
    }
}
