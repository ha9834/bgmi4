package com.intlgame.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.intlgame.api.compliance.R;
import com.intlgame.foundation.INTLLog;
import com.intlgame.webview.ShareAdapter;
import com.intlgame.webview.ShareManager;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareView {
    private boolean isDismissing = false;
    private ViewGroup mContainer;
    private Context mContext;
    private ShareListener mShareListener;
    private List<ShareAdapter.ItemData> shareChannelItemList;

    /* loaded from: classes2.dex */
    public interface ShareListener {
        void onShare(String str);
    }

    public ShareView(Context context, String str) {
        INTLLog.i("ShareView Construct:" + str);
        this.mContext = context;
        this.mContainer = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.intl_webview_share_container, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.intl_webview_share_dlg, this.mContainer, true);
        ((Button) viewGroup.findViewById(R.id.share_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.intlgame.view.ShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareView.this.dismiss(-1);
            }
        });
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.share_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.b(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.shareChannelItemList = ShareManager.getShareListData(this.mContext, str);
        ShareAdapter shareAdapter = new ShareAdapter(this.mContext);
        shareAdapter.setShareData(this.shareChannelItemList);
        shareAdapter.setOnItemClickListener(new ShareAdapter.OnItemClickListener() { // from class: com.intlgame.view.ShareView.2
            @Override // com.intlgame.webview.ShareAdapter.OnItemClickListener
            public void onItemClick(View view, int i) {
                ShareView.this.dismiss(i);
            }
        });
        recyclerView.setAdapter(shareAdapter);
    }

    public void setShareListener(ShareListener shareListener) {
        this.mShareListener = shareListener;
    }

    public void show(FrameLayout frameLayout) {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup == null) {
            INTLLog.i("Should init view first!");
            return;
        }
        if (frameLayout == null) {
            INTLLog.e("share view need parent view，but get null");
        } else if (viewGroup.getParent() != null) {
            INTLLog.e("share view has a parent, need not add again!");
        } else {
            frameLayout.addView(this.mContainer, new FrameLayout.LayoutParams(-1, -2, 80));
        }
    }

    public void dismiss(final int i) {
        List<ShareAdapter.ItemData> list;
        if (this.mContainer == null) {
            INTLLog.i("Should init view first!");
            return;
        }
        if (this.isDismissing) {
            INTLLog.i("already dismiss");
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.intl_webview_anim_share_slide_out);
        if (loadAnimation != null) {
            INTLLog.i("dismiss with anim");
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.intlgame.view.ShareView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ShareView.this.mContainer.post(new Runnable() { // from class: com.intlgame.view.ShareView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ShareView.this.mContainer.getParent() != null) {
                                ((ViewGroup) ShareView.this.mContainer.getParent()).removeView(ShareView.this.mContainer);
                            }
                            if (ShareView.this.mShareListener != null && i > -1) {
                                INTLLog.i("share call back");
                                if (ShareView.this.shareChannelItemList != null && i < ShareView.this.shareChannelItemList.size()) {
                                    ShareAdapter.ItemData itemData = (ShareAdapter.ItemData) ShareView.this.shareChannelItemList.get(i);
                                    INTLLog.i("share call back：" + itemData.channel);
                                    ShareView.this.mShareListener.onShare(itemData.channel);
                                }
                            }
                            ShareView.this.isDismissing = false;
                        }
                    });
                }
            });
            ViewGroup viewGroup = this.mContainer;
            if (viewGroup != null) {
                viewGroup.startAnimation(loadAnimation);
                this.isDismissing = true;
                return;
            }
            return;
        }
        if (this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.mShareListener != null && i > -1 && (list = this.shareChannelItemList) != null) {
            this.mShareListener.onShare(list.get(i).channel);
        }
        this.isDismissing = false;
    }
}
