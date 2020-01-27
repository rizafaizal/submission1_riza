package com.rizafaizal.aplikasidaftarfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Films> films = new ArrayList<>();

    public void setFilms(ArrayList<Films> films) {
        this.films = films;
    }

    public FilmsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_filmku, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Films film = (Films) getItem(i);
        viewHolder.bind(film);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtJudul, txtGenre, txtScore, txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtJudul = view.findViewById(R.id.txt_judul_film);
            txtGenre = view.findViewById(R.id.txt_genre_film);
            txtScore = view.findViewById(R.id.txt_score_film);
            txtDesc = view.findViewById(R.id.txt_desc_film);
            imgPhoto = view.findViewById(R.id.img_photo_film);
        }

        void bind(Films film) {
            txtJudul.setText(film.getJudul());
            txtGenre.setText(film.getGenre());
            txtScore.setText(film.getScore());
            txtDesc.setText(film.getDesc());
            imgPhoto.setImageResource(film.getPhoto());
        }

    }

}
