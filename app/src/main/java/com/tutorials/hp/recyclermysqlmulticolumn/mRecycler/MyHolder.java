package com.tutorials.hp.recyclermysqlmulticolumn.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tutorials.hp.recyclermysqlmulticolumn.R;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyHolder extends RecyclerView.ViewHolder {

    TextView nameTxt,propellantTxt,descTxt;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        propellantTxt= (TextView) itemView.findViewById(R.id.propellantTxt);
        descTxt= (TextView) itemView.findViewById(R.id.descTxt);
    }
}
