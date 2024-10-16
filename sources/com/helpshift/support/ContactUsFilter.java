package com.helpshift.support;

import android.content.Context;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.SupportInternal;
import com.helpshift.util.HelpshiftContext;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class ContactUsFilter {
    private static HSApiData data;
    private static Integer enableContactUs;

    /* loaded from: classes2.dex */
    public enum LOCATION {
        ACTION_BAR,
        SEARCH_FOOTER,
        QUESTION_FOOTER,
        QUESTION_ACTION_BAR,
        SEARCH_RESULT_ACTIVITY_HEADER
    }

    public static void init(Context context) {
        if (data == null) {
            data = new HSApiData(context);
            enableContactUs = Integer.valueOf(HelpshiftContext.getCoreApi().getSDKConfigurationDM().getEnableContactUs().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setConfig(HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Object obj = hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US);
        if (obj instanceof Integer) {
            enableContactUs = (Integer) hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                enableContactUs = SupportInternal.EnableContactUs.ALWAYS;
            } else {
                enableContactUs = SupportInternal.EnableContactUs.NEVER;
            }
        }
    }

    public static boolean showContactUs(LOCATION location) {
        if (location == LOCATION.SEARCH_RESULT_ACTIVITY_HEADER || SupportInternal.EnableContactUs.NEVER.equals(enableContactUs)) {
            return false;
        }
        if (SupportInternal.EnableContactUs.ALWAYS.equals(enableContactUs) || location == LOCATION.QUESTION_FOOTER) {
            return true;
        }
        if (location == LOCATION.ACTION_BAR) {
            return HelpshiftContext.getCoreApi().getActiveConversation() != null;
        }
        if (SupportInternal.EnableContactUs.AFTER_VIEWING_FAQS.equals(enableContactUs) || !SupportInternal.EnableContactUs.AFTER_MARKING_ANSWER_UNHELPFUL.equals(enableContactUs)) {
            return true;
        }
        switch (location) {
            case SEARCH_FOOTER:
                return false;
            case QUESTION_ACTION_BAR:
                return HelpshiftContext.getCoreApi().getActiveConversation() != null;
            default:
                return true;
        }
    }
}
