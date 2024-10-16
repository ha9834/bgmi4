package com.vk.api.sdk.auth;

import com.vk.api.sdk.exceptions.VKAuthException;

/* loaded from: classes3.dex */
public interface b {
    void onLogin(a aVar);

    void onLoginFailed(VKAuthException vKAuthException);
}
