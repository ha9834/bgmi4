package com.amazonaws.auth;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.Credentials;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class CognitoCredentialsProvider implements AWSCredentialsProvider {
    public static final int DEFAULT_DURATION_SECONDS = 3600;
    public static final int DEFAULT_THRESHOLD_SECONDS = 500;
    protected String authRoleArn;
    private AmazonCognitoIdentity cib;
    protected ReentrantReadWriteLock credentialsLock;
    protected String customRoleArn;
    private final AWSCognitoIdentityProvider identityProvider;
    protected int refreshThreshold;
    protected AWSSecurityTokenService securityTokenService;
    protected AWSSessionCredentials sessionCredentials;
    protected Date sessionCredentialsExpiration;
    protected int sessionDuration;
    protected String token;
    protected String unauthRoleArn;
    protected boolean useEnhancedFlow;

    protected String getUserAgent() {
        return "";
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, Regions regions) {
        this(str, str2, str3, str4, regions, new ClientConfiguration());
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, Regions regions, ClientConfiguration clientConfiguration) {
        this(str, str2, str3, str4, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration), (str3 == null && str4 == null) ? null : new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), clientConfiguration));
        this.cib.setRegion(Region.getRegion(regions));
    }

    public CognitoCredentialsProvider(String str, Regions regions) {
        this((String) null, str, (String) null, (String) null, regions, new ClientConfiguration());
    }

    public CognitoCredentialsProvider(String str, Regions regions, ClientConfiguration clientConfiguration) {
        this((String) null, str, (String) null, (String) null, regions, clientConfiguration);
    }

    public CognitoCredentialsProvider(String str, String str2, String str3, String str4, AmazonCognitoIdentityClient amazonCognitoIdentityClient, AWSSecurityTokenService aWSSecurityTokenService) {
        this.cib = amazonCognitoIdentityClient;
        this.securityTokenService = aWSSecurityTokenService;
        this.unauthRoleArn = str3;
        this.authRoleArn = str4;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
        this.useEnhancedFlow = str3 == null && str4 == null;
        if (this.useEnhancedFlow) {
            this.identityProvider = new AWSEnhancedCognitoIdentityProvider(str, str2, amazonCognitoIdentityClient);
        } else {
            this.identityProvider = new AWSBasicCognitoIdentityProvider(str, str2, amazonCognitoIdentityClient);
        }
        this.credentialsLock = new ReentrantReadWriteLock(true);
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2) {
        this(aWSCognitoIdentityProvider, str, str2, new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), new ClientConfiguration()));
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2, AWSSecurityTokenService aWSSecurityTokenService) {
        this.identityProvider = aWSCognitoIdentityProvider;
        this.unauthRoleArn = str;
        this.authRoleArn = str2;
        this.securityTokenService = aWSSecurityTokenService;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
        this.useEnhancedFlow = false;
        this.credentialsLock = new ReentrantReadWriteLock(true);
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions) {
        this(aWSCognitoIdentityProvider, regions, new ClientConfiguration());
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions, ClientConfiguration clientConfiguration) {
        this(aWSCognitoIdentityProvider, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
        this.cib.setRegion(Region.getRegion(regions));
    }

    public CognitoCredentialsProvider(AWSCognitoIdentityProvider aWSCognitoIdentityProvider, AmazonCognitoIdentityClient amazonCognitoIdentityClient) {
        this.cib = amazonCognitoIdentityClient;
        this.identityProvider = aWSCognitoIdentityProvider;
        this.unauthRoleArn = null;
        this.authRoleArn = null;
        this.securityTokenService = null;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
        this.useEnhancedFlow = true;
        this.credentialsLock = new ReentrantReadWriteLock(true);
    }

    public String getIdentityId() {
        return this.identityProvider.getIdentityId();
    }

    public String getToken() {
        return this.identityProvider.getToken();
    }

    public AWSIdentityProvider getIdentityProvider() {
        return this.identityProvider;
    }

    public void setSessionCredentialsExpiration(Date date) {
        this.credentialsLock.writeLock().lock();
        try {
            this.sessionCredentialsExpiration = date;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public Date getSessionCredentitalsExpiration() {
        this.credentialsLock.readLock().lock();
        try {
            return this.sessionCredentialsExpiration;
        } finally {
            this.credentialsLock.readLock().unlock();
        }
    }

    public String getIdentityPoolId() {
        return this.identityProvider.getIdentityPoolId();
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSSessionCredentials getCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            if (needsNewSession()) {
                startSession();
            }
            return this.sessionCredentials;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void setSessionDuration(int i) {
        this.sessionDuration = i;
    }

    public CognitoCredentialsProvider withSessionDuration(int i) {
        setSessionDuration(i);
        return this;
    }

    public int getSessionDuration() {
        return this.sessionDuration;
    }

    public void setRefreshThreshold(int i) {
        this.refreshThreshold = i;
    }

    public CognitoCredentialsProvider withRefreshThreshold(int i) {
        setRefreshThreshold(i);
        return this;
    }

    public int getRefreshThreshold() {
        return this.refreshThreshold;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIdentityId(String str) {
        this.identityProvider.identityChanged(str);
    }

    public void setLogins(Map<String, String> map) {
        this.credentialsLock.writeLock().lock();
        try {
            this.identityProvider.setLogins(map);
            clearCredentials();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public String getCustomRoleArn() {
        return this.customRoleArn;
    }

    public void setCustomRoleArn(String str) {
        this.customRoleArn = str;
    }

    public AWSCredentialsProvider withLogins(Map<String, String> map) {
        setLogins(map);
        return this;
    }

    public Map<String, String> getLogins() {
        return this.identityProvider.getLogins();
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        this.credentialsLock.writeLock().lock();
        try {
            startSession();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void clear() {
        this.credentialsLock.writeLock().lock();
        try {
            clearCredentials();
            setIdentityId(null);
            this.identityProvider.setLogins(new HashMap());
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public void clearCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            this.sessionCredentials = null;
            this.sessionCredentialsExpiration = null;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    protected void startSession() {
        try {
            this.token = this.identityProvider.refresh();
        } catch (ResourceNotFoundException unused) {
            this.token = retryRefresh();
        } catch (AmazonServiceException e) {
            if (e.getErrorCode().equals("ValidationException")) {
                this.token = retryRefresh();
            } else {
                throw e;
            }
        }
        if (this.useEnhancedFlow) {
            populateCredentialsWithCognito(this.token);
        } else {
            populateCredentialsWithSts(this.token);
        }
    }

    private String retryRefresh() {
        setIdentityId(null);
        this.token = this.identityProvider.refresh();
        return this.token;
    }

    private GetCredentialsForIdentityResult retryGetCredentialsForIdentity() {
        Map<String, String> logins;
        this.token = retryRefresh();
        String str = this.token;
        if (str != null && !str.isEmpty()) {
            logins = new HashMap<>();
            logins.put("cognito-identity.amazonaws.com", this.token);
        } else {
            logins = getLogins();
        }
        return this.cib.getCredentialsForIdentity(new GetCredentialsForIdentityRequest().withIdentityId(getIdentityId()).withLogins(logins).withCustomRoleArn(this.customRoleArn));
    }

    private void populateCredentialsWithCognito(String str) {
        Map<String, String> logins;
        GetCredentialsForIdentityResult retryGetCredentialsForIdentity;
        if (str != null && !str.isEmpty()) {
            logins = new HashMap<>();
            logins.put("cognito-identity.amazonaws.com", str);
        } else {
            logins = getLogins();
        }
        try {
            retryGetCredentialsForIdentity = this.cib.getCredentialsForIdentity(new GetCredentialsForIdentityRequest().withIdentityId(getIdentityId()).withLogins(logins).withCustomRoleArn(this.customRoleArn));
        } catch (ResourceNotFoundException unused) {
            retryGetCredentialsForIdentity = retryGetCredentialsForIdentity();
        } catch (AmazonServiceException e) {
            if (e.getErrorCode().equals("ValidationException")) {
                retryGetCredentialsForIdentity = retryGetCredentialsForIdentity();
            } else {
                throw e;
            }
        }
        Credentials credentials = retryGetCredentialsForIdentity.getCredentials();
        this.sessionCredentials = new BasicSessionCredentials(credentials.getAccessKeyId(), credentials.getSecretKey(), credentials.getSessionToken());
        setSessionCredentialsExpiration(credentials.getExpiration());
        if (retryGetCredentialsForIdentity.getIdentityId().equals(getIdentityId())) {
            return;
        }
        setIdentityId(retryGetCredentialsForIdentity.getIdentityId());
    }

    private void populateCredentialsWithSts(String str) {
        AssumeRoleWithWebIdentityRequest withDurationSeconds = new AssumeRoleWithWebIdentityRequest().withWebIdentityToken(str).withRoleArn(this.identityProvider.isAuthenticated() ? this.authRoleArn : this.unauthRoleArn).withRoleSessionName("ProviderSession").withDurationSeconds(Integer.valueOf(this.sessionDuration));
        appendUserAgent(withDurationSeconds, getUserAgent());
        com.amazonaws.services.securitytoken.model.Credentials credentials = this.securityTokenService.assumeRoleWithWebIdentity(withDurationSeconds).getCredentials();
        this.sessionCredentials = new BasicSessionCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken());
        setSessionCredentialsExpiration(credentials.getExpiration());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needsNewSession() {
        if (this.sessionCredentials == null) {
            return true;
        }
        return this.sessionCredentialsExpiration.getTime() - (System.currentTimeMillis() - ((long) (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000))) < ((long) (this.refreshThreshold * 1000));
    }

    private void appendUserAgent(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent(str);
    }

    public void registerIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.identityProvider.registerIdentityChangedListener(identityChangedListener);
    }

    public void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.identityProvider.unregisterIdentityChangedListener(identityChangedListener);
    }
}
