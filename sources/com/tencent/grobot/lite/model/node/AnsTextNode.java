package com.tencent.grobot.lite.model.node;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.helpshift.db.smartintents.tables.SmartIntentWordProbabilitiesTable;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AnsTextNode extends BaseNode {
    public static final int EMPTY_LINK_TYPE = -1;
    public static final int INNER_LINK_TYPE = 2;
    public static final int QUESTION_LINK_TYPE = 0;
    public static final int WEB_LINK_TYPE = 1;
    private static final String hrefFormat = "<a href=\"%1$s\">%2$s</a>";
    public String actionUrl;
    public String answerId;
    public EvaluateInfo evaluateInfo;
    public ArrayList<LinkInfo> linkInfos;
    public String quesText;
    public String questionId;
    public String rawText;
    public long timestamp = -1;
    public String answerKey = "";
    public int status = 0;
    public String linkWord = "";
    public int linkType = -1;
    public int position = 0;
    public boolean showGoodBad = true;

    /* loaded from: classes2.dex */
    public static final class LinkInfo implements Serializable {
        public String questionId;
        public int type;
        public String url;
        public String word;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 1;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.questionId;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getRawContent() {
        return this.rawText;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getStatus() {
        return this.status;
    }

    public String getLinkWord() {
        return this.linkWord;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getExtra() {
        return this.actionUrl;
    }

    public void initTime() {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.answerKey = String.valueOf(System.currentTimeMillis());
    }

    public SpannableStringBuilder parseRichText(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.rawText = str;
        String mergeTextAndLink = mergeTextAndLink(str.replace("\\n", "\n"), str3);
        if (isHyperlink()) {
            return null;
        }
        return new SpannableStringBuilder(mergeTextAndLink);
    }

    public boolean isHyperlink() {
        return !TextUtils.isEmpty(this.actionUrl);
    }

    private String mergeTextAndLink(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() <= 0) {
                return str;
            }
            String str3 = str;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String string = jSONObject.getString("url");
                        String string2 = jSONObject.getString(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_WORD);
                        String string3 = jSONObject.getString("link_type");
                        if ("question".equals(string3)) {
                            this.linkType = 0;
                            LinkInfo linkInfo = new LinkInfo();
                            linkInfo.word = string2;
                            linkInfo.questionId = jSONObject.getString("question_id");
                            linkInfo.type = 0;
                            if (this.linkInfos == null) {
                                this.linkInfos = new ArrayList<>();
                            }
                            this.linkInfos.add(linkInfo);
                        } else if ("new_page".equals(string3)) {
                            this.linkType = 1;
                            LinkInfo linkInfo2 = new LinkInfo();
                            linkInfo2.word = string2;
                            linkInfo2.url = string;
                            linkInfo2.type = 1;
                            if (this.linkInfos == null) {
                                this.linkInfos = new ArrayList<>();
                            }
                            this.linkInfos.add(linkInfo2);
                        } else if ("custom_page".equals(string3)) {
                            this.linkType = 2;
                            LinkInfo linkInfo3 = new LinkInfo();
                            linkInfo3.word = string2;
                            linkInfo3.url = string;
                            linkInfo3.type = 2;
                            if (this.linkInfos == null) {
                                this.linkInfos = new ArrayList<>();
                            }
                            this.linkInfos.add(linkInfo3);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            string = !string.contains("?") ? string + "?jumpWebview=1" : string + "&jumpWebview=1";
                        }
                        str3 = str3.replace(string2, String.format(hrefFormat, string, string2));
                    }
                } catch (Exception unused) {
                    return str3;
                }
            }
            return str3;
        } catch (Exception unused2) {
            return str;
        }
    }
}
