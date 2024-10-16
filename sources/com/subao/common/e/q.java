package com.subao.common.e;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import com.subao.common.e.r;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class q {
    protected abstract String a();

    protected abstract void a(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(r.a aVar) {
        if (aVar == null) {
            return Constants.JumpUrlConstants.SRC_TYPE_APP;
        }
        switch (aVar) {
            case ROM:
                return "rom";
            case SDK:
                return ServerProtocol.DIALOG_PARAM_SDK_VERSION;
            default:
                return Constants.JumpUrlConstants.SRC_TYPE_APP;
        }
    }

    public boolean a(Context context, r.a aVar) {
        InputStream inputStream = null;
        try {
            inputStream = b(context, aVar);
            boolean a2 = a(inputStream);
            com.subao.common.e.a((Closeable) inputStream);
            return a2;
        } catch (IOException | RuntimeException unused) {
            com.subao.common.e.a((Closeable) inputStream);
            return false;
        } catch (Throwable th) {
            com.subao.common.e.a((Closeable) inputStream);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            if (byteArrayOutputStream.size() <= 0) {
                return false;
            }
            a(byteArrayOutputStream.toByteArray());
            return true;
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream b(Context context, r.a aVar) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            throw new IOException("Get ContentResolver failed.");
        }
        InputStream openInputStream = contentResolver.openInputStream(b(aVar));
        if (openInputStream != null) {
            return openInputStream;
        }
        throw new IOException("Open input stream from ContentResolver failed.");
    }

    private Uri b(r.a aVar) {
        return Uri.parse(String.format("content://cn.wsds.service.config/%s.%s", a(), a(aVar)));
    }
}
