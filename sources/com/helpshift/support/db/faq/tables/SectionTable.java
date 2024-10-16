package com.helpshift.support.db.faq.tables;

import android.provider.BaseColumns;

/* loaded from: classes2.dex */
public interface SectionTable {
    public static final String TABLE_NAME = "sections";

    /* loaded from: classes2.dex */
    public interface Columns extends BaseColumns {
        public static final String PUBLISH_ID = "publish_id";
        public static final String SECTION_ID = "section_id";
        public static final String TITLE = "title";
    }
}
