package com.kenappsqlconntn;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;



public class FeedbackActivity extends Activity {

    ConnectionClass connectionClass;
    EditText edtfeedname, edtfeedemail, edtfeedph, edtfeedmobile, edtfeedaddress,edtfeedstate,edtfeedcountry,edtfeedsubject, edtfeedmessage;
//    EditText edtfeedname, edtfeedemail;
    EditText feedmessage;
    Button btnadd,btnupdate,btndelete;
    ProgressBar pbbar;
    ListView lstpro;
    String proid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        connectionClass = new ConnectionClass();

        edtfeedname = (EditText) findViewById(R.id.edtfeedname);
        edtfeedemail = (EditText) findViewById(R.id.edtfeedemail);
        edtfeedph = (EditText) findViewById(R.id.edtfeedph);
        edtfeedmobile = (EditText) findViewById(R.id.edtfeedmobile);
        edtfeedaddress = (EditText) findViewById(R.id.edtfeedaddress);
        edtfeedstate = (EditText) findViewById(R.id.edtfeedstate);
        edtfeedcountry = (EditText) findViewById(R.id.edtfeedcountry);
        edtfeedsubject = (EditText) findViewById(R.id.edtfeedsubject);
        edtfeedmessage = (EditText) findViewById(R.id.edtfeedmessage);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btndelete = (Button) findViewById(R.id.btndelete);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);
        lstpro = (ListView) findViewById(R.id.lstfeedback);
        proid = "";

//        FillList fillList = new FillList();
//        fillList.execute("");

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPro addPro = new AddPro();
                addPro.execute("");

            }
        });
//        btnupdate.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                UpdatePro updatePro = new UpdatePro();
//                updatePro.execute("");
//
//            }
//        });

//        btndelete.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                DeletePro deletePro = new DeletePro();
//                deletePro.execute("");
//
//            }
//        });

    }

    public class AddPro extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        String feedname = edtfeedname.getText().toString();
        String feedemail = edtfeedemail.getText().toString();
        String feedph = edtfeedph.getText().toString();
        String feedmobile = edtfeedmobile.getText().toString();
        String feedaddress = edtfeedaddress.getText().toString();
        String feedstate = edtfeedstate.getText().toString();
        String feedcountry = edtfeedcountry.getText().toString();
        String feedsubject = edtfeedsubject.getText().toString();
        String feedmessage = edtfeedmessage.getText().toString();


//        String proname = "taruna";
//        String prodesc = "rrrr";

        //String proname = edtproname.getText().toString();
//        String prodesc = edtprodesc.getText().toString();

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(FeedbackActivity.this, r, Toast.LENGTH_SHORT).show();
//            if(isSuccess==true) {
//                FillList fillList = new FillList();
//                fillList.execute("");
//            }

        }

        @Override
        protected String doInBackground(String... params) {
//            if (feedname.trim().equals("") || feedemail.trim().equals(""))

                if (feedname.trim().equals("") || feedemail.trim().equals("") || feedph.trim().equals("") || feedmobile.trim().equals("") || feedaddress.trim().equals("") || feedstate.trim().equals("") || feedcountry.trim().equals("") || feedsubject.trim().equals("") || feedmessage.trim().equals("") )

                    z = "Please enter Name and Email ID";
            else {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {

                        String dates = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
                                .format(Calendar.getInstance().getTime());
//                        String query = "insert into  FeedBack (FeedBack_Name, FeedBack_EmailId, FeedBack_PhoneNumber, FeedBack_MobileNumber, FeedBack_Address, FeedBack_State, Country_Name, FeedBack_Subject , FeedBack_Message) values ('" + feedname  + "','" + feedemail  +  "')";
                        //String query = "insert into  User_Registration (User_First_Name,User_Last_Name) values ('" + proname  + "','" + prodesc  + "')";
//                        String query = "insert into FeedBack (FeedBack_Name,FeedBack_EmailId) values ('" + feedname + "','" + feedemail +  "')";
//
 String query = "insert into  FeedBack (FeedBack_Name, FeedBack_EmailId, FeedBack_PhoneNumber, FeedBack_MobileNumber, FeedBack_Address, FeedBack_State, Country_Name, FeedBack_Subject , FeedBack_Message) values ('" + feedname  + "','" + feedemail  + "','" +  feedph  + "','" +  feedmobile  + "','" +  feedaddress  + "','" +  feedstate  + "','" + feedcountry  + "','" + feedsubject  + "','" +  feedmessage  + "')";


//     [FeedBack_Id] [int] IDENTITY(1,1) NOT NULL,
//	 [FeedBack_Name] [varchar](50) NULL,
//	 [FeedBack_EmailId] [varchar](50) NOT NULL,
//	 [FeedBack_PhoneNumber] [varchar](15) NOT NULL,
//	 [FeedBack_MobileNumber] [varchar](15) NULL,
//	 [FeedBack_Address] [varchar](200) NOT NULL,
//	 [FeedBack_State] [varchar](20) NULL,
//	 [Country_Name] [varchar](50) NULL,
//	 [FeedBack_Subject] [varchar](max) NOT NULL,
//	 [FeedBack_Message] [varchar](max) NOT NULL,
//	 [IsActive] [bit] NULL,
//	 [IsDelete] [bit] NULL,
//	 [InsertedOn] [datetime] NULL,

//                        //change given below:
//                        db : replace KenCommon to inductuion
//                        UserId : induction
//                        Password : swash@2015
//                        select * from User_RegistrationI


//  [User_RegistrationId] [int] IDENTITY(1,1) NOT NULL,
//	[User_First_Name] [varchar](30) NULL,
//	[User_Last_Name] [varchar](30) NULL,
//	[User_Password] [varchar](30) NULL,
//	[User_MobileNo] [varchar](15) NULL,
//	[User_EmailId] [varchar](30) NULL,
//	[Device_Model] [varchar](30) NULL,
//	[Device_OS_Type] [varchar](50) NULL,
//	[Device_OS_Version] [varchar](30) NULL,
//	[Device_Manufacturer] [varchar](30) NULL,


                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.executeUpdate();
                        z = "Added Successfully";
                        isSuccess = true;
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = "Exceptions";
                }
            }
            return z;
        }
    }


