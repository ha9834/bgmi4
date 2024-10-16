package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zza extends Fragment implements LifecycleFragment {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<Activity, WeakReference<zza>> f1406a = new WeakHashMap<>();
    private Map<String, LifecycleCallback> b = new androidx.b.a();
    private int c = 0;
    private Bundle d;

    public static zza zza(Activity activity) {
        zza zzaVar;
        WeakReference<zza> weakReference = f1406a.get(activity);
        if (weakReference != null && (zzaVar = weakReference.get()) != null) {
            return zzaVar;
        }
        try {
            zza zzaVar2 = (zza) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzaVar2 == null || zzaVar2.isRemoving()) {
                zzaVar2 = new zza();
                activity.getFragmentManager().beginTransaction().add(zzaVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f1406a.put(activity, new WeakReference<>(zzaVar2));
            return zzaVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return cls.cast(this.b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, lifecycleCallback);
            if (this.c > 0) {
                new zze(Looper.getMainLooper()).post(new bg(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.c > 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.c >= 2;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = 1;
        this.d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.c = 2;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.c = 3;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.c = 4;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.c = 5;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().dump(str, fileDescriptor, printWriter, strArr);
        }
    }
}
