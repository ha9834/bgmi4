package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import androidx.b.e;
import androidx.core.graphics.a;
import com.helpshift.util.HSLogger;

/* loaded from: classes2.dex */
class BitmapLruCache {
    private static final int CACHE_SIZE = 8388608;
    private static final float MEMORY_FRACTION = 0.15f;
    private static final String TAG = "Helpshift_BtmpLruCache";
    private final e<String, Bitmap> cache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapLruCache() {
        int round = Math.round(((float) Runtime.getRuntime().maxMemory()) * MEMORY_FRACTION);
        this.cache = new e<String, Bitmap>(round >= CACHE_SIZE ? CACHE_SIZE : round) { // from class: com.helpshift.support.imageloader.BitmapLruCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.b.e
            public int sizeOf(String str, Bitmap bitmap) {
                return a.a(bitmap);
            }
        };
    }

    public Bitmap get(String str) {
        if (str == null) {
            return null;
        }
        HSLogger.d(TAG, "Bitmap loaded from cache with key: " + str);
        return this.cache.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(String str, Bitmap bitmap) {
        if (a.a(bitmap) > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, bitmap);
        }
    }

    private int maxSize() {
        return this.cache.maxSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.cache.evictAll();
    }
}