//    public class UpdatePro extends AsyncTask<String, String, String> {
//
//
//
//        String z = "";
//        Boolean isSuccess = false;
//
//
//        String proname = edtproname.getText().toString();
//        String prodesc = edtprodesc.getText().toString();
//
//
//        @Override
//        protected void onPreExecute() {
//            pbbar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(String r) {
//            pbbar.setVisibility(View.GONE);
//            Toast.makeText(ProductsActivity.this, r, Toast.LENGTH_SHORT).show();
//            if(isSuccess==true) {
//                FillList fillList = new FillList();
//                fillList.execute("");
//            }
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            if (proname.trim().equals("") || prodesc.trim().equals(""))
//                z = "Please enter User Id and Password";
//            else {
//                try {
//                    Connection con = connectionClass.CONN();
//                    if (con == null) {
//                        z = "Error in connection with SQL server";
//                    } else {
//
//                        String dates = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
//                                .format(Calendar.getInstance().getTime());
//
//                        String query = "Update Producttbl set ProName='"+proname+"',ProDesc='"+prodesc+"' , OnDate='"+dates+"' where Id="+proid;
//                        PreparedStatement preparedStatement = con.prepareStatement(query);
//                        preparedStatement.executeUpdate();
//                        z = "Updated Successfully";
//
//                        isSuccess = true;
//                    }
//                } catch (Exception ex) {
//                    isSuccess = false;
//                    z = "Exceptions";
//                }
//            }
//            return z;
//        }
//    }
//
//
//    public class DeletePro extends AsyncTask<String, String, String> {
//
//
//
//        String z = "";
//        Boolean isSuccess = false;
//
//
//        String proname = edtproname.getText().toString();
//        String prodesc = edtprodesc.getText().toString();
//
//
//        @Override
//        protected void onPreExecute() {
//            pbbar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(String r) {
//            pbbar.setVisibility(View.GONE);
//            Toast.makeText(ProductsActivity.this, r, Toast.LENGTH_SHORT).show();
//            if(isSuccess==true) {
//                FillList fillList = new FillList();
//                fillList.execute("");
//            }
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            if (proname.trim().equals("") || prodesc.trim().equals(""))
//                z = "Please enter User Id and Password";
//            else {
//                try {
//                    Connection con = connectionClass.CONN();
//                    if (con == null) {
//                        z = "Error in connection with SQL server";
//                    } else {
//
//                        String dates = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
//                                .format(Calendar.getInstance().getTime());
//
//                        String query = "delete from Producttbl where Id="+proid;
//                        PreparedStatement preparedStatement = con.prepareStatement(query);
//                        preparedStatement.executeUpdate();
//                        z = "Deleted Successfully";
//                        isSuccess = true;
//                    }
//                } catch (Exception ex) {
//                    isSuccess = false;
//                    z = "Exceptions";
//                }
//            }
//            return z;
//        }
//    }


//    public class FillList extends AsyncTask<String, String, String> {
//        String z = "";
//
//        List<Map<String, String>> prolist  = new ArrayList<Map<String, String>>();
//
//        @Override
//        protected void onPreExecute() {
//
//            pbbar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(String r) {
//
//            pbbar.setVisibility(View.GONE);
//            Toast.makeText(ProductsActivity.this, r, Toast.LENGTH_SHORT).show();
//
//            String[] from = { "A", "B", "C" };
//            int[] views = { R.id.lblproid, R.id.lblproname,R.id.lblprodesc };
//            final SimpleAdapter ADA = new SimpleAdapter(ProductsActivity.this,
//                    prolist, R.layout.lsttemplate, from,
//                    views);
//            lstpro.setAdapter(ADA);
//
//
//            lstpro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> arg0, View arg1,
//                                        int arg2, long arg3) {
//                    HashMap<String, Object> obj = (HashMap<String, Object>) ADA
//                            .getItem(arg2);
//                    proid = (String) obj.get("A");
//                    String proname = (String) obj.get("B");
//                    String prodesc = (String) obj.get("C");
//                    edtprodesc.setText(prodesc);
//                    edtproname.setText(proname);
//               //     qty.setText(qtys);
//                }
//            });
//
//
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            try {
//                Connection con = connectionClass.CONN();
//                if (con == null) {
//                    z = "Error in connection with SQL server";
//                } else {
//                    String query = "select * from Producttbl";
//                    PreparedStatement ps = con.prepareStatement(query);
//                    ResultSet rs = ps.executeQuery();
//
//                    ArrayList<String> data1 = new ArrayList<String>();
//                    while (rs.next()) {
//                        Map<String, String> datanum = new HashMap<String, String>();
//                        datanum.put("A", rs.getString("Id"));
//                        datanum.put("B", rs.getString("ProName"));
//                        datanum.put("C", rs.getString("ProDesc"));
//                        prolist.add(datanum);
//                    }
//
//
//                    z = "Success";
//                }
//            } catch (Exception ex) {
//                z = "Error retrieving data from table";
//
//            }
//            return z;
//        }
//    }


}
