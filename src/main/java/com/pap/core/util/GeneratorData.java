package com.pap.core.util;
import java.util.List;
import java.util.Random;
public class GeneratorData {

        private final Random random;
        private int sequentialIndex = 0;

        public GeneratorData() {
            this.random = new Random();
        }

        /** Con semilla, para reproducir una ejecución que falló. */
        public GeneratorData(long seed) {
            this.random = new Random(seed);
        }

        // ---------- Elegir de colecciones ----------

        public <T> T randomFrom(T[] array) {
            requireNotEmpty(array.length);
            return array[random.nextInt(array.length)];
        }

        public <T> T randomFrom(List<T> list) {
            requireNotEmpty(list.size());
            return list.get(random.nextInt(list.size()));
        }

        /** Recorre el array en orden y vuelve al inicio (reemplaza a buildingName()). */
        public <T> T nextFrom(T[] array) {
            requireNotEmpty(array.length);
            T value = array[sequentialIndex % array.length];
            sequentialIndex++;
            return value;
        }

        // ---------- Números ----------

        /** Entero entre min y max, ambos incluidos. */
        public int randomInt(int min, int max) {
            if (min > max) throw new IllegalArgumentException("min > max");
            return random.nextInt(max - min + 1) + min;
        }

        /** Índice entre 0 y size-1. */
        public int randomIndex(int size) {
            requireNotEmpty(size);
            return random.nextInt(size);
        }

        public int randomIndexFrom(int from, int size) {
            return randomInt(from, size);
        }

        // ---------- Rutas de archivos ----------

        /** basePath + nombre aleatorio + extensión (imágenes, videos, etc.). */
        public String randomFilePath(String[] fileNames, String basePath, String extension) {
            return basePath + randomFrom(fileNames) + extension;
        }

        // ---------- Texto ----------

        public String uniqueEmail(String firstName, String lastName, String domain, String tld) {
            return firstName + lastName + System.currentTimeMillis() + "@" + domain + tld;
        }

        /** Valor de rango tipo "1_49" -> número aleatorio dentro del rango. */
        public String randomFromRange(String range) {
            String[] parts = range.split("_");
            return String.valueOf(randomInt(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        private void requireNotEmpty(int size) {
            if (size <= 0) throw new IllegalArgumentException("La colección está vacía");
        }
    }
