package com.pomac.baseapplicationarch.data.service

import com.pomac.baseapplicationarch.data.model.ResponseModel
import com.pomac.baseapplicationarch.util.constants.Routs
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Services {
    @FormUrlEncoded
    @POST(Routs.SAMPLE_GET)
    suspend fun postData(
        @Field("phone") phone: String,
        @Field("country_code") countryCode: String,
    ): ResponseModel<Any>

    @GET(Routs.SAMPLE_GET)
    suspend fun getData(
        //@Query("phone") phone: String,
    ): ResponseModel<String>
}