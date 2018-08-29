package br.edu.ifpb.gerenciadoreslayout.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDbHelper extends SQLiteOpenHelper {

    public static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "db_escola.db";

    private static final String SQL_CREATE_ALUNO =
            "CREATE TABLE " + AlunoContract.TABLE_NAME + " (" +
                    AlunoContract.ID + " INTEGER PRIMARY KEY," +
                    AlunoContract.NOME + "TEXT, " +
                    AlunoContract.NASCIMENTO + "DATE, " +
                    AlunoContract.CIDADE + "TEXT" + " )";

    private static final String SQL_DELETE_ = "";

    public AlunoDbHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    /**
     * Responsável pela criação do Banco de dados e Tabelas.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ALUNO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_);
        onCreate(db);
    }
}