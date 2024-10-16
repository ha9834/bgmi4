package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes.dex */
class DeleteRequestJsonUnmarshaller implements Unmarshaller<DeleteRequest, JsonUnmarshallerContext> {
    private static DeleteRequestJsonUnmarshaller instance;

    DeleteRequestJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public DeleteRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        DeleteRequest deleteRequest = new DeleteRequest();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Key")) {
                deleteRequest.setKey(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deleteRequest;
    }

    public static DeleteRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteRequestJsonUnmarshaller();
        }
        return instance;
    }
}
