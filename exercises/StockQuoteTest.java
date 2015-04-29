// Nikolay Pogrebnoy: у тебя есть вот такая структура данных
// 
// stockquote
//     id
//     name
//     rank int // smaller is better
//     timestamp // возраст
//     
// be able to get a list of all quotes where rank < some number
// be able to get a list of all quotes > 2 minutes old

// Nikolay Pogrebnoy: у етбя есть вон те вот данные
// Nikolay Pogrebnoy: тебе надо намутить к ним контейнер, с которого можно вынимать данные так как внизу написано

import jaba.util.*;



public class StockQuoteTest {

    private PriorityQueue<StockQuote> priorityQueue = new new PriorityQueue<StockQuote>();



}


class StockQuote {
    
    private static int counter = 0;
    
    private int id = counter++;

    private String name;

    private int rank;

    private Date timestamp;

    public StockQuote(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }


    public StockQuote(String name, int rank, Date timestamp) {
        this(name, rank);
        this.timestamp = timestamp;
    }

    
    public int     getId()        { return id; }
    public String  getName()      { return name; }
    public int     getRank()      { return rank; }
    public Date    getTimestamp() { return timestamp; }

    public String toString() {
        return String.format("StockQuote { id : %1$d, name : %2$s, rank : %3$d, timestamp : %4$s }"
                            , id, name, rank, timestamp.toString());
    }
}