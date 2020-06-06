package com.example.cdots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        final Intent intent = getIntent();

        final TextView textView = (TextView) findViewById(R.id.textView);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://173.193.85.182:31711/grocery";


//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        textView.setText(response.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!" + error);
//            }
//        });
//        try {
//
//            JSONObject jsonBody = new JSONObject();
//            jsonBody.put("name", intent.getExtras().get("name_key"));
//            jsonBody.put("mobile", intent.getExtras().get("mobile_number_key"));
//            jsonBody.put("email", intent.getExtras().get("email_key"));
//            jsonBody.put("address", intent.getExtras().get("address_key"));
//            jsonBody.put("grocery_list", intent.getExtras().get("grocery_list_key"));
//            final String requestBody = jsonBody.toString();

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string
                            textView.setText(response);
                            textView.setMovementMethod(new ScrollingMovementMethod());
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("That didn't work!" + error);
                }

            })
            {
                protected Map<String, String> getParams() {
                    Map<String, String> MyData = new HashMap<String, String>();

                    System.out.println("***********************\n");

                    //System.out.println(intent.getStringExtra("com.example.cdots.MESSAGE"));
                    MyData.put("name", intent.getExtras().getString(MainActivity.name_key));
                    MyData.put("mobile", intent.getExtras().getString(MainActivity.mobile_number_key));
                    MyData.put("mail", intent.getExtras().getString(MainActivity.email_key));
                    MyData.put("address", intent.getExtras().getString(MainActivity.address_key));
                    MyData.put("grocery_list", intent.getExtras().getString(MainActivity.grocery_list_key));
                    return MyData;
                }
            };


            // Add the request to the RequestQueue.
            queue.add(stringRequest);



    }
}
