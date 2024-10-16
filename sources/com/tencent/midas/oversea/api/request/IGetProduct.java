package com.tencent.midas.oversea.api.request;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
public interface IGetProduct {
    void getProductInfo(Context context, List<String> list, IProductInfoCallback iProductInfoCallback);
}
