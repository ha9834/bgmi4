package com.devbrackets.android.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.a.f;
import com.devbrackets.android.exomedia.b.e;
import com.devbrackets.android.exomedia.core.a;
import com.devbrackets.android.exomedia.core.video.scale.ScaleType;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.tencent.grobot.lite.R;
import java.util.Map;

/* loaded from: classes.dex */
public class VideoView extends RelativeLayout {
    private static final String q = "VideoView";

    /* renamed from: a, reason: collision with root package name */
    protected com.devbrackets.android.exomedia.ui.widget.b f1041a;
    protected ImageView b;
    protected Uri c;
    protected com.devbrackets.android.exomedia.core.a.a d;
    protected com.devbrackets.android.exomedia.b.a e;
    protected AudioManager f;
    protected b g;
    protected long h;
    protected long i;
    protected boolean j;
    protected boolean k;
    protected e l;
    protected c m;
    protected com.devbrackets.android.exomedia.core.a n;
    protected boolean o;
    protected boolean p;

    public VideoView(Context context) {
        super(context);
        this.e = new com.devbrackets.android.exomedia.b.a();
        this.g = new b();
        this.h = 0L;
        this.i = -1L;
        this.j = false;
        this.k = true;
        this.l = new e();
        this.m = new c();
        this.o = true;
        this.p = true;
        a(context, (AttributeSet) null);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new com.devbrackets.android.exomedia.b.a();
        this.g = new b();
        this.h = 0L;
        this.i = -1L;
        this.j = false;
        this.k = true;
        this.l = new e();
        this.m = new c();
        this.o = true;
        this.p = true;
        a(context, attributeSet);
    }

