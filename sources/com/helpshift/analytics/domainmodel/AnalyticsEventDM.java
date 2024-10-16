package com.helpshift.analytics.domainmodel;

import com.facebook.appevents.UserDataStore;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventDAO;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.analytics.dto.AnalyticsEventDTO;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.res.values.HSConsts;
import com.helpshift.util.DateUtil;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public class AnalyticsEventDM implements AutoRetriableDM {
    private static final DecimalFormat tsSecFormatter = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US));
    private final AnalyticsEventDAO analyticsEventDAO;
    private final Domain domain;
    private List<AnalyticsEventDTO> eventModelList;
    private final Jsonifier jsonifier;
    private final Platform platform;
    private SDKConfigurationDM sdkConfigurationDM;

    public AnalyticsEventDM(Domain domain, Platform platform) {
        this.domain = domain;
        this.platform = platform;
        this.jsonifier = platform.getJsonifier();
        this.analyticsEventDAO = platform.getAnalyticsEventDAO();
        this.sdkConfigurationDM = domain.getSDKConfigurationDM();
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.ANALYTICS, this);
        this.eventModelList = new ArrayList();
    }

    private void addEventToStorage(AnalyticsEventDTO analyticsEventDTO) {
        this.eventModelList.add(analyticsEventDTO);
    }

    private void addEventsToStorage(List<AnalyticsEventDTO> list) {
        this.eventModelList.addAll(list);
    }

    public synchronized void pushEvent(AnalyticsEventType analyticsEventType, Map<String, Object> map) {
        DecimalFormat decimalFormat = tsSecFormatter;
        double currentTimeMillis = System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        addEventToStorage(new AnalyticsEventDTO(UUID.randomUUID().toString(), analyticsEventType, map, decimalFormat.format(currentTimeMillis / 1000.0d)));
    }

    public synchronized void pushEvent(AnalyticsEventType analyticsEventType, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        pushEvent(analyticsEventType, hashMap);
    }

    public synchronized void pushEvent(AnalyticsEventType analyticsEventType) {
        pushEvent(analyticsEventType, (Map<String, Object>) null);
    }

    public void sendEventsToServer(UserDM userDM) {
        List<AnalyticsEventDTO> currentSessionEventsCopy = getCurrentSessionEventsCopy();
        clearAnalyticsEvent();
        this.analyticsEventDAO.removeAnalyticsAppLaunchData();
        sendEvents(currentSessionEventsCopy, userDM);
    }

    @Override // com.helpshift.common.AutoRetriableDM
    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        Map<String, HashMap<String, String>> unsentAnalytics;
        if (eventType == AutoRetryFailedEventDM.EventType.ANALYTICS && (unsentAnalytics = this.analyticsEventDAO.getUnsentAnalytics()) != null && unsentAnalytics.size() > 0) {
            Network analyticsNetwork = getAnalyticsNetwork();
            for (String str : unsentAnalytics.keySet()) {
                try {
                    analyticsNetwork.makeRequest(new RequestData(unsentAnalytics.get(str)));
                    this.analyticsEventDAO.removeAnalyticsData(str);
                } catch (RootAPIException e) {
                    if (e.exceptionType == NetworkException.NON_RETRIABLE) {
                        this.analyticsEventDAO.removeAnalyticsData(str);
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    private void sendEvents(List<AnalyticsEventDTO> list, UserDM userDM) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        HashMap<String, String> buildEventRequestMap = buildEventRequestMap(this.jsonifier.jsonifyAnalyticsDTOList(list), userDM);
        try {
            getAnalyticsNetwork().makeRequest(new RequestData(buildEventRequestMap));
            this.sdkConfigurationDM.updateLastSuccessfulAppLaunchEventSyncTime();
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.NON_RETRIABLE) {
                return;
            }
            this.analyticsEventDAO.saveUnsentAnalyticsData(UUID.randomUUID().toString(), buildEventRequestMap);
            this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.ANALYTICS, e.getServerStatusCode());
            throw e;
        }
    }

    private Network getAnalyticsNetwork() {
        return new GuardOKNetwork(new FailedAPICallNetworkDecorator(new POSTNetwork("/events/", this.domain, this.platform)));
    }

    private HashMap<String, String> buildEventRequestMap(String str, UserDM userDM) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("id", getAnalyticsEventId(userDM));
        userRequestData.put("e", str);
        Device device = this.platform.getDevice();
        userRequestData.put("v", device.getSDKVersion());
        userRequestData.put("os", device.getOSVersion());
        userRequestData.put("av", device.getAppVersion());
        userRequestData.put("dm", device.getDeviceModel());
        userRequestData.put(AnalyticsEventKey.SEARCH_QUERY, this.sdkConfigurationDM.getString(SDKConfigurationDM.SDK_TYPE));
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.PLUGIN_VERSION);
        String string2 = this.sdkConfigurationDM.getString(SDKConfigurationDM.RUNTIME_VERSION);
        if (!StringUtils.isEmpty(string)) {
            userRequestData.put("pv", string);
        }
        if (!StringUtils.isEmpty(string2)) {
            userRequestData.put("rv", string2);
        }
        userRequestData.put(HSConsts.READ_STATUS_KEY, device.getRom());
        String simCountryIso = device.getSimCountryIso();
        if (!StringUtils.isEmpty(simCountryIso)) {
            userRequestData.put("cc", simCountryIso);
        }
        userRequestData.put(UserDataStore.LAST_NAME, device.getLanguage());
        String sDKLanguage = this.domain.getLocaleProviderDM().getSDKLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            userRequestData.put("dln", sDKLanguage);
        }
        userRequestData.put("and_id", device.getAndroidId());
        return userRequestData;
    }

    private String getAnalyticsEventId(UserDM userDM) {
        String legacyAnalyticsEventId = new LegacyAnalyticsEventDM(this.platform).getLegacyAnalyticsEventId(userDM);
        return StringUtils.isEmpty(legacyAnalyticsEventId) ? userDM.getDeviceId() : legacyAnalyticsEventId;
    }

    public synchronized void clearAnalyticsEvent() {
        if (this.eventModelList != null) {
            this.eventModelList.clear();
        }
    }

    public synchronized List<AnalyticsEventDTO> getCurrentSessionEventsCopy() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (this.eventModelList != null) {
            arrayList.addAll(this.eventModelList);
        }
        return arrayList;
    }

    public void sendAppStartEvent(UserDM userDM) {
        if (this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.DISABLE_APP_LAUNCH_EVENT)) {
            return;
        }
        if (ListUtils.isEmpty(this.eventModelList)) {
            addEventsToStorage(this.analyticsEventDAO.getUnsentAnalyticsAppLaunchData());
        }
        String uuid = UUID.randomUUID().toString();
        DecimalFormat decimalFormat = tsSecFormatter;
        double currentTimeMillis = System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        AnalyticsEventDTO analyticsEventDTO = new AnalyticsEventDTO(uuid, AnalyticsEventType.APP_START, null, decimalFormat.format(currentTimeMillis / 1000.0d));
        addEventToStorage(analyticsEventDTO);
        boolean z = Math.abs(System.currentTimeMillis() - this.sdkConfigurationDM.getLastSuccessfulAppLaunchEventSyncTime().longValue()) >= this.sdkConfigurationDM.getAppLaunchEventSyncInterval();
        boolean z2 = !DateUtil.isToday(this.sdkConfigurationDM.getLastSuccessfulAppLaunchEventSyncTime().longValue());
        if (this.sdkConfigurationDM.isActivelySyncAppLaunchEventEnabled() || z || z2) {
            sendEventsToServer(userDM);
        } else {
            this.analyticsEventDAO.saveUnsentAnalyticsAppLaunchData(analyticsEventDTO);
        }
    }
}
