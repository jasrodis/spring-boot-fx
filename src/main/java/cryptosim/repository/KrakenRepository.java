package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.KrakenDataEntry;

@Repository
public interface KrakenRepository extends AbstractDataEntryRepository<KrakenDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<KrakenDataEntry> findByPair(String base, String quote);

}
