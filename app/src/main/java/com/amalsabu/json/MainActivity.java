package com.amalsabu.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.amalsabu.json.HelperClass.ExploreAdapter;
import com.amalsabu.json.HelperClass.ExploreModel;
import com.amalsabu.json.HelperClass.VolleySingleton;
import com.amalsabu.json.databinding.ActivityMainBinding;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static String JSON_URL = "https://run.mocky.io/v3/ee8eafce-a50c-496b-8875-ce607a3f06bf";
    private RequestQueue requestQueue;
    private List<ExploreModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list=new ArrayList<>();
        requestQueue= VolleySingleton.getmInstance(getApplicationContext()).getRequestQueue();

        exploreRecycler();
    }

    private void exploreRecycler() {

        binding.exploreRecycler.setHasFixedSize(true);
        binding.exploreRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        //Fetching data from server
        //Create a new String Request
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String heading=jsonObject.getString("heading");
                        String image=jsonObject.getString("cover_image");
                        String desc=jsonObject.getString("description");
                        Double ratingText=jsonObject.getDouble("rating");
                        Double rating=jsonObject.getDouble("rating");

                        //Create object of Model class
                        ExploreModel exploreModel= new ExploreModel(heading,image,desc,ratingText,rating);
                        list.add(exploreModel);

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                    ExploreAdapter adapter= new ExploreAdapter(getApplicationContext(),list);
                    binding.exploreRecycler.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //To execute the request we need request queue
        requestQueue.add(jsonArrayRequest);
    }
}