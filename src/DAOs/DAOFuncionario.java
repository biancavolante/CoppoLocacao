package DAOs;

import Entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOFuncionario extends DAOGenerico<Funcionario> {

    public DAOFuncionario() {
        super(Funcionario.class);
    }

    public int autoIdFuncionario() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.id) FROM Funcionario e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Funcionario> listById(int id) {
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.id = :id").setParameter("id", id).getResultList();
    }

    public List<Funcionario> listByNomeFuncionario(String nomeFuncionario) {
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.nomeFuncionario LIKE :nomeFuncionario").setParameter("nomeFuncionario", "%" + nomeFuncionario + "%").getResultList();
    }

    public List<Funcionario> listInOrderId() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.id").getResultList();
    }

    public List<Funcionario> listInOrderNomeFuncionario() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.nomeFuncionario").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Funcionario> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNomeFuncionario();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId() + ";" + lf.get(i).getNomeFuncionario() + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getTelefone() + ";" + lf.get(i).getEmail() + ";");
        }
        return ls;
    }
}

