package os.place.recruterpro.Util.observable.observableImpl;

import os.place.recruterpro.Util.observable.Observable;
import os.place.recruterpro.entities.Societe;

import java.util.ArrayList;
import java.util.List;

public class statusOfferMailing implements Observable<Societe, String> {
    List<Societe> societes = new ArrayList<>();
    @Override
    public void subscribe(Societe societe) {
        this.societes.add(societe);
    }

    @Override
    public void detach(Societe societe) {
        this.societes.remove(societe);
    }

    @Override
    public void notify(Societe societe, String s) {
        for(Societe societe1 : societes){

        }
    }
}
