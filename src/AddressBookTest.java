import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    @Test
    void AddressBookMoscow() {
        AddressBook Moscow = new AddressBook();

        Moscow.add("Камокин", "Аргуновская улица, дом 1, 17 квартира");
        Moscow.add("Агеева", "Аргуновская улица, дом 2, 252 квартира");
        Moscow.add("Акутин", "Аргуновская улица, дом 8, 117 квартира");
        Moscow.add("Мокшева", "Шоссейная улица, дом 1, 157 квартира");
        Moscow.add("Марюфич", "Наличная улица, дом 46, 241 квартира");
        Moscow.add("Иванов", "Абрамцевская улица, дом 14, 105 квартира");
        assertEquals(Set.of("Камокин", "Агеева", "Акутин"), Moscow.getPeopleOnAddress("Аргуновская улица"));
        Moscow.remove("Камокин");
        Moscow.replaceAddress("Агеева", "Шоссейная улица, дом 1, 157 квартира");
        assertEquals("Шоссейная улица, дом 1, 157 квартира", Moscow.getAddress("Агеева"));
        assertEquals(Set.of("Акутин"), Moscow.getPeopleOnAddress("Аргуновская улица"));
    }

    @Test
    void AddressBookSaratov() {
        AddressBook Saratov = new AddressBook();

        Saratov.add("Поляков", "Мичурина улица, дом 10, 72 квартира");
        Saratov.add("Карасёв", "Астраханская улица, дом 52, 230 квартира");
        Saratov.add("Тарханов", "Белоглинская улица, дом 17, 154 квартира");
        Saratov.add("Боборыкин", "Октябрьская улица, дом 41, 101 квартира");
        assertEquals("Октябрьская улица, дом 41, 101 квартира", Saratov.getAddress("Боборыкин"));
        Saratov.remove("Боборыкин");
        assertNull(Saratov.getAddress("Боборыкин"));
        Saratov.replaceAddress("Игнатенко", "Октябрьская улица, дом 41, 1024 квартира");
        assertEquals(Set.of(), Saratov.getPeopleOnAddress("Октябрьская улица, дом 41"));

    }
}