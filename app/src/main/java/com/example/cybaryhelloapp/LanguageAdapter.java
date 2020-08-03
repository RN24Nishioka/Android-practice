package com.example.cybaryhelloapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> implements View.OnClickListener{

    String[] mLanguages;

    public  LanguageAdapter(String[] mLanguages){
        this.mLanguages = mLanguages;
    }


    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View languageView = inflater.inflate(R.layout.language_item, parent, false);

        languageView.setOnClickListener(this);

        LanguageViewHolder viewHolder = new LanguageViewHolder(languageView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        String currentLanguages = mLanguages[position];
        holder.txtLanguage.setText(currentLanguages);

    }

    @Override
    public int getItemCount() {
        return mLanguages.length;
    }

    @Override
    public void onClick(View v) {

        TextView txtLanguage = v.findViewById(R.id.txt_language);
        Context context = v.getContext();
        String currentLanguage = txtLanguage.getText().toString();
        Toast.makeText(context, currentLanguage, Toast.LENGTH_SHORT).show();

    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder{

        TextView txtLanguage;

        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLanguage = itemView.findViewById(R.id.txt_language);
        }
    }
}
