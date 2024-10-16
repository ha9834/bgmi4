package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.os.Build;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStore;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreImpl;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class IdManager {
    static final String ADVERTISING_PREFERENCES = "com.twitter.sdk.android.AdvertisingPreferences";
    static final String COLLECT_IDENTIFIERS_ENABLED = "com.twitter.sdk.android.COLLECT_IDENTIFIERS_ENABLED";
    static final String PREFKEY_INSTALLATION_UUID = "installation_uuid";
    AdvertisingInfo advertisingInfo;
    AdvertisingInfoProvider advertisingInfoProvider;
    private final String appIdentifier;
    private final boolean collectHardwareIds;
    boolean fetchedAdvertisingInfo;
    private final ReentrantLock installationIdLock;
    private final PreferenceStore preferenceStore;
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");

    public IdManager(Context context) {
        this(context, new PreferenceStoreImpl(context, ADVERTISING_PREFERENCES));
    }

    IdManager(Context context, PreferenceStore preferenceStore) {
        this(context, preferenceStore, new AdvertisingInfoProvider(context, preferenceStore));
    }

    IdManager(Context context, PreferenceStore preferenceStore, AdvertisingInfoProvider advertisingInfoProvider) {
        this.installationIdLock = new ReentrantLock();
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        this.appIdentifier = context.getPackageName();
        this.advertisingInfoProvider = advertisingInfoProvider;
        this.preferenceStore = preferenceStore;
        this.collectHardwareIds = CommonUtils.getBooleanResourceValue(context, COLLECT_IDENTIFIERS_ENABLED, true);
        if (this.collectHardwareIds) {
            return;
        }
        Twitter.getLogger().d("Twitter", "Device ID collection disabled for " + context.getPackageName());
    }

    private String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public String getOsVersionString() {
        return getOsDisplayVersionString() + "/" + getOsBuildVersionString();
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL));
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getDeviceUUID() {
        if (!this.collectHardwareIds) {
            return "";
        }
        String string = this.preferenceStore.get().getString(PREFKEY_INSTALLATION_UUID, null);
        return string == null ? createInstallationUUID() : string;
    }

    private String createInstallationUUID() {
        this.installationIdLock.lock();
        try {
            String string = this.preferenceStore.get().getString(PREFKEY_INSTALLATION_UUID, null);
            if (string == null) {
                string = formatId(UUID.randomUUID().toString());
                this.preferenceStore.save(this.preferenceStore.edit().putString(PREFKEY_INSTALLATION_UUID, string));
            }
            return string;
        } finally {
            this.installationIdLock.unlock();
        }
    }

    synchronized AdvertisingInfo getAdvertisingInfo() {
        if (!this.fetchedAdvertisingInfo) {
            this.advertisingInfo = this.advertisingInfoProvider.getAdvertisingInfo();
            this.fetchedAdvertisingInfo = true;
        }
        return this.advertisingInfo;
    }

    public Boolean isLimitAdTrackingEnabled() {
        AdvertisingInfo advertisingInfo;
        if (!this.collectHardwareIds || (advertisingInfo = getAdvertisingInfo()) == null) {
            return null;
        }
        return Boolean.valueOf(advertisingInfo.limitAdTrackingEnabled);
    }

    public String getAdvertisingId() {
        AdvertisingInfo advertisingInfo;
        if (!this.collectHardwareIds || (advertisingInfo = getAdvertisingInfo()) == null) {
            return null;
        }
        return advertisingInfo.advertisingId;
    }
}
