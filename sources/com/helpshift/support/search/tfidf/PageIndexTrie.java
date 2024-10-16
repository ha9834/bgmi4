package com.helpshift.support.search.tfidf;

import android.util.Pair;
import android.util.SparseArray;
import com.helpshift.support.HSSearch;
import com.helpshift.support.search.SearchTokenDao;
import com.helpshift.support.search.SearchTokenDto;
import com.helpshift.support.search.storage.SearchTokenDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PageIndexTrie {
    private static final int BATCH_SIZE = 1000;
    private static final int MAX_TOKEN_SIZE = 50;
    private static final int maxNGramLength = 10;
    private static final int minNGramLength = 1;
    private SearchTokenDao searchTokenDao;
    private final int totalDocCount;
    private PageIndexTrieNode root = new PageIndexTrieNode(0);
    private List<SearchTokenDto> searchTokenList = new ArrayList();

    public PageIndexTrie(int i) {
        this.totalDocCount = i;
    }

    public void insert(String str, int i, int i2) {
        if (str == null || 50 < str.length()) {
            return;
        }
        int length = str.length();
        PageIndexTrieNode pageIndexTrieNode = this.root;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            PageIndexTrieNode child = pageIndexTrieNode.getChild(charAt);
            if (child == null) {
                PageIndexTrieNode pageIndexTrieNode2 = new PageIndexTrieNode(charAt);
                pageIndexTrieNode.addChild(pageIndexTrieNode2);
                pageIndexTrieNode = pageIndexTrieNode2;
            } else {
                pageIndexTrieNode = child;
            }
            if (i != 50 && i3 > 1 && i3 < 10 && i3 + 1 != length) {
                pageIndexTrieNode.isWordEnd = true;
                pageIndexTrieNode.addFrequency(i2, (HSSearch.calcFreq(i3, i) * i3) / length, i);
            }
        }
        pageIndexTrieNode.isWordEnd = true;
        pageIndexTrieNode.addFrequency(i2, HSSearch.calcFreq(length, i), i);
    }

    public void createAndStoreTfIdfIndex() {
        this.searchTokenDao = SearchTokenDaoImpl.getInstance();
        char[] cArr = new char[50];
        Iterator<PageIndexTrieNode> it = this.root.getChildren().iterator();
        while (it.hasNext()) {
            createAndStoreTfIdfIndex(it.next(), cArr, 0);
        }
        if (this.searchTokenList.size() > 0) {
            this.searchTokenDao.save(this.searchTokenList);
        }
    }

    private void createAndStoreTfIdfIndex(PageIndexTrieNode pageIndexTrieNode, char[] cArr, int i) {
        if (pageIndexTrieNode == null) {
            return;
        }
        cArr[i] = pageIndexTrieNode.nodeValue;
        if (pageIndexTrieNode.isWordEnd) {
            this.searchTokenList.add(buildTfIdfIndex(new String(cArr, 0, i + 1), pageIndexTrieNode));
            if (this.searchTokenList.size() > 1000) {
                this.searchTokenDao.save(this.searchTokenList);
                this.searchTokenList.clear();
            }
        }
        Iterator<PageIndexTrieNode> it = pageIndexTrieNode.getChildren().iterator();
        while (it.hasNext()) {
            createAndStoreTfIdfIndex(it.next(), cArr, i + 1);
        }
        pageIndexTrieNode.resetChildren();
    }

    private SearchTokenDto buildTfIdfIndex(String str, PageIndexTrieNode pageIndexTrieNode) {
        int maxFrequency = pageIndexTrieNode.getMaxFrequency();
        int faqAppearCount = pageIndexTrieNode.getFaqAppearCount();
        HashMap hashMap = new HashMap();
        SparseArray<Pair<Integer, Integer>> wordFrequencyMap = pageIndexTrieNode.getWordFrequencyMap();
        int i = -1;
        for (int i2 = 0; i2 < wordFrequencyMap.size(); i2++) {
            int keyAt = wordFrequencyMap.keyAt(i2);
            Pair<Integer, Integer> valueAt = wordFrequencyMap.valueAt(i2);
            double intValue = ((Integer) valueAt.first).intValue();
            double d = maxFrequency;
            Double.isNaN(intValue);
            Double.isNaN(d);
            double d2 = this.totalDocCount;
            double d3 = faqAppearCount;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double log10 = (intValue / d) * Math.log10(d2 / d3);
            double termWeight = HSSearch.getTermWeight(((Integer) valueAt.second).intValue());
            Double.isNaN(termWeight);
            hashMap.put(Integer.valueOf(keyAt), Double.valueOf(log10 * termWeight));
            i = Math.max(i, ((Integer) valueAt.second).intValue());
        }
        pageIndexTrieNode.resetFrequency();
        return new SearchTokenDto(str, i, hashMap);
    }
}
