package `in`.codeshuffle.typewriterview

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.util.AttributeSet
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

/**
 * Created by P Sandesh Baliga in Koramangala on 21/02/2018.
 */
class TypeWriterView(private val mContext: Context?, attrs: AttributeSet?) : AppCompatTextView(mContext, attrs) {

    constructor(context: Context?) : this(context, null)

    private var mMediaPlayer: MediaPlayer? = null
    private var mText: CharSequence? = null
    private var mPrintingText: String? = null
    private var mIndex = 0
    private var mDelay: Long = 100 //Default 500ms delay
    private var mTypeWriterListener: TypeWriterListener? = null
    private var mWithMusic = true
    private var animating = false
    private var mBlinker: Runnable? = null
    private var i = 0
    private val mHandler = Handler()
    private val mCharacterAdder: Runnable = object : Runnable {
        override fun run() {
            if (animating) {
                text = mText!!.subSequence(0, mIndex++).toString() + "_"
                //typing typed
                if (mTypeWriterListener != null) mTypeWriterListener!!.onCharacterTyped(mPrintingText!!, mIndex)
                if (mIndex <= mText!!.length) {
                    mHandler.postDelayed(this, mDelay)
                } else {
                    if (mWithMusic) mMediaPlayer!!.stop()
                    //typing end
                    if (mTypeWriterListener != null) mTypeWriterListener!!.onTypingEnd(mPrintingText!!)
                    animating = false
                    callBlink()
                }
            }
        }
    }

    private fun callBlink() {
        mBlinker = Runnable {
            if (i <= 10) {
                if (i++ % 2 != 0) {
                    text = String.format("%s _", mText)
                    mHandler.postDelayed(mBlinker, 150)
                } else {
                    text = String.format("%s   ", mText)
                    mHandler.postDelayed(mBlinker, 150)
                }
            } else i = 0
        }
        mHandler.postDelayed(mBlinker, 150)
    }

    /**
     * plays music of type writer as characters are displayed, using MediaPlayer API
     */
    private fun playMusic() {
        if (mWithMusic) {
            mMediaPlayer = MediaPlayer.create(context, R.raw.typing)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        }
    }

    /**
     * Call this function to display
     * @param text attribute
     */
    fun animateText(text: String?) {
        if (!animating) {
            animating = true
            mText = text
            mPrintingText = text
            mIndex = 0
            playMusic()
            setText("")
            mHandler.removeCallbacks(mCharacterAdder)
            //typing start
            if (mTypeWriterListener != null) mTypeWriterListener!!.onTypingStart(mPrintingText!!)
            mHandler.postDelayed(mCharacterAdder, mDelay)
        } else {
            //CAUTION: Already typing something..
            Toast.makeText(mContext, "Typewriter busy typing: $mText", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Call this function to set delay in MILLISECOND [20..150]
     * @param delay
     */
    fun setDelay(delay: Int) {
        if (delay >= 20 && delay <= 150) mDelay = delay.toLong()
    }

    /**
     * Whether to play music or not while animating
     * @param music
     */
    fun setWithMusic(music: Boolean) {
        mWithMusic = music
    }

    /**
     * Call this to remove animation at any time
     */
    fun removeAnimation() {
        mHandler.removeCallbacks(mCharacterAdder)
        if (mWithMusic && mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.stop()
        animating = false
        text = mPrintingText

        //typing removed
        if (mTypeWriterListener != null) mTypeWriterListener!!.onTypingRemoved(mPrintingText!!)
    }

    /**
     * Set listener to receive typing effects
     *
     * @param typeWriterListener
     */
    fun setTypeWriterListener(typeWriterListener: TypeWriterListener?) {
        mTypeWriterListener = typeWriterListener
    }
}