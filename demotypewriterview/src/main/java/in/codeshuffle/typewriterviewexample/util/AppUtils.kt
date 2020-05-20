package `in`.codeshuffle.typewriterviewexample.util

import `in`.codeshuffle.typewriterviewexample.R
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import java.text.MessageFormat

object AppUtils {
    fun openPlayStoreForApp(context: Context?) {
        context?.let {
            val appPackageName = it.packageName
            try {
                it.startActivity(Intent(Intent.ACTION_VIEW,
                        Uri.parse(it.resources.getString(R.string.app_market_link) + appPackageName)))
            } catch (e: ActivityNotFoundException) {
                it.startActivity(Intent(Intent.ACTION_VIEW,
                        Uri.parse(it.resources.getString(R.string.app_google_play_store_link) + appPackageName)))
            }
        }
    }

    fun shareLibraryApp(context: Context?) {
        context?.let {
            try {
                val shareBody = MessageFormat.format("{0}: {1}\n\n{2}",
                        it.getString(R.string.here_is_an_interesting_library),
                        it.getString(R.string.library_app_name),
                        it.getString(R.string.library_app_description))
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.library_app_name))
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                it.startActivity(Intent.createChooser(sharingIntent, it.resources.getString(R.string.share_using)))
            } catch (e: Exception) {
                e.printStackTrace()
                showShortToast(it, "Something went wrong!")
            }
        }
    }

    fun showShortToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}