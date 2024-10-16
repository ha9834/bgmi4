package com.helpshift.support.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageButton;
import com.helpshift.R;
import com.helpshift.support.Faq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Styles {
    public static int getColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static int getInt(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int i2 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        return i2;
    }

    public static void setImageAlpha(ImageButton imageButton, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            imageButton.setImageAlpha(i);
        } else {
            imageButton.setAlpha(i);
        }
    }

    public static void setSendMessageButtonIconColor(Context context, Drawable drawable, boolean z) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, z ? R.attr.colorAccent : android.R.attr.textColorHint);
    }

    public static void setAdminChatBubbleColor(Context context, Drawable drawable) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, R.attr.hs__chatBubbleAdminBackgroundColor);
    }

    public static void setAccentColor(Context context, Drawable drawable) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, R.attr.colorAccent);
    }

    public static Faq getQuestionWithHighlightedSearchTerms(Context context, Faq faq, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        String str = faq.title;
        String str2 = faq.body;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String hexColor = com.helpshift.util.Styles.getHexColor(context, R.attr.hs__searchHighlightColor);
        if (!(HSTransliterator.unidecode(str).equals(str) && HSTransliterator.unidecode(str2).equals(str2))) {
            int length = str.length();
            ArrayList arrayList2 = new ArrayList();
            String str3 = "";
            int i = 0;
            while (i < length) {
                String unidecode = HSTransliterator.unidecode(str.charAt(i) + "");
                String str4 = str3;
                for (int i2 = 0; i2 < unidecode.length(); i2++) {
                    str4 = str4 + unidecode.charAt(i2);
                    arrayList2.add(Integer.valueOf(i));
                }
                i++;
                str3 = str4;
            }
            String lowerCase = str3.toLowerCase();
            int length2 = str2.length();
            HSTransliterator.unidecode(str2);
            ArrayList arrayList3 = new ArrayList();
            String str5 = "";
            int i3 = 0;
            while (i3 < length2) {
                String unidecode2 = HSTransliterator.unidecode(str2.charAt(i3) + "");
                String str6 = str5;
                for (int i4 = 0; i4 < unidecode2.length(); i4++) {
                    str6 = str6 + unidecode2.charAt(i4);
                    arrayList3.add(Integer.valueOf(i3));
                }
                i3++;
                str5 = str6;
            }
            String lowerCase2 = str5.toLowerCase();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.length() >= 3) {
                    String lowerCase3 = next.toLowerCase();
                    for (int indexOf = TextUtils.indexOf(lowerCase, lowerCase3, 0); indexOf >= 0; indexOf = TextUtils.indexOf(lowerCase, lowerCase3, indexOf + lowerCase3.length())) {
                        linkedHashSet.add(str.substring(((Integer) arrayList2.get(indexOf)).intValue(), ((Integer) arrayList2.get((lowerCase3.length() + indexOf) - 1)).intValue() + 1));
                    }
                    for (int indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, 0); indexOf2 >= 0; indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, indexOf2 + lowerCase3.length())) {
                        linkedHashSet.add(str2.substring(((Integer) arrayList3.get(indexOf2)).intValue(), ((Integer) arrayList3.get((lowerCase3.length() + indexOf2) - 1)).intValue() + 1));
                    }
                }
            }
        } else {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.length() >= 3) {
                    linkedHashSet.add(next2);
                }
            }
        }
        String str7 = ">" + str2 + "<";
        String str8 = ">" + str + "<";
        Pattern compile = Pattern.compile(">[^<]+<");
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            String str9 = (String) it3.next();
            Matcher matcher = compile.matcher(str8);
            String str10 = str8;
            while (matcher.find()) {
                String substring = str8.substring(matcher.start(), matcher.end());
                str10 = str10.replace(substring, substring.replaceAll("(?i)(" + str9 + ")", "<span style=\"background-color: " + hexColor + "\">$1</span>"));
            }
            Matcher matcher2 = compile.matcher(str7);
            String str11 = str7;
            while (matcher2.find()) {
                String substring2 = str7.substring(matcher2.start(), matcher2.end());
                str11 = str11.replace(substring2, substring2.replaceAll("(?i)(" + str9 + ")", "<span style=\"background-color: " + hexColor + "\">$1</span>"));
            }
            str7 = str11;
            str8 = str10;
        }
        return new Faq(1L, faq.getId(), faq.publish_id, faq.language, faq.section_publish_id, str8.substring(1, str8.length() - 1), str7.substring(1, str7.length() - 1), faq.is_helpful, faq.is_rtl, faq.getTags(), faq.getCategoryTags());
    }

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.is_screen_large);
    }

    public static int getResourceIdForAttribute(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }
}
