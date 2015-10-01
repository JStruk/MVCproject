package juddy.mvc;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends ActionBarActivity {
    TextView textView;
    public int n=0;
    String sName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClicked();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonClicked() {
        final EditText editText = (EditText) findViewById(R.id.enterName);
        Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                n++;
                System.out.println("buttonclickd");
                TextView tv = (TextView)findViewById(R.id.textView);
                tv.setText("Button clickd :D " + n + " times");
                sName=editText.getText().toString();
                tv.setY(300);
                tv.setText("button pressed by "+sName+" "+n+" times");
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
/*        tvButton.setText("Button Clicked");
        tvButton.setX(width / 2);
        tvButton.setY(height / 2);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
