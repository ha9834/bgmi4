package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class LifecycleActivity {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1315a;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.f1315a = activity;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.f1315a instanceof FragmentActivity;
    }

    public final boolean zzh() {
        return this.f1315a instanceof Activity;
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.f1315a;
    }

    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.f1315a;
    }

    @KeepForSdk
    public Object asObject() {
        return this.f1315a;
    }
}
