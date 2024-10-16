package com.tencent.ieg.gpc.globalization.ggaws;

import android.content.Context;
import com.amazonaws.auth.AWSAbstractCognitoDeveloperIdentityProvider;
import com.amazonaws.regions.Regions;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tencent.ieg.gpc.globalization.base.GGConfig;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploader;
import com.tencent.ieg.gpc.globalization.utils.GGLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DeveloperAuthenticationProvider extends AWSAbstractCognitoDeveloperIdentityProvider {
    private static final String AWS_DEVELOPER_PROVIDER_SERVER = "AWS_DEVELOPER_PROVIDER_SERVER";
    private static final String DEVELOPER_PROVIDER = "DEVELOPER_PROVIDER";
    private Context activityContext;
    private String m_identityId;

    public DeveloperAuthenticationProvider(String str, String str2, Regions regions, Context context) {
        super(str, str2, regions);
        this.activityContext = null;
        this.m_identityId = "";
        this.activityContext = context;
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoDeveloperIdentityProvider, com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
    public String getProviderName() {
        return GGConfig.getConfig(DEVELOPER_PROVIDER);
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider, com.amazonaws.auth.AWSIdentityProvider
    public String refresh() {
        setToken(null);
        requestAuthorData();
        return this.token;
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider, com.amazonaws.auth.AWSCognitoIdentityProvider
    public String getIdentityId() {
        this.identityId = this.m_identityId;
        if (this.identityId == null) {
            GGLog.d("DeveloperAuthenticationProvider", "getIdentityId is null and try to get from server!");
            requestAuthorData();
        }
        return this.identityId;
    }

    private void requestAuthorData() {
        RequestFuture newFuture = RequestFuture.newFuture();
        Volley.newRequestQueue(this.activityContext).add(new StringRequest(GGConfig.getConfig(AWS_DEVELOPER_PROVIDER_SERVER), newFuture, newFuture) { // from class: com.tencent.ieg.gpc.globalization.ggaws.DeveloperAuthenticationProvider.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.android.volley.Request
            public Map<String, String> getParams() throws AuthFailureError {
                if (GGUploader.authorData == null) {
                    return super.getParams();
                }
                return GGUploader.authorData;
            }
        });
        try {
            JSONObject jSONObject = new JSONObject(newFuture.get().toString());
            if (jSONObject.has("Ret") && jSONObject.getInt("Ret") == 0) {
                if (jSONObject.has("IdentityId")) {
                    String string = jSONObject.getString("IdentityId");
                    this.identityId = string;
                    this.m_identityId = string;
                } else {
                    GGLog.d("DeveloperAuthenticationProvider", "IdentityId not exist!");
                }
                if (jSONObject.has("Token")) {
                    this.token = jSONObject.getString("Token");
                } else {
                    GGLog.d("DeveloperAuthenticationProvider", "Token not exist!");
                }
                GGLog.d("DeveloperAuthenticationProvider", "identityId=" + this.identityId + " token=" + this.token);
                update(this.identityId, this.token);
                return;
            }
            GGLog.d("DeveloperAuthenticationProvider", "upload author fail");
        } catch (Exception e) {
            GGLog.d("DeveloperAuthenticationProvider", e.getMessage());
        }
    }
}
