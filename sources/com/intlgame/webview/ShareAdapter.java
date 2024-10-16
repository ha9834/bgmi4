package com.intlgame.webview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.intlgame.api.compliance.R;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareAdapter extends RecyclerView.a<ItemHolder> {
    private int mItemWidth;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;
    private Resources mResources;
    private List<ItemData> mShareItemList;

    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public ShareAdapter(Context context) {
        this.mItemWidth = 0;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mResources = context.getResources();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            this.mItemWidth = windowManager.getDefaultDisplay().getWidth() / 4;
        }
    }

    public void setShareData(List<ItemData> list) {
        this.mShareItemList = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(WebViewResID.layout_share_item, viewGroup, false);
        if (this.mItemWidth != 0) {
            inflate.getLayoutParams().width = this.mItemWidth;
        }
        return new ItemHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(final ItemHolder itemHolder, int i) {
        ItemData itemData = this.mShareItemList.get(itemHolder.getAdapterPosition());
        if (itemData != null) {
            itemHolder.shareTitle.setText(this.mResources.getString(itemData.shareTitleResId));
            itemHolder.shareIcon.setImageDrawable(this.mResources.getDrawable(itemData.shareIconResId));
        }
        itemHolder.shareIcon.setOnClickListener(new View.OnClickListener() { // from class: com.intlgame.webview.ShareAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShareAdapter.this.mOnItemClickListener != null) {
                    ShareAdapter.this.mOnItemClickListener.onItemClick(itemHolder.shareIcon, itemHolder.getAdapterPosition());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.mShareItemList.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ItemHolder extends RecyclerView.w {
        ImageView shareIcon;
        TextView shareTitle;

        ItemHolder(View view) {
            super(view);
            this.shareTitle = (TextView) view.findViewById(R.id.share_channel_title);
            this.shareIcon = (ImageView) view.findViewById(R.id.share_channel_icon);
        }
    }

    /* loaded from: classes2.dex */
    public static class ItemData {
        public String channel;
        boolean isShare;
        int shareIconResId;
        int shareTitleResId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ItemData(String str) {
            this.channel = "";
            this.isShare = false;
            this.channel = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ItemData(String str, boolean z) {
            this.channel = "";
            this.isShare = false;
            this.channel = str;
            this.isShare = z;
        }
    }
}
