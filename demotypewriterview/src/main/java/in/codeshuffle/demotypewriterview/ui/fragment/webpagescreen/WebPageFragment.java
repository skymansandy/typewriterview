package in.codeshuffle.demotypewriterview.ui.fragment.webpagescreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import in.codeshuffle.demotypewriterview.util.AppConstants;
import in.codeshuffle.demotypewriterview.databinding.FragmentWebpageBinding;

public class WebPageFragment extends DialogFragment {

    private static final String CONTENT_TYPE = "contentType";

    private FragmentWebpageBinding binding;

    private WebChromeClient mChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (!isAdded()) return;
            binding.progressBar.setProgress(newProgress);
        }
    };
    private WebViewClient mWebClient = new WebViewClient() {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (!isAdded()) return;
            binding.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (!isAdded()) return;
            binding.progressBar.setVisibility(View.GONE);
        }
    };


    public static WebPageFragment getInstance(WebPageContent content) {
        Bundle bundle = new Bundle();
        WebPageFragment webPageFragment = new WebPageFragment();
        bundle.putSerializable(CONTENT_TYPE, content);
        webPageFragment.setArguments(bundle);
        return webPageFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWebpageBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            setupWebViewDefaults();
            Bundle bundle = getArguments();
            if (bundle != null) {
                WebPageContent content = (WebPageContent) bundle.getSerializable(CONTENT_TYPE);
                content = (content == null) ? WebPageContent.PAGE_VIEW_IN_GITHUB : content;
                switch (content) {
                    case PAGE_VIEW_ABOUT_LIBRARY:
                        binding.webView.loadUrl(AppConstants.URLs.VIEW_READ_ME);
                        break;
                    case PAGE_VIEW_IN_GITHUB:
                        binding.webView.loadUrl(AppConstants.URLs.GITHUB_REPO_URL);
                        break;
                    case PAGE_ISSUE_AND_FEEDBACK:
                        binding.webView.loadUrl(AppConstants.URLs.ISSUE_FEEDBACK_URL);
                        break;
                    case PAGE_DONATE_BEER:
                        binding.webView.loadUrl(AppConstants.URLs.DONATE_BEER_URL);
                        break;
                }
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebViewDefaults() {
        binding.webView.setWebChromeClient(mChromeClient);
        binding.webView.setWebViewClient(mWebClient);
        //Settings
        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
