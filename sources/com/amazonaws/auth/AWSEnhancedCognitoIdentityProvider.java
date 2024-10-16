package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;

/* loaded from: classes.dex */
public final class AWSEnhancedCognitoIdentityProvider extends AWSAbstractCognitoIdentityProvider {
    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
    public String getProviderName() {
        return "Cognito";
    }

    public AWSEnhancedCognitoIdentityProvider(String str, String str2) {
        this(str, str2, new ClientConfiguration());
    }

    public AWSEnhancedCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration) {
        this(str, str2, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public AWSEnhancedCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        super(str, str2, amazonCognitoIdentity);
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider, com.amazonaws.auth.AWSIdentityProvider
    public String refresh() {
        getIdentityId();
        return null;
    }
}
