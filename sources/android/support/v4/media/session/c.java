package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
class c {

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4, int i5);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);
    }

    public static Object a(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    public static boolean a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static void a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    /* renamed from: android.support.v4.media.session.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }

        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* loaded from: classes.dex */
    static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a, reason: collision with root package name */
        protected final T f99a;

        public b(T t) {
            this.f99a = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f99a.a();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f99a.a(str, bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f99a.a(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f99a.b(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f99a.a(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f99a.a(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f99a.a(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f99a.a(playbackInfo.getPlaybackType(), C0017c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
