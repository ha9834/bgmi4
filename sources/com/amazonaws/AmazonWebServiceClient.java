package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceClient {
    private static final String AMAZON = "Amazon";
    private static final String AWS = "AWS";
    private static final Log LOG = LogFactory.getLog(AmazonWebServiceClient.class);
    public static final boolean LOGGING_AWS_REQUEST_METRIC = true;
    protected AmazonHttpClient client;
    protected ClientConfiguration clientConfiguration;
    protected volatile URI endpoint;
    protected volatile String endpointPrefix;
    protected final List<RequestHandler2> requestHandler2s;
    private volatile String serviceName;
    private volatile Signer signer;
    private volatile String signerRegionOverride;
    protected int timeOffset;

    @Deprecated
    protected void configSigner(String str, String str2) {
    }

    @Deprecated
    protected void configSigner(URI uri) {
    }

    protected AmazonWebServiceClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, httpClient);
        this.requestHandler2s = new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, httpClient, requestMetricCollector);
        this.requestHandler2s = new CopyOnWriteArrayList();
    }

    protected Signer getSigner() {
        return this.signer;
    }

    public void setEndpoint(String str) {
        URI uri = toURI(str);
        Signer computeSignerByURI = computeSignerByURI(uri, this.signerRegionOverride, false);
        synchronized (this) {
            this.endpoint = uri;
            this.signer = computeSignerByURI;
        }
    }

    public String getEndpoint() {
        String uri;
        synchronized (this) {
            uri = this.endpoint.toString();
        }
        return uri;
    }

    public String getEndpointPrefix() {
        return this.endpointPrefix;
    }

    private URI toURI(String str) {
        if (!str.contains("://")) {
            str = this.clientConfiguration.getProtocol().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public void setEndpoint(String str, String str2, String str3) {
        URI uri = toURI(str);
        Signer computeSignerByServiceRegion = computeSignerByServiceRegion(str2, str3, str3, true);
        synchronized (this) {
            this.signer = computeSignerByServiceRegion;
            this.endpoint = uri;
            this.signerRegionOverride = str3;
        }
    }

    public Signer getSignerByURI(URI uri) {
        return computeSignerByURI(uri, this.signerRegionOverride, true);
    }

    private Signer computeSignerByURI(URI uri, String str, boolean z) {
        if (uri == null) {
            throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
        }
        String serviceNameIntern = getServiceNameIntern();
        return computeSignerByServiceRegion(serviceNameIntern, AwsHostNameUtils.parseRegionName(uri.getHost(), serviceNameIntern), str, z);
    }

    private Signer computeSignerByServiceRegion(String str, String str2, String str3, boolean z) {
        Signer signerByTypeAndService;
        String signerOverride = this.clientConfiguration.getSignerOverride();
        if (signerOverride == null) {
            signerByTypeAndService = SignerFactory.getSigner(str, str2);
        } else {
            signerByTypeAndService = SignerFactory.getSignerByTypeAndService(signerOverride, str);
        }
        if (signerByTypeAndService instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) signerByTypeAndService;
            if (str3 != null) {
                regionAwareSigner.setRegionName(str3);
            } else if (str2 != null && z) {
                regionAwareSigner.setRegionName(str2);
            }
        }
        return signerByTypeAndService;
    }

    public void setRegion(Region region) {
        String format;
        if (region == null) {
            throw new IllegalArgumentException("No region provided");
        }
        String serviceNameIntern = getServiceNameIntern();
        if (region.isServiceSupported(serviceNameIntern)) {
            format = region.getServiceEndpoint(serviceNameIntern);
            int indexOf = format.indexOf("://");
            if (indexOf >= 0) {
                format = format.substring(indexOf + 3);
            }
        } else {
            format = String.format("%s.%s.%s", getEndpointPrefix(), region.getName(), region.getDomain());
        }
        URI uri = toURI(format);
        Signer computeSignerByServiceRegion = computeSignerByServiceRegion(serviceNameIntern, region.getName(), this.signerRegionOverride, false);
        synchronized (this) {
            this.endpoint = uri;
            this.signer = computeSignerByServiceRegion;
        }
    }

    @Deprecated
    public void setConfiguration(ClientConfiguration clientConfiguration) {
        RequestMetricCollector requestMetricCollector;
        AmazonHttpClient amazonHttpClient = this.client;
        if (amazonHttpClient != null) {
            requestMetricCollector = amazonHttpClient.getRequestMetricCollector();
            amazonHttpClient.shutdown();
        } else {
            requestMetricCollector = null;
        }
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, requestMetricCollector);
    }

    public void shutdown() {
        this.client.shutdown();
    }

    @Deprecated
    public void addRequestHandler(RequestHandler requestHandler) {
        this.requestHandler2s.add(RequestHandler2.adapt(requestHandler));
    }

    public void addRequestHandler(RequestHandler2 requestHandler2) {
        this.requestHandler2s.add(requestHandler2);
    }

    @Deprecated
    public void removeRequestHandler(RequestHandler requestHandler) {
        this.requestHandler2s.remove(RequestHandler2.adapt(requestHandler));
    }

    public void removeRequestHandler(RequestHandler2 requestHandler2) {
        this.requestHandler2s.remove(requestHandler2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ExecutionContext createExecutionContext(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new ExecutionContext(this.requestHandler2s, isRequestMetricsEnabled(amazonWebServiceRequest) || isProfilingEnabled(), this);
    }

    protected final ExecutionContext createExecutionContext(Request<?> request) {
        return createExecutionContext(request.getOriginalRequest());
    }

    @Deprecated
    protected final ExecutionContext createExecutionContext() {
        return new ExecutionContext(this.requestHandler2s, isRMCEnabledAtClientOrSdkLevel() || isProfilingEnabled(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public static boolean isProfilingEnabled() {
        return System.getProperty(SDKGlobalConfiguration.PROFILING_SYSTEM_PROPERTY) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public final boolean isRequestMetricsEnabled(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollector = amazonWebServiceRequest.getRequestMetricCollector();
        if (requestMetricCollector == null || !requestMetricCollector.isEnabled()) {
            return isRMCEnabledAtClientOrSdkLevel();
        }
        return true;
    }

    @Deprecated
    private boolean isRMCEnabledAtClientOrSdkLevel() {
        RequestMetricCollector requestMetricCollector = requestMetricCollector();
        return requestMetricCollector != null && requestMetricCollector.isEnabled();
    }

    public void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    public AmazonWebServiceClient withTimeOffset(int i) {
        setTimeOffset(i);
        return this;
    }

    public int getTimeOffset() {
        return this.timeOffset;
    }

    @Deprecated
    public RequestMetricCollector getRequestMetricsCollector() {
        return this.client.getRequestMetricCollector();
    }

    @Deprecated
    protected RequestMetricCollector requestMetricCollector() {
        RequestMetricCollector requestMetricCollector = this.client.getRequestMetricCollector();
        return requestMetricCollector == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricCollector;
    }

    @Deprecated
    protected final RequestMetricCollector findRequestMetricCollector(Request<?> request) {
        RequestMetricCollector requestMetricCollector = request.getOriginalRequest().getRequestMetricCollector();
        if (requestMetricCollector != null) {
            return requestMetricCollector;
        }
        RequestMetricCollector requestMetricsCollector = getRequestMetricsCollector();
        return requestMetricsCollector == null ? AwsSdkMetrics.getRequestMetricCollector() : requestMetricsCollector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public final void endClientExecution(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        endClientExecution(aWSRequestMetrics, request, response, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public final void endClientExecution(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z) {
        if (request != null) {
            aWSRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.getTimingInfo().endTiming();
            findRequestMetricCollector(request).collectMetrics(request, response);
        }
        if (z) {
            aWSRequestMetrics.log();
        }
    }

    @Deprecated
    protected String getServiceAbbreviation() {
        return getServiceNameIntern();
    }

    public String getServiceName() {
        return getServiceNameIntern();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getServiceNameIntern() {
        if (this.serviceName == null) {
            synchronized (this) {
                if (this.serviceName == null) {
                    this.serviceName = computeServiceName();
                    return this.serviceName;
                }
            }
        }
        return this.serviceName;
    }

    public final void setServiceNameIntern(String str) {
        this.serviceName = str;
    }

    private String computeServiceName() {
        int i;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int indexOf = simpleName.indexOf("JavaClient");
        if (indexOf == -1 && (indexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int indexOf2 = simpleName.indexOf(AMAZON);
        if (indexOf2 == -1) {
            indexOf2 = simpleName.indexOf(AWS);
            if (indexOf2 == -1) {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
            i = 3;
        } else {
            i = 6;
        }
        if (indexOf2 >= indexOf) {
            throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
        }
        return StringUtils.lowerCase(simpleName.substring(indexOf2 + i, indexOf));
    }

    public final String getSignerRegionOverride() {
        return this.signerRegionOverride;
    }

    public final void setSignerRegionOverride(String str) {
        Signer computeSignerByURI = computeSignerByURI(this.endpoint, str, true);
        synchronized (this) {
            this.signer = computeSignerByURI;
            this.signerRegionOverride = str;
        }
    }
}
