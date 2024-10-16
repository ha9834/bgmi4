package com.tencent.gsdk.utils;

/* loaded from: classes2.dex */
public class d {
    public static int a() {
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            if (cls != null && cls.getName() != null) {
                if (cls.getName().equals("com.unity3d.player.UnityPlayer")) {
                    return 1;
                }
            }
        } catch (Exception unused) {
            g.c("UnityPlayer ClassNotFound");
        }
        try {
            Class<?> cls2 = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
            if (cls2 != null && cls2.getName() != null) {
                if (cls2.getName().equals("org.cocos2dx.lib.Cocos2dxActivity")) {
                    return 2;
                }
            }
        } catch (Exception unused2) {
            g.c("Cocos2dxActivity ClassNotFound");
        }
        try {
            Class<?> cls3 = Class.forName("com.epicgames.ue4.GameActivity");
            if (cls3 == null || cls3.getName() == null) {
                return 0;
            }
            return cls3.getName().equals("com.epicgames.ue4.GameActivity") ? 3 : 0;
        } catch (Exception unused3) {
            g.c("UE4 GameActivity ClassNotFound");
            return 0;
        }
    }
}
