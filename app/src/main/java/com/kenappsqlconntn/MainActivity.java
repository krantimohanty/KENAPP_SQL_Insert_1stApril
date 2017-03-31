package com.kenappsqlconntn;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainActivity extends Activity {

    ConnectionClass connectionClass;
    EditText edtuserid, edtpass;
    Button btnlogin;
    ProgressBar pbbar;
    TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);

        connectionClass = new ConnectionClass();
        edtuserid = (EditText) findViewById(R.id.edtuserid);
        edtpass = (EditText) findViewById(R.id.edtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");

            }
        });

    }

    public class DoLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;


        String userid = edtuserid.getText().toString();
        String password = edtpass.getText().toString();


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

            if (isSuccess) {
                Intent i = new Intent(MainActivity.this, FeedbackActivity.class);
                startActivity(i);
                finish();
            }

//            if (isSuccess) {
//                Intent i = new Intent(MainActivity.this, ProductsActivity.class);
//                startActivity(i);
//                finish();
//            }

        }

        @Override
        protected String doInBackground(String... params) {
            if (userid.trim().equals("") || password.trim().equals(""))
                z = "Please enter User Id and Password";
            else {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
//                        String query = "select * from Usertbl where UserId='" + userid + "' and password='" + password + "'";
                        //[User_RegistrationId)

                        String query = "select * from RequestQuote";
                        //[RequestDemo]
//                        String query = "select * from User_Registration";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if (rs.next()) {

                            z = "Login successfull";
                            isSuccess = true;
                        } else {
                            z = "Invalid Credentials";
                            isSuccess = false;
                        }

                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = "Exceptions";
                }
            }
            return z;
        }
    }

//    public String getIMEI(Activity activity)
//    {
//        TelephonyManager telephonyManager = (TelephonyManager) activity
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        return telephonyManager.getDeviceId();
//
//        //Calling the methods of TelephonyManager the returns the information
//        String IMEINumber = telephonyManager.getDeviceId();
//        String subscriberID = telephonyManager.getDeviceId();
//        String SIMSerialNumber = telephonyManager.getSimSerialNumber();
//        String networkCountryISO = telephonyManager.getNetworkCountryIso();
//        String SIMCountryISO = telephonyManager.getSimCountryIso();
//        String softwareVersion = telephonyManager.getDeviceSoftwareVersion();
//        String voiceMailNumber = telephonyManager.getVoiceMailNumber();
//
//        //Get the phone type
//        String strphoneType = "";
//
//        int phoneType = telephonyManager.getPhoneType();
//
//        switch (phoneType) {
//            case (TelephonyManager.PHONE_TYPE_CDMA):
//                strphoneType = "CDMA";
//                break;
//            case (TelephonyManager.PHONE_TYPE_GSM):
//                strphoneType = "GSM";
//                break;
//            case (TelephonyManager.PHONE_TYPE_NONE):
//                strphoneType = "NONE";
//                break;
//        }
//
//        //getting information if phone is in roaming
//        boolean isRoaming = telephonyManager.isNetworkRoaming();
//
//        String info = "Phone Details:\n";
//        info += "\n IMEI Number:" + IMEINumber;
//        info += "\n SubscriberID:" + subscriberID;
//        info += "\n Sim Serial Number:" + SIMSerialNumber;
//        info += "\n Network Country ISO:" + networkCountryISO;
//        info += "\n SIM Country ISO:" + SIMCountryISO;
//        info += "\n Software Version:" + softwareVersion;
//        info += "\n Voice Mail Number:" + voiceMailNumber;
//        info += "\n Phone Network Type:" + strphoneType;
//        info += "\n In Roaming? :" + isRoaming;
//
//        textView1.setText(info);//displaying the information in the textView
//
//    }
//
//
//
//    public String getDeviceUniqueID(Activity activity){
//        String device_unique_id = Settings.Secure.getString(activity.getContentResolver(),
//                Settings.Secure.ANDROID_ID);
//        return device_unique_id;
//    }


}
