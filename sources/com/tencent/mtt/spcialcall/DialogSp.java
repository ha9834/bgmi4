package com.tencent.mtt.spcialcall;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DialogSp extends Dialog {
    protected ArrayList<ExtendItem> mMoreItems;
    protected IWebViewClientSp mPageController;
    protected Resources mRes;

    public void layoutWindow() {
    }

    public boolean switchTheme() {
        return false;
    }

    public DialogSp(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context, MttResources.getStyleId("DialogBase"));
        this.mPageController = new NullInterface();
        this.mMoreItems = new ArrayList<>();
        this.mPageController = iWebViewClientSp;
        this.mRes = context.getResources();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSystemItems() {
        if (ExtraInfo.isCanShare()) {
            this.mMoreItems.add(new ExtendItem(0, this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_grid_share_btn_bkg")), this.mRes.getString(MttResources.getStringId("thrdcall_share"))));
        }
        if (ExtraInfo.isCanCopyLink()) {
            this.mMoreItems.add(new ExtendItem(0, this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_grid_copy_btn_bkg")), this.mRes.getString(MttResources.getStringId("thrdcall_copylink"))));
        }
        if (ExtraInfo.isCanOpenMtt()) {
            this.mMoreItems.add(new ExtendItem(0, this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_grid_openmtt_btn_bkg")), this.mRes.getString(MttResources.getStringId("thrdcall_openqbx"))));
        }
        if (ExtraInfo.isCanOpenBrowser()) {
            this.mMoreItems.add(new ExtendItem(0, this.mRes.getDrawable(MttResources.getDrawableId("thrdcall_grid_open_btn_bkg")), this.mRes.getString(MttResources.getStringId("thrdcall_openbrowser"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addExtendItems() {
        if (ExtraInfo.getExtraMoreItem() != null) {
            this.mMoreItems.addAll(ExtraInfo.getExtraMoreItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onExtendItemOnClick(View view) {
        try {
            ExtendItem extendItem = (ExtendItem) view.getTag();
            if (extendItem.getID() == 0) {
                if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_share")))) {
                    this.mPageController.sharePage(null);
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_copylink")))) {
                    this.mPageController.copyLink();
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_openqbx")))) {
                    this.mPageController.openByMtt(null);
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_openbrowser")))) {
                    this.mPageController.openByBrowser(null);
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_menu_readmode")))) {
                    this.mPageController.openReadMode();
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_menu_bookmark")))) {
                    this.mPageController.addBookmark();
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_menu_saveflow")))) {
                    this.mPageController.saveFlow();
                } else if (extendItem.getLabel().equals(this.mRes.getString(MttResources.getStringId("thrdcall_menu_fav")))) {
                    this.mPageController.favPage();
                }
            } else {
                this.mPageController.sendRsp(extendItem, MttApi.MORE_RSP);
            }
        } catch (Exception unused) {
            Toast.makeText(getContext(), MttResources.getStringId("thrdcall_sharepage_find_app_fail"), 0).show();
        }
    }
}
