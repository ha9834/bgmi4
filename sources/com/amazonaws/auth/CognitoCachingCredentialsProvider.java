package com.amazonaws.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.util.VersionInfoUtils;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public class CognitoCachingCredentialsProvider extends CognitoCredentialsProvider {
    private static final String AK_KEY = "accessKey";
    private static final String EXP_KEY = "expirationDate";
    private static final String ID_KEY = "identityId";
    private static final String SK_KEY = "secretKey";
    private static final String ST_KEY = "sessionToken";
    private static final String TAG = "CognitoCachingCredentialsProvider";
    private static final String USER_AGENT = CognitoCachingCredentialsProvider.class.getName() + "/" + VersionInfoUtils.getVersion();
    private final String DEFAULT_SHAREDPREFERENCES_NAME;
    private String identityId;
    private final IdentityChangedListener listener;
    volatile boolean needIdentityRefresh;
    private final SharedPreferences prefs;

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions) {
        super(str, str2, str3, str4, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, str2, str3, str4, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions) {
        super(str, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, AmazonCognitoIdentityClient amazonCognitoIdentityClient, AWSSecurityTokenService aWSSecurityTokenService) {
        super(str, str2, str3, str4, amazonCognitoIdentityClient, aWSSecurityTokenService);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2) {
        super(aWSCognitoIdentityProvider, str, str2);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2, AWSSecurityTokenService aWSSecurityTokenService) {
        super(aWSCognitoIdentityProvider, str, str2, aWSSecurityTokenService);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions) {
        super(aWSCognitoIdentityProvider, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions, ClientConfiguration clientConfiguration) {
        super(aWSCognitoIdentityProvider, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    private void initialize() {
        checkUpgrade();
        this.identityId = getCachedIdentityId();
        loadCachedCredentials();
        registerIdentityChangedListener(this.listener);
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public String getIdentityId() {
        if (this.needIdentityRefresh) {
            this.needIdentityRefresh = false;
            refresh();
            this.identityId = super.getIdentityId();
            saveIdentityId(this.identityId);
        }
        this.identityId = getCachedIdentityId();
        if (this.identityId == null) {
            this.identityId = super.getIdentityId();
            saveIdentityId(this.identityId);
        }
        return this.identityId;
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public AWSSessionCredentials getCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            if (this.sessionCredentials == null) {
                loadCachedCredentials();
            }
            if (this.sessionCredentialsExpiration != null && !needsNewSession()) {
                return this.sessionCredentials;
            }
            super.getCredentials();
            if (this.sessionCredentialsExpiration != null) {
                saveCredentials(this.sessionCredentials, this.sessionCredentialsExpiration.getTime());
            }
            return this.sessionCredentials;
        } catch (NotAuthorizedException e) {
            Log.e(TAG, "Failure to get credentials", e);
            if (getLogins() == null) {
                throw e;
            }
            super.setIdentityId(null);
            super.getCredentials();
            return this.sessionCredentials;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        this.credentialsLock.writeLock().lock();
        try {
            super.refresh();
            if (this.sessionCredentialsExpiration != null) {
                saveCredentials(this.sessionCredentials, this.sessionCredentialsExpiration.getTime());
            }
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void setLogins(Map<String, String> map) {
        this.credentialsLock.writeLock().lock();
        try {
            super.setLogins(map);
            this.needIdentityRefresh = true;
            clearCredentials();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clear() {
        super.clear();
        this.prefs.edit().clear().apply();
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clearCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            super.clearCredentials();
            Log.d(TAG, "Clearing credentials from SharedPreferences");
            this.prefs.edit().remove(namespace(AK_KEY)).remove(namespace(SK_KEY)).remove(namespace(ST_KEY)).remove(namespace(EXP_KEY)).apply();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public String getCachedIdentityId() {
        String string = this.prefs.getString(namespace(ID_KEY), null);
        if (string != null && this.identityId == null) {
            super.setIdentityId(string);
        }
        return string;
    }

    void loadCachedCredentials() {
        Log.d(TAG, "Loading credentials from SharedPreferences");
        this.sessionCredentialsExpiration = new Date(this.prefs.getLong(namespace(EXP_KEY), 0L));
        boolean contains = this.prefs.contains(namespace(AK_KEY));
        boolean contains2 = this.prefs.contains(namespace(SK_KEY));
        boolean contains3 = this.prefs.contains(namespace(ST_KEY));
        if (!contains || !contains2 || !contains3) {
            Log.d(TAG, "No valid credentials found in SharedPreferences");
            this.sessionCredentialsExpiration = null;
        } else {
            this.sessionCredentials = new BasicSessionCredentials(this.prefs.getString(namespace(AK_KEY), null), this.prefs.getString(namespace(SK_KEY), null), this.prefs.getString(namespace(ST_KEY), null));
        }
    }

    private void saveCredentials(AWSSessionCredentials aWSSessionCredentials, long j) {
        Log.d(TAG, "Saving credentials to SharedPreferences");
        if (aWSSessionCredentials != null) {
            this.prefs.edit().putString(namespace(AK_KEY), aWSSessionCredentials.getAWSAccessKeyId()).putString(namespace(SK_KEY), aWSSessionCredentials.getAWSSecretKey()).putString(namespace(ST_KEY), aWSSessionCredentials.getSessionToken()).putLong(namespace(EXP_KEY), j).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIdentityId(String str) {
        Log.d(TAG, "Saving identity id to SharedPreferences");
        this.identityId = str;
        this.prefs.edit().putString(namespace(ID_KEY), str).apply();
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    protected String getUserAgent() {
        return USER_AGENT;
    }

    private void checkUpgrade() {
        if (this.prefs.contains(ID_KEY)) {
            Log.i(TAG, "Identity id without namespace is detected. It will be saved under new namespace.");
            this.prefs.edit().clear().putString(namespace(ID_KEY), this.prefs.getString(ID_KEY, null)).apply();
        }
    }

    private String namespace(String str) {
        return getIdentityPoolId() + "." + str;
    }
}