    @TargetApi(11)
    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new com.devbrackets.android.exomedia.b.a();
        this.g = new b();
        this.h = 0L;
        this.i = -1L;
        this.j = false;
        this.k = true;
        this.l = new e();
        this.m = new c();
        this.o = true;
        this.p = true;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public VideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = new com.devbrackets.android.exomedia.b.a();
        this.g = new b();
        this.h = 0L;
        this.i = -1L;
        this.j = false;
        this.k = true;
        this.l = new e();
        this.m = new c();
        this.o = true;
        this.p = true;
        a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isInEditMode() || !this.o) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.d.setOnTouchListener(onTouchListener);
        super.setOnTouchListener(onTouchListener);
    }

    public void setReleaseOnDetachFromWindow(boolean z) {
        this.o = z;
    }

    public void a() {
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.onDetachedFromView(this);
            this.f1041a = null;
        }
        f();
        this.l.a();
        this.d.d();
    }

    public void setPreviewImage(Drawable drawable) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setPreviewImage(int i) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setPreviewImage(Uri uri) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageURI(uri);
        }
    }

    public ImageView getPreviewImageView() {
        return this.b;
    }

    @Deprecated
    public void setControls(com.devbrackets.android.exomedia.ui.widget.a aVar) {
        setControls((com.devbrackets.android.exomedia.ui.widget.b) aVar);
    }

    public void setControls(com.devbrackets.android.exomedia.ui.widget.b bVar) {
        com.devbrackets.android.exomedia.ui.widget.b bVar2 = this.f1041a;
        if (bVar2 != null && bVar2 != bVar) {
            bVar2.onDetachedFromView(this);
        }
        this.f1041a = bVar;
        com.devbrackets.android.exomedia.ui.widget.b bVar3 = this.f1041a;
        if (bVar3 != null) {
            bVar3.onAttachedToView(this);
        }
        d dVar = new d(getContext());
        if (this.f1041a == null) {
            dVar = null;
        }
        setOnTouchListener(dVar);
    }

    public void b() {
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.show();
            if (c()) {
                this.f1041a.hide(true);
            }
        }
    }

    @Deprecated
    public com.devbrackets.android.exomedia.ui.widget.a getVideoControls() {
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar == null || !(bVar instanceof com.devbrackets.android.exomedia.ui.widget.a)) {
            return null;
        }
        return (com.devbrackets.android.exomedia.ui.widget.a) bVar;
    }

    public com.devbrackets.android.exomedia.ui.widget.b getVideoControlsCore() {
        return this.f1041a;
    }

    public void setVideoURI(Uri uri) {
        this.c = uri;
        this.d.setVideoUri(uri);
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.showLoading(true);
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public Uri getVideoUri() {
        return this.c;
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.d.setDrmCallback(mediaDrmCallback);
    }

    public float getVolume() {
        return this.d.getVolume();
    }

    public void setHandleAudioFocus(boolean z) {
        this.g.b();
        this.p = z;
    }

    public void a(long j) {
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.showLoading(false);
        }
        this.d.a(j);
    }

    public boolean c() {
        return this.d.a();
    }

    public void d() {
        if (this.g.a()) {
            this.d.b();
            setKeepScreenOn(true);
            com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
            if (bVar != null) {
                bVar.updatePlaybackState(true);
            }
        }
    }

    public void e() {
        a(false);
    }

    public void a(boolean z) {
        if (!z) {
            this.g.b();
        }
        this.d.c();
        setKeepScreenOn(false);
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.updatePlaybackState(false);
        }
    }

    public void f() {
        b(true);
    }

    public long getDuration() {
        long j = this.i;
        return j >= 0 ? j : this.d.getDuration();
    }

    public long getCurrentPosition() {
        if (this.j) {
            return this.h + this.l.c();
        }
        return this.h + this.d.getCurrentPosition();
    }

    public void setPositionOffset(long j) {
        this.h = j;
    }

    public void setOverridePositionMatchesPlaybackSpeed(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                this.l.a(getPlaybackSpeed());
            } else {
                this.l.a(1.0f);
            }
        }
    }

    public int getBufferPercentage() {
        return this.d.getBufferedPercent();
    }

    public com.devbrackets.android.exomedia.core.b.b getWindowInfo() {
        return this.d.getWindowInfo();
    }

    public void setRepeatMode(int i) {
        this.d.setRepeatMode(i);
    }

    public float getPlaybackSpeed() {
        return this.d.getPlaybackSpeed();
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.d.getAvailableTracks();
    }

    public void setScaleType(ScaleType scaleType) {
        this.d.setScaleType(scaleType);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.d.setMeasureBasedOnAspectRatioEnabled(z);
    }

    public void setVideoRotation(int i) {
        this.d.a(i, true);
    }

    public void setOnPreparedListener(com.devbrackets.android.exomedia.a.d dVar) {
        this.n.a(dVar);
    }

    public void setOnCompletionListener(com.devbrackets.android.exomedia.a.b bVar) {
        this.n.a(bVar);
    }

    public void setOnBufferUpdateListener(com.devbrackets.android.exomedia.a.a aVar) {
        this.n.a(aVar);
    }

    public void setOnSeekCompletionListener(com.devbrackets.android.exomedia.a.e eVar) {
        this.n.a(eVar);
    }

    public void setOnErrorListener(com.devbrackets.android.exomedia.a.c cVar) {
        this.n.a(cVar);
    }

    public void setId3MetadataListener(com.devbrackets.android.exomedia.core.c.b bVar) {
        this.n.a(bVar);
    }

    public void setAnalyticsListener(AnalyticsListener analyticsListener) {
        this.n.a(analyticsListener);
    }

    public void setOnVideoSizedChangedListener(f fVar) {
        this.m.f1044a = fVar;
    }

    public Bitmap getBitmap() {
        Object obj = this.d;
        if (obj instanceof TextureView) {
            return ((TextureView) obj).getBitmap();
        }
        return null;
    }

    protected void a(Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        this.f = (AudioManager) context.getApplicationContext().getSystemService("audio");
        a aVar = new a(context, attributeSet);
        a(context, aVar);
        a(aVar);
    }

    protected void a(Context context, a aVar) {
        b(context, aVar);
        this.b = (ImageView) findViewById(R.id.exomedia_video_preview_image);
        this.d = (com.devbrackets.android.exomedia.core.a.a) findViewById(R.id.exomedia_video_view);
        this.m = new c();
        this.n = new com.devbrackets.android.exomedia.core.a(this.m);
        this.d.setListenerMux(this.n);
    }

    protected void a(a aVar) {
        if (aVar.f1042a) {
            setControls(this.e.b(getContext()) ? new com.devbrackets.android.exomedia.ui.widget.c(getContext()) : new com.devbrackets.android.exomedia.ui.widget.d(getContext()));
        }
        if (aVar.e != null) {
            setScaleType(aVar.e);
        }
        if (aVar.f != null) {
            setMeasureBasedOnAspectRatioEnabled(aVar.f.booleanValue());
        }
    }

    protected void b(Context context, a aVar) {
        View.inflate(context, R.layout.exomedia_video_view_layout, this);
        ViewStub viewStub = (ViewStub) findViewById(R.id.video_view_api_impl_stub);
        viewStub.setLayoutResource(c(context, aVar));
        viewStub.inflate();
    }

    protected int c(Context context, a aVar) {
        return this.e.a(context) ^ true ? aVar.d : aVar.c;
    }

    protected void b(boolean z) {
        this.g.b();
        this.d.a(z);
        setKeepScreenOn(false);
        com.devbrackets.android.exomedia.ui.widget.b bVar = this.f1041a;
        if (bVar != null) {
            bVar.updatePlaybackState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f1043a = false;
        protected boolean b = false;
        protected int c = 0;

        protected b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (!VideoView.this.p || this.c == i) {
                return;
            }
            this.c = i;
            switch (i) {
                case -3:
                case -2:
                    if (VideoView.this.c()) {
                        this.b = true;
                        VideoView.this.a(true);
                        return;
                    }
                    return;
                case -1:
                    if (VideoView.this.c()) {
                        this.b = true;
                        VideoView.this.e();
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                case 2:
                    if (this.f1043a || this.b) {
                        VideoView.this.d();
                        this.f1043a = false;
                        this.b = false;
                        return;
                    }
                    return;
            }
        }

        public boolean a() {
            if (!VideoView.this.p || this.c == 1) {
                return true;
            }
            if (VideoView.this.f == null) {
                return false;
            }
            if (1 == VideoView.this.f.requestAudioFocus(this, 3, 1)) {
                this.c = 1;
                return true;
            }
            this.f1043a = true;
            return false;
        }

        public boolean b() {
            if (!VideoView.this.p) {
                return true;
            }
            if (VideoView.this.f == null) {
                return false;
            }
            this.f1043a = false;
            return 1 == VideoView.this.f.abandonAudioFocus(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class c extends a.AbstractC0072a {

        /* renamed from: a, reason: collision with root package name */
        public f f1044a;

        protected c() {
        }

        @Override // com.devbrackets.android.exomedia.core.a.AbstractC0072a
        public void a() {
            if (VideoView.this.f1041a != null) {
                VideoView.this.f1041a.finishLoading();
            }
        }

        @Override // com.devbrackets.android.exomedia.core.a.AbstractC0072a
        public void b() {
            if (VideoView.this.f1041a != null) {
                VideoView.this.f1041a.setDuration(VideoView.this.getDuration());
                VideoView.this.f1041a.finishLoading();
            }
        }

        @Override // com.devbrackets.android.exomedia.core.a.AbstractC0072a
        public void a(boolean z) {
            if (VideoView.this.b != null) {
                VideoView.this.b.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class d extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        protected GestureDetector f1045a;

        public d(Context context) {
            this.f1045a = new GestureDetector(context, this);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f1045a.onTouchEvent(motionEvent);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (VideoView.this.f1041a != null && VideoView.this.f1041a.isVisible()) {
                VideoView.this.f1041a.hide(false);
                return true;
            }
            VideoView.this.b();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1042a;
        public boolean b;
        public int c;
        public int d;
        public ScaleType e;
        public Boolean f;

        public a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes;
            this.f1042a = false;
            this.b = false;
            this.c = R.layout.exomedia_default_exo_texture_video_view;
            this.d = R.layout.exomedia_default_native_texture_video_view;
            if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoView)) == null) {
                return;
            }
            this.f1042a = obtainStyledAttributes.getBoolean(R.styleable.VideoView_useDefaultControls, this.f1042a);
            this.b = obtainStyledAttributes.getBoolean(R.styleable.VideoView_useTextureViewBacking, this.b);
            if (obtainStyledAttributes.hasValue(R.styleable.VideoView_videoScale)) {
                this.e = ScaleType.a(obtainStyledAttributes.getInt(R.styleable.VideoView_videoScale, -1));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.VideoView_measureBasedOnAspectRatio)) {
                this.f = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.VideoView_measureBasedOnAspectRatio, false));
            }
            this.c = this.b ? R.layout.exomedia_default_exo_texture_video_view : R.layout.exomedia_default_exo_surface_video_view;
            this.d = this.b ? R.layout.exomedia_default_native_texture_video_view : R.layout.exomedia_default_native_surface_video_view;
            this.c = obtainStyledAttributes.getResourceId(R.styleable.VideoView_videoViewApiImpl, this.c);
            this.d = obtainStyledAttributes.getResourceId(R.styleable.VideoView_videoViewApiImplLegacy, this.d);
            obtainStyledAttributes.recycle();
        }
    }
}
