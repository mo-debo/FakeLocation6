package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.provider.Settings.Secure;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.util.Settings;

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
                Location location;
                boolean isMock = false;
                isMock = location.isFromMockProvider();
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
