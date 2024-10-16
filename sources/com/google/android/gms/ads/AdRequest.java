package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzaba;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes.dex */
public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;

    /* renamed from: a, reason: collision with root package name */
    private final zzaaz f1121a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TagForUnderAgeOfConsent {
    }

    private AdRequest(Builder builder) {
        this.f1121a = new zzaaz(builder.f1122a);
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final zzaba f1122a = new zzaba();

        public Builder() {
            this.f1122a.zzbx("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final Builder addKeyword(String str) {
            this.f1122a.zzbw(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f1122a.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.f1122a.zza(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f1122a.zzby("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f1122a.zzb(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.f1122a.zzbx(str);
            return this;
        }

        public final AdRequest build() {
            return new AdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.f1122a.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            Preconditions.checkArgument(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.f1122a.zzbz(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i) {
            this.f1122a.zzcn(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.f1122a.zza(location);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.f1122a.zzcb(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.f1122a.zzt(z);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.f1122a.zzu(z);
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(int i) {
            this.f1122a.zzco(i);
            return this;
        }

        public final Builder setMaxAdContentRating(String str) {
            this.f1122a.zzcd(str);
            return this;
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f1121a.getBirthday();
    }

    public final String getContentUrl() {
        return this.f1121a.getContentUrl();
    }

    @Deprecated
    public final int getGender() {
        return this.f1121a.getGender();
    }

    public final Set<String> getKeywords() {
        return this.f1121a.getKeywords();
    }

    public final Location getLocation() {
        return this.f1121a.getLocation();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.f1121a.getNetworkExtras(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f1121a.getNetworkExtrasBundle(cls);
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f1121a.getCustomEventExtrasBundle(cls);
    }

    public final boolean isTestDevice(Context context) {
        return this.f1121a.isTestDevice(context);
    }

    public final zzaaz zzde() {
        return this.f1121a;
    }
}
