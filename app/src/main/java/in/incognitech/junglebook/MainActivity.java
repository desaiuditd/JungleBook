package in.incognitech.junglebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import in.incognitech.junglebook.model.Animal;
import in.incognitech.junglebook.model.AnimalAdapter;
import in.incognitech.junglebook.util.MenuController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] items = {
            "bat",
            "cat",
            "rat",
            "elephant",
            "panda",
            "frog",
            "snake",
            "monkey",
            "cow",
            "lion",
            "tiger",
            "man"
        };
        ListView listView = (ListView) findViewById(R.id.list_view_animal);

        List<Animal> animalList = new ArrayList<Animal>();
        String desc = getResources().getString( R.string.about_str_app_desc );
        for (String item : items) {
            animalList.add( new Animal( item, desc, item+".jpg" ) );
        }

        listView.setAdapter(new AnimalAdapter(this, R.layout.animal_row, animalList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ( position == AnimalAdapter.getAnimalList().size() - 1 ) {
                    ScaryDialog dialog = new ScaryDialog();
                    dialog.setAnimalID(position);
                    dialog.show( MainActivity.this.getFragmentManager(), getResources().getString(R.string.app_name) );
                } else {
                    Intent i = new Intent(getApplicationContext(), AnimalActivity.class);
                    i.putExtra("animal_id", position);
                    startActivity(i);
                }
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
        return MenuController.handleMenuItemSelection( super.onOptionsItemSelected(item), item, this );
    }
}
