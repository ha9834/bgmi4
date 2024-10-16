package com.helpshift.support.adapters;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.support.ContactUsFilter;
import com.helpshift.support.Faq;
import com.helpshift.support.util.HSTransliterator;
import com.helpshift.util.Styles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SearchResultAdapter extends RecyclerView.a<RecyclerView.w> {
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_QUESTION = 3;
    private View.OnClickListener onContactUsClickedListener;
    private View.OnClickListener onQuestionClickedListener;
    private List<Faq> questions;

    public SearchResultAdapter(List<Faq> list, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.questions = list;
        this.onQuestionClickedListener = onClickListener;
        this.onContactUsClickedListener = onClickListener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new HeaderViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__search_result_header, viewGroup, false));
            case 2:
                return new FooterViewHolder((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__search_result_footer, viewGroup, false));
            default:
                return new QuestionViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs_simple_recycler_view_item, viewGroup, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (wVar instanceof FooterViewHolder) {
            configureFooterViewHolder((FooterViewHolder) wVar);
        } else if (wVar instanceof QuestionViewHolder) {
            configureQuestionViewHolder((QuestionViewHolder) wVar, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        return isPositionFooter(i) ? 2 : 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long getItemId(int i) {
        if (i == 0) {
            return 1L;
        }
        if (isPositionFooter(i)) {
            return 2L;
        }
        return Long.valueOf(this.questions.get(i - 1).publish_id).longValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.questions.size() + 2;
    }

    private void configureFooterViewHolder(FooterViewHolder footerViewHolder) {
        if (ContactUsFilter.showContactUs(ContactUsFilter.LOCATION.SEARCH_FOOTER)) {
            footerViewHolder.rootView.setVisibility(0);
            footerViewHolder.button.setOnClickListener(this.onContactUsClickedListener);
        } else {
            footerViewHolder.rootView.setVisibility(8);
        }
    }

    private void configureQuestionViewHolder(QuestionViewHolder questionViewHolder, int i) {
        Faq faq = this.questions.get(i - 1);
        ArrayList<String> arrayList = faq.searchTerms;
        String str = faq.title;
        if (arrayList != null && arrayList.size() > 0) {
            int color = Styles.getColor(questionViewHolder.textView.getContext(), R.attr.hs__searchHighlightColor);
            SpannableString spannableString = new SpannableString(str);
            if (str.equals(HSTransliterator.unidecode(str))) {
                String lowerCase = str.toLowerCase();
                for (String str2 : arrayList) {
                    if (str2.length() >= 3) {
                        for (int indexOf = TextUtils.indexOf(lowerCase, str2, 0); indexOf >= 0; indexOf = TextUtils.indexOf(lowerCase, str2, indexOf + str2.length())) {
                            spannableString.setSpan(new BackgroundColorSpan(color), indexOf, str2.length() + indexOf, 33);
                        }
                    }
                }
            } else {
                int length = str.length();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    String unidecode = HSTransliterator.unidecode(str.charAt(i2) + "");
                    for (int i3 = 0; i3 < unidecode.length(); i3++) {
                        sb.append(unidecode.charAt(i3));
                        arrayList2.add(Integer.valueOf(i2));
                    }
                }
                String lowerCase2 = sb.toString().toLowerCase();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String lowerCase3 = it.next().toLowerCase();
                    if (lowerCase3.length() >= 3) {
                        for (int indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, 0); indexOf2 >= 0; indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, indexOf2 + lowerCase3.length())) {
                            spannableString.setSpan(new BackgroundColorSpan(color), ((Integer) arrayList2.get(indexOf2)).intValue(), ((Integer) arrayList2.get((lowerCase3.length() + indexOf2) - 1)).intValue() + 1, 33);
                        }
                    }
                }
            }
            questionViewHolder.textView.setText(spannableString);
        } else {
            questionViewHolder.textView.setText(str);
        }
        questionViewHolder.textView.setOnClickListener(this.onQuestionClickedListener);
        questionViewHolder.textView.setTag(faq.publish_id);
    }

    public Faq getFaq(String str) {
        List<Faq> list = this.questions;
        if (list == null) {
            return null;
        }
        for (Faq faq : list) {
            if (faq.publish_id.equals(str)) {
                return faq;
            }
        }
        return null;
    }

    private boolean isPositionFooter(int i) {
        return i == getItemCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class QuestionViewHolder extends RecyclerView.w {
        TextView textView;

        public QuestionViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class FooterViewHolder extends RecyclerView.w {
        Button button;
        LinearLayout rootView;

        public FooterViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.rootView = linearLayout;
            this.button = (Button) linearLayout.findViewById(R.id.send_anyway_button);
        }
    }

    /* loaded from: classes2.dex */
    protected static class HeaderViewHolder extends RecyclerView.w {
        public HeaderViewHolder(TextView textView) {
            super(textView);
        }
    }
}
