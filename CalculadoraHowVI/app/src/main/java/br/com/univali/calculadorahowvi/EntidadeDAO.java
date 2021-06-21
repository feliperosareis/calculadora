package br.com.univali.calculadorahowvi;

import android.content.ContentValues;
//import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EntidadeDAO {

    private final Conexao conexao;
    private Double resultado;

    //    private SQLiteDatabase banco;
    private Cursor cursor;

    public EntidadeDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    public long inserir (Entidade entidade) {

            // Abre o banco de dados em modo de escrita.
            SQLiteDatabase db = conexao.getWritableDatabase();

            try {
                // Variável que recebe os valores do cálculo para inserir no banco.
                ContentValues values = new ContentValues();
                values.put("valor_1", entidade.getValor_1());
                values.put("valor_2", entidade.getValor_2());
                values.put("operacao", entidade.getOperacao());
                values.put("valor_1", entidade.getValor_1());

                // Verifica o tipo de operação.
                switch (entidade.getOperacao()) {
                    case "+":
                        resultado = entidade.getValor_1() + entidade.getValor_2();
                        break;
                    case "-":
                        resultado = entidade.getValor_1() - entidade.getValor_2();
                        break;
                    case "*":
                        resultado = entidade.getValor_1() * entidade.getValor_2();
                        break;
                    case "/":
                        resultado = entidade.getValor_1() / entidade.getValor_2();
                        break;
                    case "%":
                        resultado = entidade.getValor_1() % entidade.getValor_2();
                        break;
                }
                values.put("resultado", resultado);

                // Insere os dados no banco e retorna o id do registro inserido.
                long id_calculo = db.insert("historico", null, values);
                return id_calculo;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
    }

    public ArrayList<String> listar() {

        ArrayList<String> operacoes = new ArrayList<>();

        // Abre o banco de dados em modo de leitura.
        SQLiteDatabase db = conexao.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM historico ORDER BY _id DESC", null);

        // Percorre o resultado da query e monta os objetos que representam os cálculos efetuados.
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                Entidade calculo = new Entidade();
                calculo.setValor_1(cursor.getDouble(cursor.getColumnIndex("valor_1")));
                calculo.setValor_2(cursor.getDouble(cursor.getColumnIndex("valor_2")));
                calculo.setOperacao(cursor.getString(cursor.getColumnIndex("operacao")));
                calculo.setResultado(cursor.getDouble(cursor.getColumnIndex("resultado")));

                operacoes.add(calculo.getValor_1() + " " + calculo.getOperacao() + " " + calculo.getValor_2() + " = " + calculo.getResultado());
            } while (cursor.moveToNext());

        }

        return operacoes;
    }


}
