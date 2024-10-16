package com.helpshift.logger.logmodels;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class StringExtrasModel implements ILogExtrasModel {
    private String key;
    private String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringExtrasModel(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    @Override // com.helpshift.logger.logmodels.ILogExtrasModel
    public String getConsoleLoggingMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append(" : ");
        String str = this.value;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.helpshift.logger.logmodels.ILogExtrasModel
    public Object toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.key, this.value == null ? "" : this.value);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
