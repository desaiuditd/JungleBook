package in.incognitech.junglebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by udit on 31/01/16.
 */
public class ScaryDialog extends DialogFragment {

    private int animalID;

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.animal_dialog_message).setPositiveButton(R.string.animal_dialog_proceed, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Bazzinga !
                Intent i = new Intent(getActivity().getApplicationContext(), AnimalActivity.class);
                i.putExtra("animal_id", ScaryDialog.this.getAnimalID());
                startActivity(i);
            }
        }).setNegativeButton(R.string.animal_dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do Nothing
                System.out.println(which);
            }
        });
        return builder.create();
    }
}
