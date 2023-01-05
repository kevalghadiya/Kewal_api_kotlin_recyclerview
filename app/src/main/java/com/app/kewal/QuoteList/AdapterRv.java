package com.app.kewal.QuoteList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kewal.R;

import java.util.ArrayList;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.RvHolder> {

    ArrayList<String> mList = new ArrayList<>();

    public AdapterRv(ArrayList<String> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one, parent, false);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        holder.tvText.setText(mList.size());
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class RvHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public RvHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
        }
    }
}
