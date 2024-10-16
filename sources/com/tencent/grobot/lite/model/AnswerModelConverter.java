package com.tencent.grobot.lite.model;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.local.AnswerComponentInfo;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.AnswerItemInfo;
import com.tencent.grobot.lite.model.local.ContainerInfo;
import com.tencent.grobot.lite.model.local.DetailInfo;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.local.GiftItemInfo;
import com.tencent.grobot.lite.model.local.HotTextItemInfo;
import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.model.local.PicItemInfo;
import com.tencent.grobot.lite.model.local.QuestionInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.local.ToolItemInfo;
import com.tencent.grobot.lite.model.local.VideoItemInfo;
import com.tencent.imsdk.android.login.migrate.MigrateWebConsts;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AnswerModelConverter {
    private static final String TAG = "AnswerModelConverter";

    public static AnswerInfo convertAnswer(JSONObject jSONObject) {
        JSONObject optJSONObject;
        AnswerInfo answerInfo = new AnswerInfo();
        try {
            optJSONObject = jSONObject.optJSONObject("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (optJSONObject == null) {
            return answerInfo;
        }
        answerInfo.gameId = optJSONObject.optString(MigrateWebConsts.MIGRATE_WEB_PROTOCOL_GAME_ID);
        answerInfo.source = optJSONObject.optString("source");
        answerInfo.openId = optJSONObject.optString("openid");
        answerInfo.questionId = optJSONObject.optString("questionid");
        answerInfo.answerId = optJSONObject.optString("answerid");
        answerInfo.sessionId = optJSONObject.optString("sessionid");
        answerInfo.modeType = optJSONObject.optString("mode_type");
        answerInfo.imStatus = optJSONObject.optString("im_status");
        answerInfo.answerList = convertAnswerItems(optJSONObject.optJSONArray("answer"), answerInfo.answerId, false);
        JSONArray optJSONArray = optJSONObject.optJSONArray("option");
        if (optJSONArray != null) {
            ArrayList<OptionItemInfo> arrayList = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                OptionItemInfo optionItemInfo = new OptionItemInfo();
                optionItemInfo.optionId = optJSONArray.optJSONObject(i).optString("option_id");
                optionItemInfo.optionText = optJSONArray.optJSONObject(i).optString("option_text");
                optionItemInfo.optionType = optJSONArray.optJSONObject(i).optInt("option_type");
                arrayList.add(optionItemInfo);
            }
            answerInfo.optionList = arrayList;
        }
        return answerInfo;
    }

    public static ArrayList<AnswerItemInfo> convertAnswerItems(JSONArray jSONArray, String str, boolean z) {
        ArrayList<AnswerItemInfo> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                AnswerItemInfo converAnswerItemInfo = converAnswerItemInfo(jSONArray.optJSONObject(i), str, z);
                if (converAnswerItemInfo != null) {
                    arrayList.add(converAnswerItemInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static AnswerItemInfo converAnswerItemInfo(JSONObject jSONObject, String str, boolean z) {
        ContainerInfo convertContainerInfo;
        MixTipInfo mixTipInfo;
        VideoItemInfo videoItemInfo;
        PicItemInfo picItemInfo;
        AnswerItemInfo answerItemInfo = new AnswerItemInfo();
        answerItemInfo.tplType = jSONObject.optInt("tpl_type");
        int i = answerItemInfo.tplType;
        TLog.d(TAG, "convertAnswerItems, tplType=" + i);
        JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.CONTENT);
        ArrayList<AnswerComponentInfo> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            AnswerComponentInfo answerComponentInfo = new AnswerComponentInfo();
            answerComponentInfo.text = optJSONArray.optJSONObject(i2).optString("text");
            answerComponentInfo.linkWord = optJSONArray.optJSONObject(i2).optString("link_word");
            answerComponentInfo.form_template_id = optJSONArray.optJSONObject(i2).optString("form_template_id");
            answerComponentInfo.ticket_id = optJSONArray.optJSONObject(i2).optString("ticket_id");
            JSONArray optJSONArray2 = optJSONArray.optJSONObject(i2).optJSONArray("question");
            if (optJSONArray2 != null) {
                ArrayList<HotTextItemInfo> arrayList2 = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    HotTextItemInfo hotTextItemInfo = new HotTextItemInfo();
                    hotTextItemInfo.type = optJSONArray2.optJSONObject(i3).optString("type");
                    hotTextItemInfo.questionId = optJSONArray2.optJSONObject(i3).optString("question_id");
                    hotTextItemInfo.questionText = optJSONArray2.optJSONObject(i3).optString("question_display_text");
                    arrayList2.add(hotTextItemInfo);
                }
                answerComponentInfo.questionList = arrayList2;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("evaluate_type");
            if (!z && optString != null && !TextUtils.isEmpty(optString)) {
                answerComponentInfo.feedInfo = convertEvaluateInfo(optJSONObject, optString);
            }
            if (i == 2 && (picItemInfo = getPicItemInfo(optJSONArray.optJSONObject(i2))) != null) {
                answerComponentInfo.picInfo = picItemInfo;
            }
            if (i == 3 && (videoItemInfo = getVideoItemInfo(optJSONArray.optJSONObject(i2))) != null) {
                answerComponentInfo.videoInfo = videoItemInfo;
            }
            if (i == 13) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2.has("tip_div_content")) {
                    MixTipInfo mixTipInfo2 = getMixTipInfo(optJSONObject2);
                    if (mixTipInfo2 != null) {
                        answerComponentInfo.mixTip = mixTipInfo2;
                    }
                } else {
                    VideoItemInfo videoItemInfo2 = getVideoItemInfo(optJSONObject2);
                    if (videoItemInfo2 != null) {
                        answerComponentInfo.videoInfo = videoItemInfo2;
                    }
                }
            }
            if (i == 4 && (mixTipInfo = getMixTipInfo(optJSONArray.optJSONObject(i2))) != null) {
                answerComponentInfo.mixTip = mixTipInfo;
            }
            if (i == 5) {
                ToolItemInfo toolItemInfo = new ToolItemInfo();
                toolItemInfo.toolName = optJSONArray.optJSONObject(i2).optString("tool_name");
                toolItemInfo.toolDesc = optJSONArray.optJSONObject(i2).optString("tool_desc");
                toolItemInfo.timePeriod = optJSONArray.optJSONObject(i2).optInt("time_period");
                toolItemInfo.appIndex = optJSONArray.optJSONObject(i2).optString("app_index");
                toolItemInfo.toolData = optJSONArray.optJSONObject(i2).optString("tool_data");
                toolItemInfo.errorMsg = optJSONArray.optJSONObject(i2).optString("err_msg");
                answerComponentInfo.toolInfo = toolItemInfo;
            }
            if (i == 6 && (convertContainerInfo = convertContainerInfo(optJSONArray.optJSONObject(i2))) != null) {
                answerComponentInfo.containerInfo = convertContainerInfo;
            }
            if (i == 8) {
                GiftItemInfo giftItemInfo = new GiftItemInfo();
                giftItemInfo.isReceived = optJSONArray.optJSONObject(i2).optBoolean("is_received");
                giftItemInfo.groupId = optJSONArray.optJSONObject(i2).optString(FirebaseAnalytics.Param.GROUP_ID);
                giftItemInfo.amsId = optJSONArray.optJSONObject(i2).optString("ams_id");
                giftItemInfo.image = optJSONArray.optJSONObject(i2).optString("card_image");
                giftItemInfo.packageName = optJSONArray.optJSONObject(i2).optString("package_name");
                giftItemInfo.packageDesc = optJSONArray.optJSONObject(i2).optString("package_desc");
                giftItemInfo.answerId = str;
                answerComponentInfo.giftInfo = giftItemInfo;
            }
            arrayList.add(answerComponentInfo);
        }
        answerItemInfo.contentList = arrayList;
        return answerItemInfo;
    }

    private static ContainerInfo convertContainerInfo(JSONObject jSONObject) {
        QuestionInfo questionItemInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE);
            if (optString.equals("tip")) {
                MixTipInfo mixTipInfo = getMixTipInfo(jSONObject);
                if (mixTipInfo != null) {
                    ContainerInfo containerInfo = new ContainerInfo();
                    containerInfo.itemType = 3;
                    containerInfo.tipInfo = mixTipInfo;
                    return containerInfo;
                }
            } else if (optString.equals("video")) {
                VideoItemInfo videoItemInfo = getVideoItemInfo(jSONObject);
                if (videoItemInfo != null) {
                    ContainerInfo containerInfo2 = new ContainerInfo();
                    containerInfo2.itemType = 2;
                    containerInfo2.videoInfo = videoItemInfo;
                    return containerInfo2;
                }
            } else if (optString.equals("image")) {
                PicItemInfo picItemInfo = getPicItemInfo(jSONObject);
                if (picItemInfo != null) {
                    ContainerInfo containerInfo3 = new ContainerInfo();
                    containerInfo3.itemType = 1;
                    containerInfo3.picInfo = picItemInfo;
                    return containerInfo3;
                }
            } else if ("question".equals(optString) && (questionItemInfo = getQuestionItemInfo(jSONObject)) != null) {
                ContainerInfo containerInfo4 = new ContainerInfo();
                containerInfo4.itemType = 4;
                containerInfo4.questionInfo = questionItemInfo;
                return containerInfo4;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static PicItemInfo getPicItemInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            PicItemInfo picItemInfo = new PicItemInfo();
            picItemInfo.resourceId = jSONObject.optString("resource_id");
            picItemInfo.name = jSONObject.optString("name");
            picItemInfo.url = jSONObject.optString("url");
            picItemInfo.thumbImageUrl = getImageUrl(jSONObject.optString("image"));
            return picItemInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static VideoItemInfo getVideoItemInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            VideoItemInfo videoItemInfo = new VideoItemInfo();
            videoItemInfo.resourceId = jSONObject.optString("resource_id");
            videoItemInfo.name = jSONObject.optString("name");
            videoItemInfo.url = jSONObject.optString("url");
            videoItemInfo.videoId = jSONObject.optString("video_id");
            videoItemInfo.videoTime = jSONObject.optInt("vt");
            videoItemInfo.videoSize = jSONObject.optInt("vsize");
            videoItemInfo.videoViews = jSONObject.optInt("views");
            videoItemInfo.thumbImageUrl = getImageUrl(jSONObject.optString("image"));
            videoItemInfo.updateTime = jSONObject.optInt("update_time");
            return videoItemInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static MixTipInfo getMixTipInfo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        try {
            MixTipInfo mixTipInfo = new MixTipInfo();
            mixTipInfo.title = jSONObject.optString("name");
            mixTipInfo.thumbImageUrl = getImageUrl(jSONObject.optString("image"));
            mixTipInfo.format = jSONObject.optInt("content_format");
            mixTipInfo.views = jSONObject.optInt("views");
            mixTipInfo.resourceId = jSONObject.optString("resource_id");
            String optString = jSONObject.optString("tip_div_content");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray optJSONArray = jSONArray.optJSONObject(i).optJSONArray("div_item");
                        if (optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                            MixTipInfo.Item item = new MixTipInfo.Item();
                            item.type = "image".equals(optJSONObject.optString("type")) ? 0 : 1;
                            if (item.type == 0) {
                                item.source = optJSONObject.optString("image");
                            } else {
                                item.source = optJSONObject.optString(FirebaseAnalytics.Param.CONTENT);
                            }
                            String optString2 = optJSONObject.optString("float");
                            if (ViewHierarchyConstants.DIMENSION_LEFT_KEY.equals(optString2)) {
                                item.floatPosition = 0;
                            } else if ("right".equals(optString2)) {
                                item.floatPosition = 2;
                            } else {
                                item.floatPosition = 1;
                            }
                            mixTipInfo.items.add(item);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            return mixTipInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QuestionInfo getQuestionItemInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.resourceId = jSONObject.optString("resource_id", "");
        questionInfo.name = jSONObject.optString("name", "");
        questionInfo.image = jSONObject.optString("image", "");
        return questionInfo;
    }

    public static ArrayList<HotTopicInfo> convertHotTopicList(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList<HotTopicInfo> arrayList = new ArrayList<>();
        try {
            optJSONArray = jSONObject.optJSONArray("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            HotTopicInfo hotTopicInfo = new HotTopicInfo();
            hotTopicInfo.name = optJSONArray.optJSONObject(i).optString("name");
            hotTopicInfo.questionId = optJSONArray.optJSONObject(i).optString("question_id");
            hotTopicInfo.desc = optJSONArray.optJSONObject(i).optString("second_name");
            arrayList.add(hotTopicInfo);
        }
        return arrayList;
    }

    public static EvaluateInfo convertEvaluateInfo(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        EvaluateInfo evaluateInfo = new EvaluateInfo();
        evaluateInfo.evaluateType = str;
        evaluateInfo.evaluateId = jSONObject.optString("evaluate_id");
        evaluateInfo.evaluateDesc = jSONObject.optString("evaluate_text");
        JSONArray optJSONArray = jSONObject.optJSONArray("evaluate_options");
        if (optJSONArray != null) {
            ArrayList<EvaluateItemInfo> arrayList = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                EvaluateItemInfo evaluateItemInfo = new EvaluateItemInfo();
                evaluateItemInfo.itemLevel = 1;
                evaluateItemInfo.evaluateType = evaluateInfo.evaluateType;
                evaluateItemInfo.evaluateId = evaluateInfo.evaluateId;
                evaluateItemInfo.evaluateValue = optJSONArray.optJSONObject(i).optInt("evaluate_value");
                evaluateItemInfo.actionType = optJSONArray.optJSONObject(i).optString("type");
                evaluateItemInfo.optionText = optJSONArray.optJSONObject(i).optString("text");
                evaluateItemInfo.reqText = evaluateItemInfo.optionText;
                evaluateItemInfo.selectText = evaluateItemInfo.optionText;
                evaluateItemInfo.commitText = optJSONArray.optJSONObject(i).optString("commit_text");
                evaluateItemInfo.iconType = optJSONArray.optJSONObject(i).optString("icon");
                JSONObject optJSONObject = optJSONArray.optJSONObject(i).optJSONObject("ext_info");
                ArrayList<EvaluateItemInfo> arrayList2 = new ArrayList<>();
                if (optJSONObject != null) {
                    evaluateItemInfo.extDesc = optJSONObject.optString("text");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("option");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            EvaluateItemInfo evaluateItemInfo2 = new EvaluateItemInfo();
                            evaluateItemInfo2.itemLevel = 2;
                            evaluateItemInfo2.actionType = optJSONArray2.optJSONObject(i2).optString("type");
                            evaluateItemInfo2.optionText = optJSONArray2.optJSONObject(i2).optString("text");
                            evaluateItemInfo2.reqText = evaluateItemInfo2.optionText;
                            evaluateItemInfo2.selectText = evaluateItemInfo2.optionText;
                            evaluateItemInfo2.evaluateType = evaluateItemInfo.evaluateType;
                            evaluateItemInfo2.evaluateId = evaluateItemInfo.evaluateId;
                            evaluateItemInfo2.evaluateValue = evaluateItemInfo.evaluateValue;
                            arrayList2.add(evaluateItemInfo2);
                        }
                    }
                }
                evaluateItemInfo.extInfos = arrayList2;
                arrayList.add(evaluateItemInfo);
            }
            evaluateInfo.options = arrayList;
        }
        return evaluateInfo;
    }

    public static List<RecommendsInfo> convertRecommends(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("result");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    RecommendsInfo recommendsInfo = new RecommendsInfo();
                    recommendsInfo.name = optJSONObject.optString("tag_name", "");
                    recommendsInfo.type = optJSONObject.optInt("type", 0);
                    recommendsInfo.id = optJSONObject.optString("tag_id", "");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("recommend_info");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        recommendsInfo.items.addAll(getRecomendItems(optJSONArray2));
                    }
                    arrayList.add(recommendsInfo);
                }
            }
        }
        return arrayList;
    }

    public static RecommendsInfo convertDetailRecommends(JSONObject jSONObject) {
        RecommendsInfo recommendsInfo = new RecommendsInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return recommendsInfo;
        }
        recommendsInfo.items.addAll(getRecomendItems(optJSONObject.optJSONArray("recommend_info")));
        return recommendsInfo;
    }

    public static DetailInfo convertRecommendDetail(JSONObject jSONObject) {
        DetailInfo detailInfo = new DetailInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return detailInfo;
        }
        detailInfo.isLike = optJSONObject.optBoolean("is_like", false);
        detailInfo.likeNum = optJSONObject.optInt("like_num", 0);
        detailInfo.items.addAll(getRecomendItems(optJSONObject.optJSONArray("recommend_info")));
        return detailInfo;
    }

    private static List<RecommendsInfo.Item> getRecomendItems(JSONArray jSONArray) {
        RecommendsInfo.Item recommendItem;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (recommendItem = getRecommendItem(optJSONObject)) != null) {
                arrayList.add(recommendItem);
            }
        }
        return arrayList;
    }

    public static RecommendsInfo.Item getRecommendItem(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RecommendsInfo.Item item = new RecommendsInfo.Item();
        String optString = jSONObject.optString("type");
        if ("video".equals(optString)) {
            item.type = 10;
        } else if ("tip".equals(optString)) {
            item.type = 11;
        } else {
            item.type = 12;
        }
        item.url = jSONObject.optString("url");
        item.resourceId = jSONObject.optString("resource_id");
        item.name = jSONObject.optString("name");
        item.image = jSONObject.optString("image");
        item.contentFormat = jSONObject.optString("content_format");
        item.videoId = jSONObject.optString("video_id");
        item.vt = jSONObject.optInt("vt");
        item.vszie = jSONObject.optInt("vszie");
        item.views = jSONObject.optLong("views", 0L);
        item.updateTime = jSONObject.optLong("update_time", -1L);
        item.question = jSONObject.optString("question", "");
        String optString2 = jSONObject.optString("icon", "");
        if ("hot".equals(optString2)) {
            item.icon = 0;
        } else if ("new".equals(optString2)) {
            item.icon = 1;
        } else {
            item.icon = -1;
        }
        item.recommendTitle = jSONObject.optString("recommend_title", "");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tip_div_content");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            int length = optJSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("div_item")) != null && optJSONArray.length() > 0) {
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            MixTipInfo.Item item2 = new MixTipInfo.Item();
                            item2.type = !"image".equals(optJSONObject2.optString("type")) ? 1 : 0;
                            if (item2.type == 0) {
                                item2.source = optJSONObject2.optString("image");
                            } else {
                                item2.source = optJSONObject2.optString(FirebaseAnalytics.Param.CONTENT);
                            }
                            String optString3 = optJSONObject2.optString("float");
                            if (ViewHierarchyConstants.DIMENSION_LEFT_KEY.equals(optString3)) {
                                item2.floatPosition = 0;
                            } else if ("right".equals(optString3)) {
                                item2.floatPosition = 2;
                            } else {
                                item2.floatPosition = 1;
                            }
                            item.tips.add(item2);
                        }
                    }
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(MessengerShareContentUtility.SUBTITLE);
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            int length3 = optJSONArray3.length();
            for (int i3 = 0; i3 < length3; i3++) {
                String optString4 = optJSONArray3.optString(i3, "");
                if (!TextUtils.isEmpty(optString4)) {
                    item.subtitle.add(optString4);
                }
            }
        }
        return item;
    }

    public static NavigationInfo convertNavigation(JSONObject jSONObject) {
        JSONArray optJSONArray;
        NavigationInfo navigationInfo = new NavigationInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("recommend_info")) == null || optJSONArray.length() == 0) {
            return navigationInfo;
        }
        navigationInfo.items.addAll(getRecomendItems(optJSONArray));
        return navigationInfo;
    }

    public static List<TagInfo> convertNavigationIndex(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("tag_list")) == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
            if (optJSONObject2 != null) {
                TagInfo tagInfo = new TagInfo();
                tagInfo.parent = null;
                tagInfo.id = optJSONObject2.optString("tag_id");
                tagInfo.name = optJSONObject2.optString("tag_name");
                tagInfo.subs = new ArrayList();
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sub_tag_list");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject3 != null) {
                            TagInfo tagInfo2 = new TagInfo();
                            tagInfo2.parent = tagInfo.id;
                            tagInfo2.id = optJSONObject3.optString("tag_id");
                            tagInfo2.name = optJSONObject3.optString("tag_name");
                            tagInfo.subs.add(tagInfo2);
                        }
                    }
                }
                arrayList.add(tagInfo);
            }
        }
        return arrayList;
    }

    private static String getImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("http")) {
                return "https:" + str;
            }
            if (str.startsWith("http:")) {
                return str.replace("http:", "https:");
            }
        }
        return str;
    }

    public static List<String> convertKeywordsList(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("keyword_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i, "");
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }
}
