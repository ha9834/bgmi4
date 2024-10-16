package com.tencent.grobot.lite.model.local;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class EvaluateItemInfo {
    public static final String ACTIONTYPE_API = "api";
    public static final String ACTIONTYPE_EXT = "ext";
    public static final String ACTIONTYPE_INPUT = "input";
    public ArrayList<EvaluateItemInfo> extInfos;
    public int itemLevel = 1;
    public String evaluateType = EvaluateInfo.TYPE_ROBOT;
    public String evaluateId = "";
    public int evaluateValue = 0;
    public String optionText = "";
    public String reqText = "";
    public String selectText = "";
    public String actionType = ACTIONTYPE_API;
    public String iconType = "";
    public String commitText = "";
    public String extDesc = "";
    public boolean selected = false;
    public boolean enable = true;
    public String answerKey = "";
    public String fistClickText = "";
    public String secondClickText = "";
}
