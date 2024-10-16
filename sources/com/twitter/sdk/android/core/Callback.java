package com.twitter.sdk.android.core;

import a.b;
import a.d;
import a.l;

/* loaded from: classes.dex */
public abstract class Callback<T> implements d<T> {
    public abstract void failure(TwitterException twitterException);

    public abstract void success(Result<T> result);

    @Override // a.d
    public final void onResponse(b<T> bVar, l<T> lVar) {
        if (lVar.c()) {
            success(new Result<>(lVar.d(), lVar));
        } else {
            failure(new TwitterApiException(lVar));
        }
    }

    @Override // a.d
    public final void onFailure(b<T> bVar, Throwable th) {
        failure(new TwitterException("Request Failure", th));
    }
}
