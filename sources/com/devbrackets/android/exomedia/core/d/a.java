package com.devbrackets.android.exomedia.core.d;

import android.content.Context;
import android.os.Handler;
import com.devbrackets.android.exomedia.ExoMedia;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1015a;
    protected Handler b;
    protected TextOutput c;
    protected MetadataOutput d;
    protected AudioRendererEventListener e;
    protected VideoRendererEventListener f;
    protected int g = 50;
    protected int h = 5000;

    public a(Context context, Handler handler, TextOutput textOutput, MetadataOutput metadataOutput, AudioRendererEventListener audioRendererEventListener, VideoRendererEventListener videoRendererEventListener) {
        this.f1015a = context;
        this.b = handler;
        this.c = textOutput;
        this.d = metadataOutput;
        this.e = audioRendererEventListener;
        this.f = videoRendererEventListener;
    }

    public List<Renderer> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b());
        arrayList.addAll(c());
        arrayList.addAll(d());
        arrayList.addAll(e());
        return arrayList;
    }

    protected List<Renderer> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecAudioRenderer(this.f1015a, MediaCodecSelector.DEFAULT, this.b, this.e, AudioCapabilities.getCapabilities(this.f1015a), new AudioProcessor[0]));
        List<String> list = ExoMedia.a.f999a.get(ExoMedia.RendererType.AUDIO);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((Renderer) Class.forName(it.next()).getConstructor(Handler.class, AudioRendererEventListener.class).newInstance(this.b, this.e));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    protected List<Renderer> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecVideoRenderer(this.f1015a, MediaCodecSelector.DEFAULT, this.h, this.b, this.f, this.g));
        List<String> list = ExoMedia.a.f999a.get(ExoMedia.RendererType.VIDEO);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((Renderer) Class.forName(it.next()).getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(true, Integer.valueOf(this.h), this.b, this.f, Integer.valueOf(this.g)));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    protected List<Renderer> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextRenderer(this.c, this.b.getLooper()));
        return arrayList;
    }

    protected List<Renderer> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MetadataRenderer(this.d, this.b.getLooper(), MetadataDecoderFactory.DEFAULT));
        return arrayList;
    }
}
