package DAOs;

import Entidades.Maquina;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOMaquina extends DAOGenerico<Maquina> {

    public DAOMaquina() {
        super(Maquina.class);
    }

    public int autoIdMaquina() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idMaquina) FROM Maquina e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Maquina> listByIdMaquina(int idMaquina) {
        return em.createQuery("SELECT e FROM Maquina e WHERE e.idMaquina = :idMaquina").setParameter("idMaquina", idMaquina).getResultList();
    }

    public List<Maquina> listByNomeMaquina(String nomeMaquina) {
        return em.createQuery("SELECT e FROM Maquina e WHERE e.nomeMaquina LIKE :nomeMaquina").setParameter("nomeMaquina", "%" + nomeMaquina + "%").getResultList();
    }

    public List<Maquina> listInOrderIdMaquina() {
        return em.createQuery("SELECT e FROM Maquina e ORDER BY e.idMaquina").getResultList();
    }

    public List<Maquina> listInOrderNomeMaquina() {
        return em.createQuery("SELECT e FROM Maquina e ORDER BY e.nomeMaquina").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Maquina> lf;
        if (qualOrdem.equals("idMaquina")) {
            lf = listInOrderIdMaquina();
        } else {
            lf = listInOrderNomeMaquina();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdMaquina() + ";" + lf.get(i).getNomeMaquina() + ";" + lf.get(i).getValorHora() + ";");
        }
        return ls;
    }
}

