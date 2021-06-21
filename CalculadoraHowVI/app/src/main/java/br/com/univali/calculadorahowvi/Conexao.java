package br.com.univali.calculadorahowvi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static Conexao CONEXAO = null;
    private static final int VERSAO = 1;
    private static final String DBNAME = "db_calc";

    public Conexao(Context context) {
        super(context, DBNAME, null, VERSAO);
    }

    // Função que abre a conexão com o banco de dados.
    public static Conexao getInstance(Context context){
        if (CONEXAO == null) {
            CONEXAO = new Conexao(context);
        }
        return CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS historico (" +
                     "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "valor_1 DOUBLE, " +
                     "operacao CHAR(1), " +
                     "valor_2 DOUBLE, " +
                     "resultado DOUBLE)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
