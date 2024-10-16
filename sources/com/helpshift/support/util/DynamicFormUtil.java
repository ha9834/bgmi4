package com.helpshift.support.util;

import android.content.Context;
import com.helpshift.support.flows.ConversationFlow;
import com.helpshift.support.flows.DynamicFormFlow;
import com.helpshift.support.flows.FAQSectionFlow;
import com.helpshift.support.flows.FAQsFlow;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.flows.SingleFAQFlow;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DynamicFormUtil {
    public static List<Flow> toFlowList(Context context, List<HashMap<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<HashMap<String, Object>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toFlow(context, it.next()));
        }
        return arrayList;
    }

    public static Flow toFlow(Context context, HashMap hashMap) {
        String str = (String) hashMap.get("type");
        HashMap hashMap2 = new HashMap();
        if (hashMap.containsKey(ConfigDBHelper.TABLE_NAME_CONFIG)) {
            hashMap2 = (HashMap) hashMap.get(ConfigDBHelper.TABLE_NAME_CONFIG);
        }
        String str2 = (String) hashMap.get("titleResourceName");
        int identifier = str2 != null ? context.getResources().getIdentifier(str2, "string", context.getPackageName()) : 0;
        String str3 = identifier == 0 ? (String) hashMap.get("title") : "";
        if (str.equals("faqsFlow")) {
            if (identifier != 0) {
                return new FAQsFlow(identifier, hashMap2);
            }
            return new FAQsFlow(str3, hashMap2);
        }
        if (str.equals("conversationFlow")) {
            if (identifier != 0) {
                return new ConversationFlow(identifier, hashMap2);
            }
            return new ConversationFlow(str3, hashMap2);
        }
        if (str.equals("faqSectionFlow")) {
            String str4 = (String) hashMap.get("data");
            if (identifier != 0) {
                return new FAQSectionFlow(identifier, str4, hashMap2);
            }
            return new FAQSectionFlow(str3, str4, hashMap2);
        }
        if (str.equals("singleFaqFlow")) {
            String str5 = (String) hashMap.get("data");
            if (identifier != 0) {
                return new SingleFAQFlow(identifier, str5, hashMap2);
            }
            return new SingleFAQFlow(str3, str5, hashMap2);
        }
        if (!str.equals("dynamicFormFlow")) {
            return null;
        }
        List<Flow> flowList = toFlowList(context, (ArrayList) hashMap.get("data"));
        if (identifier != 0) {
            return new DynamicFormFlow(identifier, flowList);
        }
        return new DynamicFormFlow(str3, flowList);
    }
}
