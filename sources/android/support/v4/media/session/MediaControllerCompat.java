package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    private final b f82a;
    private final MediaSessionCompat.Token b;
    private final HashSet<a> c = new HashSet<>();

    /* loaded from: classes.dex */
    interface b {
        boolean a(KeyEvent keyEvent);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.b = token;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f82a = new d(context, token);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f82a = new c(context, token);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f82a = new MediaControllerImplApi21(context, token);
        } else {
            this.f82a = new e(token);
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.f82a.a(keyEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        final Object f85a;
        HandlerC0013a b;
        android.support.v4.media.session.a c;

        public void a() {
        }

        public void a(int i) {
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(f fVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f85a = android.support.v4.media.session.c.a(new b(this));
                return;
            }
            c cVar = new c(this);
            this.c = cVar;
            this.f85a = cVar;
        }

        void a(int i, Object obj, Bundle bundle) {
            HandlerC0013a handlerC0013a = this.b;
            if (handlerC0013a != null) {
                Message obtainMessage = handlerC0013a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* loaded from: classes.dex */
        private static class b implements c.a {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f87a;

            b(a aVar) {
                this.f87a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.c.a
            public void a() {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(String str, Bundle bundle) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    if (aVar.c == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.a(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object obj) {
                a aVar = this.f87a.get();
                if (aVar == null || aVar.c != null) {
                    return;
                }
                aVar.a(PlaybackStateCompat.a(obj));
            }

            @Override // android.support.v4.media.session.c.a
            public void b(Object obj) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(List<?> list) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(CharSequence charSequence) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Bundle bundle) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = this.f87a.get();
                if (aVar != null) {
                    aVar.a(new f(i, i2, i3, i4, i5));
                }
            }
        }

        /* loaded from: classes.dex */
        private static class c extends a.AbstractBinderC0014a {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f88a;

            @Override // android.support.v4.media.session.a
            public void a(boolean z) throws RemoteException {
            }

            c(a aVar) {
                this.f88a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void a(String str, Bundle bundle) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean z) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(int i) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(int i) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new f(parcelableVolumeInfo.f94a, parcelableVolumeInfo.b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e) : null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b() throws RemoteException {
                a aVar = this.f88a.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0013a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            boolean f86a;
            final /* synthetic */ a b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f86a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.b.a((String) message.obj, data);
                            return;
                        case 2:
                            this.b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.b.a((f) message.obj);
                            return;
                        case 5:
                            this.b.a((List<MediaSessionCompat.QueueItem>) message.obj);
                            return;
                        case 6:
                            this.b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.b.a(bundle);
                            return;
                        case 8:
                            this.b.b();
                            return;
                        case 9:
                            this.b.a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                        default:
                            return;
                        case 11:
                            this.b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.b.b(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.b.a();
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private final int f90a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        f(int i, int i2, int i3, int i4, int i5) {
            this.f90a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    /* loaded from: classes.dex */
    static class e implements b {

        /* renamed from: a, reason: collision with root package name */
        private android.support.v4.media.session.b f89a;

        public e(MediaSessionCompat.Token token) {
            this.f89a = b.a.a((IBinder) token.a());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f89a.a(keyEvent);
                return false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements b {

        /* renamed from: a, reason: collision with root package name */
        protected final Object f83a;
        final MediaSessionCompat.Token c;
        final Object b = new Object();
        private final List<a> d = new ArrayList();
        private HashMap<a, a> e = new HashMap<>();

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.c = token;
            this.f83a = android.support.v4.media.session.c.a(context, this.c.a());
            if (this.f83a == null) {
                throw new RemoteException();
            }
            if (this.c.b() == null) {
                b();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent keyEvent) {
            return android.support.v4.media.session.c.a(this.f83a, keyEvent);
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            android.support.v4.media.session.c.a(this.f83a, str, bundle, resultReceiver);
        }

        private void b() {
            a("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void a() {
            if (this.c.b() == null) {
                return;
            }
            for (a aVar : this.d) {
                a aVar2 = new a(aVar);
                this.e.put(aVar, aVar2);
                aVar.c = aVar2;
                try {
                    this.c.b().a(aVar2);
                    aVar.a(13, null, null);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.d.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f84a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f84a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f84a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.b) {
                    mediaControllerImplApi21.c.a(b.a.a(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.c.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    /* loaded from: classes.dex */
    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }
}
