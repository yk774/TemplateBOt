public class Answer {
    int age;
    boolean isFiction;
    boolean isRandom;
    String genre;

    public Answer(int iAge, boolean bIsFiction, boolean bIsRandom, String sGenre) {
        age = iAge;
        isFiction = bIsFiction;
        isRandom = bIsRandom;
        genre = sGenre;
    }

    public boolean getIsFiction() {
        return isFiction;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsRandom() {
        return isRandom;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        String ret = "Age: " + age;
        if(isRandom) {
            ret += " Random";
        }
        if(isFiction) {
            ret += " Fiction";
        } else {
            ret += " NonFiction";
        }
        if(genre != null) {
         ret += " Genre: " + genre;
        }

        return ret;
    }
}
