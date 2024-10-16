package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcro implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final zzyd f3397a;
    private final String b;
    private final boolean c;
    private final String d;
    private final float e;
    private final int f;
    private final int g;
    private final String h;

    public zzcro(zzyd zzydVar, String str, boolean z, String str2, float f, int i, int i2, String str3) {
        Preconditions.checkNotNull(zzydVar, "the adSize must not be null");
        this.f3397a = zzydVar;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = str3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxz.zza(bundle2, "smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, this.f3397a.width == -1);
        zzcxz.zza(bundle2, "smart_h", "auto", this.f3397a.height == -2);
        zzcxz.zza(bundle2, "ene", (Boolean) true, this.f3397a.zzchi);
        zzcxz.zza(bundle2, "format", this.b);
        zzcxz.zza(bundle2, "fluid", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.c);
        zzcxz.zza(bundle2, "sz", this.d, !TextUtils.isEmpty(r1));
        bundle2.putFloat("u_sd", this.e);
        bundle2.putInt("sw", this.f);
        bundle2.putInt("sh", this.g);
        zzcxz.zza(bundle2, "sc", this.h, !TextUtils.isEmpty(r1));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (this.f3397a.zzchg == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f3397a.height);
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f3397a.width);
            bundle3.putBoolean("is_fluid_height", this.f3397a.zzchh);
            arrayList.add(bundle3);
        } else {
            for (zzyd zzydVar : this.f3397a.zzchg) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzydVar.zzchh);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzydVar.height);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzydVar.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
