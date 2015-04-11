package com.example.mahipal.myspinner;


import android.os.Bundle;
import android.view.Menu;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    boolean firstTime = true;
    ImageView RoseView;
    ImageView OrchidView;
    ImageView SunflowerView;
    ImageView HyacinthView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RoseView.setVisibility(RoseView.INVISIBLE);
        //OrchidView.setVisibility(OrchidView.INVISIBLE);
        //SunflowerView.setVisibility(SunflowerView.INVISIBLE);
        //HyacinthView.setVisibility(HyacinthView.INVISIBLE);


        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        final String[] flowerName = {"Rose", "Orchid", "Sunflower", "Hyacinth"};




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                flowerName
        );



        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstTime) {
                    firstTime = false;
                    return;
                }

                if (position == 0) {
                    RoseView.setVisibility(RoseView.VISIBLE);
                } else if (position == 1) {
                    OrchidView.setVisibility(OrchidView.VISIBLE);
                } else if (position == 2) {
                    SunflowerView.setVisibility(SunflowerView.VISIBLE);
                } else if (position == 3) {
                    HyacinthView.setVisibility(HyacinthView.VISIBLE);
                } else {
                }

                //RoseView.setVisibility(RoseView.INVISIBLE);
//OrchidView.setVisibility(OrchidView.INVISIBLE);
//SunflowerView.setVisibility(SunflowerView.INVISIBLE);
//HyacinthView.setVisibility(HyacinthView.INVISIBLE);}


                String s = "Selected " + parent.getItemAtPosition(position)
                        + ", position = " + position
                        + ", id = " + id + ".";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String s = "Spinner contains no selected item.";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
