package assignment_3;


import java.time.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieAssignment {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {
    	
    	/* Which movies were released in 2020? */
    	List<Movie> l1 = movies.stream().filter(i->i.getYear()== 2020).collect(Collectors.toList());
    	System.out.println("1) The movies released in 2020 are :-");
    	System.out.println(l1);
    	System.out.println();
   	
    	/*  List all horror movies.  */
    	List<Movie>l2= movies.stream().filter(i->i.getGenre()==Genre.HORROR).collect(Collectors.toList());
    	System.out.println("2) The list of horror movies is as follows :-");
    	System.out.println(l2);
    	System.out.println();
    	
    	/* List Comedy movies released in 2019. */
    	List<Movie>l3 = movies.stream().filter(i->i.getGenre()==Genre.COMEDY).filter(i->i.getYear()==2019).collect(Collectors.toList());
    	System.out.println("3) The List Comedy movies released in 2019 are as follows :-");
    	System.out.println(l3);
    	System.out.println();
    	
    	/* Get all movies where Brad Pitt is an actor */
    	List<Movie>l4 = movies.stream().filter(i->i.getCast().contains("Brad Pitt")).collect(Collectors.toList());
    	System.out.println("4) List of all movies where Brad Pitt is an actor are as follows :-");
    	System.out.println(l4);
    	System.out.println();
    	
    	/* Get all movies with Brad Pitt but not with Leonardo DiCaprio*/
    	List<Movie>l5 = movies.stream().filter(i->i.getCast().contains("Brad Pitt")).filter(i->!i.getCast().contains("Leonardo DiCaprio")).collect(Collectors.toList());
    	System.out.println("5) List of all movies Brad Pitt but not with Leonardo DiCaprio are as follows :-");
    	System.out.println(l5);
    	System.out.println();
    	
    	/* Get top rated movies (5 stars) */
    	List<Movie> l6 = movies.stream().filter(i->i.getRating()==5).collect(Collectors.toList());
    	System.out.println("6) The List of top rated moves (5 Starts) are as follows :-");
    	System.out.println(l6);
    	System.out.println();
    	
    	/* Get top rated movies in 2020 */
    	List<Movie> l7 = movies.stream().filter(i->i.getRating()==5).filter(i->i.getYear()==2020).collect(Collectors.toList());
        System.out.println("7) Top rated movies in 2020 are as follows :-");
        System.out.println(l7);
        System.out.println("There are no top rated movies in year 2020");
        System.out.println();
        
        /* Group movies by genre. */ 
        Map<Genre, List<Movie>> l8 =  movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println("8) Grouping movies by Genre (Important) :-");
        System.out.println(l8);
        System.out.println();
        
        /* List all Names of Action Movies. */
        List<String> l9 = movies.stream().filter(i->i.getGenre()==Genre.ACTION).map(i->i.getName()).collect(Collectors.toList());
        System.out.println("9) List of all Action movies are as follows :-");
        System.out.println(l9);
        System.out.println();
        
        /* Sort Action movies by release date. */
        List<Movie> l10 =  movies.stream().filter(i->i.getGenre()==Genre.ACTION).sorted(Comparator.comparing(Movie::getDateOfRelease)).collect(Collectors.toList());
        System.out.println("10) Sorted Action movies by release date.");
        System.out.println(l10);
        System.out.println();
        
        /* Names of directors that have released movies after year2000. */
        List<String> l11 = movies.stream().filter(i->i.getYear()>2000).map(i->i.getDirectorName()).collect(Collectors.toList());
        System.out.println("11) Names of directors that have released movies after year 2000 are as follows :-");
        System.out.println(l10);
        System.out.println();
        
        /* Show First Rocky Movie. */
        List<Movie> l12 = movies.stream().filter(i->i.getName()=="Rocky").collect(Collectors.toList());
        System.out.println("12) First Rocky Movie :-");
        System.out.println(l12);
        System.out.println();
        
        /* Show statement if Will Smith is a cast of any movie in 2020. */
        boolean l13 = movies.stream().filter(i->i.getYear()==2020).anyMatch(i->i.getCast().contains("Will Smith"));
        System.out.println("13) Will Smith is a cast of any movie in 2020");
        System.out.println(l13);
        System.out.println();
        
        /*  Find the highest grossing movie. */
        Optional l14 = movies.stream().max(Comparator.comparing(Movie::getGrossEarning));
        System.out.println("14) The highest grossing movie is :-");
        System.out.println(l14.get());
        System.out.println();
        
        /* Find the lowest grossing movie in the year 2020 */
        Optional l15 = movies.stream().filter(i->i.getYear()==2020).min(Comparator.comparing(Movie::getGrossEarning));
        System.out.println("15) The lowest grossing movie in the year 2020 is :-");
        System.out.println(l15.get());
        System.out.println();
        
        /* How many movies released in last 5 years */
        long l17 = movies.stream().filter(i->i.getYear()>2018).count();
        System.out.println("17) The total movies released in last 5 years are :-");
        System.out.println(l17);
        System.out.println();
        
        /* Group movies by genre. */
        Map<Genre, List<Movie>> l18 = movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println("18) Grouping movies based on Genre :-");
        System.out.println(l18);
        System.out.println();
        
        /*  Find the number of movies released in each year */        
        Map<Integer, Long> l19 = movies.stream().collect(Collectors.groupingBy(Movie::getYear, Collectors.counting()));
        System.out.println("19) Number of movies released in each year are as follows :-");
        System.out.println(l19);
        System.out.println();
        
        /* Find the gross earning of movies classified by genre */
        Map<Genre, Double>  l20 = movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.summingDouble(Movie::getGrossEarning)));
        System.out.println("20) The gross earning of movies classified by genre are as follows :-");
        System.out.println(l20);
        System.out.println();
        
        /* Group movies with rating >= 4. */
        List<Movie> l21 =  movies.stream().filter(i->i.getRating()>=4).collect(Collectors.toList());
        System.out.println("21) Group movies with rating >= 4 are as follows :-");
        System.out.println(l21);
        System.out.println();
        
        /* Group movies with rating >= 4 but only names of movies. */
        List<String> l22 =   movies.stream().filter(i->i.getRating()>=4).map(i->i.getName()).collect(Collectors.toList());
        System.out.println("22) Group movies with rating >= 4 but only with names are as follows :-");
        System.out.println(l22);
        System.out.println();
        
        /* Find list of stars who have acted in Martin Scorsese movies */
        Map<List<String>, List<Movie>> l23 = movies.stream().filter(i->i.getDirectorName().contains("Martin Scorsese")).collect(Collectors.groupingBy(Movie::getCast));
        System.out.println("23) List of stars who have acted in Martin Scorsese movies :-");
        System.out.println(l23);
        System.out.println();
        
        /* Find unique list of stars who have acted in Martin Scorsesen movies. */
        Set<List<String>> l24 =  movies.stream().filter(i->i.getDirectorName().contains("Martin Scorsese")).map(i->i.getCast()).distinct().collect(Collectors.toSet());
        System.out.println("24) Unique list of stars who have acted in Martin Scorsesen movies :-");
        System.out.println(l24);
        System.out.println();
        
        
        
    }

}
