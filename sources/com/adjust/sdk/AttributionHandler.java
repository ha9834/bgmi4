package com.adjust.sdk;

import android.net.Uri;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import com.adjust.sdk.scheduler.TimerOnce;
import com.facebook.internal.ServerProtocol;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AttributionHandler implements IAttributionHandler, IActivityPackageSender.ResponseDataCallbackSubscriber {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private String lastInitiatedBy;
    private boolean paused;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("AttributionHandler");
    private TimerOnce timer = new TimerOnce(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.1
        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.this.sendAttributionRequest();
        }
    }, ATTRIBUTION_TIMER_NAME);

    @Override // com.adjust.sdk.IAttributionHandler
    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        TimerOnce timerOnce = this.timer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.timer = null;
        this.logger = null;
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
    }

    public AttributionHandler(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z, iActivityPackageSender);
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.paused = !z;
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void getAttribution() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.2
            @Override // java.lang.Runnable
            public void run() {
                AttributionHandler.this.lastInitiatedBy = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                AttributionHandler.this.getAttributionI(0L);
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSessionResponse(final SessionResponseData sessionResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.3
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler == null) {
                    return;
                }
                AttributionHandler.this.checkSessionResponseI(iActivityHandler, sessionResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSdkClickResponse(final SdkClickResponseData sdkClickResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.4
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler == null) {
                    return;
                }
                AttributionHandler.this.checkSdkClickResponseI(iActivityHandler, sdkClickResponseData);
            }
        });
    }

    public void checkAttributionResponse(final AttributionResponseData attributionResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.5
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler == null) {
                    return;
                }
                AttributionHandler.this.checkAttributionResponseI(iActivityHandler, attributionResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void resumeSending() {
        this.paused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAttributionRequest() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.6
            @Override // java.lang.Runnable
            public void run() {
                AttributionHandler.this.sendAttributionRequestI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAttributionI(long j) {
        if (this.timer.getFireIn() > j) {
            return;
        }
        if (j != 0) {
            double d = j;
            Double.isNaN(d);
            this.logger.debug("Waiting to query attribution in %s seconds", Util.SecondsDisplayFormat.format(d / 1000.0d));
        }
        this.timer.startIn(j);
    }

    private void checkAttributionI(IActivityHandler iActivityHandler, ResponseData responseData) {
        if (responseData.jsonResponse == null) {
            return;
        }
        Long l = responseData.askIn;
        if (l != null && l.longValue() >= 0) {
            iActivityHandler.setAskingAttribution(true);
            this.lastInitiatedBy = "backend";
            getAttributionI(l.longValue());
            return;
        }
        iActivityHandler.setAskingAttribution(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSessionResponseI(IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(iActivityHandler, sessionResponseData);
        iActivityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSdkClickResponseI(IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        checkAttributionI(iActivityHandler, sdkClickResponseData);
        iActivityHandler.launchSdkClickResponseTasks(sdkClickResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAttributionResponseI(IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(iActivityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        iActivityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject optJSONObject;
        String optString;
        if (attributionResponseData.jsonResponse == null || (optJSONObject = attributionResponseData.jsonResponse.optJSONObject("attribution")) == null || (optString = optJSONObject.optString(Constants.DEEPLINK, null)) == null) {
            return;
        }
        attributionResponseData.deeplink = Uri.parse(optString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAttributionRequestI() {
        if (this.activityHandlerWeakRef.get().getActivityState().isGdprForgotten) {
            return;
        }
        if (this.paused) {
            this.logger.debug("Attribution handler is paused", new Object[0]);
            return;
        }
        ActivityPackage buildAndGetAttributionPackage = buildAndGetAttributionPackage();
        this.logger.verbose("%s", buildAndGetAttributionPackage.getExtendedString());
        this.activityPackageSender.sendActivityPackage(buildAndGetAttributionPackage, generateSendingParametersI(), this);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        return hashMap;
    }

    private ActivityPackage buildAndGetAttributionPackage() {
        long currentTimeMillis = System.currentTimeMillis();
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ActivityPackage buildAttributionPackage = new PackageBuilder(iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getActivityState(), iActivityHandler.getSessionParameters(), currentTimeMillis).buildAttributionPackage(this.lastInitiatedBy);
        this.lastInitiatedBy = null;
        return buildAttributionPackage;
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender.ResponseDataCallbackSubscriber
    public void onResponseDataCallback(final ResponseData responseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.7
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler == null) {
                    return;
                }
                if (responseData.trackingState == TrackingState.OPTED_OUT) {
                    iActivityHandler.gotOptOutResponse();
                    return;
                }
                ResponseData responseData2 = responseData;
                if (responseData2 instanceof AttributionResponseData) {
                    AttributionHandler.this.checkAttributionResponseI(iActivityHandler, (AttributionResponseData) responseData2);
                }
            }
        });
    }
}
