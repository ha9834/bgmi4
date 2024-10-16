package com.helpshift.support.controllers;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.helpshift.R;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationSetupDM;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.ConversationDetailDTO;
import com.helpshift.support.contracts.AttachmentPreviewListener;
import com.helpshift.support.contracts.SearchResultListener;
import com.helpshift.support.contracts.SupportScreenView;
import com.helpshift.support.conversations.AuthenticationFailureFragment;
import com.helpshift.support.conversations.BaseConversationFragment;
import com.helpshift.support.conversations.ConversationalFragment;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.conversations.usersetup.ConversationSetupFragment;
import com.helpshift.support.flows.CustomContactUsFlowListHolder;
import com.helpshift.support.flows.DynamicFormFlowListHolder;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.fragments.DynamicFormFragment;
import com.helpshift.support.fragments.FaqFlowFragment;
import com.helpshift.support.fragments.SearchResultFragment;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.support.util.SupportNotification;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SupportController implements AttachmentPreviewListener, SearchResultListener {
    private static final String TAG = "Helpshift_SupportContr";
    private final Bundle bundle;
    private final Context context;
    private boolean conversationAddToBackStack;
    private Bundle conversationBundle;
    private FragmentManager fragmentManager;
    private boolean isControllerStarted;
    private String sourceSearchQuery;
    private int supportMode;
    private final SupportScreenView supportScreenView;
    private final String KEY_SUPPORT_CONTROLLER_STARTED_STATE = "key_support_controller_started";
    private final String KEY_CONVERSATION_BUNDLE = "key_conversation_bundle";
    private final String KEY_CONVERSATION_ADD_TO_BACK_STACK = "key_conversation_add_to_back_stack";
    private boolean searchPerformed = false;

    public SupportController(Context context, SupportScreenView supportScreenView, FragmentManager fragmentManager, Bundle bundle) {
        this.context = context;
        this.supportScreenView = supportScreenView;
        this.fragmentManager = fragmentManager;
        this.bundle = bundle;
    }

    public void onFragmentManagerUpdate(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void setSearchPerformed(boolean z) {
        this.searchPerformed = z;
    }

    public void start() {
        if (!this.isControllerStarted) {
            this.supportMode = this.bundle.getInt(SupportFragment.SUPPORT_MODE, 0);
            int i = this.supportMode;
            if (i == 1) {
                startConversationFlow(this.bundle, false);
            } else if (i == 4) {
                startDynamicForm(DynamicFormFlowListHolder.getFlowList(), false);
            } else {
                startFaqFlow(this.bundle, false, CustomContactUsFlowListHolder.getFlowList());
            }
        }
        this.isControllerStarted = true;
    }

    private void replaceConversationFlow(Bundle bundle) {
        Long valueOf = Long.valueOf(bundle.getLong(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID));
        Bundle bundle2 = this.conversationBundle;
        boolean equals = valueOf.equals(bundle2 != null ? Long.valueOf(bundle2.getLong(ConversationalFragment.BUNDLE_ARG_CONVERSATION_LOCAL_ID)) : null);
        boolean z = true;
        boolean z2 = !equals;
        List<Fragment> g = this.fragmentManager.g();
        if (z2) {
            clearConversationStack();
        } else if (g.size() > 0) {
            Fragment fragment = g.get(g.size() - 1);
            if (fragment instanceof AttachmentPreviewFragment) {
                return;
            }
            if (fragment instanceof BaseConversationFragment) {
                z = false;
            }
        }
        if (z) {
            this.conversationBundle = bundle;
            startConversationFlow();
        }
    }

    public void startConversationFlow(Bundle bundle, boolean z) {
        this.conversationAddToBackStack = z;
        this.conversationBundle = bundle;
        startConversationFlow();
    }

    public void startConversationFlow() {
        startConversationFlow(new HashMap());
    }

    public void startConversationFlow(Map<String, Boolean> map) {
        HelpshiftContext.getCoreApi();
        switch (new ConversationSetupDM(HelpshiftContext.getPlatform(), r0.getConfigFetchDM(), r0.getUserManagerDM().getActiveUserSetupDM()).getState()) {
            case NOT_STARTED:
            case IN_PROGRESS:
            case FAILED:
                showConversationSetupFragment();
                return;
            case COMPLETED:
                startConversationFlowInternal(map);
                return;
            default:
                return;
        }
    }

    private void startConversationFlowInternal(Map<String, Boolean> map) {
        String h;
        Conversation activeConversationOrPreIssue;
        if (this.conversationBundle == null) {
            this.conversationBundle = this.bundle;
        }
        boolean z = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION);
        Long l = null;
        if (HelpshiftContext.getCoreApi().getSDKConfigurationDM().shouldShowConversationHistory() && !z) {
            showConversationFragment(true, null, map);
            return;
        }
        long j = this.conversationBundle.getLong(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID, 0L);
        if (j != 0) {
            this.conversationBundle.remove(SupportNotification.BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID);
            if (HelpshiftContext.getCoreApi().getConversationController().shouldOpenConversationFromNotification(j)) {
                showConversationFragment(false, Long.valueOf(j), map);
                return;
            }
        }
        if (!z && (activeConversationOrPreIssue = HelpshiftContext.getCoreApi().getActiveConversationOrPreIssue()) != null) {
            l = activeConversationOrPreIssue.localId;
        }
        if (l == null) {
            List<Flow> flowList = CustomContactUsFlowListHolder.getFlowList();
            if (flowList == null || flowList.isEmpty()) {
                showNewConversationFragment();
                return;
            }
            FragmentManager.a b = getFragmentManager().b(this.fragmentManager.f() - 1);
            if (b != null && (h = b.h()) != null && h.equals(ConversationalFragment.class.getName())) {
                FragmentUtil.popBackStackImmediate(this.fragmentManager, h);
            }
            startDynamicForm(flowList, true);
            return;
        }
        showConversationFragment(false, l, map);
    }

    public void onAuthenticationFailure() {
        showAuthenticationFailureFragment();
    }

    private void showAuthenticationFailureFragment() {
        HSLogger.d(TAG, "Starting authentication failure fragment");
        AuthenticationFailureFragment newInstance = AuthenticationFailureFragment.newInstance();
        String name = this.conversationAddToBackStack ? newInstance.getClass().getName() : null;
        clearConversationStack();
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, newInstance, AuthenticationFailureFragment.FRAGMENT_TAG, name, false, false);
    }

    public void showConversationSetupFragment() {
        String str;
        HSLogger.d(TAG, "Starting conversation setup fragment.");
        ConversationSetupFragment newInstance = ConversationSetupFragment.newInstance();
        if (this.conversationAddToBackStack) {
            String name = newInstance.getClass().getName();
            clearConversationStack();
            str = name;
        } else {
            str = null;
        }
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, newInstance, ConversationSetupFragment.FRAGMENT_TAG, str, false, false);
    }

    public void startFaqFlow(Bundle bundle, boolean z, List<Flow> list) {
        if (isDuplicateFAQScreenAlreadyOpen(bundle)) {
            return;
        }
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, FaqFlowFragment.newInstance(bundle, list), FaqFlowFragment.FRAGMENT_TAG, z ? FaqFlowFragment.class.getName() : null, false, false);
    }

    private boolean isDuplicateFAQScreenAlreadyOpen(Bundle bundle) {
        FaqFlowController faqFlowController;
        Fragment topMostFragment = FragmentUtil.getTopMostFragment(this.fragmentManager);
        if (!(topMostFragment instanceof FaqFlowFragment) || (faqFlowController = ((FaqFlowFragment) topMostFragment).getFaqFlowController()) == null) {
            return false;
        }
        Fragment topMostFaqFragment = faqFlowController.getTopMostFaqFragment();
        if (!(topMostFaqFragment instanceof SingleQuestionFragment)) {
            return true;
        }
        String string = bundle.getString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID);
        return string != null && string.equals(((SingleQuestionFragment) topMostFaqFragment).getQuestionPublishId());
    }

    private void showNewConversationFragment() {
        String str;
        HSLogger.d(TAG, "Starting new conversation fragment");
        this.conversationBundle.putBoolean(NewConversationFragment.SEARCH_PERFORMED, this.searchPerformed);
        this.conversationBundle.putString(NewConversationFragment.SOURCE_SEARCH_QUERY, this.sourceSearchQuery);
        NewConversationFragment newInstance = NewConversationFragment.newInstance(this.conversationBundle);
        if (this.conversationAddToBackStack) {
            String name = newInstance.getClass().getName();
            clearConversationStack();
            str = name;
        } else {
            str = null;
        }
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, newInstance, NewConversationFragment.FRAGMENT_TAG, str, false, false);
    }

    private void showConversationFragment(boolean z, Long l, Map<String, Boolean> map) {
        String str;
        HSLogger.d(TAG, "Starting conversation fragment: " + l);
        if (!z) {
            if (l == null) {
                return;
            } else {
                this.conversationBundle.putLong(ConversationalFragment.BUNDLE_ARG_CONVERSATION_LOCAL_ID, l.longValue());
            }
        }
        this.conversationBundle.putBoolean(ConversationalFragment.BUNDLE_ARG_SHOW_CONVERSATION_HISTORY, z);
        for (String str2 : map.keySet()) {
            this.conversationBundle.putBoolean(str2, map.get(str2).booleanValue());
        }
        ConversationalFragment newInstance = ConversationalFragment.newInstance(this.conversationBundle);
        if (this.conversationAddToBackStack) {
            String name = newInstance.getClass().getName();
            clearConversationStack();
            str = name;
        } else {
            str = null;
        }
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, newInstance, ConversationalFragment.FRAGMENT_TAG, str, false, false);
    }

    public void showConversationSearchResultFragment(Bundle bundle) {
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, R.id.flow_fragment_container, SearchResultFragment.newInstance(bundle, this), SearchResultFragment.FRAGMENT_TAG, false);
    }

    public void startScreenshotPreviewFragment(AttachmentPickerFile attachmentPickerFile, Bundle bundle, AttachmentPreviewFragment.LaunchSource launchSource) {
        AttachmentPreviewFragment screenshotPreviewFragment = FragmentUtil.getScreenshotPreviewFragment(getFragmentManager());
        if (screenshotPreviewFragment == null) {
            screenshotPreviewFragment = AttachmentPreviewFragment.newInstance(this);
            FragmentUtil.startFragmentWithBackStack(getFragmentManager(), R.id.flow_fragment_container, screenshotPreviewFragment, AttachmentPreviewFragment.FRAGMENT_TAG, false);
        }
        screenshotPreviewFragment.setParams(bundle, attachmentPickerFile, launchSource);
    }

    public void startDynamicForm(List<Flow> list, boolean z) {
        FragmentUtil.startFragment(this.fragmentManager, R.id.flow_fragment_container, DynamicFormFragment.newInstance(this.bundle, list, this), DynamicFormFragment.FRAGMENT_TAG, z ? DynamicFormFragment.class.getName() : null, false, false);
    }

    public void startDynamicForm(String str, List<Flow> list, boolean z) {
        Bundle bundle = this.bundle;
        if (bundle != null) {
            bundle.putString(SupportFragmentConstants.FLOW_TITLE, str);
        }
        startDynamicForm(list, z);
    }

    public void startDynamicForm(int i, List<Flow> list, boolean z) {
        Bundle bundle = this.bundle;
        if (bundle != null && i != 0) {
            bundle.putString(SupportFragmentConstants.FLOW_TITLE, this.context.getResources().getString(i));
        }
        startDynamicForm(list, z);
    }

    public int getSupportMode() {
        return this.supportMode;
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public void onContactUsClicked(String str) {
        if (handleCustomContactUsFlows()) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.sourceSearchQuery = str;
        }
        startConversationFlow(this.bundle, true);
    }

    private boolean handleCustomContactUsFlows() {
        FaqFlowFragment faqFlowFragment;
        List<Flow> customContactUsFlows;
        if (HelpshiftContext.getCoreApi().getActiveConversation() != null || (faqFlowFragment = FragmentUtil.getFaqFlowFragment(this.fragmentManager)) == null || (customContactUsFlows = faqFlowFragment.getCustomContactUsFlows()) == null || customContactUsFlows.isEmpty()) {
            return false;
        }
        startDynamicForm(customContactUsFlows, true);
        return true;
    }

    public void actionDone() {
        sendTicketAvoidedEvent();
        Long localId = HelpshiftContext.getCoreApi().getUserManagerDM().getActiveUser().getLocalId();
        HelpshiftContext.getPlatform().getConversationInboxDAO().saveDescriptionDetail(localId.longValue(), new ConversationDetailDTO("", System.nanoTime(), 0));
        HelpshiftContext.getPlatform().getConversationInboxDAO().saveImageAttachment(localId.longValue(), null);
        if (getSupportMode() == 1) {
            this.supportScreenView.exitSdkSession();
        } else {
            FragmentUtil.popBackStackImmediate(getFragmentManager(), NewConversationFragment.class.getName());
        }
    }

    private void sendTicketAvoidedEvent() {
        SingleQuestionFragment singleQuestionFragment = FragmentUtil.getSingleQuestionFragment(this.fragmentManager);
        if (singleQuestionFragment != null) {
            String questionId = singleQuestionFragment.getQuestionId();
            if (TextUtils.isEmpty(questionId)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("id", questionId);
            ConversationDetailDTO descriptionDetail = HelpshiftContext.getPlatform().getConversationInboxDAO().getDescriptionDetail(HelpshiftContext.getCoreApi().getUserManagerDM().getActiveUser().getLocalId().longValue());
            if (descriptionDetail != null) {
                hashMap.put(AnalyticsEventKey.STR, descriptionDetail.title);
            }
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.TICKET_AVOIDED, hashMap);
        }
    }

    @Override // com.helpshift.support.contracts.SearchResultListener
    public void onQuestionSelected(String str, ArrayList<String> arrayList) {
        boolean isTablet = Styles.isTablet(this.context);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, str);
        if (arrayList != null) {
            this.bundle.putStringArrayList("searchTerms", arrayList);
        }
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, R.id.flow_fragment_container, SingleQuestionFragment.newInstance(this.bundle, 2, isTablet, null), null, false);
    }

    @Override // com.helpshift.support.contracts.SearchResultListener
    public void sendAnyway() {
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.TICKET_AVOIDANCE_FAILED);
        FragmentUtil.popBackStackImmediate(getFragmentManager(), SearchResultFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.b(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.startNewConversation();
        }
    }

    public void onAdminSuggestedQuestionSelected(String str, String str2, String str3, SingleQuestionFragment.QuestionReadListener questionReadListener) {
        boolean isTablet = Styles.isTablet(this.context);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, str);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_LANGUAGE, str2);
        this.bundle.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_SOURCE, str3);
        Bundle bundle = new Bundle(this.bundle);
        bundle.putBoolean(SupportFragmentConstants.DECOMPOSED, true);
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, R.id.flow_fragment_container, SingleQuestionFragment.newInstance(bundle, 3, isTablet, questionReadListener), null, false);
    }

    @Override // com.helpshift.support.contracts.AttachmentPreviewListener
    public void addAttachment(AttachmentPickerFile attachmentPickerFile) {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.b(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.ADD, attachmentPickerFile);
        }
    }

    @Override // com.helpshift.support.contracts.AttachmentPreviewListener
    public void sendAttachment(AttachmentPickerFile attachmentPickerFile, String str) {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        ConversationalFragment conversationalFragment = (ConversationalFragment) this.fragmentManager.b(ConversationalFragment.FRAGMENT_TAG);
        if (conversationalFragment != null) {
            conversationalFragment.handleAttachmentAction(AttachmentPreviewFragment.AttachmentAction.SEND, attachmentPickerFile, str);
        }
    }

    @Override // com.helpshift.support.contracts.AttachmentPreviewListener
    public void removeAttachment() {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.b(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.REMOVE, null);
        }
    }

    @Override // com.helpshift.support.contracts.AttachmentPreviewListener
    public void changeAttachment(Bundle bundle) {
        this.supportScreenView.launchAttachmentPicker(bundle);
        NewConversationFragment newConversationFragment = (NewConversationFragment) this.fragmentManager.b(NewConversationFragment.FRAGMENT_TAG);
        if (newConversationFragment != null) {
            newConversationFragment.handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction.REMOVE, null);
        }
    }

    @Override // com.helpshift.support.contracts.AttachmentPreviewListener
    public void removeAttachmentPreviewFragment() {
        FragmentUtil.popBackStack(this.fragmentManager, AttachmentPreviewFragment.class.getName());
    }

    public void onNewIntent(Bundle bundle) {
        int i = bundle.getInt(SupportFragment.SUPPORT_MODE);
        if (i == 1) {
            replaceConversationFlow(bundle);
        } else if (i == 4) {
            startDynamicForm(bundle.getString(SupportFragmentConstants.FLOW_TITLE), DynamicFormFlowListHolder.getFlowList(), true);
        } else {
            startFaqFlow(bundle, true, CustomContactUsFlowListHolder.getFlowList());
        }
    }

    private void clearConversationStack() {
        boolean z;
        List<Fragment> g = this.fragmentManager.g();
        for (int size = g.size() - 1; size >= 0; size--) {
            Fragment fragment = g.get(size);
            if ((fragment instanceof AttachmentPreviewFragment) || (fragment instanceof BaseConversationFragment) || (fragment instanceof ConversationSetupFragment) || (fragment instanceof AuthenticationFailureFragment)) {
                if (size == 0) {
                    FragmentUtil.removeFragment(this.fragmentManager, fragment);
                    List<Fragment> g2 = this.fragmentManager.g();
                    if (g2 != null && g2.size() > 0) {
                        FragmentUtil.popBackStack(this.fragmentManager, fragment.getClass().getName());
                    }
                } else {
                    FragmentUtil.popBackStack(this.fragmentManager, fragment.getClass().getName());
                }
            }
        }
        Fragment b = this.fragmentManager.b(ConversationalFragment.FRAGMENT_TAG);
        if (b != null) {
            FragmentUtil.popBackStackImmediate(this.fragmentManager, b.getClass().getName());
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.conversationAddToBackStack = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("key_support_controller_started", this.isControllerStarted);
        bundle.putBundle("key_conversation_bundle", this.conversationBundle);
        bundle.putBoolean("key_conversation_add_to_back_stack", this.conversationAddToBackStack);
    }

    public void onViewStateRestored(Bundle bundle) {
        if (this.isControllerStarted) {
            return;
        }
        if (bundle.containsKey("key_support_controller_started")) {
            this.isControllerStarted = bundle.containsKey("key_support_controller_started");
            this.supportMode = this.bundle.getInt(SupportFragment.SUPPORT_MODE, 0);
            FragmentManager fragmentManager = this.fragmentManager;
            if (fragmentManager != null) {
                AttachmentPreviewFragment attachmentPreviewFragment = (AttachmentPreviewFragment) fragmentManager.b(AttachmentPreviewFragment.FRAGMENT_TAG);
                if (attachmentPreviewFragment != null) {
                    attachmentPreviewFragment.setAttachmentPreviewListener(this);
                }
                SearchResultFragment searchResultFragment = (SearchResultFragment) this.fragmentManager.b(SearchResultFragment.FRAGMENT_TAG);
                if (searchResultFragment != null) {
                    searchResultFragment.setSearchResultListener(this);
                }
                DynamicFormFragment dynamicFormFragment = (DynamicFormFragment) this.fragmentManager.b(DynamicFormFragment.FRAGMENT_TAG);
                if (dynamicFormFragment != null) {
                    dynamicFormFragment.setSupportController(this);
                }
            }
        }
        if (bundle.containsKey("key_conversation_bundle") && bundle.containsKey("key_conversation_add_to_back_stack")) {
            this.conversationBundle = bundle.getBundle("key_conversation_bundle");
            this.conversationAddToBackStack = bundle.getBoolean("key_conversation_add_to_back_stack");
        }
    }

    public void onConversationSetupCompleted() {
        startConversationFlowInternal(new HashMap());
    }
}
