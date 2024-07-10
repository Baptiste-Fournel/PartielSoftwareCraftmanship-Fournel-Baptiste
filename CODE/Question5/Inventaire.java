package Question5;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Ressource> ressources;

    public Inventaire() {
        this.ressources = new ArrayList<>();
    }

    public void ajouterRessource(Ressource ressource) {
        ressources.add(ressource);
    }

}

