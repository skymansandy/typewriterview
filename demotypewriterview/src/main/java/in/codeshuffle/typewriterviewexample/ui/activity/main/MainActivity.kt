package `in`.codeshuffle.typewriterviewexample.ui.activity.main

import `in`.codeshuffle.typewriterviewexample.R
import `in`.codeshuffle.typewriterviewexample.databinding.ActivityMainBinding
import `in`.codeshuffle.typewriterviewexample.ui.fragment.aboutdev.AboutDevFragment
import `in`.codeshuffle.typewriterviewexample.ui.fragment.demoscreen.DemoFragment
import `in`.codeshuffle.typewriterviewexample.ui.fragment.webpagescreen.WebPageContent
import `in`.codeshuffle.typewriterviewexample.ui.fragment.webpagescreen.WebPageFragment
import `in`.codeshuffle.typewriterviewexample.util.AppUtils
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val demoFragment by lazy { DemoFragment.getInstance() }
    private val aboutLibraryFragment by lazy { WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_ABOUT_LIBRARY) }
    private val githubFragment by lazy { WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_IN_GITHUB) }
    private val issueFeedBackFragment by lazy { WebPageFragment.getInstance(WebPageContent.PAGE_ISSUE_AND_FEEDBACK) }
    private val donateBeerFragment by lazy { WebPageFragment.getInstance(WebPageContent.PAGE_DONATE_BEER) }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(demoFragment)

        setupNavDrawer()
        setupActionbarWithToggle()
    }

    private fun setupActionbarWithToggle() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = getString(R.string.app_name)
        supportActionBar?.let {
            val mDrawerToggle = ActionBarDrawerToggle(
                    this, binding.drawerLayout, binding.toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close
            )
            binding.drawerLayout.setDrawerListener(mDrawerToggle)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
            mDrawerToggle.syncState()
        }
    }

    private fun setupNavDrawer() {
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.navMenuHome -> {
                replaceFragment(demoFragment)
                binding.toolbar.title = getString(R.string.app_name)
                menuItem.isChecked = true
            }
            R.id.navMenuAboutLibrary -> {
                replaceFragment(aboutLibraryFragment)
                binding.toolbar.title = getString(R.string.about_library)
                menuItem.isChecked = true
            }
            R.id.navMenuGithub -> {
                replaceFragment(githubFragment)
                binding.toolbar.title = getString(R.string.source_code)
                menuItem.isChecked = true
            }
            R.id.navMenuIssueFeedback -> {
                replaceFragment(issueFeedBackFragment)
                binding.toolbar.title = getString(R.string.issues_and_feedback)
                menuItem.isChecked = true
            }
            R.id.navMenuDonateBeer -> {
                replaceFragment(donateBeerFragment)
                binding.toolbar.title = getString(R.string.thanks_for_the_beer)
                AppUtils.showShortToast(this,
                        getString(R.string.thats_so_nice_of_you))
            }
            R.id.navMenuAbout -> {
                val aboutDevFragment: AboutDevFragment = AboutDevFragment.getInstance()
                aboutDevFragment.show(supportFragmentManager, aboutDevFragment.tag)
            }
            R.id.navMenuRateApp -> {
                AppUtils.openPlayStoreForApp(this)
                AppUtils.showShortToast(this,
                        getString(R.string.thanks_for_the_support))
            }
            R.id.navMenuShareApp -> AppUtils.shareLibraryApp(this)
        }
        binding.drawerLayout.closeDrawers()
        return true
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        AppUtils.showShortToast(this, getString(R.string.press_back_to_exit))
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun replaceFragment(instance: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, instance)
        fragmentTransaction.commit()
    }
}