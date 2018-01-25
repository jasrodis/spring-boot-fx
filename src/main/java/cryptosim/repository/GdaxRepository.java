package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.GdaxDataEntry;

@Repository
public interface GdaxRepository extends AbstractDataEntryRepository<GdaxDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<GdaxDataEntry> findByPair(String base, String quote);

}
