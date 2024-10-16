package com.ihoc.mgpa.notch;

import com.ihoc.mgpa.n.a;
import com.ihoc.mgpa.n.i;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.p;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NotchCloudConfig {
    private static final String TAG = "TGPA";
    private NotchCloudData notchCloud;
    private boolean inNotchBlacklist = false;
    private String controlFilePath = a.e() + File.separator + ".tgpacloud";

    public NotchCloudConfig() {
        checkCloudConfig();
    }

    private void checkCloudConfig() {
        JSONObject optJSONObject;
        try {
            if (i.a(this.controlFilePath)) {
                String i = i.i(this.controlFilePath);
                if (p.b(i)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(i);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("switch");
                JSONObject optJSONObject3 = jSONObject.optJSONObject(ConfigDBHelper.TABLE_NAME_CONFIG);
                if (optJSONObject2 != null) {
                    this.inNotchBlacklist = !optJSONObject2.optBoolean("notchSupport");
                }
                if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("notchCloudData")) == null) {
                    return;
                }
                this.notchCloud = new NotchCloudData(optJSONObject.getInt("notchwidth"), optJSONObject.getInt("notchheight"));
                m.c(this.notchCloud.toString(), new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NotchCloudData getNotchCloudData() {
        return this.notchCloud;
    }

    public boolean isNotchBlack() {
        return this.inNotchBlacklist;
    }
}
