package br.com.univali.calculadorahowvi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean novaOperacao = true;
    double in1 = 0, i2 = 0;
    TextView edittext1;
    TextView edittext2;
    boolean Add, Sub, Multiply, Divide, Remainder, deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder;

    Entidade entidade = new Entidade();
    EntidadeDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instacia a conexão com o banco de dados.
        Conexao conexao = Conexao.getInstance(this);

        button_0 = (Button) findViewById(R.id.b0);
        button_1 = (Button) findViewById(R.id.b1);
        button_2 = (Button) findViewById(R.id.b2);
        button_3 = (Button) findViewById(R.id.b3);
        button_4 = (Button) findViewById(R.id.b4);
        button_5 = (Button) findViewById(R.id.b5);
        button_6 = (Button) findViewById(R.id.b6);
        button_7 = (Button) findViewById(R.id.b7);
        button_8 = (Button) findViewById(R.id.b8);
        button_9 = (Button) findViewById(R.id.b9);
        button_Dot = (Button) findViewById(R.id.bDot);
        button_Add = (Button) findViewById(R.id.badd);
        button_Sub = (Button) findViewById(R.id.bsub);
        button_Mul = (Button) findViewById(R.id.bmul);
        button_Div = (Button) findViewById(R.id.biv);
        button_Remainder = (Button) findViewById(R.id.BRemain);
        button_Del = (Button) findViewById(R.id.buttonDel);
        button_Equ = (Button) findViewById(R.id.buttoneql);

        edittext1 = (TextView) findViewById(R.id.display);
        edittext2 = (TextView) findViewById(R.id.historyDisplay);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("1");
                    edittext2.setText("1");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "1");
                    edittext2.setText(edittext2.getText() + "1");
                }

            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("2");
                    edittext2.setText("2");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "2");
                    edittext2.setText(edittext2.getText() + "2");
                }

            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("3");
                    edittext2.setText("3");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "3");
                    edittext2.setText(edittext2.getText() + "3");
                }
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("4");
                    edittext2.setText("4");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "4");
                    edittext2.setText(edittext2.getText() + "4");
                }
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("5");
                    edittext2.setText("5");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "5");
                    edittext2.setText(edittext2.getText() + "5");
                }
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("6");
                    edittext2.setText("6");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "6");
                    edittext2.setText(edittext2.getText() + "6");
                }
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("7");
                    edittext2.setText("7");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "7");
                    edittext2.setText(edittext2.getText() + "7");
                }
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("8");
                    edittext2.setText("8");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "8");
                    edittext2.setText(edittext2.getText() + "8");
                }
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("9");
                    edittext2.setText("9");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "9");
                    edittext2.setText(edittext2.getText() + "9");
                }
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (novaOperacao) {
                    edittext1.setText("0");
                    edittext2.setText("0");
                    novaOperacao = false;
                } else {
                    edittext1.setText(edittext1.getText() + "0");
                    edittext2.setText(edittext2.getText() + "0");
                }
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Add = true;
                    deci = false;
                    edittext1.setText(null);
                }

                edittext2.setText(edittext2.getText() + "+");
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Sub = true;
                    deci = false;
                    edittext1.setText(null);
                }

                edittext2.setText(edittext2.getText() + "-");
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Multiply = true;
                    deci = false;
                    edittext1.setText(null);
                }

                edittext2.setText(edittext2.getText() + "x");
            }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Divide = true;
                    deci = false;
                    edittext1.setText(null);
                }

                edittext2.setText(edittext2.getText() + "/");
            }
        });

        button_Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Remainder = true;
                    deci = false;
                    edittext1.setText(null);
                }

                edittext2.setText(edittext2.getText() + "%");
            }
        });

        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Add || Sub || Multiply || Divide || Remainder) {
                    i2 = Float.parseFloat(edittext1.getText() + "");
                }

                if (Add) {
                    edittext1.setText(in1 + i2 + "");
                    edittext2.setText(edittext2.getText() + "=" + (in1 + i2));
                    Add = false;

                    entidade.setValor_1(in1);
                    entidade.setValor_2(i2);
                    entidade.setOperacao("+");
                    entidade.setResultado(in1 + i2);
                }

                if (Sub) {

                    edittext1.setText(in1 - i2 + "");
                    edittext2.setText(edittext2.getText() + "=" + (in1 - i2));
                    Sub = false;

                    entidade.setValor_1(in1);
                    entidade.setValor_2(i2);
                    entidade.setOperacao("-");
                    entidade.setResultado(in1 - i2);
                }

                if (Multiply) {
                    edittext1.setText(in1 * i2 + "");
                    edittext2.setText(edittext2.getText() + "=" + (in1 * i2));
                    Multiply = false;

                    entidade.setValor_1(in1);
                    entidade.setValor_2(i2);
                    entidade.setOperacao("*");
                    entidade.setResultado(in1 * i2);
                }

                if (Divide) {
                    edittext1.setText(in1 / i2 + "");
                    edittext2.setText(edittext2.getText() + "=" + (in1 / i2));
                    Divide = false;

                    entidade.setValor_1(in1);
                    entidade.setValor_2(i2);
                    entidade.setOperacao("/");
                    entidade.setResultado(in1 / i2);
                }

                if (Remainder) {
                    edittext1.setText(in1 % i2 + "");
                    edittext2.setText(edittext2.getText() + "=" + (in1 % i2));
                    Remainder = false;

                    entidade.setValor_1(in1);
                    entidade.setValor_2(i2);
                    entidade.setOperacao("%");
                    entidade.setResultado(in1 % i2);
                }

                dao = new EntidadeDAO(conexao);
                dao.inserir(entidade);

                novaOperacao = true;

                Toast.makeText(getApplicationContext(), "Operação salva!", Toast.LENGTH_SHORT).show();

            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText("");
                edittext2.setText("");
                in1 = 0.0;
                i2 = 0.0;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //do nothing or you can show the error
                } else {
                    edittext1.setText(edittext1.getText() + ".");
                    edittext2.setText(edittext2.getText() + ".");
                    deci = true;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.historico)
        {
            Intent intentHistorico = new Intent(getApplicationContext(), HistoricoActivity.class);
            startActivity(intentHistorico);
        }

        return super.onOptionsItemSelected(item);
    }


}