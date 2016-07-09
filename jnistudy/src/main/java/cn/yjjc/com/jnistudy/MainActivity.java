package cn.yjjc.com.jnistudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.TextView textView;
    private android.widget.Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button);
        this.textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(this);
    }

    private native String helloFromJNI();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                System.loadLibrary("hello");
                textView.setText(helloFromJNI());
                break;
        }
    }
}
