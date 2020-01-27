package com.rizafaizal.aplikasidaftarfilm;

import android.os.Parcel;
import android.os.Parcelable;

public class Films implements Parcelable {

    private String judul;
    private String genre;
    private String score;
    private String desc;
    private int photo;

    public Films(Parcel in) {
        judul = in.readString();
        genre = in.readString();
        score = in.readString();
        desc = in.readString();
        photo = in.readInt();
    }

    public Films() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(genre);
        dest.writeString(score);
        dest.writeString(desc);
        dest.writeInt(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Films> CREATOR = new Creator<Films>() {
        @Override
        public Films createFromParcel(Parcel in) {
            return new Films(in);
        }

        @Override
        public Films[] newArray(int size) {
            return new Films[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
