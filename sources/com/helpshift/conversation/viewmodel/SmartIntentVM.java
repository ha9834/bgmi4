package com.helpshift.conversation.viewmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.F;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.smartintent.BaseSmartIntentViewState;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentCollapsedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentDM;
import com.helpshift.conversation.smartintent.SmartIntentDMCallback;
import com.helpshift.conversation.smartintent.SmartIntentExpandedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentLeafViewState;
import com.helpshift.conversation.smartintent.SmartIntentSavedState;
import com.helpshift.conversation.smartintent.SmartIntentSearchResultViewState;
import com.helpshift.conversation.smartintent.dto.SISearchResultDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.util.HSBackStackController;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.MutableBaseViewState;
import com.helpshift.widget.MutableReplyFieldViewState;
import com.helpshift.widget.ReplyFieldViewState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SmartIntentVM implements SmartIntentDMCallback {
    private static final String TAG = "Helpshift_SmartVM";
    private Conversation activeConversation;
    private SmartIntentVMCallback callback;
    private Domain domain;
    private SmartIntentSavedState lastSavedState;
    private Platform platform;
    private SmartIntentDM smartIntentDM;
    private UserDM userDM;
    private boolean isInitialized = false;
    private boolean isShowingFakeTAI = false;
    private SITreeDTO cachedSmartIntentTree = null;
    private Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelMapping = null;
    private SISearchResultDTO lastSearchResultData = null;
    private HSBackStackController<BaseSmartIntentViewState> backStackController = new HSBackStackController<>();
    private boolean skipSearchOnUserQueryChange = false;
    MutableBaseViewState replyButtonViewState = new MutableBaseViewState();
    MutableReplyFieldViewState replyFieldViewState = new MutableReplyFieldViewState();
    MutableBaseViewState clearSearchViewState = new MutableBaseViewState();

    public SmartIntentVM(Platform platform, Domain domain, SmartIntentDM smartIntentDM, UserDM userDM, Conversation conversation, SmartIntentVMCallback smartIntentVMCallback) {
        this.platform = platform;
        this.domain = domain;
        this.activeConversation = conversation;
        this.userDM = userDM;
        this.smartIntentDM = smartIntentDM;
        this.callback = smartIntentVMCallback;
        this.clearSearchViewState.setVisible(false);
        this.smartIntentDM.registerSmartIntentDMCallback(this);
    }

    public void onNewConversationStarted(Conversation conversation) {
        this.activeConversation = conversation;
    }

    private SmartIntentCollapsedRootViewState buildSmartIntentCollapsedRootViewState(SITreeDTO sITreeDTO) {
        ArrayList arrayList = new ArrayList();
        for (SmartIntentDTO smartIntentDTO : sITreeDTO.rootIntents) {
            arrayList.add(new RootIntentUIModel(smartIntentDTO.localId.longValue(), smartIntentDTO.label));
        }
        return new SmartIntentCollapsedRootViewState(sITreeDTO.promptTitle, sITreeDTO.textInputHint, sITreeDTO.enforceIntentSelection, arrayList);
    }

    private SmartIntentExpandedRootViewState buildSmartIntentExpandedRootViewState(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        return new SmartIntentExpandedRootViewState(smartIntentCollapsedRootViewState.promptTitle, smartIntentCollapsedRootViewState.typingBoxHint, smartIntentCollapsedRootViewState.enforceIntentSelection, smartIntentCollapsedRootViewState.rootIntentUIModels);
    }

    private SmartIntentLeafViewState buildSmartIntentLeafViewState(SITreeDTO sITreeDTO, long j) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<SmartIntentDTO> it = sITreeDTO.rootIntents.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            SmartIntentDTO next = it.next();
            if (next.localId.longValue() == j) {
                String str2 = next.label;
                for (SmartIntentDTO smartIntentDTO : next.children) {
                    arrayList.add(new LeafIntentUIModel(smartIntentDTO.localId.longValue(), smartIntentDTO.label));
                }
                str = str2;
            }
        }
        return new SmartIntentLeafViewState(str, sITreeDTO.textInputHint, sITreeDTO.enforceIntentSelection, j, arrayList);
    }

    private void showSmartIntentTreeInitialState(SITreeDTO sITreeDTO) {
        SmartIntentCollapsedRootViewState buildSmartIntentCollapsedRootViewState = buildSmartIntentCollapsedRootViewState(sITreeDTO);
        this.backStackController.clear();
        if (this.backStackController.addItem(buildSmartIntentCollapsedRootViewState)) {
            this.callback.showSmartIntentUI(buildSmartIntentCollapsedRootViewState);
        }
        this.replyButtonViewState.setVisible(!sITreeDTO.enforceIntentSelection);
        this.replyButtonViewState.setEnabled(false);
    }

    private void sendTreeShownEvent(SITreeDTO sITreeDTO) {
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_TREE_ID, sITreeDTO.serverId);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_TREE_VERSION, Integer.valueOf(sITreeDTO.version));
        hashMap.put(AnalyticsEventKey.SMART_INTENT_ENFORCE_INTENT_SELECTION, Boolean.valueOf(sITreeDTO.enforceIntentSelection));
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_TREE_SHOWN, hashMap);
    }

    public void showSmartIntentUI() {
        HSLogger.d(TAG, "Showing smart intent UI");
        updateConversationReplyFooter(false);
        if (this.isInitialized) {
            return;
        }
        SmartIntentSavedState smartIntentSavedState = this.lastSavedState;
        if (smartIntentSavedState != null) {
            restoreSmartIntentUIFromSavedState(smartIntentSavedState);
            this.lastSavedState = null;
            return;
        }
        if (this.smartIntentDM.isSmartIntentTreeAvailable(this.userDM)) {
            this.cachedSmartIntentTree = this.smartIntentDM.getSmartIntentTree(this.userDM);
            this.intentIdToSearchIntentUIModelMapping = null;
            SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
            if (sITreeDTO != null) {
                showSmartIntentTreeInitialState(sITreeDTO);
                sendTreeShownEvent(this.cachedSmartIntentTree);
                this.isInitialized = true;
                this.smartIntentDM.refreshSmartIntentSearchModel(this.userDM, this.cachedSmartIntentTree);
                return;
            }
        }
        showFakeTypingIndicator(true);
        this.smartIntentDM.fetchSmartIntentTreeFromServer(this.userDM);
        this.isInitialized = true;
    }

    private void restoreSmartIntentUIFromSavedState(SmartIntentSavedState smartIntentSavedState) {
        HSLogger.d(TAG, "Restoring smart intent UI state on rotation");
        if (smartIntentSavedState.isShowingTAI && this.smartIntentDM.isTreeFetchRequestInProgress(this.userDM)) {
            showFakeTypingIndicator(true);
            this.isInitialized = true;
            return;
        }
        this.cachedSmartIntentTree = this.smartIntentDM.getSmartIntentTree(this.userDM);
        SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
        if (sITreeDTO == null) {
            handleTreeUnAvailable();
            return;
        }
        showSmartIntentTreeInitialState(sITreeDTO);
        if (this.lastSavedState.selectedRootIntentLocalId != null) {
            handleRootIntentSelectedInternal(this.lastSavedState.selectedRootIntentLocalId.longValue());
        } else if (this.lastSavedState.isBottomSheetInExpandedState) {
            onSmartIntentBottomSheetExpanded();
        }
        if (StringUtils.isNotEmpty(this.lastSavedState.userTypedQuery)) {
            if (!this.lastSavedState.isSearchUIVisible) {
                this.skipSearchOnUserQueryChange = true;
            }
            this.replyFieldViewState.setReplyText(this.lastSavedState.userTypedQuery);
        }
        this.isInitialized = true;
    }

    public void handleRootIntentSelected(RootIntentUIModel rootIntentUIModel) {
        HSLogger.d(TAG, "On user selected a root intent : " + rootIntentUIModel.label);
        handleRootIntentSelectedInternal(rootIntentUIModel.localId);
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_IS_LEAF_INTENT, false);
        SmartIntentDTO rootIntentDTO = getRootIntentDTO(rootIntentUIModel.localId);
        if (rootIntentDTO != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(Collections.singletonList(rootIntentDTO.serverId)));
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SELECTION, hashMap);
    }

    private void handleRootIntentSelectedInternal(long j) {
        SmartIntentLeafViewState buildSmartIntentLeafViewState = buildSmartIntentLeafViewState(this.smartIntentDM.getSmartIntentTree(this.userDM), j);
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            this.backStackController.addItem(buildSmartIntentExpandedRootViewState((SmartIntentCollapsedRootViewState) topItem));
        }
        if (this.backStackController.addItem(buildSmartIntentLeafViewState)) {
            this.callback.updateSmartIntentView(buildSmartIntentLeafViewState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleLeafIntentSelected(LeafIntentUIModel leafIntentUIModel) {
        HSLogger.d(TAG, "On user selected a leaf intent : " + leafIntentUIModel.label);
        this.callback.hideSmartIntentView();
        resetInternalStates();
        createPreIssue(leafIntentUIModel.localId, null, null);
    }

    private void createPreIssue(long j, Integer num, Double d) {
        List<SmartIntentDTO> rootToLeafIntents = getRootToLeafIntents(j);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SmartIntentDTO smartIntentDTO : rootToLeafIntents) {
            arrayList.add(smartIntentDTO.serverId);
            arrayList2.add(smartIntentDTO.label);
        }
        this.callback.createPreIssueFromSmartIntentSelection(this.cachedSmartIntentTree.serverId, arrayList, arrayList2, this.replyFieldViewState.getReplyText());
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        hashMap.put(AnalyticsEventKey.SMART_INTENT_IS_LEAF_INTENT, true);
        if (ListUtils.isNotEmpty(arrayList)) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(arrayList));
        }
        if (d != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CONFIDENCE, d);
        }
        if (num != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, num);
        }
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SELECTION, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleSearchIntentSelected(SearchIntentUIModel searchIntentUIModel) {
        this.callback.hideSmartIntentView();
        resetInternalStates();
        Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
        searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, false);
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
        createPreIssue(searchIntentUIModel.localId, Integer.valueOf(searchIntentUIModel.rank), searchIntentUIModel.confidence);
    }

    private Map<String, Object> getSearchAnalyticsData() {
        HashMap hashMap = new HashMap();
        hashMap.put("acid", this.activeConversation.acid);
        SISearchResultDTO sISearchResultDTO = this.lastSearchResultData;
        if (sISearchResultDTO == null || !sISearchResultDTO.isSearchPerformed) {
            return hashMap;
        }
        if (this.lastSearchResultData.aiModelVersion != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_MODEL_VERSION, this.lastSearchResultData.aiModelVersion);
        }
        if (this.lastSearchResultData.searchIntentLevel != null) {
            hashMap.put(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL, this.lastSearchResultData.searchIntentLevel);
        }
        if (this.lastSearchResultData.searchAlgorithmType != null) {
            if (this.lastSearchResultData.searchAlgorithmType.intValue() == 1) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_ALGORITHM, "ml");
            } else if (this.lastSearchResultData.searchAlgorithmType.intValue() == 2) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_ALGORITHM, "ss");
            }
        }
        if (this.lastSearchResultData.searchResults != null) {
            Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelIndex = getIntentIdToSearchIntentUIModelIndex();
            int i = 0;
            if (intentIdToSearchIntentUIModelIndex != null) {
                Iterator<ValuePair<String, Double>> it = this.lastSearchResultData.searchResults.iterator();
                while (it.hasNext()) {
                    List<SearchIntentUIModel> list = intentIdToSearchIntentUIModelIndex.get(it.next().first);
                    if (ListUtils.isNotEmpty(list)) {
                        i += list.size();
                    }
                }
            }
            hashMap.put(AnalyticsEventKey.SMART_INTENT_SEARCH_RESULT_COUNT, Integer.valueOf(i));
        }
        return hashMap;
    }

    private List<SmartIntentDTO> getRootToLeafIntents(long j) {
        ArrayList arrayList = new ArrayList();
        SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
        if (sITreeDTO == null) {
            return arrayList;
        }
        for (SmartIntentDTO smartIntentDTO : sITreeDTO.rootIntents) {
            for (SmartIntentDTO smartIntentDTO2 : smartIntentDTO.children) {
                if (smartIntentDTO2.localId.longValue() == j) {
                    arrayList.add(smartIntentDTO);
                    arrayList.add(smartIntentDTO2);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    private SmartIntentDTO getRootIntentDTO(long j) {
        SITreeDTO sITreeDTO = this.cachedSmartIntentTree;
        if (sITreeDTO == null) {
            return null;
        }
        for (SmartIntentDTO smartIntentDTO : sITreeDTO.rootIntents) {
            if (smartIntentDTO.localId.longValue() == j) {
                return smartIntentDTO;
            }
        }
        return null;
    }

    private void resetInternalStates() {
        this.lastSavedState = null;
        this.isShowingFakeTAI = false;
        this.isInitialized = false;
        this.backStackController.clear();
    }

    public boolean handleBackPressedForSmartIntent() {
        if (this.backStackController.isEmpty()) {
            return false;
        }
        HSLogger.d(TAG, "On user pressed back button");
        if (this.backStackController.isTopItemOfType(SmartIntentCollapsedRootViewState.class)) {
            return false;
        }
        BaseSmartIntentViewState popTopItem = this.backStackController.popTopItem();
        if (popTopItem instanceof SmartIntentSearchResultViewState) {
            Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
            searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, true);
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
        } else if (popTopItem instanceof SmartIntentLeafViewState) {
            SmartIntentDTO rootIntentDTO = getRootIntentDTO(((SmartIntentLeafViewState) popTopItem).parentIntentId);
            List singletonList = rootIntentDTO != null ? Collections.singletonList(rootIntentDTO.serverId) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("acid", this.activeConversation.acid);
            if (ListUtils.isNotEmpty(singletonList)) {
                hashMap.put(AnalyticsEventKey.SMART_INTENT_IDS, this.platform.getJsonifier().jsonifyListToJsonArray(singletonList));
            }
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_DESELECTION, hashMap);
        }
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem == null) {
            return false;
        }
        this.callback.updateSmartIntentView(topItem);
        return true;
    }

    public void onSmartIntentBottomSheetCollapsed() {
        HSLogger.d(TAG, "Smart intent bottom sheet state changed to collapsed mode");
        this.backStackController.popTopItem(SmartIntentExpandedRootViewState.class);
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            this.callback.updateSmartIntentView(topItem);
        }
    }

    public void onSmartIntentBottomSheetExpanded() {
        HSLogger.d(TAG, "Smart intent bottom sheet state changed to Expanded mode");
        BaseSmartIntentViewState topItem = this.backStackController.getTopItem();
        if (topItem instanceof SmartIntentCollapsedRootViewState) {
            SmartIntentExpandedRootViewState buildSmartIntentExpandedRootViewState = buildSmartIntentExpandedRootViewState((SmartIntentCollapsedRootViewState) topItem);
            if (this.backStackController.addItem(buildSmartIntentExpandedRootViewState)) {
                this.callback.updateSmartIntentView(buildSmartIntentExpandedRootViewState);
            }
        }
    }

    public BaseViewState getReplyButtonViewState() {
        return this.replyButtonViewState;
    }

    public BaseViewState getClearSearchButtonViewState() {
        return this.clearSearchViewState;
    }

    public ReplyFieldViewState getReplyFieldViewState() {
        return this.replyFieldViewState;
    }

    public void onSmartIntentTextChanged(CharSequence charSequence) {
        HSLogger.d(TAG, "On user query change");
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        this.replyFieldViewState.setReplyText(charSequence2);
        this.replyButtonViewState.setEnabled(!StringUtils.isEmpty(charSequence2));
        this.clearSearchViewState.setVisible(this.cachedSmartIntentTree.enforceIntentSelection && !StringUtils.isEmpty(charSequence2));
        if (this.skipSearchOnUserQueryChange) {
            this.skipSearchOnUserQueryChange = false;
            return;
        }
        SISearchResultDTO match = this.smartIntentDM.match(this.cachedSmartIntentTree, charSequence2);
        if (match != null) {
            updateUIOnSearchResultChange(match, charSequence2);
        }
    }

    private void updateUIOnSearchResultChange(SISearchResultDTO sISearchResultDTO, String str) {
        SmartIntentSearchResultViewState smartIntentSearchResultViewState;
        BaseSmartIntentViewState topItem;
        SISearchResultDTO sISearchResultDTO2;
        if (!sISearchResultDTO.isSearchPerformed) {
            if (!StringUtils.isEmpty(str) && (sISearchResultDTO2 = this.lastSearchResultData) != null && sISearchResultDTO2.isSearchPerformed) {
                Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
                searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, true);
                this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
            }
            if (this.backStackController.popTopItem(SmartIntentSearchResultViewState.class) != null && (topItem = this.backStackController.getTopItem()) != null) {
                this.callback.updateSmartIntentView(topItem);
            }
        } else {
            if (ListUtils.isEmpty(sISearchResultDTO.searchResults)) {
                smartIntentSearchResultViewState = new SmartIntentSearchResultViewState(this.cachedSmartIntentTree.emptySearchTitle, this.cachedSmartIntentTree.emptySearchDescription, this.cachedSmartIntentTree.enforceIntentSelection, Collections.emptyList());
            } else {
                smartIntentSearchResultViewState = new SmartIntentSearchResultViewState(this.cachedSmartIntentTree.searchTitle, "", this.cachedSmartIntentTree.enforceIntentSelection, convertToSearchIntentUIModelList(sISearchResultDTO.searchResults));
            }
            this.backStackController.popTopItem(SmartIntentSearchResultViewState.class);
            if (this.backStackController.addItem(smartIntentSearchResultViewState)) {
                this.callback.updateSmartIntentView(smartIntentSearchResultViewState);
            }
        }
        this.lastSearchResultData = sISearchResultDTO;
    }

    public void onSmartIntentSendButtonClick(String str) {
        if (StringUtils.userVisibleCharacterCount(str) < this.domain.getSDKConfigurationDM().getMinimumConversationDescriptionLength()) {
            this.callback.showSmartIntentReplyValidationFailedError();
            return;
        }
        this.callback.hideSmartIntentView();
        resetInternalStates();
        this.callback.createPreIssueFromSmartIntentSendButton(this.cachedSmartIntentTree.serverId, str);
        SISearchResultDTO sISearchResultDTO = this.lastSearchResultData;
        if (sISearchResultDTO == null || !sISearchResultDTO.isSearchPerformed) {
            return;
        }
        Map<String, Object> searchAnalyticsData = getSearchAnalyticsData();
        searchAnalyticsData.put(AnalyticsEventKey.SMART_INTENT_SEARCH_CLEAR, false);
        this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.SMART_INTENT_SEARCH_INTENT, searchAnalyticsData);
    }

    public boolean shouldShowSmartIntentFakeTypingIndicator() {
        return this.isShowingFakeTAI;
    }

    private void updateConversationReplyFooter(boolean z) {
        if (z) {
            this.callback.showReplyFooterFromSmartIntent();
        } else {
            this.callback.hideReplyFooterFromSmartIntent();
        }
    }

    private void showFakeTypingIndicator(boolean z) {
        this.isShowingFakeTAI = z;
        if (z) {
            this.callback.showFakeTypingIndicatorFromSmartIntent();
        } else {
            this.callback.hideFakeTypingIndicatorFromSmartIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTreeUnAvailable() {
        resetInternalStates();
        showFakeTypingIndicator(false);
        notifyShowReplyBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTreeAvailable(SITreeDTO sITreeDTO) {
        this.cachedSmartIntentTree = sITreeDTO;
        this.intentIdToSearchIntentUIModelMapping = null;
        showFakeTypingIndicator(false);
        showSmartIntentTreeInitialState(sITreeDTO);
        sendTreeShownEvent(sITreeDTO);
    }

    @Override // com.helpshift.conversation.smartintent.SmartIntentDMCallback
    public void onTreeAvailable(UserDM userDM, final SITreeDTO sITreeDTO) {
        if (this.userDM.getLocalId().equals(userDM.getLocalId())) {
            this.domain.runOnUI(new F() { // from class: com.helpshift.conversation.viewmodel.SmartIntentVM.1
                @Override // com.helpshift.common.domain.F
                public void f() {
                    SmartIntentVM.this.handleTreeAvailable(sITreeDTO);
                }
            });
        }
    }

    @Override // com.helpshift.conversation.smartintent.SmartIntentDMCallback
    public void onTreeUnAvailable(UserDM userDM) {
        if (this.userDM.getLocalId().equals(userDM.getLocalId())) {
            this.domain.runOnUI(new F() { // from class: com.helpshift.conversation.viewmodel.SmartIntentVM.2
                @Override // com.helpshift.common.domain.F
                public void f() {
                    SmartIntentVM.this.handleTreeUnAvailable();
                }
            });
        }
    }

    private void notifyShowReplyBox() {
        this.callback.showReplyFooterFromSmartIntent();
    }

    public SmartIntentSavedState buildInstanceSaveState() {
        if (this.isShowingFakeTAI) {
            return new SmartIntentSavedState(false, null, null, false, true);
        }
        if (!this.isInitialized || this.backStackController.isEmpty()) {
            return null;
        }
        String replyText = this.replyFieldViewState.getReplyText();
        boolean z = !this.backStackController.isTopItemOfType(SmartIntentCollapsedRootViewState.class);
        BaseSmartIntentViewState lastItemOfType = this.backStackController.getLastItemOfType(SmartIntentLeafViewState.class);
        return new SmartIntentSavedState(z, lastItemOfType instanceof SmartIntentLeafViewState ? Long.valueOf(((SmartIntentLeafViewState) lastItemOfType).parentIntentId) : null, replyText, this.backStackController.isTopItemOfType(SmartIntentSearchResultViewState.class), false);
    }

    public void onRestoreInstanceState(SmartIntentSavedState smartIntentSavedState) {
        this.lastSavedState = smartIntentSavedState;
    }

    private Map<String, List<SearchIntentUIModel>> getIntentIdToSearchIntentUIModelIndex() {
        Map<String, List<SearchIntentUIModel>> map = this.intentIdToSearchIntentUIModelMapping;
        if (map != null) {
            return map;
        }
        if (this.cachedSmartIntentTree == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (SmartIntentDTO smartIntentDTO : this.cachedSmartIntentTree.rootIntents) {
            ArrayList arrayList = new ArrayList();
            for (SmartIntentDTO smartIntentDTO2 : smartIntentDTO.children) {
                SearchIntentUIModel searchIntentUIModel = new SearchIntentUIModel(smartIntentDTO2.localId.longValue(), smartIntentDTO2.label, smartIntentDTO.label);
                hashMap.put(smartIntentDTO2.serverId, Collections.singletonList(searchIntentUIModel));
                arrayList.add(searchIntentUIModel);
            }
            hashMap.put(smartIntentDTO.serverId, arrayList);
        }
        this.intentIdToSearchIntentUIModelMapping = hashMap;
        return this.intentIdToSearchIntentUIModelMapping;
    }

    private List<SearchIntentUIModel> convertToSearchIntentUIModelList(List<ValuePair<String, Double>> list) {
        Map<String, List<SearchIntentUIModel>> intentIdToSearchIntentUIModelIndex = getIntentIdToSearchIntentUIModelIndex();
        ArrayList arrayList = new ArrayList();
        if (intentIdToSearchIntentUIModelIndex == null) {
            return arrayList;
        }
        int i = 1;
        for (ValuePair<String, Double> valuePair : list) {
            List<SearchIntentUIModel> list2 = intentIdToSearchIntentUIModelIndex.get(valuePair.first);
            if (ListUtils.isNotEmpty(list2)) {
                Iterator<SearchIntentUIModel> it = list2.iterator();
                while (it.hasNext()) {
                    SearchIntentUIModel deepClone = it.next().deepClone();
                    deepClone.rank = i;
                    deepClone.confidence = valuePair.second;
                    arrayList.add(deepClone);
                    i++;
                }
            }
        }
        return arrayList;
    }

    public boolean isSmartIntentUIVisible() {
        return this.isInitialized;
    }

    public void onDestroy() {
        this.smartIntentDM.unregisterSmartIntentDMCallback();
    }
}
