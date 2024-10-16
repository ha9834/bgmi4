package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

/* loaded from: classes2.dex */
public class WebBackForwardList {

    /* renamed from: a, reason: collision with root package name */
    private IX5WebBackForwardList f6481a = null;
    private android.webkit.WebBackForwardList b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f6481a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.b = webBackForwardList;
        return webBackForwardList2;
    }

    public WebHistoryItem getCurrentItem() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f6481a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getCurrentItem());
        }
        return WebHistoryItem.a(this.b.getCurrentItem());
    }

    public int getCurrentIndex() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f6481a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getCurrentIndex();
        }
        return this.b.getCurrentIndex();
    }

    public WebHistoryItem getItemAtIndex(int i) {
        IX5WebBackForwardList iX5WebBackForwardList = this.f6481a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getItemAtIndex(i));
        }
        return WebHistoryItem.a(this.b.getItemAtIndex(i));
    }

    public int getSize() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f6481a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getSize();
        }
        return this.b.getSize();
    }
}
