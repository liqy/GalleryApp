package com.hot.small.gallery.oauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.hot.small.gallery.Config;

/**
 * Created by liqy on 2016/7/13.
 */
public class UnsplashOauth {
    private Activity activity;

    public UnsplashOauth(Activity activity) {
        this.activity = activity;
    }

    public void oauth() {
        Intent intent = new Intent(Intent.ACTION_VIEW, getAuthUri());
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.startActivity(intent);
    }

    private Uri getAuthUri() {
        String query = "authorize?client_id=%1$s&redirect_uri=%2$s&scope=%3$s&response_type=code";
        String url = Config.AUTHORIZATION_BASE_URL + String.format(query, Config.CLIENT_ID, Config.REDIRECT_URI, Config.CLIENT_SCOPE);
        return Uri.parse(url);
    }

    public void onResumeCallBack(Uri uri) {
        if (uri != null && uri.toString().startsWith(Config.REDIRECT_URI)) {
            String code = uri.getQueryParameter("code");
            if (code != null) {
                //TODO 已授权
                // request access token after user authorization

            } else {
                // check if authorization was denied by user (error=access_denied)
                String error = uri.getQueryParameter("error");
                if (error != null && error.equals("access_denied")) {
                    //TODO 未授权
                }
            }
        }
    }
}
