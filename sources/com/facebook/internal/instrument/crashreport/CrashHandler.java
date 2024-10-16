package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.v;
import kotlin.d.d;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static CrashHandler instance;
    private final Thread.UncaughtExceptionHandler previousHandler;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = CrashHandler.class.getCanonicalName();

    public static final synchronized void enable() {
        synchronized (CrashHandler.class) {
            Companion.enable();
        }
    }

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, f fVar) {
        this(uncaughtExceptionHandler);
    }

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        h.b(thread, "t");
        h.b(th, "e");
        if (InstrumentUtility.isSDKRelatedException(th)) {
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final synchronized void enable() {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendExceptionReports();
            }
            if (CrashHandler.instance != null) {
                Log.w(CrashHandler.TAG, "Already enabled!");
            } else {
                CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), null);
                Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
            }
        }

        private final void sendExceptionReports() {
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
            ArrayList arrayList = new ArrayList(listExceptionReportFiles.length);
            for (File file : listExceptionReportFiles) {
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                InstrumentData instrumentData = (InstrumentData) obj;
                h.a((Object) instrumentData, "it");
                if (instrumentData.isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List a2 = j.a((Iterable) arrayList2, (Comparator) new Comparator<InstrumentData>() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler$Companion$sendExceptionReports$validReports$3
                @Override // java.util.Comparator
                public final int compare(InstrumentData instrumentData2, InstrumentData instrumentData3) {
                    return instrumentData2.compareTo(instrumentData3);
                }
            });
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = d.b(0, Math.min(a2.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(a2.get(((v) it).b()));
            }
            InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler$Companion$sendExceptionReports$2
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    try {
                        h.a((Object) graphResponse, AnalyticsEventKey.RESPONSE);
                        if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                            Iterator it2 = a2.iterator();
                            while (it2.hasNext()) {
                                ((InstrumentData) it2.next()).clear();
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
        }
    }
}
