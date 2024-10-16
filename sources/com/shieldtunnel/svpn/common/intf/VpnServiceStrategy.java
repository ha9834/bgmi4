package com.shieldtunnel.svpn.common.intf;

/* loaded from: classes2.dex */
public class VpnServiceStrategy {
    public static final String DEFAULT_SESSION_NAME = "SVPN";
    public static final int IP_VERSION_SUPPORT_V4 = 1;
    public static final int IP_VERSION_SUPPORT_V6 = 2;
    public static boolean allowSystemUi = false;
    public static Integer appFilterMode = null;
    public static String description = "Fast, Stable and Safe";
    public static Integer iconResId = null;
    public static Integer ipVersionSupport = null;
    public static String sessionName = "SVPN";
    public static Integer startCommandResult;

    /* loaded from: classes2.dex */
    public static class FilterMode {
        public static final int ALLOW_ALL = 5;
        public static final int ALLOW_GAME = 0;
        public static final int ALLOW_SELF_ONLY = 2;
        public static final int DISALLOW_ALL_EXCEPT_SELF = 3;
        public static final int DISALLOW_NON_GAME = 1;
        public static final int DISALLOW_SELF_ONLY = 4;
    }

    /* loaded from: classes2.dex */
    public static class IpVersion {
    }

    /* loaded from: classes2.dex */
    public static class Name {
        public static final String ALLOW_SYSTEM_UI = "allowSystemUi";
        public static final String DESCRIPTION = "description";
        public static final String FILTER_MODE = "filterMode";
        public static final String ICON_RES_ID = "iconResId";
        public static final String IP_VERSION_SUPPORT = "ipVersionSupport";
        public static final String SESSION_NAME = "sessionName";
        public static final String START_COMMAND_RESULT = "startCommandResult";
    }
}
