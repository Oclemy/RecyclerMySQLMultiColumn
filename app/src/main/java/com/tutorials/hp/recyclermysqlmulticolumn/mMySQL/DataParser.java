package com.tutorials.hp.recyclermysqlmulticolumn.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tutorials.hp.recyclermysqlmulticolumn.mDataObject.Spacecraft;
import com.tutorials.hp.recyclermysqlmulticolumn.mRecycler.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    RecyclerView rv;
    String jsonData;

    ProgressDialog pd;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();


    public DataParser(Context c, RecyclerView rv, String jsonData) {
        this.c = c;
        this.rv = rv;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else
        {
            //BIND DATA USING ADAPTER
            MyAdapter adapter=new MyAdapter(c,spacecrafts);
            rv.setAdapter(adapter);
        }

    }

    private int parseData()
    {
        try {

            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            spacecrafts.clear();
            Spacecraft s=null;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String propellant=jo.getString("propellant");
                String description=jo.getString("description");

                s=new Spacecraft();
                s.setId(id);
                s.setName(name);
                s.setPropellant(propellant);
                s.setDescription(description);

                spacecrafts.add(s);

            }

            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}











