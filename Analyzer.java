package es.javacodegeek

class Analyzer {
    private static Analyzer instance;
    private Analyzer() {}

    public static Analyzer getInstance() {
        if (instance == null) {
          instance = new Analyzer();
        }
          return instance;
    }
}
