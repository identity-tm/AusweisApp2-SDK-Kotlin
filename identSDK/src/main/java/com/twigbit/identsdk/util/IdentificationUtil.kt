/*
 * Copyright (c) 2018. Moritz Morgenroth- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Moritz Morgenroth <development@moritzmorgenroth.de>
 */

package com.twigbit.identsdk.util

import com.google.gson.Gson
import java.net.URLEncoder

object IdentificationUtil {
    const val MSG_ACCESS_RIGHTS = "ACCESS_RIGHTS"
    const val MSG_ENTER_PIN = "ENTER_PIN"
    const val MSG_ENTER_PUK = "ENTER_PUK"
    const val MSG_ENTER_CAN = "ENTER_CAN"
    const val MSG_INSERT_CARD = "INSERT_CARD"
    const val MSG_BAD_STATE = "BAD_STATE"
    const val MSG_READER = "READER"
    const val MSG_CUSTOM_URL = "URL"
    const val MSG_AUTH = "AUTH"
    const val CMD_RUN_AUTH = "RUN_AUTH"
    const val CMD_GET_CERTIFICATE = "GET_CERTIFICATE"
    const val CMD_ACCEPT = "ACCEPT"
    const val CMD_CANCEL = "CANCEL"
    const val CMD_GET_READER = "GET_READER_LIST"
    const val CMD_SET_PIN = "SET_PIN"
    const val CMD_SET_PUK = "SET_PUK"
    const val CMD_SET_CAN = "SET_CAN"
    const val PARAM_TCTOKEN = "tcTokenURL"
    const val PARAM_VALUE = "value"


    val gson = Gson()
    fun parseJson(msg: String): Message? {
        return gson.fromJson(msg, Message::class.java)
    }

    fun buildTokenUrl(redirectUrl: String, clientId: String): String {
        return "https://ref-ausweisident.eid-service.de/oic/authorize?scope=FamilyNames+GivenNames+AcademicTitle+PlaceOfBirth+DateOfBirth+PlaceOfResidence+&response_type=code&redirect_uri=${URLEncoder.encode(redirectUrl, "UTF-8")}&state=123456&&client_id=$clientId&acr_values=integrated"
    }
}

class Command {
    val cmd: String = ""
}

class Message {
    val msg: String = ""
    val name: String = ""
    val card: Card? = null
    val result: Result? = null

    override fun toString(): String {
        return "Message(msg='$msg', name='$name', result='$result',  card='$card')"
    }
}

class Card {
    val deactivated: Boolean = true;
    val inoperative: Boolean = false;
    val retryCounter: Int = -1;
    override fun toString(): String {
        return "Card(deactivated=$deactivated, inoperative=$inoperative, retryCounter=$retryCounter)"
    }

}

class Result {
    val major: String = ""
    val url: String = ""
    val description: String = ""

    override fun toString(): String {
        return "Result(major='$major', url='$url', description='$description' )"
    }
}

enum class IdentMode {
    PIN,
    PUK,
    CAN
}
