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

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

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

        View row;
        ViewHolder holder;

        if ( convertView == null ) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.animal_row, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.rowImage);
            holder.textView = (TextView) row.findViewById(R.id.rowText);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        // Set the text
        holder.textView.setText(animal.getName());

        // Set the image
        try {
            InputStream inputStream = getContext().getAssets().open(animal.getImageURL());
            Bitmap bm = BitmapOptimizer.decodeSampledBitmapFromResource( parent.getResources(), inputStream, 40, 40 );
            holder.imageView.setImageDrawable(new BitmapDrawable(parent.getResources(), bm));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}
