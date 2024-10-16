package com.tencent.hawk.bridge;

import com.google.android.gms.games.request.GameRequest;

/* loaded from: classes2.dex */
public class HashGen {
    static int[] cryptTable = new int[1280];
    static boolean init_crypt_tbl = false;

    public static char toupper(char c) {
        return (c < 'a' || c > 'z') ? c : (char) (c - ' ');
    }

    public static void prepare_crypt_tbl() {
        int i = 0;
        int i2 = 1048577;
        while (i < 256) {
            int i3 = i;
            int i4 = i2;
            int i5 = 0;
            while (i5 < 5) {
                int i6 = ((i4 * 125) + 3) % 2796203;
                int i7 = (i6 & GameRequest.TYPE_ALL) << 16;
                i4 = ((i6 * 125) + 3) % 2796203;
                cryptTable[i3] = (i4 & GameRequest.TYPE_ALL) | i7;
                i5++;
                i3 += 256;
            }
            i++;
            i2 = i4;
        }
    }

    public static long oneWayHash(String str, int i) {
        if (!init_crypt_tbl) {
            prepare_crypt_tbl();
            init_crypt_tbl = true;
        }
        int i2 = 2146271213;
        int i3 = -286331154;
        int i4 = 0;
        while (i4 < str.length()) {
            int i5 = i4 + 1;
            char c = toupper(str.charAt(i4));
            i2 = (i2 + i3) ^ cryptTable[((i << 8) + c) % 1280];
            i3 = c + i2 + i3 + (i3 << 5) + 3;
            i4 = i5;
        }
        return i2 < 0 ? (Integer.MAX_VALUE & i2) | 2147483648L : i2;
    }
}
