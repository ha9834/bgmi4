package com.helpshift.common.domain;

import com.helpshift.common.domain.PollFunction;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.poller.Delay;
import com.helpshift.common.poller.HttpBackoff;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Poller {
    private PollFunction activePollFunction;
    private final Domain domain;
    private final F poll;
    private HttpBackoff conservativeBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.of(5, TimeUnit.SECONDS)).setMaxInterval(Delay.of(1, TimeUnit.MINUTES)).setRandomness(0.1f).setMultiplier(2.0f).setRetryPolicy(getPollerRetryPollicy()).build();
    private HttpBackoff aggressiveBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.of(3, TimeUnit.SECONDS)).setMaxInterval(Delay.of(3, TimeUnit.SECONDS)).setRandomness(0.0f).setMultiplier(1.0f).setRetryPolicy(getPollerRetryPollicy()).build();
    private HttpBackoff passiveBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.of(30, TimeUnit.SECONDS)).setMaxInterval(Delay.of(5, TimeUnit.MINUTES)).setRandomness(0.1f).setMultiplier(4.0f).setRetryPolicy(getPollerRetryPollicy()).build();

    public Poller(Domain domain, F f) {
        this.domain = domain;
        this.poll = f;
    }

    public synchronized void start(PollingInterval pollingInterval, long j, PollFunction.PollFunctionListener pollFunctionListener) {
        stop();
        if (pollingInterval == null) {
            return;
        }
        switch (pollingInterval) {
            case AGGRESSIVE:
                this.activePollFunction = new PollFunction(this.domain, this.aggressiveBackoff, this.poll, PollingInterval.AGGRESSIVE, pollFunctionListener);
                break;
            case PASSIVE:
                this.activePollFunction = new PollFunction(this.domain, this.passiveBackoff, this.poll, PollingInterval.PASSIVE, pollFunctionListener);
                break;
            case CONSERVATIVE:
                this.activePollFunction = new PollFunction(this.domain, this.conservativeBackoff, this.poll, PollingInterval.CONSERVATIVE, pollFunctionListener);
                break;
        }
        this.activePollFunction.start(j);
    }

    public synchronized void stop() {
        if (this.activePollFunction != null) {
            this.activePollFunction.stop();
            this.activePollFunction = null;
        }
    }

    private HttpBackoff.RetryPolicy getPollerRetryPollicy() {
        return new HttpBackoff.RetryPolicy() { // from class: com.helpshift.common.domain.Poller.1
            @Override // com.helpshift.common.poller.HttpBackoff.RetryPolicy
            public boolean shouldRetry(int i) {
                return (i == NetworkErrorCodes.AUTH_TOKEN_NOT_PROVIDED.intValue() || i == NetworkErrorCodes.INVALID_AUTH_TOKEN.intValue() || NetworkErrorCodes.NOT_RETRIABLE_STATUS_CODES.contains(Integer.valueOf(i))) ? false : true;
            }
        };
    }
}
