package com.example.vybecosapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class SavedSarveys implements Parcelable {
    Integer ID;
    String period;
    String futureSlection;
    String contentBox;

    public SavedSarveys(int ID, String period, String futureSlection, String contentBox) {
        this.ID = ID;
        this.period = period;
        this.futureSlection = futureSlection;
        this.contentBox = contentBox;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFutureSlection() {
        return futureSlection;
    }

    public void setFutureSlection(String futureSlection) {
        this.futureSlection = futureSlection;
    }

    public String getContentBox() {
        return contentBox;
    }

    public void setContentBox(String contentBox) {
        this.contentBox = contentBox;
    }
    protected SavedSarveys(Parcel in) {
        if (in.readByte() == 0) {
            ID = null;
        } else {
            ID = in.readInt();
        }
        period = in.readString();
        futureSlection = in.readString();
        contentBox = in.readString();
    }
    public static final Creator<SavedSarveys> CREATOR = new Creator<SavedSarveys>() {
        @Override
        public SavedSarveys createFromParcel(Parcel in) {
            return new SavedSarveys(in);
        }

        @Override
        public SavedSarveys[] newArray(int size) {
            return new SavedSarveys[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (ID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ID);
        }
        dest.writeString(period);
        dest.writeString(futureSlection);
        dest.writeString(contentBox);
    }
}
