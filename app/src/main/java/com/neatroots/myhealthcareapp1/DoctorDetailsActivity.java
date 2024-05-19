package com.neatroots.myhealthcareapp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp: 5yrs","Mobile No.: 9898989898","600"},
            {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No.: 7898789898", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No.: 889888989898 ", "300"},
            {"Doctor Name : Gurvinder Singh", "Hospital Address : Chinchwad ", "Exp: 6yrs", "Mobile No.: 98980000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No.: 7898789898", "800"}
    };
    private String[][] doctor_details2= {
            {"Doctor Name : Amol Gawade", "Hospital Address : Pimpri ", "Exp : 5yrs","Mobile No. 9898989898: ", "600"},
            {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No. : 7898789898", "900"},
            {"Doctor Name : Nilesh Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No. : 889888989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad ", "Exp : 6yrs", "Mobile No. : 98980000000 ", "500"},
            {"Doctor Name : Ashok Singh ", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No. : ", "800"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Seema Patel", "Hospital Address : Pimpri ","Exp:4yrs","Mobile No.:9898989898","200"},
            {"Doctor Name : Pankaj Parab", "Hospital Address : Nigdi","Exp: 5yrs","Mobile No.: 7898789898", "300"},
            {"Doctor Name : Monish Jain", "Hospital Address : Pune", "Exp: 7yrs", "Mobile No.: 889888989898 ", "300"},
            {"Doctor Name : Vishal Deshmukh", "Hospital Address : Chinchwad ", "Exp: 6yrs", "Mobile No.: 98980000000 ", "500"},
            {"Doctor Name : Shrikant Panda ", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No.: 7798989898", "600"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Nilesh Gawade", "Hospital Address : Pimpri ", "Exp: 5yrs","Mobile No.: 9898989898", "600"},
            {"Doctor Name : Pankaj Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No.: 7898789898", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No.: 8898889898", "300"},
            {"Doctor Name : Deepak Kumar", "Hospital Address : Chinchwad ", "Exp: 6yrs", "Mobile No.: 9898000000", "500"},
            {"Doctor Name : Ankul Panda ", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No.: 8898889898", "800"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Amarjeet Singh", "Hospital Address : Pimpri ", "Exp: 5yrs","Mobile No.:9898989898: ", "600"},
            {"Doctor Name : Parmjeet Puri", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No.: 7898789898", "900"},
            {"Doctor Name : Satinder Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No.: 8898889898 ", "300"},
            {"Doctor Name : Ripu Daman", "Hospital Address : Chinchwad ", "Exp: 6yrs", "Mobile No.: 989800000 ", "500"},
            {"Doctor Name : Harjeet Singh ", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No.: 9898989898", "800"}
    };
    TextView tv;
    ListView lv;

    Button btn;

    String[][] doctor_details={};

    ArrayList list;
    SimpleAdapter sa;

    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

//        map the object member
        tv=findViewById(R.id.textViewDDTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);




        if(title.compareTo("Family Physicians")==0) {
            doctor_details=doctor_details1;
        } else if (title.compareTo("Dietician")==0) {
            doctor_details=doctor_details2;
        } else if (title.compareTo("Dentist")==0) {
            doctor_details=doctor_details3;
        }
        else if (title.compareTo("Surgeon")==0) {
            doctor_details=doctor_details4;
        }
        else if (title.compareTo("Cardiologists")==0) {
            doctor_details=doctor_details5;
        }

        btn=findViewById(R.id.buttonDDBack);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(DoctorDetailsActivity.this,FinddoctorActivity.class));
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fee: "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lv=findViewById(R.id.ListViewDDDetails);
        lv.setAdapter(sa);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}