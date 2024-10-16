package com.tencent.grobot.lite.ui.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ToolUtils;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.image.ImageBridge;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.node.VideoItem;

/* loaded from: classes2.dex */
public class VideoItemView extends RelativeLayout {
    private Context context;
    private ImageView imageView;
    private View rootView;
    private TextView timeText;
    private TextView timesText;

    public VideoItemView(Context context) {
        this(context, null, 0);
    }

    public VideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }

    private void initView() {
        this.rootView = LayoutInflater.from(this.context).inflate(R.layout.chat_video_item, this);
        this.imageView = (ImageView) this.rootView.findViewById(R.id.video_cardimage);
        this.timeText = (TextView) this.rootView.findViewById(R.id.video_time);
        this.timesText = (TextView) this.rootView.findViewById(R.id.video_times);
        ViewUtils.setBoldTypeface(this.context, this.timeText);
        ViewUtils.setBoldTypeface(this.context, this.timesText);
    }

    public void setData(Object obj) {
        if (obj instanceof VideoItem) {
            VideoItem videoItem = (VideoItem) obj;
            this.timeText.setVisibility(0);
            this.timeText.setText(ToolUtils.getVideoTimeString(videoItem.videoTime));
            this.timesText.setText(ToolUtils.getVideoTimesString(this.context, videoItem.videoTimes));
            ImageBridge.loadImage(this.context, videoItem.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.imageView);
            setTag(obj);
            return;
        }
        if (obj instanceof MixTipInfo) {
            MixTipInfo mixTipInfo = (MixTipInfo) obj;
            this.timeText.setVisibility(8);
            this.timesText.setText(ToolUtils.getVideoTimesString(this.context, mixTipInfo.views));
            ImageBridge.loadImage(this.context, mixTipInfo.thumbImageUrl, R.drawable.bg_defualt_image, -1, 0, this.imageView);
            setTag(obj);
        }
    }
}
