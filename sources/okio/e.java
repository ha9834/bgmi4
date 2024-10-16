package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface e extends ReadableByteChannel, q {
    long a(byte b) throws IOException;

    long a(p pVar) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j, ByteString byteString) throws IOException;

    boolean b(long j) throws IOException;

    c c();

    ByteString d(long j) throws IOException;

    String f(long j) throws IOException;

    boolean f() throws IOException;

    InputStream g();

    byte[] h(long j) throws IOException;

    byte i() throws IOException;

    void i(long j) throws IOException;

    short j() throws IOException;

    int k() throws IOException;

    short l() throws IOException;

    int m() throws IOException;

    long n() throws IOException;

    String q() throws IOException;

    byte[] s() throws IOException;
}
