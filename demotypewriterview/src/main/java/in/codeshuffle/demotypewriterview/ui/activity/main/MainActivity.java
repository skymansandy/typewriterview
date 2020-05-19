package in.codeshuffle.demotypewriterview.ui.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import in.codeshuffle.demotypewriterview.R;
import in.codeshuffle.demotypewriterview.databinding.ActivityMainBinding;
import in.codeshuffle.demotypewriterview.ui.fragment.aboutdev.AboutDevFragment;
import in.codeshuffle.demotypewriterview.ui.fragment.demoscreen.DemoFragment;
import in.codeshuffle.demotypewriterview.ui.fragment.webpagescreen.WebPageContent;
import in.codeshuffle.demotypewriterview.ui.fragment.webpagescreen.WebPageFragment;
import in.codeshuffle.demotypewriterview.util.AppUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private DemoFragment demoFragment;
    private WebPageFragment aboutLibraryFragment;
    private WebPageFragment githubFragment;
    private WebPageFragment issueFeedBackFragment;
    private WebPageFragment donateBeerFragment;
    private boolean doubleBackToExitPressedOnce = false;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        setupFragments();
        setupNavDrawer();
        setupActionbarWithToggle();
    }

    private void setupActionbarWithToggle() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle(getString(R.string.app_name));
        if (getSupportActionBar() != null) {
            ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                    this, binding.drawerLayout, binding.toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close
            );
            binding.drawerLayout.setDrawerListener(mDrawerToggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            mDrawerToggle.syncState();
        }
    }

    private void setupNavDrawer() {
        binding.navView.setNavigationItemSelectedListener(this);
    }

    private void setupFragments() {
        demoFragment = DemoFragment.getInstance();
        aboutLibraryFragment = WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_ABOUT_LIBRARY);
        githubFragment = WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_IN_GITHUB);
        issueFeedBackFragment = WebPageFragment.getInstance(WebPageContent.PAGE_ISSUE_AND_FEEDBACK);
        donateBeerFragment = WebPageFragment.getInstance(WebPageContent.PAGE_DONATE_BEER);

        fragmentManager = getSupportFragmentManager();
        replaceFragment(demoFragment);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            binding.drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navMenuHome:
                replaceFragment(demoFragment);
                binding.toolbar.setTitle(getString(R.string.app_name));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuAboutLibrary:
                replaceFragment(aboutLibraryFragment);
                binding.toolbar.setTitle(getString(R.string.about_library));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuGithub:
                replaceFragment(githubFragment);
                binding.toolbar.setTitle(getString(R.string.source_code));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuIssueFeedback:
                replaceFragment(issueFeedBackFragment);
                binding.toolbar.setTitle(getString(R.string.issues_and_feedback));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuDonateBeer:
                replaceFragment(donateBeerFragment);
                binding.toolbar.setTitle(getString(R.string.thanks_for_the_beer));
                AppUtils.showShortToast(this,
                        getString(R.string.thats_so_nice_of_you));
                break;
            case R.id.navMenuAbout:
                AboutDevFragment aboutDevFragment = AboutDevFragment.getInstance();
                aboutDevFragment.show(getSupportFragmentManager(), aboutDevFragment.getTag());
                break;
            case R.id.navMenuRateApp:
                AppUtils.openPlayStoreForApp(this);
                AppUtils.showShortToast(this,
                        getString(R.string.thanks_for_the_support));
                break;
            case R.id.navMenuShareApp:
                AppUtils.shareLibraryApp(this);
                break;
        }
        binding.drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        AppUtils.showShortToast(this, getString(R.string.press_back_to_exit));

        new Handler().postDelayed(()
                -> doubleBackToExitPressedOnce = false, 2000);
    }

    private void replaceFragment(Fragment instance) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, instance);
        fragmentTransaction.commit();
    }
}
