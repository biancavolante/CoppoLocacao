package DAOs;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOCliente extends DAOGenerico<Cliente> {

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.rg) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByRg(int rg) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.rg = :rg").setParameter("rg", rg).getResultList();
    }

    public List<Cliente> listByNomeCliente(String nomeCliente) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.nomeCliente LIKE :nomeCliente").setParameter("nomeCliente", "%" + nomeCliente + "%").getResultList();
    }

    public List<Cliente> listInOrderRg() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.rg").getResultList();
    }

    public List<Cliente> listInOrderNomeCliente() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.nomeCliente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("rg")) {
            lf = listInOrderRg();
        } else {
            lf = listInOrderNomeCliente();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getRg() + ";" + lf.get(i).getNomeCliente() + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getEmail() + ";" + lf.get(i).getTelefone() + ";");
        }
        return ls;
    }
}

