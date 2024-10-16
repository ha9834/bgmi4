package com.tencent.grobot.lite.model.local;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class EvaluateInfo {
    public static final String TYPE_IM = "im";
    public static final String TYPE_ROBOT = "robot";
    public static final String TYPE_TICKET = "ticket";
    public ArrayList<EvaluateItemInfo> options;
    public String evaluateDesc = "";
    public String evaluateType = TYPE_ROBOT;
    public String evaluateId = "";
}
