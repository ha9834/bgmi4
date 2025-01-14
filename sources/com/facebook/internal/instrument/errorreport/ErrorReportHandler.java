package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    public static final void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    public static final void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static final void sendErrorReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        for (File file : listErrorReportFiles) {
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        j.a((List) arrayList, (Comparator) new Comparator<ErrorReportData>() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$sendErrorReports$1
            @Override // java.util.Comparator
            public final int compare(ErrorReportData errorReportData2, ErrorReportData errorReportData3) {
                h.a((Object) errorReportData3, "o2");
                return errorReportData2.compareTo(errorReportData3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size() && i < 1000; i++) {
            jSONArray.put(arrayList.get(i));
        }
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$sendErrorReports$2
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                try {
                    h.a((Object) graphResponse, AnalyticsEventKey.RESPONSE);
                    if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ErrorReportData) it.next()).clear();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public static final File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$listErrorReportFiles$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                h.a((Object) str, "name");
                l lVar = l.f6973a;
                Object[] objArr = {InstrumentUtility.ERROR_REPORT_PREFIX};
                String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(objArr, objArr.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                return new Regex(format).a(str);
            }
        });
        h.a((Object) listFiles, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }
}
