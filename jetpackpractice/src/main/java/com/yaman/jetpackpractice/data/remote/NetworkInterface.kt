package com.yaman.jetpackpractice.data.remote

import com.yaman.jetpackpractice.BuildConfig
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url
interface NetworkInterface {
    @POST(API.getchangedetecter)
    fun getchangedetector(@Body data: String?): Call<String?>?

    @POST(API.get_video_link_concept)
    fun get_video_link_concept(@Body data: String?): Call<String?>?

    @POST(API.create_annotation)
    fun create_annotation(@Body data: String?): Call<String?>?

    @POST(API.delete_annotation)
    fun delete_annotation(@Body data: String?): Call<String?>?

    @POST(API.add_video_index)
    fun addvideoindex(@Body data: String?): Call<String?>?

    @POST(API.delete_video_index)
    fun deletevideoindex(@Body data: String?): Call<String?>?

    @POST(API.submitpoll)
    fun sendpoll(@Body data: String?): Call<String?>?

    @POST(API.API_activate_course)
    fun API_activate_course(@Body data: String?): Call<String?>?

    @POST(API.mark_as_read)
    fun setread(@Body data: String?): Call<String?>?

    @POST(API.mark_as_allread)
    fun MarkAllRead(@Body data: String?): Call<String?>?

    @POST(API.delete_notification)
    fun DeleteNotification(@Body data: String?): Call<String?>?

    @POST(API.API_SUBJECTIVE_SUBMIT)
    fun API_SUBJECTIVE_SUBMIT(@Body body: String?): Call<String?>?

    @POST(API.API_subjective_result)
    fun API_subjective_result(@Body body: String?): Call<String?>?

    @POST(API.get_meta)
    fun getmeta(@Body data: String?): Call<String?>?

    @POST(API.get_meta)
    fun getmetaData(@Body data: String?): Call<String?>?

    @POST(API.get_video_link)
    fun getVideoLink(@Body data: String?): Call<String?>?

    @POST(API.get_video_logging)
    fun get_video_logging(@Body data: String?): Call<String?>?

    @POST(API.get_sign_test_link)
    fun getvideo_test_link(@Body data: String?): Call<String?>?

    @POST(API.get_notification_data)
    fun getNotification(@Body data: String?): Call<String?>?

    @POST(API.API_SUBMIT_TEST_SERIES)
    fun submitTestSeries(@Body body: String?): Call<String?>?

    @POST(API.API_SUBMIT_TEST_LATER)
    fun submitTestSeriesLater(@Body body: String?): Call<String?>?

    @POST(API.challenge_submission)
    fun challenge_submission(@Body body: String?): Call<String?>?

    @POST(API.API_SUBMIT_QUERY)
    fun getresponseofsubmitquery(@Body body: String?): Call<String?>?

    @POST(API.API_TEST_RESULT)
    fun getTestResult(@Body body: String?): Call<String>?

    @POST(API.API_TEST_LEADERBOARD)
    fun get_test_leaderboard(@Body body: String?): Call<String?>?

    @POST(API.API_TEST_LEARN)
    fun getTestlearn(@Body body: String?): Call<String?>?


    @POST(API.verifyCoupon)
    fun verifyCoupon(@Body body: String?): Call<String?>?

    @POST(API.delete_revision)
    fun delete_revision(@Body body: String?): Call<String?>?

    @POST(API.API_GET_TEST_INSTRUCTION_DATA)
    fun API_GET_TEST_INSTRUCTION_DATA(@Body body: String?): Call<String>

    @POST(API.API_GET_INFO_TEST_SERIES)
    fun API_GET_INFO_TEST_SERIES(@Body body: String?): Call<String>

    @POST(API.API_GET_SOLUTION_TESTSERIES)
    fun API_GET_SOLUTION_TESTSERIES(@Body body: String?): Call<String?>?

    @POST(API.API_CREATE_TEST_RETRIVE_COURSE)
    fun API_CREATE_TEST_RETRIVE_COURSE(@Body data: String?): Call<String?>?

    @POST(API.API_CREATE_TEST_GET_SUBJECT)
    fun API_CREATE_TEST_GET_SUBJECT(@Body data: String?): Call<String?>?

    @POST(API.API_CREATE_TEST_GET_QUES_COUNT)
    fun API_CREATE_TEST_GET_QUES_COUNT(@Body data: String?): Call<String?>?

    @POST(API.API_CREATE_TEST_GET_TEST)
    fun API_CREATE_TEST_GET_TEST(@Body data: String?): Call<String?>?

    @POST(API.API_GET_EXTRA_CLASS_DATA)
    fun getExtraClassData(@Body data: String?): Call<String>


    @POST(API.user_logout)
    fun getUserLogout(@Body data: String?): Call<String?>?

    @POST(API.COURSE_CART_COUNT)
    fun getCartCount(@Body data: String?): Call<String?>?

    @POST(API.get_file_names)
    fun get_file_names(@Body data: String?): Call<String?>?


    @POST(API.get_folder_list)
    fun get_folder_list(@Body data: String?): Call<String>


    @POST(API.GET_USER_ADDRESS)
    fun GET_USER_ADDRESS(@Body data: String?): Call<String>

    @POST(API.SAVE_USER_ADDRESS)
    fun SAVE_USER_ADDRESS(@Body data: String?): Call<String>

    @POST(API.DELETE_USER_ADDRESS)
    fun DELETE_USER_ADDRESS(@Body data: String?): Call<String>

    @POST(API.get_liveclasses_data)
    fun getLiveClassesData(@Body data: String?): Call<String?>?

    @POST(API.GET_MY_QUIRES)
    fun getMyHelpQuires(@Body data: String?): Call<String?>?


    @POST(API.COURSE_CONTENT_SEARCH)
    fun getCourseOrContentData(@Body data: String?): Call<String?>?

    @POST(API.GET_SUBMIT_MY_QUIRES)
    fun submitHelpQuires(@Body data: String?): Call<String?>?

    @POST(API.GET_QUIRES_REPLIES)
    fun getQuiresReply(@Body data: String?): Call<String?>?

    @POST(API.GET_SUBMIT_QUIRES_REPLIES)
    fun sendSupportQuiry(@Body data: String?): Call<String?>?

    @POST(API.get_testclasses_data)
    fun getLiveTestsData(@Body data: String?): Call<String?>?

    @POST(API.apply_coupon)
    fun apply_coupon(@Body data: String?): Call<String?>?

    @POST(API.int_payment)
    fun int_payment(@Body data: String?): Call<String>

    @POST(API.remove_course)
    fun remove_course(@Body data: String?): Call<String?>?

    @POST(API.free_transaction)
    fun free_transaction(@Body data: String?): Call<String?>?

//    @POST(API.payment_gateway_credentials)
//    fun payment_gateway_credentials(@Body data: String?): Call<String>?
//
//    @POST(API.payment_gateway_credentials)
//    fun payment_gateway_credentials_forEmi(@Body data: String?): Call<String>

    @POST(API.payment_gateway_credentials)
    suspend fun payment_gateway_credentials_suspend(@Body data: String?): Response<String>

    @POST(API.free_transaction_layer1)
    fun free_transaction_course(@Body data: String?): Call<String?>?

    @POST(API.get_filter_data)
    fun getFilterData(@Body data: String?): Call<String?>?

    @POST(API.get_demo_data)
    fun getvideo(@Body data: String?): Call<String?>?

    @POST(API.API_UPDATE_MOBILE_NUMBER)
    fun updateMobileNumber(@Body data: String?): Call<String?>?

    @POST(API.API_GET_BOOKMARK_LIST)
    fun getBookmarkList(@Body data: String?): Call<String>

