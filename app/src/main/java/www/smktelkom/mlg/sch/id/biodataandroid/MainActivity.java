package www.smktelkom.mlg.sch.id.biodataandroid;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNama,edtTL,edtKelas,edtAlamat,edtHobi;
    private Button btnCalculate;
    private TextView tvResult,tvResulta,tvResultb,tvResultc,tvResultd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNama = findViewById(R.id.edt_Nama);
        edtTL = findViewById(R.id.edt_TTL);
        edtKelas = findViewById(R.id.edt_Kelas);
        edtAlamat = findViewById(R.id.edt_Alamat);
        edtHobi = findViewById(R.id.edt_Hobi);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        tvResulta = findViewById(R.id.tv_resulta);
        tvResultb = findViewById(R.id.tv_resultb);
        tvResultc = findViewById(R.id.tv_resultc);
        tvResultd = findViewById(R.id.tv_resultd);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate){
            String inputNama = edtNama.getText().toString().trim();
            String inputTL = edtTL.getText().toString().trim();
            String inputKelas = edtKelas.getText().toString().trim();
            String inputALamat = edtAlamat.getText().toString().trim();
            String inputHobi = edtHobi.getText().toString().trim();


            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            if (TextUtils.isEmpty(inputNama)){
                isEmptyFields = true;
                edtNama.setError("Field ini tidak boleh kosong");
            }if (TextUtils.isEmpty(inputTL)){
                isEmptyFields = true;
                edtTL.setError("Field ini tidak boleh kosong");
            }if (TextUtils.isEmpty(inputKelas)){
                isEmptyFields = true;
                edtKelas.setError("Field ini tidak boleh kosong");
            }if (TextUtils.isEmpty(inputALamat)){
                isEmptyFields = true;
                edtAlamat.setError("Field ini tidak boleh kosong");
            }if (TextUtils.isEmpty(inputHobi)){
                isEmptyFields = true;
                edtHobi.setError("Field ini tidak boleh kosong");
            }

            String nama = toString(inputNama);
            String tl = toString(inputTL);
            Double kelas = toDouble(inputKelas);
            String alamat = toString(inputALamat);
            String hobi = toString(inputHobi);

            if (nama == null){
                isInvalidDouble = true;
                edtNama.setError("Field ini harus berisi input yang valid");
            }
            if (tl == null){
                isInvalidDouble = true;
                edtTL.setError("Field ini harus berisi input yang valid");
            }
            if (kelas == null){
                isInvalidDouble = true;
                edtKelas.setError("Field ini harus berisi input yang valid");
            }
            if (alamat == null){
                isInvalidDouble = true;
                edtAlamat.setError("Field ini harus berisi input yang valid");
            }
            if (hobi == null){
                isInvalidDouble = true;
                edtHobi.setError("Field ini harus berisi input yang valid");
            }
            if (!isEmptyFields && !isInvalidDouble){
                //double volume = length * widht * height;
                tvResult.setText("Nama : "+nama);
                tvResulta.setText("TTL : "+tl);
                tvResultb.setText("Kelas : "+kelas);
                tvResultc.setText("Alamat : "+alamat);
                tvResultd.setText("Hobi : "+hobi);


            }

        }
    }




    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

    private String toString(String str){
        try {
            return String.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
    private static final String STATE_RESULT = "state_result";


    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT,tvResult.getText().toString());
    }
}