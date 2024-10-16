package com.tencent.midas.oversea.business.h5.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.tencent.mtt.engine.http.HttpUtils;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MDefaultIntercept implements IIntercept {
    public static final String TAG = "MDefaultIntercept";
    private Context appContext;
    private HashMap<String, CacheMetaInfo> cacheMap = new HashMap<>();

    /* loaded from: classes.dex */
    public static class CacheMetaInfo {
        public String mimeType;
        public String path;
    }

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public String handleUrl(WebView webView, String str) {
        return str;
    }

    public void init() {
    }

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public int level() {
        return 0;
    }

    public MDefaultIntercept(Context context) {
        this.appContext = null;
        this.appContext = context.getApplicationContext();
        init();
    }

    public void addCacheInfo(String str, CacheMetaInfo cacheMetaInfo) {
        HashMap<String, CacheMetaInfo> hashMap = this.cacheMap;
        if (hashMap != null) {
            hashMap.put(str, cacheMetaInfo);
        }
    }

    public CacheMetaInfo getCacheInfo(String str) {
        HashMap<String, CacheMetaInfo> hashMap = this.cacheMap;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    @Override // com.tencent.midas.oversea.business.h5.webview.IIntercept
    public WebResourceResponse queryCache(String str) {
        HashMap<String, CacheMetaInfo> hashMap;
        CacheMetaInfo cacheMetaInfo;
        Log.d(TAG, "queryCache");
        if (!TextUtils.isEmpty(str) && (hashMap = this.cacheMap) != null && !hashMap.isEmpty()) {
            Iterator<String> it = this.cacheMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    cacheMetaInfo = null;
                    break;
                }
                String next = it.next();
                if (str.contains(next)) {
                    cacheMetaInfo = this.cacheMap.get(next);
                    break;
                }
            }
            if (cacheMetaInfo != null) {
                try {
                    return new WebResourceResponse(cacheMetaInfo.mimeType, HttpUtils.DEFAULT_ENCODE_NAME, this.appContext.getAssets().open(cacheMetaInfo.path));
                } catch (Exception e) {
                    Log.e(TAG, "queryCache exception: " + e.getMessage());
                }
            }
        }
        return null;
    }

    public void clearCache() {
        HashMap<String, CacheMetaInfo> hashMap = this.cacheMap;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        this.cacheMap.clear();
    }
}
