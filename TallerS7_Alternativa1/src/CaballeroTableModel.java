
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CaballeroTableModel extends AbstractTableModel {

    private List<Caballero> caballeros;
    private String[] columnas = {
            "ID",
            "Nombre",
            "Rango",
            "Constelación",
            "Nivel Poder",
            "Misión",
            "Nivel Dificultad",
            "Recompensa",
            "Aporte Santuario",
            "Impuesto Reino",
            "Recompensa Neta"
    };

    public CaballeroTableModel() {
        this.caballeros = new ArrayList<Caballero>();
    }

    public void setCaballeros(List<Caballero> caballeros) {
        if (caballeros == null) {
            this.caballeros = new ArrayList<Caballero>();
        } else {
            this.caballeros = caballeros;
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return caballeros.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Caballero c = caballeros.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getIdCaballero();
            case 1:
                return c.getNombre();
            case 2:
                return c.getRango();
            case 3:
                return c.getConstelacion();
            case 4:
                return c.getNivelPoder();
            case 5:
                return c.getMisionAsignada();
            case 6:
                return c.getNivelDificultad();
            case 7:
                return c.getRecompensa();
            case 8:
                return c.getAporteSantuario();
            case 9:
                return c.getImpuestoReino();
            case 10:
                return c.getRecompensaNeta();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 4:
            case 6:
                return Integer.class;
            case 7:
            case 8:
            case 9:
            case 10:
                return Double.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
