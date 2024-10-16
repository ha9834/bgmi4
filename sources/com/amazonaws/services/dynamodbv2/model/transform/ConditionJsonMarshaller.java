package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

/* loaded from: classes.dex */
class ConditionJsonMarshaller {
    private static ConditionJsonMarshaller instance;

    ConditionJsonMarshaller() {
    }

    public void marshall(Condition condition, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (condition.getAttributeValueList() != null) {
            List<AttributeValue> attributeValueList = condition.getAttributeValueList();
            awsJsonWriter.name("AttributeValueList");
            awsJsonWriter.beginArray();
            for (AttributeValue attributeValue : attributeValueList) {
                if (attributeValue != null) {
                    AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (condition.getComparisonOperator() != null) {
            String comparisonOperator = condition.getComparisonOperator();
            awsJsonWriter.name("ComparisonOperator");
            awsJsonWriter.value(comparisonOperator);
        }
        awsJsonWriter.endObject();
    }

    public static ConditionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ConditionJsonMarshaller();
        }
        return instance;
    }
}
