package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f60a = Log.isLoggable("MediaBrowserCompat", 3);
    private final e b;

    /* loaded from: classes.dex */
    public static abstract class c {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    /* loaded from: classes.dex */
    interface e {
        void d();

        void e();

        MediaSessionCompat.Token f();
    }

    /* loaded from: classes.dex */
    interface j {
        void a(Messenger messenger);

        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b = new h(context, componentName, bVar, bundle);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.b = new g(context, componentName, bVar, bundle);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.b = new f(context, componentName, bVar, bundle);
        } else {
            this.b = new i(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.b.d();
    }

    public void b() {
        this.b.e();
    }

    public MediaSessionCompat.Token c() {
        return this.b.f();
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final int f61a;
        private final MediaDescriptionCompat b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static MediaItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.a(a.c.b(obj)), a.c.a(obj));
        }

        public static List<MediaItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.a())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f61a = i;
            this.b = mediaDescriptionCompat;
        }

        MediaItem(Parcel parcel) {
            this.f61a = parcel.readInt();
            this.b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f61a);
            this.b.writeToParcel(parcel, i);
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f61a + ", mDescription=" + this.b + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f63a;
        a b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface a {
            void a();

            void b();

            void c();
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public b() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f63a = android.support.v4.media.a.a((a.InterfaceC0011a) new C0010b());
            } else {
                this.f63a = null;
            }
        }

        void a(a aVar) {
            this.b = aVar;
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0010b implements a.InterfaceC0011a {
            C0010b() {
            }

            @Override // android.support.v4.media.a.InterfaceC0011a
            public void a() {
                if (b.this.b != null) {
                    b.this.b.a();
                }
                b.this.a();
            }

            @Override // android.support.v4.media.a.InterfaceC0011a
            public void b() {
                if (b.this.b != null) {
                    b.this.b.b();
                }
                b.this.b();
            }

            @Override // android.support.v4.media.a.InterfaceC0011a
            public void c() {
                if (b.this.b != null) {
                    b.this.b.c();
                }
                b.this.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {

        /* renamed from: a, reason: collision with root package name */
        final Object f74a;
        final IBinder b = new Binder();
        WeakReference<m> c;

        public void a(String str) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(String str, List<MediaItem> list) {
        }

        public void a(String str, List<MediaItem> list, Bundle bundle) {
        }

        public n() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f74a = android.support.v4.media.b.a(new b());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f74a = android.support.v4.media.a.a((a.d) new a());
            } else {
                this.f74a = null;
            }
        }

        /* loaded from: classes.dex */
        private class a implements a.d {
            a() {
            }

            @Override // android.support.v4.media.a.d
            public void a(String str, List<?> list) {
                m mVar = n.this.c == null ? null : n.this.c.get();
                if (mVar == null) {
                    n.this.a(str, MediaItem.a(list));
                    return;
                }
                List<MediaItem> a2 = MediaItem.a(list);
                List<n> b = mVar.b();
                List<Bundle> a3 = mVar.a();
                for (int i = 0; i < b.size(); i++) {
                    Bundle bundle = a3.get(i);
                    if (bundle == null) {
                        n.this.a(str, a2);
                    } else {
                        n.this.a(str, a(a2, bundle), bundle);
                    }
                }
            }

            @Override // android.support.v4.media.a.d
            public void a(String str) {
                n.this.a(str);
            }

            List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }
        }

        /* loaded from: classes.dex */
        private class b extends a implements b.a {
            b() {
                super();
            }

            @Override // android.support.v4.media.b.a
            public void a(String str, List<?> list, Bundle bundle) {
                n.this.a(str, MediaItem.a(list), bundle);
            }

            @Override // android.support.v4.media.b.a
            public void a(String str, Bundle bundle) {
                n.this.a(str, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i implements e, j {

        /* renamed from: a, reason: collision with root package name */
        final Context f66a;
        final ComponentName b;
        final b c;
        final Bundle d;
        a g;
        l h;
        Messenger i;
        private String k;
        private MediaSessionCompat.Token l;
        private Bundle m;
        private Bundle n;
        final a e = new a(this);
        private final androidx.b.a<String, m> j = new androidx.b.a<>();
        int f = 1;

        public i(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (bVar == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.f66a = context;
            this.b = componentName;
            this.c = bVar;
            this.d = bundle == null ? null : new Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void d() {
            int i = this.f;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f) + ")");
            }
            this.f = 2;
            this.e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f == 0) {
                        return;
                    }
                    i.this.f = 2;
                    if (MediaBrowserCompat.f60a && i.this.g != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + i.this.g);
                    }
                    if (i.this.h != null) {
                        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + i.this.h);
                    }
                    if (i.this.i != null) {
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + i.this.i);
                    }
                    Intent intent = new Intent("android.media.browse.MediaBrowserService");
                    intent.setComponent(i.this.b);
                    i iVar = i.this;
                    iVar.g = new a();
                    boolean z = false;
                    try {
                        z = i.this.f66a.bindService(intent, i.this.g, 1);
                    } catch (Exception unused) {
                        Log.e("MediaBrowserCompat", "Failed binding to service " + i.this.b);
                    }
                    if (!z) {
                        i.this.a();
                        i.this.c.c();
                    }
                    if (MediaBrowserCompat.f60a) {
                        Log.d("MediaBrowserCompat", "connect...");
                        i.this.c();
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void e() {
            this.f = 0;
            this.e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.i != null) {
                        try {
                            i.this.h.a(i.this.i);
                        } catch (RemoteException unused) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + i.this.b);
                        }
                    }
                    int i = i.this.f;
                    i.this.a();
                    if (i != 0) {
                        i.this.f = i;
                    }
                    if (MediaBrowserCompat.f60a) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        i.this.c();
                    }
                }
            });
        }

        void a() {
            a aVar = this.g;
            if (aVar != null) {
                this.f66a.unbindService(aVar);
            }
            this.f = 1;
            this.g = null;
            this.h = null;
            this.i = null;
            this.e.a(null);
            this.k = null;
            this.l = null;
        }

        public boolean b() {
            return this.f == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public MediaSessionCompat.Token f() {
            if (!b()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f + ")");
            }
            return this.l;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
                    return;
                }
                this.k = str;
                this.l = token;
                this.m = bundle;
                this.f = 3;
                if (MediaBrowserCompat.f60a) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    c();
                }
                this.c.a();
                try {
                    for (Map.Entry<String, m> entry : this.j.entrySet()) {
                        String key = entry.getKey();
                        m value = entry.getValue();
                        List<n> b = value.b();
                        List<Bundle> a2 = value.a();
                        for (int i = 0; i < b.size(); i++) {
                            this.h.a(key, b.get(i).b, a2.get(i), this.i);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.b);
            if (a(messenger, "onConnectFailed")) {
                if (this.f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
                    return;
                }
                a();
                this.c.c();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f60a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.b + " id=" + str);
                }
                m mVar = this.j.get(str);
                if (mVar == null) {
                    if (MediaBrowserCompat.f60a) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                n a2 = mVar.a(bundle);
                if (a2 != null) {
                    if (bundle == null) {
                        if (list == null) {
                            a2.a(str);
                            return;
                        }
                        this.n = bundle2;
                        a2.a(str, (List<MediaItem>) list);
                        this.n = null;
                        return;
                    }
                    if (list == null) {
                        a2.a(str, bundle);
                        return;
                    }
                    this.n = bundle2;
                    a2.a(str, list, bundle);
                    this.n = null;
                }
            }
        }

        private static String a(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        private boolean a(Messenger messenger, String str) {
            int i;
            if (this.i == messenger && (i = this.f) != 0 && i != 1) {
                return true;
            }
            int i2 = this.f;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.b + " with mCallbacksMessenger=" + this.i + " this=" + this);
            return false;
        }

        void c() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.d);
            Log.d("MediaBrowserCompat", "  mState=" + a(this.f));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.g);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.h);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.i);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a implements ServiceConnection {
            a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f60a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            i.this.c();
                        }
                        if (a.this.a("onServiceConnected")) {
                            i.this.h = new l(iBinder, i.this.d);
                            i.this.i = new Messenger(i.this.e);
                            i.this.e.a(i.this.i);
                            i.this.f = 2;
                            try {
                                if (MediaBrowserCompat.f60a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    i.this.c();
                                }
                                i.this.h.a(i.this.f66a, i.this.i);
                            } catch (RemoteException unused) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + i.this.b);
                                if (MediaBrowserCompat.f60a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    i.this.c();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.i.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f60a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + i.this.g);
                            i.this.c();
                        }
                        if (a.this.a("onServiceDisconnected")) {
                            i.this.h = null;
                            i.this.i = null;
                            i.this.e.a(null);
                            i.this.f = 4;
                            i.this.c.b();
                        }
                    }
                });
            }

            private void a(Runnable runnable) {
                if (Thread.currentThread() == i.this.e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    i.this.e.post(runnable);
                }
            }

            boolean a(String str) {
                if (i.this.g == this && i.this.f != 0 && i.this.f != 1) {
                    return true;
                }
                if (i.this.f == 0 || i.this.f == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + i.this.b + " with mServiceConnection=" + i.this.g + " this=" + this);
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    static class f implements b.a, e, j {

        /* renamed from: a, reason: collision with root package name */
        final Context f65a;
        protected final Object b;
        protected final Bundle c;
        protected int e;
        protected l f;
        protected Messenger g;
        private MediaSessionCompat.Token i;
        private Bundle j;
        protected final a d = new a(this);
        private final androidx.b.a<String, m> h = new androidx.b.a<>();

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void c() {
        }

        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.f65a = context;
            this.c = bundle != null ? new Bundle(bundle) : new Bundle();
            this.c.putInt("extra_client_version", 1);
            bVar.a(this);
            this.b = android.support.v4.media.a.a(context, componentName, bVar.f63a, this.c);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void d() {
            android.support.v4.media.a.a(this.b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void e() {
            Messenger messenger;
            l lVar = this.f;
            if (lVar != null && (messenger = this.g) != null) {
                try {
                    lVar.b(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.a.b(this.b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public MediaSessionCompat.Token f() {
            if (this.i == null) {
                this.i = MediaSessionCompat.Token.a(android.support.v4.media.a.d(this.b));
            }
            return this.i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void a() {
            Bundle c = android.support.v4.media.a.c(this.b);
            if (c == null) {
                return;
            }
            this.e = c.getInt("extra_service_version", 0);
            IBinder a2 = androidx.core.app.e.a(c, "extra_messenger");
            if (a2 != null) {
                this.f = new l(a2, this.c);
                this.g = new Messenger(this.d);
                this.d.a(this.g);
                try {
                    this.f.b(this.f65a, this.g);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            android.support.v4.media.session.b a3 = b.a.a(androidx.core.app.e.a(c, "extra_session_binder"));
            if (a3 != null) {
                this.i = MediaSessionCompat.Token.a(android.support.v4.media.a.d(this.b), a3);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            this.f = null;
            this.g = null;
            this.i = null;
            this.d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.g != messenger) {
                return;
            }
            m mVar = this.h.get(str);
            if (mVar == null) {
                if (MediaBrowserCompat.f60a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            n a2 = mVar.a(bundle);
            if (a2 != null) {
                if (bundle == null) {
                    if (list == null) {
                        a2.a(str);
                        return;
                    }
                    this.j = bundle2;
                    a2.a(str, (List<MediaItem>) list);
                    this.j = null;
                    return;
                }
                if (list == null) {
                    a2.a(str, bundle);
                    return;
                }
                this.j = bundle2;
                a2.a(str, list, bundle);
                this.j = null;
            }
        }
    }

    /* loaded from: classes.dex */
    static class g extends f {
        g(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class h extends g {
        h(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    private static class m {

        /* renamed from: a, reason: collision with root package name */
        private final List<n> f73a = new ArrayList();
        private final List<Bundle> b = new ArrayList();

        public List<Bundle> a() {
            return this.b;
        }

        public List<n> b() {
            return this.f73a;
        }

        public n a(Bundle bundle) {
            for (int i = 0; i < this.b.size(); i++) {
                if (androidx.media.d.a(this.b.get(i), bundle)) {
                    return this.f73a.get(i);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f62a;
        private WeakReference<Messenger> b;

        a(j jVar) {
            this.f62a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null || this.f62a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            j jVar = this.f62a.get();
            Messenger messenger = this.b.get();
            try {
                switch (message.what) {
                    case 1:
                        Bundle bundle = data.getBundle("data_root_hints");
                        MediaSessionCompat.a(bundle);
                        jVar.a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                        break;
                    case 2:
                        jVar.a(messenger);
                        break;
                    case 3:
                        Bundle bundle2 = data.getBundle("data_options");
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                        MediaSessionCompat.a(bundle3);
                        jVar.a(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                        break;
                    default:
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                        break;
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    jVar.a(messenger);
                }
            }
        }

        void a(Messenger messenger) {
            this.b = new WeakReference<>(messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f72a;
        private Bundle b;

        public l(IBinder iBinder, Bundle bundle) {
            this.f72a = new Messenger(iBinder);
            this.b = bundle;
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.b);
            a(1, bundle, messenger);
        }

        void a(Messenger messenger) throws RemoteException {
            a(2, null, messenger);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            androidx.core.app.e.a(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            a(3, bundle2, messenger);
        }

        void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.b);
            a(6, bundle, messenger);
        }

        void b(Messenger messenger) throws RemoteException {
            a(7, null, messenger);
        }

        private void a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f72a.send(obtain);
        }
    }

    /* loaded from: classes.dex */
    private static class ItemReceiver extends ResultReceiver {
        private final String d;
        private final d e;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.e.a(this.d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.e.a((MediaItem) parcelable);
            } else {
                this.e.a(this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final k f;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f.a(this.d, this.e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f.a(this.d, this.e, arrayList);
        }
    }

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final c f;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i, Bundle bundle) {
            if (this.f == null) {
                return;
            }
            MediaSessionCompat.a(bundle);
            switch (i) {
                case -1:
                    this.f.c(this.d, this.e, bundle);
                    return;
                case 0:
                    this.f.b(this.d, this.e, bundle);
                    return;
                case 1:
                    this.f.a(this.d, this.e, bundle);
                    return;
                default:
                    Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.e + ", resultData=" + bundle + ")");
                    return;
            }
        }
    }
}
