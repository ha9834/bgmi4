package com.tencent.imsdk.android.tools.log;

import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.T;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public final class IMLogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    private static final String DEFAULT_TAG = "iMSDK";
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final int JSON_INDENT = 2;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static int mConfigLevel = -1;
    protected static int mLoggerLevel = 3;
    private static int mMetaLogLevel = -1;
    private static LoggerImpl mLoggerImpl = new LoggerImpl();
    private static List<String> mDeclaredMethods = new ArrayList();

    private IMLogger() {
    }

    public static void setLoggerLevel(int i) {
        try {
            if (T.mGlobalActivityUpToDate != null) {
                File externalCacheDir = T.mGlobalActivityUpToDate.getExternalCacheDir();
                if (externalCacheDir.exists()) {
                    if (new File(externalCacheDir.getPath() + "/imsdk.tag").exists()) {
                        Log.w("iMSDK", "Get debug cache flag file, will set log level to DEBUG");
                        mLoggerLevel = 3;
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (i >= 2 && i <= 7) {
            mLoggerLevel = i;
            return;
        }
        Log.e("iMSDK", "iMSDK log level error, check your IMSDK_LOG_LEVEL in AndroidManifest.xml. it should be between 2(VERBOSE) and 7(ASSERT)");
        Log.w("iMSDK", "use log level DEBUG(3) for default");
        mLoggerLevel = 3;
    }

    private static boolean checkCallStack() {
        if (mLoggerLevel >= 3) {
            return true;
        }
        try {
            if (mDeclaredMethods == null) {
                mDeclaredMethods = new ArrayList();
            }
            if (mDeclaredMethods.size() <= 0) {
                for (Method method : IMLogger.class.getDeclaredMethods()) {
                    mDeclaredMethods.add(method.getName());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getClassName().equals(IMLogger.class.getName()) && mDeclaredMethods != null && mDeclaredMethods.contains(stackTraceElement.getMethodName())) {
                    String concat = stackTraceElement.getMethodName().concat(String.valueOf(stackTraceElement.getLineNumber()));
                    if (arrayList.contains(concat)) {
                        try {
                            throw new Exception(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + " function in call cycle");
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    arrayList.add(concat);
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLoggable(int i) {
        if (!checkCallStack()) {
            return false;
        }
        mConfigLevel = IMSDKConfig.getOrDefault(IR.meta.LOG_LEVEL, -1);
        int i2 = mConfigLevel;
        if (i2 != -1) {
            setLoggerLevel(i2);
        } else {
            if (mMetaLogLevel == -1 && T.mGlobalActivityUpToDate != null) {
                mMetaLogLevel = T.Meta.readFromApplication(T.mGlobalActivityUpToDate, IR.meta.LOG_LEVEL, -1);
            }
            int i3 = mMetaLogLevel;
            if (i3 != -1) {
                setLoggerLevel(i3);
            } else {
                setLoggerLevel(3);
            }
        }
        return mLoggerLevel <= i;
    }

    public static void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            mLoggerImpl.d(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            mLoggerImpl.d(str, objArr);
        }
    }

    public static void d(Object obj) {
        String obj2;
        if (isLoggable(3)) {
            if (obj == null) {
                obj2 = "Warning : object is Null";
            } else if (obj.getClass().isArray() && (obj instanceof Object[])) {
                obj2 = Arrays.deepToString((Object[]) obj);
            } else {
                obj2 = obj.toString();
            }
            mLoggerImpl.d(obj2);
        }
    }

    public static void e(String str, Object... objArr) {
        if (isLoggable(6)) {
            mLoggerImpl.e(str, objArr);
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        if (isLoggable(6)) {
            mLoggerImpl.e(str, th, objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (isLoggable(4)) {
            mLoggerImpl.i(str, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (isLoggable(5)) {
            mLoggerImpl.w(str, objArr);
        }
    }

    public static void json(String str) {
        if (isLoggable(3)) {
            if (str == null || str.length() == 0) {
                d("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    d(new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    d(new JSONArray(trim).toString(2));
                } else {
                    e("Invalid Json", new Object[0]);
                }
            } catch (JSONException unused) {
                e("Invalid Json", new Object[0]);
            } catch (Exception e) {
                e(e.getMessage(), new Object[0]);
            }
        }
    }

    public static void xml(String str) {
        if (isLoggable(3)) {
            if (str == null || str.length() == 0) {
                d("Empty/Null xml content");
                return;
            }
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                newTransformer.transform(streamSource, streamResult);
                d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
            } catch (TransformerException unused) {
                e("Invalid xml", new Object[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    static class MarkerLog {
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private final List<Marker> mMarkers = new ArrayList();
        private boolean mFinished = false;

        MarkerLog() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        public synchronized void add(String str, long j) {
            if (IMLogger.isLoggable(3)) {
                if (this.mFinished) {
                    throw new IllegalStateException("Marker added to finished log");
                }
                this.mMarkers.add(new Marker(str, j, SystemClock.elapsedRealtime()));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized void finish(String str) {
            this.mFinished = true;
            long totalDuration = getTotalDuration();
            if (totalDuration <= 0) {
                return;
            }
            long j = this.mMarkers.get(0).time;
            IMLogger.d("(%-4d ms) %s", Long.valueOf(totalDuration), str);
            for (Marker marker : this.mMarkers) {
                long j2 = marker.time;
                IMLogger.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(marker.thread), marker.name);
                j = j2;
            }
        }

        protected synchronized void finalize() throws Throwable {
            if (!this.mFinished) {
                finish("Request on the loose");
                IMLogger.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() == 0) {
                return 0L;
            }
            return this.mMarkers.get(r2.size() - 1).time - this.mMarkers.get(0).time;
        }
    }
}
