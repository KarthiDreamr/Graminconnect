package com.example.gramincare.components

import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun BingMap() {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.apply {
                javaScriptEnabled = true
                setGeolocationEnabled(true)
            }
            webChromeClient = object : WebChromeClient() {
                override fun onGeolocationPermissionsShowPrompt(
                    origin: String,
                    callback: GeolocationPermissions.Callback
                ) {
                    callback.invoke(origin, true, false)
                }
            }
            loadDataWithBaseURL(null, """
                <!DOCTYPE html>
                <html>
                <head>
                    <title></title>
                    <meta charset="utf-8" />
                    <script type='text/javascript'
                    src='https://www.bing.com/api/maps/mapcontrol?callback=GetMap&key=YOUR_BING_MAPS_KEY' 
                    async defer></script>
                    <script type='text/javascript'>
                    function GetMap()
                    {
                        var map = new Microsoft.Maps.Map(document.getElementById('myMap'), {
                            credentials: 'Agk8_TlNOjusAEKMyoAJ6sW2CoNtPLpbYjZM_xo5AMbGIp0J1RbmW8kKsoplzUvg',
                            showLocateMeButton: true
                        });
                        map.setView({ center: new Microsoft.Maps.Location(11.074800, 77.002100), zoom: 18 });
                    }
                    </script>
                </head>
                <body>
                    <div id="myMap" style="position:relative;width:100%;height:800px;"></div>
                </body>
                </html>
            """, "text/html", "UTF-8", null
            )
        }
    })
}