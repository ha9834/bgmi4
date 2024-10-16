package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes.dex */
public class PutItemResultJsonUnmarshaller implements Unmarshaller<PutItemResult, JsonUnmarshallerContext> {
    private static PutItemResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public PutItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        PutItemResult putItemResult = new PutItemResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Attributes")) {
                putItemResult.setAttributes(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                putItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCollectionMetrics")) {
                putItemResult.setItemCollectionMetrics(ItemCollectionMetricsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return putItemResult;
    }

    public static PutItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PutItemResultJsonUnmarshaller();
        }
        return instance;
    }
}
