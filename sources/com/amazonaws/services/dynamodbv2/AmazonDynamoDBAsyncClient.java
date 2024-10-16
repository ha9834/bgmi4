package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
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
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AmazonDynamoDBAsyncClient extends AmazonDynamoDBClient implements AmazonDynamoDBAsync {
    private static final int DEFAULT_THREAD_POOL_SIZE = 10;
    private ExecutorService executorService;

    @Deprecated
    public AmazonDynamoDBAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    @Deprecated
    public AmazonDynamoDBAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newFixedThreadPool(10));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newFixedThreadPool(10));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Override // com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<BatchGetItemResult> batchGetItemAsync(final BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchGetItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BatchGetItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.batchGetItem(batchGetItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<BatchGetItemResult> batchGetItemAsync(final BatchGetItemRequest batchGetItemRequest, final AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchGetItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BatchGetItemResult call() throws Exception {
                try {
                    BatchGetItemResult batchGetItem = AmazonDynamoDBAsyncClient.this.batchGetItem(batchGetItemRequest);
                    asyncHandler.onSuccess(batchGetItemRequest, batchGetItem);
                    return batchGetItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<BatchWriteItemResult> batchWriteItemAsync(final BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchWriteItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BatchWriteItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.batchWriteItem(batchWriteItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<BatchWriteItemResult> batchWriteItemAsync(final BatchWriteItemRequest batchWriteItemRequest, final AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchWriteItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BatchWriteItemResult call() throws Exception {
                try {
                    BatchWriteItemResult batchWriteItem = AmazonDynamoDBAsyncClient.this.batchWriteItem(batchWriteItemRequest);
                    asyncHandler.onSuccess(batchWriteItemRequest, batchWriteItem);
                    return batchWriteItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<CreateTableResult> createTableAsync(final CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CreateTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.createTable(createTableRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<CreateTableResult> createTableAsync(final CreateTableRequest createTableRequest, final AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CreateTableResult call() throws Exception {
                try {
                    CreateTableResult createTable = AmazonDynamoDBAsyncClient.this.createTable(createTableRequest);
                    asyncHandler.onSuccess(createTableRequest, createTable);
                    return createTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DeleteItemResult> deleteItemAsync(final DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DeleteItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.deleteItem(deleteItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DeleteItemResult> deleteItemAsync(final DeleteItemRequest deleteItemRequest, final AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DeleteItemResult call() throws Exception {
                try {
                    DeleteItemResult deleteItem = AmazonDynamoDBAsyncClient.this.deleteItem(deleteItemRequest);
                    asyncHandler.onSuccess(deleteItemRequest, deleteItem);
                    return deleteItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DeleteTableResult> deleteTableAsync(final DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DeleteTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.deleteTable(deleteTableRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DeleteTableResult> deleteTableAsync(final DeleteTableRequest deleteTableRequest, final AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DeleteTableResult call() throws Exception {
                try {
                    DeleteTableResult deleteTable = AmazonDynamoDBAsyncClient.this.deleteTable(deleteTableRequest);
                    asyncHandler.onSuccess(deleteTableRequest, deleteTable);
                    return deleteTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DescribeLimitsResult> describeLimitsAsync(final DescribeLimitsRequest describeLimitsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeLimitsResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DescribeLimitsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeLimits(describeLimitsRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DescribeLimitsResult> describeLimitsAsync(final DescribeLimitsRequest describeLimitsRequest, final AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeLimitsResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DescribeLimitsResult call() throws Exception {
                try {
                    DescribeLimitsResult describeLimits = AmazonDynamoDBAsyncClient.this.describeLimits(describeLimitsRequest);
                    asyncHandler.onSuccess(describeLimitsRequest, describeLimits);
                    return describeLimits;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DescribeTableResult> describeTableAsync(final DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DescribeTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeTable(describeTableRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<DescribeTableResult> describeTableAsync(final DescribeTableRequest describeTableRequest, final AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DescribeTableResult call() throws Exception {
                try {
                    DescribeTableResult describeTable = AmazonDynamoDBAsyncClient.this.describeTable(describeTableRequest);
                    asyncHandler.onSuccess(describeTableRequest, describeTable);
                    return describeTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<GetItemResult> getItemAsync(final GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<GetItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public GetItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.getItem(getItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<GetItemResult> getItemAsync(final GetItemRequest getItemRequest, final AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<GetItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public GetItemResult call() throws Exception {
                try {
                    GetItemResult item = AmazonDynamoDBAsyncClient.this.getItem(getItemRequest);
                    asyncHandler.onSuccess(getItemRequest, item);
                    return item;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<ListTablesResult> listTablesAsync(final ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTablesResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ListTablesResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.listTables(listTablesRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<ListTablesResult> listTablesAsync(final ListTablesRequest listTablesRequest, final AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTablesResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ListTablesResult call() throws Exception {
                try {
                    ListTablesResult listTables = AmazonDynamoDBAsyncClient.this.listTables(listTablesRequest);
                    asyncHandler.onSuccess(listTablesRequest, listTables);
                    return listTables;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<PutItemResult> putItemAsync(final PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<PutItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PutItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.putItem(putItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<PutItemResult> putItemAsync(final PutItemRequest putItemRequest, final AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<PutItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PutItemResult call() throws Exception {
                try {
                    PutItemResult putItem = AmazonDynamoDBAsyncClient.this.putItem(putItemRequest);
                    asyncHandler.onSuccess(putItemRequest, putItem);
                    return putItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<QueryResult> queryAsync(final QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<QueryResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public QueryResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.query(queryRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<QueryResult> queryAsync(final QueryRequest queryRequest, final AsyncHandler<QueryRequest, QueryResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<QueryResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public QueryResult call() throws Exception {
                try {
                    QueryResult query = AmazonDynamoDBAsyncClient.this.query(queryRequest);
                    asyncHandler.onSuccess(queryRequest, query);
                    return query;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<ScanResult> scanAsync(final ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ScanResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ScanResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.scan(scanRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<ScanResult> scanAsync(final ScanRequest scanRequest, final AsyncHandler<ScanRequest, ScanResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ScanResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ScanResult call() throws Exception {
                try {
                    ScanResult scan = AmazonDynamoDBAsyncClient.this.scan(scanRequest);
                    asyncHandler.onSuccess(scanRequest, scan);
                    return scan;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<UpdateItemResult> updateItemAsync(final UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UpdateItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateItem(updateItemRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<UpdateItemResult> updateItemAsync(final UpdateItemRequest updateItemRequest, final AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateItemResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UpdateItemResult call() throws Exception {
                try {
                    UpdateItemResult updateItem = AmazonDynamoDBAsyncClient.this.updateItem(updateItemRequest);
                    asyncHandler.onSuccess(updateItemRequest, updateItem);
                    return updateItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<UpdateTableResult> updateTableAsync(final UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UpdateTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateTable(updateTableRequest);
            }
        });
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
    public Future<UpdateTableResult> updateTableAsync(final UpdateTableRequest updateTableRequest, final AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTableResult>() { // from class: com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UpdateTableResult call() throws Exception {
                try {
                    UpdateTableResult updateTable = AmazonDynamoDBAsyncClient.this.updateTable(updateTableRequest);
                    asyncHandler.onSuccess(updateTableRequest, updateTable);
                    return updateTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }
}
