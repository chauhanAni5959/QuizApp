package com.projectankit.quizapp.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.projectankit.quizapp.R;
import com.projectankit.quizapp.SubFragment;
import com.projectankit.quizapp.modelClass.HomeModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeModel> list;



    public HomeAdapter(Context context, ArrayList<HomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        HomeModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.des.setText(model.getDes());

//        if someone click on the category it does't give him back
        holder.itemView.setOnClickListener(v->{

            AppCompatActivity activity = (AppCompatActivity)  v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new SubFragment(model.getTitle())).addToBackStack(null).commit();

        });
    }


    //    To get the size of the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.Title);
           des = itemView.findViewById(R.id.des);
        }
    }
}
