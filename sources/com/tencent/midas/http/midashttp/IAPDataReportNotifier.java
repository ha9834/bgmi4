package com.tencent.midas.http.midashttp;

import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;

/* loaded from: classes.dex */
public interface IAPDataReportNotifier {
    void onNetworkFailure(Request request, Response response);

    void onNetworkSuccess(Request request, Response response);
}
