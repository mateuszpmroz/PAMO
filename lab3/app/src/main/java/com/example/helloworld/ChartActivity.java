package com.example.helloworld;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//
//public class JsObject {
//    private View loadingView;
//    private View view;
//    JsObject(View view, View loadingView){this.view = view;this.loadingView = loadingView;}
//    @JavascriptInterface
//    public void setVisible(){
//        runOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                view.setVisibility(View.VISIBLE);
//                loadingView.setVisibility(View.INVISIBLE);
//            }
//        });
//    }
//}

public class ChartActivity extends AppCompatActivity {
   private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        webview = (WebView) findViewById((R.id.webview));
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        String data = "<html>\n" +
                "  <head>\n" +
                "  </head>\n" +
                "  <body>\n" +
                " <div id=\"test\">Chart COVID-19</div>   <div id=\"piechart\" style=\"width: 300px; height: 150px;\"></div>\n" +
                "  </body>\n" +
                "</html>";
        webview.loadDataWithBaseURL(null,data, "text/html", "UTF-8",null);
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "yeah", Toast.LENGTH_SHORT).show();
                view.loadUrl("javascript:(function(){" +
                        "var script = document.createElement('script');\n" +
                        "document.head.appendChild(script);" +
                        "script.onload = function () {\n" +
                        "document.getElementById(\"test\").innerHTML = \"asd\";" +
                        " google.charts.load('current', {'packages':['corechart']});\n" +
                        "      google.charts.setOnLoadCallback(drawChart);\n" +
                        "\n" +
                        "      function drawChart() {\n" +
                        "\n" +
                        "        var data = google.visualization.arrayToDataTable([\n" +
                        "          ['Task', 'Hours per Day'],\n" +
                        "          ['Work',     11],\n" +
                        "          ['Eat',      2],\n" +
                        "          ['Commute',  2],\n" +
                        "          ['Watch TV', 2],\n" +
                        "          ['Sleep',    7]\n" +
                        "        ]);\n" +
                        "\n" +
                        "        var options = {\n" +
                        "          title: 'My Daily Activities'\n" +
                        "        };\n" +
                        "\n" +
                        "        var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n" +
                        "\n" +
                        "        chart.draw(data, options);\n" +
                        "      }" +
                        "};\n" +
                        "script.src = \"https://www.gstatic.com/charts/loader.js\";\n" +
                        "\n" +
                        "})();");

                webview.setVisibility(View.INVISIBLE);
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
