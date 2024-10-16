package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class OptionVerticalView extends RecyclerView {
    private Context context;

    public OptionVerticalView(Context context) {
        this(context, null, 0);
    }

    public OptionVerticalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OptionVerticalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
