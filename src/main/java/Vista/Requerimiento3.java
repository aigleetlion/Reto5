package Vista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout; 

import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_3;


public class Requerimiento3 extends JFrame{
    public Requerimiento3() throws SQLException {
        initUI();
    }
    
    public void initUI() throws SQLException{
        setLayout(new BorderLayout());
        String[]nombres= {"Proveedor", "Pagado", "Proyecto_Constructora"};

        JTable tabla = new JTable(mostrar(), nombres);

        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle("Requerimiento 3 * Grupo 64 *");  
        setLocationRelativeTo(null);
        setVisible(true);    // para que se muestre el frame
    }
    public String[][] mostrar() throws SQLException{
        
        ArrayList<Requerimiento_3> lista = new ArrayList<Requerimiento_3>();    ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        //
        lista = controlador.consultarRequerimiento3();

        
        String matriz[][] = new String [lista.size()][3];         
        
        for (int i=0; i<lista.size(); i++){
            matriz[i][0]=lista.get(i).getProveedor();
            matriz[i][1]=lista.get(i).getPagado();
            matriz[i][2]=lista.get(i).getConstructora();                
        }
        return matriz;
    }
}