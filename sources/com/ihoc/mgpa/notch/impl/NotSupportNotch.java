package com.ihoc.mgpa.notch.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes2.dex */
public class NotSupportNotch extends c {
    private static final String TAG = "NOTCHSDK_notsupport";

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public List<Rect> getNotchSize(Context context, WindowInsets windowInsets) {
        return null;
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public String getType() {
        return "notsupport";
    }

    @Override // com.ihoc.mgpa.notch.impl.c, com.ihoc.mgpa.notch.INotchSupport
    public boolean hasNotchSupport(Context context, WindowInsets windowInsets) {
        return false;
    }
}
