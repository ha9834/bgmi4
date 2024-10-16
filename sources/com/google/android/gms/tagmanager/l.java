package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class l extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5146a = com.google.android.gms.internal.gtm.zza.FUNCTION_CALL.toString();
    private static final String b = zzb.FUNCTION_CALL_NAME.toString();
    private static final String c = zzb.ADDITIONAL_PARAMS.toString();
    private final zzan d;

    public l(zzan zzanVar) {
        super(f5146a, b);
        this.d = zzanVar;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String zzc = zzgj.zzc(map.get(b));
        HashMap hashMap = new HashMap();
        zzl zzlVar = map.get(c);
        if (zzlVar != null) {
            Object zzh = zzgj.zzh(zzlVar);
            if (!(zzh instanceof Map)) {
                zzdi.zzac("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzgj.zzkc();
            }
            for (Map.Entry entry : ((Map) zzh).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzgj.zzi(this.d.zza(zzc, hashMap));
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 34 + String.valueOf(message).length());
            sb.append("Custom macro/tag ");
            sb.append(zzc);
            sb.append(" threw exception ");
            sb.append(message);
            zzdi.zzac(sb.toString());
            return zzgj.zzkc();
        }
    }
}
