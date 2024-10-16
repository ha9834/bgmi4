package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Debug;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final /* synthetic */ class yr implements Callable {

    /* renamed from: a, reason: collision with root package name */
    static final Callable f2644a = new yr();

    private yr() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmj)).booleanValue()) {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            bundle.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        Runtime runtime = Runtime.getRuntime();
        bundle.putLong("runtime_free", runtime.freeMemory());
        bundle.putLong("runtime_max", runtime.maxMemory());
        bundle.putLong("runtime_total", runtime.totalMemory());
        bundle.putInt("web_view_count", zzk.zzlk().zzvb());
        return new zzctg(bundle);
    }
}
