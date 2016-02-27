package kr.co.yonhapnewstv.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends Activity {

//    GCM Message Content
//    Bundle[ {
//        content-available=1,
//                ejson={"category":"URGENT","type":"LIVE","content":"생중계 안내입니다."},
//        title=연합뉴스TV,
//                message=생중계 안내입니다.,
//                collapse_key=do_not_collapse
//    }]

    private String mGCMTitle;
    private String mGCMMessage;
    private String mEjson;

    private Button mButtonOK;
    private Button mButtonCancel;
    private TextView mGCMMessageTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.content_main);


        mButtonOK = (Button) findViewById(R.id.buttonOK);
        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO for Daniel: put actions to perform here when clicking on 'OK' button.
            }
        });
        mButtonCancel = (Button) findViewById(R.id.buttonCancel);
        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mGCMMessageTextview = (TextView) findViewById(R.id.gcmMessage);



        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        mGCMTitle = data.getString("title");
        mGCMMessage = data.getString("message");
        mEjson = data.getString("ejson");

        mGCMMessageTextview.setText(mGCMMessage);

    }

}
