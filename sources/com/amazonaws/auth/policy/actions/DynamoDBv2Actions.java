package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

/* loaded from: classes.dex */
public enum DynamoDBv2Actions implements Action {
    AllDynamoDBv2Actions("dynamodb:*"),
    BatchGetItem("dynamodb:BatchGetItem"),
    BatchWriteItem("dynamodb:BatchWriteItem"),
    CreateTable("dynamodb:CreateTable"),
    DeleteItem("dynamodb:DeleteItem"),
    DeleteTable("dynamodb:DeleteTable"),
    DescribeLimits("dynamodb:DescribeLimits"),
    DescribeTable("dynamodb:DescribeTable"),
    GetItem("dynamodb:GetItem"),
    ListTables("dynamodb:ListTables"),
    PutItem("dynamodb:PutItem"),
    Query("dynamodb:Query"),
    Scan("dynamodb:Scan"),
    UpdateItem("dynamodb:UpdateItem"),
    UpdateTable("dynamodb:UpdateTable");

    private final String action;

    DynamoDBv2Actions(String str) {
        this.action = str;
    }

    @Override // com.amazonaws.auth.policy.Action
    public String getActionName() {
        return this.action;
    }
}
