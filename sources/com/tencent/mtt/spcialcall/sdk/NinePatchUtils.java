package com.tencent.mtt.spcialcall.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class NinePatchUtils {
    private static final int NO_COLOR = 1;

    private NinePatchUtils() {
    }

    public static Drawable decodeDrawableFromAsset(Context context, String str) throws Exception {
        Bitmap readFromAsset = readFromAsset(context, str);
        if (readFromAsset.getNinePatchChunk() == null) {
            return new BitmapDrawable(readFromAsset);
        }
        Rect rect = new Rect();
        readPaddingFromChunk(readFromAsset.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), readFromAsset, readFromAsset.getNinePatchChunk(), rect, null);
    }

    public static Bitmap decodeFromStream(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        decodeStream.setDensity(240);
        byte[] readChunk = readChunk(decodeStream);
        if (!NinePatch.isNinePatchChunk(readChunk)) {
            return decodeStream;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
        decodeStream.recycle();
        Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
        declaredField.setAccessible(true);
        declaredField.set(createBitmap, readChunk);
        return createBitmap;
    }

    public static Bitmap decodeFromFile(String str) throws Exception {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return null;
        }
        decodeFile.setDensity(240);
        byte[] readChunk = readChunk(decodeFile);
        if (!NinePatch.isNinePatchChunk(readChunk)) {
            return decodeFile;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 1, 1, decodeFile.getWidth() - 2, decodeFile.getHeight() - 2);
            decodeFile.recycle();
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, readChunk);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Drawable createDrawableFromFile(Context context, String str) throws Exception {
        Bitmap decodeFromFile = decodeFromFile(str);
        if (decodeFromFile == null) {
            return null;
        }
        decodeFromFile.setDensity(240);
        Rect rect = new Rect();
        readPaddingFromChunk(decodeFromFile.getNinePatchChunk(), rect);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), decodeFromFile, decodeFromFile.getNinePatchChunk(), rect, null);
        ninePatchDrawable.getPaint().setAntiAlias(true);
        ninePatchDrawable.setFilterBitmap(true);
        return ninePatchDrawable;
    }

    public static Bitmap readFromAsset(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        Bitmap decodeFromStream = decodeFromStream(open);
        open.close();
        return decodeFromStream;
    }

    public static void readPaddingFromChunk(byte[] bArr, Rect rect) {
        rect.left = getInt(bArr, 12);
        rect.right = getInt(bArr, 16);
        rect.top = getInt(bArr, 20);
        rect.bottom = getInt(bArr, 24);
    }

    public static byte[] readChunk(Bitmap bitmap) throws IOException {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < 32; i3++) {
            byteArrayOutputStream.write(0);
        }
        int i4 = width - 2;
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, width, 1, 0, i4, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[iArr.length - 1] == -16777216;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (i5 != iArr[i7]) {
                i6++;
                writeInt(byteArrayOutputStream, i7);
                i5 = iArr[i7];
            }
        }
        if (z2) {
            writeInt(byteArrayOutputStream, iArr.length);
            i = i6 + 1;
        } else {
            i = i6;
        }
        int i8 = i + 1;
        if (z) {
            i8--;
        }
        int i9 = z2 ? i8 - 1 : i8;
        int i10 = height - 2;
        int[] iArr2 = new int[i10];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i10);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[iArr2.length - 1] == -16777216;
        int length2 = iArr2.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length2; i13++) {
            if (i11 != iArr2[i13]) {
                i12++;
                writeInt(byteArrayOutputStream, i13);
                i11 = iArr2[i13];
            }
        }
        if (z4) {
            writeInt(byteArrayOutputStream, iArr2.length);
            i2 = i12 + 1;
        } else {
            i2 = i12;
        }
        int i14 = i2 + 1;
        if (z3) {
            i14--;
        }
        int i15 = z4 ? i14 - 1 : i14;
        int i16 = 0;
        while (true) {
            int i17 = i9 * i15;
            if (i16 < i17) {
                writeInt(byteArrayOutputStream, 1);
                i16++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i;
                byteArray[2] = (byte) i2;
                byteArray[3] = (byte) i17;
                dealPaddingInfo(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static void dealPaddingInfo(Bitmap bitmap, byte[] bArr) {
        int[] iArr = new int[bitmap.getWidth() - 2];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            }
            if (-16777216 == iArr[i2]) {
                writeInt(bArr, 12, i2);
                break;
            }
            i2++;
        }
        int length = iArr.length - 1;
        while (true) {
            if (length < 0) {
                break;
            }
            if (-16777216 == iArr[length]) {
                writeInt(bArr, 16, (iArr.length - length) - 2);
                break;
            }
            length--;
        }
        int[] iArr2 = new int[bitmap.getHeight() - 2];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (true) {
            if (i >= iArr2.length) {
                break;
            }
            if (-16777216 == iArr2[i]) {
                writeInt(bArr, 20, i);
                break;
            }
            i++;
        }
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            if (-16777216 == iArr2[length2]) {
                writeInt(bArr, 24, (iArr2.length - length2) - 2);
                return;
            }
        }
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static int getInt(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << 24) | (b2 << 8) | b | (b3 << 16);
    }

    public static void printChunkInfo(Bitmap bitmap) {
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk == null) {
            System.out.println("can't find chunk info from this bitmap(" + bitmap + ")");
            return;
        }
        byte b = ninePatchChunk[1];
        byte b2 = ninePatchChunk[2];
        byte b3 = ninePatchChunk[3];
        StringBuilder sb = new StringBuilder();
        int i = getInt(ninePatchChunk, 12);
        int i2 = getInt(ninePatchChunk, 16);
        int i3 = getInt(ninePatchChunk, 20);
        int i4 = getInt(ninePatchChunk, 24);
        sb.append("peddingLeft=" + i);
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("paddingRight=" + i2);
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("paddingTop=" + i3);
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("paddingBottom=" + i4);
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("x info=");
        for (int i5 = 0; i5 < b; i5++) {
            sb.append("," + getInt(ninePatchChunk, (i5 * 4) + 32));
        }
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("y info=");
        for (int i6 = 0; i6 < b2; i6++) {
            sb.append("," + getInt(ninePatchChunk, (b * 4) + 32 + (i6 * 4)));
        }
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        sb.append("color info=");
        for (int i7 = 0; i7 < b3; i7++) {
            sb.append("," + getInt(ninePatchChunk, (b * 4) + (b2 * 4) + 32 + (i7 * 4)));
        }
        PrintStream printStream = System.err;
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) sb);
        printStream.println(sb2.toString());
    }
}
