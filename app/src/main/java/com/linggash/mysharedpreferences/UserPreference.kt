package com.linggash.mysharedpreferences

import android.content.Context

internal class UserPreference(context: Context) {

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = preferences.edit()
        editor.apply {
            putString(NAME, value.name)
            putString(EMAIL, value.email)
            putInt(AGE, value.age)
            putString(PHONE_NUMBER, value.phoneNumber)
            putBoolean(LOVE_MU, value.isLove)
            editor.apply()
        }
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.apply {
            name = preferences.getString(NAME, "")
            email = preferences.getString(EMAIL, "")
            age = preferences.getInt(AGE, 0)
            phoneNumber = preferences.getString(PHONE_NUMBER, "")
            isLove = preferences.getBoolean(LOVE_MU, false)
        }
        return model
    }

    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val LOVE_MU = "islove"
    }
}
