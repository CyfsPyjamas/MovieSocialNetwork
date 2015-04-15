package edu.neu.cs5200.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class MyApiFilmsClient 
	{
		
		private final String FIND_MOVIE_BY_TITLE = "http://www.myapifilms.com/imdb?title=MOVIE_TITLE&format=JSON&aka=0&business=0&seasons=0&seasonYear=0&technical=0&filter=N&exactFilter=0&limit=10&forceYear=0&lang=en-us&actors=N&biography=0&trailer=0&uniqueName=0&filmography=0&bornDied=0&starSign=0&actorActress=0&actorTrivia=0&movieTrivia=0&awards=0&moviePhotos=N&movieVideos=N&similarMovies=0";
		private final String FIND_MOVIE_BY_ID ="http://www.myapifilms.com/imdb?idIMDB=ID_IMDB&format=JSON&aka=0&business=0&seasons=0&seasonYear=0&technical=0&lang=en-us&actors=N&biography=0&trailer=0&uniqueName=0&filmography=0&bornDied=0&starSign=0&actorActress=0&actorTrivia=0&movieTrivia=0&awards=0&moviePhotos=N&movieVideos=N&similarMovies=0";
		
		public Movie findMovieById(String id)
		{
			String url = FIND_MOVIE_BY_ID.replace("ID_IMDB",id);
			
			System.out.println(getJasonStringForUrl(url));
			ObjectMapper mapper = new ObjectMapper();
			String json = getJasonStringForUrl(url);
			
			try {
				return mapper.readValue(json,Movie.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public Movie[] findMovieByTitle(String title)
		{
			title = URLEncoder.encode(title);
			String urlStr=FIND_MOVIE_BY_TITLE.replace("MOVIE_TITLE",title);
			String json = getJasonStringForUrl(urlStr);
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.readValue(json, Movie[].class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		private String getJasonStringForUrl(String urlStr) {
			try {
				URL url = new URL(urlStr);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.getInputStream();
				InputStream in = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(isr);
				String out;
				StringBuffer json = new StringBuffer();
				while((out = reader.readLine()) !=null)
				{
					json.append(out);
					
				}
				return json.toString();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	public static void main(String[] args)
	{
		MyApiFilmsClient client = new MyApiFilmsClient();
		//client.findMovieByTitle("avatar");
		//Movie movie = client.findMovieById("tt0499549");
		Movie[] movies = client.findMovieByTitle("star wars");
		for (Movie movie:movies)
		{
		System.out.println(movie.getTitle());
		System.out.println(movie.getPlot());
		}
	}
}
