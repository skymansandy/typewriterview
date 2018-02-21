package in.codeshuffle.typewriterview;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by P SANDESH BALIGA in Roshan Hospitality, Koramangala on 21/02/2018.
 */

public class TypeWriterView extends AppCompatTextView {

    private MediaPlayer mPlayer;

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 100; //Default 500ms delay

    private Context c;

    private Runnable mBlinker;
    private int i = 0;

    public TypeWriterView(Context context) {
        super(context);
        c = context;
    }

    public TypeWriterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++) + "_");
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            } else {
                mPlayer.stop();
                callBlink();
            }
        }
    };

    private void callBlink() {
        mBlinker = new Runnable() {
            @Override
            public void run() {
                if (i <= 10) {
                    if (i++ % 2 != 0) {
                        setText(mText + " _");
                        mHandler.postDelayed(mBlinker, 150);
                    } else {
                        setText(mText + "   ");
                        mHandler.postDelayed(mBlinker, 150);
                    }
                } else
                    i = 0;
            }
        };
        mHandler.postDelayed(mBlinker, 150);
    }

    private void playMusic() {
        mPlayer = MediaPlayer.create(getContext(), R.raw.typing);
        mPlayer.setLooping(true);
        mPlayer.start();
    }


    public void animateText(String text) {
        mText = text;
        mIndex = 0;
        playMusic();
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setDelay(int delay)
    {
        if(delay>=20&&delay<=150)
            this.mDelay=delay;
    }

    public void removeCalls() {
        mHandler.removeCallbacks(characterAdder);
    }
}