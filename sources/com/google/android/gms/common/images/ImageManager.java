package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.b.e;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1423a = new Object();
    private static HashSet<Uri> b = new HashSet<>();
    private static ImageManager c;
    private final Context d;
    private final Handler e = new zap(Looper.getMainLooper());
    private final ExecutorService f = Executors.newFixedThreadPool(4);
    private final a g = null;
    private final zak h = new zak();
    private final Map<zaa, ImageReceiver> i = new HashMap();
    private final Map<Uri, ImageReceiver> j = new HashMap();
    private final Map<Uri, Long> k = new HashMap();

    /* loaded from: classes.dex */
    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    public static ImageManager create(Context context) {
        if (c == null) {
            c = new ImageManager(context, false);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends e<com.google.android.gms.common.images.a, Bitmap> {
        @Override // androidx.b.e
        protected final /* synthetic */ int sizeOf(com.google.android.gms.common.images.a aVar, Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2.getHeight() * bitmap2.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.b.e
        public final /* synthetic */ void entryRemoved(boolean z, com.google.android.gms.common.images.a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final zaa f1426a;

        public c(zaa zaaVar) {
            this.f1426a = zaaVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.i.get(this.f1426a);
            if (imageReceiver != null) {
                ImageManager.this.i.remove(this.f1426a);
                imageReceiver.b(this.f1426a);
            }
            com.google.android.gms.common.images.a aVar = this.f1426a.f1431a;
            if (aVar.f1430a == null) {
                this.f1426a.a(ImageManager.this.d, ImageManager.this.h, true);
                return;
            }
            Bitmap a2 = ImageManager.this.a(aVar);
            if (a2 != null) {
                this.f1426a.a(ImageManager.this.d, a2, true);
                return;
            }
            Long l = (Long) ImageManager.this.k.get(aVar.f1430a);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f1426a.a(ImageManager.this.d, ImageManager.this.h, true);
                    return;
                }
                ImageManager.this.k.remove(aVar.f1430a);
            }
            this.f1426a.a(ImageManager.this.d, ImageManager.this.h);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.j.get(aVar.f1430a);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(aVar.f1430a);
                ImageManager.this.j.put(aVar.f1430a, imageReceiver2);
            }
            imageReceiver2.a(this.f1426a);
            if (!(this.f1426a instanceof zad)) {
                ImageManager.this.i.put(this.f1426a, imageReceiver2);
            }
            synchronized (ImageManager.f1423a) {
                if (!ImageManager.b.contains(aVar.f1430a)) {
                    ImageManager.b.add(aVar.f1430a);
                    imageReceiver2.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f1425a;
        private final ParcelFileDescriptor b;

        public b(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f1425a = uri;
            this.b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.b;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.f1425a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.b.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.e.post(new d(this.f1425a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.f1425a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    @KeepName
    /* loaded from: classes.dex */
    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f1424a;
        private final ArrayList<zaa> b;

        ImageReceiver(Uri uri) {
            super(new zap(Looper.getMainLooper()));
            this.f1424a = uri;
            this.b = new ArrayList<>();
        }

        public final void a(zaa zaaVar) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.b.add(zaaVar);
        }

        public final void b(zaa zaaVar) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.b.remove(zaaVar);
        }

        public final void a() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.putExtra(Constants.EXTRA_URI, this.f1424a);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.d.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f.execute(new b(this.f1424a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* loaded from: classes.dex */
    private final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f1427a;
        private final Bitmap b;
        private final CountDownLatch c;
        private boolean d;

        public d(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f1427a = uri;
            this.b = bitmap;
            this.d = z;
            this.c = countDownLatch;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.b != null;
            if (ImageManager.this.g != null) {
                if (this.d) {
                    ImageManager.this.g.evictAll();
                    System.gc();
                    this.d = false;
                    ImageManager.this.e.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.g.put(new com.google.android.gms.common.images.a(this.f1427a), this.b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.j.remove(this.f1427a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.b;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    zaa zaaVar = (zaa) arrayList.get(i);
                    if (z) {
                        zaaVar.a(ImageManager.this.d, this.b, false);
                    } else {
                        ImageManager.this.k.put(this.f1427a, Long.valueOf(SystemClock.elapsedRealtime()));
                        zaaVar.a(ImageManager.this.d, ImageManager.this.h, false);
                    }
                    if (!(zaaVar instanceof zad)) {
                        ImageManager.this.i.remove(zaaVar);
                    }
                }
            }
            this.c.countDown();
            synchronized (ImageManager.f1423a) {
                ImageManager.b.remove(this.f1427a);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.d = context.getApplicationContext();
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        a(new zac(imageView, uri));
    }

    public final void loadImage(ImageView imageView, int i) {
        a(new zac(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zac zacVar = new zac(imageView, uri);
        zacVar.b = i;
        a(zacVar);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        a(new zad(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zad zadVar = new zad(onImageLoadedListener, uri);
        zadVar.b = i;
        a(zadVar);
    }

    private final void a(zaa zaaVar) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new c(zaaVar).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap a(com.google.android.gms.common.images.a aVar) {
        a aVar2 = this.g;
        if (aVar2 == null) {
            return null;
        }
        return aVar2.get(aVar);
    }
}
