import java.util.*;


public class Searcher implements SearchOperations{
		private Map<String, Set<Recording>> artistToRecordings = new HashMap<>();
		private Map<String, Recording> titleToRecording = new HashMap<>();
		private Map<String, Set<Recording>> genreToRecordings = new HashMap<>();

	public Searcher(Collection<Recording> data) {
		for (Recording r: data){
			String artist = r.getArtist();
			if(artistToRecordings.containsKey(artist)){
				artistToRecordings.get(artist).add(r);
			}else {
				Set<Recording> newRecording = new HashSet<>();
				newRecording.add(r);
				artistToRecordings.put(artist, newRecording);
			}
			String title = r.getTitle();
			titleToRecording.put(title, r);

			for (String genre : r.getGenre()) {
				if (genreToRecordings.containsKey(genre)) {
					genreToRecordings.get(genre).add(r);
				}else{
					Set<Recording> newGenreRecording = new HashSet<>();
					newGenreRecording.add(r);
					genreToRecordings.put(genre, newGenreRecording);
				}
			}
		}

	}

	@Override
	//klar
	public long numberOfArtists() {
		return artistToRecordings.size();
	}

	@Override
	//klar
	public long numberOfGenres() {
		return genreToRecordings.size();
	}

	@Override
	//klar
	public long numberOfTitles() {
		return titleToRecording.size();
	}

	@Override
	//klar
	public boolean doesArtistExist(String name) {
		return artistToRecordings.containsKey(name);
	}

	@Override
	//klar
	public Collection<String> getGenres() {
		return genreToRecordings.keySet();
	}

	@Override
	//klar
	public Recording getRecordingByName(String title) {
		return titleToRecording.get(title);
	}

    //tailmap och headmap
	@Override
	public Collection<Recording> getRecordingsAfter(int year) {
		return List.of();
	}

	@Override
	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
		return null;
	}

	@Override
	//klar?
	public Collection<Recording> getRecordingsByGenre(String genre) {
		return genreToRecordings.get(genre);
	}

	@Override
	public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearFrom, int yearTo) {
		return List.of();
	}

	@Override
	public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered) {
		return List.of();
	}
}

