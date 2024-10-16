package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzayb;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
@zzard
/* loaded from: classes.dex */
public final class d extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    boolean f1151a;

    @VisibleForTesting
    private zzayb b;

    public d(Context context, String str, String str2) {
        super(context);
        this.b = new zzayb(context, str);
        this.b.zzp(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1151a) {
            return false;
        }
        this.b.zzd(motionEvent);
        return false;
    }
}
