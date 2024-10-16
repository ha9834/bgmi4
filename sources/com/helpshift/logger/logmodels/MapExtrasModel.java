package com.helpshift.logger.logmodels;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class MapExtrasModel implements ILogExtrasModel {
    private String key;
    private Map value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapExtrasModel(String str, Map map) {
        this.key = str;
        this.value = map;
    }

    @Override // com.helpshift.logger.logmodels.ILogExtrasModel
    public String getConsoleLoggingMessage() {
        Map map = this.value;
        if (map == null) {
            return this.key + " : " + this.value;
        }
        return this.key + " : " + new JSONObject(map).toString();
    }

    @Override // com.helpshift.logger.logmodels.ILogExtrasModel
    public Object toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.key, this.value == null ? "" : this.value.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
