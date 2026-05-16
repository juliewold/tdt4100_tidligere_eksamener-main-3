package com.twowheels.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaesarCipherTest {

    private CaesarCipher cipher;
    private CaesarCipher autoCipher;

    @BeforeEach
    void setUp() {
        cipher = new CaesarCipher();
        autoCipher = new CaesarCipher();
        autoCipher.setAuto(true);
    }

    // Encrypt
    @Test
    void testEncryptWithValidInput() {
        assertEquals("Khoor, Zruog!", cipher.encrypt("Hello, World!", 3));
        assertEquals("Uifsf jt b tfdsfu nfttbhf!", cipher.encrypt("There is a secret message!", 1));
    }

    @Test
    void testEncryptWithNoShift() {
        assertEquals("Hello, World!", cipher.encrypt("Hello, World!", 0));
    }

    @Test
    void testEncryptWithNegativeShift() {
        assertEquals("Ebiil, Tloia!", cipher.encrypt("Hello, World!", -3));
    }

    @Test
    void testEncryptWithWrapAround() {
        assertEquals("Xlmw mw e xlmro csy!", cipher.encrypt("This is a think you!", 4));
    }

    // Decrypt
    @Test
    void testDecryptWithValidInput() {
        assertEquals("Hello, World!", cipher.decrypt("Khoor, Zruog!", 3));
        assertEquals("There is a secret message!", cipher.decrypt("Uifsf jt b tfdsfu nfttbhf!", 1));
    }

    @Test
    void testDecryptWithNoShift() {
        assertEquals("Hello, World!", cipher.decrypt("Hello, World!", 0));
    }

    @Test
    void testDecryptWithNegativeShift() {
        assertEquals("Hello, World!", cipher.decrypt("Ebiil, Tloia!", -3));
    }

    @Test
    void testDecryptWithWrapAround() {
        assertEquals("This is a think you!", cipher.decrypt("Xlmw mw e xlmro csy!", 4));
    }

    // AutoCipher Encrypt
    @Test
    void testAutoEncryptWithValidInput() {
        assertEquals("Kozky, Uizkn!", autoCipher.encrypt("Hello, World!", 3));
        assertEquals("Ubfwa ia a swyptm ycummsw!", autoCipher.encrypt("There is a secret message!", 1));
    }

    @Test
    void testAutoEncryptWithNoShift() {
        assertEquals("Hlwhv, Rfwhk!", autoCipher.encrypt("Hello, World!", 0));
    }

    @Test
    void testAutoEncryptWithNegativeShift() {
        assertEquals("Eites, Octeh!", autoCipher.encrypt("Hello, World!", -3));
    }

    @Test
    void testAutoEncryptWithWrapAround() {
        assertEquals("Xeme me e xemzj hvp!", autoCipher.encrypt("This is a think you!", 4));
    }

    // AutoCipher Decrypt
    @Test
    void testAutoDecryptWithValidInput() {
        assertEquals("Hello, World!", autoCipher.decrypt("Kozky, Uizkn!", 3));
        assertEquals("There is a secret message!", autoCipher.decrypt("Ubfwa ia a swyptm ycummsw!", 1));
    }

    @Test
    void testAutoDecryptWithNoShift() {
        assertEquals("Hello, World!", autoCipher.decrypt("Hlwhv, Rfwhk!", 0));
    }

    @Test
    void testAutoDecryptWithNegativeShift() {
        assertEquals("Hello, World!", autoCipher.decrypt("Eites, Octeh!", -3));
    }

    @Test
    void testAutoDecryptWithWrapAround() {
        assertEquals("This is a think you!", autoCipher.decrypt("Xeme me e xemzj hvp!", 4));
    }
}
