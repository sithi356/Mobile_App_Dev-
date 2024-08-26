package com.example.flowershop;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner flowerTypeSpinner;
    private Button seekVarietiesButton;
    private TextView varietiesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowerTypeSpinner = findViewById(R.id.flower_type_spinner);
        seekVarietiesButton = findViewById(R.id.seek_varieties_button);
        varietiesTextView = findViewById(R.id.varieties_text_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.flower_types, android.R.layout.simple_spinner_dropdown_item);
        flowerTypeSpinner.setAdapter(adapter);

        seekVarietiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedFlower = flowerTypeSpinner.getSelectedItem().toString();
                String varieties = getVarieties(selectedFlower);
                varietiesTextView.setText(varieties);
            }
        });
    }

    private String getVarieties(String flowerType) {
        switch (flowerType) {
            case "Rose":
                return "1. Shrub Rose\n2. Climber Rose\n3. Polyantha";
            case "Lily":
                return "1. Tiger Lily\n2. Fiery\n3. Regal";
            case "Tulip":
                return "1. Ancilla\n2. Daydream\n3. Gavota";
            default:
                return "";
        }
    }
}
