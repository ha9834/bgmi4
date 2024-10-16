package com.helpshift.support;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.c;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.c;
import com.helpshift.R;
import com.helpshift.activities.MainActivity;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.activities.ParentActivity;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.views.FontApplier;
import com.helpshift.views.HSToast;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class HSReviewFragment extends c {
    private static AlertToRateAppListener alertToRateAppListener;
    private final String TAG = "Helpshift_ReviewFrag";
    String rurl = "";
    private boolean disableReview = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setAlertToRateAppListener(AlertToRateAppListener alertToRateAppListener2) {
        alertToRateAppListener = alertToRateAppListener2;
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            this.disableReview = extras.getBoolean("disableReview", true);
            this.rurl = extras.getString("rurl");
        }
        return initAlertDialog(activity);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        sendReviewActionEvent("later");
        sendAlertToRateAppAction(2);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.disableReview) {
            HelpshiftContext.getCoreApi().getSDKConfigurationDM().setAppReviewed(true);
        }
        getActivity().finish();
    }

    void gotoApp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str.trim()));
        try {
            getContext().startActivity(intent);
        } catch (Exception e) {
            HSLogger.d("Helpshift_ReviewFrag", "Unable to resolve activity", e);
            HSToast.makeText(getContext(), getResources().getString(R.string.hs__could_not_open_attachment_msg), 0).show();
        }
    }

    void sendAlertToRateAppAction(int i) {
        AlertToRateAppListener alertToRateAppListener2 = alertToRateAppListener;
        if (alertToRateAppListener2 != null) {
            alertToRateAppListener2.onAction(i);
        }
        alertToRateAppListener = null;
    }

    private Dialog initAlertDialog(FragmentActivity fragmentActivity) {
        c.a aVar = new c.a(fragmentActivity);
        aVar.a(R.string.hs__review_message);
        androidx.appcompat.app.c b = aVar.b();
        b.setTitle(R.string.hs__review_title);
        b.setCanceledOnTouchOutside(false);
        b.a(-1, getResources().getString(R.string.hs__rate_button), new DialogInterface.OnClickListener() { // from class: com.helpshift.support.HSReviewFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(HSReviewFragment.this.rurl)) {
                    HSReviewFragment.this.rurl = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getString(SDKConfigurationDM.REVIEW_URL);
                }
                HSReviewFragment hSReviewFragment = HSReviewFragment.this;
                hSReviewFragment.rurl = hSReviewFragment.rurl.trim();
                if (!TextUtils.isEmpty(HSReviewFragment.this.rurl)) {
                    HSReviewFragment hSReviewFragment2 = HSReviewFragment.this;
                    hSReviewFragment2.gotoApp(hSReviewFragment2.rurl);
                }
                HSReviewFragment.this.sendReviewActionEvent("reviewed");
                HSReviewFragment.this.sendAlertToRateAppAction(0);
            }
        });
        b.a(-3, getResources().getString(R.string.hs__feedback_button), new DialogInterface.OnClickListener() { // from class: com.helpshift.support.HSReviewFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HSReviewFragment.this.sendReviewActionEvent("feedback");
                HSReviewFragment.this.sendAlertToRateAppAction(1);
                AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
                if (screen == AppSessionConstants.Screen.NEW_CONVERSATION || screen == AppSessionConstants.Screen.CONVERSATION || screen == AppSessionConstants.Screen.CONVERSATION_INFO || screen == AppSessionConstants.Screen.SCREENSHOT_PREVIEW) {
                    return;
                }
                Intent intent = new Intent(HSReviewFragment.this.getContext(), (Class<?>) ParentActivity.class);
                intent.putExtra(SupportFragment.SUPPORT_MODE, 1);
                intent.putExtra(SupportFragmentConstants.DECOMPOSED, true);
                intent.putExtra(MainActivity.SHOW_IN_FULLSCREEN, ActivityUtil.isFullScreen(HSReviewFragment.this.getActivity()));
                intent.putExtra("isRoot", true);
                intent.putExtra(NewConversationFragment.SEARCH_PERFORMED, true);
                HSReviewFragment.this.getActivity().startActivity(intent);
            }
        });
        b.a(-2, getResources().getString(R.string.hs__review_close_button), new DialogInterface.OnClickListener() { // from class: com.helpshift.support.HSReviewFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HSReviewFragment.this.sendReviewActionEvent("later");
                HSReviewFragment.this.sendAlertToRateAppAction(2);
            }
        });
        FontApplier.apply(b);
        return b;
    }

    void sendReviewActionEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "periodic");
        hashMap.put(AnalyticsEventKey.RESPONSE, str);
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.REVIEWED_APP, hashMap);
    }
}
