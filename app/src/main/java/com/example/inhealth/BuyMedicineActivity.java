package com.example.inhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-D3 10000IU Capsule", "", "", "", "15000"},
                    {"Healthvit Chromium 200mcg Capsule", "", "", "", "30000"},
                    {"Vitamin B Complex Capsules", "", "", "", "20000"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "", "10000"},
                    {"Dolo 650 Tablet", "", "", "", "12500"},
                    {"Crocin 650 Advance Tablet", "", "", "", "23000"},
                    {"Strepsils For Sore Throat", "", "", "", "52200"},
                    {"Tata Img Calcium + Vitamin B3 ", "", "", "", "15490"},
                    {"Feronie -XT Tablet", "", "", "", "12400"},
            };
    private String[] package_details = {
            "Membangun dan menjaga agar tulang dan gigi tetap kuat\n" +
                    "mengurangi kelelahan/stres dan nyeri otot \n" +
                    "\"Meningkatkan Imunitas dan meningkatkan daya tahan terhadap infeksi",
            "Chromium adalah trace mineral penting yang memainkan peran penting dalam membantu insulin teratur",
            "Memberikan bantuan dari kekurangan vitamin 8\n" +
                    "Membantu pembentukan sel darah merah\n" +
                    "Mempertahankan sistem saraf yang sehat",
            "meningkatkan kesehatan serta manfaat kulit.\n" +
                    "Membantu mengurangi noda kulit dan pigmentasi" +
                    "bertindak sebagai pelindung kulit dari sinar matahari UVA dan UVB yang keras",
            "dolo 650 Tablet membantu menghilangkan rasa sakit dan demam dengan menghalangi pelepasan bahan kimia tertentu",
            "Membantu meredakan demam dan menurunkan suhu tinggi\n" +
                    "Cocok untuk orang dengan kondisi jantung tekanan darah tinggi",
            "Meredakan gejala infeksi tenggorokan akibat bakteri dan mempercepat proses pemulihan\n" +
                    "Memberikan rasa hangat dan nyaman saat sakit tenggorokan",
            "Mengurangi risiko kekurangan kalsium, rakhitis dan osteoporosis\n" +
                    "Meningkatkan mobilitas dan fleksibilitas sendi",
            "Membantu mengurangi kekurangan zat besi karena kehilangan darah kronis atau asupan zat besi yang rendah"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnBack = findViewById(R.id.buttonBMBack);
        lst = findViewById(R.id.ListViewBM);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter( this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}