package com.facebook.internal.instrument;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import kotlin.text.d;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class InstrumentUtility {
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    private static final String FBSDK_PREFIX = "com.facebook";
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    private static final String INSTRUMENT_DIR = "instrument";
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    public static final String getCause(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    public static final String getStackTrace(Throwable th) {
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Throwable th2 = th;
        Throwable th3 = (Throwable) null;
        while (th2 != null && th2 != th3) {
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            Throwable th4 = th2;
            th2 = th2.getCause();
            th3 = th4;
        }
        return jSONArray.toString();
    }

    public static final boolean isSDKRelatedException(Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = th;
        Throwable th3 = (Throwable) null;
        while (th2 != null && th2 != th3) {
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                h.a((Object) stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                h.a((Object) className, "element.className");
                if (l.a(className, "com.facebook", false, 2, (Object) null)) {
                    return true;
                }
            }
            Throwable th4 = th2;
            th2 = th2.getCause();
            th3 = th4;
        }
        return false;
    }

    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility$listExceptionAnalysisReportFiles$reports$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                h.a((Object) str, "name");
                kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f6973a;
                Object[] objArr = {InstrumentUtility.ANALYSIS_REPORT_PREFIX};
                String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(objArr, objArr.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                return new Regex(format).a(str);
            }
        });
        return listFiles != null ? listFiles : new File[0];
    }

    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility$listExceptionReportFiles$reports$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                h.a((Object) str, "name");
                kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f6973a;
                Object[] objArr = {InstrumentUtility.CRASH_REPORT_PREFIX, InstrumentUtility.CRASH_SHIELD_PREFIX, InstrumentUtility.THREAD_CHECK_PREFIX};
                String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(objArr, objArr.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                return new Regex(format).a(str);
            }
        });
        return listFiles != null ? listFiles : new File[0];
    }

    public static final JSONObject readFile(String str, boolean z) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return null;
        }
        try {
            return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
        } catch (Exception unused) {
            if (z) {
                deleteFile(str);
            }
            return null;
        }
    }

    public static final void writeFile(String str, String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
            byte[] bytes = str2.getBytes(d.f6980a);
            h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public static final boolean deleteFile(String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    public static final void sendReports(String str, JSONArray jSONArray, GraphRequest.Callback callback) {
        h.b(jSONArray, "reports");
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f6973a;
            Object[] objArr = {FacebookSdk.getApplicationId()};
            String format = String.format("%s/instruments", Arrays.copyOf(objArr, objArr.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            GraphRequest.newPostRequest(null, format, jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    public static final File getInstrumentReportDir() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        h.a((Object) applicationContext, "FacebookSdk.getApplicationContext()");
        File file = new File(applicationContext.getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
