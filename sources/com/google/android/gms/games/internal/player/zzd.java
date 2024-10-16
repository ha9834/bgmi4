package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzd {

    /* renamed from: a, reason: collision with root package name */
    private final String f1683a;
    public final String name;
    public final String zzcd;
    public final String zzci;
    public final String zzmc;
    public final String zzmd;
    public final String zzme;
    public final String zzmf;
    public final String zzmg;
    public final String zzmh;
    public final String zzmi;
    public final String zzmj;
    public final String zzmk;
    public final String zzml;
    public final String zzmm;
    public final String zzmn;
    public final String zzmo;
    public final String zzmp;
    public final String zzmq;
    public final String zzmr;
    public final String zzmt;
    public final String zzmu;
    public final String zzmv;
    public final String zzmw;
    public final String zzmx;
    public final String zzmy;
    public final String zzmz;
    public final String zzna;
    public final String zznb;
    public final String zznc;
    public final String zznd;
    public final String zzne;
    public final String zznf;
    public final String zzng;
    public final String zznh;
    public final String zzni;

    public zzd(String str) {
        String concat;
        if (TextUtils.isEmpty(str)) {
            this.zzmc = "external_player_id";
            this.zzmd = "profile_name";
            this.zzme = "profile_icon_image_uri";
            this.zzmf = "profile_icon_image_url";
            this.zzmg = "profile_hi_res_image_uri";
            this.zzmh = "profile_hi_res_image_url";
            this.zzmi = "last_updated";
            this.zzmj = "is_in_circles";
            this.zzmk = "played_with_timestamp";
            this.zzml = "current_xp_total";
            this.zzmm = "current_level";
            this.zzmn = "current_level_min_xp";
            this.zzmo = "current_level_max_xp";
            this.zzmp = "next_level";
            this.zzmq = "next_level_max_xp";
            this.zzmr = "last_level_up_timestamp";
            this.zzcd = "player_title";
            this.f1683a = "has_all_public_acls";
            this.zzmt = "is_profile_visible";
            this.zzmu = "most_recent_external_game_id";
            this.zzmv = "most_recent_game_name";
            this.zzmw = "most_recent_activity_timestamp";
            this.zzmx = "most_recent_game_icon_uri";
            this.zzmy = "most_recent_game_hi_res_uri";
            this.zzmz = "most_recent_game_featured_uri";
            this.zzna = "has_debug_access";
            this.zzci = "gamer_tag";
            this.name = "real_name";
            this.zznb = "banner_image_landscape_uri";
            this.zznc = "banner_image_landscape_url";
            this.zznd = "banner_image_portrait_uri";
            this.zzne = "banner_image_portrait_url";
            this.zznf = "gamer_friend_status";
            this.zzng = "gamer_friend_update_timestamp";
            this.zznh = "is_muted";
            concat = "total_unlocked_achievements";
        } else {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("external_player_id");
            this.zzmc = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("profile_name");
            this.zzmd = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            String valueOf5 = String.valueOf(str);
            String valueOf6 = String.valueOf("profile_icon_image_uri");
            this.zzme = valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5);
            String valueOf7 = String.valueOf(str);
            String valueOf8 = String.valueOf("profile_icon_image_url");
            this.zzmf = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
            String valueOf9 = String.valueOf(str);
            String valueOf10 = String.valueOf("profile_hi_res_image_uri");
            this.zzmg = valueOf10.length() != 0 ? valueOf9.concat(valueOf10) : new String(valueOf9);
            String valueOf11 = String.valueOf(str);
            String valueOf12 = String.valueOf("profile_hi_res_image_url");
            this.zzmh = valueOf12.length() != 0 ? valueOf11.concat(valueOf12) : new String(valueOf11);
            String valueOf13 = String.valueOf(str);
            String valueOf14 = String.valueOf("last_updated");
            this.zzmi = valueOf14.length() != 0 ? valueOf13.concat(valueOf14) : new String(valueOf13);
            String valueOf15 = String.valueOf(str);
            String valueOf16 = String.valueOf("is_in_circles");
            this.zzmj = valueOf16.length() != 0 ? valueOf15.concat(valueOf16) : new String(valueOf15);
            String valueOf17 = String.valueOf(str);
            String valueOf18 = String.valueOf("played_with_timestamp");
            this.zzmk = valueOf18.length() != 0 ? valueOf17.concat(valueOf18) : new String(valueOf17);
            String valueOf19 = String.valueOf(str);
            String valueOf20 = String.valueOf("current_xp_total");
            this.zzml = valueOf20.length() != 0 ? valueOf19.concat(valueOf20) : new String(valueOf19);
            String valueOf21 = String.valueOf(str);
            String valueOf22 = String.valueOf("current_level");
            this.zzmm = valueOf22.length() != 0 ? valueOf21.concat(valueOf22) : new String(valueOf21);
            String valueOf23 = String.valueOf(str);
            String valueOf24 = String.valueOf("current_level_min_xp");
            this.zzmn = valueOf24.length() != 0 ? valueOf23.concat(valueOf24) : new String(valueOf23);
            String valueOf25 = String.valueOf(str);
            String valueOf26 = String.valueOf("current_level_max_xp");
            this.zzmo = valueOf26.length() != 0 ? valueOf25.concat(valueOf26) : new String(valueOf25);
            String valueOf27 = String.valueOf(str);
            String valueOf28 = String.valueOf("next_level");
            this.zzmp = valueOf28.length() != 0 ? valueOf27.concat(valueOf28) : new String(valueOf27);
            String valueOf29 = String.valueOf(str);
            String valueOf30 = String.valueOf("next_level_max_xp");
            this.zzmq = valueOf30.length() != 0 ? valueOf29.concat(valueOf30) : new String(valueOf29);
            String valueOf31 = String.valueOf(str);
            String valueOf32 = String.valueOf("last_level_up_timestamp");
            this.zzmr = valueOf32.length() != 0 ? valueOf31.concat(valueOf32) : new String(valueOf31);
            String valueOf33 = String.valueOf(str);
            String valueOf34 = String.valueOf("player_title");
            this.zzcd = valueOf34.length() != 0 ? valueOf33.concat(valueOf34) : new String(valueOf33);
            String valueOf35 = String.valueOf(str);
            String valueOf36 = String.valueOf("has_all_public_acls");
            this.f1683a = valueOf36.length() != 0 ? valueOf35.concat(valueOf36) : new String(valueOf35);
            String valueOf37 = String.valueOf(str);
            String valueOf38 = String.valueOf("is_profile_visible");
            this.zzmt = valueOf38.length() != 0 ? valueOf37.concat(valueOf38) : new String(valueOf37);
            String valueOf39 = String.valueOf(str);
            String valueOf40 = String.valueOf("most_recent_external_game_id");
            this.zzmu = valueOf40.length() != 0 ? valueOf39.concat(valueOf40) : new String(valueOf39);
            String valueOf41 = String.valueOf(str);
            String valueOf42 = String.valueOf("most_recent_game_name");
            this.zzmv = valueOf42.length() != 0 ? valueOf41.concat(valueOf42) : new String(valueOf41);
            String valueOf43 = String.valueOf(str);
            String valueOf44 = String.valueOf("most_recent_activity_timestamp");
            this.zzmw = valueOf44.length() != 0 ? valueOf43.concat(valueOf44) : new String(valueOf43);
            String valueOf45 = String.valueOf(str);
            String valueOf46 = String.valueOf("most_recent_game_icon_uri");
            this.zzmx = valueOf46.length() != 0 ? valueOf45.concat(valueOf46) : new String(valueOf45);
            String valueOf47 = String.valueOf(str);
            String valueOf48 = String.valueOf("most_recent_game_hi_res_uri");
            this.zzmy = valueOf48.length() != 0 ? valueOf47.concat(valueOf48) : new String(valueOf47);
            String valueOf49 = String.valueOf(str);
            String valueOf50 = String.valueOf("most_recent_game_featured_uri");
            this.zzmz = valueOf50.length() != 0 ? valueOf49.concat(valueOf50) : new String(valueOf49);
            String valueOf51 = String.valueOf(str);
            String valueOf52 = String.valueOf("has_debug_access");
            this.zzna = valueOf52.length() != 0 ? valueOf51.concat(valueOf52) : new String(valueOf51);
            String valueOf53 = String.valueOf(str);
            String valueOf54 = String.valueOf("gamer_tag");
            this.zzci = valueOf54.length() != 0 ? valueOf53.concat(valueOf54) : new String(valueOf53);
            String valueOf55 = String.valueOf(str);
            String valueOf56 = String.valueOf("real_name");
            this.name = valueOf56.length() != 0 ? valueOf55.concat(valueOf56) : new String(valueOf55);
            String valueOf57 = String.valueOf(str);
            String valueOf58 = String.valueOf("banner_image_landscape_uri");
            this.zznb = valueOf58.length() != 0 ? valueOf57.concat(valueOf58) : new String(valueOf57);
            String valueOf59 = String.valueOf(str);
            String valueOf60 = String.valueOf("banner_image_landscape_url");
            this.zznc = valueOf60.length() != 0 ? valueOf59.concat(valueOf60) : new String(valueOf59);
            String valueOf61 = String.valueOf(str);
            String valueOf62 = String.valueOf("banner_image_portrait_uri");
            this.zznd = valueOf62.length() != 0 ? valueOf61.concat(valueOf62) : new String(valueOf61);
            String valueOf63 = String.valueOf(str);
            String valueOf64 = String.valueOf("banner_image_portrait_url");
            this.zzne = valueOf64.length() != 0 ? valueOf63.concat(valueOf64) : new String(valueOf63);
            String valueOf65 = String.valueOf(str);
            String valueOf66 = String.valueOf("gamer_friend_status");
            this.zznf = valueOf66.length() != 0 ? valueOf65.concat(valueOf66) : new String(valueOf65);
            String valueOf67 = String.valueOf(str);
            String valueOf68 = String.valueOf("gamer_friend_update_timestamp");
            this.zzng = valueOf68.length() != 0 ? valueOf67.concat(valueOf68) : new String(valueOf67);
            String valueOf69 = String.valueOf(str);
            String valueOf70 = String.valueOf("is_muted");
            this.zznh = valueOf70.length() != 0 ? valueOf69.concat(valueOf70) : new String(valueOf69);
            String valueOf71 = String.valueOf(str);
            String valueOf72 = String.valueOf("total_unlocked_achievements");
            concat = valueOf72.length() != 0 ? valueOf71.concat(valueOf72) : new String(valueOf71);
        }
        this.zzni = concat;
    }
}
