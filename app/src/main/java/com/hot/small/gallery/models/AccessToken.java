package com.hot.small.gallery.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liqy on 2016/7/13.
 */
public class AccessToken implements Parcelable {

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("expires_in")
    public Integer expiresIn;

    @SerializedName("refresh_token")
    public String refreshToken;

    @SerializedName("scope")
    public String scope;

    @SerializedName("created_at")
    public Integer createdAt;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accessToken);
        dest.writeString(this.tokenType);
        dest.writeValue(this.expiresIn);
        dest.writeString(this.refreshToken);
        dest.writeString(this.scope);
        dest.writeValue(this.createdAt);
    }

    public AccessToken() {
    }

    protected AccessToken(Parcel in) {
        this.accessToken = in.readString();
        this.tokenType = in.readString();
        this.expiresIn = (Integer) in.readValue(Integer.class.getClassLoader());
        this.refreshToken = in.readString();
        this.scope = in.readString();
        this.createdAt = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator<AccessToken>() {
        @Override
        public AccessToken createFromParcel(Parcel source) {
            return new AccessToken(source);
        }

        @Override
        public AccessToken[] newArray(int size) {
            return new AccessToken[size];
        }
    };
}
