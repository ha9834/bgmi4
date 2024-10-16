package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.tagmanager.zzeh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
public class Container {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5061a;
    private final String b;
    private final DataLayer c;
    private cu d;
    private Map<String, FunctionCallMacroCallback> e;
    private Map<String, FunctionCallTagCallback> f;
    private volatile long g;
    private volatile String h;

    /* loaded from: classes2.dex */
    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    /* loaded from: classes2.dex */
    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements zzan {
        private a() {
        }

        @Override // com.google.android.gms.tagmanager.zzan
        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallMacroCallback a2 = Container.this.a(str);
            if (a2 == null) {
                return null;
            }
            return a2.getValue(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements zzan {
        private b() {
        }

        @Override // com.google.android.gms.tagmanager.zzan
        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzam = Container.this.zzam(str);
            if (zzam != null) {
                zzam.execute(str, map);
            }
            return zzgj.zzkb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Container(Context context, DataLayer dataLayer, String str, long j, zzov zzovVar) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = "";
        this.f5061a = context;
        this.c = dataLayer;
        this.b = str;
        this.g = 0L;
        a(zzovVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Container(Context context, DataLayer dataLayer, String str, long j, zzk zzkVar) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = "";
        this.f5061a = context;
        this.c = dataLayer;
        this.b = str;
        this.g = j;
        zzi zziVar = zzkVar.zzqk;
        if (zziVar == null) {
            throw new NullPointerException();
        }
        try {
            a(zzor.zza(zziVar));
        } catch (zzoz e) {
            String valueOf = String.valueOf(zziVar);
            String zzozVar = e.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(zzozVar).length());
            sb.append("Not loading resource: ");
            sb.append(valueOf);
            sb.append(" because it is invalid: ");
            sb.append(zzozVar);
            zzdi.zzav(sb.toString());
        }
        if (zzkVar.zzqj != null) {
            zzj[] zzjVarArr = zzkVar.zzqj;
            ArrayList arrayList = new ArrayList();
            for (zzj zzjVar : zzjVarArr) {
                arrayList.add(zzjVar);
            }
            b().a(arrayList);
        }
    }

    public String getContainerId() {
        return this.b;
    }

    public boolean getBoolean(String str) {
        cu b2 = b();
        if (b2 == null) {
            zzdi.zzav("getBoolean called for closed container.");
            return zzgj.zzjz().booleanValue();
        }
        try {
            return zzgj.zzg(b2.b(str).a()).booleanValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 66);
            sb.append("Calling getBoolean() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.zzav(sb.toString());
            return zzgj.zzjz().booleanValue();
        }
    }

    public double getDouble(String str) {
        cu b2 = b();
        if (b2 == null) {
            zzdi.zzav("getDouble called for closed container.");
            return zzgj.zzjy().doubleValue();
        }
        try {
            return zzgj.zzf(b2.b(str).a()).doubleValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 65);
            sb.append("Calling getDouble() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.zzav(sb.toString());
            return zzgj.zzjy().doubleValue();
        }
    }

    public long getLong(String str) {
        cu b2 = b();
        if (b2 == null) {
            zzdi.zzav("getLong called for closed container.");
            return zzgj.zzjx().longValue();
        }
        try {
            return zzgj.zze(b2.b(str).a()).longValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 63);
            sb.append("Calling getLong() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.zzav(sb.toString());
            return zzgj.zzjx().longValue();
        }
    }

    public String getString(String str) {
        cu b2 = b();
        if (b2 == null) {
            zzdi.zzav("getString called for closed container.");
            return zzgj.zzkb();
        }
        try {
            return zzgj.zzc(b2.b(str).a());
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 65);
            sb.append("Calling getString() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.zzav(sb.toString());
            return zzgj.zzkb();
        }
    }

    public long getLastRefreshTime() {
        return this.g;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.e) {
            this.e.put(str, functionCallMacroCallback);
        }
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.e) {
            this.e.remove(str);
        }
    }

    @VisibleForTesting
    final FunctionCallMacroCallback a(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.e) {
            functionCallMacroCallback = this.e.get(str);
        }
        return functionCallMacroCallback;
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.f) {
            this.f.put(str, functionCallTagCallback);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.f) {
            this.f.remove(str);
        }
    }

    @VisibleForTesting
    public final FunctionCallTagCallback zzam(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.f) {
            functionCallTagCallback = this.f.get(str);
        }
        return functionCallTagCallback;
    }

    @VisibleForTesting
    public final void zzan(String str) {
        b().a(str);
    }

    @VisibleForTesting
    public final String zzha() {
        return this.h;
    }

    private final void a(zzov zzovVar) {
        this.h = zzovVar.getVersion();
        String str = this.h;
        zzeh.a().b().equals(zzeh.zza.CONTAINER_DEBUG);
        a(new cu(this.f5061a, zzovVar, this.c, new a(), new b(), new bk()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.c.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.b));
        }
    }

    private final synchronized void a(cu cuVar) {
        this.d = cuVar;
    }

    private final synchronized cu b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.d = null;
    }
}
