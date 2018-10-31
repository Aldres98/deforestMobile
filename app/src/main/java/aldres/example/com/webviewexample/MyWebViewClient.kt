package aldres.example.com.webviewexample

import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient : WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        view!!.loadUrl(("javascript:(function() { " +
                "document.getElementsByClassName('infoblock-inner')[0].style.display='none'; })()"))

        view.loadUrl(("javascript:(function() { " +
                "document.getElementsByClassName('logo-inner')[0].style.display='none'; })()"))

        view.loadUrl(("javascript:(function() { " +
                "document.getElementsByClassName('leaflet-control-layers')[0].style.display='none'; })()"))

        view.loadUrl(("javascript:(function() { " +
                "document.getElementsByClassName('actions-inner')[0].style.display='none'; })()"))

        view.loadUrl(("javascript:(function() { " +
                "document.getElementsByClassName('leaflet-control-easyPrint')[0].style.display='none'; })()"))

        view.loadUrl(("javascript:(function() { " +
                " map.addLayer(arendatorLayer); })()"))

        view.loadUrl(("javascript:(function() { " +
                " map.addLayer(google_virub); })()"))








    }

}