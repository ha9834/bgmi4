package com.tencent.mtt.spcialcall;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.amazonaws.services.s3.internal.Constants;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.spcialcall.sdk.ExtendItem;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ShareDialogSp extends DialogSp {
    private Button mCancel;
    private String mShareInfo;
    private ListView mShareListView;

    @Override // com.tencent.mtt.spcialcall.DialogSp
    public boolean switchTheme() {
        return false;
    }

    public ShareDialogSp(Context context, IWebViewClientSp iWebViewClientSp) {
        super(context, iWebViewClientSp);
        initWindow();
        setContentView(MttResources.getLayoutId("thrdcall_share_item"));
        this.mShareListView = (ListView) findViewById(MttResources.getId("list"));
        this.mCancel = (Button) findViewById(MttResources.getId("cancel"));
        this.mCancel.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.spcialcall.ShareDialogSp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareDialogSp.this.dismiss();
            }
        });
        addExtendItems();
        addSystemItems();
    }

    public void setShareUrl(String str) {
        this.mShareInfo = str;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        layoutWindow();
    }

    @Override // com.tencent.mtt.spcialcall.DialogSp
    public void layoutWindow() {
        int min = (int) (Math.min(BrowserWindowSP.sWidth, BrowserWindowSP.sHeight) * 0.9f);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(MttResources.getDimensId("thrdcall_more_window_height"));
        if (BrowserWindowSP.sWidth > BrowserWindowSP.sHeight) {
            dimensionPixelSize = -1;
        }
        getWindow().setLayout(min, dimensionPixelSize);
    }

    private void initWindow() {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(MttResources.getColorId("thrdcall_transparent"));
        window.addFlags(2);
        window.clearFlags(Constants.MB);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getShareIntent(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ShareGridAdapter extends BaseAdapter {
        private ArrayList<ExtendItem> shareItems;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public ShareGridAdapter(ArrayList<ExtendItem> arrayList) {
            this.shareItems = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.shareItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.shareItems.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View createListItem = createListItem(ThemeSwitcher.initTransDrawable(ShareDialogSp.this.getContext(), this.shareItems.get(i)), this.shareItems.get(i).getLabel());
            createListItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.spcialcall.ShareDialogSp.ShareGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        ExtendItem extendItem = (ExtendItem) ShareGridAdapter.this.shareItems.get(i);
                        if (extendItem.getID() == -1) {
                            Intent shareIntent = ShareDialogSp.this.getShareIntent(ShareDialogSp.this.mShareInfo);
                            shareIntent.setComponent(extendItem.getComponentName());
                            ShareDialogSp.this.getContext().startActivity(shareIntent);
                        } else {
                            ShareDialogSp.this.mPageController.sendRsp(extendItem, MttApi.SHARE_RSP);
                        }
                    } catch (Exception unused) {
                        Toast.makeText(ShareDialogSp.this.getContext(), MttResources.getStringId("thrdcall_sharepage_find_app_fail"), 0).show();
                    }
                    ShareDialogSp.this.dismiss();
                }
            });
            return createListItem;
        }

        public View createListItem(Drawable drawable, CharSequence charSequence) {
            int dimensionPixelSize = ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_header_item_size"));
            int dimensionPixelSize2 = ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_header_item_size"));
            TextView textView = new TextView(ShareDialogSp.this.getContext());
            textView.setClickable(true);
            textView.setFocusable(false);
            textView.setBackgroundResource(MttResources.getDrawableId("thrdcall_more_item_bkg"));
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            textView.setGravity(1);
            int dimensionPixelSize3 = ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_header_item_margine"));
            textView.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize3);
            textView.setTextAppearance(ShareDialogSp.this.getContext(), MttResources.getStyleId("thrdcall_more_text"));
            textView.setSingleLine(true);
            textView.setText(charSequence);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(0, ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_more_header_text_size")));
            textView.setShadowLayer(2.0f, 0.0f, 2.0f, ShareDialogSp.this.mRes.getColor(MttResources.getColorId("thrdcall_more_text_shadow_color")));
            if (drawable != null) {
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize2);
                textView.setCompoundDrawables(null, drawable, null, null);
                textView.setCompoundDrawablePadding(ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_header_item_padding")));
            }
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ShareListAdapter extends BaseAdapter {
        private ArrayList<ExtendItem> shareItems;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public ShareListAdapter(ArrayList<ExtendItem> arrayList) {
            this.shareItems = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.shareItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.shareItems.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View createListItem = createListItem(new BitmapDrawable(ShareDialogSp.this.getContext().getResources(), this.shareItems.get(i).getImage()), this.shareItems.get(i).getLabel());
            createListItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.spcialcall.ShareDialogSp.ShareListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        ExtendItem extendItem = (ExtendItem) ShareListAdapter.this.shareItems.get(i);
                        if (extendItem.getID() == 0) {
                            Intent shareIntent = ShareDialogSp.this.getShareIntent(ShareDialogSp.this.mShareInfo);
                            shareIntent.setComponent(extendItem.getComponentName());
                            ShareDialogSp.this.getContext().startActivity(shareIntent);
                        } else {
                            ShareDialogSp.this.mPageController.sendRsp(extendItem, MttApi.SHARE_RSP);
                        }
                    } catch (Exception unused) {
                        Toast.makeText(ShareDialogSp.this.getContext(), MttResources.getStringId("thrdcall_sharepage_find_app_fail"), 0).show();
                    }
                    ShareDialogSp.this.dismiss();
                }
            });
            return createListItem;
        }

        public View createListItem(Drawable drawable, CharSequence charSequence) {
            drawable.setBounds(0, 0, ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_share_dialog_icon_width")), ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_share_dialog_icon_height")));
            TextView textView = new TextView(ShareDialogSp.this.getContext());
            int dimensionPixelSize = ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_share_to_item_margin"));
            textView.setClickable(true);
            textView.setFocusable(false);
            textView.setBackgroundResource(MttResources.getDrawableId("thrdcall_more_item_bkg"));
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_search_engine_dialog_item_height"))));
            textView.setGravity(16);
            textView.setTextAppearance(ShareDialogSp.this.getContext(), MttResources.getStringId("thrdcall_more_text"));
            textView.setText(charSequence);
            textView.setTextSize(0, ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_more_text_size")));
            textView.setShadowLayer(2.0f, 0.0f, 2.0f, ShareDialogSp.this.mRes.getColor(MttResources.getColorId("thrdcall_more_text_shadow_color")));
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(ShareDialogSp.this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_share_to_item_margin")));
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.spcialcall.DialogSp
    public void addSystemItems() {
        ArrayList arrayList = new ArrayList();
        Intent shareIntent = getShareIntent(this.mShareInfo);
        PackageManager packageManager = getContext().getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(shareIntent, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            Drawable loadIcon = activityInfo.loadIcon(packageManager);
            CharSequence loadLabel = activityInfo.loadLabel(packageManager);
            ExtendItem extendItem = new ExtendItem(0);
            extendItem.setImage(loadIcon);
            extendItem.setLabel(loadLabel);
            extendItem.setComponentName(new ComponentName(activityInfo.packageName, activityInfo.name));
            arrayList.add(extendItem);
        }
        this.mShareListView.setAdapter((ListAdapter) new ShareListAdapter(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.spcialcall.DialogSp
    public void addExtendItems() {
        if (ExtraInfo.getExtraShareItem() != null) {
            addExtraItem(ExtraInfo.getExtraShareItem());
        }
    }

    private void addExtraItem(ArrayList<ExtendItem> arrayList) {
        GridView gridView = new GridView(getContext());
        gridView.setLayoutParams(new AbsListView.LayoutParams(-1, (((arrayList.size() - 1) / 3) + 1) * this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_header_height"))));
        gridView.setNumColumns(3);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setHorizontalScrollBarEnabled(false);
        gridView.setStretchMode(2);
        gridView.setGravity(17);
        gridView.setAdapter((ListAdapter) new ShareGridAdapter(arrayList));
        this.mShareListView.addHeaderView(gridView);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_list_divider_height"))));
        textView.setText(getContext().getResources().getText(MttResources.getStringId("thrdcall_share_more")));
        textView.setTextSize(0, this.mRes.getDimensionPixelSize(MttResources.getDimensId("thrdcall_more_divider_text_size")));
        textView.setTextColor(-6250336);
        textView.setGravity(17);
        textView.setEnabled(false);
        textView.setFocusable(true);
        textView.setBackgroundColor(16777215);
        this.mShareListView.addHeaderView(textView);
    }
}
