package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class CreateTableRequest extends AmazonWebServiceRequest implements Serializable {
    private List<AttributeDefinition> attributeDefinitions;
    private List<GlobalSecondaryIndex> globalSecondaryIndexes;
    private List<KeySchemaElement> keySchema;
    private List<LocalSecondaryIndex> localSecondaryIndexes;
    private ProvisionedThroughput provisionedThroughput;
    private StreamSpecification streamSpecification;
    private String tableName;

    public CreateTableRequest() {
    }

    public CreateTableRequest(String str, List<KeySchemaElement> list) {
        setTableName(str);
        setKeySchema(list);
    }

    public CreateTableRequest(List<AttributeDefinition> list, String str, List<KeySchemaElement> list2, ProvisionedThroughput provisionedThroughput) {
        setAttributeDefinitions(list);
        setTableName(str);
        setKeySchema(list2);
        setProvisionedThroughput(provisionedThroughput);
    }

    public List<AttributeDefinition> getAttributeDefinitions() {
        return this.attributeDefinitions;
    }

    public void setAttributeDefinitions(Collection<AttributeDefinition> collection) {
        if (collection == null) {
            this.attributeDefinitions = null;
        } else {
            this.attributeDefinitions = new ArrayList(collection);
        }
    }

    public CreateTableRequest withAttributeDefinitions(AttributeDefinition... attributeDefinitionArr) {
        if (getAttributeDefinitions() == null) {
            this.attributeDefinitions = new ArrayList(attributeDefinitionArr.length);
        }
        for (AttributeDefinition attributeDefinition : attributeDefinitionArr) {
            this.attributeDefinitions.add(attributeDefinition);
        }
        return this;
    }

    public CreateTableRequest withAttributeDefinitions(Collection<AttributeDefinition> collection) {
        setAttributeDefinitions(collection);
        return this;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public CreateTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public List<KeySchemaElement> getKeySchema() {
        return this.keySchema;
    }

    public void setKeySchema(Collection<KeySchemaElement> collection) {
        if (collection == null) {
            this.keySchema = null;
        } else {
            this.keySchema = new ArrayList(collection);
        }
    }

    public CreateTableRequest withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement keySchemaElement : keySchemaElementArr) {
            this.keySchema.add(keySchemaElement);
        }
        return this;
    }

    public CreateTableRequest withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public List<LocalSecondaryIndex> getLocalSecondaryIndexes() {
        return this.localSecondaryIndexes;
    }

    public void setLocalSecondaryIndexes(Collection<LocalSecondaryIndex> collection) {
        if (collection == null) {
            this.localSecondaryIndexes = null;
        } else {
            this.localSecondaryIndexes = new ArrayList(collection);
        }
    }

    public CreateTableRequest withLocalSecondaryIndexes(LocalSecondaryIndex... localSecondaryIndexArr) {
        if (getLocalSecondaryIndexes() == null) {
            this.localSecondaryIndexes = new ArrayList(localSecondaryIndexArr.length);
        }
        for (LocalSecondaryIndex localSecondaryIndex : localSecondaryIndexArr) {
            this.localSecondaryIndexes.add(localSecondaryIndex);
        }
        return this;
    }

    public CreateTableRequest withLocalSecondaryIndexes(Collection<LocalSecondaryIndex> collection) {
        setLocalSecondaryIndexes(collection);
        return this;
    }

    public List<GlobalSecondaryIndex> getGlobalSecondaryIndexes() {
        return this.globalSecondaryIndexes;
    }

    public void setGlobalSecondaryIndexes(Collection<GlobalSecondaryIndex> collection) {
        if (collection == null) {
            this.globalSecondaryIndexes = null;
        } else {
            this.globalSecondaryIndexes = new ArrayList(collection);
        }
    }

    public CreateTableRequest withGlobalSecondaryIndexes(GlobalSecondaryIndex... globalSecondaryIndexArr) {
        if (getGlobalSecondaryIndexes() == null) {
            this.globalSecondaryIndexes = new ArrayList(globalSecondaryIndexArr.length);
        }
        for (GlobalSecondaryIndex globalSecondaryIndex : globalSecondaryIndexArr) {
            this.globalSecondaryIndexes.add(globalSecondaryIndex);
        }
        return this;
    }

    public CreateTableRequest withGlobalSecondaryIndexes(Collection<GlobalSecondaryIndex> collection) {
        setGlobalSecondaryIndexes(collection);
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
    }

    public CreateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    public StreamSpecification getStreamSpecification() {
        return this.streamSpecification;
    }

    public void setStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
    }

    public CreateTableRequest withStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAttributeDefinitions() != null) {
            sb.append("AttributeDefinitions: " + getAttributeDefinitions() + ",");
        }
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getKeySchema() != null) {
            sb.append("KeySchema: " + getKeySchema() + ",");
        }
        if (getLocalSecondaryIndexes() != null) {
            sb.append("LocalSecondaryIndexes: " + getLocalSecondaryIndexes() + ",");
        }
        if (getGlobalSecondaryIndexes() != null) {
            sb.append("GlobalSecondaryIndexes: " + getGlobalSecondaryIndexes() + ",");
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + ",");
        }
        if (getStreamSpecification() != null) {
            sb.append("StreamSpecification: " + getStreamSpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((getAttributeDefinitions() == null ? 0 : getAttributeDefinitions().hashCode()) + 31) * 31) + (getTableName() == null ? 0 : getTableName().hashCode())) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode())) * 31) + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode())) * 31) + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode())) * 31) + (getStreamSpecification() != null ? getStreamSpecification().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateTableRequest)) {
            return false;
        }
        CreateTableRequest createTableRequest = (CreateTableRequest) obj;
        if ((createTableRequest.getAttributeDefinitions() == null) ^ (getAttributeDefinitions() == null)) {
            return false;
        }
        if (createTableRequest.getAttributeDefinitions() != null && !createTableRequest.getAttributeDefinitions().equals(getAttributeDefinitions())) {
            return false;
        }
        if ((createTableRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (createTableRequest.getTableName() != null && !createTableRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((createTableRequest.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (createTableRequest.getKeySchema() != null && !createTableRequest.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((createTableRequest.getLocalSecondaryIndexes() == null) ^ (getLocalSecondaryIndexes() == null)) {
            return false;
        }
        if (createTableRequest.getLocalSecondaryIndexes() != null && !createTableRequest.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes())) {
            return false;
        }
        if ((createTableRequest.getGlobalSecondaryIndexes() == null) ^ (getGlobalSecondaryIndexes() == null)) {
            return false;
        }
        if (createTableRequest.getGlobalSecondaryIndexes() != null && !createTableRequest.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes())) {
            return false;
        }
        if ((createTableRequest.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        if (createTableRequest.getProvisionedThroughput() != null && !createTableRequest.getProvisionedThroughput().equals(getProvisionedThroughput())) {
            return false;
        }
        if ((createTableRequest.getStreamSpecification() == null) ^ (getStreamSpecification() == null)) {
            return false;
        }
        return createTableRequest.getStreamSpecification() == null || createTableRequest.getStreamSpecification().equals(getStreamSpecification());
    }
}
