package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;

@Deprecated
/* loaded from: classes.dex */
public interface Copy extends Transfer {
    CopyResult waitForCopyResult() throws AmazonClientException, AmazonServiceException, InterruptedException;
}
