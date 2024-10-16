package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzcmn<AdT> implements zzcjv<AdT> {
    protected abstract zzbbh<AdT> a(zzcxv zzcxvVar, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return !TextUtils.isEmpty(zzcxmVar.zzgkh.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> zzb(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        String optString = zzcxmVar.zzgkh.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzcxv zzcxvVar = zzcxuVar.zzgkx.zzfjp;
        zzcxx zzft = new zzcxx().zzg(zzcxvVar.zzghg).zzd(zzcxvVar.zzdll).zzd(zzcxvVar.zzgkz).zzft(zzcxvVar.zzglb).zzc(zzcxvVar.zzgla).zzb(zzcxvVar.zzglc).zzc(zzcxvVar.zzgld).zzb(zzcxvVar.zzdgs).zzfu(zzcxvVar.zzgle).zzb(zzcxvVar.zzglh).zzfv(zzcxvVar.zzglf).zzft(optString);
        Bundle a2 = a(zzcxvVar.zzghg.zzcgv);
        Bundle a3 = a(a2.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        a3.putInt("gw", 1);
        String optString2 = zzcxmVar.zzgkh.optString("mad_hac", null);
        if (optString2 != null) {
            a3.putString("mad_hac", optString2);
        }
        String optString3 = zzcxmVar.zzgkh.optString("adJson", null);
        if (optString3 != null) {
            a3.putString("_ad", optString3);
        }
        a3.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzcxmVar.zzgkk.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzcxmVar.zzgkk.optString(next, null);
            if (next != null) {
                a3.putString(next, optString4);
            }
        }
        a2.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a3);
        zzcxv zzamq = zzft.zzg(new zzxz(zzcxvVar.zzghg.versionCode, zzcxvVar.zzghg.zzcgn, a3, zzcxvVar.zzghg.zzcgo, zzcxvVar.zzghg.zzcgp, zzcxvVar.zzghg.zzcgq, zzcxvVar.zzghg.zzcgr, zzcxvVar.zzghg.zzbqn, zzcxvVar.zzghg.zzcgs, zzcxvVar.zzghg.zzcgt, zzcxvVar.zzghg.zzmw, zzcxvVar.zzghg.zzcgu, a2, zzcxvVar.zzghg.zzcgw, zzcxvVar.zzghg.zzcgx, zzcxvVar.zzghg.zzcgy, zzcxvVar.zzghg.zzcgz, zzcxvVar.zzghg.zzcha, zzcxvVar.zzghg.zzchb, zzcxvVar.zzghg.zzchc, zzcxvVar.zzghg.zzchd)).zzamq();
        Bundle bundle = new Bundle();
        zzcxo zzcxoVar = zzcxuVar.zzgky.zzgku;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzcxoVar.zzdfh));
        bundle2.putInt("refresh_interval", zzcxoVar.zzgkr);
        bundle2.putString("gws_query_id", zzcxoVar.zzcep);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzcxuVar.zzgkx.zzfjp.zzglb;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzcxmVar.zzdej);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzcxmVar.zzdfe));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzcxmVar.zzdff));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzcxmVar.zzdnl));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzcxmVar.zzgkc));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzcxmVar.zzdny));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzcxmVar.zzdnz));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzcxmVar.zzgkb));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzcxmVar.zzdeu);
        bundle3.putString("valid_from_timestamp", zzcxmVar.zzdev);
        bundle3.putBoolean("is_closable_area_disabled", zzcxmVar.zzbrm);
        if (zzcxmVar.zzdnx != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzcxmVar.zzdnx.zzdqm);
            bundle4.putString("rb_type", zzcxmVar.zzdnx.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return a(zzamq, bundle);
    }

    private static Bundle a(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
