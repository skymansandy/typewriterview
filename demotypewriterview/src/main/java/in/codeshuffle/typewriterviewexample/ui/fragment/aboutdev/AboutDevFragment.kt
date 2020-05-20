package `in`.codeshuffle.typewriterviewexample.ui.fragment.aboutdev

import `in`.codeshuffle.typewriterviewexample.databinding.FragmentAboutDevBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class AboutDevFragment : DialogFragment() {

    companion object {
        fun getInstance(): AboutDevFragment {
            val bundle = Bundle()
            val aboutDevFragment = AboutDevFragment()
            aboutDevFragment.arguments = bundle
            return aboutDevFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentAboutDevBinding.inflate(inflater).root
    }
}