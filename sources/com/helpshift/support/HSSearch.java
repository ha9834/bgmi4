package com.helpshift.support;

import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.support.external.DoubleMetaphone;
import com.helpshift.support.model.FaqSearchIndex;
import com.helpshift.support.model.FuzzySearchToken;
import com.helpshift.support.model.TfIdfSearchToken;
import com.helpshift.support.search.SearchTokenDao;
import com.helpshift.support.search.SearchTokenDto;
import com.helpshift.support.search.storage.SearchTokenDaoImpl;
import com.helpshift.support.search.tfidf.PageIndexTrie;
import com.helpshift.support.util.HSTransliterator;
import com.helpshift.util.HtmlUtil;
import com.nostra13.universalimageloader.core.d;
import com.tencent.imsdk.android.IR;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class HSSearch {
    private static HashMap<String, String[]> characterTable;
    private static final Pattern patternGenerateToken = Pattern.compile("[a-zA-Z0-9]+");
    private static DoubleMetaphone metaPhone = new DoubleMetaphone();
    private static boolean indexing = false;
    private static boolean markDeinit = false;

    /* loaded from: classes2.dex */
    public enum HS_SEARCH_OPTIONS {
        FULL_SEARCH,
        METAPHONE_SEARCH,
        KEYWORD_SEARCH
    }

    public static int calcFreq(int i, int i2) {
        if (i == 1) {
            return 5;
        }
        if (40 == i2) {
            return i;
        }
        if (10 == i2) {
            return 30;
        }
        if (50 == i2) {
            return 1;
        }
        if (20 == i2) {
            return 300;
        }
        return 30 == i2 ? 150 : 1;
    }

    public static int getTermWeight(int i) {
        if (i == 20) {
            return 5;
        }
        return i == 30 ? 3 : 1;
    }

    private static boolean isMetaTypeMatching(int i, int i2) {
        return !(50 == i || 50 == i2) || i == i2;
    }

    private static int smallestOf(int i, int i2) {
        return i2 < i ? i2 : i;
    }

    private static int smallestOf(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static void init() {
        if (indexing) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.helpshift.support.HSSearch.1
            @Override // java.lang.Runnable
            public void run() {
                HSTransliterator.init();
            }
        }, "HS-trnsltrtr");
        thread.setDaemon(true);
        thread.start();
    }

    public static void deinit() {
        if (!indexing) {
            HSTransliterator.deinit();
        } else {
            markDeinit = true;
        }
        characterTable = null;
    }

    public static String escapeHtml(String str) {
        return HtmlUtil.fromHtml(str).toString();
    }

    public static String stripHtml(String str) {
        return str.replaceAll("<[^<>]+>", "");
    }

    public static ArrayList<String> generateTokens(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Matcher matcher = patternGenerateToken.matcher(str);
        while (matcher.find()) {
            if (matcher.group(0).length() > 2) {
                arrayList.add(matcher.group(0));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> generateTokensForSearchQuery(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Matcher matcher = patternGenerateToken.matcher(str);
        while (matcher.find()) {
            if (matcher.group(0).length() > 2 || str.length() > 2) {
                arrayList.add(matcher.group(0));
            }
        }
        return arrayList;
    }

    public static ArrayList<TfIdfSearchToken> generateVariations(String str, int i) {
        HashSet hashSet = new HashSet();
        hashSet.add(new TfIdfSearchToken(str, i));
        String doubleMetaphone = metaPhone.doubleMetaphone(str, false);
        if (doubleMetaphone != null) {
            hashSet.add(new TfIdfSearchToken(doubleMetaphone.toLowerCase(), 50));
        }
        return new ArrayList<>(hashSet);
    }

    public static ArrayList<TfIdfSearchToken> generateSearchVariations(String str) {
        return generateVariations(str, 10);
    }

    public static String sanitize(String str) {
        return HSTransliterator.unidecode(escapeHtml(stripHtml(str)).toLowerCase());
    }

    private static void buildPageIndexTrie(PageIndexTrie pageIndexTrie, String str, String str2, List<String> list, int i) {
        generateAndAddString(pageIndexTrie, generateTokens(sanitize(str)), 20, i);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(generateTokens(it.next()));
        }
        generateAndAddString(pageIndexTrie, arrayList, 30, i);
        generateAndAddString(pageIndexTrie, generateTokens(sanitize(str2)), 10, i);
    }

    private static void generateAndAddString(PageIndexTrie pageIndexTrie, List<String> list, int i, int i2) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Iterator<TfIdfSearchToken> it2 = generateVariations(it.next(), i).iterator();
            while (it2.hasNext()) {
                TfIdfSearchToken next = it2.next();
                pageIndexTrie.insert(next.value, next.type, i2);
            }
        }
    }

    public static FaqSearchIndex indexDocuments(ArrayList<Faq> arrayList) {
        if (indexing) {
            return null;
        }
        if (!HSTransliterator.isLoaded()) {
            HSTransliterator.init();
            markDeinit = true;
        }
        indexing = true;
        Map<String, List<FuzzySearchToken>> buildFuzzyIndex = buildFuzzyIndex(arrayList);
        buildTfidfIndex(arrayList);
        FaqSearchIndex faqSearchIndex = new FaqSearchIndex(buildFuzzyIndex);
        indexing = false;
        if (markDeinit) {
            deinit();
            markDeinit = false;
        }
        return faqSearchIndex;
    }

    protected static ArrayList<TfIdfSearchToken> filterSearchQuery(ArrayList<TfIdfSearchToken> arrayList, HS_SEARCH_OPTIONS hs_search_options) {
        ArrayList<TfIdfSearchToken> arrayList2 = new ArrayList<>();
        Iterator<TfIdfSearchToken> it = arrayList.iterator();
        while (it.hasNext()) {
            TfIdfSearchToken next = it.next();
            int i = next.type;
            if (hs_search_options == HS_SEARCH_OPTIONS.FULL_SEARCH) {
                arrayList2.add(next);
            } else if (hs_search_options == HS_SEARCH_OPTIONS.METAPHONE_SEARCH && 50 == i) {
                arrayList2.add(next);
            } else if (hs_search_options == HS_SEARCH_OPTIONS.KEYWORD_SEARCH && (10 == i || 40 == i)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public static ArrayList<HashMap> queryDocs(String str, HS_SEARCH_OPTIONS hs_search_options) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = generateTokensForSearchQuery(sanitize(str)).iterator();
        while (it.hasNext()) {
            arrayList.addAll(filterSearchQuery(generateSearchVariations(it.next()), hs_search_options));
        }
        SearchTokenDao searchTokenDaoImpl = SearchTokenDaoImpl.getInstance();
        HashSet hashSet = null;
        if (searchTokenDaoImpl != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TfIdfSearchToken tfIdfSearchToken = (TfIdfSearchToken) it2.next();
                String str2 = tfIdfSearchToken.value;
                int i = tfIdfSearchToken.type;
                SearchTokenDto searchTokenDto = searchTokenDaoImpl.get(str2);
                if (searchTokenDto != null && isMetaTypeMatching(searchTokenDto.wordType, tfIdfSearchToken.type)) {
                    Map<Integer, Double> map = searchTokenDto.scoreMap;
                    HashMap hashMap3 = new HashMap();
                    for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                        hashMap3.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                    if (!hashMap3.isEmpty()) {
                        for (Map.Entry entry2 : hashMap3.entrySet()) {
                            String str3 = (String) entry2.getKey();
                            ArrayList arrayList2 = (ArrayList) hashMap2.get(str3);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            if (str2.length() > 0) {
                                arrayList2.add(str2);
                            }
                            hashMap2.put(str3, arrayList2);
                            Double d = (Double) entry2.getValue();
                            Double d2 = (Double) hashMap.get(str3);
                            double doubleValue = d.doubleValue();
                            double calcFreq = calcFreq(str2.length(), i);
                            Double.isNaN(calcFreq);
                            Double valueOf = Double.valueOf(doubleValue * calcFreq);
                            if (d2 != null) {
                                hashMap.put(str3, Double.valueOf(d2.doubleValue() + valueOf.doubleValue()));
                            } else {
                                hashMap.put(str3, valueOf);
                            }
                        }
                        HashSet hashSet2 = new HashSet(hashMap3.keySet());
                        if (hashSet != null && !hashSet.isEmpty()) {
                            hashSet.addAll(hashSet2);
                        } else {
                            hashSet = new HashSet(hashSet2);
                        }
                    }
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            TreeMap treeMap = new TreeMap(new RankComparator(hashMap));
            treeMap.putAll(hashMap);
            return sortMatchedTermsMap(treeMap, hashMap2);
        }
        if (hashSet.size() == 1) {
            HashMap hashMap4 = new HashMap();
            ArrayList<HashMap> arrayList3 = new ArrayList<>();
            String str4 = (String) hashSet.iterator().next();
            hashMap4.put("f", str4);
            hashMap4.put("t", hashMap2.get(str4));
            arrayList3.add(hashMap4);
            return arrayList3;
        }
        HashMap hashMap5 = new HashMap();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            String str5 = (String) it3.next();
            hashMap5.put(str5, hashMap.get(str5));
        }
        TreeMap treeMap2 = new TreeMap(new RankComparator(hashMap5));
        treeMap2.putAll(hashMap5);
        return sortMatchedTermsMap(treeMap2, hashMap2);
    }

    private static ArrayList<HashMap> sortMatchedTermsMap(TreeMap treeMap, HashMap hashMap) {
        ArrayList<HashMap> arrayList = new ArrayList<>();
        for (String str : treeMap.keySet()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("f", str);
            hashMap2.put("t", hashMap.get(str));
            arrayList.add(hashMap2);
        }
        return arrayList;
    }

    protected static void buildTfidfIndex(ArrayList<Faq> arrayList) {
        int size = arrayList.size();
        PageIndexTrie pageIndexTrie = new PageIndexTrie(size);
        for (int i = 0; i < size; i++) {
            Faq faq = arrayList.get(i);
            buildPageIndexTrie(pageIndexTrie, faq.title, faq.body, faq.getTags(), i);
        }
        pageIndexTrie.createAndStoreTfIdfIndex();
    }

    protected static Map<String, List<FuzzySearchToken>> buildFuzzyIndex(ArrayList<Faq> arrayList) {
        HashMap hashMap = new HashMap();
        Iterator<Faq> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<String> it2 = generateTokens(sanitize(it.next().title)).iterator();
            while (it2.hasNext()) {
                String lowerCase = it2.next().toLowerCase();
                if (lowerCase.length() > 3) {
                    FuzzySearchToken fuzzySearchToken = new FuzzySearchToken(lowerCase, i + "");
                    String substring = lowerCase.substring(0, 1);
                    List list = (List) hashMap.get(substring);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fuzzySearchToken);
                    hashMap.put(substring, list);
                    String substring2 = lowerCase.substring(1, 2);
                    List list2 = (List) hashMap.get(substring2);
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(fuzzySearchToken);
                    hashMap.put(substring2, list2);
                }
            }
            i++;
        }
        return hashMap;
    }

    public static ArrayList<HashMap> getFuzzyMatches(String str, Map<String, List<FuzzySearchToken>> map) {
        ArrayList<HashMap> arrayList = new ArrayList<>();
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = generateTokens(sanitize(str)).iterator();
            while (it.hasNext()) {
                String substring = it.next().substring(0, 1);
                ArrayList arrayList2 = new ArrayList(getNeighbourCharacters(substring));
                arrayList2.add(substring);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ArrayList arrayList3 = (ArrayList) map.get((String) it2.next());
                    if (arrayList3 != null) {
                        Iterator it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            FuzzySearchToken fuzzySearchToken = (FuzzySearchToken) it3.next();
                            String str2 = fuzzySearchToken.word;
                            if (calculateWordDistance(str2, r2) > 0.7d) {
                                String str3 = fuzzySearchToken.docId;
                                ArrayList arrayList4 = (ArrayList) hashMap.get(str3);
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList();
                                }
                                arrayList4.add(str2);
                                hashMap.put(str3, arrayList4);
                            }
                        }
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("f", entry.getKey());
                hashMap2.put("t", entry.getValue());
                arrayList.add(hashMap2);
            }
        }
        return arrayList;
    }

    private static List<String> getNeighbourCharacters(String str) {
        HashMap<String, String[]> characterTable2 = getCharacterTable();
        if (characterTable2 != null && characterTable2.containsKey(str)) {
            return Arrays.asList(characterTable2.get(str));
        }
        return new ArrayList();
    }

    static HashMap<String, String[]> getCharacterTable() {
        if (characterTable == null) {
            characterTable = new HashMap<>();
            characterTable.put(AnalyticsEventKey.ACTION_SHA, new String[]{"q", "w", AnalyticsEventKey.SEARCH_QUERY, "z"});
            characterTable.put("b", new String[]{"v", "h", AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT});
            characterTable.put(IR.path.DOCS_IMSDK_CHANNEL, new String[]{"x", "f", "v"});
            characterTable.put(d.f5744a, new String[]{AnalyticsEventKey.SEARCH_QUERY, "z", "x"});
            characterTable.put("e", new String[]{"w", AnalyticsEventKey.SEARCH_QUERY, d.f5744a, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK});
            characterTable.put("f", new String[]{d.f5744a, "g", IR.path.DOCS_IMSDK_CHANNEL, "x"});
            characterTable.put("g", new String[]{"h", "f", "v", "b"});
            characterTable.put("h", new String[]{"g", "j", "b", AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT});
            characterTable.put("i", new String[]{AnalyticsEventKey.URL, "o", "k", "j"});
            characterTable.put("j", new String[]{"m", AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT, "h", "k"});
            characterTable.put("k", new String[]{"j", AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, "m"});
            characterTable.put(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, new String[]{"k", AnalyticsEventKey.PROTOCOL, "m"});
            characterTable.put("m", new String[]{AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT, "b", AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL});
            characterTable.put(AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT, new String[]{"b", "j", "m"});
            characterTable.put("o", new String[]{AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, "k", AnalyticsEventKey.PROTOCOL});
            characterTable.put(AnalyticsEventKey.PROTOCOL, new String[]{AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, "o"});
            characterTable.put("q", new String[]{"w", AnalyticsEventKey.ACTION_SHA});
            characterTable.put(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, new String[]{AnalyticsEventKey.SEARCH_QUERY, d.f5744a, "e", "f"});
            characterTable.put(AnalyticsEventKey.SEARCH_QUERY, new String[]{AnalyticsEventKey.ACTION_SHA, "z", d.f5744a});
            characterTable.put("t", new String[]{AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, "f", "g", "y"});
            characterTable.put(AnalyticsEventKey.URL, new String[]{"j", "h", "i", "y"});
            characterTable.put("v", new String[]{IR.path.DOCS_IMSDK_CHANNEL, "g", "b"});
            characterTable.put("w", new String[]{"q", AnalyticsEventKey.ACTION_SHA, AnalyticsEventKey.SEARCH_QUERY});
            characterTable.put("x", new String[]{"z", AnalyticsEventKey.SEARCH_QUERY, IR.path.DOCS_IMSDK_CHANNEL});
            characterTable.put("y", new String[]{"g", "h", "t", AnalyticsEventKey.URL});
            characterTable.put("z", new String[]{AnalyticsEventKey.ACTION_SHA, AnalyticsEventKey.SEARCH_QUERY, "x"});
        }
        return characterTable;
    }

    static float calculateWordDistance(String str, String str2) {
        String trim = str.trim();
        String trim2 = str2.trim();
        String lowerCase = trim.toLowerCase();
        String lowerCase2 = trim2.toLowerCase();
        int length = lowerCase.length();
        int length2 = lowerCase2.length();
        int i = length + 1;
        if (length == 0) {
            return 0.0f;
        }
        int i2 = length2 + 1;
        if (length2 == 0) {
            return 0.0f;
        }
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i; i4++) {
            iArr[i4] = i4;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            iArr[i5 * i] = i5;
        }
        for (int i6 = 1; i6 < i; i6++) {
            for (int i7 = 1; i7 < i2; i7++) {
                int i8 = i6 - 1;
                int i9 = i7 - 1;
                int i10 = lowerCase.charAt(i8) == lowerCase2.charAt(i9) ? 0 : 1;
                int i11 = (i7 * i) + i6;
                int i12 = (i9 * i) + i6;
                iArr[i11] = smallestOf(iArr[i12] + 1, iArr[i11 - 1] + 1, iArr[i12 - 1] + i10);
                if (i6 > 1 && i7 > 1) {
                    if (lowerCase.charAt(i8) == lowerCase2.charAt(i7 - 2) && lowerCase.charAt(i6 - 2) == lowerCase2.charAt(i9)) {
                        iArr[i11] = smallestOf(iArr[i11], iArr[((r10 * i) + i6) - 2] + i10);
                    }
                }
            }
        }
        int i13 = iArr[i3 - 1];
        if (i > i2) {
            i2 = i;
        }
        return 1.0f - (i13 / i2);
    }
}
