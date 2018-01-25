package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.PoloniexDataEntry;

@Repository
public interface PoloniexRepository extends AbstractDataEntryRepository<PoloniexDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<PoloniexDataEntry> findByPair(String base, String quote);

}
