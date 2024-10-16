package com.amazonaws.services.cognitoidentity;

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
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import com.amazonaws.services.cognitoidentity.model.transform.ExternalServiceExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidIdentityPoolConfigurationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.NotAuthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceConflictExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AmazonCognitoIdentityClient extends AmazonWebServiceClient implements AmazonCognitoIdentity {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AmazonCognitoIdentityClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonCognitoIdentityClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.jsonErrorUnmarshallers = new ArrayList();
        this.jsonErrorUnmarshallers.add(new ExternalServiceExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidIdentityPoolConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidParameterExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotAuthorizedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceConflictExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyRequestsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("cognito-identity.us-east-1.amazonaws.com");
        this.endpointPrefix = "cognito-identity";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/cognitoidentity/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/cognitoidentity/request.handler2s"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetCredentialsForIdentityResult getCredentialsForIdentity(GetCredentialsForIdentityRequest getCredentialsForIdentityRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(getCredentialsForIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetCredentialsForIdentityRequest> marshall = new GetCredentialsForIdentityRequestMarshaller().marshall((GetCredentialsForIdentityRequest) getCredentialsForIdentityRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new GetCredentialsForIdentityResultJsonUnmarshaller()), createExecutionContext);
                        GetCredentialsForIdentityResult getCredentialsForIdentityResult = (GetCredentialsForIdentityResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return getCredentialsForIdentityResult;
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
                endClientExecution(awsRequestMetrics, getCredentialsForIdentityRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            getCredentialsForIdentityRequest = 0;
            endClientExecution(awsRequestMetrics, getCredentialsForIdentityRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.GetIdRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetIdResult getId(GetIdRequest getIdRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(getIdRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetIdRequest> marshall = new GetIdRequestMarshaller().marshall((GetIdRequest) getIdRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new GetIdResultJsonUnmarshaller()), createExecutionContext);
                        GetIdResult getIdResult = (GetIdResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return getIdResult;
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
                endClientExecution(awsRequestMetrics, getIdRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            getIdRequest = 0;
            endClientExecution(awsRequestMetrics, getIdRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetOpenIdTokenResult getOpenIdToken(GetOpenIdTokenRequest getOpenIdTokenRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext(getOpenIdTokenRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetOpenIdTokenRequest> marshall = new GetOpenIdTokenRequestMarshaller().marshall((GetOpenIdTokenRequest) getOpenIdTokenRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response invoke = invoke(marshall, new JsonResponseHandler(new GetOpenIdTokenResultJsonUnmarshaller()), createExecutionContext);
                        GetOpenIdTokenResult getOpenIdTokenResult = (GetOpenIdTokenResult) invoke.getAwsResponse();
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return getOpenIdTokenResult;
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
                endClientExecution(awsRequestMetrics, getOpenIdTokenRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            getOpenIdTokenRequest = 0;
            endClientExecution(awsRequestMetrics, getOpenIdTokenRequest, null, true);
            throw th;
        }
    }

    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
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
