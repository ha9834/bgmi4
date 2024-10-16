package com.tencent.grobot.lite.common;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.adjust.sdk.Constants;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.grobot.lite.R;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class ToolUtils {
    static DateFormat sDateFormat;
    static DecimalFormat sDecimalFormat;

    public static String getVideoTimeString(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(String.format("%02d", Integer.valueOf(i2)) + CertificateUtil.DELIMITER);
        }
        sb.append(String.format("%02d", Integer.valueOf(i3)) + CertificateUtil.DELIMITER);
        sb.append(String.format("%02d", Integer.valueOf(i4)));
        return sb.toString();
    }

    public static String getVideoTimesString(Context context, int i) {
        return i + context.getString(R.string.video_suffix);
    }

    public static String getViews(Context context, long j) {
        if (sDecimalFormat == null) {
            sDecimalFormat = new DecimalFormat(".00");
        }
        if (j > 100000000) {
            return (j / 1000000) + "M";
        }
        if (j > 1000000) {
            return sDecimalFormat.format(((float) j) / 1000000.0f) + "M";
        }
        if (j > 1000) {
            return sDecimalFormat.format(((float) j) / 1000.0f) + "K";
        }
        return String.valueOf(j);
    }

    public static String getViewsAndTimeString(Context context, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(getViews(context, j));
        sb.append(context.getString(R.string.video_suffix));
        if (j2 != -1) {
            if (sDateFormat == null) {
                sDateFormat = DateFormat.getDateInstance(1, context.getResources().getConfiguration().locale);
            }
            Date date = new Date(j2);
            sb.append(" • ");
            sb.append(sDateFormat.format(date));
        }
        return sb.toString();
    }

    public static SpannableString getSearchString(Context context, String str) {
        String string = context.getString(R.string.search_tip, str);
        SpannableString spannableString = new SpannableString(string);
        int indexOf = string.indexOf(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F2A900")), indexOf, str.length() + indexOf, 33);
        return spannableString;
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            TLog.e("EncodeUtil", "getMD5 " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
