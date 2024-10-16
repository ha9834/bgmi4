package androidx.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f812a = Log.isLoggable("MBServiceCompat", 3);
    b c;
    MediaSessionCompat.Token e;
    final androidx.b.a<IBinder, b> b = new androidx.b.a<>();
    final g d = new g();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        IBinder a();

        void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        void b() throws RemoteException;
    }

    public abstract a a(String str, int i, Bundle bundle);

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    public abstract void a(String str, c<List<MediaBrowserCompat.MediaItem>> cVar);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class g extends Handler {
        private final d b;

        g() {
            this.b = new d();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.b.a(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new f(message.replyTo));
                    return;
                case 2:
                    this.b.a(new f(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.b.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), bundle2, new f(message.replyTo));
                    return;
                case 4:
                    this.b.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), new f(message.replyTo));
                    return;
                case 5:
                    this.b.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new f(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    this.b.a(new f(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.b.b(new f(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    this.b.a(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new f(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.b.b(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new f(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f818a;
        public final int b;
        public final int c;
        public final e.a d;
        public final Bundle e;
        public final e f;
        public final HashMap<String, List<androidx.core.e.c<IBinder, Bundle>>> g = new HashMap<>();
        public a h;

        b(String str, int i, int i2, Bundle bundle, e eVar) {
            this.f818a = str;
            this.b = i;
            this.c = i2;
            this.d = new e.a(str, i, i2);
            this.e = bundle;
            this.f = eVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.d.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.b.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceCompat.this.b.remove(b.this.f.a());
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class c<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f820a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;

        void a(T t) {
        }

        c(Object obj) {
            this.f820a = obj;
        }

        public void b(T t) {
            if (this.c || this.d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f820a);
            }
            this.c = true;
            a((c<T>) t);
        }

        public void c(Bundle bundle) {
            if (this.c || this.d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f820a);
            }
            this.d = true;
            b(bundle);
        }

        boolean a() {
            return this.b || this.c || this.d;
        }

        void a(int i) {
            this.e = i;
        }

        int b() {
            return this.e;
        }

        void b(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f820a);
        }
    }

    /* loaded from: classes.dex */
    private class d {
        d() {
        }

        public void a(final String str, final int i, final int i2, final Bundle bundle, final e eVar) {
            if (!MediaBrowserServiceCompat.this.a(str, i2)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
            }
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.1
                @Override // java.lang.Runnable
                public void run() {
                    IBinder a2 = eVar.a();
                    MediaBrowserServiceCompat.this.b.remove(a2);
                    b bVar = new b(str, i, i2, bundle, eVar);
                    MediaBrowserServiceCompat.this.c = bVar;
                    bVar.h = MediaBrowserServiceCompat.this.a(str, i2, bundle);
                    MediaBrowserServiceCompat.this.c = null;
                    if (bVar.h == null) {
                        Log.i("MBServiceCompat", "No root for client " + str + " from service " + getClass().getName());
                        try {
                            eVar.b();
                            return;
                        } catch (RemoteException unused) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                            return;
                        }
                    }
                    try {
                        MediaBrowserServiceCompat.this.b.put(a2, bVar);
                        a2.linkToDeath(bVar, 0);
                        if (MediaBrowserServiceCompat.this.e != null) {
                            eVar.a(bVar.h.a(), MediaBrowserServiceCompat.this.e, bVar.h.b());
                        }
                    } catch (RemoteException unused2) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                        MediaBrowserServiceCompat.this.b.remove(a2);
                    }
                }
            });
        }

        public void a(final e eVar) {
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.2
                @Override // java.lang.Runnable
                public void run() {
                    b remove = MediaBrowserServiceCompat.this.b.remove(eVar.a());
                    if (remove != null) {
                        remove.f.a().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final e eVar) {
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.3
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str, bVar, iBinder, bundle);
                }
            });
        }

        public void a(final String str, final IBinder iBinder, final e eVar) {
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.4
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (MediaBrowserServiceCompat.this.a(str, bVar, iBinder)) {
                        return;
                    }
                    Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void a(final String str, final ResultReceiver resultReceiver, final e eVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.5
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str, bVar, resultReceiver);
                }
            });
        }

        public void a(final e eVar, final String str, final int i, final int i2, final Bundle bundle) {
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.6
                @Override // java.lang.Runnable
                public void run() {
                    IBinder a2 = eVar.a();
                    MediaBrowserServiceCompat.this.b.remove(a2);
                    b bVar = new b(str, i, i2, bundle, eVar);
                    MediaBrowserServiceCompat.this.b.put(a2, bVar);
                    try {
                        a2.linkToDeath(bVar, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void b(final e eVar) {
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder a2 = eVar.a();
                    b remove = MediaBrowserServiceCompat.this.b.remove(a2);
                    if (remove != null) {
                        a2.unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void a(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final e eVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.8
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str, bundle, bVar, resultReceiver);
                }
            });
        }

        public void b(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final e eVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.d.9
                @Override // java.lang.Runnable
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                        return;
                    }
                    MediaBrowserServiceCompat.this.b(str, bundle, bVar, resultReceiver);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        final Messenger f831a;

        f(Messenger messenger) {
            this.f831a = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e
        public IBinder a() {
            return this.f831a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e
        public void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e
        public void b() throws RemoteException {
            a(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            a(3, bundle3);
        }

        private void a(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f831a.send(obtain);
        }
    }

    public void a(String str, c<List<MediaBrowserCompat.MediaItem>> cVar, Bundle bundle) {
        cVar.a(1);
        a(str, cVar);
    }

    public void b(String str, c<MediaBrowserCompat.MediaItem> cVar) {
        cVar.a(2);
        cVar.b((c<MediaBrowserCompat.MediaItem>) null);
    }

    public void a(String str, Bundle bundle, c<List<MediaBrowserCompat.MediaItem>> cVar) {
        cVar.a(4);
        cVar.b((c<List<MediaBrowserCompat.MediaItem>>) null);
    }

    public void b(String str, Bundle bundle, c<Bundle> cVar) {
        cVar.c(null);
    }

    boolean a(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.e.c<IBinder, Bundle>> list = bVar.g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (androidx.core.e.c<IBinder, Bundle> cVar : list) {
            if (iBinder == cVar.f514a && androidx.media.d.a(bundle, cVar.b)) {
                return;
            }
        }
        list.add(new androidx.core.e.c<>(iBinder, bundle));
        bVar.g.put(str, list);
        a(str, bVar, bundle, (Bundle) null);
        this.c = bVar;
        a(str, bundle);
        this.c = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean a(String str, b bVar, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                return bVar.g.remove(str) != null;
            }
            List<androidx.core.e.c<IBinder, Bundle>> list = bVar.g.get(str);
            if (list != null) {
                Iterator<androidx.core.e.c<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().f514a) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.g.remove(str);
                }
            }
            return z;
        } finally {
            this.c = bVar;
            a(str);
            this.c = null;
        }
    }

    void a(final String str, final b bVar, final Bundle bundle, final Bundle bundle2) {
        c<List<MediaBrowserCompat.MediaItem>> cVar = new c<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.c
            public void a(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.b.get(bVar.f.a()) != bVar) {
                    if (MediaBrowserServiceCompat.f812a) {
                        Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + bVar.f818a + " id=" + str);
                        return;
                    }
                    return;
                }
                if ((b() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.a(list, bundle);
                }
                try {
                    bVar.f.a(str, list, bundle, bundle2);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str + " package=" + bVar.f818a);
                }
            }
        };
        this.c = bVar;
        if (bundle == null) {
            a(str, cVar);
        } else {
            a(str, cVar, bundle);
        }
        this.c = null;
        if (cVar.a()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.f818a + " id=" + str);
    }

    List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    void a(String str, b bVar, final ResultReceiver resultReceiver) {
        c<MediaBrowserCompat.MediaItem> cVar = new c<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.c
            public void a(MediaBrowserCompat.MediaItem mediaItem) {
                if ((b() & 2) != 0) {
                    resultReceiver.b(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.b(0, bundle);
            }
        };
        this.c = bVar;
        b(str, cVar);
        this.c = null;
        if (cVar.a()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void a(String str, Bundle bundle, b bVar, final ResultReceiver resultReceiver) {
        c<List<MediaBrowserCompat.MediaItem>> cVar = new c<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.c
            public void a(List<MediaBrowserCompat.MediaItem> list) {
                if ((b() & 4) != 0 || list == null) {
                    resultReceiver.b(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.b(0, bundle2);
            }
        };
        this.c = bVar;
        a(str, bundle, cVar);
        this.c = null;
        if (cVar.a()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    void b(String str, Bundle bundle, b bVar, final ResultReceiver resultReceiver) {
        c<Bundle> cVar = new c<Bundle>(str) { // from class: androidx.media.MediaBrowserServiceCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.c
            public void a(Bundle bundle2) {
                resultReceiver.b(0, bundle2);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.c
            void b(Bundle bundle2) {
                resultReceiver.b(-1, bundle2);
            }
        };
        this.c = bVar;
        b(str, bundle, cVar);
        this.c = null;
        if (cVar.a()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f817a;
        private final Bundle b;

        public String a() {
            return this.f817a;
        }

        public Bundle b() {
            return this.b;
        }
    }
}
