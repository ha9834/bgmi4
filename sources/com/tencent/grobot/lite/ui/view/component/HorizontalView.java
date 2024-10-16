package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.common.ComponentRef;

/* loaded from: classes2.dex */
public class HorizontalView extends RecyclerView implements ComponentRef {
    private static final String TAG = "HorizontalView";

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
    }

    public HorizontalView(Context context) {
        this(context, null, 0);
    }

    public HorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 0, false));
    }
}
