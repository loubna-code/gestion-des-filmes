package movies.spring.data.neo4j.movies;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


interface MovieRepository extends Repository<Movie, String> {

	@Query("MATCH (movie:Movie) WHERE movie.title CONTAINS $title RETURN movie")
	List<Movie> findSearchResults(@Param("title") String title);
	
	@Query("MATCH (film:Movie) WHERE date(film.released) >= date(datetime().toString()).year + '-01-01'AND date(film.released) <= date(datetime().toString()).year + '-12-31'RETURN film")
	List<Movie> findSearch();
	
}
