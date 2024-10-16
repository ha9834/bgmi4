package com.discord.connect.managers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.discord.connect.a.d;
import com.discord.connect.managers.ActivitiesManager;
import com.discord.connect.schema.Activity;

/* loaded from: classes.dex */
public final class a {
    public static boolean a(ActivitiesManager activitiesManager, Context context, ActivitiesManager.ActionType actionType) {
        Activity b = activitiesManager.b();
        if (b == null) {
            return false;
        }
        Intent intent = new Intent(com.discord.connect.a.c, Uri.parse("discord://sdk").buildUpon().path("/send/activity").appendQueryParameter("application_id", String.valueOf(b.b)).appendQueryParameter("type", String.valueOf(actionType.a())).appendQueryParameter("party_id", b.k == null ? "" : b.k.f1085a).build());
        ResolveInfo a2 = com.discord.connect.c.a(context, intent);
        if (a2 == null) {
            return false;
        }
        intent.setPackage(a2.activityInfo.packageName);
        intent.putExtra(com.discord.connect.a.d, d.f1063a.toJson(b));
        context.startActivity(intent);
        return true;
    }
}
