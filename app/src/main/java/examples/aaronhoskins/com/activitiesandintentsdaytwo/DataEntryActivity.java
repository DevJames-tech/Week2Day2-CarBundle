package examples.aaronhoskins.com.activitiesandintentsdaytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DataEntryActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 777;
    Intent intent;
    EditText etMake;
    EditText etModel;
    EditText etYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etYear = findViewById(R.id.etYear);
        intent = getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: Activity Data entry is in lifecycle onResume");
        //Log.e("TAG", "onResume: ", exception);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        final String make = etMake.getText().toString();
        final String model = etModel.getText().toString();
        final String year = etYear.getText().toString();
        final Car carToPassBack = new Car(make, model, year);

        Bundle bundle = new Bundle();
        bundle.putParcelable("car", carToPassBack);
        intent.putExtras(bundle);
        setResult(RESULT_CODE, intent);
        finish();

    }
}
