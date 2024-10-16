package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* loaded from: classes.dex */
public final class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    private static final WorkQueue downloadQueue = new WorkQueue(8, null, 2, null);
    private static final WorkQueue cacheReadQueue = new WorkQueue(2, null, 2, null);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    private ImageDownloader() {
    }

    private final synchronized Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    public static final void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.setRequest(imageRequest);
                downloaderContext.setCancelled(false);
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem != null) {
                    workItem.moveToFront();
                    k kVar = k.f6974a;
                }
            } else {
                INSTANCE.enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                k kVar2 = k.f6974a;
            }
        }
    }

    public static final boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        h.b(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            z = true;
            if (downloaderContext != null) {
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem != null && workItem.cancel()) {
                    pendingRequests.remove(requestKey);
                } else {
                    downloaderContext.setCancelled(true);
                }
            } else {
                z = false;
            }
            k kVar = k.f6974a;
        }
        return z;
    }

    public static final void prioritizeRequest(ImageRequest imageRequest) {
        WorkQueue.WorkItem workItem;
        h.b(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null && (workItem = downloaderContext.getWorkItem()) != null) {
                workItem.moveToFront();
            }
            k kVar = k.f6974a;
        }
    }

    public static final void clearCache() {
        ImageResponseCache.clearCache();
        UrlRedirectCache.clearCache();
    }

    public final Map<RequestKey, DownloaderContext> getPendingRequests() {
        return pendingRequests;
    }

    private final void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(requestKey, z));
    }

    private final void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(requestKey));
    }

    private final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue, runnable, false, 2, null));
            k kVar = k.f6974a;
        }
    }

    private final void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        Handler handler2;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled()) {
            return;
        }
        final ImageRequest request = removePendingRequest.getRequest();
        final ImageRequest.Callback callback = request != null ? request.getCallback() : null;
        if (callback == null || (handler2 = getHandler()) == null) {
            return;
        }
        handler2.post(new Runnable() { // from class: com.facebook.internal.ImageDownloader$issueResponse$1
            @Override // java.lang.Runnable
            public final void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        callback.onCompleted(new ImageResponse(ImageRequest.this, exc, z, bitmap));
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readFromCache(RequestKey requestKey, boolean z) {
        Uri redirectedUri;
        InputStream inputStream = (InputStream) null;
        boolean z2 = false;
        if (z && (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.getUri())) != null && (inputStream = ImageResponseCache.getCachedImageStream(redirectedUri)) != null) {
            z2 = true;
        }
        if (!z2) {
            inputStream = ImageResponseCache.getCachedImageStream(requestKey.getUri());
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(requestKey, null, decodeStream, z2);
            return;
        }
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        ImageRequest request = removePendingRequest != null ? removePendingRequest.getRequest() : null;
        if (removePendingRequest == null || removePendingRequest.isCancelled() || request == null) {
            return;
        }
        enqueueDownload(request, requestKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void download(com.facebook.internal.ImageDownloader.RequestKey r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    private final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(requestKey);
        }
        return remove;
    }

    /* loaded from: classes.dex */
    public static final class RequestKey {
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private Object tag;
        private Uri uri;

        public RequestKey(Uri uri, Object obj) {
            h.b(uri, ShareConstants.MEDIA_URI);
            h.b(obj, ViewHierarchyConstants.TAG_KEY);
            this.uri = uri;
            this.tag = obj;
        }

        public final Object getTag() {
            return this.tag;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final void setTag(Object obj) {
            h.b(obj, "<set-?>");
            this.tag = obj;
        }

        public final void setUri(Uri uri) {
            h.b(uri, "<set-?>");
            this.uri = uri;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            return requestKey.uri == this.uri && requestKey.tag == this.tag;
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class DownloaderContext {
        private boolean isCancelled;
        private ImageRequest request;
        private WorkQueue.WorkItem workItem;

        public DownloaderContext(ImageRequest imageRequest) {
            h.b(imageRequest, "request");
            this.request = imageRequest;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final void setRequest(ImageRequest imageRequest) {
            h.b(imageRequest, "<set-?>");
            this.request = imageRequest;
        }

        public final WorkQueue.WorkItem getWorkItem() {
            return this.workItem;
        }

        public final void setWorkItem(WorkQueue.WorkItem workItem) {
            this.workItem = workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z) {
            this.isCancelled = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CacheReadWorkItem implements Runnable {
        private final boolean allowCachedRedirects;
        private final RequestKey key;

        public CacheReadWorkItem(RequestKey requestKey, boolean z) {
            h.b(requestKey, "key");
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class DownloadImageWorkItem implements Runnable {
        private final RequestKey key;

        public DownloadImageWorkItem(RequestKey requestKey) {
            h.b(requestKey, "key");
            this.key = requestKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ImageDownloader.INSTANCE.download(this.key);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
