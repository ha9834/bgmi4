package com.tencent.grobot.lite.ui.container;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.GRobotProcessActivity;
import com.tencent.grobot.lite.recommends.Feeds;
import com.tencent.grobot.lite.ui.IM;
import com.tencent.grobot.lite.ui.Pic;
import com.tencent.grobot.lite.ui.VideoWeb;
import com.tencent.grobot.lite.youtube.YoutubePlayer;

/* loaded from: classes2.dex */
public final class Router {
    static final String ARGS_FRAME_ARGS = "frame_args";
    static final String ARGS_FRAME_TYPE = "frame_type";
    static final String ARGS_GAME_PARAMS = "frame_game_params";
    static final String ARGS_GAME_PARAMS_STR = "frame_game_params_str";
    public static final String ARGS_INIT_DATA = "data_init_engine";
    public static final String ARGS_INIT_QUES = "data_init_question";
    static final String ARGS_OTHER_PROCESS = "frame_other_process";
    static final String ARGS_SCREEN_ORIENT = "frame_screen_orient";
    static final int TYPE_FRAME_ERROR = -1;
    static final int TYPE_FRAME_FEEDS = 3;
    static final int TYPE_FRAME_IM = 1;
    static final int TYPE_FRAME_PIC = 2;
    static final int TYPE_FRAME_WEB = 0;
    static final int TYPE_FRAME_YOUTUBE_PLAYER = 4;

    public static void jump(Context context, Class<? extends Frame> cls, Bundle bundle, boolean z, boolean z2) {
        Intent intent;
        if (z2) {
            intent = new Intent(context, (Class<?>) BridgeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) GRobotProcessActivity.class);
        }
        intent.putExtra(ARGS_OTHER_PROCESS, z2);
        if (z2) {
            intent.putExtra(ARGS_GAME_PARAMS, GRobotApplication.getInstance().getGameParam());
            intent.putExtra(ARGS_GAME_PARAMS_STR, GRobotApplication.getInstance().getGameParamString());
        }
        intent.putExtra(ARGS_SCREEN_ORIENT, z);
        intent.putExtra(ARGS_FRAME_TYPE, parseFrameClazzToInt(cls));
        intent.putExtra(ARGS_FRAME_ARGS, bundle);
        context.startActivity(intent);
    }

    private static int parseFrameClazzToInt(Class<? extends Frame> cls) {
        if (VideoWeb.class.equals(cls)) {
            return 0;
        }
        if (IM.class.equals(cls)) {
            return 1;
        }
        if (Pic.class.equals(cls)) {
            return 2;
        }
        if (Feeds.class.equals(cls)) {
            return 3;
        }
        return YoutubePlayer.class.equals(cls) ? 4 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Frame parseIntToFrame(FrameActivity frameActivity, int i, Bundle bundle) {
        if (i == 0) {
            return new VideoWeb(frameActivity, bundle);
        }
        if (i == 1) {
            return new IM(frameActivity, bundle);
        }
        if (i == 2) {
            return new Pic(frameActivity, bundle);
        }
        if (i == 3) {
            return new Feeds(frameActivity, bundle);
        }
        if (i == 4) {
            return new YoutubePlayer(frameActivity, bundle);
        }
        return null;
    }

    private Router() {
        throw new UnsupportedOperationException("Can not create an object of Router class.");
    }
}
