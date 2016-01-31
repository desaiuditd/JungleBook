package in.incognitech.junglebook;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import in.incognitech.junglebook.model.Animal;
import in.incognitech.junglebook.model.AnimalAdapter;
import in.incognitech.junglebook.util.BitmapOptimizer;
import in.incognitech.junglebook.util.MenuController;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int animalID = extras.getInt("animal_id");
            Animal animal = AnimalAdapter.getAnimalList().get(animalID);
            this.getSupportActionBar().setTitle(getResources().getString(R.string.app_name)+ " - " + animal.getName());
            TextView title = (TextView) findViewById(R.id.animal_title);
            title.setText(animal.getName());
            TextView desc = (TextView) findViewById(R.id.animal_description);
            desc.setText(animal.getDesc());
            try {
                ImageView imageView = (ImageView) findViewById(R.id.animal_image);
                InputStream inputStream = getAssets().open(animal.getImageURL());
                Bitmap bm = BitmapOptimizer.decodeSampledBitmapFromResource(getResources(), inputStream, 600, 400);
                imageView.setImageDrawable(new BitmapDrawable(getResources(), bm));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuController.handleMenuItemSelection(super.onOptionsItemSelected(item), item, this);
    }

}
