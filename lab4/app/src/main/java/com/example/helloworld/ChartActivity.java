//package com.example.helloworld;
//import android.os.Bundle;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ChartActivity extends AppCompatActivity {
//   private WebView webview;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.chart);
//        webview = (WebView) findViewById((R.id.webview));
//        WebSettings webSettings = webview.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setLoadsImagesAutomatically(true);
//
//        String cases = "<img src=\"https://www.statista.com/graphic/1/1093256/novel-coronavirus-2019ncov-deaths-worldwide-by-country.jpg\" alt=\"Statistic: Number of novel coronavirus (COVID-19) deaths worldwide as of April 3, 2020, by country | Statista\" style=\"width: 100%; height: auto !important; max-width:1000px;-ms-interpolation-mode: bicubic;\"/><br />";
//        String deaths = "<img src=\"https://www.statista.com/graphic/1/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country.jpg\" alt=\"Statistic: Number of novel coronavirus (COVID-19) cases worldwide as of April 4, 2020, by country* | Statista\" style=\"width: 100%; height: auto !important; max-width:1000px;-ms-interpolation-mode: bicubic;\"/><br />";
//        String recoveried = "<img src=\"https://www.statista.com/graphic/1/1103227/coronavirus-recoveries-in-europe.jpg\" alt=\"Statistic: Number of individuals who have recovered from the coronavirus (COVID-19) in Europe as of April 3, 2020, by country | Statista\" style=\"width: 100%; height: auto !important; max-width:1000px;-ms-interpolation-mode: bicubic;\"/>";
//        String data =
//                "<!doctype html>\n" +
//                "<html>\n" +
//                "  <link rel=\"stylesheet\" href=\"css/styles.css?v=1.0\">\n" +
//                "  <head>\n" +
//                "  </head>\n" +
//                "  <body>\n" +
//                cases +
//                        deaths +
//                        recoveried +
//                "  </body>\n" +
//                "</html>";
//        webview.loadData(data, "text/html; charset=utf-8", "UTF-8");
//    }
//}
