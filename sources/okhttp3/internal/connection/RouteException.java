package okhttp3.internal.connection;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public IOException a() {
        return this.firstException;
    }

    public IOException b() {
        return this.lastException;
    }

    public void a(IOException iOException) {
        okhttp3.internal.c.a((Throwable) this.firstException, (Throwable) iOException);
        this.lastException = iOException;
    }
}
