package com.google.zxing.datamatrix.encoder;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.games.Notifications;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5410a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE, 240, 92, 254}, new int[]{28, 24, 185, TbsListener.ErrorCode.STARTDOWNLOAD_7, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 248, 116, 255, 110, 61}, new int[]{TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 138, TbsListener.ErrorCode.UNZIP_DIR_ERROR, 12, 194, TbsListener.ErrorCode.STARTDOWNLOAD_9, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, TbsListener.ErrorCode.NEEDDOWNLOAD_3, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, 109, 129, 94, 254, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, TbsListener.ErrorCode.STARTDOWNLOAD_9, 2, 188, TbsListener.ErrorCode.STARTDOWNLOAD_1, 153, TbsListener.ErrorCode.NEEDDOWNLOAD_6, 253, 79, 108, 82, 27, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 186, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, TbsListener.ErrorCode.UNZIP_DIR_ERROR, 109, 39, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 21, 155, 197, 251, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 155, 21, 5, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{TbsListener.ErrorCode.EXCEED_COPY_RETRY_NUM, 231, 43, 97, 71, 96, 103, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 37, 151, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 53, 75, 34, 249, 121, 17, 138, 110, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, TbsListener.ErrorCode.NEEDDOWNLOAD_2, 136, 120, 151, 233, TbsListener.ErrorCode.STARTDOWNLOAD_9, 93, 255}, new int[]{245, Notifications.NOTIFICATION_TYPES_ALL, 242, TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN, 250, TbsListener.ErrorCode.STARTDOWNLOAD_3, 181, 102, 120, 84, 179, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, INTLMethodID.INTL_METHOD_ID_AUTH_LAUNCH_ACCOUNT_UI, 95, 119, 115, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 184, 59, 25, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 98, 81, 112}, new int[]{77, 193, INTLMethodID.INTL_METHOD_ID_AUTH_LAUNCH_ACCOUNT_UI, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_USERNAME_STATUS, 242, 8, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 95, 100, 9, TbsListener.ErrorCode.STARTDOWNLOAD_8, 105, TbsListener.ErrorCode.COPY_TMPDIR_ERROR, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 226, 5, 9, 5}, new int[]{245, INTLMethodID.INTL_METHOD_ID_AUTH_UNBIND, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 96, 32, 117, 22, 238, INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_USERNAME_STATUS, 238, 231, TbsListener.ErrorCode.UNZIP_DIR_ERROR, 188, 237, 87, 191, 106, 16, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 118, 23, 37, 90, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, TbsListener.ErrorCode.UNZIP_DIR_ERROR, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 87, 187, TbsListener.ErrorCode.NEEDDOWNLOAD_8, TbsListener.ErrorCode.STARTDOWNLOAD_1, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 69, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, 92, 253, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 19}, new int[]{TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 9, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 238, 12, 17, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 100, 29, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 230, 192, TbsListener.ErrorCode.COPY_EXCEPTION, 235, 150, 159, 36, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 38, 200, INTLMethodID.INTL_METHOD_ID_AUTH_UNBIND, 54, 228, TbsListener.ErrorCode.NEEDDOWNLOAD_7, TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, TbsListener.ErrorCode.UNZIP_OTHER_ERROR, TbsListener.ErrorCode.STARTDOWNLOAD_5, 13, INTLMethodID.INTL_METHOD_ID_AUTH_LAUNCH_ACCOUNT_UI, 245, Notifications.NOTIFICATION_TYPES_ALL, 67, 247, 28, 155, 43, 203, 107, 233, 53, TbsListener.ErrorCode.NEEDDOWNLOAD_4, 46}, new int[]{242, 93, TbsListener.ErrorCode.STARTDOWNLOAD_10, 50, 144, TbsListener.ErrorCode.ROM_NOT_ENOUGH, 39, 118, 202, 188, 201, 189, TbsListener.ErrorCode.NEEDDOWNLOAD_4, 108, 196, 37, 185, 112, INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 64, 114, 71, TbsListener.ErrorCode.STARTDOWNLOAD_2, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 6, 27, TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, 51, 63, 87, 10, 40, INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN, 188, 17, TbsListener.ErrorCode.STARTDOWNLOAD_4, 31, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 4, 107, 232, 7, 94, TbsListener.ErrorCode.STARTDOWNLOAD_7, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 124, 86, 47, 11, TbsListener.ErrorCode.APK_INVALID}, new int[]{TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 228, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3, 89, 251, TbsListener.ErrorCode.NEEDDOWNLOAD_10, 159, 56, 89, 33, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 244, 154, 36, 73, Notifications.NOTIFICATION_TYPES_ALL, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, 136, 248, 180, 234, 197, 158, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 68, 122, 93, TbsListener.ErrorCode.COPY_SRCDIR_ERROR, 15, TbsListener.ErrorCode.STARTDOWNLOAD_1, 227, 236, 66, TwitterApiConstants.Errors.ALREADY_FAVORITED, 153, 185, 202, TbsListener.ErrorCode.STARTDOWNLOAD_8, 179, 25, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 232, 96, TbsListener.ErrorCode.ROM_NOT_ENOUGH, 231, 136, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 181, 241, 59, 52, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2, 25, 49, 232, TbsListener.ErrorCode.EXCEED_COPY_RETRY_NUM, 189, 64, 54, 108, 153, INTLMethodID.INTL_METHOD_ID_AUTH_UNBIND, 63, 96, 103, 82, 186}};
    private static final int[] c = new int[256];
    private static final int[] d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            d[i2] = i;
            c[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String a(String str, k kVar) {
        if (str.length() != kVar.f()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(kVar.f() + kVar.g());
        sb.append(str);
        int a2 = kVar.a();
        if (a2 == 1) {
            sb.append(a(str, kVar.g()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[a2];
            int[] iArr2 = new int[a2];
            int[] iArr3 = new int[a2];
            int i = 0;
            while (i < a2) {
                int i2 = i + 1;
                iArr[i] = kVar.a(i2);
                iArr2[i] = kVar.b(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < a2; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < kVar.f(); i4 += a2) {
                    sb2.append(str.charAt(i4));
                }
                String a3 = a(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * a2) {
                    sb.setCharAt(kVar.f() + i5, a3.charAt(i6));
                    i5 += a2;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String a(CharSequence charSequence, int i) {
        return a(charSequence, 0, charSequence.length(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = f5410a;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            }
            if (iArr[i4] == i3) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = b[i4];
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int i7 = i3 - 1;
            int charAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (charAt != 0 && iArr2[i7] != 0) {
                    char c2 = cArr[i7 - 1];
                    int[] iArr3 = d;
                    int[] iArr4 = c;
                    cArr[i7] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                } else {
                    cArr[i7] = cArr[i7 - 1];
                }
                i7--;
            }
            if (charAt != 0 && iArr2[0] != 0) {
                int[] iArr5 = d;
                int[] iArr6 = c;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i8 = 0; i8 < i3; i8++) {
            cArr2[i8] = cArr[(i3 - i8) - 1];
        }
        return String.valueOf(cArr2);
    }
}
