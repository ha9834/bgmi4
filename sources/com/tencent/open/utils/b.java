package com.tencent.open.utils;

import com.helpshift.analytics.AnalyticsEventKey;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final m f6397a = new m(101010256);
    private static final n b = new n(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Properties f6398a;
        byte[] b;

        private a() {
            this.f6398a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!b.b.equals(new n(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b = new n(bArr3).b();
            if ((bArr.length - length) - 2 < b) {
                return;
            }
            byte[] bArr4 = new byte[b];
            wrap.get(bArr4);
            this.f6398a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b) - 2;
            if (length2 > 0) {
                this.b = new byte[length2];
                wrap.get(this.b);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f6398a + ", otherData=" + Arrays.toString(this.b) + "]";
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            try {
                byte[] a2 = a(randomAccessFile);
                if (a2 != null) {
                    a aVar = new a();
                    aVar.a(a2);
                    String property = aVar.f6398a.getProperty(str);
                    randomAccessFile.close();
                    return property;
                }
                randomAccessFile.close();
                return null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = f6397a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            }
            if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (!z) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int b2 = new n(bArr).b();
        if (b2 == 0) {
            return null;
        }
        byte[] bArr2 = new byte[b2];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
