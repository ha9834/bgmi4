package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgj;

@ShowFirstParty
/* loaded from: classes2.dex */
public class Analytics {

    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";

    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";

    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";

    /* renamed from: a, reason: collision with root package name */
    private static volatile Analytics f4960a;
    private final zzfj b;

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Event extends zzgj {

        @ShowFirstParty
        @KeepForSdk
        public static final String AD_REWARD = "_ar";

        @ShowFirstParty
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Param extends zzgi {

        @ShowFirstParty
        @KeepForSdk
        public static final String FATAL = "fatal";

        @ShowFirstParty
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";

        @ShowFirstParty
        @KeepForSdk
        public static final String TYPE = "type";

        private Param() {
        }
    }

    @ShowFirstParty
    @Keep
    public static Analytics getInstance(Context context) {
        if (f4960a == null) {
            synchronized (Analytics.class) {
                if (f4960a == null) {
                    f4960a = new Analytics(zzfj.zza(context, null));
                }
            }
        }
        return f4960a;
    }

    private Analytics(zzfj zzfjVar) {
        Preconditions.checkNotNull(zzfjVar);
        this.b = zzfjVar;
    }
}
