package com.tencent.imsdk.android.login.discord;

import com.discord.connect.auth.Scope;
import com.discord.connect.auth.b;
import com.discord.connect.c;
import com.discord.connect.d;
import com.tencent.imsdk.android.discord.DiscordConstants;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AccountManager {
    public static c discordConnect;
    public static d discordLoginSession;
    public static d.a discordLoginSessionClientExchange;

    public static b createOAuth2ClientExchangeRequest(List<Scope> list) {
        if (list == null || list.size() <= 0) {
            list = getDefaultScopes();
        }
        return new b(Long.valueOf(DiscordConstants.getDiscordApId()).longValue(), DiscordConstants.getCallbackUriClientExchange(true), list);
    }

    public static void discordLoginSessionStart(d dVar, d.a aVar) {
        discordLoginSessionInvalidate();
        discordLoginSession = dVar;
        discordLoginSessionClientExchange = aVar;
    }

    public static void discordLoginSessionInvalidate() {
        d dVar = discordLoginSession;
        if (dVar != null) {
            dVar.close();
            discordLoginSession = null;
        }
        d.a aVar = discordLoginSessionClientExchange;
        if (aVar != null) {
            aVar.close();
            discordLoginSessionClientExchange = null;
        }
    }

    public static void discordConnectStart(c cVar) {
        discordConnectInvalidate();
        discordConnect = cVar;
    }

    public static void discordConnectInvalidate() {
        c cVar = discordConnect;
        if (cVar != null) {
            cVar.close();
        }
        discordConnect = null;
    }

    public static void shutdown() {
        discordLoginSessionInvalidate();
        discordConnectInvalidate();
    }

    private static List<Scope> getDefaultScopes() {
        return Arrays.asList(Scope.IDENTIFY, Scope.RELATIONSHIPS_READ, Scope.ACTIVITIES_WRITE);
    }
}
