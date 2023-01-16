package cadastros;

import java.util.LinkedList;

import construtores.Item;
import construtores.NotaFiscal;
import interfaces.INotasFiscais;

public class CadNotaFiscal implements INotasFiscais{

    private LinkedList<NotaFiscal> listaNotaFiscal;

    public CadNotaFiscal() {
        listaNotaFiscal = new LinkedList<NotaFiscal>();
    }

    @Override
    public void addNotaFiscal(NotaFiscal nf) throws Exception {
        listaNotaFiscal.add(nf);        
    }

    @Override
    public void removeNotaFiscal(int codigo) throws Exception {
        listaNotaFiscal.remove(codigo);
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception {
        for (NotaFiscal nf : listaNotaFiscal)
                return nf;
        return null;
    }

    @Override
    public double getTotal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub
        
    }


}
