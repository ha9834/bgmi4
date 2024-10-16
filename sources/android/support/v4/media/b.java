package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.a;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* loaded from: classes.dex */
class b {

    /* loaded from: classes.dex */
    interface a extends a.d {
        void a(String str, Bundle bundle);

        void a(String str, List<?> list, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(a aVar) {
        return new C0012b(aVar);
    }

    /* renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0012b<T extends a> extends a.e<T> {
        C0012b(T t) {
            super(t);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((a) this.f81a).a(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((a) this.f81a).a(str, bundle);
        }
    }
}
