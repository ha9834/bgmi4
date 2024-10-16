package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbyt {

    /* renamed from: a, reason: collision with root package name */
    private int f3128a;
    private zzaar b;
    private zzaea c;
    private View d;
    private List<zzadw> e;
    private zzabj g;
    private Bundle h;
    private zzbgz i;
    private zzbgz j;
    private IObjectWrapper k;
    private View l;
    private IObjectWrapper m;
    private double n;
    private zzaei o;
    private zzaei p;
    private String q;
    private float t;
    private androidx.b.g<String, zzadw> r = new androidx.b.g<>();
    private androidx.b.g<String, String> s = new androidx.b.g<>();
    private List<zzabj> f = Collections.emptyList();

    public final synchronized void zzdn(int i) {
        this.f3128a = i;
    }

    public final synchronized void zzb(zzaar zzaarVar) {
        this.b = zzaarVar;
    }

    public final synchronized void zza(zzaea zzaeaVar) {
        this.c = zzaeaVar;
    }

    public final synchronized void setImages(List<zzadw> list) {
        this.e = list;
    }

    public final synchronized void zze(List<zzabj> list) {
        this.f = list;
    }

    public final synchronized void zza(zzabj zzabjVar) {
        this.g = zzabjVar;
    }

    public final synchronized void zzz(View view) {
        this.l = view;
    }

    public final synchronized void setStarRating(double d) {
        this.n = d;
    }

    public final synchronized void zza(zzaei zzaeiVar) {
        this.o = zzaeiVar;
    }

    public final synchronized void zzb(zzaei zzaeiVar) {
        this.p = zzaeiVar;
    }

    public final synchronized void zzfl(String str) {
        this.q = str;
    }

    public final synchronized void zzh(zzbgz zzbgzVar) {
        this.i = zzbgzVar;
    }

    public final synchronized void zzi(zzbgz zzbgzVar) {
        this.j = zzbgzVar;
    }

    public final synchronized void zzan(IObjectWrapper iObjectWrapper) {
        this.k = iObjectWrapper;
    }

    public final synchronized void zzp(String str, String str2) {
        if (str2 == null) {
            this.s.remove(str);
        } else {
            this.s.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzadw zzadwVar) {
        if (zzadwVar == null) {
            this.r.remove(str);
        } else {
            this.r.put(str, zzadwVar);
        }
    }

    private final synchronized void a(float f) {
        this.t = f;
    }

    private final synchronized String a(String str) {
        return this.s.get(str);
    }

    public final synchronized int zzahv() {
        return this.f3128a;
    }

    public final synchronized zzaar getVideoController() {
        return this.b;
    }

    public final synchronized zzaea zzrj() {
        return this.c;
    }

    public final synchronized View zzahw() {
        return this.d;
    }

    public final synchronized String getHeadline() {
        return a("headline");
    }

    public final synchronized List<zzadw> getImages() {
        return this.e;
    }

    public final synchronized List<zzabj> getMuteThisAdReasons() {
        return this.f;
    }

    public final synchronized zzabj zzahx() {
        return this.g;
    }

    public final synchronized String getBody() {
        return a("body");
    }

    public final synchronized Bundle getExtras() {
        if (this.h == null) {
            this.h = new Bundle();
        }
        return this.h;
    }

    public final synchronized String getCallToAction() {
        return a("call_to_action");
    }

    public final synchronized View zzahy() {
        return this.l;
    }

    public final synchronized IObjectWrapper zzrk() {
        return this.m;
    }

    public final synchronized String getStore() {
        return a("store");
    }

    public final synchronized String getPrice() {
        return a(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.n;
    }

    public final synchronized zzaei zzri() {
        return this.o;
    }

    public final synchronized String getAdvertiser() {
        return a("advertiser");
    }

    public final synchronized zzaei zzrl() {
        return this.p;
    }

    public final synchronized String getCustomTemplateId() {
        return this.q;
    }

    public final synchronized zzbgz zzahz() {
        return this.i;
    }

    public final synchronized zzbgz zzaia() {
        return this.j;
    }

    public final synchronized IObjectWrapper zzaib() {
        return this.k;
    }

    public final synchronized androidx.b.g<String, zzadw> zzaic() {
        return this.r;
    }

    public final synchronized float zzsq() {
        return this.t;
    }

    public final synchronized androidx.b.g<String, String> zzaid() {
        return this.s;
    }

    public final synchronized void destroy() {
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
        this.k = null;
        this.r.clear();
        this.s.clear();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static zzbyt zza(zzand zzandVar) {
        try {
            zzaar videoController = zzandVar.getVideoController();
            zzaea zzrj = zzandVar.zzrj();
            View view = (View) a(zzandVar.zzso());
            String headline = zzandVar.getHeadline();
            List<zzadw> images = zzandVar.getImages();
            String body = zzandVar.getBody();
            Bundle extras = zzandVar.getExtras();
            String callToAction = zzandVar.getCallToAction();
            View view2 = (View) a(zzandVar.zzsp());
            IObjectWrapper zzrk = zzandVar.zzrk();
            String advertiser = zzandVar.getAdvertiser();
            zzaei zzrl = zzandVar.zzrl();
            zzbyt zzbytVar = new zzbyt();
            zzbytVar.f3128a = 1;
            zzbytVar.b = videoController;
            zzbytVar.c = zzrj;
            zzbytVar.d = view;
            zzbytVar.zzp("headline", headline);
            zzbytVar.e = images;
            zzbytVar.zzp("body", body);
            zzbytVar.h = extras;
            zzbytVar.zzp("call_to_action", callToAction);
            zzbytVar.l = view2;
            zzbytVar.m = zzrk;
            zzbytVar.zzp("advertiser", advertiser);
            zzbytVar.p = zzrl;
            return zzbytVar;
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzbyt zza(zzana zzanaVar) {
        try {
            zzaar videoController = zzanaVar.getVideoController();
            zzaea zzrj = zzanaVar.zzrj();
            View view = (View) a(zzanaVar.zzso());
            String headline = zzanaVar.getHeadline();
            List<zzadw> images = zzanaVar.getImages();
            String body = zzanaVar.getBody();
            Bundle extras = zzanaVar.getExtras();
            String callToAction = zzanaVar.getCallToAction();
            View view2 = (View) a(zzanaVar.zzsp());
            IObjectWrapper zzrk = zzanaVar.zzrk();
            String store = zzanaVar.getStore();
            String price = zzanaVar.getPrice();
            double starRating = zzanaVar.getStarRating();
            zzaei zzri = zzanaVar.zzri();
            zzbyt zzbytVar = new zzbyt();
            zzbytVar.f3128a = 2;
            zzbytVar.b = videoController;
            zzbytVar.c = zzrj;
            zzbytVar.d = view;
            zzbytVar.zzp("headline", headline);
            zzbytVar.e = images;
            zzbytVar.zzp("body", body);
            zzbytVar.h = extras;
            zzbytVar.zzp("call_to_action", callToAction);
            zzbytVar.l = view2;
            zzbytVar.m = zzrk;
            zzbytVar.zzp("store", store);
            zzbytVar.zzp(FirebaseAnalytics.Param.PRICE, price);
            zzbytVar.n = starRating;
            zzbytVar.o = zzri;
            return zzbytVar;
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzang zzangVar) {
        try {
            return a(zzangVar.getVideoController(), zzangVar.zzrj(), (View) a(zzangVar.zzso()), zzangVar.getHeadline(), zzangVar.getImages(), zzangVar.getBody(), zzangVar.getExtras(), zzangVar.getCallToAction(), (View) a(zzangVar.zzsp()), zzangVar.zzrk(), zzangVar.getStore(), zzangVar.getPrice(), zzangVar.getStarRating(), zzangVar.zzri(), zzangVar.getAdvertiser(), zzangVar.zzsq());
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzana zzanaVar) {
        try {
            return a(zzanaVar.getVideoController(), zzanaVar.zzrj(), (View) a(zzanaVar.zzso()), zzanaVar.getHeadline(), zzanaVar.getImages(), zzanaVar.getBody(), zzanaVar.getExtras(), zzanaVar.getCallToAction(), (View) a(zzanaVar.zzsp()), zzanaVar.zzrk(), zzanaVar.getStore(), zzanaVar.getPrice(), zzanaVar.getStarRating(), zzanaVar.zzri(), null, 0.0f);
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzand zzandVar) {
        try {
            return a(zzandVar.getVideoController(), zzandVar.zzrj(), (View) a(zzandVar.zzso()), zzandVar.getHeadline(), zzandVar.getImages(), zzandVar.getBody(), zzandVar.getExtras(), zzandVar.getCallToAction(), (View) a(zzandVar.zzsp()), zzandVar.zzrk(), null, null, -1.0d, zzandVar.zzrl(), zzandVar.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzbyt a(zzaar zzaarVar, zzaea zzaeaVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaei zzaeiVar, String str6, float f) {
        zzbyt zzbytVar = new zzbyt();
        zzbytVar.f3128a = 6;
        zzbytVar.b = zzaarVar;
        zzbytVar.c = zzaeaVar;
        zzbytVar.d = view;
        zzbytVar.zzp("headline", str);
        zzbytVar.e = list;
        zzbytVar.zzp("body", str2);
        zzbytVar.h = bundle;
        zzbytVar.zzp("call_to_action", str3);
        zzbytVar.l = view2;
        zzbytVar.m = iObjectWrapper;
        zzbytVar.zzp("store", str4);
        zzbytVar.zzp(FirebaseAnalytics.Param.PRICE, str5);
        zzbytVar.n = d;
        zzbytVar.o = zzaeiVar;
        zzbytVar.zzp("advertiser", str6);
        zzbytVar.a(f);
        return zzbytVar;
    }

    private static <T> T a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.unwrap(iObjectWrapper);
    }
}
