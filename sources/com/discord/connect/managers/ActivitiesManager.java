package com.discord.connect.managers;

import com.discord.connect.jni.Core;
import com.discord.connect.schema.Activity;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: classes.dex */
public final class ActivitiesManager {

    /* renamed from: a, reason: collision with root package name */
    private final com.discord.connect.jni.ActivitiesManager f1077a;
    private final Gson b = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public ActivitiesManager(Core core) {
        this.f1077a = new com.discord.connect.jni.ActivitiesManager(core);
    }

    public void a() {
        this.f1077a.a();
    }

    public Activity b() {
        return this.f1077a.b();
    }

    public void a(Activity activity) {
        this.f1077a.a(this.b.toJson(activity));
    }

    /* loaded from: classes.dex */
    public enum ActionType {
        JOIN(1),
        SPECTATE(2),
        LISTEN(3),
        WATCH(4),
        JOIN_REQUEST(5);

        private final int rawType;

        ActionType(int i) {
            this.rawType = i;
        }

        public int a() {
            return this.rawType;
        }
    }
}
