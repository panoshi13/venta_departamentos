package utp.edu.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import utp.edu.myapplication.Conexion.conexionSqliteHelper;
import utp.edu.myapplication.entidades.Departamento;

public class departamentoDAO {
    conexionSqliteHelper conn;
    SQLiteDatabase db;

    public departamentoDAO(Context context) {
        this.conn = new conexionSqliteHelper(context);
    }

    public void abrirConexion(){
        this.db =conn.getWritableDatabase();
    }

    public int Adicion(Departamento depa){
        ContentValues ct = new ContentValues();
        ct.put("nombre",depa.getCliente());
        ct.put("tipo",depa.getTipo());
        ct.put("años",depa.getAños());

        int resp = (int) db.insert("ventas",null,ct);
        return resp;
    }

    public Departamento consulta(String id){
        Departamento departamento = null;
        String[] parametros={id};
        Cursor cursor = db.rawQuery("SELECT * FROM ventas WHERE id=?",parametros);
        while (cursor.moveToNext()){
            departamento = new Departamento();
            departamento.setId(cursor.getInt(0));
            departamento.setCliente(cursor.getString(1));
            departamento.setTipo(cursor.getInt(2));
            departamento.setAños(cursor.getInt(3));
        }
        return  departamento;
    }
    public ArrayList<Departamento> listado(){
        Departamento departamento = null;
        ArrayList<Departamento> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM ventas",null);
        while (cursor.moveToNext()){
            departamento = new Departamento();
            departamento.setId(cursor.getInt(0));
            departamento.setCliente(cursor.getString(1));
            departamento.setTipo(cursor.getInt(2));
            departamento.setAños(cursor.getInt(3));
            lista.add(departamento);
        }
        return  lista;
    }
}
