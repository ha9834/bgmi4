package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* loaded from: classes.dex */
class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = "com.facebook.appevents.AppEventStore";

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = readAndClearStore();
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                saveEventsToDisk(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = readAndClearStore();
                for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                    readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
                }
                saveEventsToDisk(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[Catch: Throwable -> 0x009a, all -> 0x00a2, TRY_LEAVE, TryCatch #0 {Throwable -> 0x009a, blocks: (B:11:0x000e, B:17:0x002b, B:19:0x002e, B:21:0x0093, B:26:0x0039, B:39:0x004f, B:41:0x0052, B:44:0x005d, B:36:0x0061, B:50:0x0066, B:52:0x0069, B:53:0x007b, B:56:0x0074, B:29:0x007d, B:31:0x0080, B:35:0x008b), top: B:10:0x000e, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.content.Context] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch: java.lang.Throwable -> La2
            r2 = 0
            if (r1 == 0) goto Le
            monitor-exit(r0)
            return r2
        Le:
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.FileNotFoundException -> L7c
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.FileNotFoundException -> L7c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.FileNotFoundException -> L7c
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.FileNotFoundException -> L7c
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.FileNotFoundException -> L7c
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L65 java.io.FileNotFoundException -> L7d
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L65 java.io.FileNotFoundException -> L7d
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L9a java.lang.Throwable -> La2
            r1.delete()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L91
        L38:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L91
        L41:
            r3 = move-exception
            goto L48
        L43:
            r3 = move-exception
            r4 = r2
            goto L66
        L46:
            r3 = move-exception
            r4 = r2
        L48:
            java.lang.String r5 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L65
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L65
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L9a java.lang.Throwable -> La2
            r1.delete()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L90
        L5c:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L61:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L90
        L65:
            r3 = move-exception
        L66:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9a java.lang.Throwable -> La2
            r1.delete()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L7b
        L73:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
        L7b:
            throw r3     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
        L7c:
            r4 = r2
        L7d:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L9a java.lang.Throwable -> La2
            r1.delete()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L9a java.lang.Throwable -> La2
            goto L90
        L8a:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L61
        L90:
            r3 = r2
        L91:
            if (r3 != 0) goto L98
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
            r3.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> La2
        L98:
            monitor-exit(r0)
            return r3
        L9a:
            r1 = move-exception
            java.lang.Class<com.facebook.appevents.AppEventStore> r3 = com.facebook.appevents.AppEventStore.class
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r3)     // Catch: java.lang.Throwable -> La2
            monitor-exit(r0)
            return r2
        La2:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    protected static void saveEventsToDisk(PersistedEvents persistedEvents) {
        ObjectOutputStream objectOutputStream;
        if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            return;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream2 = objectOutputStream;
                Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception unused) {
                }
                Utility.closeQuietly(objectOutputStream2);
            }
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(th4, AppEventStore.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME) ? ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class) : readClassDescriptor;
        }
    }
}
