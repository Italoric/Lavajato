package tabelas;

import modelos.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author clemerson.medeiros
 */
public class TabelaFuncionario extends AbstractTableModel {

    private List<Funcionario> dadosFuncionario;
    private final String[] colunas = {"ID", "FUNCIONÁRIO", "NÚMERO", "CPF", "USUÁRIO", "TIPOUSUÁRIO"}; // colunas

    public TabelaFuncionario(List<Funcionario> lista) {
        dadosFuncionario = lista;
    }

    public void addRow(Funcionario v) {
        this.dadosFuncionario.add(v);
        this.fireTableDataChanged();
    }

    public Funcionario getFuncionario(int row) {
        return dadosFuncionario.get(row);
    }

    public void update(Funcionario funcionario, int row) {
        dadosFuncionario.set(row, funcionario);
        this.fireTableDataChanged();
    }

    public void setList(List<Funcionario> funcionario) {
        this.dadosFuncionario = funcionario;
        this.fireTableDataChanged();
    }

    public void remove(int row) {
        dadosFuncionario.remove(row);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosFuncionario.get(linha).getId();
            case 1:
                return dadosFuncionario.get(linha).getNome();
            case 2:
                return dadosFuncionario.get(linha).getNumero();
            case 3:
                return dadosFuncionario.get(linha).getCpf();
            case 4:
                return dadosFuncionario.get(linha).getUsuario();
            case 5:
                return dadosFuncionario.get(linha).getTipoUsuario();
        }
        return null;
    }
}

