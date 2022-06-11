package spase.serafim.truefalse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CameLevels extends AppCompatActivity  {

    TextView lev1, lev2, lev3, lev4, lev5, lev6, lev7, lev8, lev9, lev10,
            lev11, lev12, lev13, lev14, lev15, lev16, lev17, lev18, lev19, lev20,
            lev21, lev22, lev23, lev24, lev25, lev26, lev27, lev28, lev29, lev30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        lev1 = (TextView)findViewById(R.id.textView1);
        lev2 = (TextView)findViewById(R.id.textView2);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView buttonStart = (TextView) findViewById(R.id.button_back);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(CameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        lev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(CameLevels.this, Level1.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });
        lev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(CameLevels.this, Level2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });
    }



    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(CameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}