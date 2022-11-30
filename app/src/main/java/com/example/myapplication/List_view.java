package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class List_view extends AppCompatActivity {
    ListView listView ;
    String name[] = {"TCS","Ms Infosys","Amazon","Reliance Industries","Oracle","Capgemini","Deloitte","Accenture","Larsen & Toubro","Wipro","Concentrix","Nielsen","eClinicalWorks","Cybage Software","Atos","Einfochips","LTI","Infostretch","Sophos","IGATE"};

    String address[] = {"TCS Main Building, DA IICT Rd, Infocity, Gandhinagar, Gujarat 382421","307, Sudarshan Complex, Mithakhali Underbridge, Navrangpura, Ahmedabad, Gujarat 380009","521,Shivalik Shilp 2 Nr. Keshav Bag Party Plot, Vastrapur, Ahmedabad, Gujarat 380015","Saffron Tower, Panchavati Rd, Panchavati Society, Ambawadi, Ahmedabad, Gujarat 380006","GIFT City, 23rd, Gujarat International Finance Tec-City, Pirojpur, Gujarat 382355"," Mindspace Sez, A-201/02, K Raheja Rd, Gandhinagar, Gujarat 382010","19th floor, Shapath-V Opp, Karnavati Club Road, Sarkhej - Gandhinagar Hwy, Ahmedabad, Gujarat 380015","1st Floor, Shreyas Complex, Near Dinesh Hall, Ashram Rd, Shreyas Colony, Ahmedabad, Gujarat 380009","Sakar- 1, Ashram Rd, near Ellisbridge, Ahmedabad, Gujarat 380009","st Floor, Chakravorty Complex, Navrangapura, Vijay Cross Road, Ahmedabad, Gujarat 380009","Sardar Nagar, Nizampura, Vadodara, Gujarat 390002"," 3rd Floor, Block B, Temenos Business Park, Atladara, Vadodara, Gujarat 390012","1st Floor and 409-412,4th Floor Venus Atlantis 100 ft ring Rd, Prahlad Nagar, Ahmedabad, Gujarat 380015","2nd Floor, Tower II, Infocity, Gandhinagar, Gujarat 382007","101-104, GCP Business Center, Opp Memnagar Fire Station, Vijaya Cross Road, Memnagar, Ahmedabad, Gujarat 380014","2, Aryan Park Complex Nr, Railway Crossing, Thaltej - Shilaj Rd, Thaltej, Ahmedabad, Gujarat 380054","3HW6+P45, Sardar patel Nagar, Chamunda Nagar, Kali, Ahmedabad, Gujarat 380081","Neptune Corporate HouseBlock A B/H, 101-105, Rajpath Rangoli Rd, Bodakdev, Ahmedabad, Gujarat 380054","Sophos House, Cyberoam Technologies Pvt. Ltd., white house Panchwati Cross Road, Panchavati Society, Gulbai Tekra, Ahmedabad, Gujarat 380006","Sachin Tower, E-708, Titamium City Center, Nr, 100 Feet Anand Nagar Rd, Ahmedabad, Gujarat 380015"};

    String industry[] = {"Computer Hardware Development","Information Technology Support Services","Internet & Web Services","Energy & Utilities","Enterprise Software & Network Solutions","Enterprise Software & Network Solutions","Accounting & Tax","Business Consulting","Construction","Industry","Information Technology Support Services","Enterprise Software & Network Solutions","Computer Hardware Development","Information Technology Support Services","Information Technology Support Services","Information Technology Support Services","Information Technology Support Services","Information Technology Support Services","Enterprise Software & Network Solutions","Information Technology Support Services"};

    String website[] = {"www.tcs.com","www.infosys.com","www.amazon.in","www.ril.com","www.oracle.com","www.capgemini.com","www.deloitte.com","www.accenture.com","www.larsentoubro.com","www.wipro.com","www.concentrix.com","global.nielsen.com","www.eclinicalworks.com","www.cybage.com","www.atos.com","www.einfochips.com","business.google.com","www.infostretch.com","www.sophos.com","www.igate.com"};

    String hr[] = {"Nirav Brahmbhatt","Mallika Srivastava","Nirav Darji","Ashish Parekh","Shruti Patel","Darpesh Parmar","Deboshri Das","Prathibha Viswanath","Samir Desai","Meera Sahu","Caroline Alvares","Nirav Joshi","Pankaj Jivnani ","Abhijit Nandi","Shivani Shukla","Amit Jha ","Arun Kumar Wunnava","Kanchan Agrawal","ketan jadav","Umesh Rai"};

    String contect[] = {"global.marketing@tcs.com","askus@infosys.com","linkedin.com/in/nirav-darji-b4733914","info@ril.com","linkedin.com/in/shruti-patel-22112321b","linkedin.com/in/darpesh-parmar-77965575","linkedin.com/in/deboshridas","linkedin.com/in/prathibha-viswanath-273389a7","linkedin.com/in/samir-desai-19bb2015","linkedin.com/in/meera-sahu-885b92212","linkedin.com/in/caroline-alvares-20ab65125","linkedin.com/in/nirav-joshi-086b9b24","linkedin.com/in/pankajjivnanihr","linkedin.com/in/abhijit-nandi-645a8b111","linkedin.com/in/shivani-shukla-938b5450","linkedin.com/in/amit-jha-b1820715","wvarun@rediffmail.com","linkedin.com/in/kanchan-agrawal-652b584a","linkedin.com/in/ketan-jadav-8a856066","linkedin.com/in/umesh-rai-5022a0107"};

    String phone[] = {"+91-22-6778 9595"," 079 2646 0546","099744 52425","079 2550 0825","080063 30691","079 7122 1100","079 6682 7300","040 3384 7000"," 079 6630 4001","088664 15802","+1-800-747-0583","079 2646 0546","079 4022 2000","079 6673 7000","063015 50840","079 6712 8700","079 2752 4828","079 6777 1222"," 079 6621 6666"," 072848 34382"};

    int img[] ={R.drawable.tcs_p,R.drawable.infosys_p,R.drawable.amazon_p,R.drawable.reliance_p,R.drawable.oracle_p,R.drawable.capgemini_p,R.drawable.deloitte_p,R.drawable.accenture_p,R.drawable.larsen_p,R.drawable.wipro_p,R.drawable.concentrix_p,R.drawable.nielsen_p,R.drawable.eclinicalworks_p,R.drawable.cybage_p,R.drawable.atos_p,R.drawable.einfochips_p,R.drawable.lti_p,R.drawable.infostretch_p,R.drawable.sophos_p,R.drawable.igate_p};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listview1);
        myadapter adapter = new myadapter(this,name,address,industry,website,hr,contect,phone,img);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(List_view.this,Cmp_profile.class);
                intent.putExtra("name",name[i]);
                intent.putExtra("address",address[i]);
                intent.putExtra("industry",industry[i]);
                intent.putExtra("website",website[i]);
                intent.putExtra("hr",hr[i]);
                intent.putExtra("contect",contect[i]);
                intent.putExtra("phone",phone[i]);
                intent.putExtra("img",img[i]);
                startActivity(intent);
            }
        });

    }
    class myadapter extends ArrayAdapter<String>{
        Context context;
        String rname[];
        String raddress[];
        String rindustry[];
        String rwebsite[];
        String rhr[];
        String rcontect[];
        String rphone[];
        int rimg[];

        public myadapter(Context context,String[] rname, String[] raddress,String[]rindustry,String[]rwebsite ,String[]rhr,String[]rcontect,String[] rphone, int[] rimg) {
            super(context,R.layout.row,R.id.imageView,rname);
            this.rname = rname;
            this.raddress =raddress;
            this.rindustry =rindustry;
            this.rwebsite = rwebsite;
            this.rhr =rhr;
            this.rcontect =rcontect;
            this.rphone = rphone;
            this.rimg = rimg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.row,parent,false);

            CircleImageView imgage = view.findViewById(R.id.imageView);
            TextView txt = view.findViewById(R.id.name);

            txt.setText(rname[position]);
            imgage.setImageResource(rimg[position]);

            return view;
        }
    }
}