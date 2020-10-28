package utp.edu.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utp.edu.myapplication.DAO.departamentoDAO;
import utp.edu.myapplication.R;
import utp.edu.myapplication.entidades.Departamento;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentConsulta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentConsulta extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText id;
    Button button;
    TextView resp;
    Departamento departamento;
    public FragmentConsulta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentConsulta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentConsulta newInstance(String param1, String param2) {
        FragmentConsulta fragment = new FragmentConsulta();
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
        View view =inflater.inflate(R.layout.fragment_consulta, container, false);
        id = view.findViewById(R.id.nroId);
        button = view.findViewById(R.id.btnConsultar);
        resp = view.findViewById(R.id.lblResp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    departamentoDAO depaDAO = new departamentoDAO(getContext());
                    depaDAO.abrirConexion();
                    departamento = depaDAO.consulta(id.getText().toString());
                    int saldo = (int) ((int) departamento.costo()+ departamento.costo()*0.05*departamento.getAños()+departamento.costo()*0.10);
                    String cad = "Nombre del cliente: "+departamento.getCliente()+
                            "\nTipo de departamento: "+departamento.getTipo()+
                            "\nCosto: "+departamento.costo()+
                            "\nAños: "+departamento.getAños()+
                            "\n\nInteres a pagar: "+departamento.costo()*(0.05/departamento.getAños())+
                            "\nCuota inicial: "+departamento.costo()*0.10+
                            "\nSaldo: "+saldo+
                            "\nCuota Final: "+departamento.costo()*departamento.getAños();
                    resp.setText(cad);
                }catch (Exception e){
                    Toast.makeText(getContext(),"No existe",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}