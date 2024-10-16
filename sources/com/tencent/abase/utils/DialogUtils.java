package com.tencent.abase.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* loaded from: classes2.dex */
public class DialogUtils {
    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(sContext);
        builder.setTitle("GCloudSDK提示");
        builder.setMessage("GameID为0，请确认AndroidManifest中是否正确配置GameId");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.abase.utils.DialogUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() { // from class: com.tencent.abase.utils.DialogUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}
