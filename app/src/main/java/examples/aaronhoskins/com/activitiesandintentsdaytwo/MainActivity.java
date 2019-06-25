package examples.aaronhoskins.com.activitiesandintentsdaytwo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 666;
    TextView tvMake;
    TextView tvModel;
    TextView tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModel);
        tvYear = findViewById(R.id.tvYear);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DataEntryActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            Bundle passedBundle = data.getExtras();
            Car passedCar = passedBundle.getParcelable("car");
            displayResultViews();
            tvModel.setText(passedCar.getModel());
            tvMake.setText(passedCar.getMake());
            tvYear.setText(passedCar.getYear());
        }
    }

    private void displayResultViews() {
        tvMake.setVisibility(View.VISIBLE);
        tvModel.setVisibility(View.VISIBLE);
        tvYear.setVisibility(View.VISIBLE);
    }
}
