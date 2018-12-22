package com.example.a1602366.memorizes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 1602366 on 4/30/2018.
 */

public class calculator extends AppCompatActivity implements View.OnClickListener{
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
       Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit3=(EditText) findViewById(R.id.edit2);
                TextView text3=(TextView) findViewById(R.id.text2);
                String res=text3.getText().toString();
                edit3.setText(res);

            }
        });
    Button button9=(Button) findViewById(R.id.button9);
    button9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText edit=(EditText) findViewById(R.id.edit2);
            edit.setText("");
        }
    });

        }

    @Override
    public void onClick(View v) {
        EditText edit2 = (EditText) findViewById(R.id.edit2);
        TextView text2 = (TextView) findViewById(R.id.text2);
        String ch = edit2.getText().toString();

        try {
            //for unary operatord
            char u=ch.charAt(0);
            if((int)u>=97&&(int)u<=122){

                String nu = "";

                char c[] = ch.toCharArray();
                //for log
                if (ch.substring(0, 3).equals("log")) {
                    if (c[3] != '(') {
                        for (int i = 3; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);
                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.log(n);
                       text2.setText(Double.toString(m));

                    } else {
                        for (int i = 4; i < ch.length() - 1; i++) {
                            nu = nu + Character.toString(c[i]);
                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.log(n);
                        text2.setText(Double.toString(m));

                    }
                }




                //for sin
                else if (ch.substring(0, 3).equals("sin")) {
                    for (int i = 3; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.sin(n);
                    text2.setText(Double.toString(m));
                }

                //for cos
                else if (ch.substring(0, 3).equals("cos")) {
                    for (int i = 3; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.cos(n);
                    text2.setText(Double.toString(m));
                }
                //for tan
                else if (ch.substring(0, 3).equals("tan")) {
                    for (int i = 3; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.cos(n);
                    text2.setText(Double.toString(m));
                }

                //for cosec
                else if (ch.substring(0, 5).equals("cosec") || ch.substring(0, 4).equals("asin")) {
                    if (ch.substring(0, 5).equals("cosec")) {
                        for (int i = 5; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.asin(n);
                        text2.setText(Double.toString(m));
                    } else {
                        for (int i = 4; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.asin(n);
                        text2.setText(Double.toString(m));
                    }
                }

                //for sec
                else if (ch.substring(0, 3).equals("sec") || ch.substring(0, 4).equals("acos")) {
                    if (ch.substring(0, 3).equals("sec")) {
                        for (int i = 3; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.acos(n);
                        text2.setText(Double.toString(m));
                    } else {
                        for (int i = 4; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.acos(n);
                        text2.setText(Double.toString(m));
                    }
                }

                //for cot
                else if (ch.substring(0, 3).equals("cot") || ch.substring(0, 4).equals("atan")) {
                    if (ch.substring(0, 3).equals("cot")) {
                        for (int i = 3; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.atan(n);
                        text2.setText(Double.toString(m));
                    } else {
                        for (int i = 4; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);

                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.atan(n);
                        text2.setText(Double.toString(m));
                    }
                }
                //for exp
                else if (ch.substring(0, 3).equals("exp")) {
                    for (int i = 3; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.exp(n);
                    text2.setText(Double.toString(m));
                }
                //for sqrt
                else if (ch.substring(0, 4).equals("sqrt")) {
                    for (int i = 4; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.sqrt(n);
                    text2.setText(Double.toString(m));
                }

                //for cbrt
                else if (ch.substring(0, 4).equals("cbrt")) {
                    for (int i = 4; i < ch.length(); i++) {
                        nu = nu + Character.toString(c[i]);

                    }
                    Double n = Double.parseDouble(nu);
                    Double m = Math.cbrt(n);
                    text2.setText(Double.toString(m));
                }

                //for ln
                else {
                    if (c[2] != '(') {
                        for (int i = 2; i < ch.length(); i++) {
                            nu = nu + Character.toString(c[i]);
                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.log(n) * (2.303);
                        text2.setText(Double.toString(m));
                    } else {
                        for (int i = 3; i < ch.length() - 1; i++) {
                            nu = nu + Character.toString(c[i]);
                        }
                        Double n = Double.parseDouble(nu);
                        Double m = Math.log(n) * (2.303);
                        text2.setText(Double.toString(m));
                    }
                }
            }



            //for binary operator
            else {
                String a = "", b = "";

                double a1, b1;
                char op = ' ';
                int flag = 0;
                char ch1[] = ch.toCharArray();
                for (int i = 0; i < ch.length(); i++) {
                    if (ch1[i] == '+' || ch1[i] == '-' || ch1[i] == '*' || ch1[i] == '/' || ch1[i] == '^') {
                        op = ch1[i];
                        flag = 1;
                    }
                    if (flag == 0) {
                        a = a + Character.toString(ch1[i]);

                    } else {
                        if (flag == 2) {
                            b = b + Character.toString(ch1[i]);

                        }flag = 2;
                    }
                }

                a1 = Double.parseDouble(a);
                b1 = Double.parseDouble(b);
                if (op == '+') {
                    double c = a1 + b1;
                    text2.setText(Double.toString(c));

                } else if (op == '-') {
                    Double c = a1 - b1;
                    text2.setText(Double.toString(c));
                } else if (op == '*'||(int)op==158) {
                    Double c = a1 * b1;
                    text2.setText(Double.toString(c));
                } else if (op == '^') {
                    Double c = Math.pow(a1, b1);
                    text2.setText(Double.toString(c));
                }
                else if(op=='%'){
                    Double c=a1%b1;
                    text2.setText(Double.toString(c));
                }

                else {
                    Double c = a1 / b1;
                    text2.setText(Double.toString(c));
                }

            }

        }
        catch(Exception e){
            text2.setText("WRONG SYNTAX");
        }
    }
}


