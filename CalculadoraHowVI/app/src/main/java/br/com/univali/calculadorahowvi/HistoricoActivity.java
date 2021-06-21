package br.com.univali.calculadorahowvi;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        // Instacia a conexão com o banco de dados.
        Conexao conexao = Conexao.getInstance(this);

        // Implementa o botão de voltar para a tela da calculadora.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Vincula a variável list ao elemento ListView da tela de Histórico de operações.
        ListView list = (ListView) findViewById(R.id.list);

        EntidadeDAO dao = new EntidadeDAO(conexao);
        ArrayList<String> historico = dao.listar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historico);
        list.setAdapter(adapter);

    }
}