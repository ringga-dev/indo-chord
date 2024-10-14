/******************************************************************************
 *  Copyright (c) 2023.                                                       *
 *  @author  : Ringga Septia Pribadi                                          *
 *  Web      : https://ringga-dev.github.io/                                  *
 *  Email    : ringgadev@gmail.com                                            *
 *  Github   : https://github.com/ringga-dev                                  *
 *                                                                            *
 *                                                                            *
 *  Tanggal Pembuatan:  11/22/23, 8:58 AM(string.kt)                          *
 ******************************************************************************/

package com.batamfast.remote.extensions


fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")

fun ellipsizeString(input: String, maxLength: Int): String {
    return if (input.length <= maxLength) {
        input
    } else input.substring(0, maxLength - 3) + "..."
}