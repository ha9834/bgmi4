package com.tencent.grobot.lite.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

/* loaded from: classes2.dex */
public final class BitmapPools implements ComponentRef {
    private static final String TAG = "BitmapPools";
    private final SparseArray<Bitmap> bitmaps = new SparseArray<>(10);
    private static final Object sLock = new Object();
    private static BitmapPools sInstance = null;

    public static BitmapPools getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new BitmapPools();
                }
            }
        }
        return sInstance;
    }

    public static void destroy() {
        BitmapPools bitmapPools = sInstance;
        if (bitmapPools != null) {
            bitmapPools.onDestroy();
        }
        sInstance = null;
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        for (int i = 0; i < this.bitmaps.size(); i++) {
            Bitmap valueAt = this.bitmaps.valueAt(i);
            if (!valueAt.isRecycled()) {
                valueAt.recycle();
            }
        }
        this.bitmaps.clear();
    }

    public Bitmap decodeResource(Context context, int i) {
        Bitmap bitmap = this.bitmaps.get(i);
        if (bitmap != null) {
            return bitmap;
        }
        synchronized (sLock) {
            Bitmap bitmap2 = this.bitmaps.get(i);
            if (bitmap2 != null) {
                return bitmap2;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            options.inSampleSize = 1;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i, options);
            TLog.d(TAG, "decodeResourceBitmap, size=" + (decodeResource.getByteCount() / 1048576.0f));
            this.bitmaps.put(i, decodeResource);
            return decodeResource;
        }
    }
}
