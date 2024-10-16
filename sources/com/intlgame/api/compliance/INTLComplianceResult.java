package com.intlgame.api.compliance;

import com.intlgame.api.INTLResult;
import com.intlgame.tools.json.JsonProp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class INTLComplianceResult extends INTLResult {

    @JsonProp("adult_age_")
    public int adult_age_;

    @JsonProp("adult_status_")
    public int adult_status_;

    @JsonProp("adult_status_expiration_")
    public String adult_status_expiration_;

    @JsonProp("certificate_type_")
    public int certificate_type_;

    @JsonProp("country_code_")
    public String country_code_;

    @JsonProp("eu_user_agree_status_")
    public int eu_user_agree_status_;

    @JsonProp("game_grade_")
    public int game_grade_;

    @JsonProp("is_eea_")
    public String is_eea_;

    @JsonProp("parent_certificate_status_")
    public int parent_certificate_status_;

    @JsonProp("parent_certificate_status_expiration_")
    public String parent_certificate_status_expiration_;

    @JsonProp("region_")
    public String region_;

    @JsonProp("ts_")
    public String ts_;

    public INTLComplianceResult() {
    }

    public INTLComplianceResult(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public INTLComplianceResult(String str) throws JSONException {
        super(str);
    }

    public INTLComplianceResult(int i, int i2) {
        super(i, i2);
    }

    public INTLComplianceResult(int i, int i2, int i3, String str) {
        super(i, i2, i3, str);
    }

    public INTLComplianceResult(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public INTLComplianceResult(int i, int i2, String str, int i3, String str2) {
        super(i, i2, str, i3, str2);
    }

    @Override // com.intlgame.api.INTLResult
    public String toString() {
        return " INTLComplianceResult{adult_status_=" + this.adult_status_ + "', parent_certificate_status_expiration_=" + this.parent_certificate_status_expiration_ + "', parent_certificate_status_=" + this.parent_certificate_status_ + "', eu_user_agree_status_='" + this.eu_user_agree_status_ + "', country_code_=" + this.country_code_ + "', adult_age_='" + this.adult_age_ + "', game_grade_='" + this.game_grade_ + "', certificate_type_='" + this.certificate_type_ + "', adult_status_expiration_='" + this.adult_status_expiration_ + "', ts_='" + this.ts_ + "', region_='" + this.region_ + "', is_eea_='" + this.is_eea_ + "'}";
    }
}
