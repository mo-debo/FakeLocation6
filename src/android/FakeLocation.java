package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import com.esri.cordova.geolocation.model.Coordinate;
import com.esri.cordova.geolocation.model.InitStatus;
import com.esri.cordova.geolocation.model.LocationDataBuffer;
import com.esri.cordova.geolocation.utils.ErrorMessages;
import com.esri.cordova.geolocation.utils.JSONHelper;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;


import com.esri.cordova.geolocation.model.Error;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class FakeLocation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("check")) {
            if (Build.VERSION.SDK_INT < 18) {
                if (Secure.getString(this.cordova.getActivity().getContentResolver(), Secure.ALLOW_MOCK_LOCATION).equals("0")) {
                    callbackContext.success(0);
                } else {
                    callbackContext.success(1);
                }
            } else {
                Location location = null;
                
                boolean isMock = false;
                //isMock = location.isFromMockProvider();
                if (isMock == false) {
                    callbackContext.success(0);
                } else {
                    callbackContext.success(1);

                }
            }
            return true;

        }

        return false;
    }
}
