package com.example.marvel.data.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {

    const val BASE_URL="https://gateway.marvel.com/"
     val timeStamp= Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = "37890823f36ad43a9eea581b2285049b"
    const val PRIVATE_KEY = "80c2cc942202aaf685e42527a5f098fdbac1e811"
    const val limit = "5"
    const val offset = "20"

    const val CHARACTER_END_POINT="/v1/public/characters"

    fun hash(): String {
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

}