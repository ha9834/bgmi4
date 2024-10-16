package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzdbr implements zzdbv {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f3535a = Charset.forName("UTF-8");
    private final InputStream b;
    private boolean d = false;
    private final JSONObject c = null;

    private zzdbr(InputStream inputStream) {
        this.b = inputStream;
    }

    public static zzdbv zzf(InputStream inputStream) throws IOException {
        return new zzdbr(inputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzdbv
    public final zzdha zzanq() throws IOException {
        zzdgu zzdguVar;
        zzdhm zzdhmVar;
        zzdgr.zzb zzbVar;
        try {
            JSONObject jSONObject = new JSONObject(new String(abl.a(this.b), f3535a));
            if (!jSONObject.has("key") || jSONObject.getJSONArray("key").length() == 0) {
                throw new JSONException("invalid keyset");
            }
            zzdha.zza zzask = zzdha.zzask();
            if (jSONObject.has("primaryKeyId")) {
                zzask.zzes(jSONObject.getInt("primaryKeyId"));
            }
            JSONArray jSONArray = jSONObject.getJSONArray("key");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (!jSONObject2.has("keyData") || !jSONObject2.has("status") || !jSONObject2.has("keyId") || !jSONObject2.has("outputPrefixType")) {
                    throw new JSONException("invalid key");
                }
                zzdha.zzb.zza zzasq = zzdha.zzb.zzasq();
                String string = jSONObject2.getString("status");
                if (string.equals("ENABLED")) {
                    zzdguVar = zzdgu.ENABLED;
                } else if (string.equals("DISABLED")) {
                    zzdguVar = zzdgu.DISABLED;
                } else {
                    String valueOf = String.valueOf(string);
                    throw new JSONException(valueOf.length() != 0 ? "unknown status: ".concat(valueOf) : new String("unknown status: "));
                }
                zzdha.zzb.zza zzeu = zzasq.zzb(zzdguVar).zzeu(jSONObject2.getInt("keyId"));
                String string2 = jSONObject2.getString("outputPrefixType");
                if (string2.equals("TINK")) {
                    zzdhmVar = zzdhm.TINK;
                } else if (string2.equals("RAW")) {
                    zzdhmVar = zzdhm.RAW;
                } else if (string2.equals("LEGACY")) {
                    zzdhmVar = zzdhm.LEGACY;
                } else if (string2.equals("CRUNCHY")) {
                    zzdhmVar = zzdhm.CRUNCHY;
                } else {
                    String valueOf2 = String.valueOf(string2);
                    throw new JSONException(valueOf2.length() != 0 ? "unknown output prefix type: ".concat(valueOf2) : new String("unknown output prefix type: "));
                }
                zzdha.zzb.zza zzb = zzeu.zzb(zzdhmVar);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("keyData");
                if (!jSONObject3.has("typeUrl") || !jSONObject3.has("value") || !jSONObject3.has("keyMaterialType")) {
                    throw new JSONException("invalid keyData");
                }
                zzdgr.zza zzbo = zzdgr.zzarw().zzgk(jSONObject3.getString("typeUrl")).zzbo(zzdmr.zzz(zzdjp.decode(jSONObject3.getString("value"))));
                String string3 = jSONObject3.getString("keyMaterialType");
                if (string3.equals("SYMMETRIC")) {
                    zzbVar = zzdgr.zzb.SYMMETRIC;
                } else if (string3.equals("ASYMMETRIC_PRIVATE")) {
                    zzbVar = zzdgr.zzb.ASYMMETRIC_PRIVATE;
                } else if (string3.equals("ASYMMETRIC_PUBLIC")) {
                    zzbVar = zzdgr.zzb.ASYMMETRIC_PUBLIC;
                } else if (string3.equals("REMOTE")) {
                    zzbVar = zzdgr.zzb.REMOTE;
                } else {
                    String valueOf3 = String.valueOf(string3);
                    throw new JSONException(valueOf3.length() != 0 ? "unknown key material type: ".concat(valueOf3) : new String("unknown key material type: "));
                }
                zzask.zzb((zzdha.zzb) ((zzdob) zzb.zzb((zzdgr) ((zzdob) zzbo.zzb(zzbVar).zzaya())).zzaya()));
            }
            return (zzdha) ((zzdob) zzask.zzaya());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
