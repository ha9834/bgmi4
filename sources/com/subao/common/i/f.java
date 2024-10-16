package com.subao.common.i;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f6029a;

    /* loaded from: classes2.dex */
    public interface b {
        RandomAccessFile a(String str, boolean z);

        void a(String str);

        String[] a();
    }

    public f(b bVar) {
        this.f6029a = bVar;
    }

    private static String c(String str) {
        return "link_" + str;
    }

    public void a(String str, byte[] bArr) {
        RandomAccessFile a2 = this.f6029a.a(c(str), false);
        if (a2 != null) {
            try {
                a2.write(bArr);
                return;
            } finally {
                com.subao.common.e.a(a2);
            }
        }
        throw new IOException("Open file error");
    }

    public List<a> a(int i) {
        String[] a2 = this.f6029a.a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(a2.length);
        for (String str : a2) {
            if (str.length() > 5 && str.startsWith("link_")) {
                try {
                    arrayList.add(new a(str.substring(5), a(str)));
                    if (i > 0 && arrayList.size() == i) {
                        break;
                    }
                } catch (IOException unused) {
                    this.f6029a.a(str);
                }
            }
        }
        return arrayList;
    }

    byte[] a(String str) {
        RandomAccessFile a2 = this.f6029a.a(str, true);
        try {
            long length = a2.length();
            if (length > 1048576) {
                throw new IOException("File too large");
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            if (a2.read(bArr) == i) {
                return bArr;
            }
            throw new IOException("Read file error");
        } finally {
            com.subao.common.e.a(a2);
        }
    }

    public void b(String str) {
        this.f6029a.a(c(str));
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f6030a;
        public final byte[] b;

        public a(String str, byte[] bArr) {
            this.f6030a = str;
            this.b = bArr;
        }
    }
}
