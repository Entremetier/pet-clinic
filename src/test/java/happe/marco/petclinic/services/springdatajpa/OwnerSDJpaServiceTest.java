package happe.marco.petclinic.services.springdatajpa;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.repositories.OwnerRepository;
import happe.marco.petclinic.repositories.PetRepository;
import happe.marco.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Happe";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        //Das Objekt wird vor jedem testen einer Methode neu instanziiert um ein unbearbeitet Objekt zu haben mit dem
        //in jeder Methode gearbeitet werden kann.
    }

    @Test
    void findByLastName() {

        //Owner marco = service.findByLastName("Marco");

        //Die obere Zeile zeigt den ersten Test, auch wenn mit dem Testergebnis nichts weiter gemacht wird. Was sich aber zeigt ist das
        //die Eigenschaften instanziert werden und und die Testumgebung lauffähig ist. Man erkennt die zum einen am
        //bestehen des testes und vorher schon weil man nach dem starten des tests sieht das IntelliJ einen build Prozess
        //durchführt (erkennbar unten in der untersten Zeile in IntelliJ).
        //Wäre OwnerSDJpaService nicht durch die Annotation instanziiert würde es zu einer NullPointerException (NPE) kommen.
        //Schlussvolgerung ist das Mockito richtig läuft.

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        //WENN ownerRepository.findByLastName aufgerufen wird, DANN RETOURNIERE mir den returnOwner!

        Owner happe = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, happe.getLastName());

        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());
        //Ein Set mit 2 Ownern wird erzeugt

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        //WENN ownerRepository.findAll() aufgerufen wird DANN RETOURNIERE returnOwnerSet

        Set<Owner> owners = service.findAll();
        //die findAll() wird aufgerufen, das Ergebnis wird in einem neuen Set gespeichert

        assertNotNull(owners);
        //wir gehen davon aus das dieses Set nicht null ist, da 2 Owner Objekte im Set enthalten sein müssen

        assertEquals(2, owners.size());
        //wir gehen davon aus das 2 Objekte im Set enthalten sind und vergleichen das Ergebnis aus dem owners Set mit unserer Annahme
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        //WENN findById aufgerufen wird und es ein match mit einem Long Wert gibt (jeder Long Wert ist ok, solange er vohanden  ist)
        //DANN RETOURNIERE ein Optional.of(returnOwner)

        Owner owner = service.findById(1L);
        //es wird nach einem Long 1L gesucht, wir haben ein Objekt mit diesem Wert in der setUp() am anfang instanziiert
        //die setUp() wird vor jedem Methodentest neu ausgeführt

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        //WENN findById aufgerufen wird und es ein match mit einem Long Wert gibt (jeder Long Wert ist ok, solange er vohanden  ist)
        //DANN RETOURNIERE ein Optional.empty())
        //Dieser Test ergibt sich aus der findById() Methode in der Klasse OwnerSDJpaService Klasse, es wird hier getestet
        //was passiert wenn wir keine Id finden
        //Damit wird auch der orElse zweig in der Methode getestet.

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        //Neues Ownerobjekt wird erstellt

        when(ownerRepository.save(any())).thenReturn(returnOwner);
        //WENN die save() Methode mit einem Objekt aufgerufen wird, dann wird das returnOwner Objekt retourniert

        Owner savedOwner = service.save(ownerToSave);
        //Neues Ownerobjekt wird gespeichert

        assertNotNull(savedOwner);
        //wir gehen davon aus das in dem Ownerobjekt etwas enthalten ist

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //wenn es in der Methode keinen return Wert gibt, dann ist ein verify() eine gute Möglichkeit um sicherzugehen
        //das die Methode auch wirklich richtig ausgeführt wird
        //default ist 1, darum kann man times weglassen, so wie man es bei deleteById() sieht
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}