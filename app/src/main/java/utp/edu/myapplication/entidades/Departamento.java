package utp.edu.myapplication.entidades;

public class Departamento {
    private int id;
    private String cliente;
    private int tipo;
    private int años;

    public Departamento(int id, String cliente, int tipo, int años) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.años = años;
    }

    public Departamento() {

    }
    public int costo(){
        int costo = 0;
        switch (this.tipo){
            case 1:
                costo = 120000;
                break;
            case 2:
                costo = 160000;
                break;
            case 3:
                costo = 200000;
                break;
            case 4:
                costo = 250000;
                break;
        }
        return costo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
}
