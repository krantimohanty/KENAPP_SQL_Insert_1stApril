package com.kenappsqlconntn;

import android.app.Activity;
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
import java.util.Locale;


public class RequestQuoteActivity extends Activity {

    ConnectionClass connectionClass;
    EditText edtquotefirstname, edtquotelastname, edtquotequoteorg, edtquotedesigntn, edtquoteplace,edtquoteemail,edtquotemobile,edtquoteindustry, edtquoteemploys, edtquoteturn, edtquotecomments, edtquotesample;
//    EditText edtfeedname, edtfeedemail;
    EditText feedmessage;
    Button btnadd,btnupdate,btndelete;
    ProgressBar pbbar;
    ListView lstpro;
    String proid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_quote);

        connectionClass = new ConnectionClass();

        edtquotefirstname = (EditText) findViewById(R.id.edtquotefirstname);
        edtquotelastname = (EditText) findViewById(R.id.edtquotelastname);
        edtquotequoteorg = (EditText) findViewById(R.id.edtquotequoteorg);
        edtquotedesigntn = (EditText) findViewById(R.id.edtquotedesigntn);
        edtquoteplace = (EditText) findViewById(R.id.edtquoteplace);
        edtquoteemail = (EditText) findViewById(R.id.edtquoteemail);
        edtquotemobile = (EditText) findViewById(R.id.edtquotemobile);
        edtquoteindustry = (EditText) findViewById(R.id.edtquoteindustry);
        edtquoteemploys = (EditText) findViewById(R.id.edtquoteemploys);
        edtquoteturn = (EditText) findViewById(R.id.edtquoteturn);
        edtquotecomments = (EditText) findViewById(R.id.edtquotecomments);
        edtquotesample = (EditText) findViewById(R.id.edtquotesample);


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

//        edtquotefirstname = (EditText) findViewById(R.id.edtquotefirstname);
//        edtquotelastname = (EditText) findViewById(R.id.edtquotelastname);
//        edtquotequoteorg = (EditText) findViewById(R.id.edtquotequoteorg);
//        edtquotedesigntn = (EditText) findViewById(R.id.edtquotedesigntn);
//        edtquoteplace = (EditText) findViewById(R.id.edtquoteplace);
//        edtquoteemail = (EditText) findViewById(R.id.edtquoteemail);
//        edtquotemobile = (EditText) findViewById(R.id.edtquotemobile);
//        edtquoteindustry = (EditText) findViewById(R.id.edtquoteindustry);
//        edtquoteemploys = (EditText) findViewById(R.id.edtquoteemploys);

//        edtquoteturn = (EditText) findViewById(R.id.edtquoteturn);
//        edtquotecomments = (EditText) findViewById(R.id.edtquotecomments);
//        edtquotesample = (EditText) findViewById(R.id.edtquotesample);

        String quotefname = edtquotefirstname.getText().toString();
        String quotelname = edtquotelastname.getText().toString();
        String quoteorg = edtquotequoteorg.getText().toString();
        String quotedesigntn = edtquotedesigntn.getText().toString();
        String quoteplace = edtquoteplace.getText().toString();
        String quoteemail = edtquoteemail.getText().toString();
        String quotemobile = edtquotemobile.getText().toString();
        String quoteindustry = edtquoteindustry.getText().toString();
        String quoteemployes = edtquoteemploys.getText().toString();
        String quoteturn = edtquoteturn.getText().toString();
        String quotecomments = edtquotecomments.getText().toString();
        String quotesample = edtquotesample.getText().toString();





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
            Toast.makeText(RequestQuoteActivity.this, r, Toast.LENGTH_SHORT).show();
//            if(isSuccess==true) {
//                FillList fillList = new FillList();
//                fillList.execute("");
//            }

        }

//        String quotefname = edtquotefirstname.getText().toString();
//        String quotelname = edtquotelastname.getText().toString();
//        String quoteorg = edtquotequoteorg.getText().toString();
//        String quotedesigntn = edtquotedesigntn.getText().toString();
//        String quoteplace = edtquoteplace.getText().toString();
//        String quoteemail = edtquoteemail.getText().toString();

//        String quotemobile = edtquotemobile.getText().toString();
//        String quoteindustry = edtquoteindustry.getText().toString();
//        String quoteemployes = edtquoteemploys.getText().toString();

//        String quoteturn = edtquoteturn.getText().toString();
//        String quotecomments = edtquotecomments.getText().toString();
//        String quotesample = edtquotesample.getText().toString();

        @Override
        protected String doInBackground(String... params) {
//            if (feedname.trim().equals("") || feedemail.trim().equals(""))

                if (quotefname.trim().equals("") || quotelname.trim().equals("") || quoteorg.trim().equals("") || quotedesigntn.trim().equals("") || quoteplace.trim().equals("") || quoteemail.trim().equals("") || quotemobile.trim().equals("") || quoteindustry.trim().equals("") || quoteemployes.trim().equals("") || quoteturn.trim().equals("") || quotecomments.trim().equals("") || quotesample.trim().equals(""))

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

//    table 4-[dbo].[RequestQuote]
//    (
//   [RequestQuote_Id] [int] IDENTITY(1,1) NOT NULL,
//	 [RequestQuote_Title] [varchar](20) NULL,
//	 [RequestQuote_FirstName] [varchar](20) NULL,
//	 [RequestQuote_LastName] [varchar](20) NULL,
//	 [RequestQuote_Organization] [varchar](50) NOT NULL,
//	 [RequestQuote_Designation] [varchar](50) NULL,

//	 [RequestQuote_Place] [varchar](50) NULL,
//	 [RequestQuote_EmailId] [varchar](50) NOT NULL,
//	 [RequestQuote_MobileNumber] [nchar](10) NOT NULL,
//	 [Industry_Name] [varchar](50) NOT NULL,
//	 [RequestQuot_NoOfEmpolyee] [varchar](50) NOT NULL,
//	 [RequestQuot_TurnOver] [varchar](50) NOT NULL,
//	 [RequestQuot_Comment] [varchar](max) NOT NULL,
//	 [RequestQuot_Sample] [varchar](max) NULL,

//	 [RequestQuot_UsingERP] [varchar](10) NULL,
//	 [RequestQuot_SupportService] [varchar](10) NULL,
//	 [RequestQuot_SolutionDemo] [varchar](10) NULL,
//	 [IsActive] [bit] NULL,
//	 [IsDelete] [bit] NULL,
//	 [InsertedOn] [datetime] NULL,
 String query = "insert into  RequestQuote (RequestQuote_FirstName, " +
         "RequestQuote_LastName, " +
         "RequestQuote_Organization, " +
         "RequestQuote_Designation, " +
         "RequestQuote_Place, " +
         "RequestQuote_EmailId, " +
         "RequestQuote_MobileNumber, " +
         "Industry_Name , " +
         "RequestQuot_NoOfEmpolyee, " +
         "RequestQuot_TurnOver, " +
         "RequestQuot_Comment, " +
         "RequestQuot_Sample) values ('" + quotefname  + "','" +
         quotelname   + "','" +
         quoteorg   + "','" +
         quotedesigntn   + "','" +
         quoteplace   + "','" +
         quoteemail   + "','" +
         quotemobile   + "','" +
         quoteindustry   + "','" +
         quoteemployes   + "','" +
         quoteturn    + "','" +
         quotecomments   + "','" +
         quotesample   + "')";




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
