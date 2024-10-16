package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzm extends dx {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5174a = com.google.android.gms.internal.gtm.zza.ARBITRARY_PIXEL.toString();
    private static final String b = zzb.URL.toString();
    private static final String c = zzb.ADDITIONAL_PARAMS.toString();
    private static final String d = zzb.UNREPEATABLE.toString();
    private static final String e;
    private static final Set<String> f;
    private final zza g;
    private final Context h;

    /* loaded from: classes2.dex */
    public interface zza {
        zzbx zzgx();
    }

    public zzm(Context context) {
        this(context, new eg(context));
    }

    @VisibleForTesting
    private zzm(Context context, zza zzaVar) {
        super(f5174a, b);
        this.g = zzaVar;
        this.h = context;
    }

    @Override // com.google.android.gms.tagmanager.dx
    public final void zzd(Map<String, zzl> map) {
        String zzc = map.get(d) != null ? zzgj.zzc(map.get(d)) : null;
        if (zzc == null || !a(zzc)) {
            Uri.Builder buildUpon = Uri.parse(zzgj.zzc(map.get(b))).buildUpon();
            zzl zzlVar = map.get(c);
            if (zzlVar != null) {
                Object zzh = zzgj.zzh(zzlVar);
                if (!(zzh instanceof List)) {
                    String valueOf = String.valueOf(buildUpon.build().toString());
                    zzdi.zzav(valueOf.length() != 0 ? "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(valueOf) : new String("ArbitraryPixel: additional params not a list: not sending partial hit: "));
                    return;
                }
                for (Object obj : (List) zzh) {
                    if (!(obj instanceof Map)) {
                        String valueOf2 = String.valueOf(buildUpon.build().toString());
                        zzdi.zzav(valueOf2.length() != 0 ? "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(valueOf2) : new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: "));
                        return;
                    } else {
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                        }
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.g.zzgx().zzay(uri);
            String valueOf3 = String.valueOf(uri);
            zzdi.zzab(valueOf3.length() != 0 ? "ArbitraryPixel: url = ".concat(valueOf3) : new String("ArbitraryPixel: url = "));
            if (zzc != null) {
                synchronized (zzm.class) {
                    f.add(zzc);
                    dk.a(this.h, e, zzc, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }

    private final synchronized boolean a(String str) {
        if (f.contains(str)) {
            return true;
        }
        if (!this.h.getSharedPreferences(e, 0).contains(str)) {
            return false;
        }
        f.add(str);
        return true;
    }

    static {
        String str = f5174a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17);
        sb.append("gtm_");
        sb.append(str);
        sb.append("_unrepeatable");
        e = sb.toString();
        f = new HashSet();
    }
}
