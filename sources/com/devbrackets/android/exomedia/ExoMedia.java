package com.devbrackets.android.exomedia;

import com.devbrackets.android.exomedia.core.e.a;
import com.devbrackets.android.exomedia.core.e.a.e;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ExoMedia {

    /* loaded from: classes.dex */
    public enum RendererType {
        AUDIO,
        VIDEO,
        CLOSED_CAPTION,
        METADATA
    }

    /* loaded from: classes.dex */
    public interface b {
        DataSource.Factory a(String str, TransferListener transferListener);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface c {
        HttpDataSource.BaseFactory a(String str, TransferListener transferListener);
    }

    /* loaded from: classes.dex */
    public static class a {

        @Deprecated
        public static volatile c c;
        public static volatile b d;
        public static volatile LoadControl e;

        /* renamed from: a, reason: collision with root package name */
        public static final Map<RendererType, List<String>> f999a = new HashMap();
        public static final List<a.C0074a> b = new ArrayList();
        public static volatile com.devbrackets.android.exomedia.core.e.a f = new com.devbrackets.android.exomedia.core.e.a();

        static {
            a();
            b();
        }

        private static void a() {
            f999a.put(RendererType.AUDIO, new LinkedList());
            f999a.put(RendererType.VIDEO, new LinkedList());
            f999a.put(RendererType.CLOSED_CAPTION, new LinkedList());
            f999a.put(RendererType.METADATA, new LinkedList());
            List<String> list = f999a.get(RendererType.AUDIO);
            list.add("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer");
            list.add("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
            list.add("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
            f999a.get(RendererType.VIDEO).add("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer");
        }

        private static void b() {
            b.add(new a.C0074a(new com.devbrackets.android.exomedia.core.e.a.c(), null, ".m3u8", ".*\\.m3u8.*"));
            b.add(new a.C0074a(new com.devbrackets.android.exomedia.core.e.a.a(), null, ".mpd", ".*\\.mpd.*"));
            b.add(new a.C0074a(new e(), null, ".ism", ".*\\.ism.*"));
        }
    }
}
