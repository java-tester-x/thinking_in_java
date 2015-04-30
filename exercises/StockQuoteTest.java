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
// Nikolay Pogrebnoy: тебе надо намутить к ним контейнер, 
//                    с которого можно вынимать данные так как внизу написано

import jaba.util.*;



public class StockQuoteTest {

    private PriorityQueue<StockQuote> priorityQueue = new new PriorityQueue<StockQuote>();

    public void fillQueue() {

    }

    public void pri

    public static void main(String[] args) {
        
    }

}




class StockQuote implements Comparable<StockQuote> {
    
    private static int counter = 0;
    
    private int id = counter++;

    private String name;

    private int rank;

    private Timestamp timestamp;

    public StockQuote(String name, int rank) {
        this.name      = name;
        this.rank      = rank;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }


    public StockQuote(String name, int rank, Timestamp timestamp) {
        this.name      = name;
        this.rank      = rank;
        this.timestamp = timestamp;
    }

    
    public int getId()              { return id; }
    public String getName()         { return name; }
    public int getRank()            { return rank; }
    public Timestamp getTimestamp() { return timestamp; }

    public void setRank(int rank)                 { this.rank = rank; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }


    public int compareTo(StockQuote obj) {
        return this.rank < obj.rank ? 1 : (this.rank == obj.rank ? 0 : -1);
    }


    public String toString() {
        return String.format("StockQuote { id : %1$d, name : %2$s, rank : %3$d, timestamp : %4$s }"
                            , id, name, rank, timestamp.toString());
    }
}