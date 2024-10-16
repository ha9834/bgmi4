package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class UpdateTableResult implements Serializable {
    private TableDescription tableDescription;

    public TableDescription getTableDescription() {
        return this.tableDescription;
    }

    public void setTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
    }

    public UpdateTableResult withTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTableDescription() != null) {
            sb.append("TableDescription: " + getTableDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTableDescription() == null ? 0 : getTableDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTableResult)) {
            return false;
        }
        UpdateTableResult updateTableResult = (UpdateTableResult) obj;
        if ((updateTableResult.getTableDescription() == null) ^ (getTableDescription() == null)) {
            return false;
        }
        return updateTableResult.getTableDescription() == null || updateTableResult.getTableDescription().equals(getTableDescription());
    }
}
