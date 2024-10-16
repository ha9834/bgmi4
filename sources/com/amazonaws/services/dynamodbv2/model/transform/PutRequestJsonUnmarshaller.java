package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes.dex */
class PutRequestJsonUnmarshaller implements Unmarshaller<PutRequest, JsonUnmarshallerContext> {
    private static PutRequestJsonUnmarshaller instance;

    PutRequestJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public PutRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        PutRequest putRequest = new PutRequest();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Item")) {
                putRequest.setItem(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return putRequest;
    }

    public static PutRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PutRequestJsonUnmarshaller();
        }
        return instance;
    }
}
