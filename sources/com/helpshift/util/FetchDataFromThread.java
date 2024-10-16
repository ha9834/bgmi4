package com.helpshift.util;

/* loaded from: classes2.dex */
public interface FetchDataFromThread<T, R> {
    void onDataFetched(T t);

    void onFailure(R r);
}
