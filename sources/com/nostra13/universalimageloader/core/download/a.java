package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.nearby.connection.Connections;
import com.helpshift.util.AttachmentConstants;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class a implements ImageDownloader {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f5746a;
    protected final int b;
    protected final int c;

    public a(Context context) {
        this(context, 5000, 20000);
    }

    public a(Context context, int i, int i2) {
        this.f5746a = context.getApplicationContext();
        this.b = i;
        this.c = i2;
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream a(String str, Object obj) throws IOException {
        switch (ImageDownloader.Scheme.a(str)) {
            case HTTP:
            case HTTPS:
                return b(str, obj);
            case FILE:
                return d(str, obj);
            case CONTENT:
                return e(str, obj);
            case ASSETS:
                return f(str, obj);
            case DRAWABLE:
                return g(str, obj);
            default:
                return h(str, obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InputStream b(String str, Object obj) throws IOException {
        HttpURLConnection c = c(str, obj);
        for (int i = 0; c.getResponseCode() / 100 == 3 && i < 5; i++) {
            c = c(c.getHeaderField(HttpHeader.LOCATION), obj);
        }
        try {
            InputStream inputStream = c.getInputStream();
            if (!a(c)) {
                b.a((Closeable) inputStream);
                throw new IOException("Image request failed with response code " + c.getResponseCode());
            }
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(inputStream, Connections.MAX_BYTES_DATA_SIZE), c.getContentLength());
        } catch (IOException e) {
            b.a(c.getErrorStream());
            throw e;
        }
    }

    protected boolean a(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    protected HttpURLConnection c(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        return httpURLConnection;
    }

    protected InputStream d(String str, Object obj) throws IOException {
        String c = ImageDownloader.Scheme.FILE.c(str);
        if (b(str)) {
            return a(c);
        }
        return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(new FileInputStream(c), Connections.MAX_BYTES_DATA_SIZE), (int) new File(c).length());
    }

    @TargetApi(8)
    private InputStream a(String str) {
        Bitmap createVideoThumbnail;
        if (Build.VERSION.SDK_INT < 8 || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2)) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    protected InputStream e(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.f5746a.getContentResolver();
        Uri parse = Uri.parse(str);
        if (b(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return a(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    @TargetApi(14)
    protected InputStream a(Uri uri) {
        ContentResolver contentResolver = this.f5746a.getContentResolver();
        if (Build.VERSION.SDK_INT >= 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    protected InputStream f(String str, Object obj) throws IOException {
        return this.f5746a.getAssets().open(ImageDownloader.Scheme.ASSETS.c(str));
    }

    protected InputStream g(String str, Object obj) {
        return this.f5746a.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.c(str)));
    }

    protected InputStream h(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", str));
    }

    private boolean b(Uri uri) {
        String type = this.f5746a.getContentResolver().getType(uri);
        return type != null && type.startsWith(AttachmentConstants.VIDEO_MIME_PREFIX);
    }

    private boolean b(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith(AttachmentConstants.VIDEO_MIME_PREFIX);
    }
}
