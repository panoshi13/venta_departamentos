package utp.edu.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import utp.edu.myapplication.DAO.departamentoDAO;
import utp.edu.myapplication.R;
import utp.edu.myapplication.entidades.Departamento;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentInicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInicio extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button registrar,nuevo;
    EditText nombre,años;
    Spinner spinn;
    ImageView imagen;
    String[] tipos = {"70","90","120","150"};
    String depa;
    int tipo;
    public FragmentInicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentInicio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentInicio newInstance(String param1, String param2) {
        FragmentInicio fragment = new FragmentInicio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_inicio, container, false);
        //Botones
        registrar = v.findViewById(R.id.btnRegistrar);
        nuevo = v.findViewById(R.id.btnLimpiar);
        //Input
        nombre = v.findViewById(R.id.txtNombre);
        años = v.findViewById(R.id.nroAños);
        spinn = v.findViewById(R.id.spinn);
        imagen = v.findViewById(R.id.img);

        ArrayAdapter adaptador = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,tipos);
        spinn.setAdapter(adaptador);
        spinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cad = tipos[i];

                switch (cad){
                    case "70":
                        depa = "departamento1";
                        tipo = 1;
                        break;
                    case "90":
                        depa = "departamento2";
                        tipo = 2;
                        break;
                    case "120":
                        depa = "departamento3";
                        tipo = 3;
                        break;
                    case "150":
                        depa = "departamento4";
                        tipo = 4;
                        break;
                }
                //double pre[] = {14900,26000,21000,50000,60000,32000,23000,11000};
                //Obtener direccion en memoria
                int direccion_memoria = getContext().getResources().getIdentifier("drawable/"+depa,null,getContext().getPackageName());
                //asignar imagen
                imagen.setImageResource(direccion_memoria);
                //precio = pre[i];
                //costo.setText("El precio es "+pre[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Departamento departamento = new Departamento();
                    departamentoDAO depaDAO = new departamentoDAO(getContext());
                    depaDAO.abrirConexion();
                    departamento.setCliente(nombre.getText().toString());
                    departamento.setTipo(tipo);
                    departamento.setAños(Integer.parseInt(años.getText().toString()));
                    int i = depaDAO.Adicion(departamento);
                    Toast.makeText(getContext(),"Agregado con Exito!, Fila nro: "+i,Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getContext(),"Error: "+e,Toast.LENGTH_LONG).show();
                }
                limpiar();
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });

        return v;
    }

    public void limpiar(){
        nombre.setText("");
        años.setText("");
    }
    /*
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String cad = tipos[i];
        double pre[] = {14900,26000,21000,50000,60000,32000,23000,11000};
        //Obtener direccion en memoria
        int direccion_memoria = getResources().getIdentifier("drawable/"+cad,null,getPackageName());
        //asignar imagen
        imagen.setImageResource(direccion_memoria);
        precio = pre[i];
        costo.setText("El precio es "+pre[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

     */
}