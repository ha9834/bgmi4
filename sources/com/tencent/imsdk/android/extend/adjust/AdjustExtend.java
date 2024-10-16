package com.tencent.imsdk.android.extend.adjust;

import android.net.Uri;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class AdjustExtend {
    private static DeepLinkingList mDeferredList;
    private static DeepLinkingList mStandardList;

    /* loaded from: classes.dex */
    static class DeepLinkingList {
        private LinkedList<String> mUrls;

        DeepLinkingList() {
        }

        public boolean add(Uri uri) {
            if (uri != null) {
                return add(uri.toString());
            }
            return false;
        }

        public boolean add(String str) {
            if (this.mUrls == null) {
                this.mUrls = new LinkedList<>();
            }
            if (str != null) {
                return this.mUrls.add(str);
            }
            return false;
        }

        String peek() {
            LinkedList<String> linkedList = this.mUrls;
            if (linkedList == null) {
                return null;
            }
            return linkedList.peek();
        }

        String poll() {
            LinkedList<String> linkedList = this.mUrls;
            if (linkedList == null) {
                return null;
            }
            return linkedList.poll();
        }
    }

    public static boolean addStandardDeepLink(String str) {
        if (mStandardList == null) {
            mStandardList = new DeepLinkingList();
        }
        return mStandardList.add(str);
    }

    public static boolean addStandardDeepLink(Uri uri) {
        if (mStandardList == null) {
            mStandardList = new DeepLinkingList();
        }
        return mStandardList.add(uri);
    }

    public static String peekStandardDeepLink() {
        String peek;
        DeepLinkingList deepLinkingList = mStandardList;
        return (deepLinkingList == null || (peek = deepLinkingList.peek()) == null) ? "" : peek;
    }

    public static String pollStandardDeepLink() {
        String poll;
        DeepLinkingList deepLinkingList = mStandardList;
        return (deepLinkingList == null || (poll = deepLinkingList.poll()) == null) ? "" : poll;
    }

    public static boolean addDeferredDeepLink(String str) {
        if (mDeferredList == null) {
            mDeferredList = new DeepLinkingList();
        }
        return mDeferredList.add(str);
    }

    public static boolean addDeferredDeepLink(Uri uri) {
        if (mDeferredList == null) {
            mDeferredList = new DeepLinkingList();
        }
        return mDeferredList.add(uri);
    }

    public static String peekDeferredDeepLink() {
        String peek;
        DeepLinkingList deepLinkingList = mDeferredList;
        return (deepLinkingList == null || (peek = deepLinkingList.peek()) == null) ? "" : peek;
    }

    public static String pollDeferredDeepLink() {
        String poll;
        DeepLinkingList deepLinkingList = mDeferredList;
        return (deepLinkingList == null || (poll = deepLinkingList.poll()) == null) ? "" : poll;
    }
}
