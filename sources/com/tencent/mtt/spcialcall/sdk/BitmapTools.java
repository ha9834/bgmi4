package com.tencent.mtt.spcialcall.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BitmapTools {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static byte[] Drawable2Bytes(Drawable drawable) {
        try {
            Bitmap bitmap = (Bitmap) drawable.getClass().getMethod("getBitmap", null).invoke(drawable, new Object[0]);
            if (bitmap != null) {
                return Bitmap2Bytes(bitmap);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap Bytes2Bimap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }
}
