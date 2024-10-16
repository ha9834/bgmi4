package com.tencent.grobot.lite.model.local;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AnswerInfo {
    public String gameId = "";
    public String source = "";
    public String openId = "";
    public String questionId = "";
    public String answerId = "";
    public String sessionId = "";
    public String modeType = "";
    public String imStatus = "";
    public ArrayList<AnswerItemInfo> answerList = null;
    public ArrayList<OptionItemInfo> optionList = null;
    public boolean isLikeDisplay = true;
    public int timestamp = 0;
    public byte isHisDisplay = 0;
}
