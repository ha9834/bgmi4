package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbgz;

@VisibleForTesting
@zzard
/* loaded from: classes.dex */
public final class zzj {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdkh;
    public final Context zzlj;

    public zzj(zzbgz zzbgzVar) throws zzh {
        this.zzdkh = zzbgzVar.getLayoutParams();
        ViewParent parent = zzbgzVar.getParent();
        this.zzlj = zzbgzVar.zzaad();
        if (parent != null && (parent instanceof ViewGroup)) {
            this.parent = (ViewGroup) parent;
            this.index = this.parent.indexOfChild(zzbgzVar.getView());
            this.parent.removeView(zzbgzVar.getView());
            zzbgzVar.zzaq(true);
            return;
        }
        throw new zzh("Could not get the parent of the WebView for an overlay.");
    }
}
