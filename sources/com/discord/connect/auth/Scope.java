package com.discord.connect.auth;

/* loaded from: classes.dex */
public enum Scope {
    IDENTIFY("identify"),
    EMAIL("email"),
    CONNECTIONS("connections"),
    GUILDS("guilds"),
    GUILDS_JOIN("guilds.join"),
    GDM_JOIN("gdm.join"),
    RPC("rpc"),
    RPC_NOTIFICATIONS_READ("rpc.notifications.read"),
    BOT("bot"),
    WEBHOOK_INCOMING("webhook.incoming"),
    MESSAGES_READ("messages.read"),
    APPLICATIONS_BUILDS_UPLOAD("applications.builds.upload"),
    APPLICATIONS_BUILDS_READ("applications.builds.read"),
    APPLICATIONS_STORE_UPDATE("applications.store.update"),
    APPLICATIONS_ENTITLEMENTS("applications.entitlements"),
    ACTIVITIES_READ("activities.read"),
    ACTIVITIES_WRITE("activities.write"),
    RELATIONSHIPS_READ("relationships.read");

    private final String key;

    Scope(String str) {
        this.key = str;
    }

    public String a() {
        return this.key;
    }
}
