package com.helpshift.common;

import com.helpshift.HelpshiftUser;
import com.helpshift.util.StringUtils;

/* loaded from: classes2.dex */
public class HelpshiftUtils {
    public static boolean isValidHelpshiftUser(HelpshiftUser helpshiftUser) {
        if (helpshiftUser == null) {
            return false;
        }
        return (StringUtils.isEmptyWithoutTrim(helpshiftUser.getIdentifier()) && StringUtils.isEmptyWithoutTrim(helpshiftUser.getEmail())) ? false : true;
    }
}
