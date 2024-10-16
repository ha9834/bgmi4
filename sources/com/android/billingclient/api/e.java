package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.billingclient.api.h;
import com.android.billingclient.api.l;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a */
    private int f970a;
    private final String b;
    private final Handler c;
    private an d;
    private Context e;
    private Context f;
    private zzd g;
    private z h;
    private boolean i;
    private boolean j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private ExecutorService u;

    public static /* synthetic */ Context a(e eVar) {
        return eVar.f;
    }

    private final h a(h hVar) {
        this.d.b().onPurchasesUpdated(hVar, null);
        return hVar;
    }

    public static /* synthetic */ l.a a(e eVar, String str) {
        Bundle zzd;
        String valueOf = String.valueOf(str);
        zza.zza("BillingClient", valueOf.length() != 0 ? "Querying owned items, item type: ".concat(valueOf) : new String("Querying owned items, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zzh = zza.zzh(eVar.n, eVar.t, eVar.b);
        String str2 = null;
        do {
            try {
                if (eVar.n) {
                    zzd = eVar.g.zzk(9, eVar.f.getPackageName(), str, str2, zzh);
                } else {
                    zzd = eVar.g.zzd(3, eVar.f.getPackageName(), str, str2);
                }
                h a2 = af.a(zzd, "BillingClient", "getPurchase()");
                if (a2 == ad.p) {
                    ArrayList<String> stringArrayList = zzd.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = zzd.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = zzd.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str3 = stringArrayList2.get(i);
                        String str4 = stringArrayList3.get(i);
                        String valueOf2 = String.valueOf(stringArrayList.get(i));
                        zza.zza("BillingClient", valueOf2.length() != 0 ? "Sku is owned: ".concat(valueOf2) : new String("Sku is owned: "));
                        try {
                            l lVar = new l(str3, str4);
                            if (TextUtils.isEmpty(lVar.c())) {
                                zza.zzb("BillingClient", "BUG: empty/null token!");
                            }
                            arrayList.add(lVar);
                        } catch (JSONException e) {
                            String valueOf3 = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                            sb.append("Got an exception trying to decode the purchase: ");
                            sb.append(valueOf3);
                            zza.zzb("BillingClient", sb.toString());
                            return new l.a(ad.l, null);
                        }
                    }
                    str2 = zzd.getString("INAPP_CONTINUATION_TOKEN");
                    String valueOf4 = String.valueOf(str2);
                    zza.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
                } else {
                    return new l.a(a2, null);
                }
            } catch (Exception e2) {
                String valueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 57);
                sb2.append("Got exception trying to get purchases: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                zza.zzb("BillingClient", sb2.toString());
                return new l.a(ad.q, null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new l.a(ad.p, arrayList);
    }

    public final <T> Future<T> a(Callable<T> callable, long j, Runnable runnable) {
        double d = j;
        Double.isNaN(d);
        long j2 = (long) (d * 0.95d);
        if (this.u == null) {
            this.u = Executors.newFixedThreadPool(zza.zza, new az(this));
        }
        try {
            Future<T> submit = this.u.submit(callable);
            this.c.postDelayed(new ba(this, submit, runnable), j2);
            return submit;
        } catch (Exception e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("Async task throws exception ");
            sb.append(valueOf);
            zza.zzb("BillingClient", sb.toString());
            return null;
        }
    }

    private void a(Context context, o oVar, boolean z) {
        this.f = context.getApplicationContext();
        this.d = new an(this.f, oVar);
        this.e = context;
        this.t = z;
    }

    public static /* synthetic */ void a(e eVar, i iVar, j jVar) {
        int zze;
        String str;
        String a2 = iVar.a();
        try {
            String valueOf = String.valueOf(a2);
            zza.zza("BillingClient", valueOf.length() != 0 ? "Consuming purchase with token: ".concat(valueOf) : new String("Consuming purchase with token: "));
            if (eVar.n) {
                Bundle zzl = eVar.g.zzl(9, eVar.f.getPackageName(), a2, zza.zzj(iVar, eVar.n, eVar.b));
                int i = zzl.getInt("RESPONSE_CODE");
                str = zza.zze(zzl, "BillingClient");
                zze = i;
            } else {
                zze = eVar.g.zze(3, eVar.f.getPackageName(), a2);
                str = "";
            }
            h.a c = h.c();
            c.a(zze);
            c.a(str);
            h a3 = c.a();
            if (zze != 0) {
                eVar.a(new be(eVar, zze, jVar, a3, a2));
            } else {
                eVar.a(new bd(eVar, jVar, a3, a2));
            }
        } catch (Exception e) {
            eVar.a(new bf(eVar, e, jVar, a2));
        }
    }

    public final void a(Runnable runnable) {
        if (Thread.interrupted()) {
            return;
        }
        this.c.post(runnable);
    }

    public static /* synthetic */ aa b(e eVar, String str) {
        String valueOf = String.valueOf(str);
        zza.zza("BillingClient", valueOf.length() != 0 ? "Querying purchase history, item type: ".concat(valueOf) : new String("Querying purchase history, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zzh = zza.zzh(eVar.n, eVar.t, eVar.b);
        String str2 = null;
        while (eVar.l) {
            try {
                Bundle zzh2 = eVar.g.zzh(6, eVar.f.getPackageName(), str, str2, zzh);
                h a2 = af.a(zzh2, "BillingClient", "getPurchaseHistory()");
                if (a2 == ad.p) {
                    ArrayList<String> stringArrayList = zzh2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = zzh2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = zzh2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str3 = stringArrayList2.get(i);
                        String str4 = stringArrayList3.get(i);
                        String valueOf2 = String.valueOf(stringArrayList.get(i));
                        zza.zza("BillingClient", valueOf2.length() != 0 ? "Purchase record found for sku : ".concat(valueOf2) : new String("Purchase record found for sku : "));
                        try {
                            m mVar = new m(str3, str4);
                            if (TextUtils.isEmpty(mVar.a())) {
                                zza.zzb("BillingClient", "BUG: empty/null token!");
                            }
                            arrayList.add(mVar);
                        } catch (JSONException e) {
                            String valueOf3 = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                            sb.append("Got an exception trying to decode the purchase: ");
                            sb.append(valueOf3);
                            zza.zzb("BillingClient", sb.toString());
                            return new aa(ad.l, null);
                        }
                    }
                    str2 = zzh2.getString("INAPP_CONTINUATION_TOKEN");
                    String valueOf4 = String.valueOf(str2);
                    zza.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
                    if (TextUtils.isEmpty(str2)) {
                        return new aa(ad.p, arrayList);
                    }
                } else {
                    return new aa(a2, null);
                }
            } catch (RemoteException e2) {
                String valueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 64);
                sb2.append("Got exception trying to get purchase history: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                zza.zzb("BillingClient", sb2.toString());
                return new aa(ad.q, null);
            }
        }
        zza.zzb("BillingClient", "getPurchaseHistory is not supported on current device");
        return new aa(ad.j, null);
    }

    public static /* synthetic */ zzd b(e eVar) {
        return eVar.g;
    }

    private final h c(String str) {
        try {
            if (((Integer) a(new bc(this, str), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS)).intValue() != 0) {
                return ad.i;
            }
            return ad.p;
        } catch (Exception unused) {
            zza.zzb("BillingClient", "Exception while checking if billing is supported; try to reconnect");
            return ad.q;
        }
    }

    public final ag a(String str, List<ak> list, String str2) {
        Bundle zzb;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(list.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(((ak) arrayList2.get(i3)).a());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.b);
            try {
                if (this.o) {
                    zzb = this.g.zzm(10, this.f.getPackageName(), str, bundle, zza.zzi(this.k, this.t, this.b, null, arrayList2));
                } else {
                    zzb = this.g.zzb(3, this.f.getPackageName(), str, bundle);
                }
                if (zzb != null) {
                    if (zzb.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = zzb.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null) {
                            for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                                try {
                                    p pVar = new p(stringArrayList.get(i4));
                                    String valueOf = String.valueOf(pVar);
                                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
                                    sb.append("Got sku details: ");
                                    sb.append(valueOf);
                                    zza.zza("BillingClient", sb.toString());
                                    arrayList.add(pVar);
                                } catch (JSONException unused) {
                                    zza.zzb("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                                    return new ag(6, "Error trying to decode SkuDetails.", null);
                                }
                            }
                            i = i2;
                        } else {
                            zza.zzb("BillingClient", "querySkuDetailsAsync got null response list");
                            return new ag(4, "Item is unavailable for purchase.", null);
                        }
                    } else {
                        int zzd = zza.zzd(zzb, "BillingClient");
                        String zze = zza.zze(zzb, "BillingClient");
                        if (zzd != 0) {
                            StringBuilder sb2 = new StringBuilder(50);
                            sb2.append("getSkuDetails() failed. Response code: ");
                            sb2.append(zzd);
                            zza.zzb("BillingClient", sb2.toString());
                            return new ag(zzd, zze, arrayList);
                        }
                        zza.zzb("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        return new ag(6, zze, arrayList);
                    }
                } else {
                    zza.zzb("BillingClient", "querySkuDetailsAsync got null sku details list");
                    return new ag(4, "Item is unavailable for purchase.", null);
                }
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 63);
                sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                sb3.append(valueOf2);
                zza.zzb("BillingClient", sb3.toString());
                return new ag(-1, "Service connection is disconnected.", null);
            }
        }
        return new ag(0, "", arrayList);
    }

    @Override // com.android.billingclient.api.d
    public final h a(Activity activity, g gVar) {
        long j;
        Future a2;
        boolean z;
        String str;
        int i;
        String str2;
        if (!a()) {
            h hVar = ad.q;
            a(hVar);
            return hVar;
        }
        ArrayList<p> f = gVar.f();
        p pVar = f.get(0);
        String c = pVar.c();
        if (!c.equals(IabHelper.ITEM_TYPE_SUBS) || this.i) {
            String a3 = gVar.a();
            if (a3 == null || this.j) {
                if (!gVar.h() || this.l) {
                    if (f.size() <= 1 || this.s) {
                        String str3 = "";
                        for (int i2 = 0; i2 < f.size(); i2++) {
                            String valueOf = String.valueOf(str3);
                            String valueOf2 = String.valueOf(f.get(i2));
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                            sb.append(valueOf);
                            sb.append(valueOf2);
                            str3 = sb.toString();
                            if (i2 < f.size() - 1) {
                                str3 = String.valueOf(str3).concat(", ");
                            }
                        }
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 41 + String.valueOf(c).length());
                        sb2.append("Constructing buy intent for ");
                        sb2.append(str3);
                        sb2.append(", item type: ");
                        sb2.append(c);
                        zza.zza("BillingClient", sb2.toString());
                        if (this.l) {
                            Bundle zzg = zza.zzg(gVar, this.n, this.t, this.b);
                            ArrayList<String> arrayList = new ArrayList<>();
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            ArrayList<Integer> arrayList4 = new ArrayList<>();
                            int size = f.size();
                            boolean z2 = false;
                            boolean z3 = false;
                            boolean z4 = false;
                            for (int i3 = 0; i3 < size; i3++) {
                                p pVar2 = f.get(i3);
                                if (!pVar2.n().isEmpty()) {
                                    arrayList.add(pVar2.n());
                                }
                                try {
                                    str2 = new JSONObject(pVar2.a()).optString("offer_id_token");
                                } catch (JSONException unused) {
                                    str2 = "";
                                }
                                String o = pVar2.o();
                                int p = pVar2.p();
                                arrayList2.add(str2);
                                z2 |= !TextUtils.isEmpty(str2);
                                arrayList3.add(o);
                                z3 |= !TextUtils.isEmpty(o);
                                arrayList4.add(Integer.valueOf(p));
                                z4 |= p != 0;
                            }
                            if (!arrayList.isEmpty()) {
                                zzg.putStringArrayList("skuDetailsTokens", arrayList);
                            }
                            if (z2) {
                                if (!this.q) {
                                    h hVar2 = ad.i;
                                    a(hVar2);
                                    return hVar2;
                                }
                                zzg.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
                            }
                            if (z3) {
                                zzg.putStringArrayList("SKU_OFFER_ID_LIST", arrayList3);
                            }
                            if (z4) {
                                zzg.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList4);
                            }
                            if (TextUtils.isEmpty(pVar.m())) {
                                z = false;
                                str = null;
                            } else {
                                zzg.putString("skuPackageName", pVar.m());
                                z = true;
                                str = null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                zzg.putString("accountName", str);
                            }
                            if (f.size() > 1) {
                                ArrayList<String> arrayList5 = new ArrayList<>(f.size() - 1);
                                ArrayList<String> arrayList6 = new ArrayList<>(f.size() - 1);
                                for (int i4 = 1; i4 < f.size(); i4++) {
                                    arrayList5.add(f.get(i4).b());
                                    arrayList6.add(f.get(i4).c());
                                }
                                zzg.putStringArrayList("additionalSkus", arrayList5);
                                zzg.putStringArrayList("additionalSkuTypes", arrayList6);
                            }
                            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("PROXY_PACKAGE"))) {
                                String stringExtra = activity.getIntent().getStringExtra("PROXY_PACKAGE");
                                zzg.putString("proxyPackage", stringExtra);
                                try {
                                    zzg.putString("proxyPackageVersion", this.f.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                                } catch (PackageManager.NameNotFoundException unused2) {
                                    zzg.putString("proxyPackageVersion", "package not found");
                                }
                            }
                            if (this.r && z) {
                                i = 15;
                            } else if (this.n) {
                                i = 9;
                            } else {
                                i = gVar.c() ? 7 : 6;
                            }
                            j = 5000;
                            a2 = a(new bg(this, i, pVar, c, gVar, zzg), 5000L, (Runnable) null);
                        } else {
                            j = 5000;
                            if (a3 != null) {
                                a2 = a(new bh(this, gVar, pVar), 5000L, (Runnable) null);
                            } else {
                                a2 = a(new s(this, pVar, c), 5000L, (Runnable) null);
                            }
                        }
                        try {
                            Bundle bundle = (Bundle) a2.get(j, TimeUnit.MILLISECONDS);
                            int zzd = zza.zzd(bundle, "BillingClient");
                            String zze = zza.zze(bundle, "BillingClient");
                            if (zzd != 0) {
                                StringBuilder sb3 = new StringBuilder(52);
                                sb3.append("Unable to buy item, Error response code: ");
                                sb3.append(zzd);
                                zza.zzb("BillingClient", sb3.toString());
                                h.a c2 = h.c();
                                c2.a(zzd);
                                c2.a(zze);
                                h a4 = c2.a();
                                a(a4);
                                return a4;
                            }
                            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                            intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                            activity.startActivity(intent);
                            return ad.p;
                        } catch (CancellationException | TimeoutException unused3) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(str3).length() + 68);
                            sb4.append("Time out while launching billing flow: ; for sku: ");
                            sb4.append(str3);
                            sb4.append("; try to reconnect");
                            zza.zzb("BillingClient", sb4.toString());
                            h hVar3 = ad.r;
                            a(hVar3);
                            return hVar3;
                        } catch (Exception unused4) {
                            StringBuilder sb5 = new StringBuilder(String.valueOf(str3).length() + 69);
                            sb5.append("Exception while launching billing flow: ; for sku: ");
                            sb5.append(str3);
                            sb5.append("; try to reconnect");
                            zza.zzb("BillingClient", sb5.toString());
                            h hVar4 = ad.q;
                            a(hVar4);
                            return hVar4;
                        }
                    }
                    zza.zzb("BillingClient", "Current client doesn't support multi-item purchases.");
                    h hVar5 = ad.u;
                    a(hVar5);
                    return hVar5;
                }
                zza.zzb("BillingClient", "Current client doesn't support extra params for buy intent.");
                h hVar6 = ad.h;
                a(hVar6);
                return hVar6;
            }
            zza.zzb("BillingClient", "Current client doesn't support subscriptions update.");
            h hVar7 = ad.t;
            a(hVar7);
            return hVar7;
        }
        zza.zzb("BillingClient", "Current client doesn't support subscriptions.");
        h hVar8 = ad.s;
        a(hVar8);
        return hVar8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.d
    public final h a(String str) {
        char c;
        if (!a()) {
            return ad.q;
        }
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals("bbb")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 292218239:
                if (str.equals("inAppItemsOnVr")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1219490065:
                if (str.equals("subscriptionsOnVr")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return this.i ? ad.p : ad.i;
            case 1:
                if (this.j) {
                    return ad.p;
                }
                return ad.i;
            case 2:
                return c("inapp");
            case 3:
                return c(IabHelper.ITEM_TYPE_SUBS);
            case 4:
                return this.m ? ad.p : ad.i;
            case 5:
                return this.p ? ad.p : ad.i;
            case 6:
                return this.r ? ad.p : ad.i;
            case 7:
                return this.q ? ad.p : ad.i;
            case '\b':
            case '\t':
                return this.s ? ad.p : ad.i;
            default:
                String valueOf = String.valueOf(str);
                zza.zzb("BillingClient", valueOf.length() != 0 ? "Unsupported feature: ".concat(valueOf) : new String("Unsupported feature: "));
                return ad.v;
        }
    }

    @Override // com.android.billingclient.api.d
    public final void a(b bVar, c cVar) {
        if (!a()) {
            cVar.a(ad.q);
            return;
        }
        if (TextUtils.isEmpty(bVar.a())) {
            zza.zzb("BillingClient", "Please provide a valid purchase token.");
            cVar.a(ad.k);
        } else if (!this.n) {
            cVar.a(ad.b);
        } else if (a(new ax(this, bVar, cVar), 30000L, new ay(this, cVar)) == null) {
            cVar.a(c());
        }
    }

    @Override // com.android.billingclient.api.d
    public final void a(i iVar, j jVar) {
        if (!a()) {
            jVar.onConsumeResponse(ad.q, iVar.a());
        } else if (a(new aq(this, iVar, jVar), 30000L, new ar(this, jVar, iVar)) == null) {
            jVar.onConsumeResponse(c(), iVar.a());
        }
    }

    @Override // com.android.billingclient.api.d
    public final void a(q qVar, r rVar) {
        if (!a()) {
            rVar.onSkuDetailsResponse(ad.q, null);
            return;
        }
        String a2 = qVar.a();
        List<String> b = qVar.b();
        if (TextUtils.isEmpty(a2)) {
            zza.zzb("BillingClient", "Please fix the input params. SKU type can't be empty.");
            rVar.onSkuDetailsResponse(ad.g, null);
            return;
        }
        if (b != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : b) {
                aj ajVar = new aj(null);
                ajVar.a(str);
                arrayList.add(ajVar.a());
            }
            if (a(new v(this, a2, arrayList, null, rVar), 30000L, new ap(this, rVar)) == null) {
                rVar.onSkuDetailsResponse(c(), null);
                return;
            }
            return;
        }
        zza.zzb("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
        rVar.onSkuDetailsResponse(ad.f, null);
    }

    @Override // com.android.billingclient.api.d
    public final void a(String str, n nVar) {
        if (!a()) {
            nVar.a(ad.q, null);
        } else if (a(new at(this, str, nVar), 30000L, new au(this, nVar)) == null) {
            nVar.a(c(), null);
        }
    }

    @Override // com.android.billingclient.api.d
    public final boolean a() {
        return (this.f970a != 2 || this.g == null || this.h == null) ? false : true;
    }

    @Override // com.android.billingclient.api.d
    public final l.a b(String str) {
        if (!a()) {
            return new l.a(ad.q, null);
        }
        if (TextUtils.isEmpty(str)) {
            zza.zzb("BillingClient", "Please provide a valid SKU type.");
            return new l.a(ad.g, null);
        }
        try {
            return (l.a) a(new t(this, str), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new l.a(ad.r, null);
        } catch (Exception unused2) {
            return new l.a(ad.l, null);
        }
    }

    @Override // com.android.billingclient.api.d
    public final void b() {
        try {
            this.e = null;
            this.d.c();
            z zVar = this.h;
            if (zVar != null) {
                zVar.a();
            }
            if (this.h != null && this.g != null) {
                zza.zza("BillingClient", "Unbinding from service.");
                this.f.unbindService(this.h);
                this.h = null;
            }
            this.g = null;
            ExecutorService executorService = this.u;
            if (executorService != null) {
                executorService.shutdownNow();
                this.u = null;
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("There was an exception while ending connection: ");
            sb.append(valueOf);
            zza.zzb("BillingClient", sb.toString());
        } finally {
            this.f970a = 3;
        }
    }

    public final h c() {
        int i = this.f970a;
        if (i == 0 || i == 3) {
            return ad.q;
        }
        return ad.l;
    }

    private e(Context context, boolean z, o oVar, String str, String str2) {
        this.f970a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.k = 0;
        this.b = str;
        a(context, oVar, z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.lang.String r7, boolean r8, android.content.Context r9, com.android.billingclient.api.o r10) {
        /*
            r6 = this;
            java.lang.String r7 = "com.android.billingclient.ktx.BuildConfig"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.Exception -> L15
            java.lang.String r8 = "VERSION_NAME"
            java.lang.reflect.Field r7 = r7.getField(r8)     // Catch: java.lang.Exception -> L15
            r8 = 0
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Exception -> L15
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L15
            r4 = r7
            goto L18
        L15:
            java.lang.String r7 = "3.0.3"
            r4 = r7
        L18:
            r2 = 1
            r5 = 0
            r0 = r6
            r1 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.e.<init>(java.lang.String, boolean, android.content.Context, com.android.billingclient.api.o):void");
    }

    @Override // com.android.billingclient.api.d
    public final void a(f fVar) {
        if (a()) {
            zza.zza("BillingClient", "Service connection is valid. No need to re-initialize.");
            fVar.onBillingSetupFinished(ad.p);
            return;
        }
        int i = this.f970a;
        if (i == 1) {
            zza.zzb("BillingClient", "Client is already in the process of connecting to billing service.");
            fVar.onBillingSetupFinished(ad.d);
            return;
        }
        if (i == 3) {
            zza.zzb("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            fVar.onBillingSetupFinished(ad.q);
            return;
        }
        this.f970a = 1;
        this.d.a();
        zza.zza("BillingClient", "Starting in-app billing setup.");
        this.h = new z(this, fVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.f.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zza.zzb("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.b);
                    if (this.f.bindService(intent2, this.h, 1)) {
                        zza.zza("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    zza.zzb("BillingClient", "Connection to Billing service is blocked.");
                }
            }
        }
        this.f970a = 0;
        zza.zza("BillingClient", "Billing service unavailable on device.");
        fVar.onBillingSetupFinished(ad.c);
    }
}
