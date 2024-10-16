package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface ao<T> {
    int a(T t);

    T a();

    void a(T t, Writer writer) throws IOException;

    void a(T t, an anVar, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void a(T t, byte[] bArr, int i, int i2, c.a aVar) throws IOException;

    boolean a(T t, T t2);

    int b(T t);

    void b(T t, T t2);

    void d(T t);

    boolean e(T t);
}
