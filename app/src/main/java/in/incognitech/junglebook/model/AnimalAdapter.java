package in.incognitech.junglebook.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import in.incognitech.junglebook.R;
import in.incognitech.junglebook.util.BitmapOptimizer;

/**
 * Created by udit on 31/01/16.
 */
public class AnimalAdapter extends ArrayAdapter<Animal> {

    private static List<Animal> animalList;

    public static List<Animal> getAnimalList() {
        return animalList;
    }

    public static void setAnimalList(List<Animal> animalList) {
        AnimalAdapter.animalList = animalList;
    }

    public AnimalAdapter(Context context, int resource, List<Animal> animalList) {
        super(context, resource, animalList);
        this.setAnimalList( animalList );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Animal animal = AnimalAdapter.getAnimalList().get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.animal_row, null);

        // Set the text
        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(animal.getName());

        // Set the image
        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
            InputStream inputStream = getContext().getAssets().open(animal.getImageURL());
//            Drawable drawable = Drawable.createFromStream(inputStream, null);
            Bitmap bm = BitmapOptimizer.decodeSampledBitmapFromResource( parent.getResources(), inputStream, 40, 40 );
            imageView.setImageDrawable(new BitmapDrawable(parent.getResources(), bm));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}
