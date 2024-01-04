package os.place.recruterpro.Util.observable;

public interface Observable <T,D>{
    void subscribe(T t);
    void detach(T t);
    void notify(T t, D d);
}
