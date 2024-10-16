package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.UploadImageInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class ImageHolder extends BaseViewHolder<String> {
    private BaseViewHolder.OnItemClickListener clickListener;
    private Context context;
    private TextView deleteBtn;
    private UploadImageInfo imageInfo;
    private ImageView imageView;
    private TextView progressText;

    public ImageHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.ticket_image_item, i, null);
        this.context = context;
        this.imageView = (ImageView) this.itemView.findViewById(R.id.image);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        ImageBridge.loadImage(this.context, str, -1, R.drawable.bg_defualt_image, 0, this.imageView);
    }
}
