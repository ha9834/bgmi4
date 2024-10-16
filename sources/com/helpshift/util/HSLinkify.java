package com.helpshift.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class HSLinkify {
    public static final int ALL = 15;
    private static final int EMAIL_ADDRESSES = 2;
    private static final int MAP_ADDRESSES = 8;
    private static final int PHONE_NUMBERS = 4;
    private static final String TAG = "Helpshift_HSlnkfy";
    public static final int WEB_URLS = 1;
    private static final MatchFilter sUrlMatchFilter = new MatchFilter() { // from class: com.helpshift.util.HSLinkify.1
        @Override // com.helpshift.util.HSLinkify.MatchFilter
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            return i == 0 || charSequence.charAt(i - 1) != '@';
        }
    };

    /* loaded from: classes2.dex */
    public interface LinkClickListener {
        void onLinkClickFailed();

        void onLinkClicked(String str);
    }

    /* loaded from: classes2.dex */
    public interface MatchFilter {
        boolean acceptMatch(CharSequence charSequence, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface TransformFilter {
        String transformUrl(Matcher matcher, String str);
    }

    private static boolean addLinks(Spannable spannable, int i, LinkClickListener linkClickListener) {
        int i2;
        boolean z;
        boolean z2;
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            Matcher matcher = Patterns.WEB_URL.matcher(spannable);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                MatchFilter matchFilter = sUrlMatchFilter;
                if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                    LinkSpec linkSpec = new LinkSpec();
                    String group = matcher.group(0);
                    String[] strArr = {"http://", "https://", "rtsp://"};
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArr.length) {
                            z2 = false;
                            break;
                        }
                        int i4 = i3;
                        if (!group.regionMatches(true, 0, strArr[i3], 0, strArr[i3].length())) {
                            i3 = i4 + 1;
                        } else if (group.regionMatches(false, 0, strArr[i4], 0, strArr[i4].length())) {
                            z2 = true;
                        } else {
                            group = strArr[i4] + group.substring(strArr[i4].length());
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        group = strArr[0] + group;
                    }
                    linkSpec.url = group;
                    linkSpec.start = start;
                    linkSpec.end = end;
                    arrayList.add(linkSpec);
                }
            }
        }
        if ((i & 2) != 0) {
            Matcher matcher2 = Patterns.EMAIL_ADDRESS.matcher(spannable);
            while (matcher2.find()) {
                int start2 = matcher2.start();
                int end2 = matcher2.end();
                LinkSpec linkSpec2 = new LinkSpec();
                String group2 = matcher2.group(0);
                String[] strArr2 = {WebView.SCHEME_MAILTO};
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr2.length) {
                        z = false;
                        break;
                    }
                    int i6 = i5;
                    if (!group2.regionMatches(true, 0, strArr2[i5], 0, strArr2[i5].length())) {
                        i5 = i6 + 1;
                    } else if (group2.regionMatches(false, 0, strArr2[i6], 0, strArr2[i6].length())) {
                        z = true;
                    } else {
                        group2 = strArr2[i6] + group2.substring(strArr2[i6].length());
                        z = true;
                    }
                }
                if (!z) {
                    group2 = strArr2[0] + group2;
                }
                linkSpec2.url = group2;
                linkSpec2.start = start2;
                linkSpec2.end = end2;
                arrayList.add(linkSpec2);
            }
        }
        if ((i & 4) != 0) {
            Matcher matcher3 = Patterns.PHONE.matcher(spannable);
            while (matcher3.find()) {
                String group3 = matcher3.group();
                if (group3.length() >= 6) {
                    LinkSpec linkSpec3 = new LinkSpec();
                    linkSpec3.url = WebView.SCHEME_TEL + group3;
                    linkSpec3.start = matcher3.start();
                    linkSpec3.end = matcher3.end();
                    arrayList.add(linkSpec3);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<LinkSpec>() { // from class: com.helpshift.util.HSLinkify.2
            @Override // java.util.Comparator
            public final boolean equals(Object obj) {
                return false;
            }

            @Override // java.util.Comparator
            public final int compare(LinkSpec linkSpec4, LinkSpec linkSpec5) {
                if (linkSpec4.start < linkSpec5.start) {
                    return -1;
                }
                if (linkSpec4.start <= linkSpec5.start && linkSpec4.end >= linkSpec5.end) {
                    return linkSpec4.end > linkSpec5.end ? -1 : 0;
                }
                return 1;
            }
        });
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size - 1) {
            LinkSpec linkSpec4 = (LinkSpec) arrayList.get(i7);
            int i8 = i7 + 1;
            LinkSpec linkSpec5 = (LinkSpec) arrayList.get(i8);
            if (linkSpec4.start <= linkSpec5.start && linkSpec4.end > linkSpec5.start) {
                if (linkSpec5.end <= linkSpec4.end) {
                    i2 = i8;
                } else if (linkSpec4.end - linkSpec4.start > linkSpec5.end - linkSpec5.start) {
                    i2 = i8;
                } else {
                    i2 = linkSpec4.end - linkSpec4.start < linkSpec5.end - linkSpec5.start ? i7 : -1;
                }
                if (i2 != -1) {
                    arrayList.remove(i2);
                    size--;
                }
            }
            i7 = i8;
        }
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec6 = (LinkSpec) it.next();
            spannable.setSpan(getURLSpanWithClickListener(linkSpec6.url, linkClickListener), linkSpec6.start, linkSpec6.end, 33);
        }
        return true;
    }

    public static boolean addLinks(TextView textView, int i, LinkClickListener linkClickListener) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i, linkClickListener)) {
                return false;
            }
            MovementMethod movementMethod = textView.getMovementMethod();
            if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            return true;
        }
        SpannableString valueOf = SpannableString.valueOf(text);
        if (!addLinks(valueOf, i, linkClickListener)) {
            return false;
        }
        MovementMethod movementMethod2 = textView.getMovementMethod();
        if ((movementMethod2 == null || !(movementMethod2 instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setText(valueOf);
        return true;
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter, LinkClickListener linkClickListener) {
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, matchFilter, transformFilter, linkClickListener)) {
            textView.setText(valueOf);
            MovementMethod movementMethod = textView.getMovementMethod();
            if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    private static boolean addLinks(Spannable spannable, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter, LinkClickListener linkClickListener) {
        String str2;
        boolean z;
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        Matcher matcher = pattern.matcher(spannable);
        boolean z2 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                String group = matcher.group(0);
                String[] strArr = {lowerCase};
                if (transformFilter != null) {
                    group = transformFilter.transformUrl(matcher, group);
                }
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        str2 = group;
                        z = false;
                        break;
                    }
                    int i2 = i;
                    if (!group.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                        i = i2 + 1;
                    } else if (group.regionMatches(false, 0, strArr[i2], 0, strArr[i2].length())) {
                        str2 = group;
                        z = true;
                    } else {
                        str2 = strArr[i2] + group.substring(strArr[i2].length());
                        z = true;
                    }
                }
                if (!z) {
                    str2 = strArr[0] + str2;
                }
                spannable.setSpan(getURLSpanWithClickListener(str2, linkClickListener), start, end, 33);
                z2 = true;
            }
        }
        return z2;
    }

    private static URLSpan getURLSpanWithClickListener(final String str, final LinkClickListener linkClickListener) {
        return new URLSpan(str) { // from class: com.helpshift.util.HSLinkify.3
            @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
            public void onClick(View view) {
                try {
                    super.onClick(view);
                    if (linkClickListener != null) {
                        linkClickListener.onLinkClicked(str);
                    }
                } catch (Exception e) {
                    HSLogger.e(HSLinkify.TAG, "Error in handling link click.", e);
                    LinkClickListener linkClickListener2 = linkClickListener;
                    if (linkClickListener2 != null) {
                        linkClickListener2.onLinkClickFailed();
                    }
                }
            }
        };
    }
}
