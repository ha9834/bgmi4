package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzaju<ReferenceT> implements zzajt {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<zzaho<? super ReferenceT>>> f2742a = new HashMap();
    private ReferenceT b;

    public final void zzg(ReferenceT referencet) {
        this.b = referencet;
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final boolean zzcs(String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final boolean zzg(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        zzh(uri);
        return true;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        zzk.zzlg();
        a(path, zzaxi.zzi(uri));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void a(String str, final Map<String, String> map) {
        if (zzawz.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzawz.zzds(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzawz.zzds(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f2742a.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator<zzaho<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                final zzaho<? super ReferenceT> next = it.next();
                zzbbm.zzeae.execute(new Runnable(this, next, map) { // from class: com.google.android.gms.internal.ads.ba

                    /* renamed from: a, reason: collision with root package name */
                    private final zzaju f2065a;
                    private final zzaho b;
                    private final Map c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2065a = this;
                        this.b = next;
                        this.c = map;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2065a.a(this.b, this.c);
                    }
                });
            }
        }
    }

    public final synchronized void zza(String str, zzaho<? super ReferenceT> zzahoVar) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f2742a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f2742a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzahoVar);
    }

    public final synchronized void zzb(String str, zzaho<? super ReferenceT> zzahoVar) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f2742a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzahoVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zza(String str, Predicate<zzaho<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f2742a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzaho<? super ReferenceT> zzahoVar = (zzaho) it.next();
            if (predicate.apply(zzahoVar)) {
                arrayList.add(zzahoVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    public final synchronized void reset() {
        this.f2742a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzaho zzahoVar, Map map) {
        zzahoVar.zza(this.b, map);
    }
}
