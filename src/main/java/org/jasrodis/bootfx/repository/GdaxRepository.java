package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.GdaxDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GdaxRepository extends AbstractDataEntryRepository<GdaxDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<GdaxDataEntry> findByPair(String base, String quote);

}
