package com.example.hpf.wuziqi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements WuziqiPanel.OnGameOverListener {

    private WuziqiPanel wuziqiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wuziqiPanel = (WuziqiPanel) findViewById(R.id.id_wuziqi);
        wuziqiPanel.setOnGameOverListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"再来一局");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == 1){
            wuziqiPanel.start();
            return true;
        }
        return false;
    }

    @Override
    public void GameOver(boolean isGameOver, boolean isWhiteWin) {

        String str = null;

        if (isGameOver) {
            if (isWhiteWin) {
                str = "白方 胜!";
            } else {
                str = "黑方 胜!";
            }
        }

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("恭喜");
        alertDialog.setMessage(str);
        alertDialog.setPositiveButton("再来一局", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                wuziqiPanel.start();
            }
        });
        alertDialog.setNegativeButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });

        alertDialog.show();
    }
}
