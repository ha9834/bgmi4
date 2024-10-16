package com.tencent.gcloud.qr.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class EncodeUtil {
    private static final String BARCODE_FORMAT_CLASS = "com.google.zxing.BarcodeFormat";
    private static final String BITMATRIX_CLASS = "com.google.zxing.common.BitMatrix";
    private static final String QRCODE_WRITER_CLASS = "com.google.zxing.qrcode.QRCodeWriter";
    private int mWidth = 230;
    private int mHeight = 230;
    private int mOnColor = WebView.NIGHT_MODE_COLOR;
    private int mOffColor = -1;

    private static Bitmap addLogo(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f, f, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save(31);
            canvas.restore();
            return createBitmap;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        for (int i = 100; byteArrayOutputStream.toByteArray().length / 1024 > 100 && i > 0; i -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    private static Object deleteWhite(Object obj) {
        Object obj2;
        Method method;
        int[] iArr;
        int intValue;
        int intValue2;
        if (obj == null) {
            Log.d(ViewHierarchyConstants.TAG_KEY, "QRCodeAPI EncodeUtil deleteWhite matrixObj is null");
            return null;
        }
        try {
            Method method2 = obj.getClass().getMethod("getEnclosingRectangle", new Class[0]);
            Method method3 = obj.getClass().getMethod("getWidth", new Class[0]);
            Method method4 = obj.getClass().getMethod("getHeight", new Class[0]);
            method = obj.getClass().getMethod("get", Integer.TYPE, Integer.TYPE);
            iArr = (int[]) method2.invoke(obj, new Object[0]);
            intValue = ((Integer) method3.invoke(obj, new Object[0])).intValue();
            intValue2 = ((Integer) method4.invoke(obj, new Object[0])).intValue();
            int i = iArr[2] + 1;
            int i2 = iArr[3] + 1;
            if (i <= intValue) {
                intValue = i;
            }
            if (i2 <= intValue2) {
                intValue2 = i2;
            }
            Constructor<?>[] declaredConstructors = Class.forName(BITMATRIX_CLASS).getDeclaredConstructors();
            Constructor<?> constructor = null;
            for (int i3 = 0; i3 < declaredConstructors.length; i3++) {
                constructor = declaredConstructors[i3];
                if (constructor.getGenericParameterTypes().length == 2) {
                    break;
                }
            }
            if (constructor != null) {
                constructor.setAccessible(true);
                obj2 = constructor.newInstance(Integer.valueOf(intValue), Integer.valueOf(intValue2));
            } else {
                obj2 = null;
            }
        } catch (Exception e) {
            e = e;
            obj2 = null;
        }
        try {
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return obj2;
        }
        if (obj2 == null) {
            Log.d(ViewHierarchyConstants.TAG_KEY, "QRCodeAPI EncodeUtil deleteWhite resMatrixObj is null");
            return null;
        }
        Method method5 = obj2.getClass().getMethod("clear", new Class[0]);
        Method method6 = obj2.getClass().getMethod("set", Integer.TYPE, Integer.TYPE);
        method5.invoke(obj2, new Object[0]);
        for (int i4 = 0; i4 < intValue; i4++) {
            for (int i5 = 0; i5 < intValue2; i5++) {
                if (((Boolean) method.invoke(obj, Integer.valueOf(iArr[0] + i4), Integer.valueOf(iArr[1] + i5))).booleanValue()) {
                    method6.invoke(obj2, Integer.valueOf(i4), Integer.valueOf(i5));
                }
            }
        }
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00db A[Catch: Exception -> 0x0187, TryCatch #1 {Exception -> 0x0187, blocks: (B:6:0x0008, B:10:0x0012, B:12:0x0018, B:13:0x001d, B:36:0x00db, B:38:0x00e4, B:40:0x00ea, B:42:0x00f3, B:46:0x0141, B:48:0x015b, B:50:0x016a, B:51:0x0163, B:54:0x016d, B:56:0x0170, B:58:0x0182, B:66:0x00be, B:67:0x001b, B:16:0x003c, B:17:0x0048, B:19:0x004b, B:21:0x0055, B:25:0x005a, B:26:0x008e, B:28:0x0091, B:30:0x00a0, B:33:0x00a3), top: B:5:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e4 A[Catch: Exception -> 0x0187, TryCatch #1 {Exception -> 0x0187, blocks: (B:6:0x0008, B:10:0x0012, B:12:0x0018, B:13:0x001d, B:36:0x00db, B:38:0x00e4, B:40:0x00ea, B:42:0x00f3, B:46:0x0141, B:48:0x015b, B:50:0x016a, B:51:0x0163, B:54:0x016d, B:56:0x0170, B:58:0x0182, B:66:0x00be, B:67:0x001b, B:16:0x003c, B:17:0x0048, B:19:0x004b, B:21:0x0055, B:25:0x005a, B:26:0x008e, B:28:0x0091, B:30:0x00a0, B:33:0x00a3), top: B:5:0x0008, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap createQRCode(java.lang.String r19, android.graphics.Bitmap r20) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gcloud.qr.zxing.EncodeUtil.createQRCode(java.lang.String, android.graphics.Bitmap):android.graphics.Bitmap");
    }

    public void initData(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mOnColor = i3;
        this.mOffColor = i4;
    }

    public void setQRCodeSize(int i) {
        if (i > 0) {
            this.mWidth = i;
            this.mHeight = i;
        }
    }

    public boolean writeToFile(Bitmap bitmap, String str, String str2) {
        boolean z;
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("QR", "mkdirs Error");
            return false;
        }
        File file2 = new File(str, str2 + ".jpg");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fileOutputStream == null) {
            return false;
        }
        try {
            fileOutputStream.flush();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
        }
        try {
            fileOutputStream.close();
            return z;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
