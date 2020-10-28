package utp.edu.myapplication.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class conexionSqliteHelper extends SQLiteOpenHelper {
    static int version=1;
    static final String base = "bd_ventas";
    static final String tabla1="CREATE TABLE ventas(" +
            "id integer primary key autoincrement," +
            "nombre text," +
            "tipo integer, " +
            "años integer)";

    public conexionSqliteHelper(@Nullable Context context) {
        super(context, base, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ventas");
        Log.w("men","actualizando"+i+"con"+i1);
        onCreate(db);
    }
}
