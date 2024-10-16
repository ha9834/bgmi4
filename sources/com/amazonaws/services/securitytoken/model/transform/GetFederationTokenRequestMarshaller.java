package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class GetFederationTokenRequestMarshaller implements Marshaller<Request<GetFederationTokenRequest>, GetFederationTokenRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetFederationTokenRequest> marshall(GetFederationTokenRequest getFederationTokenRequest) {
        if (getFederationTokenRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GetFederationTokenRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(getFederationTokenRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter(JsonDocumentFields.ACTION, "GetFederationToken");
        defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
        if (getFederationTokenRequest.getName() != null) {
            defaultRequest.addParameter("Name", StringUtils.fromString(getFederationTokenRequest.getName()));
        }
        if (getFederationTokenRequest.getPolicy() != null) {
            defaultRequest.addParameter("Policy", StringUtils.fromString(getFederationTokenRequest.getPolicy()));
        }
        if (getFederationTokenRequest.getDurationSeconds() != null) {
            defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(getFederationTokenRequest.getDurationSeconds()));
        }
        return defaultRequest;
    }
}
