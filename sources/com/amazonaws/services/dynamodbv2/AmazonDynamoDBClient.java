package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ConditionalCheckFailedExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GetItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionSizeLimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTablesRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTablesResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PutItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.QueryRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ScanRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTableResultJsonUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AmazonDynamoDBClient extends AmazonWebServiceClient implements AmazonDynamoDB {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    @Deprecated
    public AmazonDynamoDBClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonDynamoDBClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.jsonErrorUnmarshallers = new ArrayList();
        this.jsonErrorUnmarshallers.add(new ConditionalCheckFailedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalServerErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ItemCollectionSizeLimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("dynamodb.us-east-1.amazonaws.com");
        this.endpointPrefix = ServiceAbbreviations.Dynamodb;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/dynamodbv2/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/dynamodbv2/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        ClientConfiguration clientConfiguration2 = new ClientConfiguration(clientConfiguration);
        if (clientConfiguration2.getRetryPolicy() == PredefinedRetryPolicies.DEFAULT) {
            clientConfiguration2.setRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
        }
        return clientConfiguration2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(batchGetItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<BatchGetItemRequest> marshall = new BatchGetItemRequestMarshaller().marshall((BatchGetItemRequest) batchGetItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new BatchGetItemResultJsonUnmarshaller()), createExecutionContext);
                        BatchGetItemResult batchGetItemResult = (BatchGetItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return batchGetItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, batchGetItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            batchGetItemRequest = 0;
            endClientExecution(awsRequestMetrics, batchGetItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest, com.amazonaws.AmazonWebServiceRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(batchWriteItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<BatchWriteItemRequest> marshall = new BatchWriteItemRequestMarshaller().marshall((BatchWriteItemRequest) batchWriteItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new BatchWriteItemResultJsonUnmarshaller()), createExecutionContext);
                        BatchWriteItemResult batchWriteItemResult = (BatchWriteItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return batchWriteItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, batchWriteItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            batchWriteItemRequest = 0;
            endClientExecution(awsRequestMetrics, batchWriteItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.CreateTableRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateTableResult createTable(CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(createTableRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateTableRequest> marshall = new CreateTableRequestMarshaller().marshall((CreateTableRequest) createTableRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new CreateTableResultJsonUnmarshaller()), createExecutionContext);
                        CreateTableResult createTableResult = (CreateTableResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return createTableResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, createTableRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            createTableRequest = 0;
            endClientExecution(awsRequestMetrics, createTableRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.DeleteItemRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(deleteItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteItemRequest> marshall = new DeleteItemRequestMarshaller().marshall((DeleteItemRequest) deleteItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new DeleteItemResultJsonUnmarshaller()), createExecutionContext);
                        DeleteItemResult deleteItemResult = (DeleteItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return deleteItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, deleteItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            deleteItemRequest = 0;
            endClientExecution(awsRequestMetrics, deleteItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.model.DeleteTableRequest, com.amazonaws.AmazonWebServiceRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(deleteTableRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteTableRequest> marshall = new DeleteTableRequestMarshaller().marshall((DeleteTableRequest) deleteTableRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new DeleteTableResultJsonUnmarshaller()), createExecutionContext);
                        DeleteTableResult deleteTableResult = (DeleteTableResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return deleteTableResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, deleteTableRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            deleteTableRequest = 0;
            endClientExecution(awsRequestMetrics, deleteTableRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeLimitsResult describeLimits(DescribeLimitsRequest describeLimitsRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(describeLimitsRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeLimitsRequest> marshall = new DescribeLimitsRequestMarshaller().marshall((DescribeLimitsRequest) describeLimitsRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new DescribeLimitsResultJsonUnmarshaller()), createExecutionContext);
                        DescribeLimitsResult describeLimitsResult = (DescribeLimitsResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return describeLimitsResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, describeLimitsRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            describeLimitsRequest = 0;
            endClientExecution(awsRequestMetrics, describeLimitsRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.DescribeTableRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(describeTableRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeTableRequest> marshall = new DescribeTableRequestMarshaller().marshall((DescribeTableRequest) describeTableRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new DescribeTableResultJsonUnmarshaller()), createExecutionContext);
                        DescribeTableResult describeTableResult = (DescribeTableResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return describeTableResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, describeTableRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            describeTableRequest = 0;
            endClientExecution(awsRequestMetrics, describeTableRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.GetItemRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(getItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetItemRequest> marshall = new GetItemRequestMarshaller().marshall((GetItemRequest) getItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new GetItemResultJsonUnmarshaller()), createExecutionContext);
                        GetItemResult getItemResult = (GetItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return getItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, getItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            getItemRequest = 0;
            endClientExecution(awsRequestMetrics, getItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.ListTablesRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(listTablesRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListTablesRequest> marshall = new ListTablesRequestMarshaller().marshall((ListTablesRequest) listTablesRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new ListTablesResultJsonUnmarshaller()), createExecutionContext);
                        ListTablesResult listTablesResult = (ListTablesResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return listTablesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, listTablesRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            listTablesRequest = 0;
            endClientExecution(awsRequestMetrics, listTablesRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.model.PutItemRequest, com.amazonaws.AmazonWebServiceRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(putItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<PutItemRequest> marshall = new PutItemRequestMarshaller().marshall((PutItemRequest) putItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new PutItemResultJsonUnmarshaller()), createExecutionContext);
                        PutItemResult putItemResult = (PutItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return putItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, putItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            putItemRequest = 0;
            endClientExecution(awsRequestMetrics, putItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.QueryRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public QueryResult query(QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(queryRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<QueryRequest> marshall = new QueryRequestMarshaller().marshall((QueryRequest) queryRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new QueryResultJsonUnmarshaller()), createExecutionContext);
                        QueryResult queryResult = (QueryResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return queryResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, queryRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            queryRequest = 0;
            endClientExecution(awsRequestMetrics, queryRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.ScanRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(scanRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ScanRequest> marshall = new ScanRequestMarshaller().marshall((ScanRequest) scanRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new ScanResultJsonUnmarshaller()), createExecutionContext);
                        ScanResult scanResult = (ScanResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return scanResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, scanRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            scanRequest = 0;
            endClientExecution(awsRequestMetrics, scanRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.UpdateItemRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(updateItemRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateItemRequest> marshall = new UpdateItemRequestMarshaller().marshall((UpdateItemRequest) updateItemRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new UpdateItemResultJsonUnmarshaller()), createExecutionContext);
                        UpdateItemResult updateItemResult = (UpdateItemResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return updateItemResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, updateItemRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            updateItemRequest = 0;
            endClientExecution(awsRequestMetrics, updateItemRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.UpdateTableRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(updateTableRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateTableRequest> marshall = new UpdateTableRequestMarshaller().marshall((UpdateTableRequest) updateTableRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new UpdateTableResultJsonUnmarshaller()), createExecutionContext);
                        UpdateTableResult updateTableResult = (UpdateTableResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return updateTableResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                endClientExecution(awsRequestMetrics, updateTableRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            updateTableRequest = 0;
            endClientExecution(awsRequestMetrics, updateTableRequest, null, true);
            throw th;
        }
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        return putItem(putItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonServiceException, AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        putItemRequest.setReturnValues(str2);
        return putItem(putItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2) throws AmazonServiceException, AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        return updateItem(updateItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, String str2) throws AmazonServiceException, AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        updateItemRequest.setReturnValues(str2);
        return updateItem(updateItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeTableResult describeTable(String str) throws AmazonServiceException, AmazonClientException {
        DescribeTableRequest describeTableRequest = new DescribeTableRequest();
        describeTableRequest.setTableName(str);
        return describeTable(describeTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, List<String> list) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, Map<String, Condition> map) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, List<String> list, Map<String, Condition> map) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        return deleteItem(deleteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonServiceException, AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        deleteItemRequest.setReturnValues(str2);
        return deleteItem(deleteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteTableResult deleteTable(String str) throws AmazonServiceException, AmazonClientException {
        DeleteTableRequest deleteTableRequest = new DeleteTableRequest();
        deleteTableRequest.setTableName(str);
        return deleteTable(deleteTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateTableResult createTable(List<AttributeDefinition> list, String str, List<KeySchemaElement> list2, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
        CreateTableRequest createTableRequest = new CreateTableRequest();
        createTableRequest.setAttributeDefinitions(list);
        createTableRequest.setTableName(str);
        createTableRequest.setKeySchema(list2);
        createTableRequest.setProvisionedThroughput(provisionedThroughput);
        return createTable(createTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        return getItem(getItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(String str, Map<String, AttributeValue> map, Boolean bool) throws AmazonServiceException, AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        getItemRequest.setConsistentRead(bool);
        return getItem(getItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables() throws AmazonServiceException, AmazonClientException {
        return listTables(new ListTablesRequest());
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(String str) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(String str, Integer num) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(Integer num) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateTableResult updateTable(String str, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
        UpdateTableRequest updateTableRequest = new UpdateTableRequest();
        updateTableRequest.setTableName(str);
        updateTableRequest.setProvisionedThroughput(provisionedThroughput);
        return updateTable(updateTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map, String str) throws AmazonServiceException, AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        batchGetItemRequest.setReturnConsumedCapacity(str);
        return batchGetItem(batchGetItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map) throws AmazonServiceException, AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        return batchGetItem(batchGetItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> map) throws AmazonServiceException, AmazonClientException {
        BatchWriteItemRequest batchWriteItemRequest = new BatchWriteItemRequest();
        batchWriteItemRequest.setRequestItems(map);
        return batchWriteItem(batchWriteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }
}
