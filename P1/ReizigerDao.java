// V1C - Julian Kunst

package InleverOpdrachten.P1;

import java.util.List;

public interface ReizigerDao{

    public List<Reiziger> findAll();

    public List<Reiziger> findByGBdatum(String GBdatum);

    public Reiziger save(Reiziger r);

    public Reiziger update(Reiziger r);

    public boolean delete(Reiziger r);

}
