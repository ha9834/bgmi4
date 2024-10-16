package com.tencent.grobot.lite.ui.adapter.ViewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.util.ImageUtils;
import com.tencent.grobot.lite.model.local.UploadImageInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;

/* loaded from: classes2.dex */
public class UploadImageHolder extends BaseViewHolder<UploadImageInfo> implements View.OnClickListener {
    private BaseViewHolder.OnItemClickListener clickListener;
    private Context context;
    private TextView deleteBtn;
    private UploadImageInfo imageInfo;
    private ImageView imageView;
    private TextView progressText;
    private TextView tvDesc;

    public UploadImageHolder(Context context, ViewGroup viewGroup, int i, BaseViewHolder.OnItemClickListener onItemClickListener) {
        super(context, viewGroup, R.layout.form_image_item, i, null);
        this.context = context;
        this.clickListener = onItemClickListener;
        this.imageView = (ImageView) this.itemView.findViewById(R.id.image);
        this.progressText = (TextView) this.itemView.findViewById(R.id.progress);
        this.deleteBtn = (TextView) this.itemView.findViewById(R.id.deleteBtn);
        this.deleteBtn.setOnClickListener(this);
        this.imageView.setOnClickListener(this);
        this.tvDesc = (TextView) this.itemView.findViewById(R.id.desc);
        ViewUtils.setBoldTypeface(context, this.progressText);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder
    public void bindData(UploadImageInfo uploadImageInfo) {
        if (uploadImageInfo != null) {
            this.imageInfo = uploadImageInfo;
            uploadImageInfo.position = getAdapterPosition();
            this.itemView.setTag(uploadImageInfo);
            if (uploadImageInfo.isAddBtn) {
                this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.imageView.setImageResource(R.drawable.form_icon_plus);
                this.tvDesc.setVisibility(0);
                ViewUtils.setBoldTypeface(this.tvDesc.getContext(), this.tvDesc);
                this.deleteBtn.setVisibility(8);
                this.progressText.setVisibility(8);
                return;
            }
            if (uploadImageInfo.progress > 0 && uploadImageInfo.progress < 100) {
                this.progressText.setText(uploadImageInfo.progress + "%");
                this.progressText.setVisibility(0);
            } else {
                this.progressText.setVisibility(8);
            }
            this.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Bitmap decodeBitmapFromFile = ImageUtils.decodeBitmapFromFile(uploadImageInfo.imagePath, ViewUtils.dip2px(this.context, 100.0f), ViewUtils.dip2px(this.context, 75.0f));
            this.imageView.setImageResource(0);
            this.imageView.setImageBitmap(decodeBitmapFromFile);
            this.tvDesc.setVisibility(8);
            this.deleteBtn.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewHolder.OnItemClickListener onItemClickListener = this.clickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this.deleteBtn, getAdapterPosition(), 0, this.imageInfo);
        }
    }
}
