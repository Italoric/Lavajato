 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import modelos.Agendamento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author clemerson.medeiros
 */
public class TabelaAgendamento extends AbstractTableModel {

    private List<Agendamento> dadosAgendamento;
    private final String[] colunas = {"ID", "CLIENTE", "NÚMERO", "VEÍCULO", "DATA", "HORA", "VALOR", "FUNCIONÁRIO"}; // colunas

    public TabelaAgendamento(List<Agendamento> lista) {
        dadosAgendamento = lista;
    }

    public void addRow(Agendamento v) {
        this.dadosAgendamento.add(v);
        this.fireTableDataChanged();
    }

    public Agendamento getAgendamento(int row) {
        return dadosAgendamento.get(row);
    }

    public void update(Agendamento agendamento, int row) {
        dadosAgendamento.set(row, agendamento);
        this.fireTableDataChanged();
    }

    public void setList(List<Agendamento> agendamentos) {
        this.dadosAgendamento = agendamentos;
        this.fireTableDataChanged();
    }

    public void remove(int row) {
        dadosAgendamento.remove(row);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosAgendamento.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosAgendamento.get(linha).getId();
            case 1:
                return dadosAgendamento.get(linha).getCliente();
            case 2:
                return dadosAgendamento.get(linha).getNumero();
            case 3:
                return dadosAgendamento.get(linha).getTipoveiculo();
            case 4:
                return dadosAgendamento.get(linha).getData();
            case 5:
                return dadosAgendamento.get(linha).getHora();
            case 6:
                return dadosAgendamento.get(linha).getValor();
            case 7:
                return dadosAgendamento.get(linha).getFuncionario();
        }
        return null;
    }
}
