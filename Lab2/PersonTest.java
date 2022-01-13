import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.Test
    void testEquals() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }
}