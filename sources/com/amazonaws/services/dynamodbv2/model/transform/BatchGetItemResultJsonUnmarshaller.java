package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes.dex */
public class BatchGetItemResultJsonUnmarshaller implements Unmarshaller<BatchGetItemResult, JsonUnmarshallerContext> {
    private static BatchGetItemResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public BatchGetItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        BatchGetItemResult batchGetItemResult = new BatchGetItemResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Responses")) {
                batchGetItemResult.setResponses(new MapUnmarshaller(new ListUnmarshaller(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()))).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("UnprocessedKeys")) {
                batchGetItemResult.setUnprocessedKeys(new MapUnmarshaller(KeysAndAttributesJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                batchGetItemResult.setConsumedCapacity(new ListUnmarshaller(ConsumedCapacityJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return batchGetItemResult;
    }

    public static BatchGetItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BatchGetItemResultJsonUnmarshaller();
        }
        return instance;
    }
}
