package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbzl {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3140a;
    private final zzaxb b;
    private final zzcxv c;
    private final zzbyx d;
    private final zzbyt e;

    @Nullable
    private final zzbzt f;
    private final Executor g;
    private final Executor h;
    private final zzady i;

    public zzbzl(Context context, zzaxb zzaxbVar, zzcxv zzcxvVar, zzbyx zzbyxVar, zzbyt zzbytVar, @Nullable zzbzt zzbztVar, Executor executor, Executor executor2) {
        this.f3140a = context;
        this.b = zzaxbVar;
        this.c = zzcxvVar;
        this.i = zzcxvVar.zzdgs;
        this.d = zzbyxVar;
        this.e = zzbytVar;
        this.f = zzbztVar;
        this.g = executor;
        this.h = executor2;
    }

    public final void zzc(final zzcab zzcabVar) {
        this.g.execute(new Runnable(this, zzcabVar) { // from class: com.google.android.gms.internal.ads.qi

            /* renamed from: a, reason: collision with root package name */
            private final zzbzl f2438a;
            private final zzcab b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2438a = this;
                this.b = zzcabVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2438a.a(this.b);
            }
        });
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            return;
        }
        switch (i) {
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                return;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                return;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                return;
        }
    }

    public final void zzd(@Nullable zzcab zzcabVar) {
        if (zzcabVar == null || this.f == null || zzcabVar.zzair() == null) {
            return;
        }
        try {
            zzcabVar.zzair().addView(this.f.zzajb());
        } catch (zzbhj e) {
            zzawz.zza("web view can not be obtained", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(zzcab zzcabVar, String[] strArr) {
        Map<String, WeakReference<View>> zzaiu = zzcabVar.zzaiu();
        if (zzaiu == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaiu.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(@Nonnull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzahy = this.e.zzahy();
        if (zzahy == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzahy.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzahy.getParent()).removeView(zzahy);
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsk)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzahy, layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.e.zzahy() != null) {
            if (2 == this.e.zzahv() || 1 == this.e.zzahv()) {
                this.b.zzc(this.c.zzglb, String.valueOf(this.e.zzahv()), z);
            } else if (6 == this.e.zzahv()) {
                this.b.zzc(this.c.zzglb, "2", z);
                this.b.zzc(this.c.zzglb, "1", z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzcab zzcabVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        Drawable drawable;
        if (this.d.zzaig() || this.d.zzaif()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            int i = 0;
            while (true) {
                if (i < 2) {
                    View zzfp = zzcabVar.zzfp(strArr[i]);
                    if (zzfp != null && (zzfp instanceof ViewGroup)) {
                        viewGroup = (ViewGroup) zzfp;
                        break;
                    }
                    i++;
                } else {
                    viewGroup = null;
                    break;
                }
            }
        } else {
            viewGroup = null;
        }
        boolean z = viewGroup != null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.e.zzahw() != null) {
            view = this.e.zzahw();
            zzady zzadyVar = this.i;
            if (zzadyVar != null && !z) {
                a(layoutParams, zzadyVar.zzbqf);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.e.zzrj() instanceof zzadt) {
            zzadt zzadtVar = (zzadt) this.e.zzrj();
            if (!z) {
                a(layoutParams, zzadtVar.zzrd());
            }
            View zzaduVar = new zzadu(this.f3140a, zzadtVar, layoutParams);
            zzaduVar.setContentDescription((CharSequence) zzyt.zzpe().zzd(zzacu.zzcsh));
            view = zzaduVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcabVar.zzafi().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzair = zzcabVar.zzair();
                if (zzair != null) {
                    zzair.addView(adChoicesView);
                }
            }
            zzcabVar.zza(zzcabVar.zzaiw(), view, true);
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwq)).booleanValue()) {
            zzd(zzcabVar);
        }
        String[] strArr2 = zzbzj.zzfpm;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                viewGroup2 = null;
                break;
            }
            View zzfp2 = zzcabVar.zzfp(strArr2[i2]);
            if (zzfp2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzfp2;
                break;
            }
            i2++;
        }
        this.h.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.qj

            /* renamed from: a, reason: collision with root package name */
            private final zzbzl f2439a;
            private final ViewGroup b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2439a = this;
                this.b = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2439a.a(this.b);
            }
        });
        if (viewGroup2 != null) {
            if (zza(viewGroup2)) {
                if (this.e.zzahz() != null) {
                    this.e.zzahz().zza(new qk(this, zzcabVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View zzafi = zzcabVar.zzafi();
            Context context = zzafi != null ? zzafi.getContext() : null;
            if (context == null || this.e.getImages() == null || this.e.getImages().isEmpty()) {
                return;
            }
            zzadw zzadwVar = this.e.getImages().get(0);
            zzaei zzk = zzadwVar instanceof IBinder ? zzaej.zzk(zzadwVar) : null;
            if (zzk != null) {
                try {
                    IObjectWrapper zzrf = zzk.zzrf();
                    if (zzrf == null || (drawable = (Drawable) ObjectWrapper.unwrap(zzrf)) == null) {
                        return;
                    }
                    ImageView imageView = new ImageView(context);
                    imageView.setImageDrawable(drawable);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    viewGroup2.addView(imageView);
                } catch (RemoteException unused) {
                    zzawz.zzep("Could not get drawable from image");
                }
            }
        }
    }
}
