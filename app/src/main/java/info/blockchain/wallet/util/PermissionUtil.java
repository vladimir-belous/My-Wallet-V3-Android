package info.blockchain.wallet.util;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v13.app.FragmentCompat;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import piuk.blockchain.android.R;

/**
 * Created by riaanvos on 09/05/16.
 */
public class PermissionUtil {

    public static final int PERMISSION_REQUEST_LOCATION = 160;
    public static final int PERMISSION_REQUEST_CAMERA = 161;

    public static void requestCameraPermissionFromFragment(View parentView, Context context, final Fragment fragment) {
        // Permission has not been granted and must be requested.
        if (FragmentCompat.shouldShowRequestPermissionRationale(fragment, Manifest.permission.CAMERA)) {

            Snackbar.make(parentView, context.getString(R.string.request_camera_permission),
                    Snackbar.LENGTH_INDEFINITE).setAction(context.getString(R.string.ok_cap), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    FragmentCompat.requestPermissions(fragment,
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSION_REQUEST_CAMERA);
                }
            }).show();

        } else {
            FragmentCompat.requestPermissions(fragment,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        }
    }

    public static void requestCameraPermissionFromActivity(View parentView, final Activity activity) {
        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {

            Snackbar.make(parentView, activity.getString(R.string.request_camera_permission),
                    Snackbar.LENGTH_INDEFINITE).setAction(activity.getString(R.string.ok_cap), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSION_REQUEST_CAMERA);
                }
            }).show();

        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        }
    }

    public static void requestLocationPermissionFromActivity(View parentView, final Activity activity) {
        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION) && ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {

            Snackbar.make(parentView, activity.getString(R.string.request_location_permission),
                    Snackbar.LENGTH_INDEFINITE).setAction(activity.getString(R.string.ok_cap), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                            PERMISSION_REQUEST_LOCATION);
                }
            }).show();

        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}
                    , PERMISSION_REQUEST_LOCATION);
        }
    }
}
