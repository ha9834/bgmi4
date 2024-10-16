package com.tencent.quantum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GameProcessUtility extends Activity {
    private static final String KEY_MAIN_PROCESS_PID = "game_main_process_pid";
    private static final String KEY_RESTART_INTENTS = "game_process_restart_intent";

    public static void restartGameProcess(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return;
        }
        launchIntentForPackage.addFlags(268468224);
        Intent intent = new Intent(context, (Class<?>) GameProcessUtility.class);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        new ArrayList().add(launchIntentForPackage);
        intent.putParcelableArrayListExtra(KEY_RESTART_INTENTS, new ArrayList<>(Arrays.asList(launchIntentForPackage)));
        intent.putExtra(KEY_MAIN_PROCESS_PID, Process.myPid());
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Process.killProcess(getIntent().getIntExtra(KEY_MAIN_PROCESS_PID, -1));
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(KEY_RESTART_INTENTS);
        startActivities((Intent[]) parcelableArrayListExtra.toArray(new Intent[parcelableArrayListExtra.size()]));
        finish();
        Runtime.getRuntime().exit(0);
    }
}
