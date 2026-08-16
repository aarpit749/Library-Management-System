package Service;

import Entity.Patron;

import java.util.ArrayList;
import java.util.List;

public class PatronService {
    private List<Patron> patrons = new ArrayList<>();

    public void addPatron(Patron patron) { patrons.add(patron); }
    public void updatePatron(Patron updatedPatron) {
        patrons.removeIf(p -> p.getId().equals(updatedPatron.getId()));
        patrons.add(updatedPatron);
    }
    public Patron findPatronById(String id) {
        return patrons.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
