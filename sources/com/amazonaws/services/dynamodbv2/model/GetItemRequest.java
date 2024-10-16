package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GetItemRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> attributesToGet;
    private Boolean consistentRead;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> key;
    private String projectionExpression;
    private String returnConsumedCapacity;
    private String tableName;

    public GetItemRequest() {
    }

    public GetItemRequest(String str, Map<String, AttributeValue> map) {
        setTableName(str);
        setKey(map);
    }

    public GetItemRequest(String str, Map<String, AttributeValue> map, Boolean bool) {
        setTableName(str);
        setKey(map);
        setConsistentRead(bool);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public GetItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public Map<String, AttributeValue> getKey() {
        return this.key;
    }

    public void setKey(Map<String, AttributeValue> map) {
        this.key = map;
    }

    public GetItemRequest withKey(Map<String, AttributeValue> map) {
        this.key = map;
        return this;
    }

    public GetItemRequest addKeyEntry(String str, AttributeValue attributeValue) {
        if (this.key == null) {
            this.key = new HashMap();
        }
        if (this.key.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.key.put(str, attributeValue);
        return this;
    }

    public GetItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            this.attributesToGet = new ArrayList(collection);
        }
    }

    public GetItemRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.attributesToGet.add(str);
        }
        return this;
    }

    public GetItemRequest withAttributesToGet(Collection<String> collection) {
        setAttributesToGet(collection);
        return this;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public void setConsistentRead(Boolean bool) {
        this.consistentRead = bool;
    }

    public GetItemRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public GetItemRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
    }

    public GetItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
        return this;
    }

    public String getProjectionExpression() {
        return this.projectionExpression;
    }

    public void setProjectionExpression(String str) {
        this.projectionExpression = str;
    }

    public GetItemRequest withProjectionExpression(String str) {
        this.projectionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public GetItemRequest withExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
        return this;
    }

    public GetItemRequest addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (this.expressionAttributeNames.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.expressionAttributeNames.put(str, str2);
        return this;
    }

    public GetItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getKey() != null) {
            sb.append("Key: " + getKey() + ",");
        }
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getConsistentRead() != null) {
            sb.append("ConsistentRead: " + getConsistentRead() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        }
        if (getProjectionExpression() != null) {
            sb.append("ProjectionExpression: " + getProjectionExpression() + ",");
        }
        if (getExpressionAttributeNames() != null) {
            sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getKey() == null ? 0 : getKey().hashCode())) * 31) + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode())) * 31) + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode())) * 31) + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode())) * 31) + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode())) * 31) + (getExpressionAttributeNames() != null ? getExpressionAttributeNames().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetItemRequest)) {
            return false;
        }
        GetItemRequest getItemRequest = (GetItemRequest) obj;
        if ((getItemRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (getItemRequest.getTableName() != null && !getItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((getItemRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (getItemRequest.getKey() != null && !getItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((getItemRequest.getAttributesToGet() == null) ^ (getAttributesToGet() == null)) {
            return false;
        }
        if (getItemRequest.getAttributesToGet() != null && !getItemRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if ((getItemRequest.getConsistentRead() == null) ^ (getConsistentRead() == null)) {
            return false;
        }
        if (getItemRequest.getConsistentRead() != null && !getItemRequest.getConsistentRead().equals(getConsistentRead())) {
            return false;
        }
        if ((getItemRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (getItemRequest.getReturnConsumedCapacity() != null && !getItemRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if ((getItemRequest.getProjectionExpression() == null) ^ (getProjectionExpression() == null)) {
            return false;
        }
        if (getItemRequest.getProjectionExpression() != null && !getItemRequest.getProjectionExpression().equals(getProjectionExpression())) {
            return false;
        }
        if ((getItemRequest.getExpressionAttributeNames() == null) ^ (getExpressionAttributeNames() == null)) {
            return false;
        }
        return getItemRequest.getExpressionAttributeNames() == null || getItemRequest.getExpressionAttributeNames().equals(getExpressionAttributeNames());
    }
}
