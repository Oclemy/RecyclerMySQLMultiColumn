package com.tutorials.hp.recyclermysqlmulticolumn.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.recyclermysqlmulticolumn.R;
import com.tutorials.hp.recyclermysqlmulticolumn.mDataObject.Spacecraft;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public MyAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(spacecrafts.get(position).getName());
        holder.propellantTxt.setText(spacecrafts.get(position).getPropellant());
        holder.descTxt.setText(spacecrafts.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}
