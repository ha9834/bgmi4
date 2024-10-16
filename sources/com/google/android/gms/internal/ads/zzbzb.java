package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public interface zzbzb {
    void cancelUnconfirmedClick();

    void destroy();

    void setClickConfirmingView(View view);

    void zza(View view, MotionEvent motionEvent, View view2);

    void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(View view, Map<String, WeakReference<View>> map);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(zzaag zzaagVar);

    void zza(zzaak zzaakVar);

    void zza(zzagd zzagdVar);

    void zzahk();

    void zzahl();

    void zzahm();

    void zzf(Bundle bundle);

    void zzfi(String str);

    void zzg(Bundle bundle);

    boolean zzh(Bundle bundle);

    void zzro();
}
