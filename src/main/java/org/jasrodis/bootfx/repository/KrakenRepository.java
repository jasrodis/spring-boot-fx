package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.KrakenDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KrakenRepository extends AbstractDataEntryRepository<KrakenDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<KrakenDataEntry> findByPair(String base, String quote);

}
