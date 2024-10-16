package com.devbrackets.android.exomedia.core.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.Surface;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.b.c;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a implements Player.Listener {
    private final Context b;
    private final ExoPlayer c;
    private final DefaultTrackSelector d;
    private final AdaptiveTrackSelection.Factory e;
    private final Handler f;
    private c j;
    private Surface l;
    private MediaDrmCallback m;
    private MediaSource n;
    private List<Renderer> o;
    private com.devbrackets.android.exomedia.core.c.b q;
    private com.devbrackets.android.exomedia.a.a r;
    private AnalyticsCollector u;
    private final CopyOnWriteArrayList<com.devbrackets.android.exomedia.core.c.a> g = new CopyOnWriteArrayList<>();
    private final AtomicBoolean h = new AtomicBoolean();
    private boolean i = false;
    private com.devbrackets.android.exomedia.b.c k = new com.devbrackets.android.exomedia.b.c();
    private DefaultBandwidthMeter p = new DefaultBandwidthMeter();
    private PowerManager.WakeLock s = null;
    private int t = 0;

    /* renamed from: a, reason: collision with root package name */
    protected float f1009a = 1.0f;

    public a(Context context) {
        this.j = new c();
        this.b = context;
        this.k.a(1000);
        this.k.a(new C0073a());
        this.f = new Handler();
        b bVar = new b();
        this.o = new com.devbrackets.android.exomedia.core.d.a(context, this.f, bVar, bVar, bVar, bVar).a();
        this.e = new AdaptiveTrackSelection.Factory();
        this.d = new DefaultTrackSelector(this.e);
        LoadControl defaultLoadControl = ExoMedia.a.e != null ? ExoMedia.a.e : new DefaultLoadControl();
        List<Renderer> list = this.o;
        this.c = new ExoPlayer.Builder((Renderer[]) list.toArray(new Renderer[list.size()]), this.d, new DefaultMediaSourceFactory(context), defaultLoadControl, this.p).build();
        this.c.addListener(this);
        this.u = new AnalyticsCollector(Clock.DEFAULT);
        this.c.addListener(this.u);
    }

    public void a(MediaDrmCallback mediaDrmCallback) {
        this.m = mediaDrmCallback;
    }

    public void a(Uri uri) {
        a(uri != null ? ExoMedia.a.f.a(this.b, this.f, uri, this.p) : null);
    }

    public void a(MediaSource mediaSource) {
        MediaSource mediaSource2 = this.n;
        if (mediaSource2 != null) {
            mediaSource2.removeEventListener(this.u);
        }
        if (mediaSource != null) {
            mediaSource.addEventListener(this.f, this.u);
        }
        this.n = mediaSource;
        this.i = false;
        d();
    }

    public void a(com.devbrackets.android.exomedia.core.c.a aVar) {
        if (aVar != null) {
            this.g.add(aVar);
        }
    }

    public void b(com.devbrackets.android.exomedia.core.c.a aVar) {
        if (aVar != null) {
            this.g.remove(aVar);
        }
    }

    public void a(com.devbrackets.android.exomedia.a.a aVar) {
        this.r = aVar;
        d(aVar != null);
    }

    public void a(com.devbrackets.android.exomedia.core.c.b bVar) {
        this.q = bVar;
    }

    public void a(Surface surface) {
        this.l = surface;
        a(2, 1, surface, false);
    }

    public void a(AnalyticsListener analyticsListener) {
        this.u.addListener(analyticsListener);
    }

    public void b(AnalyticsListener analyticsListener) {
        this.u.removeListener(analyticsListener);
    }

    public void a() {
        Surface surface = this.l;
        if (surface != null) {
            surface.release();
        }
        this.l = null;
        a(2, 1, null, false);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> b() {
        if (g() == 1) {
            return null;
        }
        androidx.b.a aVar = new androidx.b.a();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.d.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            return aVar;
        }
        for (ExoMedia.RendererType rendererType : new ExoMedia.RendererType[]{ExoMedia.RendererType.AUDIO, ExoMedia.RendererType.VIDEO, ExoMedia.RendererType.CLOSED_CAPTION, ExoMedia.RendererType.METADATA}) {
            int a2 = a(rendererType);
            if (currentMappedTrackInfo.getRendererCount() > a2) {
                aVar.put(rendererType, currentMappedTrackInfo.getTrackGroups(a2));
            }
        }
        return aVar;
    }

    public float c() {
        return this.f1009a;
    }

    public void d() {
        if (this.i || this.n == null) {
            return;
        }
        if (!this.o.isEmpty()) {
            this.c.stop();
        }
        this.j.a();
        this.c.prepare(this.n);
        this.i = true;
        this.h.set(false);
    }

    public void e() {
        if (this.h.getAndSet(true)) {
            return;
        }
        this.c.setPlayWhenReady(false);
        this.c.stop();
    }

    public void a(boolean z) {
        this.c.setPlayWhenReady(z);
        c(z);
    }

    public void a(long j) {
        a(j, false);
    }

    public void a(long j, boolean z) {
        this.u.notifySeekStarted();
        if (z) {
            this.c.seekTo(j);
            c cVar = this.j;
            cVar.a(cVar.b(), 100);
            return;
        }
        Timeline currentTimeline = this.c.getCurrentTimeline();
        int windowCount = currentTimeline.getWindowCount();
        long j2 = 0;
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < windowCount; i++) {
            currentTimeline.getWindow(i, window);
            long durationMs = window.getDurationMs();
            if (j2 < j && j <= j2 + durationMs) {
                this.c.seekTo(i, j - j2);
                c cVar2 = this.j;
                cVar2.a(cVar2.b(), 100);
                return;
            }
            j2 += durationMs;
        }
        Log.e("ExoMediaPlayer", "Unable to seek across windows, falling back to in-window seeking");
        this.c.seekTo(j);
        c cVar3 = this.j;
        cVar3.a(cVar3.b(), 100);
    }

    public void f() {
        d(false);
        this.g.clear();
        MediaSource mediaSource = this.n;
        if (mediaSource != null) {
            mediaSource.removeEventListener(this.u);
        }
        this.l = null;
        this.c.release();
        c(false);
    }

    public int g() {
        return this.c.getPlaybackState();
    }

    public float h() {
        return this.c.getPlaybackParameters().speed;
    }

    public long i() {
        return b(false);
    }

    public long b(boolean z) {
        long currentPosition = this.c.getCurrentPosition();
        if (z) {
            return currentPosition;
        }
        Timeline currentTimeline = this.c.getCurrentTimeline();
        int min = Math.min(currentTimeline.getWindowCount() - 1, this.c.getCurrentWindowIndex());
        long j = 0;
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < min; i++) {
            currentTimeline.getWindow(i, window);
            j += window.getDurationMs();
        }
        return j + currentPosition;
    }

    public long j() {
        return this.c.getDuration();
    }

    public int k() {
        return this.c.getBufferedPercentage();
    }

    public com.devbrackets.android.exomedia.core.b.b l() {
        Timeline currentTimeline = this.c.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        int currentWindowIndex = this.c.getCurrentWindowIndex();
        return new com.devbrackets.android.exomedia.core.b.b(this.c.getPreviousWindowIndex(), currentWindowIndex, this.c.getNextWindowIndex(), currentTimeline.getWindow(currentWindowIndex, new Timeline.Window(), true));
    }

    public boolean m() {
        return this.c.getPlayWhenReady();
    }

    public void a(int i) {
        this.c.setRepeatMode(i);
    }

    protected int a(ExoMedia.RendererType rendererType) {
        switch (rendererType) {
            case AUDIO:
            case VIDEO:
            case CLOSED_CAPTION:
            case METADATA:
                return rendererType.ordinal();
            default:
                return -1;
        }
    }

    protected void a(int i, int i2, Object obj, boolean z) {
        if (this.o.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.o) {
            if (renderer.getTrackType() == i) {
                arrayList.add(this.c.createMessage(renderer).setType(i2).setPayload(obj));
            }
        }
        if (z) {
            a(arrayList);
            return;
        }
        Iterator<PlayerMessage> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().send();
        }
    }

    protected void a(List<PlayerMessage> list) {
        boolean z = false;
        for (PlayerMessage playerMessage : list) {
            boolean z2 = z;
            boolean z3 = true;
            while (z3) {
                try {
                    playerMessage.blockUntilDelivered();
                    z3 = false;
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            z = z2;
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    protected void c(boolean z) {
        PowerManager.WakeLock wakeLock = this.s;
        if (wakeLock == null) {
            return;
        }
        if (z && !wakeLock.isHeld()) {
            this.s.acquire(1000L);
        } else {
            if (z || !this.s.isHeld()) {
                return;
            }
            this.s.release();
        }
    }

    private void d(boolean z) {
        if (z && this.r != null) {
            this.k.a();
        } else {
            this.k.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int[] f1013a;

        public int b(boolean z, int i) {
            return (z ? -268435456 : 0) | i;
        }

        private c() {
            this.f1013a = new int[]{1, 1, 1, 1};
        }

        public void a() {
            int i = 0;
            while (true) {
                int[] iArr = this.f1013a;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = 1;
                i++;
            }
        }

        public void a(boolean z, int i) {
            int b = b(z, i);
            int[] iArr = this.f1013a;
            if (iArr[3] == b) {
                return;
            }
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = iArr[3];
            iArr[3] = i;
        }

        public boolean b() {
            return (this.f1013a[3] & (-268435456)) != 0;
        }
    }

    /* renamed from: com.devbrackets.android.exomedia.core.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0073a implements c.b {
        private C0073a() {
        }

        @Override // com.devbrackets.android.exomedia.b.c.b
        public void a() {
            if (a.this.r != null) {
                a.this.r.a(a.this.k());
            }
        }
    }

    /* loaded from: classes.dex */
    private class b implements AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener {
        private b() {
        }
    }
}
