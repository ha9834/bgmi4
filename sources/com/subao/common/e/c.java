package com.subao.common.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f5979a = {"notification", "pps", "pptv", "theme", "wallpaper", "wifi", "安装", "八门神器", "百宝箱", "伴侣", "宝典", "备份", "必备", "壁纸", "变速", "表情", "补丁", "插件", "查询", "查询", "出招表", "春节神器", "答题", "大全", "大师", "单机", "动态", "翻图", "辅助", "辅助", "改名", "工具", "攻略", "喊话", "合成表", "合集", "盒子", "红包神器", "画报", "集市", "计算", "技巧", "計算", "加速", "脚本", "解说", "精选", "剧场", "快问", "礼包", "连招表", "论坛", "漫画", "秘籍", "模拟器", "魔盒", "配装器", "拼图", "启动器", "全集", "社区", "视频", "视讯", "手册", "刷开局", "刷魔", "锁屏", "台词", "特辑", "头条", "图集", "图鉴", "圖鑑", "外挂", "系列", "下载", "小说", "小智", "修改", "一键", "英雄帮", "英雄榜", "游戏盒", "游戏通", "掌游宝", "照相", "直播", "指南", "制作器", "主题", "助理", "助手", "抓包", "追剧", "桌面", "资料", "资讯", "資料", "作弊"};
    private static final String[] b = {"掌上英雄联盟"};
    private static final String[] c = {"com.kugou.android", "com.huluxia.mctool", "com.tencent.qt.sns"};
    private static final Locale d = Locale.US;
    private final HashMap<String, b> e;

    static boolean a(String str) {
        for (String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(d);
            for (String str2 : c) {
                if (str2.equals(lowerCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public c(List<b> list) {
        if (list == null || list.isEmpty()) {
            this.e = null;
            return;
        }
        this.e = new HashMap<>(list.size());
        for (b bVar : list) {
            this.e.put(bVar.f5977a.toLowerCase(d), bVar);
        }
    }

    public b a(String str, String str2) {
        b b2 = b(str, str2);
        return (b2 == null || !"com.valvesoftware.android.steam.community".equals(str)) ? b2 : b2.a(b2.c | 64);
    }

    private b b(String str, String str2) {
        HashMap<String, b> hashMap;
        b bVar;
        if (str2 == null || str2.length() == 0 || a(str2) || b(str)) {
            return null;
        }
        String lowerCase = str2.toLowerCase(d);
        HashMap<String, b> hashMap2 = this.e;
        if (hashMap2 != null && (bVar = hashMap2.get(lowerCase)) != null) {
            return bVar;
        }
        if (lowerCase.length() > 3 && (hashMap = this.e) != null) {
            for (Map.Entry<String, b> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (key.length() > 2) {
                    b value = entry.getValue();
                    if (!value.d && !value.b() && lowerCase.contains(key)) {
                        if (c(lowerCase)) {
                            return null;
                        }
                        return value;
                    }
                }
            }
        }
        return null;
    }

    public boolean c(String str) {
        for (String str2 : f5979a) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
