package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.ac;

/* loaded from: classes3.dex */
public interface MainDispatcherFactory {
    ac createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
