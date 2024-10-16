package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcrd implements zzcuz<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3389a;
    private final zzyd b;
    private final List<Parcelable> c;

    public zzcrd(Context context, zzyd zzydVar, List<Parcelable> list) {
        this.f3389a = context;
        this.b = zzydVar;
        this.c = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzk.zzlg();
        bundle2.putString("activity", zzaxi.zzap(this.f3389a));
        Bundle bundle3 = new Bundle();
        bundle3.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.b.width);
        bundle3.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.b.height);
        bundle2.putBundle("size", bundle3);
        if (this.c.size() > 0) {
            List<Parcelable> list = this.c;
            bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
        }
    }
}
