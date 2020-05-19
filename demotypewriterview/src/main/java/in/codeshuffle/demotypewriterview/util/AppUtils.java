package in.codeshuffle.demotypewriterview.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.text.MessageFormat;

import in.codeshuffle.demotypewriterview.R;


public class AppUtils {

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }

    public static void shareLibraryApp(Context context) {
        try {
            String shareBody = MessageFormat.format("{0}: {1}\n\n{2}",
                    context.getString(R.string.here_is_an_interesting_library),
                    context.getString(R.string.library_app_name),
                    context.getString(R.string.library_app_description));
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.library_app_name));
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
        } catch (Exception e) {
            e.printStackTrace();
            showShortToast(context, "Something went wrong!");
        }
    }

    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
