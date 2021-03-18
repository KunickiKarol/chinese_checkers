package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DataBase {
    private static DataBase database;
    private int game;
    private int currentMove = 0;
    private static SessionFactory factory;
    private Integer gameID;
    ArrayList<String> arrayList = new ArrayList<>();
    public ArrayList<String> dataArrayList = new ArrayList<>();
    int ruchh = 0;


    public static DataBase getInstance() {
    
        if (database == null) {
            synchronized (DataBase.class){
            if (database == null) {
                database = new DataBase();
             }
            }
        }
        return database;
    }
    public void saveToSql(String string){
        DataBase Me2 = DataBase.getInstance();
        Me2.addNewMove(string);
    }
    public void addNewMove(String string){

        Session session = factory.openSession();
        Transaction tx = null;
    
        try {
            tx = session.beginTransaction();
            SavingDataGame games = new SavingDataGame();
            games.setNrGry(gameID);
            games.setInfo(string);
            games.setNrRuchu(ruchh);
            ruchh++;
            Integer ID = (Integer) session.save(games);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void createSQl(String Board, int Players, String shape) {
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        DataBase Me = DataBase.getInstance();
        Me.gameID = Me.addNewGame(Board,Players,shape);
        System.out.println(gameID);
    }
    public Integer addNewGame(String Board, int Players, String shape) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        Integer NrGry = null;
    
        try {

            tx = session.beginTransaction();
            GameData game = new GameData();
            game.setPlansza(Board);
            game.setKsztalt(shape);
            game.setGracze(Players);
            NrGry = (Integer) session.save(game);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return NrGry;
    }
    

    public void setGameID(int numerGry) {
        game = numerGry;
    }
    
    public String nextMove() {
        if(currentMove >= arrayList.size()) {
            return "None";
        }
        if(currentMove +1 != arrayList.size()) {
            currentMove++;
        }
        return arrayList.get(currentMove-1);
    }

    public String backMove() {
        if(currentMove == 0) {
            return "None";
        } else if(currentMove >= arrayList.size()){
            currentMove = arrayList.size()-1;
            return arrayList.get(currentMove);
        }
        currentMove--;
        return arrayList.get(currentMove);
    }

    public void listEveryMove(){

        Session session = factory.openSession();
        Transaction tx = null;
        String dater = "FROM SavingDataGame G WHERE G.NrGry= " + game;
        try {
            tx = session.beginTransaction();
            List data = session.createQuery(dater).list();
            for (Iterator iterator = data.iterator(); iterator.hasNext();){
                SavingDataGame dataGame = (SavingDataGame) iterator.next();
                arrayList.add(dataGame.getInfo());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void prepare(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        DataBase Me3 = DataBase.getInstance();
        Me3.listEveryMove();
    }

    public void setter(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        DataBase Me4 = DataBase.getInstance();
        Me4.GiveData();
    }

    public void GiveData( ){
        Session session = factory.openSession();
        Transaction tx = null;
        String dater = "FROM GameData G WHERE G= " + game;
        try {
            tx = session.beginTransaction();
            List data = session.createQuery(dater).list();
            for (Iterator iterator = data.iterator(); iterator.hasNext();){
                GameData datar = (GameData) iterator.next();
                dataArrayList.add(datar.getPlansza());
                dataArrayList.add(String.valueOf(datar.getGracze()));
                dataArrayList.add(datar.getKsztalt());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            System.out.println(dataArrayList);
            session.close();
        }
    }

}
