import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FunctionChecker {
    public boolean esFuncion(List<Pair<Object, Object>> pares) {
        Set<Object> dominio = new HashSet<>();

        for (Pair<Object, Object> p : pares) {
            dominio.add(p.getFirst());
        }

        // Verificar que cada elemento en el dominio tenga al menos una asignación
        for (Object elemento : dominio) {
            boolean tieneAsignacion = pares.stream().anyMatch(pair -> pair.getFirst().equals(elemento));
            if (!tieneAsignacion) {
                return false;
            }
        }

        return true;
    }
}

