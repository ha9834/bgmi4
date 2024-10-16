package com.epicgames.ue4;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebViewPositionLayout extends ViewGroup {
    private WebViewControl webViewControl;

    public WebViewPositionLayout(Context context, WebViewControl webViewControl) {
        super(context);
        this.webViewControl = webViewControl;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.webViewControl.webView.layout(this.webViewControl.curX, this.webViewControl.curY, this.webViewControl.curX + this.webViewControl.curW, this.webViewControl.curY + this.webViewControl.curH);
    }
}
