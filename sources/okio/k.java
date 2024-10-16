package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f7183a = Logger.getLogger(k.class.getName());

    private k() {
    }

    public static e a(q qVar) {
        return new m(qVar);
    }

    public static d a(p pVar) {
        return new l(pVar);
    }

    private static p a(final OutputStream outputStream, final r rVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (rVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new p() { // from class: okio.k.1
            @Override // okio.p
            public void a_(c cVar, long j) throws IOException {
                s.a(cVar.b, 0L, j);
                while (j > 0) {
                    r.this.g();
                    n nVar = cVar.f7175a;
                    int min = (int) Math.min(j, nVar.c - nVar.b);
                    outputStream.write(nVar.f7190a, nVar.b, min);
                    nVar.b += min;
                    long j2 = min;
                    j -= j2;
                    cVar.b -= j2;
                    if (nVar.b == nVar.c) {
                        cVar.f7175a = nVar.b();
                        o.a(nVar);
                    }
                }
            }

            @Override // okio.p, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // okio.p
            public r a() {
                return r.this;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static p a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a c = c(socket);
        return c.a(a(socket.getOutputStream(), c));
    }

    public static q a(InputStream inputStream) {
        return a(inputStream, new r());
    }

    private static q a(final InputStream inputStream, final r rVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (rVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new q() { // from class: okio.k.2
            @Override // okio.q
            public long a(c cVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    r.this.g();
                    n e = cVar.e(1);
                    int read = inputStream.read(e.f7190a, e.c, (int) Math.min(j, 8192 - e.c));
                    if (read == -1) {
                        return -1L;
                    }
                    e.c += read;
                    long j2 = read;
                    cVar.b += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (k.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }

            @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // okio.q
            public r a() {
                return r.this;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static q b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a c = c(socket);
        return c.a(a(socket.getInputStream(), c));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: okio.k.3
            @Override // okio.a
            protected IOException a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // okio.a
            protected void a() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (k.a(e)) {
                        k.f7183a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    k.f7183a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
