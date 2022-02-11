package com.example.wikidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.j256.ormlite.stmt.query.In;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LandingActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.webProgressBar)
    ProgressBar webProgressBar;
    @BindView(R.id.tvTitle_toolbar)
    TextView tvTitle_toolbar;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;
    @BindView(R.id.ahbn)
    AHBottomNavigation ahbn;
    @BindView(R.id.ivSearch_toolbar)
    ImageView ivSearchToolbar;

    boolean isBack = false;

    public static void starMe(Context context) {
        context.startActivity(new Intent(context, LandingActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        setupBottomMenu();
    }

    private void setupBottomMenu() {

        ahbn.setTitleTextSizeInSp(9, 9);
        ahbn.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
        ahbn.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));
        ahbn.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahbn.setInactiveColor(Color.parseColor("#C0B8B6"));

        AHBottomNavigationItem item1 =
                new AHBottomNavigationItem(R.string.travel_all_caps, R.drawable.ic_travel_tab,
                        R.color.colorAccent);
        AHBottomNavigationItem item2 =
                new AHBottomNavigationItem(R.string.wine_all_caps, R.drawable.ic_wine_tab,
                        R.color.colorAccent);
        AHBottomNavigationItem item3 =
                new AHBottomNavigationItem(R.string.home_all_caps, R.drawable.ic_logo_tab,
                        R.color.colorAccent);
        AHBottomNavigationItem item4 =
                new AHBottomNavigationItem(R.string.shopping_all_caps, R.drawable.ic_shopping_tab,
                        R.color.colorAccent);
        AHBottomNavigationItem item5 =
                new AHBottomNavigationItem(R.string.wellness_all_caps, R.drawable.ic_wellness_tab,
                        R.color.colorAccent);

        ahbn.addItem(item1);
        ahbn.addItem(item2);
        ahbn.addItem(item3);
        ahbn.addItem(item4);
        ahbn.addItem(item5);

        ahbn.setOnTabSelectedListener((position, wasSelected) -> {

            switch (position) {
                case 0 : {
                    if (isBack == false){
//                        webView.loadUrl(WebViewURL.TRAVEL);
                    }
                    return true;
                }
                case 1 : {
                    if (isBack == false){
//                        webView.loadUrl(WebViewURL.WINE_DINE);
                    }
                    return true;
                }
                case 2 : {
                    if (isBack == false){
//                        webView.loadUrl(WebViewURL.DEFAULT);
                    }
                    return true;
                }
                case 3 : {
                    if (isBack == false){
//                        webView.loadUrl(WebViewURL.SHOPPING);
                    }
                    return true;
                }
                case 4 : {
                    if (isBack == false){
//                        webView.loadUrl(WebViewURL.WELLNESS);
                    }
                    return true;
                }
            }

            return false;
        });
    }
}