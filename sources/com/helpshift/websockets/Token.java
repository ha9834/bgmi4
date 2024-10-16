package com.helpshift.websockets;

/* loaded from: classes2.dex */
class Token {
    public static boolean isSeparator(char c) {
        if (c == '\t' || c == ' ' || c == '\"' || c == ',' || c == '/' || c == '{' || c == '}') {
            return true;
        }
        switch (c) {
            case '(':
            case ')':
                return true;
            default:
                switch (c) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (c) {
                            case '[':
                            case '\\':
                            case ']':
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    Token() {
    }

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isSeparator(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String unquote(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length >= 2 && str.charAt(0) == '\"') {
            int i = length - 1;
            if (str.charAt(i) == '\"') {
                return unescape(str.substring(1, i));
            }
        }
        return str;
    }

    public static String unescape(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf(92) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\\' || z) {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
        }
        return sb.toString();
    }
}
