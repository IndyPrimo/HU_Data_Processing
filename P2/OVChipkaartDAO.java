// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.util.List;

public interface OVChipkaartDAO {
	public List<OVChipkaart> findByReiziger(int reizigerID);
	
	public OVChipkaart saveOVChip(OVChipkaart OVChip);
	
	public OVChipkaart updateOVChip(OVChipkaart OVChip);
	
	public boolean deleteOVChip(OVChipkaart OVChip);
}