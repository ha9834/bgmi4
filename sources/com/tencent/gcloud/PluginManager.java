package com.tencent.gcloud;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PluginManager {
    public static final PluginManager Instance = new PluginManager();
    static String tag = "GCloudPluginManger";
    List<Plugin> list = new ArrayList();
    Plugin plugin = null;

    private PluginManager() {
    }

    public void addPlugin(Plugin plugin) {
        String str = tag;
        StringBuilder sb = new StringBuilder();
        sb.append("AddPlugin pl is null?:");
        sb.append(plugin != null);
        Log.i(str, sb.toString());
        if (plugin != null) {
            this.list.add(plugin);
        }
    }

    public boolean initializePlugin(Activity activity) {
        boolean z = true;
        for (int i = 0; i < this.list.size(); i++) {
            Plugin plugin = this.list.get(i);
            if (plugin != null && !plugin.onInitialize(activity)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Plugin plugin;
        for (int i3 = 0; i3 < this.list.size() && (plugin = this.list.get(i3)) != null; i3++) {
            plugin.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        Plugin plugin;
        Log.i(tag, "onDestroy");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onDestroy();
        }
    }

    protected boolean onInitialize(Activity activity) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Plugin plugin;
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        Plugin plugin;
        Log.i(tag, "onPause");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onPause();
        }
    }

    protected void onRestart() {
        Plugin plugin;
        Log.i(tag, "onRestart");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onRestart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        Plugin plugin;
        Log.i(tag, "onResume");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onResume();
        }
    }

    protected void onStart() {
        Plugin plugin;
        Log.i(tag, "onStart");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onStart();
        }
    }

    protected void onStop() {
        Plugin plugin;
        Log.i(tag, "onStop");
        for (int i = 0; i < this.list.size() && (plugin = this.list.get(i)) != null; i++) {
            plugin.onStop();
        }
    }
}
