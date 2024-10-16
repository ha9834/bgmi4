package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SdkClickHandler implements ISdkClickHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
    private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
    private static final String SOURCE_REFTAG = "reftag";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    public SdkClickHandler(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z, iActivityPackageSender);
        this.logger = AdjustFactory.getLogger();
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendSdkClick(final ActivityPackage activityPackage) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SdkClickHandler.this.packageQueue.add(activityPackage);
                SdkClickHandler.this.logger.debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.this.packageQueue.size()));
                SdkClickHandler.this.logger.verbose("%s", activityPackage.getExtendedString());
                SdkClickHandler.this.sendNextSdkClick();
            }
        });
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendReftagReferrers() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.2
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
                SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(iActivityHandler.getContext());
                try {
                    JSONArray rawReferrerArray = sharedPreferencesManager.getRawReferrerArray();
                    boolean z = false;
                    for (int i = 0; i < rawReferrerArray.length(); i++) {
                        JSONArray jSONArray = rawReferrerArray.getJSONArray(i);
                        if (jSONArray.optInt(2, -1) == 0) {
                            String optString = jSONArray.optString(0, null);
                            long optLong = jSONArray.optLong(1, -1L);
                            jSONArray.put(2, 1);
                            SdkClickHandler.this.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(optString, optLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
                            z = true;
                        }
                    }
                    if (z) {
                        sharedPreferencesManager.saveRawReferrerArray(rawReferrerArray);
                    }
                } catch (JSONException e) {
                    SdkClickHandler.this.logger.error("Send saved raw referrers error (%s)", e.getMessage());
                }
            }
        });
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendPreinstallPayload(final String str, final String str2) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.3
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler == null) {
                    return;
                }
                SdkClickHandler.this.sendSdkClick(PackageFactory.buildPreinstallSdkClickPackage(str, str2, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
            }
        });
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClick() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.4
            @Override // java.lang.Runnable
            public void run() {
                SdkClickHandler.this.sendNextSdkClickI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClickI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() == null || iActivityHandler.getActivityState().isGdprForgotten || this.paused || this.packageQueue.isEmpty()) {
            return;
        }
        final ActivityPackage remove = this.packageQueue.remove(0);
        int retries = remove.getRetries();
        Runnable runnable = new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.5
            @Override // java.lang.Runnable
            public void run() {
                SdkClickHandler.this.sendSdkClickI(remove);
                SdkClickHandler.this.sendNextSdkClick();
            }
        };
        if (retries <= 0) {
            runnable.run();
            return;
        }
        long waitingTime = Util.getWaitingTime(retries, this.backoffStrategy);
        double d = waitingTime;
        Double.isNaN(d);
        this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", Util.SecondsDisplayFormat.format(d / MILLISECONDS_TO_SECONDS_DIVISOR), Integer.valueOf(retries));
        this.scheduler.schedule(runnable, waitingTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sendSdkClickI(com.adjust.sdk.ActivityPackage r23) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.SdkClickHandler.sendSdkClickI(com.adjust.sdk.ActivityPackage):void");
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(hashMap, "queue_size", size);
        }
        return hashMap;
    }

    private void retrySendingI(ActivityPackage activityPackage) {
        this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(activityPackage.increaseRetries()));
        sendSdkClick(activityPackage);
    }

    private void logErrorMessageI(ActivityPackage activityPackage, String str, Throwable th) {
        this.logger.error(Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th)), new Object[0]);
    }
}
