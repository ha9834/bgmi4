package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class LoadAndDisplayImageTask implements b.a, Runnable {

    /* renamed from: a, reason: collision with root package name */
    final String f5719a;
    final com.nostra13.universalimageloader.core.c.a b;
    final c c;
    final com.nostra13.universalimageloader.core.d.a d;
    final com.nostra13.universalimageloader.core.d.b e;
    private final f f;
    private final g g;
    private final Handler h;
    private final e i;
    private final ImageDownloader j;
    private final ImageDownloader k;
    private final ImageDownloader l;
    private final com.nostra13.universalimageloader.core.a.b m;
    private final String n;
    private final com.nostra13.universalimageloader.core.assist.c o;
    private final boolean p;
    private LoadedFrom q = LoadedFrom.NETWORK;

    public LoadAndDisplayImageTask(f fVar, g gVar, Handler handler) {
        this.f = fVar;
        this.g = gVar;
        this.h = handler;
        this.i = fVar.f5753a;
        this.j = this.i.p;
        this.k = this.i.s;
        this.l = this.i.t;
        this.m = this.i.q;
        this.f5719a = gVar.f5755a;
        this.n = gVar.b;
        this.b = gVar.c;
        this.o = gVar.d;
        this.c = gVar.e;
        this.d = gVar.f;
        this.e = gVar.g;
        this.p = this.c.s();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2 A[Catch: all -> 0x00fb, TaskCancelledException -> 0x00fd, Merged into TryCatch #1 {all -> 0x00fb, TaskCancelledException -> 0x00fd, blocks: (B:13:0x0033, B:15:0x0042, B:18:0x0049, B:20:0x00b3, B:22:0x00bb, B:24:0x00d2, B:25:0x00dd, B:29:0x0059, B:33:0x0063, B:35:0x0071, B:37:0x0088, B:39:0x0095, B:41:0x009d, B:42:0x00fd), top: B:12:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }

    private boolean b() {
        AtomicBoolean a2 = this.f.a();
        if (a2.get()) {
            synchronized (this.f.b()) {
                if (a2.get()) {
                    com.nostra13.universalimageloader.b.c.a("ImageLoader is paused. Waiting...  [%s]", this.n);
                    try {
                        this.f.b().wait();
                        com.nostra13.universalimageloader.b.c.a(".. Resume loading [%s]", this.n);
                    } catch (InterruptedException unused) {
                        com.nostra13.universalimageloader.b.c.d("Task was interrupted [%s]", this.n);
                        return true;
                    }
                }
            }
        }
        return j();
    }

    private boolean c() {
        if (!this.c.f()) {
            return false;
        }
        com.nostra13.universalimageloader.b.c.a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.c.l()), this.n);
        try {
            Thread.sleep(this.c.l());
            return j();
        } catch (InterruptedException unused) {
            com.nostra13.universalimageloader.b.c.d("Task was interrupted [%s]", this.n);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004d, code lost:
    
        if (r1.getHeight() > 0) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap d() throws com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException {
        /*
            r10 = this;
            r0 = 0
            com.nostra13.universalimageloader.core.e r1 = r10.i     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            com.nostra13.universalimageloader.a.a.a r1 = r1.o     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            java.lang.String r2 = r10.f5719a     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            java.io.File r1 = r1.a(r2)     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L40
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            if (r4 == 0) goto L40
            long r4 = r1.length()     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L40
            java.lang.String r4 = "Load image from disk cache [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            java.lang.String r6 = r10.n     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            r5[r2] = r6     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            com.nostra13.universalimageloader.b.c.a(r4, r5)     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            com.nostra13.universalimageloader.core.assist.LoadedFrom r4 = com.nostra13.universalimageloader.core.assist.LoadedFrom.DISC_CACHE     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            r10.q = r4     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            r10.i()     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r4 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            java.lang.String r1 = r4.b(r1)     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            android.graphics.Bitmap r1 = r10.a(r1)     // Catch: java.lang.Throwable -> La5 java.lang.OutOfMemoryError -> Lb2 java.io.IOException -> Lbf com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lce
            goto L41
        L40:
            r1 = r0
        L41:
            if (r1 == 0) goto L4f
            int r4 = r1.getWidth()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r4 <= 0) goto L4f
            int r4 = r1.getHeight()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r4 > 0) goto Ld4
        L4f:
            java.lang.String r4 = "Load image from network [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.lang.String r5 = r10.n     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            r3[r2] = r5     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            com.nostra13.universalimageloader.b.c.a(r4, r3)     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            com.nostra13.universalimageloader.core.assist.LoadedFrom r2 = com.nostra13.universalimageloader.core.assist.LoadedFrom.NETWORK     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            r10.q = r2     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.lang.String r2 = r10.f5719a     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            com.nostra13.universalimageloader.core.c r3 = r10.c     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            boolean r3 = r3.i()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r3 == 0) goto L84
            boolean r3 = r10.e()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r3 == 0) goto L84
            com.nostra13.universalimageloader.core.e r3 = r10.i     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            com.nostra13.universalimageloader.a.a.a r3 = r3.o     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.lang.String r4 = r10.f5719a     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.io.File r3 = r3.a(r4)     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r3 == 0) goto L84
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r2 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            java.lang.String r2 = r2.b(r3)     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
        L84:
            r10.i()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            android.graphics.Bitmap r1 = r10.a(r2)     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r1 == 0) goto L99
            int r2 = r1.getWidth()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r2 <= 0) goto L99
            int r2 = r1.getHeight()     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            if (r2 > 0) goto Ld4
        L99:
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            r10.a(r2, r0)     // Catch: java.lang.Throwable -> L9f java.lang.OutOfMemoryError -> La1 java.io.IOException -> La3 com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lcc java.lang.IllegalStateException -> Lcf
            goto Ld4
        L9f:
            r0 = move-exception
            goto La9
        La1:
            r0 = move-exception
            goto Lb6
        La3:
            r0 = move-exception
            goto Lc3
        La5:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        La9:
            com.nostra13.universalimageloader.b.c.a(r0)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN
            r10.a(r2, r0)
            goto Ld4
        Lb2:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        Lb6:
            com.nostra13.universalimageloader.b.c.a(r0)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY
            r10.a(r2, r0)
            goto Ld4
        Lbf:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        Lc3:
            com.nostra13.universalimageloader.b.c.a(r0)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR
            r10.a(r2, r0)
            goto Ld4
        Lcc:
            r0 = move-exception
            throw r0
        Lce:
            r1 = r0
        Lcf:
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED
            r10.a(r2, r0)
        Ld4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.d():android.graphics.Bitmap");
    }

    private Bitmap a(String str) throws IOException {
        return this.m.a(new com.nostra13.universalimageloader.core.a.c(this.n, str, this.f5719a, this.o, this.b.c(), h(), this.c));
    }

    private boolean e() throws TaskCancelledException {
        com.nostra13.universalimageloader.b.c.a("Cache image on disk [%s]", this.n);
        try {
            boolean f = f();
            if (!f) {
                return f;
            }
            int i = this.i.d;
            int i2 = this.i.e;
            if (i <= 0 && i2 <= 0) {
                return f;
            }
            com.nostra13.universalimageloader.b.c.a("Resize image in disk cache [%s]", this.n);
            b(i, i2);
            return f;
        } catch (IOException e) {
            com.nostra13.universalimageloader.b.c.a(e);
            return false;
        }
    }

    private boolean f() throws IOException {
        InputStream a2 = h().a(this.f5719a, this.c.n());
        if (a2 == null) {
            com.nostra13.universalimageloader.b.c.d("No stream for image [%s]", this.n);
            return false;
        }
        try {
            return this.i.o.a(this.f5719a, a2, this);
        } finally {
            com.nostra13.universalimageloader.b.b.a((Closeable) a2);
        }
    }

    private boolean b(int i, int i2) throws IOException {
        File a2 = this.i.o.a(this.f5719a);
        if (a2 == null || !a2.exists()) {
            return false;
        }
        Bitmap a3 = this.m.a(new com.nostra13.universalimageloader.core.a.c(this.n, ImageDownloader.Scheme.FILE.b(a2.getAbsolutePath()), this.f5719a, new com.nostra13.universalimageloader.core.assist.c(i, i2), ViewScaleType.FIT_INSIDE, h(), new c.a().a(this.c).a(ImageScaleType.IN_SAMPLE_INT).a()));
        if (a3 != null && this.i.f != null) {
            com.nostra13.universalimageloader.b.c.a("Process image before cache on disk [%s]", this.n);
            a3 = this.i.f.a(a3);
            if (a3 == null) {
                com.nostra13.universalimageloader.b.c.d("Bitmap processor for disk cache returned null [%s]", this.n);
            }
        }
        if (a3 == null) {
            return false;
        }
        boolean a4 = this.i.o.a(this.f5719a, a3);
        a3.recycle();
        return a4;
    }

    @Override // com.nostra13.universalimageloader.b.b.a
    public boolean a(int i, int i2) {
        return this.p || c(i, i2);
    }

    private boolean c(final int i, final int i2) {
        if (p() || j()) {
            return false;
        }
        if (this.e == null) {
            return true;
        }
        a(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.1
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask.this.e.a(LoadAndDisplayImageTask.this.f5719a, LoadAndDisplayImageTask.this.b.d(), i, i2);
            }
        }, false, this.h, this.f);
        return true;
    }

    private void a(final FailReason.FailType failType, final Throwable th) {
        if (this.p || p() || j()) {
            return;
        }
        a(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (LoadAndDisplayImageTask.this.c.c()) {
                    LoadAndDisplayImageTask.this.b.a(LoadAndDisplayImageTask.this.c.c(LoadAndDisplayImageTask.this.i.f5748a));
                }
                LoadAndDisplayImageTask.this.d.onLoadingFailed(LoadAndDisplayImageTask.this.f5719a, LoadAndDisplayImageTask.this.b.d(), new FailReason(failType, th));
            }
        }, false, this.h, this.f);
    }

    private void g() {
        if (this.p || p()) {
            return;
        }
        a(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.3
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask.this.d.onLoadingCancelled(LoadAndDisplayImageTask.this.f5719a, LoadAndDisplayImageTask.this.b.d());
            }
        }, false, this.h, this.f);
    }

    private ImageDownloader h() {
        if (this.f.c()) {
            return this.k;
        }
        if (this.f.d()) {
            return this.l;
        }
        return this.j;
    }

    private void i() throws TaskCancelledException {
        k();
        m();
    }

    private boolean j() {
        return l() || n();
    }

    private void k() throws TaskCancelledException {
        if (l()) {
            throw new TaskCancelledException();
        }
    }

    private boolean l() {
        if (!this.b.e()) {
            return false;
        }
        com.nostra13.universalimageloader.b.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.n);
        return true;
    }

    private void m() throws TaskCancelledException {
        if (n()) {
            throw new TaskCancelledException();
        }
    }

    private boolean n() {
        if (!(!this.n.equals(this.f.a(this.b)))) {
            return false;
        }
        com.nostra13.universalimageloader.b.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.n);
        return true;
    }

    private void o() throws TaskCancelledException {
        if (p()) {
            throw new TaskCancelledException();
        }
    }

    private boolean p() {
        if (!Thread.interrupted()) {
            return false;
        }
        com.nostra13.universalimageloader.b.c.a("Task was interrupted [%s]", this.n);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f5719a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Runnable runnable, boolean z, Handler handler, f fVar) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            fVar.a(runnable);
        } else {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }
}
