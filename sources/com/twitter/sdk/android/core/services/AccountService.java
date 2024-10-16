package com.twitter.sdk.android.core.services;

import a.b;
import a.b.f;
import a.b.t;
import com.twitter.sdk.android.core.models.User;

/* loaded from: classes.dex */
public interface AccountService {
    @f(a = "/1.1/account/verify_credentials.json")
    b<User> verifyCredentials(@t(a = "include_entities") Boolean bool, @t(a = "skip_status") Boolean bool2, @t(a = "include_email") Boolean bool3);
}
