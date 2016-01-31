package in.incognitech.junglebook.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import in.incognitech.junglebook.AboutActivity;
import in.incognitech.junglebook.R;

/**
 * Created by udit on 30/01/16.
 */
public class MenuController {

    public MenuController() {}

    public static boolean handleMenuItemSelection( boolean returnFlag, MenuItem item, Activity parent ) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                if ( parent.getClass() != AboutActivity.class ) {
                    parent.startActivity(new Intent(parent, AboutActivity.class));
                    returnFlag = true;
                } else {
                    Toast.makeText(parent.getApplicationContext(),"You're aleady on About page", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.action_uninstall:
                Uri packageURI = Uri.parse("package:in.incognitech.junglebook");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                parent.startActivity(uninstallIntent);
                returnFlag = true;
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(parent);
                returnFlag = true;
        }

        return returnFlag;
    }
}
