package com.nostra13.universalimageloader.core.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class a implements com.nostra13.universalimageloader.core.a.b {

    /* renamed from: a, reason: collision with root package name */
    protected final boolean f5724a;

    public a(boolean z) {
        this.f5724a = z;
    }

    @Override // com.nostra13.universalimageloader.core.a.b
    public Bitmap a(c cVar) throws IOException {
        InputStream b2 = b(cVar);
        if (b2 == null) {
            com.nostra13.universalimageloader.b.c.d("No stream for image [%s]", cVar.a());
            return null;
        }
        try {
            b a2 = a(b2, cVar);
            b2 = b(b2, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(b2, null, a(a2.f5726a, cVar));
            if (decodeStream == null) {
                com.nostra13.universalimageloader.b.c.d("Image can't be decoded [%s]", cVar.a());
                return decodeStream;
            }
            return a(decodeStream, cVar, a2.b.f5725a, a2.b.b);
        } finally {
            com.nostra13.universalimageloader.b.b.a((Closeable) b2);
        }
    }

    protected InputStream b(c cVar) throws IOException {
        return cVar.f().a(cVar.b(), cVar.g());
    }

    protected b a(InputStream inputStream, c cVar) throws IOException {
        C0144a c0144a;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String b2 = cVar.b();
        if (cVar.h() && a(b2, options.outMimeType)) {
            c0144a = a(b2);
        } else {
            c0144a = new C0144a();
        }
        return new b(new com.nostra13.universalimageloader.core.assist.c(options.outWidth, options.outHeight, c0144a.f5725a), c0144a);
    }

    private boolean a(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.a(str) == ImageDownloader.Scheme.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected C0144a a(String str) {
        int i = 0;
        boolean z = 1;
        try {
            switch (new ExifInterface(ImageDownloader.Scheme.FILE.c(str)).getAttributeInt("Orientation", 1)) {
                case 1:
                default:
                    z = 0;
                    break;
                case 2:
                    break;
                case 3:
                    z = i;
                    i = 180;
                    break;
                case 4:
                    i = 1;
                    z = i;
                    i = 180;
                    break;
                case 5:
                    i = 1;
                    z = i;
                    i = 270;
                    break;
                case 6:
                    z = i;
                    i = 90;
                    break;
                case 7:
                    i = 1;
                    z = i;
                    i = 90;
                    break;
                case 8:
                    z = i;
                    i = 270;
                    break;
            }
        } catch (IOException unused) {
            com.nostra13.universalimageloader.b.c.c("Can't read EXIF tags from file [%s]", str);
            z = 0;
        }
        return new C0144a(i, z);
    }

    protected BitmapFactory.Options a(com.nostra13.universalimageloader.core.assist.c cVar, c cVar2) {
        int a2;
        ImageScaleType d = cVar2.d();
        if (d == ImageScaleType.NONE) {
            a2 = 1;
        } else if (d == ImageScaleType.NONE_SAFE) {
            a2 = com.nostra13.universalimageloader.b.a.a(cVar);
        } else {
            a2 = com.nostra13.universalimageloader.b.a.a(cVar, cVar2.c(), cVar2.e(), d == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (a2 > 1 && this.f5724a) {
            com.nostra13.universalimageloader.b.c.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", cVar, cVar.a(a2), Integer.valueOf(a2), cVar2.a());
        }
        BitmapFactory.Options i = cVar2.i();
        i.inSampleSize = a2;
        return i;
    }

    protected InputStream b(InputStream inputStream, c cVar) throws IOException {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        com.nostra13.universalimageloader.b.b.a((Closeable) inputStream);
        return b(cVar);
    }

    protected Bitmap a(Bitmap bitmap, c cVar, int i, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType d = cVar.d();
        if (d == ImageScaleType.EXACTLY || d == ImageScaleType.EXACTLY_STRETCHED) {
            com.nostra13.universalimageloader.core.assist.c cVar2 = new com.nostra13.universalimageloader.core.assist.c(bitmap.getWidth(), bitmap.getHeight(), i);
            float b2 = com.nostra13.universalimageloader.b.a.b(cVar2, cVar.c(), cVar.e(), d == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b2, 1.0f) != 0) {
                matrix.setScale(b2, b2);
                if (this.f5724a) {
                    com.nostra13.universalimageloader.b.c.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", cVar2, cVar2.a(b2), Float.valueOf(b2), cVar.a());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f5724a) {
                com.nostra13.universalimageloader.b.c.a("Flip image horizontally [%s]", cVar.a());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.f5724a) {
                com.nostra13.universalimageloader.b.c.a("Rotate image on %1$d° [%2$s]", Integer.valueOf(i), cVar.a());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.nostra13.universalimageloader.core.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0144a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5725a;
        public final boolean b;

        protected C0144a() {
            this.f5725a = 0;
            this.b = false;
        }

        protected C0144a(int i, boolean z) {
            this.f5725a = i;
            this.b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.nostra13.universalimageloader.core.assist.c f5726a;
        public final C0144a b;

        protected b(com.nostra13.universalimageloader.core.assist.c cVar, C0144a c0144a) {
            this.f5726a = cVar;
            this.b = c0144a;
        }
    }
}
