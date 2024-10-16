package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.image.ImagePresenter;
import com.tencent.grobot.lite.model.local.UploadImageInfo;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.UploadImageHolder;
import com.tencent.grobot.lite.ui.view.form.IFormItem;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UploadImageAdapter extends BaseViewAdapter<UploadImageInfo> {
    private View.OnClickListener addListener;
    private IFormItem iFormItem;

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected int getItemViewTypeByPosition(int i) {
        return 1;
    }

    public UploadImageAdapter(Context context) {
        super(context);
    }

    @Override // com.tencent.grobot.lite.ui.adapter.BaseViewAdapter
    protected BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i) {
        return new UploadImageHolder(this.context, viewGroup, i, new BaseViewHolder.OnItemClickListener() { // from class: com.tencent.grobot.lite.ui.adapter.UploadImageAdapter.1
            @Override // com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder.OnItemClickListener
            public void onItemClick(View view, int i2, int i3, Object obj) {
                boolean z;
                UploadImageInfo uploadImageInfo = (UploadImageInfo) obj;
                if (uploadImageInfo.isAddBtn) {
                    if (UploadImageAdapter.this.addListener != null) {
                        UploadImageAdapter.this.addListener.onClick(view);
                        return;
                    }
                    return;
                }
                if (view.getId() == R.id.deleteBtn) {
                    ImagePresenter.getInstance().deleteImage(uploadImageInfo.imagePath);
                    UploadImageAdapter.this.deleteItem(i2);
                    if (UploadImageAdapter.this.getItemCount() < 3) {
                        if (UploadImageAdapter.this.datas != null) {
                            Iterator it = UploadImageAdapter.this.datas.iterator();
                            while (it.hasNext()) {
                                if (((UploadImageInfo) it.next()).isAddBtn) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        z = true;
                        if (z) {
                            UploadImageInfo uploadImageInfo2 = new UploadImageInfo();
                            uploadImageInfo2.isAddBtn = true;
                            UploadImageAdapter.this.addItems(Collections.singletonList(uploadImageInfo2));
                        }
                    }
                    if (UploadImageAdapter.this.iFormItem != null) {
                        UploadImageAdapter.this.iFormItem.onItemEditFinish();
                    }
                }
            }
        });
    }

    public void onDestroy() {
        setDatas(null);
    }

    public void refreshItem(String str, int i) {
        List<UploadImageInfo> datas = getDatas();
        if (datas == null) {
            return;
        }
        for (UploadImageInfo uploadImageInfo : datas) {
            if (str.equals(uploadImageInfo.imagePath)) {
                uploadImageInfo.progress = i;
                notifyItemChanged(uploadImageInfo.position);
                return;
            }
        }
    }

    public void setIFormItem(IFormItem iFormItem) {
        this.iFormItem = iFormItem;
    }

    public void setAddListener(View.OnClickListener onClickListener) {
        this.addListener = onClickListener;
    }
}
