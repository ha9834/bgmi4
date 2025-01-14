package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class f implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f6392a;
    private AtomicInteger b;

    public f() {
        this.f6392a = null;
        this.b = null;
        this.f6392a = new ConcurrentLinkedQueue<>();
        this.b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f6392a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        if (writerArr == null || cArr == null || cArr.length == 0 || writerArr.length < 2) {
            return;
        }
        Writer writer = writerArr[0];
        Writer writer2 = writerArr[1];
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i = length;
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i > length2 ? length2 : i;
                int i5 = i3 + i4;
                next.getChars(i3, i5, cArr, i2);
                i -= i4;
                i2 += i4;
                length2 -= i4;
                if (i == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.write(cArr, 0, length);
                        } catch (Exception unused2) {
                        }
                    }
                    i = length;
                    i3 = i5;
                    i2 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        if (i2 > 0) {
            if (writer != null) {
                try {
                    writer.write(cArr, 0, i2);
                } catch (Exception unused3) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.write(cArr, 0, i2);
                } catch (Exception unused4) {
                }
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused5) {
            }
        }
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (Exception unused6) {
            }
        }
    }

    public int a() {
        return this.b.get();
    }

    public void b() {
        this.f6392a.clear();
        this.b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f6392a.iterator();
    }
}
