package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    public static final boolean isDebug() {
        return false;
    }

    private ExceptionAnalyzer() {
    }

    public static final void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports();
        }
    }

    public static final void execute(Throwable th) {
        if (!enabled || isDebug() || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        h.a((Object) stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            h.a((Object) stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            h.a((Object) className, "it.className");
            FeatureManager.Feature feature = FeatureManager.getFeature(className);
            if (feature != FeatureManager.Feature.Unknown) {
                FeatureManager.disableFeature(feature);
                hashSet.add(feature.toString());
            }
        }
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            HashSet hashSet2 = hashSet;
            if (!hashSet2.isEmpty()) {
                InstrumentData.Builder.build(new JSONArray((Collection) hashSet2)).save();
            }
        }
    }

    public final void sendExceptionAnalysisReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File file : listExceptionAnalysisReportFiles) {
            final InstrumentData load = InstrumentData.Builder.load(file);
            h.a((Object) load, "instrumentData");
            if (load.isValid()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", load.toString());
                    l lVar = l.f6973a;
                    Object[] objArr = {FacebookSdk.getApplicationId()};
                    String format = String.format("%s/instruments", Arrays.copyOf(objArr, objArr.length));
                    h.a((Object) format, "java.lang.String.format(format, *args)");
                    GraphRequest newPostRequest = GraphRequest.newPostRequest(null, format, jSONObject, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.ExceptionAnalyzer$sendExceptionAnalysisReports$request$1
                        @Override // com.facebook.GraphRequest.Callback
                        public final void onCompleted(GraphResponse graphResponse) {
                            try {
                                h.a((Object) graphResponse, AnalyticsEventKey.RESPONSE);
                                if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                                    InstrumentData.this.clear();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                    });
                    h.a((Object) newPostRequest, "request");
                    arrayList.add(newPostRequest);
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new GraphRequestBatch(arrayList).executeAsync();
    }
}
