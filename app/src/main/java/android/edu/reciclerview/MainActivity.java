package android.edu.reciclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    android.edu.reciclerview.MyRecyclerViewAdapter adapter;
    android.support.v7.widget.RecyclerView recyclerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new android.edu.reciclerview.MyRecyclerViewAdapter(this,animalNames);
        recyclerView.setAdapter(adapter);
         /*
        adapter.setClickListener(this);
     */
    }

   public static void ItemClickListener(View v, String txt) {

       Toast.makeText(v.getContext(), "MAINACTIVITY -->  animal = " +txt, Toast.LENGTH_SHORT).show();
    }
}

