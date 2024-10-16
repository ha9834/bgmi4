package com.helpshift;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.model.AppInfoModel;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class InstallConfig {
    private final boolean disableErrorReporting;
    private final boolean enableDefaultFallbackLanguage;
    private final boolean enableInAppNotification;
    private final boolean enableInboxPolling;
    private final boolean enableLogging;
    private final Map<String, Object> extras;
    private final String fontPath;
    private final int largeNotificationIcon;
    private final int notificationIcon;
    private final int notificationSound;
    private final int screenOrientation;
    private final String supportNotificationChannelId;

    InstallConfig(boolean z, int i, int i2, int i3, boolean z2, boolean z3, String str, boolean z4, boolean z5, int i4, String str2, Map<String, Object> map) {
        this.enableInAppNotification = z;
        this.notificationIcon = i;
        this.largeNotificationIcon = i2;
        this.notificationSound = i3;
        this.enableDefaultFallbackLanguage = z2;
        this.enableInboxPolling = z3;
        this.fontPath = str;
        this.screenOrientation = i4;
        this.extras = map;
        this.enableLogging = z4;
        this.disableErrorReporting = z5;
        this.supportNotificationChannelId = str2;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION, Boolean.valueOf(this.enableInAppNotification));
        int i = this.notificationIcon;
        if (i != 0) {
            hashMap.put("notificationIcon", Integer.valueOf(i));
        }
        int i2 = this.largeNotificationIcon;
        if (i2 != 0) {
            hashMap.put("largeNotificationIcon", Integer.valueOf(i2));
        }
        int i3 = this.notificationSound;
        if (i3 != 0) {
            hashMap.put("notificationSound", Integer.valueOf(i3));
        }
        hashMap.put("enableDefaultFallbackLanguage", Boolean.valueOf(this.enableDefaultFallbackLanguage));
        hashMap.put("enableInboxPolling", Boolean.valueOf(this.enableInboxPolling));
        hashMap.put("enableLogging", Boolean.valueOf(this.enableLogging));
        hashMap.put("disableErrorReporting", Boolean.valueOf(this.disableErrorReporting));
        hashMap.put("font", this.fontPath);
        hashMap.put(AppInfoModel.SCREEN_ORIENTATION_KEY, Integer.valueOf(this.screenOrientation));
        Map<String, Object> map = this.extras;
        if (map != null) {
            for (String str : map.keySet()) {
                if (this.extras.get(str) != null) {
                    hashMap.put(str, this.extras.get(str));
                }
            }
        }
        if (!hashMap.containsKey(SDKConfigurationDM.SDK_TYPE)) {
            hashMap.put(SDKConfigurationDM.SDK_TYPE, "android");
        }
        hashMap.put(SDKConfigurationDM.SUPPORT_NOTIFICATION_CHANNEL_ID, this.supportNotificationChannelId);
        return hashMap;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private boolean disableErrorReporting;
        private Map<String, Object> extras;
        private int largeNotificationIcon;
        private int notificationIcon;
        private int notificationSound;
        private String supportNotificationChannelId;
        private boolean enableInAppNotification = true;
        private boolean enableInboxPolling = true;
        private boolean enableDefaultFallbackLanguage = true;
        private String fontPath = null;
        private boolean enableLogging = false;
        private int screenOrientation = -1;

        public Builder setEnableInAppNotification(boolean z) {
            this.enableInAppNotification = z;
            return this;
        }

        public Builder setNotificationIcon(int i) {
            if (i != 0) {
                this.notificationIcon = i;
            }
            return this;
        }

        public Builder setLargeNotificationIcon(int i) {
            if (i != 0) {
                this.largeNotificationIcon = i;
            }
            return this;
        }

        public Builder setNotificationSound(int i) {
            if (i != 0) {
                this.notificationSound = i;
            }
            return this;
        }

        public Builder setEnableDefaultFallbackLanguage(boolean z) {
            this.enableDefaultFallbackLanguage = z;
            return this;
        }

        public Builder setEnableInboxPolling(boolean z) {
            this.enableInboxPolling = z;
            return this;
        }

        public Builder setFont(String str) {
            this.fontPath = str;
            return this;
        }

        public Builder setScreenOrientation(int i) {
            this.screenOrientation = i;
            return this;
        }

        public Builder setEnableLogging(boolean z) {
            this.enableLogging = z;
            return this;
        }

        public Builder disableErrorReporting(boolean z) {
            this.disableErrorReporting = z;
            return this;
        }

        public Builder setSupportNotificationChannelId(String str) {
            this.supportNotificationChannelId = str;
            return this;
        }

        public Builder setExtras(Map<String, Object> map) {
            this.extras = map;
            return this;
        }

        public InstallConfig build() {
            return new InstallConfig(this.enableInAppNotification, this.notificationIcon, this.largeNotificationIcon, this.notificationSound, this.enableDefaultFallbackLanguage, this.enableInboxPolling, this.fontPath, this.enableLogging, this.disableErrorReporting, this.screenOrientation, this.supportNotificationChannelId, this.extras);
        }
    }
}
