package com.helpshift.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class HSFormat {
    public static final String alphaNumericCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
    public static final HSSimpleDateFormat deviceInfoTsFormat = new HSSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    public static final HSSimpleDateFormat datePropertyTsFormat = new HSSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault(), "UTC");
    public static final HSSimpleDateFormat timeStampAnonymousUserFormat = new HSSimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault());
    public static final DecimalFormat tsSecFormatter = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US));
    public static final HSSimpleDateFormat errorLogReportingTimeFormat = new HSSimpleDateFormat("dd/MM/yyyy HH:mm:ss", "UTC");
}
