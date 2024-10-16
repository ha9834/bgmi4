package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzct;
import com.helpshift.util.ErrorReportProvider;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.imsdk.android.tools.net.volley.upload.MultiPartRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzak {

    /* renamed from: a */
    static zzr f4926a;
    private static volatile zzfj e;

    @VisibleForTesting
    private static Boolean f;
    private static zzdu<Boolean> j;
    private static zzdu<Boolean> k;
    public static zzdu<Long> zzgg;
    public static zzdu<Long> zzgh;
    public static zzdu<Long> zzgi;
    public static zzdu<String> zzgj;
    public static zzdu<String> zzgk;
    public static zzdu<Integer> zzgl;
    public static zzdu<Integer> zzgm;
    public static zzdu<Integer> zzgn;
    public static zzdu<Integer> zzgo;
    public static zzdu<Integer> zzgp;
    public static zzdu<Integer> zzgq;
    public static zzdu<Integer> zzgr;
    public static zzdu<Integer> zzgs;
    public static zzdu<Integer> zzgt;
    public static zzdu<Integer> zzgu;
    public static zzdu<String> zzgv;
    public static zzdu<Long> zzgw;
    public static zzdu<Long> zzgx;
    public static zzdu<Long> zzgy;
    public static zzdu<Long> zzgz;
    public static zzdu<Long> zzha;
    public static zzdu<Long> zzhb;
    public static zzdu<Long> zzhc;
    public static zzdu<Long> zzhd;
    public static zzdu<Long> zzhe;
    public static zzdu<Long> zzhf;
    public static zzdu<Long> zzhg;
    public static zzdu<Integer> zzhh;
    public static zzdu<Long> zzhi;
    public static zzdu<Integer> zzhj;
    public static zzdu<Integer> zzhk;
    public static zzdu<Long> zzhl;
    public static zzdu<Boolean> zzhm;
    public static zzdu<String> zzhn;
    public static zzdu<Long> zzho;
    public static zzdu<Integer> zzhp;
    public static zzdu<Double> zzhq;
    public static zzdu<Integer> zzhr;
    public static zzdu<Boolean> zzhs;
    public static zzdu<Boolean> zzht;
    public static zzdu<Boolean> zzhu;
    public static zzdu<Boolean> zzhv;
    public static zzdu<Boolean> zzhw;
    public static zzdu<Boolean> zzhx;
    public static zzdu<Boolean> zzhy;
    public static zzdu<Boolean> zzhz;
    public static zzdu<Boolean> zzia;
    public static zzdu<Boolean> zzib;
    public static zzdu<Boolean> zzic;
    public static zzdu<Boolean> zzid;
    public static zzdu<Boolean> zzie;
    public static zzdu<Boolean> zzif;
    public static zzdu<Boolean> zzig;
    public static zzdu<Boolean> zzih;
    public static zzdu<Boolean> zzii;
    public static zzdu<Boolean> zzij;
    public static zzdu<Boolean> zzik;
    public static zzdu<Boolean> zzil;
    public static zzdu<Boolean> zzim;
    public static zzdu<Boolean> zzin;
    public static zzdu<Boolean> zzio;
    public static zzdu<Boolean> zzip;
    public static zzdu<Boolean> zziq;
    public static zzdu<Boolean> zzis;
    public static zzdu<Boolean> zzit;
    public static zzdu<Boolean> zziu;
    public static zzdu<Boolean> zziv;
    public static zzdu<Boolean> zziw;
    public static zzdu<Boolean> zzix;
    public static zzdu<Boolean> zziy;
    public static zzdu<Boolean> zziz;
    public static zzdu<Boolean> zzja;
    public static zzdu<Boolean> zzjb;
    public static zzdu<Boolean> zzjc;
    public static zzdu<Boolean> zzjd;
    public static zzdu<Boolean> zzje;
    public static zzdu<Boolean> zzjg;
    public static zzdu<Boolean> zzjh;
    private static List<zzdu<?>> b = Collections.synchronizedList(new ArrayList());
    private static Set<zzdu<?>> c = Collections.synchronizedSet(new HashSet());
    private static final zzct d = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
    private static zzdu<Boolean> g = a("measurement.log_third_party_store_events_enabled", false, false, f.f4849a);
    private static zzdu<Boolean> h = a("measurement.log_installs_enabled", false, false, e.f4824a);
    private static zzdu<Boolean> i = a("measurement.log_upgrades_enabled", false, false, r.f4913a);
    public static zzdu<Boolean> zzgd = a("measurement.log_androidId_enabled", false, false, ab.f4724a);
    public static zzdu<Boolean> zzge = a("measurement.upload_dsid_enabled", false, false, ao.f4737a);
    public static zzdu<String> zzgf = a("measurement.log_tag", "FA", "FA-SVC", ay.f4747a);

    public static Map<String, String> zzk(Context context) {
        zzca zza = zzca.zza(context.getContentResolver(), zzcn.zzdh("com.google.android.gms.measurement"));
        return zza == null ? Collections.emptyMap() : zza.zzre();
    }

    public static void a(zzfj zzfjVar) {
        e = zzfjVar;
    }

    @VisibleForTesting
    public static void a(Exception exc) {
        if (e == null) {
            return;
        }
        Context context = e.getContext();
        if (f == null) {
            f = Boolean.valueOf(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
        }
        if (f.booleanValue()) {
            e.zzab().zzgk().zza("Got Exception on PhenotypeFlag.get on Play device", exc);
        }
    }

    @VisibleForTesting
    private static <V> zzdu<V> a(String str, V v, V v2, cp<V> cpVar) {
        zzdu<V> zzduVar = new zzdu<>(str, v, v2, cpVar);
        b.add(zzduVar);
        return zzduVar;
    }

    public static void a(zzr zzrVar) {
        f4926a = zzrVar;
    }

    private static boolean aI() {
        if (f4926a != null) {
        }
        return false;
    }

    public static final /* synthetic */ Long ay() {
        long zzxo;
        if (aI()) {
            zzxo = com.google.android.gms.internal.measurement.zzjn.zzyc();
        } else {
            zzxo = com.google.android.gms.internal.measurement.zzjn.zzxo();
        }
        return Long.valueOf(zzxo);
    }

    public static final /* synthetic */ String aB() {
        return aI() ? com.google.android.gms.internal.measurement.zzjn.zzye() : com.google.android.gms.internal.measurement.zzjn.zzxp();
    }

    static {
        Long valueOf = Long.valueOf(LogUtils.LOG_FUSE_TIME);
        zzgg = a("measurement.ad_id_cache_time", valueOf, valueOf, bl.f4761a);
        Long valueOf2 = Long.valueOf(ErrorReportProvider.BATCH_TIME);
        zzgh = a("measurement.monitoring.sample_period_millis", valueOf2, valueOf2, bv.f4770a);
        zzgi = a("measurement.config.cache_time", Long.valueOf(ErrorReportProvider.BATCH_TIME), 3600000L, ci.f4784a);
        zzgj = a("measurement.config.url_scheme", "https", "https", co.f4789a);
        zzgk = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", h.f4900a);
        zzgl = a("measurement.upload.max_bundles", 100, 100, g.f4874a);
        zzgm = a("measurement.upload.max_batch_size", 65536, 65536, j.f4905a);
        zzgn = a("measurement.upload.max_bundle_size", 65536, 65536, i.f4904a);
        zzgo = a("measurement.upload.max_events_per_bundle", 1000, 1000, l.f4907a);
        zzgp = a("measurement.upload.max_events_per_day", 100000, 100000, k.f4906a);
        zzgq = a("measurement.upload.max_error_events_per_day", 1000, 1000, n.f4909a);
        Integer valueOf3 = Integer.valueOf(MultiPartRequest.TIMEOUT_MS);
        zzgr = a("measurement.upload.max_public_events_per_day", valueOf3, valueOf3, m.f4908a);
        zzgs = a("measurement.upload.max_conversions_per_day", 500, 500, p.f4911a);
        zzgt = a("measurement.upload.max_realtime_events_per_day", 10, 10, o.f4910a);
        zzgu = a("measurement.store.max_stored_events_per_app", 100000, 100000, q.f4912a);
        zzgv = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", u.f4916a);
        zzgw = a("measurement.upload.backoff_period", 43200000L, 43200000L, t.f4915a);
        zzgx = a("measurement.upload.window_interval", 3600000L, 3600000L, w.f4918a);
        zzgy = a("measurement.upload.interval", 3600000L, 3600000L, v.f4917a);
        Long valueOf4 = Long.valueOf(LogUtils.LOG_FUSE_TIME);
        zzgz = a("measurement.upload.realtime_upload_interval", valueOf4, valueOf4, y.f4920a);
        zzha = a("measurement.upload.debug_upload_interval", 1000L, 1000L, x.f4919a);
        zzhb = a("measurement.upload.minimum_delay", 500L, 500L, aa.f4723a);
        zzhc = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, z.f4921a);
        Long valueOf5 = Long.valueOf(ErrorReportProvider.BATCH_TIME);
        zzhd = a("measurement.upload.stale_data_deletion_interval", valueOf5, valueOf5, ac.f4725a);
        zzhe = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, ae.f4727a);
        zzhf = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, ad.f4726a);
        zzhg = a("measurement.upload.retry_time", 1800000L, 1800000L, ag.f4729a);
        zzhh = a("measurement.upload.retry_count", 6, 6, af.f4728a);
        zzhi = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, ai.f4731a);
        zzhj = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, ah.f4730a);
        zzhk = a("measurement.audience.filter_result_max_count", 200, 200, ak.f4733a);
        zzhl = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, aj.f4732a);
        zzhm = a("measurement.test.boolean_flag", false, false, am.f4735a);
        zzhn = a("measurement.test.string_flag", "---", "---", al.f4734a);
        zzho = a("measurement.test.long_flag", -1L, -1L, an.f4736a);
        zzhp = a("measurement.test.int_flag", -2, -2, aq.f4739a);
        Double valueOf6 = Double.valueOf(-3.0d);
        zzhq = a("measurement.test.double_flag", valueOf6, valueOf6, ap.f4738a);
        zzhr = a("measurement.experiment.max_ids", 50, 50, as.f4741a);
        zzhs = a("measurement.validation.internal_limits_internal_event_params", false, false, ar.f4740a);
        zzht = a("measurement.audience.dynamic_filters", true, true, av.f4744a);
        zzhu = a("measurement.reset_analytics.persist_time", false, false, au.f4743a);
        zzhv = a("measurement.validation.value_and_currency_params", true, true, ax.f4746a);
        zzhw = a("measurement.sampling.time_zone_offset_enabled", false, false, aw.f4745a);
        zzhx = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false, az.f4748a);
        zzhy = a("measurement.fetch_config_with_admob_app_id", true, true, bb.f4751a);
        zzhz = a("measurement.client.sessions.session_id_enabled", false, false, ba.f4750a);
        zzia = a("measurement.service.sessions.session_number_enabled", false, false, bd.f4753a);
        zzib = a("measurement.client.sessions.immediate_start_enabled_foreground", false, false, bc.f4752a);
        zzic = a("measurement.client.sessions.background_sessions_enabled", false, false, bf.f4755a);
        zzid = a("measurement.client.sessions.remove_expired_session_properties_enabled", false, false, be.f4754a);
        zzie = a("measurement.service.sessions.session_number_backfill_enabled", false, false, bh.f4757a);
        zzif = a("measurement.service.sessions.remove_disabled_session_number", false, false, bg.f4756a);
        zzig = a("measurement.collection.firebase_global_collection_flag_enabled", true, true, bj.f4759a);
        zzih = a("measurement.collection.efficient_engagement_reporting_enabled", false, false, bi.f4758a);
        zzii = a("measurement.collection.redundant_engagement_removal_enabled", false, false, bk.f4760a);
        zzij = a("measurement.personalized_ads_signals_collection_enabled", true, true, bn.f4763a);
        zzik = a("measurement.personalized_ads_property_translation_enabled", true, true, bm.f4762a);
        zzil = a("measurement.collection.init_params_control_enabled", true, true, bp.f4765a);
        zzim = a("measurement.upload.disable_is_uploader", true, true, bo.f4764a);
        zzin = a("measurement.experiment.enable_experiment_reporting", true, true, br.f4767a);
        zzio = a("measurement.collection.log_event_and_bundle_v2", true, true, bq.f4766a);
        zzip = a("measurement.collection.null_empty_event_name_fix", true, true, bt.f4769a);
        zziq = a("measurement.audience.sequence_filters", false, false, bs.f4768a);
        j = a("measurement.audience.sequence_filters_bundle_timestamp", false, false, bw.f4771a);
        zzis = a("measurement.quality.checksum", false, false, null);
        zzit = a("measurement.module.collection.conditionally_omit_admob_app_id", true, true, by.f4773a);
        zziu = a("measurement.sdk.dynamite.use_dynamite2", false, false, bx.f4772a);
        zziv = a("measurement.sdk.dynamite.allow_remote_dynamite", false, false, ca.f4776a);
        zziw = a("measurement.sdk.collection.validate_param_names_alphabetical", false, false, bz.f4774a);
        zzix = a("measurement.collection.event_safelist", false, false, cc.f4778a);
        zziy = a("measurement.service.audience.scoped_filters_v27", false, false, cb.f4777a);
        zziz = a("measurement.service.audience.session_scoped_event_aggregates", false, false, ce.f4780a);
        zzja = a("measurement.service.audience.session_scoped_user_engagement", false, false, cd.f4779a);
        zzjb = a("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false, false, cg.f4782a);
        zzjc = a("measurement.sdk.collection.retrieve_deeplink_from_bow", false, false, cf.f4781a);
        zzjd = a("measurement.app_launch.event_ordering_fix", false, false, ch.f4783a);
        zzje = a("measurement.sdk.collection.last_deep_link_referrer", false, false, ck.f4786a);
        k = a("measurement.sdk.collection.last_deep_link_referrer_campaign", false, false, cj.f4785a);
        zzjg = a("measurement.sdk.collection.last_gclid_from_referrer", false, false, cm.f4788a);
        zzjh = a("measurement.upload.file_lock_state_check", false, false, cl.f4787a);
    }
}
