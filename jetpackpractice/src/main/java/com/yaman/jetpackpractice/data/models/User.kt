package com.yaman.jetpackpractice.data.models

class User {
    var creationTime: String? = null
    var gender: String? = null
    var deviceId: String? = null
    var city: String? = null
    var mobile: String? = null
    var profilePicture: String? = null
    var cCode: String? = null
    var name: String? = null
    var id: String? = null
    var jwt: String? = null
    val version: String? = null
    var state: String? = null
    var lang: String? = null
    var email: String? = null
    var username: String? = null
    var status: String? = null
    var date_of_birth: String? = null
    var guardian_name: String? = null
    var guardian_number: String? = null
    var education_qualification: String? = null
    var pin_code: String? = null
    var aadhar_card: String? = null
    var ph_status: String? = null
    var alternate_number: String? = null
    var caste_category: String? = null
    var address: String? = null
    var gstin: String? = null
    var father_name: String? = null
    var father_contact: String? = null
    var proof_marksheet: String? = null

    class Preferences {
        var main_cat: String? = null
        var sub_cat: String? = null
    }

    var preferences: ArrayList<Preferences>? = null

}
