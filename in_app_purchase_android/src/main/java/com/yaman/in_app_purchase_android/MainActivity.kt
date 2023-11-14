package com.yaman.in_app_purchase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    /**
     * Subscriptions automatically renew until they are canceled. A subscription can go through the following states:
     *
     * Active: User is in good standing and has access to the subscription.
     * Cancelled: User has cancelled but still has access until expiration.
     * In grace period: User experienced a payment issue but still has access while Google is retrying the payment method.
     * On hold: User experienced a payment issue and no longer has access while Google is retrying the payment method.
     * Paused: User paused their access and does not have access until they resume.
     * Expired: User has cancelled and lost access to the subscription. The user is considered churned at expiration.
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}