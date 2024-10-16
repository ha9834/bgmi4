package com.android.volley.toolbox;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.uqm.crashsight.CrashSight;
import java.io.File;

/* loaded from: classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    @TargetApi(9)
    public static RequestQueue newRequestQueue(Context context) {
        File file = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        if (Build.VERSION.SDK_INT < 9) {
            System.setProperty("http.keepAlive", CrashSight.SDK_IS_DEV);
            VolleyLog.e("Work around pre-Froyo bugs in HTTP connection reuse", new Object[0]);
        }
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(new HurlStack()));
        requestQueue.start();
        return requestQueue;
    }
}
