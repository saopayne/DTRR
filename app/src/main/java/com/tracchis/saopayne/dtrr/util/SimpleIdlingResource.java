package com.tracchis.saopayne.dtrr.util;


import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleIdlingResource implements IdlingResource {

    private final AtomicInteger counter = new AtomicInteger(0);
    private ResourceCallback mResourceCallback;

    @Override
    public String getName() {
        return "TEST";
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override
    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback callback) {
        mResourceCallback = callback;
    }

    public void increment() {
        counter.getAndIncrement();
    }

    public void decrement() {
        int counterVal = counter.decrementAndGet();
        if (counterVal == 0) {
            // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
            if (null != mResourceCallback) {
                mResourceCallback.onTransitionToIdle();
            }
        }

        if (counterVal < 0) {
            throw new IllegalArgumentException("Counter has been corrupted!");
        }
    }
}
