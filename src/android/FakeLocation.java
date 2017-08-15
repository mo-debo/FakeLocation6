package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;

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
                
                boolean isMock = false;
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
