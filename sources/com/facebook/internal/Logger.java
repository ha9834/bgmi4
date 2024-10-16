package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority;
    private final String tag;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();

    public static final void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        Companion.log(loggingBehavior, i, str, str2);
    }

    public static final void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, i, str, str2, objArr);
    }

    public static final void log(LoggingBehavior loggingBehavior, String str, String str2) {
        Companion.log(loggingBehavior, str, str2);
    }

    public static final void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, str, str2, objArr);
    }

    public static final synchronized void registerAccessToken(String str) {
        synchronized (Logger.class) {
            Companion.registerAccessToken(str);
        }
    }

    public static final synchronized void registerStringToReplace(String str, String str2) {
        synchronized (Logger.class) {
            Companion.registerStringToReplace(str, str2);
        }
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        h.b(loggingBehavior, "behavior");
        h.b(str, ViewHierarchyConstants.TAG_KEY);
        this.priority = 3;
        Validate.notNullOrEmpty(str, ViewHierarchyConstants.TAG_KEY);
        this.behavior = loggingBehavior;
        this.tag = LOG_TAG_BASE + str;
        this.contents = new StringBuilder();
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        Validate.oneOf(Integer.valueOf(i), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i);
    }

    public final String getContents() {
        Companion companion = Companion;
        String sb = this.contents.toString();
        h.a((Object) sb, "contents.toString()");
        return companion.replaceStrings(sb);
    }

    public final void log() {
        String sb = this.contents.toString();
        h.a((Object) sb, "contents.toString()");
        logString(sb);
        this.contents = new StringBuilder();
    }

    public final void logString(String str) {
        h.b(str, "string");
        Companion.log(this.behavior, this.priority, this.tag, str);
    }

    public final void append(StringBuilder sb) {
        h.b(sb, "stringBuilder");
        if (shouldLog()) {
            this.contents.append((CharSequence) sb);
        }
    }

    public final void append(String str) {
        h.b(str, "string");
        if (shouldLog()) {
            this.contents.append(str);
        }
    }

    public final void append(String str, Object... objArr) {
        h.b(str, "format");
        h.b(objArr, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            l lVar = l.f6973a;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            h.a((Object) format, "java.lang.String.format(format, *args)");
            sb.append(format);
        }
    }

    public final void appendKeyValue(String str, Object obj) {
        h.b(str, "key");
        h.b(obj, "value");
        append("  %s:\t%s\n", str, obj);
    }

    private final boolean shouldLog() {
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final synchronized void registerStringToReplace(String str, String str2) {
            h.b(str, "original");
            h.b(str2, "replace");
            Logger.stringsToReplace.put(str, str2);
        }

        public final synchronized void registerAccessToken(String str) {
            h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
        }

        public final void log(LoggingBehavior loggingBehavior, String str, String str2) {
            h.b(loggingBehavior, "behavior");
            h.b(str, ViewHierarchyConstants.TAG_KEY);
            h.b(str2, "string");
            log(loggingBehavior, 3, str, str2);
        }

        public final void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
            h.b(loggingBehavior, "behavior");
            h.b(str, ViewHierarchyConstants.TAG_KEY);
            h.b(str2, "format");
            h.b(objArr, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                l lVar = l.f6973a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, 3, str, format);
            }
        }

        public final void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
            h.b(loggingBehavior, "behavior");
            h.b(str, ViewHierarchyConstants.TAG_KEY);
            h.b(str2, "format");
            h.b(objArr, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                l lVar = l.f6973a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                h.a((Object) format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, i, str, format);
            }
        }

        public final void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
            h.b(loggingBehavior, "behavior");
            h.b(str, ViewHierarchyConstants.TAG_KEY);
            h.b(str2, "string");
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                String replaceStrings = replaceStrings(str2);
                if (!kotlin.text.l.a(str, Logger.LOG_TAG_BASE, false, 2, (Object) null)) {
                    str = Logger.LOG_TAG_BASE + str;
                }
                Log.println(i, str, replaceStrings);
                if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final synchronized String replaceStrings(String str) {
            String str2;
            str2 = str;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                str2 = kotlin.text.l.a(str2, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
            }
            return str2;
        }
    }
}
