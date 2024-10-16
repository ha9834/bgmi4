package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface u {

    /* loaded from: classes.dex */
    public interface a {
        ab a(z zVar) throws IOException;

        z a();

        @Nullable
        i b();

        int c();

        int d();

        int e();
    }

    ab intercept(a aVar) throws IOException;
}
