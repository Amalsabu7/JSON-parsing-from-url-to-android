package com.amalsabu.json.HelperClass;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private RequestQueue requestQueue;
    private static VolleySingleton mInstance;

    //Constructor creation
    private VolleySingleton(Context context){

        requestQueue= Volley.newRequestQueue(context.getApplicationContext());
    }

    //Create Instance of VolleySingleton
    public static synchronized VolleySingleton getmInstance(Context context){
        if (mInstance == null){
            mInstance=new VolleySingleton(context);
        }
        return mInstance;
    }

    //create a class that will return Request queue
    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
