package com.google.sample.cloudvision;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.sample.cloudvision.MainActivity;
import com.google.sample.cloudvision.dao.BottleDAO;
import com.google.sample.cloudvision.models.Bottle;

import java.util.List;

public class ListActivity extends Activity {
    private TableLayout tableLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_base);
        tableLayout=(TableLayout)findViewById(R.id.tableLayout);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.photo_extra_layout);

        ImageButton returnButton = findViewById(R.id.menuButton2);
        returnButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        });

        // get app database
        ApplicationDatabase data = MainActivity.getDatabase();
        BottleDAO dataDAO = data.getBottleDAO();
        // get bottles from DAO connected to database
        List<Bottle> bottlesAll = dataDAO.getBottlesAll();

        for (int i = bottlesAll.size(); i-- > 0; ) {
            Bottle bottle = bottlesAll.get(i);
//            System.out.println( bottle.getLabelNames() ); // to delete

            // create row
            View tableRow = LayoutInflater.from(this).inflate(R.layout.photo_base_table, null,false);
//            TextView id  = (TextView) tableRow.findViewById(R.id.id);
            TextView name  = (TextView) tableRow.findViewById(R.id.name);
            TextView description  = (TextView) tableRow.findViewById(R.id.description);

            // set values to row
//            id.setText(Long.toString(bottle.getId()));
            name.setText(bottle.getName());
            description.setText(bottle.getLabelNames());

            // add row to view
            tableLayout.addView(tableRow);
        }

    }
}
