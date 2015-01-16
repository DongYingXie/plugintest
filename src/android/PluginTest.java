package mtel.debbie.cordovaplugin;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public class PluginTest extends CordovaPlugin {

    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException {
        String back = "my ok";

        final String ACTIVITY_TAG = "MyAndroid";
        final String ACTIVITY_TAG1 = "myalert";

        Activity activity = this.cordova.getActivity();
        if (action.equals("setdatas")) {
            String mMassage = args.getString(0);
            String mTitle = args.getString(1);
            JSONArray mArray = args.getJSONArray(2);
            Log.i(ACTIVITY_TAG, mMassage);
            this.alertshow(mMassage, mTitle, mArray, callbackContext);
            // callbackContext.success(mMassage);
            return true;
        } else if (action.equals("getdatas")) {
            String mMassage = args.getString(0);
            Log.i(ACTIVITY_TAG1, mMassage);
            callbackContext.success(mMassage);
            return true;
        }
        return false;
    }

    /**
     * 显示对话框
     * 
     * @param _message
     * @param _title
     * @param _buttons
     * @param callbackContext
     */
    public void alertshow(final String _message, final String _title,
            final JSONArray _buttons, final CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        Runnable runnable = new Runnable() {

            @SuppressLint("NewApi")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                AlertDialog.Builder alert = new AlertDialog.Builder(
                        cordova.getActivity(),
                        AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                alert.setTitle(_title);
                alert.setMessage(_message);
                if (_buttons.length() > 0) {
                    try {
                        alert.setNegativeButton(_buttons.getString(0),
                                new AlertDialog.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        // TODO Auto-generated method stub
                                        dialog.dismiss();
                                        callbackContext
                                                .success("you click sure button ");

                                    }

                                });
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (_buttons.length() > 1) {
                    try {
                        alert.setNeutralButton(_buttons.getString(1),
                                new AlertDialog.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        // TODO Auto-generated method stub
                                        dialog.dismiss();
                                        callbackContext
                                                .success("you click cancel button");
                                    }

                                });
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

                alert.create().show();
            }
        };
        this.cordova.getActivity().runOnUiThread(runnable);
    }
}