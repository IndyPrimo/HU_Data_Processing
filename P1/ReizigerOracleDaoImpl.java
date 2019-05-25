// V1C - Julian Kunst

package InleverOpdrachten.P1;

import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDAO implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<Reiziger>();

    public List<Reiziger> findAll() {
        return reizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) {
        List<Reiziger> GbDReizigers = new ArrayList<Reiziger>();
        for (Reiziger r : this.reizigers){
            if (r.getGbDatum() != null) {
                if (r.getGbDatum().toString().contentEquals(GBdatum)) {
                    GbDReizigers.add(r);
                }
            }
        }
        return GbDReizigers;
    }

    public Reiziger save(Reiziger r) {
        if (!this.reizigers.contains(r)) {
            this.reizigers.add(r);
        }
        return r;
    }

    public Reiziger update(Reiziger r) {
        if (!this.reizigers.contains(r)) {
            this.reizigers.remove(r);
            this.reizigers.add(r);
            return r;
        }
        return r;
    }

    public boolean delete(Reiziger r) {
        if (this.reizigers.contains(r)) {
            this.reizigers.remove(r);
            return true;
        }
        return false;
    }

    public void closeConnection() {
    }
}
