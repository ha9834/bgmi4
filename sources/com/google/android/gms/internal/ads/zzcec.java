package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcec extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final zzayb f3200a;

    public zzcec(Context context, View view, zzayb zzaybVar) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.f3200a = zzaybVar;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f3200a.zzd(motionEvent);
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            KeyEvent.Callback childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzbgz)) {
                arrayList.add((zzbgz) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzbgz) obj).destroy();
        }
    }
}
