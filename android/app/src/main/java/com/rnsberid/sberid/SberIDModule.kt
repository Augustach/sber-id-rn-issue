package com.rnsberid.sberid

import com.facebook.react.bridge.*
import sberid.sdk.auth.login.SberIDLoginManager
import sberid.sdk.auth.pkce.PkceUtils
import java.security.SecureRandom

val getParamOrEmpty: (ReadableMap) -> (String) -> String = { params -> { params.getString(it).orEmpty()}}

class SberIDModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = "SberIDModule"

    @ReactMethod
    fun getVerifyParams(promise: Promise) {
        val codeVerifier = PkceUtils.generateRandomCodeVerifier(SecureRandom())
        val codeChallenge = PkceUtils.deriveCodeVerifierChallenge(codeVerifier)
        val codeChallengeMethod = PkceUtils.getCodeChallengeMethod()
        val result = WritableNativeMap()
        result.putString("codeVerifier", codeVerifier)
        result.putString("codeChallenge", codeChallenge)
        result.putString("codeChallengeMethod", codeChallengeMethod)
        promise.resolve(result)
    }

    @ReactMethod
    fun loginWithSberID(params: ReadableMap, promise: Promise) {
        val sberIDButtonManager = SberIDLoginManager()
        val codeVerifier = PkceUtils.generateRandomCodeVerifier(SecureRandom())
        val codeChallenge = PkceUtils.deriveCodeVerifierChallenge(codeVerifier)
        val getParam = getParamOrEmpty(params)
        val activity = currentActivity

        if (activity == null) {
            promise.reject("SberIDModule", "No activity")
            return
        }

        val uri = SberIDLoginManager.sberIDBuilder()
            .clientID(getParam("client_id"))
            .scope(getParam("scope"))
            .state(getParam("state"))
            .nonce(getParam("nonce"))
            .redirectUri(getParam("redirect_uri"))
            .codeChallenge(getParam("code_challenge"))
            .codeChallengeMethod(getParam("code_challenge_method"))
            .build()

        SberIDLoginManager().loginWithSberbankID(activity, uri)
        promise.resolve(true)
    }
}