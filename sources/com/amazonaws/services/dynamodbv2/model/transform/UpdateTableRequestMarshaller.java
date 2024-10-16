package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes.dex */
public class UpdateTableRequestMarshaller implements Marshaller<Request<UpdateTableRequest>, UpdateTableRequest> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateTableRequest> marshall(UpdateTableRequest updateTableRequest) {
        if (updateTableRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateTableRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateTableRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.UpdateTable");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateTableRequest.getAttributeDefinitions() != null) {
                List<AttributeDefinition> attributeDefinitions = updateTableRequest.getAttributeDefinitions();
                jsonWriter.name("AttributeDefinitions");
                jsonWriter.beginArray();
                for (AttributeDefinition attributeDefinition : attributeDefinitions) {
                    if (attributeDefinition != null) {
                        AttributeDefinitionJsonMarshaller.getInstance().marshall(attributeDefinition, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateTableRequest.getTableName() != null) {
                String tableName = updateTableRequest.getTableName();
                jsonWriter.name("TableName");
                jsonWriter.value(tableName);
            }
            if (updateTableRequest.getProvisionedThroughput() != null) {
                ProvisionedThroughput provisionedThroughput = updateTableRequest.getProvisionedThroughput();
                jsonWriter.name("ProvisionedThroughput");
                ProvisionedThroughputJsonMarshaller.getInstance().marshall(provisionedThroughput, jsonWriter);
            }
            if (updateTableRequest.getGlobalSecondaryIndexUpdates() != null) {
                List<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates = updateTableRequest.getGlobalSecondaryIndexUpdates();
                jsonWriter.name("GlobalSecondaryIndexUpdates");
                jsonWriter.beginArray();
                for (GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate : globalSecondaryIndexUpdates) {
                    if (globalSecondaryIndexUpdate != null) {
                        GlobalSecondaryIndexUpdateJsonMarshaller.getInstance().marshall(globalSecondaryIndexUpdate, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateTableRequest.getStreamSpecification() != null) {
                StreamSpecification streamSpecification = updateTableRequest.getStreamSpecification();
                jsonWriter.name("StreamSpecification");
                StreamSpecificationJsonMarshaller.getInstance().marshall(streamSpecification, jsonWriter);
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String stringWriter2 = stringWriter.toString();
            byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(stringWriter2));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
