package com.unigran.appdecadastro.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "AppCadastro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE CLIENTES(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOME VARCHAR(256)," +
                        "EMAIL VARCHAR(256)," +
                        "TELEFONE VARCHAR(256));"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE FORNECEDORES(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOMEFANTASIA VARCHAR(256)," +
                        "EMAIL VARCHAR(256)," +
                        "TELEFONE VARCHAR(256));"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE PRODUTOS(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NOME VARCHAR(256)," +
                        "MARCA VARCHAR(256)," +
                        "QUANTIDADE INTEGER," +
                        "PRECO REAL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
