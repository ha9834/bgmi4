package com.gamesafe.ano;

/* loaded from: classes.dex */
public class a {
    public static char a(char c) {
        char c2;
        if (c >= 'a' && c <= 'z') {
            c2 = (char) (c + 5);
            if (c2 <= 'z') {
                return c2;
            }
        } else {
            if (c < 'A' || c > 'Z') {
                return c;
            }
            c2 = (char) (c + 5);
            if (c2 <= 'Z') {
                return c2;
            }
        }
        return (char) (c2 - 26);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(str.charAt(i)));
        }
        return sb.toString();
    }
}
