package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes.dex */
class a {

    /* renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    interface InterfaceC0011a {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes.dex */
    interface d {
        void a(String str);

        void a(String str, List<?> list);
    }

    public static Object a(InterfaceC0011a interfaceC0011a) {
        return new b(interfaceC0011a);
    }

    public static Object a(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static void b(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle c(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object d(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static Object a(d dVar) {
        return new e(dVar);
    }

    /* loaded from: classes.dex */
    static class b<T extends InterfaceC0011a> extends MediaBrowser.ConnectionCallback {

        /* renamed from: a, reason: collision with root package name */
        protected final T f80a;

        public b(T t) {
            this.f80a = t;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f80a.a();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f80a.b();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f80a.c();
        }
    }

    /* loaded from: classes.dex */
    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* renamed from: a, reason: collision with root package name */
        protected final T f81a;

        public e(T t) {
            this.f81a = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.f81a.a(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.f81a.a(str);
        }
    }

    /* loaded from: classes.dex */
    static class c {
        public static int a(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        public static Object b(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }
    }
}
