package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final int TIME_MILLISEC = 1000;
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog(AmazonHttpClient.class);

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List<RequestHandler2> requestHandler2s = requestHandler2s(request, executionContext);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Response<T> response = null;
        try {
            response = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
            afterResponse(request, requestHandler2s, response, awsRequestMetrics.getTimingInfo().endTiming());
            return response;
        } catch (AmazonClientException e) {
            afterError(request, response, requestHandler2s, e);
            throw e;
        }
    }

    void afterError(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterError(request, response, amazonClientException);
        }
    }

    <T> void afterResponse(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterResponse(request, response);
        }
    }

    List<RequestHandler2> requestHandler2s(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x02ef A[Catch: all -> 0x037e, TryCatch #13 {all -> 0x037e, blocks: (B:41:0x02e7, B:43:0x02ef, B:44:0x0309, B:46:0x0352, B:60:0x037d, B:97:0x0252, B:99:0x0258, B:101:0x025e, B:102:0x0265, B:115:0x028d), top: B:40:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0352 A[Catch: all -> 0x037e, TRY_LEAVE, TryCatch #13 {all -> 0x037e, blocks: (B:41:0x02e7, B:43:0x02ef, B:44:0x0309, B:46:0x0352, B:60:0x037d, B:97:0x0252, B:99:0x0258, B:101:0x025e, B:102:0x0265, B:115:0x028d), top: B:40:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x037d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    <T> com.amazonaws.Response<T> executeHelper(com.amazonaws.Request<?> r26, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r28, com.amazonaws.http.ExecutionContext r29) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    private <T extends Throwable> T handleUnexpectedFailure(T t, AWSRequestMetrics aWSRequestMetrics) {
        aWSRequestMetrics.incrementCounter(AWSRequestMetrics.Field.Exception);
        aWSRequestMetrics.addProperty(AWSRequestMetrics.Field.Exception, t);
        return t;
    }

    void resetRequestAfterError(Request<?> request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    void setUserAgent(Request<?> request) {
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && (requestClientOptions = originalRequest.getRequestClientOptions()) != null && (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) != null) {
            str = createUserAgentString(str, clientMarker);
        }
        if (!ClientConfiguration.DEFAULT_USER_AGENT.equals(this.config.getUserAgent())) {
            str = createUserAgentString(str, this.config.getUserAgent());
        }
        request.addHeader("User-Agent", str);
    }

    static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i2 >= maxErrorRetry) {
            return false;
        }
        if (inputStream != null && !inputStream.markSupported()) {
            if (log.isDebugEnabled()) {
                log.debug("Content not repeatable");
            }
            return false;
        }
        return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i2);
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get(HttpHeader.LOCATION);
        return (statusCode != HTTP_STATUS_TEMP_REDIRECT || str == null || str.isEmpty()) ? false : true;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
            try {
                AmazonWebServiceResponse<T> handle = httpResponseHandler.handle(httpResponse);
                if (handle == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
                }
                if (REQUEST_LOG.isDebugEnabled()) {
                    REQUEST_LOG.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + handle.getRequestId());
                }
                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, handle.getRequestId());
                return handle.getResult();
            } finally {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
            }
        } catch (CRC32MismatchException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AmazonClientException("Unable to unmarshall response (" + e3.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e3);
        }
    }

    AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (statusCode == HTTP_STATUS_REQ_TOO_LONG) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_REQ_TOO_LONG);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == HTTP_STATUS_SERVICE_UNAVAILABLE && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_SERVICE_UNAVAILABLE);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText(), e);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = (i - 1) - 1;
        long delayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i2);
        if (log.isDebugEnabled()) {
            log.debug("Retriable error detected, will retry in " + delayBeforeNextRetry + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(delayBeforeNextRetry);
            return delayBeforeNextRetry;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private String getServerDateFromException(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("(");
        if (str.contains(" + 15")) {
            indexOf = str.indexOf(" + 15");
        } else {
            indexOf = str.indexOf(" - 15");
        }
        return str.substring(indexOf2 + 1, indexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    int parseClockSkewOffset(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date parseRFC822Date;
        Date date = new Date();
        String str = httpResponse.getHeaders().get("Date");
        String str2 = null;
        try {
            if (str != 0) {
                try {
                    if (!str.isEmpty()) {
                        parseRFC822Date = DateUtils.parseRFC822Date(str);
                        str = (int) ((date.getTime() - parseRFC822Date.getTime()) / 1000);
                        return str;
                    }
                } catch (RuntimeException e) {
                    e = e;
                    log.warn("Unable to parse clock skew offset from response: " + str2, e);
                    return 0;
                }
            }
            parseRFC822Date = DateUtils.parseCompressedISO8601Date(getServerDateFromException(amazonServiceException.getMessage()));
            str = (int) ((date.getTime() - parseRFC822Date.getTime()) / 1000);
            return str;
        } catch (RuntimeException e2) {
            e = e2;
            str2 = str;
        }
    }

    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }
}
