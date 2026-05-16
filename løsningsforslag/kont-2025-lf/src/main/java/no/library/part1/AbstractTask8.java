package no.library.part1;
    
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractTask8 {
    private final List<Integer> selected = new ArrayList<>();

    // Helpers used by Task8 to mark correct diagrams
    protected void object_diagram_1() { selected.add(1); }
    protected void object_diagram_2() { selected.add(2); }
    protected void object_diagram_3() { selected.add(3); }
    protected void object_diagram_4() { selected.add(4); }
    protected void object_diagram_5() { selected.add(5); }
    protected void object_diagram_6() { selected.add(6); }

    // To inspect what was selected
    public List<Integer> getSelected() {
        return Collections.unmodifiableList(selected);
    }

    // To be implemented by subclasses
    public abstract void correct_diagrams();
}

