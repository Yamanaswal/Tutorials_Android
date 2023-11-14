package com.yaman.in_app_purchase_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ConsumeParams
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams

class MainActivity : AppCompatActivity(), PurchasesUpdatedListener {

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
        createInAppPurchaseBilling()
    }


    private fun createInAppPurchaseBilling() {
        //Create BillingClient
        val billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases()
            .build()

        //Start Connection.
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                    startPurchaseQuery(billingClient)
                }
            }

            override fun onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })


    }

    private fun startPurchaseQuery(billingClient: BillingClient) {
        val list = mutableListOf<QueryProductDetailsParams.Product>()
        list.add(
            QueryProductDetailsParams.Product.newBuilder()
                .setProductId("product_id_example")
                .setProductType(BillingClient.ProductType.INAPP)
                .build()
        )

        val queryProductDetailsParams =
            QueryProductDetailsParams.newBuilder()
                .setProductList(list)
                .build()

        billingClient.queryProductDetailsAsync(queryProductDetailsParams) { billingResult,
                                                                            productDetailsList ->
            // check billingResult
            // process returned productDetailsList
            val productDetailsParamsList = mutableListOf<BillingFlowParams.ProductDetailsParams>()

            for (productDetails in productDetailsList) {
                val billingObj = BillingFlowParams.ProductDetailsParams.newBuilder()
                    // retrieve a value for "productDetails" by calling queryProductDetailsAsync()
                    .setProductDetails(productDetails)
                    // to get an offer token, call ProductDetails.subscriptionOfferDetails()
                    // for a list of offers that are available to the user
//                    .setOfferToken(productDetails.subscriptionOfferDetails)
                    .build()

                productDetailsParamsList.add(billingObj)
            }

            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productDetailsParamsList)
                .build()

            // Launch the billing flow
            val billingResult = billingClient.launchBillingFlow(this, billingFlowParams)
        }


    }

    private val purchasesUpdatedListener =
        PurchasesUpdatedListener { billingResult, purchases ->
            Log.e("Error: ", "Code ${billingResult.responseCode.toString()}, MSG: ${billingResult.debugMessage.toString()}")
        }

    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: MutableList<Purchase>?) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                handlePurchase(purchase)
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
        } else {
            // Handle any other error codes.
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        val consumeParams =
            ConsumeParams.newBuilder()
                .setPurchaseToken(purchase.purchaseToken)
                .build()

    }


}