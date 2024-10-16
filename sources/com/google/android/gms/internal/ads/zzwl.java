package com.google.android.gms.internal.ads;

import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzwl {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, C0102zza> implements zzdpm {
        private static final zza zzbxn = new zza();
        private static volatile zzdpv<zza> zzdv;

        /* loaded from: classes2.dex */
        public enum zzb implements zzdoe {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            REQUEST_FAILED_TO_RENDER(1007),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED),
            OFFLINE_UPLOAD(GamesActivityResultCodes.RESULT_LICENSE_FAILED);

            private static final zzdof<zzb> d = new apm();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int zzac() {
                return this.value;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzwl$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0102zza extends zzdob.zza<zza, C0102zza> implements zzdpm {
            private C0102zza() {
                super(zza.zzbxn);
            }

            /* synthetic */ C0102zza(apl aplVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object a(int i, Object obj, Object obj2) {
            apl aplVar = null;
            switch (apl.f2034a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0102zza(aplVar);
                case 3:
                    return a(zzbxn, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbxn;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzbxn);
                                zzdv = zzdpvVar;
                            }
                        }
                    }
                    return zzdpvVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.a((Class<zza>) zza.class, zzbxn);
        }
    }
}
