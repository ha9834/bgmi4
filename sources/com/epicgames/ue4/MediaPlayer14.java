package com.epicgames.ue4;

import android.app.Activity;
import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.security.CertificateUtil;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.midas.oversea.comm.MConstants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class MediaPlayer14 extends MediaPlayer {
    private boolean AudioEnabled;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private boolean Looping = false;
    private volatile boolean Prepared = false;
    private volatile boolean Completed = false;
    private volatile boolean ReadyStart = false;
    private volatile boolean TextureSetSurface = false;
    private volatile boolean bStart = false;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private ArrayList<AudioTrackInfo> audioTracks = new ArrayList<>();
    private ArrayList<VideoTrackInfo> videoTracks = new ArrayList<>();
    private boolean mVideoEnabled = true;

    public native void nativeClearCachedAttributeState(int i, int i2);

    /* loaded from: classes.dex */
    public class FrameUpdateInfo {
        int CurrentPosition;
        boolean FrameReady;
        boolean RegionChanged;
        float UOffset;
        float UScale;
        float VOffset;
        float VScale;

        public FrameUpdateInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class AudioTrackInfo {
        public int Channels;
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;
        public int SampleRate;

        public AudioTrackInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class CaptionTrackInfo {
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;

        public CaptionTrackInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class VideoTrackInfo {
        public int BitRate;
        public String DisplayName;
        public float FrameRate;
        public int Height;
        public int Index;
        public String Language;
        public String MimeType;
        public int Width;

        public VideoTrackInfo() {
        }
    }

    public MediaPlayer14(boolean z, boolean z2) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.AudioEnabled = true;
        this.WaitOnBitmapRender = false;
        this.SwizzlePixels = z;
        this.VulkanRenderer = z2;
        this.WaitOnBitmapRender = false;
        this.AudioEnabled = true;
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.epicgames.ue4.MediaPlayer14.1
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                GameActivity.Log.debug("MediaPlayer14: onError returned what=" + i + ", extra=" + i2);
                return true;
            }
        });
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.epicgames.ue4.MediaPlayer14.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    MediaPlayer14.this.Prepared = true;
                }
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.epicgames.ue4.MediaPlayer14.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    if (MediaPlayer14.this.Looping) {
                        MediaPlayer14.this.seekTo(0);
                        MediaPlayer14.this.start();
                    }
                    MediaPlayer14.this.Completed = true;
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 14) {
            GameActivity._activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.epicgames.ue4.MediaPlayer14.4
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    GameActivity.Log.debug("MediaPlayer14 [onActivityPaused] setAudioEnabled false");
                    MediaPlayer14.this.setAudioEnabled(false);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    GameActivity.Log.debug("MediaPlayer14 [onActivityResumed]  setAudioEnabled true");
                    MediaPlayer14.this.setAudioEnabled(true);
                }
            });
        }
    }

    public boolean isPrepared() {
        boolean z;
        synchronized (this) {
            z = this.Prepared;
        }
        return z;
    }

    public boolean didComplete() {
        boolean z;
        synchronized (this) {
            z = this.Completed;
            this.Completed = false;
        }
        return z;
    }

    @Override // android.media.MediaPlayer
    public boolean isLooping() {
        return this.Looping;
    }

    private void updateTrackInfo(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            return;
        }
        int trackCount = mediaExtractor.getTrackCount();
        this.audioTracks.ensureCapacity(trackCount);
        this.videoTracks.ensureCapacity(trackCount);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (string.startsWith("audio")) {
                AudioTrackInfo audioTrackInfo = new AudioTrackInfo();
                audioTrackInfo.Index = i3;
                audioTrackInfo.MimeType = string;
                audioTrackInfo.DisplayName = "Audio Track " + i + " (Stream " + i3 + ")";
                audioTrackInfo.Language = "und";
                audioTrackInfo.Channels = trackFormat.getInteger("channel-count");
                audioTrackInfo.SampleRate = trackFormat.getInteger("sample-rate");
                this.audioTracks.add(audioTrackInfo);
                i++;
            } else if (string.startsWith("video")) {
                VideoTrackInfo videoTrackInfo = new VideoTrackInfo();
                videoTrackInfo.Index = i3;
                videoTrackInfo.MimeType = string;
                videoTrackInfo.DisplayName = "Video Track " + i2 + " (Stream " + i3 + ")";
                videoTrackInfo.Language = "und";
                videoTrackInfo.BitRate = 0;
                videoTrackInfo.Width = trackFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                videoTrackInfo.Height = trackFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                videoTrackInfo.FrameRate = 30.0f;
                if (trackFormat.containsKey("frame-rate")) {
                    videoTrackInfo.FrameRate = trackFormat.getInteger("frame-rate");
                }
                this.videoTracks.add(videoTrackInfo);
                i2++;
            }
        }
    }

    private AudioTrackInfo findAudioTrackIndex(int i) {
        Iterator<AudioTrackInfo> it = this.audioTracks.iterator();
        while (it.hasNext()) {
            AudioTrackInfo next = it.next();
            if (next.Index == i) {
                return next;
            }
        }
        return null;
    }

    private VideoTrackInfo findVideoTrackIndex(int i) {
        Iterator<VideoTrackInfo> it = this.videoTracks.iterator();
        while (it.hasNext()) {
            VideoTrackInfo next = it.next();
            if (next.Index == i) {
                return next;
            }
        }
        return null;
    }

    public boolean setDataSourceURL(String str) throws IOException, InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            setDataSource(str);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (Build.VERSION.SDK_INT >= 16) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(str);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSourceURL: Exception = " + e);
            return false;
        }
    }

    public boolean setDataSource(String str, long j, long j2) throws IOException, InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
                setDataSource(randomAccessFile.getFD(), j, j2);
                releaseOESTextureRenderer();
                releaseBitmapRenderer();
                if (Build.VERSION.SDK_INT >= 16) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    mediaExtractor.setDataSource(randomAccessFile.getFD(), j, j2);
                    updateTrackInfo(mediaExtractor);
                    mediaExtractor.release();
                }
                return true;
            }
            return false;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSource (file): Exception = " + e);
            return false;
        }
    }

    public boolean setDataSource(AssetManager assetManager, String str, long j, long j2) throws InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            AssetFileDescriptor openFd = assetManager.openFd(str);
            setDataSource(openFd.getFileDescriptor(), j, j2);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (Build.VERSION.SDK_INT >= 16) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(openFd.getFileDescriptor(), j, j2);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSource (asset): Exception = " + e);
            return false;
        }
    }

    public void setVideoEnabled(boolean z) {
        this.WaitOnBitmapRender = true;
        this.mVideoEnabled = z;
        if (this.mVideoEnabled) {
            OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
            if (oESTextureRenderer != null && oESTextureRenderer.getSurface() != null) {
                setSurface(this.mOESTextureRenderer.getSurface());
                SetTextureStart();
            }
            BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
            if (bitmapRenderer != null && bitmapRenderer.getSurface() != null) {
                setSurface(this.mBitmapRenderer.getSurface());
                SetTextureStart();
            }
        } else {
            setSurface(null);
        }
        this.WaitOnBitmapRender = false;
    }

    public void setAudioEnabled(boolean z) {
        try {
            this.AudioEnabled = z;
            if (z) {
                setVolume(1.0f, 1.0f);
            } else {
                setVolume(0.0f, 0.0f);
            }
        } catch (Exception e) {
            GameActivity.Log.debug("MediaPlayer14: setAudioEnabled Exception: " + e.toString());
        }
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    public int getExternalTextureId() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.getExternalTextureId();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.getExternalTextureId();
        }
        return -1;
    }

    @Override // android.media.MediaPlayer
    public void prepare() throws IOException, IllegalStateException {
        synchronized (this) {
            this.Completed = false;
            try {
                try {
                    try {
                        super.prepare();
                        this.Prepared = true;
                    } catch (Exception e) {
                        GameActivity.Log.debug("MediaPlayer14: Prepare Exception: " + e.toString());
                        throw e;
                    }
                } catch (IOException e2) {
                    GameActivity.Log.debug("MediaPlayer14: Prepare IOException: " + e2.toString());
                    throw e2;
                }
            } catch (IllegalStateException e3) {
                GameActivity.Log.debug("MediaPlayer14: Prepare IllegalStateExecption: " + e3.toString());
                throw e3;
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void start() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                if (!this.TextureSetSurface) {
                    this.ReadyStart = true;
                } else {
                    this.ReadyStart = true;
                    this.bStart = true;
                    super.start();
                }
            }
        }
    }

    @Override // android.media.MediaPlayer
    public boolean isPlaying() {
        boolean isPlaying;
        synchronized (this) {
            isPlaying = (!this.ReadyStart || this.bStart) ? super.isPlaying() : true;
        }
        return isPlaying;
    }

    public void SetTextureStart() {
        synchronized (this) {
            this.TextureSetSurface = true;
            this.Completed = false;
            if (this.Prepared && this.ReadyStart && !this.bStart) {
                this.bStart = true;
                start();
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void stop() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                this.ReadyStart = false;
                this.bStart = false;
                super.stop();
            }
        }
    }

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        int currentPosition;
        synchronized (this) {
            currentPosition = this.Prepared ? super.getCurrentPosition() : 0;
        }
        return currentPosition;
    }

    @Override // android.media.MediaPlayer
    public void seekTo(int i) {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.seekTo(i);
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void setLooping(boolean z) {
        this.Looping = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        super.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1.mBitmapRenderer == null) goto L14;
     */
    @Override // android.media.MediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void release() {
        /*
            r1 = this;
            com.epicgames.ue4.MediaPlayer14$OESTextureRenderer r0 = r1.mOESTextureRenderer
            if (r0 == 0) goto Lc
        L4:
            boolean r0 = r1.WaitOnBitmapRender
            if (r0 == 0) goto L9
            goto L4
        L9:
            r1.releaseOESTextureRenderer()
        Lc:
            com.epicgames.ue4.MediaPlayer14$BitmapRenderer r0 = r1.mBitmapRenderer
            if (r0 == 0) goto L18
        L10:
            boolean r0 = r1.WaitOnBitmapRender
            if (r0 == 0) goto L15
            goto L10
        L15:
            r1.releaseOESTextureRenderer()
        L18:
            super.release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.ue4.MediaPlayer14.release():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        releaseBitmapRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        super.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1.mBitmapRenderer == null) goto L14;
     */
    @Override // android.media.MediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void reset() {
        /*
            r1 = this;
            com.epicgames.ue4.MediaPlayer14$OESTextureRenderer r0 = r1.mOESTextureRenderer
            if (r0 == 0) goto Lc
        L4:
            boolean r0 = r1.WaitOnBitmapRender
            if (r0 == 0) goto L9
            goto L4
        L9:
            r1.releaseOESTextureRenderer()
        Lc:
            com.epicgames.ue4.MediaPlayer14$BitmapRenderer r0 = r1.mBitmapRenderer
            if (r0 == 0) goto L18
        L10:
            boolean r0 = r1.WaitOnBitmapRender
            if (r0 == 0) goto L15
            goto L10
        L15:
            r1.releaseBitmapRenderer()
        L18:
            super.reset()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.ue4.MediaPlayer14.reset():void");
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        this.mBitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        if (!this.mBitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.ue4.MediaPlayer14.5
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                if (MediaPlayer14.this.mBitmapRenderer != null) {
                    MediaPlayer14.this.mBitmapRenderer.setSize(i, i2);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
        }
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer != null || CreateBitmapRenderer()) {
            return;
        }
        GameActivity.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
        reset();
    }

    public Buffer getVideoLastFrameData() {
        initBitmapRenderer();
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        Buffer updateFrameData = bitmapRenderer.updateFrameData();
        this.WaitOnBitmapRender = false;
        return updateFrameData;
    }

    public boolean getVideoLastFrame(int i) {
        initBitmapRenderer();
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer == null) {
            return false;
        }
        this.WaitOnBitmapRender = true;
        boolean updateFrameData = bitmapRenderer.updateFrameData(i);
        this.WaitOnBitmapRender = false;
        return updateFrameData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private EGLDisplay mEglDisplay;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private int mLastFramePosition = -1;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;

        public BitmapRenderer(boolean z, boolean z2) {
            this.mUseOwnContext = true;
            this.mVulkanRenderer = false;
            this.mSwizzlePixels = false;
            this.mSwizzlePixels = z;
            this.mVulkanRenderer = z2;
            this.mUseOwnContext = true;
            if (this.mVulkanRenderer) {
                this.mSwizzlePixels = true;
            } else {
                String glGetString = GLES20.glGetString(7937);
                if (glGetString.contains("Adreno (TM) ") && (Integer.parseInt(glGetString.substring(12)) < 400 || Build.VERSION.SDK_INT < 22)) {
                    GameActivity.Log.debug("MediaPlayer14: disabled shared GL context on " + glGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (this.mUseOwnContext) {
                initContext();
                saveContext();
                makeCurrent();
                initSurfaceTexture();
                restoreContext();
                return;
            }
            initSurfaceTexture();
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (!this.mVulkanRenderer) {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContext = EGL14.eglGetCurrentContext();
                if (Build.VERSION.SDK_INT >= 18 && EGL14.eglQueryContext(this.mEglDisplay, eGLContext, 12440, iArr, 0) && EGL14.eglQueryContext(this.mEglDisplay, eGLContext, 12539, iArr2, 0)) {
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0] + "." + iArr2[0]);
                } else if (EGL14.eglQueryContext(this.mEglDisplay, eGLContext, 12440, iArr, 0)) {
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0]);
                } else {
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context version not detected");
                }
            } else {
                this.mEglDisplay = EGL14.eglGetDisplay(0);
                if (this.mEglDisplay == EGL14.EGL_NO_DISPLAY) {
                    GameActivity.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr3 = new int[2];
                if (!EGL14.eglInitialize(this.mEglDisplay, iArr3, 0, iArr3, 1)) {
                    this.mEglDisplay = null;
                    GameActivity.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            int[] iArr4 = {12440, 2, 12344};
            int[] iArr5 = {12440, 3, 12539, 1, 12344};
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (iArr[0] != 3) {
                iArr5 = iArr4;
            }
            this.mEglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr5, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void initSurfaceTexture() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.mTextureID = iArr[0];
            int i = this.mTextureID;
            if (i <= 0) {
                GameActivity.Log.error("mTextureID <= 0");
                release();
                return;
            }
            this.mSurfaceTexture = new SurfaceTexture(i);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            this.mFBO = iArr2[0];
            if (this.mFBO <= 0) {
                GameActivity.Log.error("mFBO <= 0");
                release();
                return;
            }
            this.mBlitVertexShaderID = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            if (this.mBlitVertexShaderID == 0) {
                GameActivity.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            int createShader = createShader(35632, this.mSwizzlePixels ? this.mBlitFragmentShaderBGRA : this.mBlitFragmentShaderRGBA);
            if (createShader == 0) {
                GameActivity.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            this.mProgram = GLES20.glCreateProgram();
            int i2 = this.mProgram;
            if (i2 <= 0) {
                GameActivity.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(i2, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, createShader);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                GameActivity.Log.error("Could not link program: ");
                GameActivity.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            this.mBlitBuffer = iArr2[0];
            if (this.mBlitBuffer <= 0) {
                GameActivity.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void UpdateVertexData() {
            if (!this.mTriangleVerticesDirty || this.mBlitBuffer <= 0) {
                return;
            }
            this.mTriangleVertices.position(0);
            this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(34964, iArr, 0);
            int i = iArr[0];
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
            GLES20.glBindBuffer(34962, i);
            this.mTriangleVerticesDirty = false;
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        private int createShader(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            if (glCreateShader == 0) {
                return glCreateShader;
            }
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            GameActivity.Log.error("Could not compile shader " + i + CertificateUtil.DELIMITER);
            GameActivity.Log.error(GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public Buffer updateFrameData() {
            synchronized (this) {
                if (this.mFrameData == null && this.mTextureWidth > 0 && this.mTextureHeight > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(this.mTextureWidth * this.mTextureHeight * 4);
                }
                if (copyFrameTexture(0, this.mFrameData)) {
                    return this.mFrameData;
                }
                return null;
            }
        }

        public boolean updateFrameData(int i) {
            synchronized (this) {
                return copyFrameTexture(i, null);
            }
        }

        private boolean copyFrameTexture(int i, Buffer buffer) {
            int i2;
            int i3;
            boolean z;
            boolean z2;
            boolean z3;
            int i4;
            boolean z4;
            boolean z5;
            int i5;
            boolean z6;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            char c;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            this.mLastFramePosition = MediaPlayer14.this.getCurrentPosition();
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i12 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                i4 = iArr[0];
                saveContext();
                makeCurrent();
                i5 = i12;
                i2 = 0;
                i3 = 0;
                z6 = false;
                z3 = false;
                z5 = false;
                z2 = false;
                z4 = false;
                z = false;
            } else {
                GLES20.glGetError();
                boolean glIsEnabled = GLES20.glIsEnabled(3042);
                boolean glIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean glIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean glIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean glIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean glIsEnabled6 = GLES20.glIsEnabled(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR);
                GLES20.glGetIntegerv(36006, iArr, 0);
                i2 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                i3 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i13 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                int i14 = iArr[0];
                glVerify("save state");
                z = glIsEnabled6;
                z2 = glIsEnabled4;
                z3 = glIsEnabled2;
                i4 = i14;
                z4 = glIsEnabled5;
                z5 = glIsEnabled3;
                i5 = i13;
                z6 = glIsEnabled;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f = fArr[12];
            float f2 = f + fArr[0];
            float f3 = fArr[13];
            float f4 = f3 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f || fArr2[6] != f2 || fArr2[11] != f3 || fArr2[3] != f4) {
                float[] fArr3 = this.mTriangleVerticesData;
                fArr3[10] = f;
                fArr3[2] = f;
                fArr3[14] = f2;
                fArr3[6] = f2;
                fArr3[15] = f3;
                fArr3[11] = f3;
                fArr3[7] = f4;
                fArr3[3] = f4;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i6 = iArr[0];
            } else {
                i6 = i;
            }
            GLES20.glBindTexture(3553, i6);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameteri(3553, 10240, 9728);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(3553, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, 5121, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i6, 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                GameActivity.Log.warn("Failed to complete framebuffer attachment (" + glCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i11 = 36160;
                i7 = i4;
                i10 = 3553;
                i8 = i5;
                i9 = i6;
                GLES20.glReadPixels(0, 0, this.mTextureWidth, this.mTextureHeight, 6408, 5121, buffer);
            } else {
                i7 = i4;
                i8 = i5;
                i9 = i6;
                i10 = 3553;
                i11 = 36160;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(i11, 36064, i10, 0, 0);
                if (buffer != null && i9 > 0) {
                    iArr[0] = i9;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(i10, 10241, i8);
                GLES20.glTexParameteri(i10, 10240, i7);
                return true;
            }
            int i15 = i7;
            int i16 = i8;
            GLES20.glBindFramebuffer(i11, i2);
            if (buffer == null || i9 <= 0) {
                c = 1;
            } else {
                iArr[0] = i9;
                c = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            }
            GLES20.glBindBuffer(34962, i3);
            GLES20.glViewport(iArr2[0], iArr2[c], iArr2[2], iArr2[3]);
            if (z6) {
                GLES20.glEnable(3042);
            }
            if (z3) {
                GLES20.glEnable(2884);
            }
            if (z5) {
                GLES20.glEnable(3089);
            }
            if (z2) {
                GLES20.glEnable(2960);
            }
            if (z4) {
                GLES20.glEnable(2929);
            }
            if (z) {
                GLES20.glEnable(MConstants.MSG_PAYCHANNEL_GET_ORDER_ERROR);
            }
            GLES20.glTexParameteri(i10, 10241, i16);
            GLES20.glTexParameteri(i10, 10240, i15);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            MediaPlayer14.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private void showGlError(String str, int i) {
            switch (i) {
                case 1280:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    return;
                case 1281:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    return;
                case 1282:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    return;
                case 1285:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    return;
                case 1286:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    return;
                case 36054:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    return;
                case 36057:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    return;
                case 36061:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    return;
                default:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError " + i);
                    return;
            }
        }

        private void glVerify(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            showGlError(str, glGetError);
            throw new RuntimeException(str + ": glGetError " + glGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError == 0) {
                    return;
                } else {
                    showGlError(str, glGetError);
                }
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            int[] iArr = new int[1];
            int i = this.mBlitBuffer;
            if (i > 0) {
                iArr[0] = i;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i2 = this.mProgram;
            if (i2 > 0) {
                GLES20.glDeleteProgram(i2);
                this.mProgram = -1;
            }
            int i3 = this.mBlitVertexShaderID;
            if (i3 > 0) {
                GLES20.glDeleteShader(i3);
                this.mBlitVertexShaderID = -1;
            }
            int i4 = this.mBlitFragmentShaderID;
            if (i4 > 0) {
                GLES20.glDeleteShader(i4);
                this.mBlitFragmentShaderID = -1;
            }
            int i5 = this.mFBO;
            if (i5 > 0) {
                iArr[0] = i5;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i6 = this.mTextureID;
            if (i6 > 0) {
                iArr[0] = i6;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            if (this.mEglSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            if (this.mEglContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
            }
        }
    }

    private boolean CreateOESTextureRenderer(int i) {
        releaseOESTextureRenderer();
        this.mOESTextureRenderer = new OESTextureRenderer(i);
        if (!this.mOESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.ue4.MediaPlayer14.6
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                if (MediaPlayer14.this.mOESTextureRenderer != null) {
                    MediaPlayer14.this.mOESTextureRenderer.setSize(i2, i3);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
            this.TextureSetSurface = false;
        }
    }

    public FrameUpdateInfo updateVideoFrame(int i) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i)) {
            GameActivity.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            reset();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo updateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return updateVideoFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = -1;
            this.mTextureID = i;
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
            frameUpdateInfo.CurrentPosition = MediaPlayer14.this.getCurrentPosition();
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float f = this.mUScale;
            float[] fArr = this.mTransformMatrix;
            if (f != fArr[0] || this.mVScale != fArr[5] || this.mUOffset != fArr[12] || this.mVOffset != fArr[13]) {
                float[] fArr2 = this.mTransformMatrix;
                this.mUScale = fArr2[0];
                this.mVScale = fArr2[5];
                this.mUOffset = fArr2[12];
                this.mVOffset = fArr2[13];
                frameUpdateInfo.RegionChanged = true;
                frameUpdateInfo.UScale = this.mUScale;
                frameUpdateInfo.UOffset = this.mUOffset;
                frameUpdateInfo.VScale = -this.mVScale;
                frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            }
            return frameUpdateInfo;
        }
    }

    public AudioTrackInfo[] GetAudioTracks() {
        boolean z;
        AudioTrackInfo findAudioTrackIndex;
        MediaFormat format;
        if (Build.VERSION.SDK_INT >= 16) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 2) {
                    i++;
                }
            }
            AudioTrackInfo[] audioTrackInfoArr = new AudioTrackInfo[i];
            int i2 = 0;
            for (int i3 = 0; i3 < trackInfo.length; i3++) {
                if (trackInfo[i3].getTrackType() == 2) {
                    audioTrackInfoArr[i2] = new AudioTrackInfo();
                    audioTrackInfoArr[i2].Index = i3;
                    audioTrackInfoArr[i2].DisplayName = "Audio Track " + i2 + " (Stream " + i3 + ")";
                    audioTrackInfoArr[i2].Language = trackInfo[i3].getLanguage();
                    if (Build.VERSION.SDK_INT < 19 || (format = trackInfo[i3].getFormat()) == null) {
                        z = false;
                    } else {
                        audioTrackInfoArr[i2].MimeType = format.getString("mime");
                        audioTrackInfoArr[i2].Channels = format.getInteger("channel-count");
                        audioTrackInfoArr[i2].SampleRate = format.getInteger("sample-rate");
                        z = true;
                    }
                    if (!z && this.audioTracks.size() > 0 && (findAudioTrackIndex = findAudioTrackIndex(i3)) != null) {
                        audioTrackInfoArr[i2].MimeType = findAudioTrackIndex.MimeType;
                        audioTrackInfoArr[i2].Channels = findAudioTrackIndex.Channels;
                        audioTrackInfoArr[i2].SampleRate = findAudioTrackIndex.SampleRate;
                        z = true;
                    }
                    if (!z) {
                        audioTrackInfoArr[i2].MimeType = "audio/unknown";
                        audioTrackInfoArr[i2].Channels = 2;
                        audioTrackInfoArr[i2].SampleRate = 44100;
                    }
                    i2++;
                }
            }
            return audioTrackInfoArr;
        }
        AudioTrackInfo[] audioTrackInfoArr2 = {new AudioTrackInfo()};
        audioTrackInfoArr2[0].Index = 0;
        audioTrackInfoArr2[0].MimeType = "audio/unknown";
        audioTrackInfoArr2[0].DisplayName = "Audio Track 0 (Stream 0)";
        audioTrackInfoArr2[0].Language = "und";
        audioTrackInfoArr2[0].Channels = 2;
        audioTrackInfoArr2[0].SampleRate = 44100;
        return audioTrackInfoArr2;
    }

    public CaptionTrackInfo[] GetCaptionTracks() {
        if (Build.VERSION.SDK_INT >= 21) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 4) {
                    i++;
                }
            }
            CaptionTrackInfo[] captionTrackInfoArr = new CaptionTrackInfo[i];
            int i2 = 0;
            for (int i3 = 0; i3 < trackInfo.length; i3++) {
                if (trackInfo[i3].getTrackType() == 4) {
                    captionTrackInfoArr[i2] = new CaptionTrackInfo();
                    captionTrackInfoArr[i2].Index = i3;
                    captionTrackInfoArr[i2].DisplayName = "Caption Track " + i2 + " (Stream " + i3 + ")";
                    MediaFormat format = trackInfo[i3].getFormat();
                    if (format != null) {
                        captionTrackInfoArr[i2].MimeType = format.getString("mime");
                        captionTrackInfoArr[i2].Language = format.getString("language");
                    } else {
                        captionTrackInfoArr[i2].MimeType = "caption/unknown";
                        captionTrackInfoArr[i2].Language = trackInfo[i3].getLanguage();
                    }
                    i2++;
                }
            }
            return captionTrackInfoArr;
        }
        return new CaptionTrackInfo[0];
    }

    public VideoTrackInfo[] GetVideoTracks() {
        boolean z;
        VideoTrackInfo findVideoTrackIndex;
        MediaFormat format;
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (Build.VERSION.SDK_INT < 16) {
            if (videoWidth > 0 && videoHeight > 0) {
                VideoTrackInfo[] videoTrackInfoArr = {new VideoTrackInfo()};
                videoTrackInfoArr[0].Index = 0;
                videoTrackInfoArr[0].MimeType = "video/unknown";
                videoTrackInfoArr[0].DisplayName = "Video Track 0 (Stream 0)";
                videoTrackInfoArr[0].Language = "und";
                videoTrackInfoArr[0].BitRate = 0;
                videoTrackInfoArr[0].Width = videoWidth;
                videoTrackInfoArr[0].Height = videoHeight;
                videoTrackInfoArr[0].FrameRate = 30.0f;
                return videoTrackInfoArr;
            }
            return new VideoTrackInfo[0];
        }
        MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
        int i = 0;
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2.getTrackType() == 1) {
                i++;
            }
        }
        VideoTrackInfo[] videoTrackInfoArr2 = new VideoTrackInfo[i];
        int i2 = 0;
        for (int i3 = 0; i3 < trackInfo.length; i3++) {
            if (trackInfo[i3].getTrackType() == 1) {
                videoTrackInfoArr2[i2] = new VideoTrackInfo();
                videoTrackInfoArr2[i2].Index = i3;
                videoTrackInfoArr2[i2].DisplayName = "Video Track " + i2 + " (Stream " + i3 + ")";
                videoTrackInfoArr2[i2].Language = trackInfo[i3].getLanguage();
                videoTrackInfoArr2[i2].BitRate = 0;
                if (Build.VERSION.SDK_INT < 19 || (format = trackInfo[i3].getFormat()) == null) {
                    z = false;
                } else {
                    videoTrackInfoArr2[i2].MimeType = format.getString("mime");
                    videoTrackInfoArr2[i2].Width = Integer.parseInt(format.getString(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    videoTrackInfoArr2[i2].Height = Integer.parseInt(format.getString(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    videoTrackInfoArr2[i2].FrameRate = format.getFloat("frame-rate");
                    z = true;
                }
                if (!z && this.videoTracks.size() > 0 && (findVideoTrackIndex = findVideoTrackIndex(i3)) != null) {
                    videoTrackInfoArr2[i2].MimeType = findVideoTrackIndex.MimeType;
                    videoTrackInfoArr2[i2].Width = findVideoTrackIndex.Width;
                    videoTrackInfoArr2[i2].Height = findVideoTrackIndex.Height;
                    videoTrackInfoArr2[i2].FrameRate = findVideoTrackIndex.FrameRate;
                    z = true;
                }
                if (!z) {
                    videoTrackInfoArr2[i2].MimeType = "video/unknown";
                    videoTrackInfoArr2[i2].Width = videoWidth;
                    videoTrackInfoArr2[i2].Height = videoHeight;
                    videoTrackInfoArr2[i2].FrameRate = 30.0f;
                }
                i2++;
            }
        }
        return videoTrackInfoArr2;
    }
}
