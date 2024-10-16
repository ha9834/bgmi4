package com.tencent.grobot.lite.common;

import android.text.TextUtils;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.model.data.LikeUnlikeSelectInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DataManager {
    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }
        return instance;
    }

    public void setTicketStared(String str, int i) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getTicketExtraKey(), "");
        if (sharedParam != null) {
            try {
                if (!TextUtils.isEmpty(sharedParam) && (optJSONArray = (jSONObject = new JSONObject(sharedParam)).optJSONArray("tickets")) != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (str.equals(optJSONArray.getJSONObject(i2).optString("ticketId"))) {
                            return;
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ticketId", str);
                    jSONObject2.put("rating", i);
                    optJSONArray.put(optJSONArray.length(), jSONObject2);
                    jSONObject.put("tickets", optJSONArray);
                    GRobotApplication.getInstance().setSharedParam(getTicketExtraKey(), jSONObject.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ticketId", str);
        jSONObject3.put("rating", i);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0, jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("tickets", jSONArray);
        GRobotApplication.getInstance().setSharedParam(getTicketExtraKey(), jSONObject4.toString());
    }

    public int getTicketStarRating(String str) {
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getTicketExtraKey(), "");
        if (sharedParam == null) {
            return -1;
        }
        try {
            if (TextUtils.isEmpty(sharedParam) || (optJSONArray = new JSONObject(sharedParam).optJSONArray("tickets")) == null) {
                return -1;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (str.equals(optJSONArray.getJSONObject(i).optString("ticketId"))) {
                    return optJSONArray.getJSONObject(i).optInt("rating");
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setSessionStared(String str, int i) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getSessionExtraKey(), "");
        if (sharedParam != null) {
            try {
                if (!TextUtils.isEmpty(sharedParam) && (optJSONArray = (jSONObject = new JSONObject(sharedParam)).optJSONArray("sessions")) != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (str.equals(optJSONArray.getJSONObject(i2).optString("sessionId"))) {
                            return;
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sessionId", str);
                    jSONObject2.put("rating", i);
                    optJSONArray.put(optJSONArray.length(), jSONObject2);
                    jSONObject.put("sessions", optJSONArray);
                    GRobotApplication.getInstance().setSharedParam(getSessionExtraKey(), jSONObject.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("sessionId", str);
        jSONObject3.put("rating", i);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0, jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("sessions", jSONArray);
        GRobotApplication.getInstance().setSharedParam(getSessionExtraKey(), jSONObject4.toString());
    }

    public int getSessionRating(String str) {
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getSessionExtraKey(), "");
        if (sharedParam == null) {
            return -1;
        }
        try {
            if (TextUtils.isEmpty(sharedParam) || (optJSONArray = new JSONObject(sharedParam).optJSONArray("sessions")) == null) {
                return -1;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (str.equals(optJSONArray.getJSONObject(i).optString("sessionId"))) {
                    return optJSONArray.getJSONObject(i).optInt("rating");
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setLikeUnlikeSelected(String str, LikeUnlikeSelectInfo likeUnlikeSelectInfo) {
        if (likeUnlikeSelectInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("answerKey", str);
                jSONObject.put("firstLevelValue", likeUnlikeSelectInfo.firstText);
                jSONObject.put("secondLevelValue", likeUnlikeSelectInfo.secondText);
                GRobotApplication.getInstance().setSharedParam(getLikeUnlikeExtraKey(), jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LikeUnlikeSelectInfo getLikeUnlideSelectInfo(String str) {
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getLikeUnlikeExtraKey(), "");
        if (sharedParam == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sharedParam)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(sharedParam);
            if (!str.equals(jSONObject.optString("answerKey"))) {
                return null;
            }
            LikeUnlikeSelectInfo likeUnlikeSelectInfo = new LikeUnlikeSelectInfo();
            likeUnlikeSelectInfo.firstText = jSONObject.optString("firstLevelValue");
            likeUnlikeSelectInfo.secondText = jSONObject.optString("secondLevelValue");
            return likeUnlikeSelectInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setGiftGetted(String str, String str2) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getGiftExtraKey(), "");
        String str3 = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str) && str2 != null && !TextUtils.isEmpty(str2) && sharedParam != null && !TextUtils.isEmpty(sharedParam) && (optJSONArray = (jSONObject = new JSONObject(sharedParam)).optJSONArray("gifts")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (str3.equals(optJSONArray.getJSONObject(i).optString("groupId_amsId"))) {
                            return;
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("groupId_amsId", str3);
                    optJSONArray.put(optJSONArray.length(), jSONObject2);
                    jSONObject.put("gifts", optJSONArray);
                    GRobotApplication.getInstance().setSharedParam(getGiftExtraKey(), jSONObject.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("groupId_amsId", str3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0, jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("gifts", jSONArray);
        GRobotApplication.getInstance().setSharedParam(getGiftExtraKey(), jSONObject4.toString());
    }

    public boolean getGiftGet(String str, String str2) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String str3 = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getGiftExtraKey(), "");
        if (sharedParam != null) {
            try {
                if (!TextUtils.isEmpty(sharedParam) && (optJSONArray = new JSONObject(sharedParam).optJSONArray("gifts")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (str3.equals(optJSONArray.getJSONObject(i).optString("groupId_amsId"))) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void saveSearchHistory(String str) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getSearchHistoryExtraKey(), "");
        try {
            if (!TextUtils.isEmpty(str)) {
                LinkedList linkedList = new LinkedList();
                if (sharedParam != null && !TextUtils.isEmpty(sharedParam) && (optJSONArray = (jSONObject = new JSONObject(sharedParam)).optJSONArray("historys")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.getJSONObject(i).optString("item");
                        if (!optString.equals(str)) {
                            linkedList.addLast(optString);
                        }
                    }
                    linkedList.addFirst(str);
                    if (linkedList.size() > 3) {
                        linkedList.removeLast();
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < linkedList.size(); i2++) {
                        String str2 = (String) linkedList.get(i2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("item", str2);
                        jSONArray.put(i2, jSONObject2);
                    }
                    jSONObject.put("historys", jSONArray);
                    GRobotApplication.getInstance().setSharedParam(getSearchHistoryExtraKey(), jSONObject.toString());
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("item", str);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("historys", jSONArray2);
            GRobotApplication.getInstance().setSharedParam(getSearchHistoryExtraKey(), jSONObject4.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getSearchHistory() {
        JSONArray optJSONArray;
        ArrayList<String> arrayList = new ArrayList<>();
        String sharedParam = GRobotApplication.getInstance().getSharedParam(getSearchHistoryExtraKey(), "");
        if (sharedParam != null) {
            try {
                if (!TextUtils.isEmpty(sharedParam) && (optJSONArray = new JSONObject(sharedParam).optJSONArray("historys")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.getJSONObject(i).optString("item");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private void storeSearchHistory(ArrayList<String> arrayList) {
        new StringBuilder();
    }

    private static String getExtraPrefix() {
        return GRobotApplication.getInstance().getOpenId() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + GRobotApplication.getInstance().getRoleId();
    }

    private static String getSessionExtraKey() {
        return getExtraPrefix() + "_sessioninfo";
    }

    private static String getTicketExtraKey() {
        return getExtraPrefix() + "_ticketinfo";
    }

    private static String getGiftExtraKey() {
        return getExtraPrefix() + "_giftinfo";
    }

    private static String getLikeUnlikeExtraKey() {
        return getExtraPrefix() + "_likeunlikeinfo";
    }

    private static String getSearchHistoryExtraKey() {
        return getExtraPrefix() + "_search_history";
    }
}
