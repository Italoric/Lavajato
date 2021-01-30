package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.Cliente;

/**
 *
 * @author clemerson.medeiros
 */
public class TabelaCliente extends AbstractTableModel {

    private List<Cliente> dadosCliente;
    private final String[] colunas = {"NOME", "NÚMERO", "QUANTIDADE"}; // colunas

    public TabelaCliente(List<Cliente> lista) {
        dadosCliente = lista;
    }

    public void addRow(Cliente v) {
        this.dadosCliente.add(v);
        this.fireTableDataChanged();
    }

    public Cliente getCliente(int row) {
        return dadosCliente.get(row);
    }

    public void update(Cliente cliente, int row) {
        dadosCliente.set(row, cliente);
        this.fireTableDataChanged();
    }

    public void setList(List<Cliente> cliente) {
        this.dadosCliente = cliente;
        this.fireTableDataChanged();
    }

    public void remove(int row) {
        dadosCliente.remove(row);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosCliente.get(linha).getNome();
            case 1:
                return dadosCliente.get(linha).getNumero();
            case 2:
                return dadosCliente.get(linha).getQuantidade();

        }
        return null;
    }
}
