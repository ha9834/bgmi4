package com.helpshift.support.compositions;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.q;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.Section;
import com.helpshift.support.fragments.QuestionListFragment;
import com.helpshift.util.HSLogger;
import java.util.List;

/* loaded from: classes2.dex */
public class SectionPagerAdapter extends q {
    private static final String TAG = "Helpshift_SectionPager";
    private FaqTagFilter faqTagFilter;
    private List<Section> sections;

    public SectionPagerAdapter(FragmentManager fragmentManager, List<Section> list, FaqTagFilter faqTagFilter) {
        super(fragmentManager);
        this.sections = list;
        this.faqTagFilter = faqTagFilter;
    }

    @Override // androidx.fragment.app.q
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("sectionPublishId", this.sections.get(i).getPublishId());
        bundle.putSerializable("withTagsMatching", this.faqTagFilter);
        return QuestionListFragment.newInstance(bundle);
    }

    @Override // androidx.fragment.app.q, androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        try {
            super.restoreState(parcelable, classLoader);
        } catch (Exception e) {
            HSLogger.e(TAG, "Exception in restoreState: ", e);
        }
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.sections.size();
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i) {
        return this.sections.get(i).getTitle();
    }
}
