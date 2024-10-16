package com.uqm.crashsight.protobuf;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class at<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, ByteString byteString);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, Writer writer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(an anVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, Writer writer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b, an anVar) throws IOException {
        int c = anVar.c();
        int b2 = WireFormat.b(c);
        switch (WireFormat.a(c)) {
            case 0:
                a((at<T, B>) b, b2, anVar.h());
                return true;
            case 1:
                b(b, b2, anVar.j());
                return true;
            case 2:
                a((at<T, B>) b, b2, anVar.o());
                return true;
            case 3:
                B a2 = a();
                int a3 = WireFormat.a(b2, 4);
                while (anVar.b() != Integer.MAX_VALUE && a((at<T, B>) a2, anVar)) {
                }
                if (a3 != anVar.c()) {
                    throw InvalidProtocolBufferException.g();
                }
                a((at<T, B>) b, b2, (int) a((at<T, B>) a2));
                return true;
            case 4:
                return false;
            case 5:
                a((at<T, B>) b, b2, anVar.k());
                return true;
            default:
                throw InvalidProtocolBufferException.h();
        }
    }
}
