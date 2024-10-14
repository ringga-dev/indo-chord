package ngga.ring.remote.extensions

import android.util.Base64
import org.json.JSONObject
import java.io.UnsupportedEncodingException




fun decodeJWT(token: String): JSONObject? {
    try {
        // Token terdiri dari 3 bagian yang dipisahkan oleh titik.
        val split = token.split(".")
        if (split.size == 3) {
            val payload = split[1]

            // Decode Base64Url (Base64 yang disesuaikan untuk URL)
            val decodedBytes = Base64.decode(payload, Base64.URL_SAFE)
            val decodedString = String(decodedBytes, Charsets.UTF_8)

            // Ubah hasil decoding menjadi JSONObject
            return JSONObject(decodedString)
        }
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return null
}