package com.tencent.smtt.export.external.jscore.interfaces;

import android.os.Looper;

/* loaded from: classes2.dex */
public interface IX5JsVirtualMachine {
    IX5JsContext createJsContext();

    void destroy();

    Looper getLooper();

    void onPause();

    void onResume();
}
