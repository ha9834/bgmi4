package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class AssumeRoleRequestMarshaller implements Marshaller<Request<AssumeRoleRequest>, AssumeRoleRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AssumeRoleRequest> marshall(AssumeRoleRequest assumeRoleRequest) {
        if (assumeRoleRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AssumeRoleRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(assumeRoleRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter(JsonDocumentFields.ACTION, "AssumeRole");
        defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
        if (assumeRoleRequest.getRoleArn() != null) {
            defaultRequest.addParameter("RoleArn", StringUtils.fromString(assumeRoleRequest.getRoleArn()));
        }
        if (assumeRoleRequest.getRoleSessionName() != null) {
            defaultRequest.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleRequest.getRoleSessionName()));
        }
        if (assumeRoleRequest.getPolicy() != null) {
            defaultRequest.addParameter("Policy", StringUtils.fromString(assumeRoleRequest.getPolicy()));
        }
        if (assumeRoleRequest.getDurationSeconds() != null) {
            defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleRequest.getDurationSeconds()));
        }
        if (assumeRoleRequest.getExternalId() != null) {
            defaultRequest.addParameter("ExternalId", StringUtils.fromString(assumeRoleRequest.getExternalId()));
        }
        if (assumeRoleRequest.getSerialNumber() != null) {
            defaultRequest.addParameter("SerialNumber", StringUtils.fromString(assumeRoleRequest.getSerialNumber()));
        }
        if (assumeRoleRequest.getTokenCode() != null) {
            defaultRequest.addParameter("TokenCode", StringUtils.fromString(assumeRoleRequest.getTokenCode()));
        }
        return defaultRequest;
    }
}
