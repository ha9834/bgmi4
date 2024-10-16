package com.uqm.crashsight.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class ByteOutput {
    public abstract void a(ByteBuffer byteBuffer) throws IOException;

    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void b(byte[] bArr, int i, int i2) throws IOException;
}
