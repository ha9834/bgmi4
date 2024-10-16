package com.tencent.mtt.spcialcall;

import android.graphics.Bitmap;
import android.graphics.Picture;
import com.tencent.mtt.engine.IWebView;
import com.tencent.mtt.engine.IWebViewClient;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NullInterface implements IWebView, IWebViewClientSp {
    @Override // com.tencent.mtt.engine.IWebView
    public void active() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void addBookmark() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void back(boolean z) {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public boolean canGoBack() {
        return false;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public boolean canGoForward() {
        return false;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void configFontSize(int i) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void copyLink() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void deactive() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void destroy() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void downloadVideoByMtt(String str, String str2, String str3, int i, int i2) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void exitFullScreen() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void exiteBrowser() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void favPage() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void fitScreen() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void forward() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public String getTitle() {
        return null;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public String getUrl() {
        return null;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void loadUrl(String str) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onBackOrForwardChanged(IWebView iWebView) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void onDownload(String str, String str2, String str3, String str4, long j, String str5) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onPageFinished(IWebView iWebView, String str) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onPageStarted(IWebView iWebView, String str, Bitmap bitmap) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onReceivedError(IWebView iWebView, int i, String str, String str2) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public void onReceivedTitle(IWebView iWebView, String str) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openByBrowser(String str) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openByMtt(String str) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openInternalUrl(String str) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void openReadMode() {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void postUrl(String str, byte[] bArr) {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void reload() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void requesetFullScreen() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void saveFlow() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void sendRsp(ExtendItem extendItem, String str) {
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void setWebViewClient(IWebViewClient iWebViewClient) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void sharePage(String str) {
    }

    @Override // com.tencent.mtt.engine.IWebViewClient
    public boolean shouldOverrideUrlLoading(IWebView iWebView, String str) {
        return false;
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void showImageSaveDialog(String str, Bitmap bitmap) {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void showMore() {
    }

    public Bitmap snapshotPostSynchronously() {
        return null;
    }

    public Bitmap snapshotPostWholePageSynchronously() {
        return null;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public Picture snapshotWholePage(int i, int i2, IWebView.RatioRespect ratioRespect, int i3) {
        return null;
    }

    @Override // com.tencent.mtt.engine.IWebView
    public void stopLoading() {
    }

    @Override // com.tencent.mtt.spcialcall.IWebViewClientSp
    public void updateTitleItem(ArrayList<ExtendItem> arrayList) {
    }
}