    @POST(API.API_ADD_TO_BOOKMARK)
    fun addPdfBookMark(@Body body: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_UPDATE_MOBILE_NUMBER)
    Call<String> updateMobileNumber(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                    @Field(Const.MOBILE) String MOBILE,
                                    @Field(Const.OTP) String OTP);*/
    @POST(API.API_DELETE_USER_ACCOUNT)
    fun deleteUserAccount(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_DELETE_USER_ACCOUNT)
    Call<String> deleteUserAccount(@Field(Const.USER_ID) String USER_ID,
                                    @Field(Const.REASON) String REASON);*/
    @POST(API.API_MOBILE_MENU)
    fun getMobileMenu(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_MOBILE_MENU)
    Call<String> getMobileMenu(@Field("id") String id);*/
    @POST(API.GET_MY_QUIRES)
    fun getMyQuires(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.GET_MY_QUIRES)
    Call<String> getMyQuires(@Field(Const.USER_ID) String USER_ID);*/
    @POST(API.API_GET_MASTER_REGISTRATION_HIT)
    fun getMasterRegistrationHit(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_REGISTRATION_HIT)
    Call<String> getMasterRegistrationHit(@Field("id") String id);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_NOTIFICATION_COUNT)
    Call<String> getNotificationCount(@Field(Const.USER_ID) String userId);*/
    @POST(API.API_GET_NOTIFICATION_COUNT)
    fun getNotificationCount(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_HIT)
    Call<String> getMasterHit(*/
    /*@Field(Const.USER_ID) String userId,*/ /*
                              @Field(Const.DEVICE_TOKEN) String deviceToken);*/
    @POST(API.API_GET_MASTER_HIT)
    fun getMasterHit(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_APP_VERSION)
    Call<String> getAppVersion(@Field("id") String userId);*/
    @get:GET(API.API_GET_APP_VERSION)
    val appVersion: Call<String>

    @POST(API.API_USER_PROFILE_WITH_TOKEN)
    fun getUserProfileWithToken(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_UPDATE_BANNER_HIT_COUNT)
    Call<String> updateBannerHitCount(@Field(Const.BANNER_ID) String bannerId);*/
    @POST(API.API_UPDATE_BANNER_HIT_COUNT)
    fun updateBannerHitCount(@Body data: String?): Call<String?>?

    @POST(API.API_GET_LIVE_STREAM)
    fun getLiveStream(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_HIT)
    fun getMasterHits(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_HIT)
    Call<String> getMasterHits(*/
    /*@Field(Const.USER_ID) String userId,*/ /*@Field(Const.SUB_CAT) String subCatId);*/
    @GET
    fun getUser(@Url url: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_MOBILE_BANNER)
    Call<String> getMobileBanner(@Field("id") String id);*/
    @POST(API.API_MOBILE_BANNER)
    fun getMobileBanner(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_ALL_CATEGORY_DATA_EXAM)
    Call<String> getAllCategoryDataExam(*/
    /*@Field(Const.USER_ID) String userId,*/ /*
                                        @Field(Const.COURSE_TYPE) String courseType,
                                        @Field(Const.CAT_ID) String catId,
                                        @Field(Const.SUB_CAT) String subCatId,
                                        @Field(Const.STUDY_TYPE) String STUDY_TYPE);*/
    @POST(API.API_GET_ALL_CATEGORY_DATA_EXAM)
    fun getAllCategoryDataExam(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_LANDING_PAGE_DATA)
    Call<String> getLandingPageData(@Field(Const.USER_ID) String USER_ID);*/
    @get:GET(API.API_GET_LANDING_PAGE_DATA)
    val landingPageData: Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_ALL_CATEGORY_DATA)
    Call<String> getAllCategoryData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                    @Field(Const.CATEGORY_ID) String CATEGORY_ID);*/
    @POST(API.API_GET_ALL_CATEGORY_DATA)
    fun getAllCategoryData(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_ALL_CATEGORY_DATA)
    Call<String> getAllCategoryDataSub(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                       @Field(Const.SUB_CAT) String SUB_CAT);*/
    @POST(API.API_GET_ALL_CATEGORY_DATA)
    fun getAllCategoryDataSub(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_ALL_CATEGORY_DATA)
    Call<String> getAllCategoryDataSub(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                       @Field(Const.SUB_CAT) String SUB_CAT,
                                       @Field(Const.STUDY_TYPE) String STUDY_TYPE);*/
    @POST(API.API_COURSE_META_ALL)
    fun getAllStudyData(@Body data: String?): Call<String?>?


    /*@FormUrlEncoded
    @POST(API.API_GET_MY_COURSE_DATA)
    Call<String> getMyCourseData(@Field(Const.USER_ID) String USER_ID);*/
    @get:GET(API.API_GET_MY_COURSE_DATA)
    val myCourseData: Call<String?>?

    @POST(API.API_APPLY_COUPON_CODE)
    fun getApplyCouponCode(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_APPLY_COUPON_CODE)
    Call<String> getApplyCouponCode(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                    @Field(Const.COURSE_ID) String COURSE_ID,
                                    @Field(Const.COUPON_CODE) String COUPON_CODE);*/
    @POST(API.API_INITIALIZE_COURSE_PAYMENT)
    fun initializeCoursePayment(@Body data: String?): Call<String?>?

    @POST(API.API_COMPLETE_COURSE_PAYMENT)
    fun completeCoursePayment(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_COMPLETE_COURSE_PAYMENT)
    Call<String> completeCoursePayment(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                       @Field(Const.COURSE_ID) String COURSE_ID,
                                       @Field(Const.TRANSACTION_STATUS) String TRANSACTION_STATUS,
                                       @Field(Const.COURSE_INIT_PAYMENT_TOKEN) String COURSE_INIT_PAYMENT_TOKEN,
                                       @Field(Const.COURSE_FINAL_PAYMENT_TOKEN) String COURSE_FINAL_PAYMENT_TOKEN);*/
    @FormUrlEncoded
    @POST(API.API_FINAL_TRANSACTION_FOR_PAYTM)
    fun finalTransactionForPaytm( /*@Field(Const.USER_ID) String USER_ID,
                                        @Field(Const.COURSE_ID) String COURSE_ID,
                                        @Field(Const.COURSE_INIT_PAYMENT_TOKEN) String COURSE_INIT_PAYMENT_TOKEN,
                                        @Field(Const.COURSE_FINAL_PAYMENT_TOKEN) String COURSE_FINAL_PAYMENT_TOKEN*/
    ): Call<String?>?

    @POST(API.API_GET_REWARD_POINTS_NEW)
    fun getRewardPointsNew(@Body data: String?): Call<String>?

    @POST(API.API_MAKE_FREE_COURSE_TRANSACTION)
    fun makeFreeCourseTransaction(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_DAILY_DOSE)
    Call<String> dailyDose(@Field(Const.USER_ID) String USER_ID,
                           @Field(Const.MENU_ID) String MENU_ID);*/
    @POST(API.API_DAILY_DOSE)
    fun dailyDose(@Body MENU_ID: String?): Call<String?>?

    @get:GET(API.API_USER_LOGOUT_WITH_TOKEN)
    val logoutUser: Call<String?>?

    @get:GET(API.API_GET_USER)
    val user: Call<String?>?

    @POST(API.API_UPDATE_PASSWORD_WITH_OTP)
    fun getSingleCalVideoData(@Body data: String?): Call<String>

    @get:GET(API.API_GET_MASTER_REGISTRATION_HIT)
    val masterRegistrationHit: Call<String?>?

    @POST(API.API_USER_LOGIN_AUTHENTICATION)
    suspend fun userLoginAuthentication(@Body data: String?): Response<String>

    @POST(API.get_my_profile)
    fun userProfile(@Body data: String?): Call<String>

    @POST(API.API_STATE)
    fun GetState(@Body data: String?): Call<String>?

    @POST(API.API_CITY)
    fun GetCity(@Body data: String?): Call<String>?

    @POST(API.API_COUNTRY)
    fun GetCountry(@Body data: String?): Call<String?>?

    @POST(API.API_STUDENT_CATEGORY)
    fun GetStudentCategory(@Body data: String?): Call<String?>?

    @POST(API.get_languages)
    fun GetLanguage(@Body data: String?): Call<String?>?

    @POST(API.master_content)
    fun master_content(@Body data: String?): Call<String?>?

    @POST(API.get_courses)
    fun get_courses(@Body data: String?): Call<String?>?

    @POST(API.video_link)
    fun video_link(@Body data: String?): Call<String?>?

    @POST(API.GET_COUPON_OVER_COURSE)
    fun GET_COUPON_OVER_COURSE(@Body data: String?): Call<String?>?

    //    @POST(API.API_USER_LOGIN_AUTHENTICATION)
    //    Call<String> userLoginAuthentication(@Body String data);
    /*@FormUrlEncoded
        @POST(API.API_USER_LOGIN_AUTHENTICATION)
        Call<String> userLoginAuthentication(@Field(Const.EMAIL) String EMAIL,
                                                       @Field(Const.PASSWORD) String PASSWORD,
                                                       @Field(Const.IS_SOCIAL) String IS_SOCIAL,
                                                       @Field(Const.SOCIAL_TYPE) String SOCIAL_TYPE,
                                                       @Field(Const.SOCIAL_TOKEN) String SOCIAL_TOKEN,
                                                       @Field(Const.DEVICE_TYPE) String DEVICE_TYPE,
                                                       @Field(Const.LOCATION) String Location,
                                                       @Field(Const.DEVICEID) String DEVICE_id,
                                                       @Field(Const.DEVICE_TOKEN) String DEVICE_TOKEN,
                                                       @Field(Const.PROFILE_PICTURE) String PROFILE_PICTURE);*/
    @get:GET(API.API_USER_PROFILE_WITH_TOKEN)
    val userProfileWithToken: Call<String?>?

    @POST(API.API_SEND_OTP_VERIFICATION)
    fun getOtpVerification(@Body data: String?): Call<String>

    /*@FormUrlEncoded
    @POST(API.API_OTP)
    Call<String> getOtp(@Field(Const.MOBILE) String MOBILE,
                        @Field(Const.COUNTRY_CODE) String COUNTRY_CODE,
                        @Field(Const.EMAIL) String EMAIL);

    @FormUrlEncoded
    @POST(API.API_OTP)
    Call<String> getOtp(@Field(Const.EMAIL) String EMAIL,
                        @Field(Const.MOBILE) String MOBILE,
                        @Field(Const.COUNTRY_CODE) String COUNTRY_CODE,
                        @Field(Const.NAME) String NAME,
                        @Field(Const.PASSWORD) String PASSWORD,
                        @Field(Const.IS_SOCIAL) String IS_SOCIAL,
                        @Field(Const.SOCIAL_TYPE) String SOCIAL_TYPE,
                        @Field(Const.SOCIAL_TOKEN) String SOCIAL_TOKEN,
                        @Field(Const.DEVICE_TYPE) String DEVICE_TYPE,
                        @Field(Const.DEVICE_TOKEN) String DEVICE_TOKEN);

    @FormUrlEncoded
    @POST(API.API_CHANGE_PASSWORD_OTP)
    Call<String> getChangePasswordOtp(@Field(Const.MOBILE) String mobileNumber,
                                      @Field(Const.OTP) String OTP);

    @FormUrlEncoded
    @POST(API.API_CHANGE_PASSWORD_OTP)
    Call<String> getChangePasswordOTP(@Field(Const.COUNTRY_CODE) String COUNTRY_CODE,
                                      @Field(Const.MOBILE) String mobileNumber);*/
    /*@FormUrlEncoded
    @POST(API.API_OTP_FOR_MOBILE_CHANGE)
    Call<String> otpForMobileChange(@Field(Const.USER_ID) String USER_ID,
                                    @Field(Const.MOBILE) String MOBILE,
                                    @Field(Const.COUNTRY_CODE) String COUNTRY_CODE);*/
    @POST(API.API_REGISTER_USER)
    fun registerUser(@Body data: String?): Call<String?>?

    @POST(API.CONTACT_US_URL)
    fun doContactUsQuery(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_REGISTER_USER)
    Call<String> registerUser(@Field(Const.NAME) String NAME,
                              @Field(Const.EMAIL) String EMAIL,
                              @Field(Const.PASSWORD) String PASSWORD,
                              @Field(Const.MOBILE) String MOBILE,
                              @Field(Const.COUNTRY_CODE) String COUNTRY_CODE,
                              @Field(Const.IS_SOCIAL) String IS_SOCIAL,
                              @Field(Const.SOCIAL_TYPE) String SOCIAL_TYPE,
                              @Field(Const.SOCIAL_TOKEN) String SOCIAL_TOKEN,
                              @Field(Const.DEVICE_TYPE) String DEVICE_TYPE,
                              @Field(Const.DEVICEID) String DEVICE_id,
                              @Field(Const.DEVICE_TOKEN) String DEVICE_TOKEN,
                              @Field(Const.PROFILE_PICTURE) String PROFILE_PICTURE);*/
    @POST(API.API_REGISTER_USER)
    fun registerUser1(@Body data: String?): Call<String?>?

    @POST(API.API_REGISTER_USER)
    fun registerUserSign(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_REGISTER_USER)
    Call<String> registerUserSign(@Field(Const.NAME) String NAME,
                                  @Field(Const.EMAIL) String EMAIL,
                                  @Field(Const.LOCATION) String LOCATION,
                                  @Field(Const.AGE) String AGE,
                                  @Field(Const.GENDER) String GENDER,
                                  @Field(Const.PASSWORD) String PASSWORD,
                                  @Field(Const.MOBILE) String MOBILE,
                                  @Field(Const.COUNTRY_CODE) String COUNTRY_CODE,
                                  @Field(Const.IS_SOCIAL) String IS_SOCIAL,
                                  @Field(Const.SOCIAL_TYPE) String SOCIAL_TYPE,
                                  @Field(Const.SOCIAL_TOKEN) String SOCIAL_TOKEN,
                                  @Field(Const.DEVICE_TYPE) String DEVICE_TYPE,
                                  @Field(Const.DEVICEID) String DEVICE_id,
                                  @Field(Const.DEVICE_TOKEN) String DEVICE_TOKEN,
                                  @Field(Const.USER_TOKEN) String USER_TOKEN,
                                  @Field(Const.OTP) String OTP);*/

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataFirst(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_DATA)
    fun getTestDataFirsts(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getTestDataFirsts(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                  @Field(Const.ID) String ID,
                                  @Field(Const.LAYER) String LAYER,
                                  @Field(Const.MAIN_ID) String MAIN_ID,
                                  @Field(Const.SUB_ID) String SUB_ID,
                                  @Field(Const.TEST_TYPE) String TEST_TYPE,
                                  @Field(Const.TYPE) String TYPE,
                                  @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API,
                                  @Field(Const.TEST_FILTER) String TEST_FILTER,
                                  @Field(Const.PAGE) int PAGE);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getVideoDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                   @Field(Const.ID) String ID,
                                   @Field(Const.LAYER) String LAYER,
                                   @Field(Const.TYPE) String TYPE,
                                   @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    @POST(API.API_GET_MASTER_DATA)
    fun getVideoDataFirst(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getVideoDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                   @Field(Const.ID) String ID,
                                   @Field(Const.LAYER) String LAYER,
                                   @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                   @Field(Const.TYPE) String TYPE,
                                   @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getVideoDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                   @Field(Const.ID) String ID,
                                   @Field(Const.LAYER) String LAYER,
                                   @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                   @Field(Const.TOPIC_ID) String TOPIC_ID,
                                   @Field(Const.TYPE) String TYPE,
                                   @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    @POST(API.API_GET_MASTER_DATA)
    fun getVideoDataFirstt(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getVideoDataFirstt(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                   @Field(Const.ID) String ID,
                                   @Field(Const.LAYER) String LAYER,
                                   @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                   @Field(Const.TOPIC_ID) String TOPIC_ID,
                                   @Field(Const.TYPE) String TYPE,
                                   @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API,
                                   @Field(Const.TEST_FILTER) String TEST_FILTER,
                                   @Field(Const.PAGE) int PAGE);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getConceptFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.TYPE) String TYPE,
                                     @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getFreeMagazineFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                          @Field(Const.TYPE) String TYPE,
                                          @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getMagazineFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getConceptFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                     @Field(Const.TYPE) String TYPE,
                                     @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getFreeMagazineFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                      @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                          @Field(Const.TYPE) String TYPE,
                                          @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getMagazineFirstData(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    @POST(API.API_GET_MASTER_DATA)
    fun getConceptDataFirst(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getConceptDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.TOPIC_ID) String TOPIC_ID,
                                     @Field(Const.TYPE) String TYPE,
                                     @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    @POST(API.API_GET_MASTER_DATA)
    fun getConceptDataFirsst(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getConceptDataFirsst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.TOPIC_ID) String TOPIC_ID,
                                     @Field(Const.TYPE) String TYPE,
                                     @Field(Const.TILE_ID) String TILE_ID,
                                     @Field(Const.REVERT_API) String REVERT_API,
                                     @Field(Const.TEST_FILTER) String TEST_FILTER,
                                     @Field(Const.PAGE) int PAGE);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getFreeMagazineDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                      @Field(Const.TOPIC_ID) String TOPIC_ID,
                                          @Field(Const.TYPE) String TYPE,
                                          @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getMagazineDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                     @Field(Const.ID) String ID,
                                     @Field(Const.LAYER) String LAYER,
                                     @Field(Const.TOPIC_ID) String TOPIC_ID,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getPracticeDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getPracticeDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                      @Field(Const.SUBJECT_ID) String SUBJECT_ID,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                  @Field(Const.REVERT_API) String REVERT_API);*/
    @POST(API.API_GET_MASTER_DATA)
    fun getPracticeDataFirst(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_MASTER_DATA)
    Call<String> getPracticeDataFirst(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                      @Field(Const.ID) String ID,
                                      @Field(Const.LAYER) String LAYER,
                                      @Field(Const.MAIN_ID) String MAIN_ID,
                                      @Field(Const.SUB_ID) String SUB_ID,
                                      @Field(Const.TEST_TYPE) String TEST_TYPE,
                                      @Field(Const.TYPE) String TYPE,
                                      @Field(Const.TILE_ID) String TILE_ID,
                                      @Field(Const.REVERT_API) String REVERT_API,
                                      @Field(Const.TEST_FILTER) String TEST_FILTER,
                                  @Field(Const.PAGE) int PAGE);*/
    @POST(API.API_GET_LANDING_PAGE_DATA_EXAM)
    fun getLandingPageDataExam(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_LANDING_PAGE_DATA_EXAM)
    Call<String> getLandingPageDataExam(*/
    /*@Field(Const.USER_ID) String USER_ID,*/ /*
                                        @Field(Const.COURSE_TYPE) String COURSE_TYPE,
                                        @Field(Const.CAT_ID) String CAT_ID,
                                        @Field(Const.STUDY_TYPE) String STUDY_TYPE);*/

    @POST(API.API_GET_BASIC_COURSE)
    fun getBasicCourse(@Body data: String?): Call<String?>?

    @FormUrlEncoded
    @POST(API.API_POPUP_DATA_COLLECTION)
    fun getPopupDataCollection(
        @Field("popup_id") popup_id: String?,
        @Field("course_id") course_id: String?
    ): Call<String?>?

    @POST(API.API_GET_COURSE_DETAIL)
    fun getCourseDetail(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataOverviewFAQ(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataVideo(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataVideoTwo(@Body data: String?): Call<String?>?

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataVideoThree(@Body data: String?): Call<String?>?

    @POST(API.BANNER_FEED)
    fun getBannerFeed(@Body data: String?): Call<String>

    @POST(API.API_GET_MASTER_DATA)
    fun getMasterDataTest(@Body data: String?): Call<String?>?

    //@FormUrlEncoded
    @POST(API.API_REQUEST_VIDEO_LINK)
    fun requestVideoLink(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_NOTIFICATION_SETTING)
    Call<String> getNotificationSettings(*/
    /*@Field(Const.USER_ID) String userId*/ /*);*/
    @get:GET(API.API_GET_NOTIFICATION_SETTING)
    val notificationSettings: Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_GET_PREFERENCES)
    Call<String> getPreferences(@Field(Const.USER_ID) String USER_ID);*/
    @get:GET(API.API_GET_PREFERENCES)
    val preferences: Call<String?>?

    @get:GET(API.API_TOPPER_DESK)
    val topperDesk: Call<String?>?

    @get:GET(API.API_GET_REPORT_ABUSE_LIST)
    val reportAbuseList: Call<String?>?

    @get:GET(API.API_MY_TRANSACTIONS)
    val myTransactions: Call<String?>?

    @POST(API.API_HELP_AND_SUPPORT)
    fun sendHelpSupportFeedback(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_HELP_AND_SUPPORT)
    Call<String> sendHelpSupportFeedback(*/
    /*@Field(Const.USER_ID) String userId,*/ /*
                                         @Field(Const.COMMENT_TYPE) String commentType,
                                         @Field(Const.COMMENT_MSG) String commentMsg);*/
    /*@FormUrlEncoded
    @POST(API.API_ADD_MY_NOTES)
    Call<String> addMyNotesData(@Field(Const.USER_ID) String userId,
                                         @Field(Const.NOTE_DATA) String notes,
                                         @Field(Const.DOSE_TYPE) String doseId,
                                         @Field(Const.ARTICLE_ID) String articleId);*/
    @POST(API.API_ADD_MY_NOTES)
    fun addMyNotesData(@Body data: String?): Call<String?>?

    @POST(API.API_UPDATE_VIDEO_VIEW)
    fun API_UPDATE_VIDEO_VIEW(@Body data: String?): Call<String?>?

    /*@FormUrlEncoded
    @POST(API.API_UPDATE_VIDEO_VIEW)
    Call<String> API_UPDATE_VIDEO_VIEW(
            @Field(Const.USER_ID) String USER_ID,
            @Field(Const.TYPE) String type,
            @Field(Const.COURSE_ID) String COURSE_ID,
            @Field(Const.VIDEO_ID) String VIDEO_ID,
            @Field(Const.TOTAL_TIME) String TOTAL_TIME,
            @Field(Const.VIEW_TIME) String VIEW_TIME,
            @Field(Const.TILE_ID) String TILE_ID);*/

    @GET(API.API_GENERATE_LEAD)
    fun API_GENERATE_LEAD(): Call<String?>?

    @get:GET(API.API_GET_POPUP_DATA)
    val popupData: Call<String?>?

    @GET(API.get_child_app_details)
    fun get_child_app_details(): Call<String?>?

    @POST(API.get_my_courses)
    fun get_my_courses(@Body data: String?): Call<String?>?

    @POST(API.fetch_user)
    fun fetch_user(@Body data: String?): Call<String?>?

    @POST(API.update_video_view_time)
    fun update_video_view_time(@Body data: String?): Call<String?>?

    @POST(API.user_video_view_data)
    fun user_video_view_data(@Body data: String?): Call<String?>?

    @POST(API.transfer_course)
    fun transfer_course(@Body data: String?): Call<String?>?

    @POST(API.update_profile)
    fun updateprofile(@Body data: String?): Call<String?>?

    @POST(API.get_my_orders)
    fun get_my_orders(@Body data: String?): Call<String?>?

    @POST(API.get_book_orders)
    fun get_book_orders(@Body data: String?): Call<String?>?

    @POST(API.CourseDetail_JS)
    fun getCourseData(@Body data: String?): Call<String>

    @POST(API.API_GET_COUPON)
    fun API_GET_COUPON(@Body data: String?): Call<String?>?

    @POST(API.IS_COUPON_AVAILABLE)
    fun IS_COUPON_AVAILABLE(@Body data: String?): Call<String?>?

    @get:GET(API.API_get_paid_course)
    val paidCourse: Call<String?>?

    @POST(API.API_COMPLETE_ENROLLMENT)
    fun completeEnrollment(@Body data: String?): Call<String?>?

    @get:GET(API.GET_CONTACT_US_LIST_URL)
    val contactList: Call<String>

    @POST(API.API_GET_CURRENT_AFFAIR)
    fun getCurrentAffair(@Body data: String?): Call<String>

    @POST(API.API_GET_CURRENT_AFFAIR_DETAILS)
    fun getCurrentAffairDetails(@Body data: String?): Call<String>

    @get:GET(API.API_GET_FAQ)
    val fAQ: Call<String>

    @POST(API.API_GET_USER_SUPPORT_CATEGORY)
    fun getSupportCategory(@Body data: String?): Call<String>

    @POST(API.API_POST_USER_SUPPORT)
    fun getPostSupport(@Body data: String?): Call<String>

    @POST(API.API_GET_USER_DOUBT_LIST)
    fun getAllDoubt(@Body data: String?): Call<String?>?

    @POST(API.API_GET_DOUBT_SUBJECT_LIST)
    fun postSubjectList(@Body data: String?): Call<String?>?

    @POST(API.API_GET_CHECK_ISBN)
    fun postcheckIsbn(@Body data: String?): Call<String?>?

    @POST(API.API_GET_POST_DOUBT)
    fun postUserDoubt(@Body data: String?): Call<String?>?

    @POST(API.API_GET_DOUBT_REPLY)
    fun doubtReply(@Body data: String?): Call<String>

    @POST(API.API_GET_DOUBT_RESOLVE_STATUS)
    fun doubtResolveStatus(@Body data: String?): Call<String>

    @POST(API.SAVE_CONTACT_US_LIST_URL)
    fun saveContactReply(@Body data: String?): Call<String>

    @POST(API.GET_CONTACT_US_REPLY_LIST_URL)
    fun getContactReplyList(@Body data: String?): Call<String>

    @POST(API.COURSE_REVIEW_LIST)
    fun getCourseReviewList(@Body data: String?): Call<String>

    @POST(API.POST_COURSE_REVIEW)
    fun postCourseReview(@Body data: String?): Call<String>

    @POST(API.COURSE_ADD_TO_CART)
    fun addItemInCart(@Body data: String?): Call<String>?

    @get:POST(API.COURSE_CART_COUNT)
    val cartCount: Call<String>

    @get:POST(API.COURSE_SHOW_CART)
    val cartItems: Call<String>


    @POST(API.COURSE_REMOVE_ITEM)
    fun getRemoveItem(@Body data: String?): Call<String>

    @POST(API.Installment_Details)
    fun getCourseInstallmentDetails(@Body data: String?): Call<String>

    @POST(API.API_Check_Installment_Status)
    fun API_CHECK_INSTALLMENT_DATA(@Body body: String?): Call<String?>?

    @POST(API.API_Installment_Course_List)
    fun API_INSTALLMENT_COURSE_LIST(@Body body: String?): Call<String?>?

    @POST(API.update_preference)
    fun update_preference(@Body body: String?): Call<String?>?

    @POST(API.API_DOWNLOAD_CERTIFICATE)
    fun API_DOWNLOAD_CERTIFICATE(@Body body: String?): Call<String?>?

    @POST(API.getPost)
    suspend fun getPost(@Body body: String?): Response<String?>?

    @POST(API.get_post_detail)
    suspend fun get_post_detail(@Body body: String?): Response<String?>?

    @POST(API.like_unlike_post)
    suspend fun courutine_like_unlike_post(@Body body: String?): Response<String?>?

    @POST(API.get_feed_comments)
    suspend fun courutine_get_feed_comments(@Body body: String?): Response<String?>?

    @POST(API.comment_post)
    suspend fun courutine_add_comments(@Body body: String?): Response<String?>?

    @POST(API.attempt_mcq)
    suspend fun courutine_attempt_mcq(@Body body: String?): Response<String?>?

    @POST(API.pin_post)
    suspend fun courutinePinPost(@Body body: String?): Response<String?>?

    @POST(API.get_liveclasses_data)
    suspend fun getLiveClass(@Body body: String?): Response<String?>?

    @POST(API.get_testclasses_data)
    suspend fun getLiveTest(@Body body: String?): Response<String?>?

    @POST(API.getchangedetecter)
    suspend fun getChangedetectot(@Body body: String?): Response<String?>?

    @GET(API.API_DOUBT_USER_LIST)
    fun getStudentList(): Call<String?>?

    @POST(API.API_DOUBT_DOUBT_LIST)
    fun getStudentDoubtList(@Body body: String?): Call<String?>?

    @POST(API.API_GET_EXPERT_SETTING)
    fun getExpertSetting(): Call<String?>?

    @POST(API.API_RECENT_WATCH)
    fun getRecentWatchList(@Body body: String?): Call<String?>?

    @POST(API.API_ATTEND_EVENT)
    fun getAttendEvent(@Body data: String?): Call<String>?

}


object API {

    const val TERMS_AND_CONDITIONS: String = BuildConfig.BASE_URL + "term_cond/" + BuildConfig.API_ID
    const val PRIVACY_POLICY_URL: String = BuildConfig.BASE_URL + "privacy/" + BuildConfig.API_ID
//    const val API_AMAZON_S3_BUCKET_NAME_PROFILE_IMAGES = BUCKET_NAME + BuildConfig.FOLDER_PROFILE_IMAGE
//    const val API_AMAZON_S3_BUCKET_NAME_FANWALL_IMAGES = BUCKET_NAME + BuildConfig.FOLDER_FANWALL_IMAGE
//    const val API_AMAZON_S3_BUCKET_NAME_VIDEO_IMAGES = BUCKET_NAME + "video_thumbnails"
//    const val API_AMAZON_S3_BUCKET_NAME_DOCUMENT = BUCKET_NAME + BuildConfig.FOLDER_DOC
//    const val API_AMAZON_S3_BUCKET_NAME_FEEDBACK = BUCKET_NAME + "feedback_images"
//    const val API_AMAZON_S3_FILE_NAME_CREATION: String = SharedPreference.getInstance().getLoggedInUser().getId() + "sample_" + Calendar.getInstance().timeInMillis
//    const val API_AMAZON_S3_BUCKET_NAME_USER_PROFILE = BUCKET_NAME + APP_ID + "/" + "application/profile/"
//
//    //String API_AMAZON_S3_BUCKET_NAME_USER_PROFILE = BUCKET_NAME+BuildConfig.FOLDER_PROFILE_IMAGE;
//    const val API_AMAZON_S3_BUCKET_NAME_CHAT_IMAGE = BUCKET_NAME + "application/chat_system/"
//    const val API_AMAZON_S3_BUCKET_NAME_JSON_IMAGE = BUCKET_NAME + APP_ID + "/" + "admin_v1/test_management/question_bank/"

    //--------------------------FEEDS-------------------------------------//
    const val getPost = BuildConfig.BASE_URL + "index.php/" + "data_model/post/get_post_list"
    const val get_post_detail = BuildConfig.BASE_URL + "index.php/" + "data_model/post/get_post_detail"
    const val like_unlike_post = BuildConfig.BASE_URL + "index.php/" + "data_model/post/like_unlike_post"
    const val attempt_mcq = BuildConfig.BASE_URL + "index.php/" + "data_model/post/attempt_mcq"
    const val get_feed_comments = BuildConfig.BASE_URL + "index.php/" + "data_model/post/get_feed_comments"
    const val comment_post = BuildConfig.BASE_URL + "index.php/" + "data_model/post/comment_post"
    const val pin_post = BuildConfig.BASE_URL + "index.php/" + "data_model/post/post_pinned"
    const val API_SEND_OTP_VERIFICATION = BuildConfig.BASE_URL + "index.php/" + "data_model/users/send_verification_otp"
    const val API_CITY = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_cities"
    const val API_STATE = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_states"
    const val API_COUNTRY = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_countries"
    const val API_STUDENT_CATEGORY = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/student_category"
    const val API_UPDATE_PASSWORD_WITH_OTP = BuildConfig.BASE_URL + "index.php/" + "data_model/users/update_password"
    const val API_UPDATE_MOBILE_NUMBER = BuildConfig.BASE_URL + "index.php/" + "data_model/user/User_mobile_change/update_mobile_number"
    const val API_REGISTER_USER = BuildConfig.BASE_URL + "index.php/" + "data_model/users/registration"
    const val API_USER_DAMS_VERIFICATION = BuildConfig.BASE_URL + "index.php/" + "data_model/user/dams_user_verification/user_verification"
    const val API_USER_PROFILE_WITH_TOKEN = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_profile/user_profile_with_token"

    //String API_REGISTER_NIMBUS_USER = BuildConfig.BASE_URL + "index.php/"_NIMBUS + "data_model/user/registration";
    const val API_USER_LOGOUT_WITH_TOKEN = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_profile/user_logout"
    const val API_USER_LOGIN_AUTHENTICATION = BuildConfig.BASE_URL + "index.php/" + "data_model/users/login_auth"
    const val COURSE_CONTENT_SEARCH = BuildConfig.BASE_URL + "index.php/" + "data_model/course/course_content_search"

    //TODO SME
    const val API_DOUBT_USER_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/doubt_user_list"
    const val API_DOUBT_DOUBT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/studentwise_doubt_list"
    const val API_GET_EXPERT_SETTING = BuildConfig.BASE_URL + "index.php/" + "data_model/version/get_expert_setting"

    ///UTKASH API BY PRIYANSHU///
    const val master_content = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/content"
    const val get_courses = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_courses"
    const val get_my_profile = BuildConfig.BASE_URL + "index.php/" + "data_model/users/get_my_profile"
    const val get_folder_list = BuildConfig.BASE_URL + "index.php/" + "data_model/content/get_folder_list"
    const val API_COURSE_SUBJECT_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_subject_by_category"
    const val API_POST_MCQ = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_mcq/add_mcq"
    const val API_POST_NORMAL_VIDEO = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_text/add_post"
    const val API_GET_FEEDS_FOR_USER = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall/get_fan_wall_for_user"
    const val API_GET_MASTER_HIT = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/master_hit/content"
    const val API_LIKE_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_like/like_post"
    const val API_DISLIKE_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_like/dislike_post"
    const val API_REPORT_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Post_report_abuse/report"
    const val API_DELETE_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Post_delete/delete_post"
    const val API_SHARE_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_share/share_post"
    const val API_ADD_QUES_ANS_BOOKMARK = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/test_series/bookmark_question"
    const val API_ADD_BOOKMARK = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_bookmarks/add_to_bookmarks"
    const val API_REMOVE_BOOKMARK = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_bookmarks/remove_from_bookmarks"
    const val API_ADD_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_comment/add_comment"
    const val API_EDIT_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_comment/update_comment"
    const val API_DELETE_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_comment/delete_comment"
    const val API_GET_COMMENT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_comment/get_post_comment"
    const val API_GET_MASTER_REGISTRATION_HIT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/get_all_category_db"
    const val API_GET_COURSE_LIST_ZERO_LEVEL = BuildConfig.BASE_URL + "index.php/" + "data_model/user/User_category_handling/get_category_basic"
    const val API_GET_COURSE_LIST_FIRST_LEVEL = BuildConfig.BASE_URL + "index.php/" + "data_model/user/User_category_handling/get_category_basic_level_one"
    const val API_GET_COURSE_LIST_SECOND_LEVEL =
        BuildConfig.BASE_URL + "index.php/" + "data_model/user/User_category_handling/get_category_basic_level_two"
    const val API_GET_COURSE_INTERESTED_IN =
        BuildConfig.BASE_URL + "index.php/" + "data_model/user/User_category_handling/get_intersted_courses"
    const val API_STREAM_REGISTRATION = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/stream_registration"
    const val API_GET_USER = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Registration/get_active_user/"
    const val API_FOLLOW = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/follow_user"
    const val API_UNFOLLOW = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/unfollow_user"
    const val API_MAKE_AN_EXPERT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_expert_control/make_user_expert"
    const val API_REMOVE_EXPERT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_expert_control/remove_user_expert"
    const val API_FOLLOWING_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/following_list"
    const val API_FOLLOWERS_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/followers_list"

    // String API_SUBMIT_QUERY = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_queries/submit_query";
    const val API_SINGLE_POST_FOR_USER = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall/get_single_post_data_for_user"
    const val API_GET_TAG_LISTS = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_meta_tags/get_list_tags/"
    const val API_GET_USER_NOTIFICATIONS =
        BuildConfig.BASE_URL + "index.php/" + "data_model/notification_genrator/activity_logger/get_user_activities"
    const val API_CHANGE_NOTIFICATION_STATE =
        BuildConfig.BASE_URL + "index.php/" + "data_model/notification_genrator/activity_logger/make_activity_viewed"

    //    String API_GET_USER_NOTIFICATIONS = BuildConfig.BASE_URL + "index.php/" + "data_model/notification_genrator/activity_logger/get_user_activity";
    const val API_GET_LIVE_STREAM = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/live_stream/top_video_stream"
    const val API_GET_APP_VERSION = BuildConfig.BASE_URL + "index.php/" + "data_model/version/get_version"
    const val API_GET_NOTIFICATION_COUNT =
        BuildConfig.BASE_URL + "index.php/" + "data_model/notification_genrator/activity_logger/all_notification_counter"
    const val API_UPDATE_DEVICE_TOKEN = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/update_device_info"

    //String API_GET_APP_VERSION = BuildConfig.BASE_URL + "index.php/" + "";
    const val API_UPDATE_DAMS_TOKEN = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/update_dams_id_user"
    const val API_REQUEST_VIDEO_LINK = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall/on_request_create_video_link"
    const val API_REQUEST_TEST_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/get_video_study_meta"
    const val API_REQUEST_VIDEO_LINK_V2 = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall/on_request_create_video_link_v2"
    const val API_EDIT_MCQ_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_mcq/edit_mcq"
    const val API_EDIT_NORMAL_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_text/edit_post"
    const val API_ALL_NOTIFICATION_READ =
        BuildConfig.BASE_URL + "index.php/" + "data_model/notification_genrator/Activity_logger/set_all_read"
    const val API_LIKES_COUNT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_like/get_post_like_users"
    const val API_SINGLE_COMMENT_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_comment/get_single_comment_data"
    const val API_UPDATE_BANNER_HIT_COUNT = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall_banner/update_banner_hit_count"
    const val API_SUBMIT_ANSWER_POST_MCQ = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_mcq/answer_post_mcq"
    const val SAVE_EXAM_PREFERENCE = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/update_user_prefrences"
    const val GENERATE_HASH = BuildConfig.BASE_URL + "index.php/" + "data_model/Transaction/hash_generate"
    const val PRIVACY_POLICY = BuildConfig.BASE_URL + "index.php/" + "web_panel/home/privacy_app"
    const val API_GET_LANDING_PAGE_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_landing_page_data"
    const val API_GET_LANDING_PAGE_DATA_EXAM = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_landing_page_data_exam"

    /*###########################################################
    ######  #######  #     #  ######  ######  ######  ######
    #       #     #  #     #  #    #  #       #       #
    #       #     #  #     #  ######  ######  ######  ######
    #       #     #  #     #  # #          #  #            #
    ######	#######  #######  #   #   ######  ######  ######
    ############################################################# */
    const val API_SINGLE_COURSE_INFO_RAW = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_single_course_info_raw"
    const val API_GET_ALL_CATEGORY_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_all_category_data"
    const val API_GET_ALL_CATEGORY_DATA_EXAM = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_all_category_data_exam"
    const val API_GET_MY_COURSE_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/my_courses/get_list_of_my_courses"
    const val API_GET_INSTRUCTOR_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Instructor/get_instructor_profile"
    const val API_GET_FILE_LIST_CURRICULUM = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Course/get_all_file_info"
    const val API_GET_FAQ_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_faq"

    //String API_APPLY_COUPON_CODE = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/apply_coupon_code";
    const val API_APPLY_COUPON_CODE = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/apply_coupon"
    const val API_SET_POST_AS_PINNED = BuildConfig.BASE_URL + "index.php/" + "data_model/user/post_pinning/pin_a_post"
    const val API_SET_POST_AS_UNPINNED = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Post_pinning/pin_a_post_remove"
    const val API_SEARCH_COURSE = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/search_course"
    const val API_SEARCH_COURSE_EXAM = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/search_course_exam"
    const val API_CART_COURSE_EXAM = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_multi_courses_by_id"
    const val API_GET_SOLUTION_TESTSERIES = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Test_series/get_test_series_result"
    const val API_GET_MENTOR_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/mme_mentor_list"
    const val API_GET_MME_EXPERT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_follow/mme_expert_list"
    const val API_GET_BASIC_COURSE = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/get_basic_data"
    const val API_GET_COURSE_DETAIL = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_course_detail"
    const val API_GET_MASTER_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_master_data"
    const val API_VIDEO_FEEDBACK = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/video_feedback"
    const val API_DAILY_DOSE = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/master_hit/daily_dose_menu"
    const val get_my_courses = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_my_courses"
    const val get_languages = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_languages"
    const val get_child_app_details = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/child_app_details"
    const val user_video_view_data = BuildConfig.BASE_URL + "index.php/" + "data_model/course/user_video_view_data"
    const val update_video_view_time = BuildConfig.BASE_URL + "index.php/" + "data_model/course/update_video_view_time"
    const val fetch_user = BuildConfig.BASE_URL + "index.php/" + "data_model/users/search_user"
    const val transfer_course = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/transfer_course"
    const val API_GET_VIDEO_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/video/video_comment/get_video_comment"
    const val API_ADD_REVIEW_COURSE = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_rating_reviews/add_review_to_course"

    /*################################################
    Videos
################################################ */
    const val API_GET_INSTRUCTOR_REVIEW_LIST =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_instructor_reviews/get_list_of_reviews"

    //End Videos
    const val API_GET_COURSE_REVIEW_LIST =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_rating_reviews/get_list_of_reviews"

    //String API_INITIALIZE_COURSE_PAYMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/initialize_course_transaction";
    const val API_INITIALIZE_COURSE_PAYMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/initialize_transaction"
    const val API_ADD_UPDATE_ADDRESS = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/add_update_address"

    //String API_MAKE_FREE_COURSE_TRANSACTION = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/free_course_transaction";
    const val API_MAKE_FREE_COURSE_TRANSACTION = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/free_transaction"

    //String API_COMPLETE_COURSE_PAYMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/complete_course_transaction";
    const val API_COMPLETE_COURSE_PAYMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/complete_transaction"
    const val API_CCAVANUE_GET_RSA = BuildConfig.BASE_URL + "index.php/" + "data_model/payment_request/get_rsa"
    const val API_CCAVANUE_REDIRECT_URL = BuildConfig.BASE_URL + "index.php/" + "data_model/payment_request/process_status"
    const val API_DELETE_USER_COURSE_REVIEWS =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_rating_reviews/delete_review_from_course"
    const val API_EDIT_USER_COURSE_REVIEWS =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_rating_reviews/edit_review_to_course"
    const val API_GET_COMPLETE_INFO_TEST_SERIES =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/test_series/get_test_series_with_id?pro_data=1"
    const val API_COMPLETE_INFO_TESTSERIES = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Test_series/save_test"
    const val API_GET_USER_GIVEN_TESTSERIES =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Test_series/get_user_given_test_series"

    //String API_GET_COMPLETE_INFO_TEST_SERIES = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/test_series/get_test_series_with_id_app";
    const val API_GET_USER_LEADERBOARD_RESULT =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Test_series/get_test_series_basic_result"
    const val API_GET_USER_RESULT = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/test_series/top_list"
    const val API_ADD_INSTRUCTOR_REVIEW_COURSE =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_instructor_reviews/add_review_to_instructor"
    const val API_EDIT_USER_INSTRUCTOR_REVIEWS =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_instructor_reviews/edit_review_to_instructor"
    const val API_DELETE_USER_INSTRUCTOR_REVIEWS =
        BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course_instructor_reviews/delete_review_from_instructor"
    const val API_GET_REWARD_POINTS = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_reward/get_user_rewards"
    const val API_GET_REPORT_ABUSE_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Post_report_abuse/get_all_report_reasons"
    const val API_GET_REWARD_POINTS_NEW = BuildConfig.BASE_URL + "index.php/" + "data_model/users/get_reward_transaction"

    /*################################################
    Videos
################################################*/
    const val API_GET_SINGLE_VIDEO_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/get_single_video_data"
    const val API_GET_SINGLE_CAT_VIDEO_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/get_videos_for_tag_list"
    const val API_GET_POST_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/video/video_comment/get_video_comment"
    const val API_ADD_VIDEO_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/video/video_comment/add_comment"
    const val API_LIKE_VIDEO = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_like/like_video"
    const val API_DISLIKE_VIDEO = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_like/dislike_video"
    const val API_ADD_VIEW_VIDEO = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/add_video_counter"
    const val API_DELETE_VIDEO_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/video/video_comment/delete_comment"
    const val API_EDIT_VIDEO_COMMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/video/video_comment/update_comment"
    const val API_ADD_FAV = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/add_favourite_video"
    const val API_REMOVE_FAV = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/remove_favourite_video"
    const val API_GET_FAV_VIDEOS = BuildConfig.BASE_URL + "index.php/" + "data_model/video/Video_channel/get_favourite_video_list"

    //NOTIFICATION SETTINGS
    const val API_GET_NOTIFICATION_SETTING = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/user_notification_settings"
    const val API_EDIT_NOTIFICATION_SETTING = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/edit_user_notification"
    const val API_EDIT_ALLOW_TAGGING = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/allow_tagging"
    const val API_GET_REWARD_TRANSACTION = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_reward/get_reward_transaction"
    const val API_STUDY_SLIDER_IMAGES = BuildConfig.BASE_URL + "index.php/" + "data_model/slider/get_slider"
    const val MAKE_LEARNER = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/complete_element"
    const val API_COURSE_META_ALL = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/get_course_meta"
    const val API_GET_PRACTICE_STATUS = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/Test_series/get_practice_status"
    const val API_HIDE_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Post_hide/hide_post"
    const val API_UPDATE_PROFILE_PICTURE = BuildConfig.BASE_URL + "index.php/" + "data_model/user/Profile_picture/update_profile_picture"
    const val API_GET_PREFERENCES = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/get_prefrences"
    const val API_GET_MENTOR_DETAIL = BuildConfig.BASE_URL + "index.php/" + "data_model/user/registration/set_mentor"
    const val API_SUGGESTED_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/Fan_wall/suggested_post"
    const val API_MOBILE_MENU = BuildConfig.BASE_URL + "index.php/" + "data_model/mobile_menu/index"
    const val GET_NEW_CONTACT_US = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/master_hit/get_app_contact_us"
    const val API_MOBILE_BANNER = BuildConfig.BASE_URL + "index.php/" + "data_model/fanwall/fan_wall_banner/get_fan_wall_banner"
    const val API_TOPPER_DESK = BuildConfig.BASE_URL + "index.php/" + "data_model/toppers_desk"
    const val API_MY_TRANSACTIONS = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/my_courses/my_transactions"
    const val API_DELETE_USER_ACCOUNT = BuildConfig.BASE_URL + "index.php/" + "data_model/user/user_profile/delete_profile_request"
    const val API_GET_TOPIC_DATA_FIRST = BuildConfig.BASE_URL + "index.php/" + "data_model/hierarchy/get_topic_subtopic"
    const val API_GET_UNIT_DATA_FIRST = BuildConfig.BASE_URL + "index.php/" + "data_model/hierarchy/get_unit_chapter"
    const val API_DOUBTS_PLAN_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_plan/get_plans"
    const val API_SEND_ROLL_NO_POST = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/submit_roll_no"
    const val API_HELP_AND_SUPPORT = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/help_support_data"
    const val API_ADD_MY_NOTES = BuildConfig.BASE_URL + "index.php/" + "data_model/notes/notes/notes"
    const val API_GET_MY_NOTES = BuildConfig.BASE_URL + "index.php/" + "data_model/notes/notes/get_notes_my_notes"
    const val API_DELETE_MY_NOTES = BuildConfig.BASE_URL + "index.php/" + "data_model/notes/notes/delete_my_notes"
    const val API_EDIT_MY_NOTES = BuildConfig.BASE_URL + "index.php/" + "data_model/notes/notes/edit_my_notes"
    const val API_ALL_DLP = BuildConfig.BASE_URL + "index.php/" + "data_model/dlp/dlp/get_dlp"
    const val API_DLP_CETEGORIES_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/dlp/dlp/get_dlp_categories"
    const val API_UPDATE_VIDEO_VIEW = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/course/update_video_view_time"
    const val API_BOOKMARK = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/exam/set_video_bookmark"
    const val API_SUBJECTIVE_QUESTIONS = BuildConfig.BASE_URL + "index.php/" + "data_model/test/retrieve_subjective_copies"
    const val API_SUBJECTIVE_SUBMIT = BuildConfig.BASE_URL + "index.php/" + "data_model/test/submit_subjective_copies"
    const val API_subjective_result = BuildConfig.BASE_URL + "index.php/" + "data_model/test/subjective_result"
    const val API_SUBJECTIVE_RESULT = BuildConfig.BASE_URL + "index.php/" + "data_model/courses/test_web/subjective_result"
    const val API_GENERATE_LEAD = BuildConfig.BASE_URL + "index.php/" + "data_model/lead_squared/generate_lead"
    const val API_GENERATE_ACTIVITY = BuildConfig.BASE_URL + "index.php/" + "data_model/lead_squared/generate_activity"

    // popup data
    const val get_filter_data = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_course_filters"
    const val get_demo_data = BuildConfig.BASE_URL + "index.php/" + "data_model/version/get_demo_data"
    const val get_liveclasses_data = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_live_videos"
    const val get_testclasses_data = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_live_tests"
    const val int_payment = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/f_payment"
    const val payment_gateway_credentials = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_pay_gateway"
    const val remove_course = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/remove_course"
    const val free_transaction = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/free_transaction"
    const val free_transaction_layer1 = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/free_transaction"
    const val video_link = BuildConfig.BASE_URL + "index.php/" + "data_model/revision/add_revision"

    ////////////////
    const val API_SUBMIT_TEST_SERIES = BuildConfig.BASE_URL + "index.php/" + "data_model/test/save_test"
    const val API_SUBMIT_TEST_LATER = BuildConfig.BASE_URL + "index.php/" + "data_model/test/save_test_later"
    const val API_GET_TEST_INSTRUCTION_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/test/get_instructions"
    const val API_GET_INFO_TEST_SERIES = BuildConfig.BASE_URL + "index.php/" + "data_model/test/get_test_data"
    const val MOBILE_CALCULATOR = BuildConfig.BASE_URL + "index.php/" + "data_model/test/mobile_calculator"
    const val challenge_submission = BuildConfig.BASE_URL + "index.php/" + "data_model/test/test_challenge"
    const val API_SUBMIT_QUERY = BuildConfig.BASE_URL + "index.php/" + "data_model/test/submit_query"
    const val API_TEST_RESULT = BuildConfig.BASE_URL + "index.php/" + "data_model/test/get_test_result"
    const val API_TEST_LEARN = BuildConfig.BASE_URL + "index.php/" + "data_model/test/get_test_learn"
    const val verifyCoupon = BuildConfig.BASE_URL + "index.php/" + "data_model/coupon/coupon_verification"
    const val API_TEST_LEADERBOARD = BuildConfig.BASE_URL + "index.php/" + "data_model/test/get_test_leaderboard"
    const val API_CREATE_TEST_RETRIVE_COURSE = BuildConfig.BASE_URL + "index.php/" + "data_model/test/retrieve_courses"
    const val API_CREATE_TEST_GET_SUBJECT = BuildConfig.BASE_URL + "index.php/" + "data_model/test/gen_get_course_subjects"
    const val API_CREATE_TEST_GET_QUES_COUNT = BuildConfig.BASE_URL + "index.php/" + "data_model/test/gen_get_que_count"
    const val API_CREATE_TEST_GET_TEST = BuildConfig.BASE_URL + "index.php/" + "data_model/test/gen_get_questions"
    const val get_notification_data = BuildConfig.BASE_URL + "index.php/" + "data_model/notification/get_notifications"
    const val mark_as_read = BuildConfig.BASE_URL + "index.php/" + "data_model/notification/mark_as_read"
    const val mark_as_allread = BuildConfig.BASE_URL + "index.php/" + "data_model/notification/set_all_read"
    const val delete_notification = BuildConfig.BASE_URL + "index.php/" + "data_model/notification/delete_notification"
    const val get_meta = BuildConfig.BASE_URL + "index.php/" + "data_model/poll/get_content_meta"
    const val get_file_names = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_file_names"
    const val add_video_index = BuildConfig.BASE_URL + "index.php/" + "data_model/poll/add_video_index"
    const val get_video_link = BuildConfig.BASE_URL + "index.php/" + "data_model/meta_distributer/on_request_meta_source"
    const val get_video_logging = BuildConfig.BASE_URL + "index.php/" + "data_model/course/video_logging"

    ///by mohit
    const val get_sign_test_link = BuildConfig.BASE_URL + "index.php/" + "data_model/meta_distributer/on_request_meta_source_direct"
    const val submitpoll = BuildConfig.BASE_URL + "index.php/" + "data_model/poll/submit_poll"
    const val delete_revision = BuildConfig.BASE_URL + "index.php/" + "data_model/revision/delete_revision"
    const val apply_coupon = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/apply_coupon"
    const val GET_MY_QUIRES = BuildConfig.BASE_URL + "index.php/" + "data_model/help_desk/get_my_queries"
    const val GET_SUBMIT_MY_QUIRES = BuildConfig.BASE_URL + "index.php/" + "data_model/help_desk/submit_query"
    const val GET_QUIRES_REPLIES = BuildConfig.BASE_URL + "index.php/" + "data_model/help_desk/get_query_replies"
    const val GET_SUBMIT_QUIRES_REPLIES = BuildConfig.BASE_URL + "index.php/" + "data_model/help_desk/submit_query_reply"
    const val update_profile = BuildConfig.BASE_URL + "index.php/" + "data_model/users/update_profile"
    const val get_my_orders = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_my_orders"
    const val get_book_orders = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/get_orderlist"
    const val delete_video_index = BuildConfig.BASE_URL + "index.php/" + "data_model/poll/delete_video_index"
    const val user_logout = BuildConfig.BASE_URL + "index.php/" + "data_model/users/logout"
    const val get_video_link_concept = BuildConfig.BASE_URL + "index.php/" + "data_model/meta_distributer/on_request_meta_source"
    const val create_annotation = BuildConfig.BASE_URL + "index.php/" + "data_model/meta_distributer/create_annotation"
    const val delete_annotation = BuildConfig.BASE_URL + "index.php/" + "data_model/meta_distributer/delete_annotation"
    const val getchangedetecter = BuildConfig.BASE_URL + "index.php/" + "data_model/change_detector/get_api_versions"
    const val CourseDetail_JS = BuildConfig.BASE_URL + "index.php/" + "data_model/course_deprecated/get_course_detail"
    const val API_GET_EXTRA_CLASS_DATA = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_extraclasses"

    //Student Enrollment
    const val API_COMPLETE_ENROLLMENT = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/payment_profile"

    //CurrentAffair
    const val API_GET_CURRENT_AFFAIR = BuildConfig.BASE_URL + "index.php/" + "data_model/current_affairs/current_affair_list"
    const val API_GET_CURRENT_AFFAIR_DETAILS = BuildConfig.BASE_URL + "index.php/" + "data_model/current_affairs/current_affair_get_details"
    const val API_GET_USER_SUPPORT_CATEGORY = BuildConfig.BASE_URL + "index.php/" + "data_model/user_support/get_user_support_category"
    const val API_POST_USER_SUPPORT = BuildConfig.BASE_URL + "index.php/" + "data_model/user_support/post_user_support"
    const val API_GET_USER_DOUBT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/doubt_main" // doubt_list
    const val API_GET_DOUBT_SUBJECT_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/subject" // doubt_subject
    const val API_GET_POST_DOUBT = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/post_doubt" //post_doubt
    const val API_GET_DOUBT_REPLY = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/user_reply" //Doubt_Chat
    const val API_GET_DOUBT_RESOLVE_STATUS = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/change_resolve_status" //Doubt_resolve_status
    const val API_GET_CHECK_ISBN = BuildConfig.BASE_URL + "index.php/" + "data_model/doubt_section/verify_isbn" //check isbn

    //Book Mark
    const val API_ADD_TO_BOOKMARK = BuildConfig.BASE_URL + "index.php/" + "data_model/course/create_bookmark"

    // custom payment
    const val API_GET_BOOKMARK_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/course/bookmark_list"

    //FAQ
    const val API_GET_FAQ = BuildConfig.BASE_URL + "index.php/" + "data_model/course/get_faq"
    const val API_Redeem_Reward_Point = BuildConfig.BASE_URL + "index.php/" + "payment/redeem_activity_reward"
    const val CONTACT_US_URL = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/save_contact_us"
    const val GET_CONTACT_US_LIST_URL = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_contact_list"
    const val SAVE_CONTACT_US_LIST_URL = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/save_contact_us_reply"
    const val GET_CONTACT_US_REPLY_LIST_URL = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/get_contact_reply_list"

    //Ratting
    const val COURSE_REVIEW_LIST = BuildConfig.BASE_URL + "index.php/" + "data_model/course/course_review_list"
    const val POST_COURSE_REVIEW = BuildConfig.BASE_URL + "index.php/" + "data_model/course/post_course_review"
    const val BANNER_FEED = BuildConfig.BASE_URL + "index.php/" + "data_model/master_hit/banner_feed"

    //Cart
    const val COURSE_ADD_TO_CART = BuildConfig.BASE_URL + "index.php/" + "data_model/cart/addToCart"
    const val COURSE_CART_COUNT = BuildConfig.BASE_URL + "index.php/" + "data_model/cart/cartcount"
    const val COURSE_SHOW_CART = BuildConfig.BASE_URL + "index.php/" + "data_model/cart/showcart"
    const val COURSE_REMOVE_ITEM = BuildConfig.BASE_URL + "index.php/" + "data_model/cart/removeitem"

    //Reward
    const val GET_REWARD_POINT = BuildConfig.BASE_URL + "index.php/" + "data_model/users/get_reward_transaction"
    const val API_DOWNLOAD_CERTIFICATE = BuildConfig.BASE_URL + "index.php/" + "data_model/course/generate_test_certificate"
    const val Installment_Details = BuildConfig.BASE_URL + "index.php/" + "data_model/payment/pending_installment"
    const val update_preference = BuildConfig.BASE_URL + "index.php/" + "data_model/users/update_preference"
    const val API_GET_CHECKSUM_FOR_PAYTM: String = BuildConfig.BASE_URL + "Paytm/generateChecksum.php?SERVER=%s"

    // Staging Paytm Trn API
    // String API_FINAL_TRANSACTION_FOR_PAYTM = "http://emedicoz.com/Paytm/TxnStatus.php?MID=%s&ORDERID=%s&SERVER=%s";
    const val API_FINAL_TRANSACTION_FOR_PAYTM: String = BuildConfig.BASE_URL + "Paytm/TxnStatus.php?MID=%s&ORDERID=%s&SERVER=%s"
    const val API_GET_SINGLE_VIDEO_DATA2 = "data_model/video/Video_channel/get_single_video_data"
    const val API_GET_POPUP_DATA = "data_model/popup/get_popupdata"
    const val API_POPUP_DATA_COLLECTION = "data_model/popup/popupdata_collection"
    const val GET_COUPON_OVER_COURSE = "data_model/coupon/get_coupon_over_course"

    //COUPON||||||||||||||||||||\\\\\\\\\\\\\\\\
    const val IS_COUPON_AVAILABLE = "data_model/coupon/is_coupon_available"
    const val API_GET_COUPON = "data_model/coupon/get_coupon"
    const val API_activate_course = "data_model/course/activate_course"
    const val API_get_paid_course = "data_model/course/get_paid_course"
    const val API_Check_Installment_Status = "data_model/course/common"
    const val API_Installment_Course_List = "data_model/course/get_list_of_my_installmentcourses"
    const val API_RECENT_WATCH = "data_model/meta_distributer/get_recent_watch_video"
    const val GET_USER_ADDRESS = "data_model/payment/get_user_address"
    const val SAVE_USER_ADDRESS = "data_model/payment/save_user_address"
    const val DELETE_USER_ADDRESS = "data_model/payment/delete_user_address"
    const val API_ATTEND_EVENT = "data_model/master_hit/attend_event"
}