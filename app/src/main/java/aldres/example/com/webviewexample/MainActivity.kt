package aldres.example.com.webviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.webkit.WebView
import android.widget.CompoundButton
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mWebView: WebView = findViewById(R.id.webview)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        mDrawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }
        var nav: NavigationView = findViewById(R.id.nav_view)
        var oopt : Switch = nav.menu.findItem(R.id.oopt).actionView as Switch
        var ndvi : Switch = nav.menu.findItem(R.id.ndvi).actionView as Switch
        var notAllowed : Switch = nav.menu.findItem(R.id.not_allowed).actionView as Switch
        var moratory : Switch = nav.menu.findItem(R.id.moratory).actionView as Switch
        var rentals : Switch = nav.menu.findItem(R.id.rentals).actionView as Switch




        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = MyWebViewClient()
        mWebView.loadUrl("http://deforest.datamaplab.ru")

        oopt.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (b) {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.addLayer(ooptLayer); })()"))
            } else {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.removeLayer(ooptLayer); })()"))
            }

        }

        ndvi.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (b) {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.addLayer(ndvi); })()"))
            } else {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.removeLayer(ndvi); })()"))
            }

        }

        notAllowed.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (b) {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.addLayer(vyrubkaLayer); })()"))
            } else {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.removeLayer(vyrubkaLayer); })()"))
            }

        }


        moratory.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (b) {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.addLayer(moratoriiLayer); })()"))
            } else {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.removeLayer(moratoriiLayer); })()"))
            }

        }


        rentals.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (b) {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.addLayer(arendatorLayer); })()"))
            } else {
                mWebView.loadUrl(("javascript:(function() { " +
                        " map.removeLayer(arendatorLayer); })()"))
            }

        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
