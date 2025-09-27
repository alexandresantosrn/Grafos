package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrafoUtils {

    public static List<String> ordenarVertices(List<String> vertices) {
        List<String> ordenados = new ArrayList<>(vertices);
        boolean saoNumericos = ordenados.stream().allMatch(v -> v.matches("\\d+"));

        if (saoNumericos) {
            ordenados.sort(Comparator.comparingInt(Integer::parseInt));
        } else {
            Collections.sort(ordenados);
        }

        return ordenados;
    }
}
