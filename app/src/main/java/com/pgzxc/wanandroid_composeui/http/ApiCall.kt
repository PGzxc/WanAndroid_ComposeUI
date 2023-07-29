package com.pgzxc.wanandroid_composeui.http

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import com.pgzxc.wanandroid_composeui.api.IApi
import com.pgzxc.wanandroid_composeui.ext.Constants
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 *@desc：网络请求
 */
object ApiCall {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            //不验证证书
            .sslSocketFactory(createSSLSocketFactory(), TrustAllCerts())
            //.sslSocketFactory(createSSLSocketFactory())
            .hostnameVerifier(TrustAllNameVerifier())
            .cookieJar(Constants.persistentCookieJar)
            //.cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(WanApplication.context)))
            .build()
    }

    private val api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(IApi::class.java)
    }


    fun get(): IApi {
        return api
    }

    private fun createSSLSocketFactory(): SSLSocketFactory {
        lateinit var ssfFactory: SSLSocketFactory
        try {
            val sslFactory = SSLContext.getInstance("TLS")
            sslFactory.init(null, arrayOf(TrustAllCerts()), SecureRandom());
            ssfFactory = sslFactory.socketFactory
        } catch (e: Exception) {
            print("SSL错误：${e.message}")
        }
        return ssfFactory
    }
}

class TrustAllNameVerifier : HostnameVerifier {
    @SuppressLint("BadHostnameVerifier")
    override fun verify(hostname: String?, session: SSLSession?): Boolean = true
}

@SuppressLint("CustomX509TrustManager")
class TrustAllCerts : X509TrustManager {

    @SuppressLint("TrustAllX509TrustManager")
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
    }

    @SuppressLint("TrustAllX509TrustManager")
    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
}