package com.facebook.internal.instrument.errorreport;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ErrorReportData {
    public static final Companion Companion = new Companion(null);
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PRARAM_ERROR_MESSAGE = "error_message";
    private String errorMessage;
    private String filename;
    private Long timestamp;

    public ErrorReportData(String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        Long l = this.timestamp;
        if (l == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        stringBuffer.append(l.longValue());
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        h.a((Object) stringBuffer2, "StringBuffer()\n         …)\n            .toString()");
        this.filename = stringBuffer2;
    }

    public ErrorReportData(File file) {
        h.b(file, TransferTable.COLUMN_FILE);
        String name = file.getName();
        h.a((Object) name, "file.name");
        this.filename = name;
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0L));
            this.errorMessage = readFile.optString("error_message", null);
        }
    }

    public final int compareTo(ErrorReportData errorReportData) {
        h.b(errorReportData, "data");
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        long longValue = l.longValue();
        Long l2 = errorReportData.timestamp;
        if (l2 != null) {
            return (l2.longValue() > longValue ? 1 : (l2.longValue() == longValue ? 0 : -1));
        }
        return 1;
    }

    public final boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public final void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return super.toString();
        }
        String jSONObject = parameters.toString();
        h.a((Object) jSONObject, "params.toString()");
        return jSONObject;
    }

    public final JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put("timestamp", l.longValue());
            }
            jSONObject.put("error_message", this.errorMessage);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }
}
