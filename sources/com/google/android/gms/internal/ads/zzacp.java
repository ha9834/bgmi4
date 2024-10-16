package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzacp {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<zzacj<?>> f2698a = new ArrayList();
    private final Collection<zzacj<String>> b = new ArrayList();
    private final Collection<zzacj<String>> c = new ArrayList();

    public final void zza(zzacj zzacjVar) {
        this.f2698a.add(zzacjVar);
    }

    public final void zzb(zzacj<String> zzacjVar) {
        this.b.add(zzacjVar);
    }

    public final void zzc(zzacj<String> zzacjVar) {
        this.c.add(zzacjVar);
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzacj<?> zzacjVar : this.f2698a) {
            if (zzacjVar.getSource() == 1) {
                zzacjVar.zza(editor, zzacjVar.a(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbad.zzen("Flag Json is null.");
        }
    }

    public final List<String> zzqn() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzacj<String>> it = this.b.iterator();
        while (it.hasNext()) {
            String str = (String) zzyt.zzpe().zzd(it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzqo() {
        List<String> zzqn = zzqn();
        Iterator<zzacj<String>> it = this.c.iterator();
        while (it.hasNext()) {
            String str = (String) zzyt.zzpe().zzd(it.next());
            if (str != null) {
                zzqn.add(str);
            }
        }
        return zzqn;
    }
}
