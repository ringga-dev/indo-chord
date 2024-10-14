/******************************************************************************
 *  Copyright (c) 2023.                                                       *
 *  @author  : Ringga Septia Pribadi                                          *
 *  Web      : https://ringga-dev.github.io/                                  *
 *  Email    : ringgadev@gmail.com                                            *
 *  Github   : https://github.com/ringga-dev                                  *
 *                                                                            *
 *                                                                            *
 *  Tanggal Pembuatan:  11/22/23, 8:58 AM(Json.kt)                            *
 ******************************************************************************/

package ngga.ring.remote.extensions

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//----- Gson() needed
fun <T> String?.toDataModel(typeToken: TypeToken<T>): T? =
    try {
        Gson().fromJson(this ?: "", typeToken.type)
    } catch (e: Exception) {
        Log.e(TAG,"toDataModel : $e\ntheJson : $this")
        null
    }

fun <T> String?.toDataModel(classOfT: Class<T>, nullInException: Boolean = false): T? =
    try {
        Gson().fromJson(this ?: "", classOfT)
    } catch (e: Exception) {
        Log.e(TAG,"toDataModel : $e\ntheJson : $this")
        if (nullInException) null
        else classOfT.newInstance()
    }


fun <T> String?.toDataModelList(classOfT: Class<T>, nullInException: Boolean = false): List<T>? =
    try {
        val gson = Gson()
        val type = object : TypeToken<List<T>>() {}.type
        gson.fromJson(this ?: "", type)
    } catch (e: Exception) {
        Log.e(TAG,"toDataModelList : $e\ntheJson : $this")
        if (nullInException) null
        else emptyList()
    }


fun Any?.toJson(): String {
    return Gson().toJson(this)
}
