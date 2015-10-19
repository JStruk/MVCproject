package juddy.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main extends Activity {
    public int n = 0;
    public int n1, n2;
    public String s1, s2;
    public RadioButton rbAdd, rbSub, rbMult, rbDiv;
    List<RadioButton> radioButtons = new ArrayList<RadioButton>();
    public double dAns = 0;
    public String sOp;
    boolean bFlip;

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
        rbAdd = (RadioButton) findViewById(R.id.rbAdd);
        rbSub = (RadioButton) findViewById(R.id.rbSub);
        rbMult = (RadioButton) findViewById(R.id.rbMult);
        rbDiv = (RadioButton) findViewById(R.id.rbDiv);
        radioButtons.add(rbAdd);
        radioButtons.add(rbSub);
        radioButtons.add(rbMult);
        radioButtons.add(rbDiv);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        for (RadioButton button : radioButtons) {
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) processRadioButtonClick(buttonView);
                }
            });
        }
        final EditText etNum1 = (EditText) findViewById(R.id.editTextn1);
        final EditText etNum2 = (EditText) findViewById(R.id.editTextn2);
        final TextView tv = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                n++;
                s1 = etNum1.getText().toString();
                n1 = Integer.parseInt(s1);
                s2 = etNum2.getText().toString();
                n2 = Integer.parseInt(s2);
                if (rbAdd.isChecked()) {
                    sOp = "plus";
                    dAns = n1 + n2;
                } else if (rbSub.isChecked()) {
                    sOp = "subtract";
                    if (checkBox.isChecked()) {
                        if (n2 > n1) {
                            dAns = n2 - n1;
                        } else {
                            dAns = n1 - n2;
                        }
                    } else {
                        dAns = n1 - n2;
                    }
                } else if (rbMult.isChecked()) {
                    sOp = "times";
                    dAns = n1 * n2;
                } else if (rbDiv.isChecked()) {
                    sOp = "divided by";
                    if (checkBox.isChecked()) {
                        if (n2 > n1) {
                            dAns = n2 / n1;
                        } else {
                            dAns = n1 / n2;
                        }
                    } else {
                        dAns = n1 / n2;
                    }
                }
                if (checkBox.isChecked()) {
                    tv.setText(n2 + " " + sOp + " " + n1 + " is " + dAns);
                } else {
                    tv.setText(n1 + " " + sOp + " " + n2 + " is " + dAns);
                }
            }
        });
    }

    private void processRadioButtonClick(CompoundButton buttonView) {

        for (RadioButton button : radioButtons) {

            if (button != buttonView) button.setChecked(false);
        }

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
