package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ab {
    public static /* synthetic */ void a(kotlin.coroutines.e eVar, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = (CancellationException) null;
        }
        aa.a(eVar, cancellationException);
    }

    public static final void a(kotlin.coroutines.e eVar, CancellationException cancellationException) {
        z zVar = (z) eVar.get(z.f7039a);
        if (zVar != null) {
            zVar.a(cancellationException);
        }
    }
}
