package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.CexDataEntry;

@Repository
public interface CexRepository extends AbstractDataEntryRepository<CexDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<CexDataEntry> findByPair(String base, String quote);

}
