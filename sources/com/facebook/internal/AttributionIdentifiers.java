package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static AttributionIdentifiers cachedIdentifiers;
    private String androidAdvertiserIdValue;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean isTrackingLimited;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();

    public static final AttributionIdentifiers getAttributionIdentifiers(Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    public static final boolean isTrackingLimited(Context context) {
        return Companion.isTrackingLimited(context);
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }

    public final String getAndroidAdvertiserId() {
        if (FacebookSdk.isInitialized() && FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return this.androidAdvertiserIdValue;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final void setCachedIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
        }

        public final AttributionIdentifiers getCachedIdentifiers() {
            return AttributionIdentifiers.cachedIdentifiers;
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            Companion companion = this;
            AttributionIdentifiers androidIdViaReflection = companion.getAndroidIdViaReflection(context);
            if (androidIdViaReflection != null) {
                return androidIdViaReflection;
            }
            AttributionIdentifiers androidIdViaService = companion.getAndroidIdViaService(context);
            return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            Object invokeMethodQuietly;
            try {
                if (!isGooglePlayServicesAvailable(context)) {
                    return null;
                }
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null || (invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                    return null;
                }
                Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly2 != null && methodQuietly3 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                    Boolean bool = (Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                    attributionIdentifiers.isTrackingLimited = bool != null ? bool.booleanValue() : false;
                    return attributionIdentifiers;
                }
                return null;
            } catch (Exception e) {
                Utility.logd("android_id", e);
                return null;
            }
        }

        public final boolean isTrackingLimited(Context context) {
            h.b(context, "context");
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            return (invokeMethodQuietly instanceof Integer) && !(h.a(invokeMethodQuietly, (Object) 0) ^ true);
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            GoogleAdServiceConnection googleAdServiceConnection2 = googleAdServiceConnection;
            if (!context.bindService(intent, googleAdServiceConnection2, 1)) {
                return null;
            }
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
                return null;
            } finally {
                context.unbindService(googleAdServiceConnection2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0099 A[Catch: all -> 0x010e, Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:4:0x0010, B:6:0x001e, B:8:0x0027, B:12:0x0038, B:14:0x0063, B:16:0x0070, B:17:0x0090, B:19:0x0099, B:21:0x009e, B:23:0x00a6, B:25:0x00b3, B:28:0x00ba, B:31:0x00d7, B:33:0x00dd, B:36:0x00f7, B:41:0x007a, B:43:0x0087, B:45:0x0104, B:46:0x010d), top: B:3:0x0010, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[Catch: all -> 0x010e, Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:4:0x0010, B:6:0x001e, B:8:0x0027, B:12:0x0038, B:14:0x0063, B:16:0x0070, B:17:0x0090, B:19:0x0099, B:21:0x009e, B:23:0x00a6, B:25:0x00b3, B:28:0x00ba, B:31:0x00d7, B:33:0x00dd, B:36:0x00f7, B:41:0x007a, B:43:0x0087, B:45:0x0104, B:46:0x010d), top: B:3:0x0010, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[Catch: all -> 0x010e, Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:4:0x0010, B:6:0x001e, B:8:0x0027, B:12:0x0038, B:14:0x0063, B:16:0x0070, B:17:0x0090, B:19:0x0099, B:21:0x009e, B:23:0x00a6, B:25:0x00b3, B:28:0x00ba, B:31:0x00d7, B:33:0x00dd, B:36:0x00f7, B:41:0x007a, B:43:0x0087, B:45:0x0104, B:46:0x010d), top: B:3:0x0010, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r12) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            setCachedIdentifiers(attributionIdentifiers);
            return attributionIdentifiers;
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getInstallerPackageName(context.getPackageName());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class GoogleAdServiceConnection implements ServiceConnection {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final IBinder getBinder() throws InterruptedException {
            if (!(!this.consumed.compareAndSet(true, true))) {
                throw new IllegalStateException("Binder already consumed".toString());
            }
            IBinder take = this.queue.take();
            h.a((Object) take, "queue.take()");
            return take;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class GoogleAdInfo implements IInterface {
        public static final Companion Companion = new Companion(null);
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private final IBinder binder;

        public GoogleAdInfo(IBinder iBinder) {
            h.b(iBinder, "binder");
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            h.a((Object) obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            h.a((Object) obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            h.a((Object) obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            h.a((Object) obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
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
}
