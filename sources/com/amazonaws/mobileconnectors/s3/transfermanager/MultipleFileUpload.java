package com.amazonaws.mobileconnectors.s3.transfermanager;

import java.util.Collection;

@Deprecated
/* loaded from: classes.dex */
public interface MultipleFileUpload extends Transfer {
    String getBucketName();

    String getKeyPrefix();

    Collection<? extends Upload> getSubTransfers();
}
