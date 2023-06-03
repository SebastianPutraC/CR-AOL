package afterRefactoring;

class Rental 
{
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie) 
    {
        _movie = movie;
        _daysRented = 0;
    }

    public int getDaysRented() 
    {
        return _daysRented;
    }

    public Movie getMovie() 
    {
        return _movie;
    }

    double getCharge()
    {
       return  _movie.getCharge(getDaysRented());
    }

    int getFrequentRenterPoints() 
    {
      return _movie.getFrequentRenterPoints(getDaysRented());
    }


}