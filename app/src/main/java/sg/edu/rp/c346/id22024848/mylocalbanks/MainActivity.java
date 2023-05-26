package sg.edu.rp.c346.id22024848.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.bluetooth.BluetoothA2dp;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    TextView twDbs;
    TextView twOcbc;
    TextView twUob;

    String text="";
    String color="black";
    String dbs;
    String ocbc;
    String uob;
    String dbscn;
    String ocbccn;
    String uobcn;
    String dbsweb;
    String ocbcweb;
    String uobweb;
    String dbsphone;
    String ocbcphone;
    String uobphone;
    String error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twDbs=findViewById(R.id.textViewDbs);
        twOcbc=findViewById(R.id.textViewOcbc);
        twUob=findViewById(R.id.textViewUob);
        registerForContextMenu(twDbs);
        registerForContextMenu(twOcbc);
        registerForContextMenu(twUob);

        dbs=getString(R.string.dbs);
        ocbc=getString(R.string.ocbc);
        uob=getString(R.string.uob);
        dbscn=getString(R.string.dbscn);
        ocbccn=getString(R.string.ocbccn);
        uobcn=getString(R.string.uobcn);
        dbsweb=getString(R.string.dbsweb);
        ocbcweb=getString(R.string.ocbcweb);
        uobweb=getString(R.string.uobweb);
        dbsphone=getString(R.string.dbsphone);
        ocbcphone=getString(R.string.ocbcphone);
        uobphone=getString(R.string.uobphone);
        error=getString(R.string.error);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.D
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            twDbs.setText(dbs);
            twOcbc.setText(ocbc);
            twUob.setText(uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            twDbs.setText(dbscn);
            twOcbc.setText(ocbccn);
            twUob.setText(uobcn);
            return true;
        } else {
            twDbs.setText(error);
            twOcbc.setText(error);
            twUob.setText(error);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==twDbs){
            text=dbs;
        }
        else if(v==twOcbc){
            text=ocbc;
        }
        else if(v==twUob){
            text=uob;
        }

        getMenuInflater().inflate(R.menu.menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (text.equalsIgnoreCase(dbs)){
            if (item.getItemId()==R.id.website){
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(dbsweb) );
                startActivity(intent);

            }
            else if(item.getItemId()==R.id.contact){
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dbsphone));
                startActivity(intent);
            }
            else if(item.getItemId()==R.id.favourite) {
                if (color.equals("black")) {

                    twDbs.setTextColor(Color.parseColor("#ff0000"));
                    color="red";
                }
                else{
                    twDbs.setTextColor(Color.parseColor("#000000"));
                    color="black";
                }
            }
        }
        if (text.equalsIgnoreCase(ocbc)){
            if (item.getItemId()==R.id.website){
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(ocbcweb));
                startActivity(intent);
            }
            else if (item.getItemId()==R.id.contact){
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ocbcphone));
                startActivity(intent);
            }
            else if(item.getItemId()==R.id.favourite) {
                if (color.equals("black")) {

                    twOcbc.setTextColor(Color.parseColor("#ff0000"));
                    color="red";
                }
                else{
                    twOcbc.setTextColor(Color.parseColor("#000000"));
                    color="black";
                }
            }
        }
        if (text.equalsIgnoreCase(uob)){
            if(item.getItemId()==R.id.website){
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(uobweb));
                startActivity(intent);

            }
            else if(item.getItemId()==R.id.contact){
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+uobphone));
                startActivity(intent);
            }
            else if(item.getItemId()==R.id.favourite) {
                if (color.equals("black")) {

                    twUob.setTextColor(Color.parseColor("#ff0000"));
                    color="red";
                }
                else{
                    twUob.setTextColor(Color.parseColor("#000000"));
                    color="black";
                }
            }
        }
        return super.onContextItemSelected(item);

    }
}